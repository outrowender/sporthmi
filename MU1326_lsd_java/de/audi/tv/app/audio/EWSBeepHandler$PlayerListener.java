/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tv.app.audio.EWSBeepHandler;
import de.audi.tv.app.audio.EWSBeepHandler$1;

class EWSBeepHandler$PlayerListener
extends DefaultHMIAudioServiceListener
implements WavePlayerListener {
    private final /* synthetic */ EWSBeepHandler this$0;

    private EWSBeepHandler$PlayerListener(EWSBeepHandler eWSBeepHandler) {
        this.this$0 = eWSBeepHandler;
    }

    @Override
    public void fadedIn(int n, int n2) {
        if (n == 121) {
            EWSBeepHandler.access$200(this.this$0).playTone(0, 16);
            EWSBeepHandler.access$300(this.this$0).sendEmptyMessageDelayed(1, 0);
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        if (n == 121) {
            EWSBeepHandler.access$400(this.this$0).fadeToConnection(121);
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        if (n == 121) {
            EWSBeepHandler.access$500(this.this$0).log(-1601830656, "[EWSBeepHandler.errorConnection]");
        }
    }

    @Override
    public void state(int n) {
        if (n != 0) {
            EWSBeepHandler.access$400(this.this$0).releaseConnection(121);
            EWSBeepHandler.access$300(this.this$0).removeMessages(1);
        }
    }

    @Override
    public void playToneInfo(int n) {
    }

    /* synthetic */ EWSBeepHandler$PlayerListener(EWSBeepHandler eWSBeepHandler, EWSBeepHandler$1 eWSBeepHandler$1) {
        this(eWSBeepHandler);
    }
}

