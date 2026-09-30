/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_Status
implements StatusProperty {
    public final TpCounters tpCounters = new TpCounters();
    public final MessageTime messageTime = new MessageTime();
    public final BAPString stationName = new BAPString(49);
    private static final int MAX_STATION_NAME_LENGTH = 49;

    public TpMemoInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.tpCounters.reset();
        this.messageTime.reset();
        this.stationName.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_Status tpMemoInfo_Status = (TpMemoInfo_Status)bAPEntity;
        return this.tpCounters.equalTo(tpMemoInfo_Status.tpCounters) && this.messageTime.equalTo(tpMemoInfo_Status.messageTime) && this.stationName.equalTo(tpMemoInfo_Status.stationName);
    }

    private void customInitialization() {
        this.stationName.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TpMemoInfo_Status:");
        stringBuffer.append("\n - TpCounters - ");
        stringBuffer.append(this.tpCounters.toString());
        stringBuffer.append("\n - MessageTime - ");
        stringBuffer.append(this.messageTime.toString());
        stringBuffer.append("\n - StationName - ");
        stringBuffer.append(this.stationName.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.tpCounters.bitSize();
        n += this.messageTime.bitSize();
        return n += this.stationName.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.tpCounters.serialize(bitStream);
        this.messageTime.serialize(bitStream);
        this.stationName.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.tpCounters.deserialize(bitStream);
        this.messageTime.deserialize(bitStream);
        this.stationName.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return TpMemoInfo_Status.functionId();
    }

    public static final class TpCounters
    implements BAPEntity {
        public int currentMsgNumber;
        private static final int CURRENT_MSG_NUMBER_BITSIZE = 8;
        public int totalMsgNumber;
        private static final int TOTAL_MSG_NUMBER_BITSIZE = 8;

        public TpCounters() {
            this.internalReset();
            this.customInitialization();
        }

        public TpCounters(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.currentMsgNumber = 0;
            this.totalMsgNumber = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            TpCounters tpCounters = (TpCounters)bAPEntity;
            return this.currentMsgNumber == tpCounters.currentMsgNumber && this.totalMsgNumber == tpCounters.totalMsgNumber;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TpCounters:");
            stringBuffer.append("\n - CurrentMsgNumber - ");
            stringBuffer.append(this.currentMsgNumber);
            stringBuffer.append("\n - TotalMsgNumber - ");
            stringBuffer.append(this.totalMsgNumber);
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.currentMsgNumber);
            bitStream.pushByte((byte)this.totalMsgNumber);
        }

        public void deserialize(BitStream bitStream) {
            this.currentMsgNumber = bitStream.popFrontByte();
            this.totalMsgNumber = bitStream.popFrontByte();
        }
    }

    public static final class MessageTime
    implements BAPEntity {
        public int hour;
        private static final int HOUR_BITSIZE = 8;
        public int minute;
        private static final int MINUTE_BITSIZE = 8;

        public MessageTime() {
            this.internalReset();
            this.customInitialization();
        }

        public MessageTime(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.hour = 0;
            this.minute = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            MessageTime messageTime = (MessageTime)bAPEntity;
            return this.hour == messageTime.hour && this.minute == messageTime.minute;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("MessageTime:");
            stringBuffer.append("\n - Hour - ");
            stringBuffer.append(this.hour);
            stringBuffer.append("\n - Minute - ");
            stringBuffer.append(this.minute);
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.hour);
            bitStream.pushByte((byte)this.minute);
        }

        public void deserialize(BitStream bitStream) {
            this.hour = bitStream.popFrontByte();
            this.minute = bitStream.popFrontByte();
        }
    }
}

