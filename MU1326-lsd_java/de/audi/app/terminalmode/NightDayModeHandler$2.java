/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.NightDayModeHandler;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;

class NightDayModeHandler$2
implements IDSIClient {
    private final /* synthetic */ NightDayModeHandler this$0;

    NightDayModeHandler$2(NightDayModeHandler nightDayModeHandler) {
        this.this$0 = nightDayModeHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{16};
    }
}

