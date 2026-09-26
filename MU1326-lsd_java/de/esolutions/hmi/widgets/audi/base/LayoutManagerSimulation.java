/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface LayoutManagerSimulation
extends LayoutManager {
    default public int[][] simulateLayout(int n, int n2) {
    }

    default public AbstractWidget[] getSimulationWidgets() {
    }
}

