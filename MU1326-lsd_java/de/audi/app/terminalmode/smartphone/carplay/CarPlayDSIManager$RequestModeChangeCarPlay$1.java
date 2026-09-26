/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$RequestModeChangeCarPlay;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class CarPlayDSIManager$RequestModeChangeCarPlay$1
extends Command {
    private final /* synthetic */ CarPlayDSIManager$RequestModeChangeCarPlay this$1;

    CarPlayDSIManager$RequestModeChangeCarPlay$1(CarPlayDSIManager$RequestModeChangeCarPlay carPlayDSIManager$RequestModeChangeCarPlay, LogChannel logChannel) {
        this.this$1 = carPlayDSIManager$RequestModeChangeCarPlay;
        super(logChannel);
    }

    @Override
    public void execute() {
        CarPlayDSIManager$RequestModeChangeCarPlay.access$4500(this.this$1).updateState(CarPlayDSIManager$RequestModeChangeCarPlay.access$4400(this.this$1));
        this.getCommandList().commandFinished();
    }

    @Override
    public String getName() {
        return "RequestModeChangeCarPlay.canceled -> Continue CommandList";
    }
}

