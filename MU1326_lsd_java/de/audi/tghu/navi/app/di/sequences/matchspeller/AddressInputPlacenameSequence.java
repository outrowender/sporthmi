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

public class AddressInputPlacenameSequence
extends AbstractAddressInputMatchSpellerSequence {
    private static boolean isPlaceNameCenterSelected = false;

    public AddressInputPlacenameSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(147, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand("Update choice model according to selection critiria"){

            public void execute() {
                AddressInputPlacenameSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Check whether center is selected"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (AddressInputPlacenameSequence.this.isCenterSelected(navLocation) && !this.dsiResponseContainer.selectionCriterionAvailable(5)) {
                    AddressInputPlacenameSequence.setIsPlaceNameCenterSelected(true);
                } else {
                    AddressInputPlacenameSequence.setIsPlaceNameCenterSelected(false);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    AddressInputPlacenameSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = AddressInputPlacenameSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputPlacenameSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputPlacenameSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputPlacenameSequence.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    AddressInputPlacenameSequence.this.logChannel.log(10000000, "Selected item is not a valid position!");
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
        String string = Util.getLocationAccessor(navLocation).getPlaceName();
        return Util.isEmpty(string);
    }

    public static void setIsPlaceNameCenterSelected(boolean bl) {
        isPlaceNameCenterSelected = bl;
    }

    public static boolean isPlaceNameCenterSelected() {
        return isPlaceNameCenterSelected;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return null;
    }
}

