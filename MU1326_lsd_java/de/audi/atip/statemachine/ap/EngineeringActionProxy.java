/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EngineeringActionProxy
extends ActionProxy {
    public void EngineeringTestProxy(int var1);

    public void startSystemUpTimer(int var1);

    public void stopSystemUpTimer(int var1);

    public void enterREM(int var1);

    public void leaveREM(int var1);
}

