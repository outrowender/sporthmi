/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.command.DelayCommand;

public class HandleRenderingInfoProviderCommand
extends DelayCommand {
    public static final long MAX_WAIT_DELAY;

    public HandleRenderingInfoProviderCommand() {
        super(0);
    }

    @Override
    public void execute() {
        if (this.navigation.getIconHandler().getRenderingInfoProvider() == null) {
            this.logger.log(-2137614336, "HandleRenderingInfoProviderCommand#execute() - RenderingInfoProvider not set. Starting wait-timer.. ");
            super.execute();
        } else {
            this.logger.log(-2137614336, "HandleRenderingInfoProviderCommand#execute() - RenderingInfoProvider already set! ");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.logger.log(-2137614336, "HandleRenderingInfoProviderCommand#updateRenderingInfoProvider( %1 ) - stopping wait timer ", (Object)renderingInfoProvider);
        this.timer.cancel();
        super.updateRenderingInfoProvider(renderingInfoProvider);
        this.getCommandList().commandFinished();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(-2137614336, "HandleRenderingInfoProviderCommand#fireTimer() ");
        if (timer == this.timer) {
            this.logger.log(-1601830656, "HandleRenderingInfoProviderCommand#fireTimer() - RenderingInfoProvider is still not set after %1ms. Wait aborted! ", (long)0);
            this.getCommandList().commandFinished();
        }
    }
}

