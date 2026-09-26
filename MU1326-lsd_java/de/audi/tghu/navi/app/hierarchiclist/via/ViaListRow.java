/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.interapp.hierarchiclist.AbstractHierarchyListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.command.via.LiSelectViaPointCommand;
import de.audi.tghu.navi.app.util.IconUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.ViaPointListElement;

public class ViaListRow
extends AbstractHierarchyListRow {
    protected static final int ROW_LLD;
    protected static final int ROW_ELEMENT;
    protected static final int ROW_FOLDER_STATE;
    protected static final int ROW_ENTRY_TEXT;
    protected static final int ROW_ENTRY_ICON;
    protected static final int ENTRY_ENABLED;
    protected static final int ROW_LENGTH;
    protected static final int LLD_DEFAULT;
    public static final int FOLDER_NONE;
    public static final int FOLDER_CLOSED;
    public static final int FOLDER_OPENED;
    public static final int FOLDER_CHILD;
    private final ICommandListFactory commandListFactory;

    public ViaListRow(IconHandler iconHandler, ViaPointListElement viaPointListElement, int n, ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(-1), new ObjectListCell(viaPointListElement), IntegerListCell.create(n), new TextListCell("---"), new IconCell(new HMIResourceLocator(-1)), IntegerListCell.create(1)};
        this.setCells(listCellArray);
        ((IntegerListCell)this.getCell(0)).setValue(0);
        Buffer buffer = new Buffer();
        buffer.append(viaPointListElement.getDescription());
        if (viaPointListElement.isHasChildren()) {
            buffer.append(" (").append(viaPointListElement.getNumberOfViaPointsInNode()).append(')');
        }
        ((TextListCell)this.getCell(3)).setText(buffer.toString());
        this.setEnabled(!viaPointListElement.isHasChildren() || viaPointListElement.getNumberOfViaPointsInNode() != 0);
        if (viaPointListElement.getRoadIconId() != -1L && !Util.isEmpty(viaPointListElement.getRoadNumber())) {
            IconUtil.setStreetIconImage(iconHandler, (int)viaPointListElement.getRoadIconId(), viaPointListElement.getRoadNumber(), (IconCell)this.getCell(4));
        }
    }

    public final ViaPointListElement getElement() {
        return (ViaPointListElement)((ObjectListCell)this.getCell(1)).getValue();
    }

    @Override
    public final long getUid() {
        return this.getElement().getId();
    }

    @Override
    public boolean isHasChildren() {
        return this.getElement().isHasChildren();
    }

    @Override
    public boolean isHasDetails() {
        return true;
    }

    @Override
    public void queryDetails() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiSelectViaPointCommand(this.getElement().getId()));
        commandList.execute("ViaListRow#queryDetails");
    }

    public int getFolderState() {
        return ((IntegerListCell)this.getCell(2)).getValue();
    }

    public void setFolderState(int n) {
        ((IntegerListCell)this.getCell(2)).setValue(n);
    }

    public boolean isEnabled() {
        return ((IntegerListCell)this.getCell(5)).getValue() == 1;
    }

    public final void setEnabled(boolean bl) {
        ((IntegerListCell)this.getCell(5)).setValue(bl ? 1 : 0);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        switch (this.getFolderState()) {
            case 1: {
                buffer.append("+ ");
                break;
            }
            case 2: {
                buffer.append("- ");
                break;
            }
            case 3: {
                buffer.append("  ");
                break;
            }
            default: {
                buffer.append("");
            }
        }
        int n = ((IconCell)this.getCell(4)).getResourceLocator().getResourceID();
        if (n != -1) {
            buffer.append('[').append(n).append("] ");
        }
        buffer.append(((TextListCell)this.getCell(3)).getText());
        return buffer.toString();
    }
}

