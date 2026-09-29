/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface VolumeOnOffPressListener {
    public static final int UNDEFINED;
    public static final int SMS_READOUT;
    public static final int ONLINE_READOUT;
    public static final int ADDRESSBOOK_READOUT;
    public static final int TMC_READOUT;
    public static final int TOUCHPAD_READOUT;

    default public void volumeOnOffPressed(int n) {
    }
}

