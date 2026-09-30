/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.SMModule;

public interface SystemSMM
extends SMModule {
    public void registerSMM(ApplicationSMM var1);

    public void deregisterSMM(ApplicationSMM var1);
}

