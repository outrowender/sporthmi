/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.hybrid.AbstractTargetRangeComponent;
import org.dsi.ifc.carkombi.BCViewOptions;

public class TargetRangeComponentEvo
extends AbstractTargetRangeComponent {
    private int currentState = -1;

    public TargetRangeComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(16, (short)41);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(16);
    }

    protected void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
        if (bCViewOptions.getConfiguration() != null && bCViewOptions.getConfiguration().primaryEngineType == 3) {
            if (this.currentState == 1) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, this.getMenuEntryVisibilityState(bCViewOptions.currentRange1));
            }
        } else if (bCViewOptions.getConfiguration() != null && bCViewOptions.getConfiguration().secondaryEngineType == 3) {
            if (this.currentState == 1) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, this.getMenuEntryVisibilityState(bCViewOptions.currentRange2));
            }
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, 1);
        }
    }

    protected void updateVisibilityForRangeAtStateChange(int n) {
        this.currentState = n;
        if (n == 1) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, 0);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(16, 1);
        }
    }

    public int getID() {
        return 11;
    }
}

