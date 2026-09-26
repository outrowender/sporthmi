/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TimeToDestination_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean timeInfo_YearIsAvailableToBeDisplayed;
    public boolean timeInfo_MonthIsAvailableToBeDisplayed;
    public boolean timeInfo_DayIsAvailableToBeDisplayed;
    public boolean timeInfo_HourIsValid;
    public boolean timeInfo_MinuteIsValid;
    public boolean reserved_bit_0;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public TimeToDestination_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public TimeToDestination_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeInfo_YearIsAvailableToBeDisplayed = false;
        this.timeInfo_MonthIsAvailableToBeDisplayed = false;
        this.timeInfo_DayIsAvailableToBeDisplayed = false;
        this.timeInfo_HourIsValid = false;
        this.timeInfo_MinuteIsValid = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TimeToDestination_Status$ValidityInformation timeToDestination_Status$ValidityInformation = (TimeToDestination_Status$ValidityInformation)bAPEntity;
        return this.timeInfo_YearIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_YearIsAvailableToBeDisplayed && this.timeInfo_MonthIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_MonthIsAvailableToBeDisplayed && this.timeInfo_DayIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_DayIsAvailableToBeDisplayed && this.timeInfo_HourIsValid == timeToDestination_Status$ValidityInformation.timeInfo_HourIsValid && this.timeInfo_MinuteIsValid == timeToDestination_Status$ValidityInformation.timeInfo_MinuteIsValid && this.reserved_bit_0 == timeToDestination_Status$ValidityInformation.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 5: ");
        if (this.timeInfo_YearIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (TimeInfo.Year is available / to be displayed");
        } else {
            stringBuffer.append("false  (TimeInfo.Year is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.timeInfo_MonthIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (TimeInfo.Month is available / to be displayed");
        } else {
            stringBuffer.append("false  (TimeInfo.Month is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.timeInfo_DayIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (TimeInfo.Day is available / to be displayed");
        } else {
            stringBuffer.append("false  (TimeInfo.Day is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.timeInfo_HourIsValid) {
            stringBuffer.append("true  (TimeInfo.Hour is valid");
        } else {
            stringBuffer.append("false  (TimeInfo.Hour is invalid");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.timeInfo_MinuteIsValid) {
            stringBuffer.append("true  (TimeInfo.Minute is valid");
        } else {
            stringBuffer.append("false  (TimeInfo.Minute is invalid");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.reserved_bit_0) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
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
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.timeInfo_YearIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_MonthIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_DayIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_HourIsValid);
        bitStream.pushBoolean(this.timeInfo_MinuteIsValid);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.timeInfo_YearIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.timeInfo_MonthIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.timeInfo_DayIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.timeInfo_HourIsValid = bitStream.popFrontBoolean();
        this.timeInfo_MinuteIsValid = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

