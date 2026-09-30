/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.app.online.privacysettings.GPSPopupController;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.standard.IBAPServiceListener;
import de.audi.tghu.online.app.standard.IDSIServiceListener;

public class PrivacySettingsServiceListener
implements IDSIServiceListener,
IBAPServiceListener {
    private GPSPopupController gpsPopupController;
    private LogChannel logChannel;

    public PrivacySettingsServiceListener(GPSPopupController gPSPopupController, LogChannel logChannel) {
        this.gpsPopupController = gPSPopupController;
        this.logChannel = logChannel;
    }

    public void updateServiceState(int n, int n2) {
        if (n2 == 1) {
            if ((n & 0x800) != 0) {
                this.gpsPopupController.showPopup();
            } else {
                this.logChannel.log(100000000, "PrivacySettingsServiceListener#updateServiceState unsupported service state: %1", (long)n);
            }
        } else {
            this.logChannel.log(1000000, "PrivacySettingsServiceListener#updateServiceState received a non-valid service state");
        }
    }

    public void onServiceList(Service[] serviceArray) {
        if (serviceArray == null || serviceArray.length == 0) {
            this.logChannel.log(100000, "PrivacySettingsServiceListener#onServiceList no services to check for GPS use");
            return;
        }
        for (int i2 = 0; i2 < serviceArray.length; ++i2) {
            Service service = serviceArray[i2];
            if (!service.isGPSRequired()) continue;
            this.gpsPopupController.showPopup();
            break;
        }
    }
}

