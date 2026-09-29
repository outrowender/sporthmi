/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface BaseListModelListener {
    default public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    default public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    default public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    default public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

