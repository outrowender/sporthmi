/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$1;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceListHandler;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceListRow;

class CustomerDeviceInfoManager$DeviceListListener
implements BaseListModelListener {
    private final /* synthetic */ CustomerDeviceInfoManager this$0;

    private CustomerDeviceInfoManager$DeviceListListener(CustomerDeviceInfoManager customerDeviceInfoManager) {
        this.this$0 = customerDeviceInfoManager;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        CustomerDeviceInfoManager$DeviceListRow customerDeviceInfoManager$DeviceListRow;
        CustomerDeviceInfoManager.access$6300(this.this$0).log(-2137614336, "[CustomerDeviceInfoManager$DeviceListListener].itemSelected(row=%1,model=%2,terminal=%3)", (Object)evoListRow, (long)n, (long)n4);
        if (n == CustomerDeviceInfoManager.access$6400(this.this$0).getDevicesListModel().getID() && null != (customerDeviceInfoManager$DeviceListRow = (CustomerDeviceInfoManager$DeviceListRow)evoListRow)) {
            boolean bl = CustomerDeviceInfoManager$DeviceListRow.access$200(customerDeviceInfoManager$DeviceListRow);
            CustomerDeviceInfoManager$DeviceListHandler.access$6600(CustomerDeviceInfoManager.access$6500(this.this$0), customerDeviceInfoManager$DeviceListRow.getInternalDeviceIndex(), !bl);
            CustomerDeviceInfoManager$DeviceListRow customerDeviceInfoManager$DeviceListRow2 = new CustomerDeviceInfoManager$DeviceListRow(this.this$0, customerDeviceInfoManager$DeviceListRow);
            CustomerDeviceInfoManager$DeviceListRow.access$6700(customerDeviceInfoManager$DeviceListRow2, !bl);
            CustomerDeviceInfoManager.access$6800(this.this$0).getDevicesListModel().setRow(n2, customerDeviceInfoManager$DeviceListRow2);
            this.updateStartUpdateButton();
        }
    }

    private void updateStartUpdateButton() {
        boolean bl = false;
        for (int i2 = 0; i2 < CustomerDeviceInfoManager$DeviceListHandler.access$6900(CustomerDeviceInfoManager.access$6500(this.this$0)); ++i2) {
            if (!CustomerDeviceInfoManager$DeviceListRow.access$200((CustomerDeviceInfoManager$DeviceListRow)CustomerDeviceInfoManager.access$7000(this.this$0).getDevicesListModel().getRow(i2))) continue;
            bl = true;
            break;
        }
        CustomerDeviceInfoManager.access$7100(this.this$0).log(-2137614336, "[CustomerDeviceInfoManager$DeviceListListener].updateStartUpdateButton(): isEnabled = %1", bl);
        CustomerDeviceInfoManager.access$7200(this.this$0).getCustomerStartDownloadButton().setStatus(bl ? 1 : 0);
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    /* synthetic */ CustomerDeviceInfoManager$DeviceListListener(CustomerDeviceInfoManager customerDeviceInfoManager, CustomerDeviceInfoManager$1 customerDeviceInfoManager$1) {
        this(customerDeviceInfoManager);
    }
}

