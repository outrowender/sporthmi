/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import de.esolutions.fw.util.commons.Buffer;
import java.util.List;

class ComponentState$CheckDependenciesJob
implements Runnable {
    final List queue;
    final boolean startSubComponents;
    private final /* synthetic */ ComponentState this$0;

    ComponentState$CheckDependenciesJob(ComponentState componentState, List list, boolean bl) {
        this.this$0 = componentState;
        this.queue = list;
        this.startSubComponents = bl;
    }

    public String toString() {
        return new Buffer(50).append("CheckDependenciesJob(").append(this.this$0.getComponentName()).append(')').toString();
    }

    @Override
    public void run() {
        if (ComponentState.access$200(this.this$0, this.queue, this.startSubComponents)) {
            ComponentState.access$300(this.this$0).log(-2137614336, "CheckDependenciesJob[%1] OK!", (Object)this.this$0.getComponentName());
            if (this.this$0.getDomainId() > 0) {
                this.this$0.enqueueDomainStart(this.queue, this.this$0.getDomainId(), this.this$0.getStateFlagsMinimum(), this.this$0.getStateFlagsRequired(), ComponentState.access$400(this.this$0, this.queue, this.startSubComponents), false, true);
            } else {
                ComponentState.access$000(this.this$0, this.queue, true, this.startSubComponents);
            }
        } else {
            ComponentState.access$300(this.this$0).log(-2137614336, "CheckDependenciesJob[%1] not OK!", (Object)this.this$0.getComponentName());
        }
    }
}

