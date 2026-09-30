/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.interapp.combi.bap.phone.data.CallStartTime;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallInfo;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallState;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformation;

public class TelBAPCall {
    public static final int STARTING_TIME_INVALID = -1;
    private static final int CALL_OPTION_ACCEPT_CALL = 1;
    private static final int CALL_OPTION_MP_CALL_HOLD_ACCEPT_WAITING_CALL = 2;
    private static final int CALL_OPTION_MP_RELEASE_ACTIVE_CALL_ACCEPT_WAITING_CALL = 4;
    private static final int CALL_OPTION_CALL_HOLD = 8;
    private static final int CALL_OPTION_RESUME_CALL = 16;
    private static final int CALL_OPTION_MP_SWAP = 32;
    private static final int CALL_OPTION_CC_JOIN = 64;
    private static final int CALL_OPTION_CC_SPLIT = 128;
    private final CallInformation phoneCall;
    private final CombiBAPCallState callState;
    private final CombiBAPCallInfo callInfo;
    private final CallStartTime callStartTime;
    private final boolean callLeading;
    private final int deviceRole;

    private static int getBapCategory(int n) {
        return CombiADBUtils.getCombiPhoneType(n);
    }

    private static int getCallState(int n) {
        switch (n) {
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 1: 
            case 2: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 8: {
                return 8;
            }
        }
        return 0;
    }

    static int getCallType(int n, int n2) {
        switch (n) {
            case 0: 
            case 8: 
            case 9: {
                return n2 == 0 ? 1 : 5;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 6: {
                return 7;
            }
            case 5: {
                return 6;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    private static int getCallOptions(CallInformation callInformation, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl) {
        int n = 0;
        if (callInformation != null && iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            CallStateStruct callStateStruct = iTelDSIMobileEquipmentDeviceState.getCallState();
            boolean bl2 = iTelDSIMobileEquipmentDeviceState.isMultipartySupported();
            boolean bl3 = iTelDSIMobileEquipmentDeviceState.isAddToConferenceSupported();
            boolean bl4 = callStateStruct.isMultipartyActive();
            boolean bl5 = callInformation.telMpty == 1;
            boolean bl6 = bl5 && bl2 && iTelDSIMobileEquipmentDeviceState.isEnhancedCallFeaturesSupported();
            boolean bl7 = (callStateStruct.getMpCallState() == 15 || callStateStruct.getMpCallState() == 27) && iTelDSIMobileEquipmentDeviceState.isResponseAndHoldSupported();
            int n2 = callInformation.getTelCallState();
            switch (n2) {
                case 4: {
                    n = TelBAPCall.computeCallOptionsActive(callStateStruct, bl2, bl3, bl4, bl6);
                    break;
                }
                case 1: 
                case 2: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: 
                case 8: {
                    n = TelBAPCall.computeCallOptionsHold(callStateStruct, bl2, bl3, bl4);
                    break;
                }
                case 3: {
                    n = TelBAPCall.computeCallOptionsRinging(bl, callStateStruct, bl2, bl4, bl7);
                    break;
                }
            }
        }
        return n;
    }

    private static int computeCallOptionsRinging(boolean bl, CallStateStruct callStateStruct, boolean bl2, boolean bl3, boolean bl4) {
        int n = 0;
        if (bl3 || !bl) {
            n = 4;
        } else if (bl2) {
            if (callStateStruct.isHasActiveCall()) {
                n = 2;
            } else {
                n = 1;
                if (bl4) {
                    n |= 8;
                }
            }
        } else if (callStateStruct.isHasActiveCall() || callStateStruct.isHasOnHoldCall()) {
            n = 4;
        } else {
            n = 1;
            if (bl4) {
                n |= 8;
            }
        }
        return n;
    }

    private static int computeCallOptionsHold(CallStateStruct callStateStruct, boolean bl, boolean bl2, boolean bl3) {
        int n;
        if (callStateStruct.isHasIncomingCall()) {
            n = 0;
        } else if (bl && bl3) {
            n = 32;
            n |= bl2 ? 64 : 0;
        } else {
            n = 16;
        }
        return n;
    }

    private static int computeCallOptionsActive(CallStateStruct callStateStruct, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n = 0;
        if (bl && !callStateStruct.isHasIncomingCall() && !callStateStruct.isHasOutgoingCall()) {
            if (bl3) {
                n = 32;
                if (bl2) {
                    n |= 0x40;
                }
            } else {
                n = 8;
            }
            if (bl4) {
                n |= 0x80;
            }
        }
        return n;
    }

    private static CombiBAPCallState getCombiCallState(CallInformation callInformation, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl) {
        if (callInformation != null && iTelDSIMobileEquipmentDeviceState != null) {
            int n = callInformation.getTelMpty();
            int n2 = callInformation.getTelCallState();
            int n3 = callInformation.getTelCallType();
            CombiBAPCallState combiBAPCallState = new CombiBAPCallState(TelBAPCall.getCallState(n2), TelBAPCall.getCallType(n3, n), n);
            combiBAPCallState.setCallOptions(TelBAPCall.getCallOptions(callInformation, iTelDSIMobileEquipmentDeviceState, bl));
            return combiBAPCallState;
        }
        return null;
    }

    private static CombiBAPCallInfo getCombiCallInfo(CallInformation callInformation, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        if (callInformation != null && iTelDSIMobileEquipmentDeviceState != null) {
            ResourceLocator resourceLocator = callInformation.getTelRemPictureId();
            int n = callInformation.getTelMpty();
            int n2 = callInformation.getTelCallType();
            CombiBAPCallInfo combiBAPCallInfo = null;
            combiBAPCallInfo = PhoneUtils.isPictureAvailable(resourceLocator) ? new CombiBAPCallInfo(TelBAPCall.getDisplayName(callInformation, iTelDSIMobileEquipmentDeviceState, iTelTextFactory), callInformation.getTelRemNumber(), TelBAPCall.getCallType(n2, n), TelBAPCall.getBapCategory(callInformation.getTelRemNumberType()), resourceLocator.getUrl(), resourceLocator.getId()) : new CombiBAPCallInfo(TelBAPCall.getDisplayName(callInformation, iTelDSIMobileEquipmentDeviceState, iTelTextFactory), callInformation.getTelRemNumber(), TelBAPCall.getCallType(n2, n), TelBAPCall.getBapCategory(callInformation.getTelRemNumberType()));
            return combiBAPCallInfo;
        }
        return null;
    }

    private static String getDisplayName(CallInformation callInformation, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        if (callInformation != null) {
            int n = callInformation.getTelCallType();
            switch (n) {
                case 196608: {
                    return iTelTextFactory.getText(7);
                }
                case 65536: {
                    return iTelTextFactory.getText(5);
                }
                case 131072: {
                    return iTelTextFactory.getText(6);
                }
            }
            String string = callInformation.getTelRemName();
            String string2 = callInformation.getTelRemNumber();
            if (iTelDSIMobileEquipmentDeviceState.isMailboxNumber(string2)) {
                return iTelTextFactory.getText(0);
            }
            if (string != null && string.length() > 0 && !string.equals(string2)) {
                return string;
            }
            return "";
        }
        return "";
    }

    public TelBAPCall(CallInformation callInformation, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl, ITelTextFactory iTelTextFactory) {
        this.phoneCall = callInformation;
        this.callLeading = bl;
        this.deviceRole = iTelDSIMobileEquipmentDeviceState.getDeviceRole();
        this.callState = TelBAPCall.getCombiCallState(callInformation, iTelDSIMobileEquipmentDeviceState, bl);
        this.callInfo = TelBAPCall.getCombiCallInfo(callInformation, iTelDSIMobileEquipmentDeviceState, iTelTextFactory);
        int n = callInformation.getTelCallStartingTime();
        this.callStartTime = n != -1 ? new CallStartTime(n) : new CallStartTime(65535);
    }

    public int getDeviceRole() {
        return this.deviceRole;
    }

    public CombiBAPCallState getCallState() {
        return this.callState;
    }

    public CombiBAPCallInfo getCallInfo() {
        return this.callInfo;
    }

    public CallStartTime getCallStartTime() {
        return this.callStartTime;
    }

    public int getCallID() {
        return this.phoneCall.getTelCallID();
    }

    public CallInformation getPhoneCall() {
        return this.phoneCall;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelBAPCall: ");
        buffer.append("\n\t");
        buffer.append(this.phoneCall);
        buffer.append("\n\t");
        buffer.append(this.callState);
        buffer.append("\n\t");
        buffer.append(this.callInfo);
        buffer.append("\n\t");
        buffer.append(this.callStartTime);
        buffer.append("\n\t");
        buffer.append("callLeading=");
        buffer.append(this.callLeading);
        return buffer.toString();
    }
}

