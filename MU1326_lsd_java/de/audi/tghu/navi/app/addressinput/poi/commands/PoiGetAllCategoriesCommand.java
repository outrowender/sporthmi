/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager;
import org.dsi.ifc.navigation.Category;

public class PoiGetAllCategoriesCommand
extends NavCommand {
    private final int mapStyleType;
    private final PoiWarningManager poiWarningManager;
    private final LogChannel logChannel;

    public PoiGetAllCategoriesCommand(PoiWarningManager poiWarningManager, int n, LogChannel logChannel) {
        this.poiWarningManager = poiWarningManager;
        this.mapStyleType = n;
        this.logChannel = logChannel;
    }

    public void execute() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiGetAllCategoriesCommand#execute() - calling ehGetAllCategories() ");
        }
        this.getDSINavigation().ehGetAllCategories(this.mapStyleType);
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiGetAllCategoriesCommand#ehGetAllCategoriesResult( %1 )", (long)n2);
        }
        if (n2 == 0) {
            if (this.poiWarningManager != null) {
                this.poiWarningManager.poiCategoriesUpdate(n, categoryArray);
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n2);
        }
    }
}

