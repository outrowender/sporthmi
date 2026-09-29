/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.log.LogChannel;

public class MLCursor
implements ICopyTo {
    private static LogChannel lc;
    public static final boolean DEBUG_CPOS;
    public static final int CURSOR_MODE_WORD;
    public static final int CURSOR_MODE_CHAR;
    public static final String[] CURSOR_MODE_TO_STRING;
    public static final String NO_VALUE_TO_STRING_MAPPING;
    public static final int[] EMPTY;
    private int cursorWordMode = 0;
    private int position = 0;
    private StringBuffer sb = new StringBuffer();
    private char[] charArray = null;
    private int length = 0;
    private int[] currentWord = null;
    private int lastFixedChar = 0;
    protected int[] lastSequenceWord = EMPTY;
    private boolean isDirty = false;

    public static String valueToString(int n, String[] stringArray) {
        return new StringBuffer().append(n >= 0 && stringArray != null && n < stringArray.length ? stringArray[n] : "NO_VALUE_TO_STRING_MAPPING").append(" ( ").append(n).append(" )").toString();
    }

    public int getCursorMode() {
        lc.log(-2137614336, "MLCursor#getCursorMode");
        return this.cursorWordMode;
    }

    public int getLength() {
        lc.log(-2137614336, "MLCursor#getLength");
        return this.length;
    }

    public void replace(String string) {
        lc.log(-2137614336, "MLCursor#replace    replace with:%1", (Object)string);
        int[] nArray = this.getCurrentWord();
        if (nArray[0] != -1) {
            this.remove();
        }
        this.addWord(string);
    }

    public void clear() {
        lc.log(-2137614336, "MLCursor#clear");
        this.sb.delete(0, this.sb.length());
        this.position = 0;
        this.currentWord = null;
        this.invalidataCharArray(-1);
    }

    public MLCursor() {
        this("");
    }

    public MLCursor(String string) {
        lc.log(-2137614336, "MLCursor#MLCursor(String)   String:%1", (Object)string);
        this.sb = string != null ? new StringBuffer(string) : new StringBuffer();
        this.length = string != null ? string.length() : 0;
    }

    public MLCursor(LogChannel logChannel) {
        lc = logChannel;
    }

    public void setCursorMode(int n) {
        lc.log(-2137614336, "MLCursor#setCursorMode   wordmode:%1", (long)n);
        this.cursorWordMode = n;
    }

    public int[] remove() {
        lc.log(-2137614336, "MLCursor#remove");
        if (this.cursorWordMode == 0) {
            return this.removeWord();
        }
        return new int[]{this.removeChar()};
    }

    public int[] next() {
        lc.log(-2137614336, "MLCursor#next");
        int[] nArray = null;
        nArray = this.cursorWordMode == 0 ? this.getNextWord() : new int[]{this.getNextChar()};
        return nArray;
    }

    public int[] prev() {
        lc.log(-2137614336, "MLCursor#prev");
        int[] nArray = null;
        nArray = this.cursorWordMode == 0 ? this.getPrevWord() : new int[]{this.getPrevChar()};
        return nArray;
    }

    public int[] current() {
        lc.log(-2137614336, "MLCursor#current");
        int[] nArray = null;
        nArray = this.cursorWordMode == 0 ? this.getCurrentWord() : new int[]{this.getCurrentChar()};
        return nArray;
    }

    public int getCursorPos() {
        lc.log(-2137614336, "MLCursor#getCursorPos");
        return this.position;
    }

    public void setCursorPos(int n) {
        lc.log(-2137614336, "MLCursor#setCursorPos   newpos:%1", (long)n);
        this.position = this.clampCursor(n);
        this.invalidateCurrentWord();
    }

    public int getCurrentChar() {
        lc.log(-2137614336, "MLCursor#getCurrentChar");
        return this.position - 1;
    }

    public int getNextChar() {
        lc.log(-2137614336, "MLCursor#getNextChar");
        int n = -1;
        if (this.length > 0 && this.position < this.length) {
            n = this.position++;
            this.invalidateCurrentWord();
        }
        return n;
    }

    public int getPrevChar() {
        lc.log(-2137614336, "MLCursor#getPrevChar");
        int n = -1;
        if (this.length > 0 && this.position > 0) {
            --this.position;
            n = this.position;
            this.invalidateCurrentWord();
        } else {
            this.position = 0;
        }
        return n;
    }

    public String getString() {
        lc.log(-2137614336, "MLCursor#getString");
        return this.sb.toString();
    }

    public char[] getCharArray() {
        lc.log(-2137614336, "MLCursor#getCharArray");
        if (this.charArray == null) {
            if (this.sb.length() > 0) {
                this.charArray = this.sb.toString().toCharArray();
                this.length = this.charArray.length;
            } else {
                this.position = 0;
                this.charArray = null;
                this.length = 0;
            }
        }
        return this.charArray;
    }

    public void addChar(char c2) {
        lc.log(-2137614336, "MLCursor#addChar   char:%1", c2);
        this.lastSequenceWord = EMPTY;
        this.sb.insert(this.position, c2);
        this.invalidataCharArray(this.position - 1);
        this.getNextChar();
        this.currentWord = null;
    }

    public int[] getLastAddedWord() {
        lc.log(-2137614336, "MLCursor#getLastAddedWord");
        return this.lastSequenceWord;
    }

    public void addWord(String string) {
        lc.log(-2137614336, "MLCursor#addWord   word:%1", (Object)string);
        if (string == null || string.length() == 0) {
            return;
        }
        this.position = Math.max(this.position, 0);
        this.lastSequenceWord = new int[]{this.position, this.position + string.length()};
        this.sb.insert(this.position, string);
        int n = this.position;
        this.position += string.length();
        this.invalidataCharArray(n - 1);
        this.currentWord = null;
    }

    public int removeChar() {
        lc.log(-2137614336, "MLCursor#removeChar");
        this.lastSequenceWord = EMPTY;
        int n = this.getCurrentChar();
        if (n >= 0) {
            int n2 = this.getPrevChar();
            this.sb.deleteCharAt(n);
            n = n2;
            this.invalidataCharArray(this.position - 1);
            this.currentWord = null;
        }
        return n;
    }

    public int[] removeWord() {
        lc.log(-2137614336, "MLCursor#removeWord");
        this.lastSequenceWord = EMPTY;
        int[] nArray = this.getCurrentWord();
        if (nArray[0] >= 0) {
            int[] nArray2 = this.getPrevWord();
            this.sb.delete(nArray[0], nArray[1] + 1);
            nArray = nArray2;
            this.currentWord = null;
            if (nArray2[0] == -1) {
                this.setCursorPos(0);
            }
            this.invalidataCharArray(nArray[0] - 1);
        }
        return nArray;
    }

    public void remove(int n, int n2) {
        lc.log(-2137614336, "MLCursor#remove  start:%1   end:%2", (long)n, (long)n2);
        if (this.length > 0) {
            this.lastSequenceWord = EMPTY;
            n = this.clampCursor(n);
            n2 = this.clampCursor(n2);
            int n3 = Math.min(n, n2);
            int n4 = Math.max(n, n2);
            this.sb.delete(n3, n4 + 1);
            this.length = this.sb.length();
            if (this.position >= n3) {
                this.position = this.clampCursor(n3);
            }
            this.invalidataCharArray(this.position - 1);
            this.currentWord = null;
        }
    }

    public int[] getCurrentWord() {
        lc.log(-2137614336, "MLCursor#getCurrentWord");
        int[] nArray = this.currentWord;
        if (nArray == null) {
            nArray = new int[]{-1, -1};
            char[] cArray = this.getCharArray();
            if (cArray != null) {
                int n = this.clampCursor(this.getCurrentChar());
                int n2 = MLUtils.getCharType(cArray[n], n);
                nArray[0] = this.searchUntilTypeDiff(n2, false, cArray, n);
                nArray[1] = this.searchUntilTypeDiff(n2, true, cArray, n);
                this.currentWord = nArray;
            }
        }
        return nArray;
    }

    public int[] getNextWord() {
        lc.log(-2137614336, "MLCursor#getNextWord");
        int[] nArray = new int[]{-1, -1};
        char[] cArray = this.getCharArray();
        if (cArray != null && this.position < this.length) {
            int n = this.clampCursor(this.getCurrentChar());
            int n2 = MLUtils.getCharType(cArray[n], n);
            int n3 = this.currentWord != null ? this.currentWord[1] : -1;
            int n4 = n3 = n3 != -1 ? n3 : this.searchUntilTypeDiff(n2, true, cArray, n);
            if (n3 != -1 && n3 + 1 < this.length) {
                nArray[0] = n3 + 1;
                int n5 = MLUtils.getCharType(cArray[nArray[0]], nArray[0]);
                nArray[1] = this.searchUntilTypeDiff(n5, true, cArray, nArray[0]);
                this.position = this.clampCursor(nArray[1] + 1);
                this.currentWord = nArray;
            }
        }
        return nArray;
    }

    public int[] getPrevWord() {
        lc.log(-2137614336, "MLCursor#getPrevWord");
        int[] nArray = new int[]{-1, -1};
        char[] cArray = this.getCharArray();
        if (cArray != null && this.position > 0) {
            int n = MLUtils.getCharType(cArray[this.position - 1], this.position - 1);
            int n2 = this.currentWord != null ? this.currentWord[0] : -1;
            int n3 = n2 = n2 != -1 ? n2 : this.searchUntilTypeDiff(n, false, cArray, this.position - 1);
            if (n2 != -1 && n2 - 1 >= 0) {
                nArray[1] = n2 - 1;
                int n4 = MLUtils.getCharType(cArray[nArray[1]], nArray[1]);
                nArray[0] = this.searchUntilTypeDiff(n4, false, cArray, nArray[1]);
                this.position = this.clampCursor(nArray[1] + 1);
                this.currentWord = nArray;
            }
        }
        return nArray;
    }

    public int getLastFixedChar() {
        lc.log(-2137614336, "MLCursor#getLastFixedChar");
        return this.lastFixedChar;
    }

    public int clamp(int n) {
        lc.log(-2137614336, "MLCursor#clamp  value:%1", (long)n);
        n = Math.max(0, n);
        n = Math.min(n, this.sb.length());
        return n;
    }

    public String toSB(int[] nArray) {
        lc.log(-2137614336, "MLCursor#toSB");
        String string = null;
        if (nArray != null) {
            if (nArray.length == 1) {
                if (this.clamp(nArray[0]) == nArray[0]) {
                    string = this.getCharArray().length > 0 ? Character.toString(this.getCharArray()[nArray[0]]) : null;
                }
            } else if (nArray.length == 2 && nArray[0] == this.clamp(nArray[0]) && nArray[1] == this.clamp(nArray[1])) {
                string = this.getCharArray().length > 0 ? this.sb.substring(nArray[0], nArray[1] + 1) : null;
            }
        }
        return string;
    }

    public String toString() {
        lc.log(-2137614336, "MLCursor#toString");
        return this.print2SB(new StringBuffer()).toString();
    }

    public StringBuffer print2SB(StringBuffer stringBuffer) {
        lc.log(-2137614336, "MLCursor#print2SB  buffer:%1", (Object)stringBuffer);
        if (stringBuffer != null) {
            stringBuffer.append('[').append(this.position).append(',').append(this.length).append("] = \"").append(this.sb).append('\"');
        }
        return stringBuffer;
    }

    public boolean isDirty() {
        lc.log(-2137614336, "MLCursor#isDirty");
        return this.isDirty;
    }

    public void resetDirty() {
        lc.log(-2137614336, "MLCursor#resetDirty");
        this.lastFixedChar = this.length;
        this.isDirty = false;
    }

    @Override
    public boolean copyTo(ICopyTo iCopyTo) {
        lc.log(-2137614336, "MLCursor#copyTo");
        boolean bl = false;
        try {
            if (iCopyTo instanceof MLCursor) {
                MLCursor mLCursor = (MLCursor)iCopyTo;
                mLCursor.cursorWordMode = this.cursorWordMode;
                mLCursor.position = this.position;
                mLCursor.length = this.sb.length();
                mLCursor.sb = new StringBuffer();
                mLCursor.sb.append(this.sb);
                mLCursor.lastSequenceWord = new int[this.lastSequenceWord.length];
                System.arraycopy((Object)this.lastSequenceWord, 0, (Object)mLCursor.lastSequenceWord, 0, this.lastSequenceWord.length);
                mLCursor.lastFixedChar = 0;
                mLCursor.currentWord = null;
                mLCursor.isDirty = false;
                bl = true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    protected int searchUntilTypeDiff(int n, boolean bl, char[] cArray, int n2) {
        lc.log(-2137614336, "MLCursor#searchUntilTypeDiff  typeValue:%1  startindex:%2", (long)n, (long)n2);
        int n3 = -1;
        int n4 = cArray.length;
        if (bl) {
            for (int i2 = n2; i2 < n4; ++i2) {
                n3 = i2;
                if (n == MLUtils.getCharType(cArray[i2], i2)) continue;
                --n3;
                break;
            }
        } else {
            for (int i3 = n2; i3 >= 0; --i3) {
                n3 = i3;
                if (n == MLUtils.getCharType(cArray[i3], i3)) continue;
                ++n3;
                break;
            }
        }
        return n3;
    }

    protected void invalidateCurrentWord() {
        lc.log(-2137614336, "MLCursor#invalidateCurrentWord");
        if (this.currentWord != null && (this.position - 1 < this.currentWord[0] || this.position - 1 > this.currentWord[1])) {
            this.currentWord = null;
        }
    }

    protected void invalidataCharArray(int n) {
        lc.log(-2137614336, "MLCursor#invalidataCharArray  lastFixedChar:%1", (long)n);
        this.charArray = null;
        this.lastFixedChar = Math.max(Math.min(this.lastFixedChar, n), 0);
        this.isDirty = true;
        this.length = this.sb.length();
    }

    protected int clampCursor(int n) {
        lc.log(-2137614336, "MLCursor#clampCursor   value:%1", (long)n);
        int n2 = n < 0 ? 0 : n;
        n2 = n2 > this.length ? this.length : n2;
        return n2;
    }

    static {
        CURSOR_MODE_TO_STRING = new String[]{"CURSOR_MODE_WORD", "CURSOR_MODE_CHAR"};
        EMPTY = new int[]{-1, -1};
    }
}

