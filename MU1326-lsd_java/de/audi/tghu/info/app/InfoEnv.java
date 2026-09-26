/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.AbstractModelEnvironment;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.info.app.ModelAccess;

public class InfoEnv
extends AbstractModelEnvironment {
    private final ModelAccess modelAccess = new ModelAccess(this);

    public InfoEnv(IFrameworkAccess iFrameworkAccess, IIDMapper iIDMapper, IIDMapper iIDMapper2) {
        super(iFrameworkAccess, iIDMapper, iIDMapper2);
    }

    @Override
    public LogChannel getLogChannel() {
        return this.framework.getLogChannel("App.TMC.Main");
    }

    public ModelAccess getModelAccess() {
        return this.modelAccess;
    }
}

