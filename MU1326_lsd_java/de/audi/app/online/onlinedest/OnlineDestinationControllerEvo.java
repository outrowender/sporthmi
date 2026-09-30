/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.onlinedest;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;

public class OnlineDestinationControllerEvo
extends OnlineDestinationController {
    public OnlineDestinationControllerEvo(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        super(logChannel, iFrameworkAccess);
    }

    protected int getNewDistinationsAvailablePopupId() {
        return 2300006;
    }
}

