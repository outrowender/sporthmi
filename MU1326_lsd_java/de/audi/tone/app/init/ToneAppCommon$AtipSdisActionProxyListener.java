/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.init;

import de.audi.atip.interapp.audio.AtipAudioSdisService;
import de.audi.atip.interapp.def.NullAtipAudioSdisService;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.init.ToneAppCommon;

class ToneAppCommon$AtipSdisActionProxyListener
extends ActionProxyListener {
    private AtipAudioSdisService service;
    private final /* synthetic */ ToneAppCommon this$0;

    ToneAppCommon$AtipSdisActionProxyListener(ToneAppCommon toneAppCommon, int n) {
        this.this$0 = toneAppCommon;
        super(n);
        this.service = new NullAtipAudioSdisService(toneAppCommon.env.lcHMI);
    }

    @Override
    public void a2lsPopupMediaTunerAreaEntered() {
        this.service.mediaTunerAreaEntered();
    }

    @Override
    public void a2lsPopupMediaTunerAreaLeft() {
        this.service.mediaTunerAreaLeft();
    }

    public void registerService(Object object) {
        if (object != null) {
            this.service = (AtipAudioSdisService)object;
        }
    }

    public void deregisterService(Object object) {
        this.service = new NullAtipAudioSdisService(this.this$0.env.lcHMI);
    }
}

