/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$5
extends NavCommand {
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$5(AddressDisambiguator addressDisambiguator, String string) {
        this.this$0 = addressDisambiguator;
        super(string);
    }

    @Override
    public void execute() {
        if (this.env.getContainer().refinementCriterionAvailable(136)) {
            this.logger.log(1078071040, "AddressDisambiguator#prepareCandidatesList SELCRITDES_HOUSENUMBER_ALTERNATIVES (free text match)");
            this.getCommandList().put(AddressDisambiguator.receivedSelcrit, new Integer(136));
        } else if (this.env.getContainer().refinementCriterionAvailable(5)) {
            this.logger.log(1078071040, "AddressDisambiguator#prepareCandidatesList SELCRITDES_HOUSENUMBER (nvc match)");
            this.getCommandList().put(AddressDisambiguator.receivedSelcrit, new Integer(5));
        } else if (this.env.getContainer().refinementCriterionAvailable(135)) {
            this.logger.log(-1601830656, "AddressDisambiguator#prepareCandidatesList == Not in seq diagr == SELCRITDES_HOUSENUMBER_FREETEXT");
            this.getCommandList().put(AddressDisambiguator.receivedSelcrit, new Integer(-1));
        } else {
            this.logger.log(-1601830656, "AddressDisambiguator#prepareCandidatesList unknown refinementCriterionAvailable");
            this.getCommandList().put(AddressDisambiguator.receivedSelcrit, new Integer(-1));
        }
        if (null == this.getCommandList().get(AddressDisambiguator.receivedSelcrit)) {
            this.logger.log(-1601830656, "AddressDisambiguator#prepareCandidatesList no usable refinementCriterionAvailable received");
        }
        this.getCommandList().commandFinished();
    }
}

