/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.MediatorRegistry;

public interface MediatorManager
extends MediatorRegistry {
    default public void fireEvent(int n) {
    }

    default public void lockScreen() {
    }

    default public void unlockScreen() {
    }

    default public HMIModel getModel(int n) {
    }

    default public LogChannel getLogChannel() {
    }

    default public LogChannel getEventLogChannel() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public void resetJumpBackPoint(int n, int n2) {
    }
}

