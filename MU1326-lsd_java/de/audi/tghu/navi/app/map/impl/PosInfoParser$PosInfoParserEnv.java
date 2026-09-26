/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public interface PosInfoParser$PosInfoParserEnv {
    default public NavigationEnv getNaviEnv() {
    }

    default public boolean is3DLandmarksEnabled() {
    }

    default public OnlinePOIResultList getContextDependedOnlineResult() {
    }

    default public NavLocation getHomeAddress() {
    }

    default public NavLocation getOfficeAddress() {
    }

    default public AdbEntry getAdbEntry(int n) {
    }

    default public IFavorite getFavorite(int n) {
    }

    default public MapPin getMapPin(long l) {
    }

    default public ITooltipFormatter getTooltipFormatter() {
    }
}

