/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;

public interface IConfigQuery {
    public String getStringValue(String var1);

    public String getStringValue(String var1, String var2);

    public Integer getIntegerValue(String var1);

    public int getIntegerValue(String var1, int var2);

    public Boolean getBooleanValue(String var1);

    public boolean getBooleanValue(String var1, boolean var2);

    public Double getDoubleValue(String var1);

    public double getDoubleValue(String var1, double var2);

    public ConfigValue getArray(String var1);

    public ConfigValue getDictionary(String var1);

    public ConfigValue getValue(String var1);
}

