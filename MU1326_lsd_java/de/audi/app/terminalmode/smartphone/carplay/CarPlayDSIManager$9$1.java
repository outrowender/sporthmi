/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$9;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;

class CarPlayDSIManager$9$1
extends AbstractDSICommand {
    private final /* synthetic */ CarPlayDSIManager$9 this$1;

    CarPlayDSIManager$9$1(CarPlayDSIManager$9 carPlayDSIManager$9, LogChannel logChannel, String string, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager) {
        this.this$1 = carPlayDSIManager$9;
        super(logChannel, string, iContext, iDSISmartphoneManager);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.Special Phone use case] Set Audio_Media to MU", (Object)"CarPlayDSIManager");
        if ((CarPlayDSIManager.access$400(CarPlayDSIManager$9.access$3100(this.this$1)).getCurrentState().getOwnerForResource(Resource.AUDIO_PHONE).is(ResourceOwner.DEVICE) || CarPlayDSIManager.access$400(CarPlayDSIManager$9.access$3100(this.this$1)).getCurrentState().getOwnerForResource(Resource.AUDIO_RINGTONE).is(ResourceOwner.DEVICE)) && CarPlayDSIManager.access$400(CarPlayDSIManager$9.access$3100(this.this$1)).getCurrentState().getOwnerForApplication(Application.PHONE).is(ApplicationOwner.DEVICE)) {
            CarPlayDSIManager.access$400(CarPlayDSIManager$9.access$3100(this.this$1)).setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
        }
        this.commandList.commandFinished();
    }
}

