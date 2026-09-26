/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformationExt;

public interface ITelCallInformation {
    public static final int CALLTYPE_VOICE;
    public static final int CALLTYPE_DATA;
    public static final int CALLTYPE_FAX;
    public static final int CALLTYPE_EMERGENCY;
    public static final int CALLTYPE_CONFERENCE;
    public static final int CALLTYPE_INFO;
    public static final int CALLTYPE_BREAKDOWN;
    public static final int CALLTYPE_OPERATOR;
    public static final int CALLTYPE_MAILBOX;
    public static final int CALLTYPE_NO_NUMBER;
    public static final int CALLTYPE_P_CALL;
    public static final int CALLTYPE_C_CALL;
    public static final int CALLTYPE_B_CALL;

    default public short getTelCallID() {
    }

    default public int getTelCallState() {
    }

    default public int getTelMpty() {
    }

    default public String getTelRemName() {
    }

    default public String getTelRemNumber() {
    }

    default public ResourceLocator getTelRemPictureId() {
    }

    default public short getTelNumType() {
    }

    default public int getTelCallType() {
    }

    default public long getTelRemEntryId() {
    }

    default public int getTelRemNumberType() {
    }

    default public int getTelCallStartingTime() {
    }

    default public CallInformationExt getExtendedCallInformation() {
    }

    default public int getTelCallCarrier() {
    }

    default public int getPreviousCallState() {
    }

    default public boolean isConferenceMember() {
    }

    default public boolean isOutgoingCall() {
    }

    default public boolean callWasActive() {
    }

    default public int getCallDuration() {
    }

    default public int getDisconnectReason() {
    }
}

