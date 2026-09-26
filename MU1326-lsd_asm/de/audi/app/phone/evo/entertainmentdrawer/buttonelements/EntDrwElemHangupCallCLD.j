.version 50 0 
.class public super [76] 
.super [78] 

.method public [80] : [81] 
    .attribute [79] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [13] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [82] : [83] 
    .attribute [79] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [9] 
L5:     invokespecial [14] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [79] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokevirtual [10] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [86] : [87] 
    .attribute [79] .code stack 1 locals 1 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [15] 0 
L10:    goto L14 
L13:    aconst_null 
L14:    astore_2 
L15:    aload_1 
L16:    ifnull L44 
L19:    aload_1 
L20:    invokeinterface [16] 0 
L25:    ifnull L44 
L28:    aload_1 
L29:    invokeinterface [16] 0 
L34:    invokeinterface [17] 0 
L39:    ifeq L44 
L42:    iconst_2 
L43:    areturn 
L44:    aload_2 
L45:    ifnull L87 
L48:    aload_2 
L49:    invokeinterface [18] 0 
L54:    ifnull L87 
L57:    aload_2 
L58:    invokeinterface [18] 0 
L63:    invokevirtual [11] 
L66:    ifne L81 
L69:    aload_2 
L70:    invokeinterface [18] 0 
L75:    invokevirtual [12] 
L78:    ifeq L85 
L81:    iconst_0 
L82:    goto L86 
L85:    iconst_2 
L86:    areturn 
L87:    iconst_0 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1217922048 
.const [3] = Class [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = InterfaceMethod [37] [38] 
.const [16] = InterfaceMethod [39] [40] 
.const [17] = InterfaceMethod [41] [42] 
.const [18] = InterfaceMethod [43] [44] 
.const [19] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemHangupCallCLD 
.const [20] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [21] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [22] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [23] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [24] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemHangupCallCLD 
.const [46] = Utf8 getCurrentStateStruct 
.const [47] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [48] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemHangupCallCLD 
.const [49] = Utf8 getChoiceModel 
.const [50] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [51] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [52] = Utf8 isHasDisconnectingCall 
.const [53] = Utf8 ()Z 
.const [54] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [55] = Utf8 isIdle 
.const [56] = Utf8 ()Z 
.const [57] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [58] = Utf8 <init> 
.const [59] = Utf8 (Lde/audi/app/phone/core/ITelApplication;I)V 
.const [60] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemHangupCallCLD 
.const [61] = Utf8 computeNewValue 
.const [62] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [63] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [64] = Utf8 getCallLeadingDevice 
.const [65] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [66] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [67] = Utf8 getConnectedGatewayState 
.const [68] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [69] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [70] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [71] = Utf8 ()Z 
.const [72] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [73] = Utf8 getCallState 
.const [74] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [75] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemHangupCallCLD 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [78] = Class [77] 
.const [79] = Utf8 Code 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [82] = Utf8 getNewValue 
.const [83] = Utf8 ()I 
.const [84] = Utf8 getConditionModel 
.const [85] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [86] = Utf8 computeNewValue 
.const [87] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.end class 
