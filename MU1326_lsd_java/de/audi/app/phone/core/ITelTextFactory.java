/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

public interface ITelTextFactory {
    public static final int MAILBOX_CALL = 0;
    public static final int CONFERENCE_CALL = 1;
    public static final int INFO_CALL = 2;
    public static final int BREAKDOWN_CALL = 3;
    public static final int EMERGENCY_CALL = 4;
    public static final int P_CALL = 5;
    public static final int C_CALL = 6;
    public static final int B_CALL = 7;
    public static final int UNKNOWN = 8;
    public static final int CHINA_MOBILE = 9;
    public static final int CHINA_TELECOM = 10;
    public static final int CHINA_UNICOM = 11;
    public static final int CHINA_CMCC = 12;
    public static final int SIM_CARD = 13;

    public String getText(int var1);
}

