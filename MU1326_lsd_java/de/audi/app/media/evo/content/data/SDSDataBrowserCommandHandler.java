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
    private static final String LOGCLASS = "SDSDataBrowserCommandHandler";
    private final LogChannel logChannel;
    private final IDataBrowserList browserList;

    public SDSDataBrowserCommandHandler(IMediaTerminal iMediaTerminal, LogChannel logChannel, IDataBrowserList iDataBrowserList) {
        super(iMediaTerminal);
        this.logChannel = logChannel;
        this.browserList = iDataBrowserList;
    }

    public int[] getCommandIDs() {
        return new int[]{20003, 20001};
    }

    public Object performCommand(int n, Map map) {
        Integer n2;
        switch (n) {
            case 20003: {
                this.logChannel.log(1000000, "[%1.performCommand] SDS_COMMAND_DATA_START_BROWSING", (Object)LOGCLASS);
                n2 = this.startBrowsing(map);
                break;
            }
            case 20001: {
                this.logChannel.log(1000000, "[%1.performCommand] SDS_COMMAND_DATA_FOLDERUP", (Object)LOGCLASS);
                n2 = this.folderUp();
                break;
            }
            default: {
                this.logChannel.log(100000, "[%1.performCommand] unsupported command %2", (Object)LOGCLASS, (long)n);
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
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_ALBUM", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(3, 0);
                break;
            }
            case 4: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_TITLE", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(2, 0);
                break;
            }
            case 2: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_ARTIST", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(4, 0);
                break;
            }
            case 1: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_STRUCTURE", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(1, 0);
                break;
            }
            case 7: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_IPOD_AUDIOBOOKS", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(9, 0);
                break;
            }
            case 8: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_IPOD_COMPOSERS", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(10, 0);
                break;
            }
            case 10: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_GENRE", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(5, 0);
                break;
            }
            case 5: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_PLAYLIST", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(6, 0);
                break;
            }
            case 9: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_IPOD_PODCASTS", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(8, 0);
                break;
            }
            case 6: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_VIDEO", (Object)LOGCLASS);
                dataBrowserListLocator = new DataBrowserListLocator(7, 0);
                break;
            }
            case 11: {
                this.logChannel.log(1000000, "[%1.startBrowsing] BROWSE_TYPE_FAVORITE", (Object)LOGCLASS);
                this.getChoiceModel(200628).setValue(11);
                return new Integer(11001);
            }
            default: {
                this.logChannel.log(1000000, "[%1.startBrowsing] Type not supported.", (Object)LOGCLASS);
                return new Integer(11003);
            }
        }
        this.browserList.selectBrowseListPath(dataBrowserListLocator);
        return new Integer(11001);
    }

    private Integer folderUp() {
        if (!this.browserList.isReady()) {
            this.logChannel.log(1000000, "[%1.folderUp] browser not ready", (Object)LOGCLASS);
            return new Integer(21002);
        }
        if (!this.browserList.changeToParentFolder()) {
            this.logChannel.log(1000000, "[%1.folderUp] root level reached", (Object)LOGCLASS);
            return new Integer(21001);
        }
        this.logChannel.log(1000000, "[%1.folderUp] successful", (Object)LOGCLASS);
        return new Integer(11001);
    }
}

