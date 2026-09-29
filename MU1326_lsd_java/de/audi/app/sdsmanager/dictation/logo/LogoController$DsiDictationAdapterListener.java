/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.logo;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.logo.LogoController;
import de.audi.app.sdsmanager.dictation.logo.LogoController$1;

class LogoController$DsiDictationAdapterListener
extends DsiDictationAdapterEmptyListener {
    private final /* synthetic */ LogoController this$0;

    private LogoController$DsiDictationAdapterListener(LogoController logoController) {
        this.this$0 = logoController;
    }

    @Override
    public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        LogoController.access$100(this.this$0).log(1078071040, "[LogoController#updateServiceProviderInfo] serviceProviderInfo = %1", (Object)serviceProviderInfo);
        if (serviceProviderInfo.isValid()) {
            LogoController.access$200(this.this$0).update(serviceProviderInfo.getImageVoiceUrl(), serviceProviderInfo.getImageVoiceCheckSum());
        }
    }

    /* synthetic */ LogoController$DsiDictationAdapterListener(LogoController logoController, LogoController$1 logoController$1) {
        this(logoController);
    }
}

