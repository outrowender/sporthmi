/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.kombi;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.kombi.AbstractSIAComponent;
import org.dsi.ifc.carkombi.SIAViewOptions;

public class SIAComponentEvo
extends AbstractSIAComponent {
    public SIAComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600476, (short)13);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(402, (short)13);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(403, (short)13);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600476);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(402);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(403);
    }

    protected void updateMenuEntryVisibility(SIAViewOptions sIAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600476, this.getMenuEntryVisibilityState(sIAViewOptions.getReset()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(402, this.getMenuEntryVisibilityState(sIAViewOptions.getOilInspection()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(403, this.getMenuEntryVisibilityState(sIAViewOptions.getServiceData()));
    }

    public int getID() {
        return 10;
    }
}

