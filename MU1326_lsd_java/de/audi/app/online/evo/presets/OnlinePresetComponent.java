/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.presets;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.presets.OnlinePresetHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;

public class OnlinePresetComponent
extends AbstractRemoteHMIComponent {
    public void init(final LogChannel logChannel, final RemoteHMIService remoteHMIService) {
        super.init(Online.getInstance().getPresetsLogChannel(), remoteHMIService);
        remoteHMIService.addCommandHandler(1100009007, new AbstractCommandHandler("preset-entries-changed"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlinePresetComponent#indicateCommand: state STATE_PRESET_ENTRIES_CHANGED");
                if (object instanceof List) {
                    OnlinePresetHandler onlinePresetHandler;
                    List list = (List)object;
                    if (remoteHMIService instanceof RemoteHMIServiceEvo && (onlinePresetHandler = ((RemoteHMIServiceEvo)remoteHMIService).getOnlinePresetHandler()) != null) {
                        onlinePresetHandler.setPresetEntryConfigurations(list);
                    }
                }
            }
        });
    }
}

