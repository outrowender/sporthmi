/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$MessageType;

final class FolderBrowsingService$DiagPlugIn
implements IDiagPlugIn {
    private static final int MESSAGE_TYPE_EMAIL;
    private final /* synthetic */ FolderBrowsingService this$0;

    FolderBrowsingService$DiagPlugIn(FolderBrowsingService folderBrowsingService) {
        this.this$0 = folderBrowsingService;
    }

    public void cmdRequestEnterAccount(int n) {
        this.this$0.requestEnterAccount(n == 1 ? IFolderBrowsingService$MessageType.EMAIL : IFolderBrowsingService$MessageType.SMS);
    }
}

