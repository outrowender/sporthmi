/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.ViaPointListElement;

class DSINavigationDispatcher$109
extends CommandResponse {
    private final /* synthetic */ int val$usedAnchorId;
    private final /* synthetic */ ViaPointListElement[] val$viaPointListElements;
    private final /* synthetic */ int val$totalListLength;
    private final /* synthetic */ int val$positionOfUsedAnchorIdInList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$109(DSINavigationDispatcher dSINavigationDispatcher, int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.this$0 = dSINavigationDispatcher;
        this.val$usedAnchorId = n;
        this.val$viaPointListElements = viaPointListElementArray;
        this.val$totalListLength = n2;
        this.val$positionOfUsedAnchorIdInList = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liGetViaPointListResult(this.val$usedAnchorId, this.val$viaPointListElements, this.val$totalListLength, this.val$positionOfUsedAnchorIdInList);
    }
}

