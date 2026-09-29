/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IRowProperties;
import de.audi.tv.app.lists.TVEvoStationRow;
import de.audi.tv.app.lists.TVRowProperties;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVEvoRowFactory
implements ITVRowFactory {
    @Override
    public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n) {
        return new TVEvoStationRow(l, serviceInfo, n, this);
    }

    @Override
    public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n, boolean bl) {
        return new TVEvoStationRow(l, serviceInfo, n, bl, this);
    }

    @Override
    public IRowProperties createProperties(ServiceInfo serviceInfo) {
        return new TVRowProperties(TVUtil.isVideoService(serviceInfo) ? -597584210 : -234836044);
    }
}

