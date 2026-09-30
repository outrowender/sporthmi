/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public interface IFileTransferListener {
    public boolean confirmFileTransfer(IFile var1);

    public void fileTransferBegin(IFile var1);

    public void fileTransferProgress(IFile var1);

    public void fileTransferComplete(IFile var1);

    public void fileTransferStatus(IFile var1);

    public void fileTransferError(IFile var1);
}

