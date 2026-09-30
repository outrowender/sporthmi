/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_NotificationRequests;
import de.vw.mib.bap.stream.BitStream;

public final class DisasterWarning_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_MSG_ID_SERIAL_NUMBER_SEGMENT_ID_TOTAL_NUMBER_OF_SEGMENTS_WARNING_TYPE_SEVERITY_URGENCY_CERTAINTY_NOTIFICATION_REQUESTS_LANGUAGE_TIME_STAMP_MESSAGE = 1;
    public static final int RECORD_ADDRESS_MSG_ID_SERIAL_NUMBER_SEGMENT_ID_TOTAL_NUMBER_OF_SEGMENTS_MESSAGE = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int POS_MIN = 0;
    public int pos;
    public static final int MSG_ID_MIN = 0;
    public int msg_Id;
    public static final int SERIAL_NUMBER_MIN = 0;
    public int serialNumber;
    public static final int SEGMENT_ID_MIN = 0;
    public int segmentId;
    public static final int TOTAL_NUMBER_OF_SEGMENTS_MIN = 0;
    public int totalNumberOfSegments;
    public static final int WARNING_TYPE_UNKNOWN = 0;
    public static final int WARNING_TYPE_EARTHQUAKE = 1;
    public static final int WARNING_TYPE_TSUNAMI = 2;
    public static final int WARNING_TYPE_EARTHQUAKE_AND_TSUNAMI = 3;
    public static final int WARNING_TYPE_TEST = 4;
    public static final int WARNING_TYPE_OTHER = 5;
    public int warningType;
    public static final int SEVERITY_UNKNOWN = 0;
    public static final int SEVERITY_PRESIDENTIAL = 1;
    public static final int SEVERITY_EXTREME = 2;
    public static final int SEVERITY_SEVERE = 3;
    public static final int SEVERITY_AMBER = 4;
    public int severity;
    public static final int URGENCY_UNKNOWN = 0;
    public static final int URGENCY_PRESIDENTIAL = 1;
    public static final int URGENCY_IMMEDIATE = 2;
    public static final int URGENCY_EXPECTED = 3;
    public int urgency;
    public static final int CERTAINTY_UNKNOWN = 0;
    public static final int CERTAINTY_PRESIDENTIAL = 1;
    public static final int CERTAINTY_OBSERVED = 2;
    public static final int CERTAINTY_LIKELY = 3;
    public int certainty;
    public DisasterWarning_NotificationRequests notificationRequests;
    public static final int LANGUAGE_LANGUAGE_UNSPECIFIED = 0;
    public static final int LANGUAGE_GERMAN = 1;
    public static final int LANGUAGE_ENGLISH = 2;
    public static final int LANGUAGE_ITALIAN = 3;
    public static final int LANGUAGE_FRENCH = 4;
    public static final int LANGUAGE_SPANISH = 5;
    public static final int LANGUAGE_DUTCH = 6;
    public static final int LANGUAGE_SWEDISH = 7;
    public static final int LANGUAGE_DANISH = 8;
    public static final int LANGUAGE_PORTUGUESE = 9;
    public static final int LANGUAGE_FINNISH = 10;
    public static final int LANGUAGE_NORWEGIAN = 11;
    public static final int LANGUAGE_GREEK = 12;
    public static final int LANGUAGE_TURKISH = 13;
    public static final int LANGUAGE_HUNGARIAN = 14;
    public static final int LANGUAGE_POLISH = 15;
    public static final int LANGUAGE_CZECH = 16;
    public static final int LANGUAGE_HEBREW = 17;
    public static final int LANGUAGE_ARABIC = 18;
    public static final int LANGUAGE_RUSSIAN = 19;
    public static final int LANGUAGE_ICELANDIC = 20;
    public int language;
    private static final int MAX_TIMESTAMP_LENGTH = 20;
    public final BAPString timeStamp;
    private static final int MAX_MESSAGE_LENGTH = 1922;
    public final BAPString message;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public DisasterWarning_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.notificationRequests = new DisasterWarning_NotificationRequests();
        this.timeStamp = new BAPString(20);
        this.message = new BAPString(1922);
        this.internalReset();
        this.customInitialization();
    }

    public DisasterWarning_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.msg_Id = 0;
        this.serialNumber = 0;
        this.segmentId = 0;
        this.totalNumberOfSegments = 0;
        this.warningType = 0;
        this.severity = 0;
        this.urgency = 0;
        this.certainty = 0;
        this.language = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.notificationRequests.reset();
        this.timeStamp.reset();
        this.message.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DisasterWarning_Data disasterWarning_Data = (DisasterWarning_Data)bAPEntity;
        return this.arrayHeader.equalTo(disasterWarning_Data.arrayHeader) && this.pos == disasterWarning_Data.pos && this.msg_Id == disasterWarning_Data.msg_Id && this.serialNumber == disasterWarning_Data.serialNumber && this.segmentId == disasterWarning_Data.segmentId && this.totalNumberOfSegments == disasterWarning_Data.totalNumberOfSegments && this.warningType == disasterWarning_Data.warningType && this.severity == disasterWarning_Data.severity && this.urgency == disasterWarning_Data.urgency && this.certainty == disasterWarning_Data.certainty && this.notificationRequests.equalTo(disasterWarning_Data.notificationRequests) && this.language == disasterWarning_Data.language && this.timeStamp.equalTo(disasterWarning_Data.timeStamp) && this.message.equalTo(disasterWarning_Data.message);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DisasterWarning_Data");
        stringBuffer.append("\n - pos:").append(this.pos);
        stringBuffer.append("\n - msg_Id:").append(this.msg_Id);
        stringBuffer.append("\n - serialNumber:").append(this.serialNumber);
        stringBuffer.append("\n - segmentId:").append(this.segmentId);
        stringBuffer.append("\n - totalNumberOfSegments:").append(this.totalNumberOfSegments);
        stringBuffer.append("\n - warningType:").append(this.warningType);
        stringBuffer.append("\n - severity:").append(this.severity);
        stringBuffer.append("\n - urgency:").append(this.urgency);
        stringBuffer.append("\n - certainty:").append(this.certainty);
        stringBuffer.append("\n - notificationRequests:").append(this.notificationRequests.toString());
        stringBuffer.append("\n - language:").append(this.language);
        stringBuffer.append("\n - timeStamp:").append(this.timeStamp.toString());
        stringBuffer.append("\n - message:").append(this.message.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushShort((short)this.msg_Id);
                bitStream.pushShort((short)this.serialNumber);
                bitStream.pushByte((byte)this.segmentId);
                bitStream.pushByte((byte)this.totalNumberOfSegments);
                this.message.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushShort((short)this.msg_Id);
                bitStream.pushShort((short)this.serialNumber);
                bitStream.pushByte((byte)this.segmentId);
                bitStream.pushByte((byte)this.totalNumberOfSegments);
                bitStream.pushByte((byte)this.warningType);
                bitStream.pushByte((byte)this.severity);
                bitStream.pushByte((byte)this.urgency);
                bitStream.pushByte((byte)this.certainty);
                this.notificationRequests.serialize(bitStream);
                bitStream.pushByte((byte)this.language);
                this.timeStamp.serialize(bitStream);
                this.message.serialize(bitStream);
                break;
            }
            default: {
                throw new UnsupportedOperationException("Unsupported record address: " + this.arrayHeader.getSerializationRecordAddress());
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.msg_Id = bitStream.popFrontShort();
                this.serialNumber = bitStream.popFrontShort();
                this.segmentId = bitStream.popFrontByte();
                this.totalNumberOfSegments = bitStream.popFrontByte();
                this.message.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.msg_Id = bitStream.popFrontShort();
                this.serialNumber = bitStream.popFrontShort();
                this.segmentId = bitStream.popFrontByte();
                this.totalNumberOfSegments = bitStream.popFrontByte();
                this.warningType = bitStream.popFrontByte();
                this.severity = bitStream.popFrontByte();
                this.urgency = bitStream.popFrontByte();
                this.certainty = bitStream.popFrontByte();
                this.notificationRequests.deserialize(bitStream);
                this.language = bitStream.popFrontByte();
                this.timeStamp.deserialize(bitStream);
                this.message.deserialize(bitStream);
                break;
            }
            default: {
                throw new UnsupportedOperationException("Unsupported record address: " + this.arrayHeader.getSerializationRecordAddress());
            }
        }
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }
}

