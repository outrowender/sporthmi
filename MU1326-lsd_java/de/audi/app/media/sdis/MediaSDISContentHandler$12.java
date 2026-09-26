/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$12
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$command;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$12(MediaSDISContentHandler mediaSDISContentHandler, String string, int n) {
        this.this$0 = mediaSDISContentHandler;
        this.val$command = n;
        super(string);
    }

    @Override
    public void run() {
        int n;
        switch (this.val$command) {
            case 5: {
                n = 4;
                break;
            }
            case 7: {
                n = 7;
                break;
            }
            case 2: {
                n = 6;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 6: {
                n = 2;
                break;
            }
            case 3: {
                n = 5;
                break;
            }
            case 4: {
                n = 3;
                break;
            }
            default: {
                return;
            }
        }
        MediaSDISContentHandler.access$100(this.this$0).executeMenuCommand(n);
    }
}

