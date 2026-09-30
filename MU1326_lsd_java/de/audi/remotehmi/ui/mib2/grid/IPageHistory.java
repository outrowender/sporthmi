/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGridList;

public interface IPageHistory {
    public void setExpansionState(String var1, int var2, boolean var3);

    public boolean isExpanded(String var1, int var2, boolean var3);

    public void restoreToGrid(IGridList var1);
}

