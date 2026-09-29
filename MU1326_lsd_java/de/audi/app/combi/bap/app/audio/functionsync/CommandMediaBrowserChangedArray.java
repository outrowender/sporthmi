/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;

final class CommandMediaBrowserChangedArray
extends AbstractFunctionSynchronizationCommand
implements IAcknowledgeListener {
    private final BAPFunctionArrayFSG mediaBrowserArray;

    public CommandMediaBrowserChangedArray(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandMediaBrowserChangedArray");
        this.mediaBrowserArray = abstractBAPModuleFSG.getBAPFunctionArrayFSG(36);
    }

    @Override
    public void execute() {
        ArrayHandler arrayHandler = this.mediaBrowserArray.getArrayHandler();
        if (arrayHandler != null) {
            this.mediaBrowserArray.addAcknowledgeListener(this);
            if (!arrayHandler.sendFullRangeUpdate()) {
                this.mediaBrowserArray.removeAcknowledgeListener(this);
                this.commandList.commandFinished();
            }
        } else {
            this.commandList.commandFinished();
        }
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n2 == 4) {
            this.mediaBrowserArray.removeAcknowledgeListener(this);
            this.commandList.commandFinished();
        }
    }
}

