.version 50 0 
.class super [212] 
.super [214] 
.field private static final [215] [216] 
.field private static final [217] [218] 
.field private static final [219] [220] 
.field private static final [221] [222] 

.method private static [224] : [225] 
    .attribute [223] .code stack 1 locals 0 
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
L45:    invokeinterface [45] 0 
L50:    ifeq L58 
L53:    bipush 12 
L55:    goto L59 
L58:    iconst_1 
L59:    areturn 
L60:    
    .end code 
.end method 

.method annotation [226] : [227] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [41] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [228] : [229] 
    .attribute [223] .code stack 13 locals 3 
L0:     aload_3 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [24] 
L8:     sipush 10000 
L11:    ldc [2] 
L13:    invokevirtual [25] 
L16:    pop 
L17:    return 
L18:    aload_0 
L19:    getfield [24] 
L22:    ldc [3] 
L24:    ldc [4] 
L26:    aload_3 
L27:    invokevirtual [26] 
L30:    aload_3 
L31:    invokevirtual [27] 
L34:    invokevirtual [28] 
L37:    aload_0 
L38:    invokevirtual [29] 
L41:    astore 4 
L43:    aload_0 
L44:    invokevirtual [30] 
L47:    astore 5 
L49:    aload 5 
L51:    ifnonnull L67 
L54:    aload_0 
L55:    getfield [24] 
L58:    ldc [5] 
L60:    ldc [6] 
L62:    invokevirtual [25] 
L65:    pop 
L66:    return 
L67:    aload 4 
L69:    ifnonnull L89 
L72:    aload_0 
L73:    getfield [24] 
L76:    ldc [5] 
L78:    ldc [7] 
L80:    invokevirtual [25] 
L83:    pop 
L84:    aload_0 
L85:    invokespecial [42] 
L88:    return 
L89:    aload 4 
L91:    invokeinterface [46] 0 
L96:    astore 6 
L98:    aload 6 
L100:   ifnull L120 
L103:   aload 6 
L105:   invokeinterface [47] 0 
L110:   ifeq L120 
L113:   aload_0 
L114:   invokespecial [42] 
L117:   goto L216 
L120:   aload 4 
L122:   invokeinterface [48] 0 
L127:   invokevirtual [31] 
L130:   ifeq L155 
L133:   aload_0 
L134:   getfield [24] 
L137:   ldc [8] 
L139:   ldc [9] 
L141:   invokevirtual [25] 
L144:   pop 
L145:   aload_0 
L146:   sipush 144 
L149:   invokespecial [43] 
L152:   goto L216 
L155:   aload_0 
L156:   getfield [24] 
L159:   ldc [8] 
L161:   ldc [10] 
L163:   ldc [11] 
L165:   invokevirtual [32] 
L168:   pop 
L169:   aload_0 
L170:   invokevirtual [33] 
L173:   invokeinterface [49] 0 
L178:   aload_3 
L179:   invokevirtual [26] 
L182:   aload_3 
L183:   invokevirtual [34] 
L186:   aload_3 
L187:   invokevirtual [27] 
L190:   aload_3 
L191:   invokevirtual [35] 
L194:   i2s 
L195:   iconst_0 
L196:   aload_3 
L197:   invokevirtual [36] 
L200:   aload_3 
L201:   invokevirtual [37] 
L204:   aload_3 
L205:   invokevirtual [38] 
L208:   iconst_1 
L209:   iconst_1 
L210:   aload_0 
L211:   invokeinterface [50] 0 
L216:   return 
L217:   nop 
L218:   nop 
L219:   nop 
L220:   
    .end code 
.end method 

.method private [230] : [231] 
    .attribute [223] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [43] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [223] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [12] 
L8:     aload_3 
L9:     iload_1 
L10:    i2l 
L11:    invokevirtual [39] 
L14:    pop 
L15:    aload_0 
L16:    invokevirtual [29] 
L19:    iload_1 
L20:    invokestatic [13] 
L23:    istore 5 
L25:    aload_0 
L26:    iload 5 
L28:    invokespecial [43] 
L31:    return 
L32:    
    .end code 
.end method 

.method private [234] : [235] 
    .attribute [223] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [51] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [44] 
L10:    invokevirtual [40] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [236] : [237] 
    .attribute [223] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [238] : [239] 
    .attribute [223] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [52] 
.const [3] = Int -2137614336 
.const [4] = String [53] 
.const [5] = Int -1601830656 
.const [6] = String [54] 
.const [7] = String [55] 
.const [8] = Int 1078071040 
.const [9] = String [56] 
.const [10] = String [57] 
.const [11] = String [58] 
.const [12] = String [59] 
.const [13] = Method [60] [61] 
.const [14] = Class [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Field [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Method [104] [105] 
.const [41] = Method [106] [107] 
.const [42] = Method [108] [109] 
.const [43] = Method [110] [111] 
.const [44] = Method [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = InterfaceMethod [116] [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = InterfaceMethod [120] [121] 
.const [49] = InterfaceMethod [122] [123] 
.const [50] = InterfaceMethod [124] [125] 
.const [51] = Class [126] 
.const [52] = Utf8 'TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry adbEntry is null' 
.const [53] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] telNumber=%1, name=%2' 
.const [54] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] combiService is null --> NOP!' 
.const [55] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] telState is null --> NOP!' 
.const [56] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] cannot dial because outgoing call already present!' 
.const [57] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] dialing %1' 
.const [58] = Utf8 '' 
.const [59] = Utf8 '[TelBAPMethodDialNumberFromAdbEntryHandler#responseDialNumber] result=%2, telSuppServResult=%1' 
.const [60] = Class [127] 
.const [61] = NameAndType [128] [129] 
.const [62] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler$1 
.const [63] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [64] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [65] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [68] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [69] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [70] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [71] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Class [154] 
.const [89] = NameAndType [155] [156] 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Class [160] 
.const [93] = NameAndType [161] [162] 
.const [94] = Class [163] 
.const [95] = NameAndType [164] [165] 
.const [96] = Class [166] 
.const [97] = NameAndType [167] [168] 
.const [98] = Class [169] 
.const [99] = NameAndType [170] [171] 
.const [100] = Class [172] 
.const [101] = NameAndType [173] [174] 
.const [102] = Class [175] 
.const [103] = NameAndType [176] [177] 
.const [104] = Class [178] 
.const [105] = NameAndType [179] [180] 
.const [106] = Class [181] 
.const [107] = NameAndType [182] [183] 
.const [108] = Class [184] 
.const [109] = NameAndType [185] [186] 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Class [190] 
.const [113] = NameAndType [191] [192] 
.const [114] = Class [193] 
.const [115] = NameAndType [194] [195] 
.const [116] = Class [196] 
.const [117] = NameAndType [197] [198] 
.const [118] = Class [199] 
.const [119] = NameAndType [200] [201] 
.const [120] = Class [202] 
.const [121] = NameAndType [203] [204] 
.const [122] = Class [205] 
.const [123] = NameAndType [206] [207] 
.const [124] = Class [208] 
.const [125] = NameAndType [209] [210] 
.const [126] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler$1 
.const [127] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [128] = Utf8 getDialNumberResult 
.const [129] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;I)I 
.const [130] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [131] = Utf8 log 
.const [132] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;)Z 
.const [136] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [137] = Utf8 getClNumber 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [140] = Utf8 getClName 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [145] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [146] = Utf8 getTelephoneState 
.const [147] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [148] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [149] = Utf8 getCombiBapServicePhone 
.const [150] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [151] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [152] = Utf8 isHasOutgoingCall 
.const [153] = Utf8 ()Z 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [157] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [158] = Utf8 getApplication 
.const [159] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [160] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [161] = Utf8 getAdbEntryID 
.const [162] = Utf8 ()J 
.const [163] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [164] = Utf8 getAdbNumberType 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [167] = Utf8 getAdbPictureID 
.const [168] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [169] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [170] = Utf8 getAdbPhoneDataIndex 
.const [171] = Utf8 ()I 
.const [172] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [173] = Utf8 getAdbPhoneDataCount 
.const [174] = Utf8 ()I 
.const [175] = Utf8 de/audi/atip/log/LogChannel 
.const [176] = Utf8 log 
.const [177] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [178] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [179] = Utf8 enqueueResultNotification 
.const [180] = Utf8 (Ljava/lang/Runnable;)V 
.const [181] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [184] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [185] = Utf8 sendResultNotSuccessful 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [188] = Utf8 sendResult 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler$1 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler;I)V 
.const [193] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [194] = Utf8 isAutomaticRedialActive 
.const [195] = Utf8 ()Z 
.const [196] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [197] = Utf8 getConnectedGatewayState 
.const [198] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [199] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [200] = Utf8 isCustomerCallNotAllowed 
.const [201] = Utf8 ()Z 
.const [202] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [203] = Utf8 getCallState 
.const [204] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [205] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [206] = Utf8 getTelephoneDSIAccess 
.const [207] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [208] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [209] = Utf8 dialNumberFromDBEntry 
.const [210] = Utf8 (Ljava/lang/String;JLjava/lang/String;SSLorg/dsi/ifc/global/ResourceLocator;IIIZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [211] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler 
.const [212] = Class [211] 
.const [213] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [214] = Class [213] 
.const [215] = Utf8 DIAL_NUMBER_RESULT_SUCCESSFUL 
.const [216] = Utf8 I 
.const [217] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL 
.const [218] = Utf8 I 
.const [219] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK 
.const [220] = Utf8 I 
.const [221] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE 
.const [222] = Utf8 I 
.const [223] = Utf8 Code 
.const [224] = Utf8 getDialNumberResult 
.const [225] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;I)I 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [228] = Utf8 dialNumberFromAdbEntry 
.const [229] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lde/audi/atip/interapp/phone/TelAdbEntryStruct;)V 
.const [230] = Utf8 sendResultNotSuccessful 
.const [231] = Utf8 ()V 
.const [232] = Utf8 responseDialNumber 
.const [233] = Utf8 (IILorg/dsi/ifc/telephoneng/SuppServiceResponseStruct;I)V 
.const [234] = Utf8 sendResult 
.const [235] = Utf8 (I)V 
.const [236] = Utf8 access$000 
.const [237] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler;)Lde/audi/atip/log/LogChannel; 
.const [238] = Utf8 access$100 
.const [239] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodDialNumberFromAdbEntryHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
