/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenRequestItems;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class NewModelUpdateResultScreenWithSpellerForRequestCommand
extends NavCommand {
    private final IPoiScreenRequestItems modelAccess;
    private final int requestID;
    private final int startIndex;

    public NewModelUpdateResultScreenWithSpellerForRequestCommand(IPoiScreenRequestItems iPoiScreenRequestItems, int n, int n2) {
        this.modelAccess = iPoiScreenRequestItems;
        this.requestID = n;
        this.startIndex = n2;
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        this.modelAccess.onUpdateResultListForRequest(lIValueList, l, string, bl, this.requestID, this.startIndex);
        this.getCommandList().commandFinished();
    }
}

