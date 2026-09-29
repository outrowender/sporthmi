/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbSetupListener;

class ADBDSIListener$53
extends CommandResponse {
    private final /* synthetic */ int val$sortOrder;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$53(ADBDSIListener aDBDSIListener, int n, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$sortOrder = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbSetupListener)dSIListener).updateSortOrder(this.val$sortOrder, this.val$validFlag);
    }
}

