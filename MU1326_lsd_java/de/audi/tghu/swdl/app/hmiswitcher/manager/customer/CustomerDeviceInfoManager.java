/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.AbstractCustomerProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$1;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceInfo;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceListHandler;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceListListener;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceListRow;
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
    private static final String NAV_DB_DEVICE_NAME;
    private static final String SPEACH_RES_VDE_DEVICE_NAME;
    private static final String CLASSNAME;
    private static final long DEVICE_TIMEOUT;
    public static final String LIST_DELIMITER;
    public static final String MAIN_DEVICE_VALUE;
    public static final String ROLE_TAG;
    private volatile String mainDeviceName = null;
    private volatile String mainDeviceVersion = null;
    private static final boolean NEW_MODELS;
    private CustomerDeviceInfoManager$DeviceInfo currentDevice = null;
    private CustomerDeviceInfoManager$DeviceInfo currentUpdate = null;
    private CustomerDeviceInfoManager$DeviceListHandler deviceListHandler = null;
    private CustomerSelectionManager customerSelectionManager;
    private AbstractCustomerProgressManager customerProgressManager;
    private boolean showInstalledVersionInfo = false;
    static final int ERROR_TYPE_WRONG_DATA;
    static final int ERROR_TYPE_NO_DATA;
    static final int ERROR_TYPE_DATA_NOT_ACTIVATED;

    public CustomerDeviceInfoManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerDeviceInfo);
        this.getLogHMI().log(1078071040, "%1 <init>", (Object)"[CustomerDeviceInfoManager]");
        this.getSwdlModels().getDevicesListModel().setListener(new CustomerDeviceInfoManager$DeviceListListener(this, null));
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

    @Override
    public int getCurrentDeviceId() {
        int n = -1;
        if (this.currentDevice != null) {
            n = this.currentDevice.id;
        }
        return n;
    }

    @Override
    public int[] getAllDeviceIds() {
        return new int[0];
    }

    @Override
    public int getCurrentModuleId() {
        return -1;
    }

    CustomerDLState getCustomerDlState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    private void selectionError(String string, int n) {
        this.getLogHMI().log(1078071040, "%1 selectionError(%2, %3)", (Object)"[CustomerDeviceInfoManager]", (Object)string, (long)n);
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
        this.getLogHMI().log(-2137614336, "%1 selectionError: showPopupCompatibilityCheckFailure and release WaitSync mediator", (Object)"[CustomerDeviceInfoManager]");
        this.getCustomerProgressManager().showPopupCompatibilityCheckFailure();
        this.getLogHMI().log(-2137614336, "%1 selectionError(): abort media selection! ", (Object)"[CustomerDeviceInfoManager]");
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
        this.getLogHMI().log(1078071040, "%1 readAudiUpdate( %2 ) ", (Object)"[CustomerDeviceInfoManager]", (Object)string);
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
                    this.getLogHMI().log(10000, "%1 readAudiUpdate(%2) ignore invalid line %4: '%3'", (Object)"[CustomerDeviceInfoManager]", (Object)string, (Object)string2, (long)n);
                }
            }
            catch (IOException iOException) {
                this.getLogHMI().log(-1601830656, "%1 readAudiUpdate(%2) failed with IOException %3", (Object)"[CustomerDeviceInfoManager]", (Object)string, (Object)iOException);
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
        this.getLogHMI().log(1078071040, "%1 persistenceStoreLists()", (Object)"[CustomerDeviceInfoManager]");
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        CustomerDeviceInfoManager$DeviceInfo[] customerDeviceInfoManager$DeviceInfoArray = CustomerDeviceInfoManager$DeviceListHandler.access$100(this.deviceListHandler);
        int n = 0;
        if (customerDeviceInfoManager$DeviceInfoArray != null) {
            for (int i2 = 0; i2 < customerDeviceInfoManager$DeviceInfoArray.length; ++i2) {
                if (bl && !CustomerDeviceInfoManager$DeviceListRow.access$200((CustomerDeviceInfoManager$DeviceListRow)this.getSwdlModels().getDevicesListModel().getRow(i2))) continue;
                this.appendNewElement(stringBuffer, customerDeviceInfoManager$DeviceInfoArray[i2].name);
                this.appendNewElement(stringBuffer2, customerDeviceInfoManager$DeviceInfoArray[i2].displayName);
                this.appendNewElement(stringBuffer3, customerDeviceInfoManager$DeviceInfoArray[i2].newVersion);
                this.appendNewElement(stringBuffer4, CustomerDeviceInfoManager$DeviceInfo.access$300(customerDeviceInfoManager$DeviceInfoArray[i2]) ? "1" : "0");
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
            this.getLogHMI().log(-2137614336, "%1   wrote deviceNames=%2", (Object)"[CustomerDeviceInfoManager]", (Object)stringBuffer);
            this.getLogHMI().log(-2137614336, "%1   wrote displayNames=%2", (Object)"[CustomerDeviceInfoManager]", (Object)stringBuffer2);
            this.getLogHMI().log(-2137614336, "%1   wrote deviceVersions=%2", (Object)"[CustomerDeviceInfoManager]", (Object)stringBuffer3);
            this.getLogHMI().log(-2137614336, "%1   wrote mediaId=%2", (Object)"[CustomerDeviceInfoManager]", (Object)Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
            this.getLogHMI().log(-2137614336, "%1   wrote naviDbChoices=%2", (Object)"[CustomerDeviceInfoManager]", (Object)stringBuffer4);
        }
    }

    private void appendNewElement(StringBuffer stringBuffer, String string) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append("|");
        }
        stringBuffer.append(string);
    }

    private void persistenceStoreSettings() {
        this.getLogHMI().log(1078071040, "%1 persistenceStoreSettings", (Object)"[CustomerDeviceInfoManager]");
        this.getSwdlModels().getCustomerNaviDbChoice().setValue(CustomerDeviceInfoManager$DeviceListHandler.access$400(this.deviceListHandler) ? 1 : 0);
        this.getSwdlEnv().getStorageManager().setString(257, 1, this.currentUpdate.displayName);
        this.getSwdlEnv().getStorageManager().setString(257, 2, this.currentUpdate.newVersion);
        this.getSwdlEnv().getStorageManager().setString(257, 5003, Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
        this.getSwdlEnv().getStorageManager().setInt(257, 4, this.getSwdlModels().getCustomerNaviDbChoice().getValue());
        this.getLogHMI().log(-2137614336, "%1   wrote displayName=%2", (Object)"[CustomerDeviceInfoManager]", (Object)this.currentUpdate.displayName);
        this.getLogHMI().log(-2137614336, "%1   wrote deviceVersion=%2", (Object)"[CustomerDeviceInfoManager]", (Object)this.currentUpdate.newVersion);
        this.getLogHMI().log(-2137614336, "%1   wrote mediaId=%2", (Object)"[CustomerDeviceInfoManager]", (Object)Integer.toString(this.getSwdlModels().getCustomerSelectionSourceChoice().getValue()));
        this.getLogHMI().log(-2137614336, "%1   wrote naviDbChoice=%2", (Object)"[CustomerDeviceInfoManager]", (long)this.getSwdlModels().getCustomerNaviDbChoice().getValue());
    }

    private void persistenceLoadSettings() {
        int n;
        String string;
        String string2;
        String string3;
        this.getLogHMI().log(1078071040, "%1 persistenceLoadSettings", (Object)"[CustomerDeviceInfoManager]");
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
        this.getLogHMI().log(-2137614336, "%1   got displayName=%2", (Object)"[CustomerDeviceInfoManager]", (Object)string3);
        this.getLogHMI().log(-2137614336, "%1   got deviceVersion=%2", (Object)"[CustomerDeviceInfoManager]", (Object)string2);
        this.getLogHMI().log(-2137614336, "%1   got mediaId=%2", (Object)"[CustomerDeviceInfoManager]", (Object)string);
        this.getLogHMI().log(-2137614336, "%1   got naviDbChoice=%2", (Object)"[CustomerDeviceInfoManager]", (long)n);
        this.getSwdlModels().getCustomerUpdateNameLabel().setText(string3);
        this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(string3);
        this.getSwdlModels().getCustomerSummaryVersionLabel().setText(string2);
        this.getSwdlModels().getCustomerUpdateVersionLabel().setText(string2);
        try {
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            if (!"???".equals(string)) {
                this.getLogHMI().log(10000, "%1 persistenceLoadSettings(): incorrect media ID=%2 ", (Object)"[CustomerDeviceInfoManager]", (Object)string);
            }
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(0);
        }
        this.getSwdlModels().getCustomerNaviDbChoice().setValue(n);
    }

    private void startUpdate(boolean bl) {
        this.getLogHMI().log(-2137614336, "%1 -- start download! ", (Object)"[CustomerDeviceInfoManager]");
        this.persistenceStoreSettings();
        this.getCustomerSelectionManager().doCheckStartDownload();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogHMI().log(-2137614336, "%1 keyPressed(%2)", (Object)"[CustomerDeviceInfoManager]", (long)n);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.getLogHMI().log(-2137614336, "%1 keyReleased(%2) ", (Object)"[CustomerDeviceInfoManager]", (long)n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1078071040, "%1 keyTyped(modelID=%2)", (Object)"[CustomerDeviceInfoManager]", (long)n);
        if (n == this.getSwdlModels().getCustomerStartDownloadButton().getID()) {
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(7);
            this.getSwdlModels().getCustomerStartDownloadButton().setStatus(0);
            this.getSwdlModels().getCustomerStartDownloadButton().fireEvent(n3);
            this.startUpdate(true);
        } else if (n == this.getSwdlModels().getCustomerAbortSelectionMediaButton().getID()) {
            this.getLogHMI().log(-2137614336, "%1 -- abort media selection! ", (Object)"[CustomerDeviceInfoManager]");
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(6);
            this.getCustomerProgressManager().custDownloadLeaveProgress(n3);
            this.getCustomerProgressManager().swdlProgressExit();
            this.getSwdlModels().getCustomerAbortSelectionMediaButton().fireEvent(n3);
        } else {
            this.getLogHMI().log(-2137614336, "%1 -- ignore unexpected event(modelID: %2)", (Object)"[CustomerDeviceInfoManager]", (long)n);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void doGetDevices(int n, String string, boolean bl) {
        this.getLogHMI().log(-2137614336, "%1 doGetDevices( %2, %3, %4 ) ", (Object)"[CustomerDeviceInfoManager]", (Object)new Integer(n), (Object)string, (Object)bl);
        if (this.getCustomerDlState().isCancelRequested()) {
            this.getLogHMI().log(-1601830656, "%1 cancel download is requested!", (Object)"[CustomerDeviceInfoManager]");
            this.getCustomerDlState().cancelDone();
        } else {
            this.getLogHMI().log(-2137614336, "%1 call super.doGetDevices(..)", (Object)"[CustomerDeviceInfoManager]");
            this.getCustomerDlState().startSelectingDevices();
            super.doGetDevices(n, string, bl);
            this.getLogHMI().log(-2137614336, "%1 now fetch the new device list", (Object)"[CustomerDeviceInfoManager]");
            this.getDeviceInfoDSIHandler().doGetDevices();
        }
    }

    @Override
    public void updateDeviceList(String[] stringArray, int[] nArray, boolean bl) {
        this.getLogHMI().log(1078071040, "%1 updateDeviceList( %2, %3 ) ", (Object)"[CustomerDeviceInfoManager]", (Object)stringArray, (Object)nArray);
        if (this.getCustomerDlState().isCancelRequested()) {
            this.getLogHMI().log(-1601830656, "%1 cancel download is requested!", (Object)"[CustomerDeviceInfoManager]");
            this.getCustomerDlState().cancelDone();
        } else if (this.getCustomerDlState().isSelectingDevices()) {
            this.getCustomerDlState().doneSelectingDevices();
            this.getLogHMI().log(-2137614336, "%1 now create and run a new DeviceListHandler", (Object)"[CustomerDeviceInfoManager]");
            this.deviceListHandler = new CustomerDeviceInfoManager$DeviceListHandler(this, stringArray, nArray);
            this.getSwdlEnv().executeInUtilThread(this.deviceListHandler);
        } else {
            this.getLogHMI().log(10000, "%1 updateDeviceList() without a request, ignore this!", (Object)"[CustomerDeviceInfoManager]");
        }
        this.getLogHMI().log(-2137614336, "%1 done updateDeviceList", (Object)"[CustomerDeviceInfoManager]");
    }

    @Override
    public void updateInfoFilePath(String string, String string2) {
        this.getLogHMI().log(-2137614336, "%1 updateInfoFilePath( %2, %3 ) ", (Object)"[CustomerDeviceInfoManager]", (Object)string, (Object)string2);
        if (this.currentDevice != null) {
            this.getSwdlEnv().executeInUtilThread(new CustomerDeviceInfoManager$1(this, string2, string));
        } else {
            this.getLogHMI().log(-2137614336, "%1 updateInfoFilePath( %2, %3 ): no current device selected, ignoring update! ", (Object)"[CustomerDeviceInfoManager]", (Object)string, (Object)string2);
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

    @Override
    public void updateModuleList(String[] stringArray, int[] nArray, short[] sArray) {
        this.getSwdlModels().getModuleSelectButton().setStatus(1);
    }

    @Override
    public void setIsNoExclusiveBoloUpdate(boolean bl) {
    }

    @Override
    public void setIsDataModule(boolean bl) {
    }

    @Override
    public void updateFileList(String[] stringArray) {
    }

    @Override
    public void setTargetVersions(long[] lArray) {
    }

    @Override
    public void setVersions(long[] lArray) {
    }

    @Override
    public void doSelectFile(int n) {
    }

    @Override
    public void updateFileDetails(String string) {
    }

    @Override
    public void setAdditionalInfo(int[] nArray) {
    }

    @Override
    public void updateErrors(String string) {
    }

    @Override
    public void updateSummary(String string) {
    }

    @Override
    public void leaveSummaryChanged() {
    }

    @Override
    public void checkModulesDowngrade() {
    }

    static /* synthetic */ LogChannel access$500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ Map access$600(CustomerDeviceInfoManager customerDeviceInfoManager, String string) {
        return customerDeviceInfoManager.readAudiUpdate(string);
    }

    static /* synthetic */ String[] access$700(CustomerDeviceInfoManager customerDeviceInfoManager, Map map) {
        return customerDeviceInfoManager.getDeviceNames(map);
    }

    static /* synthetic */ String access$800(CustomerDeviceInfoManager customerDeviceInfoManager, Map map) {
        return customerDeviceInfoManager.getDisplayName(map);
    }

    static /* synthetic */ LogChannel access$900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ String access$1000(CustomerDeviceInfoManager customerDeviceInfoManager, Map map) {
        return customerDeviceInfoManager.getDisplayVersion(map);
    }

    static /* synthetic */ LogChannel access$1100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceInfo access$1202(CustomerDeviceInfoManager customerDeviceInfoManager, CustomerDeviceInfoManager$DeviceInfo deviceInfo) {
        customerDeviceInfoManager.currentUpdate = deviceInfo;
        return customerDeviceInfoManager.currentUpdate;
    }

    static /* synthetic */ String access$1302(CustomerDeviceInfoManager customerDeviceInfoManager, String string) {
        customerDeviceInfoManager.mainDeviceName = string;
        return customerDeviceInfoManager.mainDeviceName;
    }

    static /* synthetic */ String access$1402(CustomerDeviceInfoManager customerDeviceInfoManager, String string) {
        customerDeviceInfoManager.mainDeviceVersion = string;
        return customerDeviceInfoManager.mainDeviceVersion;
    }

    static /* synthetic */ String access$1300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.mainDeviceName;
    }

    static /* synthetic */ SwdlModels access$1500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$1600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ String access$1400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.mainDeviceVersion;
    }

    static /* synthetic */ SwdlModels access$1700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$1800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$1900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$2000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$2100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$2200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$2900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$3000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$3100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$3900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$4000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceInfo access$1200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.currentUpdate;
    }

    static /* synthetic */ LogChannel access$4100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$4200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$4900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$5000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$5100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlDSIHandlerDeviceInfo access$5200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getDeviceInfoDSIHandler();
    }

    static /* synthetic */ LogChannel access$5300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$5400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlDSIHandlerDeviceInfo access$5500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getDeviceInfoDSIHandler();
    }

    static /* synthetic */ LogChannel access$5600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$5700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlDSIHandlerDeviceInfo access$5800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getDeviceInfoDSIHandler();
    }

    static /* synthetic */ LogChannel access$5900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$6000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$6100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$6200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$6300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$6400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceListHandler access$6500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.deviceListHandler;
    }

    static /* synthetic */ SwdlModels access$6800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$7000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$7100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$7200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$7300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$7400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$7500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$7800(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$7900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlEnv access$8000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlEnv();
    }

    static /* synthetic */ LogChannel access$8100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ boolean access$8202(CustomerDeviceInfoManager customerDeviceInfoManager, boolean bl) {
        customerDeviceInfoManager.showInstalledVersionInfo = bl;
        return customerDeviceInfoManager.showInstalledVersionInfo;
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceInfo access$8302(CustomerDeviceInfoManager customerDeviceInfoManager, CustomerDeviceInfoManager$DeviceInfo deviceInfo) {
        customerDeviceInfoManager.currentDevice = deviceInfo;
        return customerDeviceInfoManager.currentDevice;
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceInfo access$8300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.currentDevice;
    }

    static /* synthetic */ LogChannel access$8500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ LogChannel access$8600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$8700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ void access$8800(CustomerDeviceInfoManager customerDeviceInfoManager, boolean bl) {
        customerDeviceInfoManager.startUpdate(bl);
    }

    static /* synthetic */ LogChannel access$8900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ SwdlModels access$9000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$9100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$9200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$9300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$9400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ SwdlModels access$9500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ void access$9600(CustomerDeviceInfoManager customerDeviceInfoManager) {
        customerDeviceInfoManager.persistenceStoreSettings();
    }

    static /* synthetic */ AbstractSwdlTextFactory access$9700(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getTextFactory();
    }

    static /* synthetic */ void access$9800(CustomerDeviceInfoManager customerDeviceInfoManager, String string, int n) {
        customerDeviceInfoManager.selectionError(string, n);
    }

    static /* synthetic */ LogChannel access$9900(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ AbstractCustomerProgressManager access$10000(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getCustomerProgressManager();
    }

    static /* synthetic */ AbstractSwdlTextFactory access$10100(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getTextFactory();
    }

    static /* synthetic */ SwdlModels access$10200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ AbstractSwdlTextFactory access$10300(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getTextFactory();
    }

    static /* synthetic */ SwdlModels access$10400(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$10500(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.getLogHMI();
    }

    static /* synthetic */ boolean access$8200(CustomerDeviceInfoManager customerDeviceInfoManager) {
        return customerDeviceInfoManager.showInstalledVersionInfo;
    }
}

