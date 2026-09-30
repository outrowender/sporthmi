/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

interface IFoundDeviceList {
    public void add(DiscoveredDevice var1);

    public void clear();

    public DiscoveredDevice getDevice(EvoListRow var1);
}

