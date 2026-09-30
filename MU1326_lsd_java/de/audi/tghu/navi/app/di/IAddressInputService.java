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
    public CommandList acceptGivenInput(AddressInputHandler var1, NavLocation var2);

    public void destAddressInputHKReturn(int var1, int var2, Command var3, Command var4);

    public NavLocation getInitialLocation();

    public CommandList getStartAddressInputCommandList(NavLocation var1);

    public CommandList getStartAddressInputCommandList(NavLocation var1, int var2);

    public void onNewNaviServiceListener();

    public void resetMemorySettings();

    public void setPoiService(IPoiService var1);
}

