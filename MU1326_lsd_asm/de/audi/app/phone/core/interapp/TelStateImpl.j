.version 50 0 
.class public super [295] 
.super [297] 
.implements [299] 
.field final [300] [301] 
.field final [302] [303] 

.method private static [305] : [306] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L34 
            L31 
            L28 
            default : L37 

L28:    ldc [2] 
L30:    areturn 
L31:    ldc [3] 
L33:    areturn 
L34:    ldc [4] 
L36:    areturn 
L37:    new [65] 
L40:    dup 
L41:    invokespecial [61] 
L44:    ldc [6] 
L46:    invokevirtual [36] 
L49:    iload_0 
L50:    invokevirtual [37] 
L53:    invokevirtual [38] 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private static [307] : [308] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L48 
            L39 
            L42 
            L45 
            L36 
            default : L51 

L36:    ldc [7] 
L38:    areturn 
L39:    ldc [8] 
L41:    areturn 
L42:    ldc [9] 
L44:    areturn 
L45:    ldc [10] 
L47:    areturn 
L48:    ldc [11] 
L50:    areturn 
L51:    new [65] 
L54:    dup 
L55:    invokespecial [61] 
L58:    ldc [12] 
L60:    invokevirtual [36] 
L63:    iload_0 
L64:    invokevirtual [37] 
L67:    invokevirtual [38] 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [62] 
L4:     aload_2 
L5:     ifnonnull L18 
L8:     new [66] 
L11:    dup 
L12:    ldc [14] 
L14:    invokespecial [63] 
L17:    athrow 
L18:    iload_1 
L19:    lookupswitch 
            65539 : L68 
            65544 : L76 
            65551 : L68 
            131080 : L76 
            196616 : L76 
            default : L84 

L68:    aload_0 
L69:    iconst_1 
L70:    putfield [67] 
L73:    goto L89 
L76:    aload_0 
L77:    iconst_2 
L78:    putfield [67] 
L81:    goto L89 
L84:    aload_0 
L85:    iconst_0 
L86:    putfield [67] 
L89:    aload_0 
L90:    aload_2 
L91:    putfield [68] 
L94:    return 
L95:    nop 
L96:    
    .end code 
.end method 

.method interface [311] : [312] 
    .attribute [304] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L41 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L39 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [41] 
L32:    ifne L39 
L35:    iconst_1 
L36:    goto L40 
L39:    iconst_0 
L40:    areturn 
L41:    iconst_0 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [315] : [316] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [41] 
L32:    areturn 
L33:    iconst_1 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [42] 
L32:    areturn 
L33:    iconst_0 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [319] : [320] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [43] 
L32:    areturn 
L33:    iconst_0 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [44] 
L32:    areturn 
L33:    iconst_0 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [45] 
L32:    areturn 
L33:    iconst_0 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnull L33 
L14:    aload_1 
L15:    invokeinterface [70] 0 
L20:    ifnull L33 
L23:    aload_1 
L24:    invokeinterface [70] 0 
L29:    invokevirtual [46] 
L32:    areturn 
L33:    iconst_0 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [304] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [69] 0 
L9:     astore_1 
L10:    aload_1 
L11:    invokeinterface [70] 0 
L16:    ifnull L50 
L19:    aload_1 
L20:    invokeinterface [70] 0 
L25:    invokevirtual [47] 
L28:    iconst_3 
L29:    if_icmpeq L46 
L32:    aload_1 
L33:    invokeinterface [70] 0 
L38:    invokevirtual [47] 
L41:    bipush 32 
L43:    if_icmpne L50 
L46:    iconst_1 
L47:    goto L51 
L50:    iconst_0 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [304] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [71] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [304] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [72] 0 
L9:     istore_1 
L10:    iload_1 
L11:    tableswitch 0 
            L40 
            L46 
            L42 
            L44 
            default : L48 

L40:    iconst_1 
L41:    areturn 
L42:    iconst_2 
L43:    areturn 
L44:    iconst_3 
L45:    areturn 
L46:    iconst_4 
L47:    areturn 
L48:    iconst_0 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [304] .code stack 2 locals 1 
L0:     new [73] 
L3:     dup 
L4:     invokespecial [64] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [16] 
L11:    invokevirtual [48] 
L14:    pop 
L15:    aload_1 
L16:    ldc [17] 
L18:    invokevirtual [48] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    invokevirtual [49] 
L27:    invokestatic [18] 
L30:    invokevirtual [48] 
L33:    pop 
L34:    aload_1 
L35:    ldc [19] 
L37:    invokevirtual [48] 
L40:    pop 
L41:    aload_1 
L42:    ldc [20] 
L44:    invokevirtual [48] 
L47:    pop 
L48:    aload_1 
L49:    aload_0 
L50:    invokevirtual [50] 
L53:    invokevirtual [51] 
L56:    pop 
L57:    aload_1 
L58:    ldc [19] 
L60:    invokevirtual [48] 
L63:    pop 
L64:    aload_1 
L65:    ldc [21] 
L67:    invokevirtual [48] 
L70:    pop 
L71:    aload_1 
L72:    aload_0 
L73:    invokevirtual [52] 
L76:    invokevirtual [51] 
L79:    pop 
L80:    aload_1 
L81:    ldc [19] 
L83:    invokevirtual [48] 
L86:    pop 
L87:    aload_1 
L88:    ldc [22] 
L90:    invokevirtual [48] 
L93:    pop 
L94:    aload_1 
L95:    aload_0 
L96:    invokevirtual [53] 
L99:    invokevirtual [51] 
L102:   pop 
L103:   aload_1 
L104:   ldc [19] 
L106:   invokevirtual [48] 
L109:   pop 
L110:   aload_1 
L111:   ldc [23] 
L113:   invokevirtual [48] 
L116:   pop 
L117:   aload_1 
L118:   aload_0 
L119:   invokevirtual [54] 
L122:   invokevirtual [51] 
L125:   pop 
L126:   aload_1 
L127:   ldc [19] 
L129:   invokevirtual [48] 
L132:   pop 
L133:   aload_1 
L134:   ldc [24] 
L136:   invokevirtual [48] 
L139:   pop 
L140:   aload_1 
L141:   aload_0 
L142:   invokevirtual [55] 
L145:   invokevirtual [51] 
L148:   pop 
L149:   aload_1 
L150:   ldc [19] 
L152:   invokevirtual [48] 
L155:   pop 
L156:   aload_1 
L157:   ldc [25] 
L159:   invokevirtual [48] 
L162:   pop 
L163:   aload_1 
L164:   aload_0 
L165:   invokevirtual [56] 
L168:   invokevirtual [51] 
L171:   pop 
L172:   aload_1 
L173:   ldc [19] 
L175:   invokevirtual [48] 
L178:   pop 
L179:   aload_1 
L180:   ldc [26] 
L182:   invokevirtual [48] 
L185:   pop 
L186:   aload_1 
L187:   aload_0 
L188:   invokevirtual [57] 
L191:   invokevirtual [51] 
L194:   pop 
L195:   aload_1 
L196:   ldc [19] 
L198:   invokevirtual [48] 
L201:   pop 
L202:   aload_1 
L203:   ldc [27] 
L205:   invokevirtual [48] 
L208:   pop 
L209:   aload_1 
L210:   aload_0 
L211:   invokevirtual [58] 
L214:   invokevirtual [51] 
L217:   pop 
L218:   aload_1 
L219:   ldc [19] 
L221:   invokevirtual [48] 
L224:   pop 
L225:   aload_1 
L226:   ldc [28] 
L228:   invokevirtual [48] 
L231:   pop 
L232:   aload_1 
L233:   aload_0 
L234:   invokevirtual [59] 
L237:   invokestatic [29] 
L240:   invokevirtual [48] 
L243:   pop 
L244:   aload_1 
L245:   ldc [30] 
L247:   invokevirtual [48] 
L250:   pop 
L251:   aload_1 
L252:   invokevirtual [60] 
L255:   areturn 
L256:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [74] 
.const [3] = String [75] 
.const [4] = String [76] 
.const [5] = Class [77] 
.const [6] = String [78] 
.const [7] = String [79] 
.const [8] = String [80] 
.const [9] = String [81] 
.const [10] = String [82] 
.const [11] = String [83] 
.const [12] = String [84] 
.const [13] = Class [85] 
.const [14] = String [86] 
.const [15] = Class [87] 
.const [16] = String [88] 
.const [17] = String [89] 
.const [18] = Method [90] [91] 
.const [19] = String [92] 
.const [20] = String [93] 
.const [21] = String [94] 
.const [22] = String [95] 
.const [23] = String [96] 
.const [24] = String [97] 
.const [25] = String [98] 
.const [26] = String [99] 
.const [27] = String [100] 
.const [28] = String [101] 
.const [29] = Method [102] [103] 
.const [30] = String [104] 
.const [31] = Class [105] 
.const [32] = Class [106] 
.const [33] = Class [107] 
.const [34] = Class [108] 
.const [35] = Class [109] 
.const [36] = Method [110] [111] 
.const [37] = Method [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Field [116] [117] 
.const [40] = Field [118] [119] 
.const [41] = Method [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Method [124] [125] 
.const [44] = Method [126] [127] 
.const [45] = Method [128] [129] 
.const [46] = Method [130] [131] 
.const [47] = Method [132] [133] 
.const [48] = Method [134] [135] 
.const [49] = Method [136] [137] 
.const [50] = Method [138] [139] 
.const [51] = Method [140] [141] 
.const [52] = Method [142] [143] 
.const [53] = Method [144] [145] 
.const [54] = Method [146] [147] 
.const [55] = Method [148] [149] 
.const [56] = Method [150] [151] 
.const [57] = Method [152] [153] 
.const [58] = Method [154] [155] 
.const [59] = Method [156] [157] 
.const [60] = Method [158] [159] 
.const [61] = Method [160] [161] 
.const [62] = Method [162] [163] 
.const [63] = Method [164] [165] 
.const [64] = Method [166] [167] 
.const [65] = Class [168] 
.const [66] = Class [169] 
.const [67] = Field [170] [171] 
.const [68] = Field [172] [173] 
.const [69] = InterfaceMethod [174] [175] 
.const [70] = InterfaceMethod [176] [177] 
.const [71] = InterfaceMethod [178] [179] 
.const [72] = InterfaceMethod [180] [181] 
.const [73] = Class [182] 
.const [74] = Utf8 ATTR_CALL_STATE 
.const [75] = Utf8 ATTR_CONNECTION_STATUS 
.const [76] = Utf8 ATTR_NO_CHANGE 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 'Unknown key ' 
.const [79] = Utf8 CONNECTION_TYPE_BTHS 
.const [80] = Utf8 CONNECTION_TYPE_INTERNAL_SIM 
.const [81] = Utf8 CONNECTION_TYPE_SAP 
.const [82] = Utf8 CONNECTION_TYPE_HFP 
.const [83] = Utf8 CONNECTION_TYPE_NONE 
.const [84] = Utf8 'Unknown connection type ' 
.const [85] = Utf8 java/lang/IllegalArgumentException 
.const [86] = Utf8 'TelStateImpl: State is null!' 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 TelStateImpl( 
.const [89] = Utf8 'key=' 
.const [90] = Class [183] 
.const [91] = NameAndType [184] [185] 
.const [92] = Utf8 ', ' 
.const [93] = Utf8 'callActive=' 
.const [94] = Utf8 'callStateIdle=' 
.const [95] = Utf8 'incomingCallPresent=' 
.const [96] = Utf8 'outgoingCallPreset=' 
.const [97] = Utf8 'activeCallPresent=' 
.const [98] = Utf8 'heldCallPresent=' 
.const [99] = Utf8 'multipartyActive=' 
.const [100] = Utf8 'phoneReady=' 
.const [101] = Utf8 'connectionType=' 
.const [102] = Class [186] 
.const [103] = NameAndType [187] [188] 
.const [104] = Utf8 ')' 
.const [105] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [108] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [109] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [110] = Class [189] 
.const [111] = NameAndType [190] [191] 
.const [112] = Class [192] 
.const [113] = NameAndType [193] [194] 
.const [114] = Class [195] 
.const [115] = NameAndType [196] [197] 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Class [210] 
.const [125] = NameAndType [211] [212] 
.const [126] = Class [213] 
.const [127] = NameAndType [214] [215] 
.const [128] = Class [216] 
.const [129] = NameAndType [217] [218] 
.const [130] = Class [219] 
.const [131] = NameAndType [220] [221] 
.const [132] = Class [222] 
.const [133] = NameAndType [223] [224] 
.const [134] = Class [225] 
.const [135] = NameAndType [226] [227] 
.const [136] = Class [228] 
.const [137] = NameAndType [229] [230] 
.const [138] = Class [231] 
.const [139] = NameAndType [232] [233] 
.const [140] = Class [234] 
.const [141] = NameAndType [235] [236] 
.const [142] = Class [237] 
.const [143] = NameAndType [238] [239] 
.const [144] = Class [240] 
.const [145] = NameAndType [241] [242] 
.const [146] = Class [243] 
.const [147] = NameAndType [244] [245] 
.const [148] = Class [246] 
.const [149] = NameAndType [247] [248] 
.const [150] = Class [249] 
.const [151] = NameAndType [250] [251] 
.const [152] = Class [252] 
.const [153] = NameAndType [253] [254] 
.const [154] = Class [255] 
.const [155] = NameAndType [256] [257] 
.const [156] = Class [258] 
.const [157] = NameAndType [259] [260] 
.const [158] = Class [261] 
.const [159] = NameAndType [262] [263] 
.const [160] = Class [264] 
.const [161] = NameAndType [265] [266] 
.const [162] = Class [267] 
.const [163] = NameAndType [268] [269] 
.const [164] = Class [270] 
.const [165] = NameAndType [271] [272] 
.const [166] = Class [273] 
.const [167] = NameAndType [274] [275] 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 java/lang/IllegalArgumentException 
.const [170] = Class [276] 
.const [171] = NameAndType [277] [278] 
.const [172] = Class [279] 
.const [173] = NameAndType [280] [281] 
.const [174] = Class [282] 
.const [175] = NameAndType [283] [284] 
.const [176] = Class [285] 
.const [177] = NameAndType [286] [287] 
.const [178] = Class [288] 
.const [179] = NameAndType [289] [290] 
.const [180] = Class [291] 
.const [181] = NameAndType [292] [293] 
.const [182] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [183] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [184] = Utf8 getKeyName 
.const [185] = Utf8 (I)Ljava/lang/String; 
.const [186] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [187] = Utf8 getConnectionTypeName 
.const [188] = Utf8 (I)Ljava/lang/String; 
.const [189] = Utf8 java/lang/StringBuffer 
.const [190] = Utf8 append 
.const [191] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [192] = Utf8 java/lang/StringBuffer 
.const [193] = Utf8 append 
.const [194] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [195] = Utf8 java/lang/StringBuffer 
.const [196] = Utf8 toString 
.const [197] = Utf8 ()Ljava/lang/String; 
.const [198] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [199] = Utf8 attr 
.const [200] = Utf8 I 
.const [201] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [202] = Utf8 telState 
.const [203] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [204] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [205] = Utf8 isIdle 
.const [206] = Utf8 ()Z 
.const [207] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [208] = Utf8 isHasIncomingCall 
.const [209] = Utf8 ()Z 
.const [210] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [211] = Utf8 isHasOutgoingCall 
.const [212] = Utf8 ()Z 
.const [213] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [214] = Utf8 isHasActiveCall 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [217] = Utf8 isHasOnHoldCall 
.const [218] = Utf8 ()Z 
.const [219] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [220] = Utf8 isMultipartyActive 
.const [221] = Utf8 ()Z 
.const [222] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [223] = Utf8 getMpCallState 
.const [224] = Utf8 ()I 
.const [225] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [226] = Utf8 append 
.const [227] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [228] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [229] = Utf8 getKey 
.const [230] = Utf8 ()I 
.const [231] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [232] = Utf8 getCallActive 
.const [233] = Utf8 ()Z 
.const [234] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [235] = Utf8 append 
.const [236] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [237] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [238] = Utf8 isCallStateIdle 
.const [239] = Utf8 ()Z 
.const [240] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [241] = Utf8 isIncomingCallPresent 
.const [242] = Utf8 ()Z 
.const [243] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [244] = Utf8 isOutgoingCallPresent 
.const [245] = Utf8 ()Z 
.const [246] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [247] = Utf8 isActiveCallPresent 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [250] = Utf8 isHeldCallPresent 
.const [251] = Utf8 ()Z 
.const [252] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [253] = Utf8 isMultipartyActive 
.const [254] = Utf8 ()Z 
.const [255] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [256] = Utf8 isPhoneReady 
.const [257] = Utf8 ()Z 
.const [258] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [259] = Utf8 getConnectionType 
.const [260] = Utf8 ()I 
.const [261] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [262] = Utf8 toString 
.const [263] = Utf8 ()Ljava/lang/String; 
.const [264] = Utf8 java/lang/StringBuffer 
.const [265] = Utf8 <init> 
.const [266] = Utf8 ()V 
.const [267] = Utf8 java/lang/Object 
.const [268] = Utf8 <init> 
.const [269] = Utf8 ()V 
.const [270] = Utf8 java/lang/IllegalArgumentException 
.const [271] = Utf8 <init> 
.const [272] = Utf8 (Ljava/lang/String;)V 
.const [273] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [274] = Utf8 <init> 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [277] = Utf8 attr 
.const [278] = Utf8 I 
.const [279] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [280] = Utf8 telState 
.const [281] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [282] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [283] = Utf8 getCallLeadingDevice 
.const [284] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [285] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [286] = Utf8 getCallState 
.const [287] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [288] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [289] = Utf8 isPhoneReady 
.const [290] = Utf8 ()Z 
.const [291] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [292] = Utf8 getTelMode 
.const [293] = Utf8 ()I 
.const [294] = Utf8 de/audi/app/phone/core/interapp/TelStateImpl 
.const [295] = Class [294] 
.const [296] = Utf8 java/lang/Object 
.const [297] = Class [296] 
.const [298] = Utf8 de/audi/atip/interapp/phone/ITelState 
.const [299] = Class [298] 
.const [300] = Utf8 telState 
.const [301] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [302] = Utf8 attr 
.const [303] = Utf8 I 
.const [304] = Utf8 Code 
.const [305] = Utf8 getKeyName 
.const [306] = Utf8 (I)Ljava/lang/String; 
.const [307] = Utf8 getConnectionTypeName 
.const [308] = Utf8 (I)Ljava/lang/String; 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [311] = Utf8 getKey 
.const [312] = Utf8 ()I 
.const [313] = Utf8 getCallActive 
.const [314] = Utf8 ()Z 
.const [315] = Utf8 isCallStateIdle 
.const [316] = Utf8 ()Z 
.const [317] = Utf8 isIncomingCallPresent 
.const [318] = Utf8 ()Z 
.const [319] = Utf8 isOutgoingCallPresent 
.const [320] = Utf8 ()Z 
.const [321] = Utf8 isActiveCallPresent 
.const [322] = Utf8 ()Z 
.const [323] = Utf8 isHeldCallPresent 
.const [324] = Utf8 ()Z 
.const [325] = Utf8 isMultipartyActive 
.const [326] = Utf8 ()Z 
.const [327] = Utf8 isCallStateDisconnecting 
.const [328] = Utf8 ()Z 
.const [329] = Utf8 isPhoneReady 
.const [330] = Utf8 ()Z 
.const [331] = Utf8 getConnectionType 
.const [332] = Utf8 ()I 
.const [333] = Utf8 toString 
.const [334] = Utf8 ()Ljava/lang/String; 
.end class 
