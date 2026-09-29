/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean newTimeToDestination_YearIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_MonthIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_DayIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_HourIsValid;
    public boolean newTimeToDestination_MinuteIsValid;
    public boolean newDistanceToDestinationIsValid;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public SemidynamicRouteGuidance_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.newTimeToDestination_YearIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_MonthIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_DayIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_HourIsValid = false;
        this.newTimeToDestination_MinuteIsValid = false;
        this.newDistanceToDestinationIsValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$ValidityInformation semidynamicRouteGuidance_Status$ValidityInformation = (SemidynamicRouteGuidance_Status$ValidityInformation)bAPEntity;
        return this.newTimeToDestination_YearIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_YearIsAvailableToBeDisplayed && this.newTimeToDestination_MonthIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_MonthIsAvailableToBeDisplayed && this.newTimeToDestination_DayIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_DayIsAvailableToBeDisplayed && this.newTimeToDestination_HourIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_HourIsValid && this.newTimeToDestination_MinuteIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_MinuteIsValid && this.newDistanceToDestinationIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newDistanceToDestinationIsValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 5: ");
        if (this.newTimeToDestination_YearIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (NewTimeToDestination.Year is available / to be displayed");
        } else {
            stringBuffer.append("false  (NewTimeToDestination.Year is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.newTimeToDestination_MonthIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (NewTimeToDestination.Month is available / to be displayed");
        } else {
            stringBuffer.append("false  (NewTimeToDestination.Month is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.newTimeToDestination_DayIsAvailableToBeDisplayed) {
            stringBuffer.append("true  (NewTimeToDestination.Day is available / to be displayed");
        } else {
            stringBuffer.append("false  (NewTimeToDestination.Day is not available / not to be displayed");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.newTimeToDestination_HourIsValid) {
            stringBuffer.append("true  (NewTimeToDestination.Hour is valid");
        } else {
            stringBuffer.append("false  (NewTimeToDestination.Hour is not valid");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.newTimeToDestination_MinuteIsValid) {
            stringBuffer.append("true  (NewTimeToDestination.Minute is valid");
        } else {
            stringBuffer.append("false  (NewTimeToDestination.Minute is not valid");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.newDistanceToDestinationIsValid) {
            stringBuffer.append("true  (NewDistanceToDestination is valid");
        } else {
            stringBuffer.append("false  (NewDistanceToDestination is not valid");
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
        bitStream.pushBoolean(this.newTimeToDestination_YearIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_MonthIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_DayIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_HourIsValid);
        bitStream.pushBoolean(this.newTimeToDestination_MinuteIsValid);
        bitStream.pushBoolean(this.newDistanceToDestinationIsValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.newTimeToDestination_YearIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.newTimeToDestination_MonthIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.newTimeToDestination_DayIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
        this.newTimeToDestination_HourIsValid = bitStream.popFrontBoolean();
        this.newTimeToDestination_MinuteIsValid = bitStream.popFrontBoolean();
        this.newDistanceToDestinationIsValid = bitStream.popFrontBoolean();
    }
}

