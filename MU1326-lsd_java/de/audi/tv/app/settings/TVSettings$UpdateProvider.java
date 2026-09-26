/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.TVSettings$1;
import java.util.List;

class TVSettings$UpdateProvider
implements ISettingListener {
    boolean visualAudioUpdate;
    boolean ewsUpdate;
    int stationListSorting = -1;
    private final /* synthetic */ TVSettings this$0;

    private TVSettings$UpdateProvider(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateVisualAudio(boolean bl) {
        List list = TVSettings.access$1500(this.this$0);
        synchronized (list) {
            this.visualAudioUpdate = bl;
            for (int i2 = 0; i2 < TVSettings.access$1500(this.this$0).size(); ++i2) {
                ((ISettingListener)TVSettings.access$1500(this.this$0).get(i2)).updateVisualAudio(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateEWS(boolean bl) {
        List list = TVSettings.access$1500(this.this$0);
        synchronized (list) {
            this.ewsUpdate = bl;
            for (int i2 = 0; i2 < TVSettings.access$1500(this.this$0).size(); ++i2) {
                ((ISettingListener)TVSettings.access$1500(this.this$0).get(i2)).updateEWS(bl);
            }
        }
    }

    @Override
    public void passwordChanged() {
        for (int i2 = 0; i2 < TVSettings.access$1500(this.this$0).size(); ++i2) {
            ((ISettingListener)TVSettings.access$1500(this.this$0).get(i2)).passwordChanged();
        }
    }

    @Override
    public void passwordNeedsToBeEnteredAgain() {
        for (int i2 = 0; i2 < TVSettings.access$1500(this.this$0).size(); ++i2) {
            ((ISettingListener)TVSettings.access$1500(this.this$0).get(i2)).passwordNeedsToBeEnteredAgain();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationListSorting(int n) {
        List list = TVSettings.access$1500(this.this$0);
        synchronized (list) {
            if (n != this.stationListSorting) {
                this.stationListSorting = n;
                for (int i2 = 0; i2 < TVSettings.access$1500(this.this$0).size(); ++i2) {
                    ((ISettingListener)TVSettings.access$1500(this.this$0).get(i2)).updateStationListSorting(n);
                }
            }
        }
    }

    /* synthetic */ TVSettings$UpdateProvider(TVSettings tVSettings, TVSettings$1 tVSettings$1) {
        this(tVSettings);
    }
}

