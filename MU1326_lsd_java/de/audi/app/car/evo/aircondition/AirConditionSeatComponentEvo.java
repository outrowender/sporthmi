/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.aircondition;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.aircondition.AbstractAirconSeatComponent;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;

public class AirConditionSeatComponentEvo
extends AbstractAirconSeatComponent {
    public AirConditionSeatComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public int getID() {
        return 43;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600035, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600038, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600041, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600044, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600048, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600049, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600050, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600051, (short)8);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600035);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600038);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600041);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600044);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600048);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600049);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600050);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600051);
    }

    protected void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
        this.setDriverSideRight(airconMasterViewOptions.getConfiguration().isCarDriverSide());
    }

    protected void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
        AirconZoneViewOptions airconZoneViewOptions;
        AirconZoneViewOptions airconZoneViewOptions2 = !this.isDriverSideRight() ? airconRowViewOptions.getZoneLeftViewOptions() : airconRowViewOptions.getZoneRightViewOptions();
        AirconZoneViewOptions airconZoneViewOptions3 = airconZoneViewOptions = this.isDriverSideRight() ? airconRowViewOptions.getZoneLeftViewOptions() : airconRowViewOptions.getZoneRightViewOptions();
        if (1 == n) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600035, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600038, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600048, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatHeaterDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600049, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatHeaterDistribution()));
        }
        if (2 == n) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600041, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600044, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600050, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatHeaterDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600051, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatHeaterDistribution()));
        }
    }
}

