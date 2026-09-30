/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.jexl.Script;
import org.apache.commons.jexl.ScriptImpl;
import org.apache.commons.jexl.parser.ASTJexlScript;
import org.apache.commons.jexl.parser.ParseException;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.parser.TokenMgrError;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ScriptFactory {
    protected static Log log = LogFactory.getLog("org.apache.commons.jexl.ScriptFactory");
    protected static Parser parser = new Parser(new StringReader(";"));
    protected static ScriptFactory factory = new ScriptFactory();

    private ScriptFactory() {
    }

    protected static ScriptFactory getInstance() {
        return factory;
    }

    public static Script createScript(String string) throws Exception {
        return ScriptFactory.getInstance().createNewScript(string);
    }

    public static Script createScript(File file) throws Exception {
        if (file == null) {
            throw new NullPointerException("scriptFile is null");
        }
        if (!file.canRead()) {
            throw new IOException("Can't read scriptFile (" + file.getCanonicalPath() + ")");
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        return ScriptFactory.createScript(ScriptFactory.readerToString(bufferedReader));
    }

    public static Script createScript(URL uRL) throws Exception {
        if (uRL == null) {
            throw new NullPointerException("scriptUrl is null");
        }
        URLConnection uRLConnection = uRL.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));
        return ScriptFactory.createScript(ScriptFactory.readerToString(bufferedReader));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Script createNewScript(String string) throws Exception {
        SimpleNode simpleNode;
        String string2 = this.cleanScript(string);
        Parser parser = ScriptFactory.parser;
        synchronized (parser) {
            log.debug("Parsing script: " + string2);
            try {
                simpleNode = ScriptFactory.parser.parse(new StringReader(string2));
            }
            catch (TokenMgrError tokenMgrError) {
                throw new ParseException(tokenMgrError.getMessage());
            }
        }
        if (simpleNode instanceof ASTJexlScript) {
            return new ScriptImpl(string2, (ASTJexlScript)simpleNode);
        }
        throw new IllegalStateException("Parsed script is not an ASTJexlScript");
    }

    private String cleanScript(String string) {
        String string2 = string.trim();
        if (!string2.endsWith(";")) {
            string2 = string2 + ";";
        }
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String readerToString(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String string = null;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuffer.append(string).append('\n');
            }
            String string2 = stringBuffer.toString();
            return string2;
        }
        finally {
            bufferedReader.close();
        }
    }
}

