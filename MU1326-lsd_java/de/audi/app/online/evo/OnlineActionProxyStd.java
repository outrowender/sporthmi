/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineBaseActionProxy;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;

public class OnlineActionProxyStd
extends OnlineBaseActionProxy {
    public OnlineActionProxyStd(LogChannel logChannel, HMIService hMIService) {
        super(logChannel, new OnlineModelBankAccess(hMIService));
    }
}

