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

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600134, (short)53);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600134);
    }

    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600134, this.getMenuEntryVisibilityState(carViewOption));
    }

    public int getID() {
        return 36;
    }
}

