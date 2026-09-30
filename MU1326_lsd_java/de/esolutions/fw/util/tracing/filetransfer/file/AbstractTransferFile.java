/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.IExtendedFile;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferConstants;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;

public abstract class AbstractTransferFile
implements IExtendedFile {
    protected boolean writable;
    protected boolean open = false;
    protected String remotePath;
    protected String localPath;
    protected long size = 0L;
    protected long completeSize = 0L;
    protected byte flag;
    protected byte userFlag;
    protected long timestamp;
    protected byte hashType;
    protected byte[] hash;
    protected String filename;
    protected boolean hashValid;
    protected long offset;
    protected FileTransferError errorObject;
    protected boolean error;
    protected long id;

    public AbstractTransferFile(String string) {
        this.localPath = string;
        this.id = FileTransferUtils.IdGenerator.getUniqueId();
    }

    public abstract boolean open(boolean var1);

    public abstract boolean write(byte[] var1);

    public abstract byte[] read(int var1);

    public abstract boolean close();

    public long getId() {
        return this.id;
    }

    public void setError(FileTransferError fileTransferError) {
        this.error = true;
        this.errorObject = fileTransferError;
    }

    public void setCompleteSize(long l) {
        this.completeSize = l;
    }

    public void setSize(long l) {
        this.size = l;
    }

    public void setPath(String string) {
        this.remotePath = string;
        this.filename = FileTransferUtils.getFileNameFromPath(string, FileTransferUtils.getSeperator(string));
    }

    public void setFlag(byte by) {
        this.flag = by;
    }

    public void setTimestamp(long l) {
        this.timestamp = l;
    }

    public void setHashType(byte by) {
        this.hashType = by;
    }

    public void setHash(byte[] byArray) {
        this.hash = byArray;
    }

    public void setValidHash(boolean bl) {
        this.hashValid = bl;
    }

    public long getSize() {
        return this.size;
    }

    public long getCompleteSize() {
        return this.completeSize;
    }

    public byte getFlag() {
        return this.flag;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public byte getHashType() {
        return this.hashType;
    }

    public byte[] getHash() {
        return this.hash;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean isHashValid() {
        return this.hashValid;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getRemotePath() {
        return this.remotePath;
    }

    public boolean isAvailable() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_AVAILABLE) == FileTransferConstants.FLAG_STATUS_AVAILABLE;
    }

    public boolean isFile() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_IS_FILE) == FileTransferConstants.FLAG_STATUS_IS_FILE;
    }

    public boolean isReadable() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_READABLE) == FileTransferConstants.FLAG_STATUS_READABLE;
    }

    public boolean hasError() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_ERROR) == FileTransferConstants.FLAG_STATUS_ERROR || this.error;
    }

    public boolean isUpload() {
        return (this.flag & FileTransferConstants.FLAG_FILE_UPLOAD) == FileTransferConstants.FLAG_FILE_UPLOAD;
    }

    public FileTransferError getError() {
        return this.errorObject;
    }

    public long getOffset() {
        return this.offset;
    }

    public byte[] getFileHash() {
        return this.hash;
    }

    public void setUserFlag(byte by) {
        this.userFlag = by;
    }

    public byte getUserFlag() {
        return this.userFlag;
    }

    public String toString() {
        String string = "TransferFile[class=" + this.getClass().getName() + ",filename=" + this.filename + ",localPath=" + this.localPath + ",remotePath=" + this.remotePath + ",flag=" + this.flag + ",size=" + this.size + ",completeSize" + this.completeSize + "]";
        return string;
    }
}

