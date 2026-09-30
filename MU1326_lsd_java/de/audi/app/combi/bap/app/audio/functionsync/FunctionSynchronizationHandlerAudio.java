/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationAudio;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationHandler;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;

public final class FunctionSynchronizationHandlerAudio
extends AbstractFunctionSynchronizationHandler {
    private static final String SYSTEM_PROPERTY_FUNCTION_SYNC_DISABLE_AUDIO = "DisableClusterFunctionSyncAudio";
    private volatile InfoStates_Status infoStatesPending;

    public FunctionSynchronizationHandlerAudio(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
        this.functionSyncDisabled = Boolean.getBoolean(SYSTEM_PROPERTY_FUNCTION_SYNC_DISABLE_AUDIO);
    }

    public void setInfoStatesPending(InfoStates_Status infoStates_Status) {
        this.logChannel.log(10000000, "[FunctionSynchronizationHandlerAudio#setInfoStatesPending] pending=%1", (Object)infoStates_Status);
        this.infoStatesPending = infoStates_Status;
    }

    public InfoStates_Status getInfoStatesPending() {
        return this.infoStatesPending;
    }

    public boolean isSourceChangeInProgress() {
        return FunctionSynchronizationHandlerAudio.isSourceChangeSyncType(this.getCurrentSyncType()) || FunctionSynchronizationHandlerAudio.isSourceChangeSyncType(this.getPendingSyncType());
    }

    private static boolean isSourceChangeSyncType(int n) {
        return n == 0 || n == 1 || n == 2 || n == 3 || n == 4 || n == 7 || n == 8;
    }

    protected AbstractFunctionSynchronization createFunctionSync(int n) {
        this.logChannel.log(10000000, "[FunctionSynchronizationHandlerAudio#createFunctionSync] create new functionSync of type %1", (long)n);
        return new FunctionSynchronizationAudio(this.moduleFsg, this, n);
    }

    public boolean isSyncTypeTrackOrStationChange() {
        int n = this.getCurrentSyncType();
        return n == 6 || n == 5;
    }
}

