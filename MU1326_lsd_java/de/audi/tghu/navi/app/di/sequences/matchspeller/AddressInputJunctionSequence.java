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
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputJunctionSequence
extends AbstractAddressInputMatchSpellerSequence {
    public AddressInputJunctionSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(4, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(final LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                if (lIValueListElement.isToRefine()) {
                    AddressInputJunctionSequence.this.modelAccess.onAmbiguousElementSelected();
                } else {
                    AddressInputJunctionSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = AddressInputJunctionSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputJunctionSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputJunctionSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputJunctionSequence.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                if (lIValueListElement.isToRefine()) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputJunctionSequence.this.createStartSequence(127, false));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        return commandList;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        return commandList;
    }

    private CommandList createStartSequence(int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(n, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }
}

