/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformationExt;

public interface ITelCallInformation {
    public static final int CALLTYPE_VOICE = 0;
    public static final int CALLTYPE_DATA = 1;
    public static final int CALLTYPE_FAX = 2;
    public static final int CALLTYPE_EMERGENCY = 3;
    public static final int CALLTYPE_CONFERENCE = 4;
    public static final int CALLTYPE_INFO = 5;
    public static final int CALLTYPE_BREAKDOWN = 6;
    public static final int CALLTYPE_OPERATOR = 7;
    public static final int CALLTYPE_MAILBOX = 8;
    public static final int CALLTYPE_NO_NUMBER = 9;
    public static final int CALLTYPE_P_CALL = 65536;
    public static final int CALLTYPE_C_CALL = 131072;
    public static final int CALLTYPE_B_CALL = 196608;

    public short getTelCallID();

    public int getTelCallState();

    public int getTelMpty();

    public String getTelRemName();

    public String getTelRemNumber();

    public ResourceLocator getTelRemPictureId();

    public short getTelNumType();

    public int getTelCallType();

    public long getTelRemEntryId();

    public int getTelRemNumberType();

    public int getTelCallStartingTime();

    public CallInformationExt getExtendedCallInformation();

    public int getTelCallCarrier();

    public int getPreviousCallState();

    public boolean isConferenceMember();

    public boolean isOutgoingCall();

    public boolean callWasActive();

    public int getCallDuration();

    public int getDisconnectReason();
}

