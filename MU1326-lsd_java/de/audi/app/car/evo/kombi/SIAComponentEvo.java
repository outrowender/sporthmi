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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1675032320, (short)13);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(402, (short)13);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(403, (short)13);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1675032320);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(402);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(403);
    }

    @Override
    protected void updateMenuEntryVisibility(SIAViewOptions sIAViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1675032320, this.getMenuEntryVisibilityState(sIAViewOptions.getReset()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(402, this.getMenuEntryVisibilityState(sIAViewOptions.getOilInspection()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(403, this.getMenuEntryVisibilityState(sIAViewOptions.getServiceData()));
    }

    @Override
    public int getID() {
        return 10;
    }
}

