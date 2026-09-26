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
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence$1;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
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

    @Override
    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(5, false, false, false));
        return commandList;
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("HousenumberInputSequence#selectListElement");
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new HousenumberMatchspellerInputSimpleSequence$1(this, lIValueListElement));
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

    @Override
    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("HousenumberMatchspellerInputSimpleSequence#selectElementByIdentifier");
    }

    @Override
    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, false, 1, null, null));
        return commandList;
    }

    static /* synthetic */ IMatchspellerModelAccess access$000(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ CommandList access$100(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence, int n, boolean bl) {
        return housenumberMatchspellerInputSimpleSequence.createStartSequence(n, bl);
    }

    static /* synthetic */ IMatchspellerModelAccess access$200(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ ICommandListFactory access$300(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.commandListFactory;
    }

    static /* synthetic */ IMatchspellerModelAccess access$400(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.modelAccess;
    }

    static /* synthetic */ IPreviewMap access$500(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.previewMap;
    }

    static /* synthetic */ IMatchspellerModelAccess access$600(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence) {
        return housenumberMatchspellerInputSimpleSequence.modelAccess;
    }
}

