/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenWithMatchSpellerInputSequenceAsia$1
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithMatchSpellerInputSequenceAsia this$0;

    PoiResultScreenWithMatchSpellerInputSequenceAsia$1(PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia, String string) {
        this.this$0 = poiResultScreenWithMatchSpellerInputSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "%1#SelectListItem with Element from CommandListContext - getCommandList().get(IPoiWorkFlowManager.SELECTED_ELEMENT) = %2", (Object)this.CLASS_NAME, this.getCommandList().get("CurrentSelection"));
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

