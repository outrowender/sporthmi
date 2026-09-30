/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.core.kombi.IDisplayConfigurationConstants;

public class DisplayConfigurationConfig
implements IDisplayConfigurationConstants {
    public int getDCVolumeRangeMin() {
        return 0;
    }

    public int getDCVolumeRangeMax() {
        return 255;
    }

    public int getDCVolumeRangeStep() {
        return 1;
    }

    public int getDCBrightnessRangeMin() {
        return 0;
    }

    public int getDCBrightnessRangeMax() {
        return 100;
    }

    public int getDCBrightnessRangeStep() {
        return 1;
    }

    public long getWatchdogTimeout() {
        return 1000L;
    }
}

