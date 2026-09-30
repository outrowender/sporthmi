/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IAnimationController;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2Std;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2Std;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2StdPlus;
import org.osgi.framework.BundleContext;

public class HMITerminalImplMIB2Std
extends HMITerminalImplMIB2High {
    public HMITerminalImplMIB2Std(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        super(n, bundleContext, iFrameworkAccess);
    }

    protected Layout generateLayout() {
        WidgetConstants widgetConstants;
        switch (this.framework.getScreenRes()) {
            case 1: {
                widgetConstants = new LayoutMIB2StdPlus();
                break;
            }
            case 0: {
                widgetConstants = new LayoutMIB2Std();
                break;
            }
            default: {
                widgetConstants = new LayoutMIB2StdPlus();
            }
        }
        return widgetConstants;
    }

    protected IAnimationController generateAnimationController() {
        return new AnimationControllerMIB2Std(109);
    }
}

