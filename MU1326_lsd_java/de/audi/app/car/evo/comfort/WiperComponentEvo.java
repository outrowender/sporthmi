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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1222113024, (short)12);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1305999104, (short)12);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1222113024);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1305999104);
    }

    @Override
    protected void updateMenuEntryVisibility(WiperViewOptions wiperViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1222113024, this.getMenuEntryVisibilityState(wiperViewOptions.getWiperServicePosition()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1305999104, this.getMenuEntryVisibilityState(wiperViewOptions.getWiperRainSensorOnOff()));
    }

    @Override
    public int getID() {
        return 12;
    }
}

