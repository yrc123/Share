package com.fzu.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class WordCore {
    private List<Map<String,String>> wordList = new ArrayList<>();
    //保留字：reservedWord  运算符：operator    标识符：id  分隔符：separator   常数:constant 错误：ERROR
    private static String inputPath;
    private static char buffer;
    private static boolean isCache=false;
    //保留字
    private static ArrayList<String> reservedWords = new ArrayList<String>(
            Arrays.asList("private","protected","public","abstract","class","extends","final","implements",
                    "interface","native","new","static","strictfp","break","continue","return","do","while","if","else","for",
                    "instanceof","switch","case","default","boolean","byte","char","double","float","int","long","short",
                    "String","null","true","false","void","this","goto"));
    //运算符
    private static ArrayList<String> operator = new ArrayList<String>(
            Arrays.asList("+","-","*","/","%","++","--","-=","*=","/=","&","|","^","~","<<",">>",">>>","==","!=",
                    ">","<","=",">=","<=","&&","||","!",".","[","]"));
    //分隔符
    private static ArrayList<String> separator = new ArrayList<String>(
            Arrays.asList(",",";",":","(",")","{","}"));

    public static void main(String[] args) throws IOException {
        inputPath=args[0];
        WordCore wordCore=new WordCore();
        wordCore.wordInput(inputPath);

        System.out.println(wordCore.getList());
    }

    public List<Map<String,String>> getList(){
        return wordList;
    }

    public void wordInput(String inputPath) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(inputPath));
        int cTemp;
        int status;
        while(true){
            if(isCache){
                cTemp= buffer;
                isCache=false;
            }
            else {
                cTemp= br.read();
            }
            if(cTemp==-1)
                break;
            status=0;
            switch (status){
                case 0:             //第0个自动机判断ID和保留字
                    status = isId((char) cTemp, br);
                case 1:
                    status=isSeparator((char) cTemp);
                case 2:
                    status=isOperator((char)cTemp,br);
                case 3:
                    status=isNumber((char)cTemp,br);
                case -1:
                    break;
            }
        }
        br.close();
    }
    private int isId(char c,BufferedReader br) throws IOException {
        if(!Character.isLetter(c))
            return 1;
        int cIntTemp;
        char cTemp;
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        while((cIntTemp=br.read())!=-1){
            cTemp=(char)cIntTemp;
            if(Character.isLetterOrDigit(cTemp))
                sb.append(cTemp);
            else{
                buffer=cTemp;
                isCache=true;
                break;
            }
        }
        if(reservedWords.contains(sb.toString())){  //如果是保留字输出保留字，不是输出ID
            System.out.println("<"+sb.toString()+","+"保留字>");
            wordList.add(Map.of(sb.toString(),"reservedWord"));
        }
        else{
            System.out.println("<"+sb.toString()+","+"标识符>");
            wordList.add(Map.of(sb.toString(),"id"));
        }
        return -1;
    }

    //判断是否为分隔符
    private int isSeparator(char c){
        if(separator.contains(String.valueOf(c))){      //是分隔符
            System.out.println("<"+c+","+"分隔符>");
            wordList.add(Map.of(c+"","separator"));
            return -1;
        }
        else{
            return 2;                                   //不是分隔符，进入下一个自动机
        }
    }

    private int isOperator(char c,BufferedReader br) throws IOException {
        if(!operator.contains(String.valueOf(c))){      //不是操作符，直接返回
            return 3;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        int cTemp;
        while((cTemp=br.read())!=-1){
            sb.append((char)cTemp);
            if(!operator.contains(sb.toString())){
                buffer= (char) cTemp;           //如果下一个字符在操作符中查不到，将其存入缓冲区
                isCache=true;
                break;
            }
        }
        if(operator.contains(sb.toString())){
            System.out.println("<"+ sb.toString()+","+"操作符>");
            wordList.add(Map.of(sb.toString(),"operator"));
        }
        else{
            System.out.println("<"+ sb.substring(0,sb.length()-1)+","+"操作符>");
            wordList.add(Map.of(sb.substring(0,sb.length()-1),"operator"));
        }
        return -1;
    }

    private int isNumber(char c,BufferedReader br) throws IOException {
        if(!Character.isDigit(c))
            return 4;
        String SCIENTIFIC="([\\+|-]?\\d+(.{0}|.\\d+)?([Ee]{1}([\\+|-]?\\d+)|))";
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        int cIntTemp;
        char cTemp;
        boolean isE=false;
        while((cIntTemp=br.read())!=-1){
            cTemp=(char)cIntTemp;
            if(Character.isDigit(cTemp) || cTemp=='.')
                sb.append(cTemp);
            else if(cTemp=='E' || cTemp=='e'){
                sb.append(cTemp);
                isE=true;
            }
            else if((cTemp=='+' || cTemp=='-') && isE)
                sb.append(cTemp);
            else{
                buffer=cTemp;
                isCache=true;
                break;
            }
        }
        if(Pattern.matches(SCIENTIFIC,sb.toString())){
            System.out.println("<"+ sb.toString()+","+"常数>");
            wordList.add(Map.of(sb.toString(),"constant"));
        }
        else{
            System.out.println("<"+ sb.toString()+","+"ERROR>");
            wordList.add(Map.of(sb.toString(),"ERROR"));
        }
        return -1;
    }
}
