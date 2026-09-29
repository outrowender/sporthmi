/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class ConnectivitySpeedThresholdListener
implements SpeedThresholdListener {
    private static final int BELOW;
    private static final int EXCEED;
    private final LogChannel log;
    private final ChoiceModelApp blueThresholdChoice;

    ConnectivitySpeedThresholdListener(LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        this.log = logChannel;
        this.blueThresholdChoice = choiceModelApp;
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        if (n == 10) {
            this.log.log(1078071040, "ConnectivitySpeedThresholdListener#exceedsUpperThreshold()");
            this.blueThresholdChoice.setValue(1);
        }
    }

    @Override
    public void belowLowerThreshold(int n) {
        if (n == 10) {
            this.log.log(1078071040, "ConnectivitySpeedThresholdListener#belowLowerThreshold()");
            this.blueThresholdChoice.setValue(0);
        }
    }
}

