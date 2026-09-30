/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;

public interface TooltipDataProvider
extends DistanceDifferentiationRow {
    public int getIcon();

    public String getPOIName();

    public boolean isToRefine();

    public String getAdditionalInfo();
}

