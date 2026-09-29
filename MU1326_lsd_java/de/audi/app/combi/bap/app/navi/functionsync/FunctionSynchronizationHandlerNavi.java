/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.functionsync;

import de.audi.app.combi.bap.app.navi.functionsync.FunctionSynchronizationNavi;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;

public class FunctionSynchronizationHandlerNavi
extends AbstractFunctionSynchronizationHandler {
    private static final String SYSTEM_PROPERTY_FUNCTION_SYNC_DISABLE_NAVI;

    public FunctionSynchronizationHandlerNavi(AbstractCombiModule abstractCombiModule) {
        super(abstractCombiModule);
        this.functionSyncDisabled = Boolean.getBoolean("DisableClusterFunctionSyncNavi");
    }

    @Override
    protected AbstractFunctionSynchronization createFunctionSync(int n) {
        this.logChannel.log(-2137614336, "[FunctionSynchronizationHandlerNavi#createFunctionSync] create new functionSync of type %1", (long)n);
        return new FunctionSynchronizationNavi((AbstractCombiModule)this.moduleFsg, this, n);
    }
}

