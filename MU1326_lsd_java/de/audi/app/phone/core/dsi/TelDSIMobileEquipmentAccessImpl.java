/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentTopologyAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.ITelephoneDSIAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelDSIMobileEquipmentAccessImpl
extends AbstractPhoneComponent
implements ITelephoneDSIAccess {
    private final ITelDSIMobileEquipmentTopologyAccess topologyAccess;
    private final boolean useLegacyDSITelephone;
    private ArrayList globalResponseListeners = new ArrayList();
    private volatile IGlobalTelephoneStateStruct telState;

    public TelDSIMobileEquipmentAccessImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.DSI");
        this.useLegacyDSITelephone = Boolean.getBoolean("useLegacyDSITelephone");
        if (this.useLegacyDSITelephone) {
            this.log.log(1000, "TelDSIMobileEquipmentAccessImpl#TelDSIMobileEquipmentAccessImpl: Legacy DSIs not supported anymore");
        }
        TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess = new TelDSIMobileEquipementTopologyAccess(iTelApplication);
        this.topologyAccess = telDSIMobileEquipementTopologyAccess;
        this.addSubPhoneComponent(telDSIMobileEquipementTopologyAccess);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.removeAllGlobalResponseListeners();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addGlobalDSIResponseListener(ITelDSIResponseListener iTelDSIResponseListener) {
        ArrayList arrayList = this.globalResponseListeners;
        synchronized (arrayList) {
            this.globalResponseListeners.add(iTelDSIResponseListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeGlobalDSIResponseListener(ITelDSIResponseListener iTelDSIResponseListener) {
        ArrayList arrayList = this.globalResponseListeners;
        synchronized (arrayList) {
            this.globalResponseListeners.remove(iTelDSIResponseListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeAllGlobalResponseListeners() {
        ArrayList arrayList = this.globalResponseListeners;
        synchronized (arrayList) {
            this.globalResponseListeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ITelDSIResponseListener[] getGlobalResponseListeners() {
        ArrayList arrayList = this.globalResponseListeners;
        synchronized (arrayList) {
            return (ITelDSIResponseListener[])this.globalResponseListeners.toArray(new ITelDSIResponseListener[this.globalResponseListeners.size()]);
        }
    }

    private ITelDSIMobileEquipmentDeviceAccess getCallLeadingDeviceAccess() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        if (this.telState == null) {
            this.log.log(10000, "TelDSIMobileEquipmentAccessImpl#getCallLeadingDeviceAccess telState is null");
            return null;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        return this.getDeviceAccess(iTelDSIMobileEquipmentDeviceState.getDeviceRole());
    }

    private ITelDSIMobileEquipmentDeviceAccess getNonCallLeadingDeviceAccess() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        if (this.telState == null) {
            this.log.log(10000, "TelDSIMobileEquipmentAccessImpl#getNonCallLeadingDeviceAccess telState is null");
            return null;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        return this.getDeviceAccess(iTelDSIMobileEquipmentDeviceState.getDeviceRole());
    }

    private ITelDSIMobileEquipmentDeviceAccess getDeviceAccess(int n) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.topologyAccess.getRoleDeviceAccess(n);
        return iTelDSIMobileEquipmentDeviceAccess != null ? iTelDSIMobileEquipmentDeviceAccess : this.topologyAccess.getNullDeviceAccess();
    }

    public void acceptCall(int n) {
        this.acceptCall(n, true, null);
    }

    public void acceptCall(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.acceptCall(TelDSIUtils.getAcceptMode(this.telState.getCallLeadingDevice()), this.getCallLeadingDeviceAccess(), n, bl, iTelDSIResponseListener);
    }

    public void acceptWaitingCallReplaceActiveCall(int n) {
        this.acceptWaitingCallReplaceActiveCall(n, true, null);
    }

    public void acceptWaitingCallReplaceActiveCall(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.acceptCall(1, this.getCallLeadingDeviceAccess(), n, bl, iTelDSIResponseListener);
    }

    public void acceptIncomingCallOnNonCallLeadingDevice(int n) {
        this.acceptIncomingCallOnNonCallLeadingDevice(n, true, null);
    }

    public void acceptIncomingCallOnNonCallLeadingDevice(int n, final boolean bl, final ITelDSIResponseListener iTelDSIResponseListener) {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        if (this.telState == null) {
            this.log.log(10000, "TelDSIMobileEquipmentAccessImpl#acceptIncomingCallOnNonCallLeadingDevice telState is null");
            return;
        }
        final ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        this.getApplication().getGlobalTelephoneStateManager().setAcceptIncomingCallOnNonCallLeadingDevicePending(true);
        this.getCallLeadingDeviceAccess().hangupCall(255, bl, n, new TelDefaultDSIResponseListener(){

            public void responseHangupCall(int n, int n2) {
                if (n == 0) {
                    TelDSIMobileEquipmentAccessImpl.this.log.log(1000000, "[TelDSIMobileEquipmentAccessImpl.acceptIncomingCallOnNonCallLeadingDevice(...).new TelDefaultDSIResponseListener() {...}#responseHangupCall] accepting call on %1", (Object)TelDSIUtils.getRoleName(iTelDSIMobileEquipmentDeviceState.getDeviceRole()));
                    TelDSIMobileEquipmentAccessImpl.this.getNonCallLeadingDeviceAccess().acceptCall(TelDSIUtils.getAcceptMode(iTelDSIMobileEquipmentDeviceState), bl, n2, new TelDefaultDSIResponseListener(){

                        public void responseAcceptCall(int n, int n2) {
                            TelDSIMobileEquipmentAccessImpl.this.getApplication().getGlobalTelephoneStateManager().setAcceptIncomingCallOnNonCallLeadingDevicePending(false);
                            if (iTelDSIResponseListener != null) {
                                iTelDSIResponseListener.responseAcceptCall(n, n2);
                            }
                        }
                    }, TelDSIMobileEquipmentAccessImpl.this.getGlobalResponseListeners());
                } else {
                    TelDSIMobileEquipmentAccessImpl.this.log.log(1000000, "[TelDSIMobileEquipmentAccessImpl#acceptCall] hanging up calls on call leading device not successfull. Not accepting call on non leading device.");
                }
                if (iTelDSIResponseListener != null) {
                    iTelDSIResponseListener.responseHangupCall(n, n2);
                }
            }
        }, this.getGlobalResponseListeners());
    }

    private void acceptCall(int n, ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.log.log(1000000, "[TelDSIMobileEquipmentAccessImpl#acceptCall] accepting call on %1", (Object)TelDSIUtils.getRoleName(iTelDSIMobileEquipmentDeviceAccess.getDeviceRole()));
        iTelDSIMobileEquipmentDeviceAccess.acceptCall(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void placeIncomingCallOnHold(int n) {
        this.placeIncomingCallOnHold(n, true, null);
    }

    public void placeIncomingCallOnHold(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.log.log(1000000, "[TelDSIMobileEquipmentAccessImpl#placeIncomingCallOnHold]");
        this.acceptCall(3, this.getCallLeadingDeviceAccess(), n, bl, iTelDSIResponseListener);
    }

    public void rejectIncomingCallOnNonCallLeadingDevice(int n) {
        this.rejectIncomingCallOnNonCallLeadingDevice(n, true, null);
    }

    public void rejectIncomingCallOnNonCallLeadingDevice(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        AbstractPhoneCall abstractPhoneCall;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        AbstractPhoneCall abstractPhoneCall2 = abstractPhoneCall = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? iTelDSIMobileEquipmentDeviceState.getCallState().getIncomingCall() : null;
        if (abstractPhoneCall != null) {
            this.getNonCallLeadingDeviceAccess().hangupCall(abstractPhoneCall.getTelCallID(), bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentAccessImpl#rejectIncomingCallOnNonCallLeadingDevice] incoming call is null --> NOP!");
        }
    }

    public void dialChinaSOSNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.getApplication().getFrameworkAccess().isCn() ? this.getNadDeviceAccess() : this.getPrimaryDeviceAccess();
        iTelDSIMobileEquipmentDeviceAccess.dialSOSNumber(string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void dialNumber(String string, int n) {
        this.dialNumber(string, n, true, null);
    }

    public void dialNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().dialNumber(string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3) {
        this.dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, n3, true, null);
    }

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, bl, n3, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n) {
        this.dialNumberFromCallStackEntry(callStackEntry, n, true, null);
    }

    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        if (callStackEntry != null) {
            if (callStackEntry.getAdbEntryID() > 0L) {
                this.dialNumberFromDBEntry(callStackEntry.getClNumber(), callStackEntry.getAdbEntryID(), callStackEntry.getClName(), (short)callStackEntry.getAdbNumberType(), (short)0, callStackEntry.getAdbPictureID(), callStackEntry.getAdbPhoneDataIndex(), callStackEntry.getAdbPhoneDataCount(), n, true, iTelDSIResponseListener);
            } else {
                this.dialNumber(callStackEntry.getClNumber(), n, true, iTelDSIResponseListener);
            }
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentAccessImpl#dialNumberFromCallStackEntry] callStackEntry is null --> NOP!");
        }
    }

    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2) {
        this.dialNumberFromADBEntry(adbEntry, n, n2, true, this.getApplication().getDefaultListener());
    }

    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        if (adbEntry != null) {
            PhoneData[] phoneDataArray = adbEntry.getPhoneData();
            if (phoneDataArray != null && n < phoneDataArray.length) {
                this.dialNumberFromDBEntry(phoneDataArray[n].getNumber(), adbEntry.getEntryId(), adbEntry.getCombinedName(), (short)phoneDataArray[n].getNumberType(), (short)adbEntry.getEntryType(), adbEntry.getPersonalData().getContactPicture(), n, adbEntry.getPhoneData().length, n2, true, iTelDSIResponseListener);
            } else {
                this.log.log(100000, "[AbstractTelephoneDSIAccess#dialNumberFromADBEntry] no number to dial --> NOP!: %1", (Object)adbEntry);
            }
        } else {
            this.log.log(100000, "[AbstractTelephoneDSIAccess#dialNumberFromADBEntry] adbEntry is null --> NOP!");
        }
    }

    public void hangupCall(int n, int n2) {
        this.hangupCall(n, n2, true, null);
    }

    public void hangupCall(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.hangupCall(this.getCallLeadingDeviceAccess(), n, n2, bl, iTelDSIResponseListener);
    }

    public void hangupCall(int n, int n2, int n3, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.hangupCall(this.getDeviceAccess(n), n2, n3, bl, iTelDSIResponseListener);
    }

    private void hangupCall(ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess, int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        iTelDSIMobileEquipmentDeviceAccess.hangupCall(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void splitCall(int n, int n2) {
        this.splitCall(n, n2, true, null);
    }

    public void splitCall(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().splitCall((short)n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void splitCall(int n, int n2, int n3, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().splitCall((short)n2, bl, n3, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void unlockSIMWithPIN(String string, int n) {
        this.unlockSIMWithPIN(string, n, true, null);
    }

    public void unlockSIMWithPIN(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.requestUnlockSIM(0, string, "", iTelDSIResponseListener, bl, n);
    }

    public void unlockSIMWithPUK(String string, String string2, int n) {
        this.unlockSIMWithPUK(string, string2, n, true, null);
    }

    public void unlockSIMWithPUK(String string, String string2, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.requestUnlockSIM(2, string, string2, iTelDSIResponseListener, bl, n);
    }

    public void setAutomaticPINEntryActive(boolean bl, int n) {
        this.setAutomaticPINEntryActive(bl, n, true, null);
    }

    public void setAutomaticPINEntryActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestSetAutomaticPinEntryActive(bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void swapCalls(int n) {
        this.swapCalls(n, true, null);
    }

    public void swapCalls(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().swapCalls(bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void joinCallsToConference(int n) {
        this.joinCallsToConference(n, true, null);
    }

    public void joinCallsToConference(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().joinCalls(bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void sendDTMF(String string, int n) {
        this.sendDTMF(string, n, true, null);
    }

    public void sendDTMF(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().sendDTMF(string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetOptimizationMode(int n, int n2) {
        this.requestSetOptimizationMode(n, n2, true, null);
    }

    public void requestSetOptimizationMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetOptimizationMode(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void restoreFactorySettings(int n) {
        this.restoreFactorySettings(n, true, null);
    }

    public void restoreFactorySettings(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.topologyAccess.restoreFactorySettings(bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSIMPINRequired(String string, boolean bl, int n) {
        this.requestSIMPINRequired(string, bl, n, true, null);
    }

    public void requestSIMPINRequired(String string, boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestSIMPINRequired(string, bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetLanguage(String string, int n) {
        this.requestSetLanguage(string, n, true, null);
    }

    public void requestSetLanguage(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.topologyAccess.requestSetLanguage(string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetMICMuteState(int n, int n2) {
        this.requestSetMICMuteState(n, n2, true, null);
    }

    public void requestSetMICMuteState(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().requestSetMICMuteState(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetHandsFreeMode(int n, int n2) {
        this.requestSetHandsFreeMode(n, n2, true, null);
    }

    public void requestSetHandsFreeMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().requestSetHandsFreeMode(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetHandsFreeModeNonCallLeadingDevice(int n, int n2) {
        this.requestSetHandsFreeModeNonCallLeadingDevice(n, n2, true, null);
    }

    public void requestSetHandsFreeModeNonCallLeadingDevice(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNonCallLeadingDeviceAccess().requestSetHandsFreeMode(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetHandsFreeModeCallLeadingDevice(int n, int n2) {
        this.requestSetHandsFreeModeCallLeadingDevice(n, n2, true, null);
    }

    public void requestSetHandsFreeModeCallLeadingDevice(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getCallLeadingDeviceAccess().requestSetHandsFreeMode(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetMailboxNumber(String string, int n) {
        this.requestSetMailboxNumber(string, n, true, null);
    }

    public void requestSetMailboxNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetMailboxContent(string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestTelPower(int n, int n2) {
        this.requestTelPower(n, n2, true, null);
    }

    public void requestTelPower(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestTelPower(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetNadMode(int n, int n2) {
        this.requestSetNadMode(n, n2, true, null);
    }

    public void requestSetNadMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.topologyAccess.requestSetNADMode(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestNetworkRegistration(String string, int n, int n2) {
        this.requestNetworkRegistration(string, n, n2, true, null);
    }

    public void requestNetworkRegistration(String string, int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestNetworkRegistration(string, n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestAbortNetworkRegistration() {
        this.getNadDeviceAccess().requestAbortNetworkRegistration();
    }

    public void requestNetworkSearch(int n) {
        this.requestNetworkSearch(n, true, null);
    }

    public void requestNetworkSearch(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestNetworkSearch(bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestAbortNetworkSearch() {
        this.getNadDeviceAccess().requestAbortNetworkSearch();
    }

    public void requestCallForward(CFRequestData[] cFRequestDataArray, int n) {
        this.requestCallForward(cFRequestDataArray, n, true, null);
    }

    public void requestCallForward(CFRequestData[] cFRequestDataArray, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestCallForward(cFRequestDataArray, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void abortCallForwardRequest() {
        this.getNadDeviceAccess().abortCallForwardRequest();
    }

    public void requestCallWaiting(int n, int n2) {
        this.requestCallWaiting(n, n2, true, null);
    }

    public void requestCallWaiting(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestCallWaiting(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void abortCallWaitingRequest() {
        this.getNadDeviceAccess().abortCallWaitingRequest();
    }

    public void requestCLIR(int n, int n2) {
        this.requestCLIR(n, n2, true, null);
    }

    public void requestCLIR(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestCLIR(n, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetCDMAThreeWayCallingSetting(boolean bl, int n) {
        this.requestSetCDMAThreeWayCallingSetting(bl, n, true, null);
    }

    public void requestSetCDMAThreeWayCallingSetting(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetCDMAThreeWayCallingSetting(bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetAutomaticEmergencyCallActive(boolean bl, int n) {
        this.requestSetAutomaticEmergencyCallActive(bl, n, true, null);
    }

    public void requestSetAutomaticEmergencyCallActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetAutomaticEmergencyCallActive(bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestChangeSIMCode(String string, String string2, int n) {
        this.requestChangeSIMCode(string, string2, n, true, null);
    }

    public void requestChangeSIMCode(String string, String string2, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getNadDeviceAccess().requestChangeSIMCode(0, string, string2, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void dialOperator(String string, int n, int n2) {
        this.dialOperator(string, n2, true, n, null);
    }

    public void dialOperator(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.getApplication().getFrameworkAccess().isCn() ? this.getNadDeviceAccess() : this.getPrimaryDeviceAccess();
        iTelDSIMobileEquipmentDeviceAccess.dialOperator(n2, string, bl, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void abortCallerIDRequest() {
        this.getNadDeviceAccess().abortCallerIDRequest();
    }

    public void requestSetPhoneRingtone(int n, String string, int n2) {
        this.requestSetPhoneRingtone(n, string, n2, true, null);
    }

    public void requestSetPhoneRingtone(int n, String string, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetPhoneRingtone(n, string, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetMicGainLevel(int n, int n2) {
        this.getCallLeadingDeviceAccess().requestSetMicGainLevel(n, true, n2, null, this.getGlobalResponseListeners());
    }

    public void requestIncreaseMicGainLevel(short s, int n) {
        this.getCallLeadingDeviceAccess().requestIncreaseMicGainLevel(s, true, n, null, this.getGlobalResponseListeners());
    }

    public void requestDecreaseMicGainLevel(short s, int n) {
        this.getCallLeadingDeviceAccess().requestDecreaseMicGainLevel(s, true, n, null, this.getGlobalResponseListeners());
    }

    public void requestSetESIMActive(boolean bl, int n) {
        this.requestSetESIMActive(bl, n, true, null);
    }

    public void requestSetESIMActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetESIMActive(bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void deleteAllCallStacks(int n, int n2) {
        this.getPrimaryDeviceAccess().deleteCallstacksAll(n, true, n2, null, this.getGlobalResponseListeners());
    }

    public void deleteCallStackEntry(int n, int n2, int n3) {
        this.getPrimaryDeviceAccess().deleteCallstacksEntry(n, n2, true, n3, null, this.getGlobalResponseListeners());
    }

    public void resetMissedCallIndicator(int n) {
        this.getPrimaryDeviceAccess().resetMissedCallIndicator(true, n, null, this.getGlobalResponseListeners());
    }

    public void revertCallstacks(boolean bl, int n) {
        this.getPrimaryDeviceAccess().revertCallstacks(bl, true, n, null, this.getGlobalResponseListeners());
    }

    public void requestSetPhoneReminderSetting(boolean bl, int n) {
        this.requestSetPhoneReminderSetting(bl, n, true, null);
    }

    public void requestSetPhoneReminderSetting(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.getPrimaryDeviceAccess().requestSetPhoneReminderSetting(bl, bl2, n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void togglePhones(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.topologyAccess.togglePhones(n, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetNadRole(int n, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        this.topologyAccess.requestSetNadRole(n, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetAutomaticRedialActive(boolean bl, int n, int n2) {
        this.requestSetAutomaticRedialActive(bl, n, null, n2);
    }

    public void requestSetAutomaticRedialActive(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, int n2) {
        this.requestSetAutomaticRedialActive(bl, n, iTelDSIResponseListener, true, n2);
    }

    public void requestSetAutomaticRedialActive(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, boolean bl2, int n2) {
        this.getNadDeviceAccess().requestSetAutomaticRedialActive(bl, bl2, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetEnhancedPrivacyMode(boolean bl, int n, int n2) {
        this.requestSetEnhancedPrivacyMode(bl, n, null, n2);
    }

    public void requestSetEnhancedPrivacyMode(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, int n2) {
        this.requestSetEnhancedPrivacyMode(bl, n, iTelDSIResponseListener, true, n2);
    }

    public void requestSetEnhancedPrivacyMode(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, boolean bl2, int n2) {
        this.getPrimaryDeviceAccess().requestSetEnhancedPrivacyMode(bl, bl2, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    public void requestSetPrivacyMode(boolean bl, int n, int n2) {
        this.requestSetPrivacyMode(bl, n, null, n2);
    }

    public void requestSetPrivacyMode(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, int n2) {
        this.requestSetPrivacyMode(bl, n, iTelDSIResponseListener, true, n2);
    }

    public void requestSetPrivacyMode(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, boolean bl2, int n2) {
        this.getPrimaryDeviceAccess().requestSetPrivacyMode(bl, bl2, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    private void requestUnlockSIM(int n, String string, String string2, ITelDSIResponseListener iTelDSIResponseListener, boolean bl, int n2) {
        this.getNadDeviceAccess().requestUnlockSIM(n, string, string2, bl, n2, iTelDSIResponseListener, this.getGlobalResponseListeners());
    }

    private ITelDSIMobileEquipmentDeviceAccess getNadDeviceAccess() {
        return this.topologyAccess.getNADInstance();
    }

    private ITelDSIMobileEquipmentDeviceAccess getPrimaryDeviceAccess() {
        return this.topologyAccess.getPrimaryTelephoneAccess();
    }
}

