.version 50 0 
.class public super [388] 
.super [390] 
.implements [392] 
.implements [394] 
.field private static [395] [396] 
.field private static [397] [398] 
.field private static [399] [400] 
.field private static [401] [402] 
.field private static [403] [404] 
.field private [405] [406] 
.field private [407] [408] 
.field private [409] [410] 
.field private [411] [412] 
.field private [413] [414] 
.field private [415] [416] 
.field private [417] [418] 
.field private [419] [420] 
.field private [421] [422] 
.field private [423] [424] 

.method public [426] : [427] 
    .attribute [425] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [54] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [70] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [428] : [429] 
    .attribute [425] .code stack 4 locals 0 
L0:     iload_3 
L1:     ifeq L19 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [70] 
L9:     aload_0 
L10:    getstatic [2] 
L13:    putfield [71] 
L16:    goto L41 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [70] 
L24:    aload_0 
L25:    fload_1 
L26:    fload_2 
L27:    iload 4 
L29:    invokespecial [56] 
L32:    aload_0 
L33:    aload_0 
L34:    iconst_0 
L35:    invokespecial [57] 
L38:    putfield [71] 
L41:    aload_0 
L42:    fload_1 
L43:    putfield [72] 
L46:    aload_0 
L47:    fload_2 
L48:    putfield [73] 
L51:    aload_0 
L52:    fload_1 
L53:    putfield [74] 
L56:    aload_0 
L57:    aload_0 
L58:    invokevirtual [41] 
L61:    putfield [75] 
L64:    aload_0 
L65:    iconst_0 
L66:    putfield [76] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [430] : [431] 
    .attribute [425] .code stack 9 locals 10 
L0:     fload_2 
L1:     fload_1 
L2:     fsub 
L3:     invokestatic [3] 
L6:     f2i 
L7:     istore 4 
L9:     aload_0 
L10:    getfield [39] 
L13:    aload_0 
L14:    getfield [40] 
L17:    fsub 
L18:    invokestatic [3] 
L21:    f2i 
L22:    istore 5 
L24:    aload_0 
L25:    iload 4 
L27:    invokespecial [58] 
L30:    fstore 6 
L32:    getstatic [4] 
L35:    i2f 
L36:    fload 6 
L38:    fmul 
L39:    f2i 
L40:    istore 7 
L42:    getstatic [5] 
L45:    i2f 
L46:    fload 6 
L48:    fmul 
L49:    f2i 
L50:    istore 8 
L52:    iload 7 
L54:    iload 8 
L56:    iadd 
L57:    istore 9 
L59:    iload_3 
L60:    ifne L76 
L63:    aload_0 
L64:    iload 9 
L66:    iload 5 
L68:    iload 4 
L70:    invokespecial [61] 
L73:    ifeq L113 
L76:    aload_0 
L77:    iload 8 
L79:    putfield [77] 
L82:    aload_0 
L83:    iload 9 
L85:    putfield [78] 
L88:    getstatic [6] 
L91:    ldc [7] 
L93:    ldc [8] 
L95:    iload 4 
L97:    i2l 
L98:    iload 7 
L100:   i2l 
L101:   aload_0 
L102:   getfield [44] 
L105:   i2l 
L106:   invokevirtual [46] 
L109:   pop 
L110:   goto L195 
L113:   aload_0 
L114:   getfield [45] 
L117:   aload_0 
L118:   getfield [44] 
L121:   isub 
L122:   istore 10 
L124:   aload_0 
L125:   getfield [43] 
L128:   iload 10 
L130:   invokestatic [9] 
L133:   istore 11 
L135:   iload 10 
L137:   iload 11 
L139:   isub 
L140:   istore 12 
L142:   aload_0 
L143:   getfield [44] 
L146:   aload_0 
L147:   getfield [43] 
L150:   iload 11 
L152:   isub 
L153:   isub 
L154:   istore 13 
L156:   aload_0 
L157:   iload 13 
L159:   putfield [77] 
L162:   aload_0 
L163:   iload 12 
L165:   iload 13 
L167:   iadd 
L168:   putfield [78] 
L171:   getstatic [6] 
L174:   ldc [7] 
L176:   ldc [10] 
L178:   aload_0 
L179:   getfield [43] 
L182:   i2l 
L183:   iload 12 
L185:   i2l 
L186:   aload_0 
L187:   getfield [44] 
L190:   i2l 
L191:   invokevirtual [46] 
L194:   pop 
L195:   aload_0 
L196:   aload_0 
L197:   iload 4 
L199:   invokespecial [62] 
L202:   putfield [79] 
L205:   getstatic [6] 
L208:   ldc [7] 
L210:   ldc [11] 
L212:   fload_1 
L213:   f2d 
L214:   fload_2 
L215:   f2d 
L216:   aload_0 
L217:   getfield [47] 
L220:   f2d 
L221:   invokevirtual [48] 
L224:   return 
L225:   nop 
L226:   nop 
L227:   nop 
L228:   
    .end code 
.end method 

.method private [432] : [433] 
    .attribute [425] .code stack 9 locals 3 
L0:     aload_0 
L1:     iload_2 
L2:     invokespecial [63] 
L5:     istore 4 
L7:     iload_1 
L8:     iload 4 
L10:    if_icmpge L31 
L13:    getstatic [6] 
L16:    ldc [7] 
L18:    ldc [12] 
L20:    iload_1 
L21:    i2l 
L22:    iload 4 
L24:    i2l 
L25:    invokevirtual [49] 
L28:    pop 
L29:    iconst_1 
L30:    areturn 
L31:    iload_2 
L32:    iload_3 
L33:    if_icmpge L77 
L36:    iload_3 
L37:    iload_2 
L38:    isub 
L39:    istore 5 
L41:    aload_0 
L42:    iload 5 
L44:    invokespecial [63] 
L47:    istore 6 
L49:    iload 6 
L51:    iload 4 
L53:    if_icmple L77 
L56:    getstatic [6] 
L59:    ldc [7] 
L61:    ldc [13] 
L63:    iload 6 
L65:    i2l 
L66:    iload 4 
L68:    i2l 
L69:    iload_2 
L70:    i2l 
L71:    invokevirtual [46] 
L74:    pop 
L75:    iconst_1 
L76:    areturn 
L77:    iconst_0 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [434] : [435] 
    .attribute [425] .code stack 2 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [58] 
L5:     fstore_2 
L6:     getstatic [4] 
L9:     i2f 
L10:    fload_2 
L11:    fmul 
L12:    f2i 
L13:    istore_3 
L14:    getstatic [5] 
L17:    i2f 
L18:    fload_2 
L19:    fmul 
L20:    f2i 
L21:    istore 4 
L23:    iload_3 
L24:    iload 4 
L26:    iadd 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private [436] : [437] 
    .attribute [425] .code stack 3 locals 2 
L0:     iload_1 
L1:     i2f 
L2:     getstatic [4] 
L5:     getstatic [5] 
L8:     iadd 
L9:     i2f 
L10:    fdiv 
L11:    fstore_2 
L12:    fload_2 
L13:    getstatic [14] 
L16:    fcmpg 
L17:    ifge L38 
L20:    iload_1 
L21:    i2f 
L22:    getstatic [14] 
L25:    fdiv 
L26:    fstore_3 
L27:    fload_3 
L28:    getstatic [4] 
L31:    getstatic [5] 
L34:    iadd 
L35:    i2f 
L36:    fdiv 
L37:    areturn 
L38:    fconst_1 
L39:    areturn 
L40:    
    .end code 
.end method 

.method private [438] : [439] 
    .attribute [425] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [45] 
L4:     aload_0 
L5:     getfield [44] 
L8:     isub 
L9:     istore_2 
L10:    iconst_3 
L11:    iload_1 
L12:    imul 
L13:    i2f 
L14:    iconst_2 
L15:    aload_0 
L16:    getfield [44] 
L19:    imul 
L20:    i2f 
L21:    getstatic [15] 
L24:    fmul 
L25:    fsub 
L26:    fstore_3 
L27:    iconst_3 
L28:    iload_2 
L29:    imul 
L30:    aload_0 
L31:    getfield [44] 
L34:    iadd 
L35:    i2f 
L36:    fstore 4 
L38:    fload_3 
L39:    fload 4 
L41:    fdiv 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [440] : [441] 
    .attribute [425] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [39] 
L4:     aload_0 
L5:     getfield [38] 
L8:     fcmpl 
L9:     ifne L14 
L12:    fconst_1 
L13:    areturn 
L14:    aload_0 
L15:    getfield [39] 
L18:    aload_0 
L19:    getfield [38] 
L22:    fsub 
L23:    fstore_1 
L24:    aload_0 
L25:    getfield [40] 
L28:    aload_0 
L29:    getfield [38] 
L32:    fsub 
L33:    fstore_2 
L34:    fload_2 
L35:    fload_1 
L36:    fdiv 
L37:    fstore_3 
L38:    fload_3 
L39:    fconst_0 
L40:    invokestatic [16] 
L43:    fstore_3 
L44:    fload_3 
L45:    fconst_1 
L46:    invokestatic [17] 
L49:    fstore_3 
L50:    fload_3 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [442] : [443] 
    .attribute [425] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [50] 
L4:     fconst_1 
L5:     fcmpl 
L6:     iflt L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [444] : [445] 
    .attribute [425] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [51] 
L4:     ifeq L15 
L7:     aload_0 
L8:     lload_1 
L9:     invokespecial [66] 
L12:    goto L20 
L15:    aload_0 
L16:    lload_1 
L17:    invokespecial [67] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [446] : [447] 
    .attribute [425] .code stack 9 locals 2 
L0:     aload_0 
L1:     lload_1 
L2:     invokespecial [68] 
L5:     istore_3 
L6:     aload_0 
L7:     iload_3 
L8:     aload_0 
L9:     getfield [43] 
L12:    isub 
L13:    invokevirtual [52] 
L16:    fstore 4 
L18:    aload_0 
L19:    getfield [39] 
L22:    aload_0 
L23:    getfield [38] 
L26:    fcmpg 
L27:    ifge L37 
L30:    fload 4 
L32:    ldc [18] 
L34:    fmul 
L35:    fstore 4 
L37:    aload_0 
L38:    dup 
L39:    getfield [40] 
L42:    fload 4 
L44:    fadd 
L45:    putfield [74] 
L48:    aload_0 
L49:    iload_3 
L50:    putfield [76] 
L53:    aload_0 
L54:    getstatic [2] 
L57:    putfield [71] 
L60:    getstatic [19] 
L63:    ldc [7] 
L65:    ldc [20] 
L67:    fload 4 
L69:    f2d 
L70:    aload_0 
L71:    getfield [40] 
L74:    f2d 
L75:    aload_0 
L76:    getfield [39] 
L79:    f2d 
L80:    invokevirtual [48] 
L83:    return 
L84:    
    .end code 
.end method 

.method protected [448] : [449] 
    .attribute [425] .code stack 2 locals 0 
L0:     iload_1 
L1:     i2f 
L2:     getstatic [2] 
L5:     fmul 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [450] : [451] 
    .attribute [425] .code stack 9 locals 2 
L0:     aload_0 
L1:     lload_1 
L2:     invokespecial [68] 
L5:     istore_3 
L6:     iload_3 
L7:     aload_0 
L8:     getfield [45] 
L11:    if_icmple L51 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [39] 
L19:    putfield [74] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [76] 
L27:    aload_0 
L28:    fconst_0 
L29:    putfield [71] 
L32:    getstatic [19] 
L35:    ldc [7] 
L37:    ldc [21] 
L39:    iload_3 
L40:    i2l 
L41:    aload_0 
L42:    getfield [45] 
L45:    i2l 
L46:    invokevirtual [49] 
L49:    pop 
L50:    return 
L51:    aload_0 
L52:    iload_3 
L53:    invokevirtual [53] 
L56:    fstore 4 
L58:    aload_0 
L59:    aload_0 
L60:    iload_3 
L61:    invokespecial [57] 
L64:    putfield [71] 
L67:    aload_0 
L68:    getfield [39] 
L71:    aload_0 
L72:    getfield [38] 
L75:    fcmpl 
L76:    ifle L93 
L79:    aload_0 
L80:    aload_0 
L81:    getfield [38] 
L84:    fload 4 
L86:    fadd 
L87:    putfield [74] 
L90:    goto L104 
L93:    aload_0 
L94:    aload_0 
L95:    getfield [38] 
L98:    fload 4 
L100:   fsub 
L101:   putfield [74] 
L104:   aload_0 
L105:   iload_3 
L106:   putfield [76] 
L109:   getstatic [19] 
L112:   ldc [7] 
L114:   ldc [22] 
L116:   iload_3 
L117:   i2d 
L118:   aload_0 
L119:   getfield [45] 
L122:   i2d 
L123:   aload_0 
L124:   getfield [40] 
L127:   f2d 
L128:   invokevirtual [48] 
L131:   return 
L132:   
    .end code 
.end method 

.method private [452] : [453] 
    .attribute [425] .code stack 7 locals 2 
L0:     lload_1 
L1:     aload_0 
L2:     getfield [42] 
L5:     lsub 
L6:     lstore_3 
L7:     lload_3 
L8:     ldc_w [1] 
L11:    lcmp 
L12:    ifle L34 
L15:    getstatic [19] 
L18:    sipush 10000 
L21:    ldc [23] 
L23:    lload_3 
L24:    ldc_w [1] 
L27:    invokevirtual [49] 
L30:    pop 
L31:    ldc [24] 
L33:    areturn 
L34:    lload_3 
L35:    l2i 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [454] : [455] 
    .attribute [425] .code stack 2 locals 0 
L0:     getstatic [25] 
L3:     invokeinterface [80] 0 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [456] : [457] 
    .attribute [425] .code stack 3 locals 6 
L0:     iconst_0 
L1:     aload_0 
L2:     getfield [45] 
L5:     aload_0 
L6:     getfield [44] 
L9:     isub 
L10:    invokestatic [26] 
L13:    istore_2 
L14:    iload_1 
L15:    iload_2 
L16:    invokestatic [9] 
L19:    istore_3 
L20:    iload_3 
L21:    i2f 
L22:    aload_0 
L23:    getfield [47] 
L26:    fmul 
L27:    fstore 4 
L29:    iload_1 
L30:    iload_2 
L31:    isub 
L32:    istore 5 
L34:    iload 5 
L36:    ifgt L47 
L39:    iload_2 
L40:    ifle L47 
L43:    iconst_1 
L44:    goto L48 
L47:    iconst_0 
L48:    istore 6 
L50:    iload 6 
L52:    ifeq L58 
L55:    fload 4 
L57:    areturn 
L58:    aload_0 
L59:    iload 5 
L61:    i2f 
L62:    invokespecial [69] 
L65:    fstore 7 
L67:    fload 4 
L69:    fload 7 
L71:    fadd 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [458] : [459] 
    .attribute [425] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [45] 
L4:     aload_0 
L5:     getfield [44] 
L8:     isub 
L9:     istore_2 
L10:    iload_1 
L11:    iload_2 
L12:    if_icmpgt L20 
L15:    aload_0 
L16:    getfield [47] 
L19:    areturn 
L20:    iload_1 
L21:    aload_0 
L22:    getfield [45] 
L25:    isub 
L26:    i2f 
L27:    aload_0 
L28:    getfield [44] 
L31:    i2f 
L32:    fdiv 
L33:    fstore_3 
L34:    aload_0 
L35:    getfield [47] 
L38:    getstatic [15] 
L41:    fsub 
L42:    fload_3 
L43:    fmul 
L44:    fload_3 
L45:    fmul 
L46:    getstatic [15] 
L49:    fadd 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [460] : [461] 
    .attribute [425] .code stack 5 locals 5 
L0:     fload_1 
L1:     fconst_0 
L2:     fcmpl 
L3:     ifne L8 
L6:     fconst_0 
L7:     areturn 
L8:     fload_1 
L9:     fstore_2 
L10:    aload_0 
L11:    getfield [44] 
L14:    i2f 
L15:    fstore_3 
L16:    aload_0 
L17:    getfield [47] 
L20:    fstore 4 
L22:    getstatic [15] 
L25:    fstore 5 
L27:    fload_2 
L28:    ldc [27] 
L30:    fload_3 
L31:    fmul 
L32:    fload_3 
L33:    fmul 
L34:    fload 4 
L36:    fmul 
L37:    ldc [27] 
L39:    fload_3 
L40:    fmul 
L41:    fload_2 
L42:    fmul 
L43:    fload 5 
L45:    fload 4 
L47:    fsub 
L48:    fmul 
L49:    fadd 
L50:    fload_2 
L51:    fload_2 
L52:    fmul 
L53:    fload 4 
L55:    fload 5 
L57:    fsub 
L58:    fmul 
L59:    fadd 
L60:    fmul 
L61:    ldc [27] 
L63:    fload_3 
L64:    fmul 
L65:    fload_3 
L66:    fmul 
L67:    fdiv 
L68:    fstore 6 
L70:    fload 6 
L72:    fconst_1 
L73:    invokestatic [16] 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public interface [462] : [463] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [464] : [465] 
    .attribute [425] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [70] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [466] : [467] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [468] : [469] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [470] : [471] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [472] : [473] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [474] : [475] 
    .attribute [425] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [476] : [477] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [478] : [479] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [47] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [480] : [481] 
    .attribute [425] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [482] : [483] 
    .attribute [425] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [484] : [485] 
    .attribute [425] .code stack 1 locals 0 
L0:     ldc [28] 
L2:     putstatic [55] 
L5:     sipush 2500 
L8:     putstatic [60] 
L11:    sipush 200 
L14:    putstatic [59] 
L17:    ldc [29] 
L19:    putstatic [64] 
L22:    fconst_0 
L23:    putstatic [65] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [82] [83] 
.const [3] = Method [84] [85] 
.const [4] = Field [86] [87] 
.const [5] = Field [88] [89] 
.const [6] = Field [90] [91] 
.const [7] = Int -2137614336 
.const [8] = String [92] 
.const [9] = Method [93] [94] 
.const [10] = String [95] 
.const [11] = String [96] 
.const [12] = String [97] 
.const [13] = String [98] 
.const [14] = Field [99] [100] 
.const [15] = Field [101] [102] 
.const [16] = Method [103] [104] 
.const [17] = Method [105] [106] 
.const [18] = Int 32959 
.const [19] = Field [107] [108] 
.const [20] = String [109] 
.const [21] = String [110] 
.const [22] = String [111] 
.const [23] = String [112] 
.const [24] = Int -129 
.const [25] = Field [113] [114] 
.const [26] = Method [115] [116] 
.const [27] = Int 16448 
.const [28] = Int -842249154 
.const [29] = Int -1701242562 
.const [30] = Class [117] 
.const [31] = Class [118] 
.const [32] = Class [119] 
.const [33] = Class [120] 
.const [34] = Class [121] 
.const [35] = Class [122] 
.const [36] = Field [123] [124] 
.const [37] = Field [125] [126] 
.const [38] = Field [127] [128] 
.const [39] = Field [129] [130] 
.const [40] = Field [131] [132] 
.const [41] = Method [133] [134] 
.const [42] = Field [135] [136] 
.const [43] = Field [137] [138] 
.const [44] = Field [139] [140] 
.const [45] = Field [141] [142] 
.const [46] = Method [143] [144] 
.const [47] = Field [145] [146] 
.const [48] = Method [147] [148] 
.const [49] = Method [149] [150] 
.const [50] = Method [151] [152] 
.const [51] = Method [153] [154] 
.const [52] = Method [155] [156] 
.const [53] = Method [157] [158] 
.const [54] = Method [159] [160] 
.const [55] = Field [161] [162] 
.const [56] = Method [163] [164] 
.const [57] = Method [165] [166] 
.const [58] = Method [167] [168] 
.const [59] = Field [169] [170] 
.const [60] = Field [171] [172] 
.const [61] = Method [173] [174] 
.const [62] = Method [175] [176] 
.const [63] = Method [177] [178] 
.const [64] = Field [179] [180] 
.const [65] = Field [181] [182] 
.const [66] = Method [183] [184] 
.const [67] = Method [185] [186] 
.const [68] = Method [187] [188] 
.const [69] = Method [189] [190] 
.const [70] = Field [191] [192] 
.const [71] = Field [193] [194] 
.const [72] = Field [195] [196] 
.const [73] = Field [197] [198] 
.const [74] = Field [199] [200] 
.const [75] = Field [201] [202] 
.const [76] = Field [203] [204] 
.const [77] = Field [205] [206] 
.const [78] = Field [207] [208] 
.const [79] = Field [209] [210] 
.const [80] = InterfaceMethod [211] [212] 
.const [81] = Int -129 
.const [82] = Class [213] 
.const [83] = NameAndType [214] [215] 
.const [84] = Class [216] 
.const [85] = NameAndType [217] [218] 
.const [86] = Class [219] 
.const [87] = NameAndType [220] [221] 
.const [88] = Class [222] 
.const [89] = NameAndType [223] [224] 
.const [90] = Class [225] 
.const [91] = NameAndType [226] [227] 
.const [92] = Utf8 'MenuScrollAnimationFunction#startAnimationNewAlgorithm: animation duration for distance %1 for constant speed: %2, deceleration %3 ms' 
.const [93] = Class [228] 
.const [94] = NameAndType [229] [230] 
.const [95] = Utf8 'MenuScrollAnimationFunction#startAnimationNewAlgorithm: reduce animation duration by %1 to constant speed: %2, deceleration %3 ms' 
.const [96] = Utf8 'MenuScrollAnimationFunction#startAnimationNewAlgorithm: start: %1, target: %2, max speed: %3' 
.const [97] = Utf8 'MenuScrollAnimationFunction#startAnimationNewAlgorithm: reset animation duration to smaller value: %1, old remaining duration: %2' 
.const [98] = Utf8 'MenuScrollAnimationFunction#startAnimationNewAlgorithm: reset animation because new duration %1 is greater than rest duration %2, rest distance: %3' 
.const [99] = Class [231] 
.const [100] = NameAndType [232] [233] 
.const [101] = Class [234] 
.const [102] = NameAndType [235] [236] 
.const [103] = Class [237] 
.const [104] = NameAndType [238] [239] 
.const [105] = Class [240] 
.const [106] = NameAndType [241] [242] 
.const [107] = Class [243] 
.const [108] = NameAndType [244] [245] 
.const [109] = Utf8 'MenuScrollAnimationFunction#updateProgressSlowScroll: update value by %1 to %2, target: %3' 
.const [110] = Utf8 'MenuScrollAnimationFunction#updateProgressFastScroll: target reached. current timer after animation start: %1, animation duration: %2' 
.const [111] = Utf8 'MenuScrollAnimationFunction#updateProgressFastScroll: animationTime: %1, totalDuration: %2, value: %3' 
.const [112] = Utf8 'MenuScrollAnimationFunction#getAnimationTime: AnimationTime too high: %1, use Integer.MAX_VALUE (%2)' 
.const [113] = Class [246] 
.const [114] = NameAndType [247] [248] 
.const [115] = Class [249] 
.const [116] = NameAndType [250] [251] 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [118] = Utf8 java/lang/Object 
.const [119] = Utf8 java/lang/Math 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [122] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [123] = Class [252] 
.const [124] = NameAndType [253] [254] 
.const [125] = Class [255] 
.const [126] = NameAndType [256] [257] 
.const [127] = Class [258] 
.const [128] = NameAndType [259] [260] 
.const [129] = Class [261] 
.const [130] = NameAndType [262] [263] 
.const [131] = Class [264] 
.const [132] = NameAndType [265] [266] 
.const [133] = Class [267] 
.const [134] = NameAndType [268] [269] 
.const [135] = Class [270] 
.const [136] = NameAndType [271] [272] 
.const [137] = Class [273] 
.const [138] = NameAndType [274] [275] 
.const [139] = Class [276] 
.const [140] = NameAndType [277] [278] 
.const [141] = Class [279] 
.const [142] = NameAndType [280] [281] 
.const [143] = Class [282] 
.const [144] = NameAndType [283] [284] 
.const [145] = Class [285] 
.const [146] = NameAndType [286] [287] 
.const [147] = Class [288] 
.const [148] = NameAndType [289] [290] 
.const [149] = Class [291] 
.const [150] = NameAndType [292] [293] 
.const [151] = Class [294] 
.const [152] = NameAndType [295] [296] 
.const [153] = Class [297] 
.const [154] = NameAndType [298] [299] 
.const [155] = Class [300] 
.const [156] = NameAndType [301] [302] 
.const [157] = Class [303] 
.const [158] = NameAndType [304] [305] 
.const [159] = Class [306] 
.const [160] = NameAndType [307] [308] 
.const [161] = Class [309] 
.const [162] = NameAndType [310] [311] 
.const [163] = Class [312] 
.const [164] = NameAndType [313] [314] 
.const [165] = Class [315] 
.const [166] = NameAndType [316] [317] 
.const [167] = Class [318] 
.const [168] = NameAndType [319] [320] 
.const [169] = Class [321] 
.const [170] = NameAndType [322] [323] 
.const [171] = Class [324] 
.const [172] = NameAndType [325] [326] 
.const [173] = Class [327] 
.const [174] = NameAndType [328] [329] 
.const [175] = Class [330] 
.const [176] = NameAndType [331] [332] 
.const [177] = Class [333] 
.const [178] = NameAndType [334] [335] 
.const [179] = Class [336] 
.const [180] = NameAndType [337] [338] 
.const [181] = Class [339] 
.const [182] = NameAndType [340] [341] 
.const [183] = Class [342] 
.const [184] = NameAndType [343] [344] 
.const [185] = Class [345] 
.const [186] = NameAndType [346] [347] 
.const [187] = Class [348] 
.const [188] = NameAndType [349] [350] 
.const [189] = Class [351] 
.const [190] = NameAndType [352] [353] 
.const [191] = Class [354] 
.const [192] = NameAndType [355] [356] 
.const [193] = Class [357] 
.const [194] = NameAndType [358] [359] 
.const [195] = Class [360] 
.const [196] = NameAndType [361] [362] 
.const [197] = Class [363] 
.const [198] = NameAndType [364] [365] 
.const [199] = Class [366] 
.const [200] = NameAndType [367] [368] 
.const [201] = Class [369] 
.const [202] = NameAndType [370] [371] 
.const [203] = Class [372] 
.const [204] = NameAndType [373] [374] 
.const [205] = Class [375] 
.const [206] = NameAndType [376] [377] 
.const [207] = Class [378] 
.const [208] = NameAndType [379] [380] 
.const [209] = Class [381] 
.const [210] = NameAndType [382] [383] 
.const [211] = Class [384] 
.const [212] = NameAndType [385] [386] 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [214] = Utf8 slowScrollSpeed 
.const [215] = Utf8 F 
.const [216] = Utf8 java/lang/Math 
.const [217] = Utf8 abs 
.const [218] = Utf8 (F)F 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [220] = Utf8 defaultConstSpeedDuration 
.const [221] = Utf8 I 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [223] = Utf8 defaultDecelerationDuration 
.const [224] = Utf8 I 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [226] = Utf8 menuLogCh 
.const [227] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [228] = Utf8 java/lang/Math 
.const [229] = Utf8 min 
.const [230] = Utf8 (II)I 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [232] = Utf8 minAvgSpeed 
.const [233] = Utf8 F 
.const [234] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [235] = Utf8 endSpeed 
.const [236] = Utf8 F 
.const [237] = Utf8 java/lang/Math 
.const [238] = Utf8 max 
.const [239] = Utf8 (FF)F 
.const [240] = Utf8 java/lang/Math 
.const [241] = Utf8 min 
.const [242] = Utf8 (FF)F 
.const [243] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [244] = Utf8 menuLayoutLogCh 
.const [245] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [247] = Utf8 framework 
.const [248] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [249] = Utf8 java/lang/Math 
.const [250] = Utf8 max 
.const [251] = Utf8 (II)I 
.const [252] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [253] = Utf8 slowScrollActive 
.const [254] = Utf8 Z 
.const [255] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [256] = Utf8 speed 
.const [257] = Utf8 F 
.const [258] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [259] = Utf8 start 
.const [260] = Utf8 F 
.const [261] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [262] = Utf8 target 
.const [263] = Utf8 F 
.const [264] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [265] = Utf8 value 
.const [266] = Utf8 F 
.const [267] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [268] = Utf8 getCurrentTime 
.const [269] = Utf8 ()J 
.const [270] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [271] = Utf8 startTime 
.const [272] = Utf8 J 
.const [273] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [274] = Utf8 passedTime 
.const [275] = Utf8 I 
.const [276] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [277] = Utf8 decelerationDuration 
.const [278] = Utf8 I 
.const [279] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [280] = Utf8 totalDuration 
.const [281] = Utf8 I 
.const [282] = Utf8 de/audi/atip/log/LogChannel 
.const [283] = Utf8 log 
.const [284] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [285] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [286] = Utf8 maxSpeed 
.const [287] = Utf8 F 
.const [288] = Utf8 de/audi/atip/log/LogChannel 
.const [289] = Utf8 log 
.const [290] = Utf8 (ILjava/lang/String;DDD)V 
.const [291] = Utf8 de/audi/atip/log/LogChannel 
.const [292] = Utf8 log 
.const [293] = Utf8 (ILjava/lang/String;JJ)Z 
.const [294] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [295] = Utf8 getProgress 
.const [296] = Utf8 ()F 
.const [297] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [298] = Utf8 isSlowScrollActive 
.const [299] = Utf8 ()Z 
.const [300] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [301] = Utf8 calculateCurrentDistanceSlowScroll 
.const [302] = Utf8 (I)F 
.const [303] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [304] = Utf8 calculateCurrentDistanceFastScroll 
.const [305] = Utf8 (I)F 
.const [306] = Utf8 java/lang/Object 
.const [307] = Utf8 <init> 
.const [308] = Utf8 ()V 
.const [309] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [310] = Utf8 slowScrollSpeed 
.const [311] = Utf8 F 
.const [312] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [313] = Utf8 startFastScrollAnimation 
.const [314] = Utf8 (FFZ)V 
.const [315] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [316] = Utf8 getCurrentSpeed 
.const [317] = Utf8 (I)F 
.const [318] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [319] = Utf8 calculateDurationFactor 
.const [320] = Utf8 (I)F 
.const [321] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [322] = Utf8 defaultConstSpeedDuration 
.const [323] = Utf8 I 
.const [324] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [325] = Utf8 defaultDecelerationDuration 
.const [326] = Utf8 I 
.const [327] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [328] = Utf8 shouldUseNewDuration 
.const [329] = Utf8 (III)Z 
.const [330] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [331] = Utf8 calculateMaxSpeed 
.const [332] = Utf8 (I)F 
.const [333] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [334] = Utf8 calculateTotalDuration 
.const [335] = Utf8 (I)I 
.const [336] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [337] = Utf8 minAvgSpeed 
.const [338] = Utf8 F 
.const [339] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [340] = Utf8 endSpeed 
.const [341] = Utf8 F 
.const [342] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [343] = Utf8 updateProgressSlowScroll 
.const [344] = Utf8 (J)V 
.const [345] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [346] = Utf8 updateProgressFastScroll 
.const [347] = Utf8 (J)V 
.const [348] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [349] = Utf8 getAnimationTime 
.const [350] = Utf8 (J)I 
.const [351] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [352] = Utf8 calculateDistanceDuringDeceleration 
.const [353] = Utf8 (F)F 
.const [354] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [355] = Utf8 slowScrollActive 
.const [356] = Utf8 Z 
.const [357] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [358] = Utf8 speed 
.const [359] = Utf8 F 
.const [360] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [361] = Utf8 start 
.const [362] = Utf8 F 
.const [363] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [364] = Utf8 target 
.const [365] = Utf8 F 
.const [366] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [367] = Utf8 value 
.const [368] = Utf8 F 
.const [369] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [370] = Utf8 startTime 
.const [371] = Utf8 J 
.const [372] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [373] = Utf8 passedTime 
.const [374] = Utf8 I 
.const [375] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [376] = Utf8 decelerationDuration 
.const [377] = Utf8 I 
.const [378] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [379] = Utf8 totalDuration 
.const [380] = Utf8 I 
.const [381] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [382] = Utf8 maxSpeed 
.const [383] = Utf8 F 
.const [384] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [385] = Utf8 getMonotonicTime 
.const [386] = Utf8 ()J 
.const [387] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuScrollAnimationFunction 
.const [388] = Class [387] 
.const [389] = Utf8 java/lang/Object 
.const [390] = Class [389] 
.const [391] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetConstants 
.const [392] = Class [391] 
.const [393] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [394] = Class [393] 
.const [395] = Utf8 slowScrollSpeed 
.const [396] = Utf8 F 
.const [397] = Utf8 defaultDecelerationDuration 
.const [398] = Utf8 I 
.const [399] = Utf8 defaultConstSpeedDuration 
.const [400] = Utf8 I 
.const [401] = Utf8 minAvgSpeed 
.const [402] = Utf8 F 
.const [403] = Utf8 endSpeed 
.const [404] = Utf8 F 
.const [405] = Utf8 maxSpeed 
.const [406] = Utf8 F 
.const [407] = Utf8 decelerationDuration 
.const [408] = Utf8 I 
.const [409] = Utf8 start 
.const [410] = Utf8 F 
.const [411] = Utf8 target 
.const [412] = Utf8 F 
.const [413] = Utf8 value 
.const [414] = Utf8 F 
.const [415] = Utf8 passedTime 
.const [416] = Utf8 I 
.const [417] = Utf8 startTime 
.const [418] = Utf8 J 
.const [419] = Utf8 totalDuration 
.const [420] = Utf8 I 
.const [421] = Utf8 speed 
.const [422] = Utf8 F 
.const [423] = Utf8 slowScrollActive 
.const [424] = Utf8 Z 
.const [425] = Utf8 Code 
.const [426] = Utf8 <init> 
.const [427] = Utf8 ()V 
.const [428] = Utf8 startAnimation 
.const [429] = Utf8 (FFZZ)V 
.const [430] = Utf8 startFastScrollAnimation 
.const [431] = Utf8 (FFZ)V 
.const [432] = Utf8 shouldUseNewDuration 
.const [433] = Utf8 (III)Z 
.const [434] = Utf8 calculateTotalDuration 
.const [435] = Utf8 (I)I 
.const [436] = Utf8 calculateDurationFactor 
.const [437] = Utf8 (I)F 
.const [438] = Utf8 calculateMaxSpeed 
.const [439] = Utf8 (I)F 
.const [440] = Utf8 getProgress 
.const [441] = Utf8 ()F 
.const [442] = Utf8 isTargetReached 
.const [443] = Utf8 ()Z 
.const [444] = Utf8 updateProgress 
.const [445] = Utf8 (J)V 
.const [446] = Utf8 updateProgressSlowScroll 
.const [447] = Utf8 (J)V 
.const [448] = Utf8 calculateCurrentDistanceSlowScroll 
.const [449] = Utf8 (I)F 
.const [450] = Utf8 updateProgressFastScroll 
.const [451] = Utf8 (J)V 
.const [452] = Utf8 getAnimationTime 
.const [453] = Utf8 (J)I 
.const [454] = Utf8 getCurrentTime 
.const [455] = Utf8 ()J 
.const [456] = Utf8 calculateCurrentDistanceFastScroll 
.const [457] = Utf8 (I)F 
.const [458] = Utf8 getCurrentSpeed 
.const [459] = Utf8 (I)F 
.const [460] = Utf8 calculateDistanceDuringDeceleration 
.const [461] = Utf8 (F)F 
.const [462] = Utf8 getSpeed 
.const [463] = Utf8 ()F 
.const [464] = Utf8 resetSlowScrollMode 
.const [465] = Utf8 ()V 
.const [466] = Utf8 isSlowScrollActive 
.const [467] = Utf8 ()Z 
.const [468] = Utf8 getStart 
.const [469] = Utf8 ()F 
.const [470] = Utf8 getTarget 
.const [471] = Utf8 ()F 
.const [472] = Utf8 getValue 
.const [473] = Utf8 ()F 
.const [474] = Utf8 getStartTime 
.const [475] = Utf8 ()J 
.const [476] = Utf8 getTotalDuration 
.const [477] = Utf8 ()I 
.const [478] = Utf8 getMaxSpeed 
.const [479] = Utf8 ()F 
.const [480] = Utf8 getDecelerationDuration 
.const [481] = Utf8 ()I 
.const [482] = Utf8 getSlowScrollSpeed 
.const [483] = Utf8 ()F 
.const [484] = Utf8 <clinit> 
.const [485] = Utf8 ()V 
.end class 
