package com.eight;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScritpEngine {
	public static void main(String[] args) throws ScriptException {
		  ScriptEngineManager mgr = new ScriptEngineManager();
		  ScriptEngine engine = mgr.getEngineByName("JavaScript");
		  String foo = "var i;";
		  System.out.println(engine.eval(foo));
		  String pnt = "print('Hello');";
		  System.out.println(engine.eval(pnt));
	}
}
