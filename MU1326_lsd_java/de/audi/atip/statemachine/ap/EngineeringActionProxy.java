/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EngineeringActionProxy
extends ActionProxy {
    default public void EngineeringTestProxy(int n) {
    }

    default public void startSystemUpTimer(int n) {
    }

    default public void stopSystemUpTimer(int n) {
    }

    default public void enterREM(int n) {
    }

    default public void leaveREM(int n) {
    }
}

