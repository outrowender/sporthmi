/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class TMCAbstractListManager$9
extends TMCCommand {
    private final /* synthetic */ int val$distCarToFinalDest;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$9(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, int n) {
        this.this$0 = tMCAbstractListManager;
        this.val$distCarToFinalDest = n;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.lc.log(-2137614336, "%1#updateDistanceAndDirection(distCarToFinalDest:%1) execute", (Object)TMCAbstractListManager.access$200(), (long)this.val$distCarToFinalDest);
        BaseListModelApp baseListModelApp = this.this$0.listModel.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)baseListModelApp.getRow(i2);
            if (tMCAbstractListRow == null || tMCAbstractListRow.getTmcListElement().hasChild) continue;
            tMCAbstractListRow.updateDistanceAndDireciton(this.val$distCarToFinalDest, this.this$0.rowBuilder.getDirectionArrow(tMCAbstractListRow.getTmcListElement().getMessage()), this.this$0.rowBuilder.getAirDistance(tMCAbstractListRow.getTmcListElement().getMessage()));
            baseListModelApp.setRow(i2, tMCAbstractListRow);
        }
        this.this$0.listModel.update(baseListModelApp);
        baseListModelApp = this.this$0.listModelDetails.getCopy();
        TMCAbstractListRow tMCAbstractListRow = null;
        for (int i3 = 0; i3 < baseListModelApp.getLength(); ++i3) {
            TMCAbstractListRow tMCAbstractListRow2 = (TMCAbstractListRow)baseListModelApp.getRow(i3);
            long l = (long)this.val$distCarToFinalDest - tMCAbstractListRow2.getTmcListElement().getMessage().distanceToEvent;
            if (tMCAbstractListRow2.isLayoutOnRoute() && l < 0L) {
                tMCAbstractListRow = tMCAbstractListRow2;
                continue;
            }
            tMCAbstractListRow2.updateDistanceAndDireciton(this.val$distCarToFinalDest, this.this$0.rowBuilder.getDirectionArrow(tMCAbstractListRow2.getTmcListElement().getMessage()), this.this$0.rowBuilder.getAirDistance(tMCAbstractListRow2.getTmcListElement().getMessage()));
            baseListModelApp.setRow(i3, tMCAbstractListRow2);
        }
        if (tMCAbstractListRow != null) {
            baseListModelApp.remove(tMCAbstractListRow);
        }
        this.this$0.listModelDetails.update(baseListModelApp);
        this.getCommandList().commandFinished();
    }
}

