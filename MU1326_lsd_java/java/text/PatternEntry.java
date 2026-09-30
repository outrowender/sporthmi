/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.ParseException;

class PatternEntry {
    static final int RESET = -2;
    static final int UNSET = -1;
    int strength = -1;
    String chars = "";
    String extension = "";

    public void appendQuotedExtension(StringBuffer stringBuffer) {
        PatternEntry.appendQuoted(this.extension, stringBuffer);
    }

    public void appendQuotedChars(StringBuffer stringBuffer) {
        PatternEntry.appendQuoted(this.chars, stringBuffer);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        PatternEntry patternEntry = (PatternEntry)object;
        boolean bl = this.chars.equals(patternEntry.chars);
        return bl;
    }

    public int hashCode() {
        return this.chars.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        this.addToBuffer(stringBuffer, true, false, null);
        return stringBuffer.toString();
    }

    final int getStrength() {
        return this.strength;
    }

    final String getExtension() {
        return this.extension;
    }

    final String getChars() {
        return this.chars;
    }

    void addToBuffer(StringBuffer stringBuffer, boolean bl, boolean bl2, PatternEntry patternEntry) {
        if (bl2 && stringBuffer.length() > 0) {
            if (this.strength == 0 || patternEntry != null) {
                stringBuffer.append('\n');
            } else {
                stringBuffer.append(' ');
            }
        }
        if (patternEntry != null) {
            stringBuffer.append('&');
            if (bl2) {
                stringBuffer.append(' ');
            }
            patternEntry.appendQuotedChars(stringBuffer);
            this.appendQuotedExtension(stringBuffer);
            if (bl2) {
                stringBuffer.append(' ');
            }
        }
        switch (this.strength) {
            case 3: {
                stringBuffer.append('=');
                break;
            }
            case 2: {
                stringBuffer.append(',');
                break;
            }
            case 1: {
                stringBuffer.append(';');
                break;
            }
            case 0: {
                stringBuffer.append('<');
                break;
            }
            case -2: {
                stringBuffer.append('&');
                break;
            }
            case -1: {
                stringBuffer.append('?');
            }
        }
        if (bl2) {
            stringBuffer.append(' ');
        }
        PatternEntry.appendQuoted(this.chars, stringBuffer);
        if (bl && this.extension.length() != 0) {
            stringBuffer.append('/');
            PatternEntry.appendQuoted(this.extension, stringBuffer);
        }
    }

    static void appendQuoted(String string, StringBuffer stringBuffer) {
        boolean bl = false;
        char c2 = string.charAt(0);
        if (Character.isSpaceChar(c2)) {
            bl = true;
            stringBuffer.append('\'');
        } else if (PatternEntry.isSpecialChar(c2)) {
            bl = true;
            stringBuffer.append('\'');
        } else {
            switch (c2) {
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case '\u0010': 
                case '@': {
                    bl = true;
                    stringBuffer.append('\'');
                    break;
                }
                case '\'': {
                    bl = true;
                    stringBuffer.append('\'');
                    break;
                }
                default: {
                    if (!bl) break;
                    bl = false;
                    stringBuffer.append('\'');
                }
            }
        }
        stringBuffer.append(string);
        if (bl) {
            stringBuffer.append('\'');
        }
    }

    PatternEntry(int n, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        this.strength = n;
        this.chars = stringBuffer.toString();
        this.extension = stringBuffer2.length() > 0 ? stringBuffer2.toString() : "";
    }

    static boolean isSpecialChar(char c2) {
        return c2 == ' ' || c2 <= '/' && c2 >= '\"' || c2 <= '?' && c2 >= ':' || c2 <= '`' && c2 >= '[' || c2 <= '~' && c2 >= '{';
    }

    static class Parser {
        private String pattern;
        private int i;
        private StringBuffer newChars = new StringBuffer();
        private StringBuffer newExtension = new StringBuffer();

        public Parser(String string) {
            this.pattern = string;
            this.i = 0;
        }

        public PatternEntry next() throws ParseException {
            int n = -1;
            this.newChars.setLength(0);
            this.newExtension.setLength(0);
            boolean bl = true;
            boolean bl2 = false;
            block10: while (this.i < this.pattern.length()) {
                char c2 = this.pattern.charAt(this.i);
                if (bl2) {
                    if (c2 == '\'') {
                        bl2 = false;
                    } else if (this.newChars.length() == 0) {
                        this.newChars.append(c2);
                    } else if (bl) {
                        this.newChars.append(c2);
                    } else {
                        this.newExtension.append(c2);
                    }
                } else {
                    switch (c2) {
                        case '=': {
                            if (n != -1) break block10;
                            n = 3;
                            break;
                        }
                        case ',': {
                            if (n != -1) break block10;
                            n = 2;
                            break;
                        }
                        case ';': {
                            if (n != -1) break block10;
                            n = 1;
                            break;
                        }
                        case '<': {
                            if (n != -1) break block10;
                            n = 0;
                            break;
                        }
                        case '&': {
                            if (n != -1) break block10;
                            n = -2;
                            break;
                        }
                        case '\t': 
                        case '\n': 
                        case '\f': 
                        case '\r': 
                        case ' ': {
                            break;
                        }
                        case '/': {
                            bl = false;
                            break;
                        }
                        case '\'': {
                            bl2 = true;
                            c2 = this.pattern.charAt(++this.i);
                            if (this.newChars.length() == 0) {
                                this.newChars.append(c2);
                                break;
                            }
                            if (bl) {
                                this.newChars.append(c2);
                                break;
                            }
                            this.newExtension.append(c2);
                            break;
                        }
                        default: {
                            if (n == -1) {
                                throw new ParseException(Msg.getString("K01ae", this.pattern.substring(this.i, this.i + 10 < this.pattern.length() ? this.i + 10 : this.pattern.length())), this.i);
                            }
                            if (PatternEntry.isSpecialChar(c2) && !bl2) {
                                throw new ParseException(Msg.getString("K01af", Integer.toString(c2, 16)), this.i);
                            }
                            if (bl) {
                                this.newChars.append(c2);
                                break;
                            }
                            this.newExtension.append(c2);
                        }
                    }
                }
                ++this.i;
            }
            if (n == -1) {
                return null;
            }
            if (this.newChars.length() == 0) {
                throw new ParseException(Msg.getString("K01ae", this.pattern.substring(this.i, this.i + 10 < this.pattern.length() ? this.i + 10 : this.pattern.length())), this.i);
            }
            return new PatternEntry(n, this.newChars, this.newExtension);
        }
    }
}

