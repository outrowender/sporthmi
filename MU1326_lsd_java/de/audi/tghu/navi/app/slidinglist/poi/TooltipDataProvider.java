/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;

public interface TooltipDataProvider
extends DistanceDifferentiationRow {
    default public int getIcon() {
    }

    default public String getPOIName() {
    }

    default public boolean isToRefine() {
    }

    default public String getAdditionalInfo() {
    }
}

