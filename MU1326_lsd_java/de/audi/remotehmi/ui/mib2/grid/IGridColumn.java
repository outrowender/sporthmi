/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGrid$ExpandMode;

public interface IGridColumn
extends Cloneable {
    default public String getTabId() {
    }

    default public void setTabId(String string) {
    }

    default public int getTabIndex() {
    }

    default public void setTabIndex(int n) {
    }

    default public int getGapBefore() {
    }

    default public void setGapBefore(int n) {
    }

    default public int getGapAfter() {
    }

    default public void setGapAfter(int n) {
    }

    default public IGrid$ExpandMode getWidthMode() {
    }

    default public void setWidthMode(IGrid$ExpandMode iGrid$ExpandMode) {
    }

    default public Object clone() {
    }
}

