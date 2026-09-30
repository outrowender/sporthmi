/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteStorageEvo;
import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.favorite.IFavoriteStorage;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;

public class NaviFavoriteEvoRow
extends FavoriteListRow
implements IFavorite {
    public static final int MAX_COLUMNS = 7;
    public static final int COLUMN_INDEX_LAYOUT = 0;
    public static final int COLUMN_INDEX_ICONID = 1;
    public static final int COLUMN_INDEX_TEXTLINE1 = 2;
    public static final int COLUMN_INDEX_TEXTLINE2 = 3;
    public static final int COLUMN_INDEX_PROPERTY = 4;
    private byte[] favoriteLocation;
    private String favoriteName;
    private final String street;
    private final String houseNumber;
    private final String city;
    private final String countryAbbreviation;
    private final int latitude;
    private final int longitude;
    private final String formattedAddressLine;
    private final String state;
    private final String district;
    private final String postCode;
    private final int iconID;
    private final int favoriteType;

    public NaviFavoriteEvoRow(long l, byte[] byArray, String string, NavLocation navLocation, NavigationEnv navigationEnv) {
        super(l, 7);
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        this.street = this.getStreet(navLocation, iMyLocationAccessor, navigationEnv);
        this.houseNumber = LocationFormatter.formatHousenumber(navLocation);
        this.city = LocationFormatter.getCity(iMyLocationAccessor);
        this.countryAbbreviation = LocationFormatter.formatCountryAbbreviation(navLocation);
        this.latitude = navLocation.latitude;
        this.longitude = navLocation.longitude;
        this.favoriteName = string;
        this.state = this.getState(navLocation, navigationEnv);
        this.district = this.getDistrict(navLocation, iMyLocationAccessor, navigationEnv);
        this.postCode = this.getPostCode(navLocation, iMyLocationAccessor, navigationEnv);
        this.favoriteLocation = byArray;
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, navigationEnv);
        this.formattedAddressLine = locationFormattingResponse.getSecondLineAsText();
        this.iconID = -1;
        this.favoriteType = iMyLocationAccessor.getType();
        this.formatRow();
    }

    private String getStreet(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor, NavigationEnv navigationEnv) {
        if (navigationEnv.getFramework().isJp()) {
            return iMyLocationAccessor.getChome();
        }
        return iMyLocationAccessor.getStreet();
    }

    private String getState(NavLocation navLocation, NavigationEnv navigationEnv) {
        if (navigationEnv.getFramework().isAsia()) {
            return LocationFormatter.formatState(navLocation);
        }
        return LocationFormatter.formatStateAbbreviation(navLocation);
    }

    private String getDistrict(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor, NavigationEnv navigationEnv) {
        if (navigationEnv.getFramework().isJp()) {
            return iMyLocationAccessor.getPlaceName();
        }
        if ((navigationEnv.getFramework().isCn() || navigationEnv.getFramework().isTaiwan()) && iMyLocationAccessor.isTownOrder9()) {
            return iMyLocationAccessor.getTown();
        }
        return iMyLocationAccessor.getDistrict();
    }

    private String getPostCode(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor, NavigationEnv navigationEnv) {
        if (navigationEnv.getFramework().isAsia()) {
            return iMyLocationAccessor.getWard();
        }
        return LocationFormatter.formatZIPCode(navLocation);
    }

    private NaviFavoriteEvoRow(long l, byte[] byArray, String string, String string2, String string3, String string4, int n, String string5, int n2, int n3, int n4, String string6, String string7, String string8, String string9) {
        super(l, 7);
        this.favoriteLocation = byArray;
        this.favoriteName = string;
        this.street = string2;
        this.houseNumber = string3;
        this.city = string4;
        this.iconID = n;
        this.countryAbbreviation = string5;
        this.favoriteType = n2;
        this.longitude = n3;
        this.latitude = n4;
        this.formattedAddressLine = string6;
        this.state = string7;
        this.district = string8;
        this.postCode = string9;
        this.formatRow();
    }

    public NaviFavoriteEvoRow(NaviFavoriteStorageEvo naviFavoriteStorageEvo) {
        this(NaviFavoriteHandler.generateUniqueID(), naviFavoriteStorageEvo.navLocation, naviFavoriteStorageEvo.favoriteName, naviFavoriteStorageEvo.street, naviFavoriteStorageEvo.houseNumber, naviFavoriteStorageEvo.city, naviFavoriteStorageEvo.iconID, naviFavoriteStorageEvo.countryAbbreviation, naviFavoriteStorageEvo.favoriteType, naviFavoriteStorageEvo.longitude, naviFavoriteStorageEvo.latitude, naviFavoriteStorageEvo.formattedAddressLine, naviFavoriteStorageEvo.state, naviFavoriteStorageEvo.district, naviFavoriteStorageEvo.ward);
    }

    public EvoListRow copy() {
        return new NaviFavoriteEvoRow(this.getUniqueID(), this.favoriteLocation, this.favoriteName, this.street, this.houseNumber, this.city, this.iconID, this.countryAbbreviation, this.favoriteType, this.longitude, this.latitude, this.formattedAddressLine, this.state, this.district, this.postCode);
    }

    public IFavoriteStorage getIFavorite() {
        return new NaviFavoriteStorageEvo(this.favoriteName, this.street, this.houseNumber, this.city, this.iconID, this.favoriteLocation, this.getUniqueID(), this.countryAbbreviation, this.favoriteType, this.longitude, this.latitude, this.formattedAddressLine, this.state, this.district, this.postCode);
    }

    private void formatRow() {
        this.setInteger(0, 0);
        this.setInteger(1, 4);
        this.setText(2, this.favoriteName);
        this.setText(3, this.formattedAddressLine);
        this.setPropertyCell(4, new PropertyListCell(698976777, new int[]{-458046171}));
    }

    public void setFavoriteName(String string) {
        this.favoriteName = string;
    }

    public String getFavoriteName() {
        return this.favoriteName;
    }

    public byte[] getFavoriteLocation() {
        return this.favoriteLocation;
    }

    public void setFavoriteLocation(byte[] byArray) {
        this.favoriteLocation = byArray;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public String getFormattedAddressLine() {
        return this.formattedAddressLine;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getState() {
        return this.state;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public int getType() {
        return this.favoriteType;
    }
}

