/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerBandImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$ISpellerBandAsia;
import java.util.List;

public class SpellerControllerAsia$SpellerBandImplAsia
extends SpellerController$SpellerBandImpl
implements SpellerControllerAsia$ISpellerBandAsia {
    private int spellerBandInternalLanguage;
    private final /* synthetic */ SpellerControllerAsia this$0;

    public SpellerControllerAsia$SpellerBandImplAsia(SpellerControllerAsia spellerControllerAsia, List list, boolean bl) {
        this.this$0 = spellerControllerAsia;
        super(spellerControllerAsia, list, bl);
    }

    protected SpellerControllerAsia$SpellerBandImplAsia(SpellerControllerAsia spellerControllerAsia, List list, boolean bl, boolean bl2, boolean bl3) {
        this.this$0 = spellerControllerAsia;
        super(spellerControllerAsia, list, bl, bl2, bl3);
    }

    public int getSpellerBandInternalLanguage() {
        return this.spellerBandInternalLanguage;
    }

    public void setSpellerBandInternalLanguage(int n) {
        this.spellerBandInternalLanguage = n;
    }

    @Override
    public void itemPressed(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (SpellerControllerAsia.access$000(this.this$0) == null || this.deletePosItem == SpellerControllerAsia.access$100(this.this$0)) {
            return;
        }
        if (SpellerControllerAsia.access$200(this.this$0) instanceof SpellerController$SingleCharItem) {
            SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)SpellerControllerAsia.access$300(this.this$0);
            if (spellerController$SingleCharItem.getParent() instanceof SpellerController$AbstractExpandableItem$Char) {
                this.moveDeleteButton(SpellerControllerAsia.access$400(this.this$0), true);
            } else {
                super.itemPressed(spellerController$ISpellerItem);
            }
        } else {
            super.itemPressed(spellerController$ISpellerItem);
        }
    }

    @Override
    public void adjustDeleteButton(SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl) {
        super.moveDeleteButton(spellerController$ISpellerItem, bl);
    }
}

