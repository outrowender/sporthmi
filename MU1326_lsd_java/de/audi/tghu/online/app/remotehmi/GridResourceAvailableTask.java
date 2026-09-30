/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIViewTask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import java.util.List;

public final class GridResourceAvailableTask
extends AbstractRemoteHMIViewTask {
    private final int status;
    private final Commands.StateGridResourceAvailablePayload payload;
    private final AbstractCommandHandler commandHandler;
    private final LogChannel logChannel;

    public GridResourceAvailableTask(AbstractCommandHandler abstractCommandHandler, String string, String string2, int n, Commands.StateGridResourceAvailablePayload stateGridResourceAvailablePayload, LogChannel logChannel) {
        super(string, new Integer(13000), string2, LogAppender.Factory.fromObject(stateGridResourceAvailablePayload.getLocalLocations(), 256));
        this.commandHandler = abstractCommandHandler;
        this.status = n;
        this.payload = stateGridResourceAvailablePayload;
        this.logChannel = logChannel;
    }

    public void run() {
        this.commandHandler.indicateCommand(this.status, this.payload);
    }

    public Long getDelayMillis() {
        return new Long(this.payload.getDelayMillis());
    }

    public boolean isCoalescable() {
        return true;
    }

    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof GridResourceAvailableTask)) {
            return false;
        }
        GridResourceAvailableTask gridResourceAvailableTask = (GridResourceAvailableTask)remoteHMITask;
        Commands.StateGridResourceAvailablePayload stateGridResourceAvailablePayload = gridResourceAvailableTask.payload;
        if (!stateGridResourceAvailablePayload.getContextName().equals(this.payload.getContextName())) {
            return false;
        }
        List list = this.payload.getLocalLocations();
        stateGridResourceAvailablePayload.add(list);
        stateGridResourceAvailablePayload.setProperties(this.payload.getProperties());
        this.logChannel.log(100000000, "RemoteHMIServiceEvo#GridResourceAvailableTask#coalesceWith: coalesced image updates: %1", (Object)list);
        return true;
    }
}

