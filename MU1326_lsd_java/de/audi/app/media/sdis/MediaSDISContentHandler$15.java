/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;
import de.audi.app.media.selection.ISelectionListener;

class MediaSDISContentHandler$15
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISelectionListener val$selectionListener;
    private final /* synthetic */ int val$category;
    private final /* synthetic */ long val$entryId;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$15(MediaSDISContentHandler mediaSDISContentHandler, String string, ISelectionListener iSelectionListener, int n, long l) {
        this.this$0 = mediaSDISContentHandler;
        this.val$selectionListener = iSelectionListener;
        this.val$category = n;
        this.val$entryId = l;
        super(string);
    }

    @Override
    public void run() {
        int n;
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.playMoreOf]", (Object)"MediaSDISContentHandler");
        if (!MediaSDISContentHandler.access$100(this.this$0).supportsPlayMoreOf()) {
            MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.playMoreOf] not supported", (Object)"MediaSDISContentHandler");
            this.val$selectionListener.notifySelectionChanged(null, false);
        }
        switch (this.val$category) {
            case 3: {
                n = 3;
                break;
            }
            case 2: {
                n = 4;
                break;
            }
            case 1: {
                n = 5;
                break;
            }
            default: {
                MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.playMoreOf] category unknown '%2'", (Object)"MediaSDISContentHandler", (long)this.val$category);
                this.val$selectionListener.notifySelectionChanged(null, false);
                return;
            }
        }
        MediaSDISContentHandler.access$100(this.this$0).playMoreOf(this.val$entryId, n, this.val$selectionListener);
    }
}

