/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.BapManeuverDescriptor;

class DSINavigationDispatcher$160
extends CommandResponse {
    private final /* synthetic */ BapManeuverDescriptor[] val$bapManeuverDescriptor;
    private final /* synthetic */ int val$exitViewId;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$160(DSINavigationDispatcher dSINavigationDispatcher, BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$bapManeuverDescriptor = bapManeuverDescriptorArray;
        this.val$exitViewId = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateBapManeuverInformation(this.val$bapManeuverDescriptor, this.val$exitViewId);
    }
}

