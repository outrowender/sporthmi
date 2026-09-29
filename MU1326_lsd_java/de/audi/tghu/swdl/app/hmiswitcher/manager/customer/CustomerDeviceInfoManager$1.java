/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceInfo;

class CustomerDeviceInfoManager$1
implements Runnable {
    private final /* synthetic */ String val$infoFileTarget;
    private final /* synthetic */ String val$infoFileSource;
    private final /* synthetic */ CustomerDeviceInfoManager this$0;

    CustomerDeviceInfoManager$1(CustomerDeviceInfoManager customerDeviceInfoManager, String string, String string2) {
        this.this$0 = customerDeviceInfoManager;
        this.val$infoFileTarget = string;
        this.val$infoFileSource = string2;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("CustomerUpdate: DeviceVersionHandler").toString());
        if (CustomerDeviceInfoManager.access$8200(this.this$0)) {
            CustomerDeviceInfoManager$DeviceInfo.access$10600(CustomerDeviceInfoManager.access$8300(this.this$0), this.val$infoFileTarget);
            CustomerDeviceInfoManager.access$8202(this.this$0, false);
        } else {
            CustomerDeviceInfoManager$DeviceInfo.access$10700(CustomerDeviceInfoManager.access$8300(this.this$0), this.val$infoFileSource, this.val$infoFileTarget);
        }
    }
}

