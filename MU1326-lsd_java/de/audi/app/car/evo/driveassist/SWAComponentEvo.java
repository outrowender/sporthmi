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

    @Override
    protected void updateMenuEntryVisibility(SWAViewOptions sWAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(841484544, this.getMenuEntryVisibilityState(sWAViewOptions.getBrightness()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(841484544, (short)5);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(841484544);
    }

    @Override
    public int getID() {
        return 4;
    }
}

