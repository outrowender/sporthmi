/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer;

import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$AnimationTransformation;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerAnimationState;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;
import java.util.List;

public class EntertainmentDrawerStateUpdater
implements WidgetConstants {
    private EntertainmentDrawerOpenCloseController entDrawerOpenCloseController;
    private EntertainmentDrawerAnimationState animationStates;
    private int targetState = 1;
    private int screenHeight;
    public static final int DEFAULT_Y_SCREEN_OFFSET;
    public static final int EMPTY_GLASS_PLATE_WIDTH;

    public EntertainmentDrawerStateUpdater(EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController, EntertainmentDrawerAnimationState entertainmentDrawerAnimationState, int n) {
        this.entDrawerOpenCloseController = entertainmentDrawerOpenCloseController;
        this.animationStates = entertainmentDrawerAnimationState;
        this.screenHeight = n;
        EntertainmentDrawerState entertainmentDrawerState = this.getTargetState(1, false);
        EntertainmentDrawerState entertainmentDrawerState2 = entertainmentDrawerState != null ? entertainmentDrawerState : entertainmentDrawerAnimationState.getCurrentState();
        entertainmentDrawerAnimationState.setCurrentState(entertainmentDrawerState2);
    }

    public boolean updateTargetState(boolean bl) {
        return this.updateTargetState(this.targetState, bl);
    }

    public boolean updateTargetState(int n, boolean bl) {
        this.targetState = n;
        EntertainmentDrawerState entertainmentDrawerState = this.getTargetState(n, bl);
        if (entertainmentDrawerState != null) {
            EntertainmentDrawerState entertainmentDrawerState2 = new EntertainmentDrawerState(this.animationStates.getCurrentState());
            EntertainmentDrawerState entertainmentDrawerState3 = new EntertainmentDrawerState(entertainmentDrawerState2);
            this.animationStates.setSourceState(entertainmentDrawerState2);
            this.animationStates.setCurrentState(entertainmentDrawerState3);
            this.animationStates.setTargetState(entertainmentDrawerState);
            EntertainmentDrawerAnimationState entertainmentDrawerAnimationState = this.entDrawerOpenCloseController.getAnimationStates();
            entertainmentDrawerAnimationState.setTargetState(entertainmentDrawerState);
            entertainmentDrawerAnimationState.setSourceState(entertainmentDrawerState2);
            entertainmentDrawerAnimationState.setCurrentState(entertainmentDrawerState3);
            return true;
        }
        return false;
    }

    private EntertainmentDrawerState getTargetState(int n, boolean bl) {
        EntertainmentDrawerState entertainmentDrawerState;
        EntertainmentDrawerState entertainmentDrawerState2 = entertainmentDrawerState = this.animationStates.getTargetState() != null ? this.animationStates.getTargetState() : this.animationStates.getCurrentState();
        if (this.entDrawerOpenCloseController.isConnected() && entertainmentDrawerState != null) {
            boolean bl2;
            boolean bl3;
            EntertainmentDrawerState entertainmentDrawerState3 = new EntertainmentDrawerState(entertainmentDrawerState);
            int n2 = this.entDrawerOpenCloseController.getAudioSourceFromModel();
            List list = this.entDrawerOpenCloseController.getBlacklistedAudioSource();
            boolean bl4 = this.entDrawerOpenCloseController.isDrawerVisible();
            entertainmentDrawerState3.setContent(this.getContent(n2));
            EntertainmentDrawerContentController entertainmentDrawerContentController = entertainmentDrawerState3.getContent();
            if (entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isDefaultAudioSource(n2) && !this.entDrawerOpenCloseController.isDelayForDeblacklistingActive()) {
                this.setStatusBarGapWidth(280);
            }
            boolean bl5 = bl3 = entertainmentDrawerState.getContent() != entertainmentDrawerContentController;
            if (bl3 && entertainmentDrawerContentController != null) {
                this.setHasToRequestDrawerState(entertainmentDrawerState, false);
                entertainmentDrawerContentController.relayout();
            }
            entertainmentDrawerState3.setAudioSource(n2);
            entertainmentDrawerState3.setDrawerState(this.getDrawerState(n, entertainmentDrawerContentController, n2, list));
            entertainmentDrawerState3.setAnimateDrawerStateChange(bl);
            int n3 = entertainmentDrawerState3.getDrawerState();
            entertainmentDrawerState3.setYScreenOffset(this.getYScreenOffset(entertainmentDrawerContentController, n3));
            entertainmentDrawerState3.setYTranslation(this.getYTranslation(n3, entertainmentDrawerContentController));
            entertainmentDrawerState3.setHeight(this.getHeight(entertainmentDrawerContentController));
            entertainmentDrawerState3.setWidth(this.getWidth(entertainmentDrawerContentController, n3));
            entertainmentDrawerState3.setOpacity(this.getContentOpacity(n3));
            entertainmentDrawerState3.setGapHeight(this.getGapHeight(n3));
            entertainmentDrawerState3.setVisible(this.getVisibility(bl4, entertainmentDrawerContentController));
            entertainmentDrawerState3.setHeaderVisible(this.getHeaderVisibility(entertainmentDrawerContentController));
            boolean bl6 = bl2 = !entertainmentDrawerState3.equalsIfMinimizedExcludingAnimate(entertainmentDrawerState);
            if (bl2) {
                this.logDifference(entertainmentDrawerState, entertainmentDrawerState3);
                return entertainmentDrawerState3;
            }
        }
        return null;
    }

    private void setHasToRequestDrawerState(EntertainmentDrawerState entertainmentDrawerState, boolean bl) {
        if (entertainmentDrawerState.getContent() != null) {
            entertainmentDrawerState.getContent().setHasToRequestDrawerState(bl);
        }
    }

    private void setStatusBarGapWidth(int n) {
        IStatusbarGapEventHandler iStatusbarGapEventHandler = this.entDrawerOpenCloseController.getStatusbarGapEventHandler();
        if (iStatusbarGapEventHandler != null) {
            iStatusbarGapEventHandler.setGapWidth(n, true);
        }
    }

    private void logDifference(EntertainmentDrawerState entertainmentDrawerState, EntertainmentDrawerState entertainmentDrawerState2) {
        String string;
        if (IWidgetLogChannel.logEntertainmentStateUpdater.isDebug() && (string = entertainmentDrawerState.getDifference(entertainmentDrawerState2)).length() > 0) {
            IWidgetLogChannel.logEntertainmentStateUpdater.log(-2137614336, "EntertainmentDrawerStateUpdater#getTargetDrawState: state has changed:\n%1", (Object)string);
        }
    }

    private int getDrawerState(int n, EntertainmentDrawerContentController entertainmentDrawerContentController, int n2, List list) {
        if (entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isPhoneAudioSource(entertainmentDrawerContentController.getAudioSource())) {
            if (n == 2 || n == 1 || n == 6) {
                IWidgetLogChannel.logEntertainmentStateUpdater.log(-2137614336, "EntertainmentDrawerStateUpdater#getDrawerState: audiosource: phone -> explicitly set drawer state to closed, requested state was: %1", (long)n);
                return 1;
            }
            return 0;
        }
        if (entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isDefaultAudioSource(n2)) {
            return 2;
        }
        if (n == 6) {
            return 6;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (n2 != (Integer)list.get(i2)) continue;
            bl = true;
            break;
        }
        if (entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isSDSAudioSource(n2) && n == 2) {
            return 1;
        }
        if (entertainmentDrawerContentController != null && (EntertainmentDrawerContentManager.isAPSAudioSource(n2) || EntertainmentDrawerContentManager.isMediaAudioSource(n2) || EntertainmentDrawerContentManager.isTunerAudioSource(n2) || EntertainmentDrawerContentManager.isTVAudioSource(n2) || EntertainmentDrawerContentManager.isSDISAudioSource(n2)) && (entertainmentDrawerContentController.getRequestedDrawerState() == 2 || entertainmentDrawerContentController.getRequestedDrawerState() == 6)) {
            return entertainmentDrawerContentController.getRequestedDrawerState();
        }
        if (n2 != -1 && entertainmentDrawerContentController != null && !bl) {
            return n;
        }
        if (bl) {
            return 2;
        }
        if (entertainmentDrawerContentController == null || n2 == -1) {
            return 2;
        }
        return 2;
    }

    private float getContentOpacity(int n) {
        if (n == 2) {
            return 0.0f;
        }
        return 1.0f;
    }

    private EntertainmentDrawerContentController getContent(int n) {
        if (this.entDrawerOpenCloseController.isConnected()) {
            return (EntertainmentDrawerContentController)this.entDrawerOpenCloseController.getTerminalImpl().getDrawerManager().getNewEntertainmentContent(n);
        }
        return null;
    }

    private ContainerController$AnimationTransformation getAnimationTransformation(EntertainmentDrawerContentController entertainmentDrawerContentController) {
        if (entertainmentDrawerContentController != null && entertainmentDrawerContentController.getPreferredHeight() != -1 && entertainmentDrawerContentController.getHideTransformation(true) != null) {
            return entertainmentDrawerContentController.getHideTransformation(true);
        }
        return this.entDrawerOpenCloseController.getOriginalAnimationTransformation();
    }

    private float getGapHeight(int n) {
        if (n == 2) {
            return 1.0f;
        }
        return 0.0f;
    }

    private int getHeight(EntertainmentDrawerContentController entertainmentDrawerContentController) {
        int n = 0;
        n = entertainmentDrawerContentController == null || entertainmentDrawerContentController.getPreferredHeight() == -1 ? this.entDrawerOpenCloseController.getHeight() : entertainmentDrawerContentController.getPreferredHeight();
        return n;
    }

    private int getYScreenOffset(EntertainmentDrawerContentController entertainmentDrawerContentController, int n) {
        if (entertainmentDrawerContentController == null || entertainmentDrawerContentController.getPreferredHeight() == -1) {
            return 197;
        }
        int n2 = 0;
        if (entertainmentDrawerContentController != null && entertainmentDrawerContentController.isHeaderVisible() && n == 0) {
            n2 = 50;
        }
        return this.screenHeight - entertainmentDrawerContentController.getPreferredHeight() - n2;
    }

    private float getHeaderVisibility(EntertainmentDrawerContentController entertainmentDrawerContentController) {
        if (entertainmentDrawerContentController != null) {
            return entertainmentDrawerContentController.isHeaderVisible() ? 1.0f : 0.0f;
        }
        return 0.0f;
    }

    private int getWidth(EntertainmentDrawerContentController entertainmentDrawerContentController, int n) {
        int n2;
        int n3 = entertainmentDrawerContentController == null || entertainmentDrawerContentController.getPreferredWidth() == -1 ? 300 : entertainmentDrawerContentController.getPreferredWidth() - this.entDrawerOpenCloseController.getIndentHorizontal() * 2;
        if (this.entDrawerOpenCloseController.getStatusbarGapEventHandler() != null) {
            n2 = this.entDrawerOpenCloseController.getStatusbarGapEventHandler().getMaxGapWidth();
            n3 = Math.min(n3, n2);
        }
        if (entertainmentDrawerContentController != null) {
            n2 = this.entDrawerOpenCloseController.getIndentHorizontal() * 2;
            int n4 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthOpened()[0] - n2;
            int n5 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthOpened()[1] - n2;
            int n6 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthClosed()[0] - n2;
            int n7 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthClosed()[1] - n2;
            int n8 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthMinimized()[0] - n2;
            int n9 = entertainmentDrawerContentController.getAudioDrawerMinMaxWidthMinimized()[1] - n2;
            if (n == 0) {
                if (n3 < n4) {
                    n3 = n4;
                } else if (n3 > n5) {
                    n3 = n5;
                }
            } else if (n == 1 || n == 6) {
                if (n3 < n6) {
                    n3 = n6;
                } else if (n3 > n7) {
                    n3 = n7;
                }
            } else if (n == 2) {
                if (n3 < n8) {
                    n3 = n8;
                } else if (n3 > n9) {
                    n3 = n9;
                }
            }
        }
        return n3;
    }

    private float getYTranslation(int n, EntertainmentDrawerContentController entertainmentDrawerContentController) {
        boolean bl;
        float f2 = 0.0f;
        boolean bl2 = n != 0 && n != 3;
        boolean bl3 = bl = entertainmentDrawerContentController != null && entertainmentDrawerContentController.getGlassplateType() == 1;
        if (bl2 || bl) {
            ContainerController$AnimationTransformation containerController$AnimationTransformation = this.getAnimationTransformation(entertainmentDrawerContentController);
            float f3 = f2 = containerController$AnimationTransformation != null ? containerController$AnimationTransformation.getTransY() : 0.0f;
        }
        if (entertainmentDrawerContentController != null && entertainmentDrawerContentController.isHeaderVisible() && !EntertainmentDrawerContentManager.isAPSAudioSource(entertainmentDrawerContentController.getAudioSource())) {
            f2 += 16450;
        }
        return f2;
    }

    private boolean getVisibility(boolean bl, EntertainmentDrawerContentController entertainmentDrawerContentController) {
        return entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isPhoneAudioSource(entertainmentDrawerContentController.getAudioSource()) ? true : bl;
    }
}

