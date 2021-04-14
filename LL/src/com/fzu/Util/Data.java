package com.fzu.Util;

import java.util.*;

public class Data {

	public static Map<String,List<List<String>>>  dataInitial(){
		Map<String,List<List<String>>> input;
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
		return input;
	}
	public static Map<String,List<List<String>>>  dataInitial2(){
		Map<String,List<List<String>>> input;
		input=new HashMap<>();
		input.put("program",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("{","decls","stmts","}","program\'")));
		}});
		input.put("block",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("{","decls","stmts","}")));
		}});
		input.put("equality\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("==","rel","equality\'")));
			add(new ArrayList<String>(Arrays.asList("!=","rel","equality\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("decls",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("ε","decls\'")));
		}});
		input.put("equality",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("rel","equality\'")));
		}});
		input.put("factor",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("(","bool",")")));
			add(new ArrayList<String>(Arrays.asList("loc")));
			add(new ArrayList<String>(Arrays.asList("num")));
			add(new ArrayList<String>(Arrays.asList("real")));
			add(new ArrayList<String>(Arrays.asList("true")));
			add(new ArrayList<String>(Arrays.asList("false")));
		}});
		input.put("join",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("equality","join\'")));
		}});
		input.put("stmt",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("loc","=","bool",";")));
			add(new ArrayList<String>(Arrays.asList("if","(","bool",")","stmt","stmt\'")));
			add(new ArrayList<String>(Arrays.asList("while","(","bool",")","stmt")));
			add(new ArrayList<String>(Arrays.asList("do","stmt","while","(","bool",")",";")));
			add(new ArrayList<String>(Arrays.asList("break",";")));
			add(new ArrayList<String>(Arrays.asList("block")));
		}});
		input.put("stmt\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("else","stmt")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("expr\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("+","term","expr\'")));
			add(new ArrayList<String>(Arrays.asList("-","term","expr\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("type",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("basic","type\'")));
		}});
		input.put("rel",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("expr","rel\'")));
		}});
		input.put("rel\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("<","expr")));
			add(new ArrayList<String>(Arrays.asList("<=","expr")));
			add(new ArrayList<String>(Arrays.asList(">=","expr")));
			add(new ArrayList<String>(Arrays.asList(">","expr")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("stmts",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("ε","stmts\'")));
		}});
		input.put("term\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("*","unary","term\'")));
			add(new ArrayList<String>(Arrays.asList("/","unary","term\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("term",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("unary","term\'")));
		}});
		input.put("unary",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("!","unary")));
			add(new ArrayList<String>(Arrays.asList("-","unary")));
			add(new ArrayList<String>(Arrays.asList("factor")));
		}});
		input.put("Loc",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("loc","[","num","]")));
			add(new ArrayList<String>(Arrays.asList("id")));
		}});
		input.put("bool",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("join","bool\'")));
		}});
		input.put("program\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("expr",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("term","expr\'")));
		}});
		input.put("decl",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("type","id")));
		}});
		input.put("join\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("&&","equality","join\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("decls\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("ε")));
			add(new ArrayList<String>(Arrays.asList("decl","decls\'")));
		}});
		input.put("bool\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("||","join","bool\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("stmts\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("stmt","stmts\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});
		input.put("type\'",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("[","num","type\'")));
			add(new ArrayList<String>(Arrays.asList("ε")));
		}});














		return input;
	}
	public static Map<String,List<List<String>>> dataInitial1(){
		Map<String,List<List<String>>> input;
		input=new HashMap<>();
		input.put("S",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("M","H")));
			add(new ArrayList<String>(Arrays.asList("a")));
		}});
		input.put("H",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("L","S","o")));
			add(new ArrayList<String>(Arrays.asList("")));
		}});
		input.put("K",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("d","M","L")));
			add(new ArrayList<String>(Arrays.asList("")));
		}});
		input.put("L",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("e","H","f")));
		}});
		input.put("M",new ArrayList<>(){{
			add(new ArrayList<String>(Arrays.asList("K")));
			add(new ArrayList<String>(Arrays.asList("b","L","M")));
		}});
		return input;
	}

}
