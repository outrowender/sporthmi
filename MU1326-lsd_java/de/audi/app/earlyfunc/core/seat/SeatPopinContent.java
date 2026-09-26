/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent$SeatMemoryDetail;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;

public class SeatPopinContent {
    private MasterSeatPopinContent masterContentFrontLeft;
    private MasterSeatPopinContent masterContentFrontRight;
    private MasterSeatPopinContent$SeatMemoryDetail memoryDetailFrontLeft;
    private MasterSeatPopinContent$SeatMemoryDetail memoryDetailFrontRight;
    private int cancelReason = 1;
    private boolean pneumaticSeatContent = false;

    public SeatPopinContent() {
        this.masterContentFrontLeft = MasterSeatPopinContent.NONE;
        this.masterContentFrontRight = MasterSeatPopinContent.NONE;
        this.memoryDetailFrontLeft = MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE;
        this.memoryDetailFrontRight = MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE;
    }

    public SeatPopinContent(SeatContent seatContent) {
        this.masterContentFrontLeft = MasterSeatPopinContent.getContentForID(seatContent.getContent1RL());
        this.masterContentFrontRight = MasterSeatPopinContent.getContentForID(seatContent.getContent1RR());
        this.memoryDetailFrontLeft = MasterSeatPopinContent$SeatMemoryDetail.getMemoryDetailForID(seatContent.getMemoryDetail1RL());
        this.memoryDetailFrontRight = MasterSeatPopinContent$SeatMemoryDetail.getMemoryDetailForID(seatContent.getMemoryDetail1RR());
        this.pneumaticSeatContent = false;
    }

    public SeatPopinContent(SeatPneumaticContent seatPneumaticContent) {
        this.masterContentFrontLeft = MasterSeatPopinContent.getContentForID(seatPneumaticContent.getContent1RL());
        this.masterContentFrontRight = MasterSeatPopinContent.getContentForID(seatPneumaticContent.getContent1RR());
        this.memoryDetailFrontLeft = MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE;
        this.memoryDetailFrontRight = MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE;
        this.pneumaticSeatContent = true;
    }

    public void setContent(boolean bl, MasterSeatPopinContent masterSeatPopinContent, MasterSeatPopinContent$SeatMemoryDetail masterSeatPopinContent$SeatMemoryDetail) {
        this.setMasterContent(bl, masterSeatPopinContent);
        this.setMemoryDetail(bl, masterSeatPopinContent$SeatMemoryDetail);
    }

    public void setMasterContent(boolean bl, MasterSeatPopinContent masterSeatPopinContent) {
        if (bl) {
            this.setMasterContentFrontLeft(masterSeatPopinContent);
        } else {
            this.setMasterContentFrontRight(masterSeatPopinContent);
        }
    }

    public void setMemoryDetail(boolean bl, MasterSeatPopinContent$SeatMemoryDetail masterSeatPopinContent$SeatMemoryDetail) {
        if (bl) {
            this.setMemoryDetailFrontLeft(masterSeatPopinContent$SeatMemoryDetail);
        } else {
            this.setMemoryDetailFrontRight(masterSeatPopinContent$SeatMemoryDetail);
        }
    }

    public void setMemoryDetail(boolean bl, int n) {
        if (bl) {
            this.setMemoryDetailFrontLeft(n);
        } else {
            this.setMemoryDetailFrontRight(n);
        }
    }

    public int getMasterContentFrontLeftID() {
        return this.masterContentFrontLeft.getSeatContentID();
    }

    public int getMasterContentID(boolean bl) {
        return bl ? this.getMasterContentFrontLeftID() : this.getMasterContentFrontRightID();
    }

    public void setMasterContentFrontLeft(int n) {
        this.masterContentFrontLeft = MasterSeatPopinContent.getContentForID(n);
    }

    public void setMasterContentFrontLeft(MasterSeatPopinContent masterSeatPopinContent) {
        this.masterContentFrontLeft = masterSeatPopinContent;
    }

    public int getMasterContentFrontRightID() {
        return this.masterContentFrontRight.getSeatContentID();
    }

    public MasterSeatPopinContent getMasterContentFrontLeft() {
        return this.masterContentFrontLeft;
    }

    public MasterSeatPopinContent getMasterContentFrontRight() {
        return this.masterContentFrontRight;
    }

    public void setMasterContentFrontRight(int n) {
        this.masterContentFrontRight = MasterSeatPopinContent.getContentForID(n);
    }

    public void setMasterContentFrontRight(MasterSeatPopinContent masterSeatPopinContent) {
        this.masterContentFrontRight = masterSeatPopinContent;
    }

    public MasterSeatPopinContent getMasterContent(boolean bl) {
        return bl ? this.getMasterContentFrontLeft() : this.getMasterContentFrontRight();
    }

    public MasterSeatPopinContent$SeatMemoryDetail getMemoryDetail(boolean bl) {
        return bl ? this.getMemoryDetailFrontLeft() : this.getMemoryDetailFrontRight();
    }

    public MasterSeatPopinContent$SeatMemoryDetail getMemoryDetailFrontLeft() {
        return this.memoryDetailFrontLeft;
    }

    public void setMemoryDetailFrontLeft(MasterSeatPopinContent$SeatMemoryDetail masterSeatPopinContent$SeatMemoryDetail) {
        this.memoryDetailFrontLeft = masterSeatPopinContent$SeatMemoryDetail;
    }

    public MasterSeatPopinContent$SeatMemoryDetail getMemoryDetailFrontRight() {
        return this.memoryDetailFrontRight;
    }

    public void setMemoryDetailFrontRight(MasterSeatPopinContent$SeatMemoryDetail masterSeatPopinContent$SeatMemoryDetail) {
        this.memoryDetailFrontRight = masterSeatPopinContent$SeatMemoryDetail;
    }

    public int getMemoryDetailIDFrontLeft() {
        return this.memoryDetailFrontLeft.getMemoryDetailID();
    }

    public void setMemoryDetailFrontLeft(int n) {
        this.memoryDetailFrontLeft = MasterSeatPopinContent$SeatMemoryDetail.getMemoryDetailForID(n);
    }

    public int getMemoryDetailIDFrontRight() {
        return this.memoryDetailFrontRight.getMemoryDetailID();
    }

    public void setMemoryDetailFrontRight(int n) {
        this.memoryDetailFrontRight = MasterSeatPopinContent$SeatMemoryDetail.getMemoryDetailForID(n);
    }

    public int getCancelReason() {
        return this.cancelReason;
    }

    protected void setCancelReason(int n) {
        if (n == 1 || n == 0) {
            this.cancelReason = n;
        }
    }

    public void setCancelReasonToASG() {
        this.cancelReason = 1;
    }

    public void setCancelReasonToFSG() {
        this.cancelReason = 0;
    }

    public boolean isPneumaticSeatContent() {
        return this.pneumaticSeatContent;
    }

    public void setPneumaticSeatContent(boolean bl) {
        this.pneumaticSeatContent = bl;
    }

    public SeatContent getDSISeatContent() {
        return new SeatContent(this.getMasterContentFrontLeftID(), this.getMemoryDetailIDFrontLeft(), this.getMasterContentFrontRightID(), this.getMemoryDetailIDFrontRight());
    }

    public SeatPneumaticContent getDSISeatPneumaticContent() {
        return new SeatPneumaticContent(this.getMasterContentFrontLeftID(), this.getMasterContentFrontRightID());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SeatPopinContent(masterContentFrontLeft='");
        stringBuffer.append(this.masterContentFrontLeft.toString());
        stringBuffer.append("',memoryDetailFrontLeft='");
        stringBuffer.append(this.memoryDetailFrontLeft.toString());
        stringBuffer.append("',masterContentFrontRight='");
        stringBuffer.append(this.masterContentFrontRight.toString());
        stringBuffer.append("',memoryDetailFrontRight='");
        stringBuffer.append(this.memoryDetailFrontRight.toString());
        stringBuffer.append("',cancelReason='");
        stringBuffer.append(this.cancelReason == 1 ? "ASG" : "FSG");
        stringBuffer.append("',pneumaticSeatContent='");
        stringBuffer.append(this.pneumaticSeatContent);
        stringBuffer.append("')");
        return stringBuffer.toString();
    }

    public boolean equalsSeatPopinContent(SeatPopinContent seatPopinContent) {
        return this.masterContentFrontLeft.equalsMasterSeatPopinContent(seatPopinContent.getMasterContentFrontLeft()) && this.masterContentFrontRight.equalsMasterSeatPopinContent(seatPopinContent.getMasterContentFrontRight()) && this.memoryDetailFrontLeft.equalsSeatMemoryDetail(seatPopinContent.getMemoryDetailFrontLeft()) && this.memoryDetailFrontRight.equalsSeatMemoryDetail(seatPopinContent.getMemoryDetailFrontRight()) && this.isPneumaticSeatContent() == seatPopinContent.isPneumaticSeatContent();
    }

    public boolean equals(Object object) {
        return object instanceof SeatPopinContent && this.equalsSeatPopinContent((SeatPopinContent)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.masterContentFrontLeft == null ? 0 : this.masterContentFrontLeft.hashCode());
        n = 31 * n + (this.masterContentFrontRight == null ? 0 : this.masterContentFrontRight.hashCode());
        n = 31 * n + (this.memoryDetailFrontLeft == null ? 0 : this.memoryDetailFrontLeft.hashCode());
        n = 31 * n + (this.memoryDetailFrontRight == null ? 0 : this.memoryDetailFrontRight.hashCode());
        n = 31 * n + (this.pneumaticSeatContent ? 1231 : 1237);
        return n;
    }
}

