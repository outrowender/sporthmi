/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.WriteConfigException;

public interface IConfigExporter {
    public void beginDictionary(ConfigDictionary var1, int var2) throws WriteConfigException;

    public void endDictionary() throws WriteConfigException;

    public void beginArray(ConfigArray var1, int var2) throws WriteConfigException;

    public void endArray() throws WriteConfigException;

    public void beginDictEntry(int var1, String var2) throws WriteConfigException;

    public void endDictEntry(boolean var1) throws WriteConfigException;

    public void beginArrayEntry(int var1) throws WriteConfigException;

    public void endArrayEntry(boolean var1) throws WriteConfigException;

    public void writeString(String var1) throws WriteConfigException;

    public void writeInteger(int var1) throws WriteConfigException;

    public void writeDouble(double var1) throws WriteConfigException;

    public void writeNull() throws WriteConfigException;

    public void writeBoolean(boolean var1) throws WriteConfigException;
}

