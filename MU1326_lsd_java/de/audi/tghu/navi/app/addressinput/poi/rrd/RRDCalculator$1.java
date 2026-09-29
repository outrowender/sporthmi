/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.RRDCalculator;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocationWgs84;

class RRDCalculator$1
extends NavCommand {
    private final /* synthetic */ IRRDListProvider val$rrdListProvider;
    private final /* synthetic */ RRDCalculator this$0;

    RRDCalculator$1(RRDCalculator rRDCalculator, String string, IRRDListProvider iRRDListProvider) {
        this.this$0 = rRDCalculator;
        this.val$rrdListProvider = iRRDListProvider;
        super(string);
    }

    @Override
    public void execute() {
        NavLocationWgs84[] navLocationWgs84Array = this.val$rrdListProvider.getRRDCalculationList();
        if (navLocationWgs84Array != null && navLocationWgs84Array.length > 0) {
            RRDCalculator.access$000(this.this$0).log(1078071040, "RRDCalculator#createStartRRDCalculation - Command = GetRRDListForCalculation. List has Elements. Start RRDCalculation");
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.createStartRRDCalculation(navLocationWgs84Array));
        } else {
            RRDCalculator.access$000(this.this$0).log(1078071040, "RRDCalculator#createStartRRDCalculation - Command = GetRRDListForCalculation. The list is null or has no elements");
            this.getCommandList().commandFinished();
        }
    }
}

