/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ContextManagerComponentEvo;
import de.audi.app.online.evo.NaviComponentEvo;
import de.audi.app.online.evo.RemoteHMIAnimationComponentEvo;
import de.audi.app.online.evo.remotehmi.browser.RemoteHMIBrowserComponentEvo;
import de.audi.app.online.evo.remotehmi.sds.HMISpeechASRListenerEvo;
import de.audi.app.online.evo.remotehmi.sds.HMISpeechTTSListenerEvo;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.NaviComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIAnimationComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIComponentFactory;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;

public class RemoteHMIComponentFactoryEvo
extends RemoteHMIComponentFactory {
    public ContextManagerComponent createContextManagerComponent() {
        return new ContextManagerComponentEvo();
    }

    public NaviComponent createNaviComponent() {
        return new NaviComponentEvo();
    }

    public HMISpeechASRListener createASRListener() {
        return new HMISpeechASRListenerEvo();
    }

    public HMISpeechTTSListener createTTSComponent() {
        return new HMISpeechTTSListenerEvo();
    }

    public RemoteHMIBrowserComponent createBrowserComponent() {
        return new RemoteHMIBrowserComponentEvo();
    }

    public RemoteHMIAnimationComponent createAnimationComponent() {
        return new RemoteHMIAnimationComponentEvo();
    }
}

