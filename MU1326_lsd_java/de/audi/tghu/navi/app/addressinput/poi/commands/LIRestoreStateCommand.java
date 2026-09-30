/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public class LIRestoreStateCommand
extends NavCommand {
    protected final LISpellerData spellerState;
    protected final IAdditionalStateInfo[] stateInfos;
    protected boolean lispUpdateSpellerResponded = false;
    protected boolean liValueListResponded = false;
    protected boolean liCurrentStateResponded = false;
    protected boolean liResultResponded = false;

    public LIRestoreStateCommand(LISpellerData lISpellerData) {
        this.spellerState = lISpellerData;
        this.stateInfos = null;
    }

    public LIRestoreStateCommand(SpellerStack.StackElement stackElement) {
        if (stackElement == null) {
            throw new IllegalArgumentException("Given StackElement is null!");
        }
        this.spellerState = stackElement.spellerData;
        this.stateInfos = stackElement.infos;
    }

    public void execute() {
        this.logger.log(10000000, "LIRestoreStateCommand#execute() - calling liRestoreState()");
        if (this.spellerState == null) {
            this.logger.log(10000000, "LIRestoreStateCommand#execute() - spellerState is null");
            this.getCommandList().commandAborted("LISpellerData is null");
        } else if (this.stateInfos != null) {
            this.logger.log(10000000, "LIRestoreStateCommand#execute() - calling restoreBefore()");
            for (int i2 = 0; i2 < this.stateInfos.length; ++i2) {
                this.stateInfos[i2].restoreBefore();
            }
        }
        this.getDSINavigation().liRestoreState(this.spellerState);
    }

    protected synchronized void checkFinished() {
        this.logger.log(10000000, "LIRestoreStateCommand#checkFinished() ");
        if (this.liValueListResponded && this.lispUpdateSpellerResponded && this.liCurrentStateResponded && this.liResultResponded) {
            if (this.stateInfos != null) {
                this.logger.log(10000000, "LIRestoreStateCommand#checkFinished() - calling restoreAfter()");
                for (int i2 = 0; i2 < this.stateInfos.length; ++i2) {
                    this.stateInfos[i2].restoreAfter();
                }
            }
            this.logger.log(10000000, "LIRestoreStateCommand#checkFinished() - finished");
            this.getCommandList().commandFinished();
        }
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(10000000, "LIRestoreStateCommand#lispUpdateSpellerResult() ");
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.lispUpdateSpellerResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(10000000, "LIRestoreStateCommand#liValueList() - lispValueListCount: %1", l);
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "LIRestoreStateCommand#liValueList() - lispValueList: %1", (Object)lIValueList);
        }
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000000, "LIRestoreStateCommand#liCurrentState - liCurrentLd=%1; availableSelectionCriteria=%2; usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        if (l == 0L) {
            this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
            this.liCurrentStateResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    public void liResult(long l) {
        this.logger.log(10000000, "LIRestoreStateCommand#liResult( %1 )", l);
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

