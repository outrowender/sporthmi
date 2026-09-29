/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.combi.bap.app.kombipictures.IPictureManager;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;

public abstract class AbstractCombiBAPApplication
extends AbstractBAPApplication {
    private IPictureManager pictureManager;

    protected AbstractCombiBAPApplication(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, new CombiLogger(iFrameworkAccess));
        this.pictureManager = this.createPictureManager(iFrameworkAccess);
        this.logChannel.log(1078071040, "*** Combi BAP HMI application has been started ***");
    }

    @Override
    public String getName() {
        return "Combi";
    }

    protected abstract IPictureManager createPictureManager(IFrameworkAccess iFrameworkAccess) {
    }

    public IPictureManager getPictureManager() {
        return this.pictureManager;
    }

    @Override
    protected void activate(AbstractActivator abstractActivator) {
        super.activate(abstractActivator);
        this.pictureManager.init(abstractActivator.getBundleContext());
    }

    @Override
    protected void dereferenceApplicationComponents() {
        super.dereferenceApplicationComponents();
        this.pictureManager.deinit();
        this.pictureManager = null;
    }

    public boolean isMOSTListSupported() {
        return this.frameworkAccess.getSysConstManager().getAdaptationANP().isFastMOSTListAvailable() || Boolean.getBoolean("MOSTListSupported");
    }
}

