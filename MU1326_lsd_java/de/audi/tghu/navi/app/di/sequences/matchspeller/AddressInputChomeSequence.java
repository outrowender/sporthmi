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
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputChomeSequence
extends AbstractAddressInputMatchSpellerSequence {
    private static boolean isChomeCenterSelected = false;

    public AddressInputChomeSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
        this.logChannel.log(10000000, "%1#AddressInputChomeSequence(), modelAccess: %2 ", (Object)this.CLASS_NAME, (Object)iMatchspellerModelAccess);
    }

    public CommandList getStartCommandList() {
        this.logChannel.log(10000000, "%1#getStartCommandList(), modelAccess: %2 ", (Object)this.CLASS_NAME, (Object)this.modelAccess);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(144, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand("Check whether center is selected"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (AddressInputChomeSequence.this.isCenterSelected(navLocation)) {
                    AddressInputChomeSequence.setIsChomeCenterSelected(true);
                } else {
                    AddressInputChomeSequence.setIsChomeCenterSelected(false);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Update value of housenumber_available choice model"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid() && !AddressInputChomeSequence.this.isHouseNumberNeeded(this.dsiResponseContainer)) {
                    AddressInputChomeSequence.this.modelAccess.onElementSelected(navLocation);
                } else {
                    AddressInputChomeSequence.this.modelAccess.onAmbiguousElementSelected();
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    private boolean isHouseNumberNeeded(DSIResponseContainer dSIResponseContainer) {
        return dSIResponseContainer.selectionCriterionAvailable(5) && dSIResponseContainer.refinementCriterionAvailable(5);
    }

    private boolean isCenterSelected(NavLocation navLocation) {
        if (!navLocation.isPositionValid()) {
            return false;
        }
        String string = Util.getLocationAccessor(navLocation).getChome();
        return Util.isEmpty(string);
    }

    public static void setIsChomeCenterSelected(boolean bl) {
        isChomeCenterSelected = bl;
    }

    public static boolean isChomeCenterSelected() {
        return isChomeCenterSelected;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return null;
    }
}

