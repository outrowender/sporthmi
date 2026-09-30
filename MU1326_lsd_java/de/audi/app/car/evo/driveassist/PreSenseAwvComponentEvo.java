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

    protected void updateMenuEntryVisibility(AWVViewOptions aWVViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600233, this.getMenuEntryVisibilityState(aWVViewOptions.getSystem()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600234, this.getMenuEntryVisibilityState(aWVViewOptions.getWarning()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600811, this.getMenuEntryVisibilityState(aWVViewOptions.getWarningTimegap()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600233, (short)3);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600234, (short)3);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600811, (short)3);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600233);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600234);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600811);
    }

    public int getID() {
        return 37;
    }
}

