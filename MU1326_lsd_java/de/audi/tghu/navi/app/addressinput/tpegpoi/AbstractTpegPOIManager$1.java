/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi;

import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIManager;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractTpegPOIManager$1
extends NavCommand {
    private final /* synthetic */ AbstractTpegPOIManager this$0;

    AbstractTpegPOIManager$1(AbstractTpegPOIManager abstractTpegPOIManager, String string) {
        this.this$0 = abstractTpegPOIManager;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.previewMap.setPreviewAreaAroundCCP(5);
        this.getCommandList().commandFinished();
    }
}

