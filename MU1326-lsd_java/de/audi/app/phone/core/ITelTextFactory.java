/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

public interface ITelTextFactory {
    public static final int MAILBOX_CALL;
    public static final int CONFERENCE_CALL;
    public static final int INFO_CALL;
    public static final int BREAKDOWN_CALL;
    public static final int EMERGENCY_CALL;
    public static final int P_CALL;
    public static final int C_CALL;
    public static final int B_CALL;
    public static final int UNKNOWN;
    public static final int CHINA_MOBILE;
    public static final int CHINA_TELECOM;
    public static final int CHINA_UNICOM;
    public static final int CHINA_CMCC;
    public static final int SIM_CARD;

    default public String getText(int n) {
    }
}

