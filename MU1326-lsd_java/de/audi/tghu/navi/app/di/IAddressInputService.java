/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputService
extends IAddressInputForm {
    @Override
    default public CommandList acceptGivenInput(AddressInputHandler addressInputHandler, NavLocation navLocation) {
    }

    @Override
    default public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
    }

    @Override
    default public NavLocation getInitialLocation() {
    }

    @Override
    default public CommandList getStartAddressInputCommandList(NavLocation navLocation) {
    }

    @Override
    default public CommandList getStartAddressInputCommandList(NavLocation navLocation, int n) {
    }

    @Override
    default public void onNewNaviServiceListener() {
    }

    @Override
    default public void resetMemorySettings() {
    }

    @Override
    default public void setPoiService(IPoiService iPoiService) {
    }
}

