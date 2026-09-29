/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.memory.TourHandler;

class TourHandler$2
extends NavCommand {
    private final /* synthetic */ String val$tourname;
    private final /* synthetic */ TourHandler this$0;

    TourHandler$2(TourHandler tourHandler, String string, String string2) {
        this.this$0 = tourHandler;
        this.val$tourname = string2;
        super(string);
    }

    @Override
    public void execute() {
        GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
        guiTooltipInformationContainer.toolTipTwoLinesLine1st = this.val$tourname;
        guiTooltipInformationContainer.toolTipTwoLinesLine2nd = "";
        guiTooltipInformationContainer.toolTipOneLineLine1st = this.val$tourname;
        TourHandler.access$200(this.this$0).getPreviewMap().setPreviewRouteOffroad(TourHandler.access$100(this.this$0), 12, null, guiTooltipInformationContainer);
        this.getCommandList().commandFinished();
    }
}

