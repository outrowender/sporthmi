/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGrid$ExpandMode;

public interface IGridRow
extends Cloneable {
    default public int getGapBefore() {
    }

    default public void setGapBefore(int n) {
    }

    default public int getGapAfter() {
    }

    default public void setGapAfter(int n) {
    }

    default public IGrid.ExpandMode getHeightMode() {
    }

    default public void setHeightMode(IGrid.ExpandMode expandMode) {
    }

    default public Object clone() {
    }
}

