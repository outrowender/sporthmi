/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.PartialPopupComponent;
import de.audi.app.online.evo.PartialPopupComponent$1$1;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class PartialPopupComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ PartialPopupComponent this$0;

    PartialPopupComponent$1(PartialPopupComponent partialPopupComponent, String string, RemoteHMIService remoteHMIService) {
        this.this$0 = partialPopupComponent;
        this.val$remoteHmiService = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        PartialPopupComponent$1$1 partialPopupComponent$1$1 = new PartialPopupComponent$1$1(this, object);
        this.val$remoteHmiService.execute(partialPopupComponent$1$1);
    }

    static /* synthetic */ PartialPopupComponent access$000(PartialPopupComponent$1 partialPopupComponent$1) {
        return partialPopupComponent$1.this$0;
    }
}

