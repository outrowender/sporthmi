/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

public class Info {
    private int line;
    private int column;
    private String templateName;

    public Info(String string, int n, int n2) {
        this.templateName = string;
        this.line = n;
        this.column = n2;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}

