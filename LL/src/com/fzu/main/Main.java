package com.fzu.main;

import com.fzu.Util.Data;
import com.fzu.syntax.Core;
import com.fzu.word.WordCore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
	private static String inputPath;
	public static void main(String[] args) throws IOException {
		inputPath=args[0];
		WordCore wordCore=new WordCore();
		wordCore.wordInput(inputPath);
		final List<Map<String, String>> list = wordCore.getList();
		List<String> inputList=new ArrayList<>();
		for (Map<String, String> stringMap : list) {
			for (Map.Entry<String, String> entry : stringMap.entrySet()) {
				String value=entry.getValue();
				if(value.equals("reservedWord"))
				{
					inputList.add(entry.getKey());
				}
				else if(value.equals("operator")){
					inputList.add(entry.getKey());
				}
				else if(value.equals("id")){
					inputList.add("id");
				}
				else if(value.equals("separator")){
					inputList.add(entry.getKey());
				}
				else if(value.equals("constant")){
					inputList.add("num");
				}
			}
		}
		Core core=new Core(Data.dataInitial2());
		core.analyze(inputList);
		//System.out.println(wordCore.getList());

	}
}
