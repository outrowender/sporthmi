/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.core.boardbook.BoardbookFilePlayerSession;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.esolutions.fw.util.commons.Buffer;

public class BoardbookHandler
implements IBrowserCallbackHandler,
ButtonListener {
    public static final int VIDEO_START_PLAY = 1;
    public static final int VIDEO_FINISHED = 0;
    public static final String[] SUPPORTED_VIDEO_MIME_TYPES = new String[]{"video/x-msvideo", "audio/midi", "video/mpeg", "audio/ogg"};
    private ViewSizeHelper viewSizeListener = new ViewSizeHelper();
    private IViewSizeManager viewSizeService;
    private ButtonModelApp errorButtonModel;
    private ChoiceModelApp errorChoiceModel;
    protected final LogChannel logChannel;
    private IMediaFilePlayerService mediaService;
    private final BoardbookFilePlayerSession currentSession;
    private ChoiceModelApp displayContextModel;
    IBrowserHandler browserHandler;
    private ButtonModelApp buttonPause;
    private LabelModelApp titleVideo;
    private LabelModelApp timeRemaining;
    private LabelModelApp timePlayed;
    private RangeModelApp progress;
    private HMIService hmiService;
    private IFrameworkAccess fwAccess;
    private boolean isVideoLoading = false;

    public BoardbookHandler(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.fwAccess = iFrameworkAccess;
        this.logChannel = logChannel;
        this.hmiService = iFrameworkAccess.getHMIService();
        this.currentSession = new BoardbookFilePlayerSession(logChannel, this, iFrameworkAccess.getScreenRes(), iFrameworkAccess.isEvoHighMMIKombi());
        this.hmiService.getButtonModel(601217).setButtonListener(this);
    }

    public void initializeModels(ButtonModelApp buttonModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, LabelModelApp labelModelApp2, LabelModelApp labelModelApp3, RangeModelApp rangeModelApp) {
        this.buttonPause = buttonModelApp;
        this.displayContextModel = choiceModelApp;
        this.titleVideo = labelModelApp;
        this.timeRemaining = labelModelApp2;
        this.timePlayed = labelModelApp3;
        this.progress = rangeModelApp;
        if (this.buttonPause != null) {
            this.buttonPause.setButtonListener(this);
        }
        if (this.displayContextModel != null) {
            this.displayContextModel.setValue(0);
        }
    }

    public void setErrorButtonModel(ButtonModelApp buttonModelApp) {
        if (this.errorButtonModel != null) {
            this.errorButtonModel.setButtonListener(null);
        }
        this.errorButtonModel = buttonModelApp;
        this.errorButtonModel.setButtonListener(this);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1000000, "BoardbookHandler#keyTyped: model %1, keyId %2", (long)n, (long)n2);
        if (n == 601217) {
            this.logChannel.log(1000000, "BoardbookHandler#keyTyped: Virtual Button Pressed");
            if (n2 == 15) {
                this.logChannel.log(1000000, "BoardbookHandler#keyTyped: Virtual Button HK Return was pressed");
                this.returnFromVideoToBoardbook();
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void setErrorChoiceModel(ChoiceModelApp choiceModelApp) {
        this.errorChoiceModel = choiceModelApp;
    }

    private void setErrorChoiceModelValue(int n) {
        if (this.errorChoiceModel != null) {
            this.logChannel.log(10000000, "BoardbookBrowserHandler#setErrorChoiceModelValue: %1", (long)n);
            this.errorChoiceModel.setValue(n);
        }
    }

    private void setErrorChoiceModelStatus(int n) {
        if (this.errorChoiceModel != null) {
            this.logChannel.log(10000000, "BoardbookBrowserHandler#setErrorChoiceModelStatus: %1", (long)n);
            this.errorChoiceModel.setStatus(n);
        }
    }

    public void indicateBrowserStateNotFound() {
        if (this.errorChoiceModel != null) {
            this.setErrorChoiceModelStatus(2);
            this.setErrorChoiceModelValue(2);
        }
    }

    public void indicateBrowserStateComplete() {
        if (this.errorChoiceModel != null) {
            this.setErrorChoiceModelStatus(1);
            this.setErrorChoiceModelValue(1);
        }
    }

    public void handleVideo(String string, String string2) {
        this.logChannel.log(1000000, "BoardbookHandler#handleVideo url %1, description \"%2\"", (Object)string, (Object)string2);
        if (this.viewSizeService != null && this.viewSizeService.getCurrentViewSize() == 1) {
            this.logChannel.log(1000000, "BoardbookHandler#handleVideo() display manager is in SMALL Stage View...aborting");
            return;
        }
        String string3 = string2;
        if (string3 == null) {
            string3 = "";
        }
        if (this.titleVideo != null) {
            this.titleVideo.setText(string3);
        }
        if (this.displayContextModel != null) {
            this.displayContextModel.setValue(0);
        }
        if (this.mediaService != null) {
            this.mediaService.close(this.currentSession);
            this.currentSession.setPlaybackUrl(string);
            this.updatePlayPosition(0, 0);
            this.mediaService.open(this.currentSession);
        } else {
            this.logChannel.log(10000, "BoardbookHandler#handleVideo no media service");
        }
    }

    protected void returnFromVideoToBoardbook() {
        this.logChannel.log(1000000, "BoardbookHandler#returnFromVideoToBoardbook: closing session and invoking event");
        if (this.mediaService != null) {
            this.logChannel.log(10000000, "BoardbookHandler#returnFromVideoToBoardbook: closing session");
            this.mediaService.close(this.currentSession);
        }
        this.hmiService.getChoiceModel(601033).setValue(0);
    }

    public void setMediaService(IMediaFilePlayerService iMediaFilePlayerService) {
        this.logChannel.log(1000000, "BoardbookHandler#setMediaService called");
        if (iMediaFilePlayerService != null) {
            this.mediaService = iMediaFilePlayerService;
        }
    }

    public boolean scrollDown(int n) {
        return false;
    }

    public boolean scrollUp(int n) {
        return false;
    }

    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(1000000, "BoardbookHandler#updatePlayPosition %1 %2", (long)n, (long)n2);
        if (this.progress != null) {
            this.progress.setLimits(0, n2, 1);
            this.progress.setValue(n);
        }
        String string = this.formatSeconds(n2 - n, true);
        if (this.timeRemaining != null) {
            this.timeRemaining.setText(string);
        }
        String string2 = this.formatSeconds(n, false);
        if (this.timePlayed != null) {
            this.timePlayed.setText(string2);
        }
        this.setVideoLoading(true);
    }

    private String formatSeconds(int n, boolean bl) {
        Buffer buffer = new Buffer();
        if (bl) {
            buffer.append("-");
        }
        buffer.append(n / 60);
        buffer.append(":");
        int n2 = n % 60;
        if (n2 < 10) {
            buffer.append("0");
        }
        buffer.append(n2);
        return buffer.toString();
    }

    public void startMediaPlayback() {
        this.logChannel.log(1000000, "BoardbookHandler#startMediaPlayback: called");
    }

    public ChoiceModelApp getDisplayContextModel() {
        return this.displayContextModel;
    }

    public boolean indicateEfiUrl(String string) {
        return false;
    }

    public void belowLowerThreshold(int n) {
    }

    public void exceedsUpperThreshold(int n) {
    }

    public void indicateBrowserStateTimeout() {
    }

    public void javascriptAlert(String string) {
    }

    public boolean press() {
        this.logChannel.log(10000000, "BoardbookHandler#press DDS Enter pressed!");
        if (this.hmiService.getChoiceModel(601033).getValue() == 0) {
            this.logChannel.log(1000000, "BoardbookHandler#press Video finished! %1", (long)this.hmiService.getChoiceModel(601033).getValue());
            return false;
        }
        this.hmiService.getVirtualButtonModel(601444).fireEvent(0);
        return true;
    }

    public void indicateBoardbookAvailable(boolean bl) {
        this.logChannel.log(1000000, "BoardbookHandler#indicateBoardbookAvailable %1", bl);
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        this.browserHandler = iBrowserHandler;
    }

    public void setViewSizeService(IViewSizeManager iViewSizeManager) {
        this.viewSizeService = iViewSizeManager;
        this.viewSizeService.addViewSizeListener(this.viewSizeListener);
    }

    public void triggerScreenChangeToVideo() {
        this.logChannel.log(10000000, "BoardbookHandler#triggerScreenChangeToVideo: called");
        this.hmiService.getChoiceModel(601033).setValue(1);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "BoardbookHandler#keyPressed: modelID: %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(10000000, "BoardbookHandler#keyReleased: modelID: %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "BoardbookHandler#updateScrollbarX: pageContentWidth: %1, visibleAreaWidth %2, scrollPositionX %3", (long)n, (long)n2, (long)n3);
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "BoardbookHandler#updateScrollbarY: pageContentHeight: %1, visibleAreaHeight %2, scrollPositionY %3", (long)n, (long)n2, (long)n3);
    }

    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(10000000, "BoardbookHandler#updateBrowserStateBusy: busy: %1", bl);
    }

    public void updateBrowserState(int n) {
        this.logChannel.log(10000000, "BoardbookHandler#updateBrowserState: busy: %1", (long)n);
    }

    public void virtualButtonBack() {
        this.logChannel.log(10000000, "BoardbookHandler#virtualButtonBack: called");
    }

    public void setVideoLoading(boolean bl) {
        this.isVideoLoading = bl;
        this.logChannel.log(10000000, "BoardbookHandler#setVideoLoading: %1", this.isVideoLoading);
    }

    public boolean isVideoLoading() {
        this.logChannel.log(10000000, "BoardbookHandler#isVideoLoading: %1", this.isVideoLoading);
        return this.isVideoLoading;
    }

    class ViewSizeHelper
    implements IViewSizeListener {
        ViewSizeHelper() {
        }

        public void viewSizeChanged(int n) {
            BoardbookHandler.this.logChannel.log(1000000, "BoardbookHandler#ViewSizeListener#viewSizeChanged() to %1", (long)n);
            if (BoardbookHandler.this.currentSession == null) {
                return;
            }
            if (n == 1) {
                BoardbookHandler.this.logChannel.log(10000000, "BoardbookHandler#viewSizeChanged to SMALL. Session paused");
                BoardbookHandler.this.currentSession.pause();
            } else if (n == 2) {
                BoardbookHandler.this.logChannel.log(10000000, "BoardbookHandler#viewSizeChanged to LARGE and Session isPaused: resuming");
                BoardbookHandler.this.currentSession.resume();
            }
        }
    }
}

