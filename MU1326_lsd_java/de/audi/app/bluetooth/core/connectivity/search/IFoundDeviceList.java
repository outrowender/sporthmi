/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

interface IFoundDeviceList {
    default public void add(DiscoveredDevice discoveredDevice) {
    }

    default public void clear() {
    }

    default public DiscoveredDevice getDevice(EvoListRow evoListRow) {
    }
}

