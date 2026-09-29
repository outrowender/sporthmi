/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringSDSCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiSelectSelectionCriteriaSubstringCommand
extends NavCommand {
    protected final SubstringSearchHandler searchHandler;
    protected final int selectionCriteriaIndex;
    protected final int maxItemsCount;
    protected boolean liValueListResponded;
    protected boolean lispUpdateSpellerResponded;
    protected boolean updatePoiSubstringSearchResponded;
    protected boolean liResultResponded;
    protected boolean substringSearchStarted;

    public PoiSelectSelectionCriteriaSubstringCommand(int n, int n2, SubstringSearchHandler substringSearchHandler) {
        this.selectionCriteriaIndex = n;
        this.maxItemsCount = n2;
        this.searchHandler = substringSearchHandler;
    }

    @Override
    public void execute() {
        if (this.env.getInputModeManager().isSdsActive()) {
            this.logger.log(1078071040, "%1#execute() - SDS is active, starting workaround command instead.", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaSubstringSDSCommand(this.selectionCriteriaIndex, this.maxItemsCount, this.searchHandler));
        } else {
            this.logger.log(1078071040, "%1#execute() - selectionCriteriaIndex: %2, maxItemsCount: %3", (Object)this.CLASS_NAME, (long)this.selectionCriteriaIndex, (long)this.maxItemsCount);
            this.getDSINavigation().poiSelectSelectionCriteria(this.selectionCriteriaIndex);
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(1078071040, "%1#liValueList - lispValueListCount: %2", (Object)this.CLASS_NAME, l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(1078071040, "%1#lispUpdateSpellerResult - resultCode: %2", (Object)this.CLASS_NAME, l);
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.lispUpdateSpellerResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logger.log(-2137614336, "%1#updatePoiSubstringSearchStatus( %2 ), minimumItems to move on = %3", (Object)this.CLASS_NAME, (Object)valueListStatus, (long)this.maxItemsCount);
        this.dsiResponseContainer.setPoiSubstringSearchStatus(valueListStatus);
        if (valueListStatus.getStatus() == 0) {
            this.logger.log(-2137614336, "%1#updatePoiSubstringSearchStatus( %2) - status is invalid.", (Object)this.CLASS_NAME, (Object)valueListStatus);
            return;
        }
        if (valueListStatus.getStatus() == 2 && valueListStatus.getDistance() == 0) {
            this.logger.log(-2137614336, "%1#updatePoiSubstringSearchStatus() - search is starting.", (Object)this.CLASS_NAME);
            this.substringSearchStarted = true;
        }
        if (!this.substringSearchStarted) {
            return;
        }
        if (this.searchHandler != null) {
            this.searchHandler.updatePoiSubstringSearchStatus(valueListStatus);
        }
        if (valueListStatus.getStatus() == 1 || valueListStatus.getStatus() == 3 || valueListStatus.getNumberOfAvailableItems() >= this.maxItemsCount) {
            this.updatePoiSubstringSearchResponded = true;
            this.checkFinished();
        }
    }

    @Override
    public void liResult(long l) {
        this.logger.log(-2137614336, "%1#liResult( %2 )", (Object)this.CLASS_NAME, l);
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    protected void checkFinished() {
        if (this.liValueListResponded && this.lispUpdateSpellerResponded && this.updatePoiSubstringSearchResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }
}

