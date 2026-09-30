/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class SwitchToOnlineComponent
extends AbstractRemoteHMIComponent {
    public void init(final LogChannel logChannel, final RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(1100009010, new AbstractCommandHandler("switch-to-online"){

            public void indicateCommand(int n, Object object) {
                if (object != null && object instanceof Integer) {
                    int n2 = (Integer)object;
                    logChannel.log(1000000, "SwitchToOnlineComponent#indicateCommand(): switching to service type %1", (long)n2);
                    ChoiceModelApp choiceModelApp = remoteHMIService.getModelBankAccess().getChoiceModel(4586);
                    choiceModelApp.setValue(n2);
                    ChoiceModelApp choiceModelApp2 = remoteHMIService.getModelBankAccess().getChoiceModel(4622);
                    choiceModelApp2.setValue(~choiceModelApp2.getValue());
                    return;
                }
                logChannel.log(100000, "SwitchToOnlineComponent#indicateCommand(): encountered unexpected payload object.");
            }
        });
    }
}

