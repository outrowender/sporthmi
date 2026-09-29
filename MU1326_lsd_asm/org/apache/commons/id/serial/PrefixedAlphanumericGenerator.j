.version 50 0 
.class public super [103] 
.super [105] 
.field private final [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     iload_3 
L3:     aload_1 
L4:     ifnonnull L11 
L7:     iconst_0 
L8:     goto L15 
L11:    aload_1 
L12:    invokevirtual [10] 
L15:    isub 
L16:    invokespecial [14] 
L19:    aload_1 
L20:    ifnonnull L33 
L23:    new [22] 
L26:    dup 
L27:    ldc [3] 
L29:    invokespecial [15] 
L32:    athrow 
L33:    iload_3 
L34:    aload_1 
L35:    invokevirtual [10] 
L38:    if_icmpgt L51 
L41:    new [23] 
L44:    dup 
L45:    ldc [5] 
L47:    invokespecial [16] 
L50:    athrow 
L51:    aload_0 
L52:    aload_1 
L53:    putfield [24] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public interface [111] : [112] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     getfield [11] 
L8:     invokevirtual [10] 
L11:    i2l 
L12:    ladd 
L13:    freturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     getfield [11] 
L8:     invokevirtual [10] 
L11:    i2l 
L12:    ladd 
L13:    freturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     getfield [11] 
L8:     invokevirtual [10] 
L11:    iadd 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [108] .code stack 3 locals 1 
L0:     new [25] 
L3:     dup 
L4:     aload_0 
L5:     getfield [11] 
L8:     invokespecial [20] 
L11:    astore_1 
L12:    aload_1 
L13:    aload_0 
L14:    invokespecial [21] 
L17:    invokevirtual [12] 
L20:    pop 
L21:    aload_1 
L22:    invokevirtual [13] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = String [27] 
.const [4] = Class [28] 
.const [5] = String [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Method [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Class [58] 
.const [23] = Class [59] 
.const [24] = Field [60] [61] 
.const [25] = Class [62] 
.const [26] = Utf8 java/lang/NullPointerException 
.const [27] = Utf8 'prefix must not be null' 
.const [28] = Utf8 java/lang/IllegalArgumentException 
.const [29] = Utf8 'size less prefix length must be at least one' 
.const [30] = Utf8 java/lang/StringBuffer 
.const [31] = Utf8 org/apache/commons/id/serial/PrefixedAlphanumericGenerator 
.const [32] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [33] = Utf8 java/lang/String 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
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
.const [58] = Utf8 java/lang/NullPointerException 
.const [59] = Utf8 java/lang/IllegalArgumentException 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 java/lang/String 
.const [64] = Utf8 length 
.const [65] = Utf8 ()I 
.const [66] = Utf8 org/apache/commons/id/serial/PrefixedAlphanumericGenerator 
.const [67] = Utf8 prefix 
.const [68] = Utf8 Ljava/lang/String; 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 append 
.const [71] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 toString 
.const [74] = Utf8 ()Ljava/lang/String; 
.const [75] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (ZI)V 
.const [78] = Utf8 java/lang/NullPointerException 
.const [79] = Utf8 <init> 
.const [80] = Utf8 (Ljava/lang/String;)V 
.const [81] = Utf8 java/lang/IllegalArgumentException 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Ljava/lang/String;)V 
.const [84] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [85] = Utf8 maxLength 
.const [86] = Utf8 ()J 
.const [87] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [88] = Utf8 minLength 
.const [89] = Utf8 ()J 
.const [90] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [91] = Utf8 getSize 
.const [92] = Utf8 ()I 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Ljava/lang/String;)V 
.const [96] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [97] = Utf8 nextStringIdentifier 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 org/apache/commons/id/serial/PrefixedAlphanumericGenerator 
.const [100] = Utf8 prefix 
.const [101] = Utf8 Ljava/lang/String; 
.const [102] = Utf8 org/apache/commons/id/serial/PrefixedAlphanumericGenerator 
.const [103] = Class [102] 
.const [104] = Utf8 org/apache/commons/id/serial/AlphanumericGenerator 
.const [105] = Class [104] 
.const [106] = Utf8 prefix 
.const [107] = Utf8 Ljava/lang/String; 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/String;ZI)V 
.const [111] = Utf8 getPrefix 
.const [112] = Utf8 ()Ljava/lang/String; 
.const [113] = Utf8 maxLength 
.const [114] = Utf8 ()J 
.const [115] = Utf8 minLength 
.const [116] = Utf8 ()J 
.const [117] = Utf8 getSize 
.const [118] = Utf8 ()I 
.const [119] = Utf8 nextStringIdentifier 
.const [120] = Utf8 ()Ljava/lang/String; 
.end class 
