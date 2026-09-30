/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PU_Content_Status
implements StatusProperty {
    public int taid;
    private static final int TAID_BITSIZE = 8;
    public int priority;
    private static final int PRIORITY_BITSIZE = 8;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_HIGH = 2;
    public int logicalContext;
    private static final int LOGICAL_CONTEXT_BITSIZE = 8;
    public static final int LOGICAL_CONTEXT_DEFAULT_CONTEXT_ANY_CONTEXT = 0;
    public static final int LOGICAL_CONTEXT_RADIO = 1;
    public static final int LOGICAL_CONTEXT_MEDIA = 2;
    public static final int LOGICAL_CONTEXT_NAVIGATION = 3;
    public static final int LOGICAL_CONTEXT_TELEPHONE = 4;
    public static final int LOGICAL_CONTEXT_CONNECT_ONLINE_CONNECTION_RELATED = 5;
    public static final int LOGICAL_CONTEXT_SPEECH_DIALOGUE = 6;
    public static final int LOGICAL_CONTEXT_CAR = 7;
    public static final int LOGICAL_CONTEXT_SETUP = 8;
    public static final int LOGICAL_CONTEXT_TONE = 9;
    public static final int LOGICAL_CONTEXT_OFFICE = 10;
    public int cursorPosition;
    private static final int CURSOR_POSITION_BITSIZE = 8;
    public static final int CURSOR_POSITION_DO_NOT_SHOW_ANY_OPTION = 0;
    public static final int CURSOR_POSITION_OPTION_1 = 1;
    public static final int CURSOR_POSITION_OPTION_2 = 2;
    public static final int CURSOR_POSITION_OPTION_3 = 3;
    public static final int CURSOR_POSITION_OPTION_4 = 4;
    public final Option_1 option_1 = new Option_1();
    public final Option_2 option_2 = new Option_2();
    public final Option_3 option_3 = new Option_3();
    public final Option_4 option_4 = new Option_4();
    public final BAPString text = new BAPString(452);
    private static final int MAX_TEXT_LENGTH = 452;
    public int icon;
    private static final int ICON_BITSIZE = 8;
    public static final int ICON_NO_ICON = 0;
    public static final int ICON_PHONE = 1;
    public static final int ICON_BLUETOOTH = 2;
    public static final int ICON_SEMI_DYNAMIC_ROUTE = 3;
    public static final int ICON_SMS = 4;
    public static final int ICON_EMAIL = 5;
    public static final int ICON_MEETING = 6;
    public static final int ICON_FUEL = 7;
    public static final int ICON_VEHICLE_BATTERY = 8;
    public static final int ICON_DATA_CONNECTION_REQUEST = 9;
    public static final int ICON_POI_ALERT = 10;
    public int maximumDisplayTime;
    private static final int MAXIMUM_DISPLAY_TIME_BITSIZE = 8;

    public int getTransactionId() {
        return this.taid;
    }

    public void setTransactionId(int n) {
        this.taid = n;
    }

    public PU_Content_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PU_Content_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.taid = 0;
        this.priority = 0;
        this.logicalContext = 0;
        this.cursorPosition = 0;
        this.icon = 0;
        this.maximumDisplayTime = 0;
    }

    public void reset() {
        this.internalReset();
        this.option_1.reset();
        this.option_2.reset();
        this.option_3.reset();
        this.option_4.reset();
        this.text.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PU_Content_Status pU_Content_Status = (PU_Content_Status)bAPEntity;
        return this.taid == pU_Content_Status.taid && this.priority == pU_Content_Status.priority && this.logicalContext == pU_Content_Status.logicalContext && this.cursorPosition == pU_Content_Status.cursorPosition && this.option_1.equalTo(pU_Content_Status.option_1) && this.option_2.equalTo(pU_Content_Status.option_2) && this.option_3.equalTo(pU_Content_Status.option_3) && this.option_4.equalTo(pU_Content_Status.option_4) && this.text.equalTo(pU_Content_Status.text) && this.icon == pU_Content_Status.icon && this.maximumDisplayTime == pU_Content_Status.maximumDisplayTime;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PU_Content_Status:");
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - Priority: ");
        switch (this.priority) {
            case 0: {
                stringBuffer.append("0x00 (low)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (medium)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (high)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - LogicalContext: ");
        switch (this.logicalContext) {
            case 0: {
                stringBuffer.append("0x00 (default context / any context)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (radio)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (media)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (navigation)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (telephone)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (connect (online connection related))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (speech dialogue)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (car)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (setup)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (tone)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (office)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CursorPosition: ");
        switch (this.cursorPosition) {
            case 0: {
                stringBuffer.append("0x00 (do not show any option)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (option 1)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (option 2)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (option 3)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (option 4)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Option_1 - ");
        stringBuffer.append(this.option_1.toString());
        stringBuffer.append("\n - Option_2 - ");
        stringBuffer.append(this.option_2.toString());
        stringBuffer.append("\n - Option_3 - ");
        stringBuffer.append(this.option_3.toString());
        stringBuffer.append("\n - Option_4 - ");
        stringBuffer.append(this.option_4.toString());
        stringBuffer.append("\n - Text - ");
        stringBuffer.append(this.text.toString());
        stringBuffer.append("\n - Icon: ");
        switch (this.icon) {
            case 0: {
                stringBuffer.append("0x00 (no icon)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (phone)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (bluetooth)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (semi dynamic route)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (SMS)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (email)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (meeting)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (fuel)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (vehicle battery)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (data connection request)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (POI alert)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - maximumDisplayTime - ");
        stringBuffer.append(this.maximumDisplayTime);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        n += this.option_1.bitSize();
        n += this.option_2.bitSize();
        n += this.option_3.bitSize();
        n += this.option_4.bitSize();
        n += this.text.bitSize();
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.taid);
        bitStream.pushByte((byte)this.priority);
        bitStream.pushByte((byte)this.logicalContext);
        bitStream.pushByte((byte)this.cursorPosition);
        this.option_1.serialize(bitStream);
        this.option_2.serialize(bitStream);
        this.option_3.serialize(bitStream);
        this.option_4.serialize(bitStream);
        this.text.serialize(bitStream);
        bitStream.pushByte((byte)this.icon);
        bitStream.pushByte((byte)this.maximumDisplayTime);
    }

    public void deserialize(BitStream bitStream) {
        this.taid = bitStream.popFrontByte();
        this.priority = bitStream.popFrontByte();
        this.logicalContext = bitStream.popFrontByte();
        this.cursorPosition = bitStream.popFrontByte();
        this.option_1.deserialize(bitStream);
        this.option_2.deserialize(bitStream);
        this.option_3.deserialize(bitStream);
        this.option_4.deserialize(bitStream);
        this.text.deserialize(bitStream);
        this.icon = bitStream.popFrontByte();
        this.maximumDisplayTime = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 19;
    }

    public int getFunctionId() {
        return PU_Content_Status.functionId();
    }

    public static final class Option_1
    implements BAPEntity {
        public int optionType;
        private static final int OPTION_TYPE_BITSIZE = 8;
        public static final int OPTION_TYPE_NO_OPTION_HIDE_OPTION = 0;
        public static final int OPTION_TYPE_OPTION_YES = 1;
        public static final int OPTION_TYPE_OPTION_OK = 2;
        public static final int OPTION_TYPE_OPTION_NO = 3;
        public static final int OPTION_TYPE_OPTION_CANCEL = 4;
        public static final int OPTION_TYPE_OPTION_IGNORE = 5;
        public static final int OPTION_TYPE_OPTION_ACCEPT = 6;
        public static final int OPTION_TYPE_OPTION_DENY = 7;
        public static final int OPTION_TYPE_OPTION_SAVE = 8;
        public static final int OPTION_TYPE_OPTION_CLOSE = 9;
        public static final int OPTION_TYPE_OPTION_CONFIRM = 10;
        public static final int OPTION_TYPE_SHOW_PARAMETER_OPTION_STRING = 255;
        public final BAPString optionString = new BAPString(91);
        private static final int MAX_OPTION_STRING_LENGTH = 91;

        public Option_1() {
            this.internalReset();
            this.customInitialization();
        }

        public Option_1(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.optionType = 0;
        }

        public void reset() {
            this.internalReset();
            this.optionString.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Option_1 option_1 = (Option_1)bAPEntity;
            return this.optionType == option_1.optionType && this.optionString.equalTo(option_1.optionString);
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Option_1:");
            stringBuffer.append("\n - OptionType: ");
            switch (this.optionType) {
                case 0: {
                    stringBuffer.append("0x00 (no option / hide option)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (option \\\"yes\\\")");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (option \\\"ok\\\")");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (option \\\"no\\\")");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (option \\\"cancel\\\")");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (option \\\"ignore\\\")");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (option \\\"accept\\\")");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (option \\\"deny\\\")");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (option \\\"save\\\")");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (option \\\"close\\\")");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (option \\\"confirm\\\")");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (show parameter OptionString)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - OptionString - ");
            stringBuffer.append(this.optionString.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += this.optionString.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.optionType);
            this.optionString.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.optionType = bitStream.popFrontByte();
            this.optionString.deserialize(bitStream);
        }
    }

    public static final class Option_2
    implements BAPEntity {
        public int optionType;
        private static final int OPTION_TYPE_BITSIZE = 8;
        public static final int OPTION_TYPE_NO_OPTION_HIDE_OPTION = 0;
        public static final int OPTION_TYPE_OPTION_YES = 1;
        public static final int OPTION_TYPE_OPTION_OK = 2;
        public static final int OPTION_TYPE_OPTION_NO = 3;
        public static final int OPTION_TYPE_OPTION_CANCEL = 4;
        public static final int OPTION_TYPE_OPTION_IGNORE = 5;
        public static final int OPTION_TYPE_OPTION_ACCEPT = 6;
        public static final int OPTION_TYPE_OPTION_DENY = 7;
        public static final int OPTION_TYPE_OPTION_SAVE = 8;
        public static final int OPTION_TYPE_OPTION_CLOSE = 9;
        public static final int OPTION_TYPE_OPTION_CONFIRM = 10;
        public static final int OPTION_TYPE_SHOW_PARAMETER_OPTION_STRING = 255;
        public final BAPString optionString = new BAPString(91);
        private static final int MAX_OPTION_STRING_LENGTH = 91;

        public Option_2() {
            this.internalReset();
            this.customInitialization();
        }

        public Option_2(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.optionType = 0;
        }

        public void reset() {
            this.internalReset();
            this.optionString.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Option_2 option_2 = (Option_2)bAPEntity;
            return this.optionType == option_2.optionType && this.optionString.equalTo(option_2.optionString);
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Option_2:");
            stringBuffer.append("\n - OptionType: ");
            switch (this.optionType) {
                case 0: {
                    stringBuffer.append("0x00 (no option / hide option)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (option \\\"yes\\\")");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (option \\\"ok\\\")");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (option \\\"no\\\")");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (option \\\"cancel\\\")");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (option \\\"ignore\\\")");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (option \\\"accept\\\")");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (option \\\"deny\\\")");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (option \\\"save\\\")");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (option \\\"close\\\")");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (option \\\"confirm\\\")");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (show parameter OptionString)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - OptionString - ");
            stringBuffer.append(this.optionString.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += this.optionString.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.optionType);
            this.optionString.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.optionType = bitStream.popFrontByte();
            this.optionString.deserialize(bitStream);
        }
    }

    public static final class Option_3
    implements BAPEntity {
        public int optionType;
        private static final int OPTION_TYPE_BITSIZE = 8;
        public static final int OPTION_TYPE_NO_OPTION_HIDE_OPTION = 0;
        public static final int OPTION_TYPE_OPTION_YES = 1;
        public static final int OPTION_TYPE_OPTION_OK = 2;
        public static final int OPTION_TYPE_OPTION_NO = 3;
        public static final int OPTION_TYPE_OPTION_CANCEL = 4;
        public static final int OPTION_TYPE_OPTION_IGNORE = 5;
        public static final int OPTION_TYPE_OPTION_ACCEPT = 6;
        public static final int OPTION_TYPE_OPTION_DENY = 7;
        public static final int OPTION_TYPE_OPTION_SAVE = 8;
        public static final int OPTION_TYPE_OPTION_CLOSE = 9;
        public static final int OPTION_TYPE_OPTION_CONFIRM = 10;
        public static final int OPTION_TYPE_SHOW_PARAMETER_OPTION_STRING = 255;
        public final BAPString optionString = new BAPString(91);
        private static final int MAX_OPTION_STRING_LENGTH = 91;

        public Option_3() {
            this.internalReset();
            this.customInitialization();
        }

        public Option_3(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.optionType = 0;
        }

        public void reset() {
            this.internalReset();
            this.optionString.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Option_3 option_3 = (Option_3)bAPEntity;
            return this.optionType == option_3.optionType && this.optionString.equalTo(option_3.optionString);
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Option_3:");
            stringBuffer.append("\n - OptionType: ");
            switch (this.optionType) {
                case 0: {
                    stringBuffer.append("0x00 (no option / hide option)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (option \\\"yes\\\")");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (option \\\"ok\\\")");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (option \\\"no\\\")");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (option \\\"cancel\\\")");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (option \\\"ignore\\\")");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (option \\\"accept\\\")");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (option \\\"deny\\\")");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (option \\\"save\\\")");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (option \\\"close\\\")");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (option \\\"confirm\\\")");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (show parameter OptionString)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - OptionString - ");
            stringBuffer.append(this.optionString.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += this.optionString.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.optionType);
            this.optionString.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.optionType = bitStream.popFrontByte();
            this.optionString.deserialize(bitStream);
        }
    }

    public static final class Option_4
    implements BAPEntity {
        public int optionType;
        private static final int OPTION_TYPE_BITSIZE = 8;
        public static final int OPTION_TYPE_NO_OPTION_HIDE_OPTION = 0;
        public static final int OPTION_TYPE_OPTION_YES = 1;
        public static final int OPTION_TYPE_OPTION_OK = 2;
        public static final int OPTION_TYPE_OPTION_NO = 3;
        public static final int OPTION_TYPE_OPTION_CANCEL = 4;
        public static final int OPTION_TYPE_OPTION_IGNORE = 5;
        public static final int OPTION_TYPE_OPTION_ACCEPT = 6;
        public static final int OPTION_TYPE_OPTION_DENY = 7;
        public static final int OPTION_TYPE_OPTION_SAVE = 8;
        public static final int OPTION_TYPE_OPTION_CLOSE = 9;
        public static final int OPTION_TYPE_OPTION_CONFIRM = 10;
        public static final int OPTION_TYPE_SHOW_PARAMETER_OPTION_STRING = 255;
        public final BAPString optionString = new BAPString(91);
        private static final int MAX_OPTION_STRING_LENGTH = 91;

        public Option_4() {
            this.internalReset();
            this.customInitialization();
        }

        public Option_4(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.optionType = 0;
        }

        public void reset() {
            this.internalReset();
            this.optionString.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Option_4 option_4 = (Option_4)bAPEntity;
            return this.optionType == option_4.optionType && this.optionString.equalTo(option_4.optionString);
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Option_4:");
            stringBuffer.append("\n - OptionType: ");
            switch (this.optionType) {
                case 0: {
                    stringBuffer.append("0x00 (no option / hide option)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (option \\\"yes\\\")");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (option \\\"ok\\\")");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (option \\\"no\\\")");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (option \\\"cancel\\\")");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (option \\\"ignore\\\")");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (option \\\"accept\\\")");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (option \\\"deny\\\")");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (option \\\"save\\\")");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (option \\\"close\\\")");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (option \\\"confirm\\\")");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (show parameter OptionString)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - OptionString - ");
            stringBuffer.append(this.optionString.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += this.optionString.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.optionType);
            this.optionString.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.optionType = bitStream.popFrontByte();
            this.optionString.deserialize(bitStream);
        }
    }
}

