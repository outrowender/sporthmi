/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceInfo;

class CustomerDeviceInfoManager$DeviceListHandler
implements Runnable {
    static final String CLASSNAME;
    String[] devices;
    CustomerDeviceInfoManager$DeviceInfo[] deviceAvailable2Update;
    int[] additionalInfo;
    int deviceAvailable2UpdateCount = 0;
    private final /* synthetic */ CustomerDeviceInfoManager this$0;

    CustomerDeviceInfoManager$DeviceListHandler(CustomerDeviceInfoManager customerDeviceInfoManager, String[] stringArray, int[] nArray) {
        this.this$0 = customerDeviceInfoManager;
        this.devices = stringArray;
        this.additionalInfo = nArray;
        if (stringArray != null) {
            this.deviceAvailable2Update = new CustomerDeviceInfoManager$DeviceInfo[stringArray.length];
            this.deviceAvailable2UpdateCount = stringArray.length;
        }
        CustomerDeviceInfoManager.access$1302(customerDeviceInfoManager, null);
        CustomerDeviceInfoManager.access$1402(customerDeviceInfoManager, null);
    }

    private boolean checkCancel() {
        boolean bl = false;
        if (this.this$0.getCustomerDlState().isCancelRequested()) {
            CustomerDeviceInfoManager.access$7300(this.this$0).log(-1601830656, "%1 cancel device selection is requested!", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]");
            this.this$0.getCustomerDlState().cancelDone();
            bl = true;
        }
        return bl;
    }

    private void cleanUpDeviceSelection() {
        this.devices = new String[0];
        this.deviceAvailable2Update = new CustomerDeviceInfoManager$DeviceInfo[0];
        this.additionalInfo = new int[0];
        this.deviceAvailable2UpdateCount = 0;
    }

    private boolean isNavDBUpdate() {
        if (this.deviceAvailable2Update != null) {
            for (int i2 = 0; i2 < this.deviceAvailable2Update.length; ++i2) {
                if (this.deviceAvailable2Update[i2] == null || !CustomerDeviceInfoManager$DeviceInfo.access$300(this.deviceAvailable2Update[i2])) continue;
                return true;
            }
        }
        return false;
    }

    private void clearDeviceNotAvailable2Update(int n) {
        CustomerDeviceInfoManager.access$7400(this.this$0).log(-2137614336, "%1 clearUpdateDevice(%2): %3", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)Integer.toString(n), (Object)this.deviceAvailable2Update[n].displayName);
        this.deviceAvailable2Update[n] = null;
        --this.deviceAvailable2UpdateCount;
    }

    private void selectDevice(int n, boolean bl) {
        CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo = this.deviceAvailable2Update[n];
        if (customerDeviceInfoManager$DeviceInfo != null) {
            CustomerDeviceInfoManager.access$7500(this.this$0).log(-2137614336, "%1 selectDevice(id=%2, select=%3)", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
            if (bl) {
                CustomerDeviceInfoManager$DeviceInfo.access$7600(customerDeviceInfoManager$DeviceInfo);
            } else {
                CustomerDeviceInfoManager$DeviceInfo.access$7700(customerDeviceInfoManager$DeviceInfo);
            }
        } else {
            CustomerDeviceInfoManager.access$7800(this.this$0).log(10000, "%1 selectDevice(id=%2, select=%3) the software update for device with id=%2 is not available and can't be selected or deselected", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
        }
    }

    private CustomerDeviceInfoManager$DeviceInfo[] getDeviceAvailable2Update() {
        CustomerDeviceInfoManager$DeviceInfo[] customerDeviceInfoManager$DeviceInfoArray = null;
        CustomerDeviceInfoManager.access$7900(this.this$0).log(1078071040, "%1 getDeviceAvailable2Update(): count= %2", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (long)this.deviceAvailable2UpdateCount);
        if (this.deviceAvailable2UpdateCount > 0) {
            customerDeviceInfoManager$DeviceInfoArray = new CustomerDeviceInfoManager$DeviceInfo[this.deviceAvailable2UpdateCount];
            int n = 0;
            for (int i2 = 0; i2 < this.deviceAvailable2Update.length; ++i2) {
                if (this.deviceAvailable2Update[i2] == null) continue;
                customerDeviceInfoManager$DeviceInfoArray[n++] = this.deviceAvailable2Update[i2];
            }
        }
        return customerDeviceInfoManager$DeviceInfoArray;
    }

    private int getDeviceAvailable2UpdateCount() {
        return this.deviceAvailable2UpdateCount;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("CustomerUpdate: DeviceListHandler").toString());
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = CustomerDeviceInfoManager.access$8000(this.this$0).getHMISwitcher().getUOTAController();
        CustomerDeviceInfoManager.access$8100(this.this$0).log(1078071040, "%1 processing devices ", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]");
        if (this.this$0.checkAccessType(1)) {
            CustomerDeviceInfoManager.access$1202(this.this$0, null);
            CustomerDeviceInfoManager.access$8202(this.this$0, false);
            for (int i2 = 0; i2 < this.devices.length; ++i2) {
                this.deviceAvailable2Update[i2] = new CustomerDeviceInfoManager$DeviceInfo(this.this$0, i2, this.devices[i2], this.additionalInfo[i2]);
                CustomerDeviceInfoManager.access$8302(this.this$0, this.deviceAvailable2Update[i2]);
                CustomerDeviceInfoManager$DeviceInfo.access$8400(CustomerDeviceInfoManager.access$8300(this.this$0));
                if (CustomerDeviceInfoManager.access$8300((CustomerDeviceInfoManager)this.this$0).additionalInfo == 1 || CustomerDeviceInfoManager.access$8300((CustomerDeviceInfoManager)this.this$0).additionalInfo == 2) {
                    CustomerDeviceInfoManager.access$8500(this.this$0).log(1078071040, "%1 Device: %2 VersionInfo: %3 ", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)CustomerDeviceInfoManager.access$8300(this.this$0).getDescription(), (Object)CustomerDeviceInfoManager.access$8300(this.this$0).getVersionInfo());
                } else {
                    CustomerDeviceInfoManager.access$8600(this.this$0).log(1078071040, "%1 ignoring device: %2 ", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)CustomerDeviceInfoManager.access$8300((CustomerDeviceInfoManager)this.this$0).name);
                }
                if (CustomerDeviceInfoManager.access$8300(this.this$0).equals(CustomerDeviceInfoManager.access$1200(this.this$0))) {
                    if (!CustomerDeviceInfoManager$DeviceInfo.access$7600(CustomerDeviceInfoManager.access$8300(this.this$0))) {
                        CustomerDeviceInfoManager.access$1202(this.this$0, null);
                        this.clearDeviceNotAvailable2Update(i2);
                        break;
                    }
                } else {
                    CustomerDeviceInfoManager$DeviceInfo.access$7700(CustomerDeviceInfoManager.access$8300(this.this$0));
                    this.clearDeviceNotAvailable2Update(i2);
                }
                if (!this.checkCancel()) continue;
                this.cleanUpDeviceSelection();
                return;
            }
            CustomerDeviceInfoManager$DeviceInfo[] customerDeviceInfoManager$DeviceInfoArray = CustomerDeviceInfoManager.access$6500(this.this$0).getDeviceAvailable2Update();
            if (null != CustomerDeviceInfoManager.access$1200(this.this$0)) {
                CustomerDeviceInfoManager.access$8700(this.this$0).getCustomerProgressStateChoice().setValue(2);
                if (baseUpdateOverTheAirController.isInstallActive()) {
                    CustomerDeviceInfoManager.access$8800(this.this$0, false);
                } else {
                    if (null != CustomerDeviceInfoManager.access$1300(this.this$0)) {
                        CustomerDeviceInfoManager.access$1200((CustomerDeviceInfoManager)this.this$0).displayName = CustomerDeviceInfoManager.access$1300(this.this$0);
                    }
                    if (null != CustomerDeviceInfoManager.access$1400(this.this$0)) {
                        CustomerDeviceInfoManager.access$1200((CustomerDeviceInfoManager)this.this$0).newVersion = CustomerDeviceInfoManager.access$1400(this.this$0);
                    }
                    CustomerDeviceInfoManager.access$8900(this.this$0).log(1078071040, "%1 Update Device: %2 VersionInfo: %3 ", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Object)CustomerDeviceInfoManager.access$1200(this.this$0).getDescription(), (Object)CustomerDeviceInfoManager.access$1200(this.this$0).getVersionInfo());
                    CustomerDeviceInfoManager.access$9000(this.this$0).getCustomerProgressStateChoice().setValue(2);
                    CustomerDeviceInfoManager.access$9100(this.this$0).getCustomerUpdateDeviceLabel().setText(CustomerDeviceInfoManager.access$1200(this.this$0).getDescription());
                    CustomerDeviceInfoManager.access$9200(this.this$0).getCustomerUpdateVersionLabel().setText(CustomerDeviceInfoManager.access$1200(this.this$0).getVersionInfo());
                    ModelGroup modelGroup = new ModelGroup();
                    modelGroup.add(CustomerDeviceInfoManager.access$9300(this.this$0).getCustomerReadingMetaInfoStateChoice());
                    if (!this.checkCancel()) {
                        CustomerDeviceInfoManager.access$9400(this.this$0).getCustomerReadingMetaInfoStateChoice().setValue(1);
                        CustomerDeviceInfoManager.access$9500(this.this$0).getCustomerReadingMetaInfoStateChoice().setStatus(1);
                        modelGroup.flush();
                        modelGroup.removeAll();
                        CustomerDeviceInfoManager.access$9600(this.this$0);
                    }
                }
            } else {
                CustomerDeviceInfoManager.access$9800(this.this$0, CustomerDeviceInfoManager.access$9700(this.this$0).getTextConstantCustNoDevice(), 1);
            }
        } else if (this.this$0.checkAccessType(2)) {
            CustomerDeviceInfoManager.access$9900(this.this$0).log(-1601830656, "%1 run(): accessType=showSummary", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]");
            boolean bl = false;
            for (int i3 = 0; i3 < this.additionalInfo.length; ++i3) {
                if (this.additionalInfo[i3] == 3) {
                    bl = true;
                    break;
                }
                if (this.additionalInfo[i3] != 2) continue;
                CustomerDeviceInfoManager.access$8302(this.this$0, new CustomerDeviceInfoManager$DeviceInfo(this.this$0, i3, this.devices[i3], this.additionalInfo[i3]));
                CustomerDeviceInfoManager.access$8202(this.this$0, true);
                CustomerDeviceInfoManager$DeviceInfo.access$8400(CustomerDeviceInfoManager.access$8300(this.this$0));
            }
            if (baseUpdateOverTheAirController.isInstallActive()) {
                CustomerDeviceInfoManager.access$10000(this.this$0).switchUotaProgressState(bl);
            } else {
                if (bl) {
                    CustomerDeviceInfoManager.access$10200(this.this$0).getCustomerSummaryStatusLabel().setText(CustomerDeviceInfoManager.access$10100(this.this$0).getTextConstantCustDevInfoManagerUnsuccess());
                } else {
                    CustomerDeviceInfoManager.access$10400(this.this$0).getCustomerSummaryStatusLabel().setText(CustomerDeviceInfoManager.access$10300(this.this$0).getTextConstantCustDevInfoManagerSuccess());
                }
                try {
                    CustomerDeviceInfoManager.access$10000(this.this$0).showSummary(bl);
                }
                catch (Exception exception) {
                    CustomerDeviceInfoManager.access$10500(this.this$0).log(-1601830656, "%1 showSummary failed! ", (Object)"[CustomerDeviceInfoManager$DeviceListHandler]", (Throwable)exception);
                }
            }
        }
    }

    static /* synthetic */ CustomerDeviceInfoManager$DeviceInfo[] access$100(CustomerDeviceInfoManager$DeviceListHandler customerDeviceInfoManager$DeviceListHandler) {
        return customerDeviceInfoManager$DeviceListHandler.getDeviceAvailable2Update();
    }

    static /* synthetic */ boolean access$400(CustomerDeviceInfoManager$DeviceListHandler customerDeviceInfoManager$DeviceListHandler) {
        return customerDeviceInfoManager$DeviceListHandler.isNavDBUpdate();
    }

    static /* synthetic */ void access$6600(CustomerDeviceInfoManager$DeviceListHandler customerDeviceInfoManager$DeviceListHandler, int n, boolean bl) {
        customerDeviceInfoManager$DeviceListHandler.selectDevice(n, bl);
    }

    static /* synthetic */ int access$6900(CustomerDeviceInfoManager$DeviceListHandler customerDeviceInfoManager$DeviceListHandler) {
        return customerDeviceInfoManager$DeviceListHandler.getDeviceAvailable2UpdateCount();
    }
}

