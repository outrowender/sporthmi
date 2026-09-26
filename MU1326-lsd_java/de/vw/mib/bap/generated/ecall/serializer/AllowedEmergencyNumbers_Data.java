/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class AllowedEmergencyNumbers_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_ID_TEL_NUMBER;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    private static final int MAX_ID_LENGTH;
    public final BAPString id;
    private static final int MAX_TELNUMBER_LENGTH;
    public final BAPString telNumber;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public AllowedEmergencyNumbers_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.id = new BAPString(31);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public AllowedEmergencyNumbers_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.id.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AllowedEmergencyNumbers_Data allowedEmergencyNumbers_Data = (AllowedEmergencyNumbers_Data)bAPEntity;
        return this.arrayHeader.equalTo(allowedEmergencyNumbers_Data.arrayHeader) && this.pos == allowedEmergencyNumbers_Data.pos && this.id.equalTo(allowedEmergencyNumbers_Data.id) && this.telNumber.equalTo(allowedEmergencyNumbers_Data.telNumber);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AllowedEmergencyNumbers_Data");
        stringBuffer.append("\n - pos:").append(this.pos);
        stringBuffer.append("\n - id:").append(this.id.toString());
        stringBuffer.append("\n - telNumber:").append(this.telNumber.toString());
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
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.id.serialize(bitStream);
                this.telNumber.serialize(bitStream);
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
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.id.deserialize(bitStream);
                this.telNumber.deserialize(bitStream);
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

