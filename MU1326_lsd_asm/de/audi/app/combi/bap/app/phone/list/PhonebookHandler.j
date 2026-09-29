.version 50 0 
.class public super [463] 
.super [465] 
.field private [466] [467] 
.field private final [468] [469] 
.field private [470] [471] 
.field private final [472] [473] 

.method public [475] : [476] 
    .attribute [474] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [76] 
L7:     aload_0 
L8:     new [81] 
L11:    dup 
L12:    invokespecial [77] 
L15:    putfield [82] 
L18:    aload_0 
L19:    new [83] 
L22:    dup 
L23:    aload_0 
L24:    aconst_null 
L25:    invokespecial [78] 
L28:    putfield [84] 
L31:    aload_1 
L32:    invokevirtual [46] 
L35:    iconst_3 
L36:    aload_0 
L37:    getfield [45] 
L40:    invokeinterface [85] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [477] : [478] 
    .attribute [474] .code stack 9 locals 8 
L0:     aload_0 
L1:     getfield [43] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_0 
L9:     getfield [47] 
L12:    invokevirtual [48] 
L15:    pop 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [49] 
L21:    aload_0 
L22:    getfield [42] 
L25:    checkcast [7] 
L28:    invokevirtual [50] 
L31:    astore_2 
L32:    aload_2 
L33:    ifnull L234 
L36:    aload_0 
L37:    getfield [51] 
L40:    ifne L50 
L43:    aload_0 
L44:    invokevirtual [52] 
L47:    goto L259 
L50:    aload_1 
L51:    invokevirtual [53] 
L54:    astore_3 
L55:    aload_3 
L56:    invokeinterface [87] 0 
L61:    ifne L68 
L64:    iconst_0 
L65:    goto L76 
L68:    aload_3 
L69:    invokeinterface [87] 0 
L74:    iconst_1 
L75:    isub 
L76:    istore 4 
L78:    aload_3 
L79:    invokeinterface [88] 0 
L84:    istore 5 
L86:    aload_3 
L87:    invokeinterface [89] 0 
L92:    istore 6 
L94:    aload_3 
L95:    invokeinterface [90] 0 
L100:   istore 7 
L102:   aload_3 
L103:   invokeinterface [91] 0 
L108:   istore 8 
L110:   aload_3 
L111:   invokeinterface [87] 0 
L116:   iconst_1 
L117:   if_icmpne L149 
L120:   iload 7 
L122:   ifeq L149 
L125:   iload 8 
L127:   ifeq L149 
L130:   aload_0 
L131:   getfield [43] 
L134:   ldc [5] 
L136:   ldc [8] 
L138:   invokevirtual [54] 
L141:   pop 
L142:   aload_0 
L143:   invokevirtual [52] 
L146:   goto L231 
L149:   aload_0 
L150:   getfield [43] 
L153:   aload_0 
L154:   getfield [51] 
L157:   iload 4 
L159:   iload 5 
L161:   iload 6 
L163:   iload 7 
L165:   iload 8 
L167:   invokestatic [9] 
L170:   astore 9 
L172:   aload 9 
L174:   ifnonnull L211 
L177:   aload_0 
L178:   getfield [43] 
L181:   ldc [10] 
L183:   ldc [11] 
L185:   aload_0 
L186:   getfield [51] 
L189:   i2l 
L190:   aload_3 
L191:   invokeinterface [87] 0 
L196:   i2l 
L197:   iload 6 
L199:   i2l 
L200:   invokevirtual [55] 
L203:   pop 
L204:   aload_0 
L205:   invokevirtual [52] 
L208:   goto L231 
L211:   aload_2 
L212:   aload_1 
L213:   invokevirtual [56] 
L216:   aload 9 
L218:   getfield [57] 
L221:   aload 9 
L223:   invokevirtual [58] 
L226:   invokeinterface [92] 0 
L231:   goto L259 
L234:   aload_0 
L235:   getfield [43] 
L238:   sipush 10000 
L241:   ldc [12] 
L243:   aload_0 
L244:   getfield [47] 
L247:   invokevirtual [48] 
L250:   pop 
L251:   aload_0 
L252:   invokevirtual [52] 
L255:   aload_0 
L256:   invokevirtual [59] 
L259:   return 
L260:   
    .end code 
.end method 

.method public [479] : [480] 
    .attribute [474] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [481] : [482] 
    .attribute [474] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     aload_2 
L5:     checkcast [13] 
L8:     checkcast [13] 
L11:    invokevirtual [60] 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [61] 
L19:    ifeq L239 
L22:    aload_0 
L23:    getfield [43] 
L26:    ldc [5] 
L28:    ldc [14] 
L30:    aload_0 
L31:    getfield [47] 
L34:    aload_2 
L35:    arraylength 
L36:    i2l 
L37:    invokevirtual [62] 
L40:    pop 
L41:    aload_0 
L42:    invokevirtual [63] 
L45:    ifeq L220 
L48:    aload_0 
L49:    invokevirtual [64] 
L52:    invokevirtual [53] 
L55:    invokeinterface [93] 0 
L60:    tableswitch 0 
            L140 
            L212 
            L140 
            L212 
            L140 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            L212 
            default : L212 

L140:   aload_0 
L141:   aload_2 
L142:   checkcast [13] 
L145:   checkcast [13] 
L148:   putfield [94] 
L151:   aload_2 
L152:   arraylength 
L153:   iconst_1 
L154:   if_icmpne L168 
L157:   aload_0 
L158:   aload_0 
L159:   getfield [65] 
L162:   invokespecial [79] 
L165:   goto L256 
L168:   aload_2 
L169:   arraylength 
L170:   iconst_1 
L171:   if_icmple L204 
L174:   aload_0 
L175:   getfield [43] 
L178:   sipush 10000 
L181:   ldc [15] 
L183:   aload_0 
L184:   getfield [47] 
L187:   invokevirtual [48] 
L190:   pop 
L191:   aload_0 
L192:   invokevirtual [64] 
L195:   invokevirtual [53] 
L198:   iconst_1 
L199:   invokeinterface [95] 0 
L204:   aload_0 
L205:   aload_2 
L206:   invokevirtual [66] 
L209:   goto L256 
L212:   aload_0 
L213:   aload_2 
L214:   invokevirtual [66] 
L217:   goto L256 
L220:   aload_0 
L221:   getfield [43] 
L224:   ldc [5] 
L226:   ldc [16] 
L228:   aload_0 
L229:   getfield [47] 
L232:   invokevirtual [48] 
L235:   pop 
L236:   goto L256 
L239:   aload_0 
L240:   getfield [43] 
L243:   sipush 10000 
L246:   ldc [17] 
L248:   aload_0 
L249:   getfield [47] 
L252:   invokevirtual [48] 
L255:   pop 
L256:   return 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
    .end code 
.end method 

.method public interface [483] : [484] 
    .attribute [474] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [485] : [486] 
    .attribute [474] .code stack 6 locals 6 
L0:     aload_0 
L1:     getfield [42] 
L4:     checkcast [7] 
L7:     invokevirtual [50] 
L10:    astore_2 
L11:    aload_2 
L12:    ifnonnull L33 
L15:    aload_0 
L16:    getfield [43] 
L19:    sipush 10000 
L22:    ldc [18] 
L24:    aload_0 
L25:    getfield [47] 
L28:    invokevirtual [48] 
L31:    pop 
L32:    return 
L33:    aload_0 
L34:    getfield [44] 
L37:    dup 
L38:    astore_3 
L39:    monitorenter 
        .catch [0] from L40 to L51 using L54 
L40:    aload_0 
L41:    getfield [44] 
L44:    invokeinterface [96] 0 
L49:    aload_3 
L50:    monitorexit 
L51:    goto L61 
        .catch [0] from L54 to L58 using L54 
L54:    astore 4 
L56:    aload_3 
L57:    monitorexit 
L58:    aload 4 
L60:    athrow 
L61:    iconst_0 
L62:    istore_3 
L63:    iload_3 
L64:    aload_1 
L65:    arraylength 
L66:    if_icmpge L153 
L69:    aload_1 
L70:    iload_3 
L71:    aaload 
L72:    invokevirtual [67] 
L75:    lstore 4 
L77:    aload_0 
L78:    getfield [44] 
L81:    dup 
L82:    astore 6 
L84:    monitorenter 
        .catch [0] from L85 to L110 using L113 
L85:    aload_0 
L86:    getfield [44] 
L89:    new [97] 
L92:    dup 
L93:    lload 4 
L95:    invokespecial [80] 
L98:    aload_1 
L99:    iload_3 
L100:   aaload 
L101:   invokeinterface [98] 0 
L106:   pop 
L107:   aload 6 
L109:   monitorexit 
L110:   goto L121 
        .catch [0] from L113 to L118 using L113 
L113:   astore 7 
L115:   aload 6 
L117:   monitorexit 
L118:   aload 7 
L120:   athrow 
L121:   aload_0 
L122:   getfield [43] 
L125:   ldc [5] 
L127:   ldc [20] 
L129:   aload_0 
L130:   getfield [47] 
L133:   lload 4 
L135:   invokevirtual [62] 
L138:   pop 
L139:   aload_2 
L140:   lload 4 
L142:   invokeinterface [99] 0 
L147:   iinc 3 1 
L150:   goto L63 
L153:   return 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method public [487] : [488] 
    .attribute [474] .code stack 5 locals 1 
L0:     iload_1 
L1:     iload_2 
L2:     iadd 
L3:     istore_3 
L4:     iload_3 
L5:     iconst_1 
L6:     if_icmpge L14 
L9:     iconst_1 
L10:    istore_3 
L11:    goto L27 
L14:    iload_3 
L15:    aload_0 
L16:    getfield [51] 
L19:    if_icmplt L27 
L22:    aload_0 
L23:    getfield [51] 
L26:    istore_3 
L27:    aload_0 
L28:    iconst_1 
L29:    iload_1 
L30:    iload_3 
L31:    iload_3 
L32:    invokevirtual [68] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [489] : [490] 
    .attribute [474] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [43] 
L4:     ldc [5] 
L6:     ldc [21] 
L8:     aload_0 
L9:     getfield [47] 
L12:    iload_1 
L13:    ifeq L21 
L16:    ldc [22] 
L18:    goto L23 
L21:    ldc [23] 
L23:    iload_2 
L24:    i2l 
L25:    invokevirtual [69] 
L28:    aload_0 
L29:    getfield [43] 
L32:    ldc [5] 
L34:    ldc [24] 
L36:    aload_0 
L37:    getfield [47] 
L40:    iload_3 
L41:    i2l 
L42:    iload 4 
L44:    i2l 
L45:    invokevirtual [70] 
L48:    pop 
L49:    aload_0 
L50:    getfield [42] 
L53:    bipush 54 
L55:    invokevirtual [71] 
L58:    astore 5 
L60:    aload_0 
L61:    getfield [42] 
L64:    bipush 54 
L66:    invokevirtual [72] 
L69:    checkcast [25] 
L72:    astore 6 
L74:    aload 6 
L76:    iload_1 
L77:    ifeq L84 
L80:    iconst_0 
L81:    goto L85 
L84:    iconst_1 
L85:    putfield [100] 
L88:    aload 6 
L90:    iload_2 
L91:    putfield [101] 
L94:    aload 6 
L96:    iload_3 
L97:    putfield [102] 
L100:   aload 6 
L102:   iload 4 
L104:   putfield [103] 
L107:   aload 5 
L109:   aload 6 
L111:   invokevirtual [73] 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [491] : [492] 
    .attribute [474] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [493] : [494] 
    .attribute [474] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ifne L26 
L7:     iload_1 
L8:     ifne L26 
L11:    aload_0 
L12:    getfield [43] 
L15:    ldc [5] 
L17:    ldc [26] 
L19:    invokevirtual [54] 
L22:    pop 
L23:    goto L36 
L26:    aload_0 
L27:    iload_1 
L28:    putfield [86] 
L31:    aload_0 
L32:    invokevirtual [74] 
L35:    pop 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [495] : [496] 
    .attribute [474] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [44] 
L4:     dup 
L5:     astore 4 
L7:     monitorenter 
        .catch [0] from L8 to L119 using L122 
L8:     aload_0 
L9:     getfield [44] 
L12:    new [97] 
L15:    dup 
L16:    lload_1 
L17:    invokespecial [80] 
L20:    invokeinterface [104] 0 
L25:    checkcast [27] 
L28:    astore 5 
L30:    aload 5 
L32:    ifnull L99 
L35:    aload_0 
L36:    getfield [43] 
L39:    ldc [5] 
L41:    ldc [28] 
L43:    aload_0 
L44:    getfield [47] 
L47:    lload_1 
L48:    invokevirtual [62] 
L51:    pop 
L52:    aload 5 
L54:    aload_3 
L55:    invokevirtual [75] 
L58:    aload_0 
L59:    getfield [44] 
L62:    new [97] 
L65:    dup 
L66:    lload_1 
L67:    invokespecial [80] 
L70:    invokeinterface [105] 0 
L75:    pop 
L76:    aload_0 
L77:    getfield [44] 
L80:    invokeinterface [106] 0 
L85:    ifeq L116 
L88:    aload_0 
L89:    aload_0 
L90:    getfield [65] 
L93:    invokevirtual [66] 
L96:    goto L116 
L99:    aload_0 
L100:   getfield [43] 
L103:   ldc [10] 
L105:   ldc [29] 
L107:   aload_0 
L108:   getfield [47] 
L111:   lload_1 
L112:   invokevirtual [62] 
L115:   pop 
L116:   aload 4 
L118:   monitorexit 
L119:   goto L130 
        .catch [0] from L122 to L127 using L122 
L122:   astore 6 
L124:   aload 4 
L126:   monitorexit 
L127:   aload 6 
L129:   athrow 
L130:   return 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [497] : [498] 
    .attribute [474] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [499] : [500] 
    .attribute [474] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [501] : [502] 
    .attribute [474] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [503] : [504] 
    .attribute [474] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [505] : [506] 
    .attribute [474] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [507] : [508] 
    .attribute [474] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [107] 
.const [3] = Class [108] 
.const [4] = Class [109] 
.const [5] = Int -2137614336 
.const [6] = String [110] 
.const [7] = Class [111] 
.const [8] = String [112] 
.const [9] = Method [113] [114] 
.const [10] = Int -1601830656 
.const [11] = String [115] 
.const [12] = String [116] 
.const [13] = Class [117] 
.const [14] = String [118] 
.const [15] = String [119] 
.const [16] = String [120] 
.const [17] = String [121] 
.const [18] = String [122] 
.const [19] = Class [123] 
.const [20] = String [124] 
.const [21] = String [125] 
.const [22] = String [126] 
.const [23] = String [127] 
.const [24] = String [128] 
.const [25] = Class [129] 
.const [26] = String [130] 
.const [27] = Class [131] 
.const [28] = String [132] 
.const [29] = String [133] 
.const [30] = Class [134] 
.const [31] = Class [135] 
.const [32] = Class [136] 
.const [33] = Class [137] 
.const [34] = Class [138] 
.const [35] = Class [139] 
.const [36] = Class [140] 
.const [37] = Class [141] 
.const [38] = Class [142] 
.const [39] = Class [143] 
.const [40] = Class [144] 
.const [41] = Class [145] 
.const [42] = Field [146] [147] 
.const [43] = Field [148] [149] 
.const [44] = Field [150] [151] 
.const [45] = Field [152] [153] 
.const [46] = Method [154] [155] 
.const [47] = Field [156] [157] 
.const [48] = Method [158] [159] 
.const [49] = Method [160] [161] 
.const [50] = Method [162] [163] 
.const [51] = Field [164] [165] 
.const [52] = Method [166] [167] 
.const [53] = Method [168] [169] 
.const [54] = Method [170] [171] 
.const [55] = Method [172] [173] 
.const [56] = Method [174] [175] 
.const [57] = Field [176] [177] 
.const [58] = Method [178] [179] 
.const [59] = Method [180] [181] 
.const [60] = Method [182] [183] 
.const [61] = Method [184] [185] 
.const [62] = Method [186] [187] 
.const [63] = Method [188] [189] 
.const [64] = Method [190] [191] 
.const [65] = Field [192] [193] 
.const [66] = Method [194] [195] 
.const [67] = Method [196] [197] 
.const [68] = Method [198] [199] 
.const [69] = Method [200] [201] 
.const [70] = Method [202] [203] 
.const [71] = Method [204] [205] 
.const [72] = Method [206] [207] 
.const [73] = Method [208] [209] 
.const [74] = Method [210] [211] 
.const [75] = Method [212] [213] 
.const [76] = Method [214] [215] 
.const [77] = Method [216] [217] 
.const [78] = Method [218] [219] 
.const [79] = Method [220] [221] 
.const [80] = Method [222] [223] 
.const [81] = Class [224] 
.const [82] = Field [225] [226] 
.const [83] = Class [227] 
.const [84] = Field [228] [229] 
.const [85] = InterfaceMethod [230] [231] 
.const [86] = Field [232] [233] 
.const [87] = InterfaceMethod [234] [235] 
.const [88] = InterfaceMethod [236] [237] 
.const [89] = InterfaceMethod [238] [239] 
.const [90] = InterfaceMethod [240] [241] 
.const [91] = InterfaceMethod [242] [243] 
.const [92] = InterfaceMethod [244] [245] 
.const [93] = InterfaceMethod [246] [247] 
.const [94] = Field [248] [249] 
.const [95] = InterfaceMethod [250] [251] 
.const [96] = InterfaceMethod [252] [253] 
.const [97] = Class [254] 
.const [98] = InterfaceMethod [255] [256] 
.const [99] = InterfaceMethod [257] [258] 
.const [100] = Field [259] [260] 
.const [101] = Field [261] [262] 
.const [102] = Field [263] [264] 
.const [103] = Field [265] [266] 
.const [104] = InterfaceMethod [267] [268] 
.const [105] = InterfaceMethod [269] [270] 
.const [106] = InterfaceMethod [271] [272] 
.const [107] = Utf8 PhonebookHandler 
.const [108] = Utf8 java/util/HashMap 
.const [109] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [110] = Utf8 '[%1#requestListElements] called' 
.const [111] = Utf8 de/audi/app/combi/bap/app/phone/CombiModulePhone 
.const [112] = Utf8 '[PhonebookHandler#requestListElements] no wrap around with startPos!=0 -> send empty list' 
.const [113] = Class [273] 
.const [114] = NameAndType [274] [275] 
.const [115] = Utf8 '[PhonebookHandler#requestListElements] getArrayRequest not applicable on current list (currentListSize=%1, start=%2, numberOfElements=%3)' 
.const [116] = Utf8 '[%1#requestListElements] unable to forward request because Addressbook service is not available' 
.const [117] = Utf8 [Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry; 
.const [118] = Utf8 '[%1#responseListElements] taID check OK, received %2 element(s)' 
.const [119] = Utf8 '[%1#responseListElements] request of more than one element with full details not supported' 
.const [120] = Utf8 '[%1#responseListElements] pending request is null -> ignore update' 
.const [121] = Utf8 '[%1#responseListElements] taID check failed -> ignore update!' 
.const [122] = Utf8 '[%1#requestEntryDetails] unable to forward request because Addressbook service is not available' 
.const [123] = Utf8 java/lang/Long 
.const [124] = Utf8 '[%1#requestEntryDetails] request details for entryID: %2' 
.const [125] = Utf8 '[%1#getNextListPosResult] called (result=%2, currentEntryID=%3,...)' 
.const [126] = Utf8 successful 
.const [127] = Utf8 unsuccessful 
.const [128] = Utf8 '[%1#getNextListPosResult] ..., nextEntryID=%2, absoluteListPos=%3' 
.const [129] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [130] = Utf8 "[PhonebookHandler#notifyPhonebookChanged] list is still empty -> don't send ChangedArray" 
.const [131] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [132] = Utf8 '[%1#setEntryDetails] set details for entryID: %2' 
.const [133] = Utf8 '[%1#setEntryDetails] unknown entryID: %2' 
.const [134] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [135] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [136] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [137] = Utf8 de/audi/atip/log/LogChannel 
.const [138] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [139] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [140] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [141] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils$IndexRange 
.const [142] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceAddressBookListener 
.const [143] = Utf8 java/util/Map 
.const [144] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [145] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [146] = Class [276] 
.const [147] = NameAndType [277] [278] 
.const [148] = Class [279] 
.const [149] = NameAndType [280] [281] 
.const [150] = Class [282] 
.const [151] = NameAndType [283] [284] 
.const [152] = Class [285] 
.const [153] = NameAndType [286] [287] 
.const [154] = Class [288] 
.const [155] = NameAndType [289] [290] 
.const [156] = Class [291] 
.const [157] = NameAndType [292] [293] 
.const [158] = Class [294] 
.const [159] = NameAndType [295] [296] 
.const [160] = Class [297] 
.const [161] = NameAndType [298] [299] 
.const [162] = Class [300] 
.const [163] = NameAndType [301] [302] 
.const [164] = Class [303] 
.const [165] = NameAndType [304] [305] 
.const [166] = Class [306] 
.const [167] = NameAndType [307] [308] 
.const [168] = Class [309] 
.const [169] = NameAndType [310] [311] 
.const [170] = Class [312] 
.const [171] = NameAndType [313] [314] 
.const [172] = Class [315] 
.const [173] = NameAndType [316] [317] 
.const [174] = Class [318] 
.const [175] = NameAndType [319] [320] 
.const [176] = Class [321] 
.const [177] = NameAndType [322] [323] 
.const [178] = Class [324] 
.const [179] = NameAndType [325] [326] 
.const [180] = Class [327] 
.const [181] = NameAndType [328] [329] 
.const [182] = Class [330] 
.const [183] = NameAndType [331] [332] 
.const [184] = Class [333] 
.const [185] = NameAndType [334] [335] 
.const [186] = Class [336] 
.const [187] = NameAndType [337] [338] 
.const [188] = Class [339] 
.const [189] = NameAndType [340] [341] 
.const [190] = Class [342] 
.const [191] = NameAndType [343] [344] 
.const [192] = Class [345] 
.const [193] = NameAndType [346] [347] 
.const [194] = Class [348] 
.const [195] = NameAndType [349] [350] 
.const [196] = Class [351] 
.const [197] = NameAndType [352] [353] 
.const [198] = Class [354] 
.const [199] = NameAndType [355] [356] 
.const [200] = Class [357] 
.const [201] = NameAndType [358] [359] 
.const [202] = Class [360] 
.const [203] = NameAndType [361] [362] 
.const [204] = Class [363] 
.const [205] = NameAndType [364] [365] 
.const [206] = Class [366] 
.const [207] = NameAndType [367] [368] 
.const [208] = Class [369] 
.const [209] = NameAndType [370] [371] 
.const [210] = Class [372] 
.const [211] = NameAndType [373] [374] 
.const [212] = Class [375] 
.const [213] = NameAndType [376] [377] 
.const [214] = Class [378] 
.const [215] = NameAndType [379] [380] 
.const [216] = Class [381] 
.const [217] = NameAndType [382] [383] 
.const [218] = Class [384] 
.const [219] = NameAndType [385] [386] 
.const [220] = Class [387] 
.const [221] = NameAndType [388] [389] 
.const [222] = Class [390] 
.const [223] = NameAndType [391] [392] 
.const [224] = Utf8 java/util/HashMap 
.const [225] = Class [393] 
.const [226] = NameAndType [394] [395] 
.const [227] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [228] = Class [396] 
.const [229] = NameAndType [397] [398] 
.const [230] = Class [399] 
.const [231] = NameAndType [400] [401] 
.const [232] = Class [402] 
.const [233] = NameAndType [403] [404] 
.const [234] = Class [405] 
.const [235] = NameAndType [406] [407] 
.const [236] = Class [408] 
.const [237] = NameAndType [409] [410] 
.const [238] = Class [411] 
.const [239] = NameAndType [412] [413] 
.const [240] = Class [414] 
.const [241] = NameAndType [415] [416] 
.const [242] = Class [417] 
.const [243] = NameAndType [418] [419] 
.const [244] = Class [420] 
.const [245] = NameAndType [421] [422] 
.const [246] = Class [423] 
.const [247] = NameAndType [424] [425] 
.const [248] = Class [426] 
.const [249] = NameAndType [427] [428] 
.const [250] = Class [429] 
.const [251] = NameAndType [430] [431] 
.const [252] = Class [432] 
.const [253] = NameAndType [433] [434] 
.const [254] = Utf8 java/lang/Long 
.const [255] = Class [435] 
.const [256] = NameAndType [436] [437] 
.const [257] = Class [438] 
.const [258] = NameAndType [439] [440] 
.const [259] = Class [441] 
.const [260] = NameAndType [442] [443] 
.const [261] = Class [444] 
.const [262] = NameAndType [445] [446] 
.const [263] = Class [447] 
.const [264] = NameAndType [448] [449] 
.const [265] = Class [450] 
.const [266] = NameAndType [451] [452] 
.const [267] = Class [453] 
.const [268] = NameAndType [454] [455] 
.const [269] = Class [456] 
.const [270] = NameAndType [457] [458] 
.const [271] = Class [459] 
.const [272] = NameAndType [460] [461] 
.const [273] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [274] = Utf8 computeRange 
.const [275] = Utf8 (Lde/audi/atip/log/LogChannel;IIIIZZ)Lde/audi/app/bap/fw/arrays/ArrayUtils$IndexRange; 
.const [276] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [277] = Utf8 moduleFsg 
.const [278] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [279] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [280] = Utf8 logChannel 
.const [281] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [282] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [283] = Utf8 detailRequestsInProgress 
.const [284] = Utf8 Ljava/util/Map; 
.const [285] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [286] = Utf8 pictureProvider 
.const [287] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider; 
.const [288] = Utf8 de/audi/app/combi/bap/app/phone/CombiModulePhone 
.const [289] = Utf8 getPictureManager 
.const [290] = Utf8 ()Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [291] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [292] = Utf8 className 
.const [293] = Utf8 Ljava/lang/String; 
.const [294] = Utf8 de/audi/atip/log/LogChannel 
.const [295] = Utf8 log 
.const [296] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [297] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [298] = Utf8 setPendingRequest 
.const [299] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)V 
.const [300] = Utf8 de/audi/app/combi/bap/app/phone/CombiModulePhone 
.const [301] = Utf8 getAddressbookServiceListener 
.const [302] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServiceAddressBookListener; 
.const [303] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [304] = Utf8 currentListSize 
.const [305] = Utf8 I 
.const [306] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [307] = Utf8 sendEmptyList 
.const [308] = Utf8 ()V 
.const [309] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [310] = Utf8 getArrayHeader 
.const [311] = Utf8 ()Lde/audi/app/bap/fw/arrays/IArrayHeader; 
.const [312] = Utf8 de/audi/atip/log/LogChannel 
.const [313] = Utf8 log 
.const [314] = Utf8 (ILjava/lang/String;)Z 
.const [315] = Utf8 de/audi/atip/log/LogChannel 
.const [316] = Utf8 log 
.const [317] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [318] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [319] = Utf8 getTaID 
.const [320] = Utf8 ()I 
.const [321] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils$IndexRange 
.const [322] = Utf8 startIndex 
.const [323] = Utf8 I 
.const [324] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils$IndexRange 
.const [325] = Utf8 getSize 
.const [326] = Utf8 ()I 
.const [327] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [328] = Utf8 clearPendingRequest 
.const [329] = Utf8 ()V 
.const [330] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [331] = Utf8 addToMapping 
.const [332] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry;)V 
.const [333] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [334] = Utf8 checkTAID 
.const [335] = Utf8 (I)Z 
.const [336] = Utf8 de/audi/atip/log/LogChannel 
.const [337] = Utf8 log 
.const [338] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [339] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [340] = Utf8 isRequestPending 
.const [341] = Utf8 ()Z 
.const [342] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [343] = Utf8 getPendingRequest 
.const [344] = Utf8 ()Lde/audi/app/bap/fw/arrays/GetArrayIndication; 
.const [345] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [346] = Utf8 pendingRequestResult 
.const [347] = Utf8 [Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry; 
.const [348] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [349] = Utf8 sendStatusRequest 
.const [350] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [351] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [352] = Utf8 getEntryId 
.const [353] = Utf8 ()J 
.const [354] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [355] = Utf8 getNextListPosResult 
.const [356] = Utf8 (ZIII)V 
.const [357] = Utf8 de/audi/atip/log/LogChannel 
.const [358] = Utf8 log 
.const [359] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [360] = Utf8 de/audi/atip/log/LogChannel 
.const [361] = Utf8 log 
.const [362] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [363] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [364] = Utf8 getBAPFunctionMethodFSG 
.const [365] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG; 
.const [366] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [367] = Utf8 createResultSerializer 
.const [368] = Utf8 (I)Lde/vw/mib/bap/requests/ResultMethod; 
.const [369] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [370] = Utf8 resultREQ 
.const [371] = Utf8 (Lde/vw/mib/bap/requests/ResultMethod;)V 
.const [372] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [373] = Utf8 sendFullRangeUpdate 
.const [374] = Utf8 ()Z 
.const [375] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [376] = Utf8 setDetails 
.const [377] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails;)V 
.const [378] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [379] = Utf8 <init> 
.const [380] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [381] = Utf8 java/util/HashMap 
.const [382] = Utf8 <init> 
.const [383] = Utf8 ()V 
.const [384] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler$1;)V 
.const [387] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [388] = Utf8 requestEntryDetails 
.const [389] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry;)V 
.const [390] = Utf8 java/lang/Long 
.const [391] = Utf8 <init> 
.const [392] = Utf8 (J)V 
.const [393] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [394] = Utf8 detailRequestsInProgress 
.const [395] = Utf8 Ljava/util/Map; 
.const [396] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [397] = Utf8 pictureProvider 
.const [398] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider; 
.const [399] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [400] = Utf8 registerPictureProvider 
.const [401] = Utf8 (ILde/audi/app/combi/bap/app/kombipictures/IPictureProvider;)V 
.const [402] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [403] = Utf8 currentListSize 
.const [404] = Utf8 I 
.const [405] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [406] = Utf8 getStart 
.const [407] = Utf8 ()I 
.const [408] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [409] = Utf8 getStartOffset 
.const [410] = Utf8 ()I 
.const [411] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [412] = Utf8 getNumberOfElements 
.const [413] = Utf8 ()I 
.const [414] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [415] = Utf8 isModeShift 
.const [416] = Utf8 ()Z 
.const [417] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [418] = Utf8 isModeArrayDirectionBackward 
.const [419] = Utf8 ()Z 
.const [420] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceAddressBookListener 
.const [421] = Utf8 requestPhonebookListElements 
.const [422] = Utf8 (III)V 
.const [423] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [424] = Utf8 getRecordAddress 
.const [425] = Utf8 ()I 
.const [426] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [427] = Utf8 pendingRequestResult 
.const [428] = Utf8 [Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry; 
.const [429] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [430] = Utf8 setRecordAddress 
.const [431] = Utf8 (I)V 
.const [432] = Utf8 java/util/Map 
.const [433] = Utf8 clear 
.const [434] = Utf8 ()V 
.const [435] = Utf8 java/util/Map 
.const [436] = Utf8 put 
.const [437] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [438] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceAddressBookListener 
.const [439] = Utf8 requestPhonebookEntryDetails 
.const [440] = Utf8 (J)V 
.const [441] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [442] = Utf8 getNextListPos_Result 
.const [443] = Utf8 I 
.const [444] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [445] = Utf8 currentPos 
.const [446] = Utf8 I 
.const [447] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [448] = Utf8 nextPos 
.const [449] = Utf8 I 
.const [450] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [451] = Utf8 absoluteListPos 
.const [452] = Utf8 I 
.const [453] = Utf8 java/util/Map 
.const [454] = Utf8 get 
.const [455] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [456] = Utf8 java/util/Map 
.const [457] = Utf8 remove 
.const [458] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [459] = Utf8 java/util/Map 
.const [460] = Utf8 isEmpty 
.const [461] = Utf8 ()Z 
.const [462] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [463] = Class [462] 
.const [464] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [465] = Class [464] 
.const [466] = Utf8 currentListSize 
.const [467] = Utf8 I 
.const [468] = Utf8 detailRequestsInProgress 
.const [469] = Utf8 Ljava/util/Map; 
.const [470] = Utf8 pendingRequestResult 
.const [471] = Utf8 [Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry; 
.const [472] = Utf8 pictureProvider 
.const [473] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider; 
.const [474] = Utf8 Code 
.const [475] = Utf8 <init> 
.const [476] = Utf8 (Lde/audi/app/combi/bap/app/phone/CombiModulePhone;)V 
.const [477] = Utf8 requestListElements 
.const [478] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)V 
.const [479] = Utf8 getArrayElement 
.const [480] = Utf8 (I)Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [481] = Utf8 responseListElements 
.const [482] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [483] = Utf8 getCurrentListSize 
.const [484] = Utf8 ()I 
.const [485] = Utf8 requestEntryDetails 
.const [486] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry;)V 
.const [487] = Utf8 getNextListPos 
.const [488] = Utf8 (II)V 
.const [489] = Utf8 getNextListPosResult 
.const [490] = Utf8 (ZIII)V 
.const [491] = Utf8 dataMustBeReversed 
.const [492] = Utf8 ()Z 
.const [493] = Utf8 notifyPhonebookChanged 
.const [494] = Utf8 (I)V 
.const [495] = Utf8 setEntryDetails 
.const [496] = Utf8 (J[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails;)V 
.const [497] = Utf8 getPredecessorID 
.const [498] = Utf8 (I)I 
.const [499] = Utf8 getSuccessorID 
.const [500] = Utf8 (I)I 
.const [501] = Utf8 access$000 
.const [502] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/atip/log/LogChannel; 
.const [503] = Utf8 access$100 
.const [504] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/atip/log/LogChannel; 
.const [505] = Utf8 access$200 
.const [506] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [507] = Utf8 access$300 
.const [508] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.end class 
