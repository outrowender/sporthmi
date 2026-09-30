/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipSequenceNAR
extends AddressInputCityZipSequence {
    public AddressInputCityZipSequenceNAR(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NavCommand(this.CLASS_NAME + "#SetCurrentLDFromResponseContainer"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getLiCurrentLD()));
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(2)) {
                    boolean bl;
                    boolean bl2 = bl = !AddressInputCityZipSequenceNAR.this.spellerStack.containsContextID(65);
                    if (this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                        AddressInputCityZipSequenceNAR.this.logChannel.log(10000000, "%1#execute() - ZIP CODE and TOWN are available start multicriteria", (Object)this.CLASS_NAME);
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, bl));
                    } else {
                        AddressInputCityZipSequenceNAR.this.logChannel.log(10000000, "%1#execute() - only TOWN ist available. start with SELCRITDES_TOWN only", (Object)this.CLASS_NAME);
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, false, false, bl));
                    }
                } else {
                    this.getCommandList().commandAborted("SELCRITDES_TOWN ist not available as selection criteria");
                }
            }
        });
        if (this.spellerStack.containsContextID(65)) {
            commandList.add(new NavCommand("Set Street For CityHistory"){

                public void execute() {
                    this.getDSINavigation().liSetStreetForCityHistory(this.dsiResponseContainer.getLiCurrentLD().street);
                }

                public void liHistoryResult(int n) {
                    if (n == 0) {
                        this.logger.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#updateLiCityHistory#liHistoryResult() - result OK").toString());
                        this.getCommandList().commandFinished();
                    } else {
                        this.logger.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#updateLiCityHistory#liHistoryResult() - commandAborted").toString());
                        this.getCommandList().commandAborted(n);
                    }
                }
            });
        }
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lICityHistoryEntry);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand(){

            public void execute() {
                final Object object = this.getCommandList().get("NavLocation from History");
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
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(this.CLASS_NAME + "#getSelectListElementCommandList Strip city and add to history"){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                    CommandList commandList = AddressInputCityZipSequenceNAR.this.commandListFactory.createCommandList();
                    commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add stiped location to history").toString()){

                        public void execute() {
                            boolean bl = (this).AddressInputCityZipSequenceNAR.this.spellerStack.containsContextID(65);
                            if (bl) {
                                this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), (this).AddressInputCityZipSequenceNAR.this.cityHistory, (this).AddressInputCityZipSequenceNAR.this.commandListFactory, bl));
                            } else {
                                this.getCommandList().commandFinishedWithPostSequence((this).AddressInputCityZipSequenceNAR.this.cityHistory.addLastCityCommandList(this.dsiResponseContainer.getLiCurrentLD(), bl));
                            }
                        }
                    });
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, !this.spellerStack.containsContextID(65), 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }
}

