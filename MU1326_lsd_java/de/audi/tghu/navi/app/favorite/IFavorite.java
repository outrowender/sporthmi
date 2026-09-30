/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite;

public interface IFavorite {
    public long getUniqueID();

    public String getFavoriteName();

    public String getHouseNumber();

    public String getStreet();

    public String getCity();

    public int getLongitude();

    public int getLatitude();

    public byte[] getFavoriteLocation();
}

