/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.sdars.CategoryFilter;
import de.audi.tuner.app.sdars.CategoryFilter$1;

class CategoryFilter$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ CategoryFilter this$0;

    private CategoryFilter$ChoiceListener(CategoryFilter categoryFilter) {
        this.this$0 = categoryFilter;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (CategoryFilter.access$800(this.this$0).getValue() != 1) {
            CategoryFilter.access$800(this.this$0).setValue(1);
            CategoryFilter.access$900(this.this$0, true);
        } else {
            CategoryFilter.access$800(this.this$0).setValue(0);
            CategoryFilter.access$900(this.this$0, false);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100593: {
                CategoryFilter.access$900(this.this$0, true);
                break;
            }
            case 100591: {
                CategoryFilter.access$900(this.this$0, false);
                break;
            }
            case 100592: {
                CategoryFilter.access$1000(this.this$0).getButtonModel(n).fireEvent(n3);
                break;
            }
        }
    }

    /* synthetic */ CategoryFilter$ChoiceListener(CategoryFilter categoryFilter, CategoryFilter$1 categoryFilter$1) {
        this(categoryFilter);
    }
}

