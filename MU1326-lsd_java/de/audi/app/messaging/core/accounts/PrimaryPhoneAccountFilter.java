/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessagingAccount;

public class PrimaryPhoneAccountFilter
implements IAccountFilter {
    private final DeviceRoleInfo primaryDevice;
    LogChannel log;

    public PrimaryPhoneAccountFilter(DeviceRoleInfo deviceRoleInfo, LogChannel logChannel) {
        this.primaryDevice = deviceRoleInfo;
        this.log = logChannel;
        this.log.log(1078071040, "[PrimaryPhoneAccountFilter#Constructor] primaryDevice = %1", (Object)deviceRoleInfo);
    }

    @Override
    public boolean accept(MessagingAccount messagingAccount) {
        boolean bl = false;
        if (this.primaryDevice != null) {
            if (this.primaryDevice.isSimDevice()) {
                if (!Strings.isNullOrEmpty(messagingAccount.getSimCardId()) && messagingAccount.getSimCardId().equalsIgnoreCase(this.primaryDevice.getSimCardId())) {
                    bl = true;
                }
            } else if (!Strings.isNullOrEmpty(messagingAccount.getBtDeviceAddress()) && messagingAccount.getBtDeviceAddress().equalsIgnoreCase(this.primaryDevice.getBtDeviceAddress())) {
                bl = true;
            }
        } else {
            this.log.log(-1601830656, "[PrimaryPhoneAccountFilter#accept] primaryDevice is NULL");
        }
        return bl;
    }

    @Override
    public String getDescription() {
        return "AccountFilter for PrimaryDevice Accounts";
    }
}

