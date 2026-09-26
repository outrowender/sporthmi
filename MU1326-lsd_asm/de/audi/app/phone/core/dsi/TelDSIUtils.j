.version 50 0 
.class public super [73] 
.super [75] 

.method public annotation [77] : [78] 
    .attribute [76] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [79] : [80] 
    .attribute [76] .code stack 2 locals 1 
L0:     aload_0 
L1:     ifnull L96 
L4:     aload_0 
L5:     invokeinterface [17] 0 
L10:    ifnull L96 
L13:    aload_0 
L14:    invokeinterface [17] 0 
L19:    astore_1 
L20:    aload_1 
L21:    invokevirtual [10] 
L24:    ifeq L96 
L27:    aload_1 
L28:    invokevirtual [11] 
L31:    ifeq L43 
L34:    aload_0 
L35:    invokeinterface [18] 0 
L40:    ifeq L50 
L43:    aload_1 
L44:    invokevirtual [12] 
L47:    ifeq L52 
L50:    iconst_1 
L51:    areturn 
L52:    aload_1 
L53:    invokevirtual [11] 
L56:    aload_1 
L57:    invokevirtual [13] 
L60:    ixor 
L61:    ifeq L94 
L64:    aload_1 
L65:    invokevirtual [14] 
L68:    ifnull L94 
L71:    aload_1 
L72:    invokevirtual [14] 
L75:    invokevirtual [15] 
L78:    bipush 8 
L80:    if_icmpeq L94 
L83:    aload_0 
L84:    invokeinterface [18] 0 
L89:    ifeq L94 
L92:    iconst_2 
L93:    areturn 
L94:    iconst_0 
L95:    areturn 
L96:    iconst_0 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public static [81] : [82] 
    .attribute [76] .code stack 1 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            65536 : L36 
            131072 : L39 
            196608 : L42 
            default : L45 

L36:    ldc [2] 
L38:    areturn 
L39:    ldc [3] 
L41:    areturn 
L42:    ldc [4] 
L44:    areturn 
L45:    ldc [5] 
L47:    areturn 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [19] 
.const [3] = String [20] 
.const [4] = String [21] 
.const [5] = String [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = InterfaceMethod [41] [42] 
.const [18] = InterfaceMethod [43] [44] 
.const [19] = Utf8 ROLE_PRIMARY 
.const [20] = Utf8 ROLE_ASSOCIATED 
.const [21] = Utf8 ROLE_DATA 
.const [22] = Utf8 ROLE_UNKNOWN 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [25] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [26] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [46] = Utf8 isHasIncomingCall 
.const [47] = Utf8 ()Z 
.const [48] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [49] = Utf8 isHasActiveCall 
.const [50] = Utf8 ()Z 
.const [51] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [52] = Utf8 isMultipartyActive 
.const [53] = Utf8 ()Z 
.const [54] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [55] = Utf8 isHasOnHoldCall 
.const [56] = Utf8 ()Z 
.const [57] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [58] = Utf8 getHeldCall 
.const [59] = Utf8 ()Lde/audi/app/phone/core/calllist/AbstractPhoneCall; 
.const [60] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [61] = Utf8 getTelCallState 
.const [62] = Utf8 ()I 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [67] = Utf8 getCallState 
.const [68] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [69] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [70] = Utf8 isMultipartySupported 
.const [71] = Utf8 ()Z 
.const [72] = Utf8 de/audi/app/phone/core/dsi/TelDSIUtils 
.const [73] = Class [72] 
.const [74] = Utf8 java/lang/Object 
.const [75] = Class [74] 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 getAcceptMode 
.const [80] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [81] = Utf8 getRoleName 
.const [82] = Utf8 (I)Ljava/lang/String; 
.end class 
