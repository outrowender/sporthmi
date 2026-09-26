/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.VirtualButtonAdapter;

class AbstractHMIViewListener$1
extends VirtualButtonAdapter {
    private final /* synthetic */ AbstractHMIViewListener this$0;

    AbstractHMIViewListener$1(AbstractHMIViewListener abstractHMIViewListener) {
        this.this$0 = abstractHMIViewListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (n == -954719488) {
            this.this$0.keyPressedVirtualButton(n, n2, n3);
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (n == -954719488) {
            this.this$0.keyPressedVirtualButton(n, 10403, n3);
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (n == -954719488) {
            this.this$0.keyPressedVirtualButton(n, 10403, n3);
        }
    }
}

