/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;

class ADBDSIListener$36
extends CommandResponse {
    private final /* synthetic */ DownloadInfo val$downloadCountMe;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$36(ADBDSIListener aDBDSIListener, DownloadInfo downloadInfo, int n) {
        this.this$0 = aDBDSIListener;
        this.val$downloadCountMe = downloadInfo;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountMe(this.val$downloadCountMe, this.val$validFlag);
    }
}

