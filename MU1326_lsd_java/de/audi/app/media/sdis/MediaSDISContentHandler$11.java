/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;
import de.esolutions.fw.util.commons.Buffer;

class MediaSDISContentHandler$11
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pScreenX;
    private final /* synthetic */ int val$pScreenY;
    private final /* synthetic */ int val$pX;
    private final /* synthetic */ int val$pY;
    private final /* synthetic */ boolean val$pSelectAndActivate;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$11(MediaSDISContentHandler mediaSDISContentHandler, String string, int n, int n2, int n3, int n4, boolean bl) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pScreenX = n;
        this.val$pScreenY = n2;
        this.val$pX = n3;
        this.val$pY = n4;
        this.val$pSelectAndActivate = bl;
        super(string);
    }

    @Override
    public void run() {
        float f2;
        float f3;
        int n;
        int n2;
        switch (MediaSDISContentHandler.access$200(this.this$0).getFramework().getScreenRes()) {
            case 2: {
                n2 = 1024;
                n = 480;
                break;
            }
            case 4: {
                n2 = 1440;
                n = 540;
                break;
            }
            default: {
                n2 = 800;
                n = 480;
            }
        }
        float f4 = (float)this.val$pScreenX / (float)this.val$pScreenY;
        if (MediaSDISContentHandler.access$300(this.this$0) != 5) {
            int n3 = MediaSDISContentHandler.access$200(this.this$0).getMediaPersistence().getStorage().load(MediaSDISContentHandler.access$200(this.this$0), 170, 0, 0, 5);
            switch (n3) {
                case 4: {
                    f4 = 1717966400;
                    break;
                }
                case 3: {
                    f4 = 1914488639;
                    break;
                }
                case 2: {
                    f4 = 965665599;
                    break;
                }
                case 1: {
                    f4 = -1414878657;
                    break;
                }
            }
        }
        if ((f3 = (float)n2) / f4 > (f2 = (float)n)) {
            f3 = f2 * f4;
        } else {
            f2 = f3 / f4;
        }
        int n4 = (int)(((float)n2 - f3) / 2.0f);
        int n5 = (int)(((float)n - f2) / 2.0f);
        float f5 = (float)this.val$pX / (float)this.val$pScreenX;
        float f6 = (float)this.val$pY / (float)this.val$pScreenY;
        int n6 = Math.round(f5 * f3) + n4;
        int n7 = Math.round(f6 * f2) + n5;
        if (MediaSDISContentHandler.access$000(this.this$0).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(this.val$pSelectAndActivate ? "CLICK_ACTIVE" : "CLICK").append(",rX='").append(this.val$pX).append("',rY='").append(this.val$pY).append("',rResX='").append(this.val$pScreenX).append("',rResY='").append(this.val$pScreenY).append("',resX='").append(n2).append("',resY='").append(n).append("',x='").append(n6).append("',y='").append(n7).append("'");
            MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.ontouchEvent] %2", (Object)"MediaSDISContentHandler", (Object)buffer);
        }
        MediaSDISContentHandler.access$100(this.this$0).touchEvent(this.val$pSelectAndActivate ? 1 : 0, n6, n7);
    }
}

