/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import java.util.List;

class AbstractExternalServiceProvider$1
extends AbstractCommandHandler {
    private final /* synthetic */ AbstractExternalServiceProvider this$0;

    AbstractExternalServiceProvider$1(AbstractExternalServiceProvider abstractExternalServiceProvider, String string) {
        this.this$0 = abstractExternalServiceProvider;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        List list = (List)object;
        this.this$0.sendAppsUpdateToDestAndMap(list);
        this.this$0.sendAppsUpdateToOperatorCall(list);
    }
}

