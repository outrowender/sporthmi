/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;

class ADBDSIListener$3
extends CommandResponse {
    private final /* synthetic */ int val$reason;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$3(ADBDSIListener aDBDSIListener, int n) {
        this.this$0 = aDBDSIListener;
        this.val$reason = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).invalidData(this.val$reason);
    }
}

