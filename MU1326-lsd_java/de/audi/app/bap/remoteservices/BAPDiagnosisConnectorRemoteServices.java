/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG;

public class BAPDiagnosisConnectorRemoteServices
extends AbstractBAPDiagnosisConnectorASG {
    public BAPDiagnosisConnectorRemoteServices(AbstractBAPApplication abstractBAPApplication, AbstractBAPModuleASG abstractBAPModuleASG) {
        super(abstractBAPApplication, abstractBAPModuleASG, "AppBapRemoteServices");
    }

    protected void initKeyDescriptions() {
    }

    protected void initCmdDescriptions() {
    }
}

