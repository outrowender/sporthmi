/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface LayoutManagerSimulation
extends LayoutManager {
    public int[][] simulateLayout(int var1, int var2);

    public AbstractWidget[] getSimulationWidgets();
}

