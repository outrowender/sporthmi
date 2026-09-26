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
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.street.IStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSimpleSequence$1;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
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

    @Override
    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(3, false, false, true));
        return commandList;
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        if (this.childSequence != null) {
            this.childSequence.selectListElement(lIValueListElement, bl);
            return;
        }
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("StreetInputSimpleSequence#selectListElement");
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new StreetInputSimpleSequence$1(this));
        return commandList;
    }

    @Override
    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("StreetInputSimpleSequence#selectElementByIdentifier");
    }

    @Override
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

    static /* synthetic */ IMatchspellerModelAccess access$000(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ ICommandListFactory access$100(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.commandListFactory;
    }

    static /* synthetic */ IMatchspellerModelAccess access$200(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ IPreviewMap access$300(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.previewMap;
    }

    static /* synthetic */ IMatchspellerModelAccess access$400(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ boolean access$500(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.refine;
    }

    static /* synthetic */ IMatchspellerInputSequence access$602(StreetInputSimpleSequence streetInputSimpleSequence, IMatchspellerInputSequence iMatchspellerInputSequence) {
        streetInputSimpleSequence.childSequence = iMatchspellerInputSequence;
        return streetInputSimpleSequence.childSequence;
    }

    static /* synthetic */ IMatchspellerModelAccess access$700(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.refinementModelAccess;
    }

    static /* synthetic */ SpellerStack access$800(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.spellerStack;
    }

    static /* synthetic */ ICommandListFactory access$900(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.commandListFactory;
    }

    static /* synthetic */ IPreviewMap access$1000(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.previewMap;
    }

    static /* synthetic */ IMatchspellerInputSequence access$1100(StreetInputSimpleSequence streetInputSimpleSequence) {
        return streetInputSimpleSequence.childSequence;
    }
}

