.version 50 0 
.class public super [181] 
.super [183] 
.field protected [184] [185] 
.field protected [186] [187] 
.field protected [188] [189] 
.field protected [190] [191] 
.field protected [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     aload_0 
L6:     iconst_m1 
L7:     putfield [34] 
L10:    aload_0 
L11:    sipush 2048 
L14:    newarray byte 
L16:    putfield [35] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     aload_0 
L6:     iconst_m1 
L7:     putfield [34] 
L10:    iload_2 
L11:    ifle L24 
L14:    aload_0 
L15:    iload_2 
L16:    newarray byte 
L18:    putfield [35] 
L21:    goto L37 
L24:    new [36] 
L27:    dup 
L28:    ldc [5] 
L30:    invokestatic [7] 
L33:    invokespecial [28] 
L36:    athrow 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnonnull L20 
L7:     new [37] 
L10:    dup 
L11:    ldc [9] 
L13:    invokestatic [7] 
L16:    invokespecial [29] 
L19:    athrow 
L20:    aload_0 
L21:    getfield [19] 
L24:    aload_0 
L25:    getfield [20] 
L28:    isub 
L29:    aload_0 
L30:    getfield [21] 
L33:    invokevirtual [22] 
L36:    iadd 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [201] : [202] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [35] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [203] : [204] 
    .attribute [194] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     iconst_m1 
L5:     if_icmpeq L24 
L8:     aload_0 
L9:     getfield [20] 
L12:    aload_0 
L13:    getfield [17] 
L16:    isub 
L17:    aload_0 
L18:    getfield [23] 
L21:    if_icmplt L66 
L24:    aload_0 
L25:    getfield [21] 
L28:    aload_0 
L29:    getfield [18] 
L32:    invokevirtual [24] 
L35:    istore_1 
L36:    iload_1 
L37:    ifle L64 
L40:    aload_0 
L41:    iconst_m1 
L42:    putfield [34] 
L45:    aload_0 
L46:    iconst_0 
L47:    putfield [39] 
L50:    aload_0 
L51:    iload_1 
L52:    iconst_m1 
L53:    if_icmpne L60 
L56:    iconst_0 
L57:    goto L61 
L60:    iload_1 
L61:    putfield [38] 
L64:    iload_1 
L65:    areturn 
L66:    aload_0 
L67:    getfield [17] 
L70:    ifne L133 
L73:    aload_0 
L74:    getfield [23] 
L77:    aload_0 
L78:    getfield [18] 
L81:    arraylength 
L82:    if_icmple L133 
L85:    aload_0 
L86:    getfield [18] 
L89:    arraylength 
L90:    iconst_2 
L91:    imul 
L92:    istore_1 
L93:    iload_1 
L94:    aload_0 
L95:    getfield [23] 
L98:    if_icmple L106 
L101:   aload_0 
L102:   getfield [23] 
L105:   istore_1 
L106:   iload_1 
L107:   newarray byte 
L109:   astore_2 
L110:   aload_0 
L111:   getfield [18] 
L114:   iconst_0 
L115:   aload_2 
L116:   iconst_0 
L117:   aload_0 
L118:   getfield [18] 
L121:   arraylength 
L122:   invokestatic [12] 
L125:   aload_0 
L126:   aload_2 
L127:   putfield [35] 
L130:   goto L166 
L133:   aload_0 
L134:   getfield [17] 
L137:   ifle L166 
L140:   aload_0 
L141:   getfield [18] 
L144:   aload_0 
L145:   getfield [17] 
L148:   aload_0 
L149:   getfield [18] 
L152:   iconst_0 
L153:   aload_0 
L154:   getfield [18] 
L157:   arraylength 
L158:   aload_0 
L159:   getfield [17] 
L162:   isub 
L163:   invokestatic [12] 
L166:   aload_0 
L167:   dup 
L168:   getfield [20] 
L171:   aload_0 
L172:   getfield [17] 
L175:   isub 
L176:   putfield [39] 
L179:   aload_0 
L180:   aload_0 
L181:   iconst_0 
L182:   dup_x1 
L183:   putfield [34] 
L186:   putfield [38] 
L189:   aload_0 
L190:   getfield [21] 
L193:   aload_0 
L194:   getfield [18] 
L197:   aload_0 
L198:   getfield [20] 
L201:   aload_0 
L202:   getfield [18] 
L205:   arraylength 
L206:   aload_0 
L207:   getfield [20] 
L210:   isub 
L211:   invokevirtual [25] 
L214:   istore_1 
L215:   aload_0 
L216:   iload_1 
L217:   ifgt L227 
L220:   aload_0 
L221:   getfield [20] 
L224:   goto L233 
L227:   aload_0 
L228:   getfield [20] 
L231:   iload_1 
L232:   iadd 
L233:   putfield [38] 
L236:   iload_1 
L237:   areturn 
L238:   nop 
L239:   nop 
L240:   
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [40] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [20] 
L10:    putfield [34] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [194] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [209] : [210] 
    .attribute [194] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L63 
L7:     aload_0 
L8:     getfield [20] 
L11:    aload_0 
L12:    getfield [19] 
L15:    if_icmplt L28 
L18:    aload_0 
L19:    invokespecial [31] 
L22:    iconst_m1 
L23:    if_icmpne L28 
L26:    iconst_m1 
L27:    areturn 
L28:    aload_0 
L29:    getfield [19] 
L32:    aload_0 
L33:    getfield [20] 
L36:    isub 
L37:    ifle L61 
L40:    aload_0 
L41:    getfield [18] 
L44:    aload_0 
L45:    dup 
L46:    getfield [20] 
L49:    dup_x1 
L50:    iconst_1 
L51:    iadd 
L52:    putfield [39] 
L55:    baload 
L56:    sipush 255 
L59:    iand 
L60:    areturn 
L61:    iconst_m1 
L62:    areturn 
L63:    new [37] 
L66:    dup 
L67:    ldc [9] 
L69:    invokestatic [7] 
L72:    invokespecial [29] 
L75:    athrow 
L76:    
    .end code 
.end method 

.method public synchronized [211] : [212] 
    .attribute [194] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L319 
L7:     aload_1 
L8:     ifnull L319 
L11:    iload_2 
L12:    iflt L311 
L15:    iload_2 
L16:    aload_1 
L17:    arraylength 
L18:    if_icmpgt L311 
L21:    iload_3 
L22:    iflt L311 
L25:    iload_3 
L26:    aload_1 
L27:    arraylength 
L28:    iload_2 
L29:    isub 
L30:    if_icmpgt L311 
L33:    iload_3 
L34:    ifne L39 
L37:    iconst_0 
L38:    areturn 
L39:    aload_0 
L40:    getfield [20] 
L43:    aload_0 
L44:    getfield [19] 
L47:    if_icmpge L137 
L50:    aload_0 
L51:    getfield [19] 
L54:    aload_0 
L55:    getfield [20] 
L58:    isub 
L59:    iload_3 
L60:    if_icmplt L67 
L63:    iload_3 
L64:    goto L76 
L67:    aload_0 
L68:    getfield [19] 
L71:    aload_0 
L72:    getfield [20] 
L75:    isub 
L76:    istore 5 
L78:    aload_0 
L79:    getfield [18] 
L82:    aload_0 
L83:    getfield [20] 
L86:    aload_1 
L87:    iload_2 
L88:    iload 5 
L90:    invokestatic [12] 
L93:    aload_0 
L94:    dup 
L95:    getfield [20] 
L98:    iload 5 
L100:   iadd 
L101:   putfield [39] 
L104:   iload 5 
L106:   iload_3 
L107:   if_icmpeq L120 
L110:   aload_0 
L111:   getfield [21] 
L114:   invokevirtual [22] 
L117:   ifne L123 
L120:   iload 5 
L122:   areturn 
L123:   iload_2 
L124:   iload 5 
L126:   iadd 
L127:   istore_2 
L128:   iload_3 
L129:   iload 5 
L131:   isub 
L132:   istore 4 
L134:   goto L140 
L137:   iload_3 
L138:   istore 4 
L140:   aload_0 
L141:   getfield [17] 
L144:   iconst_m1 
L145:   if_icmpne L195 
L148:   iload 4 
L150:   aload_0 
L151:   getfield [18] 
L154:   arraylength 
L155:   if_icmplt L195 
L158:   aload_0 
L159:   getfield [21] 
L162:   aload_1 
L163:   iload_2 
L164:   iload 4 
L166:   invokevirtual [25] 
L169:   istore 5 
L171:   iload 5 
L173:   iconst_m1 
L174:   if_icmpne L274 
L177:   iload 4 
L179:   iload_3 
L180:   if_icmpne L187 
L183:   iconst_m1 
L184:   goto L191 
L187:   iload_3 
L188:   iload 4 
L190:   isub 
L191:   areturn 
L192:   goto L274 
L195:   aload_0 
L196:   invokespecial [31] 
L199:   iconst_m1 
L200:   if_icmpne L218 
L203:   iload 4 
L205:   iload_3 
L206:   if_icmpne L213 
L209:   iconst_m1 
L210:   goto L217 
L213:   iload_3 
L214:   iload 4 
L216:   isub 
L217:   areturn 
L218:   aload_0 
L219:   getfield [19] 
L222:   aload_0 
L223:   getfield [20] 
L226:   isub 
L227:   iload 4 
L229:   if_icmplt L237 
L232:   iload 4 
L234:   goto L246 
L237:   aload_0 
L238:   getfield [19] 
L241:   aload_0 
L242:   getfield [20] 
L245:   isub 
L246:   istore 5 
L248:   aload_0 
L249:   getfield [18] 
L252:   aload_0 
L253:   getfield [20] 
L256:   aload_1 
L257:   iload_2 
L258:   iload 5 
L260:   invokestatic [12] 
L263:   aload_0 
L264:   dup 
L265:   getfield [20] 
L268:   iload 5 
L270:   iadd 
L271:   putfield [39] 
L274:   iload 4 
L276:   iload 5 
L278:   isub 
L279:   istore 4 
L281:   iload 4 
L283:   ifne L288 
L286:   iload_3 
L287:   areturn 
L288:   aload_0 
L289:   getfield [21] 
L292:   invokevirtual [22] 
L295:   ifne L303 
L298:   iload_3 
L299:   iload 4 
L301:   isub 
L302:   areturn 
L303:   iload_2 
L304:   iload 5 
L306:   iadd 
L307:   istore_2 
L308:   goto L140 
L311:   new [41] 
L314:   dup 
L315:   invokespecial [32] 
L318:   athrow 
L319:   aload_0 
L320:   getfield [18] 
L323:   ifnonnull L339 
L326:   new [37] 
L329:   dup 
L330:   ldc [9] 
L332:   invokestatic [7] 
L335:   invokespecial [29] 
L338:   athrow 
L339:   new [42] 
L342:   dup 
L343:   ldc [15] 
L345:   invokestatic [7] 
L348:   invokespecial [33] 
L351:   athrow 
L352:   
    .end code 
.end method 

.method public synchronized [213] : [214] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     iconst_m1 
L5:     if_icmpeq L42 
L8:     aload_0 
L9:     getfield [18] 
L12:    ifnull L26 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [17] 
L20:    putfield [39] 
L23:    goto L55 
L26:    new [37] 
L29:    dup 
L30:    ldc [9] 
L32:    invokestatic [7] 
L35:    invokespecial [29] 
L38:    athrow 
L39:    goto L55 
L42:    new [37] 
L45:    dup 
L46:    ldc [16] 
L48:    invokestatic [7] 
L51:    invokespecial [29] 
L54:    athrow 
L55:    return 
L56:    
    .end code 
.end method 

.method public synchronized [215] : [216] 
    .attribute [194] .code stack 7 locals 2 
L0:     lload_1 
L1:     lconst_1 
L2:     lcmp 
L3:     ifge L8 
L6:     lconst_0 
L7:     return 
L8:     aload_0 
L9:     getfield [19] 
L12:    aload_0 
L13:    getfield [20] 
L16:    isub 
L17:    i2l 
L18:    lload_1 
L19:    lcmp 
L20:    iflt L37 
L23:    aload_0 
L24:    dup 
L25:    getfield [20] 
L28:    i2l 
L29:    lload_1 
L30:    ladd 
L31:    l2i 
L32:    putfield [39] 
L35:    lload_1 
L36:    return 
L37:    aload_0 
L38:    getfield [19] 
L41:    aload_0 
L42:    getfield [20] 
L45:    isub 
L46:    i2l 
L47:    lstore_3 
L48:    aload_0 
L49:    aload_0 
L50:    getfield [19] 
L53:    putfield [39] 
L56:    aload_0 
L57:    getfield [17] 
L60:    iconst_m1 
L61:    if_icmpeq L145 
L64:    lload_1 
L65:    aload_0 
L66:    getfield [23] 
L69:    i2l 
L70:    lcmp 
L71:    ifgt L140 
L74:    aload_0 
L75:    invokespecial [31] 
L78:    iconst_m1 
L79:    if_icmpne L84 
L82:    lload_3 
L83:    return 
L84:    aload_0 
L85:    getfield [19] 
L88:    aload_0 
L89:    getfield [20] 
L92:    isub 
L93:    i2l 
L94:    lload_1 
L95:    lload_3 
L96:    lsub 
L97:    lcmp 
L98:    iflt L117 
L101:   aload_0 
L102:   dup 
L103:   getfield [20] 
L106:   i2l 
L107:   lload_1 
L108:   lload_3 
L109:   lsub 
L110:   ladd 
L111:   l2i 
L112:   putfield [39] 
L115:   lload_1 
L116:   return 
L117:   lload_3 
L118:   aload_0 
L119:   getfield [19] 
L122:   aload_0 
L123:   getfield [20] 
L126:   isub 
L127:   i2l 
L128:   ladd 
L129:   lstore_3 
L130:   aload_0 
L131:   aload_0 
L132:   getfield [19] 
L135:   putfield [39] 
L138:   lload_3 
L139:   return 
L140:   aload_0 
L141:   iconst_m1 
L142:   putfield [34] 
L145:   lload_3 
L146:   aload_0 
L147:   getfield [21] 
L150:   lload_1 
L151:   lload_3 
L152:   lsub 
L153:   invokevirtual [26] 
L156:   ladd 
L157:   return 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Class [44] 
.const [4] = Class [45] 
.const [5] = String [46] 
.const [6] = Class [47] 
.const [7] = Method [48] [49] 
.const [8] = Class [50] 
.const [9] = String [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Method [54] [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = String [58] 
.const [16] = String [59] 
.const [17] = Field [60] [61] 
.const [18] = Field [62] [63] 
.const [19] = Field [64] [65] 
.const [20] = Field [66] [67] 
.const [21] = Field [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Field [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Field [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = Class [98] 
.const [37] = Class [99] 
.const [38] = Field [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Field [104] [105] 
.const [41] = Class [106] 
.const [42] = Class [107] 
.const [43] = Utf8 java/io/BufferedInputStream 
.const [44] = Utf8 java/io/FilterInputStream 
.const [45] = Utf8 java/lang/IllegalArgumentException 
.const [46] = Utf8 K0058 
.const [47] = Utf8 com/ibm/oti/util/Msg 
.const [48] = Class [108] 
.const [49] = NameAndType [109] [110] 
.const [50] = Utf8 java/io/IOException 
.const [51] = Utf8 K0059 
.const [52] = Utf8 java/io/InputStream 
.const [53] = Utf8 java/lang/System 
.const [54] = Class [111] 
.const [55] = NameAndType [112] [113] 
.const [56] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [57] = Utf8 java/lang/NullPointerException 
.const [58] = Utf8 K0047 
.const [59] = Utf8 K005a 
.const [60] = Class [114] 
.const [61] = NameAndType [115] [116] 
.const [62] = Class [117] 
.const [63] = NameAndType [118] [119] 
.const [64] = Class [120] 
.const [65] = NameAndType [121] [122] 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Class [126] 
.const [69] = NameAndType [127] [128] 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Class [150] 
.const [85] = NameAndType [151] [152] 
.const [86] = Class [153] 
.const [87] = NameAndType [154] [155] 
.const [88] = Class [156] 
.const [89] = NameAndType [157] [158] 
.const [90] = Class [159] 
.const [91] = NameAndType [160] [161] 
.const [92] = Class [162] 
.const [93] = NameAndType [163] [164] 
.const [94] = Class [165] 
.const [95] = NameAndType [166] [167] 
.const [96] = Class [168] 
.const [97] = NameAndType [169] [170] 
.const [98] = Utf8 java/lang/IllegalArgumentException 
.const [99] = Utf8 java/io/IOException 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [107] = Utf8 java/lang/NullPointerException 
.const [108] = Utf8 com/ibm/oti/util/Msg 
.const [109] = Utf8 getString 
.const [110] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [111] = Utf8 java/lang/System 
.const [112] = Utf8 arraycopy 
.const [113] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [114] = Utf8 java/io/BufferedInputStream 
.const [115] = Utf8 markpos 
.const [116] = Utf8 I 
.const [117] = Utf8 java/io/BufferedInputStream 
.const [118] = Utf8 buf 
.const [119] = Utf8 [B 
.const [120] = Utf8 java/io/BufferedInputStream 
.const [121] = Utf8 count 
.const [122] = Utf8 I 
.const [123] = Utf8 java/io/BufferedInputStream 
.const [124] = Utf8 pos 
.const [125] = Utf8 I 
.const [126] = Utf8 java/io/BufferedInputStream 
.const [127] = Utf8 in 
.const [128] = Utf8 Ljava/io/InputStream; 
.const [129] = Utf8 java/io/InputStream 
.const [130] = Utf8 available 
.const [131] = Utf8 ()I 
.const [132] = Utf8 java/io/BufferedInputStream 
.const [133] = Utf8 marklimit 
.const [134] = Utf8 I 
.const [135] = Utf8 java/io/InputStream 
.const [136] = Utf8 read 
.const [137] = Utf8 ([B)I 
.const [138] = Utf8 java/io/InputStream 
.const [139] = Utf8 read 
.const [140] = Utf8 ([BII)I 
.const [141] = Utf8 java/io/InputStream 
.const [142] = Utf8 skip 
.const [143] = Utf8 (J)J 
.const [144] = Utf8 java/io/FilterInputStream 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Ljava/io/InputStream;)V 
.const [147] = Utf8 java/lang/IllegalArgumentException 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;)V 
.const [150] = Utf8 java/io/IOException 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Ljava/lang/String;)V 
.const [153] = Utf8 java/io/FilterInputStream 
.const [154] = Utf8 close 
.const [155] = Utf8 ()V 
.const [156] = Utf8 java/io/BufferedInputStream 
.const [157] = Utf8 fillbuf 
.const [158] = Utf8 ()I 
.const [159] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 java/lang/NullPointerException 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;)V 
.const [165] = Utf8 java/io/BufferedInputStream 
.const [166] = Utf8 markpos 
.const [167] = Utf8 I 
.const [168] = Utf8 java/io/BufferedInputStream 
.const [169] = Utf8 buf 
.const [170] = Utf8 [B 
.const [171] = Utf8 java/io/BufferedInputStream 
.const [172] = Utf8 count 
.const [173] = Utf8 I 
.const [174] = Utf8 java/io/BufferedInputStream 
.const [175] = Utf8 pos 
.const [176] = Utf8 I 
.const [177] = Utf8 java/io/BufferedInputStream 
.const [178] = Utf8 marklimit 
.const [179] = Utf8 I 
.const [180] = Utf8 java/io/BufferedInputStream 
.const [181] = Class [180] 
.const [182] = Utf8 java/io/FilterInputStream 
.const [183] = Class [182] 
.const [184] = Utf8 buf 
.const [185] = Utf8 [B 
.const [186] = Utf8 count 
.const [187] = Utf8 I 
.const [188] = Utf8 marklimit 
.const [189] = Utf8 I 
.const [190] = Utf8 markpos 
.const [191] = Utf8 I 
.const [192] = Utf8 pos 
.const [193] = Utf8 I 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Ljava/io/InputStream;)V 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/io/InputStream;I)V 
.const [199] = Utf8 available 
.const [200] = Utf8 ()I 
.const [201] = Utf8 close 
.const [202] = Utf8 ()V 
.const [203] = Utf8 fillbuf 
.const [204] = Utf8 ()I 
.const [205] = Utf8 mark 
.const [206] = Utf8 (I)V 
.const [207] = Utf8 markSupported 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 read 
.const [210] = Utf8 ()I 
.const [211] = Utf8 read 
.const [212] = Utf8 ([BII)I 
.const [213] = Utf8 reset 
.const [214] = Utf8 ()V 
.const [215] = Utf8 skip 
.const [216] = Utf8 (J)J 
.end class 
