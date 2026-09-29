/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviInputStartingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.log.LogChannel;

public class NaviInputStartedCommand
extends AbstractSystemCallCommand
implements ISDSNaviInputStartingCommand {
    private final byte destinationType;
    private final NaviSDSHandlerImpl sdsHandler;
    private final NaviService naviService;
    private final IOnlineDestinationService onlineDestService;

    public NaviInputStartedCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandlerImpl naviSDSHandlerImpl, NaviService naviService, IOnlineDestinationService iOnlineDestinationService) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.naviService = naviService;
        this.onlineDestService = iOnlineDestinationService;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        NaviSDSUtils.resetVDEData(this.destinationType, this.sdsHandler);
        NaviSDSUtils.setInputStartedMode(this.destinationType, this.sdsHandler, this.logger);
        switch (this.destinationType) {
            case 23: {
                this.logger.log(-2137614336, "[%1#execute] POI online input started, sending OK!", (Object)this.getName());
                this.sendResult(3000);
                break;
            }
            case 27: {
                this.logger.log(-2137614336, "[%1#execute] MyAudi-contact input started, sending OK!", (Object)this.getName());
                this.onlineDestService.enterOnlineDestinationHandling();
                this.sendResult(3000);
                break;
            }
            case 35: {
                this.logger.log(-2137614336, "[%1#execute] Map Code input started", (Object)this.getName());
                this.naviService.enterMapCode();
                break;
            }
            case 37: {
                this.logger.log(-2137614336, "[%1#execute] Phone number input started", (Object)this.getName());
                this.naviService.enterTelephoneNumber();
                break;
            }
            case 44: 
            case 46: 
            case 47: {
                int n = NaviSDSUtils.getNaviDestType(this.destinationType);
                this.logger.log(-2137614336, "[%1#execute] Starting destination input with destType %2", (Object)this.getName(), (long)n);
                this.naviService.startDestinationInputWithCurrentLD(n);
                break;
            }
            case 10: {
                this.sdsHandler.setAIFCountry(true);
            }
            default: {
                int n = NaviSDSUtils.getNaviDestType(this.destinationType);
                this.logger.log(-2137614336, "[%1#execute] Starting destination input with destType %2!", (Object)this.getName(), (long)n);
                this.naviService.startDestinationInput(n);
            }
        }
    }

    @Override
    public void responseStartDestinationInput(byte by) {
        this.logger.log(-2137614336, "%1#responseStartDestinationInput: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "%1#responseStartDestinationInput: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

