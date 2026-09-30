/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.config.query.IConfigQuery;

public class SerializerParam {
    public static final int BE = 0;
    public static final int LE = 1;
    public static final String[] typeNames = new String[]{"BE", "LE"};
    private int type;

    public static SerializerParam create(IConfigQuery iConfigQuery) {
        int n;
        String string = iConfigQuery.getStringValue("serializer");
        if (string == null) {
            return null;
        }
        if (string.equals("BE")) {
            n = 0;
        } else if (string.equals("LE")) {
            n = 1;
        } else {
            return null;
        }
        return new SerializerParam(n);
    }

    private SerializerParam(int n) {
        this.type = n;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "[Serializer:" + typeNames[this.type] + "]";
    }
}

