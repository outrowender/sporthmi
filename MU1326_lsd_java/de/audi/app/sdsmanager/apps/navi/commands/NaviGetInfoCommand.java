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

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        NaviService.NaviInfoDetails naviInfoDetails = this.service.getNaviInfo(true);
        if (naviInfoDetails == null) {
            this.logger.log(100000, "%1#execute: No infoDetails given!", (Object)this.getName());
            this.sendResult(40001);
            return;
        }
        this.logger.log(10000000, "%1#execute: infoDetails=%2!", (Object)this.getName(), (Object)naviInfoDetails);
        this.adjustDistance(naviInfoDetails);
        SDSModelAccess.setNavInfoForLevel(naviInfoDetails.city, 1);
        SDSModelAccess.setNavInfoForLevel(naviInfoDetails.street, 2);
        SDSModelAccess.setNavInfoForLevel(naviInfoDetails.houseNumber, 3);
        SDSModelAccess.setNavInfoForLevel(naviInfoDetails.country, 4);
        SDSModelAccess.setNavInfoDistance((int)naviInfoDetails.distance);
        SDSModelAccess.setNavInfoPOIName(naviInfoDetails.poiName);
        SDSModelAccess.setNavInfoScaleUnit(naviInfoDetails.distanceUnit);
        SDSModelAccess.setNavInfoTime(this.adjustTime(naviInfoDetails.time));
        this.sendResult(40000);
    }

    protected String adjustTime(DateMetric dateMetric) {
        return NaviSDSUtils.formatTimeString(dateMetric, this.languageManager, this.sdsHandlerService.getFramework(), this.logger);
    }

    protected void adjustDistance(NaviService.NaviInfoDetails naviInfoDetails) {
        switch (naviInfoDetails.distanceUnit) {
            case 2: {
                if (!(naviInfoDetails.distance < 1.0f)) break;
                naviInfoDetails.distance = new Distance(naviInfoDetails.distance, 2).getValue(4);
                naviInfoDetails.distanceUnit = 3;
                break;
            }
            case 4: {
                naviInfoDetails.distance = (float)Math.floor(naviInfoDetails.distance / 3.0f);
                naviInfoDetails.distanceUnit = 3;
                break;
            }
        }
    }
}

