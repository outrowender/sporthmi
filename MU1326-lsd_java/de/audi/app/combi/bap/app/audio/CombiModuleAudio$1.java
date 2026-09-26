/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class CombiModuleAudio$1
implements TimerListener {
    private final /* synthetic */ CombiModuleAudio this$0;

    CombiModuleAudio$1(CombiModuleAudio combiModuleAudio) {
        this.this$0 = combiModuleAudio;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(CombiModuleAudio.access$000(this.this$0))) {
            CombiModuleAudio.access$200(this.this$0).log(-2137614336, "[CombiModuleAudio.CombiModuleAudio(...).new TimerListener() {...}#fireTimer] restore old SDS state=%1", (long)CombiModuleAudio.access$100(this.this$0));
            CombiModuleAudio.access$300(this.this$0).updateSDSState(CombiModuleAudio.access$100(this.this$0));
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

