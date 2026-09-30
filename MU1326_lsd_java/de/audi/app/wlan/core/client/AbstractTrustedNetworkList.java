/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 *  de.mib.swdiagnosis.connectivity.TrustedNetworksDiag
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.client.CommandDeleteTrustedNetwork;
import de.audi.app.wlan.core.client.ITrustedNetworkList;
import de.audi.app.wlan.core.client.Network;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import de.mib.swdiagnosis.connectivity.TrustedNetworksDiag;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.networking.DiscoveredNetwork;

public abstract class AbstractTrustedNetworkList
extends AbstractWlanComponent
implements ITrustedNetworkList {
    private final int[] attributeNotifications = new int[]{21, 20};
    private static final int DISCONNECTED = 0;
    private static final int CONNECTED = 1;
    private final Map map = new HashMap();
    private volatile String[] networkNames;
    private volatile String[] bssidAddresses;
    private volatile int[] encryptionTypes;
    private volatile String connectedNetwork;
    private final ChoiceModelApp tetheringConnectedChoice = this.getChoiceModel(2500224);
    private final ChoiceModelApp deleteTrustedNetworkResult = this.getChoiceModel(0x262660);

    public AbstractTrustedNetworkList(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public void deleteTrustedNetwork(String string) {
        if (this.map.containsKey(string = string.toLowerCase())) {
            String string2 = ((Network)this.map.get(string)).getNetworkName();
            ChoiceModelApp choiceModelApp = this.getDeleteTrustedNetworkCommandMonitor();
            CommandDeleteTrustedNetwork.schedule(this.wlanApplication, this.dsiWlan, string2, string, choiceModelApp);
        }
    }

    protected ChoiceModelApp getDeleteTrustedNetworkCommandMonitor() {
        return this.deleteTrustedNetworkResult;
    }

    public boolean isConnected(String string) {
        return this.connectedNetwork != null && this.connectedNetwork.equals(string.toLowerCase());
    }

    public boolean isConnected() {
        return this.connectedNetwork != null && !"".equals(this.connectedNetwork);
    }

    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        if (n != 1) {
            return;
        }
        if (this.log.isInfo()) {
            this.log.log(1000000, "AbstractTrustedNetworkList#updateTrustedNetworks() %1, %2", (Object)StringUtils.toString(stringArray), (Object)StringUtils.toString(stringArray2));
        }
        this.networkNames = stringArray;
        this.bssidAddresses = stringArray2;
        this.encryptionTypes = nArray;
        this.updateTrustedNetworks();
    }

    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "AbstractTrustedNetworkList#updateConnectedNetwork(): name=%1 address=%2, signal=%3", (Object)string, (Object)string2, (Object)Integer.toString(n));
        this.tetheringConnectedChoice.setValue(string2 == null || "".equals(string2) ? 0 : 1);
        this.connectedNetwork = string2.toLowerCase();
        this.updateTrustedNetworks();
    }

    private void updateTrustedNetworks() {
        this.map.clear();
        if (this.networkNames == null || this.bssidAddresses == null || this.encryptionTypes == null) {
            this.log.log(100000, "AbstractTrustedNetworkList#updateTrustedNetworks(): Invalid data");
        } else {
            for (int i2 = 0; i2 < this.networkNames.length && i2 < this.bssidAddresses.length && i2 < this.encryptionTypes.length; ++i2) {
                if (this.bssidAddresses[i2] == null) continue;
                String string = this.bssidAddresses[i2].toLowerCase();
                this.map.put(string, new Network(this.networkNames[i2], string, this.encryptionTypes[i2], string.equals(this.connectedNetwork)));
            }
        }
        this.updateTrustedNetworks((Network[])this.map.values().toArray(new Network[this.map.size()]));
    }

    protected abstract void updateTrustedNetworks(Network[] var1);

    public boolean isTrusted(String string) {
        Network network = (Network)this.map.get(string = string.toLowerCase());
        return network != null;
    }

    public Network getNetwork(String string) {
        string = string.toLowerCase();
        Network network = (Network)this.map.get(string);
        return network;
    }

    public void init() {
        super.init();
        this.wlanApplication.getDiag().addDiagnosisComponent((IDiagComponent)new TrustedNetworksDiag((ITrustedNetworkList)this));
    }

    public void deinit() {
        this.map.clear();
        super.deinit();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("=== Trusted WLAN networks ===\n");
        Iterator iterator = this.map.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            DiscoveredNetwork discoveredNetwork = (DiscoveredNetwork)this.map.get(string);
            buffer.append(discoveredNetwork.getNetworkName());
            buffer.append(" : ");
            buffer.append(string);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

