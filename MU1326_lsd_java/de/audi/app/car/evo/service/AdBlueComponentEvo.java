/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractAdBlueComponent;
import org.dsi.ifc.global.CarViewOption;

public class AdBlueComponentEvo
extends AbstractAdBlueComponent {
    public AdBlueComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1177028864, (short)53);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1177028864);
    }

    @Override
    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1177028864, this.getMenuEntryVisibilityState(carViewOption));
    }

    @Override
    public int getID() {
        return 36;
    }
}

