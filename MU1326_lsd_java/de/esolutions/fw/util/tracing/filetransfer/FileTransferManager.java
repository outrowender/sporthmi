/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager;
import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.IExtendedFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferConstants;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class FileTransferManager
extends AbstractFileTransferManager {
    private HashMap fileTransferRequestObjects = new HashMap();
    private HashMap fileTransferUploadObjects = new HashMap();
    private final Object mapSynchronisation = new Object();
    private final FileTransferUtils.RequestIdPool requestIdPool = new FileTransferUtils.RequestIdPool();

    private boolean isIgnored(FileTransferObject fileTransferObject) {
        return fileTransferObject.ignore;
    }

    private void ignoreFile(FileTransferObject fileTransferObject) {
        fileTransferObject.ignore = true;
    }

    public FileTransferManager(int n, byte by, String string) {
        this.blockSize = n;
        this.hashType = by;
        this.downloadDirectory = string;
        this.printStartUp();
    }

    public FileTransferManager(int n, byte by, String string, IFileFactory iFileFactory) {
        this.blockSize = n;
        this.hashType = by;
        this.downloadDirectory = string;
        this.fileFactory = iFileFactory;
        this.printStartUp();
    }

    private void printStartUp() {
        System.out.println("FileTransferManager started ");
        System.out.println("using: blockSize         = " + this.blockSize);
        System.out.println("       hashType          = " + this.hashType);
        System.out.println("       downloadDirectory = " + this.downloadDirectory);
    }

    public boolean uploadFile(IFile iFile) {
        int n = this.requestIdPool.getId(FileTransferConstants.OPERATION_UPLOAD);
        try {
            boolean bl = iFile.open(false);
            if (bl) {
                byte by = (byte)(FileTransferConstants.FLAG_FILE_UPLOAD | FileTransferConstants.FLAG_STATUS_AVAILABLE | FileTransferConstants.FLAG_STATUS_IS_FILE | FileTransferConstants.FLAG_STATUS_READABLE);
                ((IExtendedFile)iFile).setFlag(by);
                this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, iFile.getSize(), iFile.getTimestamp(), this.hashType, new byte[0]);
                this.notifyListenerFileTransferBegin(iFile);
                this.sendFileTransferMessages(n, iFile, FileTransferConstants.FLAG_FILE_UPLOAD);
                iFile.close();
                iFile.open(false);
                byte[] byArray = FileTransferUtils.calculateHash(this.hashType, iFile);
                iFile.close();
                this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, iFile.getSize(), iFile.getTimestamp(), this.hashType, byArray);
                this.notifyListenerFileTransferComplete(iFile);
                this.requestIdPool.releaseId(n);
                return true;
            }
            ((IExtendedFile)iFile).setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iFile);
            return false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            IExtendedFile iExtendedFile = (IExtendedFile)iFile;
            iExtendedFile.setError(new FileTransferError(30, exception));
            this.notifyListenerFileTransferError(iFile);
            this.requestIdPool.releaseId(n);
            return false;
        }
    }

    public boolean requestFileStatus(String string, IFile iFile) {
        if (iFile == null) {
            String string2 = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
            iFile = this.fileFactory.createFile(string2);
        }
        ((IExtendedFile)iFile).setPath(string);
        return this.sendRequest(string, iFile, FileTransferConstants.OPERATION_STATUS);
    }

    public boolean requestFileDownload(String string, IFile iFile) {
        if (iFile == null) {
            String string2 = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
            iFile = this.fileFactory.createFile(string2);
        }
        ((IExtendedFile)iFile).setPath(string);
        return this.sendRequest(string, iFile, FileTransferConstants.OPERATION_DOWNLOAD);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendRequest(String string, IFile iFile, byte by) {
        if (this.fileTransferSender == null) {
            return false;
        }
        int n = this.requestIdPool.getId(by);
        try {
            this.fileTransferSender.sendFileRequest(n, string, by);
            Object object = this.mapSynchronisation;
            synchronized (object) {
                FileTransferObject fileTransferObject = new FileTransferObject((IExtendedFile)iFile);
                fileTransferObject.operation = by;
                this.fileTransferRequestObjects.put(new Integer(n), fileTransferObject);
            }
            return true;
        }
        catch (Exception exception) {
            ((IExtendedFile)iFile).setError(new FileTransferError(30, exception));
            this.notifyListenerFileTransferError(iFile);
            this.requestIdPool.releaseId(n);
            return false;
        }
    }

    public boolean handleFileRequestMessage(int n, String string, byte by) {
        IFile iFile = this.fileFactory.createFile(string);
        boolean bl = iFile.open(false);
        try {
            if (bl) {
                if (FileTransferConstants.OPERATION_DOWNLOAD == by) {
                    this.fileDownloadRequest(n, iFile);
                } else if (FileTransferConstants.OPERATION_STATUS == by) {
                    this.fileStatusRequest(n, iFile);
                }
                iFile.close();
            } else {
                ((IExtendedFile)iFile).setError(new FileTransferError(10));
                this.fileStatusRequest(n, iFile);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean handleInitExitMessage() {
        this.cleanTransferObjects();
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cleanTransferObjects() {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            this.cleanAllTransferObjects(this.fileTransferRequestObjects.values());
            this.cleanAllTransferObjects(this.fileTransferUploadObjects.values());
            this.fileTransferRequestObjects = null;
            this.fileTransferUploadObjects = null;
            this.fileTransferRequestObjects = new HashMap();
            this.fileTransferUploadObjects = new HashMap();
        }
    }

    private void cleanAllTransferObjects(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            FileTransferObject fileTransferObject = (FileTransferObject)iterator.next();
            fileTransferObject.file.setError(new FileTransferError(60));
            this.notifyListenerFileTransferError(fileTransferObject.file);
        }
    }

    private boolean fileDownloadRequest(int n, IFile iFile) throws IOException, TransportException, InterruptedException {
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, false);
        this.sendFileTransferMessages(n, iFile, FileTransferConstants.FLAG_NOTHING_SET);
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, true);
        return true;
    }

    private boolean fileStatusRequest(int n, IFile iFile) throws IOException, TransportException, InterruptedException {
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, true);
        return true;
    }

    private boolean firstFileTransferStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferObject fileTransferObject) {
        IExtendedFile iExtendedFile = fileTransferObject.file;
        this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
        if (!this.confirmFileTransfer(iExtendedFile)) {
            this.ignoreFile(fileTransferObject);
            fileTransferObject.firstStatusRunDone = true;
            return true;
        }
        this.notifyListenerFileTransferBegin(iExtendedFile);
        iExtendedFile.open(true);
        fileTransferObject.firstStatusRunDone = true;
        return true;
    }

    private boolean lastFileTransferStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferObject fileTransferObject, HashMap hashMap) {
        boolean bl = true;
        try {
            IExtendedFile iExtendedFile = fileTransferObject.file;
            if (this.isIgnored(fileTransferObject)) {
                return true;
            }
            this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
            if (!iExtendedFile.hasError()) {
                iExtendedFile.open(false);
                byte[] byArray2 = FileTransferUtils.calculateHash(by2, iExtendedFile);
                boolean bl2 = Arrays.equals(byArray2, byArray);
                iExtendedFile.setValidHash(bl2);
                iExtendedFile.close();
                this.notifyListenerFileTransferComplete(iExtendedFile);
                this.removeTransferId(hashMap, n);
            } else {
                iExtendedFile.setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(iExtendedFile);
                bl = false;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            IExtendedFile iExtendedFile = fileTransferObject.file;
            iExtendedFile.setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iExtendedFile);
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean fileStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferObject fileTransferObject, HashMap hashMap) {
        boolean bl = true;
        IExtendedFile iExtendedFile = fileTransferObject.file;
        try {
            iExtendedFile.open(true);
            this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
            iExtendedFile.close();
            if (!iExtendedFile.hasError()) {
                this.notifyListenerFileTransferStatus(iExtendedFile);
            }
        }
        catch (Exception exception) {
            iExtendedFile.setError(new FileTransferError(exception));
        }
        finally {
            if (iExtendedFile.hasError()) {
                iExtendedFile.setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(iExtendedFile);
                bl = false;
            }
        }
        this.removeTransferId(hashMap, n);
        return bl;
    }

    private void setFileStatus(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, IExtendedFile iExtendedFile) {
        if (string != null && string.trim().length() > 0) {
            iExtendedFile.setPath(string);
        }
        iExtendedFile.setFlag(by);
        iExtendedFile.setTimestamp(l2);
        iExtendedFile.setHashType(by2);
        iExtendedFile.setHash(byArray);
        iExtendedFile.setSize(0L);
        iExtendedFile.setCompleteSize(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FileTransferObject findFileTransferObject(int n, byte by) {
        FileTransferObject fileTransferObject = null;
        Object object = this.mapSynchronisation;
        synchronized (object) {
            if (this.isUpload(by)) {
                boolean bl = !this.fileTransferUploadObjects.containsKey(new Integer(n));
                fileTransferObject = this.findFileObject(n, this.fileTransferUploadObjects);
                fileTransferObject.firstStatusRunDone = !bl;
            } else {
                fileTransferObject = this.findFileObject(n, this.fileTransferRequestObjects);
            }
        }
        return fileTransferObject;
    }

    public boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        boolean bl = this.isUpload(by);
        boolean bl2 = true;
        HashMap hashMap = this.findFileTransferMap(by);
        FileTransferObject fileTransferObject = this.findFileTransferObject(n, by);
        if (this.fileTransferSender == null && !bl) {
            fileTransferObject.operation = FileTransferConstants.OPERATION_DOWNLOAD;
        }
        if (fileTransferObject.operation == FileTransferConstants.OPERATION_STATUS) {
            return this.fileStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferObject, hashMap);
        }
        if (fileTransferObject.file.hasError() || this.hasFlag(by, FileTransferConstants.FLAG_STATUS_ERROR)) {
            if (this.hasFlag(by, FileTransferConstants.FLAG_STATUS_ERROR)) {
                this.setFileStatus(n, string, by, l, l2, by2, byArray, fileTransferObject.file);
                fileTransferObject.file.setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(fileTransferObject.file);
            }
            this.removeTransferId(hashMap, n);
            return false;
        }
        if (fileTransferObject.operation == FileTransferConstants.OPERATION_DOWNLOAD || bl) {
            if (!fileTransferObject.firstStatusRunDone) {
                bl2 = this.firstFileTransferStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferObject);
            } else {
                fileTransferObject.file.close();
                bl2 = this.lastFileTransferStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferObject, hashMap);
            }
        }
        return bl2;
    }

    public boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
        HashMap hashMap = this.findFileTransferMap(by);
        FileTransferObject fileTransferObject = this.findFileObject(n, hashMap);
        if (this.isIgnored(fileTransferObject)) {
            return true;
        }
        IExtendedFile iExtendedFile = fileTransferObject.file;
        if (iExtendedFile.hasError()) {
            return false;
        }
        if (!this.isFirstBlock(by) && n2 == 0 || this.isFirstBlock(by) && n2 != 0) {
            iExtendedFile.setError(new FileTransferError(40, "first block and blocknumber mismatch "));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (fileTransferObject.lastBlock != n2 - 1) {
            iExtendedFile.setError(new FileTransferError(40, "wrong block number received"));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (fileTransferObject.lastBlockFlagReceived) {
            iExtendedFile.setError(new FileTransferError(40, " previously last block received"));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (this.isFirstBlock(by) && !fileTransferObject.firstStatusRunDone) {
            iExtendedFile.setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (this.isLastBlock(by)) {
            fileTransferObject.lastBlockFlagReceived = true;
        }
        fileTransferObject.lastBlock = n2;
        iExtendedFile.write(byArray);
        this.notifyListenerFileTransferProgress(iExtendedFile);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FileTransferObject findFileObject(int n, HashMap hashMap) {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            FileTransferObject fileTransferObject = null;
            if (hashMap.containsKey(new Integer(n))) {
                fileTransferObject = (FileTransferObject)hashMap.get(new Integer(n));
            } else {
                String string = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
                IFile iFile = this.fileFactory.createFile(string);
                fileTransferObject = new FileTransferObject((IExtendedFile)iFile);
                hashMap.put(new Integer(n), fileTransferObject);
            }
            return fileTransferObject;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HashMap findFileTransferMap(byte by) {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            HashMap hashMap = this.fileTransferRequestObjects;
            if (this.isUpload(by)) {
                hashMap = this.fileTransferUploadObjects;
            }
            return hashMap;
        }
    }

    private boolean sendFileTransferStatus(int n, IFile iFile, byte by, boolean bl) throws IOException, TransportException, InterruptedException {
        if (iFile.hasError()) {
            by = (byte)(by | FileTransferConstants.FLAG_STATUS_ERROR);
            this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, 0L, 0L, this.hashType, new byte[0]);
        } else {
            if (iFile.isAvailable()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_AVAILABLE);
            }
            if (iFile.isFile()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_IS_FILE);
            }
            if (iFile.isReadable()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_READABLE);
            }
            long l = iFile.getSize();
            long l2 = iFile.getTimestamp();
            byte[] byArray = new byte[]{};
            if (!bl) {
                byArray = FileTransferUtils.calculateHash(this.hashType, iFile);
            }
            this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, l, l2, this.hashType, byArray);
        }
        return true;
    }

    private boolean sendFileTransferMessages(int n, IFile iFile, byte by) throws IOException, TransportException, InterruptedException {
        int n2 = 0;
        byte[] byArray = null;
        do {
            byte by2 = by;
            if (n2 == 0) {
                by2 = (byte)(by2 | FileTransferConstants.FLAG_TRANSFER_FIRST_BLOCK);
            }
            if ((byArray = iFile.read(this.blockSize)) != null) {
                if (iFile.getOffset() == iFile.getSize()) {
                    by2 = (byte)(by2 | FileTransferConstants.FLAG_TRANSFER_LAST_BLOCK);
                }
            } else {
                return false;
            }
            this.notifyListenerFileTransferProgress(iFile);
            this.fileTransferSender.sendFileTransfer(n, n2, by2, byArray.length, byArray);
            ++n2;
        } while (iFile.getOffset() < iFile.getSize());
        return true;
    }

    private void removeTransferId(HashMap hashMap, int n) {
        this.requestIdPool.releaseId(n);
        hashMap.remove(new Integer(n));
    }

    private boolean isLastBlock(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_TRANSFER_LAST_BLOCK);
    }

    private boolean isFirstBlock(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_TRANSFER_FIRST_BLOCK);
    }

    private boolean isUpload(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_FILE_UPLOAD);
    }

    private boolean hasFlag(byte by, byte by2) {
        return (by & by2) == by2;
    }

    public boolean reset(String string) {
        this.cleanTransferObjects();
        this.downloadDirectory = string;
        return true;
    }

    private static class FileTransferObject {
        private final IExtendedFile file;
        private boolean ignore = false;
        private int lastBlock = -1;
        private boolean lastBlockFlagReceived = false;
        private boolean firstStatusRunDone = false;
        private byte operation = (byte)-1;

        public FileTransferObject(IExtendedFile iExtendedFile) {
            this.file = iExtendedFile;
        }
    }
}

