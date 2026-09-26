/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public class TokenMgrError
extends Error {
    static final long serialVersionUID;
    static final int LEXICAL_ERROR;
    static final int STATIC_LEXER_ERROR;
    static final int INVALID_LEXICAL_STATE;
    static final int LOOP_DETECTED;
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
                        String string2 = new StringBuffer().append("0000").append(Integer.toString(c2, 16)).toString();
                        stringBuffer.append(new StringBuffer().append("\\u").append(string2.substring(string2.length() - 4, string2.length())).toString());
                        continue block11;
                    }
                    stringBuffer.append(c2);
                }
            }
        }
        return stringBuffer.toString();
    }

    private static final String LexicalError(boolean bl, int n, int n2, int n3, String string, char c2) {
        return new StringBuffer().append("Lexical error at line ").append(n2).append(", column ").append(n3).append(".  Encountered: ").append(bl ? "<EOF> " : new StringBuffer().append("\"").append(TokenMgrError.addEscapes(String.valueOf(c2))).append("\"").append(" (").append((int)c2).append("), ").toString()).append("after : \"").append(TokenMgrError.addEscapes(string)).append("\"").toString();
    }

    @Override
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

