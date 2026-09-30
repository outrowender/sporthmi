/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface InfoService {
    public static final int TIM_NOT_AVAILABLE = 0;
    public static final int TIM_AVAILABLE = 1;
    public static final int TIM_RECORDING = 2;
    public static final int TMC_MESSAGES_NOT_AVAILABLE = 0;
    public static final int TMC_MESSAGES_AVAILABLE = 1;

    public int getTPInfoAvailable();

    public void speakTmcMessages(boolean var1);

    public void speakTIMMessages(boolean var1);
}

