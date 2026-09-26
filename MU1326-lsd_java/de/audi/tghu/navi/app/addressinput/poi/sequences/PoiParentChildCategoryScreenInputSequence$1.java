/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiParentChildCategoryScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiParentChildCategoryScreenInputSequence this$0;

    PoiParentChildCategoryScreenInputSequence$1(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, String string) {
        this.this$0 = poiParentChildCategoryScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        PoiParentChildCategoryScreenInputSequence.access$000(this.this$0).setParentElement((LIValueListElement)this.getCommandList().get("CurrentSelection"));
        this.getCommandList().commandFinished();
    }
}

