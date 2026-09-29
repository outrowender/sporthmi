/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbSetupListener;

class ADBDSIListener$46
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ String val$fullPath;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$46(ADBDSIListener aDBDSIListener, int n, String string) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$fullPath = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbSetupListener)dSIListener).importBackupFileResult(this.val$success, this.val$fullPath);
    }
}

