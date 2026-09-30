/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.AbstractListModelApp;

public interface DynamicListModelApp
extends AbstractListModelApp {
    public static final int NO_THRESHOLD = -1;

    public void setListListener(DynamicListModelListener var1);

    public void fill(ListRow[] var1, int var2);

    public void setThreshold(int var1, int var2);

    public void setSelected(ListRow var1);

    public boolean updateRow(ListRow var1);
}

