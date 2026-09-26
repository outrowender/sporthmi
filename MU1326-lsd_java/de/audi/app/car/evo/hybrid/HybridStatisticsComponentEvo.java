/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HybridStatisticsComponentEvo
extends AbstractHybridStatisticsComponent {
    public HybridStatisticsComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(15, CODING_ID[0]);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(16, CODING_ID[0]);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(14, CODING_ID[0]);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(15);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(16);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(14);
    }

    @Override
    public int getID() {
        return 44;
    }

    @Override
    protected void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(15, this.getMenuEntryVisibilityState(new CarViewOption[]{bCViewOptions.getStatisticsDistanceCurrentIntervallZE(), bCViewOptions.getStatisticsDistanceZE()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, this.getMenuEntryVisibilityState(new CarViewOption[]{bCViewOptions.getStatisticDistanceEUkm(), bCViewOptions.getStatisticDistanceEUmls()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, this.getMenuEntryVisibilityState(bCViewOptions.getStatisticsReset()));
    }

    @Override
    protected float getHistoryValue(int n) {
        switch (n) {
            case 0: {
                return 5699;
            }
            case 1: {
                return 31300;
            }
        }
        return 32959;
    }
}

