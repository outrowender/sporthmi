/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$1;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$2;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$3;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$4;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$5;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence$6;
import de.audi.tghu.navi.app.addressinput.city.ICityInputSequence;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.SetCityAsLocationForPreviewMapCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class CityZipInputSimpleSequence
extends AbstractMatchspellerInputSequence
implements ICityInputSequence,
IMatchspellerInputSequenceExt {
    protected final CityHistory cityHistory;
    protected final int inputCriteria;
    protected final IAddressInputForm addressInputForm;

    public CityZipInputSimpleSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        this(iMatchspellerModelAccess, spellerStack, iCommandListFactory, cityHistory, -1, iPreviewMap, iAddressInputForm);
    }

    public CityZipInputSimpleSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, int n, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iPreviewMap);
        this.cityHistory = cityHistory;
        this.inputCriteria = n;
        this.addressInputForm = iAddressInputForm;
    }

    @Override
    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new CityZipInputSimpleSequence$1(this, "CityZipInputSimpleSequence#SetCurrentLDFromResponseContainer"));
        commandList.add(new CityZipInputSimpleSequence$2(this, "Choose speller SelectionCriteria for City"));
        return commandList;
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("CityZipInputSimpleSequence#selectListElement");
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new CityZipInputSimpleSequence$3(this, lIValueListElement));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    @Override
    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("CityZipInputSimpleSequence#selectElementByIdentifier");
    }

    @Override
    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new CityZipInputSimpleSequence$4(this));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    @Override
    public void selectHistoryElement(LICityHistoryEntry lICityHistoryEntry, boolean bl) {
        CommandList commandList = this.getSelectHistoryElementCommandList(lICityHistoryEntry, bl);
        commandList.execute("CityZipInputSimpleSequence#selectHistoryElement");
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new CityZipInputSimpleSequence$5(this));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    @Override
    public void showHistoryLocationInPreviewMap(IPreviewMap iPreviewMap, LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new CityZipInputSimpleSequence$6(this, "SetNavLocationForPreviewMap", iPreviewMap));
        commandList.execute("CityZipInputSimpleSequence#showHistoryLocationInPreviewMap");
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
            return;
        }
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new SetCityAsLocationForPreviewMapCommand(iPreviewMap, lIValueListElement));
            commandList.execute("CityZipInputSequence#showLocationInPreviewMap");
        }
    }

    @Override
    public void restore() {
        int n = 1;
        if (this.childSequence != null) {
            this.childSequence.restore();
            this.childSequence = null;
            return;
        }
        SpellerStack$StackElement spellerStack$StackElement = this.spellerStack.pop();
        if (spellerStack$StackElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement.spellerData));
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, n, null, null));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#restore").toString());
        }
    }
}

