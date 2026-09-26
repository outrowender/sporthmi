/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;

class ADBDSIListener$42
extends CommandResponse {
    private final /* synthetic */ int val$downloadState2ndPhone;
    private final /* synthetic */ int val$failureReason;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$42(ADBDSIListener aDBDSIListener, int n, int n2, int n3) {
        this.this$0 = aDBDSIListener;
        this.val$downloadState2ndPhone = n;
        this.val$failureReason = n2;
        this.val$validFlag = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateDownloadState2ndPhone(this.val$downloadState2ndPhone, this.val$failureReason, this.val$validFlag);
    }
}

