package com.fzu.syntax;

import java.util.*;
public class Core {
    public static void main(String[] args) {

    }

    Map<String,List<List<String>>> input;
    Map<String, Set<String>> firstSet=new HashMap<>();
    Map<String,Set<String>> followSet=new HashMap<>();
    Map<String,List<List<Object>>> table=new HashMap<>();
    Map<String,Map<String,List<String>>> analyseTable=new HashMap<>();
    public Core(Map<String,List<List<String>>> input){
        this.input=input;
        getFirst();
        getFollow();
        getAnalyseTable();
    }


    private void getFirst() {
        for (Object o : input.keySet().toArray()) {
            first((String) o);
        }
    }

    private void getFollow() {
        initTable();
        for (Map.Entry<String, List<List<String>>> entry : input.entrySet()) {
            follow(entry.getKey());
        }
    }
    /*private void EliminateLeftRecursion(){
        Object []keys=input.keySet().toArray();
        for (int i = 1; i <= keys.length; i++) {
            List<List<String>> lists = input.get(keys[i]);
            for(int j=1;j<=i-1;j++){
                for (List<String> list : lists) {

                }


            }
        }
    }*/
    private void getAnalyseTable(){
        for (Map.Entry<String, List<List<String>>> entry : input.entrySet()) {
            //for每个产生式
            analyseTable.put(entry.getKey(),new HashMap<>());
            for (int i = 0; i < input.get(entry.getKey()).size(); i++) {
                //for每个产生式的或
                List<List<String>> lists = input.get(entry.getKey());
                List<String> strings = lists.get(i);
                for (int j = 0; j < strings.size(); j++) {
                    //first(beta)
                    boolean flag=false;
                    Map<String, List<String>> map = analyseTable.get(entry.getKey());
                    for (Object o : first(strings.get(j))) {
                        //for first(beta)中的每个值
                        if(((String)o).equals("ε")){
                            flag=true;
                        }else {
                            map.put((String) o,input.get(entry.getKey()).get(i));
                        }
                    }
                    if(flag==true){
                        for (Object o : follow(entry.getKey())) {
                            map.put((String) o,input.get(entry.getKey()).get(i));
                        }
                    }else{
                        break;
                    }
                }
            }
        }
    }

    private void initTable() {
        for (Map.Entry<String, List<List<String>>> entry : input.entrySet()) {
            List<List<String>> lists = entry.getValue();
            for (int i = 0; i < lists.size(); i++) {
                List<String> list = lists.get(i);
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    if(input.containsKey(s)){//如果在箭头左边出现过
                        if(!table.containsKey(s)){
                            table.put(s,new ArrayList());
                        }
                        table.get(s).add(Arrays.asList(entry.getKey(),i,j));
                    }
                }
            }
        }
    }

    public List<Object> first(String s){
        if(!firstSet.containsKey(s)){
            if (input.containsKey(s)) {
                //说明是非终结符
                firstSet.put(s,new HashSet<String>());
                List<List<String>> lists = input.get(s);
                for (List<String> list : lists) {
                    for (String s1 : list) {
                        //s1是某一条产生式的右边
                        boolean flag=false;//flag代表能否推出空 true：能 false：不能
                        /*遍历s1的first集，看能否推出空*/
                        for (Object s2 : first(s1)) {
                            if(s2.equals("ε")) flag=true;
                            firstSet.get(s).add((String)s2);
                        }
                        if (flag==false) {
                            break;
                        }
                    }
                }
            }
            else{
                //说明是终结符,直接返回该终结符。【由于只有一个，故转化成单例List】
                return Collections.singletonList(s);
            }
        }
        return Arrays.asList(firstSet.get(s).toArray());
    }
    public List<Object> follow(String s){
        if(!followSet.containsKey(s)){
            followSet.put(s,new HashSet<>());
            followSet.get(s).add("$");
            //s可能不一定存在table中，需要特判.存在则进行follow集的构造，不存在follow集就是$
            if(table.containsKey(s)){
                for (List<Object> index : table.get(s)) {
                    Integer location=(Integer) index.get(2);
                    int size=input.get(index.get(0)).get((Integer) index.get(1)).size();//所在字符串的大小
                    //后继是否为空，true代表没有空
                    boolean flag=false;
                    List<String> afters = input.get(index.get(0)).get((Integer) index.get(1));
                    for(int i=location+1;i<size;i++){
                        List<Object> firstList = first(afters.get(i));
                        //当前first集是否有空，true代表有空
                        boolean empty=false;
                        for (int j = 0; j < firstList.size(); j++) {
                            if(((String)firstList.get(j)).equals("ε")){
                                empty=true;
                            }else {
                                followSet.get(s).add((String) firstList.get(j));
                            }
                        }
                        if(empty==false){//beta中的第i个字符不能推出空
                            flag=true;//beta不能推出空
                            break;
                        }
                    }
                    if(flag==false){//如果beta能出推出空，则将A的follow也加入进去
                        List<Object> follow = follow((String) index.get(0));
                        List<String> set = (List<String>)(List)follow;
                        followSet.get(s).addAll(set);
                    }
                }
            }

        }
        return Arrays.asList(followSet.get(s).toArray());
//                //如果不是产生式的最后一个字符
//                if(size!=(Integer)index.get(2)+1){
//                    /*将first集加入到follow集中*/
//                    String string=input.get(index.get(0))
//                            .get((Integer) index.get(1)).get(location+1);
//                    Set<String> firsts = firstSet.get(string);//获得first集
//                    for (String f : firsts) {
//                        if (!f.equals("")) followSet.get(s).add(f);//将first集加入follow集中
//                    }
//                    if(!firsts.contains(""))
//                        break;//如果不能推出空，则不再向后寻找
//                    else {
//                        Set<String> follows = followSet.get(index.get(0));
//                        for (String follow : follows) {
//                            followSet.get(s).add(follow);
//                        }
//                    }
//                }
//                else{
//                    Set<String> follows = followSet.get(index.get(0));
//                    for (String follow : follows) {
//                        followSet.get(s).add(follow);
//                    }
//                }

    }
    public List<String> getProduction(String nonTerminal,String terminal){
        Map<String, List<String>> listMap = analyseTable.get(nonTerminal);
        if (listMap.containsKey(terminal)) {
            return listMap.get(terminal);//返回M[X,a]条目
        }
        else return null;//不存在则返回空
    }
    public void analyze(List<String> inputString){
        Stack<String> stack=new Stack<>();
        stack.push("$");
        boolean flag=false;
        for (Map.Entry<String, List<List<String>>> entry : input.entrySet()) {
            String key=entry.getKey();
            Map<String, List<String>> listMap = analyseTable.get(key);
            for (Map.Entry<String, List<String>> e : listMap.entrySet()) {
                if(e.getKey().equals(inputString.get(0))){
                    stack.push(key);
                    flag=true;
                }
            }
            if(flag==true)break;
        }
        int ptr=0;
        int cnt=1;
        String top=stack.peek();
        while(!top.equals("$")){
            StringBuffer sb=new StringBuffer();
            sb.append(cnt+".\tstack：\t\t"+stack+"\n");
            sb.append("\tinputList：\t"+inputString.subList(ptr,inputString.size())+"\n");
            cnt++;
            System.out.println(sb);
            if(top.equals(inputString.get(ptr))){
                //匹配到，进行弹栈操作，指针前移
                stack.pop();
//                System.out.println("匹配"+top);
                ptr++;
                if(ptr>=inputString.size())break;
            }
            else if(!input.containsKey(top)){
                //如果是终结符
                System.out.println("error");
            }
            else if(getProduction(top,inputString.get(ptr))==null){
                System.out.println("error");
            }
            else if(getProduction(top,inputString.get(ptr))!=null){
                List<String> strings = getProduction(top, inputString.get(ptr));
//                System.out.print(stack.peek()+"->");
//                for (String s : strings) {
//                    System.out.print(s+" ");
//                }
//                System.out.println();
                //弹出栈顶
                stack.pop();
                for (int i = strings.size() - 1; i >= 0; i--) {
                    if(!strings.get(i).equals("ε"))stack.push(strings.get(i));//倒序入栈
                }
            }
            top=stack.peek();
        }
    }
    public Map<String, List<List<String>>> getInput() {
        return input;
    }

    public void setInput(Map<String, List<List<String>>> input) {
        this.input = input;
    }

    public Map<String, Set<String>> getFirstSet() {
        return firstSet;
    }

    public void setFirstSet(Map<String, Set<String>> firstSet) {
        this.firstSet = firstSet;
    }

    public Map<String, Set<String>> getFollowSet() {
        return followSet;
    }

    public void setFollowSet(Map<String, Set<String>> followSet) {
        this.followSet = followSet;
    }
}
