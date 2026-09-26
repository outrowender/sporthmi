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
    @Override
    public void init(BundleContext bundleContext) {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void setNotification(int n) {
    }

    @Override
    public IDSIKombiPictureServerController getDSIKombiPictureServerController() {
        return null;
    }

    @Override
    public DSIKombiPictureServerListener getDSIKombiPictureServerListener() {
        return null;
    }

    @Override
    public void registerPictureProvider(int n, IPictureProvider iPictureProvider) {
    }

    @Override
    public void requestCoverArt(long l, int n) {
    }

    @Override
    public void responseCoverArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    @Override
    public void requestStationArt(long l, int n) {
    }

    @Override
    public void responseStationArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    @Override
    public void requestActiveCallPicture(int n) {
    }

    @Override
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
    }

    @Override
    public void requestAdbContactPicture(long l) {
    }

    @Override
    public void responseAdbContactPicture(long l, ResourceLocator resourceLocator) {
    }
}

