/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListRow;

public interface AbstractListModelListener {
    default public void itemFocused(int n, ListRow listRow, int n2, int n3) {
    }

    default public void itemSelected(int n, ListRow listRow, int n2) {
    }

    default public void rebuildListFromStart(int n, int n2) {
    }

    default public void rebuildListFromEnd(int n, int n2) {
    }

    default public void scrollingActive(int n, boolean bl, int n2) {
    }
}

