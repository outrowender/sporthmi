/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.CursoredLinkedList;
import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.audi.atip.hmi.model.texteditor.mlcursorll.IInsertBoundOps;
import de.audi.atip.hmi.model.texteditor.mlcursorll.MLCursorLL;
import de.audi.atip.hmi.modelaccess.ICopyTo;

public class InsertRightBoundOps
implements IInsertBoundOps {
    @Override
    public boolean checkLimitCharType(MLCursor mLCursor, char c2) {
        return mLCursor.getLength() == 0 || MLUtils.getCharType(mLCursor.getCharArray()[mLCursor.getLength() - 1]) == MLUtils.getCharType(c2);
    }

    @Override
    public ListNode boundNode(ListNode listNode) {
        return listNode.left;
    }

    @Override
    public void insertMove(CursoredLinkedList cursoredLinkedList, MLCursor mLCursor) {
        cursoredLinkedList.insertMoveCRight(new ICopyTo[]{mLCursor});
    }

    @Override
    public void insertMove(CursoredLinkedList cursoredLinkedList, String[] stringArray, int n) {
        ICopyTo[] iCopyToArray = MLUtils.stringArr2ICopyArr(stringArray, true, n);
        if (iCopyToArray != null) {
            cursoredLinkedList.insertMoveCRight(iCopyToArray);
        }
    }

    @Override
    public MLCursor move(CursoredLinkedList cursoredLinkedList, MLCursorLL mLCursorLL) {
        cursoredLinkedList.moveRight();
        MLCursor mLCursor = mLCursorLL.getCursor();
        if (mLCursor == null) {
            return null;
        }
        mLCursor.setCursorMode(mLCursorLL.getCursorMode());
        mLCursor.setCursorPos(0);
        return mLCursor;
    }

    @Override
    public boolean checkBoundCharType(MLCursor mLCursor, char c2) {
        return mLCursor.getLength() == 0 || MLUtils.getCharType(mLCursor.getCharArray()[0]) == MLUtils.getCharType(c2);
    }
}

