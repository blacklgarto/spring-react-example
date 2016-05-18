package com.winterbe.react;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by ff on 17.05.16.
 */
public class NashSingletone {
    public static NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");

    public NashSingletone(){
    }

    public static NashornScriptEngine engine(){
        try {
        nashornScriptEngine.eval(read("static/nashorn-polyfill.js"));
        nashornScriptEngine.eval(read("static/vendor/react.js"));
        nashornScriptEngine.eval(read("static/vendor/showdown.min.js"));
        nashornScriptEngine.eval(read("static/commentBox.js"));
        return nashornScriptEngine;
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    private static Reader read(String path) {
        InputStream in = NashSingletone.class.getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
