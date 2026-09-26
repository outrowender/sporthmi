/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.SMModule;

public interface SystemSMM
extends SMModule {
    default public void registerSMM(ApplicationSMM applicationSMM) {
    }

    default public void deregisterSMM(ApplicationSMM applicationSMM) {
    }
}

