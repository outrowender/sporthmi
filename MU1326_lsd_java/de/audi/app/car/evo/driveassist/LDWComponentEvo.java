/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractLDWComponent;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;

public class LDWComponentEvo
extends AbstractLDWComponent {
    public LDWComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(LDWHCAViewOptions lDWHCAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600236, this.getMenuEntryVisibilityState(lDWHCAViewOptions.getHCAInterventionStyle()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600235, this.getMenuEntryVisibilityState(lDWHCAViewOptions.getHCAToleranceLevel()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600236, (short)4);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600235, (short)4);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600236);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600235);
    }

    public int getID() {
        return 16;
    }
}

