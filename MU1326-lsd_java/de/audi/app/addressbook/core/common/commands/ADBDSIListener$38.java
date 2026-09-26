/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;

class ADBDSIListener$38
extends CommandResponse {
    private final /* synthetic */ DownloadInfo val$downloadCountSim;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$38(ADBDSIListener aDBDSIListener, DownloadInfo downloadInfo, int n) {
        this.this$0 = aDBDSIListener;
        this.val$downloadCountSim = downloadInfo;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountSim(this.val$downloadCountSim, this.val$validFlag);
    }
}

