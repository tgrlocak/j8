package com.tgrl.exp.j8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * <code>Nashorn</code> replaces Rhino as the default JavaScript engine for the Oracle JVM. Nashorn is much
 * faster since it uses the <code>invokedynamic</code> feature of the JVM. It also includes a command line tool (<b><code>jjs</code></b>).
 */
public class NashornBasics {

  /**
   * You can run JavaScript dynamically from Java with:<br/>
   * <p>
   *    <code>import javax.script.ScriptEngine;<br/>
   *    import javax.script.ScriptEngineManager;</code>
   * </p>
   * @throws ScriptException 
   * @throws FileNotFoundException 
   */
  public void scriptEngineWithNashorn() throws ScriptException, FileNotFoundException {
    ScriptEngineManager engineManager = new ScriptEngineManager();
    ScriptEngine engine = engineManager.getEngineByName("nashorn");
    
    engine.eval("function p(s) { print(s) }");
    engine.eval("p('Hello Nashborn!');");
    
    engine.eval(new FileReader("library.js"));
  }
}
