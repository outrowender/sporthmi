.version 50 0 
.class super [139] 
.super [141] 
.implements [143] 
.field private final synthetic [144] [145] 

.method private [147] : [148] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [32] 
L5:     aload_0 
L6:     invokespecial [30] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [146] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 6 locals 3 
L0:     getstatic [3] 
L3:     astore_3 
L4:     aload_1 
L5:     invokestatic [4] 
L8:     aload_0 
L9:     getfield [24] 
L12:    invokestatic [5] 
L15:    invokeinterface [33] 0 
L20:    ifeq L100 
        .catch [14] from L23 to L74 using L77 
L23:    getstatic [6] 
L26:    ifnonnull L41 
L29:    ldc [7] 
L31:    invokestatic [8] 
L34:    dup 
L35:    putstatic [31] 
L38:    goto L44 
L41:    getstatic [6] 
L44:    ldc [9] 
L46:    iconst_1 
L47:    anewarray [10] 
L50:    dup 
L51:    iconst_0 
L52:    getstatic [11] 
L55:    aastore 
L56:    invokevirtual [25] 
L59:    aconst_null 
L60:    iconst_1 
L61:    anewarray [12] 
L64:    dup 
L65:    iconst_0 
L66:    getstatic [13] 
L69:    aastore 
L70:    invokevirtual [26] 
L73:    pop 
L74:    goto L162 
L77:    astore 4 
L79:    aload_0 
L80:    getfield [24] 
L83:    invokestatic [15] 
L86:    sipush 10000 
L89:    ldc [16] 
L91:    aload 4 
L93:    invokevirtual [27] 
L96:    pop 
L97:    goto L162 
        .catch [14] from L100 to L139 using L142 
        .catch [14] from L4 to L162 using L169 
        .catch [0] from L4 to L162 using L184 
L100:   getstatic [6] 
L103:   ifnonnull L118 
L106:   ldc [7] 
L108:   invokestatic [8] 
L111:   dup 
L112:   putstatic [31] 
L115:   goto L121 
L118:   getstatic [6] 
L121:   ldc [9] 
L123:   iconst_0 
L124:   anewarray [10] 
L127:   invokevirtual [25] 
L130:   aconst_null 
L131:   iconst_0 
L132:   anewarray [12] 
L135:   invokevirtual [26] 
L138:   pop 
L139:   goto L162 
L142:   astore 4 
L144:   aload_0 
L145:   getfield [24] 
L148:   invokestatic [15] 
L151:   sipush 10000 
L154:   ldc [16] 
L156:   aload 4 
L158:   invokevirtual [27] 
L161:   pop 
L162:   aload_3 
L163:   invokestatic [4] 
L166:   goto L193 
        .catch [0] from L169 to L177 using L184 
L169:   astore 4 
L171:   aload 4 
L173:   aload_1 
L174:   invokevirtual [28] 
L177:   aload_3 
L178:   invokestatic [4] 
L181:   goto L193 
        .catch [0] from L184 to L186 using L184 
L184:   astore 5 
L186:   aload_3 
L187:   invokestatic [4] 
L190:   aload 5 
L192:   athrow 
L193:   return 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method synthetic [153] : [154] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [34] 
.const [3] = Field [35] [36] 
.const [4] = Method [37] [38] 
.const [5] = Method [39] [40] 
.const [6] = Field [41] [42] 
.const [7] = String [43] 
.const [8] = Method [44] [45] 
.const [9] = String [46] 
.const [10] = Class [47] 
.const [11] = Field [48] [49] 
.const [12] = Class [50] 
.const [13] = Field [51] [52] 
.const [14] = Class [53] 
.const [15] = Method [54] [55] 
.const [16] = String [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Class [61] 
.const [22] = Class [62] 
.const [23] = Class [63] 
.const [24] = Field [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = Field [80] [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = Utf8 ThreadState 
.const [35] = Class [84] 
.const [36] = NameAndType [85] [86] 
.const [37] = Class [87] 
.const [38] = NameAndType [88] [89] 
.const [39] = Class [90] 
.const [40] = NameAndType [91] [92] 
.const [41] = Class [93] 
.const [42] = NameAndType [94] [95] 
.const [43] = Utf8 'com.microdoc.j9.Tools' 
.const [44] = Class [96] 
.const [45] = NameAndType [97] [98] 
.const [46] = Utf8 dumpThreadsInfo 
.const [47] = Utf8 java/lang/Class 
.const [48] = Class [99] 
.const [49] = NameAndType [100] [101] 
.const [50] = Utf8 java/lang/Object 
.const [51] = Class [102] 
.const [52] = NameAndType [103] [104] 
.const [53] = Utf8 java/lang/Exception 
.const [54] = Class [105] 
.const [55] = NameAndType [106] [107] 
.const [56] = Utf8 'Calling dumpThreadsInfo failed!' 
.const [57] = Utf8 de/audi/atip/error/ErrorManager$J9ThreadInfoProvider 
.const [58] = Utf8 java/lang/System 
.const [59] = Utf8 de/audi/atip/error/ErrorManager 
.const [60] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [61] = Utf8 java/lang/Boolean 
.const [62] = Utf8 java/lang/reflect/Method 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Class [123] 
.const [75] = NameAndType [124] [125] 
.const [76] = Class [126] 
.const [77] = NameAndType [127] [128] 
.const [78] = Class [129] 
.const [79] = NameAndType [130] [131] 
.const [80] = Class [132] 
.const [81] = NameAndType [133] [134] 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Utf8 java/lang/System 
.const [85] = Utf8 out 
.const [86] = Utf8 Ljava/io/PrintStream; 
.const [87] = Utf8 java/lang/System 
.const [88] = Utf8 setOut 
.const [89] = Utf8 (Ljava/io/PrintStream;)V 
.const [90] = Utf8 de/audi/atip/error/ErrorManager 
.const [91] = Utf8 access$600 
.const [92] = Utf8 (Lde/audi/atip/error/ErrorManager;)Lde/audi/atip/base/IFrameworkAccess; 
.const [93] = Utf8 de/audi/atip/error/ErrorManager 
.const [94] = Utf8 class$com$microdoc$j9$Tools 
.const [95] = Utf8 Ljava/lang/Class; 
.const [96] = Utf8 de/audi/atip/error/ErrorManager 
.const [97] = Utf8 class$ 
.const [98] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [99] = Utf8 java/lang/Boolean 
.const [100] = Utf8 TYPE 
.const [101] = Utf8 Ljava/lang/Class; 
.const [102] = Utf8 java/lang/Boolean 
.const [103] = Utf8 TRUE 
.const [104] = Utf8 Ljava/lang/Boolean; 
.const [105] = Utf8 de/audi/atip/error/ErrorManager 
.const [106] = Utf8 access$700 
.const [107] = Utf8 (Lde/audi/atip/error/ErrorManager;)Lde/audi/atip/log/LogChannel; 
.const [108] = Utf8 de/audi/atip/error/ErrorManager$J9ThreadInfoProvider 
.const [109] = Utf8 this$0 
.const [110] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [111] = Utf8 java/lang/Class 
.const [112] = Utf8 getMethod 
.const [113] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [114] = Utf8 java/lang/reflect/Method 
.const [115] = Utf8 invoke 
.const [116] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 log 
.const [119] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [120] = Utf8 java/lang/Exception 
.const [121] = Utf8 printStackTrace 
.const [122] = Utf8 (Ljava/io/PrintStream;)V 
.const [123] = Utf8 de/audi/atip/error/ErrorManager$J9ThreadInfoProvider 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/atip/error/ErrorManager;)V 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/atip/error/ErrorManager 
.const [130] = Utf8 class$com$microdoc$j9$Tools 
.const [131] = Utf8 Ljava/lang/Class; 
.const [132] = Utf8 de/audi/atip/error/ErrorManager$J9ThreadInfoProvider 
.const [133] = Utf8 this$0 
.const [134] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [135] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [136] = Utf8 isEvoStd 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 de/audi/atip/error/ErrorManager$J9ThreadInfoProvider 
.const [139] = Class [138] 
.const [140] = Utf8 java/lang/Object 
.const [141] = Class [140] 
.const [142] = Utf8 de/esolutions/fw/util/commons/error/DumpInfoProvider 
.const [143] = Class [142] 
.const [144] = Utf8 this$0 
.const [145] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Lde/audi/atip/error/ErrorManager;)V 
.const [149] = Utf8 getName 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 dump 
.const [152] = Utf8 (Ljava/io/PrintStream;Ljava/lang/String;)V 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/audi/atip/error/ErrorManager;Lde/audi/atip/error/ErrorManager$1;)V 
.end class 
