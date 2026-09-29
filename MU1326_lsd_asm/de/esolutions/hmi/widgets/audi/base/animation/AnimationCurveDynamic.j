.version 50 0 
.class public super [340] 
.super [342] 
.field private static final [343] [344] 
.field public static final [345] [346] 
.field public static final [347] [348] 
.field public static final [349] [350] 
.field public static final [351] [352] 
.field public static final [353] [354] 
.field public static final [355] [356] 
.field protected [357] [358] 
.field [359] [360] 
.field [361] [362] 
.field [363] [364] 
.field private [365] [366] 

.method public [368] : [369] 
    .attribute [367] .code stack 8 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     fload_3 
L4:     fload 4 
L6:     iload 5 
L8:     aload 6 
L10:    iload 8 
L12:    invokespecial [52] 
L15:    aload_0 
L16:    iconst_1 
L17:    putfield [57] 
L20:    aload_0 
L21:    aload 7 
L23:    putfield [58] 
L26:    aload_0 
L27:    aload 7 
L29:    iconst_3 
L30:    faload 
L31:    f2l 
L32:    putfield [59] 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [370] : [371] 
    .attribute [367] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ifne L35 
L7:     aload_0 
L8:     getfield [24] 
L11:    aload_0 
L12:    getfield [25] 
L15:    lsub 
L16:    ldc_w [1] 
L19:    ladd 
L20:    aload_0 
L21:    getfield [26] 
L24:    i2l 
L25:    ladd 
L26:    l2f 
L27:    aload_0 
L28:    invokevirtual [27] 
L31:    fcmpl 
L32:    ifgt L42 
L35:    aload_0 
L36:    invokevirtual [28] 
L39:    ifeq L65 
L42:    aload_0 
L43:    aload_0 
L44:    getfield [29] 
L47:    putfield [64] 
L50:    aload_0 
L51:    getfield [31] 
L54:    ldc [2] 
L56:    ldc [3] 
L58:    invokevirtual [32] 
L61:    pop 
L62:    goto L153 
L65:    aload_0 
L66:    getfield [24] 
L69:    aload_0 
L70:    getfield [25] 
L73:    lsub 
L74:    aload_0 
L75:    getfield [26] 
L78:    i2l 
L79:    lcmp 
L80:    iflt L90 
L83:    aload_0 
L84:    getfield [23] 
L87:    ifeq L137 
L90:    aload_0 
L91:    aload_0 
L92:    aload_0 
L93:    getfield [30] 
L96:    invokevirtual [33] 
L99:    putfield [64] 
L102:   aload_0 
L103:   getfield [34] 
L106:   iconst_2 
L107:   if_icmpne L122 
L110:   aload_0 
L111:   aload_0 
L112:   aload_0 
L113:   getfield [30] 
L116:   invokevirtual [33] 
L119:   putfield [64] 
L122:   aload_0 
L123:   getfield [31] 
L126:   ldc [2] 
L128:   ldc [4] 
L130:   invokevirtual [32] 
L133:   pop 
L134:   goto L153 
L137:   aload_0 
L138:   invokespecial [53] 
L141:   aload_0 
L142:   getfield [31] 
L145:   ldc [2] 
L147:   ldc [5] 
L149:   invokevirtual [32] 
L152:   pop 
L153:   ldc [2] 
L155:   aload_0 
L156:   getfield [31] 
L159:   invokevirtual [35] 
L162:   if_icmpgt L184 
L165:   aload_0 
L166:   getfield [31] 
L169:   ldc [2] 
L171:   ldc [6] 
L173:   aload_0 
L174:   getfield [30] 
L177:   invokestatic [7] 
L180:   invokevirtual [36] 
L183:   pop 
L184:   return 
L185:   nop 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [367] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_4 
L5:     faload 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [374] : [375] 
    .attribute [367] .code stack 3 locals 4 
L0:     fload_1 
L1:     fstore_2 
L2:     aload_0 
L3:     getfield [29] 
L6:     fload_1 
L7:     fsub 
L8:     fstore_3 
L9:     iconst_1 
L10:    istore 4 
L12:    fload_3 
L13:    fstore 5 
L15:    fload_3 
L16:    fconst_0 
L17:    fcmpg 
L18:    ifge L30 
L21:    iconst_m1 
L22:    istore 4 
L24:    fload_3 
L25:    invokestatic [8] 
L28:    fstore 5 
L30:    fload 5 
L32:    ldc [9] 
L34:    fcmpl 
L35:    ifle L199 
L38:    aload_0 
L39:    getfield [21] 
L42:    iconst_1 
L43:    if_icmpgt L74 
L46:    aload_0 
L47:    getfield [21] 
L50:    i2f 
L51:    aload_0 
L52:    getfield [37] 
L55:    fmul 
L56:    iload 4 
L58:    i2f 
L59:    fmul 
L60:    fstore_3 
L61:    aload_0 
L62:    dup 
L63:    getfield [21] 
L66:    iconst_2 
L67:    imul 
L68:    putfield [57] 
L71:    goto L81 
L74:    fload_3 
L75:    aload_0 
L76:    getfield [38] 
L79:    fdiv 
L80:    fstore_3 
L81:    fload_3 
L82:    invokestatic [8] 
L85:    fstore 5 
L87:    fload 5 
L89:    aload_0 
L90:    getfield [39] 
L93:    fcmpl 
L94:    ifle L109 
L97:    iload 4 
L99:    i2f 
L100:   aload_0 
L101:   getfield [39] 
L104:   fmul 
L105:   fstore_3 
L106:   goto L128 
L109:   fload 5 
L111:   aload_0 
L112:   getfield [37] 
L115:   fcmpg 
L116:   ifge L128 
L119:   iload 4 
L121:   i2f 
L122:   aload_0 
L123:   getfield [37] 
L126:   fmul 
L127:   fstore_3 
L128:   fload_1 
L129:   aload_0 
L130:   getfield [40] 
L133:   fsub 
L134:   invokestatic [8] 
L137:   ldc [9] 
L139:   fcmpg 
L140:   ifge L152 
L143:   iload 4 
L145:   i2f 
L146:   aload_0 
L147:   getfield [37] 
L150:   fmul 
L151:   fstore_3 
L152:   fload_2 
L153:   fload_3 
L154:   fadd 
L155:   fstore_2 
L156:   aload_0 
L157:   getfield [40] 
L160:   aload_0 
L161:   getfield [29] 
L164:   fcmpg 
L165:   ifge L185 
L168:   fload_2 
L169:   aload_0 
L170:   getfield [29] 
L173:   fcmpl 
L174:   ifle L199 
L177:   aload_0 
L178:   getfield [29] 
L181:   fstore_2 
L182:   goto L199 
L185:   fload_2 
L186:   aload_0 
L187:   getfield [29] 
L190:   fcmpg 
L191:   ifge L199 
L194:   aload_0 
L195:   getfield [29] 
L198:   fstore_2 
L199:   fload_2 
L200:   areturn 
L201:   nop 
L202:   nop 
L203:   nop 
L204:   
    .end code 
.end method 

.method private [376] : [377] 
    .attribute [367] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     getfield [25] 
L8:     lsub 
L9:     l2f 
L10:    aload_0 
L11:    getfield [26] 
L14:    i2f 
L15:    fdiv 
L16:    fstore_1 
L17:    fload_1 
L18:    f2i 
L19:    istore_2 
L20:    iconst_0 
L21:    istore_3 
L22:    iload_3 
L23:    iload_2 
L24:    if_icmpge L45 
L27:    aload_0 
L28:    aload_0 
L29:    aload_0 
L30:    getfield [30] 
L33:    invokevirtual [33] 
L36:    putfield [64] 
L39:    iinc 3 1 
L42:    goto L22 
L45:    aload_0 
L46:    getfield [30] 
L49:    aload_0 
L50:    getfield [29] 
L53:    fsub 
L54:    invokestatic [8] 
L57:    ldc [9] 
L59:    fcmpl 
L60:    ifle L92 
L63:    aload_0 
L64:    aload_0 
L65:    getfield [30] 
L68:    invokevirtual [33] 
L71:    fstore_3 
L72:    aload_0 
L73:    aload_0 
L74:    getfield [30] 
L77:    fload_1 
L78:    iload_2 
L79:    i2f 
L80:    fsub 
L81:    fload_3 
L82:    aload_0 
L83:    getfield [30] 
L86:    fsub 
L87:    fmul 
L88:    fadd 
L89:    putfield [64] 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [378] : [379] 
    .attribute [367] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [58] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [380] : [381] 
    .attribute [367] .code stack 3 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     putfield [60] 
L5:     aload_0 
L6:     lload_3 
L7:     putfield [61] 
L10:    aload_0 
L11:    invokevirtual [41] 
L14:    aload_0 
L15:    invokevirtual [42] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [382] : [383] 
    .attribute [367] .code stack 4 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     fload_2 
L3:     iload_3 
L4:     invokespecial [54] 
L7:     aload_0 
L8:     fload_1 
L9:     fload_2 
L10:    invokespecial [55] 
L13:    aload_0 
L14:    invokevirtual [43] 
L17:    aload_0 
L18:    iconst_1 
L19:    putfield [57] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [384] : [385] 
    .attribute [367] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     iconst_1 
L6:     faload 
L7:     putfield [65] 
L10:    aload_0 
L11:    getfield [22] 
L14:    iconst_2 
L15:    faload 
L16:    fstore_3 
L17:    fload_3 
L18:    invokestatic [8] 
L21:    ldc [10] 
L23:    fcmpg 
L24:    ifge L29 
L27:    fconst_2 
L28:    fstore_3 
L29:    aload_0 
L30:    fload_2 
L31:    fload_1 
L32:    fsub 
L33:    invokestatic [8] 
L36:    fload_3 
L37:    fdiv 
L38:    putfield [67] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [22] 
L46:    iconst_0 
L47:    faload 
L48:    putfield [66] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [386] : [387] 
    .attribute [367] .code stack 9 locals 4 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_3 
L5:     faload 
L6:     fstore_1 
L7:     aload_0 
L8:     getfield [22] 
L11:    iconst_4 
L12:    faload 
L13:    fstore_2 
L14:    iconst_0 
L15:    istore_3 
L16:    aload_0 
L17:    getfield [40] 
L20:    fstore 4 
L22:    fload 4 
L24:    aload_0 
L25:    getfield [29] 
L28:    fsub 
L29:    invokestatic [8] 
L32:    ldc [9] 
L34:    fcmpl 
L35:    ifle L139 
L38:    iinc 3 1 
L41:    aload_0 
L42:    fload 4 
L44:    invokevirtual [33] 
L47:    fstore 4 
L49:    iload_3 
L50:    sipush 1000 
L53:    if_icmple L22 
L56:    aload_0 
L57:    getfield [31] 
L60:    sipush 10000 
L63:    ldc [11] 
L65:    aload_0 
L66:    getfield [44] 
L69:    i2d 
L70:    aload_0 
L71:    getfield [40] 
L74:    f2d 
L75:    aload_0 
L76:    getfield [29] 
L79:    f2d 
L80:    invokevirtual [45] 
L83:    aload_0 
L84:    getfield [31] 
L87:    sipush 10000 
L90:    ldc [12] 
L92:    aload_0 
L93:    getfield [22] 
L96:    iconst_0 
L97:    faload 
L98:    f2d 
L99:    aload_0 
L100:   getfield [22] 
L103:   iconst_1 
L104:   faload 
L105:   f2d 
L106:   aload_0 
L107:   getfield [22] 
L110:   iconst_2 
L111:   faload 
L112:   f2d 
L113:   invokevirtual [45] 
L116:   aload_0 
L117:   getfield [31] 
L120:   sipush 10000 
L123:   ldc [13] 
L125:   fload_1 
L126:   invokestatic [7] 
L129:   fload_2 
L130:   invokestatic [7] 
L133:   invokevirtual [46] 
L136:   goto L139 
L139:   iload_3 
L140:   iconst_1 
L141:   if_icmple L187 
L144:   aload_0 
L145:   fload_1 
L146:   ldc [14] 
L148:   fsub 
L149:   aload_0 
L150:   getfield [22] 
L153:   iconst_5 
L154:   faload 
L155:   fsub 
L156:   f2i 
L157:   iload_3 
L158:   iconst_1 
L159:   isub 
L160:   idiv 
L161:   putfield [69] 
L164:   aload_0 
L165:   fload_2 
L166:   ldc [14] 
L168:   fsub 
L169:   aload_0 
L170:   getfield [22] 
L173:   iconst_5 
L174:   faload 
L175:   fsub 
L176:   f2i 
L177:   iload_3 
L178:   iconst_1 
L179:   isub 
L180:   idiv 
L181:   putfield [62] 
L184:   goto L205 
L187:   aload_0 
L188:   fload_1 
L189:   ldc [14] 
L191:   fsub 
L192:   f2i 
L193:   putfield [69] 
L196:   aload_0 
L197:   fload_2 
L198:   ldc [14] 
L200:   fsub 
L201:   f2i 
L202:   putfield [62] 
L205:   aload_0 
L206:   getfield [47] 
L209:   aload_0 
L210:   getfield [26] 
L213:   if_icmplt L226 
L216:   aload_0 
L217:   aload_0 
L218:   getfield [47] 
L221:   iconst_5 
L222:   iadd 
L223:   putfield [62] 
L226:   aload_0 
L227:   getfield [31] 
L230:   ldc [2] 
L232:   ldc [15] 
L234:   aload_0 
L235:   getfield [44] 
L238:   i2l 
L239:   iload_3 
L240:   i2l 
L241:   invokevirtual [48] 
L244:   pop 
L245:   aload_0 
L246:   invokevirtual [49] 
L249:   return 
L250:   nop 
L251:   nop 
L252:   
    .end code 
.end method 

.method public [388] : [389] 
    .attribute [367] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [56] 
L5:     iload_1 
L6:     iconst_1 
L7:     if_icmpne L33 
L10:    aload_0 
L11:    aload_0 
L12:    getfield [50] 
L15:    putfield [63] 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [51] 
L23:    putfield [68] 
L26:    aload_0 
L27:    invokevirtual [42] 
L30:    goto L53 
L33:    aload_0 
L34:    aload_0 
L35:    getfield [51] 
L38:    putfield [63] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [50] 
L46:    putfield [68] 
L49:    aload_0 
L50:    invokevirtual [42] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [390] : [391] 
    .attribute [367] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [40] 
L5:     aload_0 
L6:     getfield [29] 
L9:     invokespecial [55] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [71] 
.const [4] = String [72] 
.const [5] = String [73] 
.const [6] = String [74] 
.const [7] = Method [75] [76] 
.const [8] = Method [77] [78] 
.const [9] = Int -1782589901 
.const [10] = Int 16777216 
.const [11] = String [79] 
.const [12] = String [80] 
.const [13] = String [81] 
.const [14] = Int 41025 
.const [15] = String [82] 
.const [16] = Class [83] 
.const [17] = Class [84] 
.const [18] = Class [85] 
.const [19] = Class [86] 
.const [20] = Class [87] 
.const [21] = Field [88] [89] 
.const [22] = Field [90] [91] 
.const [23] = Field [92] [93] 
.const [24] = Field [94] [95] 
.const [25] = Field [96] [97] 
.const [26] = Field [98] [99] 
.const [27] = Method [100] [101] 
.const [28] = Method [102] [103] 
.const [29] = Field [104] [105] 
.const [30] = Field [106] [107] 
.const [31] = Field [108] [109] 
.const [32] = Method [110] [111] 
.const [33] = Method [112] [113] 
.const [34] = Field [114] [115] 
.const [35] = Method [116] [117] 
.const [36] = Method [118] [119] 
.const [37] = Field [120] [121] 
.const [38] = Field [122] [123] 
.const [39] = Field [124] [125] 
.const [40] = Field [126] [127] 
.const [41] = Method [128] [129] 
.const [42] = Method [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Field [134] [135] 
.const [45] = Method [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Field [146] [147] 
.const [51] = Field [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Field [160] [161] 
.const [58] = Field [162] [163] 
.const [59] = Field [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Field [168] [169] 
.const [62] = Field [170] [171] 
.const [63] = Field [172] [173] 
.const [64] = Field [174] [175] 
.const [65] = Field [176] [177] 
.const [66] = Field [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = Field [184] [185] 
.const [70] = Int 335544320 
.const [71] = Utf8 'AnimationCurveDynamic#approachDynamic 1: value = target' 
.const [72] = Utf8 'AnimationCurveDynamic#approachDynamic 2: value = calculateNewValue( value )' 
.const [73] = Utf8 'AnimationCurveDynamic#approachDynamic 3: regainTime()' 
.const [74] = Utf8 'AnimationCurveDynamic#approachDynamic new value: %1' 
.const [75] = Class [186] 
.const [76] = NameAndType [187] [188] 
.const [77] = Class [189] 
.const [78] = NameAndType [190] [191] 
.const [79] = Utf8 'AnimationCurveDynamic#calculateDelays more than 1000 steps for animation with type: %1, start: %2, target: %3' 
.const [80] = Utf8 'AnimationCurveDynamic#calculateDelays more than 1000 steps  factor: %1, minStep: %2, maxStepFactor: %3' 
.const [81] = Utf8 'AnimationCurveDynamic#calculateDelays more than 1000 steps  minDuration: %1, maxDuration: %2' 
.const [82] = Utf8 'AnimationCurveDynamic#calculateDelays animation with type: %1, needs: %2 steps' 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 java/lang/Float 
.const [87] = Utf8 java/lang/Math 
.const [88] = Class [192] 
.const [89] = NameAndType [193] [194] 
.const [90] = Class [195] 
.const [91] = NameAndType [196] [197] 
.const [92] = Class [198] 
.const [93] = NameAndType [199] [200] 
.const [94] = Class [201] 
.const [95] = NameAndType [202] [203] 
.const [96] = Class [204] 
.const [97] = NameAndType [205] [206] 
.const [98] = Class [207] 
.const [99] = NameAndType [208] [209] 
.const [100] = Class [210] 
.const [101] = NameAndType [211] [212] 
.const [102] = Class [213] 
.const [103] = NameAndType [214] [215] 
.const [104] = Class [216] 
.const [105] = NameAndType [217] [218] 
.const [106] = Class [219] 
.const [107] = NameAndType [220] [221] 
.const [108] = Class [222] 
.const [109] = NameAndType [223] [224] 
.const [110] = Class [225] 
.const [111] = NameAndType [226] [227] 
.const [112] = Class [228] 
.const [113] = NameAndType [229] [230] 
.const [114] = Class [231] 
.const [115] = NameAndType [232] [233] 
.const [116] = Class [234] 
.const [117] = NameAndType [235] [236] 
.const [118] = Class [237] 
.const [119] = NameAndType [238] [239] 
.const [120] = Class [240] 
.const [121] = NameAndType [241] [242] 
.const [122] = Class [243] 
.const [123] = NameAndType [244] [245] 
.const [124] = Class [246] 
.const [125] = NameAndType [247] [248] 
.const [126] = Class [249] 
.const [127] = NameAndType [250] [251] 
.const [128] = Class [252] 
.const [129] = NameAndType [253] [254] 
.const [130] = Class [255] 
.const [131] = NameAndType [256] [257] 
.const [132] = Class [258] 
.const [133] = NameAndType [259] [260] 
.const [134] = Class [261] 
.const [135] = NameAndType [262] [263] 
.const [136] = Class [264] 
.const [137] = NameAndType [265] [266] 
.const [138] = Class [267] 
.const [139] = NameAndType [268] [269] 
.const [140] = Class [270] 
.const [141] = NameAndType [271] [272] 
.const [142] = Class [273] 
.const [143] = NameAndType [274] [275] 
.const [144] = Class [276] 
.const [145] = NameAndType [277] [278] 
.const [146] = Class [279] 
.const [147] = NameAndType [280] [281] 
.const [148] = Class [282] 
.const [149] = NameAndType [283] [284] 
.const [150] = Class [285] 
.const [151] = NameAndType [286] [287] 
.const [152] = Class [288] 
.const [153] = NameAndType [289] [290] 
.const [154] = Class [291] 
.const [155] = NameAndType [292] [293] 
.const [156] = Class [294] 
.const [157] = NameAndType [295] [296] 
.const [158] = Class [297] 
.const [159] = NameAndType [298] [299] 
.const [160] = Class [300] 
.const [161] = NameAndType [301] [302] 
.const [162] = Class [303] 
.const [163] = NameAndType [304] [305] 
.const [164] = Class [306] 
.const [165] = NameAndType [307] [308] 
.const [166] = Class [309] 
.const [167] = NameAndType [310] [311] 
.const [168] = Class [312] 
.const [169] = NameAndType [313] [314] 
.const [170] = Class [315] 
.const [171] = NameAndType [316] [317] 
.const [172] = Class [318] 
.const [173] = NameAndType [319] [320] 
.const [174] = Class [321] 
.const [175] = NameAndType [322] [323] 
.const [176] = Class [324] 
.const [177] = NameAndType [325] [326] 
.const [178] = Class [327] 
.const [179] = NameAndType [328] [329] 
.const [180] = Class [330] 
.const [181] = NameAndType [331] [332] 
.const [182] = Class [333] 
.const [183] = NameAndType [334] [335] 
.const [184] = Class [336] 
.const [185] = NameAndType [337] [338] 
.const [186] = Utf8 java/lang/Float 
.const [187] = Utf8 toString 
.const [188] = Utf8 (F)Ljava/lang/String; 
.const [189] = Utf8 java/lang/Math 
.const [190] = Utf8 abs 
.const [191] = Utf8 (F)F 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [193] = Utf8 easeIn 
.const [194] = Utf8 I 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [196] = Utf8 animationParameters 
.const [197] = Utf8 [F 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [199] = Utf8 renderEachStep 
.const [200] = Utf8 Z 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [202] = Utf8 animationStepStart 
.const [203] = Utf8 J 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [205] = Utf8 lastAnimationStepStart 
.const [206] = Utf8 J 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [208] = Utf8 maxTimerIntervall 
.const [209] = Utf8 I 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [211] = Utf8 getMaxDuration 
.const [212] = Utf8 ()F 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [214] = Utf8 isFinished 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [217] = Utf8 target 
.const [218] = Utf8 F 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [220] = Utf8 value 
.const [221] = Utf8 F 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [223] = Utf8 logAnimation 
.const [224] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [225] = Utf8 de/audi/atip/log/LogChannel 
.const [226] = Utf8 log 
.const [227] = Utf8 (ILjava/lang/String;)Z 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [229] = Utf8 calculateNewValue 
.const [230] = Utf8 (F)F 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [232] = Utf8 animationDirection 
.const [233] = Utf8 I 
.const [234] = Utf8 de/audi/atip/log/LogChannel 
.const [235] = Utf8 getCurrentLogThreshold 
.const [236] = Utf8 ()I 
.const [237] = Utf8 de/audi/atip/log/LogChannel 
.const [238] = Utf8 log 
.const [239] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [240] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [241] = Utf8 minStep 
.const [242] = Utf8 F 
.const [243] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [244] = Utf8 factor 
.const [245] = Utf8 F 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [247] = Utf8 maxStep 
.const [248] = Utf8 F 
.const [249] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [250] = Utf8 start 
.const [251] = Utf8 F 
.const [252] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [253] = Utf8 approachDynamic 
.const [254] = Utf8 ()V 
.const [255] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [256] = Utf8 calculateProgress 
.const [257] = Utf8 ()V 
.const [258] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [259] = Utf8 calculateDelays 
.const [260] = Utf8 ()V 
.const [261] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [262] = Utf8 type 
.const [263] = Utf8 I 
.const [264] = Utf8 de/audi/atip/log/LogChannel 
.const [265] = Utf8 log 
.const [266] = Utf8 (ILjava/lang/String;DDD)V 
.const [267] = Utf8 de/audi/atip/log/LogChannel 
.const [268] = Utf8 log 
.const [269] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [270] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [271] = Utf8 timerIntervall 
.const [272] = Utf8 I 
.const [273] = Utf8 de/audi/atip/log/LogChannel 
.const [274] = Utf8 log 
.const [275] = Utf8 (ILjava/lang/String;JJ)Z 
.const [276] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [277] = Utf8 checkDelays 
.const [278] = Utf8 ()V 
.const [279] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [280] = Utf8 originalTarget 
.const [281] = Utf8 F 
.const [282] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [283] = Utf8 originalStart 
.const [284] = Utf8 F 
.const [285] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (IIFFZLde/audi/atip/log/LogChannel;I)V 
.const [288] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [289] = Utf8 regainTime 
.const [290] = Utf8 ()V 
.const [291] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [292] = Utf8 initialize 
.const [293] = Utf8 (FFI)V 
.const [294] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [295] = Utf8 initializeParameters 
.const [296] = Utf8 (FF)V 
.const [297] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [298] = Utf8 setAnimationDirection 
.const [299] = Utf8 (I)V 
.const [300] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [301] = Utf8 easeIn 
.const [302] = Utf8 I 
.const [303] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [304] = Utf8 animationParameters 
.const [305] = Utf8 [F 
.const [306] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [307] = Utf8 plannedDuration 
.const [308] = Utf8 J 
.const [309] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [310] = Utf8 animationStepStart 
.const [311] = Utf8 J 
.const [312] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [313] = Utf8 lastAnimationStepStart 
.const [314] = Utf8 J 
.const [315] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [316] = Utf8 maxTimerIntervall 
.const [317] = Utf8 I 
.const [318] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [319] = Utf8 target 
.const [320] = Utf8 F 
.const [321] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [322] = Utf8 value 
.const [323] = Utf8 F 
.const [324] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [325] = Utf8 minStep 
.const [326] = Utf8 F 
.const [327] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [328] = Utf8 factor 
.const [329] = Utf8 F 
.const [330] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [331] = Utf8 maxStep 
.const [332] = Utf8 F 
.const [333] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [334] = Utf8 start 
.const [335] = Utf8 F 
.const [336] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [337] = Utf8 timerIntervall 
.const [338] = Utf8 I 
.const [339] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveDynamic 
.const [340] = Class [339] 
.const [341] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [342] = Class [341] 
.const [343] = Utf8 MAX_ALLOWED_ANIMATION_STEPS 
.const [344] = Utf8 I 
.const [345] = Utf8 POS_FACTOR 
.const [346] = Utf8 I 
.const [347] = Utf8 POS_MIN_STEP 
.const [348] = Utf8 I 
.const [349] = Utf8 POS_MAX_STEP_QUOTIENT 
.const [350] = Utf8 I 
.const [351] = Utf8 POS_MIN_DURATION 
.const [352] = Utf8 I 
.const [353] = Utf8 POS_MAX_DURATION 
.const [354] = Utf8 I 
.const [355] = Utf8 POS_INITIAL_DELAY 
.const [356] = Utf8 I 
.const [357] = Utf8 animationParameters 
.const [358] = Utf8 [F 
.const [359] = Utf8 minStep 
.const [360] = Utf8 F 
.const [361] = Utf8 maxStep 
.const [362] = Utf8 F 
.const [363] = Utf8 factor 
.const [364] = Utf8 F 
.const [365] = Utf8 easeIn 
.const [366] = Utf8 I 
.const [367] = Utf8 Code 
.const [368] = Utf8 <init> 
.const [369] = Utf8 (IIFFZLde/audi/atip/log/LogChannel;[FI)V 
.const [370] = Utf8 approachDynamic 
.const [371] = Utf8 ()V 
.const [372] = Utf8 getMaxDuration 
.const [373] = Utf8 ()F 
.const [374] = Utf8 calculateNewValue 
.const [375] = Utf8 (F)F 
.const [376] = Utf8 regainTime 
.const [377] = Utf8 ()V 
.const [378] = Utf8 setAnimationParameters 
.const [379] = Utf8 ([F)V 
.const [380] = Utf8 computeNextStep 
.const [381] = Utf8 (JJ)V 
.const [382] = Utf8 initialize 
.const [383] = Utf8 (FFI)V 
.const [384] = Utf8 initializeParameters 
.const [385] = Utf8 (FF)V 
.const [386] = Utf8 calculateDelays 
.const [387] = Utf8 ()V 
.const [388] = Utf8 setAnimationDirection 
.const [389] = Utf8 (I)V 
.const [390] = Utf8 recalculateParameters 
.const [391] = Utf8 ()V 
.end class 
