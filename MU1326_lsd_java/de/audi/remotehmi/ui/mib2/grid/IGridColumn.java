/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGrid;

public interface IGridColumn
extends Cloneable {
    public String getTabId();

    public void setTabId(String var1);

    public int getTabIndex();

    public void setTabIndex(int var1);

    public int getGapBefore();

    public void setGapBefore(int var1);

    public int getGapAfter();

    public void setGapAfter(int var1);

    public IGrid.ExpandMode getWidthMode();

    public void setWidthMode(IGrid.ExpandMode var1);

    public Object clone() throws CloneNotSupportedException;
}

