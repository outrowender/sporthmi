/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;

class AbstractExternalServiceProvider$4
extends AbstractCommandHandler {
    private final /* synthetic */ AbstractExternalServiceProvider this$0;

    AbstractExternalServiceProvider$4(AbstractExternalServiceProvider abstractExternalServiceProvider, String string) {
        this.this$0 = abstractExternalServiceProvider;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        AbstractExternalServiceProvider.access$000(this.this$0);
    }
}

