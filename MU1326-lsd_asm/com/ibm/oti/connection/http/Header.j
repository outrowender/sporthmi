.version 50 0 
.class public super [113] 
.super [115] 
.field private static final [116] [117] 
.field private [118] [119] 
.field private [120] [121] 
.field private [122] [123] 

.method public [125] : [126] 
    .attribute [124] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     new [20] 
L8:     dup 
L9:     iconst_5 
L10:    invokespecial [18] 
L13:    putfield [21] 
L16:    aload_0 
L17:    new [22] 
L20:    dup 
L21:    iconst_5 
L22:    invokespecial [19] 
L25:    putfield [23] 
L28:    aload_0 
L29:    iconst_0 
L30:    putfield [24] 
L33:    aload_0 
L34:    iload_1 
L35:    putfield [24] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifne L18 
L7:     aload_0 
L8:     getfield [8] 
L11:    aload_1 
L12:    invokevirtual [10] 
L15:    ifnonnull L45 
L18:    aload_0 
L19:    getfield [7] 
L22:    aload_1 
L23:    invokevirtual [11] 
L26:    aload_0 
L27:    getfield [7] 
L30:    aload_0 
L31:    getfield [9] 
L34:    ifeq L41 
L37:    aload_2 
L38:    goto L42 
L41:    aconst_null 
L42:    invokevirtual [11] 
L45:    aload_1 
L46:    ifnonnull L62 
L49:    aload_0 
L50:    getfield [8] 
L53:    aload_0 
L54:    aload_2 
L55:    invokevirtual [12] 
L58:    pop 
L59:    goto L75 
L62:    aload_0 
L63:    getfield [8] 
L66:    aload_1 
L67:    invokevirtual [13] 
L70:    aload_2 
L71:    invokevirtual [12] 
L74:    pop 
L75:    return 
L76:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [124] .code stack 4 locals 0 
L0:     iload_1 
L1:     iflt L60 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [7] 
L9:     invokevirtual [14] 
L12:    iconst_2 
L13:    idiv 
L14:    if_icmpge L60 
L17:    aload_0 
L18:    getfield [9] 
L21:    ifeq L42 
L24:    aload_0 
L25:    getfield [7] 
L28:    iload_1 
L29:    iconst_2 
L30:    imul 
L31:    iconst_1 
L32:    iadd 
L33:    invokevirtual [15] 
L36:    checkcast [6] 
L39:    goto L59 
L42:    aload_0 
L43:    aload_0 
L44:    getfield [7] 
L47:    iload_1 
L48:    iconst_2 
L49:    imul 
L50:    invokevirtual [15] 
L53:    checkcast [6] 
L56:    invokevirtual [16] 
L59:    areturn 
L60:    aconst_null 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L16 
L4:     aload_0 
L5:     getfield [8] 
L8:     aload_0 
L9:     invokevirtual [10] 
L12:    checkcast [6] 
L15:    areturn 
L16:    aload_0 
L17:    getfield [8] 
L20:    aload_1 
L21:    invokevirtual [13] 
L24:    invokevirtual [10] 
L27:    checkcast [6] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [124] .code stack 3 locals 0 
L0:     iload_1 
L1:     iflt L31 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [7] 
L9:     invokevirtual [14] 
L12:    iconst_2 
L13:    idiv 
L14:    if_icmpge L31 
L17:    aload_0 
L18:    getfield [7] 
L21:    iload_1 
L22:    iconst_2 
L23:    imul 
L24:    invokevirtual [15] 
L27:    checkcast [6] 
L30:    areturn 
L31:    aconst_null 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [14] 
L7:     iconst_2 
L8:     idiv 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Field [30] [31] 
.const [8] = Field [32] [33] 
.const [9] = Field [34] [35] 
.const [10] = Method [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Class [56] 
.const [21] = Field [57] [58] 
.const [22] = Class [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Utf8 com/ibm/oti/connection/http/Header 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/util/Vector 
.const [28] = Utf8 java/util/Hashtable 
.const [29] = Utf8 java/lang/String 
.const [30] = Class [64] 
.const [31] = NameAndType [65] [66] 
.const [32] = Class [67] 
.const [33] = NameAndType [68] [69] 
.const [34] = Class [70] 
.const [35] = NameAndType [71] [72] 
.const [36] = Class [73] 
.const [37] = NameAndType [74] [75] 
.const [38] = Class [76] 
.const [39] = NameAndType [77] [78] 
.const [40] = Class [79] 
.const [41] = NameAndType [80] [81] 
.const [42] = Class [82] 
.const [43] = NameAndType [83] [84] 
.const [44] = Class [85] 
.const [45] = NameAndType [86] [87] 
.const [46] = Class [88] 
.const [47] = NameAndType [89] [90] 
.const [48] = Class [91] 
.const [49] = NameAndType [92] [93] 
.const [50] = Class [94] 
.const [51] = NameAndType [95] [96] 
.const [52] = Class [97] 
.const [53] = NameAndType [98] [99] 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Utf8 java/util/Vector 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Utf8 java/util/Hashtable 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Utf8 com/ibm/oti/connection/http/Header 
.const [65] = Utf8 props 
.const [66] = Utf8 Ljava/util/Vector; 
.const [67] = Utf8 com/ibm/oti/connection/http/Header 
.const [68] = Utf8 keyTable 
.const [69] = Utf8 Ljava/util/Hashtable; 
.const [70] = Utf8 com/ibm/oti/connection/http/Header 
.const [71] = Utf8 duplicates 
.const [72] = Utf8 Z 
.const [73] = Utf8 java/util/Hashtable 
.const [74] = Utf8 get 
.const [75] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [76] = Utf8 java/util/Vector 
.const [77] = Utf8 addElement 
.const [78] = Utf8 (Ljava/lang/Object;)V 
.const [79] = Utf8 java/util/Hashtable 
.const [80] = Utf8 put 
.const [81] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [82] = Utf8 java/lang/String 
.const [83] = Utf8 toLowerCase 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 java/util/Vector 
.const [86] = Utf8 size 
.const [87] = Utf8 ()I 
.const [88] = Utf8 java/util/Vector 
.const [89] = Utf8 elementAt 
.const [90] = Utf8 (I)Ljava/lang/Object; 
.const [91] = Utf8 com/ibm/oti/connection/http/Header 
.const [92] = Utf8 get 
.const [93] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/util/Vector 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (I)V 
.const [100] = Utf8 java/util/Hashtable 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (I)V 
.const [103] = Utf8 com/ibm/oti/connection/http/Header 
.const [104] = Utf8 props 
.const [105] = Utf8 Ljava/util/Vector; 
.const [106] = Utf8 com/ibm/oti/connection/http/Header 
.const [107] = Utf8 keyTable 
.const [108] = Utf8 Ljava/util/Hashtable; 
.const [109] = Utf8 com/ibm/oti/connection/http/Header 
.const [110] = Utf8 duplicates 
.const [111] = Utf8 Z 
.const [112] = Utf8 com/ibm/oti/connection/http/Header 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 incCapacity 
.const [117] = Utf8 I 
.const [118] = Utf8 props 
.const [119] = Utf8 Ljava/util/Vector; 
.const [120] = Utf8 keyTable 
.const [121] = Utf8 Ljava/util/Hashtable; 
.const [122] = Utf8 duplicates 
.const [123] = Utf8 Z 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Z)V 
.const [127] = Utf8 add 
.const [128] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [129] = Utf8 get 
.const [130] = Utf8 (I)Ljava/lang/String; 
.const [131] = Utf8 get 
.const [132] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [133] = Utf8 getKey 
.const [134] = Utf8 (I)Ljava/lang/String; 
.const [135] = Utf8 length 
.const [136] = Utf8 ()I 
.end class 
