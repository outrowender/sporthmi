/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTel1BAPMethodHandler
extends AbstractPhoneComponent
implements ITelDSIResponseListener,
ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker combiBapServicePhoneTracker;
    private volatile CombiBAPServicePhone combiBapService;
    private IGlobalTelephoneStateStruct globalTelephoneState;
    private final DispatcherBase tel1Dispatcher;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone;

    public AbstractTel1BAPMethodHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, "App.Phone.BAP");
        this.tel1Dispatcher = dispatcherBase;
    }

    public void init() {
        super.init();
        this.combiBapServicePhoneTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = AbstractTel1BAPMethodHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.combiBapServicePhoneTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        if (this.combiBapServicePhoneTracker != null) {
            this.combiBapServicePhoneTracker.closeTracker();
            this.combiBapServicePhoneTracker = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    protected void enqueueResultNotification(Runnable runnable) {
        this.tel1Dispatcher.execute(runnable);
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel1BAPMethodHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "AbstractTel1BAPMethodHandler#addingService service is null");
            return null;
        }
        if (object instanceof CombiBAPServicePhone) {
            this.setCombiBapService((CombiBAPServicePhone)object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    protected void setCombiBapService(CombiBAPServicePhone combiBAPServicePhone) {
        this.combiBapService = combiBAPServicePhone;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel1BAPMethodHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "AbstractTel1BAPMethodHandler#removedService service is null");
            return;
        }
        if (object instanceof CombiBAPServicePhone) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.setCombiBapService(null);
        }
    }

    protected CombiBAPServicePhone getCombiBapServicePhone() {
        return this.combiBapService;
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.globalTelephoneState = iGlobalTelephoneStateStruct;
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.globalTelephoneState;
    }

    public void responseAbortNetworkRegistration(int n, int n2) {
    }

    public void responseAbortNetworkSearch(int n, int n2) {
    }

    public void responseAcceptCall(int n, int n2) {
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
    }

    public void responseCallWaiting(int n, int n2, int n3, int n4) {
    }

    public void responseChangeSIMCode(int n, int n2, int n3) {
    }

    public void responseCLIR(int n, int n2, int n3, int n4) {
    }

    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct, int n2) {
    }

    public void responseHangupCall(int n, int n2) {
    }

    public void responseJoinCalls(int n, int n2) {
    }

    public void responseNetworkRegistration(int n, int n2) {
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n, int n2) {
    }

    public void responseRestoreFactorySettings(int n, int n2) {
    }

    public void responseSendDTMF(int n, int n2) {
    }

    public void responseServiceCodeAbort(int n, int n2) {
    }

    public void responseSetAutomaticEmergencyCallActive(int n, int n2) {
    }

    public void responseSetAutomaticPinEntryActive(int n, int n2) {
    }

    public void responseSetAutomaticRedialActive(int n, int n2) {
    }

    public void responseSetCDMAThreeWayCallingSetting(int n, int n2) {
    }

    public void responseSetESIMActive(int n, int n2) {
    }

    public void responseSetHandsFreeMode(int n, int n2) {
    }

    public void responseSetMailboxContent(int n, int n2) {
    }

    public void responseSetMICMuteState(int n, int n2) {
    }

    public void responseSetNADMode(int n, int n2, int n3) {
    }

    public void responseSetOptimizationMode(int n, int n2, int n3) {
    }

    public void responseSetPhoneReminderSetting(int n, int n2) {
    }

    public void responseSetPhoneRingtone(int n, int n2) {
    }

    public void responseSetPrivacyMode(int n, int n2) {
    }

    public void responseSIMPINRequired(int n, int n2) {
    }

    public void responseSplitCall(int n, int n2) {
    }

    public void responseSwapCalls(int n, int n2) {
    }

    public void responseTelPower(int n, int n2) {
    }

    public void responseUnlockOtherSIM(int n, int n2) {
    }

    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
    }

    public void responseChangeTopology(int n, int n2) {
    }

    public void responseSetSIMAliases(int n, int n2) {
    }

    public void responseCheckSIMPINCode(int n, int n2) {
    }

    public void responseRemoveOtherSIM(int n, int n2) {
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

