/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.core.joker.AbstractJokerKeyComponent;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$CombiMFLHandler;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$JokerKeyFunction;

class AbstractJokerKeyComponent$JokerKeyFunctionCluster
extends AbstractJokerKeyComponent$JokerKeyFunction {
    private final /* synthetic */ AbstractJokerKeyComponent this$0;

    public AbstractJokerKeyComponent$JokerKeyFunctionCluster(AbstractJokerKeyComponent abstractJokerKeyComponent, int n, int n2, int n3, int n4) {
        this.this$0 = abstractJokerKeyComponent;
        super(abstractJokerKeyComponent, n, n2, n3, n4);
    }

    @Override
    protected void updateJokerKeyConfiguration() {
        this.this$0.getLogChannel().log(-2137614336, "[JokerKeyFunctionCluster#updateJokerKeyConfiguration] cluster specific joker key function (%1) selected, waiting for confirmation", (long)this.meaning);
        AbstractJokerKeyComponent$CombiMFLHandler.access$900(AbstractJokerKeyComponent.access$800(this.this$0), this.meaning);
    }
}

