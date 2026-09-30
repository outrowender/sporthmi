/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.app.system.locking.SpeedEvaluationRequirements;
import de.audi.atip.log.LogChannel;

final class SpeedLockingEvaluator {
    private final LogChannel logChannel;

    public SpeedLockingEvaluator(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public boolean evaluate(SpeedEvaluationRequirements speedEvaluationRequirements) {
        this.logChannel.log(10000000, "SpeedLockingEvaluator#evaluate(%1)", (Object)speedEvaluationRequirements);
        return speedEvaluationRequirements.isVehicleSpeedExceeded();
    }
}

