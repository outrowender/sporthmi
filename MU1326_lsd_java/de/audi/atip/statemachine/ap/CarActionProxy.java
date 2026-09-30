/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface CarActionProxy
extends ActionProxy {
    public void setIndividualEntered(int var1);

    public void charismaExited(int var1);

    public void ugdoAbort(int var1);

    public void ugdoRestart(int var1);

    public void carMenusEntered(int var1, boolean var2);

    public void browserScreenEntered(int var1);

    public void browserScreenExited(int var1);

    public void charismaEntered(int var1);

    public void resetTruffleSelection(int var1);

    public void browserScreenEnteredByHistory(int var1);

    public void browserScreenStartMediaPlayback(int var1);

    public void browserScreenEndMediaPlayback(int var1);

    public void codriverMovementByDriverScreenExited(int var1);

    public void codriverMovementByDriverScreenEntered(int var1);

    public void setCarContext(int var1, int var2);

    public void ugdoSync(int var1);

    public void charismaMenuStateChange(int var1, int var2);

    public void jokerKeyPopupActive(int var1, int var2);
}

