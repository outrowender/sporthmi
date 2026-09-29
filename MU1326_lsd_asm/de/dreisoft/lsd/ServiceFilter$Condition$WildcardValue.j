.version 50 0 
.class public super [105] 
.super [107] 
.field private [108] [109] 
.field private [110] [111] 
.field private [112] [113] 

.method public [115] : [116] 
    .attribute [114] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [19] 
L9:     aload_0 
L10:    getfield [7] 
L13:    bipush 42 
L15:    invokevirtual [8] 
L18:    istore_3 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [7] 
L24:    iconst_0 
L25:    iload_3 
L26:    invokevirtual [9] 
L29:    putfield [20] 
L32:    aload_0 
L33:    aload_0 
L34:    getfield [7] 
L37:    iload_3 
L38:    iconst_1 
L39:    iadd 
L40:    invokevirtual [11] 
L43:    putfield [21] 
L46:    aload_0 
L47:    getfield [12] 
L50:    bipush 42 
L52:    invokevirtual [8] 
L55:    iconst_m1 
L56:    if_icmpeq L70 
L59:    new [22] 
L62:    dup 
L63:    ldc [3] 
L65:    aload_1 
L66:    invokespecial [18] 
L69:    athrow 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [114] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_1 
L7:     invokevirtual [13] 
L10:    astore_2 
L11:    aload_2 
L12:    invokevirtual [14] 
L15:    aload_0 
L16:    getfield [10] 
L19:    invokevirtual [14] 
L22:    aload_0 
L23:    getfield [12] 
L26:    invokevirtual [14] 
L29:    iadd 
L30:    if_icmplt L59 
L33:    aload_2 
L34:    aload_0 
L35:    getfield [10] 
L38:    invokevirtual [15] 
L41:    ifeq L59 
L44:    aload_2 
L45:    aload_0 
L46:    getfield [12] 
L49:    invokevirtual [16] 
L52:    ifeq L59 
L55:    iconst_1 
L56:    goto L60 
L59:    iconst_0 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public interface [119] : [120] 
    .attribute [114] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = String [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Field [28] [29] 
.const [8] = Method [30] [31] 
.const [9] = Method [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Class [58] 
.const [23] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [24] = Utf8 'filter syntax invalid: only one wildcard symbol allowed per value' 
.const [25] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/lang/String 
.const [28] = Class [59] 
.const [29] = NameAndType [60] [61] 
.const [30] = Class [62] 
.const [31] = NameAndType [63] [64] 
.const [32] = Class [65] 
.const [33] = NameAndType [66] [67] 
.const [34] = Class [68] 
.const [35] = NameAndType [69] [70] 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [59] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [60] = Utf8 valStr 
.const [61] = Utf8 Ljava/lang/String; 
.const [62] = Utf8 java/lang/String 
.const [63] = Utf8 indexOf 
.const [64] = Utf8 (I)I 
.const [65] = Utf8 java/lang/String 
.const [66] = Utf8 substring 
.const [67] = Utf8 (II)Ljava/lang/String; 
.const [68] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [69] = Utf8 prefix 
.const [70] = Utf8 Ljava/lang/String; 
.const [71] = Utf8 java/lang/String 
.const [72] = Utf8 substring 
.const [73] = Utf8 (I)Ljava/lang/String; 
.const [74] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [75] = Utf8 suffix 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 toString 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 java/lang/String 
.const [81] = Utf8 length 
.const [82] = Utf8 ()I 
.const [83] = Utf8 java/lang/String 
.const [84] = Utf8 startsWith 
.const [85] = Utf8 (Ljava/lang/String;)Z 
.const [86] = Utf8 java/lang/String 
.const [87] = Utf8 endsWith 
.const [88] = Utf8 (Ljava/lang/String;)Z 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [95] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [96] = Utf8 valStr 
.const [97] = Utf8 Ljava/lang/String; 
.const [98] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [99] = Utf8 prefix 
.const [100] = Utf8 Ljava/lang/String; 
.const [101] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [102] = Utf8 suffix 
.const [103] = Utf8 Ljava/lang/String; 
.const [104] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$WildcardValue 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 valStr 
.const [109] = Utf8 Ljava/lang/String; 
.const [110] = Utf8 prefix 
.const [111] = Utf8 Ljava/lang/String; 
.const [112] = Utf8 suffix 
.const [113] = Utf8 Ljava/lang/String; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [117] = Utf8 equals 
.const [118] = Utf8 (Ljava/lang/Object;)Z 
.const [119] = Utf8 toString 
.const [120] = Utf8 ()Ljava/lang/String; 
.end class 
