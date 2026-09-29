/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.filebrowser.FileBrowserManager;
import de.audi.tghu.filebrowser.FileListRow;
import de.audi.tghu.filebrowser.IFileBrowser;
import de.audi.tghu.filebrowser.IFileBrowserSession;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;

public abstract class AbstractFileBrowserSession
implements IFileBrowserSession,
DSIFileBrowserListener {
    private final FileBrowserManager manager;
    private final int session;
    private Path currentPath;
    private int typeFilter = 0;
    private String[] allowedExtensions = null;

    AbstractFileBrowserSession(FileBrowserManager fileBrowserManager, int n, Path path, String[] stringArray) {
        this.manager = fileBrowserManager;
        this.session = n;
        this.setCurrentPath(path);
        if (stringArray != null) {
            this.setFileExtensionFilter(stringArray);
        }
    }

    AbstractFileBrowserSession(FileBrowserManager fileBrowserManager, int n, Path path, boolean bl) {
        this.manager = fileBrowserManager;
        this.session = n;
        this.setCurrentPath(path);
        if (bl) {
            this.setFileTypeFilter(1);
        }
    }

    final DSIFileBrowser getDSI() {
        return this.manager.getDSI();
    }

    final LogChannel getLog() {
        return this.manager.getLog();
    }

    final LogChannel getLogDSI() {
        return this.manager.getLogDSI();
    }

    final IFrameworkAccess getFramework() {
        return this.manager.getFramework();
    }

    final String path2String(Path path) {
        Buffer buffer = new Buffer(128);
        buffer.append(path.getMountPoint());
        String[] stringArray = path.getFolderNames();
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                buffer.append('/');
                buffer.append(stringArray[i2]);
            }
        }
        return buffer.toString();
    }

    final String cwd2String(Path path) {
        String[] stringArray = path.getFolderNames();
        if (null == stringArray || 0 == stringArray.length) {
            return "/";
        }
        return stringArray[stringArray.length - 1];
    }

    final ListRow[] fileSet2ListRows(BrowsedFileSet browsedFileSet, int n) {
        BrowsedFile[] browsedFileArray = browsedFileSet.getFiles();
        ListRow[] listRowArray = new ListRow[browsedFileArray.length];
        for (int i2 = 0; i2 < browsedFileArray.length; ++i2) {
            listRowArray[i2] = new FileListRow(browsedFileArray[i2], n + i2);
        }
        return listRowArray;
    }

    final Path cdPath(Path path, String string) {
        this.getLog().log(-2137614336, "cdPath(%1,\"%2\")", (Object)path, (Object)string);
        Path path2 = path;
        String[] stringArray = path.getFolderNames();
        if (".".equals(string)) {
            this.getLog().log(-2137614336, "cd(.) is a noop!");
        } else if ("..".equals(string)) {
            if (stringArray.length > 0) {
                String[] stringArray2 = new String[stringArray.length - 1];
                System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, stringArray.length - 1);
                path2 = new Path(path.getMountPoint(), stringArray2);
                this.getLog().log(-2137614336, "cd(..) to %1", (Object)path2);
            } else {
                this.getLog().log(-2137614336, "cd(..) already at top level!");
            }
        } else {
            String[] stringArray3 = new String[stringArray.length + 1];
            System.arraycopy((Object)stringArray, 0, (Object)stringArray3, 0, stringArray.length);
            stringArray3[stringArray.length] = string;
            path2 = new Path(path.getMountPoint(), stringArray3);
            this.getLog().log(-2137614336, "cd( %1 ) to %2", (Object)string, (Object)path2);
        }
        return path2;
    }

    final void setCurrentPath(Path path) {
        this.currentPath = path;
    }

    @Override
    public final int getSession() {
        return this.session;
    }

    @Override
    public void close() {
        this.manager.close(this.getSession());
    }

    @Override
    public final Path pwd() {
        return this.currentPath;
    }

    @Override
    public final IFileBrowser getSelection() {
        return this.manager.getSelection(this, true);
    }

    @Override
    public final void setFileTypeFilter(int n) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.typeFilter = n;
            this.getLogDSI().log(1078071040, "-> setFileTypeFilter(%2,%1)", (long)n, (long)this.getSession());
            dSIFileBrowser.setFileTypeFilter(this.getSession(), n);
        }
    }

    @Override
    public final int getFileTypeFilter() {
        return this.typeFilter;
    }

    @Override
    public final void setFileExtensionFilter(String[] stringArray) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.allowedExtensions = stringArray;
            this.getLogDSI().log(1078071040, "-> setFileExtensionFilter(%2,%1)", (Object)stringArray, (long)this.getSession());
            dSIFileBrowser.setFileExtensionFilter(this.getSession(), stringArray);
        }
    }

    @Override
    public final String[] getFileExtensionFilter() {
        return this.allowedExtensions;
    }

    public void startSpeller() {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1078071040, "-> startSpeller(%1)", (long)this.getSession());
            dSIFileBrowser.startSpeller(this.getSession(), 42);
        }
    }

    public void stopSpeller() {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1078071040, "-> stopSpeller(%1)", (long)this.getSession());
            dSIFileBrowser.stopSpeller(this.getSession());
        }
    }
}

