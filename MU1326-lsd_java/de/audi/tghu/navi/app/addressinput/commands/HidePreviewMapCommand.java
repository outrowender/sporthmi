/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;

public class HidePreviewMapCommand
extends NavCommand {
    private final IPreviewMap previewMap;

    public HidePreviewMapCommand(IPreviewMap iPreviewMap) {
        this.previewMap = iPreviewMap;
    }

    @Override
    public void execute() {
        if (this.previewMap != null) {
            this.logger.log(-2137614336, "%1#execute() - hiding preview map", (Object)this.CLASS_NAME);
            this.previewMap.hidePreviewMap();
        } else {
            this.logger.log(-1601830656, "%1#execute() - preview map is null!", (Object)this.CLASS_NAME);
        }
        this.getCommandList().commandFinished();
    }
}

