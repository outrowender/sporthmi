.version 50 0 
.class super [148] 
.super [150] 
.field private final [151] [152] 

.method [154] : [155] 
    .attribute [153] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [30] 
L6:     aload_0 
L7:     iconst_5 
L8:     putfield [34] 
L11:    return 
L12:    
    .end code 
.end method 

.method [156] : [157] 
    .attribute [153] .code stack 4 locals 6 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [23] 
L16:    astore_1 
L17:    aload_0 
L18:    invokevirtual [24] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnonnull L39 
L26:    aload_0 
L27:    getfield [21] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    invokevirtual [22] 
L37:    pop 
L38:    return 
L39:    aload_1 
L40:    ifnonnull L60 
L43:    aload_0 
L44:    getfield [21] 
L47:    ldc [4] 
L49:    ldc [6] 
L51:    invokevirtual [22] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [31] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [35] 0 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L80 
L71:    aload_3 
L72:    invokeinterface [36] 0 
L77:    goto L81 
L80:    aconst_null 
L81:    astore 4 
L83:    aload 4 
L85:    ifnull L96 
L88:    aload 4 
L90:    invokevirtual [25] 
L93:    goto L97 
L96:    aconst_null 
L97:    astore 5 
L99:    aload 5 
L101:   ifnull L126 
L104:   aload 5 
L106:   invokevirtual [26] 
L109:   ifnull L126 
L112:   aload 5 
L114:   invokevirtual [26] 
L117:   arraylength 
L118:   iconst_5 
L119:   if_icmpne L126 
L122:   iconst_1 
L123:   goto L127 
L126:   iconst_0 
L127:   istore 6 
L129:   iload 6 
L131:   ifeq L155 
L134:   aload_0 
L135:   getfield [21] 
L138:   ldc [7] 
L140:   ldc [8] 
L142:   invokevirtual [22] 
L145:   pop 
L146:   aload_0 
L147:   bipush 7 
L149:   invokespecial [32] 
L152:   goto L212 
L155:   aload 4 
L157:   invokevirtual [27] 
L160:   ifeq L195 
L163:   aload_0 
L164:   getfield [21] 
L167:   ldc [7] 
L169:   ldc [9] 
L171:   invokevirtual [22] 
L174:   pop 
L175:   aload_0 
L176:   invokevirtual [28] 
L179:   invokeinterface [37] 0 
L184:   iconst_1 
L185:   iconst_1 
L186:   aload_0 
L187:   invokeinterface [38] 0 
L192:   goto L212 
L195:   aload_0 
L196:   getfield [21] 
L199:   ldc [7] 
L201:   ldc [10] 
L203:   invokevirtual [22] 
L206:   pop 
L207:   aload_0 
L208:   iconst_1 
L209:   invokespecial [32] 
L212:   return 
L213:   nop 
L214:   nop 
L215:   nop 
L216:   
    .end code 
.end method 

.method private [158] : [159] 
    .attribute [153] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [32] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [153] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [32] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [162] : [163] 
    .attribute [153] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [33] 
L10:    invokevirtual [29] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [164] : [165] 
    .attribute [153] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [166] : [167] 
    .attribute [153] .code stack 1 locals 0 
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
.const [3] = String [40] 
.const [4] = Int -1601830656 
.const [5] = String [41] 
.const [6] = String [42] 
.const [7] = Int 1078071040 
.const [8] = String [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Class [54] 
.const [20] = Class [55] 
.const [21] = Field [56] [57] 
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
.const [33] = Method [80] [81] 
.const [34] = Field [82] [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = InterfaceMethod [86] [87] 
.const [37] = InterfaceMethod [88] [89] 
.const [38] = InterfaceMethod [90] [91] 
.const [39] = Class [92] 
.const [40] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls]' 
.const [41] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls] combiService is null --> NOP!' 
.const [42] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls] telState is null --> NOP!' 
.const [43] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls] maximung conference members, returning result 0x07' 
.const [44] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls invoking joinCalls)' 
.const [45] = Utf8 '[TelBAPMethodJoinCallsHandler#joinCalls] multy party not active, no join possible' 
.const [46] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler$1 
.const [47] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [48] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [51] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [52] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [53] = Utf8 de/audi/app/phone/core/calllist/ConferenceCall 
.const [54] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [55] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Class [96] 
.const [59] = NameAndType [97] [98] 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Class [102] 
.const [63] = NameAndType [103] [104] 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Class [114] 
.const [71] = NameAndType [115] [116] 
.const [72] = Class [117] 
.const [73] = NameAndType [118] [119] 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Class [126] 
.const [79] = NameAndType [127] [128] 
.const [80] = Class [129] 
.const [81] = NameAndType [130] [131] 
.const [82] = Class [132] 
.const [83] = NameAndType [133] [134] 
.const [84] = Class [135] 
.const [85] = NameAndType [136] [137] 
.const [86] = Class [138] 
.const [87] = NameAndType [139] [140] 
.const [88] = Class [141] 
.const [89] = NameAndType [142] [143] 
.const [90] = Class [144] 
.const [91] = NameAndType [145] [146] 
.const [92] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler$1 
.const [93] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [94] = Utf8 log 
.const [95] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;)Z 
.const [99] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [100] = Utf8 getTelephoneState 
.const [101] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [102] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [103] = Utf8 getCombiBapServicePhone 
.const [104] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [105] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [106] = Utf8 getConferenceCall 
.const [107] = Utf8 ()Lde/audi/app/phone/core/calllist/ConferenceCall; 
.const [108] = Utf8 de/audi/app/phone/core/calllist/ConferenceCall 
.const [109] = Utf8 getMembers 
.const [110] = Utf8 ()[Lde/audi/app/phone/core/calllist/SingleCall; 
.const [111] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [112] = Utf8 isMultipartyActive 
.const [113] = Utf8 ()Z 
.const [114] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [115] = Utf8 getApplication 
.const [116] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [117] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [118] = Utf8 enqueueResultNotification 
.const [119] = Utf8 (Ljava/lang/Runnable;)V 
.const [120] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [123] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [124] = Utf8 sendResultNotSuccessful 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [127] = Utf8 sendResult 
.const [128] = Utf8 (I)V 
.const [129] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler$1 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler;I)V 
.const [132] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [133] = Utf8 MAX_CONFERENCE_MEMBERS 
.const [134] = Utf8 I 
.const [135] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [136] = Utf8 getCallLeadingDevice 
.const [137] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [138] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [139] = Utf8 getCallState 
.const [140] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [141] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [142] = Utf8 getTelephoneDSIAccess 
.const [143] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [144] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [145] = Utf8 joinCallsToConference 
.const [146] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [147] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler 
.const [148] = Class [147] 
.const [149] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [150] = Class [149] 
.const [151] = Utf8 MAX_CONFERENCE_MEMBERS 
.const [152] = Utf8 I 
.const [153] = Utf8 Code 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [156] = Utf8 joinCalls 
.const [157] = Utf8 ()V 
.const [158] = Utf8 sendResultNotSuccessful 
.const [159] = Utf8 ()V 
.const [160] = Utf8 responseJoinCalls 
.const [161] = Utf8 (II)V 
.const [162] = Utf8 sendResult 
.const [163] = Utf8 (I)V 
.const [164] = Utf8 access$000 
.const [165] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler;)Lde/audi/atip/log/LogChannel; 
.const [166] = Utf8 access$100 
.const [167] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodJoinCallsHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
