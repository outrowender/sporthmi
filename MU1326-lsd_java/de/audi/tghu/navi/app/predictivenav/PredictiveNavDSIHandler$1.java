/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavDSIHandler;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;

class PredictiveNavDSIHandler$1
implements IDSIClient {
    private final /* synthetic */ PredictiveNavDSIHandler this$0;

    PredictiveNavDSIHandler$1(PredictiveNavDSIHandler predictiveNavDSIHandler) {
        this.this$0 = predictiveNavDSIHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        PredictiveNavDSIHandler.access$000(this.this$0, (DSIPredictiveNavigation)dSIBase);
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{1, 3, 2};
    }
}

