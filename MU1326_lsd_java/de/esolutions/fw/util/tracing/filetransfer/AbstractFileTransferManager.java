/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferReceiver;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferSender;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractFileTransferManager
implements IFileTransferReceiver {
    protected int blockSize;
    protected byte hashType;
    protected String downloadDirectory;
    protected IFileTransferSender fileTransferSender = null;
    protected IFileFactory fileFactory = null;
    protected ArrayList listeners = new ArrayList();

    public String getDownloadDirectory() {
        return this.downloadDirectory;
    }

    public void registerListener(IFileTransferListener iFileTransferListener) {
        if (!this.listeners.contains(iFileTransferListener)) {
            this.listeners.add(iFileTransferListener);
        }
    }

    public void unregisterListener(IFileTransferListener iFileTransferListener) {
        if (this.listeners.contains(iFileTransferListener)) {
            this.listeners.remove(iFileTransferListener);
        }
    }

    protected void notifyListenerFileTransferBegin(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferBegin(iFile);
        }
    }

    protected void notifyListenerFileTransferComplete(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferComplete(iFile);
        }
    }

    protected void notifyListenerFileTransferError(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferError(iFile);
        }
    }

    protected void notifyListenerFileTransferStatus(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferStatus(iFile);
        }
    }

    protected void notifyListenerFileTransferProgress(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferProgress(iFile);
        }
    }

    protected boolean confirmFileTransfer(IFile iFile) {
        boolean bl = false;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IFileTransferListener iFileTransferListener = (IFileTransferListener)iterator.next();
            if (iFileTransferListener == null || !iFileTransferListener.confirmFileTransfer(iFile)) continue;
            bl = true;
        }
        return bl;
    }

    public void setFileTransferSender(IFileTransferSender iFileTransferSender) {
        this.fileTransferSender = iFileTransferSender;
    }

    public void setFileFactory(IFileFactory iFileFactory) {
        this.fileFactory = iFileFactory;
    }

    public abstract boolean uploadFile(IFile var1);

    public abstract boolean requestFileStatus(String var1, IFile var2);

    public abstract boolean requestFileDownload(String var1, IFile var2);

    public abstract boolean handleFileRequestMessage(int var1, String var2, byte var3);

    public abstract boolean handleFileStatusMessage(int var1, String var2, byte var3, long var4, long var6, byte var8, byte[] var9);

    public abstract boolean handleFileTransferMessage(int var1, int var2, byte var3, int var4, byte[] var5);
}

