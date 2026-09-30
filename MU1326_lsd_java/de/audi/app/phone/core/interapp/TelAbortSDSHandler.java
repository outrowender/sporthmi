/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.SDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelAbortSDSHandler
extends AbstractPhoneComponent {
    private final PhoneServiceTracker sdsServiceTracker;
    private volatile SDSService sdsService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public TelAbortSDSHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.sdsServiceTracker = new PhoneServiceTracker(iTelApplication.getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = TelAbortSDSHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof SDSService) {
                    TelAbortSDSHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                    TelAbortSDSHandler.this.sdsService = null;
                }
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = TelAbortSDSHandler.this.getApplication().getBundleContext().getService(serviceReference);
                if (object instanceof SDSService) {
                    TelAbortSDSHandler.this.sdsService = (SDSService)object;
                    return object;
                }
                TelAbortSDSHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                return null;
            }
        }, this.log);
    }

    public void init() {
        super.init();
        this.sdsServiceTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(65544, (IGlobalTelephoneStateListener)this);
    }

    public void deinit() {
        super.deinit();
        this.sdsServiceTracker.closeTracker();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(65544, (IGlobalTelephoneStateListener)this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        if (!(n != 65544 && n != 131080 && n != 196616 || (iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice()) == null || iTelDSIMobileEquipmentDeviceState.getCallState() == null || iTelDSIMobileEquipmentDeviceState.getCallState().getTransition() != 2 && iGlobalTelephoneStateStruct.getCallState().getTransition() != 1)) {
            SDSService sDSService = this.sdsService;
            if (sDSService != null) {
                this.log.log(1000000, "[TelAbortSDSHandler#updateGlobalTelephoneStateProperty] incoming call accepted. Aborting SDS!");
                sDSService.abortSDSSession(true, (byte)7);
            } else {
                this.log.log(100000, "[TelAbortSDSHandler#updateGlobalTelephoneStateProperty] SDSService is null --> NOP!");
            }
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

