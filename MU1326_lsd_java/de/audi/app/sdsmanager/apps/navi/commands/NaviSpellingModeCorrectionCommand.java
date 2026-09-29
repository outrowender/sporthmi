/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class NaviSpellingModeCorrectionCommand
extends AbstractSystemCallCommand {
    private final boolean isSpellingRecog;
    private final byte destinationType;

    public NaviSpellingModeCorrectionCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.isSpellingRecog = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 1);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] destinationType=%3, isSpellingRecog=%2", (Object)this.getName(), (Object)this.isSpellingRecog, (long)this.destinationType);
        switch (this.destinationType) {
            case 3: 
            case 12: {
                this.logger.log(-2137614336, "[%1#execute] Setting city spelling to %2!", (Object)this.getName(), (Object)this.isSpellingRecog);
                SDSModelAccess.setNavSpellingCityModel(this.isSpellingRecog);
                break;
            }
            case 13: {
                this.logger.log(-2137614336, "[%1#execute] Setting street spelling to %2!", (Object)this.getName(), (Object)this.isSpellingRecog);
                SDSModelAccess.setNavSpellingStreetModel(this.isSpellingRecog);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#execute] Unhandled destinationType %2!", (Object)this.getName(), (long)this.destinationType);
            }
        }
        this.processingFinished();
    }
}

