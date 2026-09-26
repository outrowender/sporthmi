/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class FillListByCompleteSpellerResultCommand
extends NavCommand {
    public static final String COUNTRIES_LIST_KEY;
    private int selectionCriterion;
    private int selectionCriterion2;
    private boolean removeZipCode;
    private boolean removeTown;
    private boolean removeStreet;
    private CommandList postCommandList = null;
    private boolean valueListResponded = false;
    private boolean spellerResultResponded = false;
    private ListModelApp list;

    public FillListByCompleteSpellerResultCommand(ListModelApp listModelApp, int n, boolean bl, boolean bl2, boolean bl3) {
        this(listModelApp, n, -1, bl, bl2, bl3);
    }

    public FillListByCompleteSpellerResultCommand(ListModelApp listModelApp, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.list = listModelApp;
        this.selectionCriterion = n;
        this.selectionCriterion2 = n2;
        this.removeZipCode = bl;
        this.removeTown = bl2;
        this.removeStreet = bl3;
        listModelApp.setMaxColumns(2);
        listModelApp.clear();
    }

    private FillListByCompleteSpellerResultCommand(ListModelApp listModelApp) {
        this.list = listModelApp;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "FillListByCompleteSpellerResultCommand#execute() - selectionCriterion: %1, selectionCriterion2: %2, list.getLength(): %3", (Object)Selcrit.asString(this.selectionCriterion), (Object)Selcrit.asString(this.selectionCriterion2), (long)this.list.getLength());
        this.logger.log(1078071040, "FillListByCompleteSpellerResultCommand#execute() - removeZipCode: %1, removeTown: %2, removeStreet: %3", this.removeZipCode, this.removeTown, this.removeStreet);
        try {
            if (this.list.getLength() == 0) {
                if (this.selectionCriterion2 == -1) {
                    this.logger.log(1078071040, "FillListByCompleteSpellerResultCommand#execute() - call liStartSpeller()");
                    this.getDSINavigation().liStartSpeller(this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet);
                } else {
                    this.logger.log(1078071040, "FillListByCompleteSpellerResultCommand#execute() - call liStartMultiCriteriaSpeller(%1, %2)", (Object)Selcrit.asString(this.selectionCriterion), (Object)Selcrit.asString(this.selectionCriterion2));
                    this.getDSINavigation().liStartMultiCriteriaSpeller(this.selectionCriterion, this.selectionCriterion2, this.removeZipCode, this.removeTown, this.removeStreet);
                }
            } else {
                int n = ((IntegerListCell)this.list.getCell(this.list.getLength() - 1, 0)).getValue();
                this.logger.log(1078071040, "FillListByCompleteSpellerResultCommand#execute() - calling lispRequestValueListByListIndex(%1,true)", (long)n);
                this.getDSINavigation().lispRequestValueListByListIndex(n, true);
            }
        }
        catch (Exception exception) {
            this.getCommandList().commandAborted(exception);
        }
    }

    private void checkFinished() {
        int n = this.list.getLength();
        this.putResultInCommandListCache();
        if (n == 0) {
            if (this.valueListResponded && this.spellerResultResponded) {
                this.getCommandList().commandFinishedWithPostSequence(this.postCommandList);
            }
        } else if (this.valueListResponded) {
            this.getCommandList().commandFinishedWithPostSequence(this.postCommandList);
        }
    }

    private void putResultInCommandListCache() {
        LIValueListElement[] lIValueListElementArray = new LIValueListElement[this.list.getLength()];
        for (int i2 = 0; i2 < this.list.getLength(); ++i2) {
            lIValueListElementArray[i2] = (LIValueListElement)((ObjectListCell)this.list.getCell(i2, 1)).getValue();
        }
        this.getCommandList().put("countries", lIValueListElementArray);
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        int n;
        int n2;
        this.logger.log(1078071040, "LIStartSpellerCommand#liValueList() - (# %1) ", l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.valueListResponded = true;
        int n3 = this.list.getLength();
        if (l - (long)n3 <= 0L) {
            this.checkFinished();
            return;
        }
        if (n3 == 0 && (long)this.list.getMaxRows() < l) {
            this.list.setMaxRows((int)l);
        }
        int n4 = lIValueList.getList().length;
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        for (n2 = n = n3 > 0 ? 1 : 0; n2 < n4; ++n2) {
            this.list.addRow(new BaseListRow(new ListCell[]{new IntegerListCell(lIValueListElementArray[n2].listIndex, -129), new ObjectListCell(lIValueListElementArray[n2])}));
        }
        n2 = this.list.getLength();
        if ((long)n2 < l) {
            this.postCommandList = this.navigation.getCommandListFactory().createCommandList();
            this.postCommandList.add(new FillListByCompleteSpellerResultCommand(this.list));
        }
        this.checkFinished();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(1078071040, "LIStartSpellerCommand#lispUpdateSpellerResult() ");
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.spellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

