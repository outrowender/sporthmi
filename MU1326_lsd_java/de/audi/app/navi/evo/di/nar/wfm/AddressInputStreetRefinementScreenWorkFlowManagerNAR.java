/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;

public class AddressInputStreetRefinementScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    private final CityHistory cityHistory;

    public AddressInputStreetRefinementScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityHistory = cityHistory;
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30702: {
                if (this.spellerStack.containsContextID(74)) {
                    this.createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow(commandList);
                    break;
                }
                if (this.spellerStack.containsContextID(65)) {
                    this.createDiNarStreetRefinementScreenListElementSelectedStreetFirstWorkFlow(commandList);
                    break;
                }
                this.createDiNarStreetRefinementScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of StreetRefinementScreen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow - AddStreetAndCityToHistoryCommand with NavLocation from ResponseContainer").toString()){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().positionValid) {
                    boolean bl = AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.spellerStack.containsContextID(65);
                    this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.cityHistory, AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.commandListFactory, bl));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new NavCommand("Check For PositionValid or start AdditionCriteriaSpeller for Housenumber"){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().positionValid) {
                    this.env.getChoiceModel(401799).setValue(0);
                    this.getCommandList().commandFinished();
                    return;
                }
                if (this.dsiResponseContainer.refinementCriterionAvailable(125)) {
                    this.env.getChoiceModel(401799).setValue(2);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.inputManager.getHousenumberScreenListener().getSetHousenumberByAdditionalCriteria());
                } else {
                    this.getCommandList().commandAborted("SELCRITDES_REFINEBYADDITONALCRITERIA is not available");
                }
            }
        });
    }

    private void createDiNarStreetRefinementScreenListElementSelectedStreetFirstWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
        commandList.add(new NavCommand("AddStreetAndCityToHistoryCommand with NavLocation from ResponseContainer"){

            public void execute() {
                this.env.getChoiceModel(401799).setValue(0);
                this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.cityHistory, AddressInputStreetRefinementScreenWorkFlowManagerNAR.this.commandListFactory, true));
            }
        });
    }

    private void createDiNarStreetRefinementScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
    }
}

