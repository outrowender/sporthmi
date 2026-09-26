/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface SlidingListModelGUI
extends ListModelGUI {
    public static final byte CONTEXT_PREVIOUS;
    public static final byte CONTEXT_CURRENT;
    public static final byte CONTEXT_NEXT;

    default public boolean isEndOfList(int n) {
    }

    default public int getRowsAvailable(int n) {
    }

    default public void setVisibleRows(int n) {
    }

    default public void moveContext(int n) {
    }

    default public boolean isCursorPositionReset() {
    }

    default public boolean isJumpingToStartOfListSupported() {
    }

    default public void jumpToStartOfList(int n) {
    }

    default public void jumpToEndOfList(int n) {
    }

    default public boolean isJumpingToEndOfListSupported() {
    }

    default public int getFocusedCursorPosition() {
    }

    default public int getFocusedCursorPositionOffset() {
    }

    default public void setFocusOffset(int n) {
    }

    default public void setFirstScreenOffset(int n) {
    }

    default public boolean isFastScrollingEnabled() {
    }

    default public void scrollingActive(boolean bl, int n) {
    }

    default public boolean getRowFromPreviousContext(int n, ListCell[] listCellArray) {
    }

    default public boolean getRowFromNextContext(int n, ListCell[] listCellArray) {
    }

    default public int getListLength() {
    }

    default public int getLineNumber() {
    }
}

