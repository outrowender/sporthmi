/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;

public interface IMapFlagHandler$IMapFlagHandlerEnv {
    default public LogChannel getLogger() {
    }

    default public NavLocation getHome() {
    }

    default public NavLocation getOffice() {
    }

    default public AdbEntry[] getTops() {
    }

    default public MapPin[] getContextDependedPins() {
    }

    default public boolean isFavoriteVisible(int n) {
    }

    default public IFavorite[] getFavorites() {
    }

    default public MapDataContainer getMapDataContainer() {
    }

    default public void configureFlags(int n, MapFlag[] mapFlagArray) {
    }
}

