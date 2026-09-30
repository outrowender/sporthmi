/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.OPSSegment;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;

public class OPSSector {
    private final ChoiceModelApp statusModel;
    private OPSSegment activeSegment;
    private int currentVisibilityStatus = 14;
    public static final int VISIBLE = 1;
    public static final int INVISIBLE = 0;
    private ArrayList segments;
    private LogChannel logChannel;
    private int constantRange = 0;
    public static final int DEFAULT_CONSTANT_RANGE = 15;
    private int lastDistanceValue;

    public OPSSector(LogChannel logChannel, ChoiceModelApp choiceModelApp, ArrayList arrayList) {
        this.logChannel = logChannel;
        this.segments = arrayList;
        this.statusModel = choiceModelApp;
    }

    public OPSSector(LogChannel logChannel, ChoiceModelApp choiceModelApp, int n, ChoiceModelApp choiceModelApp2) {
        this.logChannel = logChannel;
        this.statusModel = choiceModelApp;
        this.setConstantRange(15);
        this.segments = new ArrayList(1);
    }

    public OPSSector(LogChannel logChannel, ChoiceModelApp choiceModelApp, int n, ChoiceModelApp choiceModelApp2, int n2) {
        this.logChannel = logChannel;
        this.statusModel = choiceModelApp;
        this.setConstantRange(n2);
        this.segments = new ArrayList(n);
        this.initSegmentWithConstantRange(n, choiceModelApp2);
    }

    private void setConstantRange(int n) {
        this.constantRange = n;
        if (this.constantRange <= 0) {
            this.constantRange = 15;
        }
    }

    private void initSegmentWithConstantRange(int n, ChoiceModelApp choiceModelApp) {
        int n2 = 0;
        int n3 = this.constantRange * n;
        int n4 = 1;
        this.segments.add(new OPSSegment(n2, n3, choiceModelApp, n4));
    }

    public void applyCurrentStatusLvl(int n) {
        if (this.isVisibleStatus(n) && this.activeSegment != null) {
            this.activeSegment.setStatus(n, this.lastDistanceValue, this.constantRange);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[OPSSector#applyCurrentStatus] activeSegment='%1', statusLvl='%2', distanceModel='%3'", (Object)this.activeSegment, (Object)new Integer(n), (long)this.getDistanceModel().getID());
            }
        }
    }

    private boolean isVisibleStatus(int n) {
        this.currentVisibilityStatus = n;
        return this.isSectorVisible();
    }

    private boolean isSectorVisible() {
        if (this.currentVisibilityStatus == 14 || this.currentVisibilityStatus == 15 || this.currentVisibilityStatus == 13) {
            this.setVisibility(0);
            return false;
        }
        this.setVisibility(1);
        return true;
    }

    private void setVisibility(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[OPSSector#setVisibility] visibility='%1', currentVisibilityStatus='%2', activeSegment='%3', statusModel='%4'", (Object)new Integer(n), (Object)new Integer(this.currentVisibilityStatus), (Object)this.activeSegment, (long)this.statusModel.getID());
        }
        this.statusModel.setValue(n);
    }

    public void hide() {
        if (this.statusModel.getValue() != 0) {
            this.setVisibility(0);
        }
    }

    public void show() {
        if (this.statusModel.getValue() != 1 && this.currentVisibilityStatus != 14) {
            this.setVisibility(1);
        }
    }

    public ChoiceModelApp getStatusModel() {
        return this.statusModel;
    }

    public void applyDistanceValue(int n) {
        this.lastDistanceValue = n;
        this.setActiveSegment(n);
        this.isSectorVisible();
        this.applyCurrentStatusLvl(this.currentVisibilityStatus);
    }

    private void setActiveSegment(int n) {
        Iterator iterator = this.segments.iterator();
        while (iterator.hasNext()) {
            OPSSegment oPSSegment = (OPSSegment)iterator.next();
            if (!oPSSegment.isActive(n, this.segments.size(), this.constantRange)) continue;
            this.activeSegment = oPSSegment;
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[OPSSector#setActiveSegment] activeSegment='%1', updatedDistValue='%2', distanceModel='%3'", (Object)this.activeSegment, (Object)new Integer(n), (long)this.getDistanceModel().getID());
            }
            return;
        }
        this.activeSegment = null;
    }

    public ChoiceModelApp getDistanceModel() {
        return ((OPSSegment)this.segments.get(0)).getDistanceModel();
    }
}

