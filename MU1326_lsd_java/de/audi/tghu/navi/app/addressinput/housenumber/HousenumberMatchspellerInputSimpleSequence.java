/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.housenumber;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
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
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class HousenumberMatchspellerInputSimpleSequence
extends AbstractMatchspellerInputSequence
implements IMatchspellerInputSequenceExt {
    protected final IAddressInputForm addressInputForm;

    public HousenumberMatchspellerInputSimpleSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iPreviewMap);
        this.addressInputForm = iAddressInputForm;
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(5, false, false, false));
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("HousenumberInputSequence#selectListElement");
    }

    public CommandList getSelectListElementCommandList(final LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                if (lIValueListElement.isToRefine()) {
                    HousenumberMatchspellerInputSimpleSequence.this.modelAccess.onAmbiguousElementSelected();
                    this.getCommandList().commandFinishedWithPostSequence(HousenumberMatchspellerInputSimpleSequence.this.createStartSequence(127, false));
                } else {
                    HousenumberMatchspellerInputSimpleSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = HousenumberMatchspellerInputSimpleSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(HousenumberMatchspellerInputSimpleSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(HousenumberMatchspellerInputSimpleSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(HousenumberMatchspellerInputSimpleSequence.this.addressInputForm));
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(HousenumberMatchspellerInputSimpleSequence.this.modelAccess));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        return commandList;
    }

    private CommandList createStartSequence(int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(n, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        return commandList;
    }

    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("HousenumberMatchspellerInputSimpleSequence#selectElementByIdentifier");
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, false, 1, null, null));
        return commandList;
    }
}

