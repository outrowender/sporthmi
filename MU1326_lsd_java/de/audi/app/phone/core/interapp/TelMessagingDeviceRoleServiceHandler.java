/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import de.audi.atip.interapp.phone.ITelMESlotState;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelMessagingDeviceRoleServiceHandler
extends AbstractPhoneComponent {
    private volatile PhoneServiceTracker messagingServiceTracker;
    private volatile List roleObserverServices = new LinkedList();
    private boolean lastIsSim = false;
    private String lastSimID = "";
    private String lastBTMacAddress = "";
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver;

    public TelMessagingDeviceRoleServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.messagingServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver == null ? (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver = TelMessagingDeviceRoleServiceHandler.class$("de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver")) : class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver).getName(), new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof IDeviceRoleObserver && TelMessagingDeviceRoleServiceHandler.this.roleObserverServices.contains(object)) {
                    TelMessagingDeviceRoleServiceHandler.this.roleObserverServices.remove(object);
                    object = null;
                    TelMessagingDeviceRoleServiceHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                }
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = TelMessagingDeviceRoleServiceHandler.this.getApplication().getBundleContext().getService(serviceReference);
                if (object instanceof IDeviceRoleObserver && !TelMessagingDeviceRoleServiceHandler.this.roleObserverServices.contains(object)) {
                    TelMessagingDeviceRoleServiceHandler.this.roleObserverServices.add(object);
                    TelMessagingDeviceRoleServiceHandler.this.updateMessagingRoleObserver(TelMessagingDeviceRoleServiceHandler.this.lastIsSim, TelMessagingDeviceRoleServiceHandler.this.lastBTMacAddress, TelMessagingDeviceRoleServiceHandler.this.lastSimID);
                    return object;
                }
                TelMessagingDeviceRoleServiceHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                return null;
            }
        }, this.log);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.messagingServiceTracker.openTracker();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.messagingServiceTracker.closeTracker();
        this.messagingServiceTracker = null;
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelMessagingDeviceRoleServiceHandler#updateGlobalTelephoneStateProperty] state is null --> NOP!");
            return;
        }
        ITelMESlotState iTelMESlotState = null;
        if ((n == 65539 || n == 65551 || n == 65554) && iGlobalTelephoneStateStruct.getPrimaryDeviceState() != null && (iTelMESlotState = iGlobalTelephoneStateStruct.getPrimaryDeviceState().getDevice()) != null) {
            String string;
            boolean bl = iTelMESlotState.isSim();
            String string2 = iTelMESlotState.getBTMacAddress() != null ? iTelMESlotState.getBTMacAddress() : "";
            String string3 = string = iTelMESlotState.getSimCardID() != null ? iTelMESlotState.getSimCardID() : "";
            if (this.lastIsSim != bl || !this.lastBTMacAddress.equals(string2) || !this.lastSimID.equals(string)) {
                this.log.log(1000000, "[TelMessagingDeviceRoleServiceHandler#updateGlobalTelephoneStateProperty] isSim: %1, btMACAddress: %2, simID: %3", bl, (Object)string2, (Object)string);
                this.updateMessagingRoleObserver(bl, string2 != null ? string2 : "", string != null ? string : "");
                this.lastIsSim = bl;
                this.lastBTMacAddress = string2;
                this.lastSimID = string;
            }
        }
    }

    private void updateMessagingRoleObserver(boolean bl, String string, String string2) {
        for (int i2 = 0; i2 < this.roleObserverServices.size(); ++i2) {
            Object object = this.roleObserverServices.get(i2);
            if (!(object instanceof IDeviceRoleObserver)) continue;
            ((IDeviceRoleObserver)object).updateDeviceRoleInfo(new DeviceRoleInfo(bl, string2, string));
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

