/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

class PoiResultScreenWithSpellerInputSequence$5
extends NavCommand {
    private final /* synthetic */ LIValueList val$list;
    private final /* synthetic */ PoiResultScreenWithSpellerInputSequence this$0;

    PoiResultScreenWithSpellerInputSequence$5(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence, String string, LIValueList lIValueList) {
        this.this$0 = poiResultScreenWithSpellerInputSequence;
        this.val$list = lIValueList;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getContainer().setLispValueListCount(0L);
        this.env.getContainer().setLispValueList(this.val$list);
        this.commandList.commandFinished();
    }
}

