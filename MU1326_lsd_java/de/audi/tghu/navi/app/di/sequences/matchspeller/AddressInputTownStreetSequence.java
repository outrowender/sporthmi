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
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputTownStreetSequence
extends AbstractAddressInputMatchSpellerSequence {
    private static boolean isTownStreetCenterSelected = false;

    public AddressInputTownStreetSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(150, false, false, false));
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
        commandList.add(new NavCommand("Check whether center is selected"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (AddressInputTownStreetSequence.this.isCenterSelected(navLocation)) {
                    AddressInputTownStreetSequence.setIsTownStreetCenterSelected(true);
                } else {
                    AddressInputTownStreetSequence.setIsTownStreetCenterSelected(false);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Update value of town_needs_village_or_street choice model"){

            public void execute() {
                if (!this.dsiResponseContainer.selectionCriterionAvailable(151) || !this.dsiResponseContainer.refinementCriterionAvailable(151)) {
                    AddressInputTownStreetSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                } else {
                    AddressInputTownStreetSequence.this.modelAccess.onAmbiguousElementSelected();
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    CommandList commandList = AddressInputTownStreetSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputTownStreetSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputTownStreetSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputTownStreetSequence.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.logger.log(10000000, "Selected item is not a valid position!");
                }
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private boolean isCenterSelected(NavLocation navLocation) {
        if (!navLocation.isPositionValid()) {
            return false;
        }
        String string = Util.getLocationAccessor(navLocation).getSubmunicipalTown();
        String string2 = Util.getLocationAccessor(navLocation).getStreet();
        return Util.isEmpty(string) && Util.isEmpty(string2);
    }

    public static void setIsTownStreetCenterSelected(boolean bl) {
        isTownStreetCenterSelected = bl;
    }

    public static boolean isTownStreetCenterSelected() {
        return isTownStreetCenterSelected;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return null;
    }
}

