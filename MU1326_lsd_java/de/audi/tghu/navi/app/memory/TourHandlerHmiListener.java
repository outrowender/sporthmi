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
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.command.NavCommand;
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
import de.audi.tghu.navi.app.memory.TourPlanEvoListRow;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
    private static final String TOUR_NAME_DEFAULT = "Tour";
    private static final int MAX_COLUMNS = 2;
    private static final int COLUMN_ID = 1;
    private static final int COLUMN_SHORTCUT = 0;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_SHOW = 0;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_HIDE = 1;
    protected static final int OFFR_DISCLAIMER_PERSISTENCE_DEFAULT = 1;
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
        this.env.getChoiceModel(401930).setValue(1);
        this.env.getChoiceModel(401925).setValue(0);
    }

    private void setListener() {
        this.env.getListModel(400552).setMaxRows(50);
        this.env.getListModel(400552).setListListener(this);
        this.env.getListModel(400552).setMaxColumns(2);
        this.env.getListModel(400549).setMaxRows(50);
        this.env.getListModel(400549).setListListener(this);
        this.env.getListModel(400549).setMaxColumns(2);
        this.env.getBaseListModel(401905).setListener(this);
        this.env.getBaseListModel(401985).setListener(this);
        this.env.getButtonModel(401904).setButtonListener(this);
        this.env.getButtonModel(400551).setButtonListener(this);
        this.env.getButtonModel(401987).setButtonListener(this);
        this.env.getButtonModel(400553).setButtonListener(this);
        this.env.getSpellerModel(400555).setSpellerListener(this);
        this.env.getSpellerModel(400555).setMaxLength(40);
        this.env.getButtonModel(400550).setButtonListener(this);
        this.env.getButtonModel(401907).setButtonListener(this);
        this.env.getButtonModel(401918).setButtonListener(this);
        this.env.getChoiceModel(400573).setChoiceListener(this);
        this.env.getChoiceModel(401927).setChoiceListener(this);
        this.env.getButtonModel(401929).setButtonListener(this);
        this.env.getButtonModel(401928).setButtonListener(this);
        this.env.getButtonModel(401920).setButtonListener(this);
        this.env.getButtonModel(401919).setButtonListener(this);
        this.env.getButtonModel(401917).setButtonListener(this);
        this.env.getSpellerModel(401926).setSpellerListener(this);
        this.env.getChoiceModel(401925).setChoiceListener(this);
        this.env.getChoiceModel(401930).setChoiceListener(this);
        this.env.getButtonModel(401916).setButtonListener(this);
        this.env.getButtonModel(401924).setButtonListener(this);
        this.env.getButtonModel(402020).setButtonListener(this);
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
        return "Track " + this.getDateTime();
    }

    private String getDateTime() {
        long l = this.env.getFramework().getKombiTime();
        DateMetric dateMetric = new DateMetric(new Date(), 0);
        dateMetric.setDate(l);
        String string = dateMetric.format(20);
        dateMetric = new DateMetric(new Date(), 6);
        dateMetric.setDate(l);
        String string2 = dateMetric.format();
        return "<" + string + "> <" + string2 + ">";
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "TourHandler#keyTyped( model = %1, key = %2 )", (long)n, (long)n2);
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
                string = this.env.getSpellerModel(400555).getText();
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
                this.env.getSpellerModel(400555).clear();
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
                    commandList.add(new SetLoadedTour());
                    commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_LOAD_TOUR_BACKUP_BUTTON");
                } else {
                    this.logChannel.log(10000, "TourHandler#keyTyped() - no tour plan backup available!");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401904: {
                this.favSuggestion = this.createTourNameForSaving();
                this.env.getSpellerModel(400555).setCompletionText(this.favSuggestion);
                this.env.getSpellerModel(400555).setText("");
                this.env.getSpellerModel(400555).setControlButtonStates(1, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401907: {
                if (this.tourHandler.getNavSegmentId() == null) {
                    commandList = this.commandListFactory.createCommandList(0);
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new SetLoadedTour());
                    commandList.add(new StartGuidance());
                    commandList.execute("TourHandler#keyTyped.NAV_MEM_ROUTE_START_CURRENT_BUTTON");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401918: {
                Object object;
                int n4 = this.checkForTmpHideOffroadDisclaimerCheckbox();
                if (n4 == 1) {
                    object = this.env.getChoiceModel(401927);
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
                int n5 = this.env.getChoiceModel(400573).getValue();
                Route route = null;
                if (n5 != 0) {
                    if (this.env.getChoiceModel(401923).getValue() == 0) {
                        route = this.tourHandler.getEmptyRoute(0);
                    } else {
                        this.wantedToDeactivate = true;
                    }
                } else {
                    int n6 = this.env.getChoiceModel(401927).getValue();
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
                ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401927);
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
                this.env.getSpellerModel(401926).setText(this.getTrailNameProposal());
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401926: {
                string = this.env.getSpellerModel(401926).getText();
                if (n2 == 0) {
                    commandList = this.commandListFactory.createCommandList();
                    commandList.add(new TrStopTraceRecording());
                    commandList.add(new TrStoreTrace(string));
                    commandList.add(this.getDisableOffroadIfPrevioulseRequestedCommandList());
                    commandList.execute("TourHandler#keyTyped.NAV_OFFR_STORE_SPELLER");
                }
                this.env.getSpellerModel(401926).clear();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401925: {
                this.env.getChoiceModel(401930).setValue(0);
                this.env.getChoiceModel(401925).setValue(1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401930: {
                this.env.getChoiceModel(401930).setValue(1);
                this.env.getChoiceModel(401925).setValue(0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401916: {
                this.dsiNavRouteOptTrail = this.env.getChoiceModel(401930).getValue() == 1 ? 2 : 3;
                this.saveOffRoadRouteOptionsState(this.dsiNavRouteOptTrail);
                this.startGuidance();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401924: {
                this.dsiNavRouteOptTrail = this.env.getChoiceModel(401930).getValue() == 1 ? 1 : 4;
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
        stringBuffer.append(this.env.getTranslatedText(57, TOUR_NAME_DEFAULT));
        stringBuffer.append(" ");
        stringBuffer.append(dateMetric.getFormattedValue());
        return stringBuffer.toString();
    }

    private CommandList getDisableOffroadIfPrevioulseRequestedCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.wantedToDeactivate) {
            Route route = this.tourHandler.getEmptyRoute(0);
            commandList.add(new NavCommand("reset wantedToDeactivate"){

                public void execute() {
                    TourHandlerHmiListener.this.wantedToDeactivate = false;
                    this.getCommandList().commandFinished();
                }
            });
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

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "TourHandler#itemSelected( %1, %2 )", (long)n, (long)n2);
        CommandList commandList = null;
        switch (n) {
            case 400552: {
                this.fc.incCounter(15);
                commandList = this.commandListFactory.createCommandList(0);
                commandList.add(this.tourHandler.loadTour(1, n2, this.getTourID(n, n2)));
                if (n3 == 0) {
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new SetLoadedTour());
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
                this.logChannel.log(100000, "TourHandler#itemSelected() - unknown model id: %1", (long)n);
            }
        }
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "TourHandlerHmiListener#textChanged() text=%2", (Object)string);
        if (Util.isEmpty(string)) {
            if (!Util.isEmpty(this.favSuggestion)) {
                this.env.getSpellerModel(400555).setCompletionText(this.favSuggestion);
            }
        } else if (!Util.isEmpty(this.env.getSpellerModel(400555).getCompletionText())) {
            this.favSuggestion = this.env.getSpellerModel(400555).getCompletionText();
            this.env.getSpellerModel(400555).setCompletionText("");
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(100000, "TourHandler#itemSelected(EvoListRow row, int model, int index, int col, int terminal)");
        if (n == 401905 || n == 401985) {
            TourPlanEvoListRow tourPlanEvoListRow = (TourPlanEvoListRow)evoListRow;
            RouteListData routeListData = tourPlanEvoListRow.getRoute();
            if (routeListData.segmentId == null) {
                CommandList commandList = this.commandListFactory.createCommandList(0);
                commandList.add(this.tourHandler.loadTour(routeListData.memoryId, n2, routeListData.id));
                if (n3 == 2) {
                    commandList.add(new RGStopGuidanceCommand());
                    commandList.add(new SetLoadedTour());
                    commandList.add(new StartGuidance());
                }
                commandList.execute("TourHandler#itemSelected.NAV_MEM_ROUTE_BASE_LIST");
            } else {
                this.tourHandler.showTour(routeListData.segmentId, routeListData.name, 1);
            }
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.itemSelected(evoListRow, n, n2, 2, n4);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.setOffrDisclaimerPersistence(this.env.getChoiceModel(401927).getValue());
            state.serializeAndWrite();
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
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            this.env.getChoiceModel(401927).setValue(state.getOffrDisclaimerPersistence());
        } else {
            this.logChannel.log(10000, "TourHandlerHmiListener#loadState() - no storage manager available!!! ");
        }
    }

    public void resetSettings() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401927);
        if (choiceModelApp == null) {
            this.logChannel.log(100000, "TourHandlerHmiListener#resetSettings() choiceModel is null");
            return;
        }
        choiceModelApp.setValue(1);
        this.saveState();
    }

    public static class State
    extends PersistentState {
        private static final int VERSION = 1;
        private static final int KEY = 943;
        private int offrDisclaimerPersistence;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 943, logChannel);
        }

        protected void initWithDefaultValues() {
            this.offrDisclaimerPersistence = 1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.offrDisclaimerPersistence);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.offrDisclaimerPersistence = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.logChannel.log(10000000, "TourHandlerHmiListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.offrDisclaimerPersistence = dataInputStream.readInt();
                }
            }
            catch (IOException iOException) {
                this.logChannel.log(10000, "TourHandlerHmiListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public int getOffrDisclaimerPersistence() {
            return this.offrDisclaimerPersistence;
        }

        public void setOffrDisclaimerPersistence(int n) {
            this.offrDisclaimerPersistence = n;
        }
    }

    public final class SetLoadedTour
    extends NavCommand {
        public void execute() {
            TourHandlerHmiListener.this.logChannel.log(10000000, "TourHandler.SetLoadedTour#execute()");
            this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(TourHandlerHmiListener.this.tourHandler.getLoadedTour()));
        }
    }

    public final class StartGuidance
    extends NavCommand {
        public void execute() {
            TourHandlerHmiListener.this.logChannel.log(10000000, "TourHandler.StartGuidance#execute()");
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceSequence());
        }
    }
}

