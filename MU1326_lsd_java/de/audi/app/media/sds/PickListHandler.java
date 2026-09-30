/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.media.IMediaSDSService;
import org.dsi.ifc.global.ResourceLocator;

public class PickListHandler
extends AbstractMediaTerminalComponent {
    private static final int COL_ID = 0;
    private static final int COL_RECORDSET = 1;
    private static final int COL_NAME = 2;
    private static final int COL_ICON = 3;
    private static final int COL_NAME_SECOND_ROW = 4;
    private static final int MAX_COL_SOURCE_WITH_ICON = 4;
    private static final int MAX_COL_SOURCE_WITHOUT_ICON = 3;
    private static final int MAX_COL_BROWSER = 5;
    static final int REC_NAME = 0;
    static final int REC_NAME_ICON = 1;
    static final int REC_TITLE_WITH_ICON = 2;
    static final int REC_ALBUM_WITH_ICON = 3;
    static final int REC_ARTIST_WITH_ICON = 4;
    static final int REC_TITLE_WITH_ICON_2L = 5;
    static final int REC_ALBUM_WITH_ICON_2L = 6;
    static final int ICON_CD = 0;
    static final int ICON_DVD = 1;
    static final int ICON_SD = 2;
    static final int ICON_SD1 = 3;
    static final int ICON_SD2 = 4;
    static final int ICON_USB = 5;
    static final int ICON_USB1 = 6;
    static final int ICON_USB1_1 = 7;
    static final int ICON_USB1_2 = 8;
    static final int ICON_USB2 = 9;
    static final int ICON_USB2_1 = 10;
    static final int ICON_USB2_2 = 11;
    static final int ICON_BT = 12;
    static final int ICON_WLAN = 13;
    private static final IntMap SDSICONMAP = new IntMap(35);

    public PickListHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void fillBrowserPickList(IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray, int n) {
        BaseListModelApp baseListModelApp = this.getBaseListModel(254);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < mediaSDSListEntryArray.length; ++i2) {
            IMediaSDSService.MediaSDSListEntry mediaSDSListEntry = mediaSDSListEntryArray[i2];
            ResourceLocator resourceLocator = mediaSDSListEntry.getCover();
            EvoListRow evoListRow = new EvoListRow(mediaSDSListEntry.getId(), 5);
            evoListRow.setLong(0, mediaSDSListEntry.getId());
            evoListRow.setInteger(1, this.getBrowserRecordSet(mediaSDSListEntry, n));
            evoListRow.setText(2, mediaSDSListEntry.getName());
            evoListRow.setText(4, mediaSDSListEntry.getNameSecondRow());
            evoListRow.setText(3, null == resourceLocator ? null : resourceLocator.getUrl());
            baseListModelApp2.append(evoListRow);
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private int getBrowserRecordSet(IMediaSDSService.MediaSDSListEntry mediaSDSListEntry, int n) {
        int n2;
        if (!this.getTerminal().getFramework().isPorsche()) {
            n2 = 0;
        } else {
            boolean bl = null != mediaSDSListEntry.getNameSecondRow();
            switch (n) {
                case 1: {
                    n2 = bl ? 6 : 3;
                    break;
                }
                case 2: {
                    n2 = 4;
                    break;
                }
                case 3: {
                    n2 = bl ? 5 : 2;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    public void fillSourcePickList(IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray) {
        BaseListModelApp baseListModelApp = this.getBaseListModel(254);
        ISourceController iSourceController = this.getTerminal().getSourceController();
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < mediaSDSListEntryArray.length; ++i2) {
            EvoListRow evoListRow;
            int n;
            IMediaSDSService.MediaSDSListEntry mediaSDSListEntry = mediaSDSListEntryArray[i2];
            ISource iSource = iSourceController.getSource(mediaSDSListEntry.getSourceID());
            if (iSource == null) {
                n = -1;
            } else {
                ISourceSlot iSourceSlot = iSource.getSlot(mediaSDSListEntry.getSlot());
                n = PickListHandler.getSdsIcon(MediaUtils.getHMISourceIcon(iSourceSlot));
            }
            if (n == -1) {
                evoListRow = new EvoListRow(mediaSDSListEntry.getId(), 3);
                evoListRow.setInteger(1, 0);
            } else {
                evoListRow = new EvoListRow(mediaSDSListEntry.getId(), 4);
                evoListRow.setInteger(1, 1);
                evoListRow.setInteger(3, n);
            }
            evoListRow.setLong(0, mediaSDSListEntry.getId());
            evoListRow.setText(2, mediaSDSListEntry.getName());
            baseListModelApp2.append(evoListRow);
        }
        baseListModelApp.update(baseListModelApp2);
    }

    static int getSdsIcon(int n) {
        try {
            return SDSICONMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return -1;
        }
    }

    static {
        SDSICONMAP.put(1, 0);
        SDSICONMAP.put(2, 0);
        SDSICONMAP.put(3, 0);
        SDSICONMAP.put(4, 0);
        SDSICONMAP.put(5, 0);
        SDSICONMAP.put(6, 0);
        SDSICONMAP.put(7, 0);
        SDSICONMAP.put(8, 0);
        SDSICONMAP.put(9, 1);
        SDSICONMAP.put(10, 1);
        SDSICONMAP.put(11, 1);
        SDSICONMAP.put(12, 1);
        SDSICONMAP.put(13, 1);
        SDSICONMAP.put(14, 1);
        SDSICONMAP.put(15, 1);
        SDSICONMAP.put(16, 1);
        SDSICONMAP.put(17, 2);
        SDSICONMAP.put(18, 3);
        SDSICONMAP.put(19, 4);
        SDSICONMAP.put(21, 5);
        SDSICONMAP.put(22, 6);
        SDSICONMAP.put(23, 7);
        SDSICONMAP.put(24, 8);
        SDSICONMAP.put(27, 9);
        SDSICONMAP.put(28, 10);
        SDSICONMAP.put(29, 11);
        SDSICONMAP.put(35, 12);
        SDSICONMAP.put(37, 13);
    }
}

