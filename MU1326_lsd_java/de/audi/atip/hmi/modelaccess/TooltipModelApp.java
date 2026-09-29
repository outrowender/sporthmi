/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TooltipListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface TooltipModelApp
extends HMIModelApp {
    default public void setListener(TooltipListener tooltipListener) {
    }

    default public void setData(ListRow[] listRowArray) {
    }

    default public void updateData(int n, int n2, ListCell listCell) {
    }

    default public void clear() {
    }

    default public void setMaxColumns(int n) {
    }

    default public void setMaxRows(int n) {
    }
}

