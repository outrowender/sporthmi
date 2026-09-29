/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IBackupLocationHandler;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputManager
extends IBackupLocationHandler {
    default public CommandList abortAddressInput(boolean bl) {
    }

    default public CommandList acceptGivenInput(AddressInputHandler addressInputHandler, NavLocation navLocation) {
    }

    default public void addAddressToFavorites(NavLocation navLocation) {
    }

    default public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
    }

    default public void executeAddressInputEvent(CommandList commandList, int n) {
    }

    default public NavLocation getInitialLocation() {
    }

    default public CommandList getStartParkingNearDestination(NavLocation navLocation) {
    }

    default public void startPoiNearDestination(NavLocation navLocation) {
    }

    default public CommandList handleAddressInputEvent(CommandList commandList, int n) {
    }

    default public void onNewNaviServiceListener() {
    }

    default public void resetMemorySettings() {
    }

    default public void setPoiService(IPoiService iPoiService) {
    }

    default public IPoiService getPoiService() {
    }

    default public void start() {
    }

    default public void start(NavLocation navLocation) {
    }

    default public void startWithoutStrip(NavLocation navLocation) {
    }

    default public void startForOnline() {
    }

    default public void startForOnline(CommandList commandList) {
    }

    default public void startStoringNavLocationOnAdbEntry(NavLocation navLocation) {
    }

    default public void startStreetInputSequenceWithFollowupJunction(boolean bl) {
    }

    default public int getActiveSpellerContextId() {
    }

    default public int getAutoSelectLeftElementEventId() {
    }

    default public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
    }

    default public int getStreetScreenAmbiguousListElementSelecteEventId() {
    }

    default public int getStartForOnlineEventId() {
    }

    default public int getStartCityInputFromMainScreenEventId() {
    }

    default public IAddressInputMainScreenListener getMainScreenListener() {
    }

    default public void startForRemoteHMI() {
    }

    default public int getStartForRemoteHMIEventId() {
    }
}

