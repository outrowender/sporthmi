/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenPrepareParentChild;
import de.audi.tghu.navi.app.command.NavCommand;

public class PoiPrepareParentChildCommand
extends NavCommand {
    private final IPoiScreenPrepareParentChild modelAccess;

    public PoiPrepareParentChildCommand(IPoiScreenPrepareParentChild iPoiScreenPrepareParentChild) {
        this.modelAccess = iPoiScreenPrepareParentChild;
    }

    @Override
    public void execute() {
        this.modelAccess.prepareParentChild(this.dsiResponseContainer.selectionCriterionAvailable(0x6800000) ? 1 : 0);
        this.getCommandList().commandFinished();
    }
}

