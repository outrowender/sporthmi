/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class ModelUpdateResultListCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess;
    private final int startIndex;
    private final int requestID;

    public ModelUpdateResultListCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this(iMatchspellerModelAccess, -2, -2);
    }

    public ModelUpdateResultListCommand(IMatchspellerModelAccess iMatchspellerModelAccess, int n, int n2) {
        this.modelAccess = iMatchspellerModelAccess;
        this.requestID = n;
        this.startIndex = n2;
    }

    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        if (this.requestID == -2 || this.startIndex == -2) {
            this.modelAccess.onUpdateResultList(lIValueList, l, string, bl);
        } else {
            this.modelAccess.onUpdateResultList(lIValueList, l, string, bl, this.requestID, this.startIndex);
        }
        this.getCommandList().commandFinished();
    }
}

