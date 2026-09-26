/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;

class OnlineMediaComponent$11
implements Runnable {
    private final /* synthetic */ OnlineMediaComponent this$0;

    OnlineMediaComponent$11(OnlineMediaComponent onlineMediaComponent) {
        this.this$0 = onlineMediaComponent;
    }

    @Override
    public void run() {
        System.out.println("Simulation: starting...");
        while (this.this$0.counter < 100) {
            System.out.println(new StringBuffer().append("Simulation: counter: ").append(this.this$0.counter).toString());
            this.this$0.updatePlayPosition(this.this$0.counter++, 100);
            try {
                Thread.sleep(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

