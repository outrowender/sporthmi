/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.HardKeyListener$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class HardKeyListener$TVListener
extends DefaultTVListener {
    private final /* synthetic */ HardKeyListener this$0;

    private HardKeyListener$TVListener(HardKeyListener hardKeyListener) {
        this.this$0 = hardKeyListener;
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        HardKeyListener.access$402(this.this$0, true);
        HardKeyListener.access$300(this.this$0).log(1078071040, "[HardKeyListener.TVListener.updateStartUpMUConfig] hard keys available:%1", HardKeyListener.access$400(this.this$0));
    }

    @Override
    public void updateSelectedSource(int n) {
        if (n == 1) {
            HardKeyListener.access$502(this.this$0, true);
        } else {
            HardKeyListener.access$502(this.this$0, false);
        }
    }

    /* synthetic */ HardKeyListener$TVListener(HardKeyListener hardKeyListener, HardKeyListener$1 hardKeyListener$1) {
        this(hardKeyListener);
    }
}

