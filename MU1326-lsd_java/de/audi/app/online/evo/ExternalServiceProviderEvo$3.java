/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.VirtualButtonAdapter;

class ExternalServiceProviderEvo$3
extends VirtualButtonAdapter {
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ VirtualButtonModelApp val$virtualButtonModelApp;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$3(ExternalServiceProviderEvo externalServiceProviderEvo, RemoteHMIService remoteHMIService, VirtualButtonModelApp virtualButtonModelApp) {
        this.this$0 = externalServiceProviderEvo;
        this.val$remoteHmiService = remoteHMIService;
        this.val$virtualButtonModelApp = virtualButtonModelApp;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 689709824) {
            ContextManagerComponent contextManagerComponent = this.val$remoteHmiService.getContextManagerComponent();
            EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
            if (entryPoint != null && entryPoint.getEntryPointId() == 1) {
                contextManagerComponent.setWaitForApplicationValue(0);
            } else {
                this.val$virtualButtonModelApp.fireEvent(0);
            }
        }
    }
}

