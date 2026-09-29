/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbInitListener;

class ADBDSIListener$66
extends CommandResponse {
    private final /* synthetic */ int val$maxLocalEntries;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$66(ADBDSIListener aDBDSIListener, int n, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$maxLocalEntries = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbInitListener)dSIListener).updateMaxLocalEntries(this.val$maxLocalEntries, this.val$validFlag);
    }
}

