/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.dataupdates;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IGenericDataUpdatePayload;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.dataupdates.AbstractDataUpdateComponent$1;
import de.audi.tghu.online.app.dataupdates.AbstractDataUpdateComponent$2;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;
import java.util.Map;

public abstract class AbstractDataUpdateComponent
extends AbstractRemoteHMIComponent {
    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(-1033515747, new AbstractDataUpdateComponent$1(this, "app-list-dataupdates", logChannel));
        remoteHMIService.addCommandHandler(-1016738531, new AbstractDataUpdateComponent$2(this, "applist-dataupdate-finished", logChannel));
    }

    protected abstract void storeDataUpdates(Map map) {
    }

    public void requestDataUpdates(int n) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(310469122);
        remoteHMIAction.getParameters().put("value", new Integer(n));
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void requestDataUpdates(List list) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(310469122);
        remoteHMIAction.getParameters().put("value", list);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public abstract void indicateDataUpdateFinished(IGenericDataUpdatePayload iGenericDataUpdatePayload) {
    }
}

