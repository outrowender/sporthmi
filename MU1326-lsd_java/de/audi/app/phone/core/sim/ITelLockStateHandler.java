/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;

public interface ITelLockStateHandler {
    default public void unlockSIMwithPIN(String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void setPINSpeller(String string) {
    }
}

