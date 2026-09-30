/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.syscall.ISystemCallParameter;

public interface ISDSApplication {
    public int[] getCommands();

    public void processCommand(int var1, ISystemCallParameter[] var2);

    public void sessionEnded();

    public void sessionStarted();

    public boolean ignoreJoystick();

    public void recognizerOpen(boolean var1);

    public boolean freezeLists();

    public boolean unfreezeLists();

    public boolean isListLineDataGetActive();

    public void sdsListLineDataGet(int var1, int var2);

    public void entrySelected(int var1);
}

