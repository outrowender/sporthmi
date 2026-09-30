/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.previews;

import de.audi.app.online.evo.previews.PreviewUpdateCommandHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RrdCalculationHandler;

public class PreviewUpdateComponent
extends AbstractRemoteHMIComponent {
    private final RrdCalculationHandler rrdCalculationHandler;

    public PreviewUpdateComponent(RrdCalculationHandler rrdCalculationHandler) {
        this.rrdCalculationHandler = rrdCalculationHandler;
    }

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        PreviewUpdateCommandHandler previewUpdateCommandHandler = new PreviewUpdateCommandHandler("update-previews", this.remoteHmiService, this.rrdCalculationHandler, logChannel);
        this.remoteHmiService.addCommandHandler(1100000070, previewUpdateCommandHandler);
    }
}

