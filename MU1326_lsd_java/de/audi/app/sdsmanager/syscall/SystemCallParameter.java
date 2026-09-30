/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.syscall;

import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.esolutions.fw.util.commons.Buffer;

public class SystemCallParameter
implements ISystemCallParameter {
    private final int type;
    private final Object value;

    public SystemCallParameter(Boolean bl) {
        this.type = 1;
        this.value = bl;
    }

    public SystemCallParameter(Integer n) {
        this.type = 2;
        this.value = n;
    }

    public SystemCallParameter(String string) {
        this.type = 3;
        this.value = string;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean getBoolean() {
        return this.getType() == 1 && (Boolean)this.getValue() != false;
    }

    public int getInteger() {
        if (this.getType() == 2) {
            return (Integer)this.getValue();
        }
        return -1;
    }

    public String getString() {
        if (this.getType() == 3) {
            return (String)this.getValue();
        }
        return "";
    }

    public String toString() {
        Buffer buffer = new Buffer();
        String string = this.type == 1 ? "Boolean" : (this.type == 2 ? "Integer" : (this.type == 3 ? "String" : "UNK"));
        buffer.append("Type: ").append(this.type).append(" (").append(string).append("), ").append("Value: ").append(this.value);
        return buffer.toString();
    }
}

