/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.ui.mib2.IExternalService;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;

class AbstractExternalServiceProvider$3
extends AbstractCommandHandler {
    private final /* synthetic */ AbstractExternalServiceProvider this$0;

    AbstractExternalServiceProvider$3(AbstractExternalServiceProvider abstractExternalServiceProvider, String string) {
        this.this$0 = abstractExternalServiceProvider;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Object[] objectArray = (Object[])object;
        IExternalService iExternalService = (IExternalService)objectArray[0];
        Integer n2 = (Integer)objectArray[1];
        this.this$0.sendIconUpdateToMedia(iExternalService, n2);
    }
}

