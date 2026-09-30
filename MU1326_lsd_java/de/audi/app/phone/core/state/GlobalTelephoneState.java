/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.dsi.AbstractTelDSIDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.app.phone.core.event.TelChoiceModelSetValueEvent;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.GlobalTelephoneStateDiag;
import de.audi.app.phone.core.state.GlobalTelephoneStateModelHandler;
import de.audi.app.phone.core.state.GlobalTelephoneStateStructME;
import de.audi.app.phone.core.state.IGlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.state.NullEcallState;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallStateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;
import org.osgi.framework.BundleContext;

public class GlobalTelephoneState
implements IGlobalTelephoneState,
IPhoneDiagComponent,
ITelEcallStateListener {
    static final int CALL_LEADING_DEVICE_PRIMARY = 0;
    static final int CALL_LEADING_DEVICE_ASSOCIATED = 1;
    static final int CALL_LEADING_DEVICE_DATA = 2;
    static final int NAD_USAGE_UNKNOWN = -1;
    private static final SimpleIntObjectMap attributeNameMap = PhoneUtils.getFieldNameMap(class$de$audi$app$phone$core$state$IGlobalTelephoneState == null ? (class$de$audi$app$phone$core$state$IGlobalTelephoneState = GlobalTelephoneState.class$("de.audi.app.phone.core.state.IGlobalTelephoneState")) : class$de$audi$app$phone$core$state$IGlobalTelephoneState, "ATTR");
    public static final int STATE_UNKNOWN = -1;
    public static final int SIGNAL_QUALITY_UNKNOWN = 255;
    private final LogChannel log;
    private final BundleContext bundleContext;
    private final LinkedList globalListeners = new LinkedList();
    private final Map attributeToListenerMap = new HashMap();
    private volatile boolean newSMSAvailable;
    private volatile boolean newEMailAvailable;
    private volatile boolean ringtoneMuteSettingOn;
    private volatile boolean ringtoneMuteActive;
    private volatile IEcallState ecallState = new NullEcallState();
    private volatile boolean acceptIncomingCallOnNonCallLeadingDevicePending;
    private volatile ITelTopology topology;
    private volatile int nadMode;
    private volatile NADTemperatureStruct nadTemp;
    private volatile EmergencyNumbers emergencyNumbers;
    private volatile ServiceNumbers serviceNumbers;
    private volatile String eUICCID;
    private volatile String eSIMMSISDN;
    private volatile boolean eSIMActive;
    private volatile boolean eSIMB2BMode;
    private volatile int nadUsage = -1;
    private volatile CallStateStruct primaryCallState;
    private volatile CallStateStruct associatedCallState;
    private volatile CallStateStruct dataCallState;
    private volatile int callLeadingDevice = 0;
    private volatile ITelDSIMobileEquipmentDeviceState primaryDevice;
    private volatile ITelDSIMobileEquipmentDeviceState associatedDevice;
    private volatile ITelDSIMobileEquipmentDeviceState dataOnlyNadDevice;
    private volatile PhoneServiceProvider ecallStateListenerProvider;
    protected volatile ActivationStateStruct activationStateDSINAD;
    private final ITelApplication phoneApplication;
    private final Object stateMutex = new Object();
    private final TelGlobalStateDSIResponseListener dsiResponseListener;
    static /* synthetic */ Class class$de$audi$app$phone$core$state$IGlobalTelephoneState;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallStateListener;

    static String getNadUsageName(int n) {
        switch (n) {
            case -1: {
                return "NAD_USAGE_UNKNOWN";
            }
            case 0: {
                return "NAD_USAGE_PRIMARY";
            }
            case 1: {
                return "NAD_USAGE_ASSOCIATED";
            }
            case 2: {
                return "NAD_USAGE_DATA";
            }
        }
        return new StringBuffer().append("Unknown nad usage ").append(n).toString();
    }

    public static String getAttributeName(int n) {
        return (String)attributeNameMap.get(n);
    }

    public static boolean telFeatSupported(short s, int n) {
        return (s & n) == n;
    }

    public static boolean supportsFeature(ActivationStateStruct activationStateStruct, int n) {
        if (activationStateStruct != null) {
            short s = activationStateStruct.getTelFeat();
            int n2 = activationStateStruct.getTelMode();
            if (n2 == 0 || n2 == 2 || n2 == 1) {
                switch (n) {
                    case 2: 
                    case 8: 
                    case 16: 
                    case 32: 
                    case 64: {
                        return true;
                    }
                }
                return GlobalTelephoneState.telFeatSupported(s, n);
            }
            if (n2 == 3) {
                return GlobalTelephoneState.telFeatSupported(s, n);
            }
        }
        return false;
    }

    private static boolean isCallStateSingleDisconnecting(CallStateStruct callStateStruct) {
        return callStateStruct != null && callStateStruct.getMpCallState() == 3 || callStateStruct.getMpCallState() == 32;
    }

    private static boolean incomingCallAccepted(CallStateStruct callStateStruct) {
        return callStateStruct != null && callStateStruct.getTransition() == 2;
    }

    private static boolean wasPreviousCallStateIncommingCall(CallStateStruct callStateStruct) {
        int n = callStateStruct != null ? callStateStruct.getPreviousMPCallState() : 0;
        return n == 15;
    }

    public GlobalTelephoneState(ITelApplication iTelApplication) {
        this.phoneApplication = iTelApplication;
        this.log = iTelApplication.getFrameworkAccess().getLogChannel("App.Phone.State");
        this.bundleContext = iTelApplication.getBundleContext();
        iTelApplication.addDiagnosisComponent(new GlobalTelephoneStateDiag(this));
        this.dsiResponseListener = new TelGlobalStateDSIResponseListener();
    }

    public void init() {
        this.registerListener(new GlobalTelephoneStateModelHandler(this.phoneApplication, this.log));
        this.phoneApplication.getTelephoneDSIAccess().addGlobalDSIResponseListener(this.dsiResponseListener);
        this.ecallStateListenerProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelEcallStateListener == null ? (class$de$audi$atip$interapp$phone$ITelEcallStateListener = GlobalTelephoneState.class$("de.audi.atip.interapp.phone.ITelEcallStateListener")) : class$de$audi$atip$interapp$phone$ITelEcallStateListener).getName(), this, null, this.bundleContext, this.log);
        this.ecallStateListenerProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.globalListeners.clear();
        Map map = this.attributeToListenerMap;
        synchronized (map) {
            this.attributeToListenerMap.clear();
        }
        this.phoneApplication.getTelephoneDSIAccess().removeGlobalDSIResponseListener(this.dsiResponseListener);
        if (this.ecallStateListenerProvider != null) {
            this.ecallStateListenerProvider.stopService();
            this.ecallStateListenerProvider = null;
        }
    }

    ITelDSIMobileEquipmentDeviceState getPrimaryDevice() {
        return this.primaryDevice;
    }

    ITelDSIMobileEquipmentDeviceState getSecondaryDevice() {
        return this.associatedDevice;
    }

    ITelDSIMobileEquipmentDeviceState getDataOnlyNadDevice() {
        return this.dataOnlyNadDevice;
    }

    ITelDSIMobileEquipmentDeviceState getCallLeadingDevice() {
        switch (this.callLeadingDevice) {
            case 1: {
                return this.associatedDevice;
            }
            case 0: {
                return this.primaryDevice;
            }
            case 2: {
                return this.dataOnlyNadDevice;
            }
        }
        return this.primaryDevice;
    }

    ITelDSIMobileEquipmentDeviceState getNonCallLeadingDevice() {
        return this.callLeadingDevice == 0 ? this.associatedDevice : this.primaryDevice;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListener(IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        LinkedList linkedList = this.globalListeners;
        synchronized (linkedList) {
            this.globalListeners.add(iGlobalTelephoneStateListener);
        }
    }

    public void setNadUsagePrimary() {
        this.log.log(1000000, "[GlobalTelephoneState#setNadUsagePrimary]");
        this.nadUsage = 0;
    }

    public void setNadUsageAssociated() {
        this.log.log(1000000, "[GlobalTelephoneState#setNadUsageAssociated]");
        this.nadUsage = 1;
    }

    public void setNadUsageData() {
        this.log.log(1000000, "[GlobalTelephoneState#setNadUsageData]");
        this.nadUsage = 2;
    }

    public void setNadUsageUnknown() {
        this.log.log(1000000, "[GlobalTelephoneState#setNadUsageUnknown]");
        this.nadUsage = -1;
    }

    int getNadUsage() {
        return this.nadUsage;
    }

    public void registerListenerForSpecificAttributeUpdate(int[] nArray, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.registerListenerForSpecificAttributeUpdate(nArray[i2], iGlobalTelephoneStateListener);
            }
        }
    }

    public void removeListenerForSpecificAttributeUpdate(int[] nArray, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.removeListenerForSpecificAttributeUpdate(nArray[i2], iGlobalTelephoneStateListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListenerForSpecificAttributeUpdate(int n, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        Map map = this.attributeToListenerMap;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.attributeToListenerMap.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.attributeToListenerMap.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iGlobalTelephoneStateListener)) {
                return;
            }
            linkedList.add(iGlobalTelephoneStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListenerForSpecificAttributeUpdate(int n, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        Map map = this.attributeToListenerMap;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.attributeToListenerMap.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iGlobalTelephoneStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
        LinkedList linkedList = this.globalListeners;
        synchronized (linkedList) {
            this.globalListeners.remove(iGlobalTelephoneStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void enqueueListenerUpdate(int n) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.phoneApplication.enqueueEvent(new TelGlobalStateUpdateEvent(n, new GlobalTelephoneStateStructME(this.primaryDevice, this.associatedDevice, this.dataOnlyNadDevice, this.getCallLeadingDevice(), this.getNonCallLeadingDevice(), this.isNewSMSAvailable(), this.isNewEMailAvailable(), this.isRingtoneMuteActive(), this.isRingtoneMuteSettingOn(), this.getEcallState(), this.getNadMode(), this.nadTemp, this.emergencyNumbers, this.serviceNumbers, this.eUICCID, this.eSIMMSISDN, this.eSIMActive, this.eSIMB2BMode, this.nadUsage, this.acceptIncomingCallOnNonCallLeadingDevicePending, this.topology)));
        }
    }

    private void enqueueCallStateChoiceUpdate(int n, int n2) {
        this.phoneApplication.enqueueEvent(new TelChoiceModelSetValueEvent(this.phoneApplication.getFrameworkAccess().getHMIService().getChoiceModel(n2), n));
    }

    private void enqueueCallStateActiveUpdate(CallStateStruct callStateStruct, int n) {
        if (callStateStruct != null) {
            boolean bl = !callStateStruct.isIdle() && !callStateStruct.isHasIncomingCall() && !callStateStruct.isHasDisconnectingCall();
            this.phoneApplication.enqueueEvent(new TelChoiceModelSetValueEvent(this.phoneApplication.getFrameworkAccess().getHMIService().getChoiceModel(n), bl ? 1 : 0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateNewMessagesAvailable(boolean bl, boolean bl2) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.log.log(1000000, "[GlobalTelephoneState#updateNewMessagesAvailable] smsAvailable=%1, emailsAvailable=%2", bl, bl2);
            this.setNewSMSAvailable(bl);
            this.setNewEMailAvailable(bl2);
            this.enqueueListenerUpdate(262148);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRingtoneMuteActive(boolean bl) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.log.log(1000000, "[GlobalTelephoneState#updateRingtoneMute] active=%1", bl);
            this.setRingtoneMuteActive(bl);
            this.enqueueListenerUpdate(262150);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRingtoneMuteSetting(boolean bl) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.log.log(1000000, "[GlobalTelephoneState#updateRingtoneMute] settingOn=%1", bl);
            this.setRingtoneMuteSettingOn(bl);
            this.enqueueListenerUpdate(262149);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTopology(ITelTopology iTelTopology) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.log.log(1000000, "[GlobalTelephoneState#updateTopology] %1", (Object)iTelTopology);
            this.topology = iTelTopology;
            this.enqueueListenerUpdate(262157);
        }
    }

    private void setCallFocus() {
        int n;
        int n2 = this.primaryCallState != null ? this.primaryCallState.getMpCallState() : 0;
        int n3 = this.associatedCallState != null ? this.associatedCallState.getMpCallState() : 0;
        int n4 = n = this.dataCallState != null ? this.dataCallState.getMpCallState() : 0;
        if (n != 0 && this.dataOnlyNadDevice.getTelMode() != 3) {
            this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call on data only instance --> call leading device is data");
            this.callLeadingDevice = 2;
        } else if (n2 != 0 && n3 == 0) {
            this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call only on primary phone --> call leading device is primary");
            this.callLeadingDevice = 0;
        } else if (n2 == 0 && n3 != 0) {
            this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call only on associated phone --> call leading device is associated");
            this.callLeadingDevice = 1;
        } else if (n2 != 0 && n3 != 0) {
            this.computeCallLeadingDeviceForCallStateIdle();
        } else {
            this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] both phone are in idle --> call leading device is primary");
            this.callLeadingDevice = 0;
        }
    }

    private void computeCallLeadingDeviceForCallStateIdle() {
        if (this.callLeadingDevice == 0) {
            if (GlobalTelephoneState.incomingCallAccepted(this.associatedCallState) && GlobalTelephoneState.isCallStateSingleDisconnecting(this.primaryCallState)) {
                this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call on associated phone was accepted, switching call leading device to associated");
                this.callLeadingDevice = 1;
            } else if (GlobalTelephoneState.isCallStateSingleDisconnecting(this.primaryCallState) && GlobalTelephoneState.wasPreviousCallStateIncommingCall(this.primaryCallState) && this.associatedCallState.isHasIncomingCall() && !this.acceptIncomingCallOnNonCallLeadingDevicePending) {
                this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] incoming call on associated available and disconecting call on primary (previously in incoming state) -> switching call leading device to associated");
                this.callLeadingDevice = 1;
            } else {
                this.log.log(1000000, "[GlobalTelephoneState#setAudioFocus] call on associated phone, however call leading device is still primary");
            }
        } else if (this.callLeadingDevice == 1) {
            if (GlobalTelephoneState.incomingCallAccepted(this.primaryCallState) && GlobalTelephoneState.isCallStateSingleDisconnecting(this.associatedCallState)) {
                this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call on primary phone was accepted, switching call leading device to primary");
                this.callLeadingDevice = 0;
            } else if (GlobalTelephoneState.isCallStateSingleDisconnecting(this.associatedCallState) && GlobalTelephoneState.wasPreviousCallStateIncommingCall(this.associatedCallState) && this.primaryCallState.isHasIncomingCall() && !this.acceptIncomingCallOnNonCallLeadingDevicePending) {
                this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] incoming call on primary available and disconecting call on associated (previously in incoming state) -> switching call leading device to primary");
                this.callLeadingDevice = 0;
            } else {
                this.log.log(1000000, "[GlobalTelephoneState#setCallFocus] call on primary phone, however call leading device is still associated");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMEDevice(int n, int n2, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        Object object = this.stateMutex;
        synchronized (object) {
            if (n2 == -65536) {
                this.log.log(10000000, "[GlobalTelephoneState#updateMEDevice] disregarding update %1 for ROLE_UNKNOWN", (Object)GlobalTelephoneState.getAttributeName(n));
                return;
            }
            if (iTelDSIMobileEquipmentDeviceState == null) {
                this.log.log(100000, "[GlobalTelephoneState#updateMEDevice] attribute=%1, deviceRole=%2, meStateStruct is null --> NOP!");
                return;
            }
            switch (n2) {
                case 65536: {
                    this.primaryDevice = iTelDSIMobileEquipmentDeviceState;
                    break;
                }
                case 131072: {
                    this.associatedDevice = iTelDSIMobileEquipmentDeviceState;
                    break;
                }
                case 196608: {
                    this.dataOnlyNadDevice = iTelDSIMobileEquipmentDeviceState;
                    break;
                }
                default: {
                    this.log.log(10000000, "[GlobalTelephoneState#updateMEDevice] no processing for deviceRole %1", (long)n2);
                }
            }
            int n3 = AbstractTelDSIDeviceAccess.getAttribute(n, n2);
            switch (n3) {
                case 65537: {
                    this.enqueueListenerUpdate(65537);
                    break;
                }
                case 65538: {
                    this.emergencyNumbers = iTelDSIMobileEquipmentDeviceState.getTelEmerNums();
                    this.enqueueListenerUpdate(262145);
                    break;
                }
                case 65539: {
                    this.enqueueListenerUpdate(65538);
                    break;
                }
                case 65540: {
                    this.phoneApplication.logStartupEvent(new StringBuffer().append("[TEL-HMI] updateActivationState: ").append(iTelDSIMobileEquipmentDeviceState.getActivationState()).toString());
                    this.enqueueListenerUpdate(65539);
                    break;
                }
                case 65541: {
                    this.enqueueListenerUpdate(65540);
                    break;
                }
                case 65542: {
                    this.enqueueListenerUpdate(65541);
                    break;
                }
                case 65543: {
                    this.enqueueListenerUpdate(65542);
                    break;
                }
                case 65544: {
                    this.enqueueListenerUpdate(65543);
                    break;
                }
                case 65545: {
                    this.primaryCallState = iTelDSIMobileEquipmentDeviceState.getCallState();
                    this.setCallFocus();
                    this.enqueueListenerUpdate(65544);
                    if (iTelDSIMobileEquipmentDeviceState.getCallState() == null) break;
                    int n4 = this.getCallLeadingDevice() != null && this.getCallLeadingDevice().getCallState() != null ? this.getCallLeadingDevice().getCallState().getCallStateChoiceValue() : 0;
                    int n5 = this.getNonCallLeadingDevice() != null && this.getNonCallLeadingDevice().getCallState() != null ? this.getNonCallLeadingDevice().getCallState().getCallStateChoiceValue() : 0;
                    this.enqueueCallStateChoiceUpdate(iTelDSIMobileEquipmentDeviceState.getCallState().getCallStateChoiceValue(), 3848);
                    this.enqueueCallStateChoiceUpdate(n4, 4367);
                    this.enqueueCallStateChoiceUpdate(n5, 4395);
                    this.enqueueCallStateActiveUpdate(iTelDSIMobileEquipmentDeviceState.getCallState(), 300503);
                    break;
                }
                case 65546: {
                    this.enqueueListenerUpdate(65545);
                    break;
                }
                case 65547: {
                    this.enqueueListenerUpdate(65546);
                    break;
                }
                case 65548: {
                    this.enqueueListenerUpdate(65547);
                    break;
                }
                case 65549: {
                    this.enqueueListenerUpdate(65548);
                    break;
                }
                case 65550: {
                    this.enqueueListenerUpdate(65549);
                    break;
                }
                case 65551: {
                    this.enqueueListenerUpdate(65550);
                    break;
                }
                case 65552: {
                    this.enqueueListenerUpdate(65551);
                    break;
                }
                case 65553: {
                    this.enqueueListenerUpdate(65552);
                    break;
                }
                case 65554: {
                    this.enqueueListenerUpdate(65553);
                    break;
                }
                case 65555: {
                    this.nadTemp = iTelDSIMobileEquipmentDeviceState.getnADTemperature();
                    this.enqueueListenerUpdate(262146);
                    break;
                }
                case 65556: {
                    this.enqueueListenerUpdate(65554);
                    break;
                }
                case 65557: {
                    this.enqueueListenerUpdate(65555);
                    break;
                }
                case 65558: {
                    this.enqueueListenerUpdate(65556);
                    break;
                }
                case 65559: {
                    this.enqueueListenerUpdate(65557);
                    break;
                }
                case 65560: {
                    this.enqueueListenerUpdate(65558);
                    break;
                }
                case 65561: {
                    this.enqueueListenerUpdate(65559);
                    break;
                }
                case 65562: {
                    this.serviceNumbers = iTelDSIMobileEquipmentDeviceState.getServiceNumbers();
                    this.enqueueListenerUpdate(262155);
                    break;
                }
                case 65563: {
                    this.enqueueListenerUpdate(65561);
                    break;
                }
                case 65564: {
                    this.enqueueListenerUpdate(65562);
                    break;
                }
                case 65565: {
                    this.enqueueListenerUpdate(65563);
                    break;
                }
                case 65566: {
                    this.enqueueListenerUpdate(65564);
                    break;
                }
                case 65567: {
                    this.enqueueListenerUpdate(65565);
                    break;
                }
                case 65568: {
                    this.enqueueListenerUpdate(65566);
                    break;
                }
                case 65569: {
                    this.setNadMode(iTelDSIMobileEquipmentDeviceState.getNadMode());
                    this.enqueueListenerUpdate(262147);
                    break;
                }
                case 65570: {
                    this.enqueueListenerUpdate(65567);
                    break;
                }
                case 65571: {
                    break;
                }
                case 65572: {
                    this.enqueueListenerUpdate(65579);
                    break;
                }
                case 65573: {
                    break;
                }
                case 65574: {
                    this.enqueueListenerUpdate(65568);
                    break;
                }
                case 65575: {
                    this.enqueueListenerUpdate(65569);
                    break;
                }
                case 65576: {
                    break;
                }
                case 65577: {
                    this.enqueueListenerUpdate(65570);
                    break;
                }
                case 65578: {
                    this.eUICCID = iTelDSIMobileEquipmentDeviceState.geteUICCID();
                    this.enqueueListenerUpdate(262151);
                    break;
                }
                case 65579: {
                    this.eSIMMSISDN = iTelDSIMobileEquipmentDeviceState.geteSIMMSISDN();
                    this.enqueueListenerUpdate(262152);
                    break;
                }
                case 65580: {
                    this.eSIMActive = iTelDSIMobileEquipmentDeviceState.iseSIMActive();
                    this.enqueueListenerUpdate(262153);
                    break;
                }
                case 65581: {
                    this.eSIMB2BMode = iTelDSIMobileEquipmentDeviceState.iseSIMB2BModeActive();
                    this.enqueueListenerUpdate(262154);
                    break;
                }
                case 65582: {
                    this.enqueueListenerUpdate(65572);
                    break;
                }
                case 65583: {
                    this.enqueueListenerUpdate(65576);
                    this.enqueueListenerUpdate(65573);
                    break;
                }
                case 65584: {
                    this.enqueueListenerUpdate(65576);
                    this.enqueueListenerUpdate(65574);
                    break;
                }
                case 65585: {
                    this.enqueueListenerUpdate(65576);
                    this.enqueueListenerUpdate(65575);
                    break;
                }
                case 65586: {
                    this.enqueueListenerUpdate(65577);
                    break;
                }
                case 65587: {
                    this.enqueueListenerUpdate(65578);
                    break;
                }
                case 131073: {
                    this.enqueueListenerUpdate(131073);
                    break;
                }
                case 131074: {
                    this.emergencyNumbers = iTelDSIMobileEquipmentDeviceState.getTelEmerNums();
                    this.enqueueListenerUpdate(262145);
                    break;
                }
                case 131075: {
                    this.enqueueListenerUpdate(131074);
                    break;
                }
                case 131076: {
                    this.enqueueListenerUpdate(131075);
                    break;
                }
                case 131077: {
                    this.enqueueListenerUpdate(131076);
                    break;
                }
                case 131078: {
                    this.enqueueListenerUpdate(131077);
                    break;
                }
                case 131079: {
                    this.enqueueListenerUpdate(131078);
                    break;
                }
                case 131080: {
                    this.enqueueListenerUpdate(131079);
                    break;
                }
                case 131081: {
                    this.associatedCallState = iTelDSIMobileEquipmentDeviceState.getCallState();
                    this.setCallFocus();
                    this.enqueueListenerUpdate(131080);
                    if (iTelDSIMobileEquipmentDeviceState.getCallState() == null) break;
                    int n6 = this.getCallLeadingDevice() != null && this.getCallLeadingDevice().getCallState() != null ? this.getCallLeadingDevice().getCallState().getCallStateChoiceValue() : 0;
                    int n7 = this.getNonCallLeadingDevice() != null && this.getNonCallLeadingDevice().getCallState() != null ? this.getNonCallLeadingDevice().getCallState().getCallStateChoiceValue() : 0;
                    this.enqueueCallStateChoiceUpdate(iTelDSIMobileEquipmentDeviceState.getCallState().getCallStateChoiceValue(), 4196);
                    this.enqueueCallStateChoiceUpdate(n6, 4367);
                    this.enqueueCallStateChoiceUpdate(n7, 4395);
                    this.enqueueCallStateActiveUpdate(iTelDSIMobileEquipmentDeviceState.getCallState(), 300957);
                    break;
                }
                case 131082: {
                    this.enqueueListenerUpdate(131081);
                    break;
                }
                case 131083: {
                    this.enqueueListenerUpdate(131082);
                    break;
                }
                case 131084: {
                    this.enqueueListenerUpdate(131083);
                    break;
                }
                case 131085: {
                    this.enqueueListenerUpdate(131084);
                    break;
                }
                case 131086: {
                    this.enqueueListenerUpdate(131085);
                    break;
                }
                case 131087: {
                    this.enqueueListenerUpdate(131086);
                    break;
                }
                case 131088: {
                    this.enqueueListenerUpdate(131087);
                    break;
                }
                case 131089: {
                    this.enqueueListenerUpdate(131088);
                    break;
                }
                case 131090: {
                    this.enqueueListenerUpdate(131089);
                    break;
                }
                case 131091: {
                    this.nadTemp = iTelDSIMobileEquipmentDeviceState.getnADTemperature();
                    this.enqueueListenerUpdate(262146);
                    break;
                }
                case 131092: {
                    this.enqueueListenerUpdate(131090);
                    break;
                }
                case 131093: {
                    this.enqueueListenerUpdate(131091);
                    break;
                }
                case 131094: {
                    this.enqueueListenerUpdate(131092);
                    break;
                }
                case 131095: {
                    this.enqueueListenerUpdate(131093);
                    break;
                }
                case 131096: {
                    this.enqueueListenerUpdate(131094);
                    break;
                }
                case 131097: {
                    this.enqueueListenerUpdate(131095);
                    break;
                }
                case 131098: {
                    this.serviceNumbers = iTelDSIMobileEquipmentDeviceState.getServiceNumbers();
                    this.enqueueListenerUpdate(262155);
                    break;
                }
                case 131099: {
                    this.enqueueListenerUpdate(131097);
                    break;
                }
                case 131100: {
                    this.enqueueListenerUpdate(131098);
                    break;
                }
                case 131101: {
                    this.enqueueListenerUpdate(131099);
                    break;
                }
                case 131102: {
                    this.enqueueListenerUpdate(131100);
                    break;
                }
                case 131103: {
                    this.enqueueListenerUpdate(131101);
                    break;
                }
                case 131104: {
                    this.enqueueListenerUpdate(131102);
                    break;
                }
                case 131105: {
                    this.setNadMode(iTelDSIMobileEquipmentDeviceState.getNadMode());
                    this.enqueueListenerUpdate(262147);
                    break;
                }
                case 131106: {
                    this.enqueueListenerUpdate(131103);
                    break;
                }
                case 131107: {
                    break;
                }
                case 131108: {
                    this.enqueueListenerUpdate(131115);
                    break;
                }
                case 131109: {
                    break;
                }
                case 131110: {
                    this.enqueueListenerUpdate(131104);
                    break;
                }
                case 131111: {
                    this.enqueueListenerUpdate(131105);
                    break;
                }
                case 131112: {
                    break;
                }
                case 131113: {
                    this.enqueueListenerUpdate(131106);
                    break;
                }
                case 131114: {
                    this.eUICCID = iTelDSIMobileEquipmentDeviceState.geteUICCID();
                    this.enqueueListenerUpdate(262151);
                    break;
                }
                case 131115: {
                    this.eSIMMSISDN = iTelDSIMobileEquipmentDeviceState.geteSIMMSISDN();
                    this.enqueueListenerUpdate(262152);
                    break;
                }
                case 131116: {
                    this.eSIMActive = iTelDSIMobileEquipmentDeviceState.iseSIMActive();
                    this.enqueueListenerUpdate(262153);
                    break;
                }
                case 131117: {
                    this.eSIMB2BMode = iTelDSIMobileEquipmentDeviceState.iseSIMB2BModeActive();
                    this.enqueueListenerUpdate(262154);
                    break;
                }
                case 131118: {
                    this.enqueueListenerUpdate(131108);
                    break;
                }
                case 131119: {
                    this.enqueueListenerUpdate(131112);
                    this.enqueueListenerUpdate(131109);
                    break;
                }
                case 131120: {
                    this.enqueueListenerUpdate(131112);
                    this.enqueueListenerUpdate(131110);
                    break;
                }
                case 131121: {
                    this.enqueueListenerUpdate(131112);
                    this.enqueueListenerUpdate(131111);
                    break;
                }
                case 131122: {
                    this.enqueueListenerUpdate(131113);
                    break;
                }
                case 131123: {
                    this.enqueueListenerUpdate(131114);
                    break;
                }
                case 196609: {
                    this.enqueueListenerUpdate(196609);
                    break;
                }
                case 196610: {
                    this.emergencyNumbers = iTelDSIMobileEquipmentDeviceState.getTelEmerNums();
                    this.enqueueListenerUpdate(262145);
                    break;
                }
                case 196611: {
                    this.enqueueListenerUpdate(196610);
                    break;
                }
                case 196612: {
                    this.enqueueListenerUpdate(196611);
                    break;
                }
                case 196613: {
                    this.enqueueListenerUpdate(196612);
                    break;
                }
                case 196614: {
                    this.enqueueListenerUpdate(196613);
                    break;
                }
                case 196615: {
                    this.enqueueListenerUpdate(196614);
                    break;
                }
                case 196616: {
                    this.enqueueListenerUpdate(196615);
                    break;
                }
                case 196617: {
                    this.dataCallState = iTelDSIMobileEquipmentDeviceState.getCallState();
                    this.setCallFocus();
                    this.enqueueListenerUpdate(196616);
                    if (iTelDSIMobileEquipmentDeviceState.getCallState() == null) break;
                    int n8 = this.getCallLeadingDevice() != null && this.getCallLeadingDevice().getCallState() != null ? this.getCallLeadingDevice().getCallState().getCallStateChoiceValue() : 0;
                    this.enqueueCallStateChoiceUpdate(n8, 4367);
                    this.enqueueCallStateActiveUpdate(iTelDSIMobileEquipmentDeviceState.getCallState(), 301085);
                    this.enqueueCallStateChoiceUpdate(iTelDSIMobileEquipmentDeviceState.getCallState().getCallStateChoiceValue(), 4475);
                    break;
                }
                case 196618: {
                    this.enqueueListenerUpdate(196617);
                    break;
                }
                case 196619: {
                    this.enqueueListenerUpdate(196618);
                    break;
                }
                case 196620: {
                    this.enqueueListenerUpdate(196619);
                    break;
                }
                case 196621: {
                    this.enqueueListenerUpdate(196620);
                    break;
                }
                case 196622: {
                    this.enqueueListenerUpdate(196621);
                    break;
                }
                case 196623: {
                    this.enqueueListenerUpdate(196622);
                    break;
                }
                case 196624: {
                    this.enqueueListenerUpdate(196623);
                    break;
                }
                case 196625: {
                    this.enqueueListenerUpdate(196624);
                    break;
                }
                case 196626: {
                    this.enqueueListenerUpdate(196625);
                    break;
                }
                case 196627: {
                    this.nadTemp = iTelDSIMobileEquipmentDeviceState.getnADTemperature();
                    this.enqueueListenerUpdate(262146);
                    break;
                }
                case 196628: {
                    this.enqueueListenerUpdate(196626);
                    break;
                }
                case 196629: {
                    this.enqueueListenerUpdate(196627);
                    break;
                }
                case 196630: {
                    this.enqueueListenerUpdate(196628);
                    break;
                }
                case 196631: {
                    this.enqueueListenerUpdate(196629);
                    break;
                }
                case 196632: {
                    this.enqueueListenerUpdate(196630);
                    break;
                }
                case 196633: {
                    this.enqueueListenerUpdate(196631);
                    break;
                }
                case 196634: {
                    this.serviceNumbers = iTelDSIMobileEquipmentDeviceState.getServiceNumbers();
                    this.enqueueListenerUpdate(262155);
                    break;
                }
                case 196635: {
                    this.enqueueListenerUpdate(196633);
                    break;
                }
                case 196636: {
                    this.enqueueListenerUpdate(196634);
                    break;
                }
                case 196637: {
                    this.enqueueListenerUpdate(196635);
                    break;
                }
                case 196638: {
                    this.enqueueListenerUpdate(196636);
                    break;
                }
                case 196639: {
                    this.enqueueListenerUpdate(196637);
                    break;
                }
                case 196640: {
                    this.enqueueListenerUpdate(196638);
                    break;
                }
                case 196641: {
                    this.setNadMode(iTelDSIMobileEquipmentDeviceState.getNadMode());
                    this.enqueueListenerUpdate(262147);
                    break;
                }
                case 196642: {
                    this.enqueueListenerUpdate(196639);
                    break;
                }
                case 196643: {
                    break;
                }
                case 196644: {
                    this.enqueueListenerUpdate(196651);
                    break;
                }
                case 196645: {
                    break;
                }
                case 196646: {
                    this.enqueueListenerUpdate(196640);
                    break;
                }
                case 196647: {
                    this.enqueueListenerUpdate(196641);
                    break;
                }
                case 196648: {
                    break;
                }
                case 196649: {
                    this.enqueueListenerUpdate(196642);
                    break;
                }
                case 196650: {
                    this.eUICCID = iTelDSIMobileEquipmentDeviceState.geteUICCID();
                    this.enqueueListenerUpdate(262151);
                    break;
                }
                case 196651: {
                    this.eSIMMSISDN = iTelDSIMobileEquipmentDeviceState.geteSIMMSISDN();
                    this.enqueueListenerUpdate(262152);
                    break;
                }
                case 196652: {
                    this.eSIMActive = iTelDSIMobileEquipmentDeviceState.iseSIMActive();
                    this.enqueueListenerUpdate(262153);
                    break;
                }
                case 196653: {
                    this.eSIMB2BMode = iTelDSIMobileEquipmentDeviceState.iseSIMB2BModeActive();
                    this.enqueueListenerUpdate(262154);
                    break;
                }
                case 196654: {
                    this.enqueueListenerUpdate(196644);
                    break;
                }
                case 196655: {
                    this.enqueueListenerUpdate(196648);
                    this.enqueueListenerUpdate(196645);
                    break;
                }
                case 196656: {
                    this.enqueueListenerUpdate(196648);
                    this.enqueueListenerUpdate(196646);
                    break;
                }
                case 196657: {
                    this.enqueueListenerUpdate(196648);
                    this.enqueueListenerUpdate(196647);
                    break;
                }
                case 196658: {
                    this.enqueueListenerUpdate(196649);
                    break;
                }
                case 196659: {
                    this.enqueueListenerUpdate(196650);
                    break;
                }
                default: {
                    this.log.log(100000, "[GlobalTelephoneState#updateMEDevice] unhandled update attribute=%1, deviceRole=%2", (long)n, (long)n2);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEcallState(int n, IEcallState iEcallState) {
        this.log.log(1000000, "GlobalTelephoneState#updateEcallState(): attr %1,  ecallState %2", (Object)String.valueOf(n), (Object)iEcallState);
        Object object = this.stateMutex;
        synchronized (object) {
            int n2;
            this.setEcallState(iEcallState);
            if (iEcallState.isLowPrioritySOSEmergencyCallType()) {
                switch (iEcallState.getCall().getState()) {
                    case 3: {
                        n2 = 3;
                        break;
                    }
                    case 4: {
                        n2 = 4;
                        break;
                    }
                    case 2: {
                        n2 = 2;
                        break;
                    }
                    case 5: {
                        n2 = 5;
                        break;
                    }
                    default: {
                        n2 = 0;
                        break;
                    }
                }
            } else {
                n2 = 0;
            }
            this.enqueueCallStateChoiceUpdate(n2, 3848);
            this.enqueueCallStateChoiceUpdate(n2, 4196);
            this.enqueueCallStateChoiceUpdate(n2, 4475);
            this.enqueueCallStateChoiceUpdate(n2, 4367);
            this.enqueueCallStateChoiceUpdate(0, 4395);
            this.enqueueCallStateChoiceUpdate(n2 != 0 ? 1 : 0, 300957);
            this.enqueueCallStateChoiceUpdate(n2 != 0 ? 1 : 0, 301085);
            this.enqueueListenerUpdate(262156);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAcceptIncomingCallOnNonCallLeadingDevicePending(boolean bl) {
        this.log.log(1000000, "[GlobalTelephoneState#setAcceptIncomingCallOnNonCallLeadingDevicePending] %1", bl);
        Object object = this.stateMutex;
        synchronized (object) {
            this.acceptIncomingCallOnNonCallLeadingDevicePending = bl;
        }
    }

    boolean isNewSMSAvailable() {
        return this.newSMSAvailable;
    }

    void setNewSMSAvailable(boolean bl) {
        this.newSMSAvailable = bl;
    }

    boolean isNewEMailAvailable() {
        return this.newEMailAvailable;
    }

    void setNewEMailAvailable(boolean bl) {
        this.newEMailAvailable = bl;
    }

    boolean isRingtoneMuteSettingOn() {
        return this.ringtoneMuteSettingOn;
    }

    void setRingtoneMuteSettingOn(boolean bl) {
        this.ringtoneMuteSettingOn = bl;
    }

    boolean isRingtoneMuteActive() {
        return this.ringtoneMuteActive;
    }

    void setRingtoneMuteActive(boolean bl) {
        this.ringtoneMuteActive = bl;
    }

    public IEcallState getEcallState() {
        return this.ecallState;
    }

    void setEcallState(IEcallState iEcallState) {
        this.ecallState = iEcallState;
    }

    int getNadMode() {
        return this.nadMode;
    }

    void setNadMode(int n) {
        this.nadMode = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("############## Global Telephone State #################");
        buffer.append("\n");
        buffer.append("ecallState=");
        buffer.append(this.ecallState);
        buffer.append("\n");
        buffer.append("newSMSAvailable=");
        buffer.append(this.isNewSMSAvailable());
        buffer.append("\n");
        buffer.append("newEMailAvailable=");
        buffer.append(this.isNewEMailAvailable());
        buffer.append("\n");
        buffer.append("ringtoneMuteActive=");
        buffer.append(this.isRingtoneMuteActive());
        buffer.append("\n");
        buffer.append("ringtoneMuteSettingOn=");
        buffer.append(this.isRingtoneMuteSettingOn());
        buffer.append("\n");
        buffer.append("nadMode=");
        buffer.append(this.getNadMode());
        buffer.append("\n");
        buffer.append("nadUsage=");
        buffer.append(GlobalTelephoneState.getNadUsageName(this.getNadUsage()));
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("--------------- PRIMARY DEVICE ------------------------");
        buffer.append("\n");
        buffer.append(this.getPrimaryDevice());
        buffer.append("\n");
        buffer.append("--------------- SECONDARY DEVICE ----------------------");
        buffer.append("\n");
        buffer.append(this.getSecondaryDevice());
        buffer.append("\n");
        buffer.append("------------- DATA_ONLY_NAD DEVICE ---------------------");
        buffer.append("\n");
        buffer.append(this.getDataOnlyNadDevice());
        buffer.append("\n");
        buffer.append("------------- CALL LEADING DEVICE ---------------------");
        buffer.append("\n");
        buffer.append(this.getCallLeadingDevice());
        buffer.append("\n");
        buffer.append("#######################################################");
        return buffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelGlobalStateUpdateEvent
    extends AbstractTelEvent {
        private final int attribute;
        private final IGlobalTelephoneStateStruct update;

        public TelGlobalStateUpdateEvent(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
            super("TelGlobalStateUpdateEvent", GlobalTelephoneState.getAttributeName(n));
            this.attribute = n;
            this.update = iGlobalTelephoneStateStruct;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            LinkedList linkedList;
            GlobalTelephoneState.this.log.log(10000000, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] start update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
            Object object = GlobalTelephoneState.this.globalListeners;
            synchronized (object) {
                linkedList = (LinkedList)GlobalTelephoneState.this.globalListeners.clone();
            }
            object = linkedList.iterator();
            while (object.hasNext()) {
                try {
                    ((IGlobalTelephoneStateListener)object.next()).updateGlobalTelephoneStateProperty(this.attribute, this.update);
                }
                catch (Exception exception) {
                    GlobalTelephoneState.this.log.log(100000, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] exception occured during update of %1: \n%2", (Object)GlobalTelephoneState.getAttributeName(this.attribute), (Throwable)exception);
                }
            }
            Object object2 = GlobalTelephoneState.this.attributeToListenerMap;
            synchronized (object2) {
                LinkedList linkedList2 = (LinkedList)GlobalTelephoneState.this.attributeToListenerMap.get(new Integer(this.attribute));
                if (linkedList2 == null) {
                    GlobalTelephoneState.this.log.log(10000000, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] finished update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
                    return;
                }
                object = (LinkedList)linkedList2.clone();
            }
            object2 = object.iterator();
            while (object2.hasNext()) {
                try {
                    ((IGlobalTelephoneStateListener)object2.next()).updateGlobalTelephoneStateProperty(this.attribute, this.update);
                }
                catch (Exception exception) {
                    GlobalTelephoneState.this.log.log(100000, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] exception occured: ", (Throwable)exception);
                }
            }
            GlobalTelephoneState.this.log.log(10000000, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] finished update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
        }
    }

    private class TelGlobalStateDSIResponseListener
    extends TelDefaultDSIResponseListener {
        private TelGlobalStateDSIResponseListener() {
        }

        public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
            GlobalTelephoneState.this.enqueueListenerUpdate(65562);
        }
    }
}

