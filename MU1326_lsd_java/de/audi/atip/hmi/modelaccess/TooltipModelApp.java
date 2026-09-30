/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TooltipListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface TooltipModelApp
extends HMIModelApp {
    public void setListener(TooltipListener var1);

    public void setData(ListRow[] var1);

    public void updateData(int var1, int var2, ListCell var3);

    public void clear();

    public void setMaxColumns(int var1);

    public void setMaxRows(int var1);
}

