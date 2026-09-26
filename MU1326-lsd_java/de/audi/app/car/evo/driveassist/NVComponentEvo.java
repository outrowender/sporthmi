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

    @Override
    protected void updateMenuEntryVisibility(NVViewOptions nVViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(824707328, this.getMenuEntryVisibilityState(nVViewOptions.getContrast()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(824707328, (short)26);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(824707328);
    }

    @Override
    public int getID() {
        return 13;
    }
}

