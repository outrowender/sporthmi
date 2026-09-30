/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.AbstractFoundDeviceList;
import de.audi.app.bluetooth.core.connectivity.trusted.ITrustedDeviceList;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public class FoundDeviceList
extends AbstractFoundDeviceList {
    private static final int NUM_COLUMNS = 3;

    public FoundDeviceList(LogChannel logChannel, BaseListModelApp baseListModelApp, ITrustedDeviceList iTrustedDeviceList) {
        super(logChannel, baseListModelApp, iTrustedDeviceList);
    }

    protected EvoListRow getFoundDeviceRow(int n, DiscoveredDevice discoveredDevice) {
        EvoListRow evoListRow = new EvoListRow(n, 3);
        evoListRow.setText(0, discoveredDevice != null ? discoveredDevice.getDeviceAddress() : "");
        evoListRow.setText(1, discoveredDevice != null ? discoveredDevice.getDeviceName() : "");
        evoListRow.setInteger(2, this.isConnected(discoveredDevice) ? 1 : 0);
        return evoListRow;
    }

    protected void addToList(EvoListRow evoListRow) {
        EvoListRow evoListRow2 = this.listModel.getRow(0);
        if (evoListRow2 == null) {
            this.listModel.append(evoListRow);
        } else {
            this.listModel.insertBefore(evoListRow2.getUniqueID(), evoListRow);
        }
    }
}

