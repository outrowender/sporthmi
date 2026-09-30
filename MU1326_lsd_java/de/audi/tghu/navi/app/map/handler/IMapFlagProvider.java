/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.handler.MapUserFlag;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;

public interface IMapFlagProvider {
    public IMapFlagProvider setTopDestinations(AdbEntry[] var1);

    public IMapFlagProvider setContext(int var1, boolean var2, boolean var3);

    public IMapFlagProvider setAutomaticFlagHiding(boolean var1);

    public IMapFlagProvider setPicNavMapLocation(NavLocation var1);

    public IMapFlagProvider setOnlinePOIResultList(OnlinePOIResultList var1);

    public IMapFlagProvider setRemoteHMIResultList(OnlinePOIResultList var1);

    public IMapFlagProvider setPicNavCarouselMapPosition(NavLocationWgs84 var1);

    public MapUserFlag[] getMapUserFlags();

    public MapFlag[][] getChangedMapUserFlags(MapFlag[] var1);

    public void copyHandlesBack2MapFlags(MapFlag[] var1);
}

