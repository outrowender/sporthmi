/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class RGEnableEnhancedSignPostInfoCommand
extends NavCommand {
    private boolean enable;

    public RGEnableEnhancedSignPostInfoCommand(boolean bl) {
        this.enable = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RGEnableEnhancedSignPostInfoCommand#execute() - calling rgEnableEnhancedSignPostInfo( %1 ) ", this.enable);
        this.getDSINavigation().rgEnableEnhancedSignPostInfo(this.enable);
        this.getCommandList().commandFinished();
    }
}

