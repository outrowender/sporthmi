/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.calllist.SingleCall;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.DisconnectReason;

public class CallState {
    public static final int TRANSITION_UNDEFINED;
    public static final int TRANSITION_DIALED;
    public static final int TRANSITION_ACCEPT_INCOMING_CALL;
    public static final int TRANSITION_JOIN_CONFERENCE;
    public static final int TRANSITION_IDLE;
    public static final int TRANSITION_IDLE_2_ACTIVE;
    public static final int CONFERENCE_DUMMY_CALLID;
    private static final int CALLTYPE_MASK_SINGLE_CALL;
    private static final int CALLTYPE_MASK_CONFERENCE_CALL;
    private static final int CALLSTATE_MASK_DIALING;
    private static final int CALLSTATE_MASK_RINGING;
    private static final int CALLSTATE_MASK_ACTIVE;
    private static final int CALLSTATE_MASK_DISCONNECTING;
    private static final int CALLSTATE_MASK_HOLD;
    private static final int MP_MASK_ACTIVE_CONFERENCE;
    private static final int MP_MASK_ACTIVE_SINGLE;
    private static final int MP_MASK_DIALING;
    private static final int MP_MASK_DISCONNECTING_SINGLE;
    private static final int MP_MASK_DISCONNECTING_CONFERENCE;
    private static final int MP_MASK_ON_HOLD_CONFERENCE;
    private static final int MP_MASK_ON_HOLD_SINGLE;
    private static final int MP_MASK_RINGING;
    private static final int MP_MASK_IDLE;
    private final HashMap callStateMaskToMPCallStateMap = new HashMap();
    private final HashMap dsiCallStateToBitMaskMap = new HashMap();
    private final HashMap singleCallToMPMaskMap = new HashMap();
    private final HashMap disconnectReasonMap = new HashMap();
    private final HashMap dsiCallMap = new HashMap();
    private final SimpleIntIntMap mpCallStateToCallModelMap = new SimpleIntIntMap();
    private int mpCallState;
    private int previousMPCallState;
    private final Object mutex = new Object();
    private AbstractPhoneCall[] phoneCalls = new AbstractPhoneCall[0];
    private CallInformation[] dsiCallList;
    private int previousMPCallStateMask;
    private int mpCallStateMask;
    private final LogChannel log;
    private int transition;

    public static String getTransitionString(int n) {
        switch (n) {
            case 0: {
                return "TRANSITION_UNDEFINED";
            }
            case 1: {
                return "TRANSITION_DIALED";
            }
            case 2: {
                return "TRANSITION_ACCEPT_INCOMING_CALL";
            }
            case 3: {
                return "TRANSITION_JOIN_CONFERENCE";
            }
            case 4: {
                return "TRANSITION_IDLE";
            }
            case 5: {
                return "TRANSITION_IDLE_2_ACTIVE";
            }
        }
        return "";
    }

    private static boolean isStatePresent(int n, int n2) {
        return (n & n2) == n2;
    }

    public CallState(LogChannel logChannel) {
        this.log = logChannel;
        this.mpCallStateToCallModelMap.add(0, 0);
        this.mpCallStateToCallModelMap.add(1, 2);
        this.mpCallStateToCallModelMap.add(2, 3);
        this.mpCallStateToCallModelMap.add(3, 4);
        this.mpCallStateToCallModelMap.add(4, 9);
        this.mpCallStateToCallModelMap.add(5, 8);
        this.mpCallStateToCallModelMap.add(6, 16);
        this.mpCallStateToCallModelMap.add(7, 12);
        this.mpCallStateToCallModelMap.add(8, 11);
        this.mpCallStateToCallModelMap.add(9, 11);
        this.mpCallStateToCallModelMap.add(10, 21);
        this.mpCallStateToCallModelMap.add(11, 13);
        this.mpCallStateToCallModelMap.add(12, 13);
        this.mpCallStateToCallModelMap.add(13, 13);
        this.mpCallStateToCallModelMap.add(14, 21);
        this.mpCallStateToCallModelMap.add(15, 1);
        this.mpCallStateToCallModelMap.add(16, 6);
        this.mpCallStateToCallModelMap.add(17, 7);
        this.mpCallStateToCallModelMap.add(18, 7);
        this.mpCallStateToCallModelMap.add(19, 10);
        this.mpCallStateToCallModelMap.add(20, 19);
        this.mpCallStateToCallModelMap.add(21, 20);
        this.mpCallStateToCallModelMap.add(22, 14);
        this.mpCallStateToCallModelMap.add(23, 18);
        this.mpCallStateToCallModelMap.add(24, 15);
        this.mpCallStateToCallModelMap.add(25, 5);
        this.mpCallStateToCallModelMap.add(26, 6);
        this.mpCallStateToCallModelMap.add(27, 22);
        this.mpCallStateToCallModelMap.add(28, 23);
        this.mpCallStateToCallModelMap.add(29, 23);
        this.mpCallStateToCallModelMap.add(30, 24);
        this.mpCallStateToCallModelMap.add(31, 24);
        this.mpCallStateToCallModelMap.add(32, 25);
        this.mpCallStateToCallModelMap.add(33, 25);
        this.mpCallStateToCallModelMap.add(34, 25);
        this.mpCallStateToCallModelMap.add(35, 25);
        this.initMappings();
    }

    public void init() {
    }

    public void deinit() {
    }

    private void initMappings() {
        this.initCallStateMaskToMPCallStateMapping();
        this.initDsiCallStateToBitMaskMap();
        this.initCallToMPMaskMap();
    }

    private void initDsiCallStateToBitMaskMap() {
        this.dsiCallStateToBitMaskMap.put(new Integer(4), new Integer(32));
        this.dsiCallStateToBitMaskMap.put(new Integer(2), new Integer(8));
        this.dsiCallStateToBitMaskMap.put(new Integer(1), new Integer(8));
        this.dsiCallStateToBitMaskMap.put(new Integer(5), new Integer(64));
        this.dsiCallStateToBitMaskMap.put(new Integer(6), new Integer(128));
        this.dsiCallStateToBitMaskMap.put(new Integer(8), new Integer(128));
        this.dsiCallStateToBitMaskMap.put(new Integer(3), new Integer(16));
    }

    private void initCallToMPMaskMap() {
        this.singleCallToMPMaskMap.put(new Integer(18), new Integer(1));
        this.singleCallToMPMaskMap.put(new Integer(130), new Integer(2));
        this.singleCallToMPMaskMap.put(new Integer(132), new Integer(4));
        this.singleCallToMPMaskMap.put(new Integer(68), new Integer(8));
        this.singleCallToMPMaskMap.put(new Integer(66), new Integer(16));
        this.singleCallToMPMaskMap.put(new Integer(10), new Integer(32));
        this.singleCallToMPMaskMap.put(new Integer(34), new Integer(64));
        this.singleCallToMPMaskMap.put(new Integer(36), new Integer(128));
    }

    private void initCallStateMaskToMPCallStateMapping() {
        this.callStateMaskToMPCallStateMap.put(new Integer(0), new Integer(0));
        this.callStateMaskToMPCallStateMap.put(new Integer(1), new Integer(15));
        this.callStateMaskToMPCallStateMap.put(new Integer(2), new Integer(25));
        this.callStateMaskToMPCallStateMap.put(new Integer(3), new Integer(17));
        this.callStateMaskToMPCallStateMap.put(new Integer(4), new Integer(22));
        this.callStateMaskToMPCallStateMap.put(new Integer(5), new Integer(18));
        this.callStateMaskToMPCallStateMap.put(new Integer(16), new Integer(3));
        this.callStateMaskToMPCallStateMap.put(new Integer(8), new Integer(32));
        this.callStateMaskToMPCallStateMap.put(new Integer(18), new Integer(9));
        this.callStateMaskToMPCallStateMap.put(new Integer(10), new Integer(34));
        this.callStateMaskToMPCallStateMap.put(new Integer(20), new Integer(13));
        this.callStateMaskToMPCallStateMap.put(new Integer(12), new Integer(13));
        this.callStateMaskToMPCallStateMap.put(new Integer(32), new Integer(2));
        this.callStateMaskToMPCallStateMap.put(new Integer(48), new Integer(2));
        this.callStateMaskToMPCallStateMap.put(new Integer(40), new Integer(2));
        this.callStateMaskToMPCallStateMap.put(new Integer(33), new Integer(15));
        this.callStateMaskToMPCallStateMap.put(new Integer(34), new Integer(4));
        this.callStateMaskToMPCallStateMap.put(new Integer(36), new Integer(6));
        this.callStateMaskToMPCallStateMap.put(new Integer(64), new Integer(1));
        this.callStateMaskToMPCallStateMap.put(new Integer(96), new Integer(4));
        this.callStateMaskToMPCallStateMap.put(new Integer(65), new Integer(16));
        this.callStateMaskToMPCallStateMap.put(new Integer(66), new Integer(5));
        this.callStateMaskToMPCallStateMap.put(new Integer(67), new Integer(19));
        this.callStateMaskToMPCallStateMap.put(new Integer(68), new Integer(24));
        this.callStateMaskToMPCallStateMap.put(new Integer(69), new Integer(21));
        this.callStateMaskToMPCallStateMap.put(new Integer(80), new Integer(8));
        this.callStateMaskToMPCallStateMap.put(new Integer(72), new Integer(33));
        this.callStateMaskToMPCallStateMap.put(new Integer(82), new Integer(10));
        this.callStateMaskToMPCallStateMap.put(new Integer(74), new Integer(35));
        this.callStateMaskToMPCallStateMap.put(new Integer(84), new Integer(14));
        this.callStateMaskToMPCallStateMap.put(new Integer(76), new Integer(14));
        this.callStateMaskToMPCallStateMap.put(new Integer(128), new Integer(7));
        this.callStateMaskToMPCallStateMap.put(new Integer(160), new Integer(6));
        this.callStateMaskToMPCallStateMap.put(new Integer(129), new Integer(26));
        this.callStateMaskToMPCallStateMap.put(new Integer(130), new Integer(23));
        this.callStateMaskToMPCallStateMap.put(new Integer(131), new Integer(20));
        this.callStateMaskToMPCallStateMap.put(new Integer(144), new Integer(11));
        this.callStateMaskToMPCallStateMap.put(new Integer(136), new Integer(11));
        this.callStateMaskToMPCallStateMap.put(new Integer(146), new Integer(12));
        this.callStateMaskToMPCallStateMap.put(new Integer(138), new Integer(12));
        this.callStateMaskToMPCallStateMap.put(new Integer(17), new Integer(27));
        this.callStateMaskToMPCallStateMap.put(new Integer(9), new Integer(27));
        this.callStateMaskToMPCallStateMap.put(new Integer(81), new Integer(28));
        this.callStateMaskToMPCallStateMap.put(new Integer(73), new Integer(28));
        this.callStateMaskToMPCallStateMap.put(new Integer(145), new Integer(29));
        this.callStateMaskToMPCallStateMap.put(new Integer(137), new Integer(29));
        this.callStateMaskToMPCallStateMap.put(new Integer(19), new Integer(30));
        this.callStateMaskToMPCallStateMap.put(new Integer(11), new Integer(30));
        this.callStateMaskToMPCallStateMap.put(new Integer(21), new Integer(31));
        this.callStateMaskToMPCallStateMap.put(new Integer(13), new Integer(31));
    }

    private int getDSICallStateMask(int n) {
        return this.getIntValue(this.dsiCallStateToBitMaskMap, n, 0);
    }

    private int getMPMask(int n, int n2) {
        return this.getIntValue(this.singleCallToMPMaskMap, n | n2, 0);
    }

    private int getIntValue(Map map, int n, int n2) {
        Integer n3 = (Integer)map.get(new Integer(n));
        return n3 != null ? n3 : n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int determineMPCallState(AbstractPhoneCall[] abstractPhoneCallArray) {
        Object object = this.mutex;
        synchronized (object) {
            this.previousMPCallStateMask = this.mpCallStateMask;
            this.mpCallStateMask = 0;
            if (abstractPhoneCallArray != null) {
                for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
                    int n = abstractPhoneCallArray[i2] instanceof ConferenceCall ? 4 : 2;
                    int n2 = this.getDSICallStateMask(abstractPhoneCallArray[i2].getTelCallState());
                    this.mpCallStateMask |= this.getMPMask(n, n2);
                }
            }
            return this.getIntValue(this.callStateMaskToMPCallStateMap, this.mpCallStateMask, -1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallList(CallInformation[] callInformationArray) {
        Object object = this.mutex;
        synchronized (object) {
            this.dsiCallList = callInformationArray;
            this.updatePhoneCalls(callInformationArray);
            this.assignDisconnectReasons();
            this.setMpCallState(this.determineMPCallState(this.phoneCalls));
            this.determineTransition();
        }
    }

    private void determineTransition() {
        this.transition = this.isTransitionToIdle() ? 4 : (this.isTransitionDialed() ? 1 : (this.isTransitionJoinToConference() ? 3 : (this.isTransitionAcceptIncomingCall() ? 2 : (this.isTransitionDirectToActive() ? 5 : 0))));
        this.log.log(1078071040, "[CallState#determineTransition] %1", (Object)CallState.getTransitionString(this.transition));
    }

    private boolean isTransitionDirectToActive() {
        return (this.previousMPCallState == -1 || this.previousMPCallState == 0) && this.hasActiveCall();
    }

    private boolean isTransitionAcceptIncomingCall() {
        return CallState.isStatePresent(this.previousMPCallStateMask, 1) && (this.getActiveCall() != null && this.getActiveCall().getPreviousCallState() == 3 || this.getHeldCall() != null && this.getHeldCall().getPreviousCallState() == 3) && !this.hasIncomingCall();
    }

    private boolean isTransitionJoinToConference() {
        return (CallState.isStatePresent(this.previousMPCallStateMask, 128) && CallState.isStatePresent(this.previousMPCallStateMask, 2) || CallState.isStatePresent(this.previousMPCallStateMask, 64) && CallState.isStatePresent(this.previousMPCallStateMask, 2) || CallState.isStatePresent(this.previousMPCallStateMask, 4) && CallState.isStatePresent(this.previousMPCallStateMask, 64)) && this.hasActiveConferenceCall() && !this.hasOnHoldCall();
    }

    private boolean isTransitionDialed() {
        return !CallState.isStatePresent(this.previousMPCallStateMask, 32) && this.hasOutgoingCall();
    }

    private boolean isTransitionToIdle() {
        return this.previousMPCallState != 0 && this.mpCallState == 0;
    }

    private void assignDisconnectReasons() {
        Iterator iterator = this.disconnectReasonMap.keySet().iterator();
        while (iterator.hasNext()) {
            ConferenceCall conferenceCall;
            Integer n = (Integer)iterator.next();
            Integer n2 = (Integer)this.disconnectReasonMap.get(n);
            AbstractPhoneCall abstractPhoneCall = this.getPhoneCall(n);
            if (abstractPhoneCall == null) continue;
            int n3 = n2;
            abstractPhoneCall.setDisconnectReason(n3);
            if (!abstractPhoneCall.isConferenceMember() || (conferenceCall = this.getConferenceCall()) == null) continue;
            conferenceCall.setDisconnectReason(n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallDurationList(CallDuration[] callDurationArray) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < callDurationArray.length; ++i2) {
                short s = callDurationArray[i2].getTelCallID();
                int n = callDurationArray[i2].getTelElapsedTime();
                AbstractPhoneCall abstractPhoneCall = this.getPhoneCall(s);
                if (abstractPhoneCall == null) continue;
                abstractPhoneCall.setCallDuration(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SingleCall getDSICall(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return (SingleCall)this.dsiCallMap.get(new Integer(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AbstractPhoneCall getPhoneCall(int n) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall = this.phoneCalls[i2];
                if (abstractPhoneCall.getTelCallID() == n) {
                    return abstractPhoneCall;
                }
                if (!(abstractPhoneCall instanceof ConferenceCall) || (abstractPhoneCall = ((ConferenceCall)abstractPhoneCall).getMember(n)) == null) continue;
                return abstractPhoneCall;
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDisconnectReason(DisconnectReason disconnectReason) {
        Object object = this.mutex;
        synchronized (object) {
            this.disconnectReasonMap.put(new Integer(disconnectReason.getCallId()), new Integer(disconnectReason.getDisconnectReason()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getMpCallState() {
        Object object = this.mutex;
        synchronized (object) {
            return this.mpCallState;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getPreviousMPCallState() {
        Object object = this.mutex;
        synchronized (object) {
            return this.previousMPCallState;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updatePhoneCalls(CallInformation[] callInformationArray) {
        Object object = this.mutex;
        synchronized (object) {
            if (callInformationArray == null || callInformationArray.length == 0) {
                this.dsiCallMap.clear();
                this.phoneCalls = new AbstractPhoneCall[0];
            } else {
                this.updateDsiCallMap(callInformationArray);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.dsiCallMap.values());
                this.createPhoneCalls(arrayList);
            }
        }
        this.log.log(-2137614336, "[CallState#updatePhoneCalls] callList=%1, phoneCalls=%2", (Object)Converter.array2String(callInformationArray), (Object)Converter.array2String(this.phoneCalls));
    }

    private void createPhoneCalls(ArrayList arrayList) {
        AbstractPhoneCall abstractPhoneCall;
        Object object;
        ArrayList arrayList2 = new ArrayList();
        ConferenceCall conferenceCall = null;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            object = (AbstractPhoneCall)iterator.next();
            if (!(object instanceof ConferenceCall)) continue;
            conferenceCall = (ConferenceCall)object;
            iterator.remove();
            break;
        }
        if (conferenceCall != null) {
            conferenceCall.removeMembers();
            object = arrayList.iterator();
            while (object.hasNext()) {
                abstractPhoneCall = (SingleCall)object.next();
                if (!abstractPhoneCall.isConferenceMember()) continue;
                conferenceCall.addMember((SingleCall)abstractPhoneCall);
                object.remove();
            }
            arrayList2.add(conferenceCall);
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            abstractPhoneCall = (AbstractPhoneCall)object.next();
            if (abstractPhoneCall.isConferenceMember()) continue;
            arrayList2.add(abstractPhoneCall);
        }
        this.phoneCalls = (AbstractPhoneCall[])arrayList2.toArray(new AbstractPhoneCall[arrayList2.size()]);
    }

    private void updateDsiCallMap(CallInformation[] callInformationArray) {
        short s;
        CallInformation callInformation;
        for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
            callInformation = callInformationArray[i2];
            s = callInformation.getTelCallID();
            Integer n = new Integer(s);
            AbstractPhoneCall abstractPhoneCall = (AbstractPhoneCall)this.dsiCallMap.get(n);
            if (abstractPhoneCall != null) {
                abstractPhoneCall.updateCall(callInformation);
                continue;
            }
            if (s == 254) {
                this.dsiCallMap.put(n, new ConferenceCall(callInformationArray[i2]));
                continue;
            }
            this.dsiCallMap.put(n, new SingleCall(callInformationArray[i2]));
        }
        Iterator iterator = this.dsiCallMap.values().iterator();
        while (iterator.hasNext()) {
            callInformation = (AbstractPhoneCall)iterator.next();
            s = 0;
            for (int i3 = 0; i3 < callInformationArray.length; ++i3) {
                if (callInformation.getTelCallID() != callInformationArray[i3].getTelCallID()) continue;
                s = 1;
            }
            if (s != 0) continue;
            this.log.log(-2137614336, "[CallState#updatePhoneCalls] removing phone call with id %1", (long)callInformation.getTelCallID());
            iterator.remove();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getNrCalls() {
        Object object = this.mutex;
        synchronized (object) {
            return this.phoneCalls.length;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasActiveSingleCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 64);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasActiveConferenceCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 128);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasActiveCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.hasActiveSingleCall() || this.hasActiveConferenceCall();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasOutgoingCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 32);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasDisconnectingSingleCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 16);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasDisconnectingCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.hasDisconnectingConferenceCall() || this.hasDisconnectingSingleCall();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasOnHoldSingleCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasOnHoldCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.hasOnHoldSingleCall() || this.hasOnHoldConferenceCall();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasOnHoldConferenceCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasDisconnectingConferenceCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 8);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasIncomingCall() {
        Object object = this.mutex;
        synchronized (object) {
            return CallState.isStatePresent(this.mpCallStateMask, 1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasEmergencyCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasInfoCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasBreakdownCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(6);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasOperatorCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(7);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isMultipartyActive() {
        Object object = this.mutex;
        synchronized (object) {
            return this.hasActiveCall() && this.hasOnHoldCall();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AbstractPhoneCall getActiveCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.getCallWithState(4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    SingleCall getOutgoingCall() {
        Object object = this.mutex;
        synchronized (object) {
            AbstractPhoneCall abstractPhoneCall = this.getCallWithState(1);
            if (abstractPhoneCall == null) {
                abstractPhoneCall = this.getCallWithState(2);
            }
            return abstractPhoneCall instanceof SingleCall ? (SingleCall)abstractPhoneCall : null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AbstractPhoneCall getHeldCall() {
        Object object = this.mutex;
        synchronized (object) {
            AbstractPhoneCall abstractPhoneCall = this.getCallWithState(6);
            if (abstractPhoneCall == null) {
                abstractPhoneCall = this.getCallWithState(8);
            }
            return abstractPhoneCall;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    SingleCall getIncomingCall() {
        Object object = this.mutex;
        synchronized (object) {
            AbstractPhoneCall abstractPhoneCall = this.getCallWithState(3);
            return abstractPhoneCall instanceof SingleCall ? (SingleCall)abstractPhoneCall : null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AbstractPhoneCall getDisconnectingCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.getCallWithState(5);
        }
    }

    AbstractPhoneCall getEmergencyCall() {
        AbstractPhoneCall[] abstractPhoneCallArray = this.getCallsWithType(3);
        if (abstractPhoneCallArray != null && abstractPhoneCallArray.length == 1) {
            return abstractPhoneCallArray[0];
        }
        return null;
    }

    private AbstractPhoneCall[] getCallsWithType(int n) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
            AbstractPhoneCall abstractPhoneCall = this.phoneCalls[i2];
            if (abstractPhoneCall.getTelCallType() == n) {
                arrayList.add(abstractPhoneCall);
                continue;
            }
            if (!(abstractPhoneCall instanceof ConferenceCall)) continue;
            SingleCall[] singleCallArray = ((ConferenceCall)abstractPhoneCall).getMembers();
            for (int i3 = 0; i3 < singleCallArray.length; ++i3) {
                if (singleCallArray[i3].getTelCallType() != n) continue;
                arrayList.add(abstractPhoneCall);
            }
        }
        return (AbstractPhoneCall[])arrayList.toArray(new AbstractPhoneCall[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ConferenceCall getConferenceCall() {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                if (!(this.phoneCalls[i2] instanceof ConferenceCall)) continue;
                return (ConferenceCall)this.phoneCalls[i2];
            }
            return null;
        }
    }

    private boolean callWithTypePresent(int n) {
        for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
            AbstractPhoneCall abstractPhoneCall = this.phoneCalls[i2];
            if (abstractPhoneCall.getTelCallType() == n) {
                return true;
            }
            if (!(abstractPhoneCall instanceof ConferenceCall)) continue;
            SingleCall[] singleCallArray = ((ConferenceCall)abstractPhoneCall).getMembers();
            for (int i3 = 0; i3 < singleCallArray.length; ++i3) {
                if (singleCallArray[i3].getTelCallType() != n) continue;
                return true;
            }
        }
        return false;
    }

    private AbstractPhoneCall getCallWithState(int n) {
        AbstractPhoneCall abstractPhoneCall = null;
        for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
            AbstractPhoneCall abstractPhoneCall2 = this.phoneCalls[i2];
            if (abstractPhoneCall2.getTelCallState() == n && (abstractPhoneCall == null || abstractPhoneCall2.getTelCallID() < abstractPhoneCall.getTelCallID())) {
                abstractPhoneCall = abstractPhoneCall2;
                continue;
            }
            if (!(abstractPhoneCall2 instanceof ConferenceCall)) continue;
            SingleCall[] singleCallArray = ((ConferenceCall)abstractPhoneCall2).getMembers();
            for (int i3 = 0; i3 < singleCallArray.length; ++i3) {
                if (singleCallArray[i3].getTelCallState() != n || abstractPhoneCall != null && singleCallArray[i3].getTelCallID() >= abstractPhoneCall.getTelCallID()) continue;
                abstractPhoneCall = singleCallArray[i3];
            }
        }
        return abstractPhoneCall;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setHangupByUser(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n == 255) {
                for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                    AbstractPhoneCall abstractPhoneCall = this.phoneCalls[i2];
                    abstractPhoneCall.setHangupByUser();
                }
            } else if (n == 254) {
                ConferenceCall conferenceCall = this.getConferenceCall();
                if (conferenceCall != null) {
                    conferenceCall.setHangupByUser();
                }
            } else {
                SingleCall singleCall = this.getDSICall(n);
                if (singleCall != null) {
                    singleCall.setHangupByUser();
                }
            }
        }
    }

    protected AbstractPhoneCall[] getPhoneCalls() {
        return this.phoneCalls;
    }

    protected CallInformation[] getDsiCallList() {
        return this.dsiCallList;
    }

    private void setMpCallState(int n) {
        this.previousMPCallState = this.mpCallState;
        this.mpCallState = n;
    }

    int getTransition() {
        return this.transition;
    }

    int getCallStateChoiceValue() {
        return this.mpCallStateToCallModelMap.get(this.mpCallState);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasBCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(768);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasPCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(256);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasCCall() {
        Object object = this.mutex;
        synchronized (object) {
            return this.callWithTypePresent(512);
        }
    }
}

