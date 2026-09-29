/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.presets;

import de.audi.app.online.evo.presets.OnlinePresetComponent$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class OnlinePresetComponent
extends AbstractRemoteHMIComponent {
    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(Online.getInstance().getPresetsLogChannel(), remoteHMIService);
        remoteHMIService.addCommandHandler(802066497, new OnlinePresetComponent$1(this, "preset-entries-changed", logChannel, remoteHMIService));
    }
}

