/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.core.boardbook.BoardbookFilePlayerSession;
import de.audi.app.car.core.boardbook.BoardbookHandler$ViewSizeHelper;
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
import de.audi.atip.mmicombi.IViewSizeManager;
import de.esolutions.fw.util.commons.Buffer;

public class BoardbookHandler
implements IBrowserCallbackHandler,
ButtonListener {
    public static final int VIDEO_START_PLAY;
    public static final int VIDEO_FINISHED;
    public static final String[] SUPPORTED_VIDEO_MIME_TYPES;
    private BoardbookHandler$ViewSizeHelper viewSizeListener = new BoardbookHandler$ViewSizeHelper(this);
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
        this.hmiService.getButtonModel(-2127820544).setButtonListener(this);
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

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "BoardbookHandler#keyTyped: model %1, keyId %2", (long)n, (long)n2);
        if (n == -2127820544) {
            this.logChannel.log(1078071040, "BoardbookHandler#keyTyped: Virtual Button Pressed");
            if (n2 == 15) {
                this.logChannel.log(1078071040, "BoardbookHandler#keyTyped: Virtual Button HK Return was pressed");
                this.returnFromVideoToBoardbook();
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void setErrorChoiceModel(ChoiceModelApp choiceModelApp) {
        this.errorChoiceModel = choiceModelApp;
    }

    private void setErrorChoiceModelValue(int n) {
        if (this.errorChoiceModel != null) {
            this.logChannel.log(-2137614336, "BoardbookBrowserHandler#setErrorChoiceModelValue: %1", (long)n);
            this.errorChoiceModel.setValue(n);
        }
    }

    private void setErrorChoiceModelStatus(int n) {
        if (this.errorChoiceModel != null) {
            this.logChannel.log(-2137614336, "BoardbookBrowserHandler#setErrorChoiceModelStatus: %1", (long)n);
            this.errorChoiceModel.setStatus(n);
        }
    }

    @Override
    public void indicateBrowserStateNotFound() {
        if (this.errorChoiceModel != null) {
            this.setErrorChoiceModelStatus(2);
            this.setErrorChoiceModelValue(2);
        }
    }

    @Override
    public void indicateBrowserStateComplete() {
        if (this.errorChoiceModel != null) {
            this.setErrorChoiceModelStatus(1);
            this.setErrorChoiceModelValue(1);
        }
    }

    public void handleVideo(String string, String string2) {
        this.logChannel.log(1078071040, "BoardbookHandler#handleVideo url %1, description \"%2\"", (Object)string, (Object)string2);
        if (this.viewSizeService != null && this.viewSizeService.getCurrentViewSize() == 1) {
            this.logChannel.log(1078071040, "BoardbookHandler#handleVideo() display manager is in SMALL Stage View...aborting");
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
        this.logChannel.log(1078071040, "BoardbookHandler#returnFromVideoToBoardbook: closing session and invoking event");
        if (this.mediaService != null) {
            this.logChannel.log(-2137614336, "BoardbookHandler#returnFromVideoToBoardbook: closing session");
            this.mediaService.close(this.currentSession);
        }
        this.hmiService.getChoiceModel(-919926528).setValue(0);
    }

    public void setMediaService(IMediaFilePlayerService iMediaFilePlayerService) {
        this.logChannel.log(1078071040, "BoardbookHandler#setMediaService called");
        if (iMediaFilePlayerService != null) {
            this.mediaService = iMediaFilePlayerService;
        }
    }

    @Override
    public boolean scrollDown(int n) {
        return false;
    }

    @Override
    public boolean scrollUp(int n) {
        return false;
    }

    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(1078071040, "BoardbookHandler#updatePlayPosition %1 %2", (long)n, (long)n2);
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
        this.logChannel.log(1078071040, "BoardbookHandler#startMediaPlayback: called");
    }

    public ChoiceModelApp getDisplayContextModel() {
        return this.displayContextModel;
    }

    @Override
    public boolean indicateEfiUrl(String string) {
        return false;
    }

    @Override
    public void belowLowerThreshold(int n) {
    }

    @Override
    public void exceedsUpperThreshold(int n) {
    }

    @Override
    public void indicateBrowserStateTimeout() {
    }

    @Override
    public void javascriptAlert(String string) {
    }

    @Override
    public boolean press() {
        this.logChannel.log(-2137614336, "BoardbookHandler#press DDS Enter pressed!");
        if (this.hmiService.getChoiceModel(-919926528).getValue() == 0) {
            this.logChannel.log(1078071040, "BoardbookHandler#press Video finished! %1", (long)this.hmiService.getChoiceModel(-919926528).getValue());
            return false;
        }
        this.hmiService.getVirtualButtonModel(1680673024).fireEvent(0);
        return true;
    }

    @Override
    public void indicateBoardbookAvailable(boolean bl) {
        this.logChannel.log(1078071040, "BoardbookHandler#indicateBoardbookAvailable %1", bl);
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        this.browserHandler = iBrowserHandler;
    }

    public void setViewSizeService(IViewSizeManager iViewSizeManager) {
        this.viewSizeService = iViewSizeManager;
        this.viewSizeService.addViewSizeListener(this.viewSizeListener);
    }

    public void triggerScreenChangeToVideo() {
        this.logChannel.log(-2137614336, "BoardbookHandler#triggerScreenChangeToVideo: called");
        this.hmiService.getChoiceModel(-919926528).setValue(1);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "BoardbookHandler#keyPressed: modelID: %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "BoardbookHandler#keyReleased: modelID: %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void updateScrollbarX(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "BoardbookHandler#updateScrollbarX: pageContentWidth: %1, visibleAreaWidth %2, scrollPositionX %3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "BoardbookHandler#updateScrollbarY: pageContentHeight: %1, visibleAreaHeight %2, scrollPositionY %3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(-2137614336, "BoardbookHandler#updateBrowserStateBusy: busy: %1", bl);
    }

    @Override
    public void updateBrowserState(int n) {
        this.logChannel.log(-2137614336, "BoardbookHandler#updateBrowserState: busy: %1", (long)n);
    }

    @Override
    public void virtualButtonBack() {
        this.logChannel.log(-2137614336, "BoardbookHandler#virtualButtonBack: called");
    }

    public void setVideoLoading(boolean bl) {
        this.isVideoLoading = bl;
        this.logChannel.log(-2137614336, "BoardbookHandler#setVideoLoading: %1", this.isVideoLoading);
    }

    public boolean isVideoLoading() {
        this.logChannel.log(-2137614336, "BoardbookHandler#isVideoLoading: %1", this.isVideoLoading);
        return this.isVideoLoading;
    }

    static /* synthetic */ BoardbookFilePlayerSession access$000(BoardbookHandler boardbookHandler) {
        return boardbookHandler.currentSession;
    }

    static {
        SUPPORTED_VIDEO_MIME_TYPES = new String[]{"video/x-msvideo", "audio/midi", "video/mpeg", "audio/ogg"};
    }
}

