/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;

class ADBDSIListener$37
extends CommandResponse {
    private final /* synthetic */ DownloadInfo val$downloadCountOpp;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$37(ADBDSIListener aDBDSIListener, DownloadInfo downloadInfo, int n) {
        this.this$0 = aDBDSIListener;
        this.val$downloadCountOpp = downloadInfo;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountOpp(this.val$downloadCountOpp, this.val$validFlag);
    }
}

