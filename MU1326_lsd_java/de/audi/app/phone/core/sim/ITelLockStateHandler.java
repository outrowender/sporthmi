/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;

public interface ITelLockStateHandler {
    public void unlockSIMwithPIN(String var1, int var2, ITelDSIResponseListener var3);

    public void setPINSpeller(String var1);
}

