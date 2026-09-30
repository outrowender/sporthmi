/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractKeyDataComponent;
import de.audi.app.car.evo.service.VehicleStatesHelper;
import org.dsi.ifc.global.CarViewOption;

public class KeyDataComponentEvo
extends AbstractKeyDataComponent {
    private static final int MOBILE_KEY_SERVICE_NOT_AVAILABLE = 0;
    private static final int MOBILE_KEY_SERVICE_AVAILABLE = 1;
    private boolean mobileKeyServiceAvailable = false;
    private boolean mobileKeyFleetMode = false;

    public KeyDataComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        VehicleStatesHelper.updateVinAndKeyDataVisibilityFromKeyData(carViewOption, this.getMenuEntryVisibilityState(carViewOption), this.getApplication());
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(181, (short)32);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(181);
    }

    protected void initModels() {
        super.initModels();
        this.mobileKeyServiceAvailable = this.getApplication().getFrameworkAccess().getSysApp().getAdaptationANP().isMobileDeviceKeyProfile();
        this.setMobileKeyAvailability();
    }

    public int getID() {
        return 8;
    }

    public void updateFleetModeState(boolean bl) {
        this.mobileKeyFleetMode = bl;
        this.setMobileKeyAvailability();
    }

    public void updateServiceActiveState(boolean bl) {
    }

    private void setMobileKeyAvailability() {
        this.getLogChannel().log(1000000, "KeyDataComponentEvo#setMobileKeyAvailability: mobileKeyServiceAvailable = %1, mobileKeyFleetMode = %2", this.mobileKeyServiceAvailable, this.mobileKeyFleetMode);
        this.getChoiceModel(602736).setValue(this.mobileKeyServiceAvailable && !this.mobileKeyFleetMode ? 1 : 0);
    }
}

