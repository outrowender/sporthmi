/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoHmiListener;
import de.audi.app.info.tmc.InfoHmiListener$1;
import de.audi.app.info.tmc.InfoHmiListener$EvoTmcOptionModelListener$1;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;

class InfoHmiListener$EvoTmcOptionModelListener
extends DefaultOptionListener {
    private final /* synthetic */ InfoHmiListener this$0;

    private InfoHmiListener$EvoTmcOptionModelListener(InfoHmiListener infoHmiListener) {
        this.this$0 = infoHmiListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        InfoHmiListener.access$500(this.this$0).log(1078071040, "InfoHmiListener#EvoTmcOptionModelListener.keyPressed() modelID=%1, targetModelID=%2, targetRow=%3", (long)n, (long)n2, (long)n3);
        if (n == -341768448) {
            TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)InfoHmiListener.access$400(this.this$0).getBaseListModel(n2).getRow(n3);
            InfoHmiListener.access$300(this.this$0).setFocusedRowIndex(-1);
            this.showTmcEventInMap(tMCAbstractListRow);
        } else {
            InfoHmiListener.access$500(this.this$0).log(10000, "InfoHmiListener#EvoTmcOptionModelListener.keyPressed() unsupported modelID");
        }
        InfoHmiListener.access$400(this.this$0).getHMIService().getOptionModel(n).fireEvent(n5);
    }

    private void showTmcEventInMap(TMCAbstractListRow tMCAbstractListRow) {
        InfoHmiListener.access$200(this.this$0).getMapService().mapEntered();
        CommandListManager commandListManager = InfoHmiListener.access$200(this.this$0).getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new InfoHmiListener$EvoTmcOptionModelListener$1(this, InfoHmiListener.access$200(this.this$0), InfoHmiListener.access$500(this.this$0), tMCAbstractListRow));
        commandListManager.execute(commandList);
    }

    /* synthetic */ InfoHmiListener$EvoTmcOptionModelListener(InfoHmiListener infoHmiListener, InfoHmiListener$1 infoHmiListener$1) {
        this(infoHmiListener);
    }

    static /* synthetic */ InfoHmiListener access$900(InfoHmiListener$EvoTmcOptionModelListener infoHmiListener$EvoTmcOptionModelListener) {
        return infoHmiListener$EvoTmcOptionModelListener.this$0;
    }
}

