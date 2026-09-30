/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.AbstractOPSDistanceControl;
import de.audi.app.earlyfunc.core.parking.ops.OPSSector;

public final class OPSSectorFactory {
    private final int leftOuterModelID;
    private final int leftInnerModelID;
    private final int rightInnerModelID;
    private final int rightOuterModelID;
    private final int leftOuterStatusModelID;
    private final int leftInnerStatusModelID;
    private final int rightInnerStatusModelID;
    private final int rightOuterStatusModelID;
    private final int errorIconStatusModelID;
    private final int leftOuterNumberSegments;
    private final int leftInnerNumberSegments;
    private final int rightInnerNumberSegments;
    private final int rightOuterNumberSegments;
    private final int range;
    public static final OPSSectorFactory FRONTAREA_WITH_CONSTANT_DIST_RANGE = new OPSSectorFactory(2100141, 2100107, 2100105, 2100109, 2100111, 2100108, 2100106, 2100110, 2100112, 6, 8, 8, 6, 15);
    public static final OPSSectorFactory REARAREA_WITH_CONSTANT_DIST_RANGE = new OPSSectorFactory(0x200BB0, 2100131, 2100129, 2100133, 2100135, 2100132, 2100130, 2100134, 2100136, 6, 11, 11, 6, 15);
    public static final OPSSectorFactory LEFTAREA_WITH_CONSTANT_DIST_RANGE = new OPSSectorFactory(0, 2100119, 2100117, 2100113, 2100115, 2100120, 2100118, 2100114, 2100116, 6, 6, 6, 6, 15);
    public static final OPSSectorFactory RIGHTAREA_WITH_CONSTANT_DIST_RANGE = new OPSSectorFactory(0, 2100127, 2100125, 2100121, 2100123, 2100128, 2100126, 2100122, 2100124, 6, 6, 6, 6, 15);

    private OPSSectorFactory(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13) {
        this.errorIconStatusModelID = n;
        this.leftOuterModelID = n2;
        this.leftInnerModelID = n3;
        this.rightInnerModelID = n4;
        this.rightOuterModelID = n5;
        this.leftOuterStatusModelID = n6;
        this.leftInnerStatusModelID = n7;
        this.rightInnerStatusModelID = n8;
        this.rightOuterStatusModelID = n9;
        this.leftOuterNumberSegments = n10;
        this.leftInnerNumberSegments = n11;
        this.rightInnerNumberSegments = n12;
        this.rightOuterNumberSegments = n13;
        this.range = 0;
    }

    private OPSSectorFactory(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14) {
        this.errorIconStatusModelID = n;
        this.leftOuterModelID = n2;
        this.leftInnerModelID = n3;
        this.rightInnerModelID = n4;
        this.rightOuterModelID = n5;
        this.leftOuterStatusModelID = n6;
        this.leftInnerStatusModelID = n7;
        this.rightInnerStatusModelID = n8;
        this.rightOuterStatusModelID = n9;
        this.leftOuterNumberSegments = n10;
        this.leftInnerNumberSegments = n11;
        this.rightInnerNumberSegments = n12;
        this.rightOuterNumberSegments = n13;
        this.range = n14;
    }

    public OPSSector createLeftOuterSector(AbstractOPSDistanceControl abstractOPSDistanceControl) {
        return new OPSSector(abstractOPSDistanceControl.getLogChannel(), abstractOPSDistanceControl.getChoiceModel(this.leftOuterStatusModelID), this.leftOuterNumberSegments, abstractOPSDistanceControl.getChoiceModel(this.leftOuterModelID), this.range);
    }

    public OPSSector createLeftInnerSector(AbstractOPSDistanceControl abstractOPSDistanceControl) {
        return new OPSSector(abstractOPSDistanceControl.getLogChannel(), abstractOPSDistanceControl.getChoiceModel(this.leftInnerStatusModelID), this.leftInnerNumberSegments, abstractOPSDistanceControl.getChoiceModel(this.leftInnerModelID), this.range);
    }

    public OPSSector createRightInnerSector(AbstractOPSDistanceControl abstractOPSDistanceControl) {
        return new OPSSector(abstractOPSDistanceControl.getLogChannel(), abstractOPSDistanceControl.getChoiceModel(this.rightInnerStatusModelID), this.rightInnerNumberSegments, abstractOPSDistanceControl.getChoiceModel(this.rightInnerModelID), this.range);
    }

    public OPSSector createRightOuterSector(AbstractOPSDistanceControl abstractOPSDistanceControl) {
        return new OPSSector(abstractOPSDistanceControl.getLogChannel(), abstractOPSDistanceControl.getChoiceModel(this.rightOuterStatusModelID), this.rightOuterNumberSegments, abstractOPSDistanceControl.getChoiceModel(this.rightOuterModelID), this.range);
    }

    public int getErrorIconStatusModelID() {
        return this.errorIconStatusModelID;
    }

    public int getLeftOuterModelID() {
        return this.leftOuterModelID;
    }

    public int getLeftInnerModelID() {
        return this.leftInnerModelID;
    }

    public int getRightInnerModelID() {
        return this.rightInnerModelID;
    }

    public int getRightOuterModelID() {
        return this.rightOuterModelID;
    }

    public int getLeftOuterStatusModelID() {
        return this.leftOuterStatusModelID;
    }

    public int getLeftInnerStatusModelID() {
        return this.leftInnerStatusModelID;
    }

    public int getRightInnerStatusModelID() {
        return this.rightInnerStatusModelID;
    }

    public int getRightOuterStatusModelID() {
        return this.rightOuterStatusModelID;
    }

    public int getLeftOuterNumberSegments() {
        return this.leftOuterNumberSegments;
    }

    public int getLeftInnerNumberSegments() {
        return this.leftInnerNumberSegments;
    }

    public int getRightInnerNumberSegments() {
        return this.rightInnerNumberSegments;
    }

    public int getRightOuterNumberSegments() {
        return this.rightOuterNumberSegments;
    }

    public int getRange() {
        return this.range;
    }
}

