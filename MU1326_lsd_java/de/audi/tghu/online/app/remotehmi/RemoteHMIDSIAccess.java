/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IRemoteHMI;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.ArrayList;

public class RemoteHMIDSIAccess {
    private static final int CACHE_SIZE;
    private IRemoteHMI dsi;
    private final LogChannel logChannel;
    private ArrayList dsiListeners = new ArrayList(1);
    private ArrayList actionCache = new ArrayList(100);
    private ArrayList actionContextCache = new ArrayList(100);

    public RemoteHMIDSIAccess(LogChannel logChannel) {
        this(logChannel, null);
    }

    public RemoteHMIDSIAccess(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
    }

    public void setIRemoteHMI(IRemoteHMI iRemoteHMI) {
        this.dsi = iRemoteHMI;
        this.informDSIListeners();
        this.logChannel.log(1078071040, "RemoteHMIDSIAccess#setIRemoteHMI: sending cached actions.");
        for (int i2 = 0; i2 < this.actionCache.size(); ++i2) {
            this.action((String)this.actionContextCache.get(i2), (RemoteHMIAction)this.actionCache.get(i2));
        }
        this.actionCache.clear();
        this.actionContextCache.clear();
    }

    public void action(String string, RemoteHMIAction remoteHMIAction) {
        int n = remoteHMIAction.getType();
        if (this.dsi == null) {
            int n2;
            switch (n) {
                case 1: 
                case 451: 
                case 10008900: 
                case 100000011: {
                    n2 = 1078071040;
                    break;
                }
                default: {
                    n2 = -1601830656;
                }
            }
            this.logChannel.log(n2, "RemoteHMIDSIAccess#action: no DSI, action ID is %1", (long)n);
            if (this.actionCache.size() < 100) {
                this.logChannel.log(n2, "RemoteHMIDSIAccess#action: no DSI, add action to cache", (long)n);
                this.actionCache.add(remoteHMIAction);
                this.actionContextCache.add(string);
            }
            return;
        }
        this.logChannel.log(1078071040, "RemoteHMIDSIAccess#action: called for action type '%1'", (long)n);
        this.dsi.action(string, remoteHMIAction);
    }

    public boolean hasDSI() {
        return this.dsi != null;
    }

    public void setHMILanguage(String string) {
        if (this.dsi == null) {
            this.logChannel.log(10000, "RemoteHMIDSIAccess#setHMILanguage: no DSI");
            return;
        }
        this.dsi.setHMILanguage(string);
    }

    public void setContext(String string) {
        if (this.dsi == null) {
            this.logChannel.log(10000, "RemoteHMIDSIAccess#setContext: no DSI");
            return;
        }
        this.dsi.setContext(string);
    }

    public void resetToFactorySettings() {
        if (this.dsi == null) {
            this.logChannel.log(10000, "RemoteHMIDSIAccess#resetToFactorySettings: no DSI");
            return;
        }
        this.dsi.resetToFactorySettings();
    }

    public void addDSIListener(RemoteHMIDSIAccess$IRemoteHMIDSIListener remoteHMIDSIAccess$IRemoteHMIDSIListener) {
        this.dsiListeners.add(remoteHMIDSIAccess$IRemoteHMIDSIListener);
        if (this.dsi != null) {
            remoteHMIDSIAccess$IRemoteHMIDSIListener.remoteHmiDsiReady();
        }
    }

    public void informDSIListeners() {
        RemoteHMIDSIAccess$IRemoteHMIDSIListener[] remoteHMIDSIAccess$IRemoteHMIDSIListenerArray = (RemoteHMIDSIAccess$IRemoteHMIDSIListener[])this.dsiListeners.toArray(new RemoteHMIDSIAccess$IRemoteHMIDSIListener[this.dsiListeners.size()]);
        if (remoteHMIDSIAccess$IRemoteHMIDSIListenerArray == null) {
            return;
        }
        for (int i2 = 0; i2 < remoteHMIDSIAccess$IRemoteHMIDSIListenerArray.length; ++i2) {
            remoteHMIDSIAccess$IRemoteHMIDSIListenerArray[i2].remoteHmiDsiReady();
        }
    }
}

