/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.SetCityAsLocationForPreviewMapCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipSimpleSequence
extends AbstractAddressInputMatchSpellerSequence {
    protected static final int CRITERIA_UNDEFINED = -1;
    public static final int CRITERIA_CITY_ONLY = 1;
    public static final int CRITERIA_ZIP_ONLY = 2;
    public static final int CRITERIA_CITY_ZIP = 3;
    public static final int CRITERIA_CITY_ZIP_LICENSEPLATE = 4;
    protected final CityHistory cityHistory;
    protected int inputCriteria = -1;

    public AddressInputCityZipSimpleSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
        this.cityHistory = cityHistory;
    }

    public AddressInputCityZipSimpleSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory, int n) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
        this.cityHistory = cityHistory;
        this.inputCriteria = n;
    }

    public void setInputCriteria(int n) {
        this.inputCriteria = n;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.env.getFramework().isPGen2()) {
            commandList.add(new NavCommand(){

                public void execute() {
                    this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.env.getContainer().getLiCurrentLD()));
                }
            });
        }
        commandList.add(new NavCommand(){

            public void execute() {
                if (AddressInputCityZipSimpleSequence.this.inputCriteria == 4 && (this.dsiResponseContainer.selectionCriterionAvailable(133) || this.dsiResponseContainer.selectionCriterionAvailable(6))) {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, 6, true, true, true));
                    } else if (this.dsiResponseContainer.selectionCriterionAvailable(133)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, true, true, true));
                    } else if (this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                        this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
                    }
                } else if ((AddressInputCityZipSimpleSequence.this.inputCriteria == -1 || AddressInputCityZipSimpleSequence.this.inputCriteria == 3) && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, true));
                } else if ((AddressInputCityZipSimpleSequence.this.inputCriteria == -1 || AddressInputCityZipSimpleSequence.this.inputCriteria == 1) && this.dsiResponseContainer.selectionCriterionAvailable(2)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
                } else if ((AddressInputCityZipSimpleSequence.this.inputCriteria == -1 || AddressInputCityZipSimpleSequence.this.inputCriteria == 2) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
                } else {
                    this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
                }
            }
        });
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.dsiResponseContainer.getLispCurrentSelectionCriterion() == 2) {
                    this.getCommandList().commandFinishedWithPostCommand(new AddCityToHistoryCommand(AddressInputCityZipSimpleSequence.this.cityHistory));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new SetCityAsLocationForPreviewMapCommand(iPreviewMap, lIValueListElement));
            commandList.execute(this.CLASS_NAME + "#showLocationInPreviewMap");
        }
    }
}

