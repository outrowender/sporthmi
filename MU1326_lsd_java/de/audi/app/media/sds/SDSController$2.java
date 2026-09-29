/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.sds.SDSController;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;

class SDSController$2
extends AbstractServiceListTracker {
    private final /* synthetic */ SDSController this$0;

    SDSController$2(SDSController sDSController, LogChannel logChannel, IServiceManager iServiceManager) {
        this.this$0 = sDSController;
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
        return SDSController.class$de$audi$atip$interapp$media$IMediaSDSServiceListener == null ? (SDSController.class$de$audi$atip$interapp$media$IMediaSDSServiceListener = SDSController.class$("de.audi.atip.interapp.media.IMediaSDSServiceListener")) : SDSController.class$de$audi$atip$interapp$media$IMediaSDSServiceListener;
    }

    @Override
    protected boolean checkServiceProperties(Dictionary dictionary) {
        return true;
    }
}

