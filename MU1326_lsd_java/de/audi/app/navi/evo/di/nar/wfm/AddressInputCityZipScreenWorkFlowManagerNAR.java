/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.additionalstate.SaveHousenumberFirstValueStateInfo;
import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    private final CityHistory cityHistory;

    public AddressInputCityZipScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityHistory = cityHistory;
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30202: {
                this.createNarCityZipScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30203: {
                this.createNarCityZipScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of city zip screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarCityZipScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createNarCityZipScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(61), null));
        CommandList commandList2 = this.getCommandToCheckValidDestinationAndStartFollowSequence();
        if (commandList2 != null) {
            commandList.add(commandList2);
        }
    }

    private void createNarCityZipScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createNarCityZipScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("selectedElement");
        commandList.add(0, new LIGetStateCommand(this.spellerStack, lIValueListElement, -1, null, SpellerContextManager.getSpellerContext(106), null));
        CommandList commandList2 = this.getCommandToCheckValidDestinationAndStartFollowSequence();
        if (commandList2 != null) {
            commandList.add(commandList2);
        }
    }

    private CommandList getCommandToCheckValidDestinationAndStartFollowSequence() {
        if (this.spellerStack.containsContextID(74)) {
            return this.createCitySelectForHousenumberFirstWorkFlow();
        }
        if (this.spellerStack.containsContextID(65)) {
            return this.createCitySelectForStreetFirstWorkFlow();
        }
        return this.createCitySelectWorkFlow();
    }

    private CommandList createCitySelectWorkFlow() {
        this.env.getChoiceModel(401799).setValue(0);
        return null;
    }

    private CommandList createCitySelectForStreetFirstWorkFlow() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createCitySelectForStreetFirstWorkFlow - decide if refinement screen is needed or NavLocation can be added to history").toString()){

            public void execute() {
                if (!this.dsiResponseContainer.getLiCurrentLD().isPositionValid() && this.dsiResponseContainer.selectionCriterionAvailable(127)) {
                    AddressInputCityZipScreenWorkFlowManagerNAR.this.logChannel.log(10000000, "AddressInputCityZipScreenWorkFlowManagerNAR.createCitySelectForStreetFirstWorkFlow().new NavCommand() {...}#execute() - Refinement is nessesary.");
                    this.env.getChoiceModel(401799).setValue(1);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getStreetRefinementScreenListener().getStartCommandList());
                } else {
                    AddressInputCityZipScreenWorkFlowManagerNAR.this.logChannel.log(10000000, "AddressInputCityZipScreenWorkFlowManagerNAR.createCitySelectForStreetFirstWorkFlow().new NavCommand() {...}#execute() - NO REFINEMENT --> Add City to History");
                    this.env.getChoiceModel(401799).setValue(0);
                    boolean bl = AddressInputCityZipScreenWorkFlowManagerNAR.this.spellerStack.containsContextID(65);
                    this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputCityZipScreenWorkFlowManagerNAR.this.cityHistory, AddressInputCityZipScreenWorkFlowManagerNAR.this.commandListFactory, bl));
                }
            }
        });
        return commandList;
    }

    private CommandList createCitySelectForHousenumberFirstWorkFlow() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createCitySelectForHousenumberFirstWorkFlow decide if Housenumber freetext or alternative has to be used").toString()){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(136)) {
                        this.getCommandList().commandFinishedWithPostSequence(this.createAddHousenumberCommandList(this.getHouseNumberInput(), this.dsiResponseContainer.getLiCurrentLD()));
                    } else {
                        AddressInputCityZipScreenWorkFlowManagerNAR.this.logChannel.log(10000000, "%1#execute() - The Address is valid but no housenumber selcritdes available", (Object)this.CLASS_NAME);
                        this.env.getChoiceModel(401799).setValue(3);
                        this.getCommandList().commandFinished();
                    }
                    return;
                }
                if (this.dsiResponseContainer.selectionCriterionAvailable(135)) {
                    this.env.getChoiceModel(401799).setValue(1);
                    this.getCommandList().commandFinishedWithPostSequence(this.createAddHousenumberFreetextAndStartRefinement(this.getHouseNumberInput()));
                } else if (this.dsiResponseContainer.selectionCriterionAvailable(127)) {
                    AddressInputCityZipScreenWorkFlowManagerNAR.this.logChannel.log(10000000, "%1#execute() - Address invalid because no housenumber available (no SELCRITDES_HOUSENUMBER_FREETEXT) -> Refinement is nessesary", (Object)this.CLASS_NAME);
                    this.env.getChoiceModel(401799).setValue(1);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getStreetRefinementScreenListener().getStartCommandList());
                } else {
                    this.getCommandList().commandAborted("SELCRITDES_HOUSENUMBER_FREETEXT is not available and no SELCRITDES_REFINEBYASSOCIATION");
                }
            }

            private String getHouseNumberInput() {
                IAdditionalStateInfo[] iAdditionalStateInfoArray = AddressInputCityZipScreenWorkFlowManagerNAR.this.spellerStack.getAdditionalStateForFirstContextFound(65);
                SaveHousenumberFirstValueStateInfo saveHousenumberFirstValueStateInfo = null;
                for (int i2 = 0; i2 < iAdditionalStateInfoArray.length; ++i2) {
                    if (!(iAdditionalStateInfoArray[i2] instanceof SaveHousenumberFirstValueStateInfo)) continue;
                    saveHousenumberFirstValueStateInfo = (SaveHousenumberFirstValueStateInfo)iAdditionalStateInfoArray[i2];
                    break;
                }
                AddressInputCityZipScreenWorkFlowManagerNAR.this.logChannel.log(10000000, "%1#getCommandToCheckValidDestinationAndStartFollowSequence stateInfo is available. Try to start housenumberinput", (Object)this.CLASS_NAME);
                return saveHousenumberFirstValueStateInfo != null ? saveHousenumberFirstValueStateInfo.getHousenumberFirstValue() : "";
            }

            private CommandList createAddHousenumberFreetextAndStartRefinement(String string) {
                CommandList commandList = AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getHousenumberScreenListener().getSetHousenumberFreetextWithAutoSelect(string);
                commandList.add(new NavCommand(new StringBuffer().append(AddressInputCityZipScreenWorkFlowManagerNAR.this.CLASS_NAME).append("#createAddHousenumberFreetextAndStartRefinement start refinement screen if necessary").toString()){

                    public void execute() {
                        if (!this.dsiResponseContainer.getLiCurrentLD().positionValid) {
                            this.getCommandList().commandFinishedWithPostSequence((this).AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getStreetRefinementScreenListener().getStartCommandList());
                        } else {
                            this.getCommandList().commandFinished();
                        }
                    }
                });
                return commandList;
            }

            private CommandList createAddHousenumberCommandList(String string, NavLocation navLocation) {
                boolean bl = AddressInputCityZipScreenWorkFlowManagerNAR.this.spellerStack.containsContextID(65);
                CommandList commandList = AddressInputCityZipScreenWorkFlowManagerNAR.this.commandListFactory.createCommandList();
                commandList.add(new AddStreetAndCityToHistoryCommand(navLocation, AddressInputCityZipScreenWorkFlowManagerNAR.this.cityHistory, AddressInputCityZipScreenWorkFlowManagerNAR.this.commandListFactory, bl));
                commandList.add(AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getHousenumberScreenListener().getStartCommandList());
                commandList.add(AddressInputCityZipScreenWorkFlowManagerNAR.this.inputManager.getHousenumberScreenListener().getSetHousenumber(string));
                return commandList;
            }
        });
        return commandList;
    }
}

