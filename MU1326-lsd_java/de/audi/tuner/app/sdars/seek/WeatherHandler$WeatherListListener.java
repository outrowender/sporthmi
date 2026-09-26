/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.WeatherHandler;
import de.audi.tuner.app.sdars.seek.WeatherHandler$1;
import de.audi.tuner.app.sdars.seek.WeatherRow;

class WeatherHandler$WeatherListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ WeatherHandler this$0;

    private WeatherHandler$WeatherListListener(WeatherHandler weatherHandler) {
        this.this$0 = weatherHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        WeatherRow weatherRow = (WeatherRow)evoListRow;
        boolean bl = weatherRow.isActivationCheckboxSelected();
        int n5 = !bl ? 1 : 3;
        boolean bl2 = WeatherHandler.access$600(this.this$0).isSeekListFull(4);
        if (bl2 && n5 == 1) {
            WeatherHandler.access$700(this.this$0).showPartialPopup(16);
        } else {
            int n6 = n5 == 1 ? 1 : -1;
            WeatherHandler.access$800(this.this$0, n6);
            this.this$0.dsiInterface.manageSeek2(4, weatherRow.getSeekId(), 0, n5);
        }
    }

    /* synthetic */ WeatherHandler$WeatherListListener(WeatherHandler weatherHandler, WeatherHandler$1 weatherHandler$1) {
        this(weatherHandler);
    }
}

