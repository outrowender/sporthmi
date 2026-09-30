/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParkingNearDestinationScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiParkingNearDestinationScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private static final int MINIMUM_RESULTS_TO_GO_ON = 1;
    private final IPoiParkingNearDestinationScreenModelAccess modelAccess;
    private final SubstringSearchHandler substringSearchHandler;

    public PoiParkingNearDestinationScreenInputSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiParkingNearDestinationScreenModelAccess iPoiParkingNearDestinationScreenModelAccess, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(16), iPoiManager);
        this.modelAccess = iPoiParkingNearDestinationScreenModelAccess;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiParkingNearDestinationScreenModelAccess);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#Set SearchContext to SelectedLocation from ResponseContainer").toString()){

            public void execute() {
                CommandList commandList = PoiParkingNearDestinationScreenInputSequence.this.commandListFactory.createCommandList();
                NavLocation navLocation = new NavLocation();
                final NavLocation navLocation2 = this.dsiResponseContainer.getSelectedLocation();
                navLocation.longitude = navLocation2.longitude;
                navLocation.latitude = navLocation2.latitude;
                commandList.add(new PoiSetContextCommand(navLocation));
                commandList.add(new NavCommand(){

                    public void execute() {
                        if ((this).PoiParkingNearDestinationScreenInputSequence.this.poiSearchArea.getSearchContext() == 1) {
                            PoiParkingNearDestinationScreenInputSequence.this.modelAccess.updateNavLocationForAirDistance(null);
                        } else {
                            PoiParkingNearDestinationScreenInputSequence.this.modelAccess.updateNavLocationForAirDistance(navLocation2);
                        }
                        this.getCommandList().commandFinished();
                    }
                });
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        commandList.add(new NavCommand("Decide which speller must be started"){

            public void execute() {
                if (PoiParkingNearDestinationScreenInputSequence.this.poiSearchArea.getSearchContext() == 1) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(32777, false));
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(32777, false, false, false));
                }
            }
        });
        commandList.add(new LispSelectByCategoryUidCommand(102));
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "%1#createStartSequence#execute()", (Object)this.CLASS_NAME);
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "%1#createStartSequence#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
                }
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
                }
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                    return;
                }
                CommandList commandList = PoiParkingNearDestinationScreenInputSequence.this.commandListFactory.createCommandList();
                commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiParkingNearDestinationScreenInputSequence.this.substringSearchHandler));
                commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiParkingNearDestinationScreenInputSequence.this.modelAccess, PoiParkingNearDestinationScreenInputSequence.this.commandListFactory, 1, PoiParkingNearDestinationScreenInputSequence.this.poiManager));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public void requestItems(int n, int n2, int n3) {
        this.requestItems(n, n2, n3, null);
    }

    public void requestItems(int n, int n2, int n3, NavCommand navCommand) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LIValueListWindowSizeCommand(n3));
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.add(new LIValueListWindowSizeCommand(-1));
        if (n == 0 && navCommand != null) {
            commandList.add(navCommand);
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    private int getSortOrder() {
        return 2;
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
    }

    public void setInput(String string) {
        this.env.getLogChannel().log(10000000, "%1#setInput( %2 )", (Object)this.CLASS_NAME, (Object)string);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Input was entered");
        }
        LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        this.env.getContainer().setLispValueListCount(0L);
        this.env.getContainer().setLispValueList(lIValueList);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateResultScreenWithSpellerListCommand(this.modelAccess));
        }
        commandList.add(new SetInputCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setInput").toString());
    }
}

