/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface EarlyAppsActionProxy
extends ActionProxy {
    public void volumeLoweredEntertainmnetExited(int var1);

    public void carMenusEnteredEarly(int var1, boolean var2);

    public void phevGoodbyeEntered(int var1, boolean var2);
}

