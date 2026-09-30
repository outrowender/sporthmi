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
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.disambiguation.LISPGetLocationFromIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.search.Token;

public abstract class AddressDisambiguator {
    protected static final int SELCRITDES_HOUSENUMBER_NOT_AVAILABLE = -1;
    public static String receivedSelcrit = "ReceivedSelcriterion";
    protected SearchResultListRow searchResultListRow;
    public int terminal;
    public NavigationEnv env;
    public final LogChannel logger;
    public ICommandListFactory commandListFactory;
    private LISpellerData spellerState;

    protected abstract void getBestPointAndNearestHNr();

    protected abstract boolean fillRowsIn(LIValueList var1);

    protected abstract void setListModels(int var1);

    protected abstract void setSpellerInput(String var1);

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
        commandList.add(new NavCommand("freeMatch: get HNrFreeMatch-Popup-Infos: bestPt and nearestHNr"){

            public void execute() {
                AddressDisambiguator.this.getBestPointAndNearestHNr();
                AddressDisambiguator.this.setListModels(2);
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPGetLocationFromIndexCommand(0));
        return commandList;
    }

    protected NavCommand getSelectedNavLocCommand() {
        final LogChannel logChannel = this.logger;
        NavCommand navCommand = new NavCommand("tracing out selected location navLoc"){

            public void execute() {
                if (logChannel.isDebug2()) {
                    logChannel.log(100000000, "Selected location navLoc is >>%1<<", (Object)this.env.getContainer().getSelectedLocation());
                }
                this.getCommandList().commandFinished();
            }
        };
        return navCommand;
    }

    private CommandList getHNRListCL(boolean bl, boolean bl2) {
        final LogChannel logChannel = this.logger;
        CommandList commandList = this.commandListFactory.createCommandList();
        final boolean bl3 = bl;
        if (bl2) {
            commandList.add(new LISPDeleteAllCharactersCommand());
        }
        commandList.add(new NavCommand("Take HNr-list out of iValueList"){

            public void execute() {
                LIValueList lIValueList = this.env.getContainer().getLispValueList();
                if (0 == lIValueList.list.length) {
                    logChannel.log(100000, "getHNRListCL no values received");
                    this.getCommandList().commandAborted("getHNRListCL no values received");
                    return;
                }
                if (bl3) {
                    AddressDisambiguator.this.setSpellerInput(AddressDisambiguator.this.getHouseNrUserInput());
                }
                if (!AddressDisambiguator.this.fillRowsIn(lIValueList)) {
                    logChannel.log(100000, "getHNRListCL negative fillRowsIn(env.getContainer().getLispValueList(), fillSpeller)");
                    this.getCommandList().commandAborted("getHNRListCL negative fillRowsIn(env.getContainer().getLispValueList(), fillSpeller)");
                    return;
                }
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    protected CommandList getIncompleteOrInvalidCL() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SetInputCommand(this.getHouseNrUserInput()));
        commandList.add(new NavCommand("incompl/ivalid: Get ValueList"){

            public void execute() {
                this.logger.log(1000000, "Choose if [HNRSeq2ambig] or [HNRSeq3invalid] by inspecting values=>>%1<<", (Object)this.env.getContainer().getLispValueList());
                if (0 == this.env.getContainer().getLispValueList().list.length) {
                    AddressDisambiguator.this.setListModels(4);
                    this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.this.getHNRListCL(false, true));
                } else {
                    AddressDisambiguator.this.setListModels(5);
                    this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.this.getHNRListCL(true, false));
                }
            }
        });
        return commandList;
    }

    public String getHouseNrUserInput() {
        Token[] tokenArray = this.searchResultListRow.getSearchResult().getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7);
        return token.getToken();
    }

    public void setDisambiguationChoice(int n) {
        this.env.getChoiceModel(401470).setValue(n);
    }

    protected int getDisambiguationChoice() {
        return this.env.getChoiceModel(401470).getValue();
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
            this.logger.log(100000, "AddressDisambiguator#prepareCandidatesList result-data navLoc is null");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISetCurrentLDCommand(navLocation));
        commandList.add(new NavCommand("AddressDisambiguator#prepareCandidatesList - Choose SelectionCriterion"){

            public void execute() {
                if (this.env.getContainer().refinementCriterionAvailable(136)) {
                    this.logger.log(1000000, "AddressDisambiguator#prepareCandidatesList SELCRITDES_HOUSENUMBER_ALTERNATIVES (free text match)");
                    this.getCommandList().put(receivedSelcrit, new Integer(136));
                } else if (this.env.getContainer().refinementCriterionAvailable(5)) {
                    this.logger.log(1000000, "AddressDisambiguator#prepareCandidatesList SELCRITDES_HOUSENUMBER (nvc match)");
                    this.getCommandList().put(receivedSelcrit, new Integer(5));
                } else if (this.env.getContainer().refinementCriterionAvailable(135)) {
                    this.logger.log(100000, "AddressDisambiguator#prepareCandidatesList == Not in seq diagr == SELCRITDES_HOUSENUMBER_FREETEXT");
                    this.getCommandList().put(receivedSelcrit, new Integer(-1));
                } else {
                    this.logger.log(100000, "AddressDisambiguator#prepareCandidatesList unknown refinementCriterionAvailable");
                    this.getCommandList().put(receivedSelcrit, new Integer(-1));
                }
                if (null == this.getCommandList().get(receivedSelcrit)) {
                    this.logger.log(100000, "AddressDisambiguator#prepareCandidatesList no usable refinementCriterionAvailable received");
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("AddressDisambiguator#prepareCandidatesList - Call LIStartSpellerCommand with LiCurrentLD from DSIResponseContainer"){

            public void execute() {
                if ((Integer)this.getCommandList().get(receivedSelcrit) == -1) {
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                } else {
                    int n = (Integer)this.getCommandList().get(receivedSelcrit);
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(n, false, false, false));
                }
            }
        });
        commandList.add(new NavCommand("AddressDisambiguator#prepareCandidatesList - Decide follow action for disambiguation"){

            public void execute() {
                int n = (Integer)this.getCommandList().get(receivedSelcrit);
                if (136 == n) {
                    AddressDisambiguator.this.setDisambiguationChoice(2);
                    this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.this.getHNrFreeMatchPopupCL(AddressDisambiguator.this.getHouseNrUserInput()));
                } else if ((Integer)this.getCommandList().get(receivedSelcrit) == -1) {
                    AddressDisambiguator.this.setDisambiguationChoice(0);
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.this.getIncompleteOrInvalidCL());
                }
            }
        });
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand("AddressDisambiguator#prepareCandidatesList - CacheSpellerStateCommand"){

            public void execute() {
                AddressDisambiguator.this.setSpellerState(this.env.getContainer().getSpellerState());
                this.getCommandList().commandFinished();
            }
        });
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
}

