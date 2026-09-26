/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IHMITerminalRegistry;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.keyhandling.IKeyEventDistributor;
import de.audi.atip.log.LogChannel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class HMITerminalRegistry
implements IHMITerminalRegistry {
    private IFrameworkAccess framework;
    private LogChannel log;
    private final Map allTerminals;
    private IDisplayManager displayManager;
    private final IRootWindow[] rootWindows;
    private final IKeyEventDistributor[] keyEventDistributors;
    private final ITerminalContext[] terminalContexts;
    private String currentSkin;
    private TTSSessionBasedService ttsService;
    private boolean unsupported = false;

    public HMITerminalRegistry(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.HMIService.HMI");
        this.allTerminals = Collections.synchronizedMap(new HashMap());
        this.rootWindows = new IRootWindow[8];
        this.keyEventDistributors = new IKeyEventDistributor[8];
        this.terminalContexts = new ITerminalContext[8];
    }

    @Override
    public void registerTerminal(int n, String string, HMITerminal hMITerminal) {
        this.log.log(1078071040, "HMITerminalRegistry#registerTerminal %2 %1", (Object)string, (long)n);
        HMITerminal[] hMITerminalArray = (HMITerminal[])this.allTerminals.get(string);
        if (hMITerminalArray == null) {
            hMITerminalArray = new HMITerminal[8];
            this.allTerminals.put(string, hMITerminalArray);
        }
        hMITerminalArray[n] = hMITerminal;
    }

    @Override
    public HMITerminal getTerminal(int n) {
        HMITerminal[] hMITerminalArray;
        if (this.framework.isFrontMU()) {
            if (n == 3 || n == 4) {
                if (n == 3) {
                    this.log.log(1000, "HMITerminalRegistry#getTerminal requesting terminal: %1 on frontunit, return terminal: %2", (long)n, 0L);
                    n = 0;
                } else {
                    this.log.log(1000, "HMITerminalRegistry#getTerminal requesting terminal: %1 on frontunit, return terminal: %2", (long)n, (long)0);
                    n = 2;
                }
            }
        } else if (n == 0 || n == 2) {
            if (n == 0) {
                this.log.log(1000, "HMITerminalRegistry#getTerminal requesting terminal: %1 on rearseatunit, return terminal: %2", (long)n, (long)0);
                n = 3;
            } else {
                this.log.log(1000, "HMITerminalRegistry#getTerminal requesting terminal: %1 on rearseatunit, return terminal: %2", (long)n, (long)0);
                n = 4;
            }
        }
        if ((hMITerminalArray = (HMITerminal[])this.allTerminals.get(this.currentSkin)) == null) {
            this.log.log(10000, "HMITerminalRegistry#getTerminal no terminals for skin %1", (Object)this.currentSkin);
            this.framework.getErrorMgr().handleError(null, "HMITerminalRegistry#getTerminal no terminals set", 0, 3, 0);
            return null;
        }
        if (hMITerminalArray[n] != null) {
            if (!hMITerminalArray[n].isStarted()) {
                this.log.log(10000, "HMITerminalRegistry#getTerminal terminal %1 not started ", (long)n);
                hMITerminalArray[n].start();
            }
        } else {
            this.log.log(10000, "HMITerminalRegistry#getTerminal no terminal for terminalID %1", (long)n);
            this.framework.getErrorMgr().handleError(null, "HMITerminalRegistry#getTerminal no terminals set for terminal", 0, 3, 0);
        }
        return hMITerminalArray[n];
    }

    protected void setSkin(String string) {
        if (!string.equalsIgnoreCase(this.currentSkin)) {
            this.stopOldTerminals();
        }
        this.currentSkin = string;
        HMITerminal[] hMITerminalArray = (HMITerminal[])this.allTerminals.get(this.currentSkin);
        if (hMITerminalArray == null) {
            this.log.log(10000, "HMITerminalRegistry#setSkin no terminals registered for skin %1 yet", (Object)string);
        } else if (this.unsupported) {
            this.setUnsupportedDevelopmentBuild(true);
        }
    }

    private void stopOldTerminals() {
        HMITerminal[] hMITerminalArray = (HMITerminal[])this.allTerminals.get(this.currentSkin);
        if (hMITerminalArray != null) {
            for (int i2 = 0; i2 < hMITerminalArray.length; ++i2) {
                if (hMITerminalArray[i2] == null || !hMITerminalArray[i2].isStarted()) continue;
                hMITerminalArray[i2].stop();
            }
        }
    }

    protected void setUnsupportedDevelopmentBuild(boolean bl) {
        this.log.log(1078071040, "HMITerminalRegistry#setUnsupportedDevelopmentBuild unsupported: %1", bl);
        this.unsupported = bl;
        HMITerminal[] hMITerminalArray = (HMITerminal[])this.allTerminals.get(this.currentSkin);
        if (hMITerminalArray != null) {
            for (int i2 = 0; i2 < hMITerminalArray.length; ++i2) {
                IGUIManager iGUIManager;
                if (hMITerminalArray[i2] == null || (iGUIManager = hMITerminalArray[i2].getGUIManager()) == null) continue;
                iGUIManager.setUnsupportedDevelopmentBuild(bl);
            }
        }
    }

    @Override
    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        this.ttsService = tTSSessionBasedService;
        this.propagateTTSServiceChange();
    }

    private void propagateTTSServiceChange() {
        HMITerminal[] hMITerminalArray;
        Collection collection = this.allTerminals.values();
        Iterator iterator = collection.iterator();
        if (iterator.hasNext() && (hMITerminalArray = (HMITerminal[])iterator.next()) != null) {
            for (int i2 = 0; i2 < hMITerminalArray.length; ++i2) {
                if (hMITerminalArray[i2] == null) continue;
                hMITerminalArray[i2].setTTSService(this.ttsService);
            }
        }
    }

    @Override
    public void registerRootWindow(int n, IRootWindow iRootWindow) {
        if (n >= 0 && n < 8) {
            this.rootWindows[n] = iRootWindow;
        }
    }

    @Override
    public void registerKeyEventDistributor(int n, IKeyEventDistributor iKeyEventDistributor) {
        if (n >= 0 && n < 8) {
            this.keyEventDistributors[n] = iKeyEventDistributor;
        }
    }

    @Override
    public IRootWindow getRootWindow(int n) {
        if (n >= 0 && n < 8) {
            return this.rootWindows[n];
        }
        return null;
    }

    @Override
    public IKeyEventDistributor getKeyEventDistributor(int n) {
        if (n >= 0 && n < 8) {
            return this.keyEventDistributors[n];
        }
        return null;
    }

    @Override
    public ITerminalContext getTerminalContext(int n) {
        if (n >= 0 && n < 8) {
            return this.terminalContexts[n];
        }
        return null;
    }

    @Override
    public void registerTerminalContext(int n, ITerminalContext iTerminalContext) {
        if (n >= 0 && n < 8) {
            this.terminalContexts[n] = iTerminalContext;
        }
    }

    @Override
    public IDisplayManager getDisplayManager() {
        return this.displayManager;
    }

    @Override
    public void registerDisplayManager(IDisplayManager iDisplayManager) {
        this.displayManager = iDisplayManager;
    }
}

