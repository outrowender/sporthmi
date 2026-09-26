/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EarlyAppsActionProxy
extends ActionProxy {
    default public void volumeLoweredEntertainmnetExited(int n) {
    }

    default public void carMenusEnteredEarly(int n, boolean bl) {
    }

    default public void phevGoodbyeEntered(int n, boolean bl) {
    }
}

