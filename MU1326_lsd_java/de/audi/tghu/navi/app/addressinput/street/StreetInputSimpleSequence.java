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
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.street.IStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class StreetInputSimpleSequence
extends AbstractMatchspellerInputSequence
implements IStreetInputSequence,
IMatchspellerInputSequenceExt {
    private final IMatchspellerModelAccess refinementModelAccess;
    private final boolean refine;
    protected final IAddressInputForm addressInputForm;

    public StreetInputSimpleSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, boolean bl, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iPreviewMap);
        this.refinementModelAccess = iMatchspellerModelAccess2;
        this.refine = bl;
        this.addressInputForm = iAddressInputForm;
    }

    public StreetInputSimpleSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        this(iMatchspellerModelAccess, iMatchspellerModelAccess2, spellerStack, iCommandListFactory, true, iPreviewMap, iAddressInputForm);
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(3, false, false, true));
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        if (this.childSequence != null) {
            this.childSequence.selectListElement(lIValueListElement, bl);
            return;
        }
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("StreetInputSimpleSequence#selectListElement");
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    StreetInputSimpleSequence.this.modelAccess.onElementSelected(navLocation);
                    CommandList commandList = StreetInputSimpleSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(StreetInputSimpleSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(StreetInputSimpleSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(StreetInputSimpleSequence.this.addressInputForm));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    StreetInputSimpleSequence.this.modelAccess.onAmbiguousElementSelected();
                    this.logger.log(10000000, "StreetInputSimpleSequence#getSelectListElementCommandList - refine: %1", StreetInputSimpleSequence.this.refine);
                    if (StreetInputSimpleSequence.this.refine) {
                        StreetInputSimpleSequence.this.childSequence = new StreetRefinementByCityInputSequence(StreetInputSimpleSequence.this.refinementModelAccess, StreetInputSimpleSequence.this.spellerStack, StreetInputSimpleSequence.this.commandListFactory, StreetInputSimpleSequence.this.previewMap, StreetInputSimpleSequence.this.addressInputForm);
                        this.getCommandList().commandFinishedWithPostSequence(((StreetRefinementByCityInputSequence)StreetInputSimpleSequence.this.childSequence).createStartCommandList(false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            }
        });
        return commandList;
    }

    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("StreetInputSimpleSequence#selectElementByIdentifier");
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

