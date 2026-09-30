/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.ecall.BAPApplicationEcall;
import de.audi.app.bap.ecall.BAPDiagnosisConnectorEcall;
import de.audi.app.bap.ecall.BAPModuleEcall;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;

public final class BAPActivatorEcall
extends AbstractBAPActivator {
    private AbstractBAPModuleASG eCallModule;

    protected String getApplicationName() {
        return "AppBapEcall";
    }

    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new BAPApplicationEcall(iFrameworkAccess);
    }

    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[BAPActivatorEcall#createModules] application: %1", (Object)abstractBAPApplication);
        this.eCallModule = new BAPModuleEcall(abstractBAPApplication);
        return new AbstractBAPModule[]{this.eCallModule};
    }

    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[BAPActivatorEcall#createDiagnosis] application: %1", (Object)abstractBAPApplication);
        return new BAPDiagnosisConnectorEcall(abstractBAPApplication, this.eCallModule);
    }
}

