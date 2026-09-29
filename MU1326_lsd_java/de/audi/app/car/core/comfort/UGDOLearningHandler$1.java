/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.UGDOLearningHandler;
import de.audi.atip.hmi.model.DefaultButtonListener;

class UGDOLearningHandler$1
extends DefaultButtonListener {
    private final /* synthetic */ UGDOLearningHandler this$0;

    UGDOLearningHandler$1(UGDOLearningHandler uGDOLearningHandler) {
        this.this$0 = uGDOLearningHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#keyPressed] modelID='%1'", (long)n);
        switch (n) {
            case 600417: {
                UGDOLearningHandler.access$102(this.this$0, true);
                UGDOLearningHandler.access$200(this.this$0, 1);
                break;
            }
            case 600418: {
                UGDOLearningHandler.access$102(this.this$0, true);
                UGDOLearningHandler.access$200(this.this$0, 2);
                break;
            }
            case 600420: {
                UGDOLearningHandler.access$102(this.this$0, true);
                UGDOLearningHandler.access$200(this.this$0, 3);
                break;
            }
            case 600415: {
                UGDOLearningHandler.access$300(this.this$0);
                break;
            }
            case 600625: {
                UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#] error during learning, retry yes");
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(824838400).setPressed(true);
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(808061184).setPressed(false);
                this.this$0.startLearningButton(UGDOLearningHandler.access$500(this.this$0), UGDOLearningHandler.access$600(this.this$0));
                break;
            }
            case 600624: {
                UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#] error during learning, no retry, go back");
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(824838400).setPressed(false);
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(808061184).setPressed(true);
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            case 601785: {
                UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#] leave learning process via HK_RETURN/back");
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            case 600423: {
                UGDOLearningHandler.access$702(this.this$0, false);
                UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#keyPressed] abort learning fixed learning system, learningStarted: false");
                UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#startSync] dsi.abortUGDOLearning()");
                UGDOLearningHandler.access$800(this.this$0).getDSICarComfort().abortUGDOLearning();
                UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            default: {
                UGDOLearningHandler.access$000(this.this$0).log(-1601830656, "[UGDOLearningHandler#keyPressed] Key Pressed reached unknown state!");
            }
        }
    }
}

