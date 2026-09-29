.version 50 0 
.class public super [130] 
.super [132] 
.implements [134] 
.field private static final [135] [136] 
.field private [137] [138] 
.field private volatile [139] [140] 

.method public [142] : [143] 
    .attribute [141] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     putfield [26] 
L11:    aload_0 
L12:    new [27] 
L15:    dup 
L16:    invokespecial [23] 
L19:    putfield [28] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [144] : [145] 
    .attribute [141] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [141] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [29] 
L7:     dup 
L8:     invokespecial [24] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [16] 
L16:    invokevirtual [18] 
L19:    ifeq L79 
L22:    new [30] 
L25:    dup 
L26:    invokespecial [25] 
L29:    astore_2 
L30:    aload_1 
L31:    invokeinterface [31] 0 
L36:    astore_3 
L37:    aload_3 
L38:    invokeinterface [32] 0 
L43:    ifeq L65 
L46:    aload_2 
L47:    aload_3 
L48:    invokeinterface [33] 0 
L53:    invokevirtual [19] 
L56:    ldc [6] 
L58:    invokevirtual [20] 
L61:    pop 
L62:    goto L37 
L65:    aload_0 
L66:    getfield [16] 
L69:    ldc [7] 
L71:    ldc [8] 
L73:    ldc [9] 
L75:    aload_2 
L76:    invokevirtual [21] 
L79:    aload_0 
L80:    aload_1 
L81:    putfield [28] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [34] [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = Class [38] 
.const [6] = String [39] 
.const [7] = Int -2137614336 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Field [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Class [70] 
.const [28] = Field [71] [72] 
.const [29] = Class [73] 
.const [30] = Class [74] 
.const [31] = InterfaceMethod [75] [76] 
.const [32] = InterfaceMethod [77] [78] 
.const [33] = InterfaceMethod [79] [80] 
.const [34] = Class [81] 
.const [35] = NameAndType [82] [83] 
.const [36] = Utf8 java/util/TreeSet 
.const [37] = Utf8 java/lang/IllegalArgumentException 
.const [38] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [39] = Utf8 ',' 
.const [40] = Utf8 '[%1#setCurrentlyLoadedGrammerRuleIDs] %2' 
.const [41] = Utf8 SDSGrammarStateImpl 
.const [42] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 java/util/SortedSet 
.const [47] = Utf8 java/util/Iterator 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Utf8 java/util/TreeSet 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Utf8 java/lang/IllegalArgumentException 
.const [74] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [75] = Class [120] 
.const [76] = NameAndType [121] [122] 
.const [77] = Class [123] 
.const [78] = NameAndType [124] [125] 
.const [79] = Class [126] 
.const [80] = NameAndType [127] [128] 
.const [81] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [82] = Utf8 getGrammarLog 
.const [83] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [85] = Utf8 lc 
.const [86] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [88] = Utf8 loadedGrammarIdSet 
.const [89] = Utf8 Ljava/util/SortedSet; 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 isDebug 
.const [92] = Utf8 ()Z 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 java/util/TreeSet 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 java/lang/IllegalArgumentException 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [115] = Utf8 lc 
.const [116] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [117] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [118] = Utf8 loadedGrammarIdSet 
.const [119] = Utf8 Ljava/util/SortedSet; 
.const [120] = Utf8 java/util/SortedSet 
.const [121] = Utf8 iterator 
.const [122] = Utf8 ()Ljava/util/Iterator; 
.const [123] = Utf8 java/util/Iterator 
.const [124] = Utf8 hasNext 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Utf8 next 
.const [128] = Utf8 ()Ljava/lang/Object; 
.const [129] = Utf8 de/audi/app/sdsmanager/grammar/SDSGrammarStateImpl 
.const [130] = Class [129] 
.const [131] = Utf8 java/lang/Object 
.const [132] = Class [131] 
.const [133] = Utf8 de/audi/app/sdsmanager/grammar/ISDSGrammarState 
.const [134] = Class [133] 
.const [135] = Utf8 LOGCLASS 
.const [136] = Utf8 Ljava/lang/String; 
.const [137] = Utf8 lc 
.const [138] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [139] = Utf8 loadedGrammarIdSet 
.const [140] = Utf8 Ljava/util/SortedSet; 
.const [141] = Utf8 Code 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 getCurrentlyLoadedGrammarRuleIDs 
.const [145] = Utf8 ()Ljava/util/SortedSet; 
.const [146] = Utf8 setCurrentlyLoadedGrammarRuleIDs 
.const [147] = Utf8 (Ljava/util/SortedSet;)V 
.end class 
