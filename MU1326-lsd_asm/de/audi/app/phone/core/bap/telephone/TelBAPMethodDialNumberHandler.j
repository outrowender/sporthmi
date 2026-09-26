.version 50 0 
.class super [164] 
.super [166] 
.field private static final [167] [168] 
.field private static final [169] [170] 
.field private static final [171] [172] 
.field private static final [173] [174] 
.field private static final [175] [176] 
.field private static final [177] [178] 
.field private static final [179] [180] 
.field private static final [181] [182] 

.method private static [184] : [185] 
    .attribute [183] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            0 : L36 
            12 : L38 
            13 : L38 
            default : L40 

L36:    iconst_0 
L37:    areturn 
L38:    iconst_5 
L39:    areturn 
L40:    aload_0 
L41:    ifnull L58 
L44:    aload_0 
L45:    invokeinterface [35] 0 
L50:    ifeq L58 
L53:    bipush 12 
L55:    goto L59 
L58:    iconst_1 
L59:    areturn 
L60:    
    .end code 
.end method 

.method annotation [186] : [187] 
    .attribute [183] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [31] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [188] : [189] 
    .attribute [183] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [22] 
L13:    aload_0 
L14:    invokevirtual [23] 
L17:    astore_3 
L18:    aload_0 
L19:    invokevirtual [24] 
L22:    astore 4 
L24:    aload 4 
L26:    ifnonnull L42 
L29:    aload_0 
L30:    getfield [21] 
L33:    ldc [4] 
L35:    ldc [5] 
L37:    invokevirtual [25] 
L40:    pop 
L41:    return 
L42:    aload_3 
L43:    ifnonnull L63 
L46:    aload_0 
L47:    getfield [21] 
L50:    ldc [4] 
L52:    ldc [6] 
L54:    invokevirtual [25] 
L57:    pop 
L58:    aload_0 
L59:    invokespecial [32] 
L62:    return 
L63:    aload_3 
L64:    invokeinterface [36] 0 
L69:    astore 5 
L71:    aload 5 
L73:    ifnull L93 
L76:    aload 5 
L78:    invokeinterface [37] 0 
L83:    ifeq L93 
L86:    aload_0 
L87:    invokespecial [32] 
L90:    goto L158 
L93:    aload_3 
L94:    invokeinterface [38] 0 
L99:    invokevirtual [26] 
L102:   ifeq L127 
L105:   aload_0 
L106:   getfield [21] 
L109:   ldc [7] 
L111:   ldc [8] 
L113:   invokevirtual [25] 
L116:   pop 
L117:   aload_0 
L118:   sipush 144 
L121:   invokespecial [33] 
L124:   goto L158 
L127:   aload_0 
L128:   getfield [21] 
L131:   ldc [7] 
L133:   ldc [9] 
L135:   aload_1 
L136:   invokevirtual [27] 
L139:   pop 
L140:   aload_0 
L141:   invokevirtual [28] 
L144:   invokeinterface [39] 0 
L149:   aload_1 
L150:   iconst_1 
L151:   iconst_1 
L152:   aload_0 
L153:   invokeinterface [40] 0 
L158:   return 
L159:   nop 
L160:   
    .end code 
.end method 

.method private [190] : [191] 
    .attribute [183] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [183] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     aload_3 
L9:     iload_1 
L10:    i2l 
L11:    invokevirtual [29] 
L14:    pop 
L15:    aload_0 
L16:    invokevirtual [23] 
L19:    iload_1 
L20:    invokestatic [11] 
L23:    istore 5 
L25:    aload_0 
L26:    iload 5 
L28:    invokespecial [33] 
L31:    return 
L32:    
    .end code 
.end method 

.method private [194] : [195] 
    .attribute [183] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [41] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [34] 
L10:    invokevirtual [30] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [196] : [197] 
    .attribute [183] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [198] : [199] 
    .attribute [183] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [42] 
.const [4] = Int -1601830656 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = Int 1078071040 
.const [8] = String [45] 
.const [9] = String [46] 
.const [10] = String [47] 
.const [11] = Method [48] [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Method [85] [86] 
.const [35] = InterfaceMethod [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = InterfaceMethod [91] [92] 
.const [38] = InterfaceMethod [93] [94] 
.const [39] = InterfaceMethod [95] [96] 
.const [40] = InterfaceMethod [97] [98] 
.const [41] = Class [99] 
.const [42] = Utf8 '[TelBAPMethodDialNumberHandler#dialNumber] telNumber=%1, name=%2' 
.const [43] = Utf8 '[TelBAPMethodDialNumberHandler#dialNumber] combiService is null --> NOP!' 
.const [44] = Utf8 '[TelBAPMethodDialNumberHandler#dialNumber] telState is null --> NOP!' 
.const [45] = Utf8 '[TelBAPMethodDialNumberHandler#dialNumber] cannot dial because outgoing call already present!' 
.const [46] = Utf8 '[TelBAPMethodDialNumberHandler#dialNumber] dialing %1' 
.const [47] = Utf8 '[TelBAPMethodDialNumberHandler#responseDialNumber] result=%2, telSuppServResult=%1' 
.const [48] = Class [100] 
.const [49] = NameAndType [101] [102] 
.const [50] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler$1 
.const [51] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [52] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [53] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [56] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [57] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [58] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Class [142] 
.const [86] = NameAndType [143] [144] 
.const [87] = Class [145] 
.const [88] = NameAndType [146] [147] 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Class [151] 
.const [92] = NameAndType [152] [153] 
.const [93] = Class [154] 
.const [94] = NameAndType [155] [156] 
.const [95] = Class [157] 
.const [96] = NameAndType [158] [159] 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler$1 
.const [100] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [101] = Utf8 getDialNumberResult 
.const [102] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;I)I 
.const [103] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [104] = Utf8 log 
.const [105] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [109] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [110] = Utf8 getTelephoneState 
.const [111] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [112] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [113] = Utf8 getCombiBapServicePhone 
.const [114] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;)Z 
.const [118] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [119] = Utf8 isHasOutgoingCall 
.const [120] = Utf8 ()Z 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 log 
.const [123] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [124] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [125] = Utf8 getApplication 
.const [126] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 log 
.const [129] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [130] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [131] = Utf8 enqueueResultNotification 
.const [132] = Utf8 (Ljava/lang/Runnable;)V 
.const [133] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [136] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [137] = Utf8 sendResultNotSuccessful 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [140] = Utf8 sendResult 
.const [141] = Utf8 (I)V 
.const [142] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler$1 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler;I)V 
.const [145] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [146] = Utf8 isAutomaticRedialActive 
.const [147] = Utf8 ()Z 
.const [148] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [149] = Utf8 getConnectedGatewayState 
.const [150] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [151] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [152] = Utf8 isCustomerCallNotAllowed 
.const [153] = Utf8 ()Z 
.const [154] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [155] = Utf8 getCallState 
.const [156] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [157] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [158] = Utf8 getTelephoneDSIAccess 
.const [159] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [160] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [161] = Utf8 dialNumber 
.const [162] = Utf8 (Ljava/lang/String;IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [163] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler 
.const [164] = Class [163] 
.const [165] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [166] = Class [165] 
.const [167] = Utf8 DIAL_NUMBER_RESULT_SUCCESSFUL 
.const [168] = Utf8 I 
.const [169] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL 
.const [170] = Utf8 I 
.const [171] = Utf8 DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL 
.const [172] = Utf8 I 
.const [173] = Utf8 DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL 
.const [174] = Utf8 I 
.const [175] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID 
.const [176] = Utf8 I 
.const [177] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK 
.const [178] = Utf8 I 
.const [179] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL 
.const [180] = Utf8 I 
.const [181] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE 
.const [182] = Utf8 I 
.const [183] = Utf8 Code 
.const [184] = Utf8 getDialNumberResult 
.const [185] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;I)I 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [188] = Utf8 dialNumber 
.const [189] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [190] = Utf8 sendResultNotSuccessful 
.const [191] = Utf8 ()V 
.const [192] = Utf8 responseDialNumber 
.const [193] = Utf8 (IILorg/dsi/ifc/telephoneng/SuppServiceResponseStruct;I)V 
.const [194] = Utf8 sendResult 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 access$000 
.const [197] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler;)Lde/audi/atip/log/LogChannel; 
.const [198] = Utf8 access$100 
.const [199] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
