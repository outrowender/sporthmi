/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

class WLANDSIListener
implements DSIWLANListener,
ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final WLANDefaultListener wlanDefaultListener;
    private final LogChannel log;

    WLANDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.wlanDefaultListener = new WLANDefaultListener(logChannel);
        this.log = logChannel;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "WLANDSIListener#asyncException():  called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void responseAbortSearch(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseAbortSearch(n);
            }
        });
    }

    public void responseConnectNetwork(final String string, final String string2, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseConnectNetwork(string, string2, n);
            }
        });
    }

    public void responseDeleteTrustedNetwork(final String string, final String string2, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseDeleteTrustedNetwork(string, string2, n);
            }
        });
    }

    public void responseDisconnectNetwork(final String string, final String string2, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseDisconnectNetwork(string, string2, n);
            }
        });
    }

    public void responseFactoryReset(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseFactoryReset(n);
            }
        });
    }

    public void responseNetworkSearch(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseNetworkSearch(n, n2);
            }
        });
    }

    public void responseSetProfile(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseSetProfile(n);
            }
        });
    }

    public void responseSetRFActive(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseSetRFActive(n);
            }
        });
    }

    public void responseSetRole(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).responseSetRole(n);
            }
        });
    }

    public void responseActivateWps(int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                WLANDSIListener.this.log.log(100000, "WLANDSIListener#responseActivateWps not implemented");
            }
        });
    }

    public void updateConnectedNetwork(final String string, final String string2, final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateConnectedNetwork(string, string2, n, n2);
            }
        });
    }

    public void updateDiscoveredNetwork(final DiscoveredNetwork discoveredNetwork, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateDiscoveredNetwork(discoveredNetwork, n);
            }
        });
    }

    public void updateNodeList(final Node[] nodeArray, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateNodeList(nodeArray, n);
            }
        });
    }

    public void updateProfile(final Profile profile, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateProfile(profile, n);
            }
        });
    }

    public void updateRFActive(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateRFActive(n, n2);
            }
        });
    }

    public void updateRole(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateRole(n, n2);
            }
        });
    }

    public void updateStartupState(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateStartupState(n, n2);
            }
        });
    }

    public void updateTrustedNetworks(final String[] stringArray, final String[] stringArray2, final int[] nArray, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateTrustedNetworks(stringArray, stringArray2, nArray, n);
            }
        });
    }

    public void updateWlanEnabled(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIWLANListener)dSIListener).updateWlanEnabled(bl, n);
            }
        });
    }

    public void updateWPSRunning(int n, int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                WLANDSIListener.this.log.log(100000, "WLANDSIListener#updateWPSRunning not implemented");
            }
        });
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.wlanDefaultListener;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }
}

