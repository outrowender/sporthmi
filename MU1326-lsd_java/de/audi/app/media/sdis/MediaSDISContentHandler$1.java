/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.sdis.MediaSDISContentHandler;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;

class MediaSDISContentHandler$1
extends AbstractServiceListTracker {
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$1(MediaSDISContentHandler mediaSDISContentHandler, LogChannel logChannel, IServiceManager iServiceManager) {
        this.this$0 = mediaSDISContentHandler;
        super(logChannel, iServiceManager);
    }

    @Override
    protected void serviceRemoved(Object object) {
    }

    @Override
    protected void serviceAdded(Object object) {
    }

    @Override
    protected Class getTrackedServiceClass() {
        return MediaSDISContentHandler.class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (MediaSDISContentHandler.class$de$audi$atip$interapp$sdis$ISDISBlockingService = MediaSDISContentHandler.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : MediaSDISContentHandler.class$de$audi$atip$interapp$sdis$ISDISBlockingService;
    }

    @Override
    protected boolean checkServiceProperties(Dictionary dictionary) {
        return true;
    }
}

