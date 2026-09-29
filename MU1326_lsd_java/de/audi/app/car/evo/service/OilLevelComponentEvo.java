/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractOilLevelComponent;
import org.dsi.ifc.global.CarViewOption;

public class OilLevelComponentEvo
extends AbstractOilLevelComponent {
    private static final int MAX_OIL_DSI;
    private static final int MAX_OIL_HMI;

    public OilLevelComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1126697216, this.getMenuEntryVisibilityState(carViewOption));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1126697216, (short)18);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1126697216);
    }

    @Override
    public int getID() {
        return 6;
    }

    @Override
    protected int segments(int n) {
        int n2 = n == 8 ? 10 : super.segments(n);
        this.getLogChannel().log(1078071040, "segments(%1)->%2", (long)n, (long)n2);
        return n2;
    }
}

