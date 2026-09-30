/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.storage.IStorageAccess;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;

public class TelADBDownloadInquiryHandler
extends AbstractPhoneComponent {
    public static final short DOWNLOAD_CHOICE_UNKNOWN = -1;
    public static final short DOWNLOAD_CHOICE_YES = 0;
    public static final short DOWNLOAD_CHOICE_NO = 1;
    public static final short DOWNLOAD_CHOICE_LATER = 2;
    public static final int MOBILE_ADB_DOWNLOAD_NO_ASK = 0;
    public static final int MOBILE_ADB_DOWNLOAD_ASK = 1;
    private final IStorageAccess storageManager;
    private volatile String simCardID = "";
    private volatile short mobileADBDownloadSetting = 1;
    private volatile IGlobalTelephoneStateStruct telState;
    final BluetoothListener bluetoothListener;
    final TelADBDownloadYesButtonListener telADBDownloadYesButtonListener;
    final TelADBDownloadNoButtonListener telADBDownloadNoButtonListener;
    final TelADBDownloadLaterButtonListener telADBDownloadLaterButtonListener;
    private volatile TrustedDevice[] trustedDevices;
    private volatile boolean primaryADBDLConnected;

    private static String getMobileAdbDownloadSettingName(short s) {
        switch (s) {
            case 0: {
                return "DOWNLOAD_YES";
            }
            case 1: {
                return "DOWNLOAD_NO";
            }
            case 2: {
                return "DOWNLOAD_LATER";
            }
        }
        return "DOWNLOAD_UNKNOWN";
    }

    private static String checkSIMCardUpdate(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationState();
        PhoneInformation phoneInformation = iGlobalTelephoneStateStruct.getPhoneInformation();
        if (activationStateStruct != null && phoneInformation != null && activationStateStruct.getTelActivationState() == 5 && activationStateStruct.getTelMode() == 0) {
            return phoneInformation.getSimId();
        }
        return null;
    }

    public TelADBDownloadInquiryHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.storageManager = iTelApplication.getFrameworkAccess().getStorageMgr();
        this.bluetoothListener = new BluetoothListener();
        this.telADBDownloadYesButtonListener = new TelADBDownloadYesButtonListener(iTelApplication);
        this.telADBDownloadNoButtonListener = new TelADBDownloadNoButtonListener(iTelApplication);
        this.telADBDownloadLaterButtonListener = new TelADBDownloadLaterButtonListener(iTelApplication);
        this.addSubPhoneComponent(this.telADBDownloadYesButtonListener);
        this.addSubPhoneComponent(this.telADBDownloadNoButtonListener);
        this.addSubPhoneComponent(this.telADBDownloadLaterButtonListener);
        this.addSubPhoneComponent(new FactoryResetListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getBluetoothHandler().addBluetoothListener(this.bluetoothListener);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.simCardID = this.getSIMCardIDFromPersistence();
        this.mobileADBDownloadSetting = this.getMobileSIMCardSettingFromPersistence();
        this.log.log(1000000, "[TelADBDownloadInquiryHandler#init] persisted sim card id=%1, persisted download setting=%2", (Object)this.simCardID, (long)this.mobileADBDownloadSetting);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getBluetoothHandler().removeBluetoothListener(this.bluetoothListener);
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
        if (n == 65539 || n == 65554) {
            String string = TelADBDownloadInquiryHandler.checkSIMCardUpdate(iGlobalTelephoneStateStruct);
            if (string != null && string.length() > 0) {
                this.updateAndStoreSIMCardID(string);
            } else {
                this.getChoiceModel(300671).setValue(0);
            }
        }
    }

    private void updateAndStoreSIMCardID(String string) {
        this.log.log(1000000, "[TelADBDownloadInquiryHandler#setSIMCardID] simCardID = %1", (Object)string);
        if (!this.simCardID.equals(string)) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler#setSIMCardID] this.simCardID=%1, new simCardID=%2", (Object)this.simCardID, (Object)string);
            this.setMobileADBDownloadSetting((short)-1);
        } else {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler#setSIMCardID] SIM-Card ID has not changed.");
            this.setMobileADBDownloadChoiceModel();
        }
        this.simCardID = string;
        this.storeSIMCardIDToPersistence(string);
        this.checkConnectedADBDLProfile();
    }

    private void setMobileADBDownloadSetting(short s) {
        this.log.log(1000000, "[TelADBDownloadInquiryHandler#setMobileADBDownloadSetting] mobileADBDownloadSetting=%1", (Object)TelADBDownloadInquiryHandler.getMobileAdbDownloadSettingName(s));
        this.mobileADBDownloadSetting = s;
        this.storeMobileADBDownloadSettingToPersistence(s);
        this.setMobileADBDownloadChoiceModel();
        this.log.log(10000000, "[TelADBDownloadInquiryHandler#setMobileADBDownloadSetting] this.simCardID=%1, this.mobileADBDownloadSetting=%2", (Object)this.simCardID, (Object)TelADBDownloadInquiryHandler.getMobileAdbDownloadSettingName(s));
    }

    private void setMobileADBDownloadChoiceModel() {
        switch (this.mobileADBDownloadSetting) {
            case -1: 
            case 2: {
                this.getChoiceModel(300671).setValue(1);
                break;
            }
            case 0: 
            case 1: {
                this.getChoiceModel(300671).setValue(0);
                break;
            }
            default: {
                this.log.log(100000, "[TelADBDownloadInquiryHandler#setMobileADBDownloadChoiceModel] unhandled download setting %1", (long)this.mobileADBDownloadSetting);
            }
        }
    }

    String getSIMCardIDFromPersistence() {
        return this.storageManager.getString(1003, 90, "");
    }

    private void storeSIMCardIDToPersistence(String string) {
        this.storageManager.setString(1003, 90, string);
    }

    void storeMobileADBDownloadSettingToPersistence(short s) {
        this.storageManager.setInt(1003, 100, s);
    }

    short getMobileSIMCardSettingFromPersistence() {
        return (short)this.storageManager.getInt(1003, 100, -1);
    }

    String getSimCardID() {
        return this.simCardID;
    }

    void setSimCardID(String string) {
        this.simCardID = string;
    }

    private void checkConnectedADBDLProfile() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler#checkConnectedADBDLProfile] state is null");
            return;
        }
        if (this.trustedDevices == null) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler#checkConnectedADBDLProfile] trustedDevices is null");
            return;
        }
        if (iGlobalTelephoneStateStruct.getTelMode() == 0) {
            TrustedDevice trustedDevice = null;
            for (int i2 = 0; i2 < this.trustedDevices.length; ++i2) {
                TrustedDevice trustedDevice2 = this.trustedDevices[i2];
                if (trustedDevice2 != null) {
                    this.primaryADBDLConnected = trustedDevice2.getDeviceRole() == 0 && (trustedDevice2.getActiveServiceTypes() & 0x20) == 32;
                    trustedDevice = trustedDevice2;
                    if (!this.primaryADBDLConnected) continue;
                    this.log.log(1000000, "[TelADBDownloadInquiryHandler#checkConnectedADBDLProfile] ADRDL connection simID=%1, btDevice=%2", (Object)this.simCardID, (Object)trustedDevice);
                    this.setMobileADBDownloadSetting((short)0);
                    break;
                }
                this.log.log(1000000, "[TelADBDownloadInquiryHandler#checkConnectedADBDLProfile] trustedDevices[%1] is null", (long)i2);
            }
        }
    }

    static /* synthetic */ TrustedDevice[] access$102(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler, TrustedDevice[] trustedDeviceArray) {
        telADBDownloadInquiryHandler.trustedDevices = trustedDeviceArray;
        return trustedDeviceArray;
    }

    class BluetoothListener
    implements ITelBluetoothListener {
        BluetoothListener() {
        }

        public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray) {
            TelADBDownloadInquiryHandler.access$102(TelADBDownloadInquiryHandler.this, trustedDeviceArray);
            TelADBDownloadInquiryHandler.this.checkConnectedADBDLProfile();
        }
    }

    private class FactoryResetListener
    extends AbstractTelMessageListener {
        public FactoryResetListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 28);
        }

        protected void messageReceived() {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler.FactoryResetListener#messageRecieved]");
            TelADBDownloadInquiryHandler.this.simCardID = "";
            TelADBDownloadInquiryHandler.this.storeSIMCardIDToPersistence("");
            TelADBDownloadInquiryHandler.this.mobileADBDownloadSetting = (short)-1;
            TelADBDownloadInquiryHandler.this.storeMobileADBDownloadSettingToPersistence((short)-1);
        }
    }

    class TelADBDownloadNoButtonListener
    extends TelDefaultButtonListener {
        public TelADBDownloadNoButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300309);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler.TelADBDownloadNoButtonListener#keyTyped] User has chosen not to download address book from mobile device");
            TelADBDownloadInquiryHandler.this.setMobileADBDownloadSetting((short)1);
            this.fireEvent(n3);
        }
    }

    class TelADBDownloadYesButtonListener
    extends TelDefaultButtonListener {
        public TelADBDownloadYesButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 301114);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler.TelADBDownloadYesButtonListener#keyTyped] User has chosen to download address book from mobile device");
            TelADBDownloadInquiryHandler.this.setMobileADBDownloadSetting((short)0);
            this.fireEvent(n3);
        }
    }

    class TelADBDownloadLaterButtonListener
    extends TelDefaultButtonListener {
        public TelADBDownloadLaterButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300308);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelADBDownloadInquiryHandler.TelADBDownloadLaterButtonListener#keyTyped] User has chosen to be asked the next time.");
            TelADBDownloadInquiryHandler.this.setMobileADBDownloadSetting((short)2);
            this.fireEvent(n3);
        }
    }
}

