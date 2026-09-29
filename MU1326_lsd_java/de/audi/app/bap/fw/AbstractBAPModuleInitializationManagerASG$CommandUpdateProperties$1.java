/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.utils.CollectionUtils$Predicate;

class AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties$1
implements CollectionUtils$Predicate {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties this$1;

    AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties$1(AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties abstractBAPModuleInitializationManagerASG$CommandUpdateProperties) {
        this.this$1 = abstractBAPModuleInitializationManagerASG$CommandUpdateProperties;
    }

    @Override
    public boolean evaluate(Object object) {
        BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)object;
        int n = bAPFunctionPropertyASG.getFctID();
        return n == AbstractBAPModuleInitializationManagerASG.access$000(AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties.access$100(this.this$1)).getFunctionList().getOperationStateBAPFctID() || AbstractBAPModuleInitializationManagerASG.access$000(AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties.access$100(this.this$1)).getFunctionList().isInModuleSpecificRange(n) && AbstractBAPModuleInitializationManagerASG.access$000(AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties.access$100(this.this$1)).getFunctionList().isFunctionSupported(n);
    }
}

