.version 50 0 
.class super [170] 
.super [172] 
.field private final [173] [174] 
.field private final [175] [176] 
.field private [177] [178] 
.field private [179] [180] 
.field private [181] [182] 

.method public [184] : [185] 
    .attribute [183] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [33] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method [186] : [187] 
    .attribute [183] .code stack 5 locals 2 
L0:     aload_0 
L1:     dup 
L2:     getfield [22] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [34] 
L10:    aload_0 
L11:    dup 
L12:    getfield [23] 
L15:    lload_1 
L16:    ladd 
L17:    putfield [35] 
L20:    lload_1 
L21:    ldc_w [1] 
L24:    lcmp 
L25:    ifle L87 
L28:    aload_0 
L29:    getfield [24] 
L32:    ifnonnull L48 
L35:    aload_0 
L36:    new [37] 
L39:    dup 
L40:    bipush 20 
L42:    invokespecial [31] 
L45:    putfield [36] 
L48:    invokestatic [3] 
L51:    astore_3 
L52:    aload_3 
L53:    arraylength 
L54:    iconst_1 
L55:    iadd 
L56:    newarray long 
L58:    astore 4 
L60:    aload 4 
L62:    iconst_0 
L63:    lload_1 
L64:    lastore 
L65:    aload_3 
L66:    iconst_0 
L67:    aload 4 
L69:    iconst_1 
L70:    aload_3 
L71:    arraylength 
L72:    invokestatic [4] 
L75:    aload_0 
L76:    getfield [24] 
L79:    aload 4 
L81:    invokeinterface [38] 0 
L86:    pop 
L87:    return 
L88:    
    .end code 
.end method 

.method [188] : [189] 
    .attribute [183] .code stack 4 locals 4 
L0:     aload_1 
L1:     ldc [5] 
L3:     invokevirtual [25] 
L6:     aload_1 
L7:     aload_0 
L8:     getfield [20] 
L11:    invokevirtual [25] 
L14:    aload_1 
L15:    ldc [6] 
L17:    invokevirtual [25] 
L20:    aload_1 
L21:    aload_0 
L22:    getfield [21] 
L25:    invokevirtual [25] 
L28:    aload_1 
L29:    ldc [7] 
L31:    invokevirtual [25] 
L34:    aload_1 
L35:    aload_0 
L36:    getfield [22] 
L39:    invokevirtual [26] 
L42:    aload_1 
L43:    ldc [7] 
L45:    invokevirtual [25] 
L48:    aload_1 
L49:    aload_0 
L50:    getfield [23] 
L53:    invokevirtual [27] 
L56:    aload_0 
L57:    getfield [24] 
L60:    ifnull L209 
L63:    aload_0 
L64:    getfield [24] 
L67:    invokeinterface [39] 0 
L72:    istore_2 
L73:    iconst_0 
L74:    istore_3 
L75:    iload_3 
L76:    iload_2 
L77:    if_icmpge L209 
L80:    aload_0 
L81:    getfield [24] 
L84:    iload_3 
L85:    invokeinterface [40] 0 
L90:    checkcast [8] 
L93:    checkcast [8] 
L96:    astore 4 
L98:    aload_1 
L99:    ldc [9] 
L101:   invokevirtual [25] 
L104:   aload_1 
L105:   aload_0 
L106:   getfield [20] 
L109:   invokevirtual [25] 
L112:   aload_1 
L113:   ldc [6] 
L115:   invokevirtual [25] 
L118:   aload_1 
L119:   aload_0 
L120:   getfield [21] 
L123:   invokevirtual [25] 
L126:   aload_1 
L127:   ldc [10] 
L129:   invokevirtual [25] 
L132:   aload_1 
L133:   aload 4 
L135:   iconst_0 
L136:   laload 
L137:   invokevirtual [28] 
L140:   iconst_1 
L141:   istore 5 
L143:   iload 5 
L145:   aload 4 
L147:   arraylength 
L148:   if_icmpge L197 
L151:   aload 4 
L153:   iload 5 
L155:   laload 
L156:   lconst_0 
L157:   lcmp 
L158:   ifle L197 
L161:   iload 5 
L163:   iconst_1 
L164:   if_icmpne L176 
L167:   aload_1 
L168:   ldc [11] 
L170:   invokevirtual [25] 
L173:   goto L182 
L176:   aload_1 
L177:   ldc [7] 
L179:   invokevirtual [25] 
L182:   aload_1 
L183:   aload 4 
L185:   iload 5 
L187:   laload 
L188:   invokevirtual [28] 
L191:   iinc 5 1 
L194:   goto L143 
L197:   aload_1 
L198:   ldc [12] 
L200:   invokevirtual [29] 
L203:   iinc 3 1 
L206:   goto L75 
L209:   return 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 

.method [190] : [191] 
    .attribute [183] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifnull L150 
L7:     aload_1 
L8:     ldc [5] 
L10:    invokevirtual [25] 
L13:    aload_1 
L14:    aload_0 
L15:    getfield [20] 
L18:    invokevirtual [25] 
L21:    aload_1 
L22:    ldc [6] 
L24:    invokevirtual [25] 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [21] 
L32:    invokevirtual [29] 
L35:    aload_0 
L36:    getfield [24] 
L39:    invokeinterface [39] 0 
L44:    istore_2 
L45:    iconst_0 
L46:    istore_3 
L47:    iload_3 
L48:    iload_2 
L49:    if_icmpge L150 
L52:    aload_0 
L53:    getfield [24] 
L56:    iload_3 
L57:    invokeinterface [40] 0 
L62:    checkcast [8] 
L65:    checkcast [8] 
L68:    astore 4 
L70:    aload_1 
L71:    ldc [13] 
L73:    invokevirtual [25] 
L76:    aload_1 
L77:    aload 4 
L79:    iconst_0 
L80:    laload 
L81:    invokevirtual [28] 
L84:    iconst_1 
L85:    istore 5 
L87:    iload 5 
L89:    aload 4 
L91:    arraylength 
L92:    if_icmpge L138 
L95:    aload 4 
L97:    iload 5 
L99:    laload 
L100:   lconst_0 
L101:   lcmp 
L102:   ifle L138 
L105:   iload 5 
L107:   iconst_1 
L108:   if_icmpne L117 
L111:   aload_1 
L112:   ldc [11] 
L114:   invokevirtual [25] 
L117:   aload_1 
L118:   aload 4 
L120:   iload 5 
L122:   laload 
L123:   invokevirtual [28] 
L126:   aload_1 
L127:   ldc [7] 
L129:   invokevirtual [25] 
L132:   iinc 5 1 
L135:   goto L87 
L138:   aload_1 
L139:   ldc [12] 
L141:   invokevirtual [29] 
L144:   iinc 3 1 
L147:   goto L47 
L150:   return 
L151:   nop 
L152:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Method [43] [44] 
.const [4] = Method [45] [46] 
.const [5] = String [47] 
.const [6] = String [48] 
.const [7] = String [49] 
.const [8] = Class [50] 
.const [9] = String [51] 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = String [54] 
.const [13] = String [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Field [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Field [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Class [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = Int 838860800 
.const [42] = Utf8 java/util/ArrayList 
.const [43] = Class [103] 
.const [44] = NameAndType [104] [105] 
.const [45] = Class [106] 
.const [46] = NameAndType [107] [108] 
.const [47] = Utf8 'AP-call: ' 
.const [48] = Utf8 '.' 
.const [49] = Utf8 ', ' 
.const [50] = Utf8 [J 
.const [51] = Utf8 '    ' 
.const [52] = Utf8 ' took: ' 
.const [53] = Utf8 ' sleeping: ' 
.const [54] = Utf8 '' 
.const [55] = Utf8 '  took: ' 
.const [56] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 de/audi/atip/util/ModelStatistics 
.const [59] = Utf8 java/lang/System 
.const [60] = Utf8 java/util/List 
.const [61] = Utf8 java/io/PrintStream 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Utf8 java/util/ArrayList 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Class [163] 
.const [100] = NameAndType [164] [165] 
.const [101] = Class [166] 
.const [102] = NameAndType [167] [168] 
.const [103] = Utf8 de/audi/atip/util/ModelStatistics 
.const [104] = Utf8 getSleepPeriods 
.const [105] = Utf8 ()[J 
.const [106] = Utf8 java/lang/System 
.const [107] = Utf8 arraycopy 
.const [108] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [109] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [110] = Utf8 ap 
.const [111] = Utf8 Ljava/lang/String; 
.const [112] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [113] = Utf8 apMethod 
.const [114] = Utf8 Ljava/lang/String; 
.const [115] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [116] = Utf8 calls 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [119] = Utf8 totalProcessingTime 
.const [120] = Utf8 J 
.const [121] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [122] = Utf8 criticalMethodCalls 
.const [123] = Utf8 Ljava/util/List; 
.const [124] = Utf8 java/io/PrintStream 
.const [125] = Utf8 print 
.const [126] = Utf8 (Ljava/lang/String;)V 
.const [127] = Utf8 java/io/PrintStream 
.const [128] = Utf8 print 
.const [129] = Utf8 (I)V 
.const [130] = Utf8 java/io/PrintStream 
.const [131] = Utf8 println 
.const [132] = Utf8 (J)V 
.const [133] = Utf8 java/io/PrintStream 
.const [134] = Utf8 print 
.const [135] = Utf8 (J)V 
.const [136] = Utf8 java/io/PrintStream 
.const [137] = Utf8 println 
.const [138] = Utf8 (Ljava/lang/String;)V 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 java/util/ArrayList 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (I)V 
.const [145] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [146] = Utf8 ap 
.const [147] = Utf8 Ljava/lang/String; 
.const [148] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [149] = Utf8 apMethod 
.const [150] = Utf8 Ljava/lang/String; 
.const [151] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [152] = Utf8 calls 
.const [153] = Utf8 I 
.const [154] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [155] = Utf8 totalProcessingTime 
.const [156] = Utf8 J 
.const [157] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [158] = Utf8 criticalMethodCalls 
.const [159] = Utf8 Ljava/util/List; 
.const [160] = Utf8 java/util/List 
.const [161] = Utf8 add 
.const [162] = Utf8 (Ljava/lang/Object;)Z 
.const [163] = Utf8 java/util/List 
.const [164] = Utf8 size 
.const [165] = Utf8 ()I 
.const [166] = Utf8 java/util/List 
.const [167] = Utf8 get 
.const [168] = Utf8 (I)Ljava/lang/Object; 
.const [169] = Utf8 de/audi/atip/util/ActionProxyStatistics$ActionProxyCallData 
.const [170] = Class [169] 
.const [171] = Utf8 java/lang/Object 
.const [172] = Class [171] 
.const [173] = Utf8 ap 
.const [174] = Utf8 Ljava/lang/String; 
.const [175] = Utf8 apMethod 
.const [176] = Utf8 Ljava/lang/String; 
.const [177] = Utf8 calls 
.const [178] = Utf8 I 
.const [179] = Utf8 totalProcessingTime 
.const [180] = Utf8 J 
.const [181] = Utf8 criticalMethodCalls 
.const [182] = Utf8 Ljava/util/List; 
.const [183] = Utf8 Code 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [186] = Utf8 addCall 
.const [187] = Utf8 (J)V 
.const [188] = Utf8 dump 
.const [189] = Utf8 (Ljava/io/PrintStream;)V 
.const [190] = Utf8 dumpCriticalCalls 
.const [191] = Utf8 (Ljava/io/PrintStream;)V 
.end class 
