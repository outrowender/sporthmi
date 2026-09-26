/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnector
 */
package de.audi.app.combi.bap;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.fw.CombiCodingAccess;
import de.audi.app.combi.bap.fw.CombiModelAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnector;

public abstract class AbstractCombiActivator
extends AbstractBAPActivator {
    @Override
    protected void init() {
        CombiModelAccess.init(this.framework);
        CombiCodingAccess.init(this.framework);
    }

    @Override
    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        return new CombiDiagnosisConnector((AbstractCombiBAPApplication)abstractBAPApplication);
    }
}

