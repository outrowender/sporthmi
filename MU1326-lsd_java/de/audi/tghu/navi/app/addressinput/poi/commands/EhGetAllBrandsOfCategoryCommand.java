/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.preferredstations.PreferredStationsHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Brand;

public class EhGetAllBrandsOfCategoryCommand
extends NavCommand {
    private final int mapStyleType;
    private final int categoryUid;
    private final PreferredStationsHandler preferredStationsHandler;

    public EhGetAllBrandsOfCategoryCommand(PreferredStationsHandler preferredStationsHandler, int n, int n2) {
        this.preferredStationsHandler = preferredStationsHandler;
        this.mapStyleType = n;
        this.categoryUid = n2;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "EhGetAllBrandsOfCategoryCommand#execute() - calling ehGetAllBrandsOfCategory() ");
        this.getDSINavigation().ehGetAllBrandsOfCategory(this.mapStyleType, this.categoryUid);
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.logger.log(1078071040, "EhGetAllBrandsOfCategoryCommand#ehGetAllBrandsOfCategoryResult( %1 )", (long)n3);
        if (n3 == 0) {
            if (this.preferredStationsHandler != null) {
                this.preferredStationsHandler.brandsUpdated(n, n2, brandArray);
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n3);
        }
    }
}

