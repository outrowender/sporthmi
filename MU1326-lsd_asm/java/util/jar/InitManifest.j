.version 50 0 
.class super [469] 
.super [471] 
.field private static final [472] [473] 
.field private [474] [475] 
.field private [476] [477] 
.field private [478] [479] 
.field private [480] [481] 
.field private [482] [483] 
.field private [484] [485] 
.field private [486] [487] 
.field private [488] [489] 
.field private [490] [491] 

.method static [493] : [494] 
    .attribute [492] .code stack 1 locals 0 
L0:     invokestatic [5] 
L3:     putstatic [65] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [495] : [496] 
    .attribute [492] .code stack 4 locals 6 
L0:     aload_0 
L1:     invokespecial [66] 
L4:     aload_0 
L5:     sipush 1024 
L8:     newarray byte 
L10:    putfield [82] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [83] 
L18:    aload_0 
L19:    iconst_0 
L20:    putfield [84] 
L23:    aload_0 
L24:    iconst_5 
L25:    newarray byte 
L27:    putfield [85] 
L30:    aload_0 
L31:    iconst_0 
L32:    newarray char 
L34:    putfield [86] 
L37:    aload_0 
L38:    new [87] 
L41:    dup 
L42:    sipush 256 
L45:    invokespecial [67] 
L48:    putfield [88] 
L51:    aload_0 
L52:    new [89] 
L55:    dup 
L56:    invokespecial [68] 
L59:    putfield [90] 
L62:    aload_0 
L63:    new [91] 
L66:    dup 
L67:    ldc [11] 
L69:    invokespecial [69] 
L72:    invokestatic [13] 
L75:    checkcast [14] 
L78:    putfield [93] 
L81:    ldc [15] 
L83:    aload_0 
L84:    getfield [46] 
L87:    invokevirtual [47] 
L90:    ifeq L98 
L93:    aload_0 
L94:    aconst_null 
L95:    putfield [93] 
L98:    aload_2 
L99:    astore 6 
L101:   new [94] 
L104:   dup 
L105:   invokespecial [70] 
L108:   astore 7 
L110:   aload_0 
L111:   aload_1 
L112:   aload 7 
L114:   invokespecial [71] 
L117:   pop 
L118:   aload 7 
L120:   invokevirtual [48] 
L123:   astore 8 
L125:   goto L144 
L128:   aload_0 
L129:   aload 8 
L131:   invokeinterface [95] 0 
L136:   checkcast [14] 
L139:   aload 6 
L141:   invokespecial [72] 
L144:   aload 8 
L146:   invokeinterface [96] 0 
L151:   ifne L128 
L154:   aload 5 
L156:   ifnull L183 
L159:   aload_2 
L160:   aload 5 
L162:   invokevirtual [49] 
L165:   ifnonnull L183 
L168:   new [81] 
L171:   dup 
L172:   ldc [19] 
L174:   aload 5 
L176:   invokestatic [21] 
L179:   invokespecial [73] 
L182:   athrow 
L183:   aload 7 
L185:   invokevirtual [50] 
L188:   aconst_null 
L189:   checkcast [22] 
L192:   astore 9 
L194:   goto L344 
L197:   aload 7 
L199:   invokevirtual [48] 
L202:   astore 8 
L204:   aload 8 
L206:   invokeinterface [95] 0 
L211:   checkcast [14] 
L214:   astore 10 
L216:   aload 10 
L218:   invokevirtual [51] 
L221:   bipush 7 
L223:   if_icmplt L244 
L226:   aload 10 
L228:   iconst_0 
L229:   iconst_5 
L230:   invokevirtual [52] 
L233:   invokevirtual [53] 
L236:   ldc [23] 
L238:   invokevirtual [47] 
L241:   ifne L257 
L244:   new [81] 
L247:   dup 
L248:   ldc [24] 
L250:   invokestatic [25] 
L253:   invokespecial [73] 
L256:   athrow 
L257:   aload 10 
L259:   bipush 6 
L261:   aload 10 
L263:   invokevirtual [51] 
L266:   invokevirtual [52] 
L269:   astore 11 
L271:   new [97] 
L274:   dup 
L275:   bipush 12 
L277:   invokespecial [74] 
L280:   astore 6 
L282:   aload 4 
L284:   ifnull L299 
L287:   aload 4 
L289:   aload 11 
L291:   aload 9 
L293:   invokeinterface [98] 0 
L298:   pop 
L299:   aload_3 
L300:   aload 11 
L302:   aload 6 
L304:   invokeinterface [98] 0 
L309:   pop 
L310:   goto L329 
L313:   aload_0 
L314:   aload 8 
L316:   invokeinterface [95] 0 
L321:   checkcast [14] 
L324:   aload 6 
L326:   invokespecial [72] 
L329:   aload 8 
L331:   invokeinterface [96] 0 
L336:   ifne L313 
L339:   aload 7 
L341:   invokevirtual [50] 
L344:   aload 4 
L346:   ifnonnull L362 
L349:   aload_0 
L350:   aload_1 
L351:   aload 7 
L353:   invokespecial [71] 
L356:   ifne L197 
L359:   goto L375 
L362:   aload_0 
L363:   aload_1 
L364:   aload 7 
L366:   invokespecial [75] 
L369:   dup 
L370:   astore 9 
L372:   ifnonnull L197 
L375:   return 
L376:   
    .end code 
.end method 

.method private [497] : [498] 
    .attribute [492] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     ifnull L34 
L7:     aload_2 
L8:     new [92] 
L11:    dup 
L12:    aload_0 
L13:    getfield [42] 
L16:    iconst_0 
L17:    iload_1 
L18:    aload_0 
L19:    getfield [46] 
L22:    invokespecial [76] 
L25:    invokeinterface [99] 0 
L30:    pop 
L31:    goto L179 
L34:    aload_0 
L35:    getfield [54] 
L38:    ifnonnull L117 
        .catch [32] from L41 to L105 using L105 
L41:    getstatic [6] 
L44:    ifeq L66 
L47:    aload_2 
L48:    aload_0 
L49:    getfield [42] 
L52:    iconst_0 
L53:    iload_1 
L54:    invokestatic [29] 
L57:    invokeinterface [99] 0 
L62:    pop 
L63:    goto L117 
L66:    aload_0 
L67:    getfield [43] 
L70:    arraylength 
L71:    iload_1 
L72:    if_icmpge L82 
L75:    aload_0 
L76:    iload_1 
L77:    newarray char 
L79:    putfield [86] 
L82:    aload_2 
L83:    aload_0 
L84:    getfield [42] 
L87:    aload_0 
L88:    getfield [43] 
L91:    iconst_0 
L92:    iload_1 
L93:    invokestatic [30] 
L96:    invokeinterface [99] 0 
L101:   pop 
L102:   goto L117 
L105:   pop 
L106:   aload_0 
L107:   new [101] 
L110:   dup 
L111:   invokespecial [77] 
L114:   putfield [100] 
L117:   aload_0 
L118:   getfield [54] 
L121:   ifnull L179 
L124:   aload_0 
L125:   getfield [43] 
L128:   arraylength 
L129:   iload_1 
L130:   if_icmpge L140 
L133:   aload_0 
L134:   iload_1 
L135:   newarray char 
L137:   putfield [86] 
L140:   aload_0 
L141:   getfield [54] 
L144:   aload_0 
L145:   getfield [42] 
L148:   iconst_0 
L149:   aload_0 
L150:   getfield [43] 
L153:   iconst_0 
L154:   iload_1 
L155:   invokevirtual [55] 
L158:   pop 
L159:   aload_2 
L160:   new [92] 
L163:   dup 
L164:   aload_0 
L165:   getfield [43] 
L168:   iconst_0 
L169:   iload_1 
L170:   invokespecial [78] 
L173:   invokeinterface [99] 0 
L178:   pop 
L179:   return 
L180:   
    .end code 
.end method 

.method private [499] : [500] 
    .attribute [492] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [40] 
L4:     iconst_m1 
L5:     if_icmpne L10 
L8:     aconst_null 
L9:     areturn 
L10:    iconst_0 
L11:    istore 4 
L13:    iconst_0 
L14:    istore 5 
L16:    iconst_0 
L17:    istore 6 
L19:    aload_0 
L20:    getfield [44] 
L23:    invokevirtual [56] 
L26:    aload_0 
L27:    getfield [41] 
L30:    aload_0 
L31:    getfield [40] 
L34:    if_icmpne L91 
L37:    aload_0 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [39] 
L43:    invokevirtual [57] 
L46:    dup_x1 
L47:    putfield [83] 
L50:    iconst_m1 
L51:    if_icmpne L86 
L54:    aload_0 
L55:    getfield [44] 
L58:    invokevirtual [58] 
L61:    ifne L66 
L64:    aconst_null 
L65:    areturn 
L66:    iload 5 
L68:    ifeq L78 
L71:    aload_0 
L72:    iload 4 
L74:    aload_2 
L75:    invokespecial [79] 
L78:    aload_0 
L79:    getfield [44] 
L82:    invokevirtual [59] 
L85:    areturn 
L86:    aload_0 
L87:    iconst_0 
L88:    putfield [84] 
L91:    aload_0 
L92:    getfield [39] 
L95:    aload_0 
L96:    dup 
L97:    getfield [41] 
L100:   dup_x1 
L101:   iconst_1 
L102:   iadd 
L103:   putfield [84] 
L106:   baload 
L107:   istore_3 
L108:   iload 6 
L110:   ifeq L163 
L113:   iload_3 
L114:   bipush 10 
L116:   if_icmpeq L135 
L119:   aload_0 
L120:   dup 
L121:   getfield [41] 
L124:   iconst_1 
L125:   isub 
L126:   putfield [84] 
L129:   bipush 13 
L131:   istore_3 
L132:   goto L157 
L135:   aload_0 
L136:   getfield [44] 
L139:   invokevirtual [58] 
L142:   ifne L148 
L145:   goto L333 
L148:   aload_0 
L149:   getfield [44] 
L152:   bipush 13 
L154:   invokevirtual [60] 
L157:   iconst_0 
L158:   istore 6 
L160:   goto L175 
L163:   iload_3 
L164:   bipush 13 
L166:   if_icmpne L175 
L169:   iconst_1 
L170:   istore 6 
L172:   goto L333 
L175:   iload 5 
L177:   ifeq L235 
L180:   iload_3 
L181:   bipush 32 
L183:   if_icmpne L200 
L186:   aload_0 
L187:   getfield [44] 
L190:   iload_3 
L191:   invokevirtual [60] 
L194:   iconst_0 
L195:   istore 5 
L197:   goto L333 
L200:   aload_0 
L201:   iload 4 
L203:   aload_2 
L204:   invokespecial [79] 
L207:   iload_3 
L208:   bipush 10 
L210:   if_icmpne L229 
L213:   aload_0 
L214:   getfield [44] 
L217:   iload_3 
L218:   invokevirtual [60] 
L221:   aload_0 
L222:   getfield [44] 
L225:   invokevirtual [59] 
L228:   areturn 
L229:   iconst_0 
L230:   istore 4 
L232:   goto L268 
L235:   iload_3 
L236:   bipush 10 
L238:   if_icmpne L268 
L241:   aload_0 
L242:   getfield [44] 
L245:   invokevirtual [58] 
L248:   ifne L254 
L251:   goto L333 
L254:   aload_0 
L255:   getfield [44] 
L258:   iload_3 
L259:   invokevirtual [60] 
L262:   iconst_1 
L263:   istore 5 
L265:   goto L333 
L268:   iconst_0 
L269:   istore 5 
L271:   aload_0 
L272:   getfield [44] 
L275:   iload_3 
L276:   invokevirtual [60] 
L279:   iload 4 
L281:   aload_0 
L282:   getfield [42] 
L285:   arraylength 
L286:   if_icmpne L322 
L289:   aload_0 
L290:   getfield [42] 
L293:   arraylength 
L294:   iconst_2 
L295:   imul 
L296:   newarray byte 
L298:   astore 7 
L300:   aload_0 
L301:   getfield [42] 
L304:   iconst_0 
L305:   aload 7 
L307:   iconst_0 
L308:   aload_0 
L309:   getfield [42] 
L312:   arraylength 
L313:   invokestatic [35] 
L316:   aload_0 
L317:   aload 7 
L319:   putfield [85] 
L322:   aload_0 
L323:   getfield [42] 
L326:   iload 4 
L328:   iinc 4 1 
L331:   iload_3 
L332:   bastore 
L333:   goto L26 
L336:   
    .end code 
.end method 

.method private [501] : [502] 
    .attribute [492] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [40] 
L4:     iconst_m1 
L5:     if_icmpne L10 
L8:     iconst_0 
L9:     areturn 
L10:    iconst_0 
L11:    istore 4 
L13:    iconst_0 
L14:    istore 5 
L16:    iconst_0 
L17:    istore 6 
L19:    aload_0 
L20:    getfield [41] 
L23:    aload_0 
L24:    getfield [40] 
L27:    if_icmpne L77 
L30:    aload_0 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [39] 
L36:    invokevirtual [57] 
L39:    dup_x1 
L40:    putfield [83] 
L43:    iconst_m1 
L44:    if_icmpne L72 
L47:    iload 5 
L49:    ifeq L59 
L52:    aload_0 
L53:    iload 4 
L55:    aload_2 
L56:    invokespecial [79] 
L59:    aload_2 
L60:    invokeinterface [102] 0 
L65:    ifeq L70 
L68:    iconst_1 
L69:    areturn 
L70:    iconst_0 
L71:    areturn 
L72:    aload_0 
L73:    iconst_0 
L74:    putfield [84] 
L77:    aload_0 
L78:    getfield [39] 
L81:    aload_0 
L82:    dup 
L83:    getfield [41] 
L86:    dup_x1 
L87:    iconst_1 
L88:    iadd 
L89:    putfield [84] 
L92:    baload 
L93:    istore_3 
L94:    iload 6 
L96:    ifeq L124 
L99:    iload_3 
L100:   bipush 10 
L102:   if_icmpeq L118 
L105:   aload_0 
L106:   dup 
L107:   getfield [41] 
L110:   iconst_1 
L111:   isub 
L112:   putfield [84] 
L115:   bipush 13 
L117:   istore_3 
L118:   iconst_0 
L119:   istore 6 
L121:   goto L136 
L124:   iload_3 
L125:   bipush 13 
L127:   if_icmpne L136 
L130:   iconst_1 
L131:   istore 6 
L133:   goto L260 
L136:   iload 5 
L138:   ifeq L174 
L141:   iload_3 
L142:   bipush 32 
L144:   if_icmpne L153 
L147:   iconst_0 
L148:   istore 5 
L150:   goto L260 
L153:   aload_0 
L154:   iload 4 
L156:   aload_2 
L157:   invokespecial [79] 
L160:   iload_3 
L161:   bipush 10 
L163:   if_icmpne L168 
L166:   iconst_1 
L167:   areturn 
L168:   iconst_0 
L169:   istore 4 
L171:   goto L203 
L174:   iload_3 
L175:   bipush 10 
L177:   if_icmpne L203 
L180:   iload 4 
L182:   ifne L197 
L185:   aload_2 
L186:   invokeinterface [102] 0 
L191:   ifne L197 
L194:   goto L260 
L197:   iconst_1 
L198:   istore 5 
L200:   goto L260 
L203:   iconst_0 
L204:   istore 5 
L206:   iload 4 
L208:   aload_0 
L209:   getfield [42] 
L212:   arraylength 
L213:   if_icmpne L249 
L216:   aload_0 
L217:   getfield [42] 
L220:   arraylength 
L221:   iconst_2 
L222:   imul 
L223:   newarray byte 
L225:   astore 7 
L227:   aload_0 
L228:   getfield [42] 
L231:   iconst_0 
L232:   aload 7 
L234:   iconst_0 
L235:   aload_0 
L236:   getfield [42] 
L239:   arraylength 
L240:   invokestatic [35] 
L243:   aload_0 
L244:   aload 7 
L246:   putfield [85] 
L249:   aload_0 
L250:   getfield [42] 
L253:   iload 4 
L255:   iinc 4 1 
L258:   iload_3 
L259:   bastore 
L260:   goto L19 
L263:   nop 
L264:   
    .end code 
.end method 

.method private [503] : [504] 
    .attribute [492] .code stack 5 locals 4 
L0:     aload_1 
L1:     bipush 58 
L3:     invokevirtual [61] 
L6:     istore 4 
L8:     iload 4 
L10:    iconst_1 
L11:    if_icmpge L28 
L14:    new [81] 
L17:    dup 
L18:    ldc [36] 
L20:    aload_1 
L21:    invokestatic [21] 
L24:    invokespecial [73] 
L27:    athrow 
L28:    aload_1 
L29:    iconst_0 
L30:    iload 4 
L32:    invokevirtual [52] 
L35:    astore_3 
L36:    aload_0 
L37:    getfield [45] 
L40:    aload_3 
L41:    invokeinterface [103] 0 
L46:    checkcast [37] 
L49:    astore 5 
L51:    aload 5 
L53:    ifnonnull L97 
        .catch [38] from L56 to L69 using L69 
L56:    new [104] 
L59:    dup 
L60:    aload_3 
L61:    invokespecial [80] 
L64:    astore 5 
L66:    goto L84 
L69:    astore 6 
L71:    new [81] 
L74:    dup 
L75:    aload 6 
L77:    invokevirtual [62] 
L80:    invokespecial [73] 
L83:    athrow 
L84:    aload_0 
L85:    getfield [45] 
L88:    aload_3 
L89:    aload 5 
L91:    invokeinterface [98] 0 
L96:    pop 
L97:    iload 4 
L99:    iconst_1 
L100:   iadd 
L101:   aload_1 
L102:   invokevirtual [51] 
L105:   if_icmpge L121 
L108:   aload_1 
L109:   iload 4 
L111:   iconst_1 
L112:   iadd 
L113:   invokevirtual [63] 
L116:   bipush 32 
L118:   if_icmpeq L135 
L121:   new [81] 
L124:   dup 
L125:   ldc [36] 
L127:   aload_1 
L128:   invokestatic [21] 
L131:   invokespecial [73] 
L134:   athrow 
L135:   aload_2 
L136:   aload 5 
L138:   aload_1 
L139:   iload 4 
L141:   iconst_2 
L142:   iadd 
L143:   aload_1 
L144:   invokevirtual [51] 
L147:   invokevirtual [52] 
L150:   invokevirtual [64] 
L153:   pop 
L154:   return 
L155:   nop 
L156:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [105] 
.const [3] = Class [106] 
.const [4] = Class [107] 
.const [5] = Method [108] [109] 
.const [6] = Field [110] [111] 
.const [7] = Class [112] 
.const [8] = Class [113] 
.const [9] = Class [114] 
.const [10] = Class [115] 
.const [11] = String [116] 
.const [12] = Class [117] 
.const [13] = Method [118] [119] 
.const [14] = Class [120] 
.const [15] = String [121] 
.const [16] = Class [122] 
.const [17] = Class [123] 
.const [18] = Class [124] 
.const [19] = String [125] 
.const [20] = Class [126] 
.const [21] = Method [127] [128] 
.const [22] = Class [129] 
.const [23] = String [130] 
.const [24] = String [131] 
.const [25] = Method [132] [133] 
.const [26] = Class [134] 
.const [27] = Class [135] 
.const [28] = Class [136] 
.const [29] = Method [137] [138] 
.const [30] = Method [139] [140] 
.const [31] = Class [141] 
.const [32] = Class [142] 
.const [33] = Class [143] 
.const [34] = Class [144] 
.const [35] = Method [145] [146] 
.const [36] = String [147] 
.const [37] = Class [148] 
.const [38] = Class [149] 
.const [39] = Field [150] [151] 
.const [40] = Field [152] [153] 
.const [41] = Field [154] [155] 
.const [42] = Field [156] [157] 
.const [43] = Field [158] [159] 
.const [44] = Field [160] [161] 
.const [45] = Field [162] [163] 
.const [46] = Field [164] [165] 
.const [47] = Method [166] [167] 
.const [48] = Method [168] [169] 
.const [49] = Method [170] [171] 
.const [50] = Method [172] [173] 
.const [51] = Method [174] [175] 
.const [52] = Method [176] [177] 
.const [53] = Method [178] [179] 
.const [54] = Field [180] [181] 
.const [55] = Method [182] [183] 
.const [56] = Method [184] [185] 
.const [57] = Method [186] [187] 
.const [58] = Method [188] [189] 
.const [59] = Method [190] [191] 
.const [60] = Method [192] [193] 
.const [61] = Method [194] [195] 
.const [62] = Method [196] [197] 
.const [63] = Method [198] [199] 
.const [64] = Method [200] [201] 
.const [65] = Field [202] [203] 
.const [66] = Method [204] [205] 
.const [67] = Method [206] [207] 
.const [68] = Method [208] [209] 
.const [69] = Method [210] [211] 
.const [70] = Method [212] [213] 
.const [71] = Method [214] [215] 
.const [72] = Method [216] [217] 
.const [73] = Method [218] [219] 
.const [74] = Method [220] [221] 
.const [75] = Method [222] [223] 
.const [76] = Method [224] [225] 
.const [77] = Method [226] [227] 
.const [78] = Method [228] [229] 
.const [79] = Method [230] [231] 
.const [80] = Method [232] [233] 
.const [81] = Class [234] 
.const [82] = Field [235] [236] 
.const [83] = Field [237] [238] 
.const [84] = Field [239] [240] 
.const [85] = Field [241] [242] 
.const [86] = Field [243] [244] 
.const [87] = Class [245] 
.const [88] = Field [246] [247] 
.const [89] = Class [248] 
.const [90] = Field [249] [250] 
.const [91] = Class [251] 
.const [92] = Class [252] 
.const [93] = Field [253] [254] 
.const [94] = Class [255] 
.const [95] = InterfaceMethod [256] [257] 
.const [96] = InterfaceMethod [258] [259] 
.const [97] = Class [260] 
.const [98] = InterfaceMethod [261] [262] 
.const [99] = InterfaceMethod [263] [264] 
.const [100] = Field [265] [266] 
.const [101] = Class [267] 
.const [102] = InterfaceMethod [268] [269] 
.const [103] = InterfaceMethod [270] [271] 
.const [104] = Class [272] 
.const [105] = Utf8 java/util/jar/InitManifest 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 com/ibm/oti/vm/VM 
.const [108] = Class [273] 
.const [109] = NameAndType [274] [275] 
.const [110] = Class [276] 
.const [111] = NameAndType [277] [278] 
.const [112] = Utf8 java/io/IOException 
.const [113] = Utf8 java/io/ByteArrayOutputStream 
.const [114] = Utf8 java/util/HashMap 
.const [115] = Utf8 com/ibm/oti/util/PriviAction 
.const [116] = Utf8 'manifest.read.encoding' 
.const [117] = Utf8 java/security/AccessController 
.const [118] = Class [279] 
.const [119] = NameAndType [280] [281] 
.const [120] = Utf8 java/lang/String 
.const [121] = Utf8 '' 
.const [122] = Utf8 java/util/ArrayList 
.const [123] = Utf8 java/util/Iterator 
.const [124] = Utf8 java/util/jar/Attributes 
.const [125] = Utf8 K0009 
.const [126] = Utf8 com/ibm/oti/util/Msg 
.const [127] = Class [282] 
.const [128] = NameAndType [283] [284] 
.const [129] = Utf8 [B 
.const [130] = Utf8 'name:' 
.const [131] = Utf8 K000a 
.const [132] = Class [285] 
.const [133] = NameAndType [286] [287] 
.const [134] = Utf8 java/util/Map 
.const [135] = Utf8 java/util/List 
.const [136] = Utf8 com/ibm/oti/util/Util 
.const [137] = Class [288] 
.const [138] = NameAndType [289] [290] 
.const [139] = Class [291] 
.const [140] = NameAndType [292] [293] 
.const [141] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [142] = Utf8 java/io/UTFDataFormatException 
.const [143] = Utf8 java/io/InputStream 
.const [144] = Utf8 java/lang/System 
.const [145] = Class [294] 
.const [146] = NameAndType [295] [296] 
.const [147] = Utf8 K000b 
.const [148] = Utf8 java/util/jar/Attributes$Name 
.const [149] = Utf8 java/lang/IllegalArgumentException 
.const [150] = Class [297] 
.const [151] = NameAndType [298] [299] 
.const [152] = Class [300] 
.const [153] = NameAndType [301] [302] 
.const [154] = Class [303] 
.const [155] = NameAndType [304] [305] 
.const [156] = Class [306] 
.const [157] = NameAndType [307] [308] 
.const [158] = Class [309] 
.const [159] = NameAndType [310] [311] 
.const [160] = Class [312] 
.const [161] = NameAndType [313] [314] 
.const [162] = Class [315] 
.const [163] = NameAndType [316] [317] 
.const [164] = Class [318] 
.const [165] = NameAndType [319] [320] 
.const [166] = Class [321] 
.const [167] = NameAndType [322] [323] 
.const [168] = Class [324] 
.const [169] = NameAndType [325] [326] 
.const [170] = Class [327] 
.const [171] = NameAndType [328] [329] 
.const [172] = Class [330] 
.const [173] = NameAndType [331] [332] 
.const [174] = Class [333] 
.const [175] = NameAndType [334] [335] 
.const [176] = Class [336] 
.const [177] = NameAndType [337] [338] 
.const [178] = Class [339] 
.const [179] = NameAndType [340] [341] 
.const [180] = Class [342] 
.const [181] = NameAndType [343] [344] 
.const [182] = Class [345] 
.const [183] = NameAndType [346] [347] 
.const [184] = Class [348] 
.const [185] = NameAndType [349] [350] 
.const [186] = Class [351] 
.const [187] = NameAndType [352] [353] 
.const [188] = Class [354] 
.const [189] = NameAndType [355] [356] 
.const [190] = Class [357] 
.const [191] = NameAndType [358] [359] 
.const [192] = Class [360] 
.const [193] = NameAndType [361] [362] 
.const [194] = Class [363] 
.const [195] = NameAndType [364] [365] 
.const [196] = Class [366] 
.const [197] = NameAndType [367] [368] 
.const [198] = Class [369] 
.const [199] = NameAndType [370] [371] 
.const [200] = Class [372] 
.const [201] = NameAndType [373] [374] 
.const [202] = Class [375] 
.const [203] = NameAndType [376] [377] 
.const [204] = Class [378] 
.const [205] = NameAndType [379] [380] 
.const [206] = Class [381] 
.const [207] = NameAndType [382] [383] 
.const [208] = Class [384] 
.const [209] = NameAndType [385] [386] 
.const [210] = Class [387] 
.const [211] = NameAndType [388] [389] 
.const [212] = Class [390] 
.const [213] = NameAndType [391] [392] 
.const [214] = Class [393] 
.const [215] = NameAndType [394] [395] 
.const [216] = Class [396] 
.const [217] = NameAndType [397] [398] 
.const [218] = Class [399] 
.const [219] = NameAndType [400] [401] 
.const [220] = Class [402] 
.const [221] = NameAndType [403] [404] 
.const [222] = Class [405] 
.const [223] = NameAndType [406] [407] 
.const [224] = Class [408] 
.const [225] = NameAndType [409] [410] 
.const [226] = Class [411] 
.const [227] = NameAndType [412] [413] 
.const [228] = Class [414] 
.const [229] = NameAndType [415] [416] 
.const [230] = Class [417] 
.const [231] = NameAndType [418] [419] 
.const [232] = Class [420] 
.const [233] = NameAndType [421] [422] 
.const [234] = Utf8 java/io/IOException 
.const [235] = Class [423] 
.const [236] = NameAndType [424] [425] 
.const [237] = Class [426] 
.const [238] = NameAndType [427] [428] 
.const [239] = Class [429] 
.const [240] = NameAndType [430] [431] 
.const [241] = Class [432] 
.const [242] = NameAndType [433] [434] 
.const [243] = Class [435] 
.const [244] = NameAndType [436] [437] 
.const [245] = Utf8 java/io/ByteArrayOutputStream 
.const [246] = Class [438] 
.const [247] = NameAndType [439] [440] 
.const [248] = Utf8 java/util/HashMap 
.const [249] = Class [441] 
.const [250] = NameAndType [442] [443] 
.const [251] = Utf8 com/ibm/oti/util/PriviAction 
.const [252] = Utf8 java/lang/String 
.const [253] = Class [444] 
.const [254] = NameAndType [445] [446] 
.const [255] = Utf8 java/util/ArrayList 
.const [256] = Class [447] 
.const [257] = NameAndType [448] [449] 
.const [258] = Class [450] 
.const [259] = NameAndType [451] [452] 
.const [260] = Utf8 java/util/jar/Attributes 
.const [261] = Class [453] 
.const [262] = NameAndType [454] [455] 
.const [263] = Class [456] 
.const [264] = NameAndType [457] [458] 
.const [265] = Class [459] 
.const [266] = NameAndType [460] [461] 
.const [267] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [268] = Class [462] 
.const [269] = NameAndType [463] [464] 
.const [270] = Class [465] 
.const [271] = NameAndType [466] [467] 
.const [272] = Utf8 java/util/jar/Attributes$Name 
.const [273] = Utf8 com/ibm/oti/vm/VM 
.const [274] = Utf8 useNatives 
.const [275] = Utf8 ()Z 
.const [276] = Utf8 java/util/jar/InitManifest 
.const [277] = Utf8 useNative 
.const [278] = Utf8 Z 
.const [279] = Utf8 java/security/AccessController 
.const [280] = Utf8 doPrivileged 
.const [281] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [282] = Utf8 com/ibm/oti/util/Msg 
.const [283] = Utf8 getString 
.const [284] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String; 
.const [285] = Utf8 com/ibm/oti/util/Msg 
.const [286] = Utf8 getString 
.const [287] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [288] = Utf8 com/ibm/oti/util/Util 
.const [289] = Utf8 convertFromUTF8 
.const [290] = Utf8 ([BII)Ljava/lang/String; 
.const [291] = Utf8 com/ibm/oti/util/Util 
.const [292] = Utf8 convertUTF8WithBuf 
.const [293] = Utf8 ([B[CII)Ljava/lang/String; 
.const [294] = Utf8 java/lang/System 
.const [295] = Utf8 arraycopy 
.const [296] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [297] = Utf8 java/util/jar/InitManifest 
.const [298] = Utf8 inbuf 
.const [299] = Utf8 [B 
.const [300] = Utf8 java/util/jar/InitManifest 
.const [301] = Utf8 inbufCount 
.const [302] = Utf8 I 
.const [303] = Utf8 java/util/jar/InitManifest 
.const [304] = Utf8 inbufPos 
.const [305] = Utf8 I 
.const [306] = Utf8 java/util/jar/InitManifest 
.const [307] = Utf8 buffer 
.const [308] = Utf8 [B 
.const [309] = Utf8 java/util/jar/InitManifest 
.const [310] = Utf8 charbuf 
.const [311] = Utf8 [C 
.const [312] = Utf8 java/util/jar/InitManifest 
.const [313] = Utf8 out 
.const [314] = Utf8 Ljava/io/ByteArrayOutputStream; 
.const [315] = Utf8 java/util/jar/InitManifest 
.const [316] = Utf8 attributeNames 
.const [317] = Utf8 Ljava/util/Map; 
.const [318] = Utf8 java/util/jar/InitManifest 
.const [319] = Utf8 encoding 
.const [320] = Utf8 Ljava/lang/String; 
.const [321] = Utf8 java/lang/String 
.const [322] = Utf8 equals 
.const [323] = Utf8 (Ljava/lang/Object;)Z 
.const [324] = Utf8 java/util/ArrayList 
.const [325] = Utf8 iterator 
.const [326] = Utf8 ()Ljava/util/Iterator; 
.const [327] = Utf8 java/util/jar/Attributes 
.const [328] = Utf8 getValue 
.const [329] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [330] = Utf8 java/util/ArrayList 
.const [331] = Utf8 clear 
.const [332] = Utf8 ()V 
.const [333] = Utf8 java/lang/String 
.const [334] = Utf8 length 
.const [335] = Utf8 ()I 
.const [336] = Utf8 java/lang/String 
.const [337] = Utf8 substring 
.const [338] = Utf8 (II)Ljava/lang/String; 
.const [339] = Utf8 java/lang/String 
.const [340] = Utf8 toLowerCase 
.const [341] = Utf8 ()Ljava/lang/String; 
.const [342] = Utf8 java/util/jar/InitManifest 
.const [343] = Utf8 converter 
.const [344] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [345] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [346] = Utf8 convert 
.const [347] = Utf8 ([BI[CII)I 
.const [348] = Utf8 java/io/ByteArrayOutputStream 
.const [349] = Utf8 reset 
.const [350] = Utf8 ()V 
.const [351] = Utf8 java/io/InputStream 
.const [352] = Utf8 read 
.const [353] = Utf8 ([B)I 
.const [354] = Utf8 java/io/ByteArrayOutputStream 
.const [355] = Utf8 size 
.const [356] = Utf8 ()I 
.const [357] = Utf8 java/io/ByteArrayOutputStream 
.const [358] = Utf8 toByteArray 
.const [359] = Utf8 ()[B 
.const [360] = Utf8 java/io/ByteArrayOutputStream 
.const [361] = Utf8 write 
.const [362] = Utf8 (I)V 
.const [363] = Utf8 java/lang/String 
.const [364] = Utf8 indexOf 
.const [365] = Utf8 (I)I 
.const [366] = Utf8 java/lang/IllegalArgumentException 
.const [367] = Utf8 toString 
.const [368] = Utf8 ()Ljava/lang/String; 
.const [369] = Utf8 java/lang/String 
.const [370] = Utf8 charAt 
.const [371] = Utf8 (I)C 
.const [372] = Utf8 java/util/jar/Attributes 
.const [373] = Utf8 put 
.const [374] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [375] = Utf8 java/util/jar/InitManifest 
.const [376] = Utf8 useNative 
.const [377] = Utf8 Z 
.const [378] = Utf8 java/lang/Object 
.const [379] = Utf8 <init> 
.const [380] = Utf8 ()V 
.const [381] = Utf8 java/io/ByteArrayOutputStream 
.const [382] = Utf8 <init> 
.const [383] = Utf8 (I)V 
.const [384] = Utf8 java/util/HashMap 
.const [385] = Utf8 <init> 
.const [386] = Utf8 ()V 
.const [387] = Utf8 com/ibm/oti/util/PriviAction 
.const [388] = Utf8 <init> 
.const [389] = Utf8 (Ljava/lang/String;)V 
.const [390] = Utf8 java/util/ArrayList 
.const [391] = Utf8 <init> 
.const [392] = Utf8 ()V 
.const [393] = Utf8 java/util/jar/InitManifest 
.const [394] = Utf8 readLines 
.const [395] = Utf8 (Ljava/io/InputStream;Ljava/util/List;)Z 
.const [396] = Utf8 java/util/jar/InitManifest 
.const [397] = Utf8 addAttribute 
.const [398] = Utf8 (Ljava/lang/String;Ljava/util/jar/Attributes;)V 
.const [399] = Utf8 java/io/IOException 
.const [400] = Utf8 <init> 
.const [401] = Utf8 (Ljava/lang/String;)V 
.const [402] = Utf8 java/util/jar/Attributes 
.const [403] = Utf8 <init> 
.const [404] = Utf8 (I)V 
.const [405] = Utf8 java/util/jar/InitManifest 
.const [406] = Utf8 nextChunk 
.const [407] = Utf8 (Ljava/io/InputStream;Ljava/util/List;)[B 
.const [408] = Utf8 java/lang/String 
.const [409] = Utf8 <init> 
.const [410] = Utf8 ([BIILjava/lang/String;)V 
.const [411] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [412] = Utf8 <init> 
.const [413] = Utf8 ()V 
.const [414] = Utf8 java/lang/String 
.const [415] = Utf8 <init> 
.const [416] = Utf8 ([CII)V 
.const [417] = Utf8 java/util/jar/InitManifest 
.const [418] = Utf8 addLine 
.const [419] = Utf8 (ILjava/util/List;)V 
.const [420] = Utf8 java/util/jar/Attributes$Name 
.const [421] = Utf8 <init> 
.const [422] = Utf8 (Ljava/lang/String;)V 
.const [423] = Utf8 java/util/jar/InitManifest 
.const [424] = Utf8 inbuf 
.const [425] = Utf8 [B 
.const [426] = Utf8 java/util/jar/InitManifest 
.const [427] = Utf8 inbufCount 
.const [428] = Utf8 I 
.const [429] = Utf8 java/util/jar/InitManifest 
.const [430] = Utf8 inbufPos 
.const [431] = Utf8 I 
.const [432] = Utf8 java/util/jar/InitManifest 
.const [433] = Utf8 buffer 
.const [434] = Utf8 [B 
.const [435] = Utf8 java/util/jar/InitManifest 
.const [436] = Utf8 charbuf 
.const [437] = Utf8 [C 
.const [438] = Utf8 java/util/jar/InitManifest 
.const [439] = Utf8 out 
.const [440] = Utf8 Ljava/io/ByteArrayOutputStream; 
.const [441] = Utf8 java/util/jar/InitManifest 
.const [442] = Utf8 attributeNames 
.const [443] = Utf8 Ljava/util/Map; 
.const [444] = Utf8 java/util/jar/InitManifest 
.const [445] = Utf8 encoding 
.const [446] = Utf8 Ljava/lang/String; 
.const [447] = Utf8 java/util/Iterator 
.const [448] = Utf8 next 
.const [449] = Utf8 ()Ljava/lang/Object; 
.const [450] = Utf8 java/util/Iterator 
.const [451] = Utf8 hasNext 
.const [452] = Utf8 ()Z 
.const [453] = Utf8 java/util/Map 
.const [454] = Utf8 put 
.const [455] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [456] = Utf8 java/util/List 
.const [457] = Utf8 add 
.const [458] = Utf8 (Ljava/lang/Object;)Z 
.const [459] = Utf8 java/util/jar/InitManifest 
.const [460] = Utf8 converter 
.const [461] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [462] = Utf8 java/util/List 
.const [463] = Utf8 size 
.const [464] = Utf8 ()I 
.const [465] = Utf8 java/util/Map 
.const [466] = Utf8 get 
.const [467] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [468] = Utf8 java/util/jar/InitManifest 
.const [469] = Class [468] 
.const [470] = Utf8 java/lang/Object 
.const [471] = Class [470] 
.const [472] = Utf8 useNative 
.const [473] = Utf8 Z 
.const [474] = Utf8 inbuf 
.const [475] = Utf8 [B 
.const [476] = Utf8 inbufCount 
.const [477] = Utf8 I 
.const [478] = Utf8 inbufPos 
.const [479] = Utf8 I 
.const [480] = Utf8 buffer 
.const [481] = Utf8 [B 
.const [482] = Utf8 charbuf 
.const [483] = Utf8 [C 
.const [484] = Utf8 out 
.const [485] = Utf8 Ljava/io/ByteArrayOutputStream; 
.const [486] = Utf8 encoding 
.const [487] = Utf8 Ljava/lang/String; 
.const [488] = Utf8 converter 
.const [489] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [490] = Utf8 attributeNames 
.const [491] = Utf8 Ljava/util/Map; 
.const [492] = Utf8 Code 
.const [493] = Utf8 <clinit> 
.const [494] = Utf8 ()V 
.const [495] = Utf8 <init> 
.const [496] = Utf8 (Ljava/io/InputStream;Ljava/util/jar/Attributes;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V 
.const [497] = Utf8 addLine 
.const [498] = Utf8 (ILjava/util/List;)V 
.const [499] = Utf8 nextChunk 
.const [500] = Utf8 (Ljava/io/InputStream;Ljava/util/List;)[B 
.const [501] = Utf8 readLines 
.const [502] = Utf8 (Ljava/io/InputStream;Ljava/util/List;)Z 
.const [503] = Utf8 addAttribute 
.const [504] = Utf8 (Ljava/lang/String;Ljava/util/jar/Attributes;)V 
.end class 
