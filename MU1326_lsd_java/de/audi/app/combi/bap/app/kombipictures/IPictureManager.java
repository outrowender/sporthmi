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
    public static final int NOTIFICATION_COVER_ART = 0;
    public static final int NOTIFICATION_STATION_ART = 1;
    public static final int NOTIFICATION_ACTIVE_CALL = 2;
    public static final int NOTIFICATION_ADB_CONTACT = 3;
    public static final int NOTIFICATION_COUNT = 4;

    public void init(BundleContext var1);

    public void deinit();

    public void setNotification(int var1);

    public IDSIKombiPictureServerController getDSIKombiPictureServerController();

    public DSIKombiPictureServerListener getDSIKombiPictureServerListener();

    public void registerPictureProvider(int var1, IPictureProvider var2);

    public void requestCoverArt(long var1, int var3);

    public void responseCoverArt(long var1, int var3, ResourceLocator var4, boolean var5);

    public void requestStationArt(long var1, int var3);

    public void responseStationArt(long var1, int var3, ResourceLocator var4, boolean var5);

    public void requestActiveCallPicture(int var1);

    public void responseActiveCallPicture(int var1, int var2, ResourceLocator var3, boolean var4);

    public void requestAdbContactPicture(long var1);

    public void responseAdbContactPicture(long var1, ResourceLocator var3);
}

