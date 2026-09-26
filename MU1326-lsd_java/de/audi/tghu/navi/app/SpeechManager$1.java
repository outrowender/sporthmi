/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.command.NavCommand;

class SpeechManager$1
extends NavCommand {
    private final /* synthetic */ int val$guidanceMode;
    private final /* synthetic */ SpeechManager this$0;

    SpeechManager$1(SpeechManager speechManager, String string, int n) {
        this.this$0 = speechManager;
        this.val$guidanceMode = n;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SpeechManager#notifyListener( %1 )", (long)this.val$guidanceMode);
        if (SpeechManager.access$000(this.this$0) != null) {
            SpeechManager.access$000(this.this$0).updateGuidanceMode(this.val$guidanceMode);
        }
        if (SpeechManager.access$100(this.this$0).size() != 0) {
            int n = 20;
            switch (this.val$guidanceMode) {
                case 1: {
                    n = 20;
                    break;
                }
                case 0: {
                    n = 21;
                    break;
                }
                case 2: {
                    n = 22;
                    break;
                }
                case 3: {
                    n = 23;
                    break;
                }
                default: {
                    n = 20;
                }
            }
            for (int i2 = 0; i2 < SpeechManager.access$100(this.this$0).size(); ++i2) {
                IAnnouncementStateListener iAnnouncementStateListener = (IAnnouncementStateListener)SpeechManager.access$100(this.this$0).get(i2);
                iAnnouncementStateListener.updateAnnouncementState(n, 1);
            }
        }
        this.getCommandList().commandFinished();
    }
}

