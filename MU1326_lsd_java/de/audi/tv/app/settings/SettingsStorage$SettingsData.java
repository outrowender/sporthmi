/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.settings.SettingsStorage$1;

class SettingsStorage$SettingsData {
    volatile boolean subtitle = false;
    volatile boolean serviceLinking = true;
    volatile boolean visualAudio = true;
    volatile boolean ews = true;
    volatile int tvNorm = 100;
    volatile int avNorm = 0;
    volatile int tvAspectRatio = 0;
    volatile int avAspectRatio = 1;
    volatile int channelSorting = 0;
    volatile int parentalLevel = 0;
    volatile int tvBrightness = 0;
    volatile int tvColor = 0;
    volatile int tvContrast = 0;
    volatile int tvTint = 0;
    volatile int avBrightness = 0;
    volatile int avColor = 0;
    volatile int avContrast = 0;
    volatile int avTint = 0;
    volatile int[] viewSettings = new int[0];

    private SettingsStorage$SettingsData() {
    }

    /* synthetic */ SettingsStorage$SettingsData(SettingsStorage$1 settingsStorage$1) {
        this();
    }
}

