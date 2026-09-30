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
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetSimpleSequence
extends AbstractAddressInputMatchSpellerSequence {
    public AddressInputStreetSimpleSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NavCommand("Check whether city has a street"){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(3)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(3, false, false, true));
                } else {
                    this.dsiResponseContainer.setLispUpdateSpellerResult("", 0, false, false, "", 0, 0, false, false, 0);
                    this.dsiResponseContainer.setLiValueList(new LIValueList(), 0L);
                    this.getCommandList().commandFinished();
                }
            }
        });
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                CommandList commandList = AddressInputStreetSimpleSequence.this.commandListFactory.createCommandList();
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    commandList.add(new ModelSelectListElementCommand(AddressInputStreetSimpleSequence.this.modelAccess));
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputStreetSimpleSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputStreetSimpleSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputStreetSimpleSequence.this.inputManager));
                    commandList.add(AddressInputStreetSimpleSequence.this.inputManager.handleAddressInputEvent(AddressInputStreetSimpleSequence.this.commandListFactory.createCommandList(), AddressInputStreetSimpleSequence.this.inputManager.getStreetScreenNonAmbiguousListElementSelectedEventId()));
                } else {
                    AddressInputStreetSimpleSequence.this.modelAccess.onAmbiguousElementSelected();
                    commandList.add(AddressInputStreetSimpleSequence.this.inputManager.handleAddressInputEvent(AddressInputStreetSimpleSequence.this.commandListFactory.createCommandList(), AddressInputStreetSimpleSequence.this.inputManager.getStreetScreenAmbiguousListElementSelecteEventId()));
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        return commandList;
    }
}

