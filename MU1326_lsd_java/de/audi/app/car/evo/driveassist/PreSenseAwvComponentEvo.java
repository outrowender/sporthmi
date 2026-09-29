/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractPreSenseAwvComponent;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;

public class PreSenseAwvComponentEvo
extends AbstractPreSenseAwvComponent {
    public PreSenseAwvComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(AWVViewOptions aWVViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1456994048, this.getMenuEntryVisibilityState(aWVViewOptions.getSystem()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1440216832, this.getMenuEntryVisibilityState(aWVViewOptions.getWarning()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-349566720, this.getMenuEntryVisibilityState(aWVViewOptions.getWarningTimegap()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1456994048, (short)3);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1440216832, (short)3);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-349566720, (short)3);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1456994048);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1440216832);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-349566720);
    }

    @Override
    public int getID() {
        return 37;
    }
}

