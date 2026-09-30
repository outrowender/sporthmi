/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status
implements StatusProperty {
    public int callState0;
    private static final int CALL_STATE0_BITSIZE = 4;
    public static final int CALL_STATE0_IDLE = 0;
    public static final int CALL_STATE0_RINGING_WAITING = 1;
    public static final int CALL_STATE0_ACTIVE = 2;
    public static final int CALL_STATE0_DIALING = 3;
    public static final int CALL_STATE0_DISCONNECTING = 4;
    public static final int CALL_STATE0_ON_HOLD = 5;
    public static final int CALL_STATE0_CONNECTED_CIB = 6;
    public static final int CALL_STATE0_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE0_INCOMING_ON_HOLD = 8;
    public int callType0;
    private static final int CALL_TYPE0_BITSIZE = 4;
    public static final int CALL_TYPE0_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE0_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE0_DATA_CALL = 2;
    public static final int CALL_TYPE0_FAX_CALL = 3;
    public static final int CALL_TYPE0_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE0_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE0_INFO_CALL = 6;
    public static final int CALL_TYPE0_SERVICE_CALL = 7;
    public static final int CALL_TYPE0_ACN_EMERGENCY_CALL = 8;
    public final CallOptions0 callOptions0 = new CallOptions0();
    public int callState1;
    private static final int CALL_STATE1_BITSIZE = 4;
    public static final int CALL_STATE1_IDLE = 0;
    public static final int CALL_STATE1_RINGING_WAITING = 1;
    public static final int CALL_STATE1_ACTIVE = 2;
    public static final int CALL_STATE1_DIALING = 3;
    public static final int CALL_STATE1_DISCONNECTING = 4;
    public static final int CALL_STATE1_ON_HOLD = 5;
    public static final int CALL_STATE1_CONNECTED_CIB = 6;
    public static final int CALL_STATE1_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE1_INCOMING_ON_HOLD = 8;
    public int callType1;
    private static final int CALL_TYPE1_BITSIZE = 4;
    public static final int CALL_TYPE1_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE1_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE1_DATA_CALL = 2;
    public static final int CALL_TYPE1_FAX_CALL = 3;
    public static final int CALL_TYPE1_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE1_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE1_INFO_CALL = 6;
    public static final int CALL_TYPE1_SERVICE_CALL = 7;
    public static final int CALL_TYPE1_ACN_EMERGENCY_CALL = 8;
    public final CallOptions1 callOptions1 = new CallOptions1();
    public int callState2;
    private static final int CALL_STATE2_BITSIZE = 4;
    public static final int CALL_STATE2_IDLE = 0;
    public static final int CALL_STATE2_RINGING_WAITING = 1;
    public static final int CALL_STATE2_ACTIVE = 2;
    public static final int CALL_STATE2_DIALING = 3;
    public static final int CALL_STATE2_DISCONNECTING = 4;
    public static final int CALL_STATE2_ON_HOLD = 5;
    public static final int CALL_STATE2_CONNECTED_CIB = 6;
    public static final int CALL_STATE2_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE2_INCOMING_ON_HOLD = 8;
    public int callType2;
    private static final int CALL_TYPE2_BITSIZE = 4;
    public static final int CALL_TYPE2_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE2_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE2_DATA_CALL = 2;
    public static final int CALL_TYPE2_FAX_CALL = 3;
    public static final int CALL_TYPE2_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE2_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE2_INFO_CALL = 6;
    public static final int CALL_TYPE2_SERVICE_CALL = 7;
    public static final int CALL_TYPE2_ACN_EMERGENCY_CALL = 8;
    public final CallOptions2 callOptions2 = new CallOptions2();
    public int callState3;
    private static final int CALL_STATE3_BITSIZE = 4;
    public static final int CALL_STATE3_IDLE = 0;
    public static final int CALL_STATE3_RINGING_WAITING = 1;
    public static final int CALL_STATE3_ACTIVE = 2;
    public static final int CALL_STATE3_DIALING = 3;
    public static final int CALL_STATE3_DISCONNECTING = 4;
    public static final int CALL_STATE3_ON_HOLD = 5;
    public static final int CALL_STATE3_CONNECTED_CIB = 6;
    public static final int CALL_STATE3_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE3_INCOMING_ON_HOLD = 8;
    public int callType3;
    private static final int CALL_TYPE3_BITSIZE = 4;
    public static final int CALL_TYPE3_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE3_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE3_DATA_CALL = 2;
    public static final int CALL_TYPE3_FAX_CALL = 3;
    public static final int CALL_TYPE3_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE3_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE3_INFO_CALL = 6;
    public static final int CALL_TYPE3_SERVICE_CALL = 7;
    public static final int CALL_TYPE3_ACN_EMERGENCY_CALL = 8;
    public final CallOptions3 callOptions3 = new CallOptions3();
    public int callState4;
    private static final int CALL_STATE4_BITSIZE = 4;
    public static final int CALL_STATE4_IDLE = 0;
    public static final int CALL_STATE4_RINGING_WAITING = 1;
    public static final int CALL_STATE4_ACTIVE = 2;
    public static final int CALL_STATE4_DIALING = 3;
    public static final int CALL_STATE4_DISCONNECTING = 4;
    public static final int CALL_STATE4_ON_HOLD = 5;
    public static final int CALL_STATE4_CONNECTED_CIB = 6;
    public static final int CALL_STATE4_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE4_INCOMING_ON_HOLD = 8;
    public int callType4;
    private static final int CALL_TYPE4_BITSIZE = 4;
    public static final int CALL_TYPE4_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE4_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE4_DATA_CALL = 2;
    public static final int CALL_TYPE4_FAX_CALL = 3;
    public static final int CALL_TYPE4_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE4_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE4_INFO_CALL = 6;
    public static final int CALL_TYPE4_SERVICE_CALL = 7;
    public static final int CALL_TYPE4_ACN_EMERGENCY_CALL = 8;
    public final CallOptions4 callOptions4 = new CallOptions4();
    public int callState5;
    private static final int CALL_STATE5_BITSIZE = 4;
    public static final int CALL_STATE5_IDLE = 0;
    public static final int CALL_STATE5_RINGING_WAITING = 1;
    public static final int CALL_STATE5_ACTIVE = 2;
    public static final int CALL_STATE5_DIALING = 3;
    public static final int CALL_STATE5_DISCONNECTING = 4;
    public static final int CALL_STATE5_ON_HOLD = 5;
    public static final int CALL_STATE5_CONNECTED_CIB = 6;
    public static final int CALL_STATE5_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE5_INCOMING_ON_HOLD = 8;
    public int callType5;
    private static final int CALL_TYPE5_BITSIZE = 4;
    public static final int CALL_TYPE5_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE5_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE5_DATA_CALL = 2;
    public static final int CALL_TYPE5_FAX_CALL = 3;
    public static final int CALL_TYPE5_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE5_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE5_INFO_CALL = 6;
    public static final int CALL_TYPE5_SERVICE_CALL = 7;
    public static final int CALL_TYPE5_ACN_EMERGENCY_CALL = 8;
    public final CallOptions5 callOptions5 = new CallOptions5();
    public int callState6;
    private static final int CALL_STATE6_BITSIZE = 4;
    public static final int CALL_STATE6_IDLE = 0;
    public static final int CALL_STATE6_RINGING_WAITING = 1;
    public static final int CALL_STATE6_ACTIVE = 2;
    public static final int CALL_STATE6_DIALING = 3;
    public static final int CALL_STATE6_DISCONNECTING = 4;
    public static final int CALL_STATE6_ON_HOLD = 5;
    public static final int CALL_STATE6_CONNECTED_CIB = 6;
    public static final int CALL_STATE6_REMOTE_SIDE_BUSY = 7;
    public static final int CALL_STATE6_INCOMING_ON_HOLD = 8;
    public int callType6;
    private static final int CALL_TYPE6_BITSIZE = 4;
    public static final int CALL_TYPE6_UNKNOWN_CALL_TYPE = 0;
    public static final int CALL_TYPE6_SINGLE_VOICE_CALL = 1;
    public static final int CALL_TYPE6_DATA_CALL = 2;
    public static final int CALL_TYPE6_FAX_CALL = 3;
    public static final int CALL_TYPE6_EMERGENCY_CALL = 4;
    public static final int CALL_TYPE6_CONFERENCE_VOICE_CALL = 5;
    public static final int CALL_TYPE6_INFO_CALL = 6;
    public static final int CALL_TYPE6_SERVICE_CALL = 7;
    public static final int CALL_TYPE6_ACN_EMERGENCY_CALL = 8;
    public final CallOptions6 callOptions6 = new CallOptions6();
    public final CallIncomingDiverted callIncomingDiverted = new CallIncomingDiverted();
    public final CallOutgoingDiverted_eCallConfirmationPending callOutgoingDiverted_eCallConfirmationPending = new CallOutgoingDiverted_eCallConfirmationPending();

    public CallState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callState0 = 0;
        this.callType0 = 0;
        this.callState1 = 0;
        this.callType1 = 0;
        this.callState2 = 0;
        this.callType2 = 0;
        this.callState3 = 0;
        this.callType3 = 0;
        this.callState4 = 0;
        this.callType4 = 0;
        this.callState5 = 0;
        this.callType5 = 0;
        this.callState6 = 0;
        this.callType6 = 0;
    }

    public void reset() {
        this.internalReset();
        this.callOptions0.reset();
        this.callOptions1.reset();
        this.callOptions2.reset();
        this.callOptions3.reset();
        this.callOptions4.reset();
        this.callOptions5.reset();
        this.callOptions6.reset();
        this.callIncomingDiverted.reset();
        this.callOutgoingDiverted_eCallConfirmationPending.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status callState_Status = (CallState_Status)bAPEntity;
        return this.callState0 == callState_Status.callState0 && this.callType0 == callState_Status.callType0 && this.callOptions0.equalTo(callState_Status.callOptions0) && this.callState1 == callState_Status.callState1 && this.callType1 == callState_Status.callType1 && this.callOptions1.equalTo(callState_Status.callOptions1) && this.callState2 == callState_Status.callState2 && this.callType2 == callState_Status.callType2 && this.callOptions2.equalTo(callState_Status.callOptions2) && this.callState3 == callState_Status.callState3 && this.callType3 == callState_Status.callType3 && this.callOptions3.equalTo(callState_Status.callOptions3) && this.callState4 == callState_Status.callState4 && this.callType4 == callState_Status.callType4 && this.callOptions4.equalTo(callState_Status.callOptions4) && this.callState5 == callState_Status.callState5 && this.callType5 == callState_Status.callType5 && this.callOptions5.equalTo(callState_Status.callOptions5) && this.callState6 == callState_Status.callState6 && this.callType6 == callState_Status.callType6 && this.callOptions6.equalTo(callState_Status.callOptions6) && this.callIncomingDiverted.equalTo(callState_Status.callIncomingDiverted) && this.callOutgoingDiverted_eCallConfirmationPending.equalTo(callState_Status.callOutgoingDiverted_eCallConfirmationPending);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallState_Status:");
        stringBuffer.append("\n - CallState0: ");
        switch (this.callState0) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType0: ");
        switch (this.callType0) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions0 - ");
        stringBuffer.append(this.callOptions0.toString());
        stringBuffer.append("\n - CallState1: ");
        switch (this.callState1) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType1: ");
        switch (this.callType1) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions1 - ");
        stringBuffer.append(this.callOptions1.toString());
        stringBuffer.append("\n - CallState2: ");
        switch (this.callState2) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType2: ");
        switch (this.callType2) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions2 - ");
        stringBuffer.append(this.callOptions2.toString());
        stringBuffer.append("\n - CallState3: ");
        switch (this.callState3) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType3: ");
        switch (this.callType3) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions3 - ");
        stringBuffer.append(this.callOptions3.toString());
        stringBuffer.append("\n - CallState4: ");
        switch (this.callState4) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType4: ");
        switch (this.callType4) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions4 - ");
        stringBuffer.append(this.callOptions4.toString());
        stringBuffer.append("\n - CallState5: ");
        switch (this.callState5) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType5: ");
        switch (this.callType5) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions5 - ");
        stringBuffer.append(this.callOptions5.toString());
        stringBuffer.append("\n - CallState6: ");
        switch (this.callState6) {
            case 0: {
                stringBuffer.append("0x0 (Idle)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Ringing/Waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Dialing)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Disconnecting)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (OnHold)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Connected_CIB)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (RemoteSideBusy)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (INCOMING OnHold)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallType6: ");
        switch (this.callType6) {
            case 0: {
                stringBuffer.append("0x0 (unknown call type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (single voice call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (data call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (fax call)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (emergency call)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (conference voice call)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (info call)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (service call)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (ACN (emergency call))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallOptions6 - ");
        stringBuffer.append(this.callOptions6.toString());
        stringBuffer.append("\n - CallIncomingDiverted - ");
        stringBuffer.append(this.callIncomingDiverted.toString());
        stringBuffer.append("\n - CallOutgoingDiverted_eCallConfirmationPending - ");
        stringBuffer.append(this.callOutgoingDiverted_eCallConfirmationPending.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += this.callOptions0.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions1.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions2.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions3.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions4.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions5.bitSize();
        n += 4;
        n += 4;
        n += this.callOptions6.bitSize();
        n += this.callIncomingDiverted.bitSize();
        return n += this.callOutgoingDiverted_eCallConfirmationPending.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.callState0);
        bitStream.pushBits(4, this.callType0);
        this.callOptions0.serialize(bitStream);
        bitStream.pushBits(4, this.callState1);
        bitStream.pushBits(4, this.callType1);
        this.callOptions1.serialize(bitStream);
        bitStream.pushBits(4, this.callState2);
        bitStream.pushBits(4, this.callType2);
        this.callOptions2.serialize(bitStream);
        bitStream.pushBits(4, this.callState3);
        bitStream.pushBits(4, this.callType3);
        this.callOptions3.serialize(bitStream);
        bitStream.pushBits(4, this.callState4);
        bitStream.pushBits(4, this.callType4);
        this.callOptions4.serialize(bitStream);
        bitStream.pushBits(4, this.callState5);
        bitStream.pushBits(4, this.callType5);
        this.callOptions5.serialize(bitStream);
        bitStream.pushBits(4, this.callState6);
        bitStream.pushBits(4, this.callType6);
        this.callOptions6.serialize(bitStream);
        this.callIncomingDiverted.serialize(bitStream);
        this.callOutgoingDiverted_eCallConfirmationPending.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.callState0 = bitStream.popFrontBits(4);
        this.callType0 = bitStream.popFrontBits(4);
        this.callOptions0.deserialize(bitStream);
        this.callState1 = bitStream.popFrontBits(4);
        this.callType1 = bitStream.popFrontBits(4);
        this.callOptions1.deserialize(bitStream);
        this.callState2 = bitStream.popFrontBits(4);
        this.callType2 = bitStream.popFrontBits(4);
        this.callOptions2.deserialize(bitStream);
        this.callState3 = bitStream.popFrontBits(4);
        this.callType3 = bitStream.popFrontBits(4);
        this.callOptions3.deserialize(bitStream);
        this.callState4 = bitStream.popFrontBits(4);
        this.callType4 = bitStream.popFrontBits(4);
        this.callOptions4.deserialize(bitStream);
        this.callState5 = bitStream.popFrontBits(4);
        this.callType5 = bitStream.popFrontBits(4);
        this.callOptions5.deserialize(bitStream);
        this.callState6 = bitStream.popFrontBits(4);
        this.callType6 = bitStream.popFrontBits(4);
        this.callOptions6.deserialize(bitStream);
        this.callIncomingDiverted.deserialize(bitStream);
        this.callOutgoingDiverted_eCallConfirmationPending.deserialize(bitStream);
    }

    public static int functionId() {
        return 22;
    }

    public int getFunctionId() {
        return CallState_Status.functionId();
    }

    public static final class CallOptions0
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpholdAcceptWaiting;
        public boolean acceptCall;
        private static final int CALL_OPTIONS0_BITSIZE = 8;

        public CallOptions0() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions0(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpholdAcceptWaiting = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions0 callOptions0 = (CallOptions0)bAPEntity;
            return this.ccsplit == callOptions0.ccsplit && this.ccjoin == callOptions0.ccjoin && this.mpswap == callOptions0.mpswap && this.resumeCall == callOptions0.resumeCall && this.callHold == callOptions0.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions0.mpreleaseActiceCallAcceptWaitingCall && this.mpholdAcceptWaiting == callOptions0.mpholdAcceptWaiting && this.acceptCall == callOptions0.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions0:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpholdAcceptWaiting) {
                stringBuffer.append("true  (MPHoldAcceptWaiting");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpholdAcceptWaiting);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpholdAcceptWaiting = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions1
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS1_BITSIZE = 8;

        public CallOptions1() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions1(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions1 callOptions1 = (CallOptions1)bAPEntity;
            return this.ccsplit == callOptions1.ccsplit && this.ccjoin == callOptions1.ccjoin && this.mpswap == callOptions1.mpswap && this.resumeCall == callOptions1.resumeCall && this.callHold == callOptions1.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions1.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions1.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions1.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions1:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions2
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS2_BITSIZE = 8;

        public CallOptions2() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions2(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions2 callOptions2 = (CallOptions2)bAPEntity;
            return this.ccsplit == callOptions2.ccsplit && this.ccjoin == callOptions2.ccjoin && this.mpswap == callOptions2.mpswap && this.resumeCall == callOptions2.resumeCall && this.callHold == callOptions2.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions2.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions2.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions2.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions2:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions3
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS3_BITSIZE = 8;

        public CallOptions3() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions3(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions3 callOptions3 = (CallOptions3)bAPEntity;
            return this.ccsplit == callOptions3.ccsplit && this.ccjoin == callOptions3.ccjoin && this.mpswap == callOptions3.mpswap && this.resumeCall == callOptions3.resumeCall && this.callHold == callOptions3.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions3.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions3.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions3.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions3:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions4
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS4_BITSIZE = 8;

        public CallOptions4() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions4(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions4 callOptions4 = (CallOptions4)bAPEntity;
            return this.ccsplit == callOptions4.ccsplit && this.ccjoin == callOptions4.ccjoin && this.mpswap == callOptions4.mpswap && this.resumeCall == callOptions4.resumeCall && this.callHold == callOptions4.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions4.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions4.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions4.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions4:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions5
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS5_BITSIZE = 8;

        public CallOptions5() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions5(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions5 callOptions5 = (CallOptions5)bAPEntity;
            return this.ccsplit == callOptions5.ccsplit && this.ccjoin == callOptions5.ccjoin && this.mpswap == callOptions5.mpswap && this.resumeCall == callOptions5.resumeCall && this.callHold == callOptions5.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions5.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions5.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions5.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions5:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOptions6
    implements BAPEntity {
        public boolean ccsplit;
        public boolean ccjoin;
        public boolean mpswap;
        public boolean resumeCall;
        public boolean callHold;
        public boolean mpreleaseActiceCallAcceptWaitingCall;
        public boolean mpcallHoldAcceptWaitingCall;
        public boolean acceptCall;
        private static final int CALL_OPTIONS6_BITSIZE = 8;

        public CallOptions6() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOptions6(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ccsplit = false;
            this.ccjoin = false;
            this.mpswap = false;
            this.resumeCall = false;
            this.callHold = false;
            this.mpreleaseActiceCallAcceptWaitingCall = false;
            this.mpcallHoldAcceptWaitingCall = false;
            this.acceptCall = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOptions6 callOptions6 = (CallOptions6)bAPEntity;
            return this.ccsplit == callOptions6.ccsplit && this.ccjoin == callOptions6.ccjoin && this.mpswap == callOptions6.mpswap && this.resumeCall == callOptions6.resumeCall && this.callHold == callOptions6.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callOptions6.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callOptions6.mpcallHoldAcceptWaitingCall && this.acceptCall == callOptions6.acceptCall;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOptions6:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.ccsplit) {
                stringBuffer.append("true  (CCSplit");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.ccjoin) {
                stringBuffer.append("true  (CCJoin");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.mpswap) {
                stringBuffer.append("true  (MPSwap");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.resumeCall) {
                stringBuffer.append("true  (ResumeCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.callHold) {
                stringBuffer.append("true  (CallHold");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mpreleaseActiceCallAcceptWaitingCall) {
                stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mpcallHoldAcceptWaitingCall) {
                stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.acceptCall) {
                stringBuffer.append("true  (AcceptCall");
            } else {
                stringBuffer.append("false  (option not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.ccsplit);
            bitStream.pushBoolean(this.ccjoin);
            bitStream.pushBoolean(this.mpswap);
            bitStream.pushBoolean(this.resumeCall);
            bitStream.pushBoolean(this.callHold);
            bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
            bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
            bitStream.pushBoolean(this.acceptCall);
        }

        public void deserialize(BitStream bitStream) {
            this.ccsplit = bitStream.popFrontBoolean();
            this.ccjoin = bitStream.popFrontBoolean();
            this.mpswap = bitStream.popFrontBoolean();
            this.resumeCall = bitStream.popFrontBoolean();
            this.callHold = bitStream.popFrontBoolean();
            this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
            this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
            this.acceptCall = bitStream.popFrontBoolean();
        }
    }

    public static final class CallIncomingDiverted
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean call6Diverted;
        public boolean call5Diverted;
        public boolean call4Diverted;
        public boolean call3Diverted;
        public boolean call2Diverted;
        public boolean call1Diverted;
        public boolean call0Diverted;
        private static final int CALL_INCOMING_DIVERTED_BITSIZE = 8;

        public CallIncomingDiverted() {
            this.internalReset();
            this.customInitialization();
        }

        public CallIncomingDiverted(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_7 = false;
            this.call6Diverted = false;
            this.call5Diverted = false;
            this.call4Diverted = false;
            this.call3Diverted = false;
            this.call2Diverted = false;
            this.call1Diverted = false;
            this.call0Diverted = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallIncomingDiverted callIncomingDiverted = (CallIncomingDiverted)bAPEntity;
            return this.reserved_bit_7 == callIncomingDiverted.reserved_bit_7 && this.call6Diverted == callIncomingDiverted.call6Diverted && this.call5Diverted == callIncomingDiverted.call5Diverted && this.call4Diverted == callIncomingDiverted.call4Diverted && this.call3Diverted == callIncomingDiverted.call3Diverted && this.call2Diverted == callIncomingDiverted.call2Diverted && this.call1Diverted == callIncomingDiverted.call1Diverted && this.call0Diverted == callIncomingDiverted.call0Diverted;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallIncomingDiverted:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.reserved_bit_7) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.call6Diverted) {
                stringBuffer.append("true  (call 6 diverted");
            } else {
                stringBuffer.append("false  (call 6 not diverted");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.call5Diverted) {
                stringBuffer.append("true  (call 5 diverted");
            } else {
                stringBuffer.append("false  (call 5 not diverted");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.call4Diverted) {
                stringBuffer.append("true  (call 4 diverted");
            } else {
                stringBuffer.append("false  (call 4 not diverted");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.call3Diverted) {
                stringBuffer.append("true  (call 3 diverted");
            } else {
                stringBuffer.append("false  (call 3 not diverted");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.call2Diverted) {
                stringBuffer.append("true  (call 2 diverted");
            } else {
                stringBuffer.append("false  (call 2 not diverted");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.call1Diverted) {
                stringBuffer.append("true  (call 1 diverted");
            } else {
                stringBuffer.append("false  (call 1 not diverted");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.call0Diverted) {
                stringBuffer.append("true  (call 0 diverted");
            } else {
                stringBuffer.append("false  (call 0 not diverted");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_7);
            bitStream.pushBoolean(this.call6Diverted);
            bitStream.pushBoolean(this.call5Diverted);
            bitStream.pushBoolean(this.call4Diverted);
            bitStream.pushBoolean(this.call3Diverted);
            bitStream.pushBoolean(this.call2Diverted);
            bitStream.pushBoolean(this.call1Diverted);
            bitStream.pushBoolean(this.call0Diverted);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_7 = bitStream.popFrontBoolean();
            this.call6Diverted = bitStream.popFrontBoolean();
            this.call5Diverted = bitStream.popFrontBoolean();
            this.call4Diverted = bitStream.popFrontBoolean();
            this.call3Diverted = bitStream.popFrontBoolean();
            this.call2Diverted = bitStream.popFrontBoolean();
            this.call1Diverted = bitStream.popFrontBoolean();
            this.call0Diverted = bitStream.popFrontBoolean();
        }
    }

    public static final class CallOutgoingDiverted_eCallConfirmationPending
    implements BAPEntity {
        public boolean eCallConfirmationPending;
        public boolean call6Diverted;
        public boolean call5Diverted;
        public boolean call4Diverted;
        public boolean call3Diverted;
        public boolean call2Diverted;
        public boolean call1Diverted;
        public boolean call0Diverted;
        private static final int CALL_OUTGOING_DIVERTED_E_CALL_CONFIRMATION_PENDING_BITSIZE = 8;

        public CallOutgoingDiverted_eCallConfirmationPending() {
            this.internalReset();
            this.customInitialization();
        }

        public CallOutgoingDiverted_eCallConfirmationPending(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.eCallConfirmationPending = false;
            this.call6Diverted = false;
            this.call5Diverted = false;
            this.call4Diverted = false;
            this.call3Diverted = false;
            this.call2Diverted = false;
            this.call1Diverted = false;
            this.call0Diverted = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            CallOutgoingDiverted_eCallConfirmationPending callOutgoingDiverted_eCallConfirmationPending = (CallOutgoingDiverted_eCallConfirmationPending)bAPEntity;
            return this.eCallConfirmationPending == callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending && this.call6Diverted == callOutgoingDiverted_eCallConfirmationPending.call6Diverted && this.call5Diverted == callOutgoingDiverted_eCallConfirmationPending.call5Diverted && this.call4Diverted == callOutgoingDiverted_eCallConfirmationPending.call4Diverted && this.call3Diverted == callOutgoingDiverted_eCallConfirmationPending.call3Diverted && this.call2Diverted == callOutgoingDiverted_eCallConfirmationPending.call2Diverted && this.call1Diverted == callOutgoingDiverted_eCallConfirmationPending.call1Diverted && this.call0Diverted == callOutgoingDiverted_eCallConfirmationPending.call0Diverted;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CallOutgoingDiverted_eCallConfirmationPending:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.eCallConfirmationPending) {
                stringBuffer.append("true  (eCall confirmation pending");
            } else {
                stringBuffer.append("false  (no confirmation pending");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.call6Diverted) {
                stringBuffer.append("true  (call 6 diverted");
            } else {
                stringBuffer.append("false  (call 6 not diverted");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.call5Diverted) {
                stringBuffer.append("true  (call 5 diverted");
            } else {
                stringBuffer.append("false  (call 5 not diverted");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.call4Diverted) {
                stringBuffer.append("true  (call 4 diverted");
            } else {
                stringBuffer.append("false  (call 4 not diverted");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.call3Diverted) {
                stringBuffer.append("true  (call 3 diverted");
            } else {
                stringBuffer.append("false  (call 3 not diverted");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.call2Diverted) {
                stringBuffer.append("true  (call 2 diverted");
            } else {
                stringBuffer.append("false  (call 2 not diverted");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.call1Diverted) {
                stringBuffer.append("true  (call 1 diverted");
            } else {
                stringBuffer.append("false  (call 1 not diverted");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.call0Diverted) {
                stringBuffer.append("true  (call 0 diverted");
            } else {
                stringBuffer.append("false  (call 0 not diverted");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.eCallConfirmationPending);
            bitStream.pushBoolean(this.call6Diverted);
            bitStream.pushBoolean(this.call5Diverted);
            bitStream.pushBoolean(this.call4Diverted);
            bitStream.pushBoolean(this.call3Diverted);
            bitStream.pushBoolean(this.call2Diverted);
            bitStream.pushBoolean(this.call1Diverted);
            bitStream.pushBoolean(this.call0Diverted);
        }

        public void deserialize(BitStream bitStream) {
            this.eCallConfirmationPending = bitStream.popFrontBoolean();
            this.call6Diverted = bitStream.popFrontBoolean();
            this.call5Diverted = bitStream.popFrontBoolean();
            this.call4Diverted = bitStream.popFrontBoolean();
            this.call3Diverted = bitStream.popFrontBoolean();
            this.call2Diverted = bitStream.popFrontBoolean();
            this.call1Diverted = bitStream.popFrontBoolean();
            this.call0Diverted = bitStream.popFrontBoolean();
        }
    }
}

