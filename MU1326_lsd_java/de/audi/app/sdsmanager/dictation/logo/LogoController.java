/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.logo;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.logo.LogoController$DsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.OnlineLogoItem;

public final class LogoController
extends AbstractDictationComponent {
    private volatile OnlineLogoItem onlineLogoItem;

    public LogoController(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.onlineLogoItem = this.createOnlineLogoItem();
        dictationComponentManager.getDsiDictationAdapter().addListener(new LogoController$DsiDictationAdapterListener(this, null));
    }

    private OnlineLogoItem createOnlineLogoItem() {
        return new OnlineLogoItem(this.log, this.framework.getHmiServiceApp().getLabelModel(3879), "/var/hmi/AppSDSManager/provider_logo.png", "/eso/hmi/lsd/images/AppSDSManager/default_provider_logo.png", this.framework);
    }

    static /* synthetic */ LogChannel access$100(LogoController logoController) {
        return logoController.log;
    }

    static /* synthetic */ OnlineLogoItem access$200(LogoController logoController) {
        return logoController.onlineLogoItem;
    }
}

