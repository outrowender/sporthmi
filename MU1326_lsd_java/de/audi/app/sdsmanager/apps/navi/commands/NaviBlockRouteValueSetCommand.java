/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviBlockRouteValueSetCommand
extends AbstractSystemCallCommand {
    private static final int DISTANCE_UKNOWN;
    private static final int TYPE_KILOMETERS;
    private static final int TYPE_MILES;
    private static final int TYPE_METERS;
    private static final int TYPE_YARDS;
    private static final int TYPE_NEXT_STREET;
    private static final int TYPE_NEXT_SECTION;
    private static final int TYPE_NO_U_TURN;
    private final NaviService service;
    private final int distanceType;

    public NaviBlockRouteValueSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.distanceType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: distanceType=%2", (Object)this.getName(), (long)this.distanceType);
        int n = 128;
        SDSModelAccess.setNavInfoDistance(0);
        switch (this.distanceType) {
            case 5: {
                this.logger.log(-2137614336, "[%1#processBlockRouteValueSet] Blocking next section!", (Object)this.getName());
                n = -1;
                break;
            }
            case 4: {
                this.logger.log(-2137614336, "[%1#processBlockRouteValueSet] Blocking next street!", (Object)this.getName());
                n = 300;
                break;
            }
            case 6: {
                this.logger.log(-2137614336, "[%1#processBlockRouteValueSet] Unblocking next section!", (Object)this.getName());
                this.service.unblockRoute();
                return;
            }
            default: {
                n = this.getDistanceFromSlot();
            }
        }
        if (n == 128) {
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: distance=%2!", (Object)this.getName(), (long)n);
        this.service.blockRoute(n);
    }

    private int getDistanceFromSlot() {
        String string = SDSModelAccess.getSlotModelStrings()[0];
        int n = 128;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(-1601830656, "[%1#execute: No number found in '%2', returning DISTANCE_UKNOWN!", (Object)this.getName(), (Object)string);
            return n;
        }
        switch (this.distanceType) {
            case 0: {
                this.logger.log(-2137614336, "[%1#execute: Kilometers recognized, multiplying distance with 1000!", (Object)this.getName());
                n *= 1000;
                break;
            }
            case 1: {
                this.logger.log(-2137614336, "[%1#execute: Miles recognized, multiplying distance with 1760 * 0,9144!", (Object)this.getName());
                n = (int)((double)(n * 1760) * 0.9144);
                break;
            }
            case 3: {
                this.logger.log(-2137614336, "%1#execute: Yards recognized, multiplying distance with 1760 * 0,9144!", (Object)this.getName());
                n = (int)((double)n * 0.9144);
                break;
            }
            case 2: {
                this.logger.log(-2137614336, "%1#execute: Meters recognized, no multiplication needed!", (Object)this.getName());
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unhandled distanceType %2, sending ERROR!", (Object)this.getName(), (long)this.distanceType);
                return n;
            }
        }
        return n;
    }

    public void responseBlockRoute(byte by) {
        this.logger.log(-2137614336, "%1#responseBlockRoute: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "%1#responseBlockRoute: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    public void responseUnblockRoute(byte by) {
        this.logger.log(-2137614336, "%1#responseUnblockRoute: result=%2, calling responseBlockRoute!", (Object)this.getName(), (long)by);
        this.responseBlockRoute(by);
    }
}

