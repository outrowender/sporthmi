/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.ParkingFocusPropertyCollection;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSystemControllerComponentEvo
extends AbstractParkingSystemControllerComponent
implements IParkingFocusPropertyConfig {
    IParkingFocusPropertyConfig propertyConfigChain = this;
    private ParkingFocusPropertyCollection focusProperties = new ParkingFocusPropertyCollection();

    public ParkingSystemControllerComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1006, this.getMenuEntryVisibilityState(parkingSystemViewOptions.pdcPLASystemState));
    }

    @Override
    protected void initModels() {
        this.reconfigParkingOptionDrawer();
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1006, (short)2);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1006);
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public int getStandbyPopupID() {
        return 6;
    }

    @Override
    public synchronized void registerParkingSystemComponent(IParkingSystem iParkingSystem) {
        super.registerParkingSystemComponent(iParkingSystem);
        this.propertyConfigChain = iParkingSystem.createFocusPropertyDecorator(this.propertyConfigChain);
    }

    @Override
    public synchronized void reconfigParkingOptionDrawer() {
        PropertyModelApp propertyModelApp = this.getPropertyModel(1879842816);
        this.getLogChannel().log(-2137614336, "[ParkingSystemControllerComponentEvo#reconfigParkingOptionDrawer] collects focus properties and sets PropertyModel for ParkingSystems: modelID='%1' , category='CATEGORIE_POPUPS_FAHRZEUG_CAR_EINPARKHILFE(%2)'", (long)propertyModelApp.getID(), (long)0);
        this.propertyConfigChain.configureFocusProperties(new ParkingFocusPropertyCollection());
        propertyModelApp.setProperties(1055127382, this.focusProperties.getFocusPropertyArray());
    }

    @Override
    public void configureFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
        if (parkingFocusPropertyCollection != null) {
            this.focusProperties = parkingFocusPropertyCollection;
        }
    }

    @Override
    public void init() {
        super.init();
        this.getOPSViewModeHandler().init(554377216);
    }

    @Override
    public void deinit() {
        this.getOPSViewModeHandler().deinit();
        super.deinit();
    }
}

