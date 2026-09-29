/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;

class ADBDSIListener$41
extends CommandResponse {
    private final /* synthetic */ int val$downloadState;
    private final /* synthetic */ int val$failureReason;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$41(ADBDSIListener aDBDSIListener, int n, int n2, int n3) {
        this.this$0 = aDBDSIListener;
        this.val$downloadState = n;
        this.val$failureReason = n2;
        this.val$validFlag = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateDownloadState(this.val$downloadState, this.val$failureReason, this.val$validFlag);
    }
}

