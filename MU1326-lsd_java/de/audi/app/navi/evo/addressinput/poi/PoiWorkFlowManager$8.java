/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiWorkFlowManager$8
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$8(PoiWorkFlowManager poiWorkFlowManager, String string) {
        this.this$0 = poiWorkFlowManager;
        super(string);
    }

    @Override
    public void execute() {
        LIValueListElement lIValueListElement = (LIValueListElement)this.getCommandList().get("CurrentSelection");
        this.logger.log(-2137614336, "%1#NavCommand#execute: element retreived: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        this.getCommandList().commandFinishedWithPostCommand(new LIGetStateCommand(PoiWorkFlowManager.access$800(this.this$0), lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(15), null));
    }
}

