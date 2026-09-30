/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.street;

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
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class StreetRefinementByCityInputSequence
extends AbstractMatchspellerInputSequence
implements IMatchspellerInputSequenceExt {
    private final IAddressInputForm addressInputForm;

    public StreetRefinementByCityInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iPreviewMap);
        this.addressInputForm = iAddressInputForm;
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(127, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("StreetRefinementByCityInputSequence#selectListElement");
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                StreetRefinementByCityInputSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                CommandList commandList = StreetRefinementByCityInputSequence.this.commandListFactory.createCommandList();
                commandList.add(new UpdateAddressInputFormScreenModelsCommand(StreetRefinementByCityInputSequence.this.modelAccess));
                commandList.add(new CmdNaviPreviewMapUpdate(StreetRefinementByCityInputSequence.this.previewMap, 1, null, null));
                commandList.add(new SetBackupLocationForAddressInputFormCommand(StreetRefinementByCityInputSequence.this.addressInputForm));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public void selectElementByIdentifier(String string) {
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return this.commandListFactory.createCommandList();
    }
}

