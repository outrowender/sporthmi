/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.eni.logger.LoggerENI;
import de.audi.atip.base.IFrameworkAccess;

public final class BAPApplicationENI
extends AbstractBAPApplication {
    public BAPApplicationENI(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, new LoggerENI(iFrameworkAccess));
    }

    @Override
    public String getName() {
        return "ENI";
    }
}

