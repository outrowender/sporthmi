/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.mobilekey;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;
import de.audi.atip.interapp.eni.ENIMobileKeyListener;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.log.LogChannel;

public class MobileKeyVTANController
implements ENIMobileKeyListener,
ButtonListener {
    private LogChannel log;
    private HMIService hmiService;
    ENIServiceOnline eniServiceOnline;
    private static final int AUDI_CONNECT_KEYCODE_PLEASEWAIT;
    private static final int AUDI_CONNECT_KEYCODE;
    private static final int AUDI_CONNECT_KEYCODE_NOT_AVAILABLE;
    private static final int AUDI_CONNECT_KEYCODE_GENERIC_ERROR;
    private String encryptedVTAN = "";
    private int[] buttonModels = new int[]{1914643200};

    public MobileKeyVTANController(LogChannel logChannel, HMIService hMIService, IFrameworkAccess iFrameworkAccess) {
        logChannel.log(1078071040, "MobileKeyVTANController#c'tor");
        this.log = logChannel;
        this.hmiService = hMIService;
        for (int i2 = 0; i2 < this.buttonModels.length; ++i2) {
            hMIService.getButtonModel(this.buttonModels[i2]).setButtonListener(this);
        }
    }

    public void setENIServiceOnline(ENIServiceOnline eNIServiceOnline) {
        this.log.log(1078071040, "MobileKeyVTANController#setENIServiceOnline eniServiceOnline set: %1", (Object)eNIServiceOnline);
        this.eniServiceOnline = eNIServiceOnline;
    }

    private void getVTAN() {
        this.log.log(1078071040, "MobileKeyVTANController#getVTAN called");
        this.callKeycodeScreen(0);
        this.eniServiceOnline.startVTANAuthData();
    }

    @Override
    public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
        this.log.log(1078071040, "MobileKeyVTANController#onMobileDeviceKeyCount keyCount = %1", (Object)mobileKeyCount);
    }

    @Override
    public void onVTANAuthDataFinished(boolean bl, String string) {
        if (bl) {
            this.log.log(1078071040, "MobileKeyVTANController#onVTANAuthDataFinished: vtan auth data ok: %1", (Object)string);
            if (!"".equals(string)) {
                this.log.log(1078071040, "MobileKeyVTANController#onVTANAuthDataFinished: vtan auth data will be forwarded to BAP eni service");
                this.eniServiceOnline.remoteProcessGetVtan(string);
            } else {
                this.log.log(-1601830656, "MobileKeyVTANController#onVTANAuthDataFinished: vtan auth data is empty");
            }
        } else {
            this.log.log(-1601830656, "MobileKeyVTANController#onVTANAuthDataFinished: vtan auth data not successfully");
            this.callKeycodeScreen(3);
        }
    }

    @Override
    public void onRemoteProcessGetVtan(int n, int n2) {
        this.log.log(1078071040, "MobileKeyVTANController#onRemoteProcessGetVtan called");
        if (n == 3) {
            if (!this.encryptedVTAN.equals("")) {
                this.log.log(1078071040, "MobileKeyVTANController#onRemoteProcessGetVtan encryptedVTAN = %1", (Object)this.encryptedVTAN);
                this.eniServiceOnline.startVTANDecryption(this.encryptedVTAN);
            } else {
                this.log.log(-1601830656, "MobileKeyVTANController#onRemoteProcessGetVtan encryptedVTAN is empty");
                this.callKeycodeScreen(3);
            }
        } else if (n == 4) {
            this.log.log(-1601830656, "MobileKeyVTANController#onRemoteProcessGetVtan RemoteProcessSate = FAILED_SEE_EXCEPTION_STATE");
            if (n2 == 26) {
                this.log.log(-1601830656, "MobileKeyVTANController#onRemoteProcessGetVtan ExceptionState = ERROR_VTAN_NOT_AVAILABLE");
                this.callKeycodeScreen(2);
            } else {
                this.log.log(-1601830656, "MobileKeyVTANController#onRemoteProcessGetVtan ExceptionState = GENERIC_ERROR");
                this.callKeycodeScreen(3);
            }
        } else {
            this.log.log(1078071040, "MobileKeyVTANController#onRemoteProcessGetVtan other state: %1", (long)n);
        }
    }

    @Override
    public void onRemoteProcessFinished(boolean bl) {
        this.log.log(1078071040, "MobileKeyVTANController#onRemoteProcessFinished called");
        if (!bl) {
            this.log.log(-1601830656, "MobileKeyVTANController#onRemoteProcessFinished RemoteProcessCall was not successful");
            this.callKeycodeScreen(3);
        }
    }

    @Override
    public void onVtanDataEncrypted(String string) {
        this.log.log(1078071040, "MobileKeyVTANController#onVtanDataEncrypted with encryptedVTAN = %1", (Object)string);
        this.encryptedVTAN = string;
    }

    @Override
    public void onVTANDecryptionFinished(boolean bl, VTANData vTANData) {
        this.log.log(1078071040, "MobileKeyVTANController#onVTANDecryptionFinished called");
        if (bl) {
            this.log.log(1078071040, "MobileKeyVTANController#onVTANDecryptionFinished decrypted vtan ok");
            this.log.log(1078071040, "MobileKeyVTANController#onVTANDecryptionFinished KeyCodeUserLabel = %1", (Object)vTANData.getUserName());
            this.log.log(1078071040, "MobileKeyVTANController#onVTANDecryptionFinished CodeSecurityCodeLabel = %1", (Object)vTANData.getVTAN());
            this.callKeycodeScreen(1);
            this.hmiService.getLabelModel(1897865984).setText(vTANData.getUserName());
            this.hmiService.getLabelModel(1847534336).setText(vTANData.getVTAN());
        } else {
            this.log.log(-1601830656, "MobileKeyVTANController#onVTANDecryptionFinished call was not successful");
            this.callKeycodeScreen(3);
        }
    }

    private void callKeycodeScreen(int n) {
        this.log.log(1078071040, "MobileKeyVTANController#callKeycodeScreen called");
        if (n == 0) {
            this.log.log(1078071040, "MobileKeyVTANController#show AUDI_CONNECT_KEYCODE_PLEASEWAIT");
            this.hmiService.getChoiceModel(1881088768).setStatus(0);
        } else if (n == 1) {
            this.log.log(1078071040, "MobileKeyVTANController#show AUDI_CONNECT_KEYCODE");
            this.hmiService.getChoiceModel(1881088768).setStatus(1);
            this.hmiService.getChoiceModel(1881088768).setValue(0);
        } else if (n == 2) {
            this.log.log(1078071040, "MobileKeyVTANController#show AUDI_CONNECT_KEYCODE_NOT_AVAILABLE");
            this.hmiService.getChoiceModel(1881088768).setStatus(1);
            this.hmiService.getChoiceModel(1881088768).setValue(-1);
        } else if (n == 3) {
            this.log.log(1078071040, "MobileKeyVTANController#show AUDI_CONNECT_KEYCODE_GENERIC_ERROR");
            this.hmiService.getChoiceModel(1881088768).setStatus(2);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "MobileKeyVTANController#keyTyped called");
        if (n == 1914643200) {
            this.log.log(1078071040, "MobileKeyVTANController#keyTyped retrieving key code/VTAN");
            this.getVTAN();
            this.hmiService.getButtonModel(n).fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

