/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.details.PoiStackListRow;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesListRow;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesParentListRow;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRow;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiRightDrawerHmiListener
extends AbstractPoiRightDrawerHmiListener {
    private final PoiManager poiManager;
    private final IDetailsScreen detailsScreen;

    public PoiRightDrawerHmiListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, MapInterface mapInterface, NaviADBHandler naviADBHandler, PoiManager poiManager, ITelService iTelService, IDetailsScreen iDetailsScreen) {
        super(navigationEnv, iCommandListFactory, iNaviFavoriteHandler, mapInterface, naviADBHandler, iTelService);
        this.poiManager = poiManager;
        this.detailsScreen = iDetailsScreen;
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401043));
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401013));
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401005));
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401012));
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401380));
        this.registerAsOptionListenerForAllLists(navigationEnv.getHMIService().getOptionModel(401485));
    }

    protected void registerAsOptionListenerForAllLists(OptionModelApp optionModelApp) {
        optionModelApp.setListener(this, PoiScreensEvo.getPoiParentChildResultScreenListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiResultScreeNoSpellerListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiResultScreenWithSpellerListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiParkingNearDestinationScreenListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiParentChildCategoryScreenBaseListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getDiAsiaTelephoneNumberScreenTiledListModel());
        optionModelApp.setListener(this, PoiScreensEvo.getMapViewStackMenuModel());
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#keyTyped. modelId: %1, targetModelId: %2, targetRow: %3").toString(), (long)n, (long)n2, (long)n3);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(n2);
        EvoListRow evoListRow = baseListModelApp.getRow(n3);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n2);
        if (lIValueListElement == null) {
            this.logChannel.log(100000, "%1#keyTyped: liValueListElement is null", (Object)this.CLASS_NAME);
            return;
        }
        NavLocation navLocation = null;
        if (evoListRow instanceof PoiIconedParentCategoriesParentListRow) {
            navLocation = this.env.getContainer().getLiCurrentLD();
        }
        if (n == 401013) {
            String string;
            if (evoListRow instanceof PoiIconedParentCategoriesParentListRow || evoListRow instanceof PoiIconedParentCategoriesListRow) {
                string = (String)evoListRow.getCell(2);
            } else if (evoListRow instanceof PoiIconedResultsListRow) {
                string = (String)evoListRow.getCell(1);
            } else if (evoListRow instanceof PoiStackListRow) {
                string = (String)evoListRow.getCell(1);
            } else {
                string = "";
                this.logChannel.log(10000, "%1#keyTyped - Unknown type of row for extracting favorite name.", (Object)this.CLASS_NAME);
            }
            this.saveAsFavorite(lIValueListElement, string, navLocation);
        } else if (n == 401005) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#keyTyped --> NAV_ONLINE_INPUT_COMPLETED_CALL_NUMBER_OPTION will be executed with liValueListElement = %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
            }
            PoiUtil.callPoi(lIValueListElement, this.env, this.commandListFactory, this.telService);
        } else if (n == 401380) {
            this.parkingNearDestination(lIValueListElement, navLocation);
        } else if (n == 401012) {
            this.showInMap(lIValueListElement, navLocation);
        } else if (n == 401485) {
            this.addToContact(lIValueListElement, navLocation);
        } else if (n == 401043) {
            this.showDetails(lIValueListElement, navLocation);
        }
        this.env.fireModelEvent(n, n5);
    }

    protected void parkingNearDestination(LIValueListElement lIValueListElement, final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new NavCommand("SetLocation As SelectedLocation"){

                public void execute() {
                    this.dsiResponseContainer.setSelectedLocation(navLocation);
                    this.getCommandList().commandFinished();
                }
            });
        }
        this.poiManager.executePoiSelectionEvent(commandList, 1204);
    }

    protected void showDetails(LIValueListElement lIValueListElement, final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new NavCommand("SetLocation As SelectedLocation"){

                public void execute() {
                    this.dsiResponseContainer.setSelectedLocation(navLocation);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand("get location from response container"){

            public void execute() {
                PoiRightDrawerHmiListener.this.detailsScreen.enterDetailsScreen(this.dsiResponseContainer.getSelectedLocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showDetails").toString());
    }
}

