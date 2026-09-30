/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.IPreviewInfo;
import de.audi.remotehmi.ui.mib2.DrawerEntryLeftDrawer;
import de.audi.remotehmi.ui.ql.CommandsQL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Commands
extends CommandsQL {
    public static final int STATE_LEFT_DRAWER = 10000001;
    public static final int STATE_RIGHT_DRAWER = 10000002;
    public static final int STATE_MINI_APPS_OTHER_CONTEXT = 10000004;
    public static final int STATE_APPS_OTHER_CONTEXT_MEDIA = 10000005;
    public static final int STATE_UPDATE_RIGHT_DRAWER_STATE = 0x989686;
    public static final int STATE_MEDIA_APPLICATION_ICON_UPDATE = 10000007;
    public static final int STATE_SELECTED_LEFT_DRAWER_ENTRY = 0x989688;
    public static final int STATE_APPS_OTHER_CONTEXT_PHONE = 0x989689;
    public static final int STATE_SELECTED_LEFT_DRAWER_SUB_ENTRY = 100000010;
    public static final int STATE_APP_START_SUCCESS = 100000011;
    public static final int STATE_APP_START_ERROR = 100000012;
    public static final int STATE_LEFT_DRAWER_ICON_UPDATE = 100000013;
    public static final int STATE_I18N_READY = 100000014;
    public static final int STATE_CLOSE_RIGHT_DRAWER = 100000015;
    public static final int STATE_SEND_MINIAPPS_DOWNLOAD_ERROR = 100000016;
    public static final int STATE_TOP_WIZARD_RIGHT_DRAWER_UPDATE = 100000017;
    public static final int STATE_SET_CONTEXT_TO_BE_STARTED = 100000018;
    public static final int STATE_GRAYOUT_RIGHT_DRAWER_ENTRY = 100000019;
    public static final int STATE_INTERPRETER_RESUMPTION_FAILED = 100000020;
    public static final int STATE_HMI_FCT_CALL = 0x9898D9;
    public static final int STATE_RHMI_DSI_READY = 1100000011;
    public static final int PROVIDE_GRID_FACTORY = 1100000012;
    public static final int STATE_GRID_RESOURCE_AVAILABLE = 1100000013;
    public static final int STATE_APPLIST_LOADED = 1100000020;
    public static final int STATE_SERVICELIST_UPDATE = 1100000030;
    public static final int STATE_ACTIVATE_SPEECH_DICTIONARY = 1100000040;
    public static final int STATE_UPDATE_SERVICE_DISCOVERY_DEVICES = 1100000050;
    public static final int STATE_MOBILE_DEVICE_PERSONALIZED = 1100000060;
    public static final int STATE_UPDATE_PREVIEWS = 1100000070;
    public static final int STATE_POPUP_SHOW = 1100009000;
    public static final int STATE_POPUP_HIDE = 1100009001;
    public static final int STATE_PREDEVELOPMENT_GOTO_AUDI_CONNECT = 1110000001;
    public static final int STATE_CONNECTIVITY_CHANGED = 1100009002;
    public static final int STATE_LAST_MOBILE_APPLIST_DOWNLOAD = 1100009003;
    public static final int STATE_RECEIVED_SUBSCRIBE_MESSAGES_COUNT = 1100009004;
    public static final int STATE_LAST_PARSED_MOBILE_APPS = 1100009005;
    public static final int STATE_LAST_BACKEND_ACCESS = 1100009006;
    public static final int STATE_PRESET_ENTRIES_CHANGED = 1100009007;
    public static final int STATE_UPDATE_NAVLOCATION_NAME = 1100009008;
    public static final int STATE_BUNDLED_CONNECTIVITY_SHOW_POPUP = 1100009009;
    public static final int STATE_SWITCH_TO_ONLINE = 1100009010;
    public static final int STATE_ACTION_WITHOUT_INTERPRETER = 1200009005;

    public static final class LeftDrawerPayload
    extends AbstractContextPayload {
        public List leftDrawerEntriesList;

        public LeftDrawerPayload(String string, List list) {
            super(string);
            this.leftDrawerEntriesList = list;
        }
    }

    public static final class RightDrawerPayload
    extends AbstractContextPayload {
        public List rightDrawerEntriesList;

        public RightDrawerPayload(String string, List list) {
            super(string);
            this.rightDrawerEntriesList = list;
        }
    }

    public static final class MiniAppStatusPayload
    extends AbstractContextPayload {
        public final String hostingContext;

        public MiniAppStatusPayload(String string, String string2) {
            super(string);
            this.hostingContext = string2;
        }
    }

    public static abstract class AbstractContextPayload {
        private final String contextName;

        protected AbstractContextPayload(String string) {
            this.contextName = string;
        }

        public final String getContextName() {
            return this.contextName;
        }
    }

    public static final class RightDrawerStatePayload
    extends AbstractContextPayload {
        public final String entryId;
        public final String value;

        public RightDrawerStatePayload(String string, String string2, String string3) {
            super(string);
            this.entryId = string2;
            this.value = string3;
        }
    }

    public static final class StateUpdatePreviewsPayload {
        private final long delayMillis;
        private final List previews;

        public StateUpdatePreviewsPayload(long l, IPreviewInfo iPreviewInfo) {
            this.delayMillis = l;
            this.previews = new ArrayList(10);
            this.previews.add(iPreviewInfo);
        }

        public long getDelayMillis() {
            return this.delayMillis;
        }

        public List getPreviews() {
            return this.previews;
        }
    }

    public static class LeftDrawerIconUpdatePayload
    extends AbstractContextPayload {
        private final DrawerEntryLeftDrawer drawerEntry;
        private final int updateType;

        public LeftDrawerIconUpdatePayload(String string, DrawerEntryLeftDrawer drawerEntryLeftDrawer, int n) {
            super(string);
            this.drawerEntry = drawerEntryLeftDrawer;
            this.updateType = n;
        }

        public final DrawerEntryLeftDrawer getDrawerEntry() {
            return this.drawerEntry;
        }

        public final int getUpdateType() {
            return this.updateType;
        }
    }

    public static final class GrayoutRightDrawerEntryPayload
    extends AbstractContextPayload {
        public final String entryId;
        public final String infoText;

        public GrayoutRightDrawerEntryPayload(String string, String string2, String string3) {
            super(string);
            this.entryId = string2;
            this.infoText = string3;
        }
    }

    public static class SelectedLeftDrawerEntryPayload
    extends AbstractContextPayload {
        public String idValue;

        public SelectedLeftDrawerEntryPayload(String string, String string2) {
            super(string2);
            this.idValue = string;
        }
    }

    public static final class SelectedLeftDrawerSubEntryPayload
    extends SelectedLeftDrawerEntryPayload {
        public SelectedLeftDrawerSubEntryPayload(String string, String string2) {
            super(string, string2);
        }
    }

    public static final class StateGridResourceAvailablePayload
    extends AbstractContextPayload {
        private final List localLocations;
        private final long delayMillis;
        private HMIProperties properties;

        public StateGridResourceAvailablePayload(String string, String string2, HMIProperties hMIProperties, long l) {
            super(string);
            this.delayMillis = l;
            this.localLocations = new ArrayList();
            this.localLocations.add(string2);
            this.properties = hMIProperties;
        }

        public List getLocalLocations() {
            return this.localLocations;
        }

        public HMIProperties getProperties() {
            return this.properties;
        }

        public void add(List list) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                if (this.localLocations.contains(string)) continue;
                this.localLocations.add(string);
            }
        }

        public long getDelayMillis() {
            return this.delayMillis;
        }

        public void setProperties(HMIProperties hMIProperties) {
            this.properties = hMIProperties;
        }
    }
}

