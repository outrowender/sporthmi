/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.FactResetService;
import de.audi.atip.msg.MsgListener;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelRestoreFactorySettingsHandler
extends AbstractPhoneComponent
implements MsgListener,
ServiceTrackerCustomizer {
    private volatile PhoneServiceProvider msgListenerServiceProvider;
    private volatile PhoneServiceTracker factoryResetServiceTracker;
    private volatile FactResetService factoryResetService;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    static /* synthetic */ Class class$de$audi$atip$interapp$FactResetService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public TelRestoreFactorySettingsHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.factoryResetServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$FactResetService == null ? (class$de$audi$atip$interapp$FactResetService = TelRestoreFactorySettingsHandler.class$("de.audi.atip.interapp.FactResetService")) : class$de$audi$atip$interapp$FactResetService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.factoryResetServiceTracker.openTracker();
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.msgListenerServiceProvider = new PhoneServiceProvider((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = TelRestoreFactorySettingsHandler.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.msgListenerServiceProvider.startService();
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        if (this.msgListenerServiceProvider != null) {
            this.msgListenerServiceProvider.stopService();
        }
        if (this.factoryResetServiceTracker != null) {
            this.factoryResetServiceTracker.closeTracker();
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (n == 65539) {
            this.updateFactoryResetService();
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelRestoreFactorySettingsHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelRestoreFactorySettingsHandler#addingService service is null");
            return null;
        }
        if (object instanceof FactResetService) {
            this.log.log(1000000, "[TelRestoreFactorySettingsHandler#addingService] FactResetService=%1", object);
            this.setFactResetService((FactResetService)object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelRestoreFactorySettingsHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelRestoreFactorySettingsHandler#removedService service is null");
            return;
        }
        if (object instanceof FactResetService) {
            this.log.log(1000000, "[TelRestoreFactorySettingsHandler#removedService] FactResetService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.factoryResetService = null;
        }
    }

    private void setFactResetService(FactResetService factResetService) {
        this.factoryResetService = factResetService;
        this.updateFactoryResetService();
    }

    private void updateFactoryResetService() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        FactResetService factResetService = this.factoryResetService;
        if (factResetService != null && iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null) {
            int n = this.telephoneState.getActivationState().getTelActivationState();
            boolean bl = n != 5 && n != 1 && n != 12;
            boolean bl2 = n == 2;
            this.log.log(1000000, "[TelRestoreFactorySettingsHandler#updateFactoryResetService] activationState=%1, sending blockPhone=%2, blockBluetooth=%3", (Object)new Integer(n), (Object)bl, (Object)bl2);
            factResetService.setPhoneStateBlockReset(bl, bl2);
        } else {
            this.log.log(10000, "[TelRestoreFactorySettingsHandler#updateFactoryResetService] service, state or activation state is null");
        }
    }

    public void processMsg(int n) {
        if (n == 28) {
            this.restoreTelephoneSettings();
        }
    }

    private void restoreTelephoneSettings() {
        this.log.log(1000000, "[TelRestoreFactorySettingsHandler#restoreTelephoneSettings]");
        this.getApplication().getTelephoneDSIAccess().restoreFactorySettings(0);
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

