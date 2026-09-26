/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.app.messaging.core.readout.MessageReader$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class MessageReader$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MessageReader this$0;

    private MessageReader$MyButtonListener(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        String string;
        switch (n) {
            case 2200322: {
                string = "readoutStartButton";
                break;
            }
            case 2200323: {
                string = "readoutStopButton";
                break;
            }
            case 2200318: {
                string = "readoutPauseButton";
                break;
            }
            case 2200319: {
                string = "readoutResumeButton";
                break;
            }
            case 2200321: {
                string = "readoutSkipForwardButton";
                break;
            }
            case 2200320: {
                string = "readoutSkipBackwarButton";
                break;
            }
            default: {
                string = "unknown";
            }
        }
        MessageReader.access$4400(this.this$0).log(1078071040, "[MessageReader#keyTyped] model = %1", (Object)string);
        if (MessageReader.access$4500(this.this$0)) {
            MessageReader.access$4502(this.this$0, false);
            return;
        }
        if (n == 43196672) {
            this.this$0.start();
        } else if (n == 59973888) {
            this.this$0.stop();
        } else if (n == -23977728) {
            this.this$0.pause();
        } else if (n == -7200512) {
            this.this$0.resume();
        } else if (n == 26419456) {
            this.this$0.skipForward();
        } else if (n == 9642240) {
            this.this$0.skipBackward();
        } else {
            MessageReader.access$4600(this.this$0).log(10000, "[MessageReader#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        MessageReader.access$4700(this.this$0).log(1078071040, "[MessageReader#keyLongTyped] model = %1", (long)n);
        if (n == 43196672 || n == 59973888 || n == -23977728 || n == -7200512) {
            this.this$0.stop();
            MessageReader.access$3602(this.this$0, true);
            MessageReader.access$4502(this.this$0, true);
        }
    }

    /* synthetic */ MessageReader$MyButtonListener(MessageReader messageReader, MessageReader$1 messageReader$1) {
        this(messageReader);
    }
}

