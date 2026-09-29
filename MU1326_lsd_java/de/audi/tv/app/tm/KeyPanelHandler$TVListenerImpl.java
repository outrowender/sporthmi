/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.audi.tv.app.tm.KeyPanelHandler$1;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.tvtuner.StartUpConfig;

class KeyPanelHandler$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ KeyPanelHandler this$0;

    private KeyPanelHandler$TVListenerImpl(KeyPanelHandler keyPanelHandler) {
        this.this$0 = keyPanelHandler;
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        short[] sArray = startUpConfig.requiredKeypanelList;
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(5);
        SimpleIntObjectMap simpleIntObjectMap2 = new SimpleIntObjectMap(15);
        int n = -1;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            n = sArray[i2];
            i2 += 2;
            IntList intList = new IntList(4);
            IntList intList2 = new IntList(20);
            while (i2 < sArray.length && sArray[i2] != 255) {
                if (sArray[i2] > 0 && sArray[i2] < 5) {
                    intList.add(sArray[i2]);
                } else if (sArray[i2] != 15 && sArray[i2] != 12 && sArray[i2] != 16 && sArray[i2] != 17 && sArray[i2] != 13 && sArray[i2] != 18 && sArray[i2] != 19 && sArray[i2] != 14 && sArray[i2] != 40 && sArray[i2] != 41 && sArray[i2] != 42 && sArray[i2] != 43) {
                    intList2.add(sArray[i2]);
                }
                ++i2;
            }
            simpleIntObjectMap.add(n, intList.toArray());
            simpleIntObjectMap2.add(n, intList2.toArray());
        }
        KeyPanelHandler.access$400(this.this$0).getDataModel(-575920384).set(simpleIntObjectMap);
        KeyPanelHandler.access$400(this.this$0).getDataModel(-559143168).set(simpleIntObjectMap2);
    }

    @Override
    public void updateTMTVKeyPanel(short s, short s2) {
        if (s == -1) {
            return;
        }
        KeyPanelHandler.access$500(this.this$0).setValue(s);
        KeyPanelHandler.access$500(this.this$0).setStatus(1);
    }

    /* synthetic */ KeyPanelHandler$TVListenerImpl(KeyPanelHandler keyPanelHandler, KeyPanelHandler$1 keyPanelHandler$1) {
        this(keyPanelHandler);
    }
}

