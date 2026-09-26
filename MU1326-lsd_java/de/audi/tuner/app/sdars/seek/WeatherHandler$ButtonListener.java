/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.WeatherHandler;
import de.audi.tuner.app.sdars.seek.WeatherHandler$1;

class WeatherHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ WeatherHandler this$0;

    private WeatherHandler$ButtonListener(WeatherHandler weatherHandler) {
        this.this$0 = weatherHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        WeatherHandler.access$300(this.this$0);
    }

    /* synthetic */ WeatherHandler$ButtonListener(WeatherHandler weatherHandler, WeatherHandler$1 weatherHandler$1) {
        this(weatherHandler);
    }
}

