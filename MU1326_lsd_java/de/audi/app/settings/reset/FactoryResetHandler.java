/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.reset;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.reset.FactoryResetServiceImpl;
import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.FactResetService;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;

public final class FactoryResetHandler
implements ButtonListener,
ListListener,
ITVStateListener,
TimerListener,
ComponentStateListener,
CacheEventListener {
    private FactoryResetServiceImpl service;
    private static final int BOX_UNCHECKED = 0;
    private static final int BOX_CHECKED = 1;
    private static final int BOX_DISABLED = 0;
    private static final int BOX_ENABLED = 1;
    private final ResetEntry[] resetEntries;
    private final SettingsEnv env;
    private final LogChannel lc;
    private static final int resetTimer = 20;
    private Timer systemResetTimer = new Timer("System Reset after Factory Reset Timer", 20000L, true, this);
    private int naviComponentState = 0;
    private static final int RESET_ENTRY_ALL_ENTRIES = 0;
    private static final int RESET_ENTRY_TONE = 1;
    private static final int RESET_ENTRY_TUNER = 2;
    private static final int RESET_ENTRY_MEDIA = 3;
    private static final int RESET_ENTRY_JUKEBOX = 4;
    private static final int RESET_ENTRY_ADRESSBOOK = 5;
    private static final int RESET_ENTRY_PHONE = 6;
    private static final int RESET_ENTRY_BLUETOOTH = 7;
    private static final int RESET_ENTRY_NAV_SETTINGS = 8;
    private static final int RESET_ENTRY_NAV_MEMORY = 9;
    private static final int RESET_ENTRY_NAV_MEMORY_ONLINE = 10;
    private static final int RESET_ENTRY_SDS = 11;
    private static final int RESET_ENTRY_TVAV = 12;
    private static final int RESET_ENTRY_MESSAGING = 13;
    private static final int RESET_ENTRY_PRESETS = 14;
    private static final int RESET_ENTRY_APPS = 15;
    private static final int RESET_ENTRY_USER_HINTS = 16;
    private static final int RESET_ENTRY_AUDI_CONNECT = 17;
    private static final int RESET_ENTRY_AUDI_SMARTPHOE_INTERFACE = 18;
    private static final int RESET_ENTRY_WORD_PREDICTION = 19;
    private static final int RESET_ENTRY_SDIS = 20;
    private static final int RESET_NUM_ENTRIES = 21;
    public static final int COLUMN_LABELINDEX = 0;
    public static final int COLUMN_CHECKBOX = 1;
    public static final int COLUMN_ENTRY_ID = 2;
    public static final int COLUMN_ENABLED = 3;
    public static final int COLUMN_MAX = 4;
    private static final int TEXTID_RESET_ALL = 0;
    private static final int TEXTID_RESET_TONE = 1;
    private static final int TEXTID_RESET_TUNER = 2;
    private static final int TEXTID_RESET_MEDIA = 3;
    private static final int TEXTID_RESET_JUKEBOX = 4;
    private static final int TEXTID_RESET_TV_AV = 5;
    private static final int TEXTID_RESET_ADRBOOK = 6;
    private static final int TEXTID_RESET_PHONE = 7;
    private static final int TEXTID_RESET_BLUETOOTH_WLAN = 8;
    private static final int TEXTID_RESET_NAV_SET = 9;
    private static final int TEXTID_RESET_NAV_MEM_ONL = 10;
    private static final int TEXTID_RESET_NAV_MEM = 11;
    private static final int TEXTID_RESET_SDS = 12;
    private static final int TEXTID_RESET_MESSAGING = 15;
    private static final int TEXTID_RESET_PRESETS = 16;
    private static final int TEXTID_RESET_APPS = 17;
    private static final int TEXTID_RESET_USER_HINTS = 18;
    private static final int TEXTID_RESET_AUDI_CONNECT = 19;
    private static final int TEXTID_RESET_BLUETOOTH = 20;
    private static final int TEXTID_RESET_WLAN = 21;
    private static final int TEXTID_AUDI_SMARTPHONE_INTERFACE = 22;
    private static final int TEXTID_RESET_WORD_PREDICTION = 23;
    private static final int TEXTID_RESET_SDIS = 24;
    private boolean isManualGearshift = true;
    private static final String[] PRESET_SERVICE_ID = new String[]{"service_dsi_presetlayout"};

    public FactoryResetHandler(SettingsEnv settingsEnv) {
        CacheHandler cacheHandler;
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.Reset");
        this.service = new FactoryResetServiceImpl(this);
        if (!this.env.getFw().isPorsche() && (cacheHandler = this.env.getFw().getCacheHandler()) != null) {
            cacheHandler.addListener(this);
            this.lc.log(10000000, "FactoryResetHandler#registerCacheHandler isManualGearshift == %1", this.isManualGearshift);
        }
        int n = 8;
        if (this.env.getFw().getSysConst(461) == 1 && this.env.getFw().getSysConst(492) == 0) {
            n = 20;
        } else if (this.env.getFw().getSysConst(461) == 0 && this.env.getFw().getSysConst(492) == 1) {
            n = 21;
        }
        this.resetEntries = new ResetEntry[21];
        this.resetEntries[0] = new ResetEntry(0, 36, "ALL_ENTRIES");
        this.resetEntries[1] = new ResetEntry(1, 26, "TONE");
        this.resetEntries[2] = new ResetEntry(2, 29, "TUNER");
        this.resetEntries[3] = new ResetEntry(3, 33, "MEDIA");
        this.resetEntries[4] = new ResetEntry(4, 32, "JUKEBOX");
        this.resetEntries[5] = new ResetEntry(6, 30, "ADRBOOK");
        this.resetEntries[6] = new ResetEntry(7, 28, "PHONE");
        this.resetEntries[7] = new ResetEntry(n, 20, "BLUETOOTH");
        this.resetEntries[8] = new ResetEntry(9, 24, "NAV_SETT");
        this.resetEntries[9] = new ResetEntry(11, 23, "NAV_MEM");
        this.resetEntries[10] = new ResetEntry(10, 23, "NAV_MEM_ONL");
        this.resetEntries[11] = new ResetEntry(12, 25, "SDS");
        this.resetEntries[12] = new ResetEntry(5, 27, "TVAV");
        this.resetEntries[13] = new ResetEntry(15, 35, "MESSAGING");
        this.resetEntries[14] = new ResetEntry(16, 34, "PRESETS");
        this.resetEntries[15] = new ResetEntry(17, 86, "APPS");
        this.resetEntries[16] = new ResetEntry(18, 87, "USER_HINTS");
        this.resetEntries[17] = new ResetEntry(19, 88, "AUDI_CONNECT");
        this.resetEntries[18] = new ResetEntry(22, 94, "AUDI_SMARTPHONE_INTERFACE");
        this.resetEntries[19] = new ResetEntry(23, 95, "WORD_PREDICTION");
        this.resetEntries[20] = new ResetEntry(24, 85, "SMART_DISPLAY");
        this.env.getChoiceModel(1100087).setStatus(0);
        this.env.getButtonModel(1100090).setButtonListener(this);
        this.env.getButtonModel(1100100).setButtonListener(this);
        this.env.getButtonModel(1100093).setButtonListener(this);
        this.env.getButtonModel(1100326).setButtonListener(this);
        ListModelApp listModelApp = this.env.getListModel(1100091);
        listModelApp.setMaxColumns(4);
        listModelApp.setMaxRows(21);
        listModelApp.setListListener(this);
        this.updateEntryList();
    }

    private boolean isSettingPresetVisible() {
        if (this.env.getFw().isPorsche()) {
            return true;
        }
        return !this.env.getFw().isEvoHighMMIKombi();
    }

    public FactResetService getResetService() {
        return this.service;
    }

    public void deselectAll() {
        this.setAllEntries(0);
        this.setResetMenueEntry();
    }

    void updateEntryList() {
        ListModelApp listModelApp = this.env.getListModel(1100091);
        listModelApp.clear();
        for (int i2 = 0; i2 < this.resetEntries.length; ++i2) {
            if (this.isDeviceVisible(i2)) {
                ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(this.resetEntries[i2].getTextID()), IntegerListCell.create(this.isEntryEnabled(i2) ? this.resetEntries[i2].getChecked() : 0), IntegerListCell.create(i2), IntegerListCell.create(this.isEntryEnabled(i2) ? 1 : 0)};
                listModelApp.addRow(listCellArray);
                if (!this.lc.isInfo()) continue;
                this.lc.log(1000000, "updateEntryList: (%1) - %2 (%3)", (Object)Integer.toString(i2), (Object)this.resetEntries[i2], (Object)(this.isEntryEnabled(i2) ? "enabled" : "disabled"));
                continue;
            }
            this.resetEntries[i2].enabled = 0;
        }
        this.setResetMenueEntry();
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 1100090: {
                this.lc.log(1000000, "keyPressed SETTINGS_CONFIRM_BUTTON");
                this.env.getButtonModel(1100090).fireEvent(n3);
                break;
            }
            case 1100100: {
                this.lc.log(1000000, "keyPressed RESTART_CONFIRM_BUTTON");
                this.doResetSettings();
                this.env.getButtonModel(1100100).fireEvent(n3);
                break;
            }
            case 1100093: {
                this.lc.log(1000000, "keyPressed RESET_MEDIA_DRIVER_CONFIRM_BUTTON");
                this.doResetMediaDriver();
                this.env.getButtonModel(1100093).fireEvent(n3);
                break;
            }
            case 1100326: {
                this.env.getButtonModel(1100326).fireEvent(n3);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 1100090: {
                this.doResetSettings();
                break;
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(1000000, "itemSelected: %1", (long)n2);
        ListModelApp listModelApp = this.env.getListModel(n);
        int n5 = ((IntegerListCell)listModelApp.getCell(n2, 2)).getValue();
        int n6 = ((IntegerListCell)listModelApp.getCell(n2, 1)).getValue();
        int n7 = ((IntegerListCell)listModelApp.getCell(n2, 3)).getValue();
        if (n7 == 0) {
            this.lc.log(1000000, "itemSelected: row disabled, nothing to do");
            return;
        }
        int n8 = n6 == 1 ? 0 : 1;
        boolean bl = n8 == 1;
        this.lc.log(10000000, "itemSelected: row=%3, entry=%1, activating=%2", (Object)this.resetEntries[n5].getDescription(), (Object)(bl ? "Y" : "N"), (long)n2);
        switch (n5) {
            case 0: {
                this.setAllEntries(n8);
                break;
            }
            case 4: {
                if (bl) {
                    this.setFuncEntry(3, 1);
                }
                this.setFuncEntry(4, n8);
                break;
            }
            case 3: {
                if (!bl) {
                    this.setFuncEntry(4, 0);
                }
                this.setFuncEntry(3, n8);
                break;
            }
            default: {
                this.setFuncEntry(n5, n8);
            }
        }
        this.setResetMenueEntry();
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setAllEntries(int n) {
        this.lc.log(1000000, "setAllEntries: active %1", (long)n);
        ListModelApp listModelApp = this.env.getListModel(1100091);
        for (int i2 = 0; i2 < listModelApp.getLength(); ++i2) {
            if (this.getListEntryValue(i2, 3) != 1) continue;
            listModelApp.setCell(i2, 1, IntegerListCell.create(n));
            this.resetEntries[this.getListEntryValue(i2, 2)].checked = n;
        }
    }

    private void doResetMediaDriver() {
        this.lc.log(1000000, "send message to media app concering media driver update");
        this.env.getFw().getMsgDistrib().sendMessage(89);
    }

    private void doResetSettings() {
        this.env.getFw().getStorageMgr().startReset2FactorySettings();
        ListModelApp listModelApp = this.env.getListModel(1100091);
        for (int i2 = 1; i2 < listModelApp.getLength(); ++i2) {
            int n;
            if (this.getListEntryValue(i2, 1) != 1 || this.getListEntryValue(i2, 3) != 1 || (n = this.getListEntryValue(i2, 2)) == 3 && this.resetEntries[4].getEnabled() == 1 && this.resetEntries[4].getChecked() == 1) continue;
            int n2 = this.resetEntries[this.getListEntryValue(i2, 2)].getMessageID();
            this.lc.log(1000000, "doResetSettings send msg %1", (long)n2);
            this.env.getFw().getMsgDistrib().sendMessage(n2);
        }
        this.env.getFw().getStorageMgr().endReset2FactorySettings();
        this.env.getFw().getInfotainmentrecorder().logInit();
        if (this.env.getChoiceModel(4528).getValue() == 1) {
            this.lc.log(100000, "FactoryResetHandler: One of the components needs a target reset. Target Reset will be requested in 20 seconds");
            this.env.getFw().getStartupMgr().logStartupEvent("FactoryResetHandler: One of the components needs a target reset. Target Reset will be requested in 20 seconds");
            this.systemResetTimer.restart();
        }
        this.deselectAll();
    }

    private boolean isEntryEnabled(int n) {
        switch (n) {
            case 6: {
                return !this.service.isPhoneResetBlocked();
            }
            case 7: {
                return !this.service.isBluetoothResetBlocked();
            }
            case 17: {
                return !this.service.isAudiConnectBlocked();
            }
        }
        return true;
    }

    private boolean isDeviceVisible(int n) {
        switch (n) {
            case 5: {
                return this.env.getFw().getSysConst(470) == 1;
            }
            case 6: {
                return this.env.getFw().getSysConst(473) == 1;
            }
            case 13: {
                return this.env.getFw().getSysConst(472) == 1;
            }
            case 15: 
            case 17: {
                if (this.env.getFw().isEvoStd()) {
                    return false;
                }
                return this.env.getFw().getSysConst(474) == 1;
            }
            case 8: 
            case 10: {
                if (this.env.getFw().isEvoStd() || !this.isNavInitialized()) {
                    return false;
                }
                return this.env.getFw().getSysConst(459) == 1;
            }
            case 12: {
                if (this.env.getFw().isEvoStd()) {
                    return false;
                }
                return this.env.getFw().getSysConst(491) == 1;
            }
            case 4: {
                return this.env.getFw().getSysConst(503) == 1;
            }
            case 11: {
                return this.env.getFw().getSysConst(460) == 1;
            }
            case 14: {
                return this.isSettingPresetVisible();
            }
            case 7: {
                return this.env.getFw().getSysConst(461) == 1 || this.env.getFw().getSysConst(492) == 1;
            }
            case 9: {
                return false;
            }
            case 18: {
                return this.env.getFw().getSysConst(4238) == 1 || this.env.getFw().getSysConst(4237) == 1;
            }
            case 19: {
                if (this.env.getFw().getSysConst(4168) == 5) {
                    return false;
                }
                return this.env.getFw().getSysConst(4518) == 1;
            }
            case 20: {
                if (this.env.getFw().getSysConst(4168) == 5) {
                    return false;
                }
                return this.env.getFw().getSysConst(3892) == 1;
            }
        }
        return true;
    }

    private void setResetMenueEntry() {
        int n;
        ListModelApp listModelApp = this.env.getListModel(1100091);
        int n2 = 0;
        int n3 = 0;
        for (n = 1; n < listModelApp.getLength(); ++n) {
            n2 += this.getListEntryValue(n, 1) == 1 ? 1 : 0;
            n3 += this.getListEntryValue(n, 3) == 0 ? 1 : 0;
        }
        if (n2 == 0) {
            this.setFuncEntry(0, 0);
            this.lc.log(1000000, "setResetAllEntry: BOX_UNCHECKED");
        }
        n = n2 == listModelApp.getLength() - 1 - n3 ? 1 : 0;
        this.setFuncEntry(0, n);
        this.lc.log(1000000, "setResetAllEntry: %1", (long)n);
        this.env.getChoiceModel(1100087).setStatus(n2 > 0 ? 1 : 0);
        if (this.resetEntries[15].checked == 1 || this.resetEntries[17].checked == 1 || this.resetEntries[10].checked == 1) {
            this.env.getChoiceModel(4528).setValue(1);
        } else {
            this.env.getChoiceModel(4528).setValue(0);
        }
    }

    private void setFuncEntry(int n, int n2) {
        ListModelApp listModelApp = this.env.getListModel(1100091);
        for (int i2 = 0; i2 < listModelApp.getLength(); ++i2) {
            if (this.getListEntryValue(i2, 2) != n) continue;
            listModelApp.setCell(i2, 1, IntegerListCell.create(n2));
            this.resetEntries[n].checked = n2;
            return;
        }
    }

    private int getListEntryValue(int n, int n2) {
        ListModelApp listModelApp = this.env.getListModel(1100091);
        return ((IntegerListCell)listModelApp.getCell(n, n2)).getValue();
    }

    public void updateState(int n, int[] nArray) {
        HMIModelApp hMIModelApp = this.env.getFw().getHmiServiceApp().getModelApp(491);
        if (hMIModelApp instanceof SysConstModel) {
            int n2 = ((SysConstModel)hMIModelApp).getValue();
            int n3 = 0;
            if (n == 0) {
                n3 = 1;
            }
            if (n2 != n3) {
                ((SysConstModel)hMIModelApp).setValue(n3);
                this.updateEntryList();
            }
        }
    }

    public void fireTimer(Timer timer) {
        this.lc.log(100000, "FactoryResetHandler: Request target reset now");
        this.env.getFw().getStartupMgr().logStartupEvent("FactoryResetHandler: Request target reset now");
        this.env.getFw().getPowerMgr().rebootSystem();
    }

    public void cancelTimer(Timer timer) {
    }

    public void appStateChanged(String string, int n) {
        if ("Navi".equals(string) || "AppNavAsia".equals(string)) {
            this.lc.log(1000000, "FactoryResetHandler::appStateChanged(%1,%2)", (Object)string, (long)n);
            this.naviComponentState = n;
            this.updateEntryList();
        }
    }

    private boolean isNavInitialized() {
        return 1 == this.naviComponentState;
    }

    public String[] getServiceIDs() {
        return PRESET_SERVICE_ID;
    }

    public String[] getTokens(String string) {
        return PRESET_SERVICE_ID;
    }

    public void updateToken(String string, String string2, Object object) {
        boolean bl;
        if (string.equals(PRESET_SERVICE_ID[0]) && string2.equals(PRESET_SERVICE_ID[0]) && object instanceof Boolean && (bl = ((Boolean)object).booleanValue()) != this.isManualGearshift) {
            this.isManualGearshift = bl;
            this.lc.log(10000000, "FactoryResetHandler#updateToken isManualGearshift == %1", this.isManualGearshift);
        }
    }

    public void dump(Buffer buffer) {
        buffer.append("ResetEntries: ").append(this.resetEntries);
        if (this.resetEntries != null) {
            for (int i2 = 0; i2 < this.resetEntries.length; ++i2) {
                buffer.append("\n\t").append(i2).append(": ").append(this.resetEntries[i2]);
            }
        }
        buffer.append("\n\nFields:");
        buffer.append("\n\t").append("naviComponentState: ").append(this.naviComponentState);
        buffer.append("\n\t").append("isManualGearshift: ").append(this.isManualGearshift);
        buffer.append("\n\t").append("PRESET_SERVICE_ID: ").append(StringUtils.toString(PRESET_SERVICE_ID));
        buffer.append("\n\nSystem Constants:");
        buffer.append("\n\t").append("ICoreSysConfig.BLUETOOTH: ").append(this.env.getFw().getSysConst(461));
        buffer.append("\n\t").append("ICoreSysConfig.WLAN: ").append(this.env.getFw().getSysConst(492));
        buffer.append("\n\n");
        this.service.dump(buffer);
        buffer.append("\n\nModels:");
        buffer.append("\n").append("ICoreSettingsModelBank.RESET_ALL_SELECTION_AVAILABLE_CHOICE").append(this.env.getChoiceModel(1100087).dumpContent());
        buffer.append("\n\n").append("ICoreSettingsModelBank.RESET_CONFIRM_BUTTON").append(this.env.getButtonModel(1100090).dumpContent());
        buffer.append("\n\n").append("ICoreSettingsModelBank.RESET_RESTART_CONFIRM_BUTTON").append(this.env.getButtonModel(1100100).dumpContent());
        buffer.append("\n\n").append("ICoreSettingsModelBank.RESET_MEDIA_DRIVER_CONFIRM_BUTTON").append(this.env.getButtonModel(1100093).dumpContent());
        buffer.append("\n\n").append("ICoreSettingsModelBank.FACTORY_RESET_BUTTON").append(this.env.getButtonModel(1100326).dumpContent());
        buffer.append("\n\n").append("ICoreSettingsModelBank.RESET_FUNCTIONS_LIST").append(this.env.getListModel(1100091).dumpContent());
    }

    public class ResetEntry {
        private int messageID;
        private int textID;
        private int checked;
        private int enabled;
        private String description;

        private ResetEntry(int n, int n2, String string) {
            this.messageID = n2;
            this.textID = n;
            this.checked = 0;
            this.enabled = 1;
            this.description = string;
        }

        protected int getMessageID() {
            return this.messageID;
        }

        protected int getTextID() {
            return this.textID;
        }

        public int getEnabled() {
            return this.enabled;
        }

        protected int getChecked() {
            return this.checked;
        }

        protected String getDescription() {
            return this.description;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("ResetEntry[textID='").append(this.textID).append("',");
            buffer.append("messageID='").append(this.messageID).append("',");
            buffer.append("checked='").append(this.checked).append("',");
            buffer.append("enabled='").append(this.enabled).append("',");
            buffer.append("description='").append(this.description).append("']");
            return buffer.toString();
        }
    }
}

