/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

import de.audi.app.combi.bap.app.kombipictures.IPictureManager;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.dsi.pictureserver.IDSIKombiPictureServerController;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;
import org.osgi.framework.BundleContext;

public class NullPictureManager
implements IPictureManager {
    public void init(BundleContext bundleContext) {
    }

    public void deinit() {
    }

    public void setNotification(int n) {
    }

    public IDSIKombiPictureServerController getDSIKombiPictureServerController() {
        return null;
    }

    public DSIKombiPictureServerListener getDSIKombiPictureServerListener() {
        return null;
    }

    public void registerPictureProvider(int n, IPictureProvider iPictureProvider) {
    }

    public void requestCoverArt(long l, int n) {
    }

    public void responseCoverArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    public void requestStationArt(long l, int n) {
    }

    public void responseStationArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    public void requestActiveCallPicture(int n) {
    }

    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
    }

    public void requestAdbContactPicture(long l) {
    }

    public void responseAdbContactPicture(long l, ResourceLocator resourceLocator) {
    }
}

