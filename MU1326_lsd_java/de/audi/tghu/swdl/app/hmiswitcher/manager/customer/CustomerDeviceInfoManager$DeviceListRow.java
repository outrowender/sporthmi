/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager$DeviceInfo;

class CustomerDeviceInfoManager$DeviceListRow
extends EvoListRow {
    private static final int COLUMN_NUMBER;
    private static final int COLUMN_COMPONENT_NAME;
    private static final int COLUMN_COMPONENT_SELECTED;
    private static final int COLUMN_COMPONENT_VERSION;
    private static final int COLUMN_COMPONENT_LIST_INDEX;
    private static final int SELECTED;
    private static final int NOT_SELECTED;
    private int internalDeviceIndex;
    private final /* synthetic */ CustomerDeviceInfoManager this$0;

    public CustomerDeviceInfoManager$DeviceListRow(CustomerDeviceInfoManager customerDeviceInfoManager, CustomerDeviceInfoManager$DeviceInfo customerDeviceInfoManager$DeviceInfo, boolean bl, int n) {
        this.this$0 = customerDeviceInfoManager;
        super(n, 4);
        this.setText(0, customerDeviceInfoManager$DeviceInfo.getDescription());
        this.setInteger(1, bl ? 1 : 0);
        this.setText(2, customerDeviceInfoManager$DeviceInfo.getNewVersion());
        this.setInteger(3, n);
        this.setInternalDeviceIndex(customerDeviceInfoManager$DeviceInfo.id);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.hasEqualCells((EvoListRow)object);
    }

    private boolean hasEqualCells(EvoListRow evoListRow) {
        if (evoListRow.getColumnCount() == this.getColumnCount()) {
            for (int i2 = 0; i2 < this.getColumnCount(); ++i2) {
                if (evoListRow.getCell(i2) != null && evoListRow.getCell(i2).equals(this.getCell(i2))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public CustomerDeviceInfoManager$DeviceListRow(CustomerDeviceInfoManager customerDeviceInfoManager, CustomerDeviceInfoManager$DeviceListRow customerDeviceInfoManager$DeviceListRow) {
        this.this$0 = customerDeviceInfoManager;
        super(customerDeviceInfoManager$DeviceListRow);
        this.setInternalDeviceIndex(customerDeviceInfoManager$DeviceListRow.getInternalDeviceIndex());
    }

    @Override
    public EvoListRow copy() {
        return new CustomerDeviceInfoManager$DeviceListRow(this.this$0, this);
    }

    public int getInternalDeviceIndex() {
        return this.internalDeviceIndex;
    }

    private void setInternalDeviceIndex(int n) {
        this.internalDeviceIndex = n;
    }

    private boolean isDeviceSelected() {
        return this.getInteger(1) == 1;
    }

    private void setSelected(boolean bl) {
        this.setInteger(1, bl ? 1 : 0);
    }

    @Override
    public String toString() {
        return new StringBuffer("[DeviceListRow]:").append(this.getText(0)).append(",version=").append(this.getText(2)).append(",isselected=").append(this.getInteger(1)).append(",listIndex=").append(this.getInteger(3)).toString();
    }

    static /* synthetic */ boolean access$200(CustomerDeviceInfoManager$DeviceListRow customerDeviceInfoManager$DeviceListRow) {
        return customerDeviceInfoManager$DeviceListRow.isDeviceSelected();
    }

    static /* synthetic */ void access$6700(CustomerDeviceInfoManager$DeviceListRow customerDeviceInfoManager$DeviceListRow, boolean bl) {
        customerDeviceInfoManager$DeviceListRow.setSelected(bl);
    }
}

