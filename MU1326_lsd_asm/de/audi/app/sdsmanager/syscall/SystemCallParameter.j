.version 50 0 
.class public super [119] 
.super [121] 
.implements [123] 
.field private final [124] [125] 
.field private final [126] [127] 

.method public [129] : [130] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     iconst_2 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     iconst_3 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [137] : [138] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     iconst_1 
L5:     if_icmpne L25 
L8:     aload_0 
L9:     invokevirtual [20] 
L12:    checkcast [2] 
L15:    invokevirtual [21] 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     iconst_2 
L5:     if_icmpne L19 
L8:     aload_0 
L9:     invokevirtual [20] 
L12:    checkcast [3] 
L15:    invokevirtual [22] 
L18:    areturn 
L19:    iconst_m1 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     iconst_3 
L5:     if_icmpne L16 
L8:     aload_0 
L9:     invokevirtual [20] 
L12:    checkcast [4] 
L15:    areturn 
L16:    ldc [5] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [128] .code stack 2 locals 2 
L0:     new [31] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [17] 
L12:    iconst_1 
L13:    if_icmpne L21 
L16:    ldc [7] 
L18:    goto L49 
L21:    aload_0 
L22:    getfield [17] 
L25:    iconst_2 
L26:    if_icmpne L34 
L29:    ldc [8] 
L31:    goto L49 
L34:    aload_0 
L35:    getfield [17] 
L38:    iconst_3 
L39:    if_icmpne L47 
L42:    ldc [9] 
L44:    goto L49 
L47:    ldc [10] 
L49:    astore_2 
L50:    aload_1 
L51:    ldc [11] 
L53:    invokevirtual [23] 
L56:    aload_0 
L57:    getfield [17] 
L60:    invokevirtual [24] 
L63:    ldc [12] 
L65:    invokevirtual [23] 
L68:    aload_2 
L69:    invokevirtual [23] 
L72:    ldc [13] 
L74:    invokevirtual [23] 
L77:    ldc [14] 
L79:    invokevirtual [23] 
L82:    aload_0 
L83:    getfield [18] 
L86:    invokevirtual [25] 
L89:    pop 
L90:    aload_1 
L91:    invokevirtual [26] 
L94:    areturn 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = String [35] 
.const [6] = Class [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = String [41] 
.const [12] = String [42] 
.const [13] = String [43] 
.const [14] = String [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Method [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = Field [73] [74] 
.const [31] = Class [75] 
.const [32] = Utf8 java/lang/Boolean 
.const [33] = Utf8 java/lang/Integer 
.const [34] = Utf8 java/lang/String 
.const [35] = Utf8 '' 
.const [36] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [37] = Utf8 Boolean 
.const [38] = Utf8 Integer 
.const [39] = Utf8 String 
.const [40] = Utf8 UNK 
.const [41] = Utf8 'Type: ' 
.const [42] = Utf8 ' (' 
.const [43] = Utf8 '), ' 
.const [44] = Utf8 'Value: ' 
.const [45] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Class [88] 
.const [56] = NameAndType [89] [90] 
.const [57] = Class [91] 
.const [58] = NameAndType [92] [93] 
.const [59] = Class [94] 
.const [60] = NameAndType [95] [96] 
.const [61] = Class [97] 
.const [62] = NameAndType [98] [99] 
.const [63] = Class [100] 
.const [64] = NameAndType [101] [102] 
.const [65] = Class [103] 
.const [66] = NameAndType [104] [105] 
.const [67] = Class [106] 
.const [68] = NameAndType [107] [108] 
.const [69] = Class [109] 
.const [70] = NameAndType [110] [111] 
.const [71] = Class [112] 
.const [72] = NameAndType [113] [114] 
.const [73] = Class [115] 
.const [74] = NameAndType [116] [117] 
.const [75] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [76] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [77] = Utf8 type 
.const [78] = Utf8 I 
.const [79] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [80] = Utf8 value 
.const [81] = Utf8 Ljava/lang/Object; 
.const [82] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [83] = Utf8 getType 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [86] = Utf8 getValue 
.const [87] = Utf8 ()Ljava/lang/Object; 
.const [88] = Utf8 java/lang/Boolean 
.const [89] = Utf8 booleanValue 
.const [90] = Utf8 ()Z 
.const [91] = Utf8 java/lang/Integer 
.const [92] = Utf8 intValue 
.const [93] = Utf8 ()I 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [97] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [100] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [101] = Utf8 append 
.const [102] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [103] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [104] = Utf8 toString 
.const [105] = Utf8 ()Ljava/lang/String; 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [113] = Utf8 type 
.const [114] = Utf8 I 
.const [115] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [116] = Utf8 value 
.const [117] = Utf8 Ljava/lang/Object; 
.const [118] = Utf8 de/audi/app/sdsmanager/syscall/SystemCallParameter 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 de/audi/app/sdsmanager/syscall/ISystemCallParameter 
.const [123] = Class [122] 
.const [124] = Utf8 type 
.const [125] = Utf8 I 
.const [126] = Utf8 value 
.const [127] = Utf8 Ljava/lang/Object; 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/Boolean;)V 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/Integer;)V 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Ljava/lang/String;)V 
.const [135] = Utf8 getType 
.const [136] = Utf8 ()I 
.const [137] = Utf8 getValue 
.const [138] = Utf8 ()Ljava/lang/Object; 
.const [139] = Utf8 getBoolean 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 getInteger 
.const [142] = Utf8 ()I 
.const [143] = Utf8 getString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 toString 
.const [146] = Utf8 ()Ljava/lang/String; 
.end class 
