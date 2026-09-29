/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;

class ADBDSIListener$40
extends CommandResponse {
    private final /* synthetic */ int val$profileId;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$40(ADBDSIListener aDBDSIListener, int n) {
        this.this$0 = aDBDSIListener;
        this.val$profileId = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).profileDeleted(this.val$profileId);
    }
}

