/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.EntryMeter;

class ADBDSIListener$29
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ EntryMeter[] val$entryMeterVector;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$29(ADBDSIListener aDBDSIListener, int n, EntryMeter[] entryMeterArray) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entryMeterVector = entryMeterArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).entryMeterResult(this.val$success, this.val$entryMeterVector);
    }
}

