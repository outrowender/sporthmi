/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;

public interface IConfigValueResolver {
    public ConfigValue getInArray(ConfigValue var1, String var2);

    public ConfigValue getInDictionary(ConfigValue var1, String var2);
}

