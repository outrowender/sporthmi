/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.CursoredLinkedList;
import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.audi.atip.hmi.model.texteditor.mlcursorll.IInsertBoundOps;
import de.audi.atip.hmi.model.texteditor.mlcursorll.InsertLeftBoundOps;
import de.audi.atip.hmi.model.texteditor.mlcursorll.InsertRightBoundOps;
import de.audi.atip.hmi.model.texteditor.mlcursorll.NexCharOp;
import de.audi.atip.hmi.model.texteditor.mlcursorll.NextWordOp;
import de.audi.atip.hmi.model.texteditor.mlcursorll.Op;
import de.audi.atip.hmi.model.texteditor.mlcursorll.PrevCharOp;
import de.audi.atip.hmi.model.texteditor.mlcursorll.PrevWordOp;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.log.LogChannel;

public class MLCursorLL
implements ICopyTo {
    private static LogChannel lc;
    protected int m_cursorPos = 0;
    protected int totalSize = 0;
    protected CursoredLinkedList m_list;
    protected int m_cursorWordMode = 0;
    private InsertLeftBoundOps m_insertLeftBoundOps = new InsertLeftBoundOps();
    private InsertRightBoundOps m_insertRightBoundOps = new InsertRightBoundOps();
    private String[] tmp = new String[1];
    private PrevWordOp prevWordOp = new PrevWordOp();
    private NextWordOp nextWordOp = new NextWordOp();
    private PrevCharOp prevCharOp = new PrevCharOp();
    private NexCharOp nextCharOp = new NexCharOp();

    public MLCursorLL() {
    }

    public MLCursorLL(LogChannel logChannel) {
        lc = logChannel;
        this.m_list = new CursoredLinkedList(logChannel);
    }

    public String getString() {
        lc.log(-2137614336, "MLCursorLL#getString");
        StringBuffer stringBuffer = new StringBuffer();
        if (this.totalSize > 0) {
            ListNode listNode = this.m_list.head.right;
            while (listNode != null && listNode != this.m_list.tail) {
                if (listNode.data != null && listNode.data.length > 0 && listNode.data[0] instanceof MLCursor) {
                    stringBuffer.append(((MLCursor)listNode.data[0]).getString());
                }
                listNode = listNode.right;
            }
        }
        return stringBuffer.toString();
    }

    public void replace(String[] stringArray) {
        lc.log(-2137614336, "MLCursorLL#replace  replaceWith:%1", (Object)stringArray);
        if (this.getCurrentWord() != null) {
            this.remove();
        }
        this.insertWord(stringArray);
    }

    public void addChar(char c2) {
        lc.log(-2137614336, "MLCursorLL#addChar  char:%1", c2);
        MLCursor mLCursor = this.getValidCursor();
        InsertLeftBoundOps insertLeftBoundOps = this.m_insertLeftBoundOps;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (mLCursor == null) {
            bl = true;
        } else {
            boolean bl4;
            if (this.m_list.current.data == null) {
                lc.log(10000, "MLCursorLL#addChar: m_list.current.data is null");
                System.err.println("MLCursorLL#addChar: m_list.current.data is null");
                return;
            }
            boolean bl5 = bl4 = this.m_list.current.data.length != 1;
            if (bl4) {
                int n = mLCursor.getCursorPos();
                if (n > 0 && n < mLCursor.getLength()) {
                    bl3 = true;
                } else {
                    IInsertBoundOps iInsertBoundOps = insertLeftBoundOps = n == 0 ? this.m_insertLeftBoundOps : this.m_insertRightBoundOps;
                    if (insertLeftBoundOps.checkLimitCharType(mLCursor, c2)) {
                        bl3 = true;
                    } else {
                        ListNode listNode = insertLeftBoundOps.boundNode(this.m_list.current);
                        if (listNode == null) {
                            lc.log(10000, "MLCursorLL#addChar: boundNode is null");
                            System.err.println("MLCursorLL#addChar: boundNode is null");
                            return;
                        }
                        if (listNode.data == null) {
                            bl = true;
                        } else if (listNode.data.length == 1) {
                            bl2 = true;
                        } else {
                            MLCursor mLCursor2 = this.getCursor(listNode);
                            if (insertLeftBoundOps.checkBoundCharType(mLCursor2, c2)) {
                                bl2 = true;
                                bl3 = true;
                            } else {
                                bl = true;
                            }
                        }
                    }
                }
            }
        }
        if (bl) {
            mLCursor = new MLCursor();
            mLCursor.setCursorMode(this.m_cursorWordMode);
            insertLeftBoundOps.insertMove(this.m_list, mLCursor);
        }
        if (bl2) {
            mLCursor = insertLeftBoundOps.move(this.m_list, this);
        }
        if (bl3) {
            this.m_list.current.data = new ICopyTo[]{mLCursor};
        }
        mLCursor.addChar(c2);
        ++this.totalSize;
        ++this.m_cursorPos;
        this.mergeNodes();
    }

    public void insertWord(String[] stringArray) {
        lc.log(-2137614336, "MLCursorLL#insertWord   word:%1", (Object)stringArray);
        if (stringArray != null && stringArray.length > 0 && stringArray[0] != null && stringArray[0].length() > 0) {
            MLCursor mLCursor = null;
            InsertLeftBoundOps insertLeftBoundOps = this.m_insertLeftBoundOps;
            int n = stringArray[0].length();
            if (this.m_list.getSize() == 0) {
                insertLeftBoundOps.insertMove(this.m_list, stringArray, this.m_cursorWordMode);
            } else {
                boolean bl;
                boolean bl2 = stringArray.length == 1;
                mLCursor = this.getValidCursor();
                if (mLCursor == null) {
                    return;
                }
                int n2 = mLCursor.getCursorPos();
                boolean bl3 = bl = this.m_list.current.data.length == 1;
                if (bl2) {
                    if (bl) {
                        mLCursor.addWord(stringArray[0]);
                    } else if (n2 > 0 && n2 < mLCursor.getLength()) {
                        this.m_list.current.data = new ICopyTo[]{mLCursor};
                        mLCursor.addWord(stringArray[0]);
                    } else {
                        insertLeftBoundOps = n2 == 0 ? this.m_insertLeftBoundOps : this.m_insertRightBoundOps;
                        insertLeftBoundOps.insertMove(this.m_list, stringArray, this.m_cursorWordMode);
                    }
                } else if (n2 > 0 && n2 < mLCursor.getLength()) {
                    this.split(stringArray);
                } else {
                    insertLeftBoundOps = n2 == 0 ? this.m_insertLeftBoundOps : this.m_insertRightBoundOps;
                    insertLeftBoundOps.insertMove(this.m_list, stringArray, this.m_cursorWordMode);
                }
            }
            this.totalSize += n;
            this.m_cursorPos += n;
            this.mergeNodes();
        }
    }

    public void insertWordsNew(String[][] stringArray) {
        lc.log(-2137614336, "MLCursorLL#insertWordsNew   words:%1", (Object)stringArray);
        ListNode listNode = null;
        ListNode listNode2 = null;
        ListNode listNode3 = null;
        int n = 0;
        if (stringArray != null && stringArray.length > 0) {
            boolean bl = true;
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                ICopyTo[] iCopyToArray = MLUtils.stringArr2ICopyArr(stringArray[i2], true, this.m_cursorWordMode);
                if (iCopyToArray == null) {
                    bl = false;
                    break;
                }
                n += stringArray[i2][0].length();
                listNode2 = new ListNode(listNode2, null, iCopyToArray);
                if (listNode2.left != null) {
                    listNode2.left.right = listNode2;
                }
                listNode = i2 == 0 ? listNode2 : listNode;
                listNode3 = i2 == stringArray.length - 1 ? listNode2 : null;
            }
            if (bl) {
                this.totalSize += n;
                this.m_cursorPos += n;
                if (this.m_list.getSize() == 0) {
                    this.m_list.insertSectionLeft(stringArray.length, listNode, listNode3, 2);
                } else {
                    MLCursor mLCursor = this.getValidCursor();
                    int n2 = mLCursor.getCursorPos();
                    if (n2 > 0 && n2 < mLCursor.getLength()) {
                        this.split(listNode, listNode3);
                    } else if (n2 == 0) {
                        this.m_list.insertSectionLeft(stringArray.length, listNode, listNode3, 0);
                    } else {
                        this.m_list.insertSectionRight(stringArray.length, listNode, listNode3, 0);
                    }
                    try {
                        this.mergeNodes(listNode);
                        this.mergeNodes(listNode3);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            this.setCursorPos(this.m_cursorPos);
        }
    }

    public void addWord(String string) {
        lc.log(-2137614336, "MLCursorLL#addWord   word:%1", (Object)string);
        if (string != null) {
            this.tmp[0] = string;
            this.insertWord(this.tmp);
        }
    }

    public int getCursorMode() {
        lc.log(-2137614336, "MLCursorLL#getCursorMode");
        return this.m_cursorWordMode;
    }

    public void setCursorMode(int n) {
        lc.log(-2137614336, "MLCursorLL#setCursorMode  mode:%1", (long)n);
        this.m_cursorWordMode = n;
        MLCursor mLCursor = this.getCursor();
        if (mLCursor != null) {
            int n2 = mLCursor.getCursorPos();
            mLCursor.setCursorMode(n);
            int n3 = mLCursor.getCursorPos();
            this.m_cursorPos += n3 - n2;
        }
    }

    public String current() {
        lc.log(-2137614336, "MLCursorLL#current");
        return this.m_cursorWordMode == 1 ? this.getCurrentCharAsString() : this.getCurrentWord();
    }

    public boolean nextChar() {
        lc.log(-2137614336, "MLCursorLL#nextChar");
        return this.next(this.nextCharOp);
    }

    public boolean nextWord() {
        lc.log(-2137614336, "MLCursorLL#nextWord");
        return this.next(this.nextWordOp);
    }

    public boolean next() {
        lc.log(-2137614336, "MLCursorLL#next");
        return this.next(this.m_cursorWordMode == 0 ? this.nextWordOp : this.nextCharOp);
    }

    public boolean prevChar() {
        lc.log(-2137614336, "MLCursorLL#prevChar");
        return this.prev(this.prevCharOp);
    }

    public boolean prevWord() {
        lc.log(-2137614336, "MLCursorLL#prevWord");
        return this.prev(this.prevWordOp);
    }

    public boolean prev() {
        lc.log(-2137614336, "MLCursorLL#prev");
        return this.prev(this.m_cursorWordMode == 0 ? this.prevWordOp : this.prevCharOp);
    }

    public char getCurrentChar() {
        lc.log(-2137614336, "MLCursorLL#getCurrentChar");
        char c2 = '\u0000';
        do {
            MLCursor mLCursor;
            if ((mLCursor = this.getValidCursor()) == null) continue;
            int n = -1;
            if (mLCursor.getCursorPos() <= 0) continue;
            n = mLCursor.getCurrentChar();
            if (n != -1) {
                c2 = mLCursor.getCharArray()[mLCursor.getCurrentChar()];
                break;
            }
            lc.log(10000, "MLCursorLL#getCurrentCharAsString   if(currentChar!=-1) !!!!! This should not happen");
        } while (this.prev());
        return c2;
    }

    public String getCurrentWord() {
        lc.log(-2137614336, "MLCursorLL#getCurrentWord");
        String string = null;
        MLCursor mLCursor = this.getValidCursor();
        if (mLCursor != null && mLCursor.getCurrentWord()[0] != -1) {
            int[] nArray = mLCursor.getCurrentWord();
            string = mLCursor.getString().substring(nArray[0], nArray[1] + 1);
        }
        return string;
    }

    public void remove() {
        lc.log(-2137614336, "MLCursorLL#remove");
        if (this.m_cursorWordMode == 0) {
            this.removeWord();
        } else {
            this.removeChar();
        }
    }

    public void removeChar() {
        lc.log(-2137614336, "MLCursorLL#removeChar");
        MLCursor mLCursor = this.getValidCursor();
        if (mLCursor != null && mLCursor.getCurrentChar() != -1) {
            mLCursor.removeChar();
            --this.m_cursorPos;
            --this.totalSize;
            if (this.m_list.current.data.length > 1) {
                this.m_list.current.data = new ICopyTo[]{this.m_list.current.data[0]};
            }
            this.mergeNodes();
        }
    }

    public void removeWord() {
        lc.log(-2137614336, "MLCursorLL#removeWord");
        MLCursor mLCursor = this.getValidCursor();
        if (mLCursor != null) {
            int[] nArray = mLCursor.getCurrentWord();
            int n = mLCursor.getCursorPos();
            if (mLCursor.getCurrentWord()[0] != -1) {
                int n2 = nArray[1] - nArray[0] + 1;
                this.totalSize -= n2;
                this.m_cursorPos -= n2 - (nArray[1] - Math.max(n - 1, 0));
                mLCursor.removeWord();
                if (this.m_list.current.data.length > 1) {
                    this.m_list.current.data = new MLCursor[]{(MLCursor)this.m_list.current.data[0]};
                }
                this.mergeNodes();
            }
        }
    }

    private void stripNode(ListNode listNode) {
        lc.log(-2137614336, "MLCursorLL#stripNode");
        if (listNode != null && listNode.data != null && listNode.data.length > 1) {
            listNode.data = new ICopyTo[]{listNode.data[0]};
        }
    }

    public void remove(int n, int n2) {
        lc.log(-2137614336, "MLCursorLL#remove   start:%1   end:%2", (long)n, (long)n2);
        try {
            if (this.totalSize > 0) {
                n = this.clampCursor(n);
                n2 = this.clampCursor(n2);
                int n3 = Math.min(n, n2);
                int n4 = Math.max(n, n2);
                int n5 = n4 - n3 + 1;
                if (n5 > 1) {
                    ListNode listNode;
                    this.setCursorPos(n3);
                    MLCursor mLCursor = this.getValidCursor();
                    if (mLCursor != null && mLCursor.getCursorPos() == mLCursor.getLength()) {
                        this.setCursorPos(n3 + 1);
                        mLCursor = this.getValidCursor();
                    }
                    int n6 = mLCursor != null ? mLCursor.getCursorPos() : 0;
                    ListNode listNode2 = mLCursor != null ? this.m_list.current : null;
                    this.setCursorPos(n4);
                    MLCursor mLCursor2 = this.getValidCursor();
                    if (mLCursor2 != null && mLCursor2.getCursorPos() == mLCursor2.getLength()) {
                        this.setCursorPos(n4 + 1);
                        mLCursor2 = this.getValidCursor();
                    }
                    int n7 = mLCursor2 != null ? mLCursor2.getCursorPos() : 0;
                    ListNode listNode3 = listNode = mLCursor2 != null ? this.m_list.current : null;
                    if (mLCursor != null && mLCursor2 != null) {
                        if (n6 < mLCursor.getLength()) {
                            this.stripNode(listNode2);
                        }
                        if (n7 > 0) {
                            this.stripNode(listNode);
                        }
                        if (mLCursor == mLCursor2) {
                            mLCursor.remove(n6, n7);
                        } else {
                            mLCursor.remove(n6, mLCursor.getLength());
                            mLCursor2.remove(0, n7);
                            if (this.m_list.current.left != listNode2) {
                                this.m_list.current = listNode.left;
                                ICopyTo[] iCopyToArray = this.m_list.current.data;
                                while (this.m_list.current != listNode2 && iCopyToArray != null) {
                                    this.m_list.removeCurrLeft();
                                }
                            }
                        }
                        this.mergeNodes(listNode2);
                        this.mergeNodes(listNode);
                        this.totalSize -= n4 == n3 ? 1 : n4 - n3 + 1;
                        this.totalSize = Math.max(this.totalSize, 0);
                        if (this.m_cursorPos >= n3) {
                            this.m_cursorPos = this.clampCursor(n3);
                        }
                    }
                    this.setCursorPos(this.m_cursorPos);
                } else {
                    this.setCursorPos(n3 + 1);
                    this.removeChar();
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected int clampCursor(int n) {
        lc.log(-2137614336, "MLCursorLL#clampCursor   value:%1", (long)n);
        int n2 = n < 0 ? 0 : n;
        n2 = n2 > this.totalSize ? this.totalSize : n2;
        return n2;
    }

    public int getSize() {
        lc.log(-2137614336, "MLCursorLL#getSize");
        return this.totalSize;
    }

    public static int clamp(int n, int n2, int n3) {
        lc.log(-2137614336, "MLCursorLL#clamp   value1:%1   value2:%2   value3:%3", (long)n, (long)n2, (long)n3);
        return Math.min(Math.max(n, n3), n2);
    }

    public int getCursorPos() {
        lc.log(-2137614336, "MLCursorLL#getCursorPos");
        return this.m_cursorPos;
    }

    public void setCursorPos(int n) {
        lc.log(-2137614336, "MLCursorLL#setCursorPos   position:%1", (long)n);
        int n2 = 0;
        int n3 = 0;
        this.m_cursorPos = MLCursorLL.clamp(0, this.totalSize, n);
        boolean bl = true;
        this.m_list.move(0);
        MLCursor mLCursor = null;
        do {
            String string = (mLCursor = this.getCursor()) != null ? mLCursor.getString() : null;
            n3 = string != null ? string.length() : 0;
            bl = n3 + (n2 += n3) < this.m_cursorPos;
        } while (bl = bl && this.m_list.moveRight() && this.m_list.current.data != null);
        if (!bl && mLCursor != null) {
            mLCursor.setCursorPos(this.m_cursorPos - n2);
        }
    }

    public void clear() {
        lc.log(-2137614336, "MLCursorLL#clear");
        this.m_list.clear();
        this.totalSize = 0;
        this.m_cursorPos = 0;
    }

    public String[] getAlternatives() {
        int n;
        lc.log(-2137614336, "MLCursorLL#getAlternatives");
        String[] stringArray = null;
        if (this.m_list.getSize() > 0 && this.m_list.current != this.m_list.head && this.m_list.current != this.m_list.tail && (n = this.m_list.current.data.length) > 0) {
            stringArray = new String[n];
            if (n == 1) {
                MLCursor mLCursor = (MLCursor)this.m_list.current.data[0];
                int[] nArray = mLCursor.getCurrentWord();
                if (nArray[0] != -1) {
                    stringArray[0] = mLCursor.getString().substring(nArray[0], nArray[1] + 1);
                }
            } else {
                for (int i2 = 0; i2 < n; ++i2) {
                    stringArray[i2] = ((MLCursor)this.m_list.current.data[i2]).getString();
                }
            }
        }
        return stringArray;
    }

    public boolean selectAlternative(int n) {
        lc.log(-2137614336, "MLCursorLL#selectAlternative");
        boolean bl = false;
        if (n > -1 && n < this.m_list.current.data.length && this.m_list.current.data.length > 1) {
            String string = n == 0 ? ((MLCursor)this.m_list.current.data[0]).getString() : this.m_list.current.data[n].toString();
            String string2 = this.getCurrentWord();
            if (string2 != null && string2.compareTo(string) != 0) {
                MLCursor mLCursor = (MLCursor)this.m_list.current.data[0];
                MLCursor mLCursor2 = (MLCursor)this.m_list.current.data[n];
                mLCursor2.setCursorMode(this.m_cursorWordMode);
                mLCursor2.setCursorPos(mLCursor2.getLength());
                this.m_list.current.data[0] = mLCursor2;
                this.m_list.current.data[n] = mLCursor;
                bl = true;
            }
        }
        return bl;
    }

    public StringBuffer print2SB(StringBuffer stringBuffer) {
        lc.log(-2137614336, "MLCursorLL#print2SB   buffer:%1", (Object)stringBuffer);
        if (stringBuffer != null) {
            ListNode listNode = this.m_list.head;
            while (listNode != null) {
                if (listNode == this.m_list.current) {
                    stringBuffer.append("\n[ ");
                } else {
                    stringBuffer.append('\n');
                }
                if (listNode.data != null) {
                    int n = listNode.data.length;
                    int n2 = n - 1;
                    for (int i2 = 0; i2 < n; ++i2) {
                        stringBuffer.append("{[").append(i2).append('/').append(n2).append(']');
                        if (listNode.data[i2] instanceof MLCursor) {
                            ((MLCursor)listNode.data[i2]).print2SB(stringBuffer);
                        } else {
                            stringBuffer.append(listNode.data[i2].toString());
                        }
                        stringBuffer.append('}');
                    }
                } else {
                    stringBuffer.append(listNode == this.m_list.head || listNode == this.m_list.tail ? " #" : " <null>");
                }
                if (listNode == this.m_list.current) {
                    stringBuffer.append(" ] ");
                }
                listNode = listNode.right;
            }
            stringBuffer.append(new StringBuffer().append("\n<size ").append(this.getSize()).append(" , cPos ").append(this.getCursorPos()).append(" ,listSize ").append(this.m_list.getSize()).append(", cursorMode ").append(MLCursor.valueToString(this.m_cursorWordMode, MLCursor.CURSOR_MODE_TO_STRING)).append(">\n").toString());
        }
        return stringBuffer;
    }

    public String toString() {
        lc.log(-2137614336, "MLCursorLL#toString");
        return this.print2SB(new StringBuffer()).toString();
    }

    @Override
    public boolean copyTo(ICopyTo iCopyTo) {
        lc.log(-2137614336, "MLCursorLL#copyTo");
        if (!(iCopyTo instanceof MLCursorLL)) {
            return false;
        }
        MLCursorLL mLCursorLL = (MLCursorLL)iCopyTo;
        if (mLCursorLL.m_list == null) {
            return false;
        }
        if (!this.m_list.copyTo(mLCursorLL.m_list)) {
            return false;
        }
        mLCursorLL.m_cursorPos = this.m_cursorPos;
        mLCursorLL.totalSize = this.totalSize;
        mLCursorLL.m_cursorWordMode = this.m_cursorWordMode;
        return true;
    }

    public String checkListValidity() {
        String string;
        lc.log(-2137614336, "MLCursorLL#checkListValidity");
        String string2 = string = this.m_list != null && this.m_list.current != null && this.m_list.head != this.m_list.tail && this.m_list.head != null && this.m_list.head.right != null && this.m_list.head.right.left == this.m_list.head && this.m_list.tail != null && this.m_list.tail.left != null && this.m_list.tail.left.right == this.m_list.tail ? null : "Entry Check Failed";
        if (string == null) {
            boolean bl;
            int n = this.m_list.getSize();
            ListNode listNode = this.m_list.head.right;
            int n2 = 0;
            boolean bl2 = bl = this.m_list.current == this.m_list.head || this.m_list.current == this.m_list.tail;
            while (listNode != this.m_list.tail) {
                ++n2;
                if (listNode == null || listNode.data == null || listNode.data.length == 0 || listNode.left == listNode.right || listNode.left == null || listNode.left.right != listNode || listNode.right == null || listNode.right.left != listNode) {
                    string = new StringBuffer().append("L2RCheck:: idx= ").append(n2).append(" node check failed").toString();
                    break;
                }
                boolean bl3 = bl = bl || listNode == this.m_list.current;
                if (n2 > n) {
                    string = new StringBuffer().append("L2RCheck:: listSize ").append(n).append(" currentListSize>listSize check failed").toString();
                    break;
                }
                listNode = listNode.right;
            }
            if (!bl && string == null) {
                string = "L2RCheck:: haven't found current node in between list nodes ";
            }
            if (n2 != n && string == null) {
                string = new StringBuffer().append("L2RCheck:: listSize ").append(n).append(" currentListSize>listSize check failed").toString();
            }
            if (string == null) {
                listNode = this.m_list.tail.left;
                n2 = 0;
                while (listNode != this.m_list.head) {
                    ++n2;
                    if (listNode == null || listNode.data == null || listNode.data.length == 0 || listNode.left == listNode.right || listNode.left == null || listNode.left.right != listNode || listNode.right == null || listNode.right.left != listNode) {
                        string = new StringBuffer().append("R2LCheck:: idx= ").append(n2).append(" node check failed").toString();
                        break;
                    }
                    if (n2 > n) {
                        string = new StringBuffer().append("R2LCheck:: listSize ").append(n).append(" currentListSize>listSize check failed").toString();
                        break;
                    }
                    listNode = listNode.left;
                }
                if (n2 != n && string == null) {
                    string = new StringBuffer().append("R2LCheck:: listSize ").append(n).append(" currentListSize>listSize check failed").toString();
                }
            }
        }
        return string;
    }

    public MLCursor getCursor() {
        lc.log(-2137614336, "MLCursorLL#getCursor");
        ICopyTo[] iCopyToArray = this.m_list.getCNode().data;
        return iCopyToArray != null ? (MLCursor)iCopyToArray[0] : null;
    }

    private boolean next(Op op) {
        lc.log(-2137614336, "MLCursorLL#next");
        boolean bl = false;
        MLCursor mLCursor = this.getCursor();
        if (mLCursor != null) {
            int n = mLCursor.getCursorPos();
            int[] nArray = op.doOp(mLCursor);
            if (nArray[0] != -1) {
                int n2 = mLCursor.getCursorPos();
                int n3 = n2 - n;
                this.m_cursorPos += n3;
                bl = true;
            } else {
                int[] nArray2 = op.noOp(mLCursor);
                if (this.m_list.current.right != this.m_list.tail) {
                    if (nArray2[0] != -1) {
                        this.m_cursorPos += mLCursor.getLength() - n;
                    }
                    while (this.m_list.moveRight()) {
                        mLCursor = this.getCursor();
                        if (mLCursor == null) continue;
                        if (mLCursor.getLength() > 0) {
                            mLCursor.setCursorMode(this.m_cursorWordMode);
                            mLCursor.setCursorPos(this.m_cursorWordMode == 0 ? 0 : 1);
                            nArray = op.noOp(mLCursor);
                            if (nArray[0] != -1) {
                                mLCursor.setCursorPos(nArray.length == 1 ? 1 : nArray[1] + 1);
                                this.m_cursorPos += mLCursor.getCursorPos();
                                bl = true;
                            }
                            break;
                        }
                        if (this.m_list.current == this.m_list.tail) continue;
                        this.m_list.removeCurrLeft();
                    }
                }
            }
        } else if (this.m_list.current == this.m_list.head && this.m_list.current.right != this.m_list.tail) {
            this.m_list.moveRight();
            MLCursor mLCursor2 = this.getCursor();
            if (mLCursor2 != null) {
                mLCursor2.setCursorMode(this.m_cursorWordMode);
                mLCursor2.setCursorPos(0);
                int[] nArray = op.noOp(mLCursor2);
                if (nArray[0] != -1) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private boolean prev(Op op) {
        MLCursor mLCursor;
        lc.log(-2137614336, "MLCursorLL#prev");
        boolean bl = false;
        MLCursor mLCursor2 = this.getCursor();
        if (mLCursor2 != null) {
            int n = mLCursor2.getCursorPos();
            int[] nArray = op.doOp(mLCursor2);
            if (nArray[0] != -1) {
                int n2 = mLCursor2.getCursorPos();
                int n3 = n2 - n;
                this.m_cursorPos += n3;
                bl = true;
            } else {
                int[] nArray2 = op.noOp(mLCursor2);
                if (this.m_list.current.left != this.m_list.head) {
                    if (nArray2[0] != -1) {
                        this.m_cursorPos -= n;
                    }
                    while (this.m_list.moveLeft()) {
                        mLCursor2 = this.getCursor();
                        if (mLCursor2 != null) {
                            if (mLCursor2.getLength() <= 0) continue;
                            mLCursor2.setCursorMode(this.m_cursorWordMode);
                            mLCursor2.setCursorPos(mLCursor2.getString().length());
                            nArray = op.noOp(mLCursor2);
                            if (nArray[0] == -1) continue;
                            bl = true;
                            break;
                        }
                        if (this.m_list.current == this.m_list.head) continue;
                        this.m_list.removeCurrRight();
                    }
                }
            }
        } else if (this.m_list.current == this.m_list.tail && this.m_list.getSize() > 0 && this.m_list.moveLeft() && (mLCursor = this.getCursor()) != null) {
            mLCursor.setCursorPos(mLCursor.getLength());
            int[] nArray = op.noOp(mLCursor);
            if (nArray[0] != -1) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean split(ListNode listNode, ListNode listNode2) {
        lc.log(-2137614336, "MLCursorLL#split(ListNode,ListNode)");
        boolean bl = true;
        if (listNode != null && listNode2 != null && this.m_list != null && this.m_list.current != null) {
            MLCursor mLCursor = this.getValidCursor();
            if (mLCursor != null) {
                ListNode[] listNodeArray = this.split(this.m_list.current);
                if (listNodeArray == null || listNodeArray[0] == null && listNodeArray[1] == null) {
                    bl = false;
                } else if (listNodeArray[1] == null) {
                    this.m_list.insertSectionRight(listNode, listNode2, 2);
                } else {
                    this.m_list.insertSectionLeft(listNode, listNode2, 2);
                }
                if (bl) {
                    mLCursor = this.getCursor();
                    mLCursor.setCursorMode(this.m_cursorWordMode);
                    mLCursor.setCursorPos(mLCursor.getLength());
                }
            } else {
                lc.log(-2137614336, "MLCursorLL#split(ListNode,ListNode) cursor not null");
                bl = false;
            }
        }
        return bl;
    }

    private ListNode[] split(ListNode listNode) {
        MLCursor mLCursor;
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#split(ListNode)");
        ListNode[] listNodeArray = null;
        boolean bl2 = listNode != null && listNode != this.m_list.head && listNode != this.m_list.tail;
        boolean bl3 = bl = bl2 && listNode.data != null && listNode.data.length > 0 && listNode.data[0] instanceof MLCursor;
        if (bl && (mLCursor = (MLCursor)listNode.data[0]).getLength() > 0) {
            int n = mLCursor.getCursorPos();
            if (n > 0 && n < mLCursor.getLength()) {
                if (listNode.data.length > 1) {
                    listNode.data = new ICopyTo[]{listNode.data[0]};
                }
                MLCursor mLCursor2 = new MLCursor(mLCursor.getString().substring(0, n));
                mLCursor2.setCursorMode(this.m_cursorWordMode);
                mLCursor2.setCursorPos(n);
                this.m_list.list.insertLeft(listNode, new ListNode(new ICopyTo[]{mLCursor2}));
                MLCursor mLCursor3 = new MLCursor(mLCursor.getString().substring(n, mLCursor.getLength()));
                mLCursor3.setCursorMode(this.m_cursorWordMode);
                mLCursor3.setCursorPos(0);
                listNode.data[0] = mLCursor3;
                listNodeArray = new ListNode[]{listNode.left, listNode};
            } else {
                listNodeArray = new ListNode[]{n == 0 ? null : listNode, n == 0 ? null : listNode};
            }
        }
        return listNodeArray;
    }

    private boolean split(String[] stringArray) {
        lc.log(-2137614336, "MLCursorLL#split(String[])   words:%1", (Object)stringArray);
        boolean bl = true;
        MLCursor mLCursor = this.getValidCursor();
        if (mLCursor != null) {
            ICopyTo[] iCopyToArray = MLUtils.stringArr2ICopyArr(stringArray, true, this.m_cursorWordMode);
            if (iCopyToArray != null) {
                if (mLCursor.getLength() != 0) {
                    ListNode[] listNodeArray = this.split(this.m_list.current);
                    if (listNodeArray == null || listNodeArray[0] == null && listNodeArray[1] == null) {
                        bl = false;
                    } else if (listNodeArray[1] == null) {
                        this.m_list.insertMoveCRight(iCopyToArray);
                    } else {
                        this.m_list.insertMoveCLeft(iCopyToArray);
                    }
                } else {
                    this.m_list.current.data = iCopyToArray;
                }
                if (bl) {
                    mLCursor = this.getCursor();
                    mLCursor.setCursorMode(this.m_cursorWordMode);
                    mLCursor.setCursorPos(mLCursor.getLength());
                }
            } else {
                bl = false;
            }
        } else {
            this.insertWord(stringArray);
            bl = true;
        }
        return bl;
    }

    private MLCursor getCursor(ListNode listNode) {
        MLCursor mLCursor;
        lc.log(-2137614336, "MLCursorLL#getCursor");
        MLCursor mLCursor2 = mLCursor = listNode != null && listNode.data != null ? (MLCursor)listNode.data[0] : null;
        if (mLCursor != null) {
            mLCursor.setCursorMode(this.m_cursorWordMode);
        }
        return mLCursor;
    }

    private MLCursor getValidCursor() {
        MLCursor mLCursor;
        lc.log(-2137614336, "MLCursorLL#getValidCursor");
        ListNode listNode = this.m_list.current;
        if (listNode == null) {
            return null;
        }
        if (listNode == this.m_list.head && this.m_list.getSize() > 0) {
            listNode = this.m_list.current = listNode.right;
            if (listNode.data != null && listNode.data.length > 0 && listNode.data[0] instanceof MLCursor) {
                this.getCursor(listNode).setCursorMode(this.m_cursorWordMode);
                this.getCursor(listNode).setCursorPos(0);
            }
        }
        if (listNode == this.m_list.tail && this.m_list.getSize() > 0) {
            listNode = this.m_list.current = listNode.left;
            if (listNode.data != null && listNode.data.length > 0 && listNode.data[0] instanceof MLCursor) {
                mLCursor = this.getCursor(listNode);
                mLCursor.setCursorMode(this.m_cursorWordMode);
                mLCursor.setCursorPos(mLCursor.getLength());
            }
        }
        mLCursor = this.getCursor(listNode);
        return mLCursor;
    }

    public String getCurrentCharAsString() {
        lc.log(-2137614336, "MLCursorLL#getCurrentCharAsString");
        String string = null;
        do {
            MLCursor mLCursor;
            if ((mLCursor = this.getValidCursor()) == null) continue;
            int n = -1;
            if (mLCursor.getCursorPos() <= 0 || (n = mLCursor.getCurrentChar()) == -1) continue;
            string = String.valueOf(mLCursor.getCharArray()[mLCursor.getCurrentChar()]);
            break;
        } while (this.prev());
        return string;
    }

    private boolean canDisposeBasedOnData(ICopyTo[] iCopyToArray) {
        lc.log(-2137614336, "MLCursorLL#canDisposeBasedOnData");
        return iCopyToArray == null || iCopyToArray.length < 1 || iCopyToArray[0] instanceof MLCursor && ((MLCursor)iCopyToArray[0]).getLength() < 1;
    }

    private boolean shouldMergeBasedOnData(ICopyTo[] iCopyToArray, ICopyTo[] iCopyToArray2) {
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#shouldMergeBasedOnData");
        boolean bl2 = bl = !this.canDisposeBasedOnData(iCopyToArray) && !this.canDisposeBasedOnData(iCopyToArray2);
        if (bl) {
            boolean bl3 = bl = iCopyToArray.length == 1 && iCopyToArray2.length == 1;
            if (!bl) {
                MLCursor mLCursor;
                int n;
                MLCursor mLCursor2 = (MLCursor)iCopyToArray[0];
                int n2 = MLUtils.getCharType(mLCursor2.getCharArray()[mLCursor2.getLength() - 1]);
                bl = n2 == (n = MLUtils.getCharType((mLCursor = (MLCursor)iCopyToArray2[0]).getCharArray()[0]));
            }
        }
        return bl;
    }

    private boolean canNodeBeDisposed(ListNode listNode) {
        lc.log(-2137614336, "MLCursorLL#canNodeBeDisposed");
        boolean bl = listNode != null;
        boolean bl2 = bl && listNode != this.m_list.head;
        boolean bl3 = bl2 && listNode != this.m_list.tail;
        boolean bl4 = bl3 && listNode.data instanceof ICopyTo[];
        boolean bl5 = bl4 && this.canDisposeBasedOnData(listNode.data);
        return bl5;
    }

    private boolean canNodeBeMerged(ListNode listNode) {
        lc.log(-2137614336, "MLCursorLL#canNodeBeMerged");
        boolean bl = listNode != null;
        boolean bl2 = bl && listNode != this.m_list.head;
        boolean bl3 = bl2 && listNode != this.m_list.tail;
        boolean bl4 = bl3 && listNode.data instanceof ICopyTo[];
        boolean bl5 = bl4 && !this.canDisposeBasedOnData(listNode.data);
        return bl5;
    }

    private MLCursor getMainWord(ICopyTo[] iCopyToArray) {
        lc.log(-2137614336, "MLCursorLL#getMainWord");
        return iCopyToArray == null || iCopyToArray.length == 0 || !(iCopyToArray[0] instanceof MLCursor) ? new MLCursor() : (MLCursor)iCopyToArray[0];
    }

    private MLCursor mergeLeftMLCursors(MLCursor mLCursor, MLCursor mLCursor2) {
        lc.log(-2137614336, "MLCursorLL#mergeLeftMLCursors");
        int n = MLCursorLL.clamp(0, mLCursor.getLength(), mLCursor.getCursorPos());
        int n2 = mLCursor2.getLength() + n;
        mLCursor2.setCursorPos(mLCursor2.getLength());
        mLCursor2.addWord(mLCursor.getString());
        mLCursor2.setCursorPos(n2);
        return mLCursor2;
    }

    private boolean mergeWithLeftNode(ListNode listNode) {
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#mergeWithLeftNode");
        boolean bl2 = bl = this.canNodeBeMerged(listNode) && this.canNodeBeMerged(listNode.left) && this.shouldMergeBasedOnData(listNode.left.data, listNode.data);
        if (bl) {
            MLCursor mLCursor = this.getMainWord(listNode.data);
            MLCursor mLCursor2 = this.getMainWord(listNode.left.data);
            MLCursor[] mLCursorArray = new MLCursor[]{this.mergeLeftMLCursors(mLCursor, mLCursor2)};
            listNode.left.data = mLCursorArray;
            this.m_list.removeLeft(listNode);
        }
        return bl;
    }

    private boolean mergeWithLeftNode() {
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#mergeWithLeftNode");
        ListNode listNode = this.m_list.current;
        boolean bl2 = bl = this.canNodeBeMerged(listNode) && this.canNodeBeMerged(listNode.left) && this.shouldMergeBasedOnData(listNode.left.data, listNode.data);
        if (bl) {
            MLCursor mLCursor = this.getMainWord(listNode.data);
            MLCursor mLCursor2 = this.getMainWord(listNode.left.data);
            MLCursor[] mLCursorArray = new MLCursor[]{this.mergeLeftMLCursors(mLCursor, mLCursor2)};
            listNode.left.data = mLCursorArray;
            this.m_list.removeCurrLeft();
        }
        return bl;
    }

    private MLCursor mergeRightMLCursors(MLCursor mLCursor, MLCursor mLCursor2) {
        lc.log(-2137614336, "MLCursorLL#mergeRightMLCursors");
        int n = MLCursorLL.clamp(0, mLCursor.getLength(), mLCursor.getCursorPos());
        mLCursor.setCursorPos(mLCursor.getLength());
        mLCursor.addWord(mLCursor2.getString());
        mLCursor.setCursorPos(n);
        return mLCursor;
    }

    private boolean mergeWithRightNode(ListNode listNode) {
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#mergeWithRightNode");
        boolean bl2 = bl = this.canNodeBeMerged(listNode) && this.canNodeBeMerged(listNode.right) && this.shouldMergeBasedOnData(listNode.data, listNode.right.data);
        if (bl) {
            MLCursor mLCursor = this.getMainWord(listNode.data);
            MLCursor mLCursor2 = this.getMainWord(listNode.right.data);
            MLCursor[] mLCursorArray = new MLCursor[]{this.mergeRightMLCursors(mLCursor, mLCursor2)};
            listNode.right.data = mLCursorArray;
            this.m_list.removeRight(listNode);
        }
        return bl;
    }

    private boolean mergeWithRightNode() {
        boolean bl;
        lc.log(-2137614336, "MLCursorLL#mergeWithRightNode");
        ListNode listNode = this.m_list.current;
        boolean bl2 = bl = this.canNodeBeMerged(listNode) && this.canNodeBeMerged(listNode.right) && this.shouldMergeBasedOnData(listNode.data, listNode.right.data);
        if (bl) {
            MLCursor mLCursor = this.getMainWord(listNode.data);
            MLCursor mLCursor2 = this.getMainWord(listNode.right.data);
            MLCursor[] mLCursorArray = new MLCursor[]{this.mergeRightMLCursors(mLCursor, mLCursor2)};
            listNode.right.data = mLCursorArray;
            this.m_list.removeCurrRight();
        }
        return bl;
    }

    private boolean mergeNodes(ListNode listNode) {
        lc.log(-2137614336, "MLCursorLL#mergeNodes");
        boolean bl = this.canNodeBeDisposed(listNode);
        if (bl) {
            this.m_list.removeLeft(listNode);
            MLCursor mLCursor = this.getCursor();
            if (mLCursor != null) {
                mLCursor.setCursorPos(mLCursor.getLength());
            }
        }
        boolean bl2 = bl ? true : this.mergeWithLeftNode(listNode);
        boolean bl3 = this.mergeWithRightNode(listNode);
        return bl2 || bl3;
    }

    private boolean mergeNodes() {
        lc.log(-2137614336, "MLCursorLL#mergeNodes");
        boolean bl = this.canNodeBeDisposed(this.m_list.current);
        if (bl) {
            this.m_list.removeCurrLeft();
            MLCursor mLCursor = this.getCursor();
            if (mLCursor != null) {
                mLCursor.setCursorPos(mLCursor.getLength());
            }
        }
        boolean bl2 = bl ? true : this.mergeWithLeftNode();
        boolean bl3 = this.mergeWithRightNode();
        return bl2 || bl3;
    }
}

