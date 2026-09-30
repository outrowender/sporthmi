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
    public HMITerminal getTerminal(int var1);

    public void registerTerminal(int var1, String var2, HMITerminal var3);

    public void setTTSService(TTSSessionBasedService var1);

    public IRootWindow getRootWindow(int var1);

    public void registerRootWindow(int var1, IRootWindow var2);

    public IDisplayManager getDisplayManager();

    public void registerDisplayManager(IDisplayManager var1);

    public IKeyEventDistributor getKeyEventDistributor(int var1);

    public void registerKeyEventDistributor(int var1, IKeyEventDistributor var2);

    public ITerminalContext getTerminalContext(int var1);

    public void registerTerminalContext(int var1, ITerminalContext var2);
}

