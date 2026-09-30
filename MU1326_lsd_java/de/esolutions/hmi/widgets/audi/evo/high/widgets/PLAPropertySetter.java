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
    private static final String PLA_CURSOR_POSITION = "pla_cursorPosition";
    private static final String PLA_CURSOR_VISIBLE = "pla_cursor_visible";
    private static final String PLA_INDICATOR = "pla_indicator";
    private static final String PLA_INSTRUCTION_SPEED = "pla_instruction_speed";
    private static final String PLA_INSTRUCTION_REVERSE_GEAR = "pla_instruction_reverseGear";
    private static final String PLA_INSTRUCTION_REVERSE = "pla_instruction_reverse";
    private static final String PLA_INSTRUCTION_FORWARD = "pla_instruction_forward";
    private static final String PLA_INSTRUCTION_BRAKE = "pla_instruction_brake";
    private static final String PLA_TOOLBAR_VISIBLE = "pla_toolbar_visible";
    private static final String PLA_TOOLBAR_RIGHT_LATERAL_REVERSE = "pla_toolbar_right_lateral_reverse";
    private static final String PLA_TOOLBAR_RIGHT_LATERAL_FORWARD = "pla_toolbar_right_lateral_forward";
    private static final String PLA_TOOLBAR_RIGHT_PARALLEL = "pla_toolbar_right_parallel";
    private static final String PLA_TOOLBAR_LEFT_LATERAL_REVERSE = "pla_toolbar_left_lateral_reverse";
    private static final String PLA_TOOLBAR_LEFT_LATERAL_FORWARD = "pla_toolbar_left_lateral_forward";
    private static final String PLA_TOOLBAR_LEFT_PARALLEL = "pla_toolbar_left_parallel";
    private static final String PLA_EXIT_STATE = "pla_exit_state";
    private static final String PLA_EXIT_LEFT = "pla_exit_left";
    private static final String PLA_EXIT_RIGHT = "pla_exit_right";
    private static final String PLA_SCANNING_RIGHT = "pla_scanning_right";
    private static final String PLA_SCANNING_LEFT = "pla_scanning_left";
    private static final String PLA_PARKING_RIGHT = "pla_parking_right";
    private static final String PLA_PARKING_LEFT = "pla_parking_left";
    private static final String PLA_PARKING_MODE_RIGHT = "pla_parking_mode_right";
    private static final String PLA_PARKING_MODE_LEFT = "pla_parking_mode_left";
    private static final String PLA_PARKING_SIGN_RIGHT = "pla_parking_sign_right";
    private static final String PLA_PARKING_SIGN_LEFT = "pla_parking_sign_left";
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
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_VISIBLE, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_SPEED, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_STATE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_LEFT, 0.0f);
    }

    private void setParkoutMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_VISIBLE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_STATE, 1.0f);
        int n = iPLAStatus.getPreSelection();
        if (n == -1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_LEFT, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_RIGHT, 1.0f);
        } else if (n == 0 || n == 2 || n == 1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_LEFT, 2.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_RIGHT, 0.0f);
        } else if (n == 3 || n == 5 || n == 4) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_LEFT, 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_RIGHT, 2.0f);
        }
    }

    private void setInstructionSymbols() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, PLA_INDICATOR, (float)iPLAStatus.getSteeringInterventionSymbol());
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_BRAKE, iPLAStatus.isBrakeSymbol() ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_RIGHT, 0.0f);
        if (iPLAStatus.getDrivingDirection() == 0) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_FORWARD, 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE, 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE_GEAR, 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE_GEAR, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_FORWARD, 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 3) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_FORWARD, 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE_GEAR, 0.0f);
        } else if (iPLAStatus.getDrivingDirection() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_FORWARD, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE, 0.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE_GEAR, 0.0f);
        }
        if (iPLAStatus.isPosOKSymbol()) {
            if (iPLAStatus.getActiveSide() == 2) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_RIGHT, 1.0f);
            } else if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_LEFT, 1.0f);
            }
        }
    }

    private void setSearchMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_RIGHT, 0.0f);
        if (iPLAStatus.getActiveSide() == 0) {
            this.setToolbarSideBoth();
        } else if (iPLAStatus.getActiveSide() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_RIGHT, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_RIGHT, 1.0f);
            this.setToolbarSideLeft();
        } else if (iPLAStatus.getActiveSide() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_LEFT, 1.0f);
            this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_LEFT, 1.0f);
            this.setToolbarSideRight();
        }
        if (iPLAStatus.getPreSelection() == -1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_VISIBLE, 0.0f);
        } else {
            this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_VISIBLE, 1.0f);
        }
        if (this.plaController.getCursorPosition() != -1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_POSITION, (float)this.plaController.getCursorPosition());
            int n = this.plaController.getCursorPosition() % 3;
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_LEFT, (float)(n + 1));
            } else {
                this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_RIGHT, (float)(n + 1));
            }
        } else {
            this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_VISIBLE, 0.0f);
        }
        if (iPLAStatus.isForwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_FORWARD, 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_FORWARD, 2.0f);
            }
        }
        if (iPLAStatus.isBackwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_REVERSE, 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_REVERSE, 2.0f);
            }
        }
        if (iPLAStatus.isBackwardParallelToRoadSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_PARALLEL, 2.0f);
            } else {
                this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_PARALLEL, 2.0f);
            }
        }
    }

    private void setStandyMode() {
        IPLAStatus iPLAStatus = this.plaController.getPLAStatus();
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_SPEED, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_RIGHT, 0.0f);
        if (iPLAStatus.getActiveSide() == 0) {
            this.setToolbarSideNone();
        } else if (iPLAStatus.getActiveSide() == 2) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_RIGHT, 1.0f);
            this.setToolbarSideLeft();
        } else if (iPLAStatus.getActiveSide() == 1) {
            this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_LEFT, 1.0f);
            this.setToolbarSideRight();
        }
        this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_VISIBLE, 0.0f);
    }

    private void setIdleMode() {
        this.setToolbarSideNone();
        this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_POSITION, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_CURSOR_VISIBLE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INDICATOR, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_SPEED, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE_GEAR, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_REVERSE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_FORWARD, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_INSTRUCTION_BRAKE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_VISIBLE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_STATE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_EXIT_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_SCANNING_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_MODE_LEFT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_RIGHT, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_PARKING_SIGN_LEFT, 0.0f);
    }

    private void setToolbarSideLeft() {
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_PARALLEL, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_FORWARD, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_REVERSE, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_PARALLEL, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_FORWARD, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_REVERSE, 0.0f);
    }

    private void setToolbarSideRight() {
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_PARALLEL, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_FORWARD, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_REVERSE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_PARALLEL, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_FORWARD, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_REVERSE, 1.0f);
    }

    private void setToolbarSideBoth() {
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_PARALLEL, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_FORWARD, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_REVERSE, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_PARALLEL, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_FORWARD, 1.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_REVERSE, 1.0f);
    }

    private void setToolbarSideNone() {
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_PARALLEL, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_FORWARD, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_LEFT_LATERAL_REVERSE, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_PARALLEL, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_FORWARD, 0.0f);
        this.propertyCache.setProperty((INode)this.propNode, PLA_TOOLBAR_RIGHT_LATERAL_REVERSE, 0.0f);
    }

    public void clearResources() {
        this.propertyCache.clearAll();
    }
}

