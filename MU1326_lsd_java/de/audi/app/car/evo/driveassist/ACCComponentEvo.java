/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractACCComponent;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;

public class ACCComponentEvo
extends AbstractACCComponent {
    public ACCComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600228, this.getMenuEntryVisibilityState(aCCViewOptions.getDrivingProgram()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600227, this.getMenuEntryVisibilityState(aCCViewOptions.getTimegap()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600774, this.getMenuEntryVisibilityState(aCCViewOptions.getCurveAssist()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600773, this.getMenuEntryVisibilityState(aCCViewOptions.getSpeedLimitOffset()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600243, this.getMenuEntryVisibilityState(aCCViewOptions.getTrafficJamAssist()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600778, this.getMenuEntryVisibilityState(aCCViewOptions.getDefaultMode()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600228, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600227, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600774, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600773, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600243, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600778, (short)0);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600228);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600227);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600774);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600773);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600243);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600778);
    }

    public int getID() {
        return 2;
    }
}

