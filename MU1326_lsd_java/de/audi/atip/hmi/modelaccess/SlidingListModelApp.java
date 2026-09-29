/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.SlidingListModelListener;
import de.audi.atip.hmi.modelaccess.AbstractListModelApp;

public interface SlidingListModelApp
extends AbstractListModelApp {
    public static final byte VISIBLE_CONTEXT_START_OF_BUFFER;
    public static final byte VISIBLE_CONTEXT_END_OF_BUFFER;

    default public void setListListener(SlidingListModelListener slidingListModelListener) {
    }

    default public void setBufferSize(int n) {
    }

    default public void appendAtEnd(ListRow[] listRowArray, boolean bl) {
    }

    default public void appendAtStart(ListRow[] listRowArray, boolean bl) {
    }

    default public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, int n2) {
    }

    default public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, byte by, int n2) {
    }

    default public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, byte by, int n2, ListRow listRow, int n3) {
    }

    default public void setListEnd(boolean bl, boolean bl2) {
    }

    default public void setListEnd2(boolean bl, boolean bl2) {
    }

    default public void remove(ListRow listRow) {
    }

    default public void updateRows(ListRow[] listRowArray) {
    }

    default public void resetCursorPosition(boolean bl) {
    }
}

