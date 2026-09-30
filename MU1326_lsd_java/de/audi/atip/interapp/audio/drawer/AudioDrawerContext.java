/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.hmi.model.IntegerListCell;

public interface AudioDrawerContext {
    public static final int PRIO_IDX_APS = 0;
    public static final int PRIO_IDX_TERMINAL_MODE_PHONE = 1;
    public static final int PRIO_IDX_PHONE = 2;
    public static final int PRIO_IDX_SDS_MAIN = 3;
    public static final int PRIO_IDX_SDS_ADB = 4;
    public static final int PRIO_IDX_SDS_MEDIA = 5;
    public static final int PRIO_IDX_SDS_MESSAGING = 6;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_CNTW = 7;
    public static final int PRIO_IDX_SDS_NAVI = 8;
    public static final int PRIO_IDX_SDS_NAVI_POI_ONLINE = 9;
    public static final int PRIO_IDX_SDS_PHONE = 10;
    public static final int PRIO_IDX_SDS_RHMI = 11;
    public static final int PRIO_IDX_SDS_TUNER = 12;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_JP = 13;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_KR = 14;
    public static final int PRIO_IDX_NAVI = 15;
    public static final int PRIO_IDX_TA = 16;
    public static final int PRIO_IDX_SDIS = 17;
    public static final int PRIO_IDX_MEDIA = 18;
    public static final int PRIO_IDX_RADIO = 19;
    public static final int PRIO_IDX_TV = 20;
    public static final int PRIO_IDX_TERMINAL_MODE = 21;
    public static final int NO_PRIO_IDX = 22;
    public static final int MAX_ROWS = 1;
    public static final int MAX_COLUMNS = 23;
    public static final int CELL_TYPE_INACTIVE = 0;
    public static final int CELL_TYPE_ACTIVE = 1;
    public static final int CELL_TYPE_APS_ACTIVE_HIGH_PRIO = 2;
    public static final int CELL_TYPE_PHONE_IDLE = 0;
    public static final int CELL_TYPE_PHONE_ACTIVE_CALL = 2;
    public static final int CELL_TYPE_PHONE_INCOMING_CALL = 3;
    public static final IntegerListCell LIST_CELL_INACTIVE = IntegerListCell.create(0);
    public static final IntegerListCell LIST_CELL_ACTIVE = IntegerListCell.create(1);
    public static final IntegerListCell LIST_CELL_APS_ACTIVE_HIGH_PRIO = IntegerListCell.create(2);
    public static final IntegerListCell LIST_CELL_PHONE_IDLE = IntegerListCell.create(0);
    public static final IntegerListCell LIST_CELL_PHONE_ACTIVE_CALL = IntegerListCell.create(2);
    public static final IntegerListCell LIST_CELL_PHONE_INCOMING_CALL = IntegerListCell.create(3);
    public static final Source SOURCE_RADIO = new Source("AUDIO_DRAWER_SRC_RADIO", 19);
    public static final Source SOURCE_TV = new Source("AUDIO_DRAWER_SRC_TV", 20);
    public static final Source SOURCE_SDIS = new Source("AUDIO_DRAWER_SRC_SDIS", 17);
    public static final Source SOURCE_TERMINAL_MODE = new Source("AUDIO_DRAWER_SRC_TERMINAL_MODE", 21);
    public static final Source SOURCE_TERMINAL_MODE_PHONE = new Source("AUDIO_DRAWER_SRC_TERMINAL_MODE_PHONE", 1);
    public static final Source SOURCE_MEDIA = new Source("AUDIO_DRAWER_SRC_MEDIA", 18);
    public static final Source SOURCE_TA = new Source("AUDIO_DRAWER_SRC_TA", 16);
    public static final Source SOURCE_SDS_MAIN = new Source("AUDIO_DRAWER_SRC_SDS_MAIN", 3);
    public static final Source SOURCE_SDS_ADB = new Source("AUDIO_DRAWER_SRC_SDS_ADB", 4);
    public static final Source SOURCE_SDS_MEDIA = new Source("AUDIO_DRAWER_SRC_SDS_MEDIA", 5);
    public static final Source SOURCE_SDS_MESSAGING = new Source("AUDIO_DRAWER_SRC_SDS_MESSAGING", 6);
    public static final Source SOURCE_SDS_NAVI_ASIA_CNTW = new Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_CNTW", 7);
    public static final Source SOURCE_SDS_NAVI = new Source("AUDIO_DRAWER_SRC_SDS_NAVI", 8);
    public static final Source SOURCE_SDS_NAVI_POI_ONLINE = new Source("AUDIO_DRAWER_SRC_SDS_NAVI_POI_ONLINE", 9);
    public static final Source SOURCE_SDS_PHONE = new Source("AUDIO_DRAWER_SRC_SDS_PHONE", 10);
    public static final Source SOURCE_SDS_RHMI = new Source("AUDIO_DRAWER_SRC_SDS_RHMI", 11);
    public static final Source SOURCE_SDS_TUNER = new Source("AUDIO_DRAWER_SRC_SDS_TUNER", 12);
    public static final Source SOURCE_SDS_NAVI_ASIA_JP = new Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_JP", 13);
    public static final Source SOURCE_SDS_NAVI_ASIA_KR = new Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_KR", 14);
    public static final Source SOURCE_NAVI = new Source("AUDIO_DRAWER_SRC_NAVI", 15);
    public static final Source SOURCE_PHONE = new Source("AUDIO_DRAWER_SRC_PHONE", 2);
    public static final Source SOURCE_APS = new Source("AUDIO_DRAWER_SRC_APS", 0);
    public static final Source SOURCE_NONE = new Source("AUDIO_DRAWER_SRC_NONE", 22);
    public static final SourceAudioState SOURCE_AUDIO_STATE_ACTIVE = new SourceAudioState("SOURCE_AUDIO_STATE_ACTIVE", LIST_CELL_ACTIVE);
    public static final SourceAudioState SOURCE_AUDIO_STATE_INACTIVE = new SourceAudioState("SOURCE_AUDIO_STATE_INACTIVE", LIST_CELL_INACTIVE);
    public static final SourceAudioState SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO = new SourceAudioState("SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO", LIST_CELL_APS_ACTIVE_HIGH_PRIO);
    public static final SourceAudioState SOURCE_PHONE_STATE_IDLE = new SourceAudioState("SOURCE_PHONE_STATE_IDLE", LIST_CELL_PHONE_IDLE);
    public static final SourceAudioState SOURCE_PHONE_STATE_ACTIVE_CALL = new SourceAudioState("SOURCE_PHONE_STATE_ACTIVE_CALL", LIST_CELL_PHONE_ACTIVE_CALL);
    public static final SourceAudioState SOURCE_PHONE_STATE_INCOMING_CALL = new SourceAudioState("SOURCE_PHONE_STATE_INCOMING_CALL", LIST_CELL_PHONE_INCOMING_CALL);
    public static final int DRAWER_OPEN = 0;
    public static final int DRAWER_CLOSED = 1;
    public static final int DRAWER_MINIMIZED = 2;

    public void setContext(Source var1, SourceAudioState var2);

    public static final class Source {
        private final String source;
        private final int column;

        private Source(String string, int n) {
            this.source = string;
            this.column = n;
        }

        public int getColumn() {
            return this.column;
        }

        public String toString() {
            return this.source;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.column;
            n = 31 * n + (this.source == null ? 0 : this.source.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof Source)) {
                return false;
            }
            Source source = (Source)object;
            if (this.column != source.column) {
                return false;
            }
            return !(this.source == null ? source.source != null : !this.source.equals(source.source));
        }
    }

    public static final class SourceAudioState {
        private final String state;
        private final IntegerListCell cell;

        private SourceAudioState(String string, IntegerListCell integerListCell) {
            this.state = string;
            this.cell = integerListCell;
        }

        public IntegerListCell getCell() {
            return this.cell;
        }

        public String toString() {
            return this.state;
        }
    }
}

