/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi;

import de.audi.app.navi.evo.details.DetailsHMIListener;
import de.audi.app.navi.evo.tpegpoi.TpegPOIManager;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.PoiDSIHandler;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;

public class TpegPOIService
extends AbstractTpegPOIService {
    private final IStartGuidanceToDestinationSequence startGuidanceSequence;
    private final INaviFavoriteHandler naviFavoriteHandler;
    private final IPoiService poiService;
    private final IDetailsScreen detailsHMIListener;
    private final IVehicle vehicle;
    private final IconHandler iconHandler;
    private final IRouteManager routeManager;
    private final NaviADBHandler navAdbHandler;
    private final ITelService telService;
    private final HomeAddressHandler homeAddressHandler;

    public TpegPOIService(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, MapInterface mapInterface, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, DetailsHMIListener detailsHMIListener, IVehicle iVehicle, IconHandler iconHandler, IRouteManager iRouteManager, PoiDSIHandler poiDSIHandler, NaviADBHandler naviADBHandler, ITelService iTelService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iCommandListFactory, mapInterface, spellerStack);
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.poiService = iPoiService;
        this.detailsHMIListener = detailsHMIListener;
        this.vehicle = iVehicle;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.navAdbHandler = naviADBHandler;
        this.telService = iTelService;
        this.homeAddressHandler = homeAddressHandler;
        this.initTpegPOIInput();
    }

    protected void initTpegPOIInput() {
        if (Util.isHURegionKR()) {
            this.inputManager = new TpegPOIManager(this.env, this.commandListFactory, this.previewMap, this.mapInterface, this.startGuidanceSequence, this.naviFavoriteHandler, this.poiService, this.detailsHMIListener, this.spellerStack, this.vehicle, this.iconHandler, this.routeManager, this.navAdbHandler, this.telService, this.homeAddressHandler);
        } else {
            this.logChannel.log(10000, "**** %1#initTpegPOIInput - region is NOT AVAILABLE ****", (Object)this.CLASS_NAME);
        }
    }

    public void startTpegPOI() {
        if (!this.tpegPOICommandListMonitor.isActive()) {
            CommandList commandList = ((TpegPOIManager)this.inputManager).getCategoryScreenListener().getStartCommandList();
            commandList.addMonitor(this.tpegPOICommandListMonitor);
            commandList.setErrorCommand(new NavCommand("TpegPOIService#startTpegPOI set DEST_TPEG_POI_DATA_AVAILABLE_CHOICE to TpegPOIConstants.TPEG_DATA_UNAVAILABLE"){

                public void execute() {
                    this.env.getLogChannel().log(1000000, "TpegPOIService#startTpegPOI no TPEG POI data available");
                    this.env.getChoiceModel(402067).setValue(0);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#startTpegPOI");
        } else {
            this.logChannel.log(10000000, "%1#startTpegPOI - the command list to start TPEG POI is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }
}

