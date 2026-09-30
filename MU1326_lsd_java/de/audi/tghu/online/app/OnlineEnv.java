/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.AbstractModelEnvironment;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.online.app.Online;

public class OnlineEnv
extends AbstractModelEnvironment {
    private final LogChannel logChannel = Online.getInstance().getLogChannel();

    public OnlineEnv(IFrameworkAccess iFrameworkAccess, IIDMapper iIDMapper, IIDMapper iIDMapper2) {
        super(iFrameworkAccess, iIDMapper, iIDMapper2);
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }
}

