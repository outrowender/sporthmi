/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.CursoredLinkedList;
import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.mlcursorll.MLCursorLL;

public interface IInsertBoundOps {
    public boolean checkLimitCharType(MLCursor var1, char var2);

    public ListNode boundNode(ListNode var1);

    public void insertMove(CursoredLinkedList var1, MLCursor var2);

    public void insertMove(CursoredLinkedList var1, String[] var2, int var3);

    public MLCursor move(CursoredLinkedList var1, MLCursorLL var2);

    public boolean checkBoundCharType(MLCursor var1, char var2);
}

