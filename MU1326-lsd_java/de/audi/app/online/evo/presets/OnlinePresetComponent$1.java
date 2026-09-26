/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.presets;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.presets.OnlinePresetComponent;
import de.audi.app.online.evo.presets.OnlinePresetHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;

class OnlinePresetComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ OnlinePresetComponent this$0;

    OnlinePresetComponent$1(OnlinePresetComponent onlinePresetComponent, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = onlinePresetComponent;
        this.val$logChannel = logChannel;
        this.val$remoteHmiService = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "OnlinePresetComponent#indicateCommand: state STATE_PRESET_ENTRIES_CHANGED");
        if (object instanceof List) {
            OnlinePresetHandler onlinePresetHandler;
            List list = (List)object;
            if (this.val$remoteHmiService instanceof RemoteHMIServiceEvo && (onlinePresetHandler = ((RemoteHMIServiceEvo)this.val$remoteHmiService).getOnlinePresetHandler()) != null) {
                onlinePresetHandler.setPresetEntryConfigurations(list);
            }
        }
    }
}

