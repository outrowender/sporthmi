/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class NewModelUpdateResultListCommand
extends NavCommand {
    private final IPoiScreenUpdateResultList modelAccess;

    public NewModelUpdateResultListCommand(IPoiScreenUpdateResultList iPoiScreenUpdateResultList) {
        this.modelAccess = iPoiScreenUpdateResultList;
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        this.modelAccess.onUpdateResultList(lIValueList, l, string, bl);
        this.getCommandList().commandFinished();
    }
}

