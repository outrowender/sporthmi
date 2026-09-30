/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface LoadSpeedThreshold {
    public static final int UP_DOWN_LOAD_DATA_LENGTH = 30;
    public static final int DEFAULT_VALUE_HYSTERESIS = 10;
    public static final int DEFAULT_VALUE_THRESHOLD = 30;

    public int getVideoCutOffThreshold();

    public int getVideoHysteresis();

    public int getSlideshowCutOffThreshold();

    public int getSlideshowHysteresis();

    public int getSlideshowDisplayDuration1();

    public int getSlideshowDisplayDuration2();

    public int getDestinationInputCutOffThreshold();

    public int getDestinationInputHysteresis();

    public int getBtBondingCutOffThreshold();

    public int getBtBondingHysteresis();

    public int getMessagingTextEditorCutOffThreshold();

    public int getMessagingTextEditorHysteresis();

    public int getRadioTextCutOffThreshold();

    public int getRadioTextHysteresis();

    public int getRadioTextDisplayTime();
}

