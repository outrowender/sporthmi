/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.kombipictures.IPictureManager;

public abstract class AbstractCombiModule
extends AbstractBAPModuleFSG {
    public AbstractCombiModule(int n, AbstractCombiBAPApplication abstractCombiBAPApplication) {
        super(n, abstractCombiBAPApplication);
    }

    public AbstractCombiModule(int n, AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(n, abstractBAPApplication, iBAPFunctionFactoryFSG);
    }

    public IPictureManager getPictureManager() {
        return ((AbstractCombiBAPApplication)this.bapApplication).getPictureManager();
    }

    @Override
    protected boolean isRelevantForUpdateProperties(int n) {
        return n != this.getFunctionList().getFctListBAPFctID() && n != this.getFunctionList().getBAPConfigBAPFctID();
    }

    @Override
    public void deactivate() {
        if (((AbstractCombiBAPApplication)this.bapApplication).isMOSTListSupported()) {
            this.listManager.deinit();
        }
        super.deactivate();
    }
}

