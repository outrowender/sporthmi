.version 50 0 
.class public super [68] 
.super [70] 

.method public [72] : [73] 
    .attribute [71] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [12] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [74] : [75] 
    .attribute [71] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [8] 
L5:     invokespecial [13] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [71] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokevirtual [9] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [78] : [79] 
    .attribute [71] .code stack 1 locals 4 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [14] 0 
L10:    goto L14 
L13:    aconst_null 
L14:    astore_2 
L15:    aload_2 
L16:    ifnull L77 
L19:    aload_2 
L20:    invokeinterface [15] 0 
L25:    ifnull L77 
L28:    aload_2 
L29:    invokeinterface [15] 0 
L34:    invokevirtual [10] 
L37:    istore_3 
L38:    aload_2 
L39:    invokeinterface [15] 0 
L44:    invokevirtual [11] 
L47:    istore 4 
L49:    aload_2 
L50:    invokeinterface [16] 0 
L55:    istore 5 
L57:    iload_3 
L58:    ifeq L75 
L61:    iload 4 
L63:    ifne L75 
L66:    iload 5 
L68:    ifeq L75 
L71:    iconst_2 
L72:    goto L76 
L75:    iconst_0 
L76:    areturn 
L77:    iconst_0 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1117258752 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = InterfaceMethod [34] [35] 
.const [15] = InterfaceMethod [36] [37] 
.const [16] = InterfaceMethod [38] [39] 
.const [17] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemResumeConferenceCLD 
.const [18] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [19] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [20] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [21] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemResumeConferenceCLD 
.const [41] = Utf8 getCurrentStateStruct 
.const [42] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [43] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemResumeConferenceCLD 
.const [44] = Utf8 getChoiceModel 
.const [45] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [46] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [47] = Utf8 isHasOnHoldConferenceCall 
.const [48] = Utf8 ()Z 
.const [49] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [50] = Utf8 isHasActiveSingleCall 
.const [51] = Utf8 ()Z 
.const [52] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/app/phone/core/ITelApplication;I)V 
.const [55] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemResumeConferenceCLD 
.const [56] = Utf8 computeNewValue 
.const [57] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [58] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [59] = Utf8 getCallLeadingDevice 
.const [60] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [61] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [62] = Utf8 getCallState 
.const [63] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [64] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [65] = Utf8 isMultipartySupported 
.const [66] = Utf8 ()Z 
.const [67] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/EntDrwElemResumeConferenceCLD 
.const [68] = Class [67] 
.const [69] = Utf8 de/audi/app/phone/evo/entertainmentdrawer/buttonelements/AbstractButtonEntertainmentDrawerElement 
.const [70] = Class [69] 
.const [71] = Utf8 Code 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [74] = Utf8 getNewValue 
.const [75] = Utf8 ()I 
.const [76] = Utf8 getConditionModel 
.const [77] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [78] = Utf8 computeNewValue 
.const [79] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.end class 
