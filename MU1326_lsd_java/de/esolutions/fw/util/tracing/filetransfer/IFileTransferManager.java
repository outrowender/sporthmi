/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;

public interface IFileTransferManager {
    public void registerListener(IFileTransferListener var1);

    public void unregisterListener(IFileTransferListener var1);

    public void setFileFactory(IFileFactory var1);

    public String getDownloadDirectory();

    public boolean uploadFile(IFile var1);

    public boolean requestFileStatus(String var1, IFile var2);

    public boolean requestFileDownload(String var1, IFile var2);
}

