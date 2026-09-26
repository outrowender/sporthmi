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
    default public IMapFlagProvider setTopDestinations(AdbEntry[] adbEntryArray) {
    }

    default public IMapFlagProvider setContext(int n, boolean bl, boolean bl2) {
    }

    default public IMapFlagProvider setAutomaticFlagHiding(boolean bl) {
    }

    default public IMapFlagProvider setPicNavMapLocation(NavLocation navLocation) {
    }

    default public IMapFlagProvider setOnlinePOIResultList(OnlinePOIResultList onlinePOIResultList) {
    }

    default public IMapFlagProvider setRemoteHMIResultList(OnlinePOIResultList onlinePOIResultList) {
    }

    default public IMapFlagProvider setPicNavCarouselMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public MapUserFlag[] getMapUserFlags() {
    }

    default public MapFlag[][] getChangedMapUserFlags(MapFlag[] mapFlagArray) {
    }

    default public void copyHandlesBack2MapFlags(MapFlag[] mapFlagArray) {
    }
}

