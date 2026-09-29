/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.devicerole;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo$1;
import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo$MyAccountManagerListener;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import org.dsi.ifc.messaging.MessagingAccount;

public final class DeviceRoleManagerEvo
extends AbstractMessagingComponent
implements IDeviceRoleObserver {
    private DeviceRoleInfo primaryDevice;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver;

    public DeviceRoleManagerEvo(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().addListener(new DeviceRoleManagerEvo$MyAccountManagerListener(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver == null ? (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver = DeviceRoleManagerEvo.class$("de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver")) : class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver).getName(), (Object)this, ServiceProperties.createServiceProperties());
        }
        catch (Exception exception) {
            this.log.log(10000, "[DeviceRoleManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void determineIfPrimaryAccountIsSelected() {
        try {
            boolean bl = false;
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
            if (this.primaryDevice != null && messagingAccount != null) {
                if (this.primaryDevice.isSimDevice()) {
                    if (!Strings.isNullOrEmpty(messagingAccount.getSimCardId()) && messagingAccount.getSimCardId().equals(this.primaryDevice.getSimCardId())) {
                        bl = true;
                    }
                } else if (!Strings.isNullOrEmpty(messagingAccount.getBtDeviceAddress()) && messagingAccount.getBtDeviceAddress().equals(this.primaryDevice.getBtDeviceAddress())) {
                    bl = true;
                }
            }
            this.log.log(1078071040, "[DeviceRoleManagerEvo#determineIfPrimaryAccountIsSelected] isSelectedAccountPrimary = %1", (Object)(bl ? "true" : "false"));
            this.framework.getHmiServiceApp().getChoiceModel(-1684856576).setValue(bl ? 1 : 0);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[DeviceRoleManagerEvo#determineIfPrimaryAccountIsSelected]");
        }
    }

    @Override
    public void updateDeviceRoleInfo(DeviceRoleInfo deviceRoleInfo) {
        this.log.log(1078071040, "[DeviceRoleManager#updateDeviceRoleInfo] primaryDeviceInfo = %1", (Object)deviceRoleInfo);
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new DeviceRoleManagerEvo$1(this, deviceRoleInfo));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ DeviceRoleInfo access$102(DeviceRoleManagerEvo deviceRoleManagerEvo, DeviceRoleInfo deviceRoleInfo) {
        deviceRoleManagerEvo.primaryDevice = deviceRoleInfo;
        return deviceRoleManagerEvo.primaryDevice;
    }

    static /* synthetic */ void access$200(DeviceRoleManagerEvo deviceRoleManagerEvo) {
        deviceRoleManagerEvo.determineIfPrimaryAccountIsSelected();
    }
}

