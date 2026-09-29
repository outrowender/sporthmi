/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.app;

import de.audi.app.bap.app.AbstractAppConnector;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractAppConnectorFSG
extends AbstractAppConnector {
    private final IFunctionRegistrationFSG functionRegistration;

    public AbstractAppConnectorFSG(LogChannel logChannel, IFunctionRegistrationFSG iFunctionRegistrationFSG) {
        super(logChannel);
        this.functionRegistration = iFunctionRegistrationFSG;
    }

    protected void sendPropertyStatus(int n, StatusProperty statusProperty) {
        this.getProperty(n).sendStatusIfChanged(statusProperty);
    }

    private BAPFunctionPropertyFSG getProperty(int n) {
        return this.functionRegistration.getBAPFunctionPropertyFSG(n);
    }
}

