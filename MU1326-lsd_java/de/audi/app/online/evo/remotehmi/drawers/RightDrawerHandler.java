/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$1;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$2;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$3;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$4;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$5;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$6;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$7;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$8;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$9;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler$RightDrawerEntriesContainer;
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
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.Commands$RightDrawerPayload;
import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.GridHelper;
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
    private static final String USER_SETTINGS_APP_ID;
    private final RemoteHMIServiceEvo remoteHMIService;
    final LogChannel log;
    private IGridList currentGridList;
    private List currentTypes = null;
    private String currentlySelectedLeftDrawerEntry;
    private Commands$RightDrawerPayload payloadLastRecieved = null;
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

    protected RightDrawerHandler(LogChannel logChannel, RemoteHMIServiceEvo remoteHMIServiceEvo, boolean bl) {
        this.log = logChannel;
        this.remoteHMIService = remoteHMIServiceEvo;
        this.contextManagerComponent = remoteHMIServiceEvo.getContextManagerComponent();
        this.modelBankAccess = remoteHMIServiceEvo.getModelBankAccess();
        this.rightDrawerTypes = new RightDrawerTypes(this, logChannel, remoteHMIServiceEvo.getLeftDrawerHandler());
        if (bl) {
            return;
        }
        remoteHMIServiceEvo.addCommandHandler(-2104059904, new RightDrawerHandler$1(this, "right-drawer", logChannel, remoteHMIServiceEvo));
        remoteHMIServiceEvo.addCommandHandler(-2036951040, new RightDrawerHandler$2(this, "update-right-drawer-state", logChannel));
        remoteHMIServiceEvo.addCommandHandler(333575429, new RightDrawerHandler$3(this, "grayout-right-drawer-entry", logChannel));
        remoteHMIServiceEvo.addCommandHandler(266466565, new RightDrawerHandler$4(this, "close-right-drawer", logChannel));
        remoteHMIServiceEvo.addCommandHandler(300020997, new RightDrawerHandler$5(this, "update-right-drawer-top-wizard", logChannel));
        ChoiceModelApp choiceModelApp = remoteHMIServiceEvo.getFrameworkAccess().getHMIService().getChoiceModel(2048664320);
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

    private RightDrawerHandler$RightDrawerEntriesContainer getRightDrawerEntries(List list, RangeCounter rangeCounter) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        Object object2;
        this.log.log(1078071040, "RightDrawerHandler#getRightDrawerEntries: Called for %1", (Object)list);
        IGridFactory iGridFactory = this.remoteHMIService.getGridFactory();
        if (iGridFactory == null) {
            this.log.log(-1601830656, "RightDrawerHandler#getRightDrawerEntries: gridFactory is null so can't update right drawer");
            return null;
        }
        String string = this.getConfigurationAsString(list, this.currentlySelectedLeftDrawerEntry);
        if (UtilOnline.areEqual(this.previousConfiguration, string)) {
            this.log.log(-2137614336, "RightDrawerHandler#getRightDrawerEntries: old and new configuration are same so no need to create new right drawer, instead use cashed one");
            return new RightDrawerHandler$RightDrawerEntriesContainer(this.currentGridList, false);
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
            this.log.log(-2137614336, "RightDrawerHandler#getRightDrawerEntries: No global, menu specific and type specific right drawer entries for %1 found", (Object)list);
            this.currentGridList = iGridFactory.createGridList(0);
            return new RightDrawerHandler$RightDrawerEntriesContainer(this.currentGridList, true);
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
        this.log.log(-2137614336, "RightDrawerHandler#getRightDrawerEntries: Number of entries returned for types %1 are : %2", (Object)this.currentTypes, (long)iGridList.size());
        if (this.previouslySelectedDrawerEntry != null && (n = arrayList.indexOf(this.previouslySelectedDrawerEntry)) != -1) {
            this.log.log(-2137614336, "RightDrawerHandler#getRightDrawerEntries: setting current cursor to index %1", (long)n);
            ICursor iCursor = this.remoteHMIService.getGridFactory().createCursor().withFocus(n, -1, null, null);
            iGridList.setCurrentCursor(iCursor);
        }
        return new RightDrawerHandler$RightDrawerEntriesContainer(iGridList, true);
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

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "RightDrawerHandler#itemSelected: callback from dropDownList: modelID=%1, itemID=%2.", (long)n, (long)n2);
        this.remoteHMIService.execute(new RightDrawerHandler$6(this, "right-drawer-item-focused", LogAppender$Factory.fromInt(n, "widgetId"), n, n2));
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(1078071040, "RightDrawerHandler#keyPressed: callback from menuItem button: modelID=%1, keyID=%2", (long)n, (long)n2);
        this.invokeAction(n, 0);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.log.log(1078071040, "RightDrawerHandler#itemFocused: callback from menu: menuItemID=%1, modelID=%2, uniqueListRowID=%3.", (long)n, (long)n2, l);
        this.remoteHMIService.execute(new RightDrawerHandler$7(this, "right-drawer-item-focused", LogAppender$Factory.fromInt(n, "widgetId"), n));
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "RightDrawerHandler#itemFocused: callback with modelID=%1, row=%2", (long)n, (long)n2);
    }

    protected void setMenuSpecificEntries(String string, Map map) {
        this.log.log(1078071040, "RightDrawerHandler#setMenuSpecificEntries: Size of menu specific entries for context name : '%1' is %2", (Object)string, (long)map.size());
        this.menuSpecificEntries = map;
    }

    private void findAndUpdateEntry(String string, String string2, String string3) {
        this.log.log(1078071040, "RightDrawerHandler#updateApplication: entry id '%1' having value '%2' for context name '%3'", (Object)string, (Object)string2, (Object)string3);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByEntryId(string);
        if (drawerEntry == null) {
            this.log.log(-1601830656, "RightDrawerHandler#updateApplication: couldn't find entry with entryid '%1' so can't update", (Object)string);
            return;
        }
        this.updateValueForEntry(string2, drawerEntry);
    }

    private void findAndGrayoutEntry(String string, String string2, String string3) {
        this.log.log(1078071040, "RightDrawerHandler#findAndGrayoutEntry: entry id = '%1', info text = '%2' for context name '%3'", (Object)string, (Object)string2, (Object)string3);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByEntryId(string);
        if (drawerEntry == null) {
            this.log.log(-1601830656, "RightDrawerHandler#findAndGrayoutEntry: couldn't find entry with entryid '%1' so can't gray it out", (Object)string);
            return;
        }
        this.grayoutEntry(drawerEntry, string2, false);
    }

    protected void closeRightDrawer(String string) {
        this.log.log(1078071040, "RightDrawerHandler#closeRightDrawer: Closing right drawer for context name '%1'", (Object)string);
        Online online = Online.getInstance();
        HMIService hMIService = online.getFramework().getHMIService();
        DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 2);
        hMIService.getEventDispatcher().postEvent(drawerEvent);
    }

    void loadRightDrawerForSpecificContext() {
        this.log.log(1078071040, "RightDrawerHandler#loadRightDrawerForSpecificContext: called");
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
            this.log.log(-1601830656, "RightDrawerHandler#invokeAction: current context is null. Can't pass action to south side");
            return;
        }
        IGridList iGridList = this.currentGridList;
        if (iGridList == null) {
            this.log.log(1078071040, "RightDrawerHandler#invokeAction: current gridList is null. Try to restore previously loaded data.");
            this.updateRightDrawer(this.storedViewDataTypes, this.storedRangeCounter, this.storedParentGrid, this.storedMainGridList);
            if (this.currentGridList != null) {
                iGridList = this.currentGridList;
            } else {
                this.log.log(-1601830656, "RightDrawerHandler#invokeAction: current gridList is null. Can't pass action to south side");
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
            this.log.log(-1601830656, "RightDrawerHandler#invokeAction: event of old list will be ignored: widgetId = '%1' and grid list content is '%2'", (Object)new Integer(n), (Object)iGridList);
            return;
        }
        IGridCell iGridCell = iGrid.getFirstCell(0);
        if (iGridCell != null && !iGridCell.isEnabled()) {
            this.log.log(1078071040, "RightDrawerHandler#invokeAction: selected entry is disabled so doing nothing");
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
            this.log.log(1078071040, "RightDrawerHandler#invokeAction: selected entry is null and grid list context is '%2'", iGridList.getLogObject(0));
            return;
        }
        int n4 = drawerEntry.getWidgetType();
        if (n4 == 1) {
            this.closeRightDrawer(remoteHMIContext.getContextName());
        }
        if ((n4 == 3 || n4 == 5) && drawerEntry.getEntryId().equals("")) {
            this.log.log(-1601830656, "RightDrawerHandler#invokeAction: Selected entry is of type dropdown or checkbox and there is no entry id so can not perform action");
            return;
        }
        this.log.log(1078071040, "RightDrawerHandler#invokeAction: Action to be invoked for entry '%1' of widget type '%2'", (Object)drawerEntry.getEntryName(), (long)n4);
        if (remoteHMIContext.getContextName().equals("top_wizard")) {
            if (drawerEntry.getEvent() != null) {
                this.triggerEvent(string3, drawerEntry, n2, bl, string, n3);
            } else {
                ContextManagerComponent contextManagerComponent = this.remoteHMIService.getContextManagerComponent();
                EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
                contextManagerComponent.setWaitForApplicationValue(1);
                entryPoint.setNameOfContextToBeStarted(drawerEntry.getEntryContext());
                RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(1754961920);
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
            this.log.log(-1601830656, "RightDrawerHandler#invokeActionInRemoteHMIService: RemoteHMIAction is null");
            return;
        }
        this.log.log(1078071040, "RightDrawerHandler#invokeActionInRemoteHMIService: called for action '%1'", (long)remoteHMIAction.getType());
        RemoteHMIContext remoteHMIContext = this.remoteHMIService.getContext();
        if (remoteHMIContext != null) {
            remoteHMIContext.setLastAction(remoteHMIAction);
        }
        this.remoteHMIService.invokeAction(remoteHMIAction);
    }

    private void triggerEvent(String string, DrawerEntry drawerEntry, int n, boolean bl, String string2, int n2) {
        this.log.log(1078071040, "RightDrawerHandler#triggerEvent: Trigger event for entry name '%1' associated with type '%2', parent grid id '%3', parent grid index '%4'", (Object)drawerEntry.getEntryName(), (Object)string, (Object)string2, (long)n2);
        RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(-2104059904);
        remoteHMIAction.getParameters().putString("selectedId", drawerEntry.getEntryId());
        remoteHMIAction.getParameters().putInt("selectedDropdownIndex", n);
        remoteHMIAction.getParameters().putString("gridId", string2);
        remoteHMIAction.getParameters().putInt("gridIndex", n2);
        remoteHMIAction.getParameters().put("onlineEntryType", string);
        remoteHMIAction.getParameters().putBoolean("entryMenuSpecific", bl);
        if (drawerEntry.getWidgetType() == 3) {
            remoteHMIAction.getParameters().putBoolean("checkboxValue", drawerEntry.getCheckboxValue());
            this.log.log(1078071040, "RightDrawerHandler#triggerEvent: Trigger event for entry name '%1' and checkbox value '%2'", (Object)drawerEntry.getEntryName(), (Object)Boolean.toString(drawerEntry.getCheckboxValue()));
        }
        this.invokeActionInRemoteHMIService(remoteHMIAction);
    }

    private void updateValueForEntry(String string, DrawerEntry drawerEntry) {
        this.log.log(1078071040, "RightDrawerHandler#updateValueForEntry: called for entryToBeUpdated with id '%1' and new value '%2'", (Object)drawerEntry.getEntryId(), (Object)string);
        IGrid iGrid = drawerEntry.getWidgetGridForEntry();
        if (iGrid == null) {
            this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: entryGrid is null for the entry to be updated");
            return;
        }
        IGridCell iGridCell = (IGridCell)iGrid.get(1);
        int n = drawerEntry.getWidgetType();
        if (n == 3) {
            boolean bl = UtilOnline.getSafeBoolean(this.log, string, false);
            if (iGridCell == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: Widget type is checkbox and gridcell is null");
                return;
            }
            iGridCell.setBooleanValue(bl);
            drawerEntry.setCheckboxValue(bl);
            this.log.log(-2137614336, "RightDrawerHandler#updateValueForEntry: checkbox entry updated");
        } else if (n == 5) {
            int n2 = UtilOnline.getSafeInt(this.log, string, 0);
            if (iGridCell == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: Widget type is dropdown and gridcell is null");
                return;
            }
            IGridList iGridList = iGridCell.getListValue();
            if (iGridList == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: Widget type is dropdown and childGridList is null");
                return;
            }
            iGridList.setCurrentSelection(n2, -1, "", "");
            drawerEntry.setDefaultSelection(n2);
            this.log.log(-2137614336, "RightDrawerHandler#updateValueForEntry: dropdown entry updated");
        } else if (n == 4) {
            IGridCell iGridCell2 = iGrid.getFirstCell(12);
            if (iGridCell2 == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: subGridContainer null");
                return;
            }
            IGrid iGrid2 = iGridCell2.getGridValue();
            if (iGrid2 == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: subGrid null");
                return;
            }
            IGridCell iGridCell3 = iGrid2.getFirstCell(0);
            if (iGridCell3 == null) {
                this.log.log(-1601830656, "RightDrawerHandler#updateValueForEntry: submenuCell null");
                return;
            }
            iGridCell3.setStringValue(string);
            drawerEntry.setInputFieldText(string);
            this.log.log(-2137614336, "RightDrawerHandler#updateValueForEntry: submenu preview entry updated");
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
        this.log.log(-2137614336, "RightDrawerHandler#updateRightDrawer: right drawer index is '%1'", (long)n);
        ListModelApp listModelApp = this.getRightDrawerListModel();
        RightDrawerHandler$RightDrawerEntriesContainer rightDrawerHandler$RightDrawerEntriesContainer = this.getRightDrawerEntries(list, rangeCounter);
        if (rightDrawerHandler$RightDrawerEntriesContainer == null) {
            this.log.log(-1601830656, "RightDrawerHandler#updateRightDrawer: rightDrawerEntriesContainer is null so can't update right drawer");
            return false;
        }
        IGridList iGridList2 = rightDrawerHandler$RightDrawerEntriesContainer.gridList;
        if (iGridList2 == null) {
            this.log.log(-1601830656, "RightDrawerHandler#updateRightDrawer: rightDrawerList is null so can't update right drawer");
            return false;
        }
        iGridList2.setParentGrid(iGrid);
        RemoteHMIContext remoteHMIContext2 = remoteHMIContext = this.contextManagerComponent == null ? null : this.contextManagerComponent.getCurrentContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName() == "top_wizard") {
            this.replaceTextConstants(iGridList2);
        }
        if (!rightDrawerHandler$RightDrawerEntriesContainer.wasUpdated && this.isListModelConsistent(iGridList2, listModelApp)) {
            this.log.log(1078071040, "RightDrawerHandler#updateRightDrawer: Using cached grid list: %1 with focus %2", iGridList2.getLogObject(0), (Object)iGridList2.getCurrentCursor().getFocus());
        } else {
            this.log.log(1078071040, "RightDrawerHandler#updateRightDrawer: grid list: %1 created with current focus %1", iGridList2.getLogObject(0), (Object)iGridList2.getCurrentCursor().getFocus());
            if (this.contextManagerComponent != null && this.contextManagerComponent.isTransitionToInclude() && n < iGridList2.size()) {
                this.log.log(-2137614336, "RightDrawerHandler#updateRightDrawer: HK Return is pressed from an include state and right index is set to old index which is '%1'", (long)n);
                ICursorComponent iCursorComponent = iGridList2.getCurrentCursor().getFocus();
                iGridList2.setCurrentFocus(iCursorComponent.withValues(n, -1, "", ""));
                this.contextManagerComponent.setTransitionToInclude(false);
            }
            GridHelper.setNewIdRange(iGridList2, rangeCounter, this.log);
            GridHelper.updateListModelTransaction(listModelApp, iGridList2, this, 5, 2, this.log);
        }
        this.findAndGrayoutEntryWithAppID("userSettings");
        if (this.isLockingActive) {
            this.updateLockingStateInternal(true);
        }
        return iGridList2 != null && !iGridList2.isEmpty();
    }

    private void findAndGrayoutEntryWithAppID(String string) {
        this.log.log(1078071040, "RightDrawerHandler#findAndGrayoutEntryWithAppID: app id = '%1'", (Object)string);
        DrawerEntry drawerEntry = this.rightDrawerTypes.findEntryByAppId(string);
        if (drawerEntry == null) {
            this.log.log(-1601830656, "RightDrawerHandler#findAndGrayoutEntryWithAppID: couldn't find entry with app id '%1' so can't gray it out", (Object)string);
            return;
        }
        this.grayoutEntry(drawerEntry, "", !this.privacyModeIsActive);
    }

    public void updateLockingState(boolean bl) {
        this.isLockingActive = bl;
        this.updateLockingStateInternal(bl);
    }

    private void updateLockingStateInternal(boolean bl) {
        this.log.log(1078071040, "RightDrawerHandler#updateLockingState: blocking: %1", bl);
        if (!this.isRightDrawerBlockingCoded(false) && !this.isRightDrawerBlockingCoded(true)) {
            this.log.log(1078071040, "RightDrawerHandler#updateLockingState: blocking of right drawer entries is not coded.");
            return;
        }
        List list = this.rightDrawerTypes.findBlockableEntries();
        this.log.log(1078071040, "RightDrawerHandler#updateLockingState: %1 blockable entries found.", (long)list.size());
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
            this.log.log(-2137614336, "RightDrawerHandler#isRightDrawerBlockingCoded: Using media bit.");
        } else {
            choiceModelApp = this.modelBankAccess.getChoiceModel(5601);
            this.log.log(-2137614336, "RightDrawerHandler#isRightDrawerBlockingCoded: Using misc bit.");
        }
        boolean bl2 = false;
        if (choiceModelApp != null) {
            bl2 = choiceModelApp.getValue() == 1;
        } else {
            this.log.log(10000, "RightDrawerHandler#isRightDrawerBlockingCoded: Drawer blocking bit model is null!");
        }
        this.log.log(1078071040, "RightDrawerHandler#isRightDrawerBlockingCoded: blocking: %1", bl2);
        return bl2;
    }

    private void storeTemporaryHeldRightDrawerdata(List list, RangeCounter rangeCounter, IGrid iGrid, IGridList iGridList) {
        this.log.log(-2137614336, "RightDrawerHandler#storeTemporaryHeldRightDrawerdata: data is stored. screen types: %1", (Object)list);
        this.storedViewDataTypes = list;
        this.storedRangeCounter = rangeCounter;
        this.storedParentGrid = iGrid;
        this.storedMainGridList = iGridList;
    }

    private boolean isListModelConsistent(IGridList iGridList, ListModelApp listModelApp) {
        if (listModelApp.getLength() == 0) {
            this.log.log(-2137614336, "RightDrawerHandler#isListModelConsistent: rightDrawerListModel is 0");
            return false;
        }
        ListCell listCell = listModelApp.getCell(0, 0);
        if (!(listCell instanceof ObjectListCell)) {
            this.log.log(-1601830656, "RightDrawerHandler#isListModelConsistent: modelCell is not instance of ObjectListCell");
            return false;
        }
        ObjectListCell objectListCell = (ObjectListCell)listCell;
        Object object = objectListCell.getValue();
        if (!(object instanceof IGridList)) {
            this.log.log(-1601830656, "RightDrawerHandler#isListModelConsistent: value is not instance of IGridList");
            return false;
        }
        IGridList iGridList2 = (IGridList)object;
        if (iGridList2.getIdRangeStart() != iGridList.getIdRangeStart()) {
            this.log.log(-2137614336, "RightDrawerHandler#isListModelConsistent: IdRange start doesn't match [%1 != %2]", (long)iGridList2.getIdRangeStart(), (long)iGridList.getIdRangeStart());
            return false;
        }
        if (iGridList2.size() != iGridList.size()) {
            this.log.log(-2137614336, "RightDrawerHandler#isListModelConsistent: size doesn't match");
            return false;
        }
        this.log.log(-2137614336, "RightDrawerHandler#isListModelConsistent: currentRightDrawerList and rightDrawerListModel are consistent");
        return true;
    }

    public ListModelApp getRightDrawerListModel() {
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(1025254144);
        if (choiceModelApp.getValue() == 0) {
            this.log.log(1078071040, "RightDrawerHandler#getRightDrawerListModel: REMOTE_HMI_RIGHT_DRAWER_LIST is used");
            return this.modelBankAccess.getListModel(404431616);
        }
        this.log.log(1078071040, "RightDrawerHandler#getRightDrawerListModel: REMOTE_HMI_RIGHT_DRAWER_OPTIONS_LIST is used");
        return this.modelBankAccess.getListModel(1176249088);
    }

    public void updateProfileInfo(boolean bl, RangeCounter rangeCounter) {
        this.log.log(1078071040, "RightDrawerHandler#updateProfileInfo: called");
        ListModelApp listModelApp = this.getRightDrawerListModel();
        RightDrawerHandler$RightDrawerEntriesContainer rightDrawerHandler$RightDrawerEntriesContainer = this.getRightDrawerEntries(null, rangeCounter);
        if (rightDrawerHandler$RightDrawerEntriesContainer == null) {
            this.log.log(-1601830656, "RightDrawerHandler#updateProfileInfo: rightDrawerEntriesContainer is null so can't update right drawer");
            return;
        }
        IGridList iGridList = rightDrawerHandler$RightDrawerEntriesContainer.gridList;
        this.replaceTextConstants(iGridList);
        GridHelper.setNewIdRange(iGridList, rangeCounter, this.log);
        GridHelper.updateListModelTransaction(listModelApp, iGridList, this, 5, 9, this.log);
    }

    private void replaceTextConstants(IGridList iGridList) {
        iGridList.replaceTextConstants("{login:", new RightDrawerHandler$8(this));
    }

    public void removeXmlEntries() {
        this.log.log(1078071040, "RightDrawerHandler#removeXmlEntries: called");
        IGridFactory iGridFactory = this.remoteHMIService.getGridFactory();
        if (iGridFactory == null) {
            this.log.log(-1601830656, "RightDrawerHandler#removeXmlEntries: gridFactory is null");
            return;
        }
        ListModelApp listModelApp = this.modelBankAccess.getListModel(404431616);
        ListModelApp listModelApp2 = this.modelBankAccess.getListModel(1176249088);
        IGridList iGridList = iGridFactory.createGridList(0);
        GridHelper.setNewIdRange(iGridList, AbstractHMIViewListenerEvo.getRangeCounter(), this.log);
        iGridList.setCurrentCursor(iGridFactory.createCursor());
        iGridList.setRightDrawerAvailable(false);
        GridHelper.updateListModelTransaction(listModelApp, iGridList, this, 5, 2, this.log);
        GridHelper.updateListModelTransaction(listModelApp2, iGridList, this, 5, 2, this.log);
    }

    public void reinitRightDrawer() {
        this.log.log(1078071040, "RightDrawerHandler#reinitRightDrawer: called");
        this.typesCurrentContext = new HashMap();
        this.menuSpecificEntries = new HashMap();
        this.removeXmlEntries();
    }

    public void resetPreviouslySelectedDrawerEntry() {
        this.log.log(1078071040, "RightDrawerHandler#resetPreviouslySelectedDrawerEntry: called");
        this.previouslySelectedDrawerEntry = null;
    }

    public void setRightDrawerForContext(String string) {
        if (this.payloadLastRecieved == null) {
            this.log.log(1078071040, "RightDrawerHandler#setRightDrawerForContext: no last recieved drawer configuration exists");
            return;
        }
        if (!string.equals(this.payloadLastRecieved.getContextName())) {
            this.log.log(1078071040, "RightDrawerHandler#setRightDrawerForContext: no last recieved drawer configuration exists for context '%1'", (Object)string);
            return;
        }
        this.log.log(1078071040, "RightDrawerHandler#setRightDrawerForContext: set last recieved drawer configuration for context '%1'", (Object)string);
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

    private void grayoutEntry(DrawerEntry drawerEntry, String string, boolean bl) {
        this.log.log(1078071040, "RightDrawerHandler#grayoutEntry: drawerEntry id '%1', info %2, gray %3", (Object)drawerEntry.getEntryId(), (Object)string, (Object)Boolean.toString(bl));
        IGrid iGrid = drawerEntry.getWidgetGridForEntry();
        if (iGrid == null) {
            this.log.log(-1601830656, "RightDrawerHandler#grayoutEntry: entryGrid is null for the entry to be grayed out so doing nothing");
            return;
        }
        RightDrawerHandler$9 rightDrawerHandler$9 = new RightDrawerHandler$9(this, bl);
        iGrid.setInfoText(string);
        int n = iGrid.forEachCell(rightDrawerHandler$9, -129);
        this.log.log(1078071040, "RightDrawerHandler#grayoutEntry: number of modified cells are '%1'", (long)n);
        if (this.currentGridList != null) {
            GridHelper.updateListModelTransaction(this.getRightDrawerListModel(), this.currentGridList, this, 3, 2, this.log);
        }
    }

    public void togglePrivacyMode(boolean bl) {
        this.privacyModeIsActive = bl;
    }

    static /* synthetic */ RightDrawerTypes access$000(RightDrawerHandler rightDrawerHandler) {
        return rightDrawerHandler.rightDrawerTypes;
    }

    static /* synthetic */ Commands$RightDrawerPayload access$102(RightDrawerHandler rightDrawerHandler, Commands$RightDrawerPayload commands$RightDrawerPayload) {
        rightDrawerHandler.payloadLastRecieved = commands$RightDrawerPayload;
        return rightDrawerHandler.payloadLastRecieved;
    }

    static /* synthetic */ void access$200(RightDrawerHandler rightDrawerHandler, String string, String string2, String string3) {
        rightDrawerHandler.findAndUpdateEntry(string, string2, string3);
    }

    static /* synthetic */ void access$300(RightDrawerHandler rightDrawerHandler, String string, String string2, String string3) {
        rightDrawerHandler.findAndGrayoutEntry(string, string2, string3);
    }

    static /* synthetic */ ContextManagerComponent access$400(RightDrawerHandler rightDrawerHandler) {
        return rightDrawerHandler.contextManagerComponent;
    }

    static /* synthetic */ DrawerEntry access$502(RightDrawerHandler rightDrawerHandler, DrawerEntry drawerEntry) {
        rightDrawerHandler.previouslySelectedDrawerEntry = drawerEntry;
        return rightDrawerHandler.previouslySelectedDrawerEntry;
    }

    static /* synthetic */ void access$600(RightDrawerHandler rightDrawerHandler, int n, int n2) {
        rightDrawerHandler.invokeAction(n, n2);
    }

    static /* synthetic */ IGridList access$700(RightDrawerHandler rightDrawerHandler) {
        return rightDrawerHandler.mainGridList;
    }

    static /* synthetic */ IGridList access$800(RightDrawerHandler rightDrawerHandler) {
        return rightDrawerHandler.currentGridList;
    }

    static /* synthetic */ RemoteHMIServiceEvo access$900(RightDrawerHandler rightDrawerHandler) {
        return rightDrawerHandler.remoteHMIService;
    }
}

