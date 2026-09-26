/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.CarPhoneService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelCarPhoneServiceHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker carPhoneServiceTracker;
    private volatile CarPhoneService carPhoneService;
    private boolean callActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$CarPhoneService;

    public TelCarPhoneServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.carPhoneServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$CarPhoneService == null ? (class$de$audi$atip$interapp$CarPhoneService = TelCarPhoneServiceHandler.class$("de.audi.atip.interapp.CarPhoneService")) : class$de$audi$atip$interapp$CarPhoneService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.carPhoneServiceTracker.openTracker();
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.carPhoneServiceTracker.closeTracker();
        this.carPhoneServiceTracker = null;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x8000100 || n == 0x8000200 || n == 0x8000300) {
            boolean bl;
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
            boolean bl2 = iTelDSIMobileEquipmentDeviceState != null ? !iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() : (bl = false);
            if (bl != this.callActive) {
                this.updateCarPhoneService(bl);
                this.callActive = bl;
            }
        }
    }

    private void updateCarPhoneService(boolean bl) {
        CarPhoneService carPhoneService = this.carPhoneService;
        if (carPhoneService != null) {
            this.log.log(1078071040, "[TelCarPhoneServiceHandler#updateGlobalTelephoneStateProperty] callActive=%1", bl);
            carPhoneService.updateCallStatus(bl);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof CarPhoneService) {
            this.carPhoneService = (CarPhoneService)object;
            this.updateCarPhoneService(this.callActive);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CarPhoneService) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.carPhoneService = null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

