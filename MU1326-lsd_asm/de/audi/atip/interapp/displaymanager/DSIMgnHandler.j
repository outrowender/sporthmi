.version 50 0 
.class public super [147] 
.super [149] 
.field public static final [150] [151] 
.field public static final [152] [153] 
.field public static final [154] [155] 
.field public static final [156] [157] 
.field public static final [158] [159] 
.field public static final [160] [161] 
.field public static final [162] [163] 
.field public static final [164] [165] 
.field private final [166] [167] 

.method public [169] : [170] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [171] : [172] 
    .attribute [168] .code stack 4 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            2 : L43 
            default : L58 

L28:    iconst_2 
L29:    newarray int 
L31:    dup 
L32:    iconst_0 
L33:    sipush 400 
L36:    iastore 
L37:    dup 
L38:    iconst_1 
L39:    bipush 106 
L41:    iastore 
L42:    areturn 
L43:    iconst_2 
L44:    newarray int 
L46:    dup 
L47:    iconst_0 
L48:    sipush 400 
L51:    iastore 
L52:    dup 
L53:    iconst_1 
L54:    bipush 90 
L56:    iastore 
L57:    areturn 
L58:    iconst_2 
L59:    newarray int 
L61:    dup 
L62:    iconst_0 
L63:    iconst_0 
L64:    iastore 
L65:    dup 
L66:    iconst_1 
L67:    iconst_0 
L68:    iastore 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [173] : [174] 
    .attribute [168] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokeinterface [28] 0 
L9:     istore_2 
L10:    iload_1 
L11:    ifne L175 
L14:    iload_2 
L15:    tableswitch 1 
            L52 
            L68 
            L84 
            L100 
            L116 
            L132 
            default : L148 

L52:    iconst_2 
L53:    newarray int 
L55:    dup 
L56:    iconst_0 
L57:    sipush 800 
L60:    iastore 
L61:    dup 
L62:    iconst_1 
L63:    sipush 480 
L66:    iastore 
L67:    areturn 
L68:    iconst_2 
L69:    newarray int 
L71:    dup 
L72:    iconst_0 
L73:    sipush 1024 
L76:    iastore 
L77:    dup 
L78:    iconst_1 
L79:    sipush 480 
L82:    iastore 
L83:    areturn 
L84:    iconst_2 
L85:    newarray int 
L87:    dup 
L88:    iconst_0 
L89:    sipush 1280 
L92:    iastore 
L93:    dup 
L94:    iconst_1 
L95:    sipush 540 
L98:    iastore 
L99:    areturn 
L100:   iconst_2 
L101:   newarray int 
L103:   dup 
L104:   iconst_0 
L105:   sipush 1440 
L108:   iastore 
L109:   dup 
L110:   iconst_1 
L111:   sipush 540 
L114:   iastore 
L115:   areturn 
L116:   iconst_2 
L117:   newarray int 
L119:   dup 
L120:   iconst_0 
L121:   sipush 1680 
L124:   iastore 
L125:   dup 
L126:   iconst_1 
L127:   sipush 580 
L130:   iastore 
L131:   areturn 
L132:   iconst_2 
L133:   newarray int 
L135:   dup 
L136:   iconst_0 
L137:   sipush 1920 
L140:   iastore 
L141:   dup 
L142:   iconst_1 
L143:   sipush 580 
L146:   iastore 
L147:   areturn 
L148:   new [29] 
L151:   dup 
L152:   new [30] 
L155:   dup 
L156:   invokespecial [21] 
L159:   ldc [4] 
L161:   invokevirtual [12] 
L164:   iload_2 
L165:   invokevirtual [13] 
L168:   invokevirtual [14] 
L171:   invokespecial [22] 
L174:   athrow 
L175:   iload_1 
L176:   iconst_1 
L177:   if_icmpeq L185 
L180:   iload_1 
L181:   iconst_2 
L182:   if_icmpne L201 
L185:   iconst_2 
L186:   newarray int 
L188:   dup 
L189:   iconst_0 
L190:   sipush 640 
L193:   iastore 
L194:   dup 
L195:   iconst_1 
L196:   sipush 360 
L199:   iastore 
L200:   areturn 
L201:   new [29] 
L204:   dup 
L205:   new [30] 
L208:   dup 
L209:   invokespecial [21] 
L212:   ldc [5] 
L214:   invokevirtual [12] 
L217:   iload_1 
L218:   invokevirtual [13] 
L221:   invokevirtual [14] 
L224:   invokespecial [22] 
L227:   athrow 
L228:   
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [168] .code stack 9 locals 5 
L0:     aload_0 
L1:     getfield [11] 
L4:     sipush 4348 
L7:     invokeinterface [31] 0 
L12:    istore_2 
L13:    aload_0 
L14:    iload_2 
L15:    invokespecial [23] 
L18:    astore_3 
L19:    aload_0 
L20:    iload_2 
L21:    invokespecial [24] 
L24:    astore 4 
L26:    iload_1 
L27:    tableswitch 0 
            L60 
            L69 
            L80 
            L91 
            L102 
            default : L118 

L60:    iconst_4 
L61:    istore 5 
L63:    iconst_3 
L64:    istore 6 
L66:    goto L120 
L69:    bipush 16 
L71:    istore 5 
L73:    bipush 9 
L75:    istore 6 
L77:    goto L120 
L80:    bipush 15 
L82:    istore 5 
L84:    bipush 9 
L86:    istore 6 
L88:    goto L120 
L91:    bipush 47 
L93:    istore 5 
L95:    bipush 20 
L97:    istore 6 
L99:    goto L120 
L102:   new [32] 
L105:   dup 
L106:   aload 4 
L108:   iconst_0 
L109:   iaload 
L110:   aload 4 
L112:   iconst_1 
L113:   iaload 
L114:   invokespecial [25] 
L117:   areturn 
L118:   aconst_null 
L119:   areturn 
L120:   new [32] 
L123:   dup 
L124:   iload 5 
L126:   iload 6 
L128:   aload 4 
L130:   iconst_0 
L131:   iaload 
L132:   aload 4 
L134:   iconst_1 
L135:   iaload 
L136:   aload_3 
L137:   iconst_0 
L138:   iaload 
L139:   aload_3 
L140:   iconst_1 
L141:   iaload 
L142:   invokespecial [26] 
L145:   areturn 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [168] .code stack 11 locals 1 
L0:     aload_0 
L1:     iload_2 
L2:     invokevirtual [15] 
L5:     astore 6 
L7:     aload 5 
L9:     iconst_0 
L10:    iload_1 
L11:    iconst_0 
L12:    iconst_0 
L13:    iconst_0 
L14:    iconst_0 
L15:    aload 6 
L17:    getfield [16] 
L20:    aload 6 
L22:    getfield [17] 
L25:    aload 6 
L27:    getfield [18] 
L30:    aload 6 
L32:    getfield [19] 
L35:    invokeinterface [33] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [168] .code stack 11 locals 1 
L0:     aload_0 
L1:     iload_3 
L2:     invokevirtual [15] 
L5:     astore 9 
L7:     aload 8 
L9:     iload_1 
L10:    iload_2 
L11:    iload 4 
L13:    iload 5 
L15:    iload 6 
L17:    iload 7 
L19:    aload 9 
L21:    getfield [16] 
L24:    aload 9 
L26:    getfield [17] 
L29:    aload 9 
L31:    getfield [18] 
L34:    aload 9 
L36:    getfield [19] 
L39:    invokeinterface [33] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = Field [43] [44] 
.const [12] = Method [45] [46] 
.const [13] = Method [47] [48] 
.const [14] = Method [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Field [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Field [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = InterfaceMethod [77] [78] 
.const [29] = Class [79] 
.const [30] = Class [80] 
.const [31] = InterfaceMethod [81] [82] 
.const [32] = Class [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = Utf8 java/lang/IllegalArgumentException 
.const [35] = Utf8 java/lang/StringBuffer 
.const [36] = Utf8 'No valid system screen resolution set: ' 
.const [37] = Utf8 'No valid video cropping base set: ' 
.const [38] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [39] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [42] = Utf8 org/dsi/ifc/displaymanagement/DSIDisplayManagement 
.const [43] = Class [86] 
.const [44] = NameAndType [87] [88] 
.const [45] = Class [89] 
.const [46] = NameAndType [90] [91] 
.const [47] = Class [92] 
.const [48] = NameAndType [93] [94] 
.const [49] = Class [95] 
.const [50] = NameAndType [96] [97] 
.const [51] = Class [98] 
.const [52] = NameAndType [99] [100] 
.const [53] = Class [101] 
.const [54] = NameAndType [102] [103] 
.const [55] = Class [104] 
.const [56] = NameAndType [105] [106] 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Class [134] 
.const [76] = NameAndType [135] [136] 
.const [77] = Class [137] 
.const [78] = NameAndType [138] [139] 
.const [79] = Utf8 java/lang/IllegalArgumentException 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [87] = Utf8 frameworkAccess 
.const [88] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 append 
.const [91] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 toString 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [99] = Utf8 getCropping 
.const [100] = Utf8 (I)Lde/audi/atip/interapp/displaymanager/Cropping; 
.const [101] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [102] = Utf8 tgtX 
.const [103] = Utf8 I 
.const [104] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [105] = Utf8 tgtY 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [108] = Utf8 tgtWidth 
.const [109] = Utf8 I 
.const [110] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [111] = Utf8 tgtHeight 
.const [112] = Utf8 I 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 java/lang/IllegalArgumentException 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Ljava/lang/String;)V 
.const [122] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [123] = Utf8 getTargetOffsetXY 
.const [124] = Utf8 (I)[I 
.const [125] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [126] = Utf8 getCroppingResolution 
.const [127] = Utf8 (I)[I 
.const [128] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (II)V 
.const [131] = Utf8 de/audi/atip/interapp/displaymanager/Cropping 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (IIIIII)V 
.const [134] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [135] = Utf8 frameworkAccess 
.const [136] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [137] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [138] = Utf8 getScreenRes 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [141] = Utf8 getSysConst 
.const [142] = Utf8 (I)I 
.const [143] = Utf8 org/dsi/ifc/displaymanagement/DSIDisplayManagement 
.const [144] = Utf8 setCropping 
.const [145] = Utf8 (IIIIIIIIII)V 
.const [146] = Utf8 de/audi/atip/interapp/displaymanager/DSIMgnHandler 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 RATIO_4_3 
.const [151] = Utf8 I 
.const [152] = Utf8 RATIO_16_9 
.const [153] = Utf8 I 
.const [154] = Utf8 RATIO_15_9 
.const [155] = Utf8 I 
.const [156] = Utf8 RATIO_47_20 
.const [157] = Utf8 I 
.const [158] = Utf8 RATIO_ZOOM 
.const [159] = Utf8 I 
.const [160] = Utf8 CROPPING_BASE_FULLSCREEN 
.const [161] = Utf8 I 
.const [162] = Utf8 CROPPING_BASE_1440_640_360_1 
.const [163] = Utf8 I 
.const [164] = Utf8 CROPPING_BASE_1440_640_360_2 
.const [165] = Utf8 I 
.const [166] = Utf8 frameworkAccess 
.const [167] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [168] = Utf8 Code 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [171] = Utf8 getTargetOffsetXY 
.const [172] = Utf8 (I)[I 
.const [173] = Utf8 getCroppingResolution 
.const [174] = Utf8 (I)[I 
.const [175] = Utf8 getCropping 
.const [176] = Utf8 (I)Lde/audi/atip/interapp/displaymanager/Cropping; 
.const [177] = Utf8 setCropping 
.const [178] = Utf8 (IIIILorg/dsi/ifc/displaymanagement/DSIDisplayManagement;)V 
.const [179] = Utf8 setCropping 
.const [180] = Utf8 (IIIIIIILorg/dsi/ifc/displaymanagement/DSIDisplayManagement;)V 
.end class 
