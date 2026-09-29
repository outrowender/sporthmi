/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.tr;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.tr.TrafficSignQueue;
import de.audi.tghu.navi.app.tr.TrafficSignRunner;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficSignService {
    private LogChannel logChannel;
    private TrafficSignQueue queue;
    private TrafficSignRunner runner;

    public TrafficSignService(NavigationEnv navigationEnv, IconHandler iconHandler, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ResourceLocatorModelApp resourceLocatorModelApp, ResourceLocatorModelApp resourceLocatorModelApp2) {
        this.logChannel = navigationEnv.getTRLogChannel();
        this.queue = new TrafficSignQueue(this.logChannel);
        this.runner = new TrafficSignRunner(this.logChannel, iconHandler, this.queue, choiceModelApp, choiceModelApp2, resourceLocatorModelApp, resourceLocatorModelApp2);
        navigationEnv.getFramework().getHMIThreadPool().execute(this.runner);
    }

    public void stop() {
        this.logChannel.log(-2137614336, "TrafficSignService#stop()");
        this.runner.stop();
    }

    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation) {
        this.logChannel.log(-2137614336, "TrafficSignService#updateCurrentTrafficSign( %1 )", (Object)trafficSignInformation);
        this.queue.postTrafficSign(trafficSignInformation);
    }
}

