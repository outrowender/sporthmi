/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.SwitchToOnlineComponent$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class SwitchToOnlineComponent
extends AbstractRemoteHMIComponent {
    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(852398145, new SwitchToOnlineComponent$1(this, "switch-to-online", logChannel, remoteHMIService));
    }
}

