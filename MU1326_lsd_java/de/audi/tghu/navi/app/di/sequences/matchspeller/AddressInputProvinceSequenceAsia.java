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
import de.audi.tghu.navi.app.addressinput.commands.AddressInputRequestValueListByIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStateHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.LiLastStateHistoryAddCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputProvinceSequenceAsia
extends AddressInputCityZipSequence {
    public AddressInputProvinceSequenceAsia(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(138, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(this.CLASS_NAME + "#getSelectListElementCommandList Strip location and add to history"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    CommandList commandList = AddressInputProvinceSequenceAsia.this.commandListFactory.createCommandList();
                    commandList.add(new LIStripLocationCommand(navLocation, 1));
                    commandList.add(new NavCommand(){

                        public void execute() {
                            NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                            CommandList commandList = (this).AddressInputProvinceSequenceAsia.this.commandListFactory.createCommandList();
                            commandList.add(new LISetCountryForCityAndStreetHistoryCommand(LocationFormatter.formatState(navLocation)));
                            commandList.add(new LiLastStateHistoryAddCommand(navLocation, false, LocationFormatter.formatState(navLocation)));
                            this.getCommandList().commandFinishedWithPostSequence(commandList);
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
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getNationWideElementSelectedCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        commandList.add(new LIStripLocationCommand(navLocation, 15));
        commandList.add(new NavCommand("Set stripped location as currentLd"){

            public void execute() {
                NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(navLocation));
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LIStateHistoryEntry lIStateHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIStateHistoryEntry);
        commandList.add(new GetLastStateHistoryEntryCommand(lIStateHistoryEntry));
        commandList.add(new NavCommand(this.CLASS_NAME + "#getSelectHistoryElementCommandList - get history location from command list context"){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object instanceof NavLocation) {
                    NavLocation navLocation = (NavLocation)object;
                    CommandList commandList = AddressInputProvinceSequenceAsia.this.commandListFactory.createCommandList();
                    commandList.add(new LISetCountryForCityAndStreetHistoryCommand(LocationFormatter.formatState(navLocation)));
                    commandList.add(new LiLastStateHistoryAddCommand(navLocation, false, LocationFormatter.formatState(navLocation)));
                    commandList.add(new LISetCurrentLDCommand(navLocation));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandAborted("unexpected Object");
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public void showHistoryLocationInPreviewMap(final IPreviewMap iPreviewMap, LIStateHistoryEntry lIStateHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastStateHistoryEntryCommand(lIStateHistoryEntry));
        commandList.add(new NavCommand(this.CLASS_NAME + "#showHistoryLocationInPreviewMap - SetNavLocationForPreviewMap"){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object instanceof NavLocation) {
                    NavLocation navLocation = (NavLocation)object;
                    iPreviewMap.setPreviewLocationCity(navLocation, 1, null, null);
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("unexpected Object");
                }
            }
        });
        commandList.execute(this.CLASS_NAME + "#showHistoryLocationInPreviewMap");
    }

    public void requestNextResultListWindow(int n, int n2) {
        this.logChannel.log(10000000, "%1#requestNextResultListWindow(), anchorIndex = %2, requestID = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (Util.isPorsche(this.env.getFramework()) || Util.isPorscheGen2(this.env.getFramework()) || Util.isBentley(this.env.getFramework())) {
            commandList.add(new AddressInputRequestValueListByIndexCommand(n, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        } else {
            int n3 = 0;
            String string = this.env.getContainer().getLispCurrentInput();
            if (this.cityHistory != null && this.cityHistory.getMatchingLastStates(string) != null) {
                n3 = this.cityHistory.getMatchingLastStates(string).size();
            }
            commandList.add(new LISPRequestValueListByListIndexCommand(n - n3, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        }
        commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
    }
}

