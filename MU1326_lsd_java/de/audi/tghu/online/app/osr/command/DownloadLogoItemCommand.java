/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.OnlineLogoItem;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;

public class DownloadLogoItemCommand
extends AbstractOSRCommand {
    private String aRemoteLocationURL;
    private String aLocalFileLocation;
    private OnlineLogoItem logoItem;
    private LogChannel logger;
    private String tempFileLocation = null;

    public DownloadLogoItemCommand(LogChannel logChannel, String string, String string2, OnlineLogoItem onlineLogoItem) {
        this.logger = logChannel;
        logChannel.log(1000000, "DownloadLogoItemCommand#DownloadLogoItemCommand()");
        this.aRemoteLocationURL = string;
        this.aLocalFileLocation = string2;
        this.logoItem = onlineLogoItem;
    }

    public void execute() {
        this.logger.log(10000000, "DownloadLogoItemCommand#execute(): downloading %1 to %2", (Object)this.aRemoteLocationURL, (Object)this.aLocalFileLocation);
        if (this.getDSI() != null) {
            Buffer buffer = new Buffer(this.aLocalFileLocation);
            buffer.append("_TMP");
            this.tempFileLocation = buffer.toString();
            File file = new File(this.tempFileLocation);
            if (file.exists()) {
                file.delete();
            }
            this.getDSI().download("local_filedownloader", this.aRemoteLocationURL, this.tempFileLocation, 20000L, 500000L);
        } else {
            this.logger.log(10000, "DownloadLogoItemCommand#execute(): no DSI");
        }
    }

    public void downloadResponse(String string, String string2, String string3, int n) {
        this.logger.log(1000000, "DownloadLogoItemCommand#downloadResponse()");
        if (n == 1) {
            this.logger.log(10000000, "DownloadLogoItemCommand#downloadResponse() File downloaded successfully from %1 to %2.", (Object)string2, (Object)string3);
            File file = new File(this.tempFileLocation);
            File file2 = new File(this.aLocalFileLocation);
            if (file2.exists()) {
                file2.delete();
            }
            if (file.exists() && !file.renameTo(file2)) {
                this.logger.log(100000, "DownloadLogoItemCommand#downloadResponse() Could not rename file %1 to %2", (Object)file.toString(), (Object)file2.toString());
            }
            this.logoItem.updateFinished();
            this.logoItem.computeAndSetChecksum();
        } else {
            this.logger.log(100000, "DownloadLogoItemCommand#downloadResponse() File downloaded failed due to :%1.", (Object)this.errorCodeFileDownloadToText(n));
        }
        this.getCommandList().commandFinished();
    }

    private String errorCodeFileDownloadToText(int n) {
        this.logger.log(1000000, "DownloadLogoItemCommand#errorCodeFileDownloadToText()");
        String string = null;
        switch (n) {
            case 2: {
                string = "No service, can occure at startup";
                break;
            }
            case 3: {
                string = "Server error";
                break;
            }
            case 4: {
                string = "The resource point to a non file resource";
                break;
            }
            case 5: {
                string = "The resource is not writeable";
                break;
            }
            case 6: {
                string = "Timeout occure";
                break;
            }
            case 7: {
                string = "IO Error";
                break;
            }
            case 8: {
                string = "URL corrupt";
                break;
            }
            case 9: {
                string = "Request canceled";
                break;
            }
            case 10: {
                string = "Could not create the file";
                break;
            }
            case 11: {
                string = "Generic error";
                break;
            }
            default: {
                string = "Generic error";
            }
        }
        return string;
    }
}

