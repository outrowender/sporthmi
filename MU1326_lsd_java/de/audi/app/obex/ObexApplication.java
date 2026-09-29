/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.obex.IEvoObexApplication;
import de.audi.app.obex.authentication.Authentication;
import de.audi.app.obex.core.AbstractObexApplication;
import de.audi.app.obex.opp.ObjectPush;
import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public class ObexApplication
extends AbstractObexApplication
implements IEvoObexApplication {
    private final IEvoConnectivity connectivity;

    public ObexApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity) {
        super(iFrameworkAccess, bundleContext, iEvoConnectivity);
        this.connectivity = iEvoConnectivity;
        this.addComponent(new Authentication(this));
        this.addComponent(new ObjectPush(this));
    }

    @Override
    public IEvoConnectivity getEvoConnectivity() {
        return this.connectivity;
    }
}

