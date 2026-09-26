/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class SDSDataBrowserCommandHandler
extends AbstractMediaTerminalComponent
implements ISDSCommandListener {
    private static final String LOGCLASS;
    private final LogChannel logChannel;
    private final IDataBrowserList browserList;

    public SDSDataBrowserCommandHandler(IMediaTerminal iMediaTerminal, LogChannel logChannel, IDataBrowserList iDataBrowserList) {
        super(iMediaTerminal);
        this.logChannel = logChannel;
        this.browserList = iDataBrowserList;
    }

    @Override
    public int[] getCommandIDs() {
        return new int[]{20003, 20001};
    }

    @Override
    public Object performCommand(int n, Map map) {
        Integer n2;
        switch (n) {
            case 20003: {
                this.logChannel.log(1078071040, "[%1.performCommand] SDS_COMMAND_DATA_START_BROWSING", (Object)"SDSDataBrowserCommandHandler");
                n2 = this.startBrowsing(map);
                break;
            }
            case 20001: {
                this.logChannel.log(1078071040, "[%1.performCommand] SDS_COMMAND_DATA_FOLDERUP", (Object)"SDSDataBrowserCommandHandler");
                n2 = this.folderUp();
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "[%1.performCommand] unsupported command %2", (Object)"SDSDataBrowserCommandHandler", (long)n);
                n2 = new Integer(11004);
            }
        }
        return n2;
    }

    private Integer startBrowsing(Map map) {
        DataBrowserListLocator dataBrowserListLocator;
        Integer n = (Integer)map.get("BROWSE_TYPE");
        if (n == null) {
            return new Integer(11003);
        }
        switch (n) {
            case 3: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_ALBUM", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(3, 0);
                break;
            }
            case 4: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_TITLE", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(2, 0);
                break;
            }
            case 2: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_ARTIST", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(4, 0);
                break;
            }
            case 1: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_STRUCTURE", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(1, 0);
                break;
            }
            case 7: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_IPOD_AUDIOBOOKS", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(9, 0);
                break;
            }
            case 8: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_IPOD_COMPOSERS", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(10, 0);
                break;
            }
            case 10: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_GENRE", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(5, 0);
                break;
            }
            case 5: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_PLAYLIST", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(6, 0);
                break;
            }
            case 9: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_IPOD_PODCASTS", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(8, 0);
                break;
            }
            case 6: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_VIDEO", (Object)"SDSDataBrowserCommandHandler");
                dataBrowserListLocator = new DataBrowserListLocator(7, 0);
                break;
            }
            case 11: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] BROWSE_TYPE_FAVORITE", (Object)"SDSDataBrowserCommandHandler");
                this.getChoiceModel(-1274084608).setValue(11);
                return new Integer(11001);
            }
            default: {
                this.logChannel.log(1078071040, "[%1.startBrowsing] Type not supported.", (Object)"SDSDataBrowserCommandHandler");
                return new Integer(11003);
            }
        }
        this.browserList.selectBrowseListPath(dataBrowserListLocator);
        return new Integer(11001);
    }

    private Integer folderUp() {
        if (!this.browserList.isReady()) {
            this.logChannel.log(1078071040, "[%1.folderUp] browser not ready", (Object)"SDSDataBrowserCommandHandler");
            return new Integer(21002);
        }
        if (!this.browserList.changeToParentFolder()) {
            this.logChannel.log(1078071040, "[%1.folderUp] root level reached", (Object)"SDSDataBrowserCommandHandler");
            return new Integer(21001);
        }
        this.logChannel.log(1078071040, "[%1.folderUp] successful", (Object)"SDSDataBrowserCommandHandler");
        return new Integer(11001);
    }
}

