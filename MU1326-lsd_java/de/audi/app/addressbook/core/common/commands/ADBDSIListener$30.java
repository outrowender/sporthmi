/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;

class ADBDSIListener$30
extends CommandResponse {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$30(ADBDSIListener aDBDSIListener, String string) {
        this.this$0 = aDBDSIListener;
        this.val$name = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).newDeviceConnected(this.val$name);
    }
}

