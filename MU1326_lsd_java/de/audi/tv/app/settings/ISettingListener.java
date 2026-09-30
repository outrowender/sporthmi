/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

public interface ISettingListener {
    public void updateVisualAudio(boolean var1);

    public void updateEWS(boolean var1);

    public void passwordChanged();

    public void passwordNeedsToBeEnteredAgain();

    public void updateStationListSorting(int var1);

    public static class Stub
    implements ISettingListener {
        public void updateVisualAudio(boolean bl) {
        }

        public void updateEWS(boolean bl) {
        }

        public void passwordChanged() {
        }

        public void passwordNeedsToBeEnteredAgain() {
        }

        public void updateStationListSorting(int n) {
        }
    }
}

