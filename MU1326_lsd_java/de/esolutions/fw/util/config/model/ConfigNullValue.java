/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import de.esolutions.fw.util.config.writer.WriteConfigException;

public class ConfigNullValue
extends ConfigValue {
    public boolean isArray() {
        return false;
    }

    public boolean isDictionary() {
        return false;
    }

    public boolean isNull() {
        return true;
    }

    public boolean isScalar() {
        return false;
    }

    public String toString() {
        return "null";
    }

    public boolean equals(Object object) {
        return object instanceof ConfigNullValue;
    }

    public void export(IConfigExporter iConfigExporter) throws WriteConfigException {
        iConfigExporter.writeNull();
    }
}

