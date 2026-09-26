/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.EcallBapDiagnosis
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.bap.BAPServiceEcallListenerClusterHandler$ListenerUpdater;
import de.audi.app.ecall.core.bap.IGlobalEcallState;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.app.ecall.core.state.EcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener;
import de.audi.atip.interapp.bap.ecall.data.EcallProvider;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.FunctionalState;
import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationData;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationVoice;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests$Builder;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.bap.ecall.data.SignalQuality;
import de.audi.atip.interapp.bap.ecall.data.SupportedServices;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.mib.swdiagnosis.ecall.EcallBapDiagnosis;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import java.lang.reflect.Field;
import java.util.LinkedList;
import org.osgi.framework.BundleContext;

public class BAPServiceEcallListenerClusterHandler
implements BAPServiceEcallListener,
IGlobalEcallState,
ITelStateListener,
ITelEcallService {
    private static final SimpleIntObjectMap ATTRIBUTE_NAME_MAP = new SimpleIntObjectMap();
    private EcallServiceProvider bapServiceEcallListenerProvider;
    private EcallServiceProvider telStateListenerProvider;
    private EcallServiceProvider telEcallServiceProvider;
    private volatile int bapAudioSource;
    private volatile PendingServiceRequests pendingServiceCalls = new PendingServiceRequests$Builder().build();
    private volatile int previousServiceCallKind;
    private volatile int serviceCallKind;
    private volatile int serviceState;
    private volatile PhoneCall[] phoneCalls;
    private volatile ITelState customerTelState;
    private volatile String emergencyNumberToBeDialed;
    private volatile EmergencyNumber[] allowedEmergencyNumbersList;
    private final LinkedList globalListeners = new LinkedList();
    private final Object stateMutex = new Object();
    private final LogChannel log;
    private final DispatcherBase listenerDispatcher;
    private final BundleContext bundleContext;
    private final IEcallApplication ecallApplication;
    static /* synthetic */ Class class$de$audi$app$ecall$core$bap$IGlobalEcallState;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestResult;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$EcallDisconnectReason;

    private static String getAttributeName(int n) {
        return (String)ATTRIBUTE_NAME_MAP.get(n);
    }

    public BAPServiceEcallListenerClusterHandler(IEcallApplication iEcallApplication, LogChannel logChannel) {
        this.log = logChannel;
        this.bundleContext = iEcallApplication.getBundleContext();
        this.ecallApplication = iEcallApplication;
        LogChannel logChannel2 = iEcallApplication.getFrameworkAccess().getLogChannel("App.Ecall.State.Dispatcher");
        this.listenerDispatcher = iEcallApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("ECALL_STATE_LISTENER_DISPATCHER", new JobLogger(logChannel2));
        iEcallApplication.addDiagnosisComponent((IEcallDiagnosisComponent)new EcallBapDiagnosis(iEcallApplication, (BAPServiceEcallListener)this));
    }

    @Override
    public void init() {
        this.listenerDispatcher.start();
        this.bapServiceEcallListenerProvider = new EcallServiceProvider((class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener = BAPServiceEcallListenerClusterHandler.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener).getName(), this, null, this.bundleContext, this.log);
        this.bapServiceEcallListenerProvider.startService();
        this.telStateListenerProvider = new EcallServiceProvider((class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = BAPServiceEcallListenerClusterHandler.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener).getName(), this, null, this.bundleContext, this.log);
        this.telStateListenerProvider.startService();
        this.telEcallServiceProvider = new EcallServiceProvider((class$de$audi$atip$interapp$phone$ITelEcallService == null ? (class$de$audi$atip$interapp$phone$ITelEcallService = BAPServiceEcallListenerClusterHandler.class$("de.audi.atip.interapp.phone.ITelEcallService")) : class$de$audi$atip$interapp$phone$ITelEcallService).getName(), this, null, this.bundleContext, this.log);
        this.telEcallServiceProvider.startService();
    }

    @Override
    public void deinit() {
        this.listenerDispatcher.stop();
        this.globalListeners.clear();
        this.bapServiceEcallListenerProvider.stopService();
        this.bapServiceEcallListenerProvider = null;
        this.telStateListenerProvider.stopService();
        this.telStateListenerProvider = null;
        this.telEcallServiceProvider.stopService();
        this.telEcallServiceProvider = null;
    }

    @Override
    public void removeListener(IGlobalEcallStateListener iGlobalEcallStateListener) {
        this.globalListeners.remove(iGlobalEcallStateListener);
    }

    @Override
    public void registerListener(IGlobalEcallStateListener iGlobalEcallStateListener) {
        this.globalListeners.add(iGlobalEcallStateListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void hangupServiceCall() {
        Object object = this.stateMutex;
        synchronized (object) {
            this.enqueueListenerUpdate(7);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void hangupLowPrioritySOSCall() {
        Object object = this.stateMutex;
        synchronized (object) {
            this.enqueueListenerUpdate(8);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dialLowPrioritySOSCall(String string) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.emergencyNumberToBeDialed = string;
            this.enqueueListenerUpdate(9);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTelState(int n, ITelState iTelState) {
        this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#updateTelState(): key %1, ecallState %2", (Object)String.valueOf(n), (Object)iTelState);
        if (n == 2) {
            Object object = this.stateMutex;
            synchronized (object) {
                this.customerTelState = iTelState;
                this.enqueueListenerUpdate(2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onCommunicationUp() {
        this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onCommunicationUp(): called");
        Object object = this.stateMutex;
        synchronized (object) {
            this.enqueueListenerUpdate(6);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onAudioSourceRequested(int n) {
        this.log.log(1078071040, "[BAPServiceEcallListenerClusterHandler#onAudioSourceRequested] called. AudioSource: %1 ", (long)n);
        Object object = this.stateMutex;
        synchronized (object) {
            this.bapAudioSource = n;
            this.enqueueListenerUpdate(5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onServiceRequests(PendingServiceRequests pendingServiceRequests) {
        this.log.log(1078071040, new StringBuffer().append("BAPServiceEcallListenerClusterHandler#onServiceRequests(): ").append(pendingServiceRequests).toString());
        Object object = this.stateMutex;
        synchronized (object) {
            this.pendingServiceCalls = pendingServiceRequests;
            if (this.serviceCallKind == 0) {
                this.previousServiceCallKind = this.serviceCallKind;
                this.serviceCallKind = BAPServiceEcallListenerClusterHandler.getServiceRequestKind(pendingServiceRequests);
            }
            this.enqueueListenerUpdate(4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onServiceState(int n, int n2, MdsTransmissionResult mdsTransmissionResult) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onServiceState(): start to handle service state serviceCallKind (%1), serviceState (%2), transmissionResult (%3)", (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)mdsTransmissionResult.toString());
        }
        Object object = this.stateMutex;
        synchronized (object) {
            if (this.bapAudioSource == 4 && n == 0 && n2 == 0) {
                this.bapAudioSource = 0;
                this.enqueueListenerUpdate(5);
            }
            this.previousServiceCallKind = this.serviceCallKind;
            this.serviceCallKind = n;
            this.serviceState = n2;
            this.enqueueListenerUpdate(3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onCallState(PhoneCall[] phoneCallArray) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onCallState(): phoneCalls %1", (Object)StringUtils.toString(phoneCallArray));
            this.phoneCalls = phoneCallArray;
            if (this.serviceCallKind == 0 && EcallUtil.isArrayNotEmpty(this.phoneCalls)) {
                this.previousServiceCallKind = this.serviceCallKind;
                this.serviceCallKind = BAPServiceEcallListenerClusterHandler.mappingToServiceKind(this.phoneCalls[0].getKind());
            } else if (this.previousServiceCallKind == 0 && this.serviceCallKind != 0 && this.phoneCalls[0].getKind() == 0) {
                this.serviceCallKind = 0;
            }
            this.enqueueListenerUpdate(1);
        }
    }

    @Override
    public void onHangupCallResult(boolean bl) {
        this.log.log(-2137614336, new StringBuffer().append("BAPServiceEcallListenerClusterHandler#onHangupCallResult(): ").append(bl).toString());
    }

    @Override
    public void onAcceptCallResult(boolean bl) {
        this.log.log(-2137614336, new StringBuffer().append("BAPServiceEcallListenerClusterHandler#onAcceptCallResult(): unhandled ").append(bl).toString());
    }

    @Override
    public void onServiceRequestResult(int n) {
        this.log.log(-2137614336, "BAPServiceEcallListenerClusterHandler#onServiceRequestResult(): unhandled %1 ", (long)n);
        EcallUtil.logStructFieldForDbg(this.log, class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestResult == null ? (class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestResult = BAPServiceEcallListenerClusterHandler.class$("de.audi.atip.interapp.bap.ecall.data.ServiceRequestResult")) : class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestResult, n);
    }

    @Override
    public void onDisconnectReason(int n) {
        this.log.log(-2137614336, "BAPServiceEcallListenerClusterHandler#onDisconnectReason(): unhandled disconnectReason %1 ", (long)n);
        EcallUtil.logStructFieldForDbg(this.log, class$de$audi$atip$interapp$bap$ecall$data$EcallDisconnectReason == null ? (class$de$audi$atip$interapp$bap$ecall$data$EcallDisconnectReason = BAPServiceEcallListenerClusterHandler.class$("de.audi.atip.interapp.bap.ecall.data.EcallDisconnectReason")) : class$de$audi$atip$interapp$bap$ecall$data$EcallDisconnectReason, n);
    }

    @Override
    public void onNetworkRegistrationState(NetworkRegistrationVoice networkRegistrationVoice, NetworkRegistrationData networkRegistrationData) {
        this.log.log(-2137614336, "BAPServiceEcallListenerClusterHandler#onNetworkRegistrationState(): unhandled networkRegistrationVoice %1, networkRegistrationData %2", (Object)networkRegistrationVoice, (Object)networkRegistrationData);
    }

    @Override
    public void onNetworkProviderInfo(EcallProvider ecallProvider, EcallProvider ecallProvider2) {
        this.log.log(-2137614336, "BAPServiceEcallListenerClusterHandler#onNetworkProviderInfo(): unhandled networkProvider (%1), serviceProvider (%2)", (Object)ecallProvider, (Object)ecallProvider2);
    }

    @Override
    public void onSignalQuality(SignalQuality signalQuality) {
        this.log.log(-2137614336, new StringBuffer().append("BAPServiceEcallListenerClusterHandler#onSignalQuality(): unhandled ").append(signalQuality).toString());
    }

    @Override
    public void onSupportedServices(SupportedServices supportedServices) {
        this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onSupportedServices(%1) --> Called. ", (Object)supportedServices);
        int n = supportedServices.isTestModeSupported() ? 1 : 0;
        this.ecallApplication.getFrameworkAccess().getHMIService().getChoiceModel(-1168494080).setValue(n);
    }

    @Override
    public void onFunctionalState(FunctionalState functionalState) {
        this.log.log(-2137614336, new StringBuffer().append("BAPServiceEcallListenerClusterHandler#onFunctionalState(): unhandled ").append(functionalState).toString());
    }

    @Override
    public void onDialNumberResult(int n) {
        this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onDialNumberResult(): result=%1", (long)n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onAllowedEmergencyNumbers(EmergencyNumber[] emergencyNumberArray) {
        this.log.log(1078071040, "BAPServiceEcallListenerClusterHandler#onAllowedEmergencyNumbers(): emergencyNumbers=%1", (Object)StringUtils.toString(emergencyNumberArray));
        Object object = this.stateMutex;
        synchronized (object) {
            this.allowedEmergencyNumbersList = emergencyNumberArray;
            this.enqueueListenerUpdate(10);
        }
    }

    private static int getServiceRequestKind(PendingServiceRequests pendingServiceRequests) {
        if (pendingServiceRequests.isManualEmergencyCallPending() && !pendingServiceRequests.isBreakdownServicePending()) {
            return 5;
        }
        if (pendingServiceRequests.isBreakdownServicePending()) {
            return 1;
        }
        return 0;
    }

    private static int mappingToServiceKind(int n) {
        int n2 = 0;
        switch (n) {
            case 1: 
            case 9: {
                n2 = 5;
                break;
            }
            case 8: {
                n2 = 4;
                break;
            }
            case 7: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void enqueueListenerUpdate(int n) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.listenerDispatcher.execute(new BAPServiceEcallListenerClusterHandler$ListenerUpdater(this, n, new EcallStateStruct(this.bapAudioSource, this.pendingServiceCalls, this.serviceCallKind, this.serviceState, this.phoneCalls, this.customerTelState, this.emergencyNumberToBeDialed, this.allowedEmergencyNumbersList)));
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

    static /* synthetic */ String access$000(int n) {
        return BAPServiceEcallListenerClusterHandler.getAttributeName(n);
    }

    static /* synthetic */ LogChannel access$100(BAPServiceEcallListenerClusterHandler bAPServiceEcallListenerClusterHandler) {
        return bAPServiceEcallListenerClusterHandler.log;
    }

    static /* synthetic */ LinkedList access$200(BAPServiceEcallListenerClusterHandler bAPServiceEcallListenerClusterHandler) {
        return bAPServiceEcallListenerClusterHandler.globalListeners;
    }

    static {
        Field[] fieldArray = (class$de$audi$app$ecall$core$bap$IGlobalEcallState == null ? (class$de$audi$app$ecall$core$bap$IGlobalEcallState = BAPServiceEcallListenerClusterHandler.class$("de.audi.app.ecall.core.bap.IGlobalEcallState")) : class$de$audi$app$ecall$core$bap$IGlobalEcallState).getFields();
        if (fieldArray != null) {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                if (!fieldArray[i2].getName().startsWith("ATTR")) continue;
                try {
                    ATTRIBUTE_NAME_MAP.add(fieldArray[i2].getInt(null), fieldArray[i2].getName());
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
    }
}

