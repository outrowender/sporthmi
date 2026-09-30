/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.commands.SaveEntryCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.sds.ISDSController;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.ProfileInfo;

public class NaviADBHandler
extends AbstractADBHandler {
    public static final String NAVI_ADB_LOGCHANNEL_NAME = "App.Navi.ADB";
    public static final String NAVI_ADB_CMDLIST_LOGCHANNEL_NAME = "App.Navi.ADBCmdList";
    private final NavigationEnv env;
    private int mode;
    public static final int MODE_LOAD_ADDRESS = 0;
    public static final int MODE_SAVE_ADDRESS = 1;
    private NavLocation locationToBeStored;
    private int selectedAddressIndex;
    private boolean isMapActive;
    private final NaviServiceListener naviServiceListener;
    private final LocationSerializer locationSerializer;
    private final ADBInterAppService adbInterAppService;

    public NaviADBHandler(NavigationEnv navigationEnv, IconHandler iconHandler, ISDSController iSDSController, NaviServiceListener naviServiceListener, ADBInterAppService aDBInterAppService, LocationSerializer locationSerializer, IVehicle iVehicle, ICommandListFactory iCommandListFactory) {
        super(navigationEnv.getFramework(), navigationEnv.getLogChannel(NAVI_ADB_LOGCHANNEL_NAME), navigationEnv.getLogChannel(NAVI_ADB_CMDLIST_LOGCHANNEL_NAME));
        this.env = navigationEnv;
        this.naviServiceListener = naviServiceListener;
        this.locationSerializer = locationSerializer;
        this.adbInterAppService = aDBInterAppService;
    }

    public int getMode() {
        return this.mode;
    }

    public void setSelectedAddressIndex(int n) {
        this.selectedAddressIndex = n;
    }

    public int getSelectedAddressIndes() {
        return this.selectedAddressIndex;
    }

    public NavLocation getLocationToBeStored() {
        return this.locationToBeStored;
    }

    public void destroy() {
        this.locationToBeStored = null;
        super.destroy();
    }

    public int getInitStartupCompleteMask() {
        return 229;
    }

    public void handleInvalidData(int n, boolean bl) {
        this.log.log(10000000, "NaviADBHandler#handleInvalidData(): reason: %2, reloadMainList: %1", bl, (Object)ADBDbgUtils.dbgInvalidDataReason(n));
    }

    public void setAdbReady(boolean bl) {
        this.log.log(10000000, "NaviADBHandler#setAdbReady(): ready: %1", bl);
        this.env.getChoiceModel(401136).setValue(bl ? 1 : 0);
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
    }

    public void updateNewEntryAvailable(boolean bl) {
        this.env.getHMIService().getChoiceModel(400532).setValue(bl ? 1 : 0);
    }

    public void updateNewTopDestEntryAvailable(boolean bl) {
        this.env.getChoiceModel(400570).setValue(bl ? 1 : 0);
    }

    public void startLoadingAddress() {
        this.mode = 0;
    }

    public void startStoringAddress(NavLocation navLocation) {
        this.mode = 1;
        this.locationToBeStored = navLocation;
    }

    public void finishStoringLocation() {
        int n = this.env.getChoiceModel(400515).getValue();
        this.doFinishStoringLocation(n);
    }

    public void finishStoringLocation(int n) {
        this.doFinishStoringLocation(n);
    }

    private void doFinishStoringLocation(int n) {
        this.env.getLogChannel(NAVI_ADB_LOGCHANNEL_NAME).log(10000000, "NaviADBHandler#doFinishStoringLocation( %1 )", (long)n);
        if (this.currentEntry.addressData[n] == null) {
            this.currentEntry.addressData[n] = new AddressData();
        }
        this.env.getLogChannel(NAVI_ADB_LOGCHANNEL_NAME).log(10000000, "NaviADBHandler#doFinishStoringLocation MPMP navLocationToBeStored( %1 )", (Object)this.locationToStream(this.locationToBeStored));
        this.currentEntry.addressData[n].navLocation = this.locationToStream(this.locationToBeStored);
        this.currentEntry.addressData[n].addressType = n == 0 ? 1 : 2;
        this.env.getLogChannel(NAVI_ADB_LOGCHANNEL_NAME).log(10000000, "NaviADBHandler#doFinishStoringLocation MPMP entry to be saved( %1 )", (Object)this.currentEntry);
        SaveEntryCommand.createSaveEntryCommand(this, this.currentEntry, null);
    }

    public void mapActive(boolean bl) {
        if (this.isMapActive || !bl || this.env.getChoiceModel(401136).getValue() == 1) {
            // empty if block
        }
        this.isMapActive = bl;
    }

    public NavLocation streamToLocation(byte[] byArray) {
        this.log.log(10000000, "NaviADBHandler#streamToLocation(): stream: %1", (Object)byArray);
        return this.locationSerializer.streamToLocation(byArray);
    }

    public byte[] locationToStream(NavLocation navLocation) {
        this.log.log(10000000, "NaviADBHandler#locationToStream(): location: %1", (Object)navLocation);
        return this.locationSerializer.locationToStream(navLocation);
    }

    public boolean isEmptyLocation(byte[] byArray) {
        return byArray == null || byArray.length == 0;
    }

    public ADBInterAppService getADBInterAppService() {
        return this.adbInterAppService;
    }

    public void updateViewSizes(AdbViewSize adbViewSize) {
        boolean bl = adbViewSize.all == 0;
        boolean bl2 = adbViewSize.navi == 0;
        this.env.getChoiceModel(401668).setValue(bl ? 0 : 1);
        this.env.getChoiceModel(401669).setValue(bl2 ? 0 : 1);
    }
}

