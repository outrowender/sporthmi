/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractMKEComponent;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;

public class MKEComponentEvo
extends AbstractMKEComponent {
    public MKEComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(MKEViewOptions mKEViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600241, this.getMenuEntryVisibilityState(mKEViewOptions.getSystemOnOff()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600241, (short)35);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600241);
    }

    public int getID() {
        return 14;
    }
}

