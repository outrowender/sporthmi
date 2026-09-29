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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(858261760, (short)0);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(858261760);
    }

    @Override
    protected void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(858261760, this.getMenuEntryVisibilityState(aCCViewOptions.getDistanceWarning()));
    }

    @Override
    public int getID() {
        return 35;
    }
}

