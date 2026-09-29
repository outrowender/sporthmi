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
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$5;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence$6;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LICityHistoryEntry;
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

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LISetCurrentLDCommand(this.vehicle.getVehicleCountryLocation()));
        commandList.add(new PoiSearchAreaCityScreenInputSequence$1(this));
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
        commandList.add(new PoiSearchAreaCityScreenInputSequence$2(this));
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new PoiSearchAreaCityScreenInputSequence$3(this));
        commandList.add(new PoiSearchAreaCityScreenInputSequence$4(this));
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

    public void addCharacter(String string, int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (bl) {
            PoiSearchAreaCityScreenInputSequence$5 poiSearchAreaCityScreenInputSequence$5 = new PoiSearchAreaCityScreenInputSequence$5(this);
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{poiSearchAreaCityScreenInputSequence$5}, new SpellerContext(52)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        if (bl) {
            commandList.add(new PoiSearchAreaCityScreenInputSequence$6(this, new StringBuffer().append(this.CLASS_NAME).append("#addCharacter - if single result select it immediately").toString(), n));
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    static /* synthetic */ int access$000(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        return poiSearchAreaCityScreenInputSequence.inputCriteria;
    }

    static /* synthetic */ IPoiSearchAreaHandler access$100(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        return poiSearchAreaCityScreenInputSequence.poiSearchAreaHandler;
    }

    static /* synthetic */ IPoiSearchAreaCityScreenModelAccess access$200(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        return poiSearchAreaCityScreenInputSequence.modelAccess;
    }
}

