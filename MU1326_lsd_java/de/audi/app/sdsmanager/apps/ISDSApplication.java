/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.syscall.ISystemCallParameter;

public interface ISDSApplication {
    default public int[] getCommands() {
    }

    default public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
    }

    default public void sessionEnded() {
    }

    default public void sessionStarted() {
    }

    default public boolean ignoreJoystick() {
    }

    default public void recognizerOpen(boolean bl) {
    }

    default public boolean freezeLists() {
    }

    default public boolean unfreezeLists() {
    }

    default public boolean isListLineDataGetActive() {
    }

    default public void sdsListLineDataGet(int n, int n2) {
    }

    default public void entrySelected(int n) {
    }
}

