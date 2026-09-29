/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class PU_Content_Status$Option_3
implements BAPEntity {
    public int optionType;
    private static final int OPTION_TYPE_BITSIZE;
    public static final int OPTION_TYPE_NO_OPTION_HIDE_OPTION;
    public static final int OPTION_TYPE_OPTION_YES;
    public static final int OPTION_TYPE_OPTION_OK;
    public static final int OPTION_TYPE_OPTION_NO;
    public static final int OPTION_TYPE_OPTION_CANCEL;
    public static final int OPTION_TYPE_OPTION_IGNORE;
    public static final int OPTION_TYPE_OPTION_ACCEPT;
    public static final int OPTION_TYPE_OPTION_DENY;
    public static final int OPTION_TYPE_OPTION_SAVE;
    public static final int OPTION_TYPE_OPTION_CLOSE;
    public static final int OPTION_TYPE_OPTION_CONFIRM;
    public static final int OPTION_TYPE_SHOW_PARAMETER_OPTION_STRING;
    public final BAPString optionString = new BAPString(91);
    private static final int MAX_OPTION_STRING_LENGTH;

    public PU_Content_Status$Option_3() {
        this.internalReset();
        this.customInitialization();
    }

    public PU_Content_Status$Option_3(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.optionType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.optionString.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PU_Content_Status$Option_3 pU_Content_Status$Option_3 = (PU_Content_Status$Option_3)bAPEntity;
        return this.optionType == pU_Content_Status$Option_3.optionType && this.optionString.equalTo(pU_Content_Status$Option_3.optionString);
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += this.optionString.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.optionType);
        this.optionString.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.optionType = bitStream.popFrontByte();
        this.optionString.deserialize(bitStream);
    }
}

