/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.Commands;
import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.DrawerEntryIcon;
import de.audi.remotehmi.ui.mib2.DrawerEntryLeftDrawer;
import de.audi.remotehmi.ui.mib2.MenuEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeftDrawerHandler
implements BaseListModelListener {
    final int MAX_COLUMNS_DRAWER;
    final int COLUMN_ID;
    final int COLUMN_RECORDSET;
    final int COLUMN_TEXT;
    final int COLUMN_IMAGE;
    final int COLUMN_REFLECTION_IMAGE;
    public static final int LEFT_DRAWER_AVAILABLE = 0;
    public static final int LEFT_DRAWER_NOT_AVAILABLE = 1;
    public static final int INDEX_OR_ID_NONE = -1;
    private Map listModelValues;
    private Map currentSubListModelValues;
    private Map subEntriesForAllEntries;
    private List menuEntries = new ArrayList();
    private final RemoteHMIService remoteHMIService;
    private final HMIService hmiService;
    private final LogChannel log;
    private final ContextManagerComponent contextManagerComponent;
    private Commands.LeftDrawerPayload payloadLastRecieved = null;
    private static int TOP_WIZARD_HOME = 0;
    private static int TOP_WIZARD_INFORMATION = 1;
    private static int TOP_WIZARD_NAVIGATION = 2;
    private static int TOP_WIZARD_ENTERTAINTMENT = 3;
    private static int TOP_WIZARD_COMMUNICATION = 4;
    private static int TOP_WIZARD_CARREMOTE = 5;
    private static Map topWizardIcons = new HashMap(){
        private static final long serialVersionUID = -1111848786856739068L;
        {
            this.put("top_wizard.home", new Integer(TOP_WIZARD_HOME));
            this.put("top_wizard.information", new Integer(TOP_WIZARD_INFORMATION));
            this.put("top_wizard.navigation", new Integer(TOP_WIZARD_NAVIGATION));
            this.put("top_wizard.entertainment", new Integer(TOP_WIZARD_ENTERTAINTMENT));
            this.put("top_wizard.communication", new Integer(TOP_WIZARD_COMMUNICATION));
            this.put("top_wizard.carRemote", new Integer(TOP_WIZARD_CARREMOTE));
        }
    };

    public LeftDrawerHandler(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup) {
        this(logChannel, remoteHMIService, false, modelGroup);
    }

    protected LeftDrawerHandler(final LogChannel logChannel, final RemoteHMIService remoteHMIService, boolean bl, ModelGroup modelGroup) {
        this.MAX_COLUMNS_DRAWER = 5;
        this.COLUMN_ID = 0;
        this.COLUMN_RECORDSET = 1;
        this.COLUMN_TEXT = 2;
        this.COLUMN_IMAGE = 3;
        this.COLUMN_REFLECTION_IMAGE = 4;
        this.log = logChannel;
        this.remoteHMIService = remoteHMIService;
        this.hmiService = remoteHMIService.getFrameworkAccess().getHMIService();
        this.contextManagerComponent = remoteHMIService.getContextManagerComponent();
        if (bl) {
            return;
        }
        remoteHMIService.addCommandHandler(10000001, new AbstractCommandHandler("left-drawer"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.LeftDrawerPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "LeftDrawerHandler#indicateCommand: Commands.STATE_LEFT_DRAWER called");
                if (!(object instanceof Commands.LeftDrawerPayload)) {
                    logChannel.log(100000, "LeftDrawerPayload#indicateCommand: wrong payload provided");
                    return;
                }
                Commands.LeftDrawerPayload leftDrawerPayload = (Commands.LeftDrawerPayload)object;
                String string = leftDrawerPayload.getContextName();
                RemoteHMIContext remoteHMIContext = remoteHMIService.getContextManagerComponent().getCurrentContext();
                if (remoteHMIContext != null && remoteHMIContext.getContextName().equals(string)) {
                    LeftDrawerHandler.this.setMenuEntriesForContext(leftDrawerPayload);
                } else {
                    logChannel.log(10000000, "LeftDrawerPayload#indicateCommand: LeftDrawerPayload saved as payloadLastRecieved");
                    LeftDrawerHandler.this.payloadLastRecieved = leftDrawerPayload;
                }
            }
        });
        remoteHMIService.addCommandHandler(100000013, new AbstractCommandHandler("left-drawer-main-icon-update"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.LeftDrawerIconUpdatePayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                Commands.LeftDrawerIconUpdatePayload leftDrawerIconUpdatePayload = (Commands.LeftDrawerIconUpdatePayload)object;
                LeftDrawerHandler.this.updateListModelEntry(leftDrawerIconUpdatePayload.getDrawerEntry(), leftDrawerIconUpdatePayload.getUpdateType(), leftDrawerIconUpdatePayload.getContextName());
            }
        });
        remoteHMIService.addCommandHandler(0x989688, new AbstractCommandHandler("selected-left-drawer-entry"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.SelectedLeftDrawerEntryPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                Commands.SelectedLeftDrawerEntryPayload selectedLeftDrawerEntryPayload = (Commands.SelectedLeftDrawerEntryPayload)object;
                String string = selectedLeftDrawerEntryPayload.idValue;
                String string2 = selectedLeftDrawerEntryPayload.getContextName();
                logChannel.log(1000000, "LeftDrawerHandler#indicateCommand: Commands.STATE_SELECTED_LEFT_DRAWER_ENTRY and contextName '%1'", (Object)string2);
                DrawerEntryLeftDrawer drawerEntryLeftDrawer = LeftDrawerHandler.this.getDrawerEntryById(string);
                LeftDrawerHandler.this.setCurrentlySelectedLeftDrawerEntry(drawerEntryLeftDrawer, LeftDrawerHandler.this.contextManagerComponent.getContext(string2));
                remoteHMIService.flushModelGroup();
            }
        });
        remoteHMIService.addCommandHandler(100000010, new AbstractCommandHandler("selected-left-drawer-sub-entry"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString(((Commands.SelectedLeftDrawerSubEntryPayload)object).getContextName());
            }

            public void indicateCommand(int n, Object object) {
                Commands.SelectedLeftDrawerSubEntryPayload selectedLeftDrawerSubEntryPayload = (Commands.SelectedLeftDrawerSubEntryPayload)object;
                String string = selectedLeftDrawerSubEntryPayload.idValue;
                String string2 = selectedLeftDrawerSubEntryPayload.getContextName();
                logChannel.log(1000000, "LeftDrawerHandler#indicateCommand: Commands.STATE_SELECTED_LEFT_DRAWER_SUB_ENTRY and contextName '%1'", (Object)string2);
                LeftDrawerHandler.this.setCurrentlySelectedLeftDrawerSubEntry(string, LeftDrawerHandler.this.contextManagerComponent.getContext(string2));
            }
        });
        HMIService hMIService = remoteHMIService.getFrameworkAccess().getHMIService();
        hMIService.getBaseListModel(2300695).setListener(this);
        hMIService.getBaseListModel(2300976).setListener(this);
        modelGroup.add(hMIService.getBaseListModel(2300695));
        modelGroup.add(hMIService.getBaseListModel(2300976));
        modelGroup.add(hMIService.getResourceLocatorModel(2301032));
    }

    public void populateSubListAndSetSelection(RemoteHMIContext remoteHMIContext) {
        Object object;
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300695);
        BaseListModelApp baseListModelApp2 = this.hmiService.getBaseListModel(2300976);
        int n = this.getEntryIndex(remoteHMIContext.getCurrentlySelectedLeftDrawerEntryId(), this.listModelValues);
        if (baseListModelApp.getLength() == 0 || n == -1) {
            return;
        }
        this.populateSubListModel(baseListModelApp, baseListModelApp2, n, remoteHMIContext.getContextName());
        if (baseListModelApp2.getLength() == 0) {
            baseListModelApp.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            object = new DrawerEvent(this.hmiService.getRootWindow(0), 1);
            this.hmiService.getEventDispatcher().postEvent((ATIPEvent)object);
        }
        object = ((RemoteHMIServiceEvo)this.remoteHMIService).getRightDrawerHandler();
        ((RightDrawerHandler)object).setCurrentlySelectedLeftDrawerEntry(remoteHMIContext.getCurrentlySelectedLeftDrawerEntryId());
    }

    public List getMenuEntries() {
        return this.menuEntries;
    }

    public void itemSelected(final EvoListRow evoListRow, final int n, int n2, int n3, int n4) {
        this.remoteHMIService.execute(new AbstractRemoteHMITask("leftdrawer-item-selected"){

            public void run() {
                LeftDrawerHandler.this.invokeAction(evoListRow, n);
            }
        });
    }

    public Set getCurrentLeftDrawerEntriesIds() {
        return this.listModelValues.keySet();
    }

    public Set getCurrentLeftDrawerSubEntriesIds() {
        return this.currentSubListModelValues.keySet();
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    protected void setMenuEntriesForContext(Commands.LeftDrawerPayload leftDrawerPayload) {
        if (leftDrawerPayload == null) {
            this.log.log(100000, "LeftDrawerHandler#setMenuEntriesForContext: LeftDrawerPayload provided is null");
            return;
        }
        String string = leftDrawerPayload.getContextName();
        List list = leftDrawerPayload.leftDrawerEntriesList;
        List list2 = list == null ? Collections.EMPTY_LIST : list;
        this.log.log(1000000, "LeftDrawerHandler#setMenuEntriesForContext: Called for context name '%1' with number of menu entries '%2'", (Object)string, (long)list2.size());
        this.menuEntries = list2;
        RightDrawerHandler rightDrawerHandler = ((RemoteHMIServiceEvo)this.remoteHMIService).getRightDrawerHandler();
        Map map = this.loadLeftDrawerForSpecificContext(string, list2);
        rightDrawerHandler.setMenuSpecificEntries(string, map);
    }

    protected void updateListModelEntry(DrawerEntryLeftDrawer drawerEntryLeftDrawer, int n, String string) {
        this.log.log(1000000, "LeftDrawerHandler#updateListModelEntry: called for context '%1'", (Object)string);
        if (drawerEntryLeftDrawer == null) {
            this.log.log(100000, "LeftDrawerHandler#updateListModelEntry: Can not update left drawer entry because the entry provided for update is null");
            return;
        }
        if (this.menuEntries == null) {
            this.log.log(100000, "LeftDrawerHandler#updateListModelEntry: Drawer entry '%1' can not be updated because menuEntries is null", (Object)drawerEntryLeftDrawer.getEntryName());
            return;
        }
        Iterator iterator = this.menuEntries.iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object2;
            MenuEntry menuEntry = (MenuEntry)iterator.next();
            DrawerEntryLeftDrawer drawerEntryLeftDrawer2 = menuEntry.getLeftDrawerEntry();
            String string2 = drawerEntryLeftDrawer.getIcon().getPath();
            String string3 = drawerEntryLeftDrawer.getReflectionIcon().getPath();
            if (drawerEntryLeftDrawer2.getEntryId().equals(drawerEntryLeftDrawer.getEntryId())) {
                object2 = this.hmiService.getBaseListModel(2300695);
                long l = ((Integer)this.listModelValues.get(drawerEntryLeftDrawer.getEntryId())).longValue();
                object = object2.getRowByUniqueID(l);
                int n2 = object2.getIndexForUniqueID(l);
                if (n == 1) {
                    drawerEntryLeftDrawer2.getIcon().setPath(string2);
                    ((EvoListRow)object).setHMIResourceLocator(3, new HMIResourceLocator(-1, string2));
                    this.log.log(10000000, "LeftDrawerHandler#updateListModelEntry: Update call for drawer entry : %1, update type : UPDATE_TYPE_MAIN, icon path : %2", (Object)drawerEntryLeftDrawer.getEntryName(), (Object)string2);
                } else if (n == 2) {
                    drawerEntryLeftDrawer2.getReflectionIcon().setPath(string3);
                    ((EvoListRow)object).setHMIResourceLocator(4, new HMIResourceLocator(-1, string3));
                    this.log.log(10000000, "LeftDrawerHandler#updateListModelEntry: Update call for drawer entry : %1, update type : UPDATE_TYPE_REFLECTION, icon path : %2", (Object)drawerEntryLeftDrawer.getEntryName(), (Object)string3);
                } else if (n == 3) {
                    this.log.log(10000000, "LeftDrawerHandler#updateListModelEntry: update type : UPDATE_TYPE_CLOSED so doing nothing as this is not supported anymore");
                }
                object2.setRow(n2, (EvoListRow)object);
                this.remoteHMIService.flushModelGroup();
                break;
            }
            object2 = menuEntry.getLeftDrawerSubEntries();
            if (object2 == null) continue;
            boolean bl = false;
            Iterator iterator2 = object2.iterator();
            while (iterator2.hasNext()) {
                object = (DrawerEntry)iterator2.next();
                if (!object.getEntryId().equals(drawerEntryLeftDrawer.getEntryId())) continue;
                Integer n3 = (Integer)this.currentSubListModelValues.get(drawerEntryLeftDrawer.getEntryId());
                long l = n3 == null ? -1L : (long)n3.intValue();
                String string4 = "";
                int n4 = -1;
                if (n == 2) {
                    object.getReflectionIcon().setPath(string3);
                    string4 = string3;
                    n4 = 4;
                } else if (n == 1) {
                    object.getIcon().setPath(string2);
                    string4 = string2;
                    n4 = 3;
                }
                if (l != -1L && n4 != -1) {
                    BaseListModelApp baseListModelApp = this.remoteHMIService.getFrameworkAccess().getHMIService().getBaseListModel(2300976);
                    EvoListRow evoListRow = baseListModelApp.getRowByUniqueID(l);
                    int n5 = baseListModelApp.getIndexForUniqueID(l);
                    evoListRow.setHMIResourceLocator(n4, new HMIResourceLocator(-1, string4));
                    baseListModelApp.setRow(n5, evoListRow);
                }
                bl = true;
                break;
            }
            if (!bl) continue;
            break;
        }
    }

    protected void setCurrentlySelectedLeftDrawerEntry(DrawerEntryLeftDrawer drawerEntryLeftDrawer, RemoteHMIContext remoteHMIContext) {
        String string = null;
        if (drawerEntryLeftDrawer != null) {
            string = drawerEntryLeftDrawer.getEntryId();
        }
        if (remoteHMIContext != null) {
            remoteHMIContext.setCurrentlySelectedLeftDrawerEntryId(string);
        }
    }

    protected void setCurrentlySelectedLeftDrawerSubEntry(String string, RemoteHMIContext remoteHMIContext) {
        if (remoteHMIContext != null) {
            remoteHMIContext.setCurrentlySelectedLeftDrawerSubEntryId(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map loadLeftDrawerForSpecificContext(String string, List list) {
        int n;
        this.log.log(1000000, "LeftDrawerHandler#loadLeftDrawerForSpecificContext: Called for context name %1", (Object)string);
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300695);
        BaseListModel baseListModel = new BaseListModel(baseListModelApp.getID(), null);
        RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getContext(string);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2301257);
        int n2 = n = list == null ? 0 : list.size();
        if (n == 0) {
            this.log.log(1000000, "LeftDrawerHandler#loadLeftDrawerForSpecificContext: no entries for context '%1'", (Object)string);
            choiceModelApp.setValue(1);
            remoteHMIContext.setLeftDrawerAvailable(false);
            this.listModelValues = Collections.EMPTY_MAP;
            this.subEntriesForAllEntries = Collections.EMPTY_MAP;
            baseListModel.removeAll();
            baseListModelApp.update(baseListModel);
            this.setCurrentlySelectedLeftDrawerEntry(null, remoteHMIContext);
            this.remoteHMIService.flushModelGroup();
            return Collections.EMPTY_MAP;
        }
        this.log.log(1000000, "LeftDrawerHandler#loadLeftDrawerForSpecificContext: no. of entries for context '%1' are '%2'", (Object)string, (long)n);
        choiceModelApp.setValue(0);
        remoteHMIContext.setLeftDrawerAvailable(true);
        HashMap hashMap = new HashMap();
        try {
            DeepCloneable deepCloneable;
            baseListModel.addHint(8);
            this.listModelValues = new HashMap();
            this.subEntriesForAllEntries = new HashMap();
            if (remoteHMIContext.getCurrentlySelectedLeftDrawerEntryId() == null) {
                MenuEntry menuEntry = (MenuEntry)list.get(0);
                deepCloneable = menuEntry.getLeftDrawerEntry();
                this.setCurrentlySelectedLeftDrawerEntry((DrawerEntryLeftDrawer)deepCloneable, remoteHMIContext);
            }
            for (int i2 = 0; i2 < n; ++i2) {
                deepCloneable = (MenuEntry)list.get(i2);
                if (deepCloneable == null) continue;
                DrawerEntryLeftDrawer drawerEntryLeftDrawer = deepCloneable.getLeftDrawerEntry();
                String string2 = drawerEntryLeftDrawer.getEntryId();
                this.populateListModelRow(baseListModel, i2, this.listModelValues, drawerEntryLeftDrawer.getEntryName(), drawerEntryLeftDrawer.getIcon().getPath(), drawerEntryLeftDrawer.getReflectionIcon().getPath(), string2, string);
                hashMap.put(string2, deepCloneable.getRightDrawerEntries());
                this.subEntriesForAllEntries.put(string2, deepCloneable.getLeftDrawerSubEntries());
            }
        }
        catch (Exception exception) {
            this.log.log(1000000, "LeftDrawerHandler#loadLeftDrawerForSpecificContext: Exception %1", (Throwable)exception);
        }
        finally {
            baseListModelApp.update(baseListModel);
            this.populateSubListAndSetSelection(remoteHMIContext);
            this.remoteHMIService.flushModelGroup();
        }
        return hashMap;
    }

    private boolean hasRightDrawerSelectionChanged(BaseListModelApp baseListModelApp, int n) {
        return baseListModelApp.getSelected() == null || baseListModelApp.getSelected().getIndex() != n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void populateSubListModel(BaseListModelApp baseListModelApp, BaseListModelApp baseListModelApp2, int n, String string) {
        BaseListModel baseListModel;
        block8: {
            int n2;
            Object object;
            this.log.log(1000000, "LeftDrawerHandler#populateSubListModel: Populate sub list model for row '%1'", (Object)Integer.toString(n));
            baseListModelApp2.removeAll();
            if (this.hasRightDrawerSelectionChanged(baseListModelApp, n)) {
                baseListModelApp.setSelectedUniqueID(n);
                baseListModelApp.trigger(ModelTrigger.JOIN_CURSOR);
            }
            String string2 = this.getSelectedEntry(n, this.listModelValues);
            baseListModel = new BaseListModel(baseListModelApp2.getID(), null);
            RemoteHMIContext remoteHMIContext = this.remoteHMIService.getContext();
            try {
                DrawerEntry drawerEntry;
                baseListModel.addHint(8);
                this.currentSubListModelValues = new HashMap();
                object = (List)this.subEntriesForAllEntries.get(string2);
                n2 = object == null ? 0 : object.size();
                this.log.log(10000000, "LeftDrawerHandler#populateSubListModel: Number of sub entries for row '%1' are '%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
                for (int i2 = 0; i2 < n2; ++i2) {
                    drawerEntry = (DrawerEntryLeftDrawer)object.get(i2);
                    if (drawerEntry == null) continue;
                    this.populateListModelRow(baseListModel, i2, this.currentSubListModelValues, drawerEntry.getEntryName(), drawerEntry.getIcon().getPath(), drawerEntry.getReflectionIcon().getPath(), drawerEntry.getEntryId(), string);
                }
                String string3 = remoteHMIContext.getCurrentlySelectedLeftDrawerSubEntryId();
                if (n2 > 0 && (string3 == null || string3.equals(""))) {
                    drawerEntry = (DrawerEntry)object.get(0);
                    remoteHMIContext.setCurrentlySelectedLeftDrawerSubEntryId(drawerEntry.getEntryId());
                }
                if (baseListModel.getLength() == 0) break block8;
            }
            catch (Exception exception) {
                block9: {
                    try {
                        this.log.log(10000, "LeftDrawerHandler#populateSubListModel: Problem with populating sub list model (IEvoOnlineModelBank.REMOTE_HMI_LEFT_DRAWER_SUB_LIST)");
                        if (baseListModel.getLength() == 0) break block9;
                    }
                    catch (Throwable throwable) {
                        if (baseListModel.getLength() != 0) {
                            Integer n3 = (Integer)this.currentSubListModelValues.get(remoteHMIContext.getCurrentlySelectedLeftDrawerSubEntryId());
                            int n4 = n3 == null ? 0 : n3;
                            baseListModel.setSelectedUniqueID(n4);
                            baseListModel.trigger(ModelTrigger.JOIN_CURSOR);
                        }
                        baseListModelApp2.update(baseListModel);
                        throw throwable;
                    }
                    Integer n5 = (Integer)this.currentSubListModelValues.get(remoteHMIContext.getCurrentlySelectedLeftDrawerSubEntryId());
                    int n6 = n5 == null ? 0 : n5;
                    baseListModel.setSelectedUniqueID(n6);
                    baseListModel.trigger(ModelTrigger.JOIN_CURSOR);
                }
                baseListModelApp2.update(baseListModel);
            }
            object = (Integer)this.currentSubListModelValues.get(remoteHMIContext.getCurrentlySelectedLeftDrawerSubEntryId());
            n2 = object == null ? 0 : (Integer)object;
            baseListModel.setSelectedUniqueID(n2);
            baseListModel.trigger(ModelTrigger.JOIN_CURSOR);
        }
        baseListModelApp2.update(baseListModel);
    }

    private void populateListModelRow(BaseListModelApp baseListModelApp, int n, Map map, String string, String string2, String string3, String string4, String string5) {
        if (map == null) {
            throw new IllegalArgumentException("Null map not allowed");
        }
        EvoListRow evoListRow = new EvoListRow(n, 5);
        evoListRow.setText(2, string);
        if ("top_wizard".equals(string5)) {
            Integer n2 = (Integer)topWizardIcons.get(string4);
            this.log.log(10000000, "LeftDrawerHandler#populateListModelRow: context top_wizard, entryid %1, iconId %2", (Object)string4, (Object)n2);
            int n3 = n2 != null ? n2 : -1;
            evoListRow.setHMIResourceLocator(3, new HMIResourceLocator(n3, HMIResourceLocator.UNDEFINED_URI));
            evoListRow.setHMIResourceLocator(4, new HMIResourceLocator(n3, HMIResourceLocator.UNDEFINED_URI));
        } else {
            this.log.log(10000000, "LeftDrawerHandler#populateListModelRow: context '%1', local url used for icon and reflection icon", (Object)string5);
            evoListRow.setHMIResourceLocator(3, new HMIResourceLocator(-1, string2));
            evoListRow.setHMIResourceLocator(4, new HMIResourceLocator(-1, string3));
        }
        baseListModelApp.append(evoListRow);
        map.put(string4, Util.createInteger(n));
    }

    private void invokeAction(EvoListRow evoListRow, int n) {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300976);
        baseListModelApp.clearAll();
        int n2 = (int)evoListRow.getUniqueID();
        String string = "";
        RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(10000001);
        if (n == 2300695) {
            this.log.log(1000000, "LeftDrawerHandler#invokeAction: item %1 was selected", (long)n2);
            remoteHMIAction.getParameters().putInt("selectedNumber", n2);
            string = this.getSelectedEntry(n2, this.listModelValues);
            DrawerEntryLeftDrawer drawerEntryLeftDrawer = this.getDrawerEntryById(string);
            this.setCurrentlySelectedLeftDrawerEntry(drawerEntryLeftDrawer, this.remoteHMIService.getContext());
        } else if (n == 2300976) {
            this.log.log(1000000, "LeftDrawerHandler#invokeAction: subitem %1 was selected", (long)n2);
            string = this.getSelectedEntry(n2, this.currentSubListModelValues);
            this.setCurrentlySelectedLeftDrawerSubEntry(string, this.remoteHMIService.getContext());
        }
        remoteHMIAction.getParameters().putString("selectedId", string);
        this.remoteHMIService.flushModelGroup();
        this.remoteHMIService.invokeAction(remoteHMIAction);
    }

    private int getEntryIndex(String string, Map map) {
        if (map == null || string == null) {
            return -1;
        }
        Integer n = (Integer)map.get(string);
        int n2 = n == null ? -1 : n;
        return n2;
    }

    private String getSelectedEntry(int n, Map map) {
        String string = "";
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n2 = (Integer)entry.getValue();
            if (n2 != n) continue;
            string = (String)entry.getKey();
            break;
        }
        return string;
    }

    private DrawerEntryLeftDrawer getDrawerEntryById(String string) {
        if (this.menuEntries == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.menuEntries.size(); ++i2) {
            MenuEntry menuEntry = (MenuEntry)this.menuEntries.get(i2);
            if (menuEntry == null) continue;
            DrawerEntryLeftDrawer drawerEntryLeftDrawer = menuEntry.getLeftDrawerEntry();
            if (menuEntry == null || drawerEntryLeftDrawer == null || drawerEntryLeftDrawer.getEntryId() == null || !drawerEntryLeftDrawer.getEntryId().equals(string)) continue;
            return drawerEntryLeftDrawer;
        }
        return null;
    }

    private void updateClosedIcon(DrawerEntryLeftDrawer drawerEntryLeftDrawer) {
        String string;
        int n;
        ResourceLocatorModelApp resourceLocatorModelApp = this.hmiService.getResourceLocatorModel(2301032);
        if (drawerEntryLeftDrawer == null) {
            this.log.log(1000000, "LeftDrawerHandler#updateClosedIcon: entry is null and doing nothing");
            return;
        }
        DrawerEntryIcon drawerEntryIcon = drawerEntryLeftDrawer.getClosedIcon();
        if (drawerEntryIcon == null || drawerEntryIcon.getPath() == null) {
            n = 1;
            string = ResourceLocatorModelApp.UNDEFINED_URI;
        } else {
            n = 0;
            string = drawerEntryIcon.getPath();
        }
        this.log.log(1000000, "LeftDrawerHandler#updateClosedIcon: updating closed icon for entry id %1 with status %2 and path %3", (Object)drawerEntryLeftDrawer);
        resourceLocatorModelApp.setStatus(n);
        resourceLocatorModelApp.setResourceLocator(-1, string);
    }

    public void setLeftDrawerForContext(String string) {
        if (this.payloadLastRecieved == null) {
            this.log.log(1000000, "LeftDrawerHandler#setLeftDrawerForContext: no last recieved drawer configuration exists");
            return;
        }
        if (!string.equals(this.payloadLastRecieved.getContextName())) {
            this.log.log(1000000, "LeftDrawerHandler#setLeftDrawerForContext: no last recieved drawer configuration exists for context '%1'", (Object)string);
            return;
        }
        this.log.log(1000000, "LeftDrawerHandler#setLeftDrawerForContext: set last recieved drawer configuration for context '%1'", (Object)string);
        this.setMenuEntriesForContext(this.payloadLastRecieved);
        this.payloadLastRecieved = null;
    }
}

