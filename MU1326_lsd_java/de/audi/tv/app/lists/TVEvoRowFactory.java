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
    public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n) {
        return new TVEvoStationRow(l, serviceInfo, n, this);
    }

    public AbstractTVStationRow createTVStationRow(long l, ServiceInfo serviceInfo, int n, boolean bl) {
        return new TVEvoStationRow(l, serviceInfo, n, bl, this);
    }

    public IRowProperties createProperties(ServiceInfo serviceInfo) {
        return new TVRowProperties(TVUtil.isVideoService(serviceInfo) ? -1365876260 : -1263599374);
    }
}

