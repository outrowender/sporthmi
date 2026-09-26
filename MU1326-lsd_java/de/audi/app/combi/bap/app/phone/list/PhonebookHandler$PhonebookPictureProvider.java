/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler$1;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.vw.mib.bap.generated.telephone.serializer.PbState_Status;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

class PhonebookHandler$PhonebookPictureProvider
implements IPictureProvider,
BAPFunctionDataListener {
    private final Map id2pictureURL = new HashMap();
    private final /* synthetic */ PhonebookHandler this$0;

    private PhonebookHandler$PhonebookPictureProvider(PhonebookHandler phonebookHandler) {
        this.this$0 = phonebookHandler;
    }

    @Override
    public void requestPicture(long l) {
        String string;
        Long l2 = new Long(l);
        if (this.id2pictureURL.containsKey(l2)) {
            string = (String)this.id2pictureURL.get(l2);
            if (string == null) {
                PhonebookHandler.access$000(this.this$0).log(-1601830656, "[PhonebookHandler.PhonebookPictureProvider#requestPicture] no pictureURL available for entryID=%1", l);
            }
        } else {
            string = null;
            PhonebookHandler.access$100(this.this$0).log(-1601830656, "[PhonebookHandler.PhonebookPictureProvider#requestPicture] entry with ID=%1 unknown", l);
        }
        ((AbstractCombiModule)PhonebookHandler.access$200(this.this$0)).getPictureManager().responseAdbContactPicture(l, string == null ? new ResourceLocator() : new ResourceLocator(string));
    }

    @Override
    public void requestPicture(long l, int n) {
        this.requestPicture(l);
    }

    @Override
    public void notifyDataValidChanged(int n, boolean bl) {
    }

    @Override
    public void notifyDataChanged(int n) {
        if (n == 51) {
            PbState_Status pbState_Status = (PbState_Status)PhonebookHandler.access$300(this.this$0).getBAPFunctionPropertyFSG(n).getLastStatus();
            if (pbState_Status.downloadState == 0) {
                this.id2pictureURL.clear();
            }
        }
    }

    @Override
    public void notifyDataUpdatedNoChange(int n) {
    }

    public void addToMapping(CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray) {
        int n = combiBAPPhonebookEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.id2pictureURL.put(new Long(combiBAPPhonebookEntryArray[i2].getPosID()), combiBAPPhonebookEntryArray[i2].getPictureURL());
        }
    }

    /* synthetic */ PhonebookHandler$PhonebookPictureProvider(PhonebookHandler phonebookHandler, PhonebookHandler$1 phonebookHandler$1) {
        this(phonebookHandler);
    }
}

