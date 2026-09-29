/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import java.util.Map;

class CustomerDeviceInfoManager$DeviceInfo {
    static final String CLASSNAME;
    int id;
    String name;
    int additionalInfo;
    boolean waitingForVersionInfo = false;
    String displayName;
    String oldVersion;
    String newVersion;
    private final /* synthetic */ CustomerDeviceInfoManager this$0;

    public CustomerDeviceInfoManager$DeviceInfo(CustomerDeviceInfoManager customerDeviceInfoManager, int n, String string, int n2) {
        this.this$0 = customerDeviceInfoManager;
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
        return "NavDB".equalsIgnoreCase(this.name) || "SpeechResVDE".equalsIgnoreCase(this.name);
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
        CustomerDeviceInfoManager.access$500(this.this$0).log(-1601830656, "%1 setInstalledVersionInfo() for %2 ... ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
        Map map = CustomerDeviceInfoManager.access$600(this.this$0, string);
        if (map != null) {
            String[] stringArray = CustomerDeviceInfoManager.access$700(this.this$0, map);
            if (this.containsDeviceId(stringArray, this.name)) {
                this.displayName = CustomerDeviceInfoManager.access$800(this.this$0, map);
                CustomerDeviceInfoManager.access$900(this.this$0).log(-2137614336, "%1 setting display name to %2", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.displayName);
                this.newVersion = CustomerDeviceInfoManager.access$1000(this.this$0, map);
                CustomerDeviceInfoManager.access$1100(this.this$0).log(-2137614336, "%1 setting source version to %2", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.newVersion);
                CustomerDeviceInfoManager.access$1202(this.this$0, this);
                if ("main".equalsIgnoreCase((String)map.get("role"))) {
                    CustomerDeviceInfoManager.access$1302(this.this$0, this.displayName);
                    CustomerDeviceInfoManager.access$1402(this.this$0, this.newVersion);
                    CustomerDeviceInfoManager.access$1500(this.this$0).getCustomerUpdateDeviceLabel().setText(CustomerDeviceInfoManager.access$1300(this.this$0));
                    CustomerDeviceInfoManager.access$1600(this.this$0).getUotaSummaryComponentsLabelModel().setText(CustomerDeviceInfoManager.access$1300(this.this$0));
                    CustomerDeviceInfoManager.access$1700(this.this$0).getCustomerUpdateVersionLabel().setText(CustomerDeviceInfoManager.access$1400(this.this$0));
                    CustomerDeviceInfoManager.access$1800(this.this$0).getCustomerSummaryVersionLabel().setText(CustomerDeviceInfoManager.access$1400(this.this$0));
                    CustomerDeviceInfoManager.access$1900(this.this$0).getCustomerNewVersionLabel().setText(CustomerDeviceInfoManager.access$1400(this.this$0));
                    CustomerDeviceInfoManager.access$2000(this.this$0).log(-2137614336, "%1 Main device found: name=%2, value=%3", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)CustomerDeviceInfoManager.access$1300(this.this$0), (Object)CustomerDeviceInfoManager.access$1400(this.this$0));
                }
                CustomerDeviceInfoManager.access$2100(this.this$0).log(-2137614336, "%1 update HMI labels, set NavDBUpdate=%2 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.isNavDBUpdateMedium());
                if (null == CustomerDeviceInfoManager.access$1300(this.this$0) || null == CustomerDeviceInfoManager.access$1400(this.this$0)) {
                    CustomerDeviceInfoManager.access$2200(this.this$0).getCustomerUpdateDeviceLabel().setText(this.getDescription());
                    CustomerDeviceInfoManager.access$2300(this.this$0).getUotaSummaryComponentsLabelModel().setText(this.getDescription());
                    CustomerDeviceInfoManager.access$2400(this.this$0).getCustomerUpdateVersionLabel().setText(this.getVersionInfo());
                    CustomerDeviceInfoManager.access$2500(this.this$0).getCustomerSummaryVersionLabel().setText(this.newVersion);
                    CustomerDeviceInfoManager.access$2600(this.this$0).getCustomerNewVersionLabel().setText(this.getNewVersion());
                }
                if (this.isNavDBUpdateMedium()) {
                    CustomerDeviceInfoManager.access$2700(this.this$0).getCustomerNaviDbChoice().setValue(1);
                    CustomerDeviceInfoManager.access$2800(this.this$0).getCustomerCurrentVersionLabel().setText("");
                } else {
                    CustomerDeviceInfoManager.access$2900(this.this$0).getCustomerNaviDbChoice().setValue(0);
                    CustomerDeviceInfoManager.access$3000(this.this$0).getCustomerCurrentVersionLabel().setText(this.getOldVersion());
                }
            } else {
                CustomerDeviceInfoManager.access$3100(this.this$0).log(-1601830656, "%1 Error: inconsistent device Name: expected %2 got %3 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (Object)stringArray);
            }
        } else {
            CustomerDeviceInfoManager.access$3200(this.this$0).log(1078071040, "%1 No [Audi]Update.txt found, do not use this device for Customer Update! ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]");
        }
        this.triggerVersionInfoRead();
    }

    private void setVersionInfo(String string, String string2) {
        String[] stringArray;
        CustomerDeviceInfoManager.access$3300(this.this$0).log(-1601830656, "%1 setVersionInfo() for %2 ... ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
        Map map = CustomerDeviceInfoManager.access$600(this.this$0, string);
        Map map2 = CustomerDeviceInfoManager.access$600(this.this$0, string2);
        if (map != null) {
            stringArray = CustomerDeviceInfoManager.access$700(this.this$0, map);
            if (this.containsDeviceId(stringArray, this.name)) {
                this.displayName = CustomerDeviceInfoManager.access$800(this.this$0, map);
                CustomerDeviceInfoManager.access$3400(this.this$0).log(-2137614336, "%1 setting display name to %2", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.displayName);
                this.newVersion = CustomerDeviceInfoManager.access$1000(this.this$0, map);
                CustomerDeviceInfoManager.access$3500(this.this$0).log(-2137614336, "%1 setting source version to %2", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.newVersion);
                CustomerDeviceInfoManager.access$1202(this.this$0, this);
                if ("main".equalsIgnoreCase((String)map.get("role"))) {
                    CustomerDeviceInfoManager.access$1302(this.this$0, this.displayName);
                    CustomerDeviceInfoManager.access$1402(this.this$0, this.newVersion);
                    CustomerDeviceInfoManager.access$3600(this.this$0).log(-2137614336, "%1 Main device found: name=%2, value=%3", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)CustomerDeviceInfoManager.access$1300(this.this$0), (Object)CustomerDeviceInfoManager.access$1400(this.this$0));
                }
            } else {
                CustomerDeviceInfoManager.access$3700(this.this$0).log(-1601830656, "%1 Error: inconsistent source device Name: expected %2 got %3 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (Object)stringArray);
            }
        } else {
            CustomerDeviceInfoManager.access$3800(this.this$0).log(1078071040, "%1 No AudiUpdate.txt found, do not use this device for Customer Update! ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]");
        }
        if (map2 != null) {
            stringArray = CustomerDeviceInfoManager.access$700(this.this$0, map2);
            if (this.containsDeviceId(stringArray, this.name)) {
                this.oldVersion = CustomerDeviceInfoManager.access$1000(this.this$0, map2);
                CustomerDeviceInfoManager.access$3900(this.this$0).log(-2137614336, "%1 setting destination version to %2 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.oldVersion);
            } else {
                CustomerDeviceInfoManager.access$4000(this.this$0).log(-2137614336, "%1 Error: inconsistent dest device Name: expected %2 got %3 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (Object)stringArray);
            }
        } else {
            this.oldVersion = null;
        }
        if (CustomerDeviceInfoManager.access$1200(this.this$0) == this) {
            CustomerDeviceInfoManager.access$4100(this.this$0).log(-2137614336, "%1 update HMI labels, set NavDBUpdate=%2 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.isNavDBUpdateMedium());
            CustomerDeviceInfoManager.access$4200(this.this$0).getCustomerUpdateNameLabel().setText(this.getDescription());
            CustomerDeviceInfoManager.access$4300(this.this$0).getCustomerUpdateVersionLabel().setText(this.getVersionInfo());
            CustomerDeviceInfoManager.access$4400(this.this$0).getCustomerSummaryVersionLabel().setText(this.newVersion);
            CustomerDeviceInfoManager.access$4500(this.this$0).getCustomerNewVersionLabel().setText(this.getNewVersion());
            if (this.isNavDBUpdateMedium()) {
                CustomerDeviceInfoManager.access$4600(this.this$0).getCustomerNaviDbChoice().setValue(1);
                CustomerDeviceInfoManager.access$4700(this.this$0).getCustomerCurrentVersionLabel().setText("");
            } else {
                CustomerDeviceInfoManager.access$4800(this.this$0).getCustomerNaviDbChoice().setValue(0);
                CustomerDeviceInfoManager.access$4900(this.this$0).getCustomerCurrentVersionLabel().setText(this.getOldVersion());
            }
        }
        this.triggerVersionInfoRead();
    }

    private void startReadVersionInfo() {
        CustomerDeviceInfoManager.access$5000(this.this$0).log(-1601830656, "%1 startReadVersionInfo() for %2 ...", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
        this.waitingForVersionInfo = true;
        this.doReadVersionInfo(this.id);
        this.waitForVersionInfo();
    }

    public void doReadVersionInfo(int n) {
        CustomerDeviceInfoManager.access$5100(this.this$0).log(-2137614336, "%1 doReadVersionInfo(deviceIndex=%2)", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (long)n);
        CustomerDeviceInfoManager.access$5200(this.this$0).doGetFileInfoPath(n);
    }

    private void doDeSelect() {
        CustomerDeviceInfoManager.access$5300(this.this$0).log(-2137614336, "%1 doDeSelect() for %2 additionalInfo=%3", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (long)this.additionalInfo);
        switch (this.additionalInfo) {
            case 0: 
            case 2: 
            case 3: 
            case 4: 
            case 14: {
                CustomerDeviceInfoManager.access$5400(this.this$0).log(-2137614336, "%1 doDeselect() for %2 not needed! additionalInfo=%3 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (long)this.additionalInfo);
                break;
            }
            default: {
                CustomerDeviceInfoManager.access$5500(this.this$0).doSetDeviceSelection(this.id, 0);
                this.additionalInfo = 2;
            }
        }
    }

    private boolean doSelect() {
        CustomerDeviceInfoManager.access$5600(this.this$0).log(-2137614336, "%1 doSelect() for %2, additionalInfo=%3", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (long)this.additionalInfo);
        switch (this.additionalInfo) {
            case 1: 
            case 5: 
            case 6: {
                CustomerDeviceInfoManager.access$5700(this.this$0).log(-2137614336, "%1 doSelect() for %2 not needed (addInfo=%3)! ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (long)this.additionalInfo);
                return true;
            }
            case 2: 
            case 14: {
                CustomerDeviceInfoManager.access$5800(this.this$0).doSetDeviceSelection(this.id, 1);
                this.additionalInfo = 1;
                return true;
            }
        }
        CustomerDeviceInfoManager.access$5900(this.this$0).log(-2137614336, "%1 doSelect() for %2 not possible (addInfo=%3)! ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name, (long)this.additionalInfo);
        return false;
    }

    private synchronized void triggerVersionInfoRead() {
        CustomerDeviceInfoManager.access$6000(this.this$0).log(-1601830656, "%1 triggerVersionInfoRead() for %2 ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
        this.waitingForVersionInfo = false;
        super.notifyAll();
    }

    private synchronized void waitForVersionInfo() {
        CustomerDeviceInfoManager.access$6100(this.this$0).log(-1601830656, "%1 waitForVersionInfo() for %2 started ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
        if (this.waitingForVersionInfo) {
            try {
                super.wait(0);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
        if (this.waitingForVersionInfo) {
            CustomerDeviceInfoManager.access$6200(this.this$0).log(-1601830656, "%1 waitForVersionInfo() for %2 timed out! ", (Object)"[CustomerDeviceInfoManager$DeviceInfo]", (Object)this.name);
            this.waitingForVersionInfo = false;
        }
    }

    static /* synthetic */ boolean access$300(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo) {
        return customerDeviceInfoManager$DeviceInfo.isNavDBUpdateMedium();
    }

    static /* synthetic */ boolean access$7600(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo) {
        return customerDeviceInfoManager$DeviceInfo.doSelect();
    }

    static /* synthetic */ void access$7700(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo) {
        customerDeviceInfoManager$DeviceInfo.doDeSelect();
    }

    static /* synthetic */ void access$8400(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo) {
        customerDeviceInfoManager$DeviceInfo.startReadVersionInfo();
    }

    static /* synthetic */ void access$10600(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo, String string) {
        customerDeviceInfoManager$DeviceInfo.setInstalledVersionInfo(string);
    }

    static /* synthetic */ void access$10700(CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo, String string, String string2) {
        customerDeviceInfoManager$DeviceInfo.setVersionInfo(string, string2);
    }
}

