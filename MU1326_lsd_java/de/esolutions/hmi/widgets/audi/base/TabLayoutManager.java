/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface TabLayoutManager
extends LayoutManager {
    public int calculateTabulator(AbstractWidget var1, int var2);

    public boolean setTabulator(int var1, int var2);

    public int[] getTabulatorIDs();
}

