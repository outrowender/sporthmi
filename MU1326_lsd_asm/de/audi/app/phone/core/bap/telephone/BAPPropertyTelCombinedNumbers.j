.version 50 0 
.class public super [253] 
.super [255] 

.method public static [257] : [258] 
    .attribute [256] .code stack 14 locals 6 
L0:     aload_0 
L1:     arraylength 
L2:     anewarray [2] 
L5:     astore_3 
L6:     iconst_0 
L7:     istore 4 
L9:     iconst_0 
L10:    istore 5 
L12:    iload 5 
L14:    aload_0 
L15:    arraylength 
L16:    if_icmpge L155 
L19:    aload_0 
L20:    iload 5 
L22:    aaload 
L23:    astore 6 
L25:    new [47] 
L28:    dup 
L29:    aload 6 
L31:    invokevirtual [23] 
L34:    aload 6 
L36:    invokevirtual [24] 
L39:    aload 6 
L41:    invokevirtual [25] 
L44:    aload 6 
L46:    invokevirtual [26] 
L49:    aload 6 
L51:    invokevirtual [27] 
L54:    aload 6 
L56:    invokevirtual [28] 
L59:    aload 6 
L61:    invokevirtual [29] 
L64:    invokespecial [43] 
L67:    astore 7 
L69:    new [46] 
L72:    dup 
L73:    iload 4 
L75:    iinc 4 1 
L78:    aload 6 
L80:    aload_1 
L81:    aload_2 
L82:    invokestatic [4] 
L85:    aload 6 
L87:    invokevirtual [23] 
L90:    aload 6 
L92:    invokevirtual [29] 
L95:    invokestatic [5] 
L98:    aload 6 
L100:   invokevirtual [30] 
L103:   invokestatic [6] 
L106:   aload 6 
L108:   invokevirtual [31] 
L111:   aload 6 
L113:   invokevirtual [32] 
L116:   aload 6 
L118:   invokevirtual [33] 
L121:   aload 6 
L123:   invokevirtual [34] 
L126:   aload 6 
L128:   invokevirtual [35] 
L131:   aload 6 
L133:   invokevirtual [36] 
L136:   aload 7 
L138:   invokespecial [44] 
L141:   astore 8 
L143:   aload_3 
L144:   iload 5 
L146:   aload 8 
L148:   aastore 
L149:   iinc 5 1 
L152:   goto L12 
L155:   aload_3 
L156:   areturn 
L157:   nop 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method private static [259] : [260] 
    .attribute [256] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     astore_3 
L5:     aload_2 
L6:     aload_3 
L7:     invokeinterface [48] 0 
L12:    ifeq L23 
L15:    aload_1 
L16:    iconst_0 
L17:    invokeinterface [49] 0 
L22:    areturn 
L23:    aload_2 
L24:    aload_3 
L25:    invokeinterface [50] 0 
L30:    ifeq L41 
L33:    aload_1 
L34:    iconst_2 
L35:    invokeinterface [49] 0 
L40:    areturn 
L41:    aload_2 
L42:    aload_3 
L43:    invokeinterface [51] 0 
L48:    ifeq L59 
L51:    aload_1 
L52:    iconst_4 
L53:    invokeinterface [49] 0 
L58:    areturn 
L59:    aload_2 
L60:    aload_3 
L61:    invokeinterface [52] 0 
L66:    ifeq L77 
L69:    aload_1 
L70:    iconst_3 
L71:    invokeinterface [49] 0 
L76:    areturn 
L77:    aload_0 
L78:    invokevirtual [24] 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private static [261] : [262] 
    .attribute [256] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L32 
            L30 
            default : L34 

L28:    iconst_3 
L29:    areturn 
L30:    iconst_1 
L31:    areturn 
L32:    iconst_2 
L33:    areturn 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public annotation [263] : [264] 
    .attribute [256] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [45] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [265] : [266] 
    .attribute [256] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [7] 
L3:     if_icmpne L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method protected [267] : [268] 
    .attribute [256] .code stack 4 locals 4 
L0:     aload_0 
L1:     invokevirtual [37] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L75 
L9:     aload_0 
L10:    invokevirtual [37] 
L13:    invokeinterface [53] 0 
L18:    astore_2 
L19:    aload_2 
L20:    aload_0 
L21:    invokevirtual [38] 
L24:    invokeinterface [54] 0 
L29:    aload_0 
L30:    invokevirtual [37] 
L33:    invokestatic [8] 
L36:    astore_3 
L37:    aload_0 
L38:    invokevirtual [39] 
L41:    astore 4 
L43:    aload 4 
L45:    ifnull L72 
L48:    aload_0 
L49:    getfield [40] 
L52:    ldc [9] 
L54:    ldc [10] 
L56:    aload_3 
L57:    invokestatic [11] 
L60:    invokevirtual [41] 
L63:    pop 
L64:    aload 4 
L66:    aload_3 
L67:    invokeinterface [55] 0 
L72:    goto L88 
L75:    aload_0 
L76:    getfield [40] 
L79:    sipush 10000 
L82:    ldc [12] 
L84:    invokevirtual [42] 
L87:    pop 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Class [57] 
.const [4] = Method [58] [59] 
.const [5] = Method [60] [61] 
.const [6] = Method [62] [63] 
.const [7] = Int 671088896 
.const [8] = Method [64] [65] 
.const [9] = Int 1078071040 
.const [10] = String [66] 
.const [11] = Method [67] [68] 
.const [12] = String [69] 
.const [13] = Class [70] 
.const [14] = Class [71] 
.const [15] = Class [72] 
.const [16] = Class [73] 
.const [17] = Class [74] 
.const [18] = Class [75] 
.const [19] = Class [76] 
.const [20] = Class [77] 
.const [21] = Class [78] 
.const [22] = Class [79] 
.const [23] = Method [80] [81] 
.const [24] = Method [82] [83] 
.const [25] = Method [84] [85] 
.const [26] = Method [86] [87] 
.const [27] = Method [88] [89] 
.const [28] = Method [90] [91] 
.const [29] = Method [92] [93] 
.const [30] = Method [94] [95] 
.const [31] = Method [96] [97] 
.const [32] = Method [98] [99] 
.const [33] = Method [100] [101] 
.const [34] = Method [102] [103] 
.const [35] = Method [104] [105] 
.const [36] = Method [106] [107] 
.const [37] = Method [108] [109] 
.const [38] = Method [110] [111] 
.const [39] = Method [112] [113] 
.const [40] = Field [114] [115] 
.const [41] = Method [116] [117] 
.const [42] = Method [118] [119] 
.const [43] = Method [120] [121] 
.const [44] = Method [122] [123] 
.const [45] = Method [124] [125] 
.const [46] = Class [126] 
.const [47] = Class [127] 
.const [48] = InterfaceMethod [128] [129] 
.const [49] = InterfaceMethod [130] [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = InterfaceMethod [136] [137] 
.const [53] = InterfaceMethod [138] [139] 
.const [54] = InterfaceMethod [140] [141] 
.const [55] = InterfaceMethod [142] [143] 
.const [56] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry 
.const [57] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [58] = Class [144] 
.const [59] = NameAndType [145] [146] 
.const [60] = Class [147] 
.const [61] = NameAndType [148] [149] 
.const [62] = Class [150] 
.const [63] = NameAndType [151] [152] 
.const [64] = Class [153] 
.const [65] = NameAndType [154] [155] 
.const [66] = Utf8 '[BAPPropertyTelCombinedNumbers#update] %1' 
.const [67] = Class [156] 
.const [68] = NameAndType [157] [158] 
.const [69] = Utf8 'BAPPropertyTelCombinedNumbers#updateAsync state is null' 
.const [70] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [71] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [72] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [73] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBUtils 
.const [74] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [75] = Utf8 de/audi/app/phone/core/ITelTextFactory 
.const [76] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [77] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [80] = Class [159] 
.const [81] = NameAndType [160] [161] 
.const [82] = Class [162] 
.const [83] = NameAndType [163] [164] 
.const [84] = Class [165] 
.const [85] = NameAndType [166] [167] 
.const [86] = Class [168] 
.const [87] = NameAndType [169] [170] 
.const [88] = Class [171] 
.const [89] = NameAndType [172] [173] 
.const [90] = Class [174] 
.const [91] = NameAndType [175] [176] 
.const [92] = Class [177] 
.const [93] = NameAndType [178] [179] 
.const [94] = Class [180] 
.const [95] = NameAndType [181] [182] 
.const [96] = Class [183] 
.const [97] = NameAndType [184] [185] 
.const [98] = Class [186] 
.const [99] = NameAndType [187] [188] 
.const [100] = Class [189] 
.const [101] = NameAndType [190] [191] 
.const [102] = Class [192] 
.const [103] = NameAndType [193] [194] 
.const [104] = Class [195] 
.const [105] = NameAndType [196] [197] 
.const [106] = Class [198] 
.const [107] = NameAndType [199] [200] 
.const [108] = Class [201] 
.const [109] = NameAndType [202] [203] 
.const [110] = Class [204] 
.const [111] = NameAndType [205] [206] 
.const [112] = Class [207] 
.const [113] = NameAndType [208] [209] 
.const [114] = Class [210] 
.const [115] = NameAndType [211] [212] 
.const [116] = Class [213] 
.const [117] = NameAndType [214] [215] 
.const [118] = Class [216] 
.const [119] = NameAndType [217] [218] 
.const [120] = Class [219] 
.const [121] = NameAndType [220] [221] 
.const [122] = Class [222] 
.const [123] = NameAndType [223] [224] 
.const [124] = Class [225] 
.const [125] = NameAndType [226] [227] 
.const [126] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry 
.const [127] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [128] = Class [228] 
.const [129] = NameAndType [229] [230] 
.const [130] = Class [231] 
.const [131] = NameAndType [232] [233] 
.const [132] = Class [234] 
.const [133] = NameAndType [235] [236] 
.const [134] = Class [237] 
.const [135] = NameAndType [238] [239] 
.const [136] = Class [240] 
.const [137] = NameAndType [241] [242] 
.const [138] = Class [243] 
.const [139] = NameAndType [244] [245] 
.const [140] = Class [246] 
.const [141] = NameAndType [247] [248] 
.const [142] = Class [249] 
.const [143] = NameAndType [250] [251] 
.const [144] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [145] = Utf8 getName 
.const [146] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;Lde/audi/app/phone/core/ITelTextFactory;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Ljava/lang/String; 
.const [147] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBUtils 
.const [148] = Utf8 getCombiPhoneType 
.const [149] = Utf8 (I)I 
.const [150] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [151] = Utf8 getCallMode 
.const [152] = Utf8 (I)I 
.const [153] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [154] = Utf8 getBAPCallStackEntries 
.const [155] = Utf8 ([Lorg/dsi/ifc/telephoneng/CallStackEntry;Lde/audi/app/phone/core/ITelTextFactory;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry; 
.const [156] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [157] = Utf8 objectArray2StringNewLines 
.const [158] = Utf8 ([Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [159] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [160] = Utf8 getClNumber 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [163] = Utf8 getClName 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [166] = Utf8 getAdbPictureID 
.const [167] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [168] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [169] = Utf8 getAdbEntryID 
.const [170] = Utf8 ()J 
.const [171] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [172] = Utf8 getAdbPhoneDataIndex 
.const [173] = Utf8 ()I 
.const [174] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [175] = Utf8 getAdbPhoneDataCount 
.const [176] = Utf8 ()I 
.const [177] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [178] = Utf8 getAdbNumberType 
.const [179] = Utf8 ()I 
.const [180] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [181] = Utf8 getClEntryType 
.const [182] = Utf8 ()I 
.const [183] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [184] = Utf8 getClDay 
.const [185] = Utf8 ()S 
.const [186] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [187] = Utf8 getClMonth 
.const [188] = Utf8 ()S 
.const [189] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [190] = Utf8 getClYear 
.const [191] = Utf8 ()S 
.const [192] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [193] = Utf8 getClHour 
.const [194] = Utf8 ()S 
.const [195] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [196] = Utf8 getClMinute 
.const [197] = Utf8 ()S 
.const [198] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [199] = Utf8 getClSecond 
.const [200] = Utf8 ()S 
.const [201] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [202] = Utf8 getTelephoneState 
.const [203] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [204] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [205] = Utf8 getApplication 
.const [206] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [207] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [208] = Utf8 getCombiService 
.const [209] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [210] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [211] = Utf8 log 
.const [212] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [213] = Utf8 de/audi/atip/log/LogChannel 
.const [214] = Utf8 log 
.const [215] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;)Z 
.const [219] = Utf8 de/audi/atip/interapp/phone/TelAdbEntryStruct 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lorg/dsi/ifc/global/ResourceLocator;JIII)V 
.const [222] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (ILjava/lang/String;Ljava/lang/String;IISSSSSSLde/audi/atip/interapp/phone/TelAdbEntryStruct;)V 
.const [225] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [228] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [229] = Utf8 isMailboxNumber 
.const [230] = Utf8 (Ljava/lang/String;)Z 
.const [231] = Utf8 de/audi/app/phone/core/ITelTextFactory 
.const [232] = Utf8 getText 
.const [233] = Utf8 (I)Ljava/lang/String; 
.const [234] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [235] = Utf8 isInfoNumber 
.const [236] = Utf8 (Ljava/lang/String;)Z 
.const [237] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [238] = Utf8 isEmergencyNumber 
.const [239] = Utf8 (Ljava/lang/String;)Z 
.const [240] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [241] = Utf8 isBreakdownNumber 
.const [242] = Utf8 (Ljava/lang/String;)Z 
.const [243] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [244] = Utf8 getCombinedCallStackEntries 
.const [245] = Utf8 ()[Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.const [246] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [247] = Utf8 getTextFactory 
.const [248] = Utf8 ()Lde/audi/app/phone/core/ITelTextFactory; 
.const [249] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [250] = Utf8 updateCombinedNumbers 
.const [251] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry;)V 
.const [252] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelCombinedNumbers 
.const [253] = Class [252] 
.const [254] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [255] = Class [254] 
.const [256] = Utf8 Code 
.const [257] = Utf8 getBAPCallStackEntries 
.const [258] = Utf8 ([Lorg/dsi/ifc/telephoneng/CallStackEntry;Lde/audi/app/phone/core/ITelTextFactory;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallStackEntry; 
.const [259] = Utf8 getName 
.const [260] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;Lde/audi/app/phone/core/ITelTextFactory;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Ljava/lang/String; 
.const [261] = Utf8 getCallMode 
.const [262] = Utf8 (I)I 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [265] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [266] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [267] = Utf8 updateAsync 
.const [268] = Utf8 ()V 
.end class 
