/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractWiperComponent;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public class WiperComponentEvo
extends AbstractWiperComponent {
    public WiperComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600247, (short)12);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600242, (short)12);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600247);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600242);
    }

    protected void updateMenuEntryVisibility(WiperViewOptions wiperViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600247, this.getMenuEntryVisibilityState(wiperViewOptions.getWiperServicePosition()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600242, this.getMenuEntryVisibilityState(wiperViewOptions.getWiperRainSensorOnOff()));
    }

    public int getID() {
        return 12;
    }
}

