/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbInitListener;

class ADBDSIListener$58
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$58(ADBDSIListener aDBDSIListener, int n) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbInitListener)dSIListener).setProfileHandlingType(this.val$success);
    }
}

