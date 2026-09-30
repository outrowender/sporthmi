/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.command.DelayCommand;

public class HandleRenderingInfoProviderCommand
extends DelayCommand {
    public static final long MAX_WAIT_DELAY = 30000L;

    public HandleRenderingInfoProviderCommand() {
        super(30000L);
    }

    public void execute() {
        if (this.navigation.getIconHandler().getRenderingInfoProvider() == null) {
            this.logger.log(10000000, "HandleRenderingInfoProviderCommand#execute() - RenderingInfoProvider not set. Starting wait-timer.. ");
            super.execute();
        } else {
            this.logger.log(10000000, "HandleRenderingInfoProviderCommand#execute() - RenderingInfoProvider already set! ");
            this.getCommandList().commandFinished();
        }
    }

    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.logger.log(10000000, "HandleRenderingInfoProviderCommand#updateRenderingInfoProvider( %1 ) - stopping wait timer ", (Object)renderingInfoProvider);
        this.timer.cancel();
        super.updateRenderingInfoProvider(renderingInfoProvider);
        this.getCommandList().commandFinished();
    }

    public void fireTimer(Timer timer) {
        this.logger.log(10000000, "HandleRenderingInfoProviderCommand#fireTimer() ");
        if (timer == this.timer) {
            this.logger.log(100000, "HandleRenderingInfoProviderCommand#fireTimer() - RenderingInfoProvider is still not set after %1ms. Wait aborted! ", 30000L);
            this.getCommandList().commandFinished();
        }
    }
}

