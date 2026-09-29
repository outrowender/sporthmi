/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.app.system.locking.AbstractLockingEvaluator;
import de.audi.app.system.locking.LockingBitWrapper;
import de.audi.app.system.locking.NhtsaEvaluationRequirements;
import de.audi.app.system.locking.NhtsaLockingEvaluator;
import de.audi.app.system.locking.SpeedEvaluationRequirements;
import de.audi.app.system.locking.SpeedLockingEvaluator;
import de.audi.atip.base.IFrameworkAccess;

public final class LockingEvaluator
extends AbstractLockingEvaluator {
    private final NhtsaLockingEvaluator nhtsaEvaluator;
    private final SpeedLockingEvaluator speedEvaluator;

    public LockingEvaluator(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        this.nhtsaEvaluator = new NhtsaLockingEvaluator(this.logChannel);
        this.speedEvaluator = new SpeedLockingEvaluator(this.logChannel);
    }

    @Override
    public boolean evaluateSpeedDefinition() {
        this.logChannel.log(-2137614336, "LockingEvaluator#evaluateSpeedDefinition() --> Entered.");
        SpeedEvaluationRequirements speedEvaluationRequirements = new SpeedEvaluationRequirements(this.speedThresholdExeeded);
        return this.speedEvaluator.evaluate(speedEvaluationRequirements);
    }

    @Override
    public boolean evaluateNhtsaDefinition() {
        this.logChannel.log(-2137614336, "LockingEvaluator#evaluateNhtsaDefinition() --> Entered.");
        if (this.generalVehicleStateDsi == null || this.carVehicleStateDsi == null || this.dynamicVehicleInfoMidFrequent == null || this.dynamicVehicleInfoMidFrequentViewOptions == null) {
            this.logChannel.log(1078071040, "LockingEvaluator#evaluateConditions() <-- Returning 'false' as at least one DSI ist not available or hasn't sent any data yet. No locking due to missing information");
            return false;
        }
        if (!this.clamp15) {
            this.logChannel.log(-2137614336, "LockingEvaluator#evaluateNhtsaDefinition() - Clamp15 is off, no locking (clamp15=%1)", this.clamp15);
            return false;
        }
        int n = this.automaticGearShiftTransMode;
        int n2 = this.dynamicVehicleInfoMidFrequent.getCurrentGear();
        boolean bl = this.dynamicVehicleInfoMidFrequentViewOptions.getAutomaticGearShiftTransMode().getState() != 0;
        boolean bl2 = this.dynamicVehicleInfoMidFrequent.getClutch() == 1;
        boolean bl3 = this.dynamicVehicleInfoMidFrequentViewOptions.getCurrentGear().getState() != 0;
        boolean bl4 = this.speedThresholdExeeded;
        boolean bl5 = this.parkingBrakeEngaged;
        NhtsaEvaluationRequirements nhtsaEvaluationRequirements = new NhtsaEvaluationRequirements(bl, n, bl2, n2, bl3, bl4, bl5);
        return this.nhtsaEvaluator.evaluate(nhtsaEvaluationRequirements);
    }

    @Override
    public boolean evaluateEngineOffDefinition() {
        this.logChannel.log(-2137614336, "LockingEvaluator#evaluateEngineOffDefinition() --> Entered.");
        this.logChannel.log(-1601830656, "LockingEvaluator#evaluateEngineOffDefinition() - Engine OFF definition is not implemented, no locking.");
        return false;
    }

    @Override
    public boolean isNowPlayingScreenLockedByNhtsaCoding() {
        int n = LockingBitWrapper.getFunctionalBitState(166);
        int n2 = LockingBitWrapper.getFunctionalBitState(167);
        int n3 = LockingBitWrapper.getFunctionalBitState(127);
        return n == 1 && n2 == 0 && n3 == 1;
    }
}

