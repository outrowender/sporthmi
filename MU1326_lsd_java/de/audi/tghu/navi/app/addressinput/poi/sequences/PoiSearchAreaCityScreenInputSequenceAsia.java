/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
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
import de.audi.tghu.navi.app.addressinput.commands.ModelInputChangedCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
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
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$5;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$6;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia$7;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.commands.FilterHandwritingCharactersCommand;
import de.audi.tghu.navi.app.di.commands.LISPAddStrokeCommand;
import de.audi.tghu.navi.app.di.commands.LISPRequestNVCValidCharsCommand;
import de.audi.tghu.navi.app.di.commands.LISetNvcRangeCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerStrokeStatusCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerValidHanziCharsCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiSearchAreaCityScreenInputSequenceAsia
extends AbstractPoiScreenInputSequence
implements IAddressInputAsiaSpecificSequence {
    private final IPoiSearchAreaCityScreenModelAccess modelAccess;
    private final int inputCriteria;
    private final CityHistory cityHistory;
    private final IVehicle vehicle;
    private IPoiSearchAreaHandler poiSearchAreaHandler;

    public PoiSearchAreaCityScreenInputSequenceAsia(IPoiSearchAreaCityScreenModelAccess iPoiSearchAreaCityScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, int n, CityHistory cityHistory, IVehicle iVehicle, IPoiManager iPoiManager, IPoiSearchAreaHandler iPoiSearchAreaHandler) {
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
        commandList.add(new LIStripLocationCommand(this.vehicle.getVehicleCountryLocation(), 15));
        commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$1(this, "Change mapping of LIStripLocationCommand result to LISetCurrentLDCommand"));
        commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$2(this));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getSelectCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$3(this));
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$4(this));
        commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$5(this));
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

    @Override
    public void addStroke(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPAddStrokeCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addStroke").toString());
    }

    @Override
    public void touchPadInputModeChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPDeleteAllCharactersCommand(true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (n == 1) {
            commandList.add(new LISetNvcRangeCommand(2));
        } else if (n == 0) {
            commandList.add(new LISetNvcRangeCommand(1));
        } else {
            this.logChannel.log(10000, "%1#inputModeTPChanged - invalid id for mode=%2", (Object)this.CLASS_NAME, (long)n);
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#inputModeTPChanged").toString());
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string, MatchspellerModelApp matchspellerModelApp) {
        this.logChannel.log(-2137614336, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new FilterHandwritingCharactersCommand(matchspellerModelApp, string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#nonAlphaNumTPCharsChanged").toString());
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestNVCValidCharsCommand(3, n2, n3));
        commandList.add(new SetSpellerValidHanziCharsCommand(this.env.getMatchSpellerModel(n)));
        commandList.add(new SetSpellerStrokeStatusCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestValidHanziCharsWindow").toString());
    }

    @Override
    public void undoStroke() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoStroke").toString());
    }

    public void spellerStateChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SpellerStateChangedCommand(n, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#spellerStateChanged").toString());
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

    public void addCharacter(String string, int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (bl) {
            PoiSearchAreaCityScreenInputSequenceAsia$6 poiSearchAreaCityScreenInputSequenceAsia$6 = new PoiSearchAreaCityScreenInputSequenceAsia$6(this);
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{poiSearchAreaCityScreenInputSequenceAsia$6}, new SpellerContext(52)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        if (bl) {
            commandList.add(new PoiSearchAreaCityScreenInputSequenceAsia$7(this, new StringBuffer().append(this.CLASS_NAME).append("#addCharacter - if single result select it immediately").toString(), n));
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    static /* synthetic */ int access$000(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        return poiSearchAreaCityScreenInputSequenceAsia.inputCriteria;
    }

    static /* synthetic */ IPoiSearchAreaHandler access$100(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        return poiSearchAreaCityScreenInputSequenceAsia.poiSearchAreaHandler;
    }

    static /* synthetic */ IPoiSearchAreaCityScreenModelAccess access$200(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        return poiSearchAreaCityScreenInputSequenceAsia.modelAccess;
    }
}

