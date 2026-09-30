/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;

public interface IFile {
    public boolean open(boolean var1);

    public boolean write(byte[] var1);

    public boolean close();

    public byte[] read(int var1);

    public String getLocalPath();

    public String getRemotePath();

    public boolean isHashValid();

    public boolean isAvailable();

    public boolean isFile();

    public boolean isUpload();

    public boolean isReadable();

    public boolean hasError();

    public FileTransferError getError();

    public String getFilename();

    public long getTimestamp();

    public long getSize();

    public long getCompleteSize();

    public long getOffset();

    public byte[] getFileHash();

    public long getId();
}

