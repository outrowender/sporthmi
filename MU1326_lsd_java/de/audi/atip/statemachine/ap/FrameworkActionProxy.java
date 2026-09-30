/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface FrameworkActionProxy
extends ActionProxy {
    public void activeApplication(int var1, int var2);

    public void hkSetupDuringPowerPopup(int var1);

    public void mainApplicationWizardLastApplication(int var1, int var2);
}

