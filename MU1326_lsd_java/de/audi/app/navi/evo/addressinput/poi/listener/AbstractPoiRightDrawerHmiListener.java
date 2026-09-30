/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.LocationFormatter;
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
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public AbstractPoiRightDrawerHmiListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, MapInterface mapInterface, NaviADBHandler naviADBHandler, ITelService iTelService) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.mapInterface = mapInterface;
        this.navAdbHandler = naviADBHandler;
        this.telService = iTelService;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    protected void addToContact(LIValueListElement lIValueListElement, final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new NavCommand("SetLocation As SelectedLocation"){

                public void execute() {
                    this.dsiResponseContainer.setSelectedLocation(navLocation);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand(){

            public void execute() {
                AbstractPoiRightDrawerHmiListener.this.navAdbHandler.startStoringAddress(this.dsiResponseContainer.getSelectedLocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(this.CLASS_NAME + "#addToContact");
    }

    protected void showInMap(LIValueListElement lIValueListElement, final NavLocation navLocation) {
        NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.getLongitude(), lIValueListElement.getLatitude());
        this.mapInterface.onShowInMapClicked(navLocationWgs84);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new NavCommand("SetLocation As SelectedLocation"){

                public void execute() {
                    this.dsiResponseContainer.setSelectedLocation(navLocation);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "%1 - show in map location = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.dsiResponseContainer.getSelectedLocation()));
                AbstractPoiRightDrawerHmiListener.this.mapInterface.destOptShowInMap(this.dsiResponseContainer.getSelectedLocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(this.CLASS_NAME + "#showInMap");
    }

    protected void saveAsFavorite(LIValueListElement lIValueListElement, String string, final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        } else {
            commandList.add(new NavCommand("SetLocation As SelectedLocation"){

                public void execute() {
                    this.dsiResponseContainer.setSelectedLocation(navLocation);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand(){

            public void execute() {
                AbstractPoiRightDrawerHmiListener.this.naviFavoriteHandler.addToFavorites(this.dsiResponseContainer.getSelectedLocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(this.CLASS_NAME + "#saveAsFavorite");
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

