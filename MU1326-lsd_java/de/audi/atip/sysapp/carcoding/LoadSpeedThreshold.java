/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface LoadSpeedThreshold {
    public static final int UP_DOWN_LOAD_DATA_LENGTH;
    public static final int DEFAULT_VALUE_HYSTERESIS;
    public static final int DEFAULT_VALUE_THRESHOLD;

    default public int getVideoCutOffThreshold() {
    }

    default public int getVideoHysteresis() {
    }

    default public int getSlideshowCutOffThreshold() {
    }

    default public int getSlideshowHysteresis() {
    }

    default public int getSlideshowDisplayDuration1() {
    }

    default public int getSlideshowDisplayDuration2() {
    }

    default public int getDestinationInputCutOffThreshold() {
    }

    default public int getDestinationInputHysteresis() {
    }

    default public int getBtBondingCutOffThreshold() {
    }

    default public int getBtBondingHysteresis() {
    }

    default public int getMessagingTextEditorCutOffThreshold() {
    }

    default public int getMessagingTextEditorHysteresis() {
    }

    default public int getRadioTextCutOffThreshold() {
    }

    default public int getRadioTextHysteresis() {
    }

    default public int getRadioTextDisplayTime() {
    }
}

