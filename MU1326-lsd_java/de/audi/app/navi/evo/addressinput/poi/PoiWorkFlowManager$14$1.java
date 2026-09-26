/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager$14;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class PoiWorkFlowManager$14$1
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager$14 this$1;

    PoiWorkFlowManager$14$1(PoiWorkFlowManager$14 poiWorkFlowManager$14, String string) {
        this.this$1 = poiWorkFlowManager$14;
        super(string);
    }

    @Override
    public void execute() {
        if (PoiWorkFlowManager$14.access$1000(this.this$1).getSearchContext() == 1) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(0xF800000, Util.isHURegionNAR()));
        } else {
            NavLocation navLocation = PoiUtil.getLocation(PoiWorkFlowManager$14.access$1000(this.this$1), this.env);
            CommandList commandList = PoiWorkFlowManager.access$000(PoiWorkFlowManager$14.access$1100(this.this$1)).createCommandList();
            commandList.add(new PoiSetContextCommand(navLocation));
            commandList.add(new LIStartSpellerCommand(0xF800000, false, false, false));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

