/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.statemachine.ap.EngineeringActionProxy;
import de.audi.tghu.redengineering.app.AudioManagementHandler;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import org.osgi.framework.BundleContext;

public class EngineeringAppEvo
extends EngineeringApp
implements EngineeringActionProxy {
    protected EngineeringAppEvo(BundleContext bundleContext, EngineeringEnv engineeringEnv, AudioManagementHandler audioManagementHandler) {
        super(bundleContext, engineeringEnv, audioManagementHandler);
    }

    public void EngineeringTestProxy(int n) {
    }

    public void startSystemUpTimer(int n) {
        super.startUpTimeTimer();
    }

    public void stopSystemUpTimer(int n) {
        super.stopUpTimeTimer();
    }

    public void enterREM(int n) {
        super.enterREM(n);
    }

    public void leaveREM(int n) {
        super.leaveREM(n);
    }
}

