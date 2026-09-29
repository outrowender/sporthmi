/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

public interface IPictureProvider {
    public static final int PICTURE_PROVIDER_TYPE_COVER_ART;
    public static final int PICTURE_PROVIDER_TYPE_STATION_ART;
    public static final int PICTURE_PROVIDER_TYPE_CALL_PICTURE;
    public static final int PICTURE_PROVIDER_TYPE_ADB_CONTACT_PICTURE;

    default public void requestPicture(long l) {
    }

    default public void requestPicture(long l, int n) {
    }
}

