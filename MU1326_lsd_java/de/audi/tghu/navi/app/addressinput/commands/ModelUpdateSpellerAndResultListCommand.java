/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class ModelUpdateSpellerAndResultListCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess;
    private int requestID;
    private int startIndex;

    public ModelUpdateSpellerAndResultListCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.modelAccess = iMatchspellerModelAccess;
        this.requestID = -1;
        this.startIndex = 0;
    }

    public ModelUpdateSpellerAndResultListCommand(IMatchspellerModelAccess iMatchspellerModelAccess, int n) {
        this.modelAccess = iMatchspellerModelAccess;
        this.startIndex = n;
        this.requestID = -1;
    }

    public ModelUpdateSpellerAndResultListCommand(IMatchspellerModelAccess iMatchspellerModelAccess, int n, int n2) {
        this.modelAccess = iMatchspellerModelAccess;
        this.requestID = n;
        this.startIndex = n2;
    }

    public void execute() {
        this.logger.log(10000000, "ModelUpdateSpellerAndResultListCommand#execute requestID = %1, startIndex = %2", (long)this.requestID, (long)this.startIndex);
        this.logger.log(10000000, "ModelUpdateSpellerAndResultListCommand#execute modelAccess = %1", (Object)this.modelAccess.getClass().getName());
        String string = this.dsiResponseContainer.getLispValidCharacters();
        String string2 = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        boolean bl2 = this.dsiResponseContainer.isLispIsUndoAvailable();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        this.logger.log(10000000, "ModelUpdateSpellerAndResultListCommand#execute valueList=%1", (Object)lIValueList);
        this.logger.log(10000000, "ModelUpdateSpellerAndResultListCommand#execute valid characters=%1", (Object)string);
        this.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
        this.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, this.requestID, this.startIndex);
        this.getCommandList().commandFinished();
    }
}

