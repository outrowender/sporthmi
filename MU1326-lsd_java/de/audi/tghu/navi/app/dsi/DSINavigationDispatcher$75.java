/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RrdCalculationInfo;

class DSINavigationDispatcher$75
extends CommandResponse {
    private final /* synthetic */ RrdCalculationInfo[] val$rrdCalculationInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$75(DSINavigationDispatcher dSINavigationDispatcher, RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rrdCalculationInfo = rrdCalculationInfoArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRrdCalculationInfo(this.val$rrdCalculationInfo);
    }
}

