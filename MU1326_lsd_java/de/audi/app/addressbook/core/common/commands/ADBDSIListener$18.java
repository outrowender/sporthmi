/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbEditListener;

class ADBDSIListener$18
extends CommandResponse {
    private final /* synthetic */ boolean val$newPublicProfileEntryAvailable;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$18(ADBDSIListener aDBDSIListener, boolean bl, int n) {
        this.this$0 = aDBDSIListener;
        this.val$newPublicProfileEntryAvailable = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbEditListener)dSIListener).updateNewPublicProfileEntryAvailable(this.val$newPublicProfileEntryAvailable, this.val$validFlag);
    }
}

