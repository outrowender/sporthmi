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
    private static final int MAX_COLS_ADB;
    private final LogChannel lc = Logger.getAppADBLog();
    private final AddressBookSDSHandler sdsHandler;
    protected final HMIService hmi;
    protected final ISDSPopupHelper sdsPopupHelper;

    public AddressBookPicklistHandler(AddressBookSDSHandler addressBookSDSHandler, HMIService hMIService, ISDSPopupHelper iSDSPopupHelper) {
        this.sdsHandler = addressBookSDSHandler;
        this.hmi = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.registerListeners();
        this.lc.log(-2137614336, "AddressBookPicklistHandler initialized.");
    }

    private void registerListeners() {
        SDSUtils.initPickList(this.hmi.getBaseListModel(3867), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(3857), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(3856), 3, this);
        SDSUtils.initPickList(this.hmi.getBaseListModel(4276), 3, this);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "AddressBookPickListHandler#itemSelected: id=%1, index=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }

    @Override
    public void showADBPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#showADBPopup: called");
        SDSUtils.unlockPicklistModel(3867, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(70, true);
    }

    @Override
    public void showADBNaviPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#showADBNaviPopup: called");
        SDSUtils.unlockPicklistModel(3867, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(71, true);
    }

    @Override
    public void removeADBNaviPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#removeADBNaviPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(71, false);
    }

    @Override
    public void removeADBPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#removeADBPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(70, false);
    }

    @Override
    public void showTelContactPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#showTelContactPopup: called");
        SDSUtils.unlockPicklistModel(3857, this.hmi, this.lc);
        this.sdsPopupHelper.triggerHapticalPopup(73, true);
    }

    @Override
    public void removeTelContactPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#removeTelContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(73, false);
    }

    @Override
    public void showADBContactPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#showADBContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(72, true);
    }

    @Override
    public void removeADBContactPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#removeADBContactPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(72, false);
    }

    @Override
    public void showMailPopup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#showMailPopup: called");
        this.sdsPopupHelper.triggerHapticalPopup(78, true);
    }

    @Override
    public void removeMailPoup() {
        this.lc.log(-2137614336, "AddressBookPickListHandler#removeMailPoup: called");
        this.sdsPopupHelper.triggerHapticalPopup(78, false);
    }
}

