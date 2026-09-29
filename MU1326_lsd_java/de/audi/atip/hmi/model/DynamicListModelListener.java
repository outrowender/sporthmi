/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModelListener;
import de.audi.atip.hmi.model.ListRow;

public interface DynamicListModelListener
extends AbstractListModelListener {
    public static final int LIST_START;
    public static final int LIST_END;

    default public void runningOutOfData(int n, ListRow listRow, int n2, int n3) {
    }

    default public void itemReleased(int n, ListRow listRow, int n2) {
    }
}

