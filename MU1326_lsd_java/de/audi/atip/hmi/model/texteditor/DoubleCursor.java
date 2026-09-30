/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.mlcursorll.MLCursorLL;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;

public class DoubleCursor
implements ICopyTo {
    private LogChannel lc;
    protected MLCursor sbCursor;
    protected MLCursorLL llCursor;
    protected int[] lastAppended;
    private String replacedWord = null;
    private int doModelNotifications = 0;
    private TextEditorModelDDGUI model;
    private boolean isLLLocked = false;

    public DoubleCursor(TextEditorModelDDGUI textEditorModelDDGUI) {
        this.model = textEditorModelDDGUI;
        this.doModelNotifications = 0;
        this.lc = this.model.getModelLogChannel();
        this.sbCursor = new MLCursor(this.lc);
        this.llCursor = new MLCursorLL(this.lc);
    }

    public String[] getAlternatives() {
        this.lc.log(10000000, "DoubleCursor#getAlternatives ");
        return this.llCursor.getAlternatives();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean selectAlternative(int n) {
        this.lc.log(10000000, "DoubleCursor#selectAlternative index:%1", (long)n);
        boolean bl = false;
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            bl = this.llCursor.selectAlternative(n);
            this.sbCursor.replace(this.llCursor.getCurrentWord());
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bl = false;
        }
        finally {
            this.unfreezeModelNotif();
        }
        return bl;
    }

    public void insertChar(char c2) {
        this.lc.log(10000000, "DoubleCursor#insertChar char:%1", c2);
        this.freezeModelNotif();
        this.lastAppended = null;
        this.lockLL(false);
        this.sbCursor.addChar(c2);
        this.llCursor.addChar(c2);
        this.unfreezeModelNotif();
    }

    private String replaceNewline(String string) {
        this.lc.log(10000000, "DoubleCursor#replaceNewline str:%1", (Object)string);
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == '\r' && i2 < string.length() - 1 && string.charAt(i2 + 1) == '\n') {
                buffer.append('\n');
                ++i2;
                continue;
            }
            buffer.append(string.charAt(i2));
        }
        return buffer.toString();
    }

    private String[] removeEmptyStrings(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2].length() == 0) continue;
            arrayList.add(stringArray[i2]);
        }
        if (!arrayList.isEmpty()) {
            return (String[])arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    private String[][] removeEmptyStrings(String[][] stringArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String[] stringArray2 = this.removeEmptyStrings(stringArray[i2]);
            if (stringArray2 == null) continue;
            arrayList.add(stringArray2);
        }
        return (String[][])arrayList.toArray((Object[])new String[arrayList.size()][]);
    }

    public void insertWord(String string) {
        this.lc.log(10000000, "DoubleCursor#insertWord(String) word:%1", (Object)string);
        string = this.replaceNewline(string);
        this.freezeModelNotif();
        this.lastAppended = null;
        this.lockLL(false);
        int n = this.sbCursor.getCursorPos();
        n = Math.max(0, n);
        this.sbCursor.addWord(string);
        this.lastAppended = new int[]{n, this.sbCursor.getCursorPos()};
        this.llCursor.addWord(string);
        this.unfreezeModelNotif();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void insertWord(String[] stringArray) {
        this.lc.log(10000000, "DoubleCursor#insertWord(String[]) wordWithAlt:%1", (Object)stringArray);
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            int n = this.sbCursor.getCursorPos();
            n = Math.max(0, n);
            String[] stringArray2 = this.removeEmptyStrings(stringArray);
            this.sbCursor.addWord(stringArray2[0]);
            this.lastAppended = new int[]{n, this.sbCursor.getCursorPos()};
            this.llCursor.insertWord(stringArray2);
        }
        finally {
            this.unfreezeModelNotif();
        }
    }

    private void insertWordsImpl(String[][] stringArray) {
        this.lc.log(10000000, "DoubleCursor#insertWordsImpl wordWithAlt:%1", (Object)stringArray);
        int n = this.sbCursor.getCursorPos();
        n = Math.max(0, n);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.sbCursor.addWord(stringArray[i2][0]);
        }
        this.lastAppended = new int[]{n, this.sbCursor.getCursorPos()};
        this.llCursor.insertWordsNew(stringArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void insertWords(String[][] stringArray) {
        this.lc.log(10000000, "DoubleCursor#insertWords(String[][]) wordWithAlt:%1", (Object)stringArray);
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            String[][] stringArray2 = this.removeEmptyStrings(stringArray);
            this.insertWordsImpl(stringArray2);
        }
        finally {
            this.unfreezeModelNotif();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String[][] stringArray) {
        this.lc.log(10000000, "DoubleCursor#replace(String[][]) alternatives:%1", (Object)stringArray);
        boolean bl = false;
        try {
            this.freezeModelNotif();
            this.replacedWord = this.currentWord();
            boolean bl2 = bl = stringArray != null && stringArray.length > 0;
            if (bl) {
                this.removeWord();
                this.replacedWord = this.replacedWord == null || this.replacedWord.length() == 0 ? null : this.replacedWord;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.insertWord(stringArray[i2]);
                }
                this.lastAppended = null;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bl = false;
        }
        finally {
            this.unfreezeModelNotif();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String string) {
        boolean bl;
        this.lc.log(10000000, "DoubleCursor#replace(String) string:%1", (Object)string);
        boolean bl2 = bl = string != null;
        if (bl) {
            try {
                this.freezeModelNotif();
                this.replacedWord = this.currentWord();
                this.replacedWord = this.replacedWord == null || this.replacedWord.length() == 0 ? null : this.replacedWord;
                this.remove();
                this.insertWord(string);
                this.lastAppended = null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                bl = false;
            }
            finally {
                this.unfreezeModelNotif();
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove() {
        this.lc.log(10000000, "DoubleCursor#remove");
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            this.sbCursor.remove();
            this.llCursor.remove();
        }
        finally {
            this.unfreezeModelNotif();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int removeChar() {
        this.lc.log(10000000, "DoubleCursor#removeChar");
        int n = -1;
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            n = this.sbCursor.removeChar();
            this.llCursor.removeChar();
        }
        finally {
            this.unfreezeModelNotif();
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] removeWord() {
        this.lc.log(10000000, "DoubleCursor#removeWord");
        int[] nArray = MLCursor.EMPTY;
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            nArray = this.sbCursor.removeWord();
            this.llCursor.removeWord();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            nArray = MLCursor.EMPTY;
        }
        finally {
            this.unfreezeModelNotif();
        }
        return nArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(int n, int n2, int n3) {
        this.lc.log(10000000, "DoubleCursor#remove   start:%1   end:%2   cPosition:%3", (long)n, (long)n2, (long)n3);
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            this.sbCursor.remove(n, n2);
            this.llCursor.remove(n, n2);
            this.setCursorPos(n3);
        }
        finally {
            this.unfreezeModelNotif();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void replace(String[] stringArray) {
        this.lc.log(10000000, "DoubleCursor#replace(String[])  replaceString:%1", (Object)stringArray);
        try {
            this.freezeModelNotif();
            this.lastAppended = null;
            this.lockLL(false);
            String[] stringArray2 = this.removeEmptyStrings(stringArray);
            this.sbCursor.replace(stringArray2[0]);
            this.llCursor.replace(stringArray2);
        }
        finally {
            this.unfreezeModelNotif();
        }
    }

    public int nextChar() {
        this.lc.log(10000000, "DoubleCursor#nextChar");
        return this.sbCursor.getNextChar();
    }

    public int[] nextWord() {
        this.lc.log(10000000, "DoubleCursor#nextWord");
        return this.sbCursor.getNextWord();
    }

    public int[] next() {
        this.lc.log(10000000, "DoubleCursor#next");
        return this.sbCursor.next();
    }

    public int prevChar() {
        this.lc.log(10000000, "DoubleCursor#prevChar");
        return this.sbCursor.getPrevChar();
    }

    public int[] prevWord() {
        this.lc.log(10000000, "DoubleCursor#prevWord");
        return this.sbCursor.getPrevWord();
    }

    public int[] prev() {
        this.lc.log(10000000, "DoubleCursor#prev");
        return this.sbCursor.prev();
    }

    public String current() {
        this.lc.log(10000000, "DoubleCursor#current");
        int[] nArray = this.sbCursor.current();
        String string = null;
        if (nArray[0] != -1) {
            string = this.sbCursor.getCursorMode() == 1 ? Character.toString(this.sbCursor.getString().charAt(nArray[0])) : this.sbCursor.getString().substring(nArray[0], nArray[1] + 1);
        }
        return string;
    }

    public int[] currentIdx() {
        this.lc.log(10000000, "DoubleCursor#currentIdx");
        return this.sbCursor.current();
    }

    public char[] getCharArray() {
        this.lc.log(10000000, "DoubleCursor#getCharArray");
        return this.sbCursor.getCharArray();
    }

    public char currentChar() {
        this.lc.log(10000000, "DoubleCursor#currentChar");
        int n = this.sbCursor.getCurrentChar();
        return n != -1 ? this.sbCursor.getString().charAt(n) : (char)'\u0000';
    }

    public int currentCharIdx() {
        this.lc.log(10000000, "DoubleCursor#currentCharIdx");
        return this.sbCursor.getCurrentChar();
    }

    public boolean stringAssertFailed(String string, String string2) {
        this.lc.log(10000000, "DoubleCursor#stringAssertFailed  string1:%1   string2:%2", (Object)string, (Object)string2);
        return !this.sCmp(string, string2);
    }

    public String currentWord() {
        this.lc.log(10000000, "DoubleCursor#currentWord");
        String string = "";
        int[] nArray = this.sbCursor.getCurrentWord();
        if (nArray[0] != -1) {
            string = this.sbCursor.getString().substring(nArray[0], nArray[1] + 1);
        }
        return string;
    }

    public int[] currentWordIdx() {
        this.lc.log(10000000, "DoubleCursor#currentWordIdx");
        return this.sbCursor.getCurrentWord();
    }

    public int currentWordLen() {
        this.lc.log(10000000, "DoubleCursor#currentWordLen");
        int[] nArray = this.sbCursor.getCurrentWord();
        int n = 0;
        if (nArray[0] != -1) {
            n = nArray[1] - nArray[0] + 1;
        }
        return n;
    }

    public int getCursorPos() {
        this.lc.log(10000000, "DoubleCursor#getCursorPos");
        this.llCursor.setCursorPos(this.sbCursor.getCursorPos());
        return this.sbCursor.getCursorPos();
    }

    public void setCursorPos(int n) {
        this.lc.log(10000000, "DoubleCursor#setCursorPos");
        this.sbCursor.setCursorPos(n);
        if (!this.isLLLocked) {
            this.llCursor.setCursorPos(n);
        }
    }

    public String getString() {
        this.lc.log(10000000, "DoubleCursor#getString");
        return this.sbCursor.getString();
    }

    public int getCursorMode() {
        this.lc.log(10000000, "DoubleCursor#getCursorMode");
        return this.sbCursor.getCursorMode();
    }

    public void setCursorMode(int n) {
        this.lc.log(10000000, "DoubleCursor#setCursorMode  WordMode:%1", (long)n);
        this.sbCursor.setCursorMode(n);
        this.llCursor.setCursorMode(n);
    }

    public int length() {
        this.lc.log(10000000, "DoubleCursor#length");
        return this.sbCursor.getLength();
    }

    public boolean isDirty() {
        this.lc.log(10000000, "DoubleCursor#isDirty");
        return this.sbCursor.isDirty();
    }

    public void resetDirty() {
        this.lc.log(10000000, "DoubleCursor#resetDirty");
        this.sbCursor.resetDirty();
    }

    public int getLastFixedChar() {
        this.lc.log(10000000, "DoubleCursor#getLastFixedChar");
        return this.sbCursor.getLastFixedChar();
    }

    public void clear() {
        this.lc.log(10000000, "DoubleCursor#clear");
        this.sbCursor.clear();
        this.llCursor.clear();
    }

    public String lastAdded() {
        this.lc.log(10000000, "DoubleCursor#lastAdded");
        return this.lastAppended != null ? this.sbCursor.getString().substring(this.lastAppended[0], this.lastAppended[1]) : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeLastAdded() {
        boolean bl;
        this.lc.log(10000000, "DoubleCursor#removeLastAdded");
        boolean bl2 = bl = this.lastAppended != null;
        if (bl) {
            try {
                this.freezeModelNotif();
                this.remove(this.lastAppended[0], this.lastAppended[1] - 1, this.lastAppended[0]);
                this.lastAppended = null;
            }
            finally {
                this.unfreezeModelNotif();
            }
        } else {
            this.replacedWord = null;
        }
        return bl;
    }

    public void lockLL(boolean bl) {
        this.lc.log(10000000, "DoubleCursor#lockLL");
    }

    public void syncLL() {
        this.lc.log(10000000, "DoubleCursor#syncLL");
        this.llCursor.setCursorMode(this.sbCursor.getCursorMode());
        if (this.llCursor.getCursorPos() != this.sbCursor.getCursorPos()) {
            this.llCursor.setCursorPos(this.sbCursor.getCursorPos());
        }
    }

    public boolean mtxAquireLock() {
        this.lc.log(10000000, "DoubleCursor#mtxAquireLock");
        return true;
    }

    public void mtxReleaseLock() {
        this.lc.log(10000000, "DoubleCursor#mtxReleaseLock");
    }

    public void freezeModelNotif() {
        this.lc.log(10000000, "DoubleCursor#freezeModelNotif");
        ++this.doModelNotifications;
    }

    public void unfreezeModelNotif() {
        this.lc.log(10000000, "DoubleCursor#unfreezeModelNotif");
        --this.doModelNotifications;
        if (this.doModelNotifications == 0 && this.model != null) {
            this.model.notifyTextChanged(this.sbCursor.getLastFixedChar());
        }
    }

    public boolean copyTo(ICopyTo iCopyTo) {
        this.lc.log(10000000, "DoubleCursor#copyTo");
        if (!(iCopyTo instanceof DoubleCursor)) {
            return false;
        }
        DoubleCursor doubleCursor = (DoubleCursor)iCopyTo;
        if (doubleCursor.llCursor == null || doubleCursor.sbCursor == null) {
            return false;
        }
        if (!this.llCursor.copyTo(doubleCursor.llCursor) || !this.sbCursor.copyTo(doubleCursor.sbCursor)) {
            return false;
        }
        doubleCursor.isLLLocked = false;
        doubleCursor.lastAppended = null;
        if (this.lastAppended != null) {
            doubleCursor.lastAppended = new int[]{this.lastAppended[0], this.lastAppended[1]};
        }
        return true;
    }

    public String toString() {
        this.lc.log(10000000, "DoubleCursor#toString");
        return this.print2SB(new StringBuffer()).toString();
    }

    public StringBuffer print2SB(StringBuffer stringBuffer) {
        this.lc.log(10000000, "DoubleCursor#print2SB   buffer:%1", (Object)stringBuffer);
        return this.llCursor.print2SB(this.sbCursor.print2SB(stringBuffer).append("\n"));
    }

    private boolean sCmp(String string, String string2) {
        this.lc.log(10000000, "DoubleCursor#sCmp   string1:%1   string2:%2", (Object)string, (Object)string2);
        return string.equals(string2) || string != null && string2 != null && string.compareTo(string2) == 0;
    }

    public String vaildityCheck() {
        this.lc.log(10000000, "DoubleCursor#vaildityCheck");
        StringBuffer stringBuffer = new StringBuffer();
        String string = this.sbCursor.getString();
        String string2 = this.llCursor.getString();
        boolean bl = this.sCmp(string, string2);
        int n = this.sbCursor.getCursorMode();
        int n2 = this.llCursor.getCursorMode();
        boolean bl2 = n == n2;
        int n3 = this.sbCursor.getCursorPos();
        int n4 = this.llCursor.getCursorPos();
        boolean bl3 = n3 == n4;
        String string3 = this.sbCursor.toSB(this.sbCursor.current());
        String string4 = this.llCursor.current();
        boolean bl4 = this.sCmp(string3, string4);
        String string5 = this.sbCursor.toSB(new int[]{this.sbCursor.getCurrentChar()});
        String string6 = this.llCursor.getCurrentCharAsString();
        boolean bl5 = this.sCmp(string5, string6);
        String string7 = this.sbCursor.toSB(this.sbCursor.getCurrentWord());
        String string8 = this.llCursor.getCurrentWord();
        boolean bl6 = this.sCmp(string7, string8);
        String string9 = this.llCursor.checkListValidity();
        boolean bl7 = bl && bl4 && bl5 && bl6 && bl2 && bl3 && string9 == null;
        stringBuffer.append("DoubleCursor Validity Check: ").append(bl7 ? "PASSED\n" : "FAILED\n");
        stringBuffer.append("StringBuffer Cursor:\n");
        this.sbCursor.print2SB(stringBuffer);
        stringBuffer.append("\nLinkedList Cursor:");
        this.llCursor.print2SB(stringBuffer);
        stringBuffer.append("1. Content Check: ").append(bl ? "PASSED" : "FAILED");
        stringBuffer.append("\n2. CursorMode Check: ").append(bl2 ? "PASSED" : "FAILED");
        stringBuffer.append("\n3. CursorPos Check: ").append(bl3 ? "PASSED" : "FAILED");
        stringBuffer.append("\n4. Current Check: ").append(bl4 ? "PASSED" : "FAILED");
        stringBuffer.append("\n5. Current Char Check: ").append(bl5 ? "PASSED" : "FAILED");
        stringBuffer.append("\n6. Current Word Check: ").append(bl6 ? "PASSED" : "FAILED");
        stringBuffer.append("\n7. LinkedList Check: ").append(string9 == null ? "PASSED" : string9);
        return stringBuffer.toString();
    }
}

