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
    public CommandList abortAddressInput(boolean var1);

    public CommandList acceptGivenInput(AddressInputHandler var1, NavLocation var2);

    public void addAddressToFavorites(NavLocation var1);

    public void destAddressInputHKReturn(int var1, int var2, Command var3, Command var4);

    public void executeAddressInputEvent(CommandList var1, int var2);

    public NavLocation getInitialLocation();

    public CommandList getStartParkingNearDestination(NavLocation var1);

    public void startPoiNearDestination(NavLocation var1);

    public CommandList handleAddressInputEvent(CommandList var1, int var2);

    public void onNewNaviServiceListener();

    public void resetMemorySettings();

    public void setPoiService(IPoiService var1);

    public IPoiService getPoiService();

    public void start();

    public void start(NavLocation var1);

    public void startWithoutStrip(NavLocation var1);

    public void startForOnline();

    public void startForOnline(CommandList var1);

    public void startStoringNavLocationOnAdbEntry(NavLocation var1);

    public void startStreetInputSequenceWithFollowupJunction(boolean var1);

    public int getActiveSpellerContextId();

    public int getAutoSelectLeftElementEventId();

    public int getStreetScreenNonAmbiguousListElementSelectedEventId();

    public int getStreetScreenAmbiguousListElementSelecteEventId();

    public int getStartForOnlineEventId();

    public int getStartCityInputFromMainScreenEventId();

    public IAddressInputMainScreenListener getMainScreenListener();

    public void startForRemoteHMI();

    public int getStartForRemoteHMIEventId();
}

