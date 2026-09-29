.version 50 0 
.class public super [310] 
.super [312] 
.implements [314] 
.field private static final [315] [316] 
.field private final [317] [318] 
.field private final [319] [320] 
.field private final [321] [322] 
.field private final [323] [324] 
.field private [325] [326] 
.field private [327] [328] 
.field private [329] [330] 

.method public [332] : [333] 
    .attribute [331] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     new [59] 
L8:     dup 
L9:     invokespecial [53] 
L12:    putfield [60] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [61] 
L20:    aload_0 
L21:    new [62] 
L24:    dup 
L25:    iconst_0 
L26:    invokespecial [54] 
L29:    putfield [63] 
L32:    aload_0 
L33:    new [62] 
L36:    dup 
L37:    iconst_0 
L38:    invokespecial [54] 
L41:    putfield [64] 
L44:    aload_0 
L45:    aload_1 
L46:    putfield [65] 
L49:    aload_0 
L50:    new [66] 
L53:    dup 
L54:    invokespecial [55] 
L57:    putfield [67] 
L60:    aload_0 
L61:    new [66] 
L64:    dup 
L65:    invokespecial [55] 
L68:    putfield [68] 
L71:    return 
L72:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [331] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [41] 
L7:     ifeq L45 
L10:    aload_0 
L11:    getfield [38] 
L14:    ldc [5] 
L16:    ldc [6] 
L18:    ldc [7] 
L20:    iload_1 
L21:    ifeq L29 
L24:    ldc [8] 
L26:    goto L31 
L29:    ldc [9] 
L31:    iload_2 
L32:    ifeq L40 
L35:    ldc [10] 
L37:    goto L42 
L40:    ldc [9] 
L42:    invokevirtual [42] 
L45:    aload_0 
L46:    getfield [34] 
L49:    dup 
L50:    astore_3 
L51:    monitorenter 
        .catch [0] from L52 to L231 using L234 
L52:    aconst_null 
L53:    astore 4 
L55:    aconst_null 
L56:    astore 5 
L58:    iload_1 
L59:    ifne L80 
L62:    aload_0 
L63:    getfield [40] 
L66:    aload_0 
L67:    getfield [36] 
L70:    invokeinterface [69] 0 
L75:    checkcast [11] 
L78:    astore 4 
L80:    iload_2 
L81:    ifne L102 
L84:    aload_0 
L85:    getfield [40] 
L88:    aload_0 
L89:    getfield [37] 
L92:    invokeinterface [69] 0 
L97:    checkcast [11] 
L100:   astore 5 
L102:   aload_0 
L103:   getfield [39] 
L106:   invokeinterface [70] 0 
L111:   aload_0 
L112:   getfield [40] 
L115:   invokeinterface [70] 0 
L120:   aload 4 
L122:   ifnonnull L140 
L125:   aload_0 
L126:   new [62] 
L129:   dup 
L130:   iconst_0 
L131:   invokespecial [54] 
L134:   putfield [63] 
L137:   goto L172 
L140:   aload_0 
L141:   getfield [39] 
L144:   aload 4 
L146:   aload_0 
L147:   getfield [36] 
L150:   invokeinterface [71] 0 
L155:   pop 
L156:   aload_0 
L157:   getfield [40] 
L160:   aload_0 
L161:   getfield [36] 
L164:   aload 4 
L166:   invokeinterface [71] 0 
L171:   pop 
L172:   aload 5 
L174:   ifnonnull L192 
L177:   aload_0 
L178:   new [62] 
L181:   dup 
L182:   iconst_0 
L183:   invokespecial [54] 
L186:   putfield [64] 
L189:   goto L224 
L192:   aload_0 
L193:   getfield [39] 
L196:   aload 5 
L198:   aload_0 
L199:   getfield [37] 
L202:   invokeinterface [71] 0 
L207:   pop 
L208:   aload_0 
L209:   getfield [40] 
L212:   aload_0 
L213:   getfield [37] 
L216:   aload 5 
L218:   invokeinterface [71] 0 
L223:   pop 
L224:   aload_0 
L225:   iconst_0 
L226:   putfield [61] 
L229:   aload_3 
L230:   monitorexit 
L231:   goto L241 
        .catch [0] from L234 to L238 using L234 
L234:   astore 6 
L236:   aload_3 
L237:   monitorexit 
L238:   aload 6 
L240:   athrow 
L241:   return 
L242:   nop 
L243:   nop 
L244:   
    .end code 
.end method 

.method public [336] : [337] 
    .attribute [331] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L32 using L33 
L7:     aload_0 
L8:     new [62] 
L11:    dup 
L12:    aload_0 
L13:    aload_1 
L14:    invokevirtual [43] 
L17:    invokespecial [54] 
L20:    putfield [63] 
L23:    aload_0 
L24:    getfield [36] 
L27:    invokevirtual [44] 
L30:    aload_2 
L31:    monitorexit 
L32:    areturn 
        .catch [0] from L33 to L36 using L33 
L33:    astore_3 
L34:    aload_2 
L35:    monitorexit 
L36:    aload_3 
L37:    athrow 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [338] : [339] 
    .attribute [331] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L32 using L33 
L7:     aload_0 
L8:     new [62] 
L11:    dup 
L12:    aload_0 
L13:    aload_1 
L14:    invokevirtual [43] 
L17:    invokespecial [54] 
L20:    putfield [64] 
L23:    aload_0 
L24:    getfield [37] 
L27:    invokevirtual [44] 
L30:    aload_2 
L31:    monitorexit 
L32:    areturn 
        .catch [0] from L33 to L36 using L33 
L33:    astore_3 
L34:    aload_2 
L35:    monitorexit 
L36:    aload_3 
L37:    athrow 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [331] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [34] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L84 using L179 
L7:     aload_0 
L8:     getfield [39] 
L11:    aload_1 
L12:    invokeinterface [69] 0 
L17:    astore_2 
L18:    aload_2 
L19:    ifnonnull L85 
L22:    new [62] 
L25:    dup 
L26:    aload_0 
L27:    invokespecial [56] 
L30:    invokespecial [54] 
L33:    astore 4 
L35:    aload_0 
L36:    getfield [39] 
L39:    aload_1 
L40:    aload 4 
L42:    invokeinterface [71] 0 
L47:    pop 
L48:    aload_0 
L49:    getfield [40] 
L52:    aload 4 
L54:    aload_1 
L55:    invokeinterface [71] 0 
L60:    pop 
L61:    aload_0 
L62:    getfield [38] 
L65:    ldc [12] 
L67:    ldc [13] 
L69:    ldc [7] 
L71:    aload_1 
L72:    aload 4 
L74:    invokevirtual [42] 
L77:    aload 4 
L79:    invokevirtual [44] 
L82:    aload_3 
L83:    monitorexit 
L84:    areturn 
        .catch [0] from L85 to L176 using L179 
L85:    aload_0 
L86:    getfield [40] 
L89:    aload_2 
L90:    invokeinterface [69] 0 
L95:    checkcast [11] 
L98:    astore 4 
L100:   aload 4 
L102:   ifnull L117 
L105:   aload 4 
L107:   invokevirtual [45] 
L110:   aload_1 
L111:   invokevirtual [45] 
L114:   if_icmpeq L159 
L117:   aload_0 
L118:   getfield [38] 
L121:   ldc [12] 
L123:   ldc [14] 
L125:   ldc [7] 
L127:   aload_1 
L128:   aload_2 
L129:   invokevirtual [42] 
L132:   aload_0 
L133:   getfield [40] 
L136:   aload_2 
L137:   aload_1 
L138:   invokeinterface [71] 0 
L143:   pop 
L144:   aload_0 
L145:   getfield [39] 
L148:   aload_1 
L149:   aload_2 
L150:   invokeinterface [71] 0 
L155:   pop 
L156:   goto L174 
L159:   aload_0 
L160:   getfield [38] 
L163:   ldc [12] 
L165:   ldc [15] 
L167:   ldc [7] 
L169:   aload_1 
L170:   aload_2 
L171:   invokevirtual [42] 
L174:   aload_3 
L175:   monitorexit 
L176:   goto L186 
        .catch [0] from L179 to L183 using L179 
L179:   astore 5 
L181:   aload_3 
L182:   monitorexit 
L183:   aload 5 
L185:   athrow 
L186:   aload_2 
L187:   checkcast [3] 
L190:   invokevirtual [44] 
L193:   areturn 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method public [342] : [343] 
    .attribute [331] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L29 using L30 
L7:     aload_0 
L8:     getfield [40] 
L11:    new [62] 
L14:    dup 
L15:    iload_1 
L16:    invokespecial [54] 
L19:    invokeinterface [69] 0 
L24:    checkcast [11] 
L27:    aload_2 
L28:    monitorexit 
L29:    areturn 
        .catch [0] from L30 to L33 using L30 
L30:    astore_3 
L31:    aload_2 
L32:    monitorexit 
L33:    aload_3 
L34:    athrow 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [344] : [345] 
    .attribute [331] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [35] 
L4:     istore_1 
L5:     iconst_0 
L6:     istore_2 
L7:     iinc 1 1 
L10:    iload_1 
L11:    ldc [16] 
L13:    if_icmple L83 
L16:    aload_0 
L17:    getfield [38] 
L20:    ldc [5] 
L22:    ldc [17] 
L24:    ldc [7] 
L26:    invokevirtual [46] 
L29:    pop 
L30:    iconst_1 
L31:    istore_1 
L32:    iinc 2 1 
L35:    iload_2 
L36:    iconst_2 
L37:    if_icmpne L83 
L40:    aload_0 
L41:    getfield [38] 
L44:    sipush 10000 
L47:    ldc [18] 
L49:    ldc [7] 
L51:    invokevirtual [46] 
L54:    pop 
L55:    aload_0 
L56:    getfield [39] 
L59:    invokeinterface [70] 0 
L64:    aload_0 
L65:    getfield [40] 
L68:    invokeinterface [70] 0 
L73:    aload_0 
L74:    iconst_1 
L75:    putfield [61] 
L78:    aload_0 
L79:    getfield [35] 
L82:    areturn 
L83:    aload_0 
L84:    getfield [40] 
L87:    iload_1 
L88:    invokestatic [19] 
L91:    invokeinterface [69] 0 
L96:    ifnonnull L7 
L99:    aload_0 
L100:   iload_1 
L101:   putfield [61] 
L104:   aload_0 
L105:   getfield [35] 
L108:   areturn 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [346] : [347] 
    .attribute [331] .code stack 1 locals 0 
L0:     ldc [20] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [348] : [349] 
    .attribute [331] .code stack 2 locals 6 
L0:     new [72] 
L3:     dup 
L4:     invokespecial [57] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [22] 
L11:    invokevirtual [47] 
L14:    pop 
L15:    aload_0 
L16:    getfield [34] 
L19:    dup 
L20:    astore_2 
L21:    monitorenter 
        .catch [0] from L22 to L143 using L146 
L22:    aload_0 
L23:    getfield [39] 
L26:    invokeinterface [73] 0 
L31:    invokeinterface [74] 0 
L36:    astore_3 
L37:    aload_3 
L38:    invokeinterface [75] 0 
L43:    ifeq L141 
L46:    aload_3 
L47:    invokeinterface [76] 0 
L52:    checkcast [11] 
L55:    astore 4 
L57:    aload_0 
L58:    getfield [39] 
L61:    aload 4 
L63:    invokeinterface [69] 0 
L68:    checkcast [3] 
L71:    astore 5 
L73:    aload_1 
L74:    aload 5 
L76:    invokevirtual [48] 
L79:    ldc [23] 
L81:    invokevirtual [47] 
L84:    aload 4 
L86:    invokevirtual [48] 
L89:    pop 
L90:    aload 5 
L92:    aload_0 
L93:    getfield [37] 
L96:    invokevirtual [49] 
L99:    ifeq L112 
L102:   aload_1 
L103:   ldc [24] 
L105:   invokevirtual [47] 
L108:   pop 
L109:   goto L131 
L112:   aload 5 
L114:   aload_0 
L115:   getfield [36] 
L118:   invokevirtual [49] 
L121:   ifeq L131 
L124:   aload_1 
L125:   ldc [25] 
L127:   invokevirtual [47] 
L130:   pop 
L131:   aload_1 
L132:   ldc [26] 
L134:   invokevirtual [47] 
L137:   pop 
L138:   goto L37 
L141:   aload_2 
L142:   monitorexit 
L143:   goto L153 
        .catch [0] from L146 to L150 using L146 
L146:   astore 6 
L148:   aload_2 
L149:   monitorexit 
L150:   aload 6 
L152:   athrow 
L153:   aload_1 
L154:   invokevirtual [50] 
L157:   areturn 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method public [350] : [351] 
    .attribute [331] .code stack 3 locals 1 
L0:     new [72] 
L3:     dup 
L4:     bipush 20 
L6:     invokespecial [58] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [7] 
L13:    invokevirtual [47] 
L16:    ldc [27] 
L18:    invokevirtual [47] 
L21:    aload_0 
L22:    invokevirtual [51] 
L25:    invokevirtual [52] 
L28:    pop 
L29:    aload_1 
L30:    invokevirtual [50] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [77] 
.const [3] = Class [78] 
.const [4] = Class [79] 
.const [5] = Int 1078071040 
.const [6] = String [80] 
.const [7] = String [81] 
.const [8] = String [82] 
.const [9] = String [83] 
.const [10] = String [84] 
.const [11] = Class [85] 
.const [12] = Int -2137614336 
.const [13] = String [86] 
.const [14] = String [87] 
.const [15] = String [88] 
.const [16] = Int -65536 
.const [17] = String [89] 
.const [18] = String [90] 
.const [19] = Method [91] [92] 
.const [20] = String [93] 
.const [21] = Class [94] 
.const [22] = String [95] 
.const [23] = String [96] 
.const [24] = String [97] 
.const [25] = String [98] 
.const [26] = String [99] 
.const [27] = String [100] 
.const [28] = Class [101] 
.const [29] = Class [102] 
.const [30] = Class [103] 
.const [31] = Class [104] 
.const [32] = Class [105] 
.const [33] = Class [106] 
.const [34] = Field [107] [108] 
.const [35] = Field [109] [110] 
.const [36] = Field [111] [112] 
.const [37] = Field [113] [114] 
.const [38] = Field [115] [116] 
.const [39] = Field [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Method [145] [146] 
.const [54] = Method [147] [148] 
.const [55] = Method [149] [150] 
.const [56] = Method [151] [152] 
.const [57] = Method [153] [154] 
.const [58] = Method [155] [156] 
.const [59] = Class [157] 
.const [60] = Field [158] [159] 
.const [61] = Field [160] [161] 
.const [62] = Class [162] 
.const [63] = Field [163] [164] 
.const [64] = Field [165] [166] 
.const [65] = Field [167] [168] 
.const [66] = Class [169] 
.const [67] = Field [170] [171] 
.const [68] = Field [172] [173] 
.const [69] = InterfaceMethod [174] [175] 
.const [70] = InterfaceMethod [176] [177] 
.const [71] = InterfaceMethod [178] [179] 
.const [72] = Class [180] 
.const [73] = InterfaceMethod [181] [182] 
.const [74] = InterfaceMethod [183] [184] 
.const [75] = InterfaceMethod [185] [186] 
.const [76] = InterfaceMethod [187] [188] 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 java/lang/Integer 
.const [79] = Utf8 java/util/HashMap 
.const [80] = Utf8 '[%1.reset] Reset (%2 %3)' 
.const [81] = Utf8 CombiBAPIdMapper 
.const [82] = Utf8 PLAYINGTRACK 
.const [83] = Utf8 '' 
.const [84] = Utf8 FOLDER 
.const [85] = Utf8 de/audi/app/media/combi/bap/CombiBAPMediaEntry 
.const [86] = Utf8 "[%1.getCombiID] '%2' -> '%3' (new)" 
.const [87] = Utf8 "[%1.getCombiID] '%2' -> '%3' (update flags)" 
.const [88] = Utf8 "[%1.getCombiID] '%2' -> '%3'" 
.const [89] = Utf8 '[%1.getNextCombiID] Next combiID out of range.' 
.const [90] = Utf8 '[%1.getNextCombiID] No free combi ID found. Reset IDs.' 
.const [91] = Class [189] 
.const [92] = NameAndType [190] [191] 
.const [93] = Utf8 'Combi.BAP.idMapper' 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 'COMBI ID\t <-> \tENTRY\n' 
.const [96] = Utf8 '\t <-> \t' 
.const [97] = Utf8 ' (BF)' 
.const [98] = Utf8 ' (PT)' 
.const [99] = Utf8 '\n' 
.const [100] = Utf8 '@' 
.const [101] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 java/util/Map 
.const [104] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [105] = Utf8 java/util/Set 
.const [106] = Utf8 java/util/Iterator 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Class [195] 
.const [110] = NameAndType [196] [197] 
.const [111] = Class [198] 
.const [112] = NameAndType [199] [200] 
.const [113] = Class [201] 
.const [114] = NameAndType [202] [203] 
.const [115] = Class [204] 
.const [116] = NameAndType [205] [206] 
.const [117] = Class [207] 
.const [118] = NameAndType [208] [209] 
.const [119] = Class [210] 
.const [120] = NameAndType [211] [212] 
.const [121] = Class [213] 
.const [122] = NameAndType [214] [215] 
.const [123] = Class [216] 
.const [124] = NameAndType [217] [218] 
.const [125] = Class [219] 
.const [126] = NameAndType [220] [221] 
.const [127] = Class [222] 
.const [128] = NameAndType [223] [224] 
.const [129] = Class [225] 
.const [130] = NameAndType [226] [227] 
.const [131] = Class [228] 
.const [132] = NameAndType [229] [230] 
.const [133] = Class [231] 
.const [134] = NameAndType [232] [233] 
.const [135] = Class [234] 
.const [136] = NameAndType [235] [236] 
.const [137] = Class [237] 
.const [138] = NameAndType [238] [239] 
.const [139] = Class [240] 
.const [140] = NameAndType [241] [242] 
.const [141] = Class [243] 
.const [142] = NameAndType [244] [245] 
.const [143] = Class [246] 
.const [144] = NameAndType [247] [248] 
.const [145] = Class [249] 
.const [146] = NameAndType [250] [251] 
.const [147] = Class [252] 
.const [148] = NameAndType [253] [254] 
.const [149] = Class [255] 
.const [150] = NameAndType [256] [257] 
.const [151] = Class [258] 
.const [152] = NameAndType [259] [260] 
.const [153] = Class [261] 
.const [154] = NameAndType [262] [263] 
.const [155] = Class [264] 
.const [156] = NameAndType [265] [266] 
.const [157] = Utf8 java/lang/Object 
.const [158] = Class [267] 
.const [159] = NameAndType [268] [269] 
.const [160] = Class [270] 
.const [161] = NameAndType [271] [272] 
.const [162] = Utf8 java/lang/Integer 
.const [163] = Class [273] 
.const [164] = NameAndType [274] [275] 
.const [165] = Class [276] 
.const [166] = NameAndType [277] [278] 
.const [167] = Class [279] 
.const [168] = NameAndType [280] [281] 
.const [169] = Utf8 java/util/HashMap 
.const [170] = Class [282] 
.const [171] = NameAndType [283] [284] 
.const [172] = Class [285] 
.const [173] = NameAndType [286] [287] 
.const [174] = Class [288] 
.const [175] = NameAndType [289] [290] 
.const [176] = Class [291] 
.const [177] = NameAndType [292] [293] 
.const [178] = Class [294] 
.const [179] = NameAndType [295] [296] 
.const [180] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [181] = Class [297] 
.const [182] = NameAndType [298] [299] 
.const [183] = Class [300] 
.const [184] = NameAndType [301] [302] 
.const [185] = Class [303] 
.const [186] = NameAndType [304] [305] 
.const [187] = Class [306] 
.const [188] = NameAndType [307] [308] 
.const [189] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [190] = Utf8 valueOf 
.const [191] = Utf8 (I)Ljava/lang/Integer; 
.const [192] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [193] = Utf8 mapMutex 
.const [194] = Utf8 Ljava/lang/Object; 
.const [195] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [196] = Utf8 nextCombiID 
.const [197] = Utf8 I 
.const [198] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [199] = Utf8 combiIDPlayingTrack 
.const [200] = Utf8 Ljava/lang/Integer; 
.const [201] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [202] = Utf8 combiIDBrowseFolder 
.const [203] = Utf8 Ljava/lang/Integer; 
.const [204] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [205] = Utf8 logger 
.const [206] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [207] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [208] = Utf8 idMap 
.const [209] = Utf8 Ljava/util/Map; 
.const [210] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [211] = Utf8 inverseIdMap 
.const [212] = Utf8 Ljava/util/Map; 
.const [213] = Utf8 de/audi/atip/log/LogChannel 
.const [214] = Utf8 isInfo 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [219] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [220] = Utf8 getCombiID 
.const [221] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPMediaEntry;)I 
.const [222] = Utf8 java/lang/Integer 
.const [223] = Utf8 intValue 
.const [224] = Utf8 ()I 
.const [225] = Utf8 de/audi/app/media/combi/bap/CombiBAPMediaEntry 
.const [226] = Utf8 getEntryFlags 
.const [227] = Utf8 ()I 
.const [228] = Utf8 de/audi/atip/log/LogChannel 
.const [229] = Utf8 log 
.const [230] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [231] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [232] = Utf8 append 
.const [233] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [234] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [235] = Utf8 append 
.const [236] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [237] = Utf8 java/lang/Integer 
.const [238] = Utf8 equals 
.const [239] = Utf8 (Ljava/lang/Object;)Z 
.const [240] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 java/lang/Object 
.const [244] = Utf8 hashCode 
.const [245] = Utf8 ()I 
.const [246] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [247] = Utf8 append 
.const [248] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [249] = Utf8 java/lang/Object 
.const [250] = Utf8 <init> 
.const [251] = Utf8 ()V 
.const [252] = Utf8 java/lang/Integer 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (I)V 
.const [255] = Utf8 java/util/HashMap 
.const [256] = Utf8 <init> 
.const [257] = Utf8 ()V 
.const [258] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [259] = Utf8 getNextCombiID 
.const [260] = Utf8 ()I 
.const [261] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [262] = Utf8 <init> 
.const [263] = Utf8 ()V 
.const [264] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (I)V 
.const [267] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [268] = Utf8 mapMutex 
.const [269] = Utf8 Ljava/lang/Object; 
.const [270] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [271] = Utf8 nextCombiID 
.const [272] = Utf8 I 
.const [273] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [274] = Utf8 combiIDPlayingTrack 
.const [275] = Utf8 Ljava/lang/Integer; 
.const [276] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [277] = Utf8 combiIDBrowseFolder 
.const [278] = Utf8 Ljava/lang/Integer; 
.const [279] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [280] = Utf8 logger 
.const [281] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [282] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [283] = Utf8 idMap 
.const [284] = Utf8 Ljava/util/Map; 
.const [285] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [286] = Utf8 inverseIdMap 
.const [287] = Utf8 Ljava/util/Map; 
.const [288] = Utf8 java/util/Map 
.const [289] = Utf8 get 
.const [290] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [291] = Utf8 java/util/Map 
.const [292] = Utf8 clear 
.const [293] = Utf8 ()V 
.const [294] = Utf8 java/util/Map 
.const [295] = Utf8 put 
.const [296] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [297] = Utf8 java/util/Map 
.const [298] = Utf8 keySet 
.const [299] = Utf8 ()Ljava/util/Set; 
.const [300] = Utf8 java/util/Set 
.const [301] = Utf8 iterator 
.const [302] = Utf8 ()Ljava/util/Iterator; 
.const [303] = Utf8 java/util/Iterator 
.const [304] = Utf8 hasNext 
.const [305] = Utf8 ()Z 
.const [306] = Utf8 java/util/Iterator 
.const [307] = Utf8 next 
.const [308] = Utf8 ()Ljava/lang/Object; 
.const [309] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [310] = Class [309] 
.const [311] = Utf8 java/lang/Object 
.const [312] = Class [311] 
.const [313] = Utf8 de/audi/app/media/diagnosis/IDiagnosisDataProvider 
.const [314] = Class [313] 
.const [315] = Utf8 LOGCLASS 
.const [316] = Utf8 Ljava/lang/String; 
.const [317] = Utf8 logger 
.const [318] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [319] = Utf8 idMap 
.const [320] = Utf8 Ljava/util/Map; 
.const [321] = Utf8 inverseIdMap 
.const [322] = Utf8 Ljava/util/Map; 
.const [323] = Utf8 mapMutex 
.const [324] = Utf8 Ljava/lang/Object; 
.const [325] = Utf8 nextCombiID 
.const [326] = Utf8 I 
.const [327] = Utf8 combiIDPlayingTrack 
.const [328] = Utf8 Ljava/lang/Integer; 
.const [329] = Utf8 combiIDBrowseFolder 
.const [330] = Utf8 Ljava/lang/Integer; 
.const [331] = Utf8 Code 
.const [332] = Utf8 <init> 
.const [333] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [334] = Utf8 reset 
.const [335] = Utf8 (ZZ)V 
.const [336] = Utf8 getCombiIDForPlayingTrack 
.const [337] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPMediaEntry;)I 
.const [338] = Utf8 getCombiIDForBrowseFolder 
.const [339] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPMediaEntry;)I 
.const [340] = Utf8 getCombiID 
.const [341] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPMediaEntry;)I 
.const [342] = Utf8 getEntry 
.const [343] = Utf8 (I)Lde/audi/app/media/combi/bap/CombiBAPMediaEntry; 
.const [344] = Utf8 getNextCombiID 
.const [345] = Utf8 ()I 
.const [346] = Utf8 getDiagKey 
.const [347] = Utf8 ()Ljava/lang/String; 
.const [348] = Utf8 getDiagValue 
.const [349] = Utf8 ()Ljava/lang/String; 
.const [350] = Utf8 toString 
.const [351] = Utf8 ()Ljava/lang/String; 
.end class 
