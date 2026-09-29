/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.app;

import de.audi.app.bap.app.AbstractAppConnector;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.atip.log.LogChannel;

public abstract class AbstractAppConnectorASG
extends AbstractAppConnector {
    private final IFunctionRegistrationASG functionRegistration;

    public AbstractAppConnectorASG(LogChannel logChannel, IFunctionRegistrationASG iFunctionRegistrationASG) {
        super(logChannel);
        this.functionRegistration = iFunctionRegistrationASG;
    }

    protected BAPFunctionPropertyASG getProperty(int n) {
        return this.functionRegistration.getBAPFunctionPropertyASG(n);
    }

    protected BAPFunctionMethodASG getMethod(int n) {
        return this.functionRegistration.getBAPFunctionMethodASG(n);
    }

    protected BAPFunctionArrayASG getArray(int n) {
        return this.functionRegistration.getBAPFunctionArrayASG(n);
    }
}

