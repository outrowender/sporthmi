/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.combi.bap.functionsync.AbstractCommandCloseFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.requests.StatusProperty;

final class CommandCloseFunctionSyncAudio
extends AbstractCommandCloseFunctionSync {
    public CommandCloseFunctionSyncAudio(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization);
    }

    protected StatusProperty createFunctionSynchronizationStatus() {
        return new FunctionSynchronisation_Status();
    }
}

