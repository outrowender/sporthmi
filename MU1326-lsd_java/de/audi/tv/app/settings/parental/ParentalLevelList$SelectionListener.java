/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.settings.parental.ParentalLevelList;
import de.audi.tv.app.settings.parental.ParentalLevelList$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class ParentalLevelList$SelectionListener
extends DSICallListener {
    private final /* synthetic */ ParentalLevelList this$0;

    private ParentalLevelList$SelectionListener(ParentalLevelList parentalLevelList) {
        this.this$0 = parentalLevelList;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        ParentalLevelList.access$200(this.this$0).getChoiceModel(-1867766016).setValue(0);
    }

    @Override
    public void selectNextService(int n) {
        ParentalLevelList.access$200(this.this$0).getChoiceModel(-1867766016).setValue(0);
    }

    /* synthetic */ ParentalLevelList$SelectionListener(ParentalLevelList parentalLevelList, ParentalLevelList$1 parentalLevelList$1) {
        this(parentalLevelList);
    }
}

