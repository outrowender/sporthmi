/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.logo;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.atip.onlinelogo.OnlineLogoItem;

public final class LogoController
extends AbstractDictationComponent {
    private volatile OnlineLogoItem onlineLogoItem;

    public LogoController(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.onlineLogoItem = this.createOnlineLogoItem();
        dictationComponentManager.getDsiDictationAdapter().addListener(new DsiDictationAdapterListener());
    }

    private OnlineLogoItem createOnlineLogoItem() {
        return new OnlineLogoItem(this.log, this.framework.getHmiServiceApp().getLabelModel(3879), "/var/hmi/AppSDSManager/provider_logo.png", "/eso/hmi/lsd/images/AppSDSManager/default_provider_logo.png", this.framework);
    }

    private class DsiDictationAdapterListener
    extends DsiDictationAdapterEmptyListener {
        private DsiDictationAdapterListener() {
        }

        public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
            LogoController.this.log.log(1000000, "[LogoController#updateServiceProviderInfo] serviceProviderInfo = %1", (Object)serviceProviderInfo);
            if (serviceProviderInfo.isValid()) {
                LogoController.this.onlineLogoItem.update(serviceProviderInfo.getImageVoiceUrl(), serviceProviderInfo.getImageVoiceCheckSum());
            }
        }
    }
}

