/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status
implements StatusProperty {
    public int messageId;
    private static final int MESSAGE_ID_BITSIZE = 4;
    public int messageStatus;
    private static final int MESSAGE_STATUS_BITSIZE = 4;
    public static final int MESSAGE_STATUS_NO_MESSAGE = 0;
    public static final int MESSAGE_STATUS_PRESENTATION_REQUEST_FOR_NEW_MESSAGE = 1;
    public static final int MESSAGE_STATUS_MESSAGE_PRESENTATION_CONFIRMED_TO_BE_SET_BY_ASG = 3;
    public int messageWaitingIndication;
    private static final int MESSAGE_WAITING_INDICATION_BITSIZE = 8;
    public static final int MESSAGE_WAITING_INDICATION_NO_MESSAGES_WAITING = 0;
    public static final int MESSAGE_WAITING_INDICATION_1_MESSAGE_WAITING = 1;
    public static final int MESSAGE_WAITING_INDICATION_SEVERAL_MESSAGES_ARE_WAITING = 2;
    public final TMCinfo tmcinfo = new TMCinfo();

    public TMCinfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.messageId = 0;
        this.messageStatus = 0;
        this.messageWaitingIndication = 0;
    }

    public void reset() {
        this.internalReset();
        this.tmcinfo.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status tMCinfo_Status = (TMCinfo_Status)bAPEntity;
        return this.messageId == tMCinfo_Status.messageId && this.messageStatus == tMCinfo_Status.messageStatus && this.messageWaitingIndication == tMCinfo_Status.messageWaitingIndication && this.tmcinfo.equalTo(tMCinfo_Status.tmcinfo);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TMCinfo_Status:");
        stringBuffer.append("\n - MessageID - ");
        stringBuffer.append(this.messageId);
        stringBuffer.append("\n - MessageStatus: ");
        switch (this.messageStatus) {
            case 0: {
                stringBuffer.append("0x0 (no message)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (presentation request for new message)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (message presentation confirmed (to be set by ASG))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MessageWaitingIndication: ");
        switch (this.messageWaitingIndication) {
            case 0: {
                stringBuffer.append("0x00 (no messages waiting)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (1 message waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (several messages are waiting)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TMCinfo - ");
        stringBuffer.append(this.tmcinfo.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        return n += this.tmcinfo.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.messageId);
        bitStream.pushBits(4, this.messageStatus);
        bitStream.pushByte((byte)this.messageWaitingIndication);
        this.tmcinfo.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.messageId = bitStream.popFrontBits(4);
        this.messageStatus = bitStream.popFrontBits(4);
        this.messageWaitingIndication = bitStream.popFrontByte();
        this.tmcinfo.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return TMCinfo_Status.functionId();
    }

    public static final class TMCinfo
    implements BAPEntity {
        public int priority;
        private static final int PRIORITY_BITSIZE = 8;
        public final BAPString streetName = new BAPString(61);
        private static final int MAX_STREET_NAME_LENGTH = 61;
        public final BAPString location = new BAPString(61);
        private static final int MAX_LOCATION_LENGTH = 61;
        public final BAPString infotext = new BAPString(121);
        private static final int MAX_INFOTEXT_LENGTH = 121;
        public final Length_Validity length_Validity = new Length_Validity();
        public int length_Value;
        private static final int LENGTH_VALUE_BITSIZE = 32;
        public int length_Unit;
        private static final int LENGTH_UNIT_BITSIZE = 8;
        public static final int LENGTH_UNIT_METER = 0;
        public static final int LENGTH_UNIT_KILOMETER = 1;
        public static final int LENGTH_UNIT_YARD = 2;
        public static final int LENGTH_UNIT_FEET = 3;
        public static final int LENGTH_UNIT_MILE_US_UK_BRITISH_STATUTE_MILE = 4;
        public static final int LENGTH_UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE = 255;

        public TMCinfo() {
            this.internalReset();
            this.customInitialization();
        }

        public TMCinfo(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.priority = 0;
            this.length_Value = 0;
            this.length_Unit = 0;
        }

        public void reset() {
            this.internalReset();
            this.streetName.reset();
            this.location.reset();
            this.infotext.reset();
            this.length_Validity.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            TMCinfo tMCinfo = (TMCinfo)bAPEntity;
            return this.priority == tMCinfo.priority && this.streetName.equalTo(tMCinfo.streetName) && this.location.equalTo(tMCinfo.location) && this.infotext.equalTo(tMCinfo.infotext) && this.length_Validity.equalTo(tMCinfo.length_Validity) && this.length_Value == tMCinfo.length_Value && this.length_Unit == tMCinfo.length_Unit;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TMCinfo:");
            stringBuffer.append("\n - Priority - ");
            stringBuffer.append(this.priority);
            stringBuffer.append("\n - StreetName - ");
            stringBuffer.append(this.streetName.toString());
            stringBuffer.append("\n - Location - ");
            stringBuffer.append(this.location.toString());
            stringBuffer.append("\n - Infotext - ");
            stringBuffer.append(this.infotext.toString());
            stringBuffer.append("\n - Length_Validity - ");
            stringBuffer.append(this.length_Validity.toString());
            stringBuffer.append("\n - Length_Value - ");
            stringBuffer.append(this.length_Value);
            stringBuffer.append("\n - Length_Unit: ");
            switch (this.length_Unit) {
                case 0: {
                    stringBuffer.append("0x00 (meter)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (kilometer)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (yard)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (feet)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (mile (US / UK (british statute mile)))");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (not supported / no information about unit available)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            n += this.streetName.bitSize();
            n += this.location.bitSize();
            n += this.infotext.bitSize();
            n += this.length_Validity.bitSize();
            n += 32;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.priority);
            this.streetName.serialize(bitStream);
            this.location.serialize(bitStream);
            this.infotext.serialize(bitStream);
            this.length_Validity.serialize(bitStream);
            bitStream.pushInt(this.length_Value);
            bitStream.pushByte((byte)this.length_Unit);
        }

        public void deserialize(BitStream bitStream) {
            this.priority = bitStream.popFrontByte();
            this.streetName.deserialize(bitStream);
            this.location.deserialize(bitStream);
            this.infotext.deserialize(bitStream);
            this.length_Validity.deserialize(bitStream);
            this.length_Value = bitStream.popFrontInt();
            this.length_Unit = bitStream.popFrontByte();
        }

        public static final class Length_Validity
        implements BAPEntity {
            private static final int RESERVED_BIT_1__7_BITSIZE = 7;
            public boolean lengthValid;
            private static final int LENGTH_VALIDITY_BITSIZE = 8;

            public Length_Validity() {
                this.internalReset();
                this.customInitialization();
            }

            public Length_Validity(BitStream bitStream) {
                this();
                this.deserialize(bitStream);
            }

            private void internalReset() {
                this.lengthValid = false;
            }

            public void reset() {
                this.internalReset();
            }

            public boolean equalTo(BAPEntity bAPEntity) {
                Length_Validity length_Validity = (Length_Validity)bAPEntity;
                return this.lengthValid == length_Validity.lengthValid;
            }

            private void customInitialization() {
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Length_Validity:");
                stringBuffer.append("\n - Bit 0: ");
                if (this.lengthValid) {
                    stringBuffer.append("true  (Length valid");
                } else {
                    stringBuffer.append("false  (Length invalid");
                }
                return stringBuffer.toString();
            }

            public int bitSize() {
                int n = 0;
                return n += 8;
            }

            public void serialize(BitStream bitStream) {
                bitStream.resetBits(7);
                bitStream.pushBoolean(this.lengthValid);
            }

            public void deserialize(BitStream bitStream) {
                bitStream.discardBits(7);
                this.lengthValid = bitStream.popFrontBoolean();
            }
        }
    }
}

