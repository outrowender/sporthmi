/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.favorite.IFavorite;
import org.dsi.ifc.global.NavLocation;

public interface INaviFavoriteHandler {
    default public NavLocation getFavoriteNavLocationByListIndex(int n) {
    }

    default public NavLocation getFavoriteNavLocationByUniqueId(long l) {
    }

    default public byte[] getFavoriteNavLocationStreamByUniqueId(long l) {
    }

    default public SDSListEntry[] getFavoriteSDSEntries() {
    }

    default public void addToFavorites(NavLocation navLocation, String string) {
    }

    default public void addToFavorites(NavLocation navLocation) {
    }

    default public EvoListRow getFavoriteRow(long l) {
    }

    default public String getFavoriteAddress(long l) {
    }

    default public IFavorite[] getFavorites() {
    }

    default public IPoiService getPoiService() {
    }

    default public void setLocationFromADB(NavLocation navLocation) {
    }

    default public int getOperationMode() {
    }

    default public boolean isCapacityReached() {
    }

    default public void saveAddressOfEditedFavorite(NavLocation navLocation) {
    }

    default public boolean isContextEditSavedFavorite() {
    }

    default public boolean isContextHome() {
    }

    default public boolean isContextOffice() {
    }

    default public HomeAddressHandler getHomeAddressHandler() {
    }

    default public HomeAddressHandler getOfficeAddressHandler() {
    }

    default public void resetSavedTypeContext() {
    }

    default public boolean handleActionDependingOnContext(NavLocation navLocation) {
    }

    default public boolean handleActionDependingOnContext(NavLocation navLocation, String string) {
    }

    default public void setFavoritesContext(int n) {
    }
}

