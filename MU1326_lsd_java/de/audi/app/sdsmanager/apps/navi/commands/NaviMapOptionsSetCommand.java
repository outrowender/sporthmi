/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.def.NullMapService;
import de.audi.atip.log.LogChannel;

public class NaviMapOptionsSetCommand
extends AbstractSystemCallCommand {
    private static final int MAP_OPTIONS_AUTO = 0;
    private static final int MAP_OPTIONS_DAY = 1;
    private static final int MAP_OPTIONS_NIGHT = 2;
    private static final int MAP_OPTIONS_BIRDVIEW = 3;
    private static final int MAP_OPTIONS_DESTINATION = 4;
    private static final int MAP_OPTIONS_GOOGLE_EARTH = 5;
    private static final int MAP_OPTIONS_CROSSING_OFF = 6;
    private static final int MAP_OPTIONS_CROSSING_ON = 7;
    private static final int MAP_OPTIONS_OVERVIEW = 8;
    private static final int MAP_OPTIONS_POSITION_DIRECTION_DRIVING = 9;
    private static final int MAP_OPTIONS_POSITION_DIRECTION_NORTH = 10;
    private static final int MAP_OPTIONS_SPLIT_OFF = 11;
    private static final int MAP_OPTIONS_SPLIT_OVERVIEW_ON = 12;
    private static final int MAP_OPTIONS_SPLIT_RANGE = 13;
    private static final int MAP_OPTIONS_SPLIT_ROUTE_INFO_ON = 14;
    private static final int MAP_OPTIONS_STANDARD = 15;
    private static final int MAP_OPTIONS_TRAFFIC = 16;
    private static final int MAP_OPTIONS_SWITCH = 17;
    private static final int MAP_OPTIONS_RANGE = 18;
    private static final int MAP_OPTIONS_SPLIT_ROUTE_MANEUVER = 19;
    private MapService mapService;
    private final int mapOption;

    public NaviMapOptionsSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, MapService mapService) {
        super(logChannel, string, sDSHandlerService);
        this.mapService = new NullMapService(this.logger);
        this.mapService = mapService;
        this.mapOption = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: mapOption=%2", (Object)this.getName(), (long)this.mapOption);
        boolean bl = true;
        int n = 0;
        switch (this.mapOption) {
            case 5: {
                this.logger.log(10000000, "%1#execute: Switching to Google Earth view!", (Object)this.getName());
                bl = this.mapService.sdsSetMapRepresentation(1);
                break;
            }
            case 15: {
                this.logger.log(10000000, "%1#execute: Switching to standard view!", (Object)this.getName());
                bl = this.mapService.sdsSetMapRepresentation(0);
                break;
            }
            case 16: {
                this.logger.log(10000000, "%1#execute: Switching to traffic view!", (Object)this.getName());
                bl = this.mapService.sdsSetMapRepresentation(2);
                break;
            }
            case 0: {
                this.logger.log(10000000, "%1#execute: Setting automatic colours for map!", (Object)this.getName());
                this.mapService.setMapColor(2);
                break;
            }
            case 3: {
                this.logger.log(10000000, "%1#execute: Setting birdview map!", (Object)this.getName());
                n = this.mapService.setMapType(2);
                break;
            }
            case 6: {
                this.logger.log(10000000, "%1#execute: Switching crossing off!", (Object)this.getName());
                this.mapService.setCrossingView(1);
                break;
            }
            case 7: {
                this.logger.log(10000000, "%1#execute: Switching crossing on!", (Object)this.getName());
                this.mapService.setCrossingView(0);
                break;
            }
            case 1: {
                this.logger.log(10000000, "%1#execute: Setting day colours for map!", (Object)this.getName());
                this.mapService.setMapColor(0);
                break;
            }
            case 4: {
                this.logger.log(10000000, "%1#execute: Setting destination map!", (Object)this.getName());
                n = this.mapService.setMapType(0);
                break;
            }
            case 2: {
                this.logger.log(10000000, "%1#execute: Setting night colours for map!", (Object)this.getName());
                this.mapService.setMapColor(1);
                break;
            }
            case 8: {
                this.logger.log(10000000, "%1#execute: Setting Overview map!", (Object)this.getName());
                n = this.mapService.setMapType(3);
                break;
            }
            case 9: {
                this.logger.log(10000000, "%1#execute: Setting 2D position map!", (Object)this.getName());
                n = this.mapService.setMapType(1);
                this.mapService.setMapOrientation(1);
                break;
            }
            case 10: {
                this.logger.log(10000000, "%1#execute: Setting 2D north map!", (Object)this.getName());
                n = this.mapService.setMapType(1);
                this.mapService.setMapOrientation(0);
                break;
            }
            case 11: {
                this.logger.log(10000000, "%1#execute: Unsetting splitting!", (Object)this.getName());
                this.mapService.setAdditionalInfos(3);
                break;
            }
            case 12: {
                this.logger.log(10000000, "%1#execute: Setting overview map splitting!", (Object)this.getName());
                this.mapService.setAdditionalInfos(2);
                break;
            }
            case 13: {
                this.logger.log(100000, "%1#execute: Unhandled mapOption %2!", (Object)this.getName(), (long)this.mapOption);
                break;
            }
            case 17: {
                this.logger.log(10000000, "%1#execute: Setting map switch!", (Object)this.getName());
                this.mapService.swapMaps();
                break;
            }
            case 14: {
                this.logger.log(10000000, "%1#execute: Setting route info splitting!", (Object)this.getName());
                this.mapService.setAdditionalInfos(0);
                break;
            }
            case 18: {
                this.logger.log(10000000, "%1#execute: Setting range map (Spiegelei)!", (Object)this.getName());
                this.mapService.setMapRepresentation(3);
                break;
            }
            case 19: {
                this.logger.log(10000000, "%1#execute: Setting route info maneuver!", (Object)this.getName());
                this.mapService.setAdditionalInfos(1);
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: Unhandled mapOption %2!", (Object)this.getName(), (long)this.mapOption);
                bl = false;
            }
        }
        this.logger.log(10000000, "%1#execute: mapServiceResult=%2, mapTypeResult=%3!", (Object)this.getName(), (Object)bl, (long)n);
        if (!bl || n == 1) {
            this.sendResult(3001);
        } else if (n == 2) {
            this.sendResult(3006);
        } else {
            this.sendResult(3000);
        }
    }
}

