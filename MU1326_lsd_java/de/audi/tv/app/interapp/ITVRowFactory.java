/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IRowProperties;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface ITVRowFactory {
    default public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n) {
    }

    default public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n, boolean bl) {
    }

    default public IRowProperties createProperties(ServiceInfo serviceInfo) {
    }
}

