/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;

final class CommandReceptionListChangedArray
extends AbstractFunctionSynchronizationCommand
implements IAcknowledgeListener {
    private final BAPFunctionArrayFSG receptionListArray;
    private final boolean forceFullRangeUpdate;

    public CommandReceptionListChangedArray(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization, boolean bl) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandReceptionListChangedArray");
        this.receptionListArray = abstractBAPModuleFSG.getBAPFunctionArrayFSG(23);
        this.forceFullRangeUpdate = bl;
    }

    @Override
    public void execute() {
        ArrayHandler arrayHandler = this.receptionListArray.getArrayHandler();
        if (arrayHandler != null) {
            this.receptionListArray.addAcknowledgeListener(this);
            if (!((ReceptionListHandler)arrayHandler).updateDeferredList(this.forceFullRangeUpdate)) {
                this.receptionListArray.removeAcknowledgeListener(this);
                this.commandList.commandFinished();
            }
        } else {
            this.commandList.commandFinished();
        }
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n2 == 4) {
            this.logger.log(-2137614336, "[CommandReceptionListChangedArray#processAcknowledge] ReceptionList acknowledged");
            this.receptionListArray.removeAcknowledgeListener(this);
            this.commandList.commandFinished();
        }
    }
}

