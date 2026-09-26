/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$1;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$2;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$3;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$4;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$5;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$6;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$7;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator$8;
import de.audi.tghu.navi.app.addressinput.disambiguation.LISPGetLocationFromIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.search.Token;

public abstract class AddressDisambiguator {
    protected static final int SELCRITDES_HOUSENUMBER_NOT_AVAILABLE;
    public static String receivedSelcrit;
    protected SearchResultListRow searchResultListRow;
    public int terminal;
    public NavigationEnv env;
    public final LogChannel logger;
    public ICommandListFactory commandListFactory;
    private LISpellerData spellerState;

    protected abstract void getBestPointAndNearestHNr() {
    }

    protected abstract boolean fillRowsIn(LIValueList lIValueList) {
    }

    protected abstract void setListModels(int n) {
    }

    protected abstract void setSpellerInput(String string) {
    }

    public AddressDisambiguator(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, LogChannel logChannel) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.logger = logChannel;
    }

    public static boolean isHNrUnclear(TryMatchLocationResultData[] tryMatchLocationResultDataArray, LogChannel logChannel) {
        if (null == tryMatchLocationResultDataArray || 0 == tryMatchLocationResultDataArray.length) {
            return false;
        }
        int n = tryMatchLocationResultDataArray[0].getMatchLevel();
        return 5 == n || 6 == n;
    }

    protected CommandList getHNrFreeMatchPopupCL(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SetInputCommand(string));
        commandList.add(new AddressDisambiguator$1(this, "freeMatch: get HNrFreeMatch-Popup-Infos: bestPt and nearestHNr"));
        commandList.add(new LISPGetLocationFromIndexCommand(0));
        return commandList;
    }

    protected NavCommand getSelectedNavLocCommand() {
        LogChannel logChannel = this.logger;
        AddressDisambiguator$2 addressDisambiguator$2 = new AddressDisambiguator$2(this, "tracing out selected location navLoc", logChannel);
        return addressDisambiguator$2;
    }

    private CommandList getHNRListCL(boolean bl, boolean bl2) {
        LogChannel logChannel = this.logger;
        CommandList commandList = this.commandListFactory.createCommandList();
        boolean bl3 = bl;
        if (bl2) {
            commandList.add(new LISPDeleteAllCharactersCommand());
        }
        commandList.add(new AddressDisambiguator$3(this, "Take HNr-list out of iValueList", logChannel, bl3));
        return commandList;
    }

    protected CommandList getIncompleteOrInvalidCL() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SetInputCommand(this.getHouseNrUserInput()));
        commandList.add(new AddressDisambiguator$4(this, "incompl/ivalid: Get ValueList"));
        return commandList;
    }

    public String getHouseNrUserInput() {
        Token[] tokenArray = this.searchResultListRow.getSearchResult().getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7);
        return token.getToken();
    }

    public void setDisambiguationChoice(int n) {
        this.env.getChoiceModel(1042286080).setValue(n);
    }

    protected int getDisambiguationChoice() {
        return this.env.getChoiceModel(1042286080).getValue();
    }

    protected void setSpellerState(LISpellerData lISpellerData) {
        this.spellerState = lISpellerData;
    }

    public LISpellerData getSpellerState() {
        return this.spellerState;
    }

    public CommandList prepareCandidatesList(SearchResultListRow searchResultListRow, int n) {
        this.searchResultListRow = searchResultListRow;
        this.terminal = n;
        NavLocation navLocation = null;
        TryMatchLocationResultData[] tryMatchLocationResultDataArray = this.env.getContainer().getTryMatchLocationResultData();
        if (AddressDisambiguator.isHNrUnclear(tryMatchLocationResultDataArray, this.logger) && null == (navLocation = tryMatchLocationResultDataArray[0].getLocation())) {
            this.logger.log(-1601830656, "AddressDisambiguator#prepareCandidatesList result-data navLoc is null");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISetCurrentLDCommand(navLocation));
        commandList.add(new AddressDisambiguator$5(this, "AddressDisambiguator#prepareCandidatesList - Choose SelectionCriterion"));
        commandList.add(new AddressDisambiguator$6(this, "AddressDisambiguator#prepareCandidatesList - Call LIStartSpellerCommand with LiCurrentLD from DSIResponseContainer"));
        commandList.add(new AddressDisambiguator$7(this, "AddressDisambiguator#prepareCandidatesList - Decide follow action for disambiguation"));
        commandList.add(new LiGetStateCommand());
        commandList.add(new AddressDisambiguator$8(this, "AddressDisambiguator#prepareCandidatesList - CacheSpellerStateCommand"));
        return commandList;
    }

    public NavLocation getTryMatchLocationResultData() {
        TryMatchLocationResultData[] tryMatchLocationResultDataArray = this.env.getContainer().getTryMatchLocationResultData();
        if (tryMatchLocationResultDataArray == null || tryMatchLocationResultDataArray.length == 0 || tryMatchLocationResultDataArray[0].getLocation() == null) {
            this.logger.log(10000, "AddressDisambiguator#getTryMatchLocationResultData found no valid TryMatchLocationResultData");
            return null;
        }
        return tryMatchLocationResultDataArray[0].getLocation();
    }

    static /* synthetic */ CommandList access$000(AddressDisambiguator addressDisambiguator, boolean bl, boolean bl2) {
        return addressDisambiguator.getHNRListCL(bl, bl2);
    }

    static {
        receivedSelcrit = "ReceivedSelcriterion";
    }
}

