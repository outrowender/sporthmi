/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnUpdatePoiList;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class ModelUpdatePoiListCommand
extends NavCommand {
    private final IPoiScreenOnUpdatePoiList modelAccess;

    public ModelUpdatePoiListCommand(IPoiScreenOnUpdatePoiList iPoiScreenOnUpdatePoiList) {
        this.modelAccess = iPoiScreenOnUpdatePoiList;
    }

    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        this.modelAccess.onUpdatePoiList(lIValueList);
        this.getCommandList().commandFinished();
    }
}

