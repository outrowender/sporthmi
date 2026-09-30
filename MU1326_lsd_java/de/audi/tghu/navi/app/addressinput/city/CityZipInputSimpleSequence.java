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
import de.audi.tghu.navi.app.addressinput.city.ICityInputSequence;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.SetCityAsLocationForPreviewMapCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
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

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("CityZipInputSimpleSequence#SetCurrentLDFromResponseContainer"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getLiCurrentLD()));
            }
        });
        commandList.add(new NavCommand("Choose speller SelectionCriteria for City"){

            public void execute() {
                if (Util.isHURegionKR() && this.env.getInputModeManager().isSdsActive()) {
                    this.logger.log(10000000, "%1#createStartCommandList - Region is Korea and SDS is active -> Skip validity checks for selection criteria and start town speller.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
                    return;
                }
                if (CityZipInputSimpleSequence.this.inputCriteria == 4 && (this.dsiResponseContainer.selectionCriterionAvailable(133) || this.dsiResponseContainer.selectionCriterionAvailable(6))) {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, 6, true, true, true));
                    } else if (this.dsiResponseContainer.selectionCriterionAvailable(133)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, true, true, true));
                    } else if (this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
                    }
                } else if ((CityZipInputSimpleSequence.this.inputCriteria == -1 || CityZipInputSimpleSequence.this.inputCriteria == 3) && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, true));
                } else if ((CityZipInputSimpleSequence.this.inputCriteria == -1 || CityZipInputSimpleSequence.this.inputCriteria == 1) && this.dsiResponseContainer.selectionCriterionAvailable(2)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
                } else if ((CityZipInputSimpleSequence.this.inputCriteria == -1 || CityZipInputSimpleSequence.this.inputCriteria == 2) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
                } else {
                    this.logger.log(1000000, "CityZipInputSimpleSequence#availableSelectionCriteria = %1 currentLD = %2", (Object)this.dsiResponseContainer.getLiAvailableSelectionCriteria(), (Object)this.dsiResponseContainer.getLiCurrentLD());
                    this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
                }
            }
        });
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.execute("CityZipInputSimpleSequence#selectListElement");
    }

    public CommandList getSelectListElementCommandList(final LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                if (!lIValueListElement.isToRefine()) {
                    this.getCommandList().commandFinishedWithPostCommand(new AddCityToHistoryCommand(CityZipInputSimpleSequence.this.cityHistory));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    public void selectElementByIdentifier(String string) {
        CommandList commandList = this.getSelectElementByIdentifierCommandList(string);
        commandList.execute("CityZipInputSimpleSequence#selectElementByIdentifier");
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.dsiResponseContainer.getLispCurrentSelectionCriterion() == 2) {
                    this.getCommandList().commandFinishedWithPostCommand(new AddCityToHistoryCommand(CityZipInputSimpleSequence.this.cityHistory));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    public void selectHistoryElement(LICityHistoryEntry lICityHistoryEntry, boolean bl) {
        CommandList commandList = this.getSelectHistoryElementCommandList(lICityHistoryEntry, bl);
        commandList.execute("CityZipInputSimpleSequence#selectHistoryElement");
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand(){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object == null || !(object instanceof NavLocation)) {
                    this.getCommandList().commandAborted("unexpected Object");
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    public void showHistoryLocationInPreviewMap(final IPreviewMap iPreviewMap, LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand("SetNavLocationForPreviewMap"){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object == null || !(object instanceof NavLocation)) {
                    this.getCommandList().commandAborted("unexpected Object");
                } else {
                    NavLocation navLocation = (NavLocation)object;
                    iPreviewMap.setPreviewLocationCity(navLocation, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute("CityZipInputSimpleSequence#showHistoryLocationInPreviewMap");
    }

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

    public void restore() {
        int n = 1;
        if (this.childSequence != null) {
            this.childSequence.restore();
            this.childSequence = null;
            return;
        }
        SpellerStack.StackElement stackElement = this.spellerStack.pop();
        if (stackElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, n, null, null));
            commandList.execute(this.CLASS_NAME + "#restore");
        }
    }
}

