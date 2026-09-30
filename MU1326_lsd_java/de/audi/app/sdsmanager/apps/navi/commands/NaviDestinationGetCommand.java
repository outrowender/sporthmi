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

public class NaviDestinationGetCommand
extends AbstractSystemCallCommand {
    private static final String COUNTRY_ABBREVIATION_NAME_USA = "USA";
    private final NaviService naviService;
    private final byte destinationType;

    public NaviDestinationGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        int n = NaviSDSUtils.getNaviDestType(this.destinationType);
        switch (n) {
            case -1: {
                this.logger.log(100000, "[%1#execute] No matching destination type found!", (Object)this.getName());
                this.sendResult(3001);
                return;
            }
            case 7: {
                int n2 = this.checkStateForCurrentCountry();
                this.sendResult(n2);
                return;
            }
        }
        boolean bl = this.naviService.isDestTypeSet(n);
        this.logger.log(10000000, "[%1#execute] navi dest type=%3, is set: %2!", (Object)this.getName(), (Object)bl, (long)n);
        this.sendResult(bl ? 3000 : 3001);
    }

    private int checkStateForCurrentCountry() {
        NaviService.NaviInfoDetails naviInfoDetails = this.naviService.getAddressDetails((byte)1);
        if (naviInfoDetails == null) {
            this.logger.log(100000, "[%1#checkStateForCurrentCountry] naviInfoDetails are null => send MAPPING_ERROR!", (Object)this.getName());
            return 3001;
        }
        if (SDSUtils.isEmpty(naviInfoDetails.country)) {
            this.logger.log(100000, "[%1#checkStateForCurrentCountry] Country is null or empty => send MAPPING_ERROR!", (Object)this.getName());
            return 3001;
        }
        if (naviInfoDetails.countryAbbreviation.equalsIgnoreCase(COUNTRY_ABBREVIATION_NAME_USA) && SDSUtils.isEmpty(naviInfoDetails.state)) {
            this.logger.log(10000000, "[%1#checkStateForCurrentCountry] Country is %2 and state not (yet) set => send MAPPING_ERROR!", (Object)this.getName(), (Object)COUNTRY_ABBREVIATION_NAME_USA);
            return 3001;
        }
        SDSModelAccess.setOneShotStateLabel(naviInfoDetails.state);
        this.logger.log(10000000, "[%1#checkStateForCurrentCountry] State is set or currently in country which has no states => send MAPPING_OK!", (Object)this.getName());
        return 3000;
    }
}

