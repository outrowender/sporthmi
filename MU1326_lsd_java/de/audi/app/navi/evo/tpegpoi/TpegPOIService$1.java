/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi;

import de.audi.app.navi.evo.tpegpoi.TpegPOIService;
import de.audi.tghu.navi.app.command.NavCommand;

class TpegPOIService$1
extends NavCommand {
    private final /* synthetic */ TpegPOIService this$0;

    TpegPOIService$1(TpegPOIService tpegPOIService, String string) {
        this.this$0 = tpegPOIService;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getLogChannel().log(1078071040, "TpegPOIService#startTpegPOI no TPEG POI data available");
        this.env.getChoiceModel(-1826486784).setValue(0);
        this.getCommandList().commandFinished();
    }
}

