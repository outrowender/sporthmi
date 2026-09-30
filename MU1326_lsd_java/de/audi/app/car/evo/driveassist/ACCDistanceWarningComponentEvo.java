/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractACCDistanceWarningComponent;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;

public class ACCDistanceWarningComponentEvo
extends AbstractACCDistanceWarningComponent {
    public ACCDistanceWarningComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600115, (short)0);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600115);
    }

    protected void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600115, this.getMenuEntryVisibilityState(aCCViewOptions.getDistanceWarning()));
    }

    public int getID() {
        return 35;
    }
}

