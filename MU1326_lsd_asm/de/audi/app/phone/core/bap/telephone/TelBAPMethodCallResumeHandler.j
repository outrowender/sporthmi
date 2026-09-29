.version 50 0 
.class super [146] 
.super [148] 

.method annotation [150] : [151] 
    .attribute [149] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [29] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [152] : [153] 
    .attribute [149] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [21] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [22] 
L16:    astore_1 
L17:    aload_0 
L18:    invokevirtual [23] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnonnull L39 
L26:    aload_0 
L27:    getfield [20] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    invokevirtual [21] 
L37:    pop 
L38:    return 
L39:    aload_1 
L40:    ifnonnull L60 
L43:    aload_0 
L44:    getfield [20] 
L47:    ldc [4] 
L49:    ldc [6] 
L51:    invokevirtual [21] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [30] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [33] 0 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L161 
L71:    aload_3 
L72:    invokeinterface [34] 0 
L77:    ifnull L161 
L80:    aload_3 
L81:    invokeinterface [34] 0 
L86:    invokevirtual [24] 
L89:    ifeq L161 
L92:    aload_3 
L93:    invokeinterface [34] 0 
L98:    invokevirtual [25] 
L101:   invokevirtual [26] 
L104:   bipush 8 
L106:   if_icmpne L129 
L109:   aload_0 
L110:   invokevirtual [27] 
L113:   invokeinterface [35] 0 
L118:   iconst_1 
L119:   iconst_1 
L120:   aload_0 
L121:   invokeinterface [36] 0 
L126:   goto L181 
L129:   aload_0 
L130:   getfield [20] 
L133:   ldc [7] 
L135:   ldc [8] 
L137:   invokevirtual [21] 
L140:   pop 
L141:   aload_0 
L142:   invokevirtual [27] 
L145:   invokeinterface [35] 0 
L150:   iconst_1 
L151:   iconst_1 
L152:   aload_0 
L153:   invokeinterface [37] 0 
L158:   goto L181 
L161:   aload_2 
L162:   ifnull L181 
L165:   aload_0 
L166:   getfield [20] 
L169:   ldc [4] 
L171:   ldc [9] 
L173:   invokevirtual [21] 
L176:   pop 
L177:   aload_0 
L178:   invokespecial [30] 
L181:   return 
L182:   nop 
L183:   nop 
L184:   
    .end code 
.end method 

.method private [154] : [155] 
    .attribute [149] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [149] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [31] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [158] : [159] 
    .attribute [149] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [38] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [32] 
L10:    invokevirtual [28] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [160] : [161] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [162] : [163] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [39] 
.const [4] = Int -1601830656 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = Int 1078071040 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Class [51] 
.const [18] = Class [52] 
.const [19] = Class [53] 
.const [20] = Field [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Method [78] [79] 
.const [33] = InterfaceMethod [80] [81] 
.const [34] = InterfaceMethod [82] [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = InterfaceMethod [86] [87] 
.const [37] = InterfaceMethod [88] [89] 
.const [38] = Class [90] 
.const [39] = Utf8 '[TelBAPMethodCallResumeHandler#resumeCall]' 
.const [40] = Utf8 '[TelBAPMethodCallResumeHandler#resumeCall] combiService is null --> NOP!' 
.const [41] = Utf8 '[TelBAPMethodCallResumeHandler#resumeCall] telState is null --> NOP!' 
.const [42] = Utf8 '[TelBAPMethodCallResumeHandler#resumeCall] invoking swapCalls()' 
.const [43] = Utf8 '[TelBAPMethodCallResumeHandler#resumeCall] There is currently no held call, returning RESUME_CALL_RESULT_NOT_SUCCESSFUL' 
.const [44] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler$1 
.const [45] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [46] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [49] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [50] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [51] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [52] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [53] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Class [124] 
.const [77] = NameAndType [125] [126] 
.const [78] = Class [127] 
.const [79] = NameAndType [128] [129] 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Class [133] 
.const [83] = NameAndType [134] [135] 
.const [84] = Class [136] 
.const [85] = NameAndType [137] [138] 
.const [86] = Class [139] 
.const [87] = NameAndType [140] [141] 
.const [88] = Class [142] 
.const [89] = NameAndType [143] [144] 
.const [90] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler$1 
.const [91] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [92] = Utf8 log 
.const [93] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;)Z 
.const [97] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [98] = Utf8 getTelephoneState 
.const [99] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [100] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [101] = Utf8 getCombiBapServicePhone 
.const [102] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [103] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [104] = Utf8 isHasOnHoldCall 
.const [105] = Utf8 ()Z 
.const [106] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [107] = Utf8 getHeldCall 
.const [108] = Utf8 ()Lde/audi/app/phone/core/calllist/AbstractPhoneCall; 
.const [109] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [110] = Utf8 getTelCallState 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [113] = Utf8 getApplication 
.const [114] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [115] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [116] = Utf8 enqueueResultNotification 
.const [117] = Utf8 (Ljava/lang/Runnable;)V 
.const [118] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [121] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [122] = Utf8 sendResultNotSuccessful 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [125] = Utf8 sendResult 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler$1 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler;I)V 
.const [130] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [131] = Utf8 getCallLeadingDevice 
.const [132] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [133] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [134] = Utf8 getCallState 
.const [135] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [136] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [137] = Utf8 getTelephoneDSIAccess 
.const [138] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [139] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [140] = Utf8 acceptCall 
.const [141] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [142] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [143] = Utf8 swapCalls 
.const [144] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [145] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [148] = Class [147] 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [152] = Utf8 resumeCall 
.const [153] = Utf8 ()V 
.const [154] = Utf8 sendResultNotSuccessful 
.const [155] = Utf8 ()V 
.const [156] = Utf8 responseSwapCalls 
.const [157] = Utf8 (II)V 
.const [158] = Utf8 sendResult 
.const [159] = Utf8 (I)V 
.const [160] = Utf8 access$000 
.const [161] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler;)Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 access$100 
.const [163] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodCallResumeHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
