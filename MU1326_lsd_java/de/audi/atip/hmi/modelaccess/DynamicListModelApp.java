/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.AbstractListModelApp;

public interface DynamicListModelApp
extends AbstractListModelApp {
    public static final int NO_THRESHOLD;

    default public void setListListener(DynamicListModelListener dynamicListModelListener) {
    }

    default public void fill(ListRow[] listRowArray, int n) {
    }

    default public void setThreshold(int n, int n2) {
    }

    default public void setSelected(ListRow listRow) {
    }

    default public boolean updateRow(ListRow listRow) {
    }
}

