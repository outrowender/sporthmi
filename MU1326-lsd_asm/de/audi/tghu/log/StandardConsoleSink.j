.version 50 0 
.class final super [157] 
.super [159] 
.implements [161] 
.implements [163] 
.field private static [164] [165] 
.field private [166] [167] 

.method public [169] : [170] 
    .attribute [168] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     invokevirtual [23] 
L8:     ldc [2] 
L10:    new [35] 
L13:    dup 
L14:    sipush 10000 
L17:    invokespecial [30] 
L20:    invokeinterface [36] 0 
L25:    pop 
L26:    aload_0 
L27:    ldc [4] 
L29:    invokestatic [5] 
L32:    putfield [37] 
L35:    return 
L36:    
    .end code 
.end method 

.method private [171] : [172] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifne L8 
L7:     return 
L8:     iload_2 
L9:     lookupswitch 
            1000 : L68 
            10000 : L78 
            100000 : L88 
            1000000 : L98 
            10000000 : L108 
            100000000 : L118 
            default : L128 

L68:    aload_1 
L69:    ldc [6] 
L71:    invokevirtual [25] 
L74:    pop 
L75:    goto L128 
L78:    aload_1 
L79:    ldc [7] 
L81:    invokevirtual [25] 
L84:    pop 
L85:    goto L128 
L88:    aload_1 
L89:    ldc [8] 
L91:    invokevirtual [25] 
L94:    pop 
L95:    goto L128 
L98:    aload_1 
L99:    ldc [9] 
L101:   invokevirtual [25] 
L104:   pop 
L105:   goto L128 
L108:   aload_1 
L109:   ldc [10] 
L111:   invokevirtual [25] 
L114:   pop 
L115:   goto L128 
L118:   aload_1 
L119:   ldc [11] 
L121:   invokevirtual [25] 
L124:   pop 
L125:   goto L128 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private [173] : [174] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifne L8 
L7:     return 
L8:     aload_1 
L9:     ldc [12] 
L11:    invokevirtual [25] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [175] : [176] 
    .attribute [168] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnull L51 
L4:     aload_0 
L5:     getstatic [13] 
L8:     aload_1 
L9:     invokeinterface [38] 0 
L14:    invokespecial [32] 
L17:    aload_1 
L18:    getstatic [13] 
L21:    invokeinterface [39] 0 
L26:    aload_0 
L27:    getstatic [13] 
L30:    invokespecial [33] 
L33:    getstatic [14] 
L36:    getstatic [13] 
L39:    invokevirtual [26] 
L42:    invokevirtual [27] 
L45:    getstatic [13] 
L48:    invokevirtual [28] 
L51:    return 
L52:    
    .end code 
.end method 

.method static [177] : [178] 
    .attribute [168] .code stack 3 locals 0 
L0:     new [40] 
L3:     dup 
L4:     sipush 300 
L7:     invokespecial [34] 
L10:    putstatic [31] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [41] 
.const [3] = Class [42] 
.const [4] = String [43] 
.const [5] = Method [44] [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = String [52] 
.const [13] = Field [53] [54] 
.const [14] = Field [55] [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Class [64] 
.const [23] = Method [65] [66] 
.const [24] = Field [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Field [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Class [89] 
.const [36] = InterfaceMethod [90] [91] 
.const [37] = Field [92] [93] 
.const [38] = InterfaceMethod [94] [95] 
.const [39] = InterfaceMethod [96] [97] 
.const [40] = Class [98] 
.const [41] = Utf8 all 
.const [42] = Utf8 java/lang/Integer 
.const [43] = Utf8 ANSICOLOR 
.const [44] = Class [99] 
.const [45] = NameAndType [100] [101] 
.const [46] = Utf8 '\x1b[0;40;35m' 
.const [47] = Utf8 '\x1b[0;40;31m' 
.const [48] = Utf8 '\x1b[0;40;33m' 
.const [49] = Utf8 '\x1b[0;40;32m' 
.const [50] = Utf8 '\x1b[0;40;36m' 
.const [51] = Utf8 '\x1b[0;40;34m' 
.const [52] = Utf8 '\x1b[0m' 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [58] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [59] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [60] = Utf8 java/util/Map 
.const [61] = Utf8 java/lang/Boolean 
.const [62] = Utf8 de/audi/atip/log/LogEntry 
.const [63] = Utf8 java/lang/System 
.const [64] = Utf8 java/io/PrintStream 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Class [141] 
.const [88] = NameAndType [142] [143] 
.const [89] = Utf8 java/lang/Integer 
.const [90] = Class [144] 
.const [91] = NameAndType [145] [146] 
.const [92] = Class [147] 
.const [93] = NameAndType [148] [149] 
.const [94] = Class [150] 
.const [95] = NameAndType [151] [152] 
.const [96] = Class [153] 
.const [97] = NameAndType [154] [155] 
.const [98] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [99] = Utf8 java/lang/Boolean 
.const [100] = Utf8 getBoolean 
.const [101] = Utf8 (Ljava/lang/String;)Z 
.const [102] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [103] = Utf8 buf 
.const [104] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [105] = Utf8 java/lang/System 
.const [106] = Utf8 out 
.const [107] = Utf8 Ljava/io/PrintStream; 
.const [108] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [109] = Utf8 getConfiguration 
.const [110] = Utf8 ()Ljava/util/Map; 
.const [111] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [112] = Utf8 ansiColorEnabled 
.const [113] = Utf8 Z 
.const [114] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [117] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [118] = Utf8 toString 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 java/io/PrintStream 
.const [121] = Utf8 println 
.const [122] = Utf8 (Ljava/lang/String;)V 
.const [123] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [124] = Utf8 clear 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/lang/Integer 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [133] = Utf8 buf 
.const [134] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [135] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [136] = Utf8 doWriteAnsiColorStart 
.const [137] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;I)V 
.const [138] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [139] = Utf8 doWriteAnsiColorStop 
.const [140] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 java/util/Map 
.const [145] = Utf8 put 
.const [146] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [147] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [148] = Utf8 ansiColorEnabled 
.const [149] = Utf8 Z 
.const [150] = Utf8 de/audi/atip/log/LogEntry 
.const [151] = Utf8 getLevel 
.const [152] = Utf8 ()I 
.const [153] = Utf8 de/audi/atip/log/LogEntry 
.const [154] = Utf8 print 
.const [155] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [156] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [157] = Class [156] 
.const [158] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [159] = Class [158] 
.const [160] = Utf8 de/audi/atip/log/LogSink 
.const [161] = Class [160] 
.const [162] = Utf8 de/audi/atip/log/IStandardConsoleLogSink 
.const [163] = Class [162] 
.const [164] = Utf8 buf 
.const [165] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [166] = Utf8 ansiColorEnabled 
.const [167] = Utf8 Z 
.const [168] = Utf8 Code 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 doWriteAnsiColorStart 
.const [172] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;I)V 
.const [173] = Utf8 doWriteAnsiColorStop 
.const [174] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [175] = Utf8 writeLog 
.const [176] = Utf8 (Lde/audi/atip/log/LogEntry;)V 
.const [177] = Utf8 <clinit> 
.const [178] = Utf8 ()V 
.end class 
