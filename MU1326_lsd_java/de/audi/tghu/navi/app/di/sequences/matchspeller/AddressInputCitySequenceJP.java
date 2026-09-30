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
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LiLastCityOrStreetHistoryAddCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCitySequenceJP
extends AddressInputCityZipSequenceAsia {
    public AddressInputCitySequenceJP(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand("Check whether center is selected"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (AddressInputCitySequenceJP.this.isCenterSelected(navLocation)) {
                    AddressInputCityZipSequenceAsia.setIsCityCenterSelected(true);
                } else {
                    AddressInputCityZipSequenceAsia.setIsCityCenterSelected(false);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Update value of choice model"){

            public void execute() {
                AddressInputCitySequenceJP.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip city and add to history").toString()){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    CommandList commandList = AddressInputCitySequenceJP.this.commandListFactory.createCommandList();
                    commandList.add(new LIStripLocationCommand(navLocation, AddressInputCitySequenceJP.this.getStripLocationType()));
                    commandList.add(new NavCommand(){

                        public void execute() {
                            NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                            this.getCommandList().commandFinishedWithPostCommand(new LiLastCityOrStreetHistoryAddCommand(navLocation, false, LocationFormatter.formatCityTitleWithoutCityCenter(navLocation)));
                        }
                    });
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    protected int getStripLocationType() {
        return 25;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lICityHistoryEntry);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectHistoryElementCommandList - get history location from command list context").toString()){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
                } else {
                    this.getCommandList().commandAborted("unexpected Object");
                }
            }
        });
        commandList.add(new NavCommand("Update value of city_needs_ward choice model"){

            public void execute() {
                AddressInputCitySequenceJP.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    private boolean isCenterSelected(NavLocation navLocation) {
        if (!navLocation.isPositionValid()) {
            return false;
        }
        String string = Util.getLocationAccessor(navLocation).getTown();
        return Util.isEmpty(string);
    }
}

