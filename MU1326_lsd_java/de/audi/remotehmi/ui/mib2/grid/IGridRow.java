/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGrid;

public interface IGridRow
extends Cloneable {
    public int getGapBefore();

    public void setGapBefore(int var1);

    public int getGapAfter();

    public void setGapAfter(int var1);

    public IGrid.ExpandMode getHeightMode();

    public void setHeightMode(IGrid.ExpandMode var1);

    public Object clone() throws CloneNotSupportedException;
}

