/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.favorite.IFavoriteStorage;
import de.esolutions.fw.util.commons.Buffer;

public class NaviFavoriteStorageEvo
implements IFavoriteStorage {
    private static final long serialVersionUID;
    protected final long uniqueID;
    protected final byte[] navLocation;
    protected final String favoriteName;
    protected final String street;
    protected final String houseNumber;
    protected final String city;
    protected final String countryAbbreviation;
    protected final int iconID;
    protected final int favoriteType;
    protected final int longitude;
    protected final int latitude;
    protected final String formattedAddressLine;
    protected final String state;
    protected final String district;
    protected final String ward;

    public NaviFavoriteStorageEvo(String string, String string2, String string3, String string4, int n, byte[] byArray, long l, String string5, int n2, int n3, int n4, String string6, String string7, String string8, String string9) {
        if (string == null) {
            throw new IllegalArgumentException("NaviFavorite#favoriteName is null!");
        }
        if (byArray == null) {
            throw new IllegalArgumentException("NaviFavorite#navLocation is null!");
        }
        this.favoriteName = string;
        this.navLocation = byArray;
        this.countryAbbreviation = string5;
        this.street = string2;
        this.houseNumber = string3;
        this.city = string4;
        this.iconID = n;
        this.uniqueID = l;
        this.favoriteType = n2;
        this.longitude = n3;
        this.latitude = n4;
        this.formattedAddressLine = string6;
        this.state = string7;
        this.district = string8;
        this.ward = string9;
    }

    @Override
    public FavoriteListRow getFavoriteListRow() {
        return new NaviFavoriteEvoRow(this);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("NaviFavoriteStorage(uniqueID=");
        buffer.append(this.uniqueID);
        buffer.append(", Name=");
        buffer.append(this.favoriteName);
        buffer.append(", street=");
        buffer.append(this.street);
        buffer.append(", houseNumber=");
        buffer.append(this.houseNumber);
        buffer.append(", city=");
        buffer.append(this.city);
        buffer.append(", countryAbbreviation=");
        buffer.append(this.countryAbbreviation);
        buffer.append(", iconID=");
        buffer.append(this.iconID);
        buffer.append(", favoriteType=");
        buffer.append(this.favoriteType);
        buffer.append(", state=");
        buffer.append(this.state);
        buffer.append(", district=");
        buffer.append(this.district);
        buffer.append(", ward=");
        buffer.append(this.ward);
        buffer.append(")");
        return buffer.toString();
    }
}

