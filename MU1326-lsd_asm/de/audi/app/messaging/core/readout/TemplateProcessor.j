.version 50 0 
.class public final super [121] 
.super [123] 

.method public annotation [125] : [126] 
    .attribute [124] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [127] : [128] 
    .attribute [124] .code stack 3 locals 5 
L0:     aload_0 
L1:     astore_2 
L2:     aload_1 
L3:     invokeinterface [22] 0 
L8:     invokeinterface [23] 0 
L13:    astore_3 
L14:    aload_3 
L15:    invokeinterface [24] 0 
L20:    ifeq L70 
L23:    aload_3 
L24:    invokeinterface [25] 0 
L29:    checkcast [2] 
L32:    astore 4 
L34:    aload 4 
L36:    invokeinterface [26] 0 
L41:    checkcast [3] 
L44:    astore 5 
L46:    aload 4 
L48:    invokeinterface [27] 0 
L53:    checkcast [3] 
L56:    astore 6 
L58:    aload_2 
L59:    aload 5 
L61:    aload 6 
L63:    invokestatic [4] 
L66:    astore_2 
L67:    goto L14 
L70:    aload_2 
L71:    areturn 
L72:    
    .end code 
.end method 

.method private static [129] : [130] 
    .attribute [124] .code stack 4 locals 5 
L0:     aload_0 
L1:     astore_3 
L2:     aload_0 
L3:     invokestatic [5] 
L6:     ifne L107 
L9:     aload_1 
L10:    invokestatic [5] 
L13:    ifne L107 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [14] 
L21:    istore 4 
L23:    iload 4 
L25:    iconst_m1 
L26:    if_icmpeq L107 
L29:    aload_2 
L30:    ifnonnull L38 
L33:    ldc [6] 
L35:    goto L39 
L38:    aload_2 
L39:    astore 5 
L41:    aload_0 
L42:    invokevirtual [15] 
L45:    aload_1 
L46:    invokevirtual [15] 
L49:    isub 
L50:    aload 5 
L52:    invokevirtual [15] 
L55:    iadd 
L56:    istore 6 
L58:    new [28] 
L61:    dup 
L62:    iload 6 
L64:    invokespecial [21] 
L67:    astore 7 
L69:    aload 7 
L71:    aload_0 
L72:    invokevirtual [16] 
L75:    pop 
L76:    aload 7 
L78:    iload 4 
L80:    iload 4 
L82:    aload_1 
L83:    invokevirtual [15] 
L86:    iadd 
L87:    invokevirtual [17] 
L90:    pop 
L91:    aload 7 
L93:    iload 4 
L95:    aload 5 
L97:    invokevirtual [18] 
L100:   pop 
L101:   aload 7 
L103:   invokevirtual [19] 
L106:   astore_3 
L107:   aload_3 
L108:   areturn 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Method [31] [32] 
.const [5] = Method [33] [34] 
.const [6] = String [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = InterfaceMethod [59] [60] 
.const [23] = InterfaceMethod [61] [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Class [71] 
.const [29] = Utf8 java/util/Map$Entry 
.const [30] = Utf8 java/lang/String 
.const [31] = Class [72] 
.const [32] = NameAndType [73] [74] 
.const [33] = Class [75] 
.const [34] = NameAndType [76] [77] 
.const [35] = Utf8 '' 
.const [36] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [37] = Utf8 de/audi/app/messaging/core/readout/TemplateProcessor 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 java/util/Map 
.const [40] = Utf8 java/util/Set 
.const [41] = Utf8 java/util/Iterator 
.const [42] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Class [117] 
.const [70] = NameAndType [118] [119] 
.const [71] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [72] = Utf8 de/audi/app/messaging/core/readout/TemplateProcessor 
.const [73] = Utf8 replaceFirst 
.const [74] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [75] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [76] = Utf8 isNullOrEmpty 
.const [77] = Utf8 (Ljava/lang/String;)Z 
.const [78] = Utf8 java/lang/String 
.const [79] = Utf8 indexOf 
.const [80] = Utf8 (Ljava/lang/String;)I 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 length 
.const [83] = Utf8 ()I 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 append 
.const [86] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 delete 
.const [89] = Utf8 (II)Lde/esolutions/fw/util/commons/Buffer; 
.const [90] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [91] = Utf8 insert 
.const [92] = Utf8 (ILjava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 toString 
.const [95] = Utf8 ()Ljava/lang/String; 
.const [96] = Utf8 java/lang/Object 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (I)V 
.const [102] = Utf8 java/util/Map 
.const [103] = Utf8 entrySet 
.const [104] = Utf8 ()Ljava/util/Set; 
.const [105] = Utf8 java/util/Set 
.const [106] = Utf8 iterator 
.const [107] = Utf8 ()Ljava/util/Iterator; 
.const [108] = Utf8 java/util/Iterator 
.const [109] = Utf8 hasNext 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 java/util/Iterator 
.const [112] = Utf8 next 
.const [113] = Utf8 ()Ljava/lang/Object; 
.const [114] = Utf8 java/util/Map$Entry 
.const [115] = Utf8 getKey 
.const [116] = Utf8 ()Ljava/lang/Object; 
.const [117] = Utf8 java/util/Map$Entry 
.const [118] = Utf8 getValue 
.const [119] = Utf8 ()Ljava/lang/Object; 
.const [120] = Utf8 de/audi/app/messaging/core/readout/TemplateProcessor 
.const [121] = Class [120] 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [122] 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 replaceVariables 
.const [128] = Utf8 (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String; 
.const [129] = Utf8 replaceFirst 
.const [130] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.end class 
