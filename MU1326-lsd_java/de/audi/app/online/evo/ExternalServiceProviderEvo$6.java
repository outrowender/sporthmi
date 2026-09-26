/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;

class ExternalServiceProviderEvo$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$applicationContext;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$6(ExternalServiceProviderEvo externalServiceProviderEvo, String string, String string2) {
        this.this$0 = externalServiceProviderEvo;
        this.val$applicationContext = string2;
        super(string);
    }

    @Override
    public void run() {
        EntryPoint entryPoint = ExternalServiceProviderEvo.access$1000(this.this$0).getContextManagerComponent().getEntryPointFromMap(4);
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
        mediaSubEntryPointsContainer.setCurrentEntryPoint(null);
        RemoteHMIAction remoteHMIAction = ExternalServiceProviderEvo.access$1100(this.this$0).getAction(216134917);
        remoteHMIAction.getParameters().putString("appContextName", this.val$applicationContext);
        ExternalServiceProviderEvo.access$1200(this.this$0).invokeAction(remoteHMIAction);
        IMediaDrawerContext iMediaDrawerContext = ExternalServiceProviderEvo.access$1300(this.this$0).getMediaDrawerContext();
        if (iMediaDrawerContext != null) {
            iMediaDrawerContext.setDrawerElements(null, null);
        }
    }
}

