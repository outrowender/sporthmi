/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IRowProperties;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface ITVRowFactory {
    public AbstractTVStationRow createTVStationRow(long var1, ServiceInfo var3, int var4);

    public AbstractTVStationRow createTVStationRow(long var1, ServiceInfo var3, int var4, boolean var5);

    public IRowProperties createProperties(ServiceInfo var1);
}

