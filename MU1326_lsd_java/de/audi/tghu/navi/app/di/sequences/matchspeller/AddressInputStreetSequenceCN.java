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
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetSequenceCN
extends AddressInputStreetSequence {
    private static boolean isStreetCenterSelected = false;

    public AddressInputStreetSequenceCN(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand("Check whether center is selected"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (AddressInputStreetSequenceCN.this.isCenterSelected(navLocation)) {
                    AddressInputStreetSequenceCN.setIsStreetCenterSelected(true);
                } else {
                    AddressInputStreetSequenceCN.setIsStreetCenterSelected(false);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    AddressInputStreetSequenceCN.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = AddressInputStreetSequenceCN.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputStreetSequenceCN.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputStreetSequenceCN.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputStreetSequenceCN.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    AddressInputStreetSequenceCN.this.modelAccess.onAmbiguousElementSelected();
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
        String string = Util.getLocationAccessor(navLocation).getStreet();
        return Util.isEmpty(string);
    }

    public static void setIsStreetCenterSelected(boolean bl) {
        isStreetCenterSelected = bl;
    }

    public static boolean isStreetCenterSelected() {
        return isStreetCenterSelected;
    }
}

