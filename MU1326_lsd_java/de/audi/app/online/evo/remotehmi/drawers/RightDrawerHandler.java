/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.textconstants.TextConstantUtil;
import de.audi.remotehmi.ui.mib2.Commands;
import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.GridHelper;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.util.RangeCounter;
import de.audi.tghu.online.app.remotehmi.util.UtilOnline;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RightDrawerHandler
implements ButtonListener,
ChoiceListener,
ListListener,
MenuModelListener {
    private static final String USER_SETTINGS_APP_ID = "userSettings";
    private final RemoteHMIServiceEvo remoteHMIService;
    final LogChannel log;
    private IGridList currentGridList;
    private List currentTypes = null;
    private String currentlySelectedLeftDrawerEntry;
    private Commands.RightDrawerPayload payloadLastRecieved = null;
    private DrawerEntry previouslySelectedDrawerEntry;
    private String previousConfiguration;
    private IGridList mainGridList = null;
    private ContextManagerComponent contextManagerComponent;
    private final OnlineModelBankAccess modelBankAccess;
    private List storedViewDataTypes;
    private RangeCounter storedRangeCounter;
    private IGrid storedParentGrid;
    private IGridList storedMainGridList;
    private RightDrawerTypes rightDrawerTypes;
    private Map menuSpecificEntries = new HashMap();
    private Map typesCurrentContext = new HashMap();
    private Map entriesCurrentTypes;
    private Map entriesCurrentMenu;
    private Map entriesCurrentContext;
    private boolean privacyModeIsActive = false;
    private boolean isLockingActive = false;

    public RightDrawerHandler(LogChannel logChannel, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this(logChannel, remoteHMIServiceEvo, false);
    }

    protected RightDrawerHandler(final LogChannel logChannel, final RemoteHMIServiceEvo remoteHMIServiceEvo, boolean bl) {
        this.log = logChannel;
        this.remoteHMIService = remoteHMIServiceEvo;
        this.contextManagerComponent = remoteHMIServiceEvo.getContextManagerComponent();
        this.modelBankAccess = remoteHMIServiceEvo.getModelBankAccess();
        this.rightDrawerTypes = new RightDrawerTypes(this, logChannel, remoteHMIServiceEvo.getLeftDrawerHandler());
        if (bl) {
            return;
        }
        remoteHMIServiceEvo.addCommandHandler(10000002, new AbstractCommandHandler("right-drawer"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.RightDrawerPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RightDrawerHandler#indicateCommand: Commands.STATE_RIGHT_DRAWER called");
                if (!(object instanceof Commands.RightDrawerPayload)) {
                    logChannel.log(100000, "RightDrawerHandler#indicateCommand: wrong payload provided");
                    return;
                }
                Commands.RightDrawerPayload rightDrawerPayload = (Commands.RightDrawerPayload)object;
                String string = rightDrawerPayload.getContextName();
                RemoteHMIContext remoteHMIContext = remoteHMIServiceEvo.getContextManagerComponent().getCurrentContext();
                if (remoteHMIContext != null && remoteHMIContext.getContextName().equals(string)) {
                    RightDrawerHandler.this.rightDrawerTypes.setRightDrawerTypes(rightDrawerPayload);
                } else {
                    logChannel.log(10000000, "RightDrawerHandler#indicateCommand: RightDrawerPayload saved as payloadLastRecieved");
                    RightDrawerHandler.this.payloadLastRecieved = rightDrawerPayload;
                }
            }
        });
        remoteHMIServiceEvo.addCommandHandler(0x989686, new AbstractCommandHandler("update-right-drawer-state"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.RightDrawerStatePayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RightDrawerHandler#indicateCommand: Commands.STATE_UPDATE_RIGHT_DRAWER_STATE called");
                if (!(object instanceof Commands.RightDrawerStatePayload)) {
                    logChannel.log(100000, "RightDrawerHandler#indicateCommand: wrong payload provided");
                    return;
                }
                Commands.RightDrawerStatePayload rightDrawerStatePayload = (Commands.RightDrawerStatePayload)object;
                String string = rightDrawerStatePayload.entryId;
                String string2 = rightDrawerStatePayload.value;
                String string3 = rightDrawerStatePayload.getContextName();
                RightDrawerHandler.this.findAndUpdateEntry(string, string2, string3);
            }
        });
        remoteHMIServiceEvo.addCommandHandler(100000019, new AbstractCommandHandler("grayout-right-drawer-entry"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.GrayoutRightDrawerEntryPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RightDrawerHandler#indicateCommand: Commands.STATE_GRAYOUT_RIGHT_DRAWER_ENTRY called");
                if (!(object instanceof Commands.GrayoutRightDrawerEntryPayload)) {
                    logChannel.log(100000, "RightDrawerHandler#indicateCommand: wrong payload provided");
                    return;
                }
                Commands.GrayoutRightDrawerEntryPayload grayoutRightDrawerEntryPayload = (Commands.GrayoutRightDrawerEntryPayload)object;
                String string = grayoutRightDrawerEntryPayload.entryId;
                String string2 = grayoutRightDrawerEntryPayload.infoText;
                String string3 = grayoutRightDrawerEntryPayload.getContextName();
                RightDrawerHandler.this.findAndGrayoutEntry(string, string2, string3);
            }
        });
        remoteHMIServiceEvo.addCommandHandler(100000015, new AbstractCommandHandler("close-right-drawer"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString((String)object);
            }

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RightDrawerHandler#indicateCommand: Commands.STATE_CLOSE_RIGHT_DRAWER called");
                String string = (String)object;
                RightDrawerHandler.this.closeRightDrawer(string);
            }
        });
        remoteHMIServiceEvo.addCommandHandler(100000017, new AbstractCommandHandler("update-right-drawer-top-wizard"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.RightDrawerPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                RemoteHMIContext remoteHMIContext;
                logChannel.log(1000000, "RightDrawerHandler#indicateCommand: Commands.STATE_TOP_WIZARD_RIGHT_DRAWER_UPDATE called");
                if (!(object instanceof Commands.RightDrawerPayload)) {
                    logChannel.log(100000, "RightDrawerHandler#indicateCommand: wrong payload provided");
                    return;
                }
                Commands.RightDrawerPayload rightDrawerPayload = (Commands.RightDrawerPayload)object;
                EntryPoint entryPoint = RightDrawerHandler.this.contextManagerComponent == null ? null : RightDrawerHandler.this.contextManagerComponent.getCurrentEntryPoint();
                RemoteHMIContext remoteHMIContext2 = remoteHMIContext = entryPoint == null ? null : entryPoint.getCurrentContext();
                if (remoteHMIContext == null) {
                    logChannel.log(100000, "RightDrawerHandler#indicateCommand: currentEntryPoint or currentContext is null");
                    return;
                }
                if (remoteHMIContext.getContextName().equals("top_wizard") && entryPoint.getEntryPointId() == 1) {
                    RightDrawerHandler.this.rightDrawerTypes.setRightDrawerTypes(rightDrawerPayload);
                }
            }
        });
        ChoiceModelApp choiceModelApp = remoteHMIServiceEvo.getFrameworkAccess().getHMIService().getChoiceModel(2301050);
        choiceModelApp.setChoiceListener(this);
    }

    private String getConfigurationAsString(List list, String string) {
        Buffer buffer = new Buffer();
        RemoteHMIContext remoteHMIContext = this.remoteHMIService.getContext();
        buffer.append('[');
        buffer.append(remoteHMIContext == null ? "" : remoteHMIContext.getContextName());
        buffer.append(']');
        buffer.append('[');
        buffer.append(string);
        buffer.append(']');
        buffer.append('[');
        if (list == null) {
            buffer.append("null");
        } else {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                buffer.append(string2);
                buffer.append(',');
            }
        }
        buffer.append(']');
        return buffer.toString();
    }

    private RightDrawerEntriesContainer getRightDrawerEntries(List list, RangeCounter rangeCounter) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        Object object2;
        this.log.log(1000000, "RightDrawerHandler#getRightDrawerEntries: Called for %1", (Object)list);
        IGridFactory iGridFactory = this.remoteHMIService.getGridFactory();
        if (iGridFactory == null) {
            this.log.log(100000, "RightDrawerHandler#getRightDrawerEntries: gridFactory is null so can't update right drawer");
            return null;
        }
        String string = this.getConfigurationAsString(list, this.currentlySelectedLeftDrawerEntry);
        if (UtilOnline.areEqual(this.previousConfiguration, string)) {
            this.log.log(10000000, "RightDrawerHandler#getRightDrawerEntries: old and new configuration are same so no need to create new right drawer, instead use cashed one");
            return new RightDrawerEntriesContainer(this.currentGridList, false);
        }
        this.previousConfiguration = string;
        List list2 = null;
        if (list != null) {
            object2 = list.iterator();
            while (object2.hasNext()) {
                List list3;
                object = (String)object2.next();
                if (object == null || !this.typesCurrentContext.containsKey(object) || (list3 = (List)this.typesCurrentContext.get(object)) == null) continue;
                if (list2 == null) {
                    list2 = new ArrayList(20);
                }
                list2.addAll(list3);
            }
        }
        object2 = null;
        if (this.typesCurrentContext.containsKey("____global____")) {
            object2 = (List)this.typesCurrentContext.get("____global____");
        }
        object = null;
        if (this.currentlySelectedLeftDrawerEntry != null && this.menuSpecificEntries.containsKey(this.currentlySelectedLeftDrawerEntry)) {
            object = (List)this.menuSpecificEntries.get(this.currentlySelectedLeftDrawerEntry);
        }
        if ((n5 = (n4 = list2 == null ? 0 : list2.size()) + (n3 = object2 == null ? 0 : object2.size()) + (n2 = object == null ? 0 : object.size())) == 0) {
            this.log.log(10000000, "RightDrawerHandler#getRightDrawerEntries: No global, menu specific and type specific right drawer entries for %1 found", (Object)list);
            this.currentGridList = iGridFactory.createGridList(0);
            return new RightDrawerEntriesContainer(this.currentGridList, true);
        }
        IGridList iGridList = iGridFactory.createGridList(n5);
        iGridList.setRangeCounter(rangeCounter);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (list2 == null) {
            this.currentTypes = null;
        } else {
            arrayList.addAll(list2);
            this.currentTypes = list;
            this.addToMap(list2, hashMap);
        }
        if (object != null && !object.isEmpty()) {
            arrayList.addAll((Collection)object);
            this.addToMap((List)object, hashMap3);
        }
        if (object2 != null && !object2.isEmpty()) {
            arrayList.addAll((Collection)object2);
            this.addToMap((List)object2, hashMap2);
        }
        Collections.sort(arrayList);
        this.addToGridlist(arrayList, iGridList);
        this.currentGridList = iGridList;
        this.entriesCurrentTypes = hashMap;
        this.entriesCurrentContext = hashMap2;
        this.entriesCurrentMenu = hashMap3;
        this.log.log(10000000, "RightDrawerHandler#getRightDrawerEntries: Number of entries returned for types %1 are : %2", (Object)this.currentTypes, (long)iGridList.size());
        if (this.previouslySelectedDrawerEntry != null && (n = arrayList.indexOf(this.previouslySelectedDrawerEntry)) != -1) {
            this.log.log(10000000, "RightDrawerHandler#getRightDrawerEntries: setting current cursor to index %1", (long)n);
            ICursor iCursor = this.remoteHMIService.getGridFactory().createCursor().withFocus(n, -1, null, null);
            iGridList.setCurrentCursor(iCursor);
        }
        return new RightDrawerEntriesContainer(iGridList, true);
    }

    private void addToGridlist(List list, IGridList iGridList) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry = (DrawerEntry)iterator.next();
            IGrid iGrid = drawerEntry.getWidgetGridForEntry();
            if (iGrid == null) {
                throw new IllegalStateException(new StringBuffer().append("drawerEntry ").append(drawerEntry.getEntryId()).append(" has no widget grid!").toString());
            }
            iGridList.add(iGrid);
        }
    }

    private void addToMap(List list, Map map) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry = (DrawerEntry)iterator.next();
            IGrid iGrid = drawerEntry.getWidgetGridForEntry();
            if (iGrid == null) {
                throw new IllegalStateException(new StringBuffer().append("drawerEntry ").append(drawerEntry.getEntryId()).append(" has no widget grid!").toString());
            }
            map.put(iGrid.getId(), drawerEntry);
        }
    }

    public void setCurrentlySelectedLeftDrawerEntry(String string) {
        this.currentlySelectedLeftDrawerEntry = string;
    }

    public List getCurrentlyFocusedTypes() {
        return this.currentTypes;
    }

    public void itemSelected(final int n, final int n2, int n3, int n4) {
        this.log.log(1000000, "RightDrawerHandler#itemSelected: callback from dropDownList: modelID=%1, itemID=%2.", (long)n, (long)n2);
        this.remoteHMIService.execute(new AbstractRemoteHMITask("right-drawer-item-focused", LogAppender.Factory.fromInt(n, "widgetId")){

            public void run() {
                if (n == 2301050) {
                    int n3 = n2 & 3;
                    if (n3 == 1) {
                        RightDrawerHandler.this.log.log(1000000, "RightDrawerHandler#itemSelected: drawer was closed, resetting focus. For modelID=%1, itemID=%2.", (long)n, (long)n2);
                        RightDrawerHandler.this.previouslySelectedDrawerEntry = null;
                    } else {
                        RightDrawerHandler.this.log.log(1000000, "RightDrawerHandler#itemSelected: ignoring focus event=%3 for modelID=%1, itemID=%2.", (long)n, (long)n2, (long)n3);
                    }
                    return;
                }
                RightDrawerHandler.this.log.log(1000000, "RightDrawerHandler#itemSelected: invoking action for modelID=%1, itemID=%2.", (long)n, (long)n2);
                RightDrawerHandler.this.invokeAction(n, n2);
            }
        });
    }

    public void keyPressed(int n, int n2, int n3) {
        this.log.log(1000000, "RightDrawerHandler#keyPressed: callback from menuItem button: modelID=%1, keyID=%2", (long)n, (long)n2);
        this.invokeAction(n, 0);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemFocused(final int n, int n2, long l, int n3) {
        this.log.log(1000000, "RightDrawerHandler#itemFocused: callback from menu: menuItemID=%1, modelID=%2, uniqueListRowID=%3.", (long)n, (long)n2, l);
        this.remoteHMIService.execute(new AbstractRemoteHMITask("right-drawer-item-focused", LogAppender.Factory.fromInt(n, "widgetId")){

            public void run() {
                if (RightDrawerHandler.this.mainGridList != null && RightDrawerHandler.this.currentGridList != null) {
                    int n2 = RightDrawerHandler.this.currentGridList.getIndexFromId(n);
                    RightDrawerHandler.this.log.log(1000000, "RightDrawerHandler#itemFocused: mainGridList not null and current focused right drawer index is '%1'", (long)n2);
                    ICursor iCursor = RightDrawerHandler.this.mainGridList.getCurrentCursor();
                    ICursorComponent iCursorComponent = iCursor.getFocus();
                    RightDrawerHandler.this.mainGridList.setCurrentFocus(iCursorComponent.withRightDrawerIndex(n2));
                    AbstractHMIViewListener abstractHMIViewListener = RightDrawerHandler.this.remoteHMIService.getCurrentView();
                    if (abstractHMIViewListener != null) {
                        abstractHMIViewListener.setNewCursor(iCursor);
                    }
                }
            }
        });
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.log.log(1000000, "RightDrawerHandler#itemFocused: callback with modelID=%1, row=%2", (long)n, (long)n2);
    }

    protected void setMenuSpecificEntries(String string, Map map) {
        this.log.log(1000000, "RightDrawerHandler#setMenuSpecificEntries: Size of menu specific entries for context name : '%1' is %2", (Object)string, (long)map.size());
        this.menuSpecificEntries = map;
    }

    private void findAndUpdateEntry(String string, String string2, String string3) {
        this.log.log(1000000, "RightDrawerHandler#updateApplication: entry id '%1' having value '%2' for context name '%3'", (Object)string, (Object)string2, (Object)string3);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByEntryId(string);
        if (drawerEntry == null) {
            this.log.log(100000, "RightDrawerHandler#updateApplication: couldn't find entry with entryid '%1' so can't update", (Object)string);
            return;
        }
        this.updateValueForEntry(string2, drawerEntry);
    }

    private void findAndGrayoutEntry(String string, String string2, String string3) {
        this.log.log(1000000, "RightDrawerHandler#findAndGrayoutEntry: entry id = '%1', info text = '%2' for context name '%3'", (Object)string, (Object)string2, (Object)string3);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByEntryId(string);
        if (drawerEntry == null) {
            this.log.log(100000, "RightDrawerHandler#findAndGrayoutEntry: couldn't find entry with entryid '%1' so can't gray it out", (Object)string);
            return;
        }
        this.grayoutEntry(drawerEntry, string2, false);
    }

    protected void closeRightDrawer(String string) {
        this.log.log(1000000, "RightDrawerHandler#closeRightDrawer: Closing right drawer for context name '%1'", (Object)string);
        Online online = Online.getInstance();
        HMIService hMIService = online.getFramework().getHMIService();
        DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 2);
        hMIService.getEventDispatcher().postEvent(drawerEvent);
    }

    void loadRightDrawerForSpecificContext() {
        this.log.log(1000000, "RightDrawerHandler#loadRightDrawerForSpecificContext: called");
        this.currentGridList = null;
        this.entriesCurrentTypes = new HashMap();
        this.entriesCurrentContext = new HashMap();
        this.entriesCurrentMenu = new HashMap();
        this.previousConfiguration = null;
        this.typesCurrentContext = this.rightDrawerTypes.getRightDrawerEntriesForCurrentContext();
    }

    private void invokeAction(int n, int n2) {
        IGrid iGrid;
        RemoteHMIContext remoteHMIContext;
        RemoteHMIContext remoteHMIContext2 = remoteHMIContext = this.contextManagerComponent == null ? null : this.contextManagerComponent.getCurrentContext();
        if (remoteHMIContext == null) {
            this.log.log(100000, "RightDrawerHandler#invokeAction: current context is null. Can't pass action to south side");
            return;
        }
        IGridList iGridList = this.currentGridList;
        if (iGridList == null) {
            this.log.log(1000000, "RightDrawerHandler#invokeAction: current gridList is null. Try to restore previously loaded data.");
            this.updateRightDrawer(this.storedViewDataTypes, this.storedRangeCounter, this.storedParentGrid, this.storedMainGridList);
            if (this.currentGridList != null) {
                iGridList = this.currentGridList;
            } else {
                this.log.log(100000, "RightDrawerHandler#invokeAction: current gridList is null. Can't pass action to south side");
                return;
            }
        }
        String string = "";
        int n3 = -1;
        IGrid iGrid2 = iGridList.getParentGrid();
        if (iGrid2 != null) {
            string = iGrid2.getId();
            n3 = iGrid2.getXmlSourceRow();
        }
        if ((iGrid = iGridList.getGridOfWidgetId(n)) == null) {
            this.log.log(100000, "RightDrawerHandler#invokeAction: event of old list will be ignored: widgetId = '%1' and grid list content is '%2'", (Object)new Integer(n), (Object)iGridList);
            return;
        }
        IGridCell iGridCell = iGrid.getFirstCell(0);
        if (iGridCell != null && !iGridCell.isEnabled()) {
            this.log.log(1000000, "RightDrawerHandler#invokeAction: selected entry is disabled so doing nothing");
            return;
        }
        String string2 = iGrid.getId();
        List list = iGrid.getDrawerTypes();
        String string3 = list == null ? "" : (String)list.get(0);
        DrawerEntry drawerEntry = (DrawerEntry)this.entriesCurrentTypes.get(string2);
        boolean bl = false;
        if (drawerEntry == null) {
            drawerEntry = (DrawerEntry)this.entriesCurrentContext.get(string2);
            string3 = "____global____";
        }
        if (drawerEntry == null) {
            drawerEntry = (DrawerEntry)this.entriesCurrentMenu.get(string2);
            bl = true;
            string3 = "";
        }
        if (drawerEntry == null) {
            this.log.log(1000000, "RightDrawerHandler#invokeAction: selected entry is null and grid list context is '%2'", iGridList.getLogObject(0));
            return;
        }
        int n4 = drawerEntry.getWidgetType();
        if (n4 == 1) {
            this.closeRightDrawer(remoteHMIContext.getContextName());
        }
        if ((n4 == 3 || n4 == 5) && drawerEntry.getEntryId().equals("")) {
            this.log.log(100000, "RightDrawerHandler#invokeAction: Selected entry is of type dropdown or checkbox and there is no entry id so can not perform action");
            return;
        }
        this.log.log(1000000, "RightDrawerHandler#invokeAction: Action to be invoked for entry '%1' of widget type '%2'", (Object)drawerEntry.getEntryName(), (long)n4);
        if (remoteHMIContext.getContextName().equals("top_wizard")) {
            if (drawerEntry.getEvent() != null) {
                this.triggerEvent(string3, drawerEntry, n2, bl, string, n3);
            } else {
                ContextManagerComponent contextManagerComponent = this.remoteHMIService.getContextManagerComponent();
                EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
                contextManagerComponent.setWaitForApplicationValue(1);
                entryPoint.setNameOfContextToBeStarted(drawerEntry.getEntryContext());
                RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(10001000);
                remoteHMIAction.getParameters().putString("appContextName", drawerEntry.getEntryContext());
                remoteHMIAction.getParameters().putString("GridId", string);
                this.invokeActionInRemoteHMIService(remoteHMIAction);
            }
            return;
        }
        this.previouslySelectedDrawerEntry = drawerEntry;
        this.triggerEvent(string3, drawerEntry, n2, bl, string, n3);
    }

    private void invokeActionInRemoteHMIService(RemoteHMIAction remoteHMIAction) {
        if (remoteHMIAction == null) {
            this.log.log(100000, "RightDrawerHandler#invokeActionInRemoteHMIService: RemoteHMIAction is null");
            return;
        }
        this.log.log(1000000, "RightDrawerHandler#invokeActionInRemoteHMIService: called for action '%1'", (long)remoteHMIAction.getType());
        RemoteHMIContext remoteHMIContext = this.remoteHMIService.getContext();
        if (remoteHMIContext != null) {
            remoteHMIContext.setLastAction(remoteHMIAction);
        }
        this.remoteHMIService.invokeAction(remoteHMIAction);
    }

    private void triggerEvent(String string, DrawerEntry drawerEntry, int n, boolean bl, String string2, int n2) {
        this.log.log(1000000, "RightDrawerHandler#triggerEvent: Trigger event for entry name '%1' associated with type '%2', parent grid id '%3', parent grid index '%4'", (Object)drawerEntry.getEntryName(), (Object)string, (Object)string2, (long)n2);
        RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(10000002);
        remoteHMIAction.getParameters().putString("selectedId", drawerEntry.getEntryId());
        remoteHMIAction.getParameters().putInt("selectedDropdownIndex", n);
        remoteHMIAction.getParameters().putString("gridId", string2);
        remoteHMIAction.getParameters().putInt("gridIndex", n2);
        remoteHMIAction.getParameters().put("onlineEntryType", string);
        remoteHMIAction.getParameters().putBoolean("entryMenuSpecific", bl);
        if (drawerEntry.getWidgetType() == 3) {
            remoteHMIAction.getParameters().putBoolean("checkboxValue", drawerEntry.getCheckboxValue());
            this.log.log(1000000, "RightDrawerHandler#triggerEvent: Trigger event for entry name '%1' and checkbox value '%2'", (Object)drawerEntry.getEntryName(), (Object)Boolean.toString(drawerEntry.getCheckboxValue()));
        }
        this.invokeActionInRemoteHMIService(remoteHMIAction);
    }

    private void updateValueForEntry(String string, DrawerEntry drawerEntry) {
        this.log.log(1000000, "RightDrawerHandler#updateValueForEntry: called for entryToBeUpdated with id '%1' and new value '%2'", (Object)drawerEntry.getEntryId(), (Object)string);
        IGrid iGrid = drawerEntry.getWidgetGridForEntry();
        if (iGrid == null) {
            this.log.log(100000, "RightDrawerHandler#updateValueForEntry: entryGrid is null for the entry to be updated");
            return;
        }
        IGridCell iGridCell = (IGridCell)iGrid.get(1);
        int n = drawerEntry.getWidgetType();
        if (n == 3) {
            boolean bl = UtilOnline.getSafeBoolean(this.log, string, false);
            if (iGridCell == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: Widget type is checkbox and gridcell is null");
                return;
            }
            iGridCell.setBooleanValue(bl);
            drawerEntry.setCheckboxValue(bl);
            this.log.log(10000000, "RightDrawerHandler#updateValueForEntry: checkbox entry updated");
        } else if (n == 5) {
            int n2 = UtilOnline.getSafeInt(this.log, string, 0);
            if (iGridCell == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: Widget type is dropdown and gridcell is null");
                return;
            }
            IGridList iGridList = iGridCell.getListValue();
            if (iGridList == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: Widget type is dropdown and childGridList is null");
                return;
            }
            iGridList.setCurrentSelection(n2, -1, "", "");
            drawerEntry.setDefaultSelection(n2);
            this.log.log(10000000, "RightDrawerHandler#updateValueForEntry: dropdown entry updated");
        } else if (n == 4) {
            IGridCell iGridCell2 = iGrid.getFirstCell(12);
            if (iGridCell2 == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: subGridContainer null");
                return;
            }
            IGrid iGrid2 = iGridCell2.getGridValue();
            if (iGrid2 == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: subGrid null");
                return;
            }
            IGridCell iGridCell3 = iGrid2.getFirstCell(0);
            if (iGridCell3 == null) {
                this.log.log(100000, "RightDrawerHandler#updateValueForEntry: submenuCell null");
                return;
            }
            iGridCell3.setStringValue(string);
            drawerEntry.setInputFieldText(string);
            this.log.log(10000000, "RightDrawerHandler#updateValueForEntry: submenu preview entry updated");
        } else {
            this.log.log(10000, "RightDrawerHandler#updateValueForEntry: Only checkbox, dropdown and submenu are allowed");
            return;
        }
        if (this.currentGridList != null) {
            GridHelper.updateListModelTransaction(this.getRightDrawerListModel(), this.currentGridList, this, 3, 2, this.log);
        }
    }

    public boolean updateRightDrawer(List list, RangeCounter rangeCounter, IGrid iGrid, IGridList iGridList) {
        RemoteHMIContext remoteHMIContext;
        this.mainGridList = iGridList;
        this.storeTemporaryHeldRightDrawerdata(list, rangeCounter, iGrid, iGridList);
        int n = iGridList == null ? -1 : iGridList.getCurrentCursor().getFocus().getRightDrawerIndex();
        this.log.log(10000000, "RightDrawerHandler#updateRightDrawer: right drawer index is '%1'", (long)n);
        ListModelApp listModelApp = this.getRightDrawerListModel();
        RightDrawerEntriesContainer rightDrawerEntriesContainer = this.getRightDrawerEntries(list, rangeCounter);
        if (rightDrawerEntriesContainer == null) {
            this.log.log(100000, "RightDrawerHandler#updateRightDrawer: rightDrawerEntriesContainer is null so can't update right drawer");
            return false;
        }
        IGridList iGridList2 = rightDrawerEntriesContainer.gridList;
        if (iGridList2 == null) {
            this.log.log(100000, "RightDrawerHandler#updateRightDrawer: rightDrawerList is null so can't update right drawer");
            return false;
        }
        iGridList2.setParentGrid(iGrid);
        RemoteHMIContext remoteHMIContext2 = remoteHMIContext = this.contextManagerComponent == null ? null : this.contextManagerComponent.getCurrentContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName() == "top_wizard") {
            this.replaceTextConstants(iGridList2);
        }
        if (!rightDrawerEntriesContainer.wasUpdated && this.isListModelConsistent(iGridList2, listModelApp)) {
            this.log.log(1000000, "RightDrawerHandler#updateRightDrawer: Using cached grid list: %1 with focus %2", iGridList2.getLogObject(0), (Object)iGridList2.getCurrentCursor().getFocus());
        } else {
            this.log.log(1000000, "RightDrawerHandler#updateRightDrawer: grid list: %1 created with current focus %1", iGridList2.getLogObject(0), (Object)iGridList2.getCurrentCursor().getFocus());
            if (this.contextManagerComponent != null && this.contextManagerComponent.isTransitionToInclude() && n < iGridList2.size()) {
                this.log.log(10000000, "RightDrawerHandler#updateRightDrawer: HK Return is pressed from an include state and right index is set to old index which is '%1'", (long)n);
                ICursorComponent iCursorComponent = iGridList2.getCurrentCursor().getFocus();
                iGridList2.setCurrentFocus(iCursorComponent.withValues(n, -1, "", ""));
                this.contextManagerComponent.setTransitionToInclude(false);
            }
            GridHelper.setNewIdRange(iGridList2, rangeCounter, this.log);
            GridHelper.updateListModelTransaction(listModelApp, iGridList2, this, 5, 2, this.log);
        }
        this.findAndGrayoutEntryWithAppID(USER_SETTINGS_APP_ID);
        if (this.isLockingActive) {
            this.updateLockingStateInternal(true);
        }
        return iGridList2 != null && !iGridList2.isEmpty();
    }

    private void findAndGrayoutEntryWithAppID(String string) {
        this.log.log(1000000, "RightDrawerHandler#findAndGrayoutEntryWithAppID: app id = '%1'", (Object)string);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByAppId(string);
        if (drawerEntry == null) {
            this.log.log(100000, "RightDrawerHandler#findAndGrayoutEntryWithAppID: couldn't find entry with app id '%1' so can't gray it out", (Object)string);
            return;
        }
        this.grayoutEntry(drawerEntry, "", !this.privacyModeIsActive);
    }

    public void updateLockingState(boolean bl) {
        this.isLockingActive = bl;
        this.updateLockingStateInternal(bl);
    }

    private void updateLockingStateInternal(boolean bl) {
        this.log.log(1000000, "RightDrawerHandler#updateLockingState: blocking: %1", bl);
        if (!this.isRightDrawerBlockingCoded(false) && !this.isRightDrawerBlockingCoded(true)) {
            this.log.log(1000000, "RightDrawerHandler#updateLockingState: blocking of right drawer entries is not coded.");
            return;
        }
        List list = this.rightDrawerTypes.findBlockableEntries();
        this.log.log(1000000, "RightDrawerHandler#updateLockingState: %1 blockable entries found.", (long)list.size());
        for (int i2 = 0; i2 < list.size(); ++i2) {
            DrawerEntry drawerEntry = (DrawerEntry)list.get(i2);
            boolean bl2 = bl;
            if (!this.isRightDrawerBlockingCoded(drawerEntry.isMediaContext())) {
                bl2 = false;
            }
            if (!drawerEntry.isEnabled()) {
                bl2 = true;
            }
            this.grayoutEntry(drawerEntry, bl2 ? drawerEntry.getInfoText() : "", !bl2);
        }
    }

    private boolean isRightDrawerBlockingCoded(boolean bl) {
        ChoiceModelApp choiceModelApp = null;
        if (bl) {
            choiceModelApp = this.modelBankAccess.getChoiceModel(5597);
            this.log.log(10000000, "RightDrawerHandler#isRightDrawerBlockingCoded: Using media bit.");
        } else {
            choiceModelApp = this.modelBankAccess.getChoiceModel(5601);
            this.log.log(10000000, "RightDrawerHandler#isRightDrawerBlockingCoded: Using misc bit.");
        }
        boolean bl2 = false;
        if (choiceModelApp != null) {
            bl2 = choiceModelApp.getValue() == 1;
        } else {
            this.log.log(10000, "RightDrawerHandler#isRightDrawerBlockingCoded: Drawer blocking bit model is null!");
        }
        this.log.log(1000000, "RightDrawerHandler#isRightDrawerBlockingCoded: blocking: %1", bl2);
        return bl2;
    }

    private void storeTemporaryHeldRightDrawerdata(List list, RangeCounter rangeCounter, IGrid iGrid, IGridList iGridList) {
        this.log.log(10000000, "RightDrawerHandler#storeTemporaryHeldRightDrawerdata: data is stored. screen types: %1", (Object)list);
        this.storedViewDataTypes = list;
        this.storedRangeCounter = rangeCounter;
        this.storedParentGrid = iGrid;
        this.storedMainGridList = iGridList;
    }

    private boolean isListModelConsistent(IGridList iGridList, ListModelApp listModelApp) {
        if (listModelApp.getLength() == 0) {
            this.log.log(10000000, "RightDrawerHandler#isListModelConsistent: rightDrawerListModel is 0");
            return false;
        }
        ListCell listCell = listModelApp.getCell(0, 0);
        if (!(listCell instanceof ObjectListCell)) {
            this.log.log(100000, "RightDrawerHandler#isListModelConsistent: modelCell is not instance of ObjectListCell");
            return false;
        }
        ObjectListCell objectListCell = (ObjectListCell)listCell;
        Object object = objectListCell.getValue();
        if (!(object instanceof IGridList)) {
            this.log.log(100000, "RightDrawerHandler#isListModelConsistent: value is not instance of IGridList");
            return false;
        }
        IGridList iGridList2 = (IGridList)object;
        if (iGridList2.getIdRangeStart() != iGridList.getIdRangeStart()) {
            this.log.log(10000000, "RightDrawerHandler#isListModelConsistent: IdRange start doesn't match [%1 != %2]", (long)iGridList2.getIdRangeStart(), (long)iGridList.getIdRangeStart());
            return false;
        }
        if (iGridList2.size() != iGridList.size()) {
            this.log.log(10000000, "RightDrawerHandler#isListModelConsistent: size doesn't match");
            return false;
        }
        this.log.log(10000000, "RightDrawerHandler#isListModelConsistent: currentRightDrawerList and rightDrawerListModel are consistent");
        return true;
    }

    public ListModelApp getRightDrawerListModel() {
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(2300989);
        if (choiceModelApp.getValue() == 0) {
            this.log.log(1000000, "RightDrawerHandler#getRightDrawerListModel: REMOTE_HMI_RIGHT_DRAWER_LIST is used");
            return this.modelBankAccess.getListModel(2300696);
        }
        this.log.log(1000000, "RightDrawerHandler#getRightDrawerListModel: REMOTE_HMI_RIGHT_DRAWER_OPTIONS_LIST is used");
        return this.modelBankAccess.getListModel(2300998);
    }

    public void updateProfileInfo(boolean bl, RangeCounter rangeCounter) {
        this.log.log(1000000, "RightDrawerHandler#updateProfileInfo: called");
        ListModelApp listModelApp = this.getRightDrawerListModel();
        RightDrawerEntriesContainer rightDrawerEntriesContainer = this.getRightDrawerEntries(null, rangeCounter);
        if (rightDrawerEntriesContainer == null) {
            this.log.log(100000, "RightDrawerHandler#updateProfileInfo: rightDrawerEntriesContainer is null so can't update right drawer");
            return;
        }
        IGridList iGridList = rightDrawerEntriesContainer.gridList;
        this.replaceTextConstants(iGridList);
        GridHelper.setNewIdRange(iGridList, rangeCounter, this.log);
        GridHelper.updateListModelTransaction(listModelApp, iGridList, this, 5, 9, this.log);
    }

    private void replaceTextConstants(IGridList iGridList) {
        iGridList.replaceTextConstants("{login:", new ITextConstantsConverter(){

            public String getText(String string) {
                I18NTextComponent i18NTextComponent = (I18NTextComponent)RightDrawerHandler.this.remoteHMIService.getI18NTextComponent();
                PortalAuthenticationService portalAuthenticationService = RightDrawerHandler.this.remoteHMIService.getAuthenticationService();
                if (portalAuthenticationService == null) {
                    return i18NTextComponent.getText(TextConstantUtil.REMOTEHMI_TEXT_LOGIN);
                }
                boolean bl = RightDrawerHandler.this.remoteHMIService.getAuthenticationService().isAuthenticated();
                String string2 = bl ? TextConstantUtil.REMOTEHMI_TEXT_LOGOFF : TextConstantUtil.REMOTEHMI_TEXT_LOGIN;
                return i18NTextComponent.getText(string2);
            }
        });
    }

    public void removeXmlEntries() {
        this.log.log(1000000, "RightDrawerHandler#removeXmlEntries: called");
        IGridFactory iGridFactory = this.remoteHMIService.getGridFactory();
        if (iGridFactory == null) {
            this.log.log(100000, "RightDrawerHandler#removeXmlEntries: gridFactory is null");
            return;
        }
        ListModelApp listModelApp = this.modelBankAccess.getListModel(2300696);
        ListModelApp listModelApp2 = this.modelBankAccess.getListModel(2300998);
        IGridList iGridList = iGridFactory.createGridList(0);
        GridHelper.setNewIdRange(iGridList, AbstractHMIViewListenerEvo.getRangeCounter(), this.log);
        iGridList.setCurrentCursor(iGridFactory.createCursor());
        iGridList.setRightDrawerAvailable(false);
        GridHelper.updateListModelTransaction(listModelApp, iGridList, this, 5, 2, this.log);
        GridHelper.updateListModelTransaction(listModelApp2, iGridList, this, 5, 2, this.log);
    }

    public void reinitRightDrawer() {
        this.log.log(1000000, "RightDrawerHandler#reinitRightDrawer: called");
        this.typesCurrentContext = new HashMap();
        this.menuSpecificEntries = new HashMap();
        this.removeXmlEntries();
    }

    public void resetPreviouslySelectedDrawerEntry() {
        this.log.log(1000000, "RightDrawerHandler#resetPreviouslySelectedDrawerEntry: called");
        this.previouslySelectedDrawerEntry = null;
    }

    public void setRightDrawerForContext(String string) {
        if (this.payloadLastRecieved == null) {
            this.log.log(1000000, "RightDrawerHandler#setRightDrawerForContext: no last recieved drawer configuration exists");
            return;
        }
        if (!string.equals(this.payloadLastRecieved.getContextName())) {
            this.log.log(1000000, "RightDrawerHandler#setRightDrawerForContext: no last recieved drawer configuration exists for context '%1'", (Object)string);
            return;
        }
        this.log.log(1000000, "RightDrawerHandler#setRightDrawerForContext: set last recieved drawer configuration for context '%1'", (Object)string);
        this.rightDrawerTypes.setRightDrawerTypes(this.payloadLastRecieved);
        this.payloadLastRecieved = null;
    }

    public String printCurrentTypes() {
        if (this.typesCurrentContext == null || this.typesCurrentContext.isEmpty()) {
            return new StringBuffer().append("No drawer information for context ").append(this.remoteHMIService.getContext().getContextName()).toString();
        }
        String string = "All TYPES FOR CURRENT CONTEXT \n";
        Iterator iterator = this.typesCurrentContext.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            List list = (List)this.typesCurrentContext.get(string2);
            string = new StringBuffer().append(string).append(this.printEntries(string2, list)).toString();
        }
        return string;
    }

    private String printEntries(String string, List list) {
        if (list == null) {
            return new StringBuffer().append("No entries for type ").append(string).toString();
        }
        String string2 = new StringBuffer().append("All ENTRIES FOR TYPE ").append(string).append("\n").toString();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry = (DrawerEntry)iterator.next();
            string2 = new StringBuffer().append(string2).append(drawerEntry.getEntryName()).append("\n").toString();
        }
        return string2;
    }

    private void grayoutEntry(DrawerEntry drawerEntry, String string, final boolean bl) {
        this.log.log(1000000, "RightDrawerHandler#grayoutEntry: drawerEntry id '%1', info %2, gray %3", (Object)drawerEntry.getEntryId(), (Object)string, (Object)Boolean.toString(bl));
        IGrid iGrid = drawerEntry.getWidgetGridForEntry();
        if (iGrid == null) {
            this.log.log(100000, "RightDrawerHandler#grayoutEntry: entryGrid is null for the entry to be grayed out so doing nothing");
            return;
        }
        IGridCellAction iGridCellAction = new IGridCellAction(){

            public boolean modify(IGridCell iGridCell) {
                int n = iGridCell.getType();
                if (n == 0 || n == 5 || n == 4) {
                    iGridCell.setEnabled(bl);
                    return true;
                }
                return false;
            }
        };
        iGrid.setInfoText(string);
        int n = iGrid.forEachCell(iGridCellAction, Integer.MAX_VALUE);
        this.log.log(1000000, "RightDrawerHandler#grayoutEntry: number of modified cells are '%1'", (long)n);
        if (this.currentGridList != null) {
            GridHelper.updateListModelTransaction(this.getRightDrawerListModel(), this.currentGridList, this, 3, 2, this.log);
        }
    }

    public void togglePrivacyMode(boolean bl) {
        this.privacyModeIsActive = bl;
    }

    private static final class RightDrawerEntriesContainer {
        public IGridList gridList;
        public boolean wasUpdated = false;

        public RightDrawerEntriesContainer(IGridList iGridList, boolean bl) {
            this.gridList = iGridList;
            this.wasUpdated = bl;
        }
    }
}

