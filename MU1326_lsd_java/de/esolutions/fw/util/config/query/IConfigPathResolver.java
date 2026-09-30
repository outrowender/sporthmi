/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;

public interface IConfigPathResolver {
    public ConfigValue resolvePath(String[] var1, ConfigValue var2);
}

