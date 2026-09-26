/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGridList;

public interface IPageHistory {
    default public void setExpansionState(String string, int n, boolean bl) {
    }

    default public boolean isExpanded(String string, int n, boolean bl) {
    }

    default public void restoreToGrid(IGridList iGridList) {
    }
}

