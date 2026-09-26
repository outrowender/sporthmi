/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$1;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$2;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$3;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$4;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$5;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener$6;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractPoiRightDrawerHmiListener
implements OptionModelListener {
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final INaviFavoriteHandler naviFavoriteHandler;
    protected final MapInterface mapInterface;
    protected final NaviADBHandler navAdbHandler;
    protected final ITelService telService;
    protected final LogChannel logChannel;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public AbstractPoiRightDrawerHmiListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, MapInterface mapInterface, NaviADBHandler naviADBHandler, ITelService iTelService) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.mapInterface = mapInterface;
        this.navAdbHandler = naviADBHandler;
        this.telService = iTelService;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    protected void addToContact(LIValueListElement lIValueListElement, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new AbstractPoiRightDrawerHmiListener$1(this, "SetLocation As SelectedLocation", navLocation));
        }
        commandList.add(new AbstractPoiRightDrawerHmiListener$2(this));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addToContact").toString());
    }

    protected void showInMap(LIValueListElement lIValueListElement, NavLocation navLocation) {
        NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.getLongitude(), lIValueListElement.getLatitude());
        this.mapInterface.onShowInMapClicked(navLocationWgs84);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new AbstractPoiRightDrawerHmiListener$3(this, "SetLocation As SelectedLocation", navLocation));
        }
        commandList.add(new AbstractPoiRightDrawerHmiListener$4(this));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showInMap").toString());
    }

    protected void saveAsFavorite(LIValueListElement lIValueListElement, String string, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new AbstractPoiRightDrawerHmiListener$5(this, "SetLocation As SelectedLocation", navLocation));
        }
        commandList.add(new AbstractPoiRightDrawerHmiListener$6(this));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#saveAsFavorite").toString());
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

