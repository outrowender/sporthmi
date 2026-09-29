/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.dsi.pictureserver.IDSIKombiPictureServerController;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;
import org.osgi.framework.BundleContext;

public interface IPictureManager {
    public static final int NOTIFICATION_COVER_ART;
    public static final int NOTIFICATION_STATION_ART;
    public static final int NOTIFICATION_ACTIVE_CALL;
    public static final int NOTIFICATION_ADB_CONTACT;
    public static final int NOTIFICATION_COUNT;

    default public void init(BundleContext bundleContext) {
    }

    default public void deinit() {
    }

    default public void setNotification(int n) {
    }

    default public IDSIKombiPictureServerController getDSIKombiPictureServerController() {
    }

    default public DSIKombiPictureServerListener getDSIKombiPictureServerListener() {
    }

    default public void registerPictureProvider(int n, IPictureProvider iPictureProvider) {
    }

    default public void requestCoverArt(long l, int n) {
    }

    default public void responseCoverArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    default public void requestStationArt(long l, int n) {
    }

    default public void responseStationArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    default public void requestActiveCallPicture(int n) {
    }

    default public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
    }

    default public void requestAdbContactPicture(long l) {
    }

    default public void responseAdbContactPicture(long l, ResourceLocator resourceLocator) {
    }
}

