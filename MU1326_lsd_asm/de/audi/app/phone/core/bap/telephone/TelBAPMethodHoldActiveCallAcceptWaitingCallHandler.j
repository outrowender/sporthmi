.version 50 0 
.class super [138] 
.super [140] 

.method annotation [142] : [143] 
    .attribute [141] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [28] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [144] : [145] 
    .attribute [141] .code stack 4 locals 4 
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
L56:    invokespecial [29] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [32] 0 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L80 
L71:    aload_3 
L72:    invokeinterface [33] 0 
L77:    goto L81 
L80:    aconst_null 
L81:    astore 4 
L83:    aload 4 
L85:    ifnull L144 
L88:    aload 4 
L90:    invokevirtual [23] 
L93:    ifeq L144 
L96:    aload 4 
L98:    invokevirtual [24] 
L101:   ifeq L144 
L104:   aload 4 
L106:   invokevirtual [25] 
L109:   ifne L144 
L112:   aload_0 
L113:   getfield [19] 
L116:   ldc [7] 
L118:   ldc [8] 
L120:   invokevirtual [20] 
L123:   pop 
L124:   aload_0 
L125:   invokevirtual [26] 
L128:   invokeinterface [34] 0 
L133:   iconst_1 
L134:   iconst_1 
L135:   aload_0 
L136:   invokeinterface [35] 0 
L141:   goto L160 
L144:   aload_0 
L145:   getfield [19] 
L148:   ldc [4] 
L150:   ldc [9] 
L152:   invokevirtual [20] 
L155:   pop 
L156:   aload_0 
L157:   invokespecial [29] 
L160:   return 
L161:   nop 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [141] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [30] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [148] : [149] 
    .attribute [141] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [36] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [31] 
L10:    invokevirtual [27] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [150] : [151] 
    .attribute [141] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [152] : [153] 
    .attribute [141] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [154] : [155] 
    .attribute [141] .code stack 1 locals 0 
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
.const [3] = String [37] 
.const [4] = Int -1601830656 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = Int 1078071040 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Class [49] 
.const [18] = Class [50] 
.const [19] = Field [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Method [69] [70] 
.const [29] = Method [71] [72] 
.const [30] = Method [73] [74] 
.const [31] = Method [75] [76] 
.const [32] = InterfaceMethod [77] [78] 
.const [33] = InterfaceMethod [79] [80] 
.const [34] = InterfaceMethod [81] [82] 
.const [35] = InterfaceMethod [83] [84] 
.const [36] = Class [85] 
.const [37] = Utf8 '[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall]' 
.const [38] = Utf8 '[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] combiService is null --> NOP!' 
.const [39] = Utf8 '[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] telState is null --> NOP!' 
.const [40] = Utf8 '[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] invoking accept call (mod = ACCEPTMODE_HOLD).' 
.const [41] = Utf8 '[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] There is already a held call, returning MPCHAWC_RESULT_NOT_SUCCESSFUL' 
.const [42] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1 
.const [43] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [44] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [47] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [48] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [49] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [50] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Class [134] 
.const [84] = NameAndType [135] [136] 
.const [85] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1 
.const [86] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [87] = Utf8 log 
.const [88] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [89] = Utf8 de/audi/atip/log/LogChannel 
.const [90] = Utf8 log 
.const [91] = Utf8 (ILjava/lang/String;)Z 
.const [92] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [93] = Utf8 getTelephoneState 
.const [94] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [95] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [96] = Utf8 getCombiBapServicePhone 
.const [97] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [98] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [99] = Utf8 isHasActiveCall 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [102] = Utf8 isHasIncomingCall 
.const [103] = Utf8 ()Z 
.const [104] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [105] = Utf8 isHasOnHoldCall 
.const [106] = Utf8 ()Z 
.const [107] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [108] = Utf8 getApplication 
.const [109] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [110] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [111] = Utf8 enqueueResultNotification 
.const [112] = Utf8 (Ljava/lang/Runnable;)V 
.const [113] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [116] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [117] = Utf8 sendResultNotSuccessful 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [120] = Utf8 sendResult 
.const [121] = Utf8 (I)V 
.const [122] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler;I)V 
.const [125] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [126] = Utf8 getCallLeadingDevice 
.const [127] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [128] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [129] = Utf8 getCallState 
.const [130] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [131] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [132] = Utf8 getTelephoneDSIAccess 
.const [133] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [134] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [135] = Utf8 acceptCall 
.const [136] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [137] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler 
.const [138] = Class [137] 
.const [139] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [140] = Class [139] 
.const [141] = Utf8 Code 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [144] = Utf8 callHoldActiveAcceptWaitingCall 
.const [145] = Utf8 ()V 
.const [146] = Utf8 responseAcceptCall 
.const [147] = Utf8 (II)V 
.const [148] = Utf8 sendResult 
.const [149] = Utf8 (I)V 
.const [150] = Utf8 sendResultNotSuccessful 
.const [151] = Utf8 ()V 
.const [152] = Utf8 access$000 
.const [153] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler;)Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 access$100 
.const [155] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHoldActiveCallAcceptWaitingCallHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
