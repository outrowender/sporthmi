/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EcallActionProxy
extends ActionProxy {
    public void ecallAppEntered(int var1);

    public void ecallAppLeft(int var1);

    public void hkBackForOprPopupAutomatic(int var1);

    public void sysInitConnectEntered(int var1);

    public void sysInitConnectLeft(int var1);

    public void sysInitPhoneEntered(int var1);

    public void sysInitPhoneLeft(int var1);

    public void btnPerformTest(int var1);
}

