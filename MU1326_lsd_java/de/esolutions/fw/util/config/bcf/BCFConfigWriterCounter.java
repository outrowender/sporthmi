/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.config.bcf.BCFStringPool;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import de.esolutions.fw.util.config.writer.WriteConfigException;

public class BCFConfigWriterCounter
implements IConfigExporter {
    private final boolean bits32;
    private final BCFStringPool pool;
    private int numElements;
    private int numElementDatas;

    public BCFConfigWriterCounter(boolean bl, BCFStringPool bCFStringPool) {
        this.bits32 = bl;
        this.pool = bCFStringPool;
    }

    public int getNumElementsPairs() {
        return this.numElements;
    }

    public int getNumElementDatas() {
        return this.numElementDatas;
    }

    public int size() {
        return this.numElements * 2 + this.numElementDatas;
    }

    private void countString(String string) {
        this.pool.addString(string);
    }

    public void beginDictionary(ConfigDictionary configDictionary, int n) throws WriteConfigException {
        ++this.numElements;
        this.numElementDatas += 2 + n;
        String[] stringArray = configDictionary.getAllDictKeys();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.countString(stringArray[i2]);
        }
    }

    public void endDictionary() throws WriteConfigException {
    }

    public void beginDictEntry(int n, String string) throws WriteConfigException {
    }

    public void endDictEntry(boolean bl) throws WriteConfigException {
    }

    public void beginArray(ConfigArray configArray, int n) throws WriteConfigException {
        ++this.numElements;
        this.numElementDatas += 2;
    }

    public void endArray() throws WriteConfigException {
    }

    public void beginArrayEntry(int n) throws WriteConfigException {
    }

    public void endArrayEntry(boolean bl) throws WriteConfigException {
    }

    public void writeString(String string) throws WriteConfigException {
        ++this.numElements;
        this.countString(string);
    }

    public void writeInteger(int n) throws WriteConfigException {
        ++this.numElements;
        if (!(this.bits32 || n >= Short.MIN_VALUE && n <= Short.MAX_VALUE)) {
            String string = Integer.toString(n);
            this.countString(string);
        }
    }

    public void writeDouble(double d2) throws WriteConfigException {
        String string = Double.toString(d2);
        this.countString(string);
        ++this.numElements;
    }

    public void writeNull() throws WriteConfigException {
        ++this.numElements;
    }

    public void writeBoolean(boolean bl) throws WriteConfigException {
        ++this.numElements;
    }
}

