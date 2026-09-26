/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class PoiGetCategoryTypesFromUIdCommand
extends NavCommand {
    private final int categoryUid;

    public PoiGetCategoryTypesFromUIdCommand(int n) {
        this.categoryUid = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute - categoryUid=%2", (Object)this.CLASS_NAME, (long)this.categoryUid);
        this.getDSINavigation().poiGetCategoryTypesFromUId(this.categoryUid);
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.logger.log(-2137614336, "%1#poiGetCategoryTypesFromUIdResult - results=%2", (Object)this.CLASS_NAME, (Object)nArray);
        this.dsiResponseContainer.setPoiGetCategoryTypesFromUId(nArray);
        this.getCommandList().commandFinished();
    }
}

