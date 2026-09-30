/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.app.audio.list.RadioTVPresetListHandler;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;

final class CommandPresetListChangedArray
extends AbstractFunctionSynchronizationCommand
implements IAcknowledgeListener {
    private final BAPFunctionArrayFSG presetListArray;
    private final boolean forceFullRangeUpdate;

    public CommandPresetListChangedArray(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization, boolean bl) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandPresetListChangedArray");
        this.presetListArray = abstractBAPModuleFSG.getBAPFunctionArrayFSG(33);
        this.forceFullRangeUpdate = bl;
    }

    public void processAcknowledge(int n, int n2) {
        if (n2 == 4) {
            this.logger.log(10000000, "[CommandPresetListChangedArray#processAcknowledge] PresetList acknowledged");
            this.presetListArray.removeAcknowledgeListener(this);
            this.commandList.commandFinished();
        }
    }

    public void execute() {
        ArrayHandler arrayHandler = this.presetListArray.getArrayHandler();
        if (arrayHandler != null) {
            this.presetListArray.addAcknowledgeListener(this);
            if (!((RadioTVPresetListHandler)arrayHandler).updateDeferredList(this.forceFullRangeUpdate)) {
                this.presetListArray.removeAcknowledgeListener(this);
                this.commandList.commandFinished();
            }
        } else {
            this.commandList.commandFinished();
        }
    }
}

