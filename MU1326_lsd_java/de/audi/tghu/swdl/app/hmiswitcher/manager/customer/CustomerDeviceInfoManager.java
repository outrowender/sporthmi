/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.AbstractCustomerProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerSelectionManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CustomerDeviceInfoManager
extends AbstractDeviceInfoManager
implements ButtonListener {
    private static final String NAV_DB_DEVICE_NAME = "NavDB";
    private static final String SPEACH_RES_VDE_DEVICE_NAME = "SpeechResVDE";
    private static final String CLASSNAME = "[CustomerDeviceInfoManager]";
    private static final long DEVICE_TIMEOUT = 10000L;
    public static final String LIST_DELIMITER = "|";
    public static final String MAIN_DEVICE_VALUE = "main";
    public static final String ROLE_TAG = "role";
    private volatile String mainDeviceName = null;
    private volatile String mainDeviceVersion = null;
    private static final boolean NEW_MODELS = false;
    private DeviceInfo currentDevice = null;
    private DeviceInfo currentUpdate = null;
    private DeviceListHandler deviceListHandler = null;
    private CustomerSelectionManager customerSelectionManager;
    private AbstractCustomerProgressManager customerProgressManager;
    private boolean showInstalledVersionInfo = false;
    static final int ERROR_TYPE_WRONG_DATA = 0;
    static final int ERROR_TYPE_NO_DATA = 1;
    static final int ERROR_TYPE_DATA_NOT_ACTIVATED = 2;

    public CustomerDeviceInfoManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerDeviceInfo);
        this.getLogHMI().log(1000000, "%1 <init>", (Object)CLASSNAME);
        this.getSwdlModels().getDevicesListModel().setListener(new DeviceListListener());
        this.getSwdlModels().getCustomerStartDownloadButton().setButtonListener(this);
        this.getSwdlModels().getCustomerAbortSelectionMediaButton().setButtonListener(this);
        this.getSwdlModels().getCustomerProgressRetryReadMediumButton().setButtonListener(this);
        this.getSwdlModels().getCustomerUpdateNewModelChoice().setValue(0);
        this.persistenceLoadSettings();
    }

    private final AbstractCustomerProgressManager getCustomerProgressManager() {
        return this.customerProgressManager;
    }

    public void setCustomerProgressManager(AbstractCustomerProgressManager abstractCustomerProgressManager) {
        this.customerProgressManager = abstractCustomerProgressManager;
    }

    private final CustomerSelectionManager getCustomerSelectionManager() {
        return this.customerSelectionManager;
    }

    public void setCustomerSelectionManager(CustomerSelectionManager customerSelectionManager) {
        this.customerSelectionManager = customerSelectionManager;
    }

    public int getCurrentDeviceId() {
        int n = -1;
        if (this.currentDevice != null) {
            n = this.currentDevice.id;
        }
        return n;
    }

    public int[] getAllDeviceIds() {
        return new int[0];
    }

    public int getCurrentModuleId() {
        return -1;
    }

    CustomerDLState getCustomerDlState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    private void selectionError(String string, int n) {
        this.getLogHMI().log(1000000, "%1 selectionError(%2, %3)", (Object)CLASSNAME, (Object)string, (long)n);
        this.getSwdlModels().getCustomerErrorLabel().setText(string);
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getSwdlModels().getCustomerReadingMetaInfoStateChoice());
        switch (n) {
            case 1: {
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(2);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
                break;
            }
            case 2: {
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(3);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
                break;
            }
            default: {
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(1);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
            }
        }
        modelGroup.flush();
        modelGroup.removeAll();
        this.getLogHMI().log(10000000, "%1 selectionError: showPopupCompatibilityCheckFailure and release WaitSync mediator", (Object)CLASSNAME);
        this.getCustomerProgressManager().showPopupCompatibilityCheckFailure();
        this.getLogHMI().log(10000000, "%1 selectionError(): abort media selection! ", (Object)CLASSNAME);
        this.getCustomerProgressManager().custDownloadLeaveProgress(this.getSwdlEnv().getTerminalId());
        this.getCustomerProgressManager().swdlProgressExit();
        this.getSwdlModels().getCustomerStartDownloadButton().setStatus(1);
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
        if (baseUpdateOverTheAirController.isInstallActive()) {
            baseUpdateOverTheAirController.resumeUota(1, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map readAudiUpdate(String string) {
        this.getLogHMI().log(1000000, "%1 readAudiUpdate( %2 ) ", (Object)CLASSNAME, (Object)string);
        HashMap hashMap = new HashMap();
        if (string == null || string.length() == 0) {
            hashMap = null;
        } else {
            FileInputStream fileInputStream = null;
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(string);
                if (239 != fileInputStream.read() || 187 != fileInputStream.read() || 191 != fileInputStream.read()) {
                    fileInputStream.close();
                    fileInputStream = new FileInputStream(string);
                }
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                int n = 0;
                while (true) {
                    String string2 = bufferedReader.readLine();
                    ++n;
                    if (string2 == null) {
                        break;
                    }
                    int n2 = string2.indexOf(61);
                    if (n2 > 0 && n2 < string2.length() - 1) {
                        String string3 = string2.substring(0, n2);
                        String string4 = string2.substring(n2 + 1);
                        hashMap.put(string3, string4);
                        continue;
                    }
                    if (0 == string2.length() || '#' == string2.charAt(0)) continue;
                    this.getLogHMI().log(10000, "%1 readAudiUpdate(%2) ignore invalid line %4: '%3'", (Object)CLASSNAME, (Object)string, (Object)string2, (long)n);
                }
            }
            catch (IOException iOException) {
                this.getLogHMI().log(100000, "%1 readAudiUpdate(%2) failed with IOException %3", (Object)CLASSNAME, (Object)string, (Object)iOException);
                hashMap = null;
            }
            finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
                catch (IOException iOException) {
                    bufferedReader = null;
                }
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
                catch (IOException iOException) {
                    fileInputStream = null;
                }
            }
        }
        return hashMap;
    }

    private String getCurrentHmiLanguage() {
        return this.getSwdlEnv().getCurrentHmiLanguage();
    }

    private String[] getDeviceNames(Map map) {
        int n = 0;
        if (null != map.get("device")) {
            ++n;
        }
        for (int i2 = 2; i2 < 10; ++i2) {
            String string = "device".concat(Integer.toString(i2));
            if (null == map.get(string)) continue;
            ++n;
        }
        String[] stringArray = new String[n];
        if (n > 0) {
            int n2 = 0;
            String string = (String)map.get("device");
            if (null != string) {
                stringArray[n2++] = string;
                --n;
            }
            for (int i3 = 2; i3 < 10 && n > 0; ++i3) {
                String string2 = "device".concat(Integer.toString(i3));
                String string3 = (String)map.get(string2);
                if (null == string3) continue;
                stringArray[n2++] = string3;
                --n;
            }
        }
        return stringArray;
    }

    private String getDisplayName(Map map) {
        String string = (String)map.get(new StringBuffer().append("name.").append(this.getCurrentHmiLanguage()).toString());
        if (string == null) {
            string = (String)map.get("name.default");
        }
        return string;
    }

    private String getDisplayVersion(Map map) {
        String string = (String)map.get(new StringBuffer().append("version.").append(this.getCurrentHmiLanguage()).toString());
        if (string == null) {
            string = (String)map.get("version.default");
        }
        return string;
    }

    private void persistenceStoreSettingLists(boolean bl) {
        this.getLogHMI().log(1000000, "%1 persistenceStoreLists()", (Object)CLASSNAME);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        DeviceInfo[] deviceInfoArray = this.deviceListHandler.getDeviceAvailable2Update();
        int n = 0;
        if (deviceInfoArray != null) {
            for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
                if (bl && !((DeviceListRow)this.getSwdlModels().getDevicesListModel().getRow(i2)).isDeviceSelected()) continue;
                this.appendNewElement(stringBuffer, deviceInfoArray[i2].name);
                this.appendNewElement(stringBuffer2, deviceInfoArray[i2].displayName);
                this.appendNewElement(stringBuffer3, deviceInfoArray[i2].newVersion);
                this.appendNewElement(stringBuffer4, deviceInfoArray[i2].isNavDBUpdateMedium() ? "1" : "0");
                ++n;
            }
        }
        if (n > 0) {
            if (n == 1) {
                this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(stringBuffer2.toString());
                this.getSwdlModels().getCustomerUpdateVersionLabel().setText(stringBuffer3.toString());
            }
            this.getSwdlEnv().getStorageManager().setString(257, 5000, stringBuffer.toString());
            this.getSwdlEnv().getStorageManager().setString(257, 5001, stringBuffer2.toString());
            this.getSwdlEnv().getStorageManager().setString(257, 5002, stringBuffer3.toString());
            this.getSwdlEnv().getStorageManager().setString(257, 5004, stringBuffer4.toString());
            this.getSwdlEnv().getStorageManager().setString(257, 5003, Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
            this.getLogHMI().log(10000000, "%1   wrote deviceNames=%2", (Object)CLASSNAME, (Object)stringBuffer);
            this.getLogHMI().log(10000000, "%1   wrote displayNames=%2", (Object)CLASSNAME, (Object)stringBuffer2);
            this.getLogHMI().log(10000000, "%1   wrote deviceVersions=%2", (Object)CLASSNAME, (Object)stringBuffer3);
            this.getLogHMI().log(10000000, "%1   wrote mediaId=%2", (Object)CLASSNAME, (Object)Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
            this.getLogHMI().log(10000000, "%1   wrote naviDbChoices=%2", (Object)CLASSNAME, (Object)stringBuffer4);
        }
    }

    private void appendNewElement(StringBuffer stringBuffer, String string) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append(LIST_DELIMITER);
        }
        stringBuffer.append(string);
    }

    private void persistenceStoreSettings() {
        this.getLogHMI().log(1000000, "%1 persistenceStoreSettings", (Object)CLASSNAME);
        this.getSwdlModels().getCustomerNaviDbChoice().setValue(this.deviceListHandler.isNavDBUpdate() ? 1 : 0);
        this.getSwdlEnv().getStorageManager().setString(257, 1, this.currentUpdate.displayName);
        this.getSwdlEnv().getStorageManager().setString(257, 2, this.currentUpdate.newVersion);
        this.getSwdlEnv().getStorageManager().setString(257, 5003, Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
        this.getSwdlEnv().getStorageManager().setInt(257, 4, this.getSwdlModels().getCustomerNaviDbChoice().getValue());
        this.getLogHMI().log(10000000, "%1   wrote displayName=%2", (Object)CLASSNAME, (Object)this.currentUpdate.displayName);
        this.getLogHMI().log(10000000, "%1   wrote deviceVersion=%2", (Object)CLASSNAME, (Object)this.currentUpdate.newVersion);
        this.getLogHMI().log(10000000, "%1   wrote mediaId=%2", (Object)CLASSNAME, (Object)Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
        this.getLogHMI().log(10000000, "%1   wrote naviDbChoice=%2", (Object)CLASSNAME, (long)this.getSwdlModels().getCustomerNaviDbChoice().getValue());
    }

    private void persistenceLoadSettings() {
        int n;
        String string;
        String string2;
        String string3;
        this.getLogHMI().log(1000000, "%1 persistenceLoadSettings", (Object)CLASSNAME);
        if (this.getSwdlEnv().isSimulator()) {
            string3 = "'Name (persistence)'";
            string2 = "'Version (persistence)'";
            string = "'Media (persistence)'";
            n = 0;
        } else {
            string3 = this.getSwdlEnv().getStorageManager().getString(257, 1, this.getTextFactory().getTextConstantUnknown());
            string2 = this.getSwdlEnv().getStorageManager().getString(257, 2, "???");
            string = this.getSwdlEnv().getStorageManager().getString(257, 5003, "???");
            n = this.getSwdlEnv().getStorageManager().getInt(257, 4, 0);
            this.getSwdlModels().getCustomerNaviDbChoice().setValue(n);
        }
        this.getLogHMI().log(10000000, "%1   got displayName=%2", (Object)CLASSNAME, (Object)string3);
        this.getLogHMI().log(10000000, "%1   got deviceVersion=%2", (Object)CLASSNAME, (Object)string2);
        this.getLogHMI().log(10000000, "%1   got mediaId=%2", (Object)CLASSNAME, (Object)string);
        this.getLogHMI().log(10000000, "%1   got naviDbChoice=%2", (Object)CLASSNAME, (long)n);
        this.getSwdlModels().getCustomerUpdateNameLabel().setText(string3);
        this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(string3);
        this.getSwdlModels().getCustomerSummaryVersionLabel().setText(string2);
        this.getSwdlModels().getCustomerUpdateVersionLabel().setText(string2);
        try {
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            if (!"???".equals(string)) {
                this.getLogHMI().log(10000, "%1 persistenceLoadSettings(): incorrect media ID=%2 ", (Object)CLASSNAME, (Object)string);
            }
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(0);
        }
        this.getSwdlModels().getCustomerNaviDbChoice().setValue(n);
    }

    private void startUpdate(boolean bl) {
        this.getLogHMI().log(10000000, "%1 -- start download! ", (Object)CLASSNAME);
        this.persistenceStoreSettings();
        this.getCustomerSelectionManager().doCheckStartDownload();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogHMI().log(10000000, "%1 keyPressed(%2)", (Object)CLASSNAME, (long)n);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.getLogHMI().log(10000000, "%1 keyReleased(%2) ", (Object)CLASSNAME, (long)n);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1000000, "%1 keyTyped(modelID=%2)", (Object)CLASSNAME, (long)n);
        if (n == this.getSwdlModels().getCustomerStartDownloadButton().getID()) {
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(7);
            this.getSwdlModels().getCustomerStartDownloadButton().setStatus(0);
            this.getSwdlModels().getCustomerStartDownloadButton().fireEvent(n3);
            this.startUpdate(true);
        } else if (n == this.getSwdlModels().getCustomerAbortSelectionMediaButton().getID()) {
            this.getLogHMI().log(10000000, "%1 -- abort media selection! ", (Object)CLASSNAME);
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(6);
            this.getCustomerProgressManager().custDownloadLeaveProgress(n3);
            this.getCustomerProgressManager().swdlProgressExit();
            this.getSwdlModels().getCustomerAbortSelectionMediaButton().fireEvent(n3);
        } else {
            this.getLogHMI().log(10000000, "%1 -- ignore unexpected event(modelID: %2)", (Object)CLASSNAME, (long)n);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void doGetDevices(int n, String string, boolean bl) {
        this.getLogHMI().log(10000000, "%1 doGetDevices( %2, %3, %4 ) ", (Object)CLASSNAME, (Object)new Integer(n), (Object)string, (Object)bl);
        if (this.getCustomerDlState().isCancelRequested()) {
            this.getLogHMI().log(100000, "%1 cancel download is requested!", (Object)CLASSNAME);
            this.getCustomerDlState().cancelDone();
        } else {
            this.getLogHMI().log(10000000, "%1 call super.doGetDevices(..)", (Object)CLASSNAME);
            this.getCustomerDlState().startSelectingDevices();
            super.doGetDevices(n, string, bl);
            this.getLogHMI().log(10000000, "%1 now fetch the new device list", (Object)CLASSNAME);
            this.getDeviceInfoDSIHandler().doGetDevices();
        }
    }

    public void updateDeviceList(String[] stringArray, int[] nArray, boolean bl) {
        this.getLogHMI().log(1000000, "%1 updateDeviceList( %2, %3 ) ", (Object)CLASSNAME, (Object)stringArray, (Object)nArray);
        if (this.getCustomerDlState().isCancelRequested()) {
            this.getLogHMI().log(100000, "%1 cancel download is requested!", (Object)CLASSNAME);
            this.getCustomerDlState().cancelDone();
        } else if (this.getCustomerDlState().isSelectingDevices()) {
            this.getCustomerDlState().doneSelectingDevices();
            this.getLogHMI().log(10000000, "%1 now create and run a new DeviceListHandler", (Object)CLASSNAME);
            this.deviceListHandler = new DeviceListHandler(stringArray, nArray);
            this.getSwdlEnv().executeInUtilThread(this.deviceListHandler);
        } else {
            this.getLogHMI().log(10000, "%1 updateDeviceList() without a request, ignore this!", (Object)CLASSNAME);
        }
        this.getLogHMI().log(10000000, "%1 done updateDeviceList", (Object)CLASSNAME);
    }

    public void updateInfoFilePath(final String string, final String string2) {
        this.getLogHMI().log(10000000, "%1 updateInfoFilePath( %2, %3 ) ", (Object)CLASSNAME, (Object)string, (Object)string2);
        if (this.currentDevice != null) {
            this.getSwdlEnv().executeInUtilThread(new Runnable(){

                public void run() {
                    Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("CustomerUpdate: DeviceVersionHandler").toString());
                    if (CustomerDeviceInfoManager.this.showInstalledVersionInfo) {
                        CustomerDeviceInfoManager.this.currentDevice.setInstalledVersionInfo(string2);
                        CustomerDeviceInfoManager.this.showInstalledVersionInfo = false;
                    } else {
                        CustomerDeviceInfoManager.this.currentDevice.setVersionInfo(string, string2);
                    }
                }
            });
        } else {
            this.getLogHMI().log(10000000, "%1 updateInfoFilePath( %2, %3 ): no current device selected, ignoring update! ", (Object)CLASSNAME, (Object)string, (Object)string2);
        }
    }

    public void doGetLanguages() {
    }

    public void updateLanguageList(String[] stringArray, short s, short s2) {
    }

    public void doSelectLanguage(int n) {
    }

    public void updateSelectedLanguage(short s) {
    }

    public void updateModuleList(String[] stringArray, int[] nArray, short[] sArray) {
        this.getSwdlModels().getModuleSelectButton().setStatus(1);
    }

    public void setIsNoExclusiveBoloUpdate(boolean bl) {
    }

    public void setIsDataModule(boolean bl) {
    }

    public void updateFileList(String[] stringArray) {
    }

    public void setTargetVersions(long[] lArray) {
    }

    public void setVersions(long[] lArray) {
    }

    public void doSelectFile(int n) {
    }

    public void updateFileDetails(String string) {
    }

    public void setAdditionalInfo(int[] nArray) {
    }

    public void updateErrors(String string) {
    }

    public void updateSummary(String string) {
    }

    public void leaveSummaryChanged() {
    }

    public void checkModulesDowngrade() {
    }

    private class DeviceInfo {
        static final String CLASSNAME = "[CustomerDeviceInfoManager$DeviceInfo]";
        int id;
        String name;
        int additionalInfo;
        boolean waitingForVersionInfo = false;
        String displayName;
        String oldVersion;
        String newVersion;

        public DeviceInfo(int n, String string, int n2) {
            this.id = n;
            this.name = string;
            this.additionalInfo = n2;
            this.displayName = string;
            this.oldVersion = "-";
            this.newVersion = "???";
        }

        public String getDescription() {
            return this.displayName;
        }

        public String getVersionInfo() {
            return this.newVersion;
        }

        public String getOldVersion() {
            return this.oldVersion != null ? this.oldVersion : "";
        }

        public String getNewVersion() {
            return this.newVersion;
        }

        private String stripDeviceId(String string) {
            int n;
            String string2 = string;
            if (string != null && (n = string.indexOf(58)) > 0) {
                string2 = string.substring(0, n);
            }
            return string2;
        }

        private boolean isNavDBUpdateMedium() {
            return CustomerDeviceInfoManager.NAV_DB_DEVICE_NAME.equalsIgnoreCase(this.name) || CustomerDeviceInfoManager.SPEACH_RES_VDE_DEVICE_NAME.equalsIgnoreCase(this.name);
        }

        private boolean containsDeviceId(String[] stringArray, String string) {
            if (null == stringArray || null == string) {
                return false;
            }
            int n = stringArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.stripDeviceId(string).equals(this.stripDeviceId(stringArray[i2]))) continue;
                return true;
            }
            return false;
        }

        private void setInstalledVersionInfo(String string) {
            CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 setInstalledVersionInfo() for %2 ... ", (Object)CLASSNAME, (Object)this.name);
            Map map = CustomerDeviceInfoManager.this.readAudiUpdate(string);
            if (map != null) {
                String[] stringArray = CustomerDeviceInfoManager.this.getDeviceNames(map);
                if (this.containsDeviceId(stringArray, this.name)) {
                    this.displayName = CustomerDeviceInfoManager.this.getDisplayName(map);
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 setting display name to %2", (Object)CLASSNAME, (Object)this.displayName);
                    this.newVersion = CustomerDeviceInfoManager.this.getDisplayVersion(map);
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 setting source version to %2", (Object)CLASSNAME, (Object)this.newVersion);
                    CustomerDeviceInfoManager.this.currentUpdate = this;
                    if (CustomerDeviceInfoManager.MAIN_DEVICE_VALUE.equalsIgnoreCase((String)map.get(CustomerDeviceInfoManager.ROLE_TAG))) {
                        CustomerDeviceInfoManager.this.mainDeviceName = this.displayName;
                        CustomerDeviceInfoManager.this.mainDeviceVersion = this.newVersion;
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(CustomerDeviceInfoManager.this.mainDeviceName);
                        CustomerDeviceInfoManager.this.getSwdlModels().getUotaSummaryComponentsLabelModel().setText(CustomerDeviceInfoManager.this.mainDeviceName);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateVersionLabel().setText(CustomerDeviceInfoManager.this.mainDeviceVersion);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerSummaryVersionLabel().setText(CustomerDeviceInfoManager.this.mainDeviceVersion);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNewVersionLabel().setText(CustomerDeviceInfoManager.this.mainDeviceVersion);
                        CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 Main device found: name=%2, value=%3", (Object)CLASSNAME, (Object)CustomerDeviceInfoManager.this.mainDeviceName, (Object)CustomerDeviceInfoManager.this.mainDeviceVersion);
                    }
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 update HMI labels, set NavDBUpdate=%2 ", (Object)CLASSNAME, (Object)this.isNavDBUpdateMedium());
                    if (null == CustomerDeviceInfoManager.this.mainDeviceName || null == CustomerDeviceInfoManager.this.mainDeviceVersion) {
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(this.getDescription());
                        CustomerDeviceInfoManager.this.getSwdlModels().getUotaSummaryComponentsLabelModel().setText(this.getDescription());
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateVersionLabel().setText(this.getVersionInfo());
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerSummaryVersionLabel().setText(this.newVersion);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNewVersionLabel().setText(this.getNewVersion());
                    }
                    if (this.isNavDBUpdateMedium()) {
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNaviDbChoice().setValue(1);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerCurrentVersionLabel().setText("");
                    } else {
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNaviDbChoice().setValue(0);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerCurrentVersionLabel().setText(this.getOldVersion());
                    }
                } else {
                    CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 Error: inconsistent device Name: expected %2 got %3 ", (Object)CLASSNAME, (Object)this.name, (Object)stringArray);
                }
            } else {
                CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 No [Audi]Update.txt found, do not use this device for Customer Update! ", (Object)CLASSNAME);
            }
            this.triggerVersionInfoRead();
        }

        private void setVersionInfo(String string, String string2) {
            String[] stringArray;
            CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 setVersionInfo() for %2 ... ", (Object)CLASSNAME, (Object)this.name);
            Map map = CustomerDeviceInfoManager.this.readAudiUpdate(string);
            Map map2 = CustomerDeviceInfoManager.this.readAudiUpdate(string2);
            if (map != null) {
                stringArray = CustomerDeviceInfoManager.this.getDeviceNames(map);
                if (this.containsDeviceId(stringArray, this.name)) {
                    this.displayName = CustomerDeviceInfoManager.this.getDisplayName(map);
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 setting display name to %2", (Object)CLASSNAME, (Object)this.displayName);
                    this.newVersion = CustomerDeviceInfoManager.this.getDisplayVersion(map);
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 setting source version to %2", (Object)CLASSNAME, (Object)this.newVersion);
                    CustomerDeviceInfoManager.this.currentUpdate = this;
                    if (CustomerDeviceInfoManager.MAIN_DEVICE_VALUE.equalsIgnoreCase((String)map.get(CustomerDeviceInfoManager.ROLE_TAG))) {
                        CustomerDeviceInfoManager.this.mainDeviceName = this.displayName;
                        CustomerDeviceInfoManager.this.mainDeviceVersion = this.newVersion;
                        CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 Main device found: name=%2, value=%3", (Object)CLASSNAME, (Object)CustomerDeviceInfoManager.this.mainDeviceName, (Object)CustomerDeviceInfoManager.this.mainDeviceVersion);
                    }
                } else {
                    CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 Error: inconsistent source device Name: expected %2 got %3 ", (Object)CLASSNAME, (Object)this.name, (Object)stringArray);
                }
            } else {
                CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 No AudiUpdate.txt found, do not use this device for Customer Update! ", (Object)CLASSNAME);
            }
            if (map2 != null) {
                stringArray = CustomerDeviceInfoManager.this.getDeviceNames(map2);
                if (this.containsDeviceId(stringArray, this.name)) {
                    this.oldVersion = CustomerDeviceInfoManager.this.getDisplayVersion(map2);
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 setting destination version to %2 ", (Object)CLASSNAME, (Object)this.oldVersion);
                } else {
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 Error: inconsistent dest device Name: expected %2 got %3 ", (Object)CLASSNAME, (Object)this.name, (Object)stringArray);
                }
            } else {
                this.oldVersion = null;
            }
            if (CustomerDeviceInfoManager.this.currentUpdate == this) {
                CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 update HMI labels, set NavDBUpdate=%2 ", (Object)CLASSNAME, (Object)this.isNavDBUpdateMedium());
                CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateNameLabel().setText(this.getDescription());
                CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateVersionLabel().setText(this.getVersionInfo());
                CustomerDeviceInfoManager.this.getSwdlModels().getCustomerSummaryVersionLabel().setText(this.newVersion);
                CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNewVersionLabel().setText(this.getNewVersion());
                if (this.isNavDBUpdateMedium()) {
                    CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNaviDbChoice().setValue(1);
                    CustomerDeviceInfoManager.this.getSwdlModels().getCustomerCurrentVersionLabel().setText("");
                } else {
                    CustomerDeviceInfoManager.this.getSwdlModels().getCustomerNaviDbChoice().setValue(0);
                    CustomerDeviceInfoManager.this.getSwdlModels().getCustomerCurrentVersionLabel().setText(this.getOldVersion());
                }
            }
            this.triggerVersionInfoRead();
        }

        private void startReadVersionInfo() {
            CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 startReadVersionInfo() for %2 ...", (Object)CLASSNAME, (Object)this.name);
            this.waitingForVersionInfo = true;
            this.doReadVersionInfo(this.id);
            this.waitForVersionInfo();
        }

        public void doReadVersionInfo(int n) {
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doReadVersionInfo(deviceIndex=%2)", (Object)CLASSNAME, (long)n);
            CustomerDeviceInfoManager.this.getDeviceInfoDSIHandler().doGetFileInfoPath(n);
        }

        private void doDeSelect() {
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doDeSelect() for %2 additionalInfo=%3", (Object)CLASSNAME, (Object)this.name, (long)this.additionalInfo);
            switch (this.additionalInfo) {
                case 0: 
                case 2: 
                case 3: 
                case 4: 
                case 14: {
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doDeselect() for %2 not needed! additionalInfo=%3 ", (Object)CLASSNAME, (Object)this.name, (long)this.additionalInfo);
                    break;
                }
                default: {
                    CustomerDeviceInfoManager.this.getDeviceInfoDSIHandler().doSetDeviceSelection(this.id, 0);
                    this.additionalInfo = 2;
                }
            }
        }

        private boolean doSelect() {
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doSelect() for %2, additionalInfo=%3", (Object)CLASSNAME, (Object)this.name, (long)this.additionalInfo);
            switch (this.additionalInfo) {
                case 1: 
                case 5: 
                case 6: {
                    CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doSelect() for %2 not needed (addInfo=%3)! ", (Object)CLASSNAME, (Object)this.name, (long)this.additionalInfo);
                    return true;
                }
                case 2: 
                case 14: {
                    CustomerDeviceInfoManager.this.getDeviceInfoDSIHandler().doSetDeviceSelection(this.id, 1);
                    this.additionalInfo = 1;
                    return true;
                }
            }
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 doSelect() for %2 not possible (addInfo=%3)! ", (Object)CLASSNAME, (Object)this.name, (long)this.additionalInfo);
            return false;
        }

        private synchronized void triggerVersionInfoRead() {
            CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 triggerVersionInfoRead() for %2 ", (Object)CLASSNAME, (Object)this.name);
            this.waitingForVersionInfo = false;
            this.notifyAll();
        }

        private synchronized void waitForVersionInfo() {
            CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 waitForVersionInfo() for %2 started ", (Object)CLASSNAME, (Object)this.name);
            if (this.waitingForVersionInfo) {
                try {
                    this.wait(10000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            if (this.waitingForVersionInfo) {
                CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 waitForVersionInfo() for %2 timed out! ", (Object)CLASSNAME, (Object)this.name);
                this.waitingForVersionInfo = false;
            }
        }
    }

    private class DeviceListRow
    extends EvoListRow {
        private static final int COLUMN_NUMBER = 4;
        private static final int COLUMN_COMPONENT_NAME = 0;
        private static final int COLUMN_COMPONENT_SELECTED = 1;
        private static final int COLUMN_COMPONENT_VERSION = 2;
        private static final int COLUMN_COMPONENT_LIST_INDEX = 3;
        private static final int SELECTED = 1;
        private static final int NOT_SELECTED = 0;
        private int internalDeviceIndex;

        public DeviceListRow(DeviceInfo deviceInfo, boolean bl, int n) {
            super(n, 4);
            this.setText(0, deviceInfo.getDescription());
            this.setInteger(1, bl ? 1 : 0);
            this.setText(2, deviceInfo.getNewVersion());
            this.setInteger(3, n);
            this.setInternalDeviceIndex(deviceInfo.id);
        }

        public boolean equals(Object object) {
            return super.equals(object) && this.hasEqualCells((EvoListRow)object);
        }

        private boolean hasEqualCells(EvoListRow evoListRow) {
            if (evoListRow.getColumnCount() == this.getColumnCount()) {
                for (int i2 = 0; i2 < this.getColumnCount(); ++i2) {
                    if (evoListRow.getCell(i2) != null && evoListRow.getCell(i2).equals(this.getCell(i2))) continue;
                    return false;
                }
                return true;
            }
            return false;
        }

        public DeviceListRow(DeviceListRow deviceListRow) {
            super(deviceListRow);
            this.setInternalDeviceIndex(deviceListRow.getInternalDeviceIndex());
        }

        public EvoListRow copy() {
            return new DeviceListRow(this);
        }

        public int getInternalDeviceIndex() {
            return this.internalDeviceIndex;
        }

        private void setInternalDeviceIndex(int n) {
            this.internalDeviceIndex = n;
        }

        private boolean isDeviceSelected() {
            return this.getInteger(1) == 1;
        }

        private void setSelected(boolean bl) {
            this.setInteger(1, bl ? 1 : 0);
        }

        public String toString() {
            return new StringBuffer("[DeviceListRow]:").append(this.getText(0)).append(",version=").append(this.getText(2)).append(",isselected=").append(this.getInteger(1)).append(",listIndex=").append(this.getInteger(3)).toString();
        }
    }

    private class DeviceListHandler
    implements Runnable {
        static final String CLASSNAME = "[CustomerDeviceInfoManager$DeviceListHandler]";
        String[] devices;
        DeviceInfo[] deviceAvailable2Update;
        int[] additionalInfo;
        int deviceAvailable2UpdateCount = 0;

        DeviceListHandler(String[] stringArray, int[] nArray) {
            this.devices = stringArray;
            this.additionalInfo = nArray;
            if (stringArray != null) {
                this.deviceAvailable2Update = new DeviceInfo[stringArray.length];
                this.deviceAvailable2UpdateCount = stringArray.length;
            }
            CustomerDeviceInfoManager.this.mainDeviceName = null;
            CustomerDeviceInfoManager.this.mainDeviceVersion = null;
        }

        private boolean checkCancel() {
            boolean bl = false;
            if (CustomerDeviceInfoManager.this.getCustomerDlState().isCancelRequested()) {
                CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 cancel device selection is requested!", (Object)CLASSNAME);
                CustomerDeviceInfoManager.this.getCustomerDlState().cancelDone();
                bl = true;
            }
            return bl;
        }

        private void cleanUpDeviceSelection() {
            this.devices = new String[0];
            this.deviceAvailable2Update = new DeviceInfo[0];
            this.additionalInfo = new int[0];
            this.deviceAvailable2UpdateCount = 0;
        }

        private boolean isNavDBUpdate() {
            if (this.deviceAvailable2Update != null) {
                for (int i2 = 0; i2 < this.deviceAvailable2Update.length; ++i2) {
                    if (this.deviceAvailable2Update[i2] == null || !this.deviceAvailable2Update[i2].isNavDBUpdateMedium()) continue;
                    return true;
                }
            }
            return false;
        }

        private void clearDeviceNotAvailable2Update(int n) {
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 clearUpdateDevice(%2): %3", (Object)CLASSNAME, (Object)Integer.toString(n), (Object)this.deviceAvailable2Update[n].displayName);
            this.deviceAvailable2Update[n] = null;
            --this.deviceAvailable2UpdateCount;
        }

        private void selectDevice(int n, boolean bl) {
            DeviceInfo deviceInfo = this.deviceAvailable2Update[n];
            if (deviceInfo != null) {
                CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "%1 selectDevice(id=%2, select=%3)", (Object)CLASSNAME, (Object)Integer.toString(n), (Object)Boolean.toString(bl));
                if (bl) {
                    deviceInfo.doSelect();
                } else {
                    deviceInfo.doDeSelect();
                }
            } else {
                CustomerDeviceInfoManager.this.getLogHMI().log(10000, "%1 selectDevice(id=%2, select=%3) the software update for device with id=%2 is not available and can't be selected or deselected", (Object)CLASSNAME, (Object)Integer.toString(n), (Object)Boolean.toString(bl));
            }
        }

        private DeviceInfo[] getDeviceAvailable2Update() {
            DeviceInfo[] deviceInfoArray = null;
            CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 getDeviceAvailable2Update(): count= %2", (Object)CLASSNAME, (long)this.deviceAvailable2UpdateCount);
            if (this.deviceAvailable2UpdateCount > 0) {
                deviceInfoArray = new DeviceInfo[this.deviceAvailable2UpdateCount];
                int n = 0;
                for (int i2 = 0; i2 < this.deviceAvailable2Update.length; ++i2) {
                    if (this.deviceAvailable2Update[i2] == null) continue;
                    deviceInfoArray[n++] = this.deviceAvailable2Update[i2];
                }
            }
            return deviceInfoArray;
        }

        private int getDeviceAvailable2UpdateCount() {
            return this.deviceAvailable2UpdateCount;
        }

        public void run() {
            Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("CustomerUpdate: DeviceListHandler").toString());
            BaseUpdateOverTheAirController baseUpdateOverTheAirController = CustomerDeviceInfoManager.this.getSwdlEnv().getHMISwitcher().getUOTAController();
            CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 processing devices ", (Object)CLASSNAME);
            if (CustomerDeviceInfoManager.this.checkAccessType(1)) {
                CustomerDeviceInfoManager.this.currentUpdate = null;
                CustomerDeviceInfoManager.this.showInstalledVersionInfo = false;
                for (int i2 = 0; i2 < this.devices.length; ++i2) {
                    this.deviceAvailable2Update[i2] = new DeviceInfo(i2, this.devices[i2], this.additionalInfo[i2]);
                    CustomerDeviceInfoManager.this.currentDevice = this.deviceAvailable2Update[i2];
                    CustomerDeviceInfoManager.this.currentDevice.startReadVersionInfo();
                    if (((CustomerDeviceInfoManager)CustomerDeviceInfoManager.this).currentDevice.additionalInfo == 1 || ((CustomerDeviceInfoManager)CustomerDeviceInfoManager.this).currentDevice.additionalInfo == 2) {
                        CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 Device: %2 VersionInfo: %3 ", (Object)CLASSNAME, (Object)CustomerDeviceInfoManager.this.currentDevice.getDescription(), (Object)CustomerDeviceInfoManager.this.currentDevice.getVersionInfo());
                    } else {
                        CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 ignoring device: %2 ", (Object)CLASSNAME, (Object)((CustomerDeviceInfoManager)CustomerDeviceInfoManager.this).currentDevice.name);
                    }
                    if (CustomerDeviceInfoManager.this.currentDevice.equals(CustomerDeviceInfoManager.this.currentUpdate)) {
                        if (!CustomerDeviceInfoManager.this.currentDevice.doSelect()) {
                            CustomerDeviceInfoManager.this.currentUpdate = null;
                            this.clearDeviceNotAvailable2Update(i2);
                            break;
                        }
                    } else {
                        CustomerDeviceInfoManager.this.currentDevice.doDeSelect();
                        this.clearDeviceNotAvailable2Update(i2);
                    }
                    if (!this.checkCancel()) continue;
                    this.cleanUpDeviceSelection();
                    return;
                }
                DeviceInfo[] deviceInfoArray = CustomerDeviceInfoManager.this.deviceListHandler.getDeviceAvailable2Update();
                if (null != CustomerDeviceInfoManager.this.currentUpdate) {
                    CustomerDeviceInfoManager.this.getSwdlModels().getCustomerProgressStateChoice().setValue(2);
                    if (baseUpdateOverTheAirController.isInstallActive()) {
                        CustomerDeviceInfoManager.this.startUpdate(false);
                    } else {
                        if (null != CustomerDeviceInfoManager.this.mainDeviceName) {
                            ((CustomerDeviceInfoManager)CustomerDeviceInfoManager.this).currentUpdate.displayName = CustomerDeviceInfoManager.this.mainDeviceName;
                        }
                        if (null != CustomerDeviceInfoManager.this.mainDeviceVersion) {
                            ((CustomerDeviceInfoManager)CustomerDeviceInfoManager.this).currentUpdate.newVersion = CustomerDeviceInfoManager.this.mainDeviceVersion;
                        }
                        CustomerDeviceInfoManager.this.getLogHMI().log(1000000, "%1 Update Device: %2 VersionInfo: %3 ", (Object)CLASSNAME, (Object)CustomerDeviceInfoManager.this.currentUpdate.getDescription(), (Object)CustomerDeviceInfoManager.this.currentUpdate.getVersionInfo());
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerProgressStateChoice().setValue(2);
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(CustomerDeviceInfoManager.this.currentUpdate.getDescription());
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerUpdateVersionLabel().setText(CustomerDeviceInfoManager.this.currentUpdate.getVersionInfo());
                        ModelGroup modelGroup = new ModelGroup();
                        modelGroup.add(CustomerDeviceInfoManager.this.getSwdlModels().getCustomerReadingMetaInfoStateChoice());
                        if (!this.checkCancel()) {
                            CustomerDeviceInfoManager.this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(1);
                            CustomerDeviceInfoManager.this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(1);
                            modelGroup.flush();
                            modelGroup.removeAll();
                            CustomerDeviceInfoManager.this.persistenceStoreSettings();
                        }
                    }
                } else {
                    CustomerDeviceInfoManager.this.selectionError(CustomerDeviceInfoManager.this.getTextFactory().getTextConstantCustNoDevice(), 1);
                }
            } else if (CustomerDeviceInfoManager.this.checkAccessType(2)) {
                CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 run(): accessType=showSummary", (Object)CLASSNAME);
                boolean bl = false;
                for (int i3 = 0; i3 < this.additionalInfo.length; ++i3) {
                    if (this.additionalInfo[i3] == 3) {
                        bl = true;
                        break;
                    }
                    if (this.additionalInfo[i3] != 2) continue;
                    CustomerDeviceInfoManager.this.currentDevice = new DeviceInfo(i3, this.devices[i3], this.additionalInfo[i3]);
                    CustomerDeviceInfoManager.this.showInstalledVersionInfo = true;
                    CustomerDeviceInfoManager.this.currentDevice.startReadVersionInfo();
                }
                if (baseUpdateOverTheAirController.isInstallActive()) {
                    CustomerDeviceInfoManager.this.getCustomerProgressManager().switchUotaProgressState(bl);
                } else {
                    if (bl) {
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerSummaryStatusLabel().setText(CustomerDeviceInfoManager.this.getTextFactory().getTextConstantCustDevInfoManagerUnsuccess());
                    } else {
                        CustomerDeviceInfoManager.this.getSwdlModels().getCustomerSummaryStatusLabel().setText(CustomerDeviceInfoManager.this.getTextFactory().getTextConstantCustDevInfoManagerSuccess());
                    }
                    try {
                        CustomerDeviceInfoManager.this.getCustomerProgressManager().showSummary(bl);
                    }
                    catch (Exception exception) {
                        CustomerDeviceInfoManager.this.getLogHMI().log(100000, "%1 showSummary failed! ", (Object)CLASSNAME, (Throwable)exception);
                    }
                }
            }
        }
    }

    private class DeviceListListener
    implements BaseListModelListener {
        private DeviceListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DeviceListRow deviceListRow;
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "[CustomerDeviceInfoManager$DeviceListListener].itemSelected(row=%1,model=%2,terminal=%3)", (Object)evoListRow, (long)n, (long)n4);
            if (n == CustomerDeviceInfoManager.this.getSwdlModels().getDevicesListModel().getID() && null != (deviceListRow = (DeviceListRow)evoListRow)) {
                boolean bl = deviceListRow.isDeviceSelected();
                CustomerDeviceInfoManager.this.deviceListHandler.selectDevice(deviceListRow.getInternalDeviceIndex(), !bl);
                DeviceListRow deviceListRow2 = new DeviceListRow(deviceListRow);
                deviceListRow2.setSelected(!bl);
                CustomerDeviceInfoManager.this.getSwdlModels().getDevicesListModel().setRow(n2, deviceListRow2);
                this.updateStartUpdateButton();
            }
        }

        private void updateStartUpdateButton() {
            boolean bl = false;
            for (int i2 = 0; i2 < CustomerDeviceInfoManager.this.deviceListHandler.getDeviceAvailable2UpdateCount(); ++i2) {
                if (!((DeviceListRow)CustomerDeviceInfoManager.this.getSwdlModels().getDevicesListModel().getRow(i2)).isDeviceSelected()) continue;
                bl = true;
                break;
            }
            CustomerDeviceInfoManager.this.getLogHMI().log(10000000, "[CustomerDeviceInfoManager$DeviceListListener].updateStartUpdateButton(): isEnabled = %1", bl);
            CustomerDeviceInfoManager.this.getSwdlModels().getCustomerStartDownloadButton().setStatus(bl ? 1 : 0);
        }

        public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        }

        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        }
    }
}

