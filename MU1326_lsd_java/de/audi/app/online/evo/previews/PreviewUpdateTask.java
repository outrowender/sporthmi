/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.previews;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IPreviewInfo;
import de.audi.remotehmi.ui.mib2.Commands;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import java.util.Iterator;
import java.util.List;

public class PreviewUpdateTask
extends AbstractRemoteHMITask {
    private final AbstractCommandHandler commandHandler;
    private final int status;
    private final Commands.StateUpdatePreviewsPayload payload;
    private final LogChannel logChannel;

    public PreviewUpdateTask(AbstractCommandHandler abstractCommandHandler, String string, int n, Commands.StateUpdatePreviewsPayload stateUpdatePreviewsPayload, LogChannel logChannel) {
        super(string, LogAppender.Factory.fromObject(stateUpdatePreviewsPayload.getPreviews(), 128));
        this.commandHandler = abstractCommandHandler;
        this.status = n;
        this.payload = stateUpdatePreviewsPayload;
        this.logChannel = logChannel;
    }

    public void run() {
        this.commandHandler.indicateCommand(this.status, this.payload);
    }

    public boolean isCoalescable() {
        return true;
    }

    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof PreviewUpdateTask)) {
            return false;
        }
        List list = this.payload.getPreviews();
        if (list == null || list.isEmpty()) {
            return true;
        }
        Commands.StateUpdatePreviewsPayload stateUpdatePreviewsPayload = ((PreviewUpdateTask)remoteHMITask).payload;
        List list2 = stateUpdatePreviewsPayload.getPreviews();
        if (list2 != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                boolean bl = false;
                IPreviewInfo iPreviewInfo = (IPreviewInfo)iterator.next();
                for (int i2 = 0; i2 < list2.size(); ++i2) {
                    IPreviewInfo iPreviewInfo2 = (IPreviewInfo)list2.get(i2);
                    if (!iPreviewInfo2.getPrevId().equals(iPreviewInfo.getPrevId())) continue;
                    list2.set(i2, iPreviewInfo);
                    bl = true;
                    break;
                }
                if (bl) continue;
                list2.add(iPreviewInfo);
            }
        }
        this.logChannel.log(1000000, "PreviewUpdateTask#coalesceWith: coalesced preview updates: %1", (Object)list2);
        return true;
    }

    public Long getDelayMillis() {
        return new Long(this.payload.getDelayMillis());
    }
}

