.version 50 0 
.class public super [107] 
.super [109] 
.field private [110] [111] 
.field private [112] [113] 

.method public [115] : [116] 
    .attribute [114] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial [20] 
        .catch [6] from L4 to L23 using L52 
L4:     invokestatic [2] 
L7:     astore_1 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [12] 
L13:    putfield [22] 
L16:    aload_0 
L17:    getfield [13] 
L20:    ifnonnull L24 
L23:    return 
        .catch [6] from L24 to L49 using L52 
L24:    iconst_1 
L25:    anewarray [3] 
L28:    dup 
L29:    iconst_0 
L30:    getstatic [4] 
L33:    aastore 
L34:    astore_2 
L35:    aload_0 
L36:    aload_1 
L37:    invokevirtual [14] 
L40:    ldc [5] 
L42:    aload_2 
L43:    invokevirtual [15] 
L46:    putfield [23] 
L49:    goto L57 
L52:    astore_1 
L53:    aload_1 
L54:    invokevirtual [17] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [114] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [114] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L55 
        .catch [6] from L7 to L49 using L50 
L7:     iconst_1 
L8:     anewarray [7] 
L11:    dup 
L12:    iconst_0 
L13:    new [24] 
L16:    dup 
L17:    lload_1 
L18:    invokespecial [21] 
L21:    aastore 
L22:    astore_3 
L23:    aload_0 
L24:    getfield [16] 
L27:    aload_0 
L28:    getfield [13] 
L31:    aload_3 
L32:    invokevirtual [18] 
L35:    astore 4 
L37:    aload 4 
L39:    checkcast [8] 
L42:    invokevirtual [19] 
L45:    lstore 5 
L47:    lload 5 
L49:    freturn 
L50:    astore_3 
L51:    ldc2_w [25] 
L54:    freturn 
L55:    ldc2_w [25] 
L58:    freturn 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [27] [28] 
.const [3] = Class [29] 
.const [4] = Field [30] [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Method [39] [40] 
.const [13] = Field [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Class [63] 
.const [25] = Long -1L 
.const [27] = Class [64] 
.const [28] = NameAndType [65] [66] 
.const [29] = Utf8 java/lang/Class 
.const [30] = Class [67] 
.const [31] = NameAndType [68] [69] 
.const [32] = Utf8 sum 
.const [33] = Utf8 java/lang/Exception 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 java/lang/Long 
.const [36] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [37] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [38] = Utf8 java/lang/reflect/Method 
.const [39] = Class [70] 
.const [40] = NameAndType [71] [72] 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Utf8 java/lang/Long 
.const [64] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [65] = Utf8 getInstance 
.const [66] = Utf8 ()Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [67] = Utf8 java/lang/Long 
.const [68] = Utf8 TYPE 
.const [69] = Utf8 Ljava/lang/Class; 
.const [70] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [71] = Utf8 getOSInstance 
.const [72] = Utf8 ()Ljava/lang/Object; 
.const [73] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [74] = Utf8 osInstance 
.const [75] = Utf8 Ljava/lang/Object; 
.const [76] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [77] = Utf8 getOSClass 
.const [78] = Utf8 ()Ljava/lang/Class; 
.const [79] = Utf8 java/lang/Class 
.const [80] = Utf8 getDeclaredMethod 
.const [81] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [82] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [83] = Utf8 sumMethod 
.const [84] = Utf8 Ljava/lang/reflect/Method; 
.const [85] = Utf8 java/lang/Exception 
.const [86] = Utf8 printStackTrace 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/reflect/Method 
.const [89] = Utf8 invoke 
.const [90] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [91] = Utf8 java/lang/Long 
.const [92] = Utf8 longValue 
.const [93] = Utf8 ()J 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/lang/Long 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (J)V 
.const [100] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [101] = Utf8 osInstance 
.const [102] = Utf8 Ljava/lang/Object; 
.const [103] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [104] = Utf8 sumMethod 
.const [105] = Utf8 Ljava/lang/reflect/Method; 
.const [106] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [107] = Class [106] 
.const [108] = Utf8 java/lang/Object 
.const [109] = Class [108] 
.const [110] = Utf8 osInstance 
.const [111] = Utf8 Ljava/lang/Object; 
.const [112] = Utf8 sumMethod 
.const [113] = Utf8 Ljava/lang/reflect/Method; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 hasSum 
.const [118] = Utf8 ()Z 
.const [119] = Utf8 sum 
.const [120] = Utf8 (J)J 
.end class 
