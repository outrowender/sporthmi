/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.AbstractFileBrowserSession;
import de.audi.tghu.filebrowser.FileBrowserManager;
import de.audi.tghu.filebrowser.IFileBrowser;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class FileBrowser
extends AbstractFileBrowserSession
implements IFileBrowser,
DSIFileBrowserListener {
    private int totalFileCount = 0;
    private int selectedFileCount = 0;
    private BrowsedFileSet resultFileSet = null;
    private ResourceLocator[] resultResources = null;
    private PreviewInfo[] resultPreviewInfo = null;
    private boolean responded = false;

    FileBrowser(FileBrowserManager fileBrowserManager, int n, Path path, String[] stringArray) {
        super(fileBrowserManager, n, path, stringArray);
    }

    FileBrowser(FileBrowserManager fileBrowserManager, int n, Path path, boolean bl) {
        super(fileBrowserManager, n, path, bl);
    }

    public final synchronized Path chdir(Path path) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> changeFolder(%2,%1)", (Object)path, (long)this.getSession());
            dSIFileBrowser.changeFolder(this.getSession(), path);
            this.selectedFileCount = 0;
            try {
                this.wait(5000L);
                if (!this.responded) {
                    this.getLog().log(10000, "changeFolder(%2, %1) timed out!", (Object)path, (long)this.getSession());
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "changeFolder(%2, %1) failed!", (Object)path, (long)this.getSession());
                this.getLog().log(10000, "Exception: ", (Throwable)exception);
            }
        }
        return this.pwd();
    }

    public synchronized int getSelectedFileCount() {
        return this.selectedFileCount;
    }

    public final synchronized int getFileCount() {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> getFileCount(%1)", (long)this.getSession());
            dSIFileBrowser.getFileCount(this.getSession());
            try {
                this.wait(5000L);
                if (!this.responded) {
                    this.getLog().log(10000, "getFileCount( %1 ) timed out!", (long)this.getSession());
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "getFileCount( %1 ) failed!", (long)this.getSession(), (Throwable)exception);
            }
        }
        return this.totalFileCount;
    }

    public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
    }

    public final synchronized BrowsedFileSet getFiles(int n, int n2) {
        this.resultFileSet = null;
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> getViewWindow(%1,%2,%3)", (long)this.getSession(), (long)n, (long)n2);
            dSIFileBrowser.getViewWindow(this.getSession(), n2, n);
            try {
                this.wait(5000L);
                if (!this.responded) {
                    this.getLog().log(10000, "getViewWindow( %1, %2, %3 ) timed out!", (long)this.getSession(), (long)n, (long)n2);
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "getViewWindow( %1, %2, %3 ) failed!", (long)this.getSession(), (long)n, (long)n2);
                this.getLog().log(10000, "Exception: ", (Throwable)exception);
            }
        }
        return this.resultFileSet;
    }

    public final synchronized ResourceLocator[] getResourceLocators(int n, int n2) {
        this.resultResources = null;
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> getResourceLocatorWindow(%1,%2,%3)", (long)this.getSession(), (long)n, (long)n2);
            dSIFileBrowser.getResourceLocatorWindow(this.getSession(), n2, n);
            try {
                this.wait(20000L);
                if (!this.responded) {
                    this.getLog().log(10000, "getResourceLocatorWindow( %1, %2, %3 ) timed out!", (long)this.getSession(), (long)n, (long)n2);
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "getResourceLocatorWindow( %1, %2, %3 ) failed!", (long)this.getSession(), (long)n, (long)n2);
                this.getLog().log(10000, "Exception: ", (Throwable)exception);
            }
        }
        return this.resultResources;
    }

    public final synchronized boolean selectFile(BrowsedFile browsedFile, boolean bl) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> setSelectionSingle(%3,%1,%2)", (Object)browsedFile, bl ? 1L : 0L, (long)this.getSession());
            dSIFileBrowser.setSelectionSingle(this.getSession(), browsedFile, bl);
            try {
                this.wait(5000L);
                if (!this.responded) {
                    this.getLog().log(10000, "setSelectionSingle(%2, %1) timed out!", (Object)browsedFile, (long)this.getSession());
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "setSelectionSingle(%2, %1) failed!", (Object)browsedFile, (long)this.getSession());
                this.getLog().log(10000, "Exception: ", (Throwable)exception);
            }
        }
        browsedFile.setSelected(bl);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PreviewInfo[] getFilesWithPreviews(int n, int n2, BrowsedFileSet browsedFileSet) {
        if (0 > n) {
            throw new IllegalArgumentException("IllegalOffset");
        }
        if (0 >= n2) {
            throw new IllegalArgumentException("IllegalNumber");
        }
        if (null == browsedFileSet) {
            throw new NullPointerException("NullFileSet");
        }
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            DSIFileBrowser dSIFileBrowser = this.getDSI();
            if (null != dSIFileBrowser) {
                this.resultFileSet = null;
                this.resultPreviewInfo = null;
                this.responded = false;
                this.getLogDSI().log(1000000, "[FileBrowser].getFilesWithPreviews(): -> getViewWindowWithPreviews(%1,%2,%3)", (long)this.getSession(), (long)n2, (long)n);
                dSIFileBrowser.getViewWindowWithPreviews(this.getSession(), n2, n);
                try {
                    this.wait(5000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                    this.getLogDSI().log(100000, "[FileBrowser].getFilesWithPreviews(): interrupted; session=%1", (long)this.getSession(), (Throwable)interruptedException);
                }
                if (!this.responded) {
                    this.getLogDSI().log(10000, "[FileBrowser].getFilesWithPreviews(): timeout; session=%1", (long)this.getSession());
                    return null;
                }
                if (null == this.resultFileSet) {
                    this.getLogDSI().log(10000, "[FileBrowser].getFilesWithPreviews(): null resultFileSet; session=%1", (long)this.getSession());
                    return null;
                }
                browsedFileSet.setFiles(this.resultFileSet.getFiles());
                browsedFileSet.setPath(this.resultFileSet.getPath());
                return this.resultPreviewInfo;
            }
            this.getLogDSI().log(10000, "[FileBrowser].getFilesWithPreviews(): null dsi; session=%1", (long)this.getSession());
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void changeFolderResult(int n, int n2, Path path) {
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            if (0 == n2 && n == this.getSession()) {
                this.responded = true;
                this.setCurrentPath(path);
            }
            this.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getFileCountResult(int n, int n2, int n3) {
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            if (0 == n2 && n == this.getSession()) {
                this.responded = true;
                this.totalFileCount = n3;
            }
            this.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            if (0 == n2 && n == this.getSession()) {
                this.responded = true;
                this.resultResources = resourceLocatorArray;
            }
            this.notifyAll();
        }
    }

    public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
    }

    public void getSelectedFilesResult(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            if (0 == n2) {
                this.responded = true;
                this.resultFileSet = browsedFileSet;
            }
            this.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void indicateSelectionResult(int n, int n2, int n3) {
        FileBrowser fileBrowser = this;
        synchronized (fileBrowser) {
            if (0 == n2 && n == this.getSession()) {
                this.responded = true;
                this.selectedFileCount = n3;
            }
            this.notifyAll();
        }
    }

    public void setFileExtensionFilterResult(int n, int n2) {
    }

    public void setFileTypeFilterResult(int n, int n2) {
    }

    public void setFileTypeActiveResult(int n) {
    }

    public void setLanguageResult(int n, String string) {
    }

    public void spellerResult(int n, int n2, String string, String string2) {
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
    }

    public void startResult(int n, int n2, Path path) {
    }

    public void asyncException(int n, String string, int n2) {
    }

    public synchronized void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
        if (0 == n2 && n == this.getSession()) {
            this.getLogDSI().log(1000000, "[FileBrowser].getViewWindowWithPreviewsResult(): <- got files with previews; session=%1", (long)this.getSession());
            this.responded = true;
            this.resultPreviewInfo = previewInfoArray;
            this.resultFileSet = browsedFileSet;
        }
        this.notifyAll();
    }

    public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
    }

    public void cancelPreviewCreationResult(int n) {
    }
}

