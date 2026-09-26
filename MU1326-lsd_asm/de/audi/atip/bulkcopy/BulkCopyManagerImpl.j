.version 50 0 
.class public super [469] 
.super [471] 
.implements [473] 
.implements [475] 
.field private final [476] [477] 
.field private [478] [479] 
.field private final [480] [481] 
.field private [482] [483] 
.field private volatile [484] [485] 
.field private [486] [487] 
.field private volatile [488] [489] 
.field private volatile [490] [491] 

.method public [493] : [494] 
    .attribute [492] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [87] 
L4:     aload_0 
L5:     new [99] 
L8:     dup 
L9:     invokespecial [87] 
L12:    putfield [100] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [101] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [102] 
L25:    aload_0 
L26:    new [103] 
L29:    dup 
L30:    invokespecial [88] 
L33:    putfield [104] 
L36:    aload_0 
L37:    aconst_null 
L38:    putfield [105] 
L41:    aload_0 
L42:    iconst_0 
L43:    putfield [106] 
L46:    aload_0 
L47:    aload_2 
L48:    putfield [107] 
L51:    aload_0 
L52:    aload_3 
L53:    putfield [108] 
L56:    aload_0 
L57:    getfield [69] 
L60:    ldc [4] 
L62:    ldc [5] 
L64:    aload_1 
L65:    aload_2 
L66:    aload_3 
L67:    invokevirtual [71] 
L70:    aconst_null 
L71:    aload_1 
L72:    if_acmpeq L86 
L75:    new [109] 
L78:    dup 
L79:    aload_0 
L80:    aload_1 
L81:    aload_2 
L82:    invokespecial [89] 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [495] : [496] 
    .attribute [492] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [69] 
L4:     ldc [4] 
L6:     ldc [7] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [72] 
L14:    pop 
L15:    aload_0 
L16:    getfield [63] 
L19:    dup 
L20:    astore_3 
L21:    monitorenter 
        .catch [0] from L22 to L165 using L168 
L22:    iload_2 
L23:    lookupswitch 
            3 : L48 
            4 : L48 
            default : L120 

L48:    aload_0 
L49:    getfield [66] 
L52:    aload_1 
L53:    invokeinterface [110] 0 
L58:    checkcast [8] 
L61:    astore 4 
L63:    aconst_null 
L64:    aload 4 
L66:    if_acmpeq L78 
L69:    iconst_1 
L70:    aload 4 
L72:    invokevirtual [73] 
L75:    if_icmpne L110 
L78:    aload_0 
L79:    getfield [66] 
L82:    aload_1 
L83:    new [111] 
L86:    dup 
L87:    iload_2 
L88:    invokespecial [90] 
L91:    invokeinterface [112] 0 
L96:    pop 
L97:    iconst_3 
L98:    iload_2 
L99:    if_icmpne L152 
L102:   aload_0 
L103:   aload_1 
L104:   putfield [105] 
L107:   goto L152 
L110:   new [113] 
L113:   dup 
L114:   ldc [10] 
L116:   invokespecial [91] 
L119:   athrow 
L120:   new [113] 
L123:   dup 
L124:   new [114] 
L127:   dup 
L128:   invokespecial [92] 
L131:   ldc [12] 
L133:   invokevirtual [74] 
L136:   iload_2 
L137:   invokevirtual [75] 
L140:   ldc [13] 
L142:   invokevirtual [74] 
L145:   invokevirtual [76] 
L148:   invokespecial [91] 
L151:   athrow 
L152:   aload_0 
L153:   aload_1 
L154:   invokeinterface [115] 0 
L159:   invokespecial [93] 
L162:   pop 
L163:   aload_3 
L164:   monitorexit 
L165:   goto L175 
        .catch [0] from L168 to L172 using L168 
L168:   astore 5 
L170:   aload_3 
L171:   monitorexit 
L172:   aload 5 
L174:   athrow 
L175:   return 
L176:   
    .end code 
.end method 

.method public [497] : [498] 
    .attribute [492] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [69] 
L4:     ldc [4] 
L6:     ldc [14] 
L8:     aload_1 
L9:     invokevirtual [77] 
L12:    pop 
L13:    aload_0 
L14:    getfield [63] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
        .catch [0] from L20 to L36 using L109 
L20:    aload_0 
L21:    getfield [66] 
L24:    aload_1 
L25:    invokeinterface [116] 0 
L30:    ifne L37 
L33:    iconst_0 
L34:    aload_2 
L35:    monitorexit 
L36:    areturn 
        .catch [0] from L37 to L48 using L109 
L37:    aload_1 
L38:    aload_0 
L39:    getfield [67] 
L42:    if_acmpne L49 
L45:    iconst_1 
L46:    aload_2 
L47:    monitorexit 
L48:    areturn 
        .catch [0] from L49 to L103 using L109 
L49:    aconst_null 
L50:    aload_0 
L51:    getfield [67] 
L54:    if_acmpne L104 
L57:    iconst_4 
L58:    aload_0 
L59:    getfield [68] 
L62:    if_icmpne L104 
L65:    aload_0 
L66:    aload_1 
L67:    putfield [105] 
L70:    aload_0 
L71:    getfield [66] 
L74:    aload_1 
L75:    new [111] 
L78:    dup 
L79:    iconst_3 
L80:    invokespecial [90] 
L83:    invokeinterface [112] 0 
L88:    pop 
L89:    aload_0 
L90:    aload_1 
L91:    invokeinterface [115] 0 
L96:    invokespecial [93] 
L99:    pop 
L100:   iconst_1 
L101:   aload_2 
L102:   monitorexit 
L103:   areturn 
        .catch [0] from L104 to L106 using L109 
L104:   aload_2 
L105:   monitorexit 
L106:   goto L114 
        .catch [0] from L109 to L112 using L109 
L109:   astore_3 
L110:   aload_2 
L111:   monitorexit 
L112:   aload_3 
L113:   athrow 
L114:   iconst_0 
L115:   areturn 
L116:   
    .end code 
.end method 

.method public [499] : [500] 
    .attribute [492] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [69] 
L4:     ldc [4] 
L6:     ldc [15] 
L8:     aload_1 
L9:     invokevirtual [77] 
L12:    pop 
L13:    aload_0 
L14:    getfield [63] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
        .catch [0] from L20 to L36 using L88 
L20:    aload_0 
L21:    getfield [66] 
L24:    aload_1 
L25:    invokeinterface [116] 0 
L30:    ifne L37 
L33:    iconst_0 
L34:    aload_2 
L35:    monitorexit 
L36:    areturn 
        .catch [0] from L37 to L83 using L88 
L37:    aload_0 
L38:    getfield [67] 
L41:    aload_1 
L42:    if_acmpne L84 
L45:    aload_0 
L46:    aconst_null 
L47:    putfield [105] 
L50:    aload_0 
L51:    getfield [66] 
L54:    aload_1 
L55:    new [111] 
L58:    dup 
L59:    iconst_4 
L60:    invokespecial [90] 
L63:    invokeinterface [112] 0 
L68:    pop 
L69:    aload_0 
L70:    aload_1 
L71:    invokeinterface [115] 0 
L76:    invokespecial [93] 
L79:    pop 
L80:    iconst_1 
L81:    aload_2 
L82:    monitorexit 
L83:    areturn 
        .catch [0] from L84 to L87 using L88 
L84:    iconst_0 
L85:    aload_2 
L86:    monitorexit 
L87:    areturn 
        .catch [0] from L88 to L91 using L88 
L88:    astore_3 
L89:    aload_2 
L90:    monitorexit 
L91:    aload_3 
L92:    athrow 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [501] : [502] 
    .attribute [492] .code stack 2 locals 0 
L0:     iconst_4 
L1:     aload_0 
L2:     getfield [68] 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [503] : [504] 
    .attribute [492] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [66] 
L4:     invokeinterface [117] 0 
L9:     invokeinterface [118] 0 
L14:    astore_1 
L15:    aload_1 
L16:    invokeinterface [119] 0 
L21:    ifeq L66 
L24:    aload_1 
L25:    invokeinterface [120] 0 
L30:    checkcast [16] 
L33:    astore_2 
L34:    aload_0 
L35:    getfield [66] 
L38:    aload_2 
L39:    invokeinterface [110] 0 
L44:    checkcast [8] 
L47:    astore_3 
L48:    aconst_null 
L49:    aload_3 
L50:    if_acmpeq L63 
L53:    iconst_1 
L54:    aload_3 
L55:    invokevirtual [73] 
L58:    if_icmpne L63 
L61:    iconst_1 
L62:    areturn 
L63:    goto L15 
L66:    iconst_0 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public [505] : [506] 
    .attribute [492] .code stack 3 locals 2 
L0:     new [121] 
L3:     dup 
L4:     invokespecial [94] 
L7:     astore_1 
L8:     new [122] 
L11:    dup 
L12:    aload_1 
L13:    invokespecial [95] 
L16:    astore_2 
L17:    aload_0 
L18:    aload_2 
L19:    ldc [19] 
L21:    invokevirtual [78] 
L24:    aload_2 
L25:    invokevirtual [79] 
L28:    aload_1 
L29:    invokevirtual [80] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [507] : [508] 
    .attribute [492] .code stack 5 locals 5 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_0 
L6:     areturn 
L7:     aload_0 
L8:     getfield [63] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L37 using L164 
L14:    aload_1 
L15:    invokeinterface [115] 0 
L20:    istore_3 
L21:    aload_0 
L22:    getfield [66] 
L25:    aload_1 
L26:    invokeinterface [116] 0 
L31:    ifeq L38 
L34:    iconst_1 
L35:    aload_2 
L36:    monitorexit 
L37:    areturn 
        .catch [0] from L38 to L163 using L164 
L38:    aload_0 
L39:    getfield [66] 
L42:    invokeinterface [117] 0 
L47:    invokeinterface [118] 0 
L52:    astore 4 
L54:    aload 4 
L56:    invokeinterface [119] 0 
L61:    ifeq L122 
L64:    aload 4 
L66:    invokeinterface [120] 0 
L71:    checkcast [16] 
L74:    astore 5 
L76:    aload 5 
L78:    invokeinterface [115] 0 
L83:    iload_3 
L84:    if_icmpne L119 
L87:    new [113] 
L90:    dup 
L91:    new [114] 
L94:    dup 
L95:    invokespecial [92] 
L98:    ldc [20] 
L100:   invokevirtual [74] 
L103:   iload_3 
L104:   invokevirtual [75] 
L107:   ldc [21] 
L109:   invokevirtual [74] 
L112:   invokevirtual [76] 
L115:   invokespecial [91] 
L118:   athrow 
L119:   goto L54 
L122:   aload_0 
L123:   getfield [66] 
L126:   aload_1 
L127:   new [111] 
L130:   dup 
L131:   iconst_1 
L132:   invokespecial [90] 
L135:   invokeinterface [112] 0 
L140:   pop 
L141:   aload_0 
L142:   iload_3 
L143:   invokespecial [93] 
L146:   ifne L160 
L149:   aload_1 
L150:   aload_0 
L151:   getfield [68] 
L154:   iload_3 
L155:   invokeinterface [123] 0 
L160:   iconst_1 
L161:   aload_2 
L162:   monitorexit 
L163:   areturn 
        .catch [0] from L164 to L168 using L164 
L164:   astore 6 
L166:   aload_2 
L167:   monitorexit 
L168:   aload 6 
L170:   athrow 
L171:   nop 
L172:   
    .end code 
.end method 

.method public [509] : [510] 
    .attribute [492] .code stack 3 locals 3 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_0 
L6:     areturn 
L7:     aload_0 
L8:     getfield [63] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L38 using L62 
L14:    aload_1 
L15:    invokeinterface [115] 0 
L20:    istore_3 
L21:    aconst_null 
L22:    aload_0 
L23:    getfield [66] 
L26:    aload_1 
L27:    invokeinterface [124] 0 
L32:    if_acmpne L39 
L35:    iconst_0 
L36:    aload_2 
L37:    monitorexit 
L38:    areturn 
        .catch [0] from L39 to L61 using L62 
L39:    aload_0 
L40:    getfield [67] 
L43:    aload_1 
L44:    if_acmpne L52 
L47:    aload_0 
L48:    aconst_null 
L49:    putfield [105] 
L52:    aload_0 
L53:    iload_3 
L54:    invokespecial [93] 
L57:    pop 
L58:    iconst_1 
L59:    aload_2 
L60:    monitorexit 
L61:    areturn 
        .catch [0] from L62 to L66 using L62 
L62:    astore 4 
L64:    aload_2 
L65:    monitorexit 
L66:    aload 4 
L68:    athrow 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method interface [511] : [512] 
    .attribute [492] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [68] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [513] : [514] 
    .attribute [492] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [67] 
L5:     if_acmpeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method interface [515] : [516] 
    .attribute [492] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [65] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [517] : [518] 
    .attribute [492] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [64] 
L4:     iload_1 
L5:     if_icmpeq L19 
L8:     aload_0 
L9:     iload_1 
L10:    putfield [101] 
L13:    aload_0 
L14:    iconst_m1 
L15:    invokespecial [93] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [519] : [520] 
    .attribute [492] .code stack 5 locals 3 
L0:     aload_1 
L1:     ldc [22] 
L3:     invokevirtual [81] 
L6:     aload_1 
L7:     ldc [23] 
L9:     invokevirtual [81] 
L12:    aload_1 
L13:    ldc [24] 
L15:    invokevirtual [81] 
L18:    aload_1 
L19:    invokevirtual [82] 
L22:    aload_1 
L23:    ldc [25] 
L25:    invokevirtual [81] 
L28:    aload_1 
L29:    ldc [26] 
L31:    invokevirtual [83] 
L34:    iconst_0 
L35:    istore_3 
L36:    iload_3 
L37:    aload_0 
L38:    getfield [70] 
L41:    arraylength 
L42:    if_icmpge L97 
L45:    aload_1 
L46:    new [114] 
L49:    dup 
L50:    invokespecial [92] 
L53:    aload_0 
L54:    getfield [70] 
L57:    iload_3 
L58:    iaload 
L59:    invokevirtual [75] 
L62:    ldc [27] 
L64:    invokevirtual [74] 
L67:    aload_0 
L68:    aload_0 
L69:    getfield [70] 
L72:    iload_3 
L73:    iaload 
L74:    invokespecial [96] 
L77:    invokevirtual [74] 
L80:    ldc [28] 
L82:    invokevirtual [74] 
L85:    invokevirtual [76] 
L88:    invokevirtual [83] 
L91:    iinc 3 1 
L94:    goto L36 
L97:    aload_1 
L98:    invokevirtual [82] 
L101:   aload_1 
L102:   new [114] 
L105:   dup 
L106:   invokespecial [92] 
L109:   ldc [29] 
L111:   invokevirtual [74] 
L114:   aload_0 
L115:   getfield [68] 
L118:   invokevirtual [75] 
L121:   ldc [27] 
L123:   invokevirtual [74] 
L126:   aload_0 
L127:   aload_0 
L128:   getfield [68] 
L131:   invokespecial [97] 
L134:   invokevirtual [74] 
L137:   ldc [30] 
L139:   invokevirtual [74] 
L142:   invokevirtual [76] 
L145:   invokevirtual [81] 
L148:   aload_1 
L149:   new [114] 
L152:   dup 
L153:   invokespecial [92] 
L156:   ldc [31] 
L158:   invokevirtual [74] 
L161:   aload_0 
L162:   getfield [67] 
L165:   invokevirtual [84] 
L168:   invokevirtual [76] 
L171:   invokevirtual [81] 
L174:   aload_1 
L175:   new [114] 
L178:   dup 
L179:   invokespecial [92] 
L182:   ldc [32] 
L184:   invokevirtual [74] 
L187:   aload_0 
L188:   getfield [64] 
L191:   ifeq L199 
L194:   ldc [33] 
L196:   goto L201 
L199:   ldc [34] 
L201:   invokevirtual [74] 
L204:   invokevirtual [76] 
L207:   invokevirtual [81] 
L210:   aload_1 
L211:   new [114] 
L214:   dup 
L215:   invokespecial [92] 
L218:   ldc [35] 
L220:   invokevirtual [74] 
L223:   aload_0 
L224:   getfield [65] 
L227:   ifeq L235 
L230:   ldc [36] 
L232:   goto L237 
L235:   ldc [37] 
L237:   invokevirtual [74] 
L240:   invokevirtual [76] 
L243:   invokevirtual [81] 
L246:   aload_1 
L247:   invokevirtual [82] 
L250:   aload_1 
L251:   new [114] 
L254:   dup 
L255:   invokespecial [92] 
L258:   ldc [38] 
L260:   invokevirtual [74] 
L263:   aload_0 
L264:   getfield [66] 
L267:   invokeinterface [117] 0 
L272:   invokeinterface [125] 0 
L277:   invokevirtual [75] 
L280:   ldc [39] 
L282:   invokevirtual [74] 
L285:   invokevirtual [76] 
L288:   invokevirtual [81] 
L291:   aload_0 
L292:   getfield [66] 
L295:   invokeinterface [117] 0 
L300:   invokeinterface [118] 0 
L305:   astore_3 
L306:   aload_3 
L307:   invokeinterface [119] 0 
L312:   ifeq L430 
L315:   aload_3 
L316:   invokeinterface [120] 0 
L321:   checkcast [16] 
L324:   astore 4 
L326:   aload_0 
L327:   getfield [66] 
L330:   aload 4 
L332:   invokeinterface [110] 0 
L337:   checkcast [8] 
L340:   invokevirtual [73] 
L343:   istore 5 
L345:   aload_1 
L346:   new [114] 
L349:   dup 
L350:   invokespecial [92] 
L353:   ldc [40] 
L355:   invokevirtual [74] 
L358:   aload 4 
L360:   invokeinterface [115] 0 
L365:   invokevirtual [75] 
L368:   ldc [27] 
L370:   invokevirtual [74] 
L373:   aload_0 
L374:   aload 4 
L376:   invokeinterface [115] 0 
L381:   invokespecial [96] 
L384:   invokevirtual [74] 
L387:   ldc [41] 
L389:   invokevirtual [74] 
L392:   iload 5 
L394:   invokevirtual [75] 
L397:   ldc [27] 
L399:   invokevirtual [74] 
L402:   aload_0 
L403:   iload 5 
L405:   invokespecial [97] 
L408:   invokevirtual [74] 
L411:   ldc [42] 
L413:   invokevirtual [74] 
L416:   aload 4 
L418:   invokevirtual [84] 
L421:   invokevirtual [76] 
L424:   invokevirtual [81] 
L427:   goto L306 
L430:   return 
L431:   nop 
L432:   
    .end code 
.end method 

.method public [521] : [522] 
    .attribute [492] .code stack 1 locals 0 
L0:     ldc [43] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [523] : [524] 
    .attribute [492] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [66] 
L4:     invokeinterface [117] 0 
L9:     invokeinterface [118] 0 
L14:    astore_3 
L15:    aload_3 
L16:    invokeinterface [119] 0 
L21:    ifeq L47 
L24:    aload_3 
L25:    invokeinterface [120] 0 
L30:    checkcast [16] 
L33:    astore 4 
L35:    aload 4 
L37:    iload_1 
L38:    iload_2 
L39:    invokeinterface [123] 0 
L44:    goto L15 
L47:    return 
L48:    
    .end code 
.end method 

.method private [525] : [526] 
    .attribute [492] .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield [69] 
L4:     ldc [4] 
L6:     ldc [44] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [85] 
L13:    pop 
L14:    iconst_4 
L15:    istore_2 
L16:    aload_0 
L17:    getfield [66] 
L20:    invokeinterface [117] 0 
L25:    invokeinterface [118] 0 
L30:    astore_3 
L31:    aload_3 
L32:    invokeinterface [119] 0 
L37:    ifeq L158 
L40:    aload_3 
L41:    invokeinterface [120] 0 
L46:    checkcast [16] 
L49:    astore 4 
L51:    aload_0 
L52:    getfield [66] 
L55:    aload 4 
L57:    invokeinterface [110] 0 
L62:    checkcast [8] 
L65:    astore 5 
L67:    aload 5 
L69:    invokevirtual [73] 
L72:    tableswitch 1 
            L119 
            L139 
            L104 
            L136 
            default : L139 

L104:   iconst_4 
L105:   iload_2 
L106:   if_icmpeq L114 
L109:   iconst_2 
L110:   iload_2 
L111:   if_icmpne L155 
L114:   iconst_3 
L115:   istore_2 
L116:   goto L155 
L119:   aload_0 
L120:   getfield [64] 
L123:   ifne L155 
L126:   iconst_4 
L127:   iload_2 
L128:   if_icmpne L155 
L131:   iconst_2 
L132:   istore_2 
L133:   goto L155 
L136:   goto L155 
L139:   aload_0 
L140:   getfield [69] 
L143:   sipush 10000 
L146:   ldc [45] 
L148:   aload 4 
L150:   aload 5 
L152:   invokevirtual [86] 
L155:   goto L31 
L158:   iconst_1 
L159:   istore 4 
L161:   iconst_0 
L162:   istore 5 
L164:   aload_0 
L165:   getfield [70] 
L168:   arraylength 
L169:   istore 6 
L171:   iload 5 
L173:   iload 6 
L175:   if_icmpge L270 
L178:   aload_0 
L179:   getfield [66] 
L182:   invokeinterface [117] 0 
L187:   invokeinterface [118] 0 
L192:   astore 7 
L194:   aload 7 
L196:   invokeinterface [119] 0 
L201:   ifeq L239 
L204:   aload 7 
L206:   invokeinterface [120] 0 
L211:   checkcast [16] 
L214:   astore 8 
L216:   aload 8 
L218:   invokeinterface [115] 0 
L223:   aload_0 
L224:   getfield [70] 
L227:   iload 5 
L229:   iaload 
L230:   if_icmpne L236 
L233:   goto L264 
L236:   goto L194 
L239:   aload_0 
L240:   getfield [64] 
L243:   ifne L258 
L246:   iconst_3 
L247:   iload_2 
L248:   if_icmpeq L258 
L251:   iconst_2 
L252:   iload_2 
L253:   if_icmpeq L258 
L256:   iconst_2 
L257:   istore_2 
L258:   iconst_0 
L259:   istore 4 
L261:   goto L270 
L264:   iinc 5 1 
L267:   goto L171 
L270:   aload_0 
L271:   iload 4 
L273:   putfield [102] 
L276:   aload_0 
L277:   getfield [68] 
L280:   iload_2 
L281:   if_icmpeq L311 
L284:   aload_0 
L285:   getfield [69] 
L288:   ldc [46] 
L290:   ldc [47] 
L292:   iload_2 
L293:   i2l 
L294:   invokevirtual [85] 
L297:   pop 
L298:   aload_0 
L299:   iload_2 
L300:   putfield [106] 
L303:   aload_0 
L304:   iload_2 
L305:   iload_1 
L306:   invokespecial [98] 
L309:   iconst_1 
L310:   areturn 
L311:   aload_0 
L312:   getfield [69] 
L315:   ldc [46] 
L317:   ldc [48] 
L319:   aload_0 
L320:   getfield [68] 
L323:   i2l 
L324:   invokevirtual [85] 
L327:   pop 
L328:   iconst_0 
L329:   areturn 
L330:   nop 
L331:   nop 
L332:   
    .end code 
.end method 

.method private [527] : [528] 
    .attribute [492] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L36 
            L39 
            L42 
            L45 
            L48 
            default : L51 

L36:    ldc [49] 
L38:    areturn 
L39:    ldc [50] 
L41:    areturn 
L42:    ldc [51] 
L44:    areturn 
L45:    ldc [52] 
L47:    areturn 
L48:    ldc [53] 
L50:    areturn 
L51:    ldc [54] 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [529] : [530] 
    .attribute [492] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch -1 
            L38 
            L41 
            L32 
            L35 
            default : L41 

L32:    ldc [55] 
L34:    areturn 
L35:    ldc [56] 
L37:    areturn 
L38:    ldc [57] 
L40:    areturn 
L41:    ldc [54] 
L43:    areturn 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [126] 
.const [3] = Class [127] 
.const [4] = Int 1078071040 
.const [5] = String [128] 
.const [6] = Class [129] 
.const [7] = String [130] 
.const [8] = Class [131] 
.const [9] = Class [132] 
.const [10] = String [133] 
.const [11] = Class [134] 
.const [12] = String [135] 
.const [13] = String [136] 
.const [14] = String [137] 
.const [15] = String [138] 
.const [16] = Class [139] 
.const [17] = Class [140] 
.const [18] = Class [141] 
.const [19] = String [142] 
.const [20] = String [143] 
.const [21] = String [144] 
.const [22] = String [145] 
.const [23] = String [146] 
.const [24] = String [147] 
.const [25] = String [148] 
.const [26] = String [149] 
.const [27] = String [150] 
.const [28] = String [151] 
.const [29] = String [152] 
.const [30] = String [153] 
.const [31] = String [154] 
.const [32] = String [155] 
.const [33] = String [156] 
.const [34] = String [157] 
.const [35] = String [158] 
.const [36] = String [159] 
.const [37] = String [160] 
.const [38] = String [161] 
.const [39] = String [162] 
.const [40] = String [163] 
.const [41] = String [164] 
.const [42] = String [165] 
.const [43] = String [166] 
.const [44] = String [167] 
.const [45] = String [168] 
.const [46] = Int -2137614336 
.const [47] = String [169] 
.const [48] = String [170] 
.const [49] = String [171] 
.const [50] = String [172] 
.const [51] = String [173] 
.const [52] = String [174] 
.const [53] = String [175] 
.const [54] = String [176] 
.const [55] = String [177] 
.const [56] = String [178] 
.const [57] = String [179] 
.const [58] = Class [180] 
.const [59] = Class [181] 
.const [60] = Class [182] 
.const [61] = Class [183] 
.const [62] = Class [184] 
.const [63] = Field [185] [186] 
.const [64] = Field [187] [188] 
.const [65] = Field [189] [190] 
.const [66] = Field [191] [192] 
.const [67] = Field [193] [194] 
.const [68] = Field [195] [196] 
.const [69] = Field [197] [198] 
.const [70] = Field [199] [200] 
.const [71] = Method [201] [202] 
.const [72] = Method [203] [204] 
.const [73] = Method [205] [206] 
.const [74] = Method [207] [208] 
.const [75] = Method [209] [210] 
.const [76] = Method [211] [212] 
.const [77] = Method [213] [214] 
.const [78] = Method [215] [216] 
.const [79] = Method [217] [218] 
.const [80] = Method [219] [220] 
.const [81] = Method [221] [222] 
.const [82] = Method [223] [224] 
.const [83] = Method [225] [226] 
.const [84] = Method [227] [228] 
.const [85] = Method [229] [230] 
.const [86] = Method [231] [232] 
.const [87] = Method [233] [234] 
.const [88] = Method [235] [236] 
.const [89] = Method [237] [238] 
.const [90] = Method [239] [240] 
.const [91] = Method [241] [242] 
.const [92] = Method [243] [244] 
.const [93] = Method [245] [246] 
.const [94] = Method [247] [248] 
.const [95] = Method [249] [250] 
.const [96] = Method [251] [252] 
.const [97] = Method [253] [254] 
.const [98] = Method [255] [256] 
.const [99] = Class [257] 
.const [100] = Field [258] [259] 
.const [101] = Field [260] [261] 
.const [102] = Field [262] [263] 
.const [103] = Class [264] 
.const [104] = Field [265] [266] 
.const [105] = Field [267] [268] 
.const [106] = Field [269] [270] 
.const [107] = Field [271] [272] 
.const [108] = Field [273] [274] 
.const [109] = Class [275] 
.const [110] = InterfaceMethod [276] [277] 
.const [111] = Class [278] 
.const [112] = InterfaceMethod [279] [280] 
.const [113] = Class [281] 
.const [114] = Class [282] 
.const [115] = InterfaceMethod [283] [284] 
.const [116] = InterfaceMethod [285] [286] 
.const [117] = InterfaceMethod [287] [288] 
.const [118] = InterfaceMethod [289] [290] 
.const [119] = InterfaceMethod [291] [292] 
.const [120] = InterfaceMethod [293] [294] 
.const [121] = Class [295] 
.const [122] = Class [296] 
.const [123] = InterfaceMethod [297] [298] 
.const [124] = InterfaceMethod [299] [300] 
.const [125] = InterfaceMethod [301] [302] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 java/util/HashMap 
.const [128] = Utf8 '[BulkCopyManagerImpl] <init>(framework=%1, log=%2, waiting[]=%3)' 
.const [129] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [130] = Utf8 '[BulkCopyManagerImpl] setClientState(client=%1, state=%2)' 
.const [131] = Utf8 java/lang/Integer 
.const [132] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [133] = Utf8 'State already set by client! Can not set twice!' 
.const [134] = Utf8 java/lang/StringBuffer 
.const [135] = Utf8 'State ' 
.const [136] = Utf8 ' denied!' 
.const [137] = Utf8 '[BulkCopyManagerImpl] lock(client=%1)' 
.const [138] = Utf8 '[BulkCopyManagerImpl] unlock(client=%1)' 
.const [139] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [140] = Utf8 java/io/ByteArrayOutputStream 
.const [141] = Utf8 java/io/PrintStream 
.const [142] = Utf8 '' 
.const [143] = Utf8 'BulkCopyClient with type=' 
.const [144] = Utf8 ' already exists!' 
.const [145] = Utf8 ' ## Legend ##' 
.const [146] = Utf8 ' ClientTypes: 1: SWDL, 2: MEDIA, ..., 0xFFFFFFFF: SURVEILLANT' 
.const [147] = Utf8 ' KnownStates: 0: UNINITIALIZED, 1: REGISTERED, 2: WAITING, 3: BUSY, 4: IDLE' 
.const [148] = Utf8 ' ## Internal State ##' 
.const [149] = Utf8 ' waiting : ' 
.const [150] = Utf8 ( 
.const [151] = Utf8 '), ' 
.const [152] = Utf8 ' state     : ' 
.const [153] = Utf8 ')' 
.const [154] = Utf8 ' lock      : ' 
.const [155] = Utf8 ' ignore    : ' 
.const [156] = Utf8 '!!!yes - ignore waiting list!!!' 
.const [157] = Utf8 no 
.const [158] = Utf8 ' registered: ' 
.const [159] = Utf8 yes 
.const [160] = Utf8 '!!!no - waiting for clients yet!!!' 
.const [161] = Utf8 ' ## Registered Clients (' 
.const [162] = Utf8 ') ##' 
.const [163] = Utf8 ' type=' 
.const [164] = Utf8 '), state=' 
.const [165] = Utf8 '), name=' 
.const [166] = Utf8 BulkCopyManager 
.const [167] = Utf8 '[BulkCopyManagerImpl] updateState(%1)' 
.const [168] = Utf8 '[BulkCopyManagerImpl] Invalid client state: %1 -> %2' 
.const [169] = Utf8 '[BulkCopyManagerImpl] change state to %1' 
.const [170] = Utf8 '[BulkCopyManagerImpl] state not changed (old=%1)' 
.const [171] = Utf8 UNINITIALIZED 
.const [172] = Utf8 REGISTERED 
.const [173] = Utf8 WAITING 
.const [174] = Utf8 BUSY 
.const [175] = Utf8 IDLE 
.const [176] = Utf8 '?' 
.const [177] = Utf8 SWDL 
.const [178] = Utf8 MEDIA 
.const [179] = Utf8 SURVEILLANT 
.const [180] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 java/util/Map 
.const [183] = Utf8 java/util/Set 
.const [184] = Utf8 java/util/Iterator 
.const [185] = Class [303] 
.const [186] = NameAndType [304] [305] 
.const [187] = Class [306] 
.const [188] = NameAndType [307] [308] 
.const [189] = Class [309] 
.const [190] = NameAndType [310] [311] 
.const [191] = Class [312] 
.const [192] = NameAndType [313] [314] 
.const [193] = Class [315] 
.const [194] = NameAndType [316] [317] 
.const [195] = Class [318] 
.const [196] = NameAndType [319] [320] 
.const [197] = Class [321] 
.const [198] = NameAndType [322] [323] 
.const [199] = Class [324] 
.const [200] = NameAndType [325] [326] 
.const [201] = Class [327] 
.const [202] = NameAndType [328] [329] 
.const [203] = Class [330] 
.const [204] = NameAndType [331] [332] 
.const [205] = Class [333] 
.const [206] = NameAndType [334] [335] 
.const [207] = Class [336] 
.const [208] = NameAndType [337] [338] 
.const [209] = Class [339] 
.const [210] = NameAndType [340] [341] 
.const [211] = Class [342] 
.const [212] = NameAndType [343] [344] 
.const [213] = Class [345] 
.const [214] = NameAndType [346] [347] 
.const [215] = Class [348] 
.const [216] = NameAndType [349] [350] 
.const [217] = Class [351] 
.const [218] = NameAndType [352] [353] 
.const [219] = Class [354] 
.const [220] = NameAndType [355] [356] 
.const [221] = Class [357] 
.const [222] = NameAndType [358] [359] 
.const [223] = Class [360] 
.const [224] = NameAndType [361] [362] 
.const [225] = Class [363] 
.const [226] = NameAndType [364] [365] 
.const [227] = Class [366] 
.const [228] = NameAndType [367] [368] 
.const [229] = Class [369] 
.const [230] = NameAndType [370] [371] 
.const [231] = Class [372] 
.const [232] = NameAndType [373] [374] 
.const [233] = Class [375] 
.const [234] = NameAndType [376] [377] 
.const [235] = Class [378] 
.const [236] = NameAndType [379] [380] 
.const [237] = Class [381] 
.const [238] = NameAndType [382] [383] 
.const [239] = Class [384] 
.const [240] = NameAndType [385] [386] 
.const [241] = Class [387] 
.const [242] = NameAndType [388] [389] 
.const [243] = Class [390] 
.const [244] = NameAndType [391] [392] 
.const [245] = Class [393] 
.const [246] = NameAndType [394] [395] 
.const [247] = Class [396] 
.const [248] = NameAndType [397] [398] 
.const [249] = Class [399] 
.const [250] = NameAndType [400] [401] 
.const [251] = Class [402] 
.const [252] = NameAndType [403] [404] 
.const [253] = Class [405] 
.const [254] = NameAndType [406] [407] 
.const [255] = Class [408] 
.const [256] = NameAndType [409] [410] 
.const [257] = Utf8 java/lang/Object 
.const [258] = Class [411] 
.const [259] = NameAndType [412] [413] 
.const [260] = Class [414] 
.const [261] = NameAndType [415] [416] 
.const [262] = Class [417] 
.const [263] = NameAndType [418] [419] 
.const [264] = Utf8 java/util/HashMap 
.const [265] = Class [420] 
.const [266] = NameAndType [421] [422] 
.const [267] = Class [423] 
.const [268] = NameAndType [424] [425] 
.const [269] = Class [426] 
.const [270] = NameAndType [427] [428] 
.const [271] = Class [429] 
.const [272] = NameAndType [430] [431] 
.const [273] = Class [432] 
.const [274] = NameAndType [433] [434] 
.const [275] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [276] = Class [435] 
.const [277] = NameAndType [436] [437] 
.const [278] = Utf8 java/lang/Integer 
.const [279] = Class [438] 
.const [280] = NameAndType [439] [440] 
.const [281] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [282] = Utf8 java/lang/StringBuffer 
.const [283] = Class [441] 
.const [284] = NameAndType [442] [443] 
.const [285] = Class [444] 
.const [286] = NameAndType [445] [446] 
.const [287] = Class [447] 
.const [288] = NameAndType [448] [449] 
.const [289] = Class [450] 
.const [290] = NameAndType [451] [452] 
.const [291] = Class [453] 
.const [292] = NameAndType [454] [455] 
.const [293] = Class [456] 
.const [294] = NameAndType [457] [458] 
.const [295] = Utf8 java/io/ByteArrayOutputStream 
.const [296] = Utf8 java/io/PrintStream 
.const [297] = Class [459] 
.const [298] = NameAndType [460] [461] 
.const [299] = Class [462] 
.const [300] = NameAndType [463] [464] 
.const [301] = Class [465] 
.const [302] = NameAndType [466] [467] 
.const [303] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [304] = Utf8 m_syncer 
.const [305] = Utf8 Ljava/lang/Object; 
.const [306] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [307] = Utf8 m_ignoreWaitingClients 
.const [308] = Utf8 Z 
.const [309] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [310] = Utf8 m_areAllWaitingClientsRegistered 
.const [311] = Utf8 Z 
.const [312] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [313] = Utf8 m_clients 
.const [314] = Utf8 Ljava/util/Map; 
.const [315] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [316] = Utf8 m_locked 
.const [317] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyClient; 
.const [318] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [319] = Utf8 m_state 
.const [320] = Utf8 I 
.const [321] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [322] = Utf8 m_log 
.const [323] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [324] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [325] = Utf8 m_waiting 
.const [326] = Utf8 [I 
.const [327] = Utf8 de/audi/atip/log/LogChannel 
.const [328] = Utf8 log 
.const [329] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [330] = Utf8 de/audi/atip/log/LogChannel 
.const [331] = Utf8 log 
.const [332] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [333] = Utf8 java/lang/Integer 
.const [334] = Utf8 intValue 
.const [335] = Utf8 ()I 
.const [336] = Utf8 java/lang/StringBuffer 
.const [337] = Utf8 append 
.const [338] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [339] = Utf8 java/lang/StringBuffer 
.const [340] = Utf8 append 
.const [341] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [342] = Utf8 java/lang/StringBuffer 
.const [343] = Utf8 toString 
.const [344] = Utf8 ()Ljava/lang/String; 
.const [345] = Utf8 de/audi/atip/log/LogChannel 
.const [346] = Utf8 log 
.const [347] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [348] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [349] = Utf8 dump 
.const [350] = Utf8 (Ljava/io/PrintStream;Ljava/lang/String;)V 
.const [351] = Utf8 java/io/PrintStream 
.const [352] = Utf8 flush 
.const [353] = Utf8 ()V 
.const [354] = Utf8 java/io/ByteArrayOutputStream 
.const [355] = Utf8 toString 
.const [356] = Utf8 ()Ljava/lang/String; 
.const [357] = Utf8 java/io/PrintStream 
.const [358] = Utf8 println 
.const [359] = Utf8 (Ljava/lang/String;)V 
.const [360] = Utf8 java/io/PrintStream 
.const [361] = Utf8 println 
.const [362] = Utf8 ()V 
.const [363] = Utf8 java/io/PrintStream 
.const [364] = Utf8 print 
.const [365] = Utf8 (Ljava/lang/String;)V 
.const [366] = Utf8 java/lang/StringBuffer 
.const [367] = Utf8 append 
.const [368] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [369] = Utf8 de/audi/atip/log/LogChannel 
.const [370] = Utf8 log 
.const [371] = Utf8 (ILjava/lang/String;J)Z 
.const [372] = Utf8 de/audi/atip/log/LogChannel 
.const [373] = Utf8 log 
.const [374] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [375] = Utf8 java/lang/Object 
.const [376] = Utf8 <init> 
.const [377] = Utf8 ()V 
.const [378] = Utf8 java/util/HashMap 
.const [379] = Utf8 <init> 
.const [380] = Utf8 ()V 
.const [381] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [382] = Utf8 <init> 
.const [383] = Utf8 (Lde/audi/atip/bulkcopy/BulkCopyManagerImpl;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;)V 
.const [384] = Utf8 java/lang/Integer 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (I)V 
.const [387] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [388] = Utf8 <init> 
.const [389] = Utf8 (Ljava/lang/String;)V 
.const [390] = Utf8 java/lang/StringBuffer 
.const [391] = Utf8 <init> 
.const [392] = Utf8 ()V 
.const [393] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [394] = Utf8 updateState 
.const [395] = Utf8 (I)Z 
.const [396] = Utf8 java/io/ByteArrayOutputStream 
.const [397] = Utf8 <init> 
.const [398] = Utf8 ()V 
.const [399] = Utf8 java/io/PrintStream 
.const [400] = Utf8 <init> 
.const [401] = Utf8 (Ljava/io/OutputStream;)V 
.const [402] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [403] = Utf8 type2String 
.const [404] = Utf8 (I)Ljava/lang/String; 
.const [405] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [406] = Utf8 state2String 
.const [407] = Utf8 (I)Ljava/lang/String; 
.const [408] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [409] = Utf8 notifyClients 
.const [410] = Utf8 (II)V 
.const [411] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [412] = Utf8 m_syncer 
.const [413] = Utf8 Ljava/lang/Object; 
.const [414] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [415] = Utf8 m_ignoreWaitingClients 
.const [416] = Utf8 Z 
.const [417] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [418] = Utf8 m_areAllWaitingClientsRegistered 
.const [419] = Utf8 Z 
.const [420] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [421] = Utf8 m_clients 
.const [422] = Utf8 Ljava/util/Map; 
.const [423] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [424] = Utf8 m_locked 
.const [425] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyClient; 
.const [426] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [427] = Utf8 m_state 
.const [428] = Utf8 I 
.const [429] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [430] = Utf8 m_log 
.const [431] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [432] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [433] = Utf8 m_waiting 
.const [434] = Utf8 [I 
.const [435] = Utf8 java/util/Map 
.const [436] = Utf8 get 
.const [437] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [438] = Utf8 java/util/Map 
.const [439] = Utf8 put 
.const [440] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [441] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [442] = Utf8 getClientType 
.const [443] = Utf8 ()I 
.const [444] = Utf8 java/util/Map 
.const [445] = Utf8 containsKey 
.const [446] = Utf8 (Ljava/lang/Object;)Z 
.const [447] = Utf8 java/util/Map 
.const [448] = Utf8 keySet 
.const [449] = Utf8 ()Ljava/util/Set; 
.const [450] = Utf8 java/util/Set 
.const [451] = Utf8 iterator 
.const [452] = Utf8 ()Ljava/util/Iterator; 
.const [453] = Utf8 java/util/Iterator 
.const [454] = Utf8 hasNext 
.const [455] = Utf8 ()Z 
.const [456] = Utf8 java/util/Iterator 
.const [457] = Utf8 next 
.const [458] = Utf8 ()Ljava/lang/Object; 
.const [459] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [460] = Utf8 onChangeStateBulkCopy 
.const [461] = Utf8 (II)V 
.const [462] = Utf8 java/util/Map 
.const [463] = Utf8 remove 
.const [464] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [465] = Utf8 java/util/Set 
.const [466] = Utf8 size 
.const [467] = Utf8 ()I 
.const [468] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [469] = Class [468] 
.const [470] = Utf8 java/lang/Object 
.const [471] = Class [470] 
.const [472] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [473] = Class [472] 
.const [474] = Utf8 de/esolutions/fw/util/commons/error/DumpInfoProvider 
.const [475] = Class [474] 
.const [476] = Utf8 m_log 
.const [477] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [478] = Utf8 m_syncer 
.const [479] = Utf8 Ljava/lang/Object; 
.const [480] = Utf8 m_waiting 
.const [481] = Utf8 [I 
.const [482] = Utf8 m_ignoreWaitingClients 
.const [483] = Utf8 Z 
.const [484] = Utf8 m_areAllWaitingClientsRegistered 
.const [485] = Utf8 Z 
.const [486] = Utf8 m_clients 
.const [487] = Utf8 Ljava/util/Map; 
.const [488] = Utf8 m_locked 
.const [489] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyClient; 
.const [490] = Utf8 m_state 
.const [491] = Utf8 I 
.const [492] = Utf8 Code 
.const [493] = Utf8 <init> 
.const [494] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;[I)V 
.const [495] = Utf8 setClientState 
.const [496] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;I)V 
.const [497] = Utf8 lock 
.const [498] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [499] = Utf8 unlock 
.const [500] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [501] = Utf8 isIdle 
.const [502] = Utf8 ()Z 
.const [503] = Utf8 isAnyClientInRegisteredState 
.const [504] = Utf8 ()Z 
.const [505] = Utf8 toString 
.const [506] = Utf8 ()Ljava/lang/String; 
.const [507] = Utf8 registerClient 
.const [508] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [509] = Utf8 unregisterClient 
.const [510] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [511] = Utf8 getInternalState 
.const [512] = Utf8 ()I 
.const [513] = Utf8 isLocked 
.const [514] = Utf8 ()Z 
.const [515] = Utf8 areAllWaitingClientsRegistered 
.const [516] = Utf8 ()Z 
.const [517] = Utf8 setIgnoreWaitingClients 
.const [518] = Utf8 (Z)V 
.const [519] = Utf8 dump 
.const [520] = Utf8 (Ljava/io/PrintStream;Ljava/lang/String;)V 
.const [521] = Utf8 getName 
.const [522] = Utf8 ()Ljava/lang/String; 
.const [523] = Utf8 notifyClients 
.const [524] = Utf8 (II)V 
.const [525] = Utf8 updateState 
.const [526] = Utf8 (I)Z 
.const [527] = Utf8 state2String 
.const [528] = Utf8 (I)Ljava/lang/String; 
.const [529] = Utf8 type2String 
.const [530] = Utf8 (I)Ljava/lang/String; 
.end class 
