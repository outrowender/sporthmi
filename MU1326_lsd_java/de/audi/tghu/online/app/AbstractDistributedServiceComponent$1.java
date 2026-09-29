/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.tghu.online.app.AbstractDistributedServiceComponent;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class AbstractDistributedServiceComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ AbstractDistributedServiceComponent this$0;

    AbstractDistributedServiceComponent$1(AbstractDistributedServiceComponent abstractDistributedServiceComponent, String string) {
        this.this$0 = abstractDistributedServiceComponent;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        String string = AbstractDistributedServiceComponent.access$000(this.this$0, object);
        boolean bl = AbstractDistributedServiceComponent.access$100(this.this$0, string);
        AbstractDistributedServiceComponent.access$200(this.this$0).log(1078071040, "DistributedServiceComponent#indicateCommand handling Destination %1, handled = %2", (Object)string, (Object)Boolean.toString(bl));
        if (!bl) {
            this.this$0.initiateHMIJump(string);
        }
    }
}

