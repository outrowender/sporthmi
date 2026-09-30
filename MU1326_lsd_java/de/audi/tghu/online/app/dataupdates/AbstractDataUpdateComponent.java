/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.dataupdates;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IGenericDataUpdatePayload;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;
import java.util.Map;

public abstract class AbstractDataUpdateComponent
extends AbstractRemoteHMIComponent {
    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(500000194, new AbstractCommandHandler("app-list-dataupdates"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "AbstractDataUpdateComponent#indicateCommand() dataUpdate list received");
                if (object instanceof Map) {
                    AbstractDataUpdateComponent.this.storeDataUpdates((Map)object);
                }
            }
        });
        remoteHMIService.addCommandHandler(500000195, new AbstractCommandHandler("applist-dataupdate-finished"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "AbstractDataUpdateComponent#indicateCommand() dataUpdate finished received");
                if (object instanceof IGenericDataUpdatePayload) {
                    AbstractDataUpdateComponent.this.indicateDataUpdateFinished((IGenericDataUpdatePayload)object);
                }
            }
        });
    }

    protected abstract void storeDataUpdates(Map var1);

    public void requestDataUpdates(int n) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(40010002);
        remoteHMIAction.getParameters().put("value", new Integer(n));
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void requestDataUpdates(List list) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(40010002);
        remoteHMIAction.getParameters().put("value", list);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public abstract void indicateDataUpdateFinished(IGenericDataUpdatePayload var1);
}

