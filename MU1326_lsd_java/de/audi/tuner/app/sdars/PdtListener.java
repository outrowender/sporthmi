/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.sdars.ISDARSRow;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.ifc.IListResourceProvider;
import de.audi.tuner.ifc.listener.IPdtListener;

public class PdtListener
implements IPdtListener {
    private final Object mutex;
    private final BaseListModelApp listModel;
    private final IListResourceProvider resourceProvider;
    private SdarsRadioText actualPdt = null;
    private int pdtAddedSid = -1;
    private long lastUsedUniqueId = 0L;
    private int imgType;

    public PdtListener(IListResourceProvider iListResourceProvider, BaseListModelApp baseListModelApp, Object object, int n) {
        this.listModel = baseListModelApp;
        this.imgType = n;
        this.mutex = object;
        this.resourceProvider = iListResourceProvider;
    }

    public SdarsRadioText getActualPdt() {
        return this.actualPdt == null ? null : new SdarsRadioText(this.actualPdt);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        Object object = this.mutex;
        synchronized (object) {
            int n2;
            this.actualPdt = sdarsRadioText;
            if (this.pdtAddedSid != n && this.pdtAddedSid != -1 && (n2 = this.listModel.getID() == 1938292992 || this.listModel.getID() == 1921515776 ? this.listModel.getIndexForUniqueID(this.lastUsedUniqueId) : this.listModel.getIndexForUniqueID(RadioObjectIds.getSDARSObjectId(this.pdtAddedSid))) != -1) {
                this.updateData(this.listModel, this.listModel.getRow(n2), n2, -1, null);
            }
            if (this.listModel.getID() == 1938292992 || this.listModel.getID() == 1921515776) {
                n2 = this.listModel.getIndexForUniqueID(this.resourceProvider.getFocussedItemUniqueId());
                EvoListRow evoListRow = this.listModel.getRow(n2);
                if (evoListRow == null || !(evoListRow instanceof ISDARSRow) || ((ISDARSRow)((Object)evoListRow)).getStation().sID != n) {
                    n2 = -1;
                }
            } else {
                n2 = this.listModel.getIndexForUniqueID(RadioObjectIds.getSDARSObjectId(n));
            }
            if (n2 != -1) {
                this.updateData(this.listModel, this.listModel.getRow(n2), n2, n, sdarsRadioText);
            }
        }
    }

    private void updateData(BaseListModelApp baseListModelApp, EvoListRow evoListRow, int n, int n2, SdarsRadioText sdarsRadioText) {
        if (evoListRow instanceof ISDARSRow) {
            if (sdarsRadioText == null) {
                ((ISDARSRow)((Object)evoListRow)).resetPdt();
                this.pdtAddedSid = -1;
            } else {
                ((ISDARSRow)((Object)evoListRow)).setProgramData(sdarsRadioText, this.imgType);
                this.pdtAddedSid = n2;
                this.lastUsedUniqueId = evoListRow.getUniqueID();
            }
            baseListModelApp.setRow(n, evoListRow);
        }
    }

    public void setPrefImgType(int n) {
        this.imgType = n;
    }
}

