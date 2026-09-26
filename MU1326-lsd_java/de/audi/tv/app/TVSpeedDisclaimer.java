/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.TVSpeedDisclaimer$1;
import de.audi.tv.app.TVSpeedDisclaimer$Properties;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.util.generics.Triple;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVSpeedDisclaimer {
    public static final int TESTMODE_VIDEO_USE_CLAMP_15;
    private final TVSpeedDisclaimer$Properties myProperties;
    private final TVEnv env;

    public TVSpeedDisclaimer(TVEnv tVEnv) {
        this.env = tVEnv;
        this.myProperties = tVEnv.properties.speedDisclaimer;
        int n = tVEnv.framework.getSysApp().getAdaptationANP().getTestmodeVideoSpeedCutoffLimit();
        this.env.lcMain.log(1078071040, "[TVSpeedDisclaimer] testmodeVideo %1", (long)n);
        ReadOnlyProperty readOnlyProperty = tVEnv.properties.eventDispatcher.vehicleMoving;
        if (n == 254) {
            readOnlyProperty = tVEnv.properties.eventDispatcher.clamp15Activated;
        }
        readOnlyProperty.combineWith(tVEnv.properties.dsiProperties.selectAndSelectedService).combineWith(tVEnv.properties.source.currentSource).using(Triple.combine()).async(tVEnv.dispatch).subscribe((Consumer)new TVSpeedDisclaimer$1(this));
    }

    private void update(boolean bl, ServiceInfo serviceInfo, int n) {
        this.env.lcMain.log(1078071040, "[TVSpeedDisclaimer.update] shouldShow:%1 sType:%2 source:%3", (Object)bl, (Object)new Integer(serviceInfo.sType), (long)n);
        boolean bl2 = false;
        if (bl) {
            if (n == 1) {
                bl2 = true;
            } else if (n == 0) {
                bl2 = TVSpeedDisclaimer.doesServiceNeedSpeedDisclaimer(serviceInfo);
            }
        }
        int n2 = bl ? 1 : 0;
        int n3 = bl2 ? 1 : 0;
        this.env.getChoiceModel(1353459456).setValue(n3);
        this.env.getChoiceModel(1470899968).setValue(n3);
        this.env.properties.terminalMode.desiredScreenMode.accept(new Integer(n2));
        TVSpeedDisclaimer$Properties.access$100(this.myProperties).accept(new Boolean(bl2));
    }

    public static boolean doesServiceNeedSpeedDisclaimer(ServiceInfo serviceInfo) {
        switch (serviceInfo.sType) {
            case 3: 
            case 4: 
            case 6: 
            case 10: {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void access$000(TVSpeedDisclaimer tVSpeedDisclaimer, boolean bl, ServiceInfo serviceInfo, int n) {
        tVSpeedDisclaimer.update(bl, serviceInfo, n);
    }
}

