/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;

public class NaviGetInfoCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private final ILanguageManager languageManager;

    public NaviGetInfoCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, ILanguageManager iLanguageManager) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.languageManager = iLanguageManager;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        NaviService$NaviInfoDetails naviService$NaviInfoDetails = this.service.getNaviInfo(true);
        if (naviService$NaviInfoDetails == null) {
            this.logger.log(-1601830656, "%1#execute: No infoDetails given!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: infoDetails=%2!", (Object)this.getName(), (Object)naviService$NaviInfoDetails);
        this.adjustDistance(naviService$NaviInfoDetails);
        SDSModelAccess.setNavInfoForLevel(naviService$NaviInfoDetails.city, 1);
        SDSModelAccess.setNavInfoForLevel(naviService$NaviInfoDetails.street, 2);
        SDSModelAccess.setNavInfoForLevel(naviService$NaviInfoDetails.houseNumber, 3);
        SDSModelAccess.setNavInfoForLevel(naviService$NaviInfoDetails.country, 4);
        SDSModelAccess.setNavInfoDistance((int)naviService$NaviInfoDetails.distance);
        SDSModelAccess.setNavInfoPOIName(naviService$NaviInfoDetails.poiName);
        SDSModelAccess.setNavInfoScaleUnit(naviService$NaviInfoDetails.distanceUnit);
        SDSModelAccess.setNavInfoTime(this.adjustTime(naviService$NaviInfoDetails.time));
        this.sendResult(1083965440);
    }

    protected String adjustTime(DateMetric dateMetric) {
        return NaviSDSUtils.formatTimeString(dateMetric, this.languageManager, this.sdsHandlerService.getFramework(), this.logger);
    }

    protected void adjustDistance(NaviService$NaviInfoDetails naviService$NaviInfoDetails) {
        switch (naviService$NaviInfoDetails.distanceUnit) {
            case 2: {
                if (!(naviService$NaviInfoDetails.distance < 1.0f)) break;
                naviService$NaviInfoDetails.distance = new Distance(naviService$NaviInfoDetails.distance, 2).getValue(4);
                naviService$NaviInfoDetails.distanceUnit = 3;
                break;
            }
            case 4: {
                naviService$NaviInfoDetails.distance = (float)Math.floor(naviService$NaviInfoDetails.distance / 16448);
                naviService$NaviInfoDetails.distanceUnit = 3;
                break;
            }
        }
    }
}

