/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.DSIDisplayListener;

class DSIDisplayListener$1
implements Runnable {
    private final /* synthetic */ int val$cid;
    private final /* synthetic */ int val$width;
    private final /* synthetic */ int val$height;
    private final /* synthetic */ DSIDisplayListener this$0;

    DSIDisplayListener$1(DSIDisplayListener dSIDisplayListener, int n, int n2, int n3) {
        this.this$0 = dSIDisplayListener;
        this.val$cid = n;
        this.val$width = n2;
        this.val$height = n3;
    }

    @Override
    public void run() {
        Integer n = new Integer(this.val$cid);
        Object object = DSIDisplayListener.access$000((DSIDisplayListener)this.this$0).displayableExtents.get(n);
        if (object != null) {
            int[] nArray = (int[])object;
            nArray[0] = this.val$width;
            nArray[1] = this.val$height;
        } else {
            int[] nArray = new int[]{this.val$width, this.val$height};
            DSIDisplayListener.access$000((DSIDisplayListener)this.this$0).displayableExtents.put(n, nArray);
        }
    }
}

