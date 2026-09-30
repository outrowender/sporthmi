/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.hierarchiclist.AbstractHierarchyListManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.command.via.LiGetViaPointListCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaApp;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.ViaPointListElement;

public class ViaListManager
extends AbstractHierarchyListManager {
    public static final int WINDOW_SIZE = 21;
    public static final int OFFSET = 10;
    protected ViaApp viaApp;
    private final IconHandler iconHandler;
    private final ICommandListFactory commandListFactory;

    public ViaListManager(IconHandler iconHandler, LogChannel logChannel, DynamicListModelApp dynamicListModelApp, ChoiceModelApp choiceModelApp, int n, ViaApp viaApp, ICommandListFactory iCommandListFactory) {
        super(logChannel, dynamicListModelApp, choiceModelApp, null, n);
        this.iconHandler = iconHandler;
        this.viaApp = viaApp;
        this.commandListFactory = iCommandListFactory;
    }

    void itemFocused(ListRow listRow, int n) {
        this.getLogChannel().log(10000000, "ViaListManager#itemFocused( %1, %2 )", (Object)listRow, (long)n);
        this.setFocusedRow(listRow);
        this.setCursorPosition(n);
    }

    public void itemSelected(HMIModelApp hMIModelApp, ListRow listRow, int n, boolean bl) {
        this.getLogChannel().log(10000000, "ViaListManager#itemSelected()");
        ViaListRow viaListRow = (ViaListRow)listRow;
        if (viaListRow.isEnabled()) {
            super.itemSelected(hMIModelApp, listRow, n, bl);
        }
    }

    void resetAll() {
        this.resetModels();
        this.signalListCalculating();
        this.initValues();
    }

    void updateList() {
        this.getLogChannel().log(10000000, "ViaListManager#updateList()");
        this.requestWindow(this.getFocusedRow(), false);
    }

    protected long getInitAnchorId() {
        return -1L;
    }

    protected void requestInitialWindow() {
        this.getLogChannel().log(10000000, "ViaListManager#requestInitialWindow()");
        this.initValues();
        this.requestWindow(-1L, this.getOpenedAnchorId());
    }

    protected void requestWindow(long l, long l2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetViaPointListCommand(this, 21, 10, (int)l, (int)l2));
        commandList.execute("ViaListManager#requestWindow");
    }

    protected void requestWindow(long[] lArray, long l) {
        this.getLogChannel().log(10000, "ViaListManager#requestWindow( %1, %2 ) - not implemented!", (Object)lArray, l);
    }

    public void updateViaList(long l, ViaPointListElement[] viaPointListElementArray, int n, int n2) {
        if (viaPointListElementArray != null && viaPointListElementArray.length > 0) {
            this.getLogChannel().log(10000000, "ViaListManager#updateViaList( #%1, %2 )", (long)viaPointListElementArray.length, l);
            ListRow[] listRowArray = new ViaListRow[viaPointListElementArray.length];
            try {
                Object object;
                int n3;
                int n4 = -1;
                long l2 = -1L;
                if (this.getFocusedRow() != null) {
                    this.getLogChannel().log(10000000, "[ViaListManager#updateViaList] Current focused message not null, msg: %1", (Object)this.getFocusedRow());
                    l2 = ((ViaListRow)this.getFocusedRow()).getUid();
                } else {
                    l2 = viaPointListElementArray[0].getId();
                }
                this.getLogChannel().log(10000000, "[ViaListManager#updateViaList] Current focused message ID: %1", l2);
                for (n3 = 0; n3 < listRowArray.length; ++n3) {
                    object = viaPointListElementArray[n3];
                    if ((long)((ViaPointListElement)object).getId() == l2) {
                        this.getLogChannel().log(10000000, "ViaListManager#updateViaList() - current focused element ID '%1' available", l2);
                        n4 = n3;
                    }
                    listRowArray[n3] = this.createListRow((ViaPointListElement)object);
                }
                n3 = this.getListBorders(n4, listRowArray.length, n2, n);
                listRowArray[0].setBorder((n3 & 1) != 0);
                listRowArray[listRowArray.length - 1].setBorder((n3 & 2) != 0);
                this.getListModel().beginTransaction();
                this.getListModel().clear();
                this.getListModel().fill(listRowArray, 0);
                this.getListModel().setListLength(listRowArray.length);
                this.setListThresholds(this.getListModel(), listRowArray.length, n3);
                object = (ViaListRow)this.getFocusedRow();
                this.getListModel().setFocusedCursorPosition((ListRow)object, this.getCursorPosition());
                this.getListModel().endTransaction();
                this.signalListAvailable();
            }
            catch (Exception exception) {
                this.getLogChannel().log(10000, "ViaListManager#updateViaList() - aborted: %1 ", (Throwable)exception);
                this.getListModel().abortTransaction();
            }
        } else {
            this.getLogChannel().log(10000, "ViaListManager#updateViaList() - empty list!");
            this.getListModel().beginTransaction();
            this.getListModel().clear();
            this.getListModel().endTransaction();
            this.initValues();
            this.signalListNotAvailable();
        }
    }

    private ViaListRow createListRow(ViaPointListElement viaPointListElement) {
        ViaListRow viaListRow = null;
        int n = 0;
        if ((long)viaPointListElement.getId() == this.getOpenedAnchorId()) {
            n = 2;
        } else if (viaPointListElement.isHasChildren()) {
            n = 1;
        } else if (viaPointListElement.getParentID() != -1L) {
            n = 3;
        }
        viaListRow = new ViaListRow(this.iconHandler, viaPointListElement, n, this.commandListFactory);
        return viaListRow;
    }

    private int getListBorders(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(10000000, "ViaListManager#getListBorders()");
        int n5 = 0;
        if (n >= n3) {
            this.getLogChannel().log(10000000, "ViaListManager#getListBorders() - found upper window border");
            n5 |= 1;
        }
        if (n2 - n >= n4 - n3) {
            this.getLogChannel().log(10000000, "ViaListManager#getListBorders() - found lower window border");
            n5 |= 2;
        }
        return n5;
    }

    public String toString() {
        ListRow[] listRowArray = this.getListModelRows();
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < listRowArray.length; ++i2) {
            buffer.append(listRowArray[i2]);
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public void setCountryListAvailability(boolean bl) {
        if (bl) {
            this.signalListAvailable();
        } else {
            this.signalListNotAvailable();
        }
    }
}

