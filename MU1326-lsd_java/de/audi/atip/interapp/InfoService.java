/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface InfoService {
    public static final int TIM_NOT_AVAILABLE;
    public static final int TIM_AVAILABLE;
    public static final int TIM_RECORDING;
    public static final int TMC_MESSAGES_NOT_AVAILABLE;
    public static final int TMC_MESSAGES_AVAILABLE;

    default public int getTPInfoAvailable() {
    }

    default public void speakTmcMessages(boolean bl) {
    }

    default public void speakTIMMessages(boolean bl) {
    }
}

