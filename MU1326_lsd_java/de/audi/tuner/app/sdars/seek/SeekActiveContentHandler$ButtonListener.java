/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;

class SeekActiveContentHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$ButtonListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        boolean bl;
        int n4;
        String string;
        int n5;
        SeekActiveContentHandler.access$700(this.this$0).hidePartialPopup(12);
        switch (n) {
            case 100646: {
                n5 = 2;
                string = SeekActiveContentHandler.access$800(this.this$0).getLabelModel(-41484032).getText();
                n4 = 13;
                bl = SeekActiveContentHandler.access$900(this.this$0).isSeekListFull(1);
                break;
            }
            case 100647: {
                n5 = 1;
                string = SeekActiveContentHandler.access$800(this.this$0).getLabelModel(-7929600).getText();
                n4 = 14;
                bl = SeekActiveContentHandler.access$900(this.this$0).isSeekListFull(1);
                break;
            }
            case 100645: {
                n5 = 4;
                string = SeekActiveContentHandler.access$800(this.this$0).getLabelModel(1619460352).getText();
                n4 = 15;
                bl = SeekActiveContentHandler.access$900(this.this$0).isSeekListFull(3);
                break;
            }
            case 100648: {
                n5 = 5;
                string = SeekActiveContentHandler.access$800(this.this$0).getLabelModel(1653014784).getText();
                n4 = 15;
                bl = SeekActiveContentHandler.access$900(this.this$0).isSeekListFull(3);
                break;
            }
            default: {
                n5 = 0;
                string = "";
                n4 = -1;
                bl = false;
                SeekActiveContentHandler.access$1000(this.this$0).log(10000, "[SeekActiveContentHandler.ButtonListener.keyTyped] wrong seekContentType!");
            }
        }
        if (bl) {
            BaseListModelApp baseListModelApp;
            switch (n) {
                case 100646: 
                case 100647: {
                    baseListModelApp = SeekActiveContentHandler.access$800(this.this$0).getBaseListModel(-2088238848);
                    break;
                }
                case 100645: 
                case 100648: {
                    baseListModelApp = SeekActiveContentHandler.access$800(this.this$0).getBaseListModel(-2121793280);
                    break;
                }
                default: {
                    baseListModelApp = null;
                }
            }
            if (baseListModelApp != null) {
                BaseListModelApp baseListModelApp2 = SeekActiveContentHandler.access$800(this.this$0).getBaseListModel(-1903623936);
                baseListModelApp2.removeAll();
                for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                    baseListModelApp2.append(baseListModelApp.getRow(i2));
                }
                SeekActiveContentHandler.access$1102(this.this$0, true);
                SeekActiveContentHandler.access$1202(this.this$0, n4);
                SeekActiveContentHandler.access$1400(this.this$0).setSeekCommand(SeekActiveContentHandler.access$1300((SeekActiveContentHandler)this.this$0).sID, n5, 1);
                SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(17);
            }
        } else {
            SeekActiveContentHandler.access$1000(this.this$0).log(-2137614336, "[DSISDARSSeek.setSeekCommand] sId %1, seekType %2", (long)SeekActiveContentHandler.access$1300((SeekActiveContentHandler)this.this$0).sID, (long)n5);
            SeekActiveContentHandler.access$1400(this.this$0).setSeekCommand(SeekActiveContentHandler.access$1300((SeekActiveContentHandler)this.this$0).sID, n5, 1);
            SeekActiveContentHandler.access$800(this.this$0).getLabelModel(1049166080).setText(string);
            SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(n4);
        }
    }

    /* synthetic */ SeekActiveContentHandler$ButtonListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

