/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.BapManeuverDescriptor;

class DSINavigationDispatcher$56
extends CommandResponse {
    private final /* synthetic */ BapManeuverDescriptor[] val$bapManeuverDescriptor;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$56(DSINavigationDispatcher dSINavigationDispatcher, BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$bapManeuverDescriptor = bapManeuverDescriptorArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateBapManeuverDescriptor(this.val$bapManeuverDescriptor);
    }
}

