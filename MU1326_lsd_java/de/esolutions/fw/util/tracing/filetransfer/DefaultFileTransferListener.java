/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public class DefaultFileTransferListener
extends AbstractFileTransferListener
implements IFileTransferListener {
    public void fileTransferBegin(IFile iFile) {
        System.out.println("FileTransfer Begin");
        System.out.println("  Object:          " + iFile);
        System.out.println("  Class:           " + iFile.getClass().getName());
        System.out.println("  RemotePath:      " + iFile.getRemotePath());
        System.out.println("  LocalPath:       " + iFile.getLocalPath());
    }

    public void fileTransferStatus(IFile iFile) {
        System.out.println("FileStatus");
        System.out.println("  Object:          " + iFile);
        System.out.println("  Class:           " + iFile.getClass().getName());
        System.out.println("  RemotePath:      " + iFile.getRemotePath());
        System.out.println("  LocalPath:       " + iFile.getLocalPath());
        System.out.println("  Size:            " + iFile.getSize());
        System.out.println("  Timestamp:       " + iFile.getTimestamp());
        System.out.println("  HashValid:       " + iFile.isHashValid());
        System.out.println("  isAvailable:     " + iFile.isAvailable());
        System.out.println("  isFile:          " + iFile.isFile());
        System.out.println("  isReadable:      " + iFile.isReadable());
        System.out.println("  isUpload:        " + iFile.isUpload());
        System.out.println("  hasError:        " + iFile.hasError());
        if (iFile.hasError() && iFile.getError() != null) {
            System.out.println("####### ERROR #######");
            System.out.println("  errorMessage:    " + iFile.getError().getErrorMessage());
            System.out.println("  errorCode:       " + iFile.getError().getErrorCode());
            System.out.println("  Exception:       " + iFile.getError().getException());
        }
    }

    public void fileTransferComplete(IFile iFile) {
        System.out.println("FileTransfer is complete");
        System.out.println("  Object:          " + iFile);
        System.out.println("  Class:           " + iFile.getClass().getName());
        System.out.println("  RemotePath:      " + iFile.getRemotePath());
        System.out.println("  LocalPath:       " + iFile.getLocalPath());
        System.out.println("  Size:            " + iFile.getSize());
        System.out.println("  Timestamp:       " + iFile.getTimestamp());
        System.out.println("  HashValid:       " + iFile.isHashValid());
        System.out.println("  isAvailable:     " + iFile.isAvailable());
        System.out.println("  isFile:          " + iFile.isFile());
        System.out.println("  isReadable:      " + iFile.isReadable());
        System.out.println("  isUpload:        " + iFile.isUpload());
        System.out.println("  hasError:        " + iFile.hasError());
        if (iFile.hasError() && iFile.getError() != null) {
            System.out.println("####### ERROR #######");
            System.out.println("  errorMessage:    " + iFile.getError().getErrorMessage());
            System.out.println("  errorCode:       " + iFile.getError().getErrorCode());
            System.out.println("  Exception:       " + iFile.getError().getException());
            iFile.getError().getException().printStackTrace();
        }
    }

    public void fileTransferProgress(IFile iFile) {
        System.out.println("FileTransfer Progress: " + iFile.getLocalPath() + ": " + iFile.getSize() + ", " + iFile.getOffset());
    }

    public void fileTransferError(IFile iFile) {
        if (iFile != null) {
            System.out.println("FileTransfer Error ");
            System.out.println("  Object:          " + iFile);
            System.out.println("  RemotePath:      " + iFile.getRemotePath());
            System.out.println("  LocalPath:       " + iFile.getLocalPath());
            System.out.println("  hasError:        " + iFile.hasError());
            System.out.println("  errorMessage:    " + iFile.getError().getErrorMessage());
            System.out.println("  errorCode:       " + iFile.getError().getErrorCode());
            System.out.println("  Exception:       " + iFile.getError().getException());
            System.out.println("  HashValid:       " + iFile.isHashValid());
            System.out.println("  isAvailable:     " + iFile.isAvailable());
            System.out.println("  isFile:          " + iFile.isFile());
            System.out.println("  isReadable:      " + iFile.isReadable());
        }
    }

    public void fileUploadComplete(IFile iFile) {
        System.out.println("FileTransfer Upload complete ");
        System.out.println("  Object:          " + iFile);
        System.out.println("  path:            " + iFile.getLocalPath());
    }
}

