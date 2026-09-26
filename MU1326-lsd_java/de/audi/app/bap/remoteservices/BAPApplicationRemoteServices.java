/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.remoteservices.logger.LoggerRemoteServices;
import de.audi.atip.base.IFrameworkAccess;

public class BAPApplicationRemoteServices
extends AbstractBAPApplication {
    public BAPApplicationRemoteServices(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, new LoggerRemoteServices(iFrameworkAccess));
    }

    @Override
    public String getName() {
        return "RemoteServices";
    }
}

