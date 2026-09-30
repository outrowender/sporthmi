/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.WriteConfigException;
import java.io.OutputStream;

public interface IConfigWriter {
    public void writeToOutputStream(OutputStream var1, ConfigValue var2, ConfigDictionary var3) throws WriteConfigException;
}

