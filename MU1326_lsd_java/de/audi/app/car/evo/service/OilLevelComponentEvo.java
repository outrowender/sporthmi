/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractOilLevelComponent;
import org.dsi.ifc.global.CarViewOption;

public class OilLevelComponentEvo
extends AbstractOilLevelComponent {
    private static final int MAX_OIL_DSI = 8;
    private static final int MAX_OIL_HMI = 10;

    public OilLevelComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600131, this.getMenuEntryVisibilityState(carViewOption));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600131, (short)18);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600131);
    }

    public int getID() {
        return 6;
    }

    protected int segments(int n) {
        int n2 = n == 8 ? 10 : super.segments(n);
        this.getLogChannel().log(1000000, "segments(%1)->%2", (long)n, (long)n2);
        return n2;
    }
}

