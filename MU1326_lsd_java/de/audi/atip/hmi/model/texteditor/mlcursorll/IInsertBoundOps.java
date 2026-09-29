/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.CursoredLinkedList;
import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.mlcursorll.MLCursorLL;

public interface IInsertBoundOps {
    default public boolean checkLimitCharType(MLCursor mLCursor, char c2) {
    }

    default public ListNode boundNode(ListNode listNode) {
    }

    default public void insertMove(CursoredLinkedList cursoredLinkedList, MLCursor mLCursor) {
    }

    default public void insertMove(CursoredLinkedList cursoredLinkedList, String[] stringArray, int n) {
    }

    default public MLCursor move(CursoredLinkedList cursoredLinkedList, MLCursorLL mLCursorLL) {
    }

    default public boolean checkBoundCharType(MLCursor mLCursor, char c2) {
    }
}

