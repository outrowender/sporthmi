/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow;

public abstract class MixedListItem
implements Comparable {
    private long mUID = -1L;
    protected long mDistToFinalDest;
    protected long mRttToFinalDest;
    protected int mFormat;
    private long mDistToCar;
    private long mRttToCar;
    protected MixedListRow mMixedListRow;
    protected RouteInfoHelper helper;

    protected void init(Object object, RouteInfoHandler.TravelData travelData, long l, long l2) {
        long l3 = this.helper.getDistToNextDest(object);
        int n = this.helper.getDestinationIndex(object);
        long l4 = this.helper.getRttToNextDest(object);
        this.mDistToFinalDest = this.helper.computeDistToFinalDest(l3, n, travelData);
        this.mRttToFinalDest = this.helper.computeRttToFinalDest(l4, n, travelData);
        this.setUID(this.mFormat, this.mDistToFinalDest);
        this.updateDistanceToCar(l);
        this.updateRttToCar(l2);
    }

    public int getFormat() {
        return this.mFormat;
    }

    public long getDistanceToCar() {
        return this.mDistToCar;
    }

    public long getRttToCCP() {
        return this.mRttToCar;
    }

    public long getUID() {
        return this.mUID;
    }

    public abstract Object getEvent();

    protected void setUID(int n, long l) {
        this.mUID = l == -1L ? (long)(Integer.MAX_VALUE - n) : (long)((int)l * 100 - n);
        this.mMixedListRow.setInteger(48, (int)this.mUID);
    }

    public boolean updateDistanceToCar(long l) {
        if (this.mDistToFinalDest != -1L) {
            this.mDistToCar = l - this.mDistToFinalDest;
            this.mMixedListRow.setCell(51, new TextListCell(this.helper.formatDistString(this.mDistToCar)));
            this.mMixedListRow.setCell(62, new LongListCell(this.mDistToCar));
            return true;
        }
        return false;
    }

    public boolean updateRttToCar(long l) {
        if (this.mRttToFinalDest == -1L) {
            return false;
        }
        long l2 = Math.max(l - this.mRttToFinalDest, 0L);
        if (l2 != this.mRttToCar) {
            this.mRttToCar = l2;
            long l3 = l2 * 1000L;
            this.mMixedListRow.setCell(52, new TextListCell(this.helper.formatMillisecond(l3)));
            this.mMixedListRow.setCell(63, new LongListCell(l3));
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        MixedListItem mixedListItem = (MixedListItem)object;
        return this.mUID == mixedListItem.mUID;
    }

    public int compareTo(Object object) {
        if (object == null) {
            return -1;
        }
        return (int)(((MixedListItem)object).mUID - this.mUID);
    }

    public BaseListRow toBaseListRow() {
        return new BaseListRow(this.mMixedListRow.getCopy());
    }

    public boolean isRealTurnElement() {
        return false;
    }

    public String getName() {
        return this.mMixedListRow.name;
    }

    public int[] getIconIDs() {
        return new int[0];
    }

    public boolean isBorderCrossingSpeedInfoAvailable() {
        return false;
    }

    public boolean isWithinHorizon() {
        return this.getDistanceToCar() <= 500L;
    }

    public MixedListRow getMixedListRow() {
        return this.mMixedListRow;
    }

    public boolean isAsia() {
        return false;
    }

    public int getDestinationIndex() {
        return 0;
    }
}

