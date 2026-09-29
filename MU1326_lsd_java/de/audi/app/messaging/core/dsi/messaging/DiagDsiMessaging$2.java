/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;

class DiagDsiMessaging$2
implements Runnable {
    private final /* synthetic */ FolderEntry val$activeFolderEntry;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ ListChangedInformation val$information;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$2(DiagDsiMessaging diagDsiMessaging, FolderEntry folderEntry, int n, ListChangedInformation listChangedInformation) {
        this.this$0 = diagDsiMessaging;
        this.val$activeFolderEntry = folderEntry;
        this.val$resultCode = n;
        this.val$information = listChangedInformation;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).changeFolderResponse(this.val$activeFolderEntry, this.val$resultCode);
        if (this.val$resultCode == 0) {
            DiagDsiMessaging.access$000(this.this$0).indicateListChanged(this.val$information);
        }
    }
}

