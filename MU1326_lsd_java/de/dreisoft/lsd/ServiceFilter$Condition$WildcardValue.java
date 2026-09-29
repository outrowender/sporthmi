/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import org.osgi.framework.InvalidSyntaxException;

public class ServiceFilter$Condition$WildcardValue {
    private String valStr;
    private String prefix;
    private String suffix;

    public ServiceFilter$Condition$WildcardValue(String string, String string2) {
        this.valStr = string2;
        int n = this.valStr.indexOf(42);
        this.prefix = this.valStr.substring(0, n);
        this.suffix = this.valStr.substring(n + 1);
        if (this.suffix.indexOf(42) != -1) {
            throw new InvalidSyntaxException("filter syntax invalid: only one wildcard symbol allowed per value", string);
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        String string = object.toString();
        return string.length() >= this.prefix.length() + this.suffix.length() && string.startsWith(this.prefix) && string.endsWith(this.suffix);
    }

    public String toString() {
        return this.valStr;
    }
}

