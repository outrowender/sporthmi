/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import de.esolutions.fw.util.config.writer.IConfigWriter;
import de.esolutions.fw.util.config.writer.WriteConfigException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class JSONConfigWriter
implements IConfigWriter,
IConfigExporter {
    private PrintStream ps;
    private int indent;
    private boolean needNewLine;
    private boolean needIndent;

    public void writeToOutputStream(OutputStream outputStream, ConfigValue configValue, ConfigDictionary configDictionary) throws WriteConfigException {
        try {
            this.ps = new PrintStream(outputStream, true, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            WriteConfigException writeConfigException = new WriteConfigException(unsupportedEncodingException.getMessage());
            throw writeConfigException;
        }
        this.indent = 0;
        this.needIndent = true;
        this.needNewLine = false;
        configValue.export(this);
        this.flush();
    }

    private void writeToken(String string, boolean bl) {
        if (this.needNewLine) {
            this.ps.println("");
            this.needNewLine = false;
        }
        if (this.needIndent) {
            for (int i2 = 0; i2 < this.indent; ++i2) {
                this.ps.print(' ');
            }
            this.needIndent = false;
        }
        this.ps.print(string);
        if (bl) {
            this.needIndent = true;
            this.needNewLine = true;
        }
    }

    private void appendToken(String string) {
        this.ps.print(string);
        this.needIndent = true;
        this.needNewLine = true;
    }

    private void flush() {
        if (this.needNewLine) {
            this.ps.println();
        }
    }

    public void beginDictionary(ConfigDictionary configDictionary, int n) throws WriteConfigException {
        this.writeToken("{", true);
        ++this.indent;
    }

    public void endDictionary() throws WriteConfigException {
        --this.indent;
        this.writeToken("}", true);
    }

    public void beginArray(ConfigArray configArray, int n) throws WriteConfigException {
        this.writeToken("[", true);
        ++this.indent;
    }

    public void endArray() throws WriteConfigException {
        --this.indent;
        this.writeToken("]", true);
    }

    public void beginDictEntry(int n, String string) throws WriteConfigException {
        this.writeToken(StringUtils.quoteString(string) + " : ", false);
    }

    public void endDictEntry(boolean bl) throws WriteConfigException {
        if (!bl) {
            this.appendToken(",");
        }
    }

    public void beginArrayEntry(int n) throws WriteConfigException {
    }

    public void endArrayEntry(boolean bl) throws WriteConfigException {
        if (!bl) {
            this.appendToken(",");
        }
    }

    public void writeString(String string) throws WriteConfigException {
        this.writeToken(StringUtils.quoteString(string), false);
    }

    public void writeInteger(int n) throws WriteConfigException {
        this.writeToken(Integer.toString(n), false);
    }

    public void writeDouble(double d2) throws WriteConfigException {
        this.writeToken(Double.toString(d2), false);
    }

    public void writeNull() throws WriteConfigException {
        this.writeToken("null", false);
    }

    public void writeBoolean(boolean bl) throws WriteConfigException {
        this.writeToken(bl ? "true" : "false", false);
    }
}

