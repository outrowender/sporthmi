/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEditListener;

class ADBDSIListener$24
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AdbEntry val$entry;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$24(ADBDSIListener aDBDSIListener, int n, AdbEntry adbEntry) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entry = adbEntry;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbEditListener)dSIListener).getEntryByReferenceIdResult(this.val$success, this.val$entry);
    }
}

