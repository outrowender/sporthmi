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

    @Override
    protected void updateMenuEntryVisibility(LDWHCAViewOptions lDWHCAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1406662400, this.getMenuEntryVisibilityState(lDWHCAViewOptions.getHCAInterventionStyle()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1423439616, this.getMenuEntryVisibilityState(lDWHCAViewOptions.getHCAToleranceLevel()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1406662400, (short)4);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1423439616, (short)4);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1406662400);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1423439616);
    }

    @Override
    public int getID() {
        return 16;
    }
}

