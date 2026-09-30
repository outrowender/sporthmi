/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

public interface ILockingEvaluator {
    public boolean evaluateSpeedDefinition();

    public boolean evaluateNhtsaDefinition();

    public boolean evaluateEngineOffDefinition();
}

