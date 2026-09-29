/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.tghu.navi.app.addressinput.poi.rrd.PoiDistanceCalculator;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.PosPosition;

class PoiDistanceCalculator$1
extends NavCommand {
    private final /* synthetic */ PoiDistanceCalculator this$0;

    PoiDistanceCalculator$1(PoiDistanceCalculator poiDistanceCalculator, String string) {
        this.this$0 = poiDistanceCalculator;
        super(string);
    }

    @Override
    public void execute() {
        PosPosition posPosition = PoiDistanceCalculator.access$000(this.this$0).getPosition();
        PoiDistanceCalculator.access$100(this.this$0).updateDirectionAndAirDistance(posPosition);
        this.getCommandList().commandFinished();
    }
}

