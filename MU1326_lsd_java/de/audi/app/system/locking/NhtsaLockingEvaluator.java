/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.app.system.locking.NhtsaEvaluationRequirements;
import de.audi.atip.log.LogChannel;

final class NhtsaLockingEvaluator {
    private final LogChannel logChannel;

    public NhtsaLockingEvaluator(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public boolean evaluate(NhtsaEvaluationRequirements nhtsaEvaluationRequirements) {
        if (nhtsaEvaluationRequirements.isCarTypeAutomatic()) {
            return this.evaluateNhtsaDefinitionForAutomaticCars(nhtsaEvaluationRequirements);
        }
        return this.evaluateNhtsaDefinitionForManualShiftCars(nhtsaEvaluationRequirements);
    }

    private boolean evaluateNhtsaDefinitionForManualShiftCars(NhtsaEvaluationRequirements nhtsaEvaluationRequirements) {
        this.logChannel.log(10000000, "NhtsaLockingEvaluator#evaluateNhtsaDefinitionForManualShiftCars() --> Entered.");
        if (nhtsaEvaluationRequirements.isVehicleSpeedExceeded()) {
            return true;
        }
        if (!nhtsaEvaluationRequirements.isParkingBrakeEngaged()) {
            return true;
        }
        if (nhtsaEvaluationRequirements.isNGearDetectionPossible()) {
            return nhtsaEvaluationRequirements.getCurrentGear() != 0;
        }
        return !nhtsaEvaluationRequirements.isClutchClutchedIn();
    }

    private boolean evaluateNhtsaDefinitionForAutomaticCars(NhtsaEvaluationRequirements nhtsaEvaluationRequirements) {
        this.logChannel.log(10000000, "NhtsaLockingEvaluator#evaluateNhtsaDefinitionForAutomaticCars() --> Entered.");
        return nhtsaEvaluationRequirements.getTransmission() != 1;
    }
}

