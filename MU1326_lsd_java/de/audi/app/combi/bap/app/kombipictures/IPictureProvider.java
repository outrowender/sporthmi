/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

public interface IPictureProvider {
    public static final int PICTURE_PROVIDER_TYPE_COVER_ART = 0;
    public static final int PICTURE_PROVIDER_TYPE_STATION_ART = 1;
    public static final int PICTURE_PROVIDER_TYPE_CALL_PICTURE = 2;
    public static final int PICTURE_PROVIDER_TYPE_ADB_CONTACT_PICTURE = 3;

    public void requestPicture(long var1);

    public void requestPicture(long var1, int var3);
}

