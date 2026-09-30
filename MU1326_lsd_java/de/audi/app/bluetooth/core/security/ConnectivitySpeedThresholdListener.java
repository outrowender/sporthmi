/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class ConnectivitySpeedThresholdListener
implements SpeedThresholdListener {
    private static final int BELOW = 0;
    private static final int EXCEED = 1;
    private final LogChannel log;
    private final ChoiceModelApp blueThresholdChoice;

    ConnectivitySpeedThresholdListener(LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        this.log = logChannel;
        this.blueThresholdChoice = choiceModelApp;
    }

    public void exceedsUpperThreshold(int n) {
        if (n == 10) {
            this.log.log(1000000, "ConnectivitySpeedThresholdListener#exceedsUpperThreshold()");
            this.blueThresholdChoice.setValue(1);
        }
    }

    public void belowLowerThreshold(int n) {
        if (n == 10) {
            this.log.log(1000000, "ConnectivitySpeedThresholdListener#belowLowerThreshold()");
            this.blueThresholdChoice.setValue(0);
        }
    }
}

