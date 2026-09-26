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
    public static final int RECORD_ADDRESS_MSG_ID_SERIAL_NUMBER_SEGMENT_ID_TOTAL_NUMBER_OF_SEGMENTS_WARNING_TYPE_SEVERITY_URGENCY_CERTAINTY_NOTIFICATION_REQUESTS_LANGUAGE_TIME_STAMP_MESSAGE;
    public static final int RECORD_ADDRESS_MSG_ID_SERIAL_NUMBER_SEGMENT_ID_TOTAL_NUMBER_OF_SEGMENTS_MESSAGE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int MSG_ID_MIN;
    public int msg_Id;
    public static final int SERIAL_NUMBER_MIN;
    public int serialNumber;
    public static final int SEGMENT_ID_MIN;
    public int segmentId;
    public static final int TOTAL_NUMBER_OF_SEGMENTS_MIN;
    public int totalNumberOfSegments;
    public static final int WARNING_TYPE_UNKNOWN;
    public static final int WARNING_TYPE_EARTHQUAKE;
    public static final int WARNING_TYPE_TSUNAMI;
    public static final int WARNING_TYPE_EARTHQUAKE_AND_TSUNAMI;
    public static final int WARNING_TYPE_TEST;
    public static final int WARNING_TYPE_OTHER;
    public int warningType;
    public static final int SEVERITY_UNKNOWN;
    public static final int SEVERITY_PRESIDENTIAL;
    public static final int SEVERITY_EXTREME;
    public static final int SEVERITY_SEVERE;
    public static final int SEVERITY_AMBER;
    public int severity;
    public static final int URGENCY_UNKNOWN;
    public static final int URGENCY_PRESIDENTIAL;
    public static final int URGENCY_IMMEDIATE;
    public static final int URGENCY_EXPECTED;
    public int urgency;
    public static final int CERTAINTY_UNKNOWN;
    public static final int CERTAINTY_PRESIDENTIAL;
    public static final int CERTAINTY_OBSERVED;
    public static final int CERTAINTY_LIKELY;
    public int certainty;
    public DisasterWarning_NotificationRequests notificationRequests;
    public static final int LANGUAGE_LANGUAGE_UNSPECIFIED;
    public static final int LANGUAGE_GERMAN;
    public static final int LANGUAGE_ENGLISH;
    public static final int LANGUAGE_ITALIAN;
    public static final int LANGUAGE_FRENCH;
    public static final int LANGUAGE_SPANISH;
    public static final int LANGUAGE_DUTCH;
    public static final int LANGUAGE_SWEDISH;
    public static final int LANGUAGE_DANISH;
    public static final int LANGUAGE_PORTUGUESE;
    public static final int LANGUAGE_FINNISH;
    public static final int LANGUAGE_NORWEGIAN;
    public static final int LANGUAGE_GREEK;
    public static final int LANGUAGE_TURKISH;
    public static final int LANGUAGE_HUNGARIAN;
    public static final int LANGUAGE_POLISH;
    public static final int LANGUAGE_CZECH;
    public static final int LANGUAGE_HEBREW;
    public static final int LANGUAGE_ARABIC;
    public static final int LANGUAGE_RUSSIAN;
    public static final int LANGUAGE_ICELANDIC;
    public int language;
    private static final int MAX_TIMESTAMP_LENGTH;
    public final BAPString timeStamp;
    private static final int MAX_MESSAGE_LENGTH;
    public final BAPString message;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
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

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.notificationRequests.reset();
        this.timeStamp.reset();
        this.message.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DisasterWarning_Data disasterWarning_Data = (DisasterWarning_Data)bAPEntity;
        return this.arrayHeader.equalTo(disasterWarning_Data.arrayHeader) && this.pos == disasterWarning_Data.pos && this.msg_Id == disasterWarning_Data.msg_Id && this.serialNumber == disasterWarning_Data.serialNumber && this.segmentId == disasterWarning_Data.segmentId && this.totalNumberOfSegments == disasterWarning_Data.totalNumberOfSegments && this.warningType == disasterWarning_Data.warningType && this.severity == disasterWarning_Data.severity && this.urgency == disasterWarning_Data.urgency && this.certainty == disasterWarning_Data.certainty && this.notificationRequests.equalTo(disasterWarning_Data.notificationRequests) && this.language == disasterWarning_Data.language && this.timeStamp.equalTo(disasterWarning_Data.timeStamp) && this.message.equalTo(disasterWarning_Data.message);
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
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
                throw new UnsupportedOperationException(new StringBuffer().append("Unsupported record address: ").append(this.arrayHeader.getSerializationRecordAddress()).toString());
            }
        }
    }

    @Override
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
                throw new UnsupportedOperationException(new StringBuffer().append("Unsupported record address: ").append(this.arrayHeader.getSerializationRecordAddress()).toString());
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

