/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlLameClientState;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.dsi.AbstractSwdlDSIHandler;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.StringTokenizer;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.swdlselection.DSISwdlSelectionListener;
import org.dsi.ifc.swdlselection.LameClient;

public class SwdlDSIHandlerSelection
extends AbstractSwdlDSIHandler
implements DSISwdlSelectionListener {
    private static final String CLASSNAME;
    private static final int[] META_RESULT_ARGS;
    private static final int[] RELEASE_RESULT_ARGS;
    private static final int RELEASE_NOT_INITIALIZED;
    private static final byte NO_MEDIA_AVAILABLE;
    protected ISelectionManager selectionManager = null;
    private volatile int requestedMedium = 0;
    private volatile int pendingDelayedMedium = 0;
    private int requestedRelease = -1;
    private int pendingDelayedRelease = -1;
    private boolean asyncExOcurred = false;
    private boolean userDefinedMode = false;
    private boolean userDownloadInterrupted = false;
    private boolean downloadIsStarted = false;
    private boolean setUserSwdlAttribute = true;
    private byte availableMedia = 0;
    private final SwdlLameClientState swdlLameClientState;
    private final SwdlDSIHandlerProgress progressDSIHandler;
    private static final boolean skipAbortBeforeSetMediumAndRelease;

    SwdlDSIHandlerSelection(SwdlEnv swdlEnv, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super("SwdlDSIHandlerSelection", swdlEnv);
        this.swdlLameClientState = new SwdlLameClientState(swdlEnv);
        this.progressDSIHandler = swdlDSIHandlerProgress;
    }

    private final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    private final SwdlLameClientState getSwdlLameClientState() {
        return this.swdlLameClientState;
    }

    private DSISwdlSelection getDSISwdlSelection() {
        return (DSISwdlSelection)this.getDSI();
    }

    private SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    private void reinit() {
        if (this.setUserSwdlAttribute) {
            this.setNotification(new int[]{3});
        }
        this.setNotification(new int[]{4, 6});
        this.waitForLameClients();
    }

    public void setSelectionManager(ISelectionManager iSelectionManager) {
        this.selectionManager = iSelectionManager;
        this.setAvailableMedia();
    }

    public void setAvailableMedia() {
        this.getLogDSI().log(-2137614336, "%1 -> setAvailableMedia(%2)", (Object)"[SwdlDSIHandlerSelection]", (long)this.availableMedia);
        if (null != this.selectionManager) {
            this.selectionManager.updateAvailableMedia(this.availableMedia);
        }
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        super.setDSI(dSIBase);
        this.reinit();
    }

    static String[] splitString(String string, char c2, int n) {
        String[] stringArray;
        if (string.length() == 0) {
            stringArray = new String[]{string};
        } else if (string.charAt(0) == '\'' && string.charAt(string.length() - 1) == '\'') {
            StringTokenizer stringTokenizer = new StringTokenizer(string, "'");
            String[] stringArray2 = new String[stringTokenizer.countTokens()];
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                stringArray2[i2] = stringTokenizer.nextToken();
            }
            if (n < 2) {
                if (stringArray2.length == 1) {
                    stringArray = new String[]{stringArray2[0]};
                } else {
                    Buffer buffer = new Buffer();
                    for (int i3 = 0; i3 < stringArray2.length; ++i3) {
                        buffer.append(stringArray2[i3]);
                    }
                    stringArray = new String[]{buffer.toString()};
                }
            } else if (stringArray2.length == 1) {
                stringArray = new String[]{"?", stringArray2[0]};
            } else {
                Buffer buffer = new Buffer();
                for (int i4 = 0; i4 < stringArray2.length - 2; ++i4) {
                    buffer.append(stringArray2[i4]);
                }
                stringArray = new String[]{buffer.toString(), stringArray2[stringArray2.length - 1]};
            }
        } else {
            int n2;
            stringArray = n < 2 ? new String[]{string} : ((n2 = string.lastIndexOf(c2)) > 0 ? new String[]{string.substring(0, n2), string.substring(n2 + 1)} : new String[]{"?", string});
        }
        return stringArray;
    }

    public final void waitForLameClients() {
        if (!this.getSwdlLameClientState().isLameClientNotification()) {
            this.getSwdlLameClientState().setLameClientList(null);
            this.setNotification(new int[]{1});
            this.getSwdlLameClientState().setLameClientNotification(true);
        }
    }

    public void initWaitForLameClients() {
        this.getSwdlLameClientState().initWaitForLameClients();
    }

    void cancelWaitForLameClients() {
        this.clearNotification(new int[]{1});
        this.getSwdlLameClientState().setLameClientNotification(false);
    }

    @Override
    public void updateUnitType(int n, int n2) {
    }

    @Override
    public void updateLameClients(LameClient[] lameClientArray, int n) {
        if (n == 1) {
            try {
                this.getSwdlLameClientState().updateLameClients(lameClientArray);
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateLameClients", exception);
            }
        }
    }

    public void requestFocus() {
        this.getLogDSI().log(1078071040, "%1 -> setGotFocus(true)", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().setGotFocus(true);
        this.logStartupEvent("Swdl Request Focus");
        this.resetDownloadIsStartedFlag();
        this.clearMediumPendingFlag();
    }

    public void releaseFocus() {
        this.getLogDSI().log(1078071040, "%1 releaseFocus()", (Object)"[SwdlDSIHandlerSelection]");
        if (this.getDSISwdlSelection() != null) {
            this.getLogDSI().log(1078071040, "%1 -> setGotFocus(false)", (Object)"[SwdlDSIHandlerSelection]");
            this.getDSISwdlSelection().setGotFocus(false);
            this.logStartupEvent("Swdl Release Focus");
            this.resetDownloadIsStartedFlag();
        } else {
            this.getLogDSI().log(10000, "%1 -> setGotFocus(false): DSISwdlSelection is not available", (Object)"[SwdlDSIHandlerSelection]");
        }
    }

    public void resetDownloadIsStartedFlag() {
        this.downloadIsStarted = false;
    }

    private int getRequestedMedium() {
        return this.requestedMedium;
    }

    private void setRequestedMedium(int n) {
        this.getLogDSI().log(-2137614336, "%1 setRequestedMedium( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        this.requestedMedium = n;
        this.setAsyncExOcurred(false);
    }

    private int getPendingDelayedMedium() {
        return this.pendingDelayedMedium;
    }

    private void setPendingDelayedMedium(int n) {
        this.getLogDSI().log(-2137614336, "%1 setPendingDelayedMedium( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        this.pendingDelayedMedium = n;
    }

    private void clearMediumPendingFlag() {
        this.getLogDSI().log(-2137614336, "%1 clearMediumPendingFlag() ", (Object)"[SwdlDSIHandlerSelection]");
        this.setRequestedMedium(0);
        this.setPendingDelayedMedium(0);
    }

    public void doGetMedia() {
        this.getLogDSI().log(1078071040, "%1 -> getMedia() ", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().getMedia();
    }

    @Override
    public void getMedia(int[] nArray) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- SwdlSelection.getMedia( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)nArray);
            if (nArray == null) {
                nArray = EMPTY_INT_ARRAY;
            }
            this.selectionManager.updateSourceMediaList(nArray);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getMedia", exception);
        }
    }

    public void doSetMedium(int n) {
        if (skipAbortBeforeSetMediumAndRelease) {
            if (this.getRequestedMedium() == 0 && this.getRequestedReleaseIndex() == -1) {
                this.setRequestedMedium(n);
                this.getLogDSI().log(1078071040, "%1 -> doSetMedium( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.getDSISwdlSelection().setMedium(n);
            } else {
                this.getLogDSI().log(-1601830656, "%1 doSetMedium( %2 ): waiting for abortSetMedium/abortSetRelease -> do not initiate a new DSI call!", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.setPendingDelayedMedium(n);
            }
        } else if (this.getRequestedMedium() != 0) {
            this.getLogDSI().log(-1601830656, "%1 doSetMedium( %2 ): waiting for abortSetMedium -> ignore doSetMedium", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        } else {
            this.getLogDSI().log(-1601830656, "%1 doSetMedium( %2 ): waiting for abortSetMedium to initiate the setMedium DSI call!", (Object)"[SwdlDSIHandlerSelection]", (long)n);
            this.setPendingDelayedMedium(n);
            this.setRequestedMedium(n);
            this.doAbortSetMedium();
        }
    }

    private String getReleaseErrorTemplate(int n) {
        return this.getTextFactory().getReleaseErrorTemplate(n);
    }

    private String formatReleaseInfo(int n, String string) {
        String string2 = this.getReleaseErrorTemplate(n);
        String string3 = string2 != null ? StringUtilities.formatMessage(string2, SwdlDSIHandlerSelection.splitString(string, ' ', RELEASE_RESULT_ARGS[n])) : StringUtilities.formatMessage(this.getTextFactory().getTextConstantUndefinedError(), new String[]{Integer.toString(n), string});
        return string3;
    }

    public String getConsistencyMessage(int n, String string, int n2) {
        return this.getTextFactory().getConsistencyMessage(n, string, n2);
    }

    @Override
    public void setMedium(int n, String string, String[] stringArray) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- setMedium( result: %3, resultInfo: %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string, (long)n);
            if (!skipAbortBeforeSetMediumAndRelease) {
                this.setRequestedMedium(0);
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                if (this.isAsyncExOcurred()) {
                    this.getLogDSI().log(1078071040, "%1 <- setMedium(): AsyncException encountered! Ignore this response and retry setMedium! ", (Object)"[SwdlDSIHandlerSelection]");
                    this.doSetMedium(this.getPendingDelayedMedium());
                    return;
                }
            } else {
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                if (this.isAsyncExOcurred()) {
                    this.getLogDSI().log(1078071040, "%1 <- setMedium(): AsyncException encountered! Ignore this response and retry setMedium! ", (Object)"[SwdlDSIHandlerSelection]");
                    this.doSetMedium(this.getRequestedMedium());
                    return;
                }
                this.setRequestedMedium(0);
            }
            if (1 == n) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.getLogDSI().log(-2137614336, "%1 Release: %2 ", (Object)"[SwdlDSIHandlerSelection]", (Object)stringArray[i2]);
                }
                this.selectionManager.updateReleaseList(stringArray, null, n);
            } else {
                this.selectionManager.updateReleaseList(EMPTY_STRING_ARRAY, this.formatReleaseInfo(n, string), n);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("setMedium", exception);
        }
    }

    public void doAbortSetMedium() {
        if (this.getRequestedMedium() != 0) {
            this.getLogDSI().log(1078071040, "%1 -> doAbortSetMedium()", (Object)"[SwdlDSIHandlerSelection]");
            this.getDSISwdlSelection().abortSetMedium();
            this.setRequestedReleaseIndex(-1);
        }
    }

    private final CustomerDLState getCustomerDLState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    @Override
    public void abortSetMedium() {
        try {
            CustomerDLState customerDLState;
            this.getLogDSI().log(1078071040, "%1 <- abortSetMedium() ", (Object)"[SwdlDSIHandlerSelection]");
            if (skipAbortBeforeSetMediumAndRelease) {
                this.setRequestedMedium(0);
            }
            if ((customerDLState = this.getCustomerDLState()) != null) {
                customerDLState.cancelDone();
            }
            int n = this.getPendingDelayedMedium();
            if (skipAbortBeforeSetMediumAndRelease) {
                if (n != 0) {
                    this.getLogDSI().log(-1601830656, "%1 abortSetMedium(): delayed set medium request found -> call doSetMedium(%2) now", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                    this.setPendingDelayedMedium(0);
                    this.setPendingDelayedReleaseIndex(-1);
                    this.doSetMedium(n);
                }
            } else {
                this.getLogDSI().log(-1601830656, "%1 abortSetMedium(): delayed set medium request found", (Object)"[SwdlDSIHandlerSelection]");
                this.getLogDSI().log(-1601830656, "%1 -> doSetMedium(%2)", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.getDSISwdlSelection().setMedium(n);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("setMedium", exception);
        }
    }

    private int getRequestedReleaseIndex() {
        return this.requestedRelease;
    }

    private void setRequestedReleaseIndex(int n) {
        this.requestedRelease = n;
        this.setAsyncExOcurred(false);
    }

    private int getPendingDelayedReleaseIndex() {
        return this.pendingDelayedRelease;
    }

    private void setPendingDelayedReleaseIndex(int n) {
        this.getLogDSI().log(-2137614336, "%1 setPendingDelayedReleaseIndex( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        this.pendingDelayedRelease = n;
    }

    public void doSetRelease(int n) {
        this.getLogDSI().log(1078071040, "%1 doSetRelease( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        if (n < 0) {
            this.getLogDSI().log(10000, "%1 index < 0, ignoring request!", (Object)"[SwdlDSIHandlerSelection]");
            return;
        }
        if (skipAbortBeforeSetMediumAndRelease) {
            if (this.getRequestedReleaseIndex() == -1) {
                this.setRequestedReleaseIndex(n);
                this.getLogDSI().log(1078071040, "%1 -> doSetRelease( %2 )", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.getDSISwdlSelection().setRelease(n);
            } else {
                this.getLogDSI().log(-1601830656, "%1 doSetRelease( %2 ): waiting for abortSetRelease -> do _not_ initiate a new DSI call!", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.setPendingDelayedReleaseIndex(n);
            }
        } else if (this.getRequestedReleaseIndex() == -1) {
            this.getLogDSI().log(-1601830656, "%1 doSetRelease( %2 ): waiting for abortSetRelease to initiate setRelease DSI call!", (Object)"[SwdlDSIHandlerSelection]", (long)n);
            this.setPendingDelayedReleaseIndex(n);
            this.setRequestedReleaseIndex(n);
            this.doAbortSetRelease();
        } else {
            this.getLogDSI().log(-1601830656, "%1 doSetRelease( %2 ): waiting for abortSetRelease -> skip to set release!", (Object)"[SwdlDSIHandlerSelection]", (long)n);
        }
    }

    private String getMetainfoErrorTemplate(int n) {
        return this.getTextFactory().getMetainfoErrorTemplate(n);
    }

    private String formatMetainfoInfo(int n, String string) {
        String string2 = this.getMetainfoErrorTemplate(n);
        String string3 = string2 != null ? StringUtilities.formatMessage(string2, SwdlDSIHandlerSelection.splitString(string, ' ', META_RESULT_ARGS[n])) : StringUtilities.formatMessage(this.getTextFactory().getTextConstantUndefinedError(), new String[]{Integer.toString(n), string});
        return string3;
    }

    @Override
    public void setRelease(int n, String string) {
        try {
            if (skipAbortBeforeSetMediumAndRelease) {
                this.getLogDSI().log(1078071040, "%1 <- setRelease( result: %3, resultInfo: %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string, (long)n);
                if (this.isAsyncExOcurred()) {
                    this.getLogDSI().log(1078071040, "%1 setRelease(): AsyncException encountered! Ignore this response and retry setRelease! ", (Object)"[SwdlDSIHandlerSelection]");
                    this.setRequestedReleaseIndex(-1);
                    this.doSetRelease(this.getRequestedReleaseIndex());
                    return;
                }
                this.setRequestedReleaseIndex(-1);
            } else {
                this.setRequestedReleaseIndex(-1);
                this.getLogDSI().log(1078071040, "%1 <- setRelease( result: %3, resultInfo: %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string, (long)n);
                if (this.isAsyncExOcurred()) {
                    this.getLogDSI().log(1078071040, "%1 setRelease(): AsyncException encountered! Ignore this response and retry setRelease! ", (Object)"[SwdlDSIHandlerSelection]");
                    this.doSetRelease(this.getRequestedReleaseIndex());
                    return;
                }
            }
            if (1 == n) {
                this.selectionManager.updateReleaseResult(string, 1);
            } else {
                this.selectionManager.updateReleaseResult(this.formatMetainfoInfo(n, string), -1);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("setRelease", exception);
        }
    }

    public void doAbortSetRelease() {
        if (this.getRequestedReleaseIndex() != -1) {
            this.getLogDSI().log(1078071040, "%1 -> doAbortSetRelease( )", (Object)"[SwdlDSIHandlerSelection]");
            this.getDSISwdlSelection().abortSetRelease();
            this.setRequestedReleaseIndex(-1);
        }
        if (!skipAbortBeforeSetMediumAndRelease) {
            this.doAbortSetMedium();
        }
    }

    @Override
    public void abortSetRelease() {
        try {
            this.getLogDSI().log(1078071040, "%1 <- abortSetRelease() ", (Object)"[SwdlDSIHandlerSelection]");
            CustomerDLState customerDLState = this.getCustomerDLState();
            if (customerDLState != null) {
                customerDLState.cancelDone();
            }
            int n = this.getPendingDelayedReleaseIndex();
            if (skipAbortBeforeSetMediumAndRelease) {
                int n2 = this.getPendingDelayedMedium();
                if (n2 != 0) {
                    this.getLogDSI().log(-1601830656, "%1 abortSetRelease(): delayed set medium request found -> call doSetMedium(%2) now", (Object)"[SwdlDSIHandlerSelection]", (long)n2);
                    this.setPendingDelayedMedium(0);
                    this.setPendingDelayedReleaseIndex(-1);
                    this.doSetMedium(n2);
                } else if (n != -1) {
                    this.getLogDSI().log(-1601830656, "%1 abortSetRelease(): delayed set release request found -> call doSetRelease(%2) now", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                    this.setPendingDelayedReleaseIndex(-1);
                    this.doSetRelease(n);
                }
            } else {
                this.getLogDSI().log(-1601830656, "%1 abortSetRelease(): delayed set release request found", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.getLogDSI().log(1078071040, "%1 -> doSetRelease(%2) ", (Object)"[SwdlDSIHandlerSelection]", (long)n);
                this.getDSISwdlSelection().setRelease(n);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("abortSetRelease", exception);
        }
    }

    public void doGetUserDefindeAllowed() {
        this.getLogDSI().log(1078071040, "%1 -> doGetUserDefinedAllowed()", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().getUserDefinedAllowed();
    }

    @Override
    public void getUserDefinedAllowed(boolean bl) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- updateUserDefinedAllowed( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)(bl ? "true" : "false"));
            this.selectionManager.updateUserDefinedAllowed(bl);
        }
        catch (Exception exception) {
            this.dsiCallbackError("updateUserDefinedAllowed", exception);
        }
    }

    public void doSetInstallationType(boolean bl) {
        this.userDefinedMode = !bl;
        this.getLogDSI().log(1078071040, "%1 -> setInstallationType( %2 )", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
        this.getDSISwdlSelection().setInstallationType(bl);
    }

    public boolean isUserDefinedMode() {
        return this.userDefinedMode;
    }

    public void doGetIncompatibleDevices() {
        this.getLogDSI().log(1078071040, "%1 -> doGetIncompatibleDevices()", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().getIncompatibleDevices();
    }

    @Override
    public void getIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        try {
            if (stringArray == null) {
                stringArray = EMPTY_STRING_ARRAY;
            }
            if (stringArray2 == null) {
                stringArray2 = EMPTY_STRING_ARRAY;
            }
            this.getLogDSI().log(-2137614336, "%1 <- getIncompatibleDevices() ", (Object)"[SwdlDSIHandlerSelection]");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.getLogDSI().log(-2137614336, "%1 Device %2 needs %3 ", (Object)"[SwdlDSIHandlerSelection]", (Object)stringArray[i2], (Object)stringArray2[i2]);
            }
            this.selectionManager.updateIncompatibleDevices(stringArray, stringArray2);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getIncompatibleDevices", exception);
        }
    }

    public void doCheckConsistency() {
        this.getLogDSI().log(1078071040, "%1 -> checkConsistency()", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().checkConsistency();
    }

    @Override
    public void checkConsistency(int n, boolean bl, String string, int n2) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- checkConsistencyEx( %2, %3, %4 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)new Integer(n), (Object)bl, (Object)string);
            this.selectionManager.updateConsistency(n, bl, string, n2);
        }
        catch (Exception exception) {
            this.dsiCallbackError("checkConsistencyEx", exception);
        }
    }

    @Override
    public void startVersionUpload(boolean bl) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- startVersionUpload( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
            this.getSwdlEnv().getHMISwitcher().getProgressManager().versionUploadDone(true);
            this.selectionManager.versionUploadDone(bl);
        }
        catch (Exception exception) {
            this.dsiCallbackError("startVersionUpload", exception);
        }
    }

    public void doStartVersionUpload() {
        try {
            this.getLogDSI().log(1078071040, "%1 -> doStartVersionUpload()", (Object)"[SwdlDSIHandlerSelection]");
            this.getSwdlEnv().getHMISwitcher().getProgressManager().versionUploadDone(false);
            this.getDSISwdlSelection().startVersionUpload();
        }
        catch (Exception exception) {
            this.getLogDSI().log(10000, "%1 calling startVersionUpload failed!", (Object)"[SwdlDSIHandlerSelection]", (Throwable)exception);
        }
        this.logStartupEvent("Swdl start Version upload");
    }

    public void abortVersionUpload() {
        this.getLogDSI().log(1078071040, "%1 -> abortVersionUpload()", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().abortVersionUpload();
        this.logStartupEvent("Swdl abort Version upload");
    }

    public void endVersionUpload() {
        this.getLogDSI().log(1078071040, "%1 -> endVersionUpload()", (Object)"[SwdlDSIHandlerSelection]");
        this.getDSISwdlSelection().endVersionUpload();
        this.logStartupEvent("Swdl end Version upload");
    }

    public void startDownload() {
        if (this.downloadIsStarted) {
            this.getLogDSI().log(-1601830656, "%1 Download is already started! Do not call startDownload again before requestFocus is called again!", (Object)"[SwdlDSIHandlerSelection]");
        } else {
            this.getProgressDSIHandler().resetAutoRetryCounter();
            this.getLogDSI().log(1078071040, "%1 -> startDownload()", (Object)"[SwdlDSIHandlerSelection]");
            this.getDSISwdlSelection().startDownload();
            this.logStartupEvent("Swdl start download!");
            this.downloadIsStarted = true;
        }
    }

    public void doStoreNfsIpAddress(String string) {
        this.getLogDSI().log(1078071040, "%1 -> doStoreNfsIpAddress( %2 )", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
        this.getDSISwdlSelection().storeNfsIpAddress(string);
    }

    public void doStoreNfsPath(String string) {
        this.getLogDSI().log(1078071040, "%1 -> doStoreNfsPath( %2 )", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
        this.getDSISwdlSelection().storeNfsPath(string);
    }

    public void doStoreFsPath(String string) {
        this.getLogDSI().log(1078071040, "%1 -> doStoreFsPath( %2 )", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
        this.getDSISwdlSelection().storeFsPath(string);
    }

    @Override
    public void storeNfsIpAddress(String string) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- storeNfsIpAddress( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
            this.selectionManager.updateNfsIpAddress(string);
        }
        catch (Exception exception) {
            this.dsiCallbackError("storeNfsIpAddress", exception);
        }
    }

    @Override
    public void storeNfsPath(String string) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- storeNfsPath( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
            this.selectionManager.updateNfsPath(string);
        }
        catch (Exception exception) {
            this.dsiCallbackError("storeNfsPath", exception);
        }
    }

    @Override
    public void storeFsPath(String string) {
        try {
            this.getLogDSI().log(-2137614336, "%1 <- storeFsPath( %2 ) ", (Object)"[SwdlDSIHandlerSelection]", (Object)string);
            this.selectionManager.updateFsPath(string);
        }
        catch (Exception exception) {
            this.dsiCallbackError("updateFsPath", exception);
        }
    }

    void setAsyncExOcurred(boolean bl) {
        this.asyncExOcurred = bl;
    }

    boolean isAsyncExOcurred() {
        return this.asyncExOcurred;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        boolean bl = false;
        switch (n2) {
            case 1005: {
                if (this.getRequestedMedium() == 0) break;
                this.setAsyncExOcurred(true);
                this.getLogDSI().log(-1601830656, "%1 AsyncException( errorCode: %3, errorMsg: %2, requestType: %4 ) ocurred! Retry setMedium!  ", (Object)"[SwdlDSIHandlerSelection]", (Object)string, (Object)new Integer(n), (long)n2);
                bl = true;
                break;
            }
            case 1006: {
                if (this.getRequestedReleaseIndex() == -1) break;
                this.setAsyncExOcurred(true);
                this.getLogDSI().log(-1601830656, "%1 AsyncException( errorCode: %3, errorMsg: %2, requestType: %4 ) ocurred! Retry setRelease!  ", (Object)"[SwdlDSIHandlerSelection]", (Object)string, (Object)new Integer(n), (long)n2);
                bl = true;
                break;
            }
        }
        if (!bl) {
            super.asyncException(n, string, n2);
        }
    }

    public void doSetUserSwdl(boolean bl) {
        this.getLogDSI().log(1078071040, "%1 -> doSetUserSwdl( %2 )", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
        this.getDSISwdlSelection().setUserSwdl(bl);
    }

    @Override
    public void updateUserSwdl(boolean bl, int n) {
        this.getLogDSI().log(1078071040, "%1 <- updateUserSwdl(userSwdl=%2, validFlag=%3) ", (Object)"[SwdlDSIHandlerSelection]", (Object)bl, (long)n);
        if (n == 1) {
            this.userDownloadInterrupted = bl;
            ChoiceModelApp choiceModelApp = this.getSwdlModels().getSwdlInProgressChoice();
            if (-1 == choiceModelApp.getValue()) {
                choiceModelApp.setValue(bl ? 1 : 0);
            }
            this.getCustomerDLState().updateCustDownloadState(bl);
            this.clearNotification(new int[]{3});
            this.setUserSwdlAttribute = false;
        } else {
            this.getLogDSI().log(1078071040, "%1 Invalid updateUserSwdl: %2 ", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
        }
    }

    public boolean isUserDownloadInterrupted() {
        return this.userDownloadInterrupted;
    }

    @Override
    public void updateRingNotOK(boolean bl, int n) {
        if (n == 1) {
            try {
                this.getLogDSI().log(1078071040, "%1 <- updateRingNotOK: %2 ", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
                if (bl) {
                    this.selectionManager.updateRingNotOk(bl);
                }
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateRingNotOK", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 Invalid updateRingNotOK: %2 ", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
        }
    }

    @Override
    public void getFinalizeTargets(int[] nArray) {
    }

    @Override
    public void setFinalizeTarget(int n, long l, long l2, long l3) {
    }

    @Override
    public void updateAvailableMedia(byte by, int n) {
        if (n == 1) {
            try {
                this.getLogDSI().log(1078071040, "%1 <- updateAvailableMedia: %2", (Object)"[SwdlDSIHandlerSelection]", (long)by);
                this.availableMedia = by;
                if (this.selectionManager != null) {
                    this.selectionManager.updateAvailableMedia(by);
                }
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateAvailableMedia", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 Invalid updateAvailableMedia: %2 ", (Object)"[SwdlDSIHandlerSelection]", (long)by);
        }
    }

    @Override
    public void updateEndDownload(boolean bl, int n) {
    }

    @Override
    public void updateEngineering(boolean bl, int n) {
    }

    public void enterComponentUpdateConfirmation(boolean bl) {
        this.getLogDSI().log(1078071040, "%1 -> enterComponentUpdateConfirmation(%2)", (Object)"[SwdlDSIHandlerSelection]", (Object)bl);
        this.getDSISwdlSelection().enterComponentUpdateConfirmation(bl);
    }

    @Override
    public void enterComponentUpdateConfirmation() {
        if (this.selectionManager != null) {
            this.selectionManager.enterComponentUpdateConfirmation();
        }
    }

    @Override
    public void setTargetLanguage(short s) {
    }

    static {
        META_RESULT_ARGS = new int[]{0, 0, 1, 1, 2, 1, 1, 2, 1, 2, 2};
        RELEASE_RESULT_ARGS = new int[]{0, 0, 1, 1, 2, 1, 1, 1, 1, 2, 2, 1};
        skipAbortBeforeSetMediumAndRelease = Boolean.getBoolean(System.getProperty("SWDL_SKIP_ABORT_BEFORE_SET", "false"));
    }
}

