/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.aircondition;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.app.car.core.aircondition.AirconConfig;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;

public class AirconComponentEvo
extends AbstractAirconComponent {
    private final AirconConfig config = new AirconConfig();

    public AirconComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public int getID() {
        return 31;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600168, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600714, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600715, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600805, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600806, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600169, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600170, (short)8);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600168);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600714);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600715);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600805);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600806);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600169);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600170);
    }

    protected void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600168, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconAirCirculationAuto()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600169, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconHeater()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600170, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconSolar()));
        if (this.currentViewOptionsRow1 != null) {
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
        }
    }

    protected void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
        if (n == 1 && this.currentViewOptionsMaster != null && this.currentViewOptionsMaster.getConfiguration() != null) {
            if (!this.currentViewOptionsMaster.getConfiguration().isCarDriverSide()) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600714, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneLeftViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600715, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneRightViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600805, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600806, 1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600805, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneRightViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600806, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneLeftViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600714, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600715, 1);
            }
        }
    }

    protected AirconConfig getConfig() {
        return this.config;
    }

    protected boolean isUpdateIonizer(int n) {
        return false;
    }

    protected void notifySystemOnOff(int n, boolean bl) {
    }

    protected void notifyAutoModeStateChanged(int n, int n2) {
    }
}

