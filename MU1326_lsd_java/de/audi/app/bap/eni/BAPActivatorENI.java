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

    protected String getApplicationName() {
        return "AppBapENI";
    }

    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new BAPApplicationENI(iFrameworkAccess);
    }

    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[BAPActivatorENI#createModules] application: %1", (Object)abstractBAPApplication);
        this.eniModule = new BAPModuleENI(abstractBAPApplication);
        return new AbstractBAPModule[]{this.eniModule};
    }

    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[BAPActivatorENI#createDiagnosis] application: %1", (Object)abstractBAPApplication);
        return new BAPDiagnosisConnectorENI(abstractBAPApplication, this.eniModule);
    }
}

