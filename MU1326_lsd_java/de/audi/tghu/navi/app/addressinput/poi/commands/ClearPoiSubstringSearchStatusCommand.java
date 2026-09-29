/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

public class ClearPoiSubstringSearchStatusCommand
extends NavCommand {
    @Override
    public void execute() {
        if (Util.isHURegionAsia()) {
            this.logger.log(-2137614336, "%1#execute - setting poiSubstringSearchStatus in dsiResponseContainer to null.", (Object)this.CLASS_NAME);
            this.dsiResponseContainer.setPoiSubstringSearchStatus(null);
        }
        this.getCommandList().commandFinished();
    }
}

