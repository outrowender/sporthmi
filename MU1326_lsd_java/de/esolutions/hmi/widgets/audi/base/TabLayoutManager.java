/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface TabLayoutManager
extends LayoutManager {
    default public int calculateTabulator(AbstractWidget abstractWidget, int n) {
    }

    default public boolean setTabulator(int n, int n2) {
    }

    default public int[] getTabulatorIDs() {
    }
}

