/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import java.util.StringTokenizer;

class HMITerminalImplMIB2High$11
implements Runnable {
    private final /* synthetic */ HMITerminalImplMIB2High this$0;

    HMITerminalImplMIB2High$11(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        this.this$0 = hMITerminalImplMIB2High;
    }

    @Override
    public void run() {
        String string = System.getProperty("initialKZBs", "");
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        while (stringTokenizer.hasMoreTokens()) {
            try {
                int n = Integer.parseInt(stringTokenizer.nextToken().trim());
                if (n == -1 || n == 17) continue;
                HMITerminalImplMIB2High.access$000(this.this$0).mergeKzb(n);
            }
            catch (NumberFormatException numberFormatException) {
                IWidgetLogChannel.logChannel3DEngine.log(10000, "HMITerminalImplMIB2#constructor wrong parameter for VMOption initialKZBs='%1'", (Object)string);
            }
        }
    }

    public String toString() {
        return "ealManager.loadInitialKzb";
    }
}

