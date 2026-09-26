/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.dataupdates;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IGenericDataUpdatePayload;
import de.audi.tghu.online.app.dataupdates.AbstractDataUpdateComponent;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class AbstractDataUpdateComponent$2
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ AbstractDataUpdateComponent this$0;

    AbstractDataUpdateComponent$2(AbstractDataUpdateComponent abstractDataUpdateComponent, String string, LogChannel logChannel) {
        this.this$0 = abstractDataUpdateComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "AbstractDataUpdateComponent#indicateCommand() dataUpdate finished received");
        if (object instanceof IGenericDataUpdatePayload) {
            this.this$0.indicateDataUpdateFinished((IGenericDataUpdatePayload)object);
        }
    }
}

