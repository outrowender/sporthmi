/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenPrepareParentChild;
import de.audi.tghu.navi.app.command.NavCommand;

public class PoiPrepareParentChildCommandAsia
extends NavCommand {
    private final IPoiScreenPrepareParentChild modelAccess;

    public PoiPrepareParentChildCommandAsia(IPoiScreenPrepareParentChild iPoiScreenPrepareParentChild) {
        this.modelAccess = iPoiScreenPrepareParentChild;
    }

    @Override
    public void execute() {
        boolean bl = this.dsiResponseContainer.selectionCriterionAvailable(0x7800000) && this.dsiResponseContainer.refinementCriterionAvailable(0x7800000);
        this.modelAccess.prepareParentChild(bl ? 1 : 0);
        this.getCommandList().commandFinished();
    }
}

