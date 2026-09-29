/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.GUIHandlerAMFM$1;

class GUIHandlerAMFM$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ GUIHandlerAMFM this$0;

    private GUIHandlerAMFM$ChoiceListener(GUIHandlerAMFM gUIHandlerAMFM) {
        this.this$0 = gUIHandlerAMFM;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        GUIHandlerAMFM.access$500((GUIHandlerAMFM)this.this$0).hmi.log(14808325, "[GUIHandlerAMFM.itemSelected] model:%1 index:%2", (long)n, (long)n2);
        switch (n) {
            case 100397: {
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(763887872).setValue(n2);
                GUIHandlerAMFM.access$700(this.this$0).setSortAlgo(n2);
                GUIHandlerAMFM.access$800(this.this$0).valueUpdated(n2, 7);
                break;
            }
            case 100524: {
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-1400372992).setValue(n2);
                GUIHandlerAMFM.access$900(this.this$0).setSortAlgo(n2);
                GUIHandlerAMFM.access$800(this.this$0).valueUpdated(n2, 0);
                break;
            }
            case 100398: {
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(780665088).setValue(n2);
                GUIHandlerAMFM.access$1000(this.this$0).switchAF(n2 == 1);
                if (!Utilities.isAfAutoResetActivated()) break;
                GUIHandlerAMFM.access$302(this.this$0, (int)GUIHandlerAMFM.access$1000((GUIHandlerAMFM)this.this$0).getActiveStationFM().frequency);
                break;
            }
            case 100399: {
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(797442304).setValue(n2);
                GUIHandlerAMFM.access$1000(this.this$0).switchReg(n2 == 1);
                break;
            }
            case 100574: {
                boolean bl = n2 == 1;
                boolean bl2 = GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-544734976).getValue() == 1;
                GUIHandlerAMFM.access$1000(this.this$0).switchHD(bl, bl2);
                break;
            }
            case 100575: {
                boolean bl = GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-561512192).getValue() == 1;
                boolean bl3 = n2 == 1;
                GUIHandlerAMFM.access$1000(this.this$0).switchHD(bl, bl3);
                break;
            }
            case 100396: {
                this.this$0.switchNamesOnOff(n2);
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(747110656).setValue(n2);
                GUIHandlerAMFM.access$800(this.this$0).valueUpdated(n2, 6);
                break;
            }
            case 100395: {
                GUIHandlerAMFM.access$1000(this.this$0).getStationNameHistory().setStationDisplayModeFixed(n2 == 1);
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(730333440).setValue(n2);
                GUIHandlerAMFM.access$800(this.this$0).valueUpdated(n2, 5);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        GUIHandlerAMFM.access$500((GUIHandlerAMFM)this.this$0).amfmGUI.log(14808325, "[GUIHAMFM.keyTyped] %1", (long)n);
        switch (n) {
            case 100489: {
                GUIHandlerAMFM.access$1000(this.this$0).forceStationListUpdate(true);
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(n).setValue(1);
                GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(n).fireEvent(n3);
                break;
            }
            case 100603: {
                GUIHandlerAMFM.access$1000(this.this$0).nextSubChannel(n3);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        GUIHandlerAMFM.access$500((GUIHandlerAMFM)this.this$0).amfmGUI.log(14808325, "[GUIHAMFM.keyReleased] %1", (long)n);
        switch (n) {
            case 100127: {
                GUIHandlerAMFM.access$1000(this.this$0).seekStation(1, n3);
                break;
            }
            case 100145: {
                GUIHandlerAMFM.access$1000(this.this$0).seekStation(2, n3);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        GUIHandlerAMFM.access$500((GUIHandlerAMFM)this.this$0).amfmGUI.log(14808325, "[GUIHAMFM.keyLongTyped] %1", (long)n);
        switch (n) {
            case 100127: {
                GUIHandlerAMFM.access$1000(this.this$0).seekStation(5, n3);
                break;
            }
            case 100145: {
                GUIHandlerAMFM.access$1000(this.this$0).seekStation(6, n3);
                break;
            }
        }
    }

    /* synthetic */ GUIHandlerAMFM$ChoiceListener(GUIHandlerAMFM gUIHandlerAMFM, GUIHandlerAMFM$1 gUIHandlerAMFM$1) {
        this(gUIHandlerAMFM);
    }
}

