/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IPorscheGridCell;

public interface IPorscheGridCellAction
extends IGridCellAction {
    default public boolean modify(IPorscheGridCell iPorscheGridCell) {
    }
}

