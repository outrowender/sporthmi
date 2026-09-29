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

    @Override
    public int getID() {
        return 31;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1747454208, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1976956672, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1960179456, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-450230016, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-433452800, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1764231424, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1781008640, (short)8);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1747454208);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1976956672);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1960179456);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-450230016);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-433452800);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1764231424);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1781008640);
    }

    @Override
    protected void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1747454208, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconAirCirculationAuto()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1764231424, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconHeater()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1781008640, this.getMenuEntryVisibilityState(airconMasterViewOptions.getAirconSolar()));
        if (this.currentViewOptionsRow1 != null) {
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
        }
    }

    @Override
    protected void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
        if (n == 1 && this.currentViewOptionsMaster != null && this.currentViewOptionsMaster.getConfiguration() != null) {
            if (!this.currentViewOptionsMaster.getConfiguration().isCarDriverSide()) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1976956672, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneLeftViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1960179456, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneRightViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-450230016, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-433452800, 1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-450230016, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneRightViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-433452800, this.getMenuEntryVisibilityState(airconRowViewOptions.getZoneLeftViewOptions().getAirconFootwellTemp()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1976956672, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1960179456, 1);
            }
        }
    }

    @Override
    protected AirconConfig getConfig() {
        return this.config;
    }

    @Override
    protected boolean isUpdateIonizer(int n) {
        return false;
    }

    @Override
    protected void notifySystemOnOff(int n, boolean bl) {
    }

    @Override
    protected void notifyAutoModeStateChanged(int n, int n2) {
    }
}

