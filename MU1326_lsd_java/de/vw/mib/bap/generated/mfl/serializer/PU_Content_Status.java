/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status$Option_1;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status$Option_2;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status$Option_3;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status$Option_4;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PU_Content_Status
implements StatusProperty {
    public int taid;
    private static final int TAID_BITSIZE;
    public int priority;
    private static final int PRIORITY_BITSIZE;
    public static final int PRIORITY_LOW;
    public static final int PRIORITY_MEDIUM;
    public static final int PRIORITY_HIGH;
    public int logicalContext;
    private static final int LOGICAL_CONTEXT_BITSIZE;
    public static final int LOGICAL_CONTEXT_DEFAULT_CONTEXT_ANY_CONTEXT;
    public static final int LOGICAL_CONTEXT_RADIO;
    public static final int LOGICAL_CONTEXT_MEDIA;
    public static final int LOGICAL_CONTEXT_NAVIGATION;
    public static final int LOGICAL_CONTEXT_TELEPHONE;
    public static final int LOGICAL_CONTEXT_CONNECT_ONLINE_CONNECTION_RELATED;
    public static final int LOGICAL_CONTEXT_SPEECH_DIALOGUE;
    public static final int LOGICAL_CONTEXT_CAR;
    public static final int LOGICAL_CONTEXT_SETUP;
    public static final int LOGICAL_CONTEXT_TONE;
    public static final int LOGICAL_CONTEXT_OFFICE;
    public int cursorPosition;
    private static final int CURSOR_POSITION_BITSIZE;
    public static final int CURSOR_POSITION_DO_NOT_SHOW_ANY_OPTION;
    public static final int CURSOR_POSITION_OPTION_1;
    public static final int CURSOR_POSITION_OPTION_2;
    public static final int CURSOR_POSITION_OPTION_3;
    public static final int CURSOR_POSITION_OPTION_4;
    public final PU_Content_Status$Option_1 option_1 = new PU_Content_Status$Option_1();
    public final PU_Content_Status$Option_2 option_2 = new PU_Content_Status$Option_2();
    public final PU_Content_Status$Option_3 option_3 = new PU_Content_Status$Option_3();
    public final PU_Content_Status$Option_4 option_4 = new PU_Content_Status$Option_4();
    public final BAPString text = new BAPString(452);
    private static final int MAX_TEXT_LENGTH;
    public int icon;
    private static final int ICON_BITSIZE;
    public static final int ICON_NO_ICON;
    public static final int ICON_PHONE;
    public static final int ICON_BLUETOOTH;
    public static final int ICON_SEMI_DYNAMIC_ROUTE;
    public static final int ICON_SMS;
    public static final int ICON_EMAIL;
    public static final int ICON_MEETING;
    public static final int ICON_FUEL;
    public static final int ICON_VEHICLE_BATTERY;
    public static final int ICON_DATA_CONNECTION_REQUEST;
    public static final int ICON_POI_ALERT;
    public int maximumDisplayTime;
    private static final int MAXIMUM_DISPLAY_TIME_BITSIZE;

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

    @Override
    public void reset() {
        this.internalReset();
        this.option_1.reset();
        this.option_2.reset();
        this.option_3.reset();
        this.option_4.reset();
        this.text.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PU_Content_Status pU_Content_Status = (PU_Content_Status)bAPEntity;
        return this.taid == pU_Content_Status.taid && this.priority == pU_Content_Status.priority && this.logicalContext == pU_Content_Status.logicalContext && this.cursorPosition == pU_Content_Status.cursorPosition && this.option_1.equalTo(pU_Content_Status.option_1) && this.option_2.equalTo(pU_Content_Status.option_2) && this.option_3.equalTo(pU_Content_Status.option_3) && this.option_4.equalTo(pU_Content_Status.option_4) && this.text.equalTo(pU_Content_Status.text) && this.icon == pU_Content_Status.icon && this.maximumDisplayTime == pU_Content_Status.maximumDisplayTime;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int getFunctionId() {
        return PU_Content_Status.functionId();
    }
}

