/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.parser.Token;

public class ParseException
extends Exception {
    static final long serialVersionUID = 654626477565941968L;
    protected boolean specialConstructor;
    public Token currentToken;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;
    protected String eol = System.getProperty("line.separator", "\n");

    public ParseException(Token token, int[][] nArray, String[] stringArray) {
        super("");
        this.specialConstructor = true;
        this.currentToken = token;
        this.expectedTokenSequences = nArray;
        this.tokenImage = stringArray;
    }

    public ParseException() {
        this.specialConstructor = false;
    }

    public ParseException(String string) {
        super(string);
        this.specialConstructor = false;
    }

    public String getMessage() {
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        String string = "";
        int n = 0;
        for (int i2 = 0; i2 < this.expectedTokenSequences.length; ++i2) {
            if (n < this.expectedTokenSequences[i2].length) {
                n = this.expectedTokenSequences[i2].length;
            }
            for (int i3 = 0; i3 < this.expectedTokenSequences[i2].length; ++i3) {
                string = string + this.tokenImage[this.expectedTokenSequences[i2][i3]] + " ";
            }
            if (this.expectedTokenSequences[i2][this.expectedTokenSequences[i2].length - 1] != 0) {
                string = string + "...";
            }
            string = string + this.eol + "    ";
        }
        String string2 = "Encountered \"";
        Token token = this.currentToken.next;
        for (int i4 = 0; i4 < n; ++i4) {
            if (i4 != 0) {
                string2 = string2 + " ";
            }
            if (token.kind == 0) {
                string2 = string2 + this.tokenImage[0];
                break;
            }
            string2 = string2 + this.add_escapes(token.image);
            token = token.next;
        }
        string2 = string2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn;
        string2 = string2 + "." + this.eol;
        string2 = this.expectedTokenSequences.length == 1 ? string2 + "Was expecting:" + this.eol + "    " : string2 + "Was expecting one of:" + this.eol + "    ";
        string2 = string2 + string;
        return string2;
    }

    protected String add_escapes(String string) {
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
                        stringBuffer.append("\\u").append(string2.substring(string2.length() - 4, string2.length()));
                        continue block11;
                    }
                    stringBuffer.append(c2);
                }
            }
        }
        return stringBuffer.toString();
    }
}

