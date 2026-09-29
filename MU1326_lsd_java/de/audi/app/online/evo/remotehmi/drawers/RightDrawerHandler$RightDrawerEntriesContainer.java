/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.remotehmi.ui.mib2.grid.IGridList;

final class RightDrawerHandler$RightDrawerEntriesContainer {
    public IGridList gridList;
    public boolean wasUpdated = false;

    public RightDrawerHandler$RightDrawerEntriesContainer(IGridList iGridList, boolean bl) {
        this.gridList = iGridList;
        this.wasUpdated = bl;
    }
}

