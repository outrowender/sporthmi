/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.util.jobqueue.TunerJobQueue;

public class TunerBasics {
    private int[] terminals;
    private final IFrameworkAccess framework;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    public final TunerJobQueue tunerJobQueue;

    public TunerBasics(Logger logger, IFrameworkAccess iFrameworkAccess) {
        this.initTerminals();
        this.framework = iFrameworkAccess;
        this.logger = logger;
        this.models = new TunerModels(iFrameworkAccess);
        this.status = new TunerStatus(this.models);
        this.tunerJobQueue = new TunerJobQueue(logger, iFrameworkAccess);
    }

    private void initTerminals() {
        this.terminals = new int[]{0};
    }

    public int[] getTerminals() {
        return this.terminals;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public TunerModels getModels() {
        return this.models;
    }

    public TunerStatus getStatus() {
        return this.status;
    }
}

