/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent$SeatMemoryDetail;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;

public abstract class AbstractSeatPopin {
    protected static final int STATE_INVISIBLE;
    protected static final int STATE_REQUESTED;
    protected static final int STATE_SHOWN;
    protected final SeatPopinContent currentContent;
    private final ISeatPopupController popinController;
    private final int hmiPopinID;
    private final boolean isLeft;
    private final SeatPopinConfigurationHandler config;
    private final LogChannel logChannel;
    private int state = 0;
    protected SeatPopinContent lastUpdatedContent;

    protected AbstractSeatPopin(int n, SeatPopinConfigurationHandler seatPopinConfigurationHandler, boolean bl, ISeatPopupController iSeatPopupController) {
        this.hmiPopinID = n;
        this.isLeft = bl;
        this.popinController = iSeatPopupController;
        this.logChannel = iSeatPopupController.getLogChannel();
        this.config = seatPopinConfigurationHandler;
        this.lastUpdatedContent = new SeatPopinContent();
        this.currentContent = new SeatPopinContent();
    }

    protected SeatPopinConfigurationHandler getConfig() {
        return this.config;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    public int getHmiPopinID() {
        return this.hmiPopinID;
    }

    public boolean isState(int n) {
        return this.state == n;
    }

    protected void setState(int n) {
        this.state = n == 1 || n == 2 ? n : 0;
    }

    public SeatPopinContent getLastUpdatedContent() {
        return this.lastUpdatedContent;
    }

    private boolean isContentAvailable(SeatPopinContent seatPopinContent) {
        boolean bl = this.getConfig().isContentAvailable(this.isLeft(), seatPopinContent);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[%1#isContentAvailable] content('%2') is %3", (Object)this, (Object)seatPopinContent, (Object)(bl ? "available" : "not available"));
        }
        return bl;
    }

    public SeatPopinContent getCurrentContent() {
        return this.currentContent;
    }

    protected ISeatPopupController getPopinController() {
        return this.popinController;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(45);
        stringBuffer.append(this.getClassName());
        stringBuffer.append("('");
        stringBuffer.append(this.getHmiPopinID());
        stringBuffer.append("','");
        stringBuffer.append(this.isLeft() ? "left" : "right");
        stringBuffer.append("')");
        return stringBuffer.toString();
    }

    public boolean supportsContent(SeatPopinContent seatPopinContent) {
        if (this.isResponsibleForContent(seatPopinContent)) {
            boolean bl = this.getConfig().isContentAvailable(this.isLeft(), seatPopinContent);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[%1#supportsContent] is responsible for seatContent='%2': content is %3", (Object)this, (Object)seatPopinContent, (Object)(bl ? "available" : "not available"));
            }
            return bl;
        }
        return false;
    }

    public boolean processHiddenNotification(int n) {
        if (n == this.getHmiPopinID()) {
            if (this.state == 2) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[%1#processHiddenNotification] cancel popin: cancelContent='%2'", (Object)this, (Object)this.currentContent);
                }
                this.currentContent.setCancelReasonToASG();
                this.getPopinController().cancelPopup(this.currentContent, this);
                this.resetResponsibleContent(this.currentContent);
                this.resetResponsibleContent(this.lastUpdatedContent);
                this.setState(0);
                return true;
            }
            if (this.isState(1)) {
                SeatPopinContent seatPopinContent = new SeatPopinContent();
                seatPopinContent.setPneumaticSeatContent(this.currentContent.isPneumaticSeatContent());
                this.getPopinController().sendShowPopupResponse(seatPopinContent, this.currentContent, this);
                this.resetContent(this.currentContent);
                this.resetResponsibleContent(this.lastUpdatedContent);
                this.setState(0);
                return true;
            }
        }
        return false;
    }

    public void processHiddenNotification() {
        if (this.isState(2)) {
            this.currentContent.setCancelReasonToFSG();
            this.getPopinController().cancelPopup(this.currentContent, this);
            this.resetResponsibleContent(this.currentContent);
            this.resetResponsibleContent(this.lastUpdatedContent);
        } else if (this.isState(1)) {
            SeatPopinContent seatPopinContent = new SeatPopinContent();
            seatPopinContent.setPneumaticSeatContent(this.currentContent.isPneumaticSeatContent());
            this.getPopinController().sendShowPopupResponse(seatPopinContent, this.currentContent, this);
            this.resetContent(this.currentContent);
            this.resetResponsibleContent(this.lastUpdatedContent);
        }
        this.setState(0);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[%1#processHiddenNotification] seat popin is invisible", (Object)this);
        }
    }

    public void processVisibleNotification() {
        if (this.isState(1)) {
            SeatPopinContent seatPopinContent = new SeatPopinContent();
            this.copyResponsibleContent(this.currentContent, seatPopinContent);
            this.getPopinController().sendShowPopupResponse(seatPopinContent, this.currentContent, this);
        }
        this.currentContent.setContent(!this.isLeft(), MasterSeatPopinContent.NONE, MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
        if (!this.isNoneContent(this.lastUpdatedContent)) {
            this.copyResponsibleContent(this.lastUpdatedContent, this.currentContent);
            this.resetContent(this.lastUpdatedContent);
        }
        this.setState(2);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[%1#processVisibleNotification] seat popin is visible: shownContent='%2' ", (Object)this, (Object)this.currentContent);
        }
    }

    public void updateContent(SeatPopinContent seatPopinContent) {
        if (this.isResponsibleForContent(seatPopinContent)) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[%1#updateContent] popin is responsible for updated content('%2').", (Object)this, (Object)seatPopinContent);
            }
            if (this.isContentAvailable(seatPopinContent) && !this.isNoneContent(seatPopinContent)) {
                this.handleAvailableContentUpdate(seatPopinContent);
            }
        }
    }

    private void handleAvailableContentUpdate(SeatPopinContent seatPopinContent) {
        this.fillContentModel(seatPopinContent);
        if (this.isState(2)) {
            this.copyResponsibleContent(seatPopinContent, this.currentContent);
        } else if (this.isState(1)) {
            this.copyResponsibleContent(seatPopinContent, this.lastUpdatedContent);
        } else {
            this.showPartialPopinAfterSupportedContentUpdate(seatPopinContent);
        }
    }

    public void requestPopin(SeatPopinContent seatPopinContent) {
        if (this.isResponsibleForContent(seatPopinContent)) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[%1#requestPopin] popin is responsible for requested content('%2').", (Object)this, (Object)seatPopinContent);
            }
            this.handleSupportedContentRequest(seatPopinContent);
        } else {
            this.handleUnsupportedContentRequest(seatPopinContent);
        }
    }

    private void handleSupportedContentRequest(SeatPopinContent seatPopinContent) {
        if (this.isContentAvailable(seatPopinContent)) {
            if (this.isNoneContent(seatPopinContent)) {
                this.handleNoneContentRequest(seatPopinContent);
            } else {
                this.handleAvailableContentRequest(seatPopinContent);
            }
        } else {
            this.handleUnavailableContentRequest(seatPopinContent);
        }
    }

    private void handleNoneContentRequest(SeatPopinContent seatPopinContent) {
        if (!this.isState(0)) {
            this.getPopinController().hideSeatPopup(this);
        }
    }

    private void handleAvailableContentRequest(SeatPopinContent seatPopinContent) {
        if (this.isState(1)) {
            this.fillContentModel(seatPopinContent);
            this.copyResponsibleContent(seatPopinContent, this.lastUpdatedContent);
        } else if (this.isState(2)) {
            this.handleAvailableContentUpdate(seatPopinContent);
            SeatPopinContent seatPopinContent2 = new SeatPopinContent();
            this.copyResponsibleContent(seatPopinContent, seatPopinContent2);
            if (!MasterSeatPopinContent.NONE.equals(seatPopinContent.getMasterContent(!this.isLeft()))) {
                this.getPopinController().sendShowPopupResponse(seatPopinContent2, seatPopinContent, this);
            }
        } else {
            this.updateAvailabilityModels();
            this.fillContentModel(seatPopinContent);
            this.copyContent(seatPopinContent, this.currentContent);
            this.getPopinController().displaySeatPopup(this);
            this.setState(1);
        }
    }

    private void handleUnavailableContentRequest(SeatPopinContent seatPopinContent) {
        SeatPopinContent seatPopinContent2 = new SeatPopinContent();
        seatPopinContent2.setPneumaticSeatContent(seatPopinContent.isPneumaticSeatContent());
        this.getPopinController().sendShowPopupResponse(seatPopinContent2, seatPopinContent, this);
    }

    private void handleUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
        if (!this.isNoneContent(seatPopinContent) && this.discardCurrentContentAfterUnsupportedContentRequest(seatPopinContent)) {
            if (this.isState(1)) {
                SeatPopinContent seatPopinContent2 = new SeatPopinContent();
                seatPopinContent2.setPneumaticSeatContent(seatPopinContent.isPneumaticSeatContent());
                this.resetResponsibleContent(this.lastUpdatedContent);
                this.getPopinController().sendShowPopupResponse(seatPopinContent2, seatPopinContent, this);
                this.resetContent(this.currentContent);
            } else if (this.isState(2)) {
                this.getPopinController().cancelPopup(this.currentContent, this);
                this.resetResponsibleContent(this.currentContent);
                this.resetResponsibleContent(this.lastUpdatedContent);
            }
            this.setState(0);
        }
    }

    protected void copyContent(SeatPopinContent seatPopinContent, SeatPopinContent seatPopinContent2) {
        seatPopinContent2.setContent(true, seatPopinContent.getMasterContent(true), seatPopinContent.getMemoryDetail(true));
        seatPopinContent2.setContent(false, seatPopinContent.getMasterContent(false), seatPopinContent.getMemoryDetail(false));
        seatPopinContent2.setPneumaticSeatContent(seatPopinContent.isPneumaticSeatContent());
    }

    protected void copyResponsibleContent(SeatPopinContent seatPopinContent, SeatPopinContent seatPopinContent2) {
        seatPopinContent2.setContent(this.isLeft(), seatPopinContent.getMasterContent(this.isLeft()), seatPopinContent.getMemoryDetail(this.isLeft()));
        seatPopinContent2.setPneumaticSeatContent(seatPopinContent.isPneumaticSeatContent());
    }

    protected boolean isNoneContent(SeatPopinContent seatPopinContent) {
        return MasterSeatPopinContent.NONE.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(this.isLeft()));
    }

    protected void resetResponsibleContent(SeatPopinContent seatPopinContent) {
        seatPopinContent.setContent(this.isLeft(), MasterSeatPopinContent.NONE, MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    protected void resetContent(SeatPopinContent seatPopinContent) {
        seatPopinContent.setContent(true, MasterSeatPopinContent.NONE, MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
        seatPopinContent.setContent(false, MasterSeatPopinContent.NONE, MasterSeatPopinContent$SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    public abstract String getClassName() {
    }

    protected abstract boolean isResponsibleForContent(SeatPopinContent seatPopinContent) {
    }

    protected abstract void fillContentModel(SeatPopinContent seatPopinContent) {
    }

    protected abstract void showPartialPopinAfterSupportedContentUpdate(SeatPopinContent seatPopinContent) {
    }

    protected abstract boolean discardCurrentContentAfterUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
    }

    public abstract void updateAvailabilityModels() {
    }
}

