/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractNVComponent;
import org.dsi.ifc.cardriverassistance.NVViewOptions;

public class NVComponentEvo
extends AbstractNVComponent {
    public NVComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(NVViewOptions nVViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600113, this.getMenuEntryVisibilityState(nVViewOptions.getContrast()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600113, (short)26);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600113);
    }

    public int getID() {
        return 13;
    }
}

