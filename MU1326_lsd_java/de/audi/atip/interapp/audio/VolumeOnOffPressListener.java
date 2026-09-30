/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface VolumeOnOffPressListener {
    public static final int UNDEFINED = -1;
    public static final int SMS_READOUT = 0;
    public static final int ONLINE_READOUT = 1;
    public static final int ADDRESSBOOK_READOUT = 2;
    public static final int TMC_READOUT = 3;
    public static final int TOUCHPAD_READOUT = 4;

    public void volumeOnOffPressed(int var1);
}

