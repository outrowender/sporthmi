/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.TopPoiResultsByUIDWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class TopPoiResultsByUIDWrapperSequence$2
extends NavCommand {
    private final /* synthetic */ TopPoiResultsByUIDWrapperSequence this$0;

    TopPoiResultsByUIDWrapperSequence$2(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        this.this$0 = topPoiResultsByUIDWrapperSequence;
    }

    @Override
    public void execute() {
        LIValueListElement lIValueListElement = new LIValueListElement();
        lIValueListElement.poiUniqueId = TopPoiResultsByUIDWrapperSequence.access$000(this.this$0);
        PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(TopPoiResultsByUIDWrapperSequence.access$100(this.this$0), TopPoiResultsByUIDWrapperSequence.access$200(this.this$0), TopPoiResultsByUIDWrapperSequence.access$300(this.this$0), this.env, lIValueListElement, TopPoiResultsByUIDWrapperSequence.access$400(this.this$0), true, TopPoiResultsByUIDWrapperSequence.access$500(this.this$0), this.this$0.detailsScreen);
        this.this$0.currentInputSequence = poiResultsGeneralInputSequence;
        this.logger.log(-2137614336, "[PoiInput] TopPoiResultsByUIDWrapperSequence#navCommand#execute() - continue directly to results screen");
        this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
    }
}

