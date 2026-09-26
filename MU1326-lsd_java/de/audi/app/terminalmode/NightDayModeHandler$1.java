/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.NightDayModeHandler;
import de.audi.app.terminalmode.dsi.DefaultDSIGeneralVehicleStatesListener;

class NightDayModeHandler$1
extends DefaultDSIGeneralVehicleStatesListener {
    private final /* synthetic */ NightDayModeHandler this$0;

    NightDayModeHandler$1(NightDayModeHandler nightDayModeHandler) {
        this.this$0 = nightDayModeHandler;
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        NightDayModeHandler.access$000(this.this$0).log(1078071040, "<- [%1.updateDisplayDayNightDesign] %2", (Object)"NightDayModeHandler", (Object)(bl ? "night" : "day"));
        NightDayModeHandler.access$100(this.this$0, bl);
    }
}

