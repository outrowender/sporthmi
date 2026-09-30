/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.reader;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.reader.ReadConfigException;
import java.io.InputStream;

public interface IConfigReader {
    public ConfigValue readFromInputStream(InputStream var1, ConfigDictionary var2) throws ReadConfigException;
}

