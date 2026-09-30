/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LiGetLastStreetHistoryEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetSequenceNAR
extends AddressInputStreetSequence {
    public AddressInputStreetSequenceNAR(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                if (AddressInputStreetSequenceNAR.this.spellerStack.getActiveSC().getContextID() == 65) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(32782, true, true, true));
                } else if (AddressInputStreetSequenceNAR.this.spellerStack.getActiveSC().getContextID() == 64) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(3, false, false, true));
                }
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                CommandList commandList = AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList();
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    AddressInputStreetSequenceNAR.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputStreetSequenceNAR.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputStreetSequenceNAR.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputStreetSequenceNAR.this.inputManager));
                    commandList.add(AddressInputStreetSequenceNAR.this.inputManager.handleAddressInputEvent(AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList(), 30303));
                } else {
                    AddressInputStreetSequenceNAR.this.modelAccess.onAmbiguousElementSelected();
                    commandList.add(AddressInputStreetSequenceNAR.this.inputManager.handleAddressInputEvent(AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList(), 30304));
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LIStreetHistoryEntry lIStreetHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIStreetHistoryEntry);
        commandList.add(new LiGetLastStreetHistoryEntryCommand(lIStreetHistoryEntry));
        commandList.add(new NavCommand(){

            public void execute() {
                final Object object = this.getCommandList().get("STREET_HISTORY_ENTRY_LOCATION");
                if (object == null || !(object instanceof NavLocation)) {
                    this.getCommandList().commandAborted("unexpected Object");
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new NavCommand("LispSelectItemFromLocationCommand"){

                        public void execute() {
                            this.getDSINavigation().lispSelectItemFromLocation((NavLocation)object);
                        }

                        public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
                            this.logger.log(10000000, "LispSelectItemFromLocationCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2, usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
                            if (l != 0L) {
                                this.getCommandList().commandAborted(l);
                                return;
                            }
                            this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
                            this.getCommandList().commandFinished();
                        }
                    });
                }
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    AddressInputStreetSequenceNAR.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputStreetSequenceNAR.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputStreetSequenceNAR.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputStreetSequenceNAR.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    AddressInputStreetSequenceNAR.this.modelAccess.onAmbiguousElementSelected();
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputStreetSequenceNAR.this.inputManager.handleAddressInputEvent(AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList(), 30303));
                } else {
                    CommandList commandList = AddressInputStreetSequenceNAR.this.inputManager.handleAddressInputEvent(AddressInputStreetSequenceNAR.this.commandListFactory.createCommandList(), 30304);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        return commandList;
    }
}

