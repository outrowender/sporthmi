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
import de.audi.atip.interapp.media.IMediaSDSService$MediaSDSListEntry;
import org.dsi.ifc.global.ResourceLocator;

public class PickListHandler
extends AbstractMediaTerminalComponent {
    private static final int COL_ID;
    private static final int COL_RECORDSET;
    private static final int COL_NAME;
    private static final int COL_ICON;
    private static final int COL_NAME_SECOND_ROW;
    private static final int MAX_COL_SOURCE_WITH_ICON;
    private static final int MAX_COL_SOURCE_WITHOUT_ICON;
    private static final int MAX_COL_BROWSER;
    static final int REC_NAME;
    static final int REC_NAME_ICON;
    static final int REC_TITLE_WITH_ICON;
    static final int REC_ALBUM_WITH_ICON;
    static final int REC_ARTIST_WITH_ICON;
    static final int REC_TITLE_WITH_ICON_2L;
    static final int REC_ALBUM_WITH_ICON_2L;
    static final int ICON_CD;
    static final int ICON_DVD;
    static final int ICON_SD;
    static final int ICON_SD1;
    static final int ICON_SD2;
    static final int ICON_USB;
    static final int ICON_USB1;
    static final int ICON_USB1_1;
    static final int ICON_USB1_2;
    static final int ICON_USB2;
    static final int ICON_USB2_1;
    static final int ICON_USB2_2;
    static final int ICON_BT;
    static final int ICON_WLAN;
    private static final IntMap SDSICONMAP;

    public PickListHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void fillBrowserPickList(IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray, int n) {
        BaseListModelApp baseListModelApp = this.getBaseListModel(254);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < iMediaSDSService$MediaSDSListEntryArray.length; ++i2) {
            IMediaSDSService$MediaSDSListEntry iMediaSDSService$MediaSDSListEntry = iMediaSDSService$MediaSDSListEntryArray[i2];
            ResourceLocator resourceLocator = iMediaSDSService$MediaSDSListEntry.getCover();
            EvoListRow evoListRow = new EvoListRow(iMediaSDSService$MediaSDSListEntry.getId(), 5);
            evoListRow.setLong(0, iMediaSDSService$MediaSDSListEntry.getId());
            evoListRow.setInteger(1, this.getBrowserRecordSet(iMediaSDSService$MediaSDSListEntry, n));
            evoListRow.setText(2, iMediaSDSService$MediaSDSListEntry.getName());
            evoListRow.setText(4, iMediaSDSService$MediaSDSListEntry.getNameSecondRow());
            evoListRow.setText(3, null == resourceLocator ? null : resourceLocator.getUrl());
            baseListModelApp2.append(evoListRow);
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private int getBrowserRecordSet(IMediaSDSService$MediaSDSListEntry iMediaSDSService$MediaSDSListEntry, int n) {
        int n2;
        if (!this.getTerminal().getFramework().isPorsche()) {
            n2 = 0;
        } else {
            boolean bl = null != iMediaSDSService$MediaSDSListEntry.getNameSecondRow();
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

    public void fillSourcePickList(IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray) {
        BaseListModelApp baseListModelApp = this.getBaseListModel(254);
        ISourceController iSourceController = this.getTerminal().getSourceController();
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < iMediaSDSService$MediaSDSListEntryArray.length; ++i2) {
            EvoListRow evoListRow;
            int n;
            IMediaSDSService$MediaSDSListEntry iMediaSDSService$MediaSDSListEntry = iMediaSDSService$MediaSDSListEntryArray[i2];
            ISource iSource = iSourceController.getSource(iMediaSDSService$MediaSDSListEntry.getSourceID());
            if (iSource == null) {
                n = -1;
            } else {
                ISourceSlot iSourceSlot = iSource.getSlot(iMediaSDSService$MediaSDSListEntry.getSlot());
                n = PickListHandler.getSdsIcon(MediaUtils.getHMISourceIcon(iSourceSlot));
            }
            if (n == -1) {
                evoListRow = new EvoListRow(iMediaSDSService$MediaSDSListEntry.getId(), 3);
                evoListRow.setInteger(1, 0);
            } else {
                evoListRow = new EvoListRow(iMediaSDSService$MediaSDSListEntry.getId(), 4);
                evoListRow.setInteger(1, 1);
                evoListRow.setInteger(3, n);
            }
            evoListRow.setLong(0, iMediaSDSService$MediaSDSListEntry.getId());
            evoListRow.setText(2, iMediaSDSService$MediaSDSListEntry.getName());
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
        SDSICONMAP = new IntMap(35);
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

