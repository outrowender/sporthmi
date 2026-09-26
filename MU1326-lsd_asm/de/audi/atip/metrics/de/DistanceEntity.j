.version 50 0 
.class public super [283] 
.super [285] 
.field public static final [286] [287] 
.field public static final [288] [289] 
.field public static final [290] [291] 
.field public static final [292] [293] 
.field public [294] [295] 
.field public [296] [297] 
.field public [298] [299] 
.field public [300] [301] 
.field public [302] [303] 
.field public [304] [305] 
.field protected final [306] [307] 
.field private [308] [309] 
.field private [310] [311] 
.field private [312] [313] 
.field private [314] [315] 

.method public static [317] : [318] 
    .attribute [316] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L15 
L4:     new [45] 
L7:     dup 
L8:     iload_0 
L9:     invokespecial [38] 
L12:    goto L23 
L15:    new [46] 
L18:    dup 
L19:    iload_0 
L20:    invokespecial [39] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method [319] : [320] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [47] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [48] 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield [49] 
L19:    aload_0 
L20:    iconst_m1 
L21:    putfield [50] 
L24:    aload_0 
L25:    aconst_null 
L26:    putfield [51] 
L29:    aload_0 
L30:    iconst_1 
L31:    putfield [52] 
L34:    aload_0 
L35:    iload_1 
L36:    putfield [53] 
L39:    return 
L40:    
    .end code 
.end method 

.method public final [321] : [322] 
    .attribute [316] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_m1 
L3:     iconst_m1 
L4:     iload_2 
L5:     invokespecial [41] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public final [323] : [324] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [47] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [49] 
L10:    aload_0 
L11:    iload_3 
L12:    putfield [48] 
L15:    aload_0 
L16:    iload 4 
L18:    putfield [50] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public final [325] : [326] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [54] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [55] 
L10:    aload_0 
L11:    iload_3 
L12:    putfield [56] 
L15:    aload_0 
L16:    iload 4 
L18:    putfield [57] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public final [327] : [328] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [52] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [329] : [330] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [50] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [331] : [332] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [51] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [333] : [334] 
    .attribute [316] .code stack 2 locals 2 
L0:     ldc [4] 
L2:     fstore_1 
L3:     aload_0 
L4:     getfield [21] 
L7:     ifeq L56 
L10:    fconst_0 
L11:    fstore_1 
L12:    aload_0 
L13:    getfield [16] 
L16:    iflt L25 
L19:    aload_0 
L20:    getfield [16] 
L23:    i2f 
L24:    fstore_1 
L25:    aload_0 
L26:    getfield [17] 
L29:    iflt L56 
L32:    aload_0 
L33:    getfield [17] 
L36:    i2f 
L37:    fstore_2 
L38:    fload_2 
L39:    fconst_1 
L40:    fcmpl 
L41:    iflt L52 
L44:    fload_2 
L45:    ldc [5] 
L47:    fdiv 
L48:    fstore_2 
L49:    goto L38 
L52:    fload_1 
L53:    fload_2 
L54:    fadd 
L55:    fstore_1 
L56:    fload_1 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L191 
L7:     aload_0 
L8:     getfield [16] 
L11:    ifgt L46 
L14:    aload_0 
L15:    getfield [16] 
L18:    ifne L38 
L21:    aload_0 
L22:    getfield [17] 
L25:    ifle L46 
L28:    aload_0 
L29:    getfield [17] 
L32:    bipush 25 
L34:    irem 
L35:    ifne L46 
L38:    aload_0 
L39:    getfield [22] 
L42:    iconst_2 
L43:    if_icmpne L55 
L46:    aload_1 
L47:    aload_0 
L48:    getfield [16] 
L51:    invokevirtual [27] 
L54:    pop 
L55:    aload_0 
L56:    getfield [17] 
L59:    iflt L149 
L62:    aload_0 
L63:    getfield [18] 
L66:    iconst_m1 
L67:    if_icmpeq L149 
L70:    aload_0 
L71:    getfield [17] 
L74:    bipush 25 
L76:    if_icmpne L90 
L79:    aload_1 
L80:    sipush 188 
L83:    invokevirtual [28] 
L86:    pop 
L87:    goto L149 
L90:    aload_0 
L91:    getfield [17] 
L94:    bipush 50 
L96:    if_icmpne L110 
L99:    aload_1 
L100:   sipush 189 
L103:   invokevirtual [28] 
L106:   pop 
L107:   goto L149 
L110:   aload_0 
L111:   getfield [17] 
L114:   bipush 75 
L116:   if_icmpne L130 
L119:   aload_1 
L120:   sipush 190 
L123:   invokevirtual [28] 
L126:   pop 
L127:   goto L149 
L130:   aload_1 
L131:   aload_0 
L132:   getfield [18] 
L135:   invokestatic [6] 
L138:   invokevirtual [29] 
L141:   aload_0 
L142:   getfield [17] 
L145:   invokevirtual [27] 
L148:   pop 
L149:   aload_0 
L150:   getfield [20] 
L153:   ifnull L168 
L156:   aload_1 
L157:   aload_0 
L158:   getfield [20] 
L161:   invokevirtual [29] 
L164:   pop 
L165:   goto L198 
L168:   aload_0 
L169:   getfield [19] 
L172:   iconst_m1 
L173:   if_icmpeq L198 
L176:   aload_1 
L177:   aload_0 
L178:   getfield [19] 
L181:   invokestatic [6] 
L184:   invokevirtual [29] 
L187:   pop 
L188:   goto L198 
L191:   aload_1 
L192:   ldc [7] 
L194:   invokevirtual [29] 
L197:   pop 
L198:   return 
L199:   nop 
L200:   
    .end code 
.end method 

.method public final [337] : [338] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L20 
L7:     aload_0 
L8:     aload_1 
L9:     invokevirtual [30] 
L12:    aload_0 
L13:    aload_2 
L14:    invokespecial [42] 
L17:    goto L27 
L20:    aload_1 
L21:    ldc [7] 
L23:    invokevirtual [31] 
L26:    pop 
L27:    return 
L28:    
    .end code 
.end method 

.method private [339] : [340] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L19 
L7:     aload_1 
L8:     aload_0 
L9:     getfield [20] 
L12:    invokevirtual [31] 
L15:    pop 
L16:    goto L39 
L19:    aload_0 
L20:    getfield [19] 
L23:    iconst_m1 
L24:    if_icmpeq L39 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [19] 
L32:    invokestatic [6] 
L35:    invokevirtual [31] 
L38:    pop 
L39:    return 
L40:    
    .end code 
.end method 

.method [341] : [342] 
    .attribute [316] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     bipush 8 
L6:     if_icmpne L17 
L9:     aload_0 
L10:    aload_1 
L11:    invokespecial [43] 
L14:    goto L179 
L17:    aload_0 
L18:    getfield [16] 
L21:    ifgt L56 
L24:    aload_0 
L25:    getfield [16] 
L28:    ifne L48 
L31:    aload_0 
L32:    getfield [17] 
L35:    ifle L56 
L38:    aload_0 
L39:    getfield [17] 
L42:    bipush 25 
L44:    irem 
L45:    ifne L56 
L48:    aload_0 
L49:    getfield [22] 
L52:    iconst_2 
L53:    if_icmpne L65 
L56:    aload_1 
L57:    aload_0 
L58:    getfield [16] 
L61:    invokevirtual [32] 
L64:    pop 
L65:    aload_0 
L66:    getfield [17] 
L69:    iflt L179 
L72:    aload_0 
L73:    getfield [18] 
L76:    iconst_m1 
L77:    if_icmpeq L179 
L80:    aload_0 
L81:    getfield [17] 
L84:    bipush 25 
L86:    if_icmpne L100 
L89:    aload_1 
L90:    sipush 188 
L93:    invokevirtual [33] 
L96:    pop 
L97:    goto L179 
L100:   aload_0 
L101:   getfield [17] 
L104:   bipush 33 
L106:   if_icmpne L120 
L109:   aload_1 
L110:   sipush 8531 
L113:   invokevirtual [33] 
L116:   pop 
L117:   goto L179 
L120:   aload_0 
L121:   getfield [17] 
L124:   bipush 50 
L126:   if_icmpne L140 
L129:   aload_1 
L130:   sipush 189 
L133:   invokevirtual [33] 
L136:   pop 
L137:   goto L179 
L140:   aload_0 
L141:   getfield [17] 
L144:   bipush 75 
L146:   if_icmpne L160 
L149:   aload_1 
L150:   sipush 190 
L153:   invokevirtual [33] 
L156:   pop 
L157:   goto L179 
L160:   aload_1 
L161:   aload_0 
L162:   getfield [18] 
L165:   invokestatic [6] 
L168:   invokevirtual [31] 
L171:   aload_0 
L172:   getfield [17] 
L175:   invokevirtual [32] 
L178:   pop 
L179:   return 
L180:   
    .end code 
.end method 

.method final [343] : [344] 
    .attribute [316] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifne L90 
L7:     aload_0 
L8:     getfield [17] 
L11:    ifne L90 
L14:    aload_0 
L15:    getfield [23] 
L18:    iconst_1 
L19:    if_icmpne L90 
L22:    iconst_0 
L23:    istore_2 
L24:    iload_2 
L25:    aload_0 
L26:    getfield [24] 
L29:    if_icmpge L45 
L32:    aload_1 
L33:    ldc [8] 
L35:    invokevirtual [31] 
L38:    pop 
L39:    iinc 2 1 
L42:    goto L24 
L45:    aload_0 
L46:    getfield [25] 
L49:    ifle L227 
L52:    aload_1 
L53:    aload_0 
L54:    getfield [18] 
L57:    invokestatic [6] 
L60:    invokevirtual [31] 
L63:    pop 
L64:    iconst_0 
L65:    istore_2 
L66:    iload_2 
L67:    aload_0 
L68:    getfield [25] 
L71:    if_icmpge L87 
L74:    aload_1 
L75:    ldc [8] 
L77:    invokevirtual [31] 
L80:    pop 
L81:    iinc 2 1 
L84:    goto L66 
L87:    goto L227 
L90:    aload_1 
L91:    aload_0 
L92:    getfield [16] 
L95:    invokevirtual [32] 
L98:    pop 
L99:    new [58] 
L102:   dup 
L103:   aload_0 
L104:   getfield [17] 
L107:   invokestatic [10] 
L110:   invokespecial [44] 
L113:   astore_2 
L114:   aload_0 
L115:   getfield [26] 
L118:   ifne L142 
L121:   aload_2 
L122:   invokevirtual [34] 
L125:   aload_0 
L126:   getfield [25] 
L129:   if_icmpge L195 
L132:   aload_2 
L133:   ldc [11] 
L135:   invokevirtual [29] 
L138:   pop 
L139:   goto L121 
L142:   aload_0 
L143:   getfield [26] 
L146:   iconst_1 
L147:   if_icmpne L186 
L150:   aload_2 
L151:   invokevirtual [34] 
L154:   ifle L195 
L157:   aload_2 
L158:   aload_2 
L159:   invokevirtual [34] 
L162:   iconst_1 
L163:   isub 
L164:   invokevirtual [35] 
L167:   bipush 48 
L169:   if_icmpne L195 
L172:   aload_2 
L173:   aload_2 
L174:   invokevirtual [34] 
L177:   iconst_1 
L178:   isub 
L179:   invokevirtual [36] 
L182:   pop 
L183:   goto L150 
L186:   aload_2 
L187:   aload_0 
L188:   getfield [17] 
L191:   invokevirtual [27] 
L194:   pop 
L195:   aload_0 
L196:   getfield [25] 
L199:   ifle L227 
L202:   aload_2 
L203:   invokevirtual [34] 
L206:   ifle L227 
L209:   aload_1 
L210:   aload_0 
L211:   getfield [18] 
L214:   invokestatic [6] 
L217:   invokevirtual [31] 
L220:   pop 
L221:   aload_1 
L222:   aload_2 
L223:   invokevirtual [37] 
L226:   pop 
L227:   return 
L228:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [59] 
.const [3] = Class [60] 
.const [4] = Int 32959 
.const [5] = Int 8257 
.const [6] = Method [61] [62] 
.const [7] = String [63] 
.const [8] = String [64] 
.const [9] = Class [65] 
.const [10] = Method [66] [67] 
.const [11] = String [68] 
.const [12] = Class [69] 
.const [13] = Class [70] 
.const [14] = Class [71] 
.const [15] = Class [72] 
.const [16] = Field [73] [74] 
.const [17] = Field [75] [76] 
.const [18] = Field [77] [78] 
.const [19] = Field [79] [80] 
.const [20] = Field [81] [82] 
.const [21] = Field [83] [84] 
.const [22] = Field [85] [86] 
.const [23] = Field [87] [88] 
.const [24] = Field [89] [90] 
.const [25] = Field [91] [92] 
.const [26] = Field [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Method [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Method [129] [130] 
.const [45] = Class [131] 
.const [46] = Class [132] 
.const [47] = Field [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Field [137] [138] 
.const [50] = Field [139] [140] 
.const [51] = Field [141] [142] 
.const [52] = Field [143] [144] 
.const [53] = Field [145] [146] 
.const [54] = Field [147] [148] 
.const [55] = Field [149] [150] 
.const [56] = Field [151] [152] 
.const [57] = Field [153] [154] 
.const [58] = Class [155] 
.const [59] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [60] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [61] = Class [156] 
.const [62] = NameAndType [157] [158] 
.const [63] = Utf8 '---' 
.const [64] = Utf8 '-' 
.const [65] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [66] = Class [159] 
.const [67] = NameAndType [160] [161] 
.const [68] = Utf8 '0' 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 de/audi/atip/metrics/Distance 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 java/lang/String 
.const [73] = Class [162] 
.const [74] = NameAndType [163] [164] 
.const [75] = Class [165] 
.const [76] = NameAndType [166] [167] 
.const [77] = Class [168] 
.const [78] = NameAndType [169] [170] 
.const [79] = Class [171] 
.const [80] = NameAndType [172] [173] 
.const [81] = Class [174] 
.const [82] = NameAndType [175] [176] 
.const [83] = Class [177] 
.const [84] = NameAndType [178] [179] 
.const [85] = Class [180] 
.const [86] = NameAndType [181] [182] 
.const [87] = Class [183] 
.const [88] = NameAndType [184] [185] 
.const [89] = Class [186] 
.const [90] = NameAndType [187] [188] 
.const [91] = Class [189] 
.const [92] = NameAndType [190] [191] 
.const [93] = Class [192] 
.const [94] = NameAndType [193] [194] 
.const [95] = Class [195] 
.const [96] = NameAndType [196] [197] 
.const [97] = Class [198] 
.const [98] = NameAndType [199] [200] 
.const [99] = Class [201] 
.const [100] = NameAndType [202] [203] 
.const [101] = Class [204] 
.const [102] = NameAndType [205] [206] 
.const [103] = Class [207] 
.const [104] = NameAndType [208] [209] 
.const [105] = Class [210] 
.const [106] = NameAndType [211] [212] 
.const [107] = Class [213] 
.const [108] = NameAndType [214] [215] 
.const [109] = Class [216] 
.const [110] = NameAndType [217] [218] 
.const [111] = Class [219] 
.const [112] = NameAndType [220] [221] 
.const [113] = Class [222] 
.const [114] = NameAndType [223] [224] 
.const [115] = Class [225] 
.const [116] = NameAndType [226] [227] 
.const [117] = Class [228] 
.const [118] = NameAndType [229] [230] 
.const [119] = Class [231] 
.const [120] = NameAndType [232] [233] 
.const [121] = Class [234] 
.const [122] = NameAndType [235] [236] 
.const [123] = Class [237] 
.const [124] = NameAndType [238] [239] 
.const [125] = Class [240] 
.const [126] = NameAndType [241] [242] 
.const [127] = Class [243] 
.const [128] = NameAndType [244] [245] 
.const [129] = Class [246] 
.const [130] = NameAndType [247] [248] 
.const [131] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [132] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [133] = Class [249] 
.const [134] = NameAndType [250] [251] 
.const [135] = Class [252] 
.const [136] = NameAndType [253] [254] 
.const [137] = Class [255] 
.const [138] = NameAndType [256] [257] 
.const [139] = Class [258] 
.const [140] = NameAndType [259] [260] 
.const [141] = Class [261] 
.const [142] = NameAndType [262] [263] 
.const [143] = Class [264] 
.const [144] = NameAndType [265] [266] 
.const [145] = Class [267] 
.const [146] = NameAndType [268] [269] 
.const [147] = Class [270] 
.const [148] = NameAndType [271] [272] 
.const [149] = Class [273] 
.const [150] = NameAndType [274] [275] 
.const [151] = Class [276] 
.const [152] = NameAndType [277] [278] 
.const [153] = Class [279] 
.const [154] = NameAndType [280] [281] 
.const [155] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [156] = Utf8 de/audi/atip/metrics/Distance 
.const [157] = Utf8 getText 
.const [158] = Utf8 (I)Ljava/lang/String; 
.const [159] = Utf8 java/lang/String 
.const [160] = Utf8 valueOf 
.const [161] = Utf8 (I)Ljava/lang/String; 
.const [162] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [163] = Utf8 distanceMajor 
.const [164] = Utf8 I 
.const [165] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [166] = Utf8 distanceMinor 
.const [167] = Utf8 I 
.const [168] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [169] = Utf8 distanceSepTextConstant 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [172] = Utf8 distanceUnitTextConstant 
.const [173] = Utf8 I 
.const [174] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [175] = Utf8 distanceUnitText 
.const [176] = Utf8 Ljava/lang/String; 
.const [177] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [178] = Utf8 isValid 
.const [179] = Utf8 Z 
.const [180] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [181] = Utf8 mode 
.const [182] = Utf8 I 
.const [183] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [184] = Utf8 zeroValueFormat 
.const [185] = Utf8 I 
.const [186] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [187] = Utf8 numberOfMajorPlacesMax 
.const [188] = Utf8 I 
.const [189] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [190] = Utf8 numberOfDecimalPlaces 
.const [191] = Utf8 I 
.const [192] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [193] = Utf8 numberOfDecimalPlacesFormat 
.const [194] = Utf8 I 
.const [195] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [196] = Utf8 append 
.const [197] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [198] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [199] = Utf8 append 
.const [200] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [201] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [202] = Utf8 append 
.const [203] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [204] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [205] = Utf8 formatValue 
.const [206] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [207] = Utf8 java/lang/StringBuffer 
.const [208] = Utf8 append 
.const [209] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [210] = Utf8 java/lang/StringBuffer 
.const [211] = Utf8 append 
.const [212] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [213] = Utf8 java/lang/StringBuffer 
.const [214] = Utf8 append 
.const [215] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [216] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [217] = Utf8 length 
.const [218] = Utf8 ()I 
.const [219] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [220] = Utf8 charAt 
.const [221] = Utf8 (I)C 
.const [222] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [223] = Utf8 deleteCharAt 
.const [224] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [225] = Utf8 java/lang/StringBuffer 
.const [226] = Utf8 append 
.const [227] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [228] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (I)V 
.const [234] = Utf8 java/lang/Object 
.const [235] = Utf8 <init> 
.const [236] = Utf8 ()V 
.const [237] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [238] = Utf8 setValues 
.const [239] = Utf8 (IIII)V 
.const [240] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [241] = Utf8 formatUnit 
.const [242] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [243] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [244] = Utf8 getStringValueModeDecimal 
.const [245] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [246] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Ljava/lang/String;)V 
.const [249] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [250] = Utf8 distanceMajor 
.const [251] = Utf8 I 
.const [252] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [253] = Utf8 distanceMinor 
.const [254] = Utf8 I 
.const [255] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [256] = Utf8 distanceSepTextConstant 
.const [257] = Utf8 I 
.const [258] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [259] = Utf8 distanceUnitTextConstant 
.const [260] = Utf8 I 
.const [261] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [262] = Utf8 distanceUnitText 
.const [263] = Utf8 Ljava/lang/String; 
.const [264] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [265] = Utf8 isValid 
.const [266] = Utf8 Z 
.const [267] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [268] = Utf8 mode 
.const [269] = Utf8 I 
.const [270] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [271] = Utf8 zeroValueFormat 
.const [272] = Utf8 I 
.const [273] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [274] = Utf8 numberOfMajorPlacesMax 
.const [275] = Utf8 I 
.const [276] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [277] = Utf8 numberOfDecimalPlaces 
.const [278] = Utf8 I 
.const [279] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [280] = Utf8 numberOfDecimalPlacesFormat 
.const [281] = Utf8 I 
.const [282] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [283] = Class [282] 
.const [284] = Utf8 java/lang/Object 
.const [285] = Class [284] 
.const [286] = Utf8 ONE_QUARTER 
.const [287] = Utf8 C 
.const [288] = Utf8 ONE_THIRD 
.const [289] = Utf8 C 
.const [290] = Utf8 ONE_HALF 
.const [291] = Utf8 C 
.const [292] = Utf8 THREE_QUARTERS 
.const [293] = Utf8 C 
.const [294] = Utf8 distanceMajor 
.const [295] = Utf8 I 
.const [296] = Utf8 distanceMinor 
.const [297] = Utf8 I 
.const [298] = Utf8 distanceSepTextConstant 
.const [299] = Utf8 I 
.const [300] = Utf8 distanceUnitTextConstant 
.const [301] = Utf8 I 
.const [302] = Utf8 distanceUnitText 
.const [303] = Utf8 Ljava/lang/String; 
.const [304] = Utf8 isValid 
.const [305] = Utf8 Z 
.const [306] = Utf8 mode 
.const [307] = Utf8 I 
.const [308] = Utf8 zeroValueFormat 
.const [309] = Utf8 I 
.const [310] = Utf8 numberOfMajorPlacesMax 
.const [311] = Utf8 I 
.const [312] = Utf8 numberOfDecimalPlaces 
.const [313] = Utf8 I 
.const [314] = Utf8 numberOfDecimalPlacesFormat 
.const [315] = Utf8 I 
.const [316] = Utf8 Code 
.const [317] = Utf8 create 
.const [318] = Utf8 (IZ)Lde/audi/atip/metrics/de/DistanceEntity; 
.const [319] = Utf8 <init> 
.const [320] = Utf8 (I)V 
.const [321] = Utf8 setValues 
.const [322] = Utf8 (II)V 
.const [323] = Utf8 setValues 
.const [324] = Utf8 (IIII)V 
.const [325] = Utf8 setValuesForDecimalFormat 
.const [326] = Utf8 (IIII)V 
.const [327] = Utf8 setValid 
.const [328] = Utf8 (Z)V 
.const [329] = Utf8 setUnitTextConstant 
.const [330] = Utf8 (I)V 
.const [331] = Utf8 setDistanceUnitText 
.const [332] = Utf8 (Ljava/lang/String;)V 
.const [333] = Utf8 toFloat 
.const [334] = Utf8 ()F 
.const [335] = Utf8 toBuffer 
.const [336] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [337] = Utf8 getStringValueAndUnit 
.const [338] = Utf8 (Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V 
.const [339] = Utf8 formatUnit 
.const [340] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [341] = Utf8 formatValue 
.const [342] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [343] = Utf8 getStringValueModeDecimal 
.const [344] = Utf8 (Ljava/lang/StringBuffer;)V 
.end class 
