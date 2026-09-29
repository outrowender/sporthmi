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

    @Override
    protected void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1540880128, this.getMenuEntryVisibilityState(aCCViewOptions.getDrivingProgram()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1557657344, this.getMenuEntryVisibilityState(aCCViewOptions.getTimegap()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-970323712, this.getMenuEntryVisibilityState(aCCViewOptions.getCurveAssist()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-987100928, this.getMenuEntryVisibilityState(aCCViewOptions.getSpeedLimitOffset()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1289221888, this.getMenuEntryVisibilityState(aCCViewOptions.getTrafficJamAssist()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-903214848, this.getMenuEntryVisibilityState(aCCViewOptions.getDefaultMode()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1540880128, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1557657344, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-970323712, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-987100928, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1289221888, (short)0);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-903214848, (short)0);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1540880128);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1557657344);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-970323712);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-987100928);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1289221888);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-903214848);
    }

    @Override
    public int getID() {
        return 2;
    }
}

