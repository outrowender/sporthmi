/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.CarCodingComponent;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.InitializationComponent;
import de.audi.tghu.online.app.remotehmi.NaviComponent;
import de.audi.tghu.online.app.remotehmi.PhoneComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIAnimationComponent;
import de.audi.tghu.online.app.remotehmi.UpdatingIconComponent;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiComponent;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;

public class RemoteHMIComponentFactory {
    public ContextManagerComponent createContextManagerComponent() {
        return new ContextManagerComponent();
    }

    public NaviComponent createNaviComponent() {
        return new NaviComponent();
    }

    public PhoneComponent createPhoneComponent() {
        return new PhoneComponent();
    }

    public RemoteHMIBrowserComponent createBrowserComponent() {
        return new RemoteHMIBrowserComponent();
    }

    public HMISpeechASRListener createASRListener() {
        return new HMISpeechASRListener();
    }

    public HMISpeechTTSListener createTTSComponent() {
        return new HMISpeechTTSListener();
    }

    public RemoteHMIAnimationComponent createAnimationComponent() {
        return new RemoteHMIAnimationComponent();
    }

    public InitializationComponent createInitializationComponent() {
        return new InitializationComponent();
    }

    public RemoteHMIEfiComponent createEfiComponent() {
        return new RemoteHMIEfiComponent();
    }

    public OnlineMediaComponent createOnlineMediaComponent() {
        return new OnlineMediaComponent();
    }

    public UpdatingIconComponent createUpdatingIconComponent() {
        return new UpdatingIconComponent();
    }

    public CarCodingComponent createCarCodingComponent() {
        return new CarCodingComponent();
    }

    public DiagnosisComponent createDiagnosisComponent() {
        return new DiagnosisComponent();
    }
}

