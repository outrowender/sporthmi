/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;
import org.dsi.ifc.organizer.DownloadInfo;

class ADBDSIListener$83
extends CommandResponse {
    private final /* synthetic */ DownloadInfo val$importCount;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$83(ADBDSIListener aDBDSIListener, DownloadInfo downloadInfo, int n) {
        this.this$0 = aDBDSIListener;
        this.val$importCount = downloadInfo;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbVCardExchangeListener)dSIListener).updateImportCount(this.val$importCount, this.val$validFlag);
    }
}

