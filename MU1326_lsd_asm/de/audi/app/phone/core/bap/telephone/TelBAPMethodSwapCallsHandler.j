.version 50 0 
.class super [132] 
.super [134] 

.method annotation [136] : [137] 
    .attribute [135] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [27] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [138] : [139] 
    .attribute [135] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [20] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [21] 
L16:    astore_1 
L17:    aload_0 
L18:    invokevirtual [22] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnonnull L39 
L26:    aload_0 
L27:    getfield [19] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    invokevirtual [20] 
L37:    pop 
L38:    return 
L39:    aload_1 
L40:    ifnonnull L60 
L43:    aload_0 
L44:    getfield [19] 
L47:    ldc [4] 
L49:    ldc [6] 
L51:    invokevirtual [20] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [28] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [31] 0 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L80 
L71:    aload_3 
L72:    invokeinterface [32] 0 
L77:    goto L81 
L80:    aconst_null 
L81:    astore 4 
L83:    aload 4 
L85:    ifnull L128 
L88:    aload 4 
L90:    invokevirtual [23] 
L93:    ifeq L128 
L96:    aload_0 
L97:    getfield [19] 
L100:   ldc [7] 
L102:   ldc [8] 
L104:   invokevirtual [20] 
L107:   pop 
L108:   aload_0 
L109:   invokevirtual [24] 
L112:   invokeinterface [33] 0 
L117:   iconst_1 
L118:   iconst_1 
L119:   aload_0 
L120:   invokeinterface [34] 0 
L125:   goto L132 
L128:   aload_0 
L129:   invokespecial [28] 
L132:   return 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method private [140] : [141] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [135] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [9] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [25] 
L13:    pop 
L14:    iload_1 
L15:    ifne L22 
L18:    iconst_0 
L19:    goto L23 
L22:    iconst_1 
L23:    istore_3 
L24:    aload_0 
L25:    iload_3 
L26:    invokespecial [29] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [144] : [145] 
    .attribute [135] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [35] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [30] 
L10:    invokevirtual [26] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [146] : [147] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [148] : [149] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [36] 
.const [4] = Int -1601830656 
.const [5] = String [37] 
.const [6] = String [38] 
.const [7] = Int 1078071040 
.const [8] = String [39] 
.const [9] = String [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Class [48] 
.const [18] = Class [49] 
.const [19] = Field [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Method [70] [71] 
.const [30] = Method [72] [73] 
.const [31] = InterfaceMethod [74] [75] 
.const [32] = InterfaceMethod [76] [77] 
.const [33] = InterfaceMethod [78] [79] 
.const [34] = InterfaceMethod [80] [81] 
.const [35] = Class [82] 
.const [36] = Utf8 '[TelBAPMethodSwapCallsHandler#swapCalls]' 
.const [37] = Utf8 '[TelBAPMethodSwapCallsHandler#swapCalls] combiService is null --> NOP!' 
.const [38] = Utf8 '[TelBAPMethodSwapCallsHandler#swapCalls] telState is null --> NOP!' 
.const [39] = Utf8 '[TelBAPMethodSwapCallsHandler#swapCalls] invoking swapCalls()' 
.const [40] = Utf8 '[TelBAPMethodSwapCallsHandler#responseSwapCalls] result=%1' 
.const [41] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler$1 
.const [42] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [43] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [44] = Utf8 de/audi/atip/log/LogChannel 
.const [45] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [46] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [47] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [48] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [49] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Class [98] 
.const [61] = NameAndType [99] [100] 
.const [62] = Class [101] 
.const [63] = NameAndType [102] [103] 
.const [64] = Class [104] 
.const [65] = NameAndType [105] [106] 
.const [66] = Class [107] 
.const [67] = NameAndType [108] [109] 
.const [68] = Class [110] 
.const [69] = NameAndType [111] [112] 
.const [70] = Class [113] 
.const [71] = NameAndType [114] [115] 
.const [72] = Class [116] 
.const [73] = NameAndType [117] [118] 
.const [74] = Class [119] 
.const [75] = NameAndType [120] [121] 
.const [76] = Class [122] 
.const [77] = NameAndType [123] [124] 
.const [78] = Class [125] 
.const [79] = NameAndType [126] [127] 
.const [80] = Class [128] 
.const [81] = NameAndType [129] [130] 
.const [82] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler$1 
.const [83] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [84] = Utf8 log 
.const [85] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 log 
.const [88] = Utf8 (ILjava/lang/String;)Z 
.const [89] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [90] = Utf8 getTelephoneState 
.const [91] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [92] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [93] = Utf8 getCombiBapServicePhone 
.const [94] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [95] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [96] = Utf8 isMultipartyActive 
.const [97] = Utf8 ()Z 
.const [98] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [99] = Utf8 getApplication 
.const [100] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;J)Z 
.const [104] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [105] = Utf8 enqueueResultNotification 
.const [106] = Utf8 (Ljava/lang/Runnable;)V 
.const [107] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [110] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [111] = Utf8 sendResultNotSuccessful 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [114] = Utf8 sendResult 
.const [115] = Utf8 (I)V 
.const [116] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler$1 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler;I)V 
.const [119] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [120] = Utf8 getCallLeadingDevice 
.const [121] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [122] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [123] = Utf8 getCallState 
.const [124] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [125] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [126] = Utf8 getTelephoneDSIAccess 
.const [127] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [128] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [129] = Utf8 swapCalls 
.const [130] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [131] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler 
.const [132] = Class [131] 
.const [133] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [134] = Class [133] 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [138] = Utf8 swapCalls 
.const [139] = Utf8 ()V 
.const [140] = Utf8 sendResultNotSuccessful 
.const [141] = Utf8 ()V 
.const [142] = Utf8 responseSwapCalls 
.const [143] = Utf8 (II)V 
.const [144] = Utf8 sendResult 
.const [145] = Utf8 (I)V 
.const [146] = Utf8 access$000 
.const [147] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler;)Lde/audi/atip/log/LogChannel; 
.const [148] = Utf8 access$100 
.const [149] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSwapCallsHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
