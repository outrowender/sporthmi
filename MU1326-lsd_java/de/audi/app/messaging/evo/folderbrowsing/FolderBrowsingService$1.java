/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class FolderBrowsingService$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ FolderBrowsingService this$0;

    FolderBrowsingService$1(FolderBrowsingService folderBrowsingService, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = folderBrowsingService;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        FolderBrowsingService.access$102(this.this$0, (IFolderBrowsingServiceListener)object);
        FolderBrowsingService.access$200(this.this$0);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        FolderBrowsingService.access$102(this.this$0, null);
    }
}

