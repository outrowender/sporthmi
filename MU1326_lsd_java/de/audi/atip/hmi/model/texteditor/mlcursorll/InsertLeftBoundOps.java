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

public class InsertLeftBoundOps
implements IInsertBoundOps {
    public boolean checkLimitCharType(MLCursor mLCursor, char c2) {
        return mLCursor.getLength() == 0 || MLUtils.getCharType(mLCursor.getCharArray()[0]) == MLUtils.getCharType(c2);
    }

    public ListNode boundNode(ListNode listNode) {
        return listNode.left;
    }

    public void insertMove(CursoredLinkedList cursoredLinkedList, MLCursor mLCursor) {
        cursoredLinkedList.insertMoveCLeft(new ICopyTo[]{mLCursor});
    }

    public void insertMove(CursoredLinkedList cursoredLinkedList, String[] stringArray, int n) {
        ICopyTo[] iCopyToArray = MLUtils.stringArr2ICopyArr(stringArray, true, n);
        if (iCopyToArray != null) {
            cursoredLinkedList.insertMoveCLeft(iCopyToArray);
        }
    }

    public MLCursor move(CursoredLinkedList cursoredLinkedList, MLCursorLL mLCursorLL) {
        cursoredLinkedList.moveLeft();
        MLCursor mLCursor = mLCursorLL.getCursor();
        if (mLCursor == null) {
            return null;
        }
        mLCursor.setCursorMode(mLCursorLL.getCursorMode());
        mLCursor.setCursorPos(mLCursor.getLength() - 1);
        return mLCursor;
    }

    public boolean checkBoundCharType(MLCursor mLCursor, char c2) {
        return mLCursor.getLength() == 0 || MLUtils.getCharType(mLCursor.getCharArray()[mLCursor.getLength() - 1]) == MLUtils.getCharType(c2);
    }
}

