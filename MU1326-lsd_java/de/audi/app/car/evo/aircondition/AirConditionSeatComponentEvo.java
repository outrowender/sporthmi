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

    @Override
    public int getID() {
        return 43;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-483981056, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-433649408, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-383317760, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-332986112, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-265877248, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-249100032, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-232322816, (short)8);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-215545600, (short)8);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-483981056);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-433649408);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-383317760);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-332986112);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-265877248);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-249100032);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-232322816);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-215545600);
    }

    @Override
    protected void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
        this.setDriverSideRight(airconMasterViewOptions.getConfiguration().isCarDriverSide());
    }

    @Override
    protected void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
        AirconZoneViewOptions airconZoneViewOptions;
        AirconZoneViewOptions airconZoneViewOptions2 = !this.isDriverSideRight() ? airconRowViewOptions.getZoneLeftViewOptions() : airconRowViewOptions.getZoneRightViewOptions();
        AirconZoneViewOptions airconZoneViewOptions3 = airconZoneViewOptions = this.isDriverSideRight() ? airconRowViewOptions.getZoneLeftViewOptions() : airconRowViewOptions.getZoneRightViewOptions();
        if (1 == n) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-483981056, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-433649408, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-265877248, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatHeaterDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-249100032, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatHeaterDistribution()));
        }
        if (2 == n) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-383317760, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-332986112, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatVentilationDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-232322816, this.getMenuEntryVisibilityState(airconZoneViewOptions2.getAirconSeatHeaterDistribution()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-215545600, this.getMenuEntryVisibilityState(airconZoneViewOptions.getAirconSeatHeaterDistribution()));
        }
    }
}

