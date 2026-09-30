/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.ecall.logger.LoggerEcall;
import de.audi.atip.base.IFrameworkAccess;

public final class BAPApplicationEcall
extends AbstractBAPApplication {
    public BAPApplicationEcall(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, new LoggerEcall(iFrameworkAccess));
    }

    public String getName() {
        return "Ecall";
    }
}

