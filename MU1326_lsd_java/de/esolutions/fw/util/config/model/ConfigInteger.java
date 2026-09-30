/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.model.ConfigScalar;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import de.esolutions.fw.util.config.writer.WriteConfigException;

public class ConfigInteger
extends ConfigScalar {
    private Integer value;

    public ConfigInteger(Integer n) {
        this.value = n;
    }

    public ConfigInteger(int n) {
        this.value = new Integer(n);
    }

    public boolean isInteger() {
        return true;
    }

    public Integer getInteger() {
        return this.value;
    }

    public Integer getInteger(Integer n) {
        if (this.value == null) {
            return n;
        }
        return this.value;
    }

    public Boolean convertToBoolean() {
        return new Boolean(this.value != 0);
    }

    public Integer convertToInteger() {
        return this.value;
    }

    public Double convertToDouble() {
        return new Double(this.value.intValue());
    }

    public String convertToString() {
        return this.value.toString();
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigInteger)) {
            return false;
        }
        ConfigInteger configInteger = (ConfigInteger)object;
        return this.value.equals(configInteger.value);
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + (this.value == null ? 0 : this.value.hashCode());
        return n;
    }

    public void export(IConfigExporter iConfigExporter) throws WriteConfigException {
        if (this.value == null) {
            iConfigExporter.writeNull();
        } else {
            iConfigExporter.writeInteger(this.value);
        }
    }
}

