/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisActualSizes;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisPreferredSizes;

public class AbstractGridLayout$LayoutData {
    public int state;
    public int widthHint = -1;
    public AbstractGridLayout$AxisPreferredSizes columnsPref;
    public AbstractGridLayout$AxisPreferredSizes rowsPref;
    public AbstractGridLayout$AxisActualSizes columnsActual;
    public AbstractGridLayout$AxisActualSizes rowsActual;

    public AbstractGridLayout$LayoutData(int n, int n2) {
        this.state = n;
        this.widthHint = n2;
    }

    public boolean hasPreferredSizes() {
        return this.columnsPref != null && this.rowsPref != null;
    }

    public boolean hasActualSizes() {
        return this.columnsActual != null && this.rowsActual != null;
    }
}

