/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

public interface ITelCallList {
    public static final int MPCALLSTATE_UNKNOWN = -1;
    public static final int MPCALLSTATE_IDLE = 0;
    public static final int MPCALLSTATE_ACTIVE = 1;
    public static final int MPCALLSTATE_DIALING = 2;
    public static final int MPCALLSTATE_DISCONNECTING = 3;
    public static final int MPCALLSTATE_ONHOLD_DIALING = 4;
    public static final int MPCALLSTATE_ACTIVE_ONHOLD = 5;
    public static final int MPCALLSTATE_HOLDCC_DIALING = 6;
    public static final int MPCALLSTATE_CC = 7;
    public static final int MPCALLSTATE_ACTIVE_DISCONNECTING = 8;
    public static final int MPCALLSTATE_ONHOLD_DISCONNECTING = 9;
    public static final int MPCALLSTATE_ACTIVE_ONHOLD_DISCONNECTING = 10;
    public static final int MPCALLSTATE_CC_DISCONNECTING = 11;
    public static final int MPCALLSTATE_CC_ONHOLD_DISCONNECTING = 12;
    public static final int MPCALLSTATE_HOLDCC_DISCONNECTING = 13;
    public static final int MPCALLSTATE_HOLDCC_ACTIVE_DISCONNECTING = 14;
    public static final int MPCALLSTATE_RINGING = 15;
    public static final int MPCALLSTATE_ACTIVE_RINGING = 16;
    public static final int MPCALLSTATE_ONHOLD_RINGING = 17;
    public static final int MPCALLSTATE_HOLDCC_RINGING = 18;
    public static final int MPCALLSTATE_ACTIVE_ONHOLD_RINGING = 19;
    public static final int MPCALLSTATE_CC_ONHOLD_RINGING = 20;
    public static final int MPCALLSTATE_HOLDCC_ACTIVE_RINGING = 21;
    public static final int MPCALLSTATE_HOLDCC = 22;
    public static final int MPCALLSTATE_CC_ONHOLD = 23;
    public static final int MPCALLSTATE_HOLDCC_ACTIVE = 24;
    public static final int MPCALLSTATE_ONHOLD = 25;
    public static final int MPCALLSTATE_CC_RINGING = 26;
    public static final int MPCALLSTATE_RINGING_DISCONNECTING = 27;
    public static final int MPCALLSTATE_ACTIVE_RINGING_DISCONNECTING = 28;
    public static final int MPCALLSTATE_CC_RINGING_DISCONNECTING = 29;
    public static final int MPCALLSTATE_ONHOLD_RINGING_DISCONNECTING = 30;
    public static final int MPCALLSTATE_HOLDCC_RINGING_DISCONNECTING = 31;
    public static final int MPCALLSTATE_DISCONNECTINGCC = 32;
    public static final int MPCALLSTATE_ACTIVE_DISCONNECTINGCC = 33;
    public static final int MPCALLSTATE_ONHOLD_DISCONNECTINGCC = 34;
    public static final int MPCALLSTATE_ACTIVE_ONHOLD_DISCONNECTINGCC = 35;
    public static final int CALLMODEL_IDLE = 0;
    public static final int CALLMODEL_1_RINGING = 1;
    public static final int CALLMODEL_1_ACTIVE = 2;
    public static final int CALLMODEL_1_DIALING = 3;
    public static final int CALLMODEL_1_DISCONNECTING = 4;
    public static final int CALLMODEL_1_ON_HOLD = 5;
    public static final int CALLMODEL_1_ACTIVE_1_RINGING = 6;
    public static final int CALLMODEL_1_ON_HOLD_1_RINGING = 7;
    public static final int CALLMODEL_1_ACTIVE_1_ON_HOLD = 8;
    public static final int CALLMODEL_1_ON_HOLD_1_DIALING = 9;
    public static final int CALLMODEL_1_ACTIVE_1_ON_HOLD_1_RINGING = 10;
    public static final int CALLMODEL_2_DISCONNECTING = 11;
    public static final int CALLMODEL_1_CONFERENCE = 12;
    public static final int CALLMODEL_1_CONFERENCE_1_DISCONNECTING = 13;
    public static final int CALLMODEL_1_CONFERENCE_ON_HOLD = 14;
    public static final int CALLMODEL_1_CONFERENCE_ON_HOLD_1_ACTIVE = 15;
    public static final int CALLMODEL_1_CONFERENCE_ON_HOLD_1_DIALING = 16;
    public static final int CALLMODEL_AUTO_REDIAL = 17;
    public static final int CALLMODEL_1_CONFERENCE_1_ON_HOLD = 18;
    public static final int CALLMODEL_1_CONFERENCE_1_ON_HOLD_1_RINGING = 19;
    public static final int CALLMODEL_1_ACTIVE_1_CONFERENCE_ON_HOLD_1_RINGING = 20;
    public static final int CALLMODEL_3_DISCONNECTING = 21;
    public static final int CALLMODEL_1_RINGING_1_DISCONNECTING = 22;
    public static final int CALLMODEL_1_ACTIVE_1_RINGING_1_DISCONNECTING = 23;
    public static final int CALLMODEL_1_ON_HOLD_1_RINGING_1_DISCONNECTING = 24;
    public static final int CALLMODEL_1_DISCONNECTINGCC = 25;
}

