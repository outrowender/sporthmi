/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.PartialPopupComponent;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class PartialPopupComponent$2
extends AbstractCommandHandler {
    private final /* synthetic */ PartialPopupComponent this$0;

    PartialPopupComponent$2(PartialPopupComponent partialPopupComponent, String string) {
        this.this$0 = partialPopupComponent;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        PartialPopupComponent.access$300(this.this$0);
        PartialPopupComponent.access$200(this.this$0).flushModelGroup();
    }
}

