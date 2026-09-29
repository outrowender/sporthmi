/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbInitListener;

class ADBDSIListener$70
extends CommandResponse {
    private final /* synthetic */ int val$maxSpeedDialEntries;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$70(ADBDSIListener aDBDSIListener, int n, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$maxSpeedDialEntries = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbInitListener)dSIListener).updateMaxSpeedDialEntries(this.val$maxSpeedDialEntries, this.val$validFlag);
    }
}

