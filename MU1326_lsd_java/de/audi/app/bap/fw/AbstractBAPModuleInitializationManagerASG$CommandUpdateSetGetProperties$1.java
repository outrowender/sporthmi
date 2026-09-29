/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.utils.CollectionUtils$Predicate;

class AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties$1
implements CollectionUtils$Predicate {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties this$1;

    AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties$1(AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties) {
        this.this$1 = abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties;
    }

    @Override
    public boolean evaluate(Object object) {
        BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)object;
        int n = bAPFunctionPropertyASG.getFctID();
        return AbstractBAPModuleInitializationManagerASG.access$000(AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties.access$200(this.this$1)).getFunctionList().isInModuleSpecificRange(n) && AbstractBAPModuleInitializationManagerASG.access$000(AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties.access$200(this.this$1)).getFunctionList().isFunctionSupported(n) && AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties.access$300(this.this$1, bAPFunctionPropertyASG);
    }
}

