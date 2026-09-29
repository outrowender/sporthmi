/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestHMIListener;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$1;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;

class IntelliDestHMIListener$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ IntelliDestHMIListener this$0;

    private IntelliDestHMIListener$MyButtonListener(IntelliDestHMIListener intelliDestHMIListener) {
        this.this$0 = intelliDestHMIListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        IntelliDestHMIListener.access$300(this.this$0).log(1078071040, "%1#ButtonListener.keyPressed model = %2 key = %3", (Object)IntelliDestHMIListener.access$200(this.this$0), (long)n, (long)n2);
        switch (n) {
            case 400993: {
                IntelliDestHMIListener.access$1300(this.this$0).configureSearchFromTruffles(IntelliDestHMIListener.access$1200(this.this$0).getText());
                break;
            }
            case 401480: {
                IntelliDestHMIListener.access$500(this.this$0).startRG(IntelliDestHMIListener.access$500((IntelliDestHMIListener)this.this$0).cachedSelectedRow, n3);
                break;
            }
            case 401481: {
                String string = IntelliDestHMIListener.access$700(this.this$0).getLabelModel(1193281024).getText();
                IntelliDestHMIListener.access$1200(this.this$0).setText(string);
                IntelliDestHMIListener.access$500(this.this$0).performQuery(string, new String[0]);
                IntelliDestHMIListener.access$1400(this.this$0).setFocusedItem(IntelliDestHMIListener.access$1200(this.this$0).getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, -1L);
                break;
            }
            case 401030: {
                IntelliDestHMIListener.access$900(this.this$0).getMainSearch().removeAllFromHistory();
                break;
            }
            case 401579: {
                IntelliDestHMIListener.access$500(this.this$0).openAddressInputForm();
                break;
            }
            case 401755: {
                IntelliDestHMIListener.access$1500(this.this$0).loadCountriesFromNavigation();
                break;
            }
        }
        IntelliDestHMIListener.access$700(this.this$0).getButtonModel(n).fireEvent(n3);
    }

    /* synthetic */ IntelliDestHMIListener$MyButtonListener(IntelliDestHMIListener intelliDestHMIListener, IntelliDestHMIListener$1 intelliDestHMIListener$1) {
        this(intelliDestHMIListener);
    }
}

