/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.remoteservices.BAPApplicationRemoteServices;
import de.audi.app.bap.remoteservices.BAPDiagnosisConnectorRemoteServices;
import de.audi.app.bap.remoteservices.BAPModuleRemoteServices;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;

public final class BAPActivatorRemoteServices
extends AbstractBAPActivator {
    private AbstractBAPModuleASG remoteServicesModule;

    @Override
    protected String getApplicationName() {
        return "AppBapRemoteServices";
    }

    @Override
    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new BAPApplicationRemoteServices(iFrameworkAccess);
    }

    @Override
    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(-2137614336, "[BAPActivatorRemoteServices#createModules] application: %1", (Object)abstractBAPApplication);
        this.remoteServicesModule = new BAPModuleRemoteServices(abstractBAPApplication);
        return new AbstractBAPModule[]{this.remoteServicesModule};
    }

    @Override
    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(-2137614336, "[BAPActivatorRemoteServices#createDiagnosis] application: %1", (Object)abstractBAPApplication);
        return new BAPDiagnosisConnectorRemoteServices(abstractBAPApplication, this.remoteServicesModule);
    }
}

