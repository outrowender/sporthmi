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
    public NavLocation getFavoriteNavLocationByListIndex(int var1);

    public NavLocation getFavoriteNavLocationByUniqueId(long var1);

    public byte[] getFavoriteNavLocationStreamByUniqueId(long var1);

    public SDSListEntry[] getFavoriteSDSEntries();

    public void addToFavorites(NavLocation var1, String var2);

    public void addToFavorites(NavLocation var1);

    public EvoListRow getFavoriteRow(long var1);

    public String getFavoriteAddress(long var1);

    public IFavorite[] getFavorites();

    public IPoiService getPoiService();

    public void setLocationFromADB(NavLocation var1);

    public int getOperationMode();

    public boolean isCapacityReached();

    public void saveAddressOfEditedFavorite(NavLocation var1);

    public boolean isContextEditSavedFavorite();

    public boolean isContextHome();

    public boolean isContextOffice();

    public HomeAddressHandler getHomeAddressHandler();

    public HomeAddressHandler getOfficeAddressHandler();

    public void resetSavedTypeContext();

    public boolean handleActionDependingOnContext(NavLocation var1);

    public boolean handleActionDependingOnContext(NavLocation var1, String var2);

    public void setFavoritesContext(int var1);
}

