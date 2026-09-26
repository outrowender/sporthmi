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
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence$1;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
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

    @Override
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

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("StreetRefinementByCityInputSequence#selectListElement");
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new StreetRefinementByCityInputSequence$1(this));
        return commandList;
    }

    @Override
    public void selectElementByIdentifier(String string) {
    }

    @Override
    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return this.commandListFactory.createCommandList();
    }

    static /* synthetic */ IMatchspellerModelAccess access$000(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        return streetRefinementByCityInputSequence.modelAccess;
    }

    static /* synthetic */ ICommandListFactory access$100(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        return streetRefinementByCityInputSequence.commandListFactory;
    }

    static /* synthetic */ IMatchspellerModelAccess access$200(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        return streetRefinementByCityInputSequence.modelAccess;
    }

    static /* synthetic */ IPreviewMap access$300(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        return streetRefinementByCityInputSequence.previewMap;
    }

    static /* synthetic */ IAddressInputForm access$400(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        return streetRefinementByCityInputSequence.addressInputForm;
    }
}

