/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public class TokenMgrError
extends Error {
    static final long serialVersionUID = 2843513002462329650L;
    static final int LEXICAL_ERROR = 0;
    static final int STATIC_LEXER_ERROR = 1;
    static final int INVALID_LEXICAL_STATE = 2;
    static final int LOOP_DETECTED = 3;
    int errorCode;

    protected static final String addEscapes(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        block11: for (int i2 = 0; i2 < string.length(); ++i2) {
            switch (string.charAt(i2)) {
                case '\u0000': {
                    continue block11;
                }
                case '\b': {
                    stringBuffer.append("\\b");
                    continue block11;
                }
                case '\t': {
                    stringBuffer.append("\\t");
                    continue block11;
                }
                case '\n': {
                    stringBuffer.append("\\n");
                    continue block11;
                }
                case '\f': {
                    stringBuffer.append("\\f");
                    continue block11;
                }
                case '\r': {
                    stringBuffer.append("\\r");
                    continue block11;
                }
                case '\"': {
                    stringBuffer.append("\\\"");
                    continue block11;
                }
                case '\'': {
                    stringBuffer.append("\\'");
                    continue block11;
                }
                case '\\': {
                    stringBuffer.append("\\\\");
                    continue block11;
                }
                default: {
                    char c2 = string.charAt(i2);
                    if (c2 < ' ' || c2 > '~') {
                        String string2 = "0000" + Integer.toString(c2, 16);
                        stringBuffer.append("\\u" + string2.substring(string2.length() - 4, string2.length()));
                        continue block11;
                    }
                    stringBuffer.append(c2);
                }
            }
        }
        return stringBuffer.toString();
    }

    private static final String LexicalError(boolean bl, int n, int n2, int n3, String string, char c2) {
        return "Lexical error at line " + n2 + ", column " + n3 + ".  Encountered: " + (bl ? "<EOF> " : "\"" + TokenMgrError.addEscapes(String.valueOf(c2)) + "\"" + " (" + c2 + "), ") + "after : \"" + TokenMgrError.addEscapes(string) + "\"";
    }

    public String getMessage() {
        return super.getMessage();
    }

    public TokenMgrError() {
    }

    public TokenMgrError(String string, int n) {
        super(string);
        this.errorCode = n;
    }

    public TokenMgrError(boolean bl, int n, int n2, int n3, String string, char c2, int n4) {
        this(TokenMgrError.LexicalError(bl, n, n2, n3, string, c2), n4);
    }
}

