package com.tgrl.exp.j8.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * You can invoke JavaScript functions directly from Java
 * @author tugrul.ocak
 *
 */
public class InvakingJSFromJava {

  public void invokingJSEngine() throws ScriptException, NoSuchMethodException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("nashborn");
    
    Invocable invocable = (Invocable) engine;
    
    engine.eval("function p(s) { print(s) }");
    invocable.invokeFunction("p", "hello");
    
    // You can use the getInterface method to implement any interface in JavaScript.
    JPrinter printer = invocable.getInterface(JPrinter.class);
    printer.p("Hello again!");
  }
  
  public static interface JPrinter {
    void p(String s);
  }
}
