/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.navigation.LIValueList;

public class LIStartSpellerCommand
extends NavCommand {
    private int selectionCriterion;
    private int selectionCriterion2;
    private boolean removeZipCode;
    private boolean removeTown;
    private boolean removeStreet;
    private boolean valueListResponded = false;
    private boolean spellerResultResponded = false;

    public LIStartSpellerCommand(int n, boolean bl, boolean bl2, boolean bl3) {
        this(n, -1, bl, bl2, bl3);
    }

    public LIStartSpellerCommand(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        super((String)null);
        this.selectionCriterion = n;
        this.selectionCriterion2 = n2;
        this.removeZipCode = bl;
        this.removeTown = bl2;
        this.removeStreet = bl3;
    }

    public void execute() {
        if (this.selectionCriterion2 == -1) {
            this.logger.log(10000000, "LIStartSpellerCommand#execute() - calling liStartSpeller( %1 ) ", (Object)Selcrit.asString(this.selectionCriterion));
            this.logger.log(10000000, "LIStartSpellerCommand#execute() - calling liStartSpeller( %1, %2, %3) ", this.removeZipCode, this.removeTown, this.removeStreet);
            this.getDSINavigation().liStartSpeller(this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet);
        } else {
            this.logger.log(10000000, "LIStartSpellerCommand#execute() - calling liStartMultiCriteriaSpeller( %1, %2 ) ", (Object)Selcrit.asString(this.selectionCriterion), (Object)Selcrit.asString(this.selectionCriterion2));
            this.getDSINavigation().liStartMultiCriteriaSpeller(this.selectionCriterion, this.selectionCriterion2, this.removeZipCode, this.removeTown, this.removeStreet);
        }
    }

    protected void checkFinished() {
        if (this.valueListResponded && this.spellerResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(10000000, "LIStartSpellerCommand#lispUpdateSpellerResult() with lispCurrentSelectionCriterion = %1 and lispValidCharacters = %2 ", (Object)Integer.toString(n), (Object)string2);
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.spellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(10000000, "LIStartSpellerCommand#liValueList() - lispValueListCount=%1", l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.valueListResponded = true;
        this.checkFinished();
    }
}

