/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.UpdateNavLocationNameComponent;
import org.dsi.ifc.global.NavLocation;

class UpdateNavLocationNameComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ UpdateNavLocationNameComponent this$0;

    UpdateNavLocationNameComponent$1(UpdateNavLocationNameComponent updateNavLocationNameComponent, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = updateNavLocationNameComponent;
        this.val$logChannel = logChannel;
        this.val$remoteHmiService = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(10000, "UpdateNavLocationNameComponent#indicateCommand() called with %1", object);
        if (!(object instanceof NavLocation)) {
            this.val$logChannel.log(10000, "UpdateNavLocationNameComponent#indicateCommand() invalid payload: %1", object);
            return;
        }
        NavLocation navLocation = (NavLocation)object;
        String string = this.val$remoteHmiService.getNaviComponent().getNaviService().getAdditionalNameFromNavLocation(navLocation);
        RemoteHMIAction remoteHMIAction = this.val$remoteHmiService.getAction(835620929);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.put("propNavLocation", navLocation);
        if (string != null) {
            hMIProperties.put("propNavLocationName", string);
        }
        this.val$remoteHmiService.invokeAction(remoteHMIAction);
    }
}

