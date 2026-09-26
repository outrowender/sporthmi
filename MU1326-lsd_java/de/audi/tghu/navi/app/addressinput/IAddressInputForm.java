/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.sds.IAddressInputSDSForm;
import de.audi.tghu.navi.app.di.IBackupLocationHandler;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputForm
extends IBackupLocationHandler {
    default public CommandList acceptGivenInput(AddressInputHandler addressInputHandler, NavLocation navLocation) {
    }

    default public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
    }

    default public NavLocation getInitialLocation() {
    }

    default public CommandList getStartAddressInputCommandList(NavLocation navLocation) {
    }

    default public CommandList getStartAddressInputCommandList(NavLocation navLocation, int n) {
    }

    default public void onNewNaviServiceListener() {
    }

    default public void resetMemorySettings() {
    }

    default public void setPoiService(IPoiService iPoiService) {
    }

    default public void start() {
    }

    default public void start(NavLocation navLocation) {
    }

    default public void startForOnline() {
    }

    default public void startWithoutStrip(NavLocation navLocation) {
    }

    default public void startCityZipInputSequence() {
    }

    default public void startForRemoteHMI() {
    }

    default public IAddressInputFormModelAccessHelper getModelAccessHelper() {
    }

    default public IAddressInputSDSForm getSDSAddressInputForm() {
    }
}

