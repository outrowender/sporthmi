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

    protected void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1006, this.getMenuEntryVisibilityState(parkingSystemViewOptions.pdcPLASystemState));
    }

    protected void initModels() {
        this.reconfigParkingOptionDrawer();
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1006, (short)2);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1006);
    }

    public int getID() {
        return 1;
    }

    public int getStandbyPopupID() {
        return 6;
    }

    public synchronized void registerParkingSystemComponent(IParkingSystem iParkingSystem) {
        super.registerParkingSystemComponent(iParkingSystem);
        this.propertyConfigChain = iParkingSystem.createFocusPropertyDecorator(this.propertyConfigChain);
    }

    public synchronized void reconfigParkingOptionDrawer() {
        PropertyModelApp propertyModelApp = this.getPropertyModel(2100336);
        this.getLogChannel().log(10000000, "[ParkingSystemControllerComponentEvo#reconfigParkingOptionDrawer] collects focus properties and sets PropertyModel for ParkingSystems: modelID='%1' , category='CATEGORIE_POPUPS_FAHRZEUG_CAR_EINPARKHILFE(%2)'", (long)propertyModelApp.getID(), 1459086142L);
        this.propertyConfigChain.configureFocusProperties(new ParkingFocusPropertyCollection());
        propertyModelApp.setProperties(1459086142, this.focusProperties.getFocusPropertyArray());
    }

    public void configureFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
        if (parkingFocusPropertyCollection != null) {
            this.focusProperties = parkingFocusPropertyCollection;
        }
    }

    public void init() {
        super.init();
        this.getOPSViewModeHandler().init(2100001);
    }

    public void deinit() {
        this.getOPSViewModeHandler().deinit();
        super.deinit();
    }
}

