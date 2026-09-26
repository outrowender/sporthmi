/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class SetInputCommand
extends NavCommand {
    private String input;
    private boolean autoSelection;
    private boolean liValueListResponded;
    private boolean lispUpdateSpellerResultResponded;
    private boolean liCurrentStateResponded;

    public SetInputCommand(String string) {
        this(string, false);
    }

    public SetInputCommand(String string, boolean bl) {
        this.input = string;
        this.autoSelection = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "%1#execute() - input = %2, autoSelect = %3", (Object)this.CLASS_NAME, (Object)String.valueOf(this.input), (Object)String.valueOf(this.autoSelection));
        this.getDSINavigation().lispSetInput(this.input, this.autoSelection);
        this.checkFinished();
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        this.logger.log(1078071040, "%1#checkFinished() - liCurrentState Responded = %2, liValueListResponded = %3, lispUpdateSpellerResultResponded = %4", (Object)this.CLASS_NAME, (Object)String.valueOf(this.liCurrentStateResponded), (Object)String.valueOf(this.liValueListResponded), (Object)String.valueOf(this.lispUpdateSpellerResultResponded));
        if (this.autoSelection) {
            if (this.liCurrentStateResponded) {
                this.getCommandList().commandFinished();
            }
        } else if (this.liValueListResponded && this.lispUpdateSpellerResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(-2137614336, "SetInputCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2; usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.liCurrentStateResponded = true;
        this.checkFinished();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(-2137614336, "SetInputCommand#lispUpdateSpellerResult() - lispCurrentInput=%1, lispIsFullMatch=%2, lispValidCharacters=%3", (Object)string, (Object)Boolean.toString(bl), (Object)string2);
        this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
        if (l == 0L) {
            this.lispUpdateSpellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

