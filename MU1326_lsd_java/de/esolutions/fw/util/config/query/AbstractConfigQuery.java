/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.IConfigQuery;

public abstract class AbstractConfigQuery
implements IConfigQuery {
    public abstract ConfigValue getValue(String var1);

    public String getStringValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isString()) {
            return configValue.getString();
        }
        return null;
    }

    public String getStringValue(String string, String string2) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return string2;
        }
        if (configValue.isString()) {
            return configValue.getString();
        }
        return string2;
    }

    public Integer getIntegerValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isInteger()) {
            return configValue.getInteger();
        }
        return null;
    }

    public int getIntegerValue(String string, int n) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return n;
        }
        if (configValue.isInteger() && configValue.getInteger() != null) {
            return configValue.getInteger();
        }
        return n;
    }

    public Boolean getBooleanValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isBoolean()) {
            return configValue.getBoolean();
        }
        return null;
    }

    public boolean getBooleanValue(String string, boolean bl) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return bl;
        }
        if (configValue.isBoolean() && configValue.getBoolean() != null) {
            return configValue.getBoolean();
        }
        return bl;
    }

    public Double getDoubleValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isDouble()) {
            return configValue.getDouble();
        }
        return null;
    }

    public double getDoubleValue(String string, double d2) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return d2;
        }
        if (configValue.isDouble() && configValue.getDouble() != null) {
            return configValue.getDouble();
        }
        return d2;
    }

    public ConfigValue getArray(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isArray()) {
            return configValue;
        }
        return null;
    }

    public ConfigValue getDictionary(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isDictionary()) {
            return configValue;
        }
        return null;
    }
}

