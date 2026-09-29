/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.BufferedFolderListContentModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ModelException;
import de.audi.atip.hmi.modelaccess.BufferedFolderListModelApp;
import de.audi.atip.hmi.modelaccess.FolderListModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class BufferedFolderListModel
extends BufferedListModel
implements BufferedFolderListModelApp,
FolderListModelGUI {
    private final Object mutex = new Object();
    private BufferedFolderListContentModel contentModel;
    private SimpleIntIntMap folderStates = new SimpleIntIntMap();

    public BufferedFolderListModel(int n) {
        super(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void contentChanged() {
        Object object = this.mutex;
        synchronized (object) {
            try {
                this.beginTransaction();
                this.clear();
                int n = -1;
                int n2 = -1;
                int n3 = this.contentModel.getRowIdByIndex(this.contentModel.getSelected());
                int n4 = this.contentModel.getLength();
                for (int i2 = 0; i2 < n4; ++i2) {
                    int n5;
                    BaseListRow baseListRow = this.contentModel.getRow(i2);
                    if (BufferedFolderListContentModel.isFolder(baseListRow)) {
                        n5 = baseListRow.getInteger(1);
                        int n6 = this.folderStates.get(n5);
                        if (n6 == 1) {
                            baseListRow.setInteger(5, baseListRow.getInteger(3));
                            baseListRow.setInteger(2, 1);
                        } else {
                            if (n6 == -1) {
                                this.folderStates.add(n5, 0);
                            }
                            baseListRow.setInteger(5, baseListRow.getInteger(4));
                            baseListRow.setInteger(2, 2);
                        }
                    } else {
                        n5 = baseListRow.getInteger(1);
                        if (this.folderStates.get(n5) == 0) {
                            if (baseListRow.getInteger(0) != n3) continue;
                            n = n2;
                            continue;
                        }
                        baseListRow.setInteger(2, 0);
                    }
                    this.addRow(baseListRow);
                    ++n2;
                    if (baseListRow.getInteger(0) != n3) continue;
                    n = n2;
                }
                this.setStatus(this.contentModel.getStatus());
                this.resetHints();
                this.addHint(this.contentModel.getHints());
                super.setSelected(n);
                this.endTransaction();
            }
            catch (Exception exception) {
                this.abortTransaction();
                throw new ModelException((HMIModel)this, (Throwable)exception);
            }
        }
    }

    @Override
    public SimpleIntIntMap getFolderStates() {
        return this.folderStates;
    }

    @Override
    public int getIndexForRowID(int n) {
        int n2 = this.getLength();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.getRow(i2).getInteger(0) != n) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int getRowIDForIndex(int n) {
        if (n >= this.getLength() || n < 0) {
            return -1;
        }
        return this.getRow(n).getInteger(0);
    }

    @Override
    public boolean isOpen(int n) {
        int n2 = this.folderStates.get(n);
        if (n2 == -1) {
            n2 = 0;
            this.folderStates.add(n, 0);
        }
        return n2 == 1;
    }

    boolean isVisible(int n) {
        return this.getIndexForRowID(n) != -1;
    }

    @Override
    public void itemSelected(int n, int n2, int n3) {
        this.itemSelected(n, this.getRowIDForIndex(n), n2, n3);
    }

    @Override
    public int itemSelected(int n, int n2, int n3, int n4) {
        if (n >= this.getLength()) {
            n = this.getIndexForRowID(n2);
        } else if (n2 != this.getRowIDForIndex(n)) {
            n = this.getIndexForRowID(n2);
        }
        if (n == -1) {
            return n;
        }
        boolean bl = BufferedFolderListContentModel.isFolder(this.getRow(n));
        if (bl) {
            int n5 = this.getRow(n).getInteger(1);
            super.setStatus(0);
            int n6 = this.isOpen(n5) ? 0 : 1;
            this.folderStates.add(n5, n6);
            this.contentChanged();
            return this.getIndexForRowID(n2);
        }
        super.itemSelected(n, n3, n4);
        return this.getIndexForRowID(n2);
    }

    void setContentModel(BufferedFolderListContentModel bufferedFolderListContentModel) {
        this.contentModel = bufferedFolderListContentModel;
    }

    @Override
    public void setFolderStates(SimpleIntIntMap simpleIntIntMap) {
        this.folderStates = simpleIntIntMap;
        this.contentChanged();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelected(int n) {
        int n2;
        Object object = this.mutex;
        synchronized (object) {
            n2 = -1;
            if (n != -1 && (n2 = this.getIndexForRowID(n)) == -1) {
                int n3 = this.contentModel.getFolderIdByIndex(this.contentModel.getSelected());
                n2 = this.getIndexByFolderId(n3);
            }
        }
        super.setSelected(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getSelected(int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            nArray[0] = this.getSelected();
            nArray[1] = this.getRowIDForIndex(nArray[0]);
        }
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(10000);
        buffer.append("\nI'm a ").append(super.getClass().getName());
        buffer.append("\nfolderStates: ").append(this.toString(this.folderStates));
        if (this.contentModel != null) {
            buffer.append("\n++++ contentModel ++++").append(this.contentModel.dumpContent());
        } else {
            buffer.append("\ncontentModel: null");
        }
        buffer.append('\n');
        buffer.append(super.dumpContent());
        return buffer.toString().replace(',', ';');
    }

    private int getIndexByFolderId(int n) {
        int n2 = this.getLength();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.getRow(i2).getInteger(1) != n) continue;
            return i2;
        }
        return -1;
    }

    private String toString(SimpleIntIntMap simpleIntIntMap) {
        if (simpleIntIntMap == null) {
            return "null";
        }
        int[] nArray = simpleIntIntMap.getKeys();
        int[] nArray2 = simpleIntIntMap.getValues();
        if (nArray.length == 0) {
            return "empty";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append("\n\t").append(nArray[i2]).append(": ").append(nArray2[i2]);
        }
        return buffer.toString();
    }
}

