/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.functionsync;

import de.audi.app.combi.bap.functionsync.AbstractCommandCloseFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.vw.mib.bap.generated.navsd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.requests.StatusProperty;

public class CommandCloseFunctionSyncNavi
extends AbstractCommandCloseFunctionSync {
    public CommandCloseFunctionSyncNavi(AbstractCombiModule abstractCombiModule, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractCombiModule, abstractFunctionSynchronization);
    }

    @Override
    protected StatusProperty createFunctionSynchronizationStatus() {
        return new FunctionSynchronisation_Status();
    }
}

