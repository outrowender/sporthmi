/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.tv.app.settings.DisplaySettings;
import de.audi.tv.app.settings.DisplaySettings$1;

class DisplaySettings$RangeListener
extends DefaultRangeListener {
    private final /* synthetic */ DisplaySettings this$0;

    private DisplaySettings$RangeListener(DisplaySettings displaySettings) {
        this.this$0 = displaySettings;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2600094: {
                DisplaySettings.access$100(this.this$0).fireEvent(n3);
                break;
            }
            case 2600095: {
                DisplaySettings.access$200(this.this$0).fireEvent(n3);
                break;
            }
            case 2600096: {
                DisplaySettings.access$300(this.this$0).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        switch (n) {
            case 2600094: {
                int n4 = DisplaySettings.access$500(this.this$0, DisplaySettings.access$400(this.this$0) - n2);
                if (n4 < DisplaySettings.access$600(this.this$0)) break;
                DisplaySettings.access$402(this.this$0, n4);
                DisplaySettings.access$700(this.this$0, DisplaySettings.access$400(this.this$0));
                DisplaySettings.access$100(this.this$0).setValue(DisplaySettings.access$400(this.this$0));
                break;
            }
            case 2600095: {
                int n5 = DisplaySettings.access$500(this.this$0, DisplaySettings.access$800(this.this$0) - n2);
                if (n5 < DisplaySettings.access$600(this.this$0)) break;
                DisplaySettings.access$802(this.this$0, n5);
                DisplaySettings.access$900(this.this$0, DisplaySettings.access$800(this.this$0));
                DisplaySettings.access$200(this.this$0).setValue(DisplaySettings.access$800(this.this$0));
                break;
            }
            case 2600096: {
                int n6 = DisplaySettings.access$500(this.this$0, DisplaySettings.access$1000(this.this$0) - n2);
                if (n6 < DisplaySettings.access$600(this.this$0)) break;
                DisplaySettings.access$1002(this.this$0, n6);
                DisplaySettings.access$1100(this.this$0, DisplaySettings.access$1000(this.this$0));
                DisplaySettings.access$300(this.this$0).setValue(DisplaySettings.access$1000(this.this$0));
                break;
            }
        }
        DisplaySettings.access$1200(this.this$0);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        switch (n) {
            case 2600094: {
                DisplaySettings.access$402(this.this$0, DisplaySettings.access$500(this.this$0, DisplaySettings.access$400(this.this$0) + n2));
                DisplaySettings.access$700(this.this$0, DisplaySettings.access$400(this.this$0));
                DisplaySettings.access$100(this.this$0).setValue(DisplaySettings.access$400(this.this$0));
                break;
            }
            case 2600095: {
                DisplaySettings.access$802(this.this$0, DisplaySettings.access$500(this.this$0, DisplaySettings.access$800(this.this$0) + n2));
                DisplaySettings.access$900(this.this$0, DisplaySettings.access$800(this.this$0));
                DisplaySettings.access$200(this.this$0).setValue(DisplaySettings.access$800(this.this$0));
                break;
            }
            case 2600096: {
                DisplaySettings.access$1002(this.this$0, DisplaySettings.access$500(this.this$0, DisplaySettings.access$1000(this.this$0) + n2));
                DisplaySettings.access$1100(this.this$0, DisplaySettings.access$1000(this.this$0));
                DisplaySettings.access$300(this.this$0).setValue(DisplaySettings.access$1000(this.this$0));
                break;
            }
        }
        DisplaySettings.access$1200(this.this$0);
    }

    /* synthetic */ DisplaySettings$RangeListener(DisplaySettings displaySettings, DisplaySettings$1 displaySettings$1) {
        this(displaySettings);
    }
}

