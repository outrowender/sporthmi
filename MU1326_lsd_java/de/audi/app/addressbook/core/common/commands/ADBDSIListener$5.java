/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;

class ADBDSIListener$5
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$spellerHandle;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$5(ADBDSIListener aDBDSIListener, int n, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$spellerHandle = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).stopSpellerResult(this.val$success, this.val$spellerHandle);
    }
}

