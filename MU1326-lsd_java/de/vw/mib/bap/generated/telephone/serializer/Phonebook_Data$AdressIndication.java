/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$AdressIndication
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean businessAddressIsSuitedAsNavigationDestaination;
    public boolean businessAddressAvailable;
    public boolean privateAddressIsSuitedAsNavigationDestaination;
    public boolean privateAddressAvailable;
    public boolean defaultAddressIsSuitedAsNavigationDestaination;
    public boolean defaultAddressAvailable;
    private static final int ADRESS_INDICATION_BITSIZE;

    public Phonebook_Data$AdressIndication() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$AdressIndication(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.businessAddressIsSuitedAsNavigationDestaination = false;
        this.businessAddressAvailable = false;
        this.privateAddressIsSuitedAsNavigationDestaination = false;
        this.privateAddressAvailable = false;
        this.defaultAddressIsSuitedAsNavigationDestaination = false;
        this.defaultAddressAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_Data$AdressIndication phonebook_Data$AdressIndication = (Phonebook_Data$AdressIndication)bAPEntity;
        return this.reserved_bit_7 == phonebook_Data$AdressIndication.reserved_bit_7 && this.reserved_bit_6 == phonebook_Data$AdressIndication.reserved_bit_6 && this.businessAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.businessAddressIsSuitedAsNavigationDestaination && this.businessAddressAvailable == phonebook_Data$AdressIndication.businessAddressAvailable && this.privateAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.privateAddressIsSuitedAsNavigationDestaination && this.privateAddressAvailable == phonebook_Data$AdressIndication.privateAddressAvailable && this.defaultAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.defaultAddressIsSuitedAsNavigationDestaination && this.defaultAddressAvailable == phonebook_Data$AdressIndication.defaultAddressAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AdressIndication:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.reserved_bit_6) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.businessAddressIsSuitedAsNavigationDestaination) {
            stringBuffer.append("true  (business address is suited as navigation destaination");
        } else {
            stringBuffer.append("false  (business address is NOT suited as navigation destaination");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.businessAddressAvailable) {
            stringBuffer.append("true  (business address available");
        } else {
            stringBuffer.append("false  (business address NOT available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.privateAddressIsSuitedAsNavigationDestaination) {
            stringBuffer.append("true  (private (home) address is suited as navigation destaination");
        } else {
            stringBuffer.append("false  (private (home) address is NOT suited as navigation destaination");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.privateAddressAvailable) {
            stringBuffer.append("true  (private (home) address available");
        } else {
            stringBuffer.append("false  (private (home) address NOT available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.defaultAddressIsSuitedAsNavigationDestaination) {
            stringBuffer.append("true  (default address is suited as navigation destaination");
        } else {
            stringBuffer.append("false  (default address is NOT suited as navigation destaination");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.defaultAddressAvailable) {
            stringBuffer.append("true  (default address available");
        } else {
            stringBuffer.append("false  (default address NOT available");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.businessAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.businessAddressAvailable);
        bitStream.pushBoolean(this.privateAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.privateAddressAvailable);
        bitStream.pushBoolean(this.defaultAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.defaultAddressAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.reserved_bit_6 = bitStream.popFrontBoolean();
        this.businessAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
        this.businessAddressAvailable = bitStream.popFrontBoolean();
        this.privateAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
        this.privateAddressAvailable = bitStream.popFrontBoolean();
        this.defaultAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
        this.defaultAddressAvailable = bitStream.popFrontBoolean();
    }
}

