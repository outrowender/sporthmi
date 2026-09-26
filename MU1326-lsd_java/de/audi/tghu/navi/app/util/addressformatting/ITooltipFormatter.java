/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.tghu.navi.app.favorite.IFavorite;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface ITooltipFormatter {
    default public String formatPOI(NavLocation navLocation) {
    }

    default public String formatPOIStack(NavLocation navLocation, int n) {
    }

    default public String formatPOI3D(NavLocation navLocation) {
    }

    default public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
    }

    default public String formatPicNavLocation(NavLocation navLocation) {
    }

    default public String formatFavorite(IFavorite iFavorite) {
    }

    default public String formatAdbEntry(AdbEntry adbEntry, int n) {
    }

    default public String formatLocation(NavLocation navLocation) {
    }

    default public String formatHomeLocation(NavLocation navLocation) {
    }

    default public String formatBuilding(NavLocation navLocation) {
    }

    default public String formatTMC(TmcMessage tmcMessage) {
    }

    default public String formatTMC(TmcListElement tmcListElement) {
    }

    default public String formatFallback(NavLocation navLocation) {
    }
}

