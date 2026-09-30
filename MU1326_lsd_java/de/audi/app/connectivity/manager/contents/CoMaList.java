/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.ISelectionHandler;
import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.app.connectivity.manager.contents.CoMaCategory;
import de.audi.app.connectivity.manager.contents.CoMaCategoryPreview;
import de.audi.app.connectivity.manager.contents.CoMaCategoryRow;
import de.audi.app.connectivity.manager.contents.CoMaRow;
import de.audi.app.connectivity.manager.contents.ICoMaList;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelGUI;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class CoMaList
extends DefaultBaseListModelListener
implements ICoMaList {
    private final CoMaCategoryRow[] categoryRows;
    private final LogChannel log;
    private final IHMIServiceApp hmiService;
    private final BaseListModelApp list;
    private final MenuModelApp menu;
    private final ISelectionHandler selectionHandler;
    private CoMaCategory[] categories;
    private AbstractCoMaDevice[] devices;
    private CoMaCategory openCategory;
    private int visibleDevices = 0;
    private String selectedDevice;
    private final Object lock = new Object();
    private volatile boolean isTerminalModeActive;
    private boolean phoneModuleIsOn = false;

    public CoMaList(LogChannel logChannel, ISelectionHandler iSelectionHandler, IHMIServiceApp iHMIServiceApp, CoMaCategory[] coMaCategoryArray) {
        this.log = logChannel;
        this.hmiService = iHMIServiceApp;
        this.selectionHandler = iSelectionHandler;
        this.list = iHMIServiceApp.getBaseListModel(2500435);
        this.list.setListener(this);
        this.menu = iHMIServiceApp.getMenuModel(2500320);
        this.categories = coMaCategoryArray;
        this.initPreviews();
        this.categoryRows = new CoMaCategoryRow[coMaCategoryArray.length];
        this.initCategoryRows();
        this.initModel();
    }

    private void initPreviews() {
        for (int i2 = 0; i2 < this.categories.length; ++i2) {
            CoMaCategory coMaCategory = this.categories[i2];
            if (coMaCategory.supportsMultipleSelection()) {
                coMaCategory.setPreview(new CoMaCategoryPreview(this.getTextNotAttachedWireless(), this.getTextAttachedNotActive()));
                continue;
            }
            coMaCategory.setPreview(new CoMaCategoryPreview(this.getTextNotAttached(), this.getTextNotAttached()));
        }
    }

    private void initCategoryRows() {
        for (int i2 = 0; i2 < this.categories.length; ++i2) {
            CoMaCategory coMaCategory = this.categories[i2];
            this.categoryRows[i2] = new CoMaCategoryRow(coMaCategory.getCategoryID(), coMaCategory.getPreviewString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initModel() {
        Object object = this.lock;
        synchronized (object) {
            for (int i2 = 0; i2 < this.categoryRows.length; ++i2) {
                this.list.append(this.categoryRows[i2]);
            }
        }
    }

    private String getTextNotAttached() {
        return this.hmiService.getText(2500595);
    }

    private String getTextNotAttachedWireless() {
        return this.hmiService.getText(2500741);
    }

    private String getTextAttachedNotActive() {
        return this.hmiService.getText(0x262886);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDevices(AbstractCoMaDevice[] abstractCoMaDeviceArray) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "##### CoMaList#updateDevices(): BEGIN (%1 devices)", (Object)StringUtils.toString(abstractCoMaDeviceArray));
        }
        boolean bl = false;
        Object object = this.lock;
        synchronized (object) {
            this.devices = abstractCoMaDeviceArray;
            BaseListModelApp baseListModelApp = this.list.getCopy();
            this.updateConnectedDevices(baseListModelApp);
            if (this.openCategory != null) {
                this.updateOpenCategory(abstractCoMaDeviceArray, baseListModelApp);
            }
            bl = this.shouldUpdateCursorPosition(this.list, baseListModelApp);
            this.list.update(baseListModelApp);
        }
        if (bl) {
            this.updateCursorPosition();
        }
        this.log.log(10000000, "##### CoMaList#updateDevices(): END (%1 non-category rows visible)", (long)this.visibleDevices);
    }

    private boolean shouldUpdateCursorPosition(BaseListModelApp baseListModelApp, BaseListModelApp baseListModelApp2) {
        MenuModel.FocusedMenuItem focusedMenuItem;
        if (baseListModelApp.getLength() != baseListModelApp2.getLength()) {
            this.log.log(10000000, "##### CoMaList#shouldUpdateCursorPosition(): list size changed: %1 -> %2", (long)baseListModelApp.getLength(), (long)baseListModelApp2.getLength());
            return true;
        }
        boolean bl = false;
        EvoListRow evoListRow = null;
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            String string;
            CoMaRow coMaRow = (CoMaRow)baseListModelApp.getRow(i2);
            CoMaRow coMaRow2 = (CoMaRow)baseListModelApp2.getRow(i2);
            if (coMaRow.getUniqueID() != coMaRow2.getUniqueID()) {
                bl = true;
                if (!this.log.isDebug()) break;
                this.log.log(10000000, "##### CoMaList#shouldUpdateCursorPosition(): unique id at index %1 changed: %2 -> %3", (long)i2, coMaRow.getUniqueID(), coMaRow2.getUniqueID());
            }
            String string2 = 6 < coMaRow.getColumnCount() ? coMaRow.getDeviceIdentifier() : null;
            String string3 = string = 6 < coMaRow2.getColumnCount() ? coMaRow2.getDeviceIdentifier() : null;
            if (this.isRecordSetDeviceOrIntegrationDevice(coMaRow2) && !CoMaList.areObjectsEqual(string2, string)) {
                bl = true;
                if (!this.log.isDebug()) break;
                this.log.log(10000000, "##### CoMaList#shouldUpdateCursorPosition(): device address at index %1 changed: %2 -> %3", (Object)String.valueOf(i2), (Object)string2, (Object)string);
            }
            if (!this.isRecordSetDeviceOrIntegrationDevice(coMaRow2) || !CoMaList.areObjectsEqual(string, this.selectedDevice)) continue;
            evoListRow = coMaRow2;
        }
        if (!bl && evoListRow != null && this.menu instanceof MenuModelGUI && ((focusedMenuItem = ((MenuModelGUI)((Object)this.menu)).getLastFocusedMenuItem()) == null || evoListRow.getUniqueID() != focusedMenuItem.getUniqueListRowID())) {
            this.log.log(10000000, "##### CoMaList#shouldUpdateCursorPosition(): list not changed, but different device is selected: %1 -> %2", focusedMenuItem != null ? focusedMenuItem.getUniqueListRowID() : -1L, evoListRow.getUniqueID());
            bl = true;
        }
        if (!bl) {
            this.log.log(1000000, "##### CoMaList#shouldUpdateCursorPosition(): list not changed!");
        }
        return bl;
    }

    private boolean isRecordSetDeviceOrIntegrationDevice(CoMaRow coMaRow) {
        return coMaRow.getRecordSet() == 2 || coMaRow.getRecordSet() == 4;
    }

    private static boolean areObjectsEqual(Object object, Object object2) {
        if (object == null || object2 == null) {
            return false;
        }
        return object.equals(object2);
    }

    private void updateOpenCategory(AbstractCoMaDevice[] abstractCoMaDeviceArray, BaseListModelApp baseListModelApp) {
        int n = this.openCategory.getService();
        int n2 = this.removeCount(baseListModelApp);
        int n3 = this.insertCount(n);
        if (this.log.isDebug()) {
            this.log.log(10000000, "CoMaList#updateOpenCategory(): service=%3, removeCount=%1, insertCount=%2", (Object)String.valueOf(n2), (Object)String.valueOf(n3), (Object)String.valueOf(n));
        }
        if (n2 == n3) {
            long l = this.openCategory.hasNewDeviceLine() ? this.openCategory.getNewDeviceLine().getUniqueID() : (long)this.openCategory.getCategoryID();
            int n4 = baseListModelApp.getIndexForUniqueID(l);
            for (int i2 = 0; i2 < abstractCoMaDeviceArray.length; ++i2) {
                if (!abstractCoMaDeviceArray[i2].supports(n)) continue;
                baseListModelApp.setRow(++n4, new CoMaRow(CoMaList.generateUniqueId(this.openCategory, i2), this.openCategory.getCategoryID(), n, abstractCoMaDeviceArray[i2]));
            }
        } else {
            this.removeDevices(baseListModelApp);
            this.insertDevices(baseListModelApp, n, this.openCategory.getNewDeviceLine(), false);
        }
    }

    private static int generateUniqueId(CoMaCategory coMaCategory, int n) {
        return (coMaCategory.getCategoryID() + 1) * 10000 + 1 + n;
    }

    public void setTerminalModeActive(boolean bl) {
        this.isTerminalModeActive = bl;
    }

    public void updateTerminalModeDevicesAmount(int n) {
        boolean bl = n == 0;
        this.log.log(10000000, "CoMaList#updateTerminalModeDevicesAmount(): isTMDeviceListEmpty=%1", bl);
        if (bl) {
            this.log.log(10000000, "CoMaList#updateTerminalModeDevicesAmount(): list was emptied, closing category");
            this.closeOpenCategory();
        }
    }

    public void updatePhoneModuleState(boolean bl) {
        this.phoneModuleIsOn = bl;
    }

    private void updateConnectedDevices(BaseListModelApp baseListModelApp) {
        for (int i2 = 0; i2 < this.categories.length; ++i2) {
            CoMaCategory coMaCategory = this.categories[i2];
            CoMaCategoryRow coMaCategoryRow = (CoMaCategoryRow)baseListModelApp.getRowByUniqueID(coMaCategory.getCategoryID());
            AbstractCoMaDevice abstractCoMaDevice = null;
            for (int i3 = 0; i3 < this.devices.length; ++i3) {
                if (!this.devices[i3].isConnected(coMaCategory.getService())) continue;
                abstractCoMaDevice = this.devices[i3];
                break;
            }
            this.checkCategoryActivationState(coMaCategoryRow);
            if (abstractCoMaDevice != null) {
                this.setCategoryName(coMaCategoryRow, coMaCategory, abstractCoMaDevice);
            } else {
                this.resetCategoryName(coMaCategoryRow, coMaCategory);
            }
            this.updateCategoryRow(baseListModelApp, coMaCategory.getCategoryID(), coMaCategoryRow);
        }
    }

    private void checkCategoryActivationState(CoMaCategoryRow coMaCategoryRow) {
        if (this.isTerminalModeActive) {
            if (coMaCategoryRow.getCategory() != 2 && coMaCategoryRow.getCategory() != 6) {
                coMaCategoryRow.setActivation(false);
            }
        } else {
            boolean bl = !this.phoneModuleIsOn && coMaCategoryRow.getCategory() == 1;
            coMaCategoryRow.setActivation(!bl);
        }
    }

    private void resetCategoryName(CoMaCategoryRow coMaCategoryRow, CoMaCategory coMaCategory) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "CoMaList#resetCategoryName(): %1 no connected Device found.", (Object)coMaCategory.getPreviewString());
        }
        if (coMaCategory.supportsMultipleSelection()) {
            coMaCategoryRow.setDeviceName(coMaCategory.getPreview().updateConnected(false));
        } else {
            coMaCategoryRow.resetDevice(this.getTextNotAttached());
        }
    }

    private void setCategoryName(CoMaCategoryRow coMaCategoryRow, CoMaCategory coMaCategory, AbstractCoMaDevice abstractCoMaDevice) {
        if (coMaCategory.supportsMultipleSelection()) {
            if (this.log.isDebug()) {
                this.log.log(10000000, "CoMaList#setCategoryName(): %1 Multiple selection supported.", (Object)coMaCategory.getPreviewString());
            }
            coMaCategoryRow.setDeviceName(coMaCategory.getPreview().updateConnected(true));
        } else {
            if (this.log.isDebug()) {
                this.log.log(10000000, "CoMaList#setCategoryName(): %2 Found Device %1.", (Object)abstractCoMaDevice, (Object)coMaCategory.getPreviewString());
            }
            coMaCategory.getPreview().updateConnected(true);
            coMaCategoryRow.setDevice(abstractCoMaDevice);
        }
    }

    private int removeCount(BaseListModelApp baseListModelApp) {
        int n = 0;
        Iterator iterator = baseListModelApp.asList().iterator();
        while (iterator.hasNext()) {
            CoMaRow coMaRow = (CoMaRow)iterator.next();
            if (coMaRow.getRecordSet() != 2 && coMaRow.getRecordSet() != 4) continue;
            ++n;
        }
        return n;
    }

    private int insertCount(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.devices.length; ++i2) {
            if (!this.devices[i2].supports(n)) continue;
            ++n2;
        }
        return n2;
    }

    private void removeDevices(BaseListModelApp baseListModelApp) {
        Iterator iterator = baseListModelApp.asList().iterator();
        while (iterator.hasNext()) {
            CoMaRow coMaRow = (CoMaRow)iterator.next();
            if (coMaRow.getRecordSet() != 2 && coMaRow.getRecordSet() != 3 && coMaRow.getRecordSet() != 4) continue;
            if (this.log.isDebug()) {
                this.log.log(10000000, "CoMaList#removeDevices() remove device " + coMaRow);
            }
            baseListModelApp.remove(coMaRow);
            --this.visibleDevices;
        }
    }

    private void insertDevices(BaseListModelApp baseListModelApp, int n, EvoListRow evoListRow, boolean bl) {
        ArrayList arrayList = new ArrayList();
        if (evoListRow != null) {
            arrayList.add(evoListRow);
            this.log.log(10000000, "CoMaList#insertDevices() insert row connectNewDevice=%1", (Object)evoListRow);
        }
        for (int i2 = 0; i2 < this.devices.length; ++i2) {
            AbstractCoMaDevice abstractCoMaDevice = this.devices[i2];
            if (abstractCoMaDevice == null || !abstractCoMaDevice.supports(n)) continue;
            CoMaRow coMaRow = new CoMaRow(CoMaList.generateUniqueId(this.openCategory, i2), this.openCategory.getCategoryID(), n, abstractCoMaDevice);
            if (this.log.isDebug()) {
                this.log.log(10000000, "CoMaList#insertDevices() insert row device %1, service=%2", (Object)coMaRow, (Object)String.valueOf(n));
            }
            arrayList.add(coMaRow);
        }
        if (!arrayList.isEmpty()) {
            EvoListRow[] evoListRowArray = (EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]);
            if (bl) {
                baseListModelApp.insertAfterAndOpen(this.openCategory.getCategoryID(), evoListRowArray);
            } else {
                baseListModelApp.insertAfter((long)this.openCategory.getCategoryID(), evoListRowArray);
            }
            this.visibleDevices += arrayList.size();
        }
    }

    private void updateCursorPosition() {
        if (this.openCategory != null) {
            for (int i2 = 0; i2 < this.list.getLength(); ++i2) {
                CoMaRow coMaRow = (CoMaRow)this.list.getRow(i2);
                if (!this.isRecordSetDeviceOrIntegrationDevice(coMaRow) || coMaRow.getDeviceIdentifier() == null || !coMaRow.getDeviceIdentifier().equals(this.selectedDevice)) continue;
                this.log.log(10000000, "CoMaList#updateCursorPosition(): %1", (Object)coMaRow);
                this.menu.setFocusedItem(2500435, FocusAdvice.KEEP_POSITION, coMaRow.getUniqueID());
                this.menu.trigger(ModelTrigger.JOIN_CURSOR);
                break;
            }
        }
    }

    public void setNewDeviceLineActivation(int n, boolean bl, boolean bl2) {
        CoMaRow coMaRow;
        CoMaCategory coMaCategory = this.getCategory(n);
        if (coMaCategory != null && (coMaRow = coMaCategory.getNewDeviceLine()) != null) {
            int n2;
            coMaRow.setActivation(bl);
            if (!bl) {
                coMaRow.setInfolineTextDisabled(bl2);
            }
            if ((n2 = this.list.getIndexForUniqueID(coMaRow.getUniqueID())) != -1) {
                this.list.setRow(n2, coMaRow);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void closeOpenCategory() {
        Object object = this.lock;
        synchronized (object) {
            BaseListModelApp baseListModelApp = this.list.getCopy();
            this.closeOpenCategory(baseListModelApp);
            this.list.update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        CoMaRow coMaRow = (CoMaRow)evoListRow;
        int n5 = coMaRow.getCategory();
        CoMaCategory coMaCategory = this.getCategory(n5);
        int n6 = coMaRow.getRecordSet();
        if (n6 == 0) {
            if (this.isTerminalModeActive && n5 != 2 && n5 != 6) {
                this.log.log(10000000, "##### CoMaList#itemSelected(): terminal mode is active. Skip.");
                return;
            }
            this.log.log(10000000, "##### CoMaList#itemSelected(): open() BEGIN");
            Object object = this.lock;
            synchronized (object) {
                BaseListModelApp baseListModelApp = this.list.getCopy();
                this.closeOpenCategory(baseListModelApp);
                if (coMaCategory.hasNewDeviceLine() || this.hasSupportedDevices(coMaCategory)) {
                    this.openCategory(baseListModelApp, (CoMaCategoryRow)coMaRow);
                }
                this.list.update(baseListModelApp);
            }
            this.log.log(10000000, "##### CoMaList#itemSelected(): open() END");
        } else if (n6 == 1) {
            this.log.log(10000000, "##### CoMaList#itemSelected(): close() BEGIN");
            this.closeOpenCategory();
            this.log.log(10000000, "##### CoMaList#itemSelected(): close() END");
        } else if (n6 == 2 || n6 == 4) {
            if (coMaRow.isActive()) {
                this.selectionHandler.deviceSelected(coMaRow, n5);
                this.list.fireEvent(n4);
            }
        } else if (n6 == 3 && coMaRow.isActive()) {
            this.selectionHandler.connectNewDeviceSelected(coMaCategory.getService());
            this.list.fireEvent(n4);
        }
    }

    private boolean hasSupportedDevices(CoMaCategory coMaCategory) {
        for (int i2 = 0; i2 < this.devices.length; ++i2) {
            AbstractCoMaDevice abstractCoMaDevice = this.devices[i2];
            if (!abstractCoMaDevice.supports(coMaCategory.getService())) continue;
            return true;
        }
        return false;
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        boolean bl = evoListRow.getInteger(0) == 2 || evoListRow.getInteger(0) == 4;
        this.selectedDevice = bl ? evoListRow.getText(6) : null;
        this.log.log(10000000, "CoMaList#itemFocused(): %1", (Object)this.selectedDevice);
    }

    private void closeOpenCategory(BaseListModelApp baseListModelApp) {
        if (this.openCategory == null) {
            return;
        }
        CoMaCategoryRow coMaCategoryRow = (CoMaCategoryRow)baseListModelApp.getRowByUniqueID(this.openCategory.getCategoryID());
        if (this.visibleDevices > 0) {
            baseListModelApp.removeAndClose(coMaCategoryRow.getUniqueID(), this.visibleDevices);
        }
        this.visibleDevices = 0;
        coMaCategoryRow.close();
        this.updateCategoryRow(baseListModelApp, this.openCategory.getCategoryID(), coMaCategoryRow);
        this.openCategory = null;
    }

    private void openCategory(BaseListModelApp baseListModelApp, CoMaCategoryRow coMaCategoryRow) {
        coMaCategoryRow.open();
        this.openCategory = this.getCategory((int)coMaCategoryRow.getUniqueID());
        this.updateCategoryRow(baseListModelApp, this.openCategory.getCategoryID(), coMaCategoryRow);
        this.insertDevices(baseListModelApp, this.openCategory.getService(), this.openCategory.getNewDeviceLine(), true);
    }

    private CoMaCategory getCategory(int n) {
        for (int i2 = 0; i2 < this.categories.length; ++i2) {
            CoMaCategory coMaCategory = this.categories[i2];
            if (coMaCategory.getCategoryID() != n) continue;
            return coMaCategory;
        }
        return null;
    }

    private void updateCategoryRow(BaseListModelApp baseListModelApp, int n, CoMaRow coMaRow) {
        baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(n), coMaRow);
    }

    public void updateCategoryDeviceName(int n, String string) {
        CoMaCategory coMaCategory = this.getCategory(n);
        coMaCategory.getPreview().updateDeviceName(string);
        CoMaCategoryRow coMaCategoryRow = (CoMaCategoryRow)this.list.getRowByUniqueID(n);
        coMaCategoryRow.setDeviceName(coMaCategory.getPreviewString());
        this.updateCategoryRow(this.list, n, coMaCategoryRow);
    }

    public void languageChanged() {
        for (int i2 = 0; i2 < this.categories.length; ++i2) {
            CoMaCategory coMaCategory = this.categories[i2];
            if (coMaCategory.supportsMultipleSelection()) {
                coMaCategory.getPreview().setTextConstants(this.getTextNotAttachedWireless(), this.getTextAttachedNotActive());
                continue;
            }
            coMaCategory.getPreview().setTextConstants(this.getTextNotAttached(), this.getTextNotAttached());
        }
    }

    public void resetList() {
        this.closeOpenCategory();
    }
}

