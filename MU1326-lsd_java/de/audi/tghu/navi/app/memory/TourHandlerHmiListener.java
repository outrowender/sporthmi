/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.command.TrCreateWaypoint;
import de.audi.tghu.navi.app.command.TrDeleteTrace;
import de.audi.tghu.navi.app.command.TrStartTraceRecording;
import de.audi.tghu.navi.app.command.TrStopTraceRecording;
import de.audi.tghu.navi.app.command.TrStoreTrace;
import de.audi.tghu.navi.app.command.storage.RmRouteAddCommand;
import de.audi.tghu.navi.app.command.storage.RmRouteDeleteCommand;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.memory.RouteListData;
import de.audi.tghu.navi.app.memory.TourHandler;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener$1;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener$SetLoadedTour;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener$StartGuidance;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener$State;
import de.audi.tghu.navi.app.memory.TourPlanEvoListRow;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class TourHandlerHmiListener
implements ButtonListener,
ListListener,
SpellerListener,
BaseListModelListener,
ChoiceListener {
    private static final String TOUR_NAME_DEFAULT;
    private static final int MAX_COLUMNS;
    private static final int COLUMN_ID;
    private static final int COLUMN_SHORTCUT;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_SHOW;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_HIDE;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_DEFAULT;
    protected final NavigationEnv env;
    protected final FunctionCounter fc;
    protected final LogChannel logChannel;
    private int dsiNavRouteOptTrail = 1;
    protected final ICommandListFactory commandListFactory;
    protected final TourHandler tourHandler;
    private IRouteManager routeManager;
    private IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence;
    private NaviFavoriteHandler naviFavoriteHandler;
    protected boolean wantedToDeactivate = false;
    private String favSuggestion;

    public TourHandlerHmiListener(NavigationEnv navigationEnv, FunctionCounter functionCounter, ICommandListFactory iCommandListFactory, TourHandler tourHandler, IRouteManager iRouteManager, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, NaviFavoriteHandler naviFavoriteHandler) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.commandListFactory = iCommandListFactory;
        this.tourHandler = tourHandler;
        this.routeManager = iRouteManager;
        this.iStartGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.naviFavoriteHandler = naviFavoriteHandler;
        this.logChannel = navigationEnv.getLogChannel();
        this.loadState();
        this.setListener();
        this.initTraceDirectionModels();
    }

    private void initTraceDirectionModels() {
        this.env.getChoiceModel(170001920).setValue(1);
        this.env.getChoiceModel(86115840).setValue(0);
    }

    private void setListener() {
        this.env.getListModel(-1474558464).setMaxRows(50);
        this.env.getListModel(-1474558464).setListListener(this);
        this.env.getListModel(-1474558464).setMaxColumns(2);
        this.env.getListModel(-1524890112).setMaxRows(50);
        this.env.getListModel(-1524890112).setListListener(this);
        this.env.getListModel(-1524890112).setMaxColumns(2);
        this.env.getBaseListModel(-249494016).setListener(this);
        this.env.getBaseListModel(1092748800).setListener(this);
        this.env.getButtonModel(-266271232).setButtonListener(this);
        this.env.getButtonModel(-1491335680).setButtonListener(this);
        this.env.getButtonModel(1126303232).setButtonListener(this);
        this.env.getButtonModel(-1457781248).setButtonListener(this);
        this.env.getSpellerModel(-1424226816).setSpellerListener(this);
        this.env.getSpellerModel(-1424226816).setMaxLength(40);
        this.env.getButtonModel(-1508112896).setButtonListener(this);
        this.env.getButtonModel(-215939584).setButtonListener(this);
        this.env.getButtonModel(-31390208).setButtonListener(this);
        this.env.getChoiceModel(-1122236928).setChoiceListener(this);
        this.env.getChoiceModel(119670272).setChoiceListener(this);
        this.env.getButtonModel(153224704).setButtonListener(this);
        this.env.getButtonModel(136447488).setButtonListener(this);
        this.env.getButtonModel(0x220600).setButtonListener(this);
        this.env.getButtonModel(-14612992).setButtonListener(this);
        this.env.getButtonModel(-48167424).setButtonListener(this);
        this.env.getSpellerModel(0x6220600).setSpellerListener(this);
        this.env.getChoiceModel(86115840).setChoiceListener(this);
        this.env.getChoiceModel(170001920).setChoiceListener(this);
        this.env.getButtonModel(-64944640).setButtonListener(this);
        this.env.getButtonModel(69338624).setButtonListener(this);
        this.env.getButtonModel(1679951360).setButtonListener(this);
    }

    private long getTourID(int n, int n2) {
        long l = -1L;
        int n3 = n2;
        ListModelApp listModelApp = this.env.getListModel(n);
        int n4 = 0;
        if (listModelApp != null) {
            n4 = listModelApp.getLength();
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n3 >= n4) {
            n3 = n4 - 1;
        }
        if (listModelApp != null) {
            l = ((LongListCell)listModelApp.getCell(n3, 1)).getValue();
        }
        return l;
    }

    private String getTourNameProposal() {
        RouteDestination[] routeDestinationArray;
        Route route = this.routeManager.getRoute();
        if (route != null && (routeDestinationArray = route.getRoutelist()) != null && routeDestinationArray.length > 0) {
            return AddressFormatter.formatOneLine(routeDestinationArray[routeDestinationArray.length - 1].getRouteLocation(), this.env).getFirstLineAsText();
        }
        return "";
    }

    protected String getTrailNameProposal() {
        return new StringBuffer().append("Track ").append(this.getDateTime()).toString();
    }

    private String getDateTime() {
        long l = this.env.getFramework().getKombiTime();
        DateMetric dateMetric = new DateMetric(new Date(), 0);
        dateMetric.setDate(l);
        String string = dateMetric.format(20);
        dateMetric = new DateMetric(new Date(), 6);
        dateMetric.setDate(l);
        String string2 = dateMetric.format();
        return new StringBuffer().append("<").append(string).append("> <").append(string2).append(">").toString();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "TourHandler#keyTyped( model = %1, key = %2 )", (long)n, (long)n2);
        CommandList commandList = null;
        String string = null;
        switch (n) {
            case 400551: {
                this.tourHandler.deleteAllTours();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401987: {
                this.tourHandler.deleteAllPressTours();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400555: {
                this.fc.incCounter(16);
                string = this.env.getSpellerModel(-1424226816).getText();
                if (Util.isEmpty(string)) {
                    string = this.favSuggestion;
                }
                if (string.equals("@_TOUR_BACKUP_@")) {
                    string = new Buffer(string).append('1').toString();
                }
                if (n2 == 0) {
                    Route route = this.routeManager.getRoute();
                    route.setRoutename(string);
                    commandList = this.commandListFactory.createCommandList();
                    commandList.add(new RmRouteAddCommand(1, route, string));
                    commandList.add(this.getDisableOffroadIfPrevioulseRequestedCommandList());
                    commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_SAVE_SPELLER");
                }
                this.env.getSpellerModel(-1424226816).clear();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400550: {
                commandList = this.commandListFactory.createCommandList();
                if (this.tourHandler.getNavSegmentId() == null) {
                    commandList.add(new RmRouteDeleteCommand(this.tourHandler.getLoadedMemoryID(), this.tourHandler.getLoadedTourID()));
                } else {
                    commandList.add(new TrDeleteTrace(this.tourHandler.getNavSegmentId()));
                }
                commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_DEL_CURRENT_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 402020: {
                Route route = this.routeManager.getRoute();
                NavLocation navLocation = route.getRoutelist()[route.getRoutelist().length - 1].getRouteLocation();
                this.naviFavoriteHandler.addToFavorites(navLocation);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400553: {
                if (this.tourHandler.getTourBackupID() >= 0L) {
                    this.fc.incCounter(15);
                    commandList = this.commandListFactory.createCommandList();
                    commandList.add(this.tourHandler.loadTour(1, -1, this.tourHandler.getTourBackupID()));
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new TourHandlerHmiListener$SetLoadedTour(this));
                    commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_LOAD_TOUR_BACKUP_BUTTON");
                } else {
                    this.logChannel.log(10000, "TourHandler#keyTyped() - no tour plan backup available!");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401904: {
                this.favSuggestion = this.createTourNameForSaving();
                this.env.getSpellerModel(-1424226816).setCompletionText(this.favSuggestion);
                this.env.getSpellerModel(-1424226816).setText("");
                this.env.getSpellerModel(-1424226816).setControlButtonStates(1, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401907: {
                if (this.tourHandler.getNavSegmentId() == null) {
                    commandList = this.commandListFactory.createCommandList(0);
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new TourHandlerHmiListener$SetLoadedTour(this));
                    commandList.add(new TourHandlerHmiListener$StartGuidance(this));
                    commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_START_CURRENT_BUTTON");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401918: {
                Object object;
                int n4 = this.checkForTmpHideOffroadDisclaimerCheckbox();
                if (n4 == 1) {
                    object = this.env.getChoiceModel(119670272);
                    object.setValue(n4 == 1 ? 1 : 0);
                    this.saveState();
                }
                object = this.tourHandler.getEmptyRoute(2);
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(new RGStopGuidanceCommand());
                commandList.add(new RmMakeRoutePersistentCommand((Route)object));
                commandList.execute("TourHandler#keyTyped.NAV_OFFR_ENABLE_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400573: {
                int n5 = this.env.getChoiceModel(-1122236928).getValue();
                Route route = null;
                if (n5 != 0) {
                    if (this.env.getChoiceModel(52561408).getValue() == 0) {
                        route = this.tourHandler.getEmptyRoute(0);
                    } else {
                        this.wantedToDeactivate = true;
                    }
                } else {
                    int n6 = this.env.getChoiceModel(119670272).getValue();
                    if (n6 != 0) {
                        route = this.tourHandler.getEmptyRoute(2);
                    }
                }
                if (route != null) {
                    commandList = this.commandListFactory.createCommandList(0);
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new RmMakeRoutePersistentCommand(route));
                    commandList.execute("TourHandler#keyTyped.NAV_OFFR_STATUS_CHOICE");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401927: {
                ChoiceModelApp choiceModelApp = this.env.getChoiceModel(119670272);
                choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
                this.saveState();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401929: {
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(new TrStartTraceRecording(0));
                commandList.execute("TourHandler#keyTyped.NAV_OFFR_RECORD_TRACE_FROM_CCP_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401928: {
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(new TrStartTraceRecording(0));
                commandList.execute("TourHandler#keyTyped.NAV_OFFR_RECORD_TRACE_FROM_STARTPOINT_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401920: {
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(new TrCreateWaypoint());
                commandList.execute("TourHandler#keyTyped.NAV_OFFR_ADD_WAYPOINT_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401919: {
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(new TrStopTraceRecording());
                commandList.add(new TrStoreTrace(null));
                commandList.add(this.getDisableOffroadIfPrevioulseRequestedCommandList());
                commandList.execute("TourHandler#keyTyped.NAV_OFFR_DISGARD_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401917: {
                this.env.getSpellerModel(0x6220600).setText(this.getTrailNameProposal());
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401926: {
                string = this.env.getSpellerModel(0x6220600).getText();
                if (n2 == 0) {
                    commandList = this.commandListFactory.createCommandList();
                    commandList.add(new TrStopTraceRecording());
                    commandList.add(new TrStoreTrace(string));
                    commandList.add(this.getDisableOffroadIfPrevioulseRequestedCommandList());
                    commandList.execute("TourHandler#keyTyped.NAV_OFFR_STORE_SPELLER");
                }
                this.env.getSpellerModel(0x6220600).clear();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401925: {
                this.env.getChoiceModel(170001920).setValue(0);
                this.env.getChoiceModel(86115840).setValue(1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401930: {
                this.env.getChoiceModel(170001920).setValue(1);
                this.env.getChoiceModel(86115840).setValue(0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401916: {
                this.dsiNavRouteOptTrail = this.env.getChoiceModel(170001920).getValue() == 1 ? 2 : 3;
                this.saveOffRoadRouteOptionsState(this.dsiNavRouteOptTrail);
                this.startGuidance();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401924: {
                this.dsiNavRouteOptTrail = this.env.getChoiceModel(170001920).getValue() == 1 ? 1 : 4;
                this.saveOffRoadRouteOptionsState(this.dsiNavRouteOptTrail);
                this.startGuidance();
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(10000, "TourHandler#keyTyped() - unknown model id: %1", (long)n);
            }
        }
    }

    protected int checkForTmpHideOffroadDisclaimerCheckbox() {
        return 0;
    }

    private String createTourNameForSaving() {
        StringBuffer stringBuffer = new StringBuffer();
        DateMetric dateMetric = new DateMetric(new Date(this.env.getFramework().getKombiTime()), 4);
        stringBuffer.append(this.env.getTranslatedText(57, "Tour"));
        stringBuffer.append(" ");
        stringBuffer.append(dateMetric.getFormattedValue());
        return stringBuffer.toString();
    }

    private CommandList getDisableOffroadIfPrevioulseRequestedCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.wantedToDeactivate) {
            Route route = this.tourHandler.getEmptyRoute(0);
            commandList.add(new TourHandlerHmiListener$1(this, "reset wantedToDeactivate"));
            commandList.add(new RGStopGuidanceCommand());
            commandList.add(new RmMakeRoutePersistentCommand(route));
        }
        return commandList;
    }

    private void startGuidance() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RGStopGuidanceCommand());
        commandList.add(this.iStartGuidanceToDestinationSequence.getOffroadStartSequence(this.tourHandler.getLocationFromNavSegmentId(), true, this.dsiNavRouteOptTrail));
        commandList.execute("TourHandler#startGuidance");
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "TourHandler#itemSelected( %1, %2 )", (long)n, (long)n2);
        CommandList commandList = null;
        switch (n) {
            case 400552: {
                this.fc.incCounter(15);
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(this.tourHandler.loadTour(1, n2, this.getTourID(n, n2)));
                if (n3 == 0) {
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new TourHandlerHmiListener$SetLoadedTour(this));
                }
                commandList.execute("TourHandler#itemSelected.NAV_MEM_ROUTE_LOAD_LIST");
                this.env.fireModelEvent(n, n4);
                break;
            }
            case 400549: {
                this.fc.incCounter(17);
                if (n3 == 0) {
                    commandList = this.commandListFactory.createCommandList(0);
                    commandList.add(new RmRouteDeleteCommand(1, this.getTourID(n, n2)));
                } else {
                    commandList = this.tourHandler.loadTour(1, n2, this.getTourID(n, n2));
                }
                commandList.execute("TourHandler#itemSelected.NAV_MEM_ROUTE_DEL_LIST");
                this.env.fireModelEvent(n, n4);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "TourHandler#itemSelected() - unknown model id: %1", (long)n);
            }
        }
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "TourHandlerHmiListener#textChanged() text=%2", (Object)string);
        if (Util.isEmpty(string)) {
            if (!Util.isEmpty(this.favSuggestion)) {
                this.env.getSpellerModel(-1424226816).setCompletionText(this.favSuggestion);
            }
        } else if (!Util.isEmpty(this.env.getSpellerModel(-1424226816).getCompletionText())) {
            this.favSuggestion = this.env.getSpellerModel(-1424226816).getCompletionText();
            this.env.getSpellerModel(-1424226816).setCompletionText("");
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-1601830656, "TourHandler#itemSelected(EvoListRow row, int model, int index, int col, int terminal)");
        if (n == -249494016 || n == 1092748800) {
            TourPlanEvoListRow tourPlanEvoListRow = (TourPlanEvoListRow)evoListRow;
            RouteListData routeListData = tourPlanEvoListRow.getRoute();
            if (routeListData.segmentId == null) {
                CommandList commandList = this.commandListFactory.createCommandList(0);
                commandList.add(this.tourHandler.loadTour(routeListData.memoryId, n2, routeListData.id));
                if (n3 == 2) {
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new TourHandlerHmiListener$SetLoadedTour(this));
                    commandList.add(new TourHandlerHmiListener$StartGuidance(this));
                }
                commandList.execute("TourHandler#itemSelected.NAV_MEM_ROUTE_BASE_LIST");
            } else {
                this.tourHandler.showTour(routeListData.segmentId, routeListData.name, 1);
            }
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.itemSelected(evoListRow, n, n2, 2, n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            TourHandlerHmiListener$State tourHandlerHmiListener$State = new TourHandlerHmiListener$State(iStorageAccess, this.logChannel);
            tourHandlerHmiListener$State.setOffrDisclaimerPersistence(this.env.getChoiceModel(119670272).getValue());
            tourHandlerHmiListener$State.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "TourHandlerHmiListener#saveState() - no storage manager available!!! ");
        }
    }

    private void saveOffRoadRouteOptionsState(int n) {
        OffroadRouteOptionsStateManager offroadRouteOptionsStateManager = new OffroadRouteOptionsStateManager(this.env);
        offroadRouteOptionsStateManager.saveDsiRouteOptionOffRoad(n);
    }

    private void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            TourHandlerHmiListener$State tourHandlerHmiListener$State = new TourHandlerHmiListener$State(iStorageAccess, this.logChannel);
            tourHandlerHmiListener$State.readAndDeserialize();
            this.env.getChoiceModel(119670272).setValue(tourHandlerHmiListener$State.getOffrDisclaimerPersistence());
        } else {
            this.logChannel.log(10000, "TourHandlerHmiListener#loadState() - no storage manager available!!! ");
        }
    }

    public void resetSettings() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(119670272);
        if (choiceModelApp == null) {
            this.logChannel.log(-1601830656, "TourHandlerHmiListener#resetSettings() choiceModel is null");
            return;
        }
        choiceModelApp.setValue(1);
        this.saveState();
    }
}

