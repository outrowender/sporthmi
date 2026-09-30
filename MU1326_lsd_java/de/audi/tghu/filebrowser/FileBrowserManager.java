/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.filebrowser.AbstractFileBrowserSession;
import de.audi.tghu.filebrowser.DefaultEvoFileListRowBuilder;
import de.audi.tghu.filebrowser.FileBrowser;
import de.audi.tghu.filebrowser.IEvoFileListRowBuilder;
import de.audi.tghu.filebrowser.IFileBrowser;
import de.audi.tghu.filebrowser.IFileBrowserManager;
import de.audi.tghu.filebrowser.IFileBrowserModelAccess;
import de.audi.tghu.filebrowser.IFileBrowserSession;
import de.audi.tghu.filebrowser.IModelFileBrowser;
import de.audi.tghu.filebrowser.ModelFileBrowser;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class FileBrowserManager
implements DSIFileBrowserListener,
IFileBrowserManager,
I18NTarget {
    private static final long WAIT_TIMEOUT = 5000L;
    private static final long WAIT_TIMEOUT_CREATE_PREVIEW = 10000L;
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final LogChannel logDSI;
    private final SimpleIntObjectMap sessions;
    private DSIFileBrowser dsi = null;
    private volatile Path resultPath = null;
    private volatile int resultSession = -1;
    private volatile boolean waitForStartResult = false;
    private volatile int pendingRequestCount = 0;
    private Object previewLock = new Object();
    private ResourceLocator resultPreviewFileRL = null;

    public FileBrowserManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.FileBrowser");
        this.logDSI = iFrameworkAccess.getLogChannel("Fw.FileBrowser.DSI");
        this.sessions = new SimpleIntObjectMap();
    }

    private synchronized void setLanguageCode(String string) {
        this.logDSI.log(1000000, "-> setLanguageCode(%1)", (Object)string);
        DSIFileBrowser dSIFileBrowser = this.dsi;
        if (dSIFileBrowser != null) {
            dSIFileBrowser.setLanguage(string);
        }
    }

    final IFrameworkAccess getFramework() {
        return this.framework;
    }

    void start(DSIFileBrowser dSIFileBrowser) {
        this.logDSI.log(1000000, "initialze DSI %1", (Object)dSIFileBrowser);
        this.dsi = dSIFileBrowser;
        this.setLanguageCode(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode());
    }

    void stop() {
        this.dsi = null;
        this.sessions.clear();
        this.resultPath = null;
    }

    public synchronized IFileBrowser open(Path path, String[] stringArray) {
        this.resultPath = null;
        this.resultSession = -1;
        this.logDSI.log(1000000, "-> start(%1)", (Object)path);
        this.waitForStartResult = true;
        ++this.pendingRequestCount;
        this.dsi.start(path);
        try {
            this.wait(5000L);
            this.waitForStartResult = false;
            if (this.resultPath != null) {
                FileBrowser fileBrowser = new FileBrowser(this, this.resultSession, this.resultPath, stringArray);
                this.sessions.add(this.resultSession, fileBrowser);
                return fileBrowser;
            }
            if (this.pendingRequestCount == 0) {
                this.log.log(10000, "an error response is received, a TiledModelFileBrowser cannot be created!");
            } else {
                this.log.log(10000, "creating FileBrowser( %1 ) timed out!", (Object)path);
            }
            return null;
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
            this.log.log(10000, "creating FileBrowser( %1 ) failed!", (Object)path, (Throwable)interruptedException);
            return null;
        }
    }

    public IModelFileBrowser open(Path path, String[] stringArray, IFileBrowserModelAccess iFileBrowserModelAccess) {
        return this.open(path, stringArray, iFileBrowserModelAccess, new DefaultEvoFileListRowBuilder());
    }

    public synchronized IModelFileBrowser open(Path path, String[] stringArray, IFileBrowserModelAccess iFileBrowserModelAccess, IEvoFileListRowBuilder iEvoFileListRowBuilder) {
        this.resultPath = null;
        this.resultSession = -1;
        ++this.pendingRequestCount;
        this.dsi.start(path);
        this.waitForStartResult = true;
        this.logDSI.log(1000000, "-> start(%1)", (Object)path);
        TiledListModelApp tiledListModelApp = iFileBrowserModelAccess.getListModel();
        try {
            tiledListModelApp.removeAll();
            tiledListModelApp.setSelectedIndex(-1);
            tiledListModelApp.setLength(1);
            this.wait(5000L);
            this.waitForStartResult = false;
            if (this.resultPath != null) {
                this.logDSI.log(10000000, "creating TiledModelFileBrowser: resultSession = %2, resultPath = %1", (Object)this.resultPath, (long)this.resultSession);
                ModelFileBrowser modelFileBrowser = new ModelFileBrowser(this, this.resultSession, this.resultPath, stringArray, iFileBrowserModelAccess, iEvoFileListRowBuilder);
                this.sessions.add(this.resultSession, modelFileBrowser);
                return modelFileBrowser;
            }
            tiledListModelApp.setLength(0);
            if (this.pendingRequestCount == 0 || this.resultSession > -1) {
                this.log.log(10000, "an error response is received, a TiledModelFileBrowser cannot be created!");
            } else {
                this.log.log(10000, "creating TiledModelFileBrowser( %1 ) timed out!", (Object)path);
            }
            if (iFileBrowserModelAccess != null) {
                iFileBrowserModelAccess.getRootFolderReachedModel().setValue(1);
            }
            return null;
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
            tiledListModelApp.setLength(0);
            if (iFileBrowserModelAccess != null) {
                iFileBrowserModelAccess.getRootFolderReachedModel().setValue(1);
            }
            this.log.log(10000, "creating TiledModelFileBrowser( %1 ) failed!", (Object)path, (Throwable)interruptedException);
            return null;
        }
    }

    public void resetModels(IFileBrowserModelAccess iFileBrowserModelAccess) {
        this.log.log(10000000, "reset FileBrowser models %1", (Object)iFileBrowserModelAccess);
        if (null != iFileBrowserModelAccess) {
            ButtonModelApp buttonModelApp;
            ChoiceModelApp choiceModelApp;
            ChoiceModelApp choiceModelApp2;
            TiledListModelApp tiledListModelApp = iFileBrowserModelAccess.getListModel();
            if (null != tiledListModelApp) {
                tiledListModelApp.removeAll();
                tiledListModelApp.setSelectedIndex(-1);
                tiledListModelApp.setLength(0);
            }
            if (null != (choiceModelApp2 = iFileBrowserModelAccess.getRootFolderReachedModel())) {
                choiceModelApp2.setValue(1);
            }
            if ((choiceModelApp = iFileBrowserModelAccess.getSelectAllChoice()) != null) {
                choiceModelApp.setValue(0);
            }
            if ((buttonModelApp = iFileBrowserModelAccess.getImportButton()) != null) {
                buttonModelApp.setStatus(0);
            }
        }
    }

    public void close(int n) {
        this.log.log(10000000, "closing ModelFileBrowser session %1", (long)n);
        this.dsi.stop(n);
        this.sessions.remove(n);
    }

    public DSIFileBrowser getDSI() {
        return this.dsi;
    }

    public LogChannel getLog() {
        return this.log;
    }

    public LogChannel getLogDSI() {
        return this.logDSI;
    }

    private AbstractFileBrowserSession getFileBrowser(int n) {
        return (AbstractFileBrowserSession)this.sessions.get(n);
    }

    final synchronized IFileBrowser getSelection(IFileBrowserSession iFileBrowserSession, boolean bl) {
        this.resultSession = -1;
        this.logDSI.log(1000000, "-> getSelectedFiles( %1 )", (Object)iFileBrowserSession);
        this.dsi.getSelectedFiles(iFileBrowserSession.getSession());
        try {
            this.wait(5000L);
            if (this.resultSession == -1) {
                this.log.log(10000, "getSelection( %1 ) timed out!", (Object)iFileBrowserSession);
                return null;
            }
            FileBrowser fileBrowser = new FileBrowser(this, this.resultSession, iFileBrowserSession.pwd(), true);
            this.sessions.add(this.resultSession, fileBrowser);
            return fileBrowser;
        }
        catch (Exception exception) {
            this.log.log(10000, "getSelection( %1 ) failed!", (Object)iFileBrowserSession, (Throwable)exception);
            return null;
        }
    }

    public void createPreviewImage(ResourceLocator resourceLocator, int n, int n2, DSIFileBrowserListener dSIFileBrowserListener) {
        if (null == resourceLocator) {
            throw new NullPointerException("NullSourceFile");
        }
        if (0 >= n) {
            throw new IllegalArgumentException("invalidWidth");
        }
        if (0 >= n2) {
            throw new IllegalArgumentException("invalidHeight");
        }
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (null != dSIFileBrowser) {
            this.getLogDSI().log(1000000, "[FileBrowserManager] -> createPreviewImage(%1,%2,%3)", (Object)resourceLocator, (long)n, (long)n2);
            dSIFileBrowser.createPreviewImage(resourceLocator, n, n2);
        } else {
            this.getLogDSI().log(100000, "[FileBrowserManager] -> createPreviewImage: no DSI - nothing to do!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public synchronized ResourceLocator createPreviewImage(ResourceLocator resourceLocator, int n, int n2) {
        if (null == resourceLocator) {
            throw new NullPointerException("NullSourceFile");
        }
        if (0 >= n) {
            throw new IllegalArgumentException("invalidWidth");
        }
        if (0 >= n2) {
            throw new IllegalArgumentException("invalidHeight");
        }
        Object object = this.previewLock;
        synchronized (object) {
            DSIFileBrowser dSIFileBrowser = this.getDSI();
            this.resultPreviewFileRL = null;
            if (null == dSIFileBrowser) {
                this.getLogDSI().log(100000, "[CreatePreviewImageJob].doRun(): no DSI - nothing to do!");
                return null;
            }
            this.getLogDSI().log(1000000, "[FileBrowserManager] -> createPreviewImage(%1,%2,%3)", (Object)resourceLocator, (long)n, (long)n2);
            dSIFileBrowser.createPreviewImage(resourceLocator, n, n2);
            try {
                this.previewLock.wait(10000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                this.getLogDSI().log(100000, "[FileBrowserManager].createPreviewImage(): interrupted while waiting for preview image!", (Throwable)interruptedException);
            }
            if (null == this.resultPreviewFileRL) {
                this.getLogDSI().log(10000, "[FileBrowserManager].createPreviewImage(): timed out while waiting for preview image!");
                this.getLogDSI().log(1000000, "[FileBrowserManager].createPreviewImage() -> cancelPreviewCreation()");
                dSIFileBrowser.cancelPreviewCreation();
            }
            try {
                ResourceLocator resourceLocator2 = this.resultPreviewFileRL;
                return resourceLocator2;
            }
            finally {
                this.resultPreviewFileRL = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelPreviewCreation() {
        DSIFileBrowser dSIFileBrowser;
        Object object = this.previewLock;
        synchronized (object) {
            dSIFileBrowser = this.getDSI();
        }
        if (null != dSIFileBrowser) {
            this.getLogDSI().log(1000000, "[FileBrowserManager] -> cancelPreviewCreation()");
            dSIFileBrowser.cancelPreviewCreation();
        } else {
            this.getLogDSI().log(100000, "[FileBrowserManager].cancelPreviewCreation(): null DSI - nothing to do!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteAllPreviewFiles() {
        DSIFileBrowser dSIFileBrowser;
        Object object = this.previewLock;
        synchronized (object) {
            dSIFileBrowser = this.getDSI();
        }
        if (null != dSIFileBrowser) {
            this.getLogDSI().log(1000000, "[FileBrowserManager] -> deleteAllPreviewFiles()");
            dSIFileBrowser.deleteAllPreviewFiles();
        } else {
            this.getLogDSI().log(100000, "[FileBrowserManager].deleteAllPreviewFiles(): null DSI - nothing to do!");
        }
    }

    public void changeFolderResult(int n, int n2, Path path) {
        this.logDSI.log(1000000, "<- changeFolderResult(%2,%3,%1)", (Object)path, (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.changeFolderResult(n, n2, path);
        }
    }

    public void getFileCountResult(int n, int n2, int n3) {
        this.logDSI.log(1000000, "<- getFileCountResult(%2,%3,%1)", (long)n3, (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.getFileCountResult(n, n2, n3);
        }
    }

    public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
        this.logDSI.log(1000000, "<- getFileCountWithFileTypeFilterResult(session=%1,success=%2,fileTypes=%3,fileCount=%4)", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (Object)new Integer(n4));
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.getFileCountWithFileTypeFilterResult(n, n2, n3, n4);
        }
    }

    public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        this.logDSI.log(1000000, "<- getResourceLocatorWindowResult(%2,%3,%1)", (Object)resourceLocatorArray, (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.getResourceLocatorWindowResult(n, n2, n3, resourceLocatorArray, n4);
        }
    }

    public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
        this.logDSI.log(1000000, "<- getResourceLocatorsResult(%2,%3,%1)", (Object)resourceLocatorArray, (long)n, (long)n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getSelectedFilesResult(int n, int n2, int n3) {
        this.logDSI.log(1000000, "<- getSelectedFilesResult(%2,%3,%1)", (long)n2, (long)n, (long)n3);
        FileBrowserManager fileBrowserManager = this;
        synchronized (fileBrowserManager) {
            if (0 == n3) {
                this.resultSession = n2;
            }
            this.notifyAll();
        }
    }

    public synchronized void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        this.logDSI.log(1000000, "<- getViewWindowResult(session=%2,success=%3,offset=%4,files=%1)", (Object)browsedFileSet, (Object)new Integer(n), (Object)new Integer(n2), (long)n3);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.getViewWindowResult(n, n2, n3, browsedFileSet, n4);
        }
    }

    public void indicateSelectionResult(int n, int n2, int n3) {
        this.logDSI.log(1000000, "<- indicateSelectionResult(%2,%3,%1)", (long)n3, (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.indicateSelectionResult(n, n2, n3);
        }
    }

    public synchronized void setFileExtensionFilterResult(int n, int n2) {
        this.logDSI.log(1000000, "<- setFileExtensionFilterResult(%1,%2)", (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.setFileExtensionFilterResult(n, n2);
        }
    }

    public void setFileTypeFilterResult(int n, int n2) {
        this.logDSI.log(1000000, "<- setFileTypeFilterResult(%1,%2)", (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.setFileTypeFilterResult(n, n2);
        }
    }

    public void setFileTypeActiveResult(int n) {
        this.logDSI.log(1000000, "<- setFileTypeActiveResult(%1)", (long)n);
        Object[] objectArray = this.sessions.getValues();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                AbstractFileBrowserSession abstractFileBrowserSession = (AbstractFileBrowserSession)objectArray[i2];
                if (abstractFileBrowserSession == null) continue;
                abstractFileBrowserSession.setFileTypeActiveResult(n);
            }
        }
    }

    public void setLanguageResult(int n, String string) {
        this.logDSI.log(1000000, "<- setLanguageResult(%2,%1)", (Object)string, (long)n);
    }

    public void spellerResult(int n, int n2, String string, String string2) {
        this.logDSI.log(1000000, "<- spellerResult(%2,%3,%1)", (Object)(string + "|" + string2), (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (abstractFileBrowserSession != null) {
            abstractFileBrowserSession.spellerResult(n, n2, string, string2);
        }
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startResult(int n, int n2, Path path) {
        this.logDSI.log(1000000, "<- startResult(%2,%3,%1)", (Object)path, (long)n, (long)n2);
        FileBrowserManager fileBrowserManager = this;
        synchronized (fileBrowserManager) {
            if (0 == n2) {
                this.resultSession = n;
                this.resultPath = path;
                if (!this.waitForStartResult && this.pendingRequestCount > 1) {
                    this.close(this.resultSession);
                    this.log.log(10000, "Running into timeout! filebrowser session %1 closed automatically!", (long)this.resultSession);
                }
            }
            if (this.pendingRequestCount > 0) {
                --this.pendingRequestCount;
            }
            this.notifyAll();
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.logDSI.log(10000, "<- asyncException(%2, %1, %3)", (Object)string, (long)n, (long)n2);
    }

    public void setLanguage(Language language) {
        this.logDSI.log(1000000, "-> setLanguage(%1)", (Object)language.getLanguageCode());
        this.setLanguageCode(language.getLanguageCode());
    }

    public synchronized void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
        this.logDSI.log(1000000, "[FileBrowserManager] <- getViewWindowWithPreviewsResult(%1,%2, ...)", (long)n, (long)n2);
        AbstractFileBrowserSession abstractFileBrowserSession = this.getFileBrowser(n);
        if (null != abstractFileBrowserSession) {
            abstractFileBrowserSession.getViewWindowWithPreviewsResult(n, n2, n3, browsedFileSet, previewInfoArray, n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
        this.getLogDSI().log(10000000, "[FileBrowserManger] <- createPreviewImageResult(%1,%2,%3)", (Object)resourceLocator, (Object)resourceLocator2, (long)n);
        Object object = this.previewLock;
        synchronized (object) {
            if (0 == n) {
                this.resultPreviewFileRL = resourceLocator2;
            }
            this.previewLock.notifyAll();
        }
    }

    public void cancelPreviewCreationResult(int n) {
        this.getLogDSI().log(10000000, "[FileBrowserManger] <- cancelPreviewCreationResult(%1)", (long)n);
        if (0 != n) {
            this.getLogDSI().log(1000000, "[FileBrowserManger].cancelPreviewCreationResult(): cancel preview creation failed (%1)", (long)n);
        }
    }
}

