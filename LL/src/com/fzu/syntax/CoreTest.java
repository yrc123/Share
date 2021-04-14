package com.fzu.syntax;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CoreTest {
    Map<String,List<List<String>>> input;
    @Before
    public void init(){
        input=new HashMap<>();
        input.put("program",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("block")));
        }});
        input.put("block",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("{","decls","stmts","}")));
        }});
        input.put("decls",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("decls","decl")));
            add(new ArrayList<String>(Arrays.asList("~")));
        }});
        input.put("decl",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("type","id")));
        }});
        input.put("type",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("type","[","num","]")));
            add(new ArrayList<String>(Arrays.asList("basic")));
        }});
        input.put("stmts",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("stmts","stmt")));
            add(new ArrayList<String>(Arrays.asList("~")));
        }});
        input.put("stmt",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("loc","=","bool",";")));
            add(new ArrayList<String>(Arrays.asList("if","(","bool",")","stmt")));
            add(new ArrayList<String>(Arrays.asList("if","(","bool",")","stmt","else","stmt")));
            add(new ArrayList<String>(Arrays.asList("while","(","bool",")","stmt")));
            add(new ArrayList<String>(Arrays.asList("do","stmt","while","(","bool",")",";")));
            add(new ArrayList<String>(Arrays.asList("break",";")));
            add(new ArrayList<String>(Arrays.asList("block")));
        }});
        input.put("loc",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("loc","[","num","]")));
            add(new ArrayList<String>(Arrays.asList("id")));
        }});
        input.put("bool",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("bool","||","join")));
            add(new ArrayList<String>(Arrays.asList("join")));
        }});
        input.put("join",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("join","&&","equality")));
            add(new ArrayList<String>(Arrays.asList("equality")));
        }});
        input.put("equality",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("equality","==","rel")));
            add(new ArrayList<String>(Arrays.asList("equality","!=","rel")));
            add(new ArrayList<String>(Arrays.asList("rel")));
        }});
        input.put("rel",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("expr","<","expr")));
            add(new ArrayList<String>(Arrays.asList("expr","<=","expr")));
            add(new ArrayList<String>(Arrays.asList("expr",">=","expr")));
            add(new ArrayList<String>(Arrays.asList("expr",">","expr")));
        }});
        input.put("expr",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("expr","+","term")));
            add(new ArrayList<String>(Arrays.asList("expr","-","term")));
            add(new ArrayList<String>(Arrays.asList("term")));
        }});
        input.put("term",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("term","*","unary")));
            add(new ArrayList<String>(Arrays.asList("term","/","unary")));
            add(new ArrayList<String>(Arrays.asList("unary")));
        }});
        input.put("unary",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("!","unary")));
            add(new ArrayList<String>(Arrays.asList("-","unary")));
            add(new ArrayList<String>(Arrays.asList("factor")));
        }});
        input.put("factor",new ArrayList<>(){{
            add(new ArrayList<String>(Arrays.asList("(","bool",")")));
            add(new ArrayList<String>(Arrays.asList("loc")));
            add(new ArrayList<String>(Arrays.asList("num")));
            add(new ArrayList<String>(Arrays.asList("real")));
            add(new ArrayList<String>(Arrays.asList("true")));
            add(new ArrayList<String>(Arrays.asList("false")));
        }});

    }
    @Test
    public void test() {
        Core core = new Core(input);
        Map<String, Set<String>> firstSet = core.getFirstSet();
        System.out.println("first集"+firstSet);
        Map<String, Set<String>> followSet = core.getFollowSet();
        System.out.println("follow集"+followSet);
        //List<String> inputString=new ArrayList<>(Arrays.asList("e","f","a","o","$"));
        //core.analyze(inputString);
    }


}