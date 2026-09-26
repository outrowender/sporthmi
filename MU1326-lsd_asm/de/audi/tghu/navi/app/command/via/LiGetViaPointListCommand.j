.version 50 0 
.class public super [208] 
.super [210] 
.field private [211] [212] 
.field private [213] [214] 
.field private [215] [216] 
.field private [217] [218] 
.field private [219] [220] 

.method public [222] : [223] 
    .attribute [221] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [41] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [42] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [43] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [44] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [45] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [221] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [34] 
L16:    aload_0 
L17:    getfield [28] 
L20:    aload_0 
L21:    getfield [29] 
L24:    aload_0 
L25:    getfield [30] 
L28:    aload_0 
L29:    getfield [31] 
L32:    invokeinterface [46] 0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [221] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    getfield [27] 
L16:    ifnull L44 
L19:    aload_0 
L20:    getfield [27] 
L23:    iload_1 
L24:    i2l 
L25:    aload_2 
L26:    iload_3 
L27:    iload 4 
L29:    invokevirtual [35] 
L32:    aload_0 
L33:    invokevirtual [36] 
L36:    invokeinterface [47] 0 
L41:    goto L68 
L44:    aload_0 
L45:    getfield [32] 
L48:    sipush 10000 
L51:    ldc [5] 
L53:    invokevirtual [33] 
L56:    pop 
L57:    aload_0 
L58:    invokevirtual [36] 
L61:    ldc [6] 
L63:    invokeinterface [48] 0 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method [228] : [229] 
    .attribute [221] .code stack 12 locals 3 
L0:     new [49] 
L3:     dup 
L4:     bipush 15 
L6:     invokespecial [39] 
L9:     astore_1 
L10:    aload_1 
L11:    new [50] 
L14:    dup 
L15:    iconst_1 
L16:    ldc [9] 
L18:    ldc2_w [54] 
L21:    aconst_null 
L22:    iconst_1 
L23:    ldc2_w [54] 
L26:    iconst_5 
L27:    invokespecial [40] 
L30:    invokeinterface [51] 0 
L35:    pop 
L36:    aload_0 
L37:    getfield [31] 
L40:    iconst_1 
L41:    if_icmpne L169 
L44:    aload_1 
L45:    new [50] 
L48:    dup 
L49:    bipush 10 
L51:    ldc [10] 
L53:    ldc2_w [54] 
L56:    aconst_null 
L57:    iconst_0 
L58:    lconst_1 
L59:    iconst_0 
L60:    invokespecial [40] 
L63:    invokeinterface [51] 0 
L68:    pop 
L69:    aload_1 
L70:    new [50] 
L73:    dup 
L74:    bipush 11 
L76:    ldc [11] 
L78:    ldc2_w [54] 
L81:    aconst_null 
L82:    iconst_0 
L83:    lconst_1 
L84:    iconst_0 
L85:    invokespecial [40] 
L88:    invokeinterface [51] 0 
L93:    pop 
L94:    aload_1 
L95:    new [50] 
L98:    dup 
L99:    bipush 12 
L101:   ldc [12] 
L103:   ldc2_w [54] 
L106:   aconst_null 
L107:   iconst_0 
L108:   lconst_1 
L109:   iconst_0 
L110:   invokespecial [40] 
L113:   invokeinterface [51] 0 
L118:   pop 
L119:   aload_1 
L120:   new [50] 
L123:   dup 
L124:   bipush 13 
L126:   ldc [13] 
L128:   ldc2_w [54] 
L131:   aconst_null 
L132:   iconst_0 
L133:   lconst_1 
L134:   iconst_0 
L135:   invokespecial [40] 
L138:   invokeinterface [51] 0 
L143:   pop 
L144:   aload_1 
L145:   new [50] 
L148:   dup 
L149:   bipush 14 
L151:   ldc [14] 
L153:   ldc2_w [54] 
L156:   aconst_null 
L157:   iconst_0 
L158:   lconst_1 
L159:   iconst_0 
L160:   invokespecial [40] 
L163:   invokeinterface [51] 0 
L168:   pop 
L169:   aload_1 
L170:   new [50] 
L173:   dup 
L174:   bipush 20 
L176:   ldc [15] 
L178:   ldc2_w [54] 
L181:   aconst_null 
L182:   iconst_1 
L183:   ldc2_w [54] 
L186:   iconst_0 
L187:   invokespecial [40] 
L190:   invokeinterface [51] 0 
L195:   pop 
L196:   aload_1 
L197:   new [50] 
L200:   dup 
L201:   bipush 21 
L203:   ldc [16] 
L205:   ldc2_w [54] 
L208:   aconst_null 
L209:   iconst_1 
L210:   ldc2_w [54] 
L213:   iconst_0 
L214:   invokespecial [40] 
L217:   invokeinterface [51] 0 
L222:   pop 
L223:   aload_1 
L224:   new [50] 
L227:   dup 
L228:   bipush 22 
L230:   ldc [17] 
L232:   ldc2_w [54] 
L235:   aconst_null 
L236:   iconst_1 
L237:   ldc2_w [54] 
L240:   iconst_0 
L241:   invokespecial [40] 
L244:   invokeinterface [51] 0 
L249:   pop 
L250:   aload_1 
L251:   new [50] 
L254:   dup 
L255:   bipush 23 
L257:   ldc [18] 
L259:   ldc2_w [54] 
L262:   aconst_null 
L263:   iconst_1 
L264:   ldc2_w [54] 
L267:   iconst_0 
L268:   invokespecial [40] 
L271:   invokeinterface [51] 0 
L276:   pop 
L277:   aload_1 
L278:   new [50] 
L281:   dup 
L282:   bipush 24 
L284:   ldc [19] 
L286:   ldc2_w [54] 
L289:   aconst_null 
L290:   iconst_1 
L291:   ldc2_w [54] 
L294:   iconst_0 
L295:   invokespecial [40] 
L298:   invokeinterface [51] 0 
L303:   pop 
L304:   aload_1 
L305:   invokeinterface [52] 0 
L310:   anewarray [8] 
L313:   astore_2 
L314:   iconst_0 
L315:   istore_3 
L316:   iload_3 
L317:   aload_1 
L318:   invokeinterface [52] 0 
L323:   if_icmpge L345 
L326:   aload_2 
L327:   iload_3 
L328:   aload_1 
L329:   iload_3 
L330:   invokeinterface [53] 0 
L335:   checkcast [8] 
L338:   aastore 
L339:   iinc 3 1 
L342:   goto L316 
L345:   aload_0 
L346:   iconst_1 
L347:   aload_2 
L348:   aload_2 
L349:   arraylength 
L350:   iconst_0 
L351:   invokevirtual [37] 
L354:   return 
L355:   nop 
L356:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [56] 
.const [4] = String [57] 
.const [5] = String [58] 
.const [6] = String [59] 
.const [7] = Class [60] 
.const [8] = Class [61] 
.const [9] = String [62] 
.const [10] = String [63] 
.const [11] = String [64] 
.const [12] = String [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = String [71] 
.const [19] = String [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Class [78] 
.const [26] = Class [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Field [108] [109] 
.const [42] = Field [110] [111] 
.const [43] = Field [112] [113] 
.const [44] = Field [114] [115] 
.const [45] = Field [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = Class [124] 
.const [50] = Class [125] 
.const [51] = InterfaceMethod [126] [127] 
.const [52] = InterfaceMethod [128] [129] 
.const [53] = InterfaceMethod [130] [131] 
.const [54] = Long -1L 
.const [56] = Utf8 'LiGetViaPointListCommand#execute() - calling liGetViaPointList() ' 
.const [57] = Utf8 'LiGetViaPointListCommand#liGetViaPointListResult()' 
.const [58] = Utf8 'LiGetViaPointListCommand#liGetViaPointListResult() - no listener registered!' 
.const [59] = Utf8 'no listener' 
.const [60] = Utf8 java/util/ArrayList 
.const [61] = Utf8 org/dsi/ifc/navigation/ViaPointListElement 
.const [62] = Utf8 'St\xe4dte' 
.const [63] = Utf8 Amberg 
.const [64] = Utf8 Erlangen 
.const [65] = Utf8 Ingolstadt 
.const [66] = Utf8 'M\xfcnchen' 
.const [67] = Utf8 'N\xfcrnberg' 
.const [68] = Utf8 'Grenz\xfcberg\xe4nge' 
.const [69] = Utf8 'F\xe4hren' 
.const [70] = Utf8 'Fl\xfcsse' 
.const [71] = Utf8 Landkreise 
.const [72] = Utf8 Autobahnkreuze 
.const [73] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [74] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [77] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaListManager 
.const [78] = Utf8 de/audi/tghu/command/ICommandList 
.const [79] = Utf8 java/util/List 
.const [80] = Class [132] 
.const [81] = NameAndType [133] [134] 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Class [138] 
.const [85] = NameAndType [139] [140] 
.const [86] = Class [141] 
.const [87] = NameAndType [142] [143] 
.const [88] = Class [144] 
.const [89] = NameAndType [145] [146] 
.const [90] = Class [147] 
.const [91] = NameAndType [148] [149] 
.const [92] = Class [150] 
.const [93] = NameAndType [151] [152] 
.const [94] = Class [153] 
.const [95] = NameAndType [154] [155] 
.const [96] = Class [156] 
.const [97] = NameAndType [157] [158] 
.const [98] = Class [159] 
.const [99] = NameAndType [160] [161] 
.const [100] = Class [162] 
.const [101] = NameAndType [163] [164] 
.const [102] = Class [165] 
.const [103] = NameAndType [166] [167] 
.const [104] = Class [168] 
.const [105] = NameAndType [169] [170] 
.const [106] = Class [171] 
.const [107] = NameAndType [172] [173] 
.const [108] = Class [174] 
.const [109] = NameAndType [175] [176] 
.const [110] = Class [177] 
.const [111] = NameAndType [178] [179] 
.const [112] = Class [180] 
.const [113] = NameAndType [181] [182] 
.const [114] = Class [183] 
.const [115] = NameAndType [184] [185] 
.const [116] = Class [186] 
.const [117] = NameAndType [187] [188] 
.const [118] = Class [189] 
.const [119] = NameAndType [190] [191] 
.const [120] = Class [192] 
.const [121] = NameAndType [193] [194] 
.const [122] = Class [195] 
.const [123] = NameAndType [196] [197] 
.const [124] = Utf8 java/util/ArrayList 
.const [125] = Utf8 org/dsi/ifc/navigation/ViaPointListElement 
.const [126] = Class [198] 
.const [127] = NameAndType [199] [200] 
.const [128] = Class [201] 
.const [129] = NameAndType [202] [203] 
.const [130] = Class [204] 
.const [131] = NameAndType [205] [206] 
.const [132] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [133] = Utf8 listener 
.const [134] = Utf8 Lde/audi/tghu/navi/app/hierarchiclist/via/ViaListManager; 
.const [135] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [136] = Utf8 windowSize 
.const [137] = Utf8 I 
.const [138] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [139] = Utf8 offset 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [142] = Utf8 anchorId 
.const [143] = Utf8 I 
.const [144] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [145] = Utf8 openedListAnchorId 
.const [146] = Utf8 I 
.const [147] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [148] = Utf8 logger 
.const [149] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;)Z 
.const [153] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [154] = Utf8 getDSINavigation 
.const [155] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [156] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaListManager 
.const [157] = Utf8 updateViaList 
.const [158] = Utf8 (J[Lorg/dsi/ifc/navigation/ViaPointListElement;II)V 
.const [159] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [160] = Utf8 getCommandList 
.const [161] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [162] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [163] = Utf8 liGetViaPointListResult 
.const [164] = Utf8 (I[Lorg/dsi/ifc/navigation/ViaPointListElement;II)V 
.const [165] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 java/util/ArrayList 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 org/dsi/ifc/navigation/ViaPointListElement 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (ILjava/lang/String;JLjava/lang/String;ZJI)V 
.const [174] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [175] = Utf8 listener 
.const [176] = Utf8 Lde/audi/tghu/navi/app/hierarchiclist/via/ViaListManager; 
.const [177] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [178] = Utf8 windowSize 
.const [179] = Utf8 I 
.const [180] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [181] = Utf8 offset 
.const [182] = Utf8 I 
.const [183] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [184] = Utf8 anchorId 
.const [185] = Utf8 I 
.const [186] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [187] = Utf8 openedListAnchorId 
.const [188] = Utf8 I 
.const [189] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [190] = Utf8 liGetViaPointList 
.const [191] = Utf8 (IIII)V 
.const [192] = Utf8 de/audi/tghu/command/ICommandList 
.const [193] = Utf8 commandFinished 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/tghu/command/ICommandList 
.const [196] = Utf8 commandAborted 
.const [197] = Utf8 (Ljava/lang/String;)V 
.const [198] = Utf8 java/util/List 
.const [199] = Utf8 add 
.const [200] = Utf8 (Ljava/lang/Object;)Z 
.const [201] = Utf8 java/util/List 
.const [202] = Utf8 size 
.const [203] = Utf8 ()I 
.const [204] = Utf8 java/util/List 
.const [205] = Utf8 get 
.const [206] = Utf8 (I)Ljava/lang/Object; 
.const [207] = Utf8 de/audi/tghu/navi/app/command/via/LiGetViaPointListCommand 
.const [208] = Class [207] 
.const [209] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [210] = Class [209] 
.const [211] = Utf8 listener 
.const [212] = Utf8 Lde/audi/tghu/navi/app/hierarchiclist/via/ViaListManager; 
.const [213] = Utf8 windowSize 
.const [214] = Utf8 I 
.const [215] = Utf8 offset 
.const [216] = Utf8 I 
.const [217] = Utf8 anchorId 
.const [218] = Utf8 I 
.const [219] = Utf8 openedListAnchorId 
.const [220] = Utf8 I 
.const [221] = Utf8 Code 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Lde/audi/tghu/navi/app/hierarchiclist/via/ViaListManager;IIII)V 
.const [224] = Utf8 execute 
.const [225] = Utf8 ()V 
.const [226] = Utf8 liGetViaPointListResult 
.const [227] = Utf8 (I[Lorg/dsi/ifc/navigation/ViaPointListElement;II)V 
.const [228] = Utf8 dummyResult 
.const [229] = Utf8 ()V 
.end class 
