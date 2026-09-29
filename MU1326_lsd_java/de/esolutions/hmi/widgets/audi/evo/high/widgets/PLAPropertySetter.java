/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController;

public class PLAPropertySetter {
    private static final String PLA_CURSOR_POSITION;
    private static final String PLA_CURSOR_VISIBLE;
    private static final String PLA_INDICATOR;
    private static final String PLA_INSTRUCTION_SPEED;
    private static final String PLA_INSTRUCTION_REVERSE_GEAR;
    private static final String PLA_INSTRUCTION_REVERSE;
    private static final String PLA_INSTRUCTION_FORWARD;
    private static final String PLA_INSTRUCTION_BRAKE;
    private static final String PLA_TOOLBAR_VISIBLE;
    private static final String PLA_TOOLBAR_RIGHT_LATERAL_REVERSE;
    private static final String PLA_TOOLBAR_RIGHT_LATERAL_FORWARD;
    private static final String PLA_TOOLBAR_RIGHT_PARALLEL;
    private static final String PLA_TOOLBAR_LEFT_LATERAL_REVERSE;
    private static final String PLA_TOOLBAR_LEFT_LATERAL_FORWARD;
    private static final String PLA_TOOLBAR_LEFT_PARALLEL;
    private static final String PLA_EXIT_STATE;
    private static final String PLA_EXIT_LEFT;
    private static final String PLA_EXIT_RIGHT;
    private static final String PLA_SCANNING_RIGHT;
    private static final String PLA_SCANNING_LEFT;
    private static final String PLA_PARKING_RIGHT;
    private static final String PLA_PARKING_LEFT;
    private static final String PLA_PARKING_MODE_RIGHT;
    private static final String PLA_PARKING_MODE_LEFT;
    private static final String PLA_PARKING_SIGN_RIGHT;
    private static final String PLA_PARKING_SIGN_LEFT;
    private final EALPropertyCache propertyCache = new EALPropertyCache();
    private final PLAController plaController;
    private final INode2D propNode;

    public PLAPropertySetter(PLAController pLAController, INode2D iNode2D) {
        this.plaController = pLAController;
        this.propNode = iNode2D;
    }

    public void applyProperties() {
        if (0 == this.plaController.getPLAMode()) {
            this.setIdleMode();
            return;
        }
        this.setInstructionSymbols();
        this.setDefaultPropertyValues();
        switch (this.plaController.getPLAMode()) {
            case 6: {
                this.setStandyMode();
                break;
            }
            case 3: {
                this.setParkoutMode();
                break;
            }
            default: {
                this.setSearchMode();
            }
        }
    }

    private void setDefaultPropertyValues() {
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_visible", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_speed", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_exit_state", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_left", 0.0f);
    }

    private void setParkoutMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_visible", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_exit_state", 1.0f);
        int n = iPLAStatus.getPreSelection();
        if (n == -1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_left", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_right", 1.0f);
        } else if (n == 0 || n == 2 || n == 1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_left", 2.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_right", 0.0f);
        } else if (n == 3 || n == 5 || n == 4) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_left", 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_exit_right", 2.0f);
        }
    }

    private void setInstructionSymbols() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, "pla_indicator", (float)iPLAStatus.getSteeringInterventionSymbol());
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_brake", iPLAStatus.isBrakeSymbol() ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_right", 0.0f);
        if (iPLAStatus.getDrivingDirection() == 0) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_forward", 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverse", 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverseGear", 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverseGear", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverse", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_forward", 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 3) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_forward", 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverse", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverseGear", 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_forward", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverse", 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverseGear", 0.0f);
        }
        if (iPLAStatus.isPosOKSymbol()) {
            if (iPLAStatus.getActiveSide() == 2) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_right", 1.0f);
            } else if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_left", 1.0f);
            }
        }
    }

    private void setSearchMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_right", 0.0f);
        if (iPLAStatus.getActiveSide() == 0) {
            this.setToolbarSideBoth();
        } else if (iPLAStatus.getActiveSide() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_parking_right", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_right", 1.0f);
            this.setToolbarSideLeft();
        } else if (iPLAStatus.getActiveSide() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_parking_left", 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_left", 1.0f);
            this.setToolbarSideRight();
        }
        if (iPLAStatus.getPreSelection() == -1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_cursor_visible", 0.0f);
        } else {
            this.propertyCache.setProperty((INode)this.propNode, "pla_cursor_visible", 1.0f);
        }
        if (this.plaController.getCursorPosition() != -1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_cursorPosition", (float)this.plaController.getCursorPosition());
            int n = this.plaController.getCursorPosition() % 3;
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_left", (float)(n + 1));
            } else {
                this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_right", (float)(n + 1));
            }
        } else {
            this.propertyCache.setProperty((INode)this.propNode, "pla_cursor_visible", 0.0f);
        }
        if (iPLAStatus.isForwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_forward", 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_forward", 2.0f);
            }
        }
        if (iPLAStatus.isBackwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_reverse", 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_reverse", 2.0f);
            }
        }
        if (iPLAStatus.isBackwardParallelToRoadSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_parallel", 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_parallel", 2.0f);
            }
        }
    }

    private void setStandyMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_speed", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_right", 0.0f);
        if (iPLAStatus.getActiveSide() == 0) {
            this.setToolbarSideNone();
        } else if (iPLAStatus.getActiveSide() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_parking_right", 1.0f);
            this.setToolbarSideLeft();
        } else if (iPLAStatus.getActiveSide() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, "pla_parking_left", 1.0f);
            this.setToolbarSideRight();
        }
        this.propertyCache.setProperty((INode)this.propNode, "pla_cursor_visible", 0.0f);
    }

    private void setIdleMode() {
        this.setToolbarSideNone();
        this.propertyCache.setProperty((INode)this.propNode, "pla_cursorPosition", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_cursor_visible", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_indicator", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_speed", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverseGear", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_reverse", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_forward", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_instruction_brake", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_visible", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_exit_state", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_exit_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_exit_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_scanning_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_mode_left", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_right", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_parking_sign_left", 0.0f);
    }

    private void setToolbarSideLeft() {
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_parallel", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_forward", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_reverse", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_parallel", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_forward", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_reverse", 0.0f);
    }

    private void setToolbarSideRight() {
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_parallel", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_forward", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_reverse", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_parallel", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_forward", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_reverse", 1.0f);
    }

    private void setToolbarSideBoth() {
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_parallel", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_forward", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_reverse", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_parallel", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_forward", 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_reverse", 1.0f);
    }

    private void setToolbarSideNone() {
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_parallel", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_forward", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_left_lateral_reverse", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_parallel", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_forward", 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, "pla_toolbar_right_lateral_reverse", 0.0f);
    }

    public void clearResources() {
        this.propertyCache.clearAll();
    }
}

