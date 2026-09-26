/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.tghu.smi.ISMPresetHandler;
import de.audi.tghu.smi.IStateMachinePresetAccess;
import de.audi.tghu.smi.Logger;

public class SMPresetHandler
implements ISMPresetHandler,
IAppPresetDefinitionHandler {
    private final LogChannel logChan;

    public SMPresetHandler(Logger logger, IFrameworkAccess iFrameworkAccess) {
        this.logChan = logger.presets;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int[] getModelIds() {
        return new int[0];
    }

    @Override
    public synchronized void requestDefinition(DefinitionRequest definitionRequest) {
        this.logChan.log(1078071040, "[SMPresetHandler#requestDefinition] request='%1'", (Object)definitionRequest);
    }

    public synchronized void requestExecute(ExecuteRequest executeRequest) {
        this.logChan.log(1078071040, "[SMPresetHandler#requestExecute] request='%1'", (Object)executeRequest);
    }

    @Override
    public synchronized void setStateMachine(IStateMachinePresetAccess iStateMachinePresetAccess) {
    }
}

