.version 50 0 
.class public super [252] 
.super [254] 
.field public static final [255] [256] 
.field public final [257] [258] 
.field public final [259] [260] 
.field public final [261] [262] 
.field public final [263] [264] 
.field public final [265] [266] 
.field public final [267] [268] 
.field private [269] [270] 

.method public static [272] : [273] 
    .attribute [271] .code stack 9 locals 1 
L0:     new [44] 
L3:     dup 
L4:     aload_0 
L5:     aconst_null 
L6:     iconst_0 
L7:     iconst_0 
L8:     iconst_0 
L9:     newarray int 
L11:    aconst_null 
L12:    aconst_null 
L13:    invokespecial [38] 
L16:    astore_3 
L17:    aload_3 
L18:    lload_1 
L19:    invokestatic [3] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [274] : [275] 
    .attribute [271] .code stack 4 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     lload_1 
L3:     invokestatic [4] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [276] : [277] 
    .attribute [271] .code stack 10 locals 9 
L0:     aload_0 
L1:     getfield [17] 
L4:     getfield [18] 
L7:     iconst_1 
L8:     if_icmpne L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    istore 4 
L18:    aload_0 
L19:    getfield [17] 
L22:    getfield [19] 
L25:    aload_0 
L26:    getfield [17] 
L29:    getfield [20] 
L32:    lsub 
L33:    lstore 5 
L35:    iconst_1 
L36:    istore 7 
L38:    aload_0 
L39:    getfield [21] 
L42:    ifnull L67 
L45:    aload_0 
L46:    getfield [22] 
L49:    ifeq L67 
L52:    aload_0 
L53:    getfield [21] 
L56:    getfield [18] 
L59:    iconst_1 
L60:    if_icmpne L67 
L63:    iconst_1 
L64:    goto L68 
L67:    iconst_0 
L68:    istore 8 
L70:    lconst_0 
L71:    lstore 9 
L73:    iload 8 
L75:    ifeq L240 
L78:    aload_0 
L79:    getfield [17] 
L82:    getfield [19] 
L85:    aload_0 
L86:    getfield [21] 
L89:    getfield [19] 
L92:    lsub 
L93:    lstore 9 
L95:    iload 4 
L97:    ifne L106 
L100:   iconst_4 
L101:   istore 7 
L103:   goto L122 
L106:   lload 9 
L108:   lload_2 
L109:   lcmp 
L110:   ifle L119 
L113:   iconst_3 
L114:   istore 7 
L116:   goto L122 
L119:   iconst_2 
L120:   istore 7 
L122:   aload_1 
L123:   ifnull L221 
L126:   iload 7 
L128:   aload_1 
L129:   getfield [23] 
L132:   if_icmpne L221 
L135:   aload_1 
L136:   getfield [24] 
L139:   getfield [21] 
L142:   getfield [25] 
L145:   invokevirtual [26] 
L148:   astore 11 
L150:   aload 11 
L152:   aload_0 
L153:   getfield [21] 
L156:   getfield [25] 
L159:   invokevirtual [26] 
L162:   invokevirtual [27] 
L165:   istore 12 
L167:   iload 12 
L169:   ifeq L221 
L172:   iload 7 
L174:   tableswitch 2 
            L214 
            L207 
            L200 
            default : L221 

L200:   bipush 9 
L202:   istore 7 
L204:   goto L221 
L207:   bipush 8 
L209:   istore 7 
L211:   goto L221 
L214:   bipush 7 
L216:   istore 7 
L218:   goto L221 
L221:   new [47] 
L224:   dup 
L225:   iload 7 
L227:   lload 5 
L229:   iload 4 
L231:   iload 8 
L233:   lload 9 
L235:   aload_0 
L236:   invokespecial [39] 
L239:   areturn 
L240:   new [47] 
L243:   dup 
L244:   iload 7 
L246:   lload 5 
L248:   iload 4 
L250:   aload_0 
L251:   invokespecial [40] 
L254:   areturn 
L255:   nop 
L256:   
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [271] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [48] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [45] 
L14:    aload_0 
L15:    lload_2 
L16:    putfield [49] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [50] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [51] 
L31:    aload_0 
L32:    lload 6 
L34:    putfield [52] 
L37:    aload_0 
L38:    aload 8 
L40:    putfield [46] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [271] .code stack 9 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     lload_2 
L3:     iload 4 
L5:     iconst_0 
L6:     lconst_0 
L7:     aload 5 
L9:     invokespecial [39] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [271] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifgt L16 
L9:     aload_0 
L10:    getfield [30] 
L13:    ifne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [284] : [285] 
    .attribute [271] .code stack 10 locals 0 
L0:     new [47] 
L3:     dup 
L4:     aload_0 
L5:     getfield [23] 
L8:     aload_0 
L9:     getfield [29] 
L12:    aload_0 
L13:    getfield [30] 
L16:    aload_0 
L17:    getfield [31] 
L20:    aload_0 
L21:    getfield [32] 
L24:    aload_0 
L25:    getfield [24] 
L28:    invokespecial [39] 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [286] : [287] 
    .attribute [271] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ifnonnull L111 
L7:     new [53] 
L10:    dup 
L11:    invokespecial [42] 
L14:    astore_1 
L15:    aload_1 
L16:    ldc [7] 
L18:    invokevirtual [33] 
L21:    aload_0 
L22:    getfield [23] 
L25:    invokevirtual [34] 
L28:    pop 
L29:    aload_1 
L30:    ldc [8] 
L32:    invokevirtual [33] 
L35:    aload_0 
L36:    getfield [29] 
L39:    ldc_w [1] 
L42:    ldiv 
L43:    invokevirtual [35] 
L46:    ldc [9] 
L48:    invokevirtual [33] 
L51:    pop 
L52:    aload_1 
L53:    ldc [10] 
L55:    invokevirtual [33] 
L58:    aload_0 
L59:    getfield [30] 
L62:    invokevirtual [36] 
L65:    pop 
L66:    aload_1 
L67:    ldc [11] 
L69:    invokevirtual [33] 
L72:    aload_0 
L73:    getfield [31] 
L76:    invokevirtual [36] 
L79:    pop 
L80:    aload_1 
L81:    ldc [12] 
L83:    invokevirtual [33] 
L86:    aload_0 
L87:    getfield [32] 
L90:    ldc_w [1] 
L93:    ldiv 
L94:    invokevirtual [35] 
L97:    ldc [9] 
L99:    invokevirtual [33] 
L102:   pop 
L103:   aload_0 
L104:   aload_1 
L105:   invokevirtual [37] 
L108:   putfield [48] 
L111:   aload_0 
L112:   getfield [28] 
L115:   areturn 
L116:   
    .end code 
.end method 

.method static [288] : [289] 
    .attribute [271] .code stack 7 locals 0 
L0:     new [47] 
L3:     dup 
L4:     iconst_1 
L5:     lconst_0 
L6:     iconst_1 
L7:     aconst_null 
L8:     invokespecial [40] 
L11:    putstatic [43] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = Method [56] [57] 
.const [4] = Method [58] [59] 
.const [5] = Class [60] 
.const [6] = Class [61] 
.const [7] = String [62] 
.const [8] = String [63] 
.const [9] = String [64] 
.const [10] = String [65] 
.const [11] = String [66] 
.const [12] = String [67] 
.const [13] = Class [68] 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Field [72] [73] 
.const [18] = Field [74] [75] 
.const [19] = Field [76] [77] 
.const [20] = Field [78] [79] 
.const [21] = Field [80] [81] 
.const [22] = Field [82] [83] 
.const [23] = Field [84] [85] 
.const [24] = Field [86] [87] 
.const [25] = Field [88] [89] 
.const [26] = Method [90] [91] 
.const [27] = Method [92] [93] 
.const [28] = Field [94] [95] 
.const [29] = Field [96] [97] 
.const [30] = Field [98] [99] 
.const [31] = Field [100] [101] 
.const [32] = Field [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Method [106] [107] 
.const [35] = Method [108] [109] 
.const [36] = Method [110] [111] 
.const [37] = Method [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Method [116] [117] 
.const [40] = Method [118] [119] 
.const [41] = Method [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Field [124] [125] 
.const [44] = Class [126] 
.const [45] = Field [127] [128] 
.const [46] = Field [129] [130] 
.const [47] = Class [131] 
.const [48] = Field [132] [133] 
.const [49] = Field [134] [135] 
.const [50] = Field [136] [137] 
.const [51] = Field [138] [139] 
.const [52] = Field [140] [141] 
.const [53] = Class [142] 
.const [54] = Int -402456576 
.const [55] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [56] = Class [143] 
.const [57] = NameAndType [144] [145] 
.const [58] = Class [146] 
.const [59] = NameAndType [147] [148] 
.const [60] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [61] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [62] = Utf8 'type:' 
.const [63] = Utf8 ', delay:' 
.const [64] = Utf8 s 
.const [65] = Utf8 ', reliable:' 
.const [66] = Utf8 ', hasBetterRoute:' 
.const [67] = Utf8 ', savingTime:' 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [70] = Utf8 org/dsi/ifc/global/NavSegmentID 
.const [71] = Utf8 java/lang/String 
.const [72] = Class [149] 
.const [73] = NameAndType [150] [151] 
.const [74] = Class [152] 
.const [75] = NameAndType [153] [154] 
.const [76] = Class [155] 
.const [77] = NameAndType [156] [157] 
.const [78] = Class [158] 
.const [79] = NameAndType [159] [160] 
.const [80] = Class [161] 
.const [81] = NameAndType [162] [163] 
.const [82] = Class [164] 
.const [83] = NameAndType [165] [166] 
.const [84] = Class [167] 
.const [85] = NameAndType [168] [169] 
.const [86] = Class [170] 
.const [87] = NameAndType [171] [172] 
.const [88] = Class [173] 
.const [89] = NameAndType [174] [175] 
.const [90] = Class [176] 
.const [91] = NameAndType [177] [178] 
.const [92] = Class [179] 
.const [93] = NameAndType [180] [181] 
.const [94] = Class [182] 
.const [95] = NameAndType [183] [184] 
.const [96] = Class [185] 
.const [97] = NameAndType [186] [187] 
.const [98] = Class [188] 
.const [99] = NameAndType [189] [190] 
.const [100] = Class [191] 
.const [101] = NameAndType [192] [193] 
.const [102] = Class [194] 
.const [103] = NameAndType [195] [196] 
.const [104] = Class [197] 
.const [105] = NameAndType [198] [199] 
.const [106] = Class [200] 
.const [107] = NameAndType [201] [202] 
.const [108] = Class [203] 
.const [109] = NameAndType [204] [205] 
.const [110] = Class [206] 
.const [111] = NameAndType [207] [208] 
.const [112] = Class [209] 
.const [113] = NameAndType [210] [211] 
.const [114] = Class [212] 
.const [115] = NameAndType [213] [214] 
.const [116] = Class [215] 
.const [117] = NameAndType [216] [217] 
.const [118] = Class [218] 
.const [119] = NameAndType [219] [220] 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Class [224] 
.const [123] = NameAndType [225] [226] 
.const [124] = Class [227] 
.const [125] = NameAndType [228] [229] 
.const [126] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [127] = Class [230] 
.const [128] = NameAndType [231] [232] 
.const [129] = Class [233] 
.const [130] = NameAndType [234] [235] 
.const [131] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [132] = Class [236] 
.const [133] = NameAndType [237] [238] 
.const [134] = Class [239] 
.const [135] = NameAndType [240] [241] 
.const [136] = Class [242] 
.const [137] = NameAndType [243] [244] 
.const [138] = Class [245] 
.const [139] = NameAndType [246] [247] 
.const [140] = Class [248] 
.const [141] = NameAndType [249] [250] 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [144] = Utf8 create 
.const [145] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;J)Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [146] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [147] = Utf8 create 
.const [148] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;Lde/audi/tghu/navi/app/map/routecalc/RcciEvent;J)Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [149] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [150] = Utf8 oldRoute 
.const [151] = Utf8 Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [152] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [153] = Utf8 etaWithSpeedAndFlowStatus 
.const [154] = Utf8 I 
.const [155] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [156] = Utf8 etaWithSpeedAndFlow 
.const [157] = Utf8 J 
.const [158] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [159] = Utf8 eta 
.const [160] = Utf8 J 
.const [161] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [162] = Utf8 newRoute 
.const [163] = Utf8 Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [164] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [165] = Utf8 newRouteRecommended 
.const [166] = Utf8 Z 
.const [167] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [168] = Utf8 type 
.const [169] = Utf8 I 
.const [170] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [171] = Utf8 origin 
.const [172] = Utf8 Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.const [173] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [174] = Utf8 segmentIDList 
.const [175] = Utf8 Lorg/dsi/ifc/global/NavSegmentID; 
.const [176] = Utf8 org/dsi/ifc/global/NavSegmentID 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 java/lang/String 
.const [180] = Utf8 equals 
.const [181] = Utf8 (Ljava/lang/Object;)Z 
.const [182] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [183] = Utf8 fingerPrint 
.const [184] = Utf8 Ljava/lang/String; 
.const [185] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [186] = Utf8 delay 
.const [187] = Utf8 J 
.const [188] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [189] = Utf8 reliable 
.const [190] = Utf8 Z 
.const [191] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [192] = Utf8 hasBetterRoute 
.const [193] = Utf8 Z 
.const [194] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [195] = Utf8 savingTime 
.const [196] = Utf8 J 
.const [197] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [198] = Utf8 append 
.const [199] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [200] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [201] = Utf8 append 
.const [202] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [203] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [204] = Utf8 append 
.const [205] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [206] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [207] = Utf8 append 
.const [208] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [209] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [210] = Utf8 toString 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;Lorg/dsi/ifc/navigation/CalculatedRouteListElement;ZI[ILorg/dsi/ifc/global/NavRectangle;[Lorg/dsi/ifc/navigation/RouteSectionInfo;)V 
.const [215] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (IJZZJLorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [218] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (IJZLorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [221] = Utf8 java/lang/Object 
.const [222] = Utf8 <init> 
.const [223] = Utf8 ()V 
.const [224] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [225] = Utf8 <init> 
.const [226] = Utf8 ()V 
.const [227] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [228] = Utf8 EMPTY 
.const [229] = Utf8 Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [230] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [231] = Utf8 type 
.const [232] = Utf8 I 
.const [233] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [234] = Utf8 origin 
.const [235] = Utf8 Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.const [236] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [237] = Utf8 fingerPrint 
.const [238] = Utf8 Ljava/lang/String; 
.const [239] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [240] = Utf8 delay 
.const [241] = Utf8 J 
.const [242] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [243] = Utf8 reliable 
.const [244] = Utf8 Z 
.const [245] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [246] = Utf8 hasBetterRoute 
.const [247] = Utf8 Z 
.const [248] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [249] = Utf8 savingTime 
.const [250] = Utf8 J 
.const [251] = Utf8 de/audi/tghu/navi/app/map/routecalc/RcciEvent 
.const [252] = Class [251] 
.const [253] = Utf8 java/lang/Object 
.const [254] = Class [253] 
.const [255] = Utf8 EMPTY 
.const [256] = Utf8 Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [257] = Utf8 type 
.const [258] = Utf8 I 
.const [259] = Utf8 delay 
.const [260] = Utf8 J 
.const [261] = Utf8 reliable 
.const [262] = Utf8 Z 
.const [263] = Utf8 hasBetterRoute 
.const [264] = Utf8 Z 
.const [265] = Utf8 savingTime 
.const [266] = Utf8 J 
.const [267] = Utf8 origin 
.const [268] = Utf8 Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.const [269] = Utf8 fingerPrint 
.const [270] = Utf8 Ljava/lang/String; 
.const [271] = Utf8 Code 
.const [272] = Utf8 create 
.const [273] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;J)Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [274] = Utf8 create 
.const [275] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;J)Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [276] = Utf8 create 
.const [277] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;Lde/audi/tghu/navi/app/map/routecalc/RcciEvent;J)Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [278] = Utf8 <init> 
.const [279] = Utf8 (IJZZJLorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [280] = Utf8 <init> 
.const [281] = Utf8 (IJZLorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [282] = Utf8 hasTrafficImpactOnCurrentRoute 
.const [283] = Utf8 ()Z 
.const [284] = Utf8 copy 
.const [285] = Utf8 ()Lde/audi/tghu/navi/app/map/routecalc/RcciEvent; 
.const [286] = Utf8 toString 
.const [287] = Utf8 ()Ljava/lang/String; 
.const [288] = Utf8 <clinit> 
.const [289] = Utf8 ()V 
.end class 
