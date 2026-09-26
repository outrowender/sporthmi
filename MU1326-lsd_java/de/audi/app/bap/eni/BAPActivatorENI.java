/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.eni.BAPApplicationENI;
import de.audi.app.bap.eni.BAPDiagnosisConnectorENI;
import de.audi.app.bap.eni.BAPModuleENI;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;

public final class BAPActivatorENI
extends AbstractBAPActivator {
    private AbstractBAPModuleASG eniModule;

    @Override
    protected String getApplicationName() {
        return "AppBapENI";
    }

    @Override
    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new BAPApplicationENI(iFrameworkAccess);
    }

    @Override
    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(-2137614336, "[BAPActivatorENI#createModules] application: %1", (Object)abstractBAPApplication);
        this.eniModule = new BAPModuleENI(abstractBAPApplication);
        return new AbstractBAPModule[]{this.eniModule};
    }

    @Override
    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(-2137614336, "[BAPActivatorENI#createDiagnosis] application: %1", (Object)abstractBAPApplication);
        return new BAPDiagnosisConnectorENI(abstractBAPApplication, this.eniModule);
    }
}

