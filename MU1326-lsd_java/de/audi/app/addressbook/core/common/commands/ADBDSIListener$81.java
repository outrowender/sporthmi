/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

class ADBDSIListener$81
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AdbEntry[] val$entries;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$81(ADBDSIListener aDBDSIListener, int n, AdbEntry[] adbEntryArray) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entries = adbEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbVCardExchangeListener)dSIListener).parseVCardResult(this.val$success, this.val$entries);
    }
}

