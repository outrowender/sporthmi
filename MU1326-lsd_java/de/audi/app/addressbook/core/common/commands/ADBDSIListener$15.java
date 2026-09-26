/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEditListener;

class ADBDSIListener$15
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AdbEntry[] val$entryList;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$15(ADBDSIListener aDBDSIListener, int n, AdbEntry[] adbEntryArray) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entryList = adbEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbEditListener)dSIListener).getEntriesResult(this.val$success, this.val$entryList);
    }
}

