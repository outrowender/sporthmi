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
    public CommandList acceptGivenInput(AddressInputHandler var1, NavLocation var2);

    public void destAddressInputHKReturn(int var1, int var2, Command var3, Command var4);

    public NavLocation getInitialLocation();

    public CommandList getStartAddressInputCommandList(NavLocation var1);

    public CommandList getStartAddressInputCommandList(NavLocation var1, int var2);

    public void onNewNaviServiceListener();

    public void resetMemorySettings();

    public void setPoiService(IPoiService var1);

    public void start();

    public void start(NavLocation var1);

    public void startForOnline();

    public void startWithoutStrip(NavLocation var1);

    public void startCityZipInputSequence();

    public void startForRemoteHMI();

    public IAddressInputFormModelAccessHelper getModelAccessHelper();

    public IAddressInputSDSForm getSDSAddressInputForm();
}

