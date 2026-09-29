/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.keyhandling.IKeyEventDistributor;

public interface IHMITerminalRegistry {
    default public HMITerminal getTerminal(int n) {
    }

    default public void registerTerminal(int n, String string, HMITerminal hMITerminal) {
    }

    default public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
    }

    default public IRootWindow getRootWindow(int n) {
    }

    default public void registerRootWindow(int n, IRootWindow iRootWindow) {
    }

    default public IDisplayManager getDisplayManager() {
    }

    default public void registerDisplayManager(IDisplayManager iDisplayManager) {
    }

    default public IKeyEventDistributor getKeyEventDistributor(int n) {
    }

    default public void registerKeyEventDistributor(int n, IKeyEventDistributor iKeyEventDistributor) {
    }

    default public ITerminalContext getTerminalContext(int n) {
    }

    default public void registerTerminalContext(int n, ITerminalContext iTerminalContext) {
    }
}

