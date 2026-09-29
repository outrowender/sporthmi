/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

public class ConsumerListHandler$ConsumerListEntry {
    public static final int HMI_CONSUMER_LIST_ENTRY_UNDEFINED;
    public static final int HMI_CONSUMER_LIST_ENTRY_CLIMATECONTROLUNIT;
    public static final int HMI_CONSUMER_LIST_ENTRY_AUXHEATER;
    public static final int HMI_CONSUMER_LIST_ENTRY_REARWINDOWHEATER;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGFRONTLEFT;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGFRONTRIGHT;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONFRONTLEFT;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONFRONTRIGHT;
    public static final int HMI_CONSUMER_LIST_ENTRY_NECKHEATINGLEFT;
    public static final int HMI_CONSUMER_LIST_ENTRY_NECKHEATINGRIGHT;
    public static final int HMI_CONSUMER_LIST_ENTRY_FOGLIGHTFRONT;
    public static final int HMI_CONSUMER_LIST_ENTRY_FOGLIGHTREAR;
    public static final int HMI_CONSUMER_LIST_ENTRY_FRONTWINDOWHEATING;
    public static final int HMI_CONSUMER_LIST_ENTRY_STEERINGWHEELHEATING;
    public static final int HMI_CONSUMER_LIST_ENTRY_MIRRORHEATING;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGREAR;
    public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONREAR;
    public static final int HMI_CONSUMER_LIST_ENTRY_220VPLUGIN;
    public static final int HMI_CONSUMER_LIST_ENTRY_THERMOCUPHOLDER;
    final String consumerName;
    final int hmiConsumerID;

    public ConsumerListHandler$ConsumerListEntry(String string, int n) {
        this.consumerName = string;
        this.hmiConsumerID = n;
    }

    public String getConsumerName() {
        return this.consumerName;
    }

    public int getHmiConsumerID() {
        return this.hmiConsumerID;
    }

    public static ConsumerListHandler$ConsumerListEntry mapDSIConsumerToListEntry(int n) {
        if (n == 1) {
            return new ConsumerListHandler$ConsumerListEntry("Climate Control Unit", 0);
        }
        if (n == 2) {
            return new ConsumerListHandler$ConsumerListEntry("Aux Heater", 1);
        }
        if (n == 3) {
            return new ConsumerListHandler$ConsumerListEntry("Rear Window Heater", 2);
        }
        if (n == 4) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Heating Front Left", 3);
        }
        if (n == 5) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Heating Front Right", 4);
        }
        if (n == 6) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Ventilation Front Left", 5);
        }
        if (n == 7) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Ventilation Front Right", 6);
        }
        if (n == 8) {
            return new ConsumerListHandler$ConsumerListEntry("Neck Heating Left", 7);
        }
        if (n == 9) {
            return new ConsumerListHandler$ConsumerListEntry("Neck Heating Right", 8);
        }
        if (n == 10) {
            return new ConsumerListHandler$ConsumerListEntry("Fog Light Front", 9);
        }
        if (n == 11) {
            return new ConsumerListHandler$ConsumerListEntry("Fog Light Rear", 10);
        }
        if (n == 12) {
            return new ConsumerListHandler$ConsumerListEntry("Front Window Heating", 11);
        }
        if (n == 13) {
            return new ConsumerListHandler$ConsumerListEntry("Steering Wheel Heating", 12);
        }
        if (n == 14) {
            return new ConsumerListHandler$ConsumerListEntry("Mirror Heating", 13);
        }
        if (n == 15) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Heating Rear", 14);
        }
        if (n == 16) {
            return new ConsumerListHandler$ConsumerListEntry("Seat Ventilation Rear", 15);
        }
        if (n == 17) {
            return new ConsumerListHandler$ConsumerListEntry("220V Plugin", 16);
        }
        if (n == 18) {
            return new ConsumerListHandler$ConsumerListEntry("Thermo Cupholder", 17);
        }
        return new ConsumerListHandler$ConsumerListEntry("Undefined Consumer", -1);
    }
}

