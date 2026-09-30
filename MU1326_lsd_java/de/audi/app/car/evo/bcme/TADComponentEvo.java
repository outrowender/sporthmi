/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.bcme.AbstractTADComponent;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public class TADComponentEvo
extends AbstractTADComponent {
    public TADComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(327, (short)40);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(328, (short)40);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(327);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(328);
    }

    protected void updateMenuEntryVisibility(TADViewOptions tADViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(327, this.getTADAngleVisibilityState(tADViewOptions.getConfiguration(), 327));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(328, this.getTADAngleVisibilityState(tADViewOptions.getConfiguration(), 328));
    }

    private int getTADAngleVisibilityState(TADConfiguration tADConfiguration, int n) {
        if (tADConfiguration != null) {
            if (n == 327 && tADConfiguration.isRollAngleInstallation()) {
                return 0;
            }
            if (n == 328 && tADConfiguration.isPitchAngleInstallation()) {
                return 0;
            }
        }
        return 1;
    }

    protected void updateRoofLoad(boolean bl) {
        this.getChoiceModel(601059).setValue(bl ? 1 : 0);
    }

    public int getID() {
        return 40;
    }
}

