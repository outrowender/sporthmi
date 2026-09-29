/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.app.online.evo.operatorcall.OperatorCallHandlerEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.tghu.online.app.JokerKeyHandler;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.handler.AbstractOperatorCallHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.GeneralMiniAppHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;
import org.osgi.framework.BundleContext;

public class OperatorCallMainEvo
extends AbstractOperatorCallMain {
    public OperatorCallMainEvo(IFrameworkAccess iFrameworkAccess, OnlineEnv onlineEnv, JokerKeyHandler jokerKeyHandler, BundleContext bundleContext, boolean bl, boolean bl2, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(iFrameworkAccess, remoteHMIService, onlineEnv, bundleContext, bl, bl2);
        this.remoteHMIService = remoteHMIService;
        this.logChannel.log(1078071040, "OperatorCallMainEvo#constructor: called");
        this.miniAppHandler = new GeneralMiniAppHandler(onlineEnv, this.operatorCallHandler);
        this.jokerKeyHandler = jokerKeyHandler;
        this.onlineOperatorCallService = onlinePOICall;
    }

    @Override
    protected AbstractOperatorCallHandler createOperatorCallHandler(IFrameworkAccess iFrameworkAccess, RemoteHMIService remoteHMIService) {
        return new OperatorCallHandlerEvo(this, this.telHandler, this.cmdListManager, this.naviHandler, iFrameworkAccess, this.intelliDestOperatorCallDataProvider, this.onlineOperatorCallService, remoteHMIService);
    }

    @Override
    public void setLanguage(Language language) {
        this.cmdListManager.setLanguage(language.getHmiCode());
        this.miniAppHandler.triggerLanguageChange();
    }

    @Override
    public void setOnlineServiceProvider(AbstractExternalServiceProvider abstractExternalServiceProvider) {
        this.miniAppHandler.setOnlineServiceProvider(abstractExternalServiceProvider);
    }

    @Override
    public void updateMiniAppList(List list) {
        this.miniAppHandler.updateMiniAppList(list);
    }
}

