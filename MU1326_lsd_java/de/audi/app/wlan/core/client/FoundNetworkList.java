/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.client.IFoundNetworkList;
import de.audi.app.wlan.core.client.ITrustedNetworkList;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.networking.DiscoveredNetwork;

class FoundNetworkList
implements IFoundNetworkList {
    private static final int NUM_COLUMNS;
    private static final int ID_ADDRESS;
    private static final int ID_NAME;
    private static final int ID_CONNECTED;
    private static final int ID_SIGNAL;
    private LogChannel log;
    private final BaseListModelApp listModel;
    private final Map map;
    private final ITrustedNetworkList networkList;
    private int idCounter = 0;

    FoundNetworkList(LogChannel logChannel, BaseListModelApp baseListModelApp, ITrustedNetworkList iTrustedNetworkList) {
        this.log = logChannel;
        this.listModel = baseListModelApp;
        this.map = new HashMap();
        this.networkList = iTrustedNetworkList;
    }

    @Override
    public void add(DiscoveredNetwork discoveredNetwork) {
        this.log.log(-2137614336, "FoundNetworkList#add(): %1, %2", (Object)discoveredNetwork.getNetworkName(), (Object)discoveredNetwork.getBssidAddress());
        if (this.map.put(discoveredNetwork.getBssidAddress(), discoveredNetwork) == null) {
            EvoListRow evoListRow = new EvoListRow(this.idCounter++, 4);
            evoListRow.setText(0, discoveredNetwork.getBssidAddress());
            evoListRow.setText(1, discoveredNetwork.getNetworkName());
            evoListRow.setInteger(2, this.networkList != null && this.networkList.isConnected(discoveredNetwork.getBssidAddress()) ? 1 : 0);
            evoListRow.setInteger(3, discoveredNetwork.gethSignalStrength());
            this.listModel.append(evoListRow);
        }
    }

    @Override
    public void clear() {
        this.map.clear();
        this.listModel.removeAll();
        this.idCounter = 0;
    }

    @Override
    public DiscoveredNetwork getNetwork(int n) {
        if (n >= 0 && n < this.listModel.getLength()) {
            return (DiscoveredNetwork)this.map.get(this.listModel.getRow(n).getText(0));
        }
        return null;
    }

    public void init() {
    }

    public void deinit() {
        this.map.clear();
        this.listModel.removeAll();
    }
}

