/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.user.DsiBluetoothEmptyListener;
import de.audi.app.sdsmanager.dictation.user.UserIdManager;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$1;
import org.dsi.ifc.bluetooth.TrustedDevice;

final class UserIdManager$DsiBluetoothListener
extends DsiBluetoothEmptyListener {
    private final /* synthetic */ UserIdManager this$0;

    private UserIdManager$DsiBluetoothListener(UserIdManager userIdManager) {
        this.this$0 = userIdManager;
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n != 1 && UserIdManager.access$600(this.this$0).isInfo()) {
            UserIdManager.access$700(this.this$0).log(1078071040, "[UserIdManager#updateTrustedDevices] validFlag = %1", (long)n);
        } else if (n == 1) {
            Object object;
            TrustedDevice trustedDevice = null;
            TrustedDevice trustedDevice2 = null;
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                object = trustedDeviceArray[i2];
                if (trustedDevice == null && UserIdManager.access$800((TrustedDevice)object)) {
                    trustedDevice = object;
                }
                if (trustedDevice2 == null && UserIdManager.access$900((TrustedDevice)object)) {
                    trustedDevice2 = object;
                }
                if (trustedDevice != null && trustedDevice2 != null) break;
            }
            if (UserIdManager.access$1000(this.this$0).isInfo()) {
                UserIdManager.access$1100(this.this$0).log(1078071040, " [UserIdManager#updateTrustedDevices] mapDevice = %1, sapDevice = %2", (Object)trustedDevice, (Object)trustedDevice2);
            }
            String string = trustedDevice != null ? trustedDevice.getDeviceAddress() : null;
            object = trustedDevice2 != null ? trustedDevice2.getDeviceAddress() : null;
            UserIdManager.access$1200(this.this$0, string);
            UserIdManager.access$1300(this.this$0, (String)object);
        }
    }

    /* synthetic */ UserIdManager$DsiBluetoothListener(UserIdManager userIdManager, UserIdManager$1 userIdManager$1) {
        this(userIdManager);
    }
}

