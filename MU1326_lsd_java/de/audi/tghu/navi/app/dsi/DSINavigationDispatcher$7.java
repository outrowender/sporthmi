/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$7
extends CommandResponse {
    private final /* synthetic */ NavLocation val$liCurrentLD;
    private final /* synthetic */ int[] val$availableSelectionCriteria;
    private final /* synthetic */ int[] val$usefulRefinementCriteria;
    private final /* synthetic */ long val$returnCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$7(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$liCurrentLD = navLocation;
        this.val$availableSelectionCriteria = nArray;
        this.val$usefulRefinementCriteria = nArray2;
        this.val$returnCode = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liCurrentState(this.val$liCurrentLD, this.val$availableSelectionCriteria, this.val$usefulRefinementCriteria, this.val$returnCode);
    }
}

