/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EcallActionProxy
extends ActionProxy {
    default public void ecallAppEntered(int n) {
    }

    default public void ecallAppLeft(int n) {
    }

    default public void hkBackForOprPopupAutomatic(int n) {
    }

    default public void sysInitConnectEntered(int n) {
    }

    default public void sysInitConnectLeft(int n) {
    }

    default public void sysInitPhoneEntered(int n) {
    }

    default public void sysInitPhoneLeft(int n) {
    }

    default public void btnPerformTest(int n) {
    }
}

