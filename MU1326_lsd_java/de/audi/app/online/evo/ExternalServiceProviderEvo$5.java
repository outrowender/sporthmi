/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

class ExternalServiceProviderEvo$5
extends AbstractRemoteHMITask {
    private final /* synthetic */ ContextManagerComponent val$contextManagerComponent;
    private final /* synthetic */ String val$applicationContext;
    private final /* synthetic */ boolean val$startMediaAppInBackground;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$5(ExternalServiceProviderEvo externalServiceProviderEvo, String string, LogAppender logAppender, ContextManagerComponent contextManagerComponent, String string2, boolean bl) {
        this.this$0 = externalServiceProviderEvo;
        this.val$contextManagerComponent = contextManagerComponent;
        this.val$applicationContext = string2;
        this.val$startMediaAppInBackground = bl;
        super(string, logAppender);
    }

    @Override
    public void run() {
        RemoteHMIAction remoteHMIAction;
        boolean bl;
        EntryPoint entryPoint = this.val$contextManagerComponent.getEntryPointFromMap(4);
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
        EntryPoint entryPoint2 = mediaSubEntryPointsContainer.getEntryPointByAppContext(this.val$applicationContext);
        if (entryPoint2 == null) {
            ExternalServiceProviderEvo.access$200(this.this$0).log(-1601830656, "ExternalServiceProviderEvo#startMediaApp() entrypoint for given context is null so doing nothing.");
            return;
        }
        int n = entryPoint2.getEntryPointId();
        if (n <= 10) {
            ExternalServiceProviderEvo.access$300(this.this$0).log(-1601830656, "ExternalServiceProviderEvo#startMediaApp() entryPoint retrieved for the given context is out of range so doing nothing");
            return;
        }
        ExternalServiceProviderEvo.access$400(this.this$0).log(-2137614336, "ExternalServiceProviderEvo#startMediaApp: Entrypoint id for AppContext : %1 is %2 ", (Object)this.val$applicationContext, (long)n);
        entryPoint2.setNameOfContextToBeStarted(this.val$applicationContext);
        mediaSubEntryPointsContainer.setCurrentEntryPoint(entryPoint2);
        RemoteHMIContext remoteHMIContext = entryPoint2.getCurrentContext();
        boolean bl2 = bl = remoteHMIContext != null && remoteHMIContext.getContextName().equals(this.val$applicationContext);
        if (bl) {
            ExternalServiceProviderEvo.access$500(this.this$0).log(1078071040, "ExternalServiceProviderEvo#startMediaApp: Context '%1' is going to be resumed %2", (Object)this.val$applicationContext, (Object)(this.val$startMediaAppInBackground ? "in the background" : ""));
            remoteHMIAction = ExternalServiceProviderEvo.access$600(this.this$0).getAction(182580485);
        } else {
            ExternalServiceProviderEvo.access$700(this.this$0).log(1078071040, "ExternalServiceProviderEvo#startMediaApp: Context '%1' is going to be started %2", (Object)this.val$applicationContext, (Object)(this.val$startMediaAppInBackground ? "in the background" : ""));
            remoteHMIAction = ExternalServiceProviderEvo.access$800(this.this$0).getAction(-2070505472);
            entryPoint2.setCurrentContext(null);
        }
        remoteHMIAction.getParameters().putString("appContextName", this.val$applicationContext);
        remoteHMIAction.getParameters().putBoolean("backgroundService", this.val$startMediaAppInBackground);
        ExternalServiceProviderEvo.access$900(this.this$0).invokeAction(remoteHMIAction);
    }
}

