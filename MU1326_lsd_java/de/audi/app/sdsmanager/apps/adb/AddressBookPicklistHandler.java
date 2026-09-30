/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.IAddressBookPicklistHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

public class AddressBookPicklistHandler
extends DefaultBaseListModelListener
implements IAddressBookPicklistHandler {
    private static final int MAX_COLS_ADB = 3;
    private final LogChannel lc = Logger.getAppADBLog();
    private final AddressBookSDSHandler sdsHandler;
    protected final HMIService hmi;
    protected final ISDSPopupHelper sdsPopupHelper;

    public AddressBookPicklistHandler(AddressBookSDSHandler addressBookSDSHandler, HMIService hMIService, ISDSPopupHelper iSDSPopupHelper) {
        this.sdsHandler = addressBookSDSHandler;
        this.hmi = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.registerListeners();
        this.lc.log(10000000, "AddressBookPicklistHandler initialized.");
    }

    private void registerListeners() {
        SDSUtils.initPickList(this.hmi.getBaseListModel(3867), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(3857), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(3856), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(4276), 3, this);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "AddressBookPickListHandler#itemSelected: id=%1, index=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }

    public void showADBPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#showADBPopup: called");
        SDSUtils.unlockPicklistModel(3867, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(70, true);
    }

    public void showADBNaviPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#showADBNaviPopup: called");
        SDSUtils.unlockPicklistModel(3867, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(71, true);
    }

    public void removeADBNaviPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#removeADBNaviPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(71, false);
    }

    public void removeADBPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#removeADBPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(70, false);
    }

    public void showTelContactPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#showTelContactPopup: called");
        SDSUtils.unlockPicklistModel(3857, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(73, true);
    }

    public void removeTelContactPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#removeTelContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(73, false);
    }

    public void showADBContactPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#showADBContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(72, true);
    }

    public void removeADBContactPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#removeADBContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(72, false);
    }

    public void showMailPopup() {
        this.lc.log(10000000, "AddressBookPickListHandler#showMailPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(78, true);
    }

    public void removeMailPoup() {
        this.lc.log(10000000, "AddressBookPickListHandler#removeMailPoup: called");
        this.sdsPopupHelper.triggerHapticalPopup(78, false);
    }
}

