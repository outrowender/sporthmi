/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.IMLDimensions;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MLDisplayData;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MultilineString$ArrList;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.SChar;

public class MultilineString {
    public static final int DEFAULT_NEW_LINE_WIDTH;
    public static final int REFLOW_AHEAD_NO_LINES;
    private DoubleCursor m_cursor;
    private MultilineTextFieldController ctrl;

    public MultilineString(DoubleCursor doubleCursor) {
        this.m_cursor = doubleCursor;
    }

    public DoubleCursor getCursor() {
        return this.m_cursor;
    }

    public MLDisplayData getDisplayDataFull(IMLDimensions iMLDimensions) {
        MLDisplayData mLDisplayData = null;
        do {
            mLDisplayData = this.reflow(mLDisplayData, iMLDimensions, this.m_cursor);
        } while (mLDisplayData.currentFlowState != 2);
        return mLDisplayData;
    }

    public MLDisplayData getDisplayDataPartial(IMLDimensions iMLDimensions, MLDisplayData mLDisplayData) {
        MLDisplayData mLDisplayData2 = mLDisplayData;
        this.ctrl = (MultilineTextFieldController)iMLDimensions;
        int n = mLDisplayData2.cursor.currentWordIdx()[1];
        boolean bl = n != -1;
        boolean bl2 = false;
        int n2 = this.ctrl.targetAnim.viewPort.vpLastVisibleLine;
        int n3 = 0;
        int n4 = 3 + Math.max(Math.max(n3, n2), 0);
        do {
            mLDisplayData2 = this.reflow(mLDisplayData2, iMLDimensions, this.m_cursor);
            boolean bl3 = bl2 = bl && (mLDisplayData2.charMetaData.size() <= n || ((SChar)mLDisplayData2.charMetaData.get((int)n)).line == -1);
            if (bl2 || !bl) continue;
            n3 = ((SChar)mLDisplayData2.charMetaData.get((int)n)).line;
            n4 = 3 + Math.max(Math.max(n3, n2), 0);
        } while ((bl2 || mLDisplayData2.sCharLines.size() <= n4) && mLDisplayData2.currentFlowState != 2);
        return mLDisplayData2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MLDisplayData invalidateReflowData(MLDisplayData mLDisplayData, int n) {
        MLDisplayData mLDisplayData2 = mLDisplayData;
        try {
            if (mLDisplayData2 != null && mLDisplayData2.cursor != null) {
                if (mLDisplayData2.cursor.mtxAquireLock()) {
                    if (mLDisplayData2.ghostCursor != null) {
                        mLDisplayData2.ghostCursor.resetToWordType();
                    }
                    mLDisplayData2.cursorPosition = 0;
                    int n2 = mLDisplayData2.cursor.getCursorPos();
                    mLDisplayData2.cursor.lockLL(true);
                    mLDisplayData2.cursor.setCursorPos(n);
                    int[] nArray = mLDisplayData2.cursor.prevWord();
                    int[] nArray2 = mLDisplayData2.cursor.nextWord();
                    int[] nArray3 = mLDisplayData2.cursor.currentWordIdx();
                    if (nArray2[1] == -1) {
                        nArray2 = nArray3;
                    }
                    if (nArray2[1] != -1) {
                        mLDisplayData2.currentLineIdx = 0;
                        mLDisplayData2.lineStartIdx = 0;
                        mLDisplayData2.cursorPosition = mLDisplayData2.cursor.getCursorPos();
                        mLDisplayData2.processedChars = 0;
                        mLDisplayData2.currentFlowState = 3;
                        mLDisplayData2.word = new short[]{(short)nArray2[0], (short)nArray2[1]};
                        mLDisplayData2.wordWidth = -1;
                        if (nArray[1] != -1) {
                            SChar sChar = (SChar)mLDisplayData2.charMetaData.get(nArray[1]);
                            boolean bl = MLUtils.getCharType(mLDisplayData2.cursor.getCharArray()[sChar.idx]) == 3;
                            mLDisplayData2.currentLineIdx = sChar.line + (bl ? (short)1 : 0);
                            mLDisplayData2.lineStartIdx = (short)(!bl ? ((short[])mLDisplayData2.sCharLines.get(sChar.line))[0] : ((short[])mLDisplayData2.sCharLines.get(sChar.line))[1] + 1);
                            if (!bl) {
                                int n3 = 0;
                                short s = sChar.idx;
                                for (int i2 = mLDisplayData2.lineStartIdx; i2 <= s; ++i2) {
                                    n3 += ((SChar)mLDisplayData2.charMetaData.get((int)i2)).w;
                                }
                                mLDisplayData2.lineWidth = n3;
                            } else {
                                mLDisplayData2.lineWidth = 0;
                            }
                            mLDisplayData2.sCharLines.removeRange(sChar.line + (bl ? (short)1 : 0), mLDisplayData2.sCharLines.size());
                            mLDisplayData2.charMetaData.removeRange(nArray2[0], mLDisplayData2.charMetaData.size());
                            mLDisplayData2.cursorPosition = nArray2[0] + 1;
                        } else {
                            mLDisplayData2.currentFlowState = 1;
                        }
                    } else {
                        mLDisplayData2.currentFlowState = 1;
                    }
                    mLDisplayData2.cursor.setCursorPos(n2);
                    mLDisplayData2.cursor.lockLL(false);
                } else {
                    IWidgetLogChannel.logMessagingMultiline.log(10000, "MultilineString#invalidateReflowData: failed to acquire lock");
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (mLDisplayData2 != null && mLDisplayData2.cursor != null) {
                mLDisplayData2.cursor.mtxReleaseLock();
            }
        }
        return mLDisplayData2;
    }

    private int prepCharData(MLDisplayData mLDisplayData) {
        int n = 0;
        IMLDimensions iMLDimensions = mLDisplayData.dims;
        char[] cArray = mLDisplayData.cursor.getCharArray();
        short[] sArray = mLDisplayData.word;
        short s = mLDisplayData.lowBound = sArray[0];
        short s2 = sArray[1];
        for (short s3 = s; s3 <= s2; s3 = (short)(s3 + 1)) {
            short s4 = (short)iMLDimensions.charWidth(cArray[s3]);
            n += s4;
            mLDisplayData.charMetaData.add(new SChar(s4, sArray, s3));
        }
        mLDisplayData.wordWidth = n;
        return n;
    }

    private void reflowNewLine(MLDisplayData mLDisplayData) {
        mLDisplayData.currentFlowState = 4;
        short s = mLDisplayData.lowBound;
        short s2 = mLDisplayData.word[1];
        short s3 = s;
        while (s3 <= s2) {
            int n = mLDisplayData.cursor.length() - 1;
            if (mLDisplayData.processedChars >= mLDisplayData.maxProcessedChars) break;
            mLDisplayData.sCharLines.add(new short[]{mLDisplayData.lineStartIdx, s3});
            SChar sChar = (SChar)mLDisplayData.charMetaData.get(s3);
            sChar.x = (short)mLDisplayData.lineWidth;
            sChar.line = (short)mLDisplayData.currentLineIdx;
            sChar.w = (short)8;
            sChar.appendType(1);
            if (mLDisplayData.lineStartIdx == s3) {
                sChar.appendType(2);
            }
            if (s3 == n) {
                sChar.appendType(4);
            }
            mLDisplayData.lineStartIdx = (short)(s3 + 1);
            ++mLDisplayData.currentLineIdx;
            mLDisplayData.lineWidth = 0;
            s3 = (short)(s3 + 1);
            ++mLDisplayData.processedChars;
            mLDisplayData.lowBound = (short)(mLDisplayData.lowBound + 1);
        }
        if (mLDisplayData.lowBound > s2) {
            mLDisplayData.currentFlowState = 3;
        }
    }

    private void reflowSoftBreak(MLDisplayData mLDisplayData) {
        short[] sArray = mLDisplayData.word;
        int n = mLDisplayData.wordWidth;
        int n2 = mLDisplayData.lowBound;
        short s = sArray[1];
        if (mLDisplayData.currentFlowState != 5 && n + mLDisplayData.lineWidth > mLDisplayData.maxLineWidth) {
            ++mLDisplayData.currentLineIdx;
            mLDisplayData.lineWidth = 0;
            mLDisplayData.sCharLines.add(new short[]{mLDisplayData.lineStartIdx, (short)(n2 - 1)});
            mLDisplayData.lineStartIdx = n2;
        }
        mLDisplayData.currentFlowState = 5;
        int n3 = mLDisplayData.cursor.length() - 1;
        int n4 = n2;
        while (n4 <= s && mLDisplayData.processedChars < mLDisplayData.maxProcessedChars) {
            SChar sChar = (SChar)mLDisplayData.charMetaData.get(n4);
            sChar.x = (short)mLDisplayData.lineWidth;
            mLDisplayData.lineWidth += sChar.w;
            sChar.line = (short)mLDisplayData.currentLineIdx;
            if (mLDisplayData.lineStartIdx == n4) {
                sChar.appendType(2);
            }
            if (n4 == n3) {
                sChar.appendType(4);
            }
            ++n4;
            ++mLDisplayData.processedChars;
            mLDisplayData.lowBound = (short)(mLDisplayData.lowBound + 1);
        }
        if (mLDisplayData.lowBound > s) {
            mLDisplayData.currentFlowState = 3;
        }
    }

    private void reflowHardBreak(MLDisplayData mLDisplayData) {
        mLDisplayData.currentFlowState = 6;
        MultilineString$ArrList multilineString$ArrList = mLDisplayData.sCharLines;
        short s = mLDisplayData.word[0];
        short s2 = mLDisplayData.word[1];
        int n = mLDisplayData.cursor.length() - 1;
        short s3 = mLDisplayData.lowBound;
        while (s3 <= s2 && mLDisplayData.processedChars < mLDisplayData.maxProcessedChars) {
            SChar sChar = (SChar)mLDisplayData.charMetaData.get(s3);
            if (sChar.w + mLDisplayData.lineWidth > mLDisplayData.maxLineWidth) {
                ++mLDisplayData.currentLineIdx;
                mLDisplayData.lineWidth = 0;
                multilineString$ArrList.add(new short[]{mLDisplayData.lineStartIdx, (short)(s3 - 1)});
                mLDisplayData.lineStartIdx = s3;
            }
            sChar.x = (short)mLDisplayData.lineWidth;
            mLDisplayData.lineWidth += sChar.w;
            sChar.line = (short)mLDisplayData.currentLineIdx;
            if (s3 == s && mLDisplayData.lineStartIdx == s3) {
                sChar.appendType(2);
            }
            if (s3 == n) {
                sChar.appendType(4);
            }
            s3 = (short)(s3 + 1);
            ++mLDisplayData.processedChars;
            mLDisplayData.lowBound = (short)(mLDisplayData.lowBound + 1);
        }
        if (mLDisplayData.lowBound > s2) {
            mLDisplayData.currentFlowState = 3;
        }
    }

    private void reflowStateMachine(MLDisplayData mLDisplayData) {
        switch (mLDisplayData.currentFlowState) {
            case 3: {
                mLDisplayData.cursor.setCursorPos(mLDisplayData.cursorPosition);
                mLDisplayData.word = new short[]{(short)mLDisplayData.cursor.currentWordIdx()[0], (short)mLDisplayData.cursor.currentWordIdx()[1]};
                if (mLDisplayData.word[0] != -1) {
                    int n = this.prepCharData(mLDisplayData);
                    if (MLUtils.getCharType(mLDisplayData.cursor.getCharArray()[mLDisplayData.word[0]]) == 3) {
                        this.reflowNewLine(mLDisplayData);
                        break;
                    }
                    if (n < mLDisplayData.maxLineWidth) {
                        this.reflowSoftBreak(mLDisplayData);
                        break;
                    }
                    this.reflowHardBreak(mLDisplayData);
                    break;
                }
                mLDisplayData.currentFlowState = 2;
                break;
            }
            case 4: {
                this.reflowNewLine(mLDisplayData);
                break;
            }
            case 5: {
                this.reflowSoftBreak(mLDisplayData);
                break;
            }
            case 6: {
                this.reflowHardBreak(mLDisplayData);
                break;
            }
        }
        if (mLDisplayData.currentFlowState == 3) {
            mLDisplayData.cursor.setCursorPos(mLDisplayData.cursorPosition);
            int[] nArray = mLDisplayData.cursor.nextWord();
            mLDisplayData.cursorPosition = mLDisplayData.cursor.getCursorPos();
            if (nArray[0] == -1) {
                mLDisplayData.currentFlowState = 2;
            }
        }
        if (mLDisplayData.currentFlowState == 2 && mLDisplayData.lineWidth > 0 && mLDisplayData.lineStartIdx < mLDisplayData.cursor.length()) {
            mLDisplayData.sCharLines.add(new short[]{mLDisplayData.lineStartIdx, (short)(mLDisplayData.cursor.length() - 1)});
        }
    }

    private MLDisplayData reflow(MLDisplayData mLDisplayData, IMLDimensions iMLDimensions, DoubleCursor doubleCursor) {
        MLDisplayData mLDisplayData2 = mLDisplayData;
        if (mLDisplayData2 == null && iMLDimensions != null && doubleCursor != null) {
            mLDisplayData2 = new MLDisplayData();
        }
        if (mLDisplayData2 != null) {
            mLDisplayData2.setNeedsRendering(true);
            int n = doubleCursor.getCursorPos();
            boolean bl = mLDisplayData2.ghostCursor != null && mLDisplayData2.ghostCursor.getCurrentWordType() == 2;
            doubleCursor.lockLL(true);
            block3: while (mLDisplayData2.processedChars < mLDisplayData2.maxProcessedChars && mLDisplayData2.currentFlowState != 2) {
                switch (mLDisplayData2.currentFlowState) {
                    case 1: {
                        mLDisplayData2.initInput(doubleCursor, iMLDimensions, 100);
                        mLDisplayData2.initStateDependentVars();
                        mLDisplayData2.initOutput();
                        mLDisplayData2.currentFlowState = 3;
                        continue block3;
                    }
                }
                this.reflowStateMachine(mLDisplayData2);
            }
            mLDisplayData2.processedChars = 0;
            doubleCursor.setCursorPos(n);
            if (bl) {
                mLDisplayData2.ghostCursor.resetToWordType();
            }
            doubleCursor.lockLL(false);
        }
        return mLDisplayData2;
    }
}

