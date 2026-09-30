/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractSWAComponent;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;

public class SWAComponentEvo
extends AbstractSWAComponent {
    public SWAComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(SWAViewOptions sWAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600114, this.getMenuEntryVisibilityState(sWAViewOptions.getBrightness()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600114, (short)5);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600114);
    }

    public int getID() {
        return 4;
    }
}

