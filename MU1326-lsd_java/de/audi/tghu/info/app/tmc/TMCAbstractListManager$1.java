/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.tmc.TmcListElement;

class TMCAbstractListManager$1
extends TMCCommand {
    private final /* synthetic */ TmcListElement[] val$elements;
    private final /* synthetic */ BaseListModelApp val$listModelEmptyCopy;
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$1(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, TmcListElement[] tmcListElementArray, BaseListModelApp baseListModelApp, int n) {
        this.this$0 = tMCAbstractListManager;
        this.val$elements = tmcListElementArray;
        this.val$listModelEmptyCopy = baseListModelApp;
        this.val$requestId = n;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.lc.log(-2137614336, "TMCAbstractListManager#tmcWindowResult - execute");
        EvoListRow[] evoListRowArray = new TMCAbstractListRow[this.val$elements.length];
        for (int i2 = 0; i2 < this.val$elements.length; ++i2) {
            TMCAbstractListRow tMCAbstractListRow;
            if (this.val$elements[i2].hasChild) {
                tMCAbstractListRow = this.this$0.rowBuilder.buildParentNodeListRow(this.val$elements[i2], this.this$0.getOpenedAnchorId());
                if (TMCAbstractListManager.access$000(this.this$0) && this.val$elements[i2].getUID() == this.this$0.getOpenedAnchorId()) {
                    TMCAbstractListManager.access$100(this.this$0, this.val$elements, i2);
                }
            } else {
                tMCAbstractListRow = this.this$0.rowBuilder.buildSimpleListRow(this.val$elements[i2]);
            }
            evoListRowArray[i2] = tMCAbstractListRow;
            this.this$0.onTmcWindowResult(this.val$elements[i2], (TMCAbstractListRow)evoListRowArray[i2]);
        }
        this.val$listModelEmptyCopy.setRows(this.val$requestId, this.val$elements[0].getPositionInCompleteList() - 1, evoListRowArray);
        this.this$0.listModel.update(this.val$listModelEmptyCopy);
        if (this.val$requestId == -3) {
            this.this$0.loadNextDetailsScreen();
        }
        if (this.val$requestId == -2) {
            this.this$0.onTmcWindowChanged();
        }
        this.getCommandList().commandFinished();
    }
}

