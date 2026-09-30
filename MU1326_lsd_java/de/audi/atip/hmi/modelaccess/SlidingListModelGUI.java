/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface SlidingListModelGUI
extends ListModelGUI {
    public static final byte CONTEXT_PREVIOUS = -1;
    public static final byte CONTEXT_CURRENT = 0;
    public static final byte CONTEXT_NEXT = 1;

    public boolean isEndOfList(int var1) throws IllegalArgumentException;

    public int getRowsAvailable(int var1) throws IllegalArgumentException;

    public void setVisibleRows(int var1);

    public void moveContext(int var1) throws IllegalArgumentException;

    public boolean isCursorPositionReset();

    public boolean isJumpingToStartOfListSupported();

    public void jumpToStartOfList(int var1);

    public void jumpToEndOfList(int var1);

    public boolean isJumpingToEndOfListSupported();

    public int getFocusedCursorPosition();

    public int getFocusedCursorPositionOffset();

    public void setFocusOffset(int var1);

    public void setFirstScreenOffset(int var1);

    public boolean isFastScrollingEnabled();

    public void scrollingActive(boolean var1, int var2);

    public boolean getRowFromPreviousContext(int var1, ListCell[] var2);

    public boolean getRowFromNextContext(int var1, ListCell[] var2);

    public int getListLength();

    public int getLineNumber();
}

