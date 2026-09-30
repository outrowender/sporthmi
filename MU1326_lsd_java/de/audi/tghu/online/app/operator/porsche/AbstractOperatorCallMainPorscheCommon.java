/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.Language;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallPorscheCommon;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.osgi.framework.BundleContext;

public abstract class AbstractOperatorCallMainPorscheCommon
extends AbstractOperatorCallMain {
    public AbstractOperatorCallMainPorscheCommon(IFrameworkAccess iFrameworkAccess, RemoteHMIService remoteHMIService, OnlineEnv onlineEnv, BundleContext bundleContext, boolean bl, boolean bl2) {
        super(iFrameworkAccess, remoteHMIService, onlineEnv, bundleContext, bl, bl2);
        ConciergeCallPorscheCommon conciergeCallPorscheCommon = (ConciergeCallPorscheCommon)this.operatorCallHandler.getOperatorCall(1);
        conciergeCallPorscheCommon.setNaviHandler(this.naviHandler);
    }

    public void setLanguage(Language language) {
        this.cmdListManager.setLanguage(language.getHmiCode());
    }

    public void setTelService(ITelService iTelService) {
        super.setTelService(iTelService);
        ConciergeCallPorscheCommon conciergeCallPorscheCommon = (ConciergeCallPorscheCommon)this.operatorCallHandler.getOperatorCall(1);
        conciergeCallPorscheCommon.setTelService(iTelService);
    }

    protected boolean isChina() {
        return this.getCommandListManager().getFramework().getSysConst(442) == 2;
    }
}

