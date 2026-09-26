/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

import de.audi.app.combi.bap.app.kombipictures.AbstractPictureManager;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractPictureManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$context;
    private final /* synthetic */ AbstractPictureManager this$0;

    AbstractPictureManager$1(AbstractPictureManager abstractPictureManager, BundleContext bundleContext) {
        this.this$0 = abstractPictureManager;
        this.val$context = bundleContext;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AbstractPictureManager.access$000(this.this$0).log(-2137614336, "[AbstractPictureManager#removedService] DSIKombiPictureServer service removed");
        AbstractPictureManager.access$100(this.this$0).deregisterDSI();
        this.val$context.ungetService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AbstractPictureManager.access$000(this.this$0).log(-2137614336, "[AbstractPictureManager#addingService] DSIKombiPictureServer service added");
        DSIKombiPictureServer dSIKombiPictureServer = (DSIKombiPictureServer)this.val$context.getService(serviceReference);
        dSIKombiPictureServer.setNotification(AbstractPictureManager.access$200(this.this$0));
        AbstractPictureManager.access$100(this.this$0).setDSI(dSIKombiPictureServer);
        AbstractPictureManager.access$100(this.this$0).setKombiHmiReady();
        return dSIKombiPictureServer;
    }
}

