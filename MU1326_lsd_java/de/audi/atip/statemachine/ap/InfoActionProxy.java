/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface InfoActionProxy
extends ActionProxy {
    public void tmcMapLeft(int var1);

    public void tmcExitMainScreen(int var1);

    public void tmcEnterMainScreen(int var1);

    public void tmcEnterScreens(int var1);

    public void tmcExitScreens(int var1);

    public void tmcEnterDetailsScreen(int var1);

    public void tmcExitDetailsScreen(int var1);
}

