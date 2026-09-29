/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModelListener;
import de.audi.atip.hmi.model.ListRow;

public interface SlidingListModelListener
extends AbstractListModelListener {
    default public void requestRowsAfter(int n, ListRow listRow, int n2, int n3) {
    }

    default public void requestRowsBefore(int n, ListRow listRow, int n2, int n3) {
    }
}

