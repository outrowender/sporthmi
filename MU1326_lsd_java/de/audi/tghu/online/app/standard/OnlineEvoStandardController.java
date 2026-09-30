/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.standard.AbstractStandardController;
import de.audi.tghu.online.app.standard.OnlineI18NHandler;

public class OnlineEvoStandardController
extends AbstractStandardController {
    private static final int ALERT_SERVICE_ACTIVE = 1;

    public OnlineEvoStandardController(LogChannel logChannel, HMIService hMIService, int n, OnlineI18NHandler onlineI18NHandler, IFrameworkAccess iFrameworkAccess) {
        super(logChannel, hMIService, n, onlineI18NHandler, iFrameworkAccess);
        logChannel.log(1000000, "OnlineEvoStandardController#c'tor");
    }

    public void onUserList(User[] userArray) {
        super.onUserList(userArray);
    }

    public void onMonitorings(int n, int n2, int n3) {
        super.onMonitorings(n, n2, n3);
        this.powerManager.setAlertServiceActive(n == 1 || n2 == 1 || n3 == 1);
    }
}

