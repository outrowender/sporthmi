/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public class Token {
    public int kind;
    public int beginLine;
    public int beginColumn;
    public int endLine;
    public int endColumn;
    public String image;
    public Token next;
    public Token specialToken;

    public final String toString() {
        return this.image;
    }

    public static final Token newToken(int n) {
        switch (n) {
            default: 
        }
        return new Token();
    }
}

