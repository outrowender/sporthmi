/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.IFoundDeviceList;
import de.audi.app.bluetooth.core.connectivity.trusted.ITrustedDeviceList;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public abstract class AbstractFoundDeviceList
implements IFoundDeviceList {
    protected LogChannel log;
    protected final BaseListModelApp listModel;
    private final Map map;
    protected final ITrustedDeviceList trustedDevices;
    private int idCounter = 0;

    public AbstractFoundDeviceList(LogChannel logChannel, BaseListModelApp baseListModelApp, ITrustedDeviceList iTrustedDeviceList) {
        this.log = logChannel;
        this.listModel = baseListModelApp;
        this.map = new HashMap();
        this.trustedDevices = iTrustedDeviceList;
    }

    @Override
    public void add(DiscoveredDevice discoveredDevice) {
        EvoListRow evoListRow;
        this.log.log(-2137614336, "AbstractFoundDeviceList#add(): %1, %2", (Object)discoveredDevice.getDeviceName(), (Object)discoveredDevice.getDeviceAddress());
        if (this.map.put(discoveredDevice.getDeviceAddress(), discoveredDevice) == null && (evoListRow = this.getFoundDeviceRow(this.idCounter, discoveredDevice)) != null) {
            ++this.idCounter;
            this.addToList(evoListRow);
        }
    }

    protected abstract EvoListRow getFoundDeviceRow(int n, DiscoveredDevice discoveredDevice) {
    }

    protected abstract void addToList(EvoListRow evoListRow) {
    }

    protected boolean isConnected(DiscoveredDevice discoveredDevice) {
        return this.trustedDevices != null && this.trustedDevices.isConnected(discoveredDevice.getDeviceAddress());
    }

    @Override
    public void clear() {
        this.map.clear();
        this.listModel.removeAll();
        this.idCounter = 0;
    }

    @Override
    public DiscoveredDevice getDevice(EvoListRow evoListRow) {
        return (DiscoveredDevice)this.map.get(evoListRow.getText(0));
    }

    public void init() {
    }

    public void deinit() {
        this.map.clear();
        this.listModel.removeAll();
    }
}

