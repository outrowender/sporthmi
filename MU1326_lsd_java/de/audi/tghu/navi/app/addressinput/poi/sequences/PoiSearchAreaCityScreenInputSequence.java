/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelInputChangedCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.commands.SpellerStateChangedCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiWorkFlowManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiSearchAreaCityScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaHandler;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiSearchAreaCityScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiSearchAreaCityScreenModelAccess modelAccess;
    private final int inputCriteria;
    private final CityHistory cityHistory;
    private final IVehicle vehicle;
    private IPoiSearchAreaHandler poiSearchAreaHandler;

    public PoiSearchAreaCityScreenInputSequence(IPoiSearchAreaCityScreenModelAccess iPoiSearchAreaCityScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, int n, CityHistory cityHistory, IVehicle iVehicle, IPoiManager iPoiManager, IPoiSearchAreaHandler iPoiSearchAreaHandler) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(17), iPoiManager);
        this.modelAccess = iPoiSearchAreaCityScreenModelAccess;
        this.inputCriteria = n;
        this.cityHistory = cityHistory;
        this.vehicle = iVehicle;
        this.poiSearchAreaHandler = iPoiSearchAreaHandler;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LISetCurrentLDCommand(this.vehicle.getVehicleCountryLocation()));
        commandList.add(new NavCommand(){

            public void execute() {
                if (PoiSearchAreaCityScreenInputSequence.this.inputCriteria == 4 && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, 6, true, true, true));
                } else if ((PoiSearchAreaCityScreenInputSequence.this.inputCriteria == -1 || PoiSearchAreaCityScreenInputSequence.this.inputCriteria == 3) && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, true));
                } else if ((PoiSearchAreaCityScreenInputSequence.this.inputCriteria == -1 || PoiSearchAreaCityScreenInputSequence.this.inputCriteria == 1) && this.dsiResponseContainer.selectionCriterionAvailable(2)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
                } else if ((PoiSearchAreaCityScreenInputSequence.this.inputCriteria == -1 || PoiSearchAreaCityScreenInputSequence.this.inputCriteria == 2) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
                } else {
                    this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
                }
            }
        });
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getAutoselectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        LIValueListElement lIValueListElement2 = new LIValueListElement();
        lIValueListElement2.listIndex = 0;
        commandList = this.getSelectCommandList(lIValueListElement2);
        commandList.put("CurrentSelection", lIValueListElement2);
        commandList.put("Is the currentSelection a History Entry", IPoiWorkFlowManager.IS_HISTORY_ENTRY_NO);
        return commandList;
    }

    public CommandList getSelectCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                PoiSearchAreaCityScreenInputSequence.this.poiSearchAreaHandler.updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
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
        commandList.add(new NavCommand(){

            public void execute() {
                PoiSearchAreaCityScreenInputSequence.this.poiSearchAreaHandler.updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void requestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public void spellerStateChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SpellerStateChangedCommand(n, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#spellerStateChanged").toString());
    }

    public void addCharacter(String string, final int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (bl) {
            IAdditionalStateInfo iAdditionalStateInfo = new IAdditionalStateInfo(){

                public void gatherInfo() {
                }

                public void restoreBefore() {
                }

                public void restoreAfter() {
                    DSIResponseContainer dSIResponseContainer = PoiSearchAreaCityScreenInputSequence.this.env.getContainer();
                    String string = dSIResponseContainer.getLispValidCharacters();
                    String string2 = dSIResponseContainer.getLispCurrentInput();
                    boolean bl = dSIResponseContainer.isLispIsFullMatch();
                    boolean bl2 = dSIResponseContainer.isLispIsUndoAvailable();
                    LIValueList lIValueList = dSIResponseContainer.getLispValueList();
                    long l = dSIResponseContainer.getLispValueListCount();
                    PoiSearchAreaCityScreenInputSequence.this.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, -1, 0);
                    PoiSearchAreaCityScreenInputSequence.this.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
                }
            };
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{iAdditionalStateInfo}, new SpellerContext(52)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        if (bl) {
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter - if single result select it immediately").toString()){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
                        LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
                        CommandList commandList = PoiSearchAreaCityScreenInputSequence.this.getAutoselectListElementCommandList(lIValueListElement);
                        PoiSearchAreaCityScreenInputSequence.this.poiManager.handlePoiSelectionEvent(commandList, 1303);
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                        this.env.fireModelEvent(n, 0);
                        return;
                    }
                    PoiSearchAreaCityScreenInputSequence.this.spellerStack.pop();
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }
}

