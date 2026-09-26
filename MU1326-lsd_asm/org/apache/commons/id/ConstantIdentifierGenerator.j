.version 50 0 
.class public super [61] 
.super [63] 
.field private final [64] [65] 

.method public static [67] : [68] 
    .attribute [66] .code stack 3 locals 0 
L0:     new [14] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [11] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     ldc [3] 
L7:     putfield [15] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [66] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new [16] 
L11:    dup 
L12:    ldc [5] 
L14:    invokespecial [13] 
L17:    athrow 
L18:    aload_0 
L19:    aload_1 
L20:    putfield [15] 
L23:    return 
L24:    
    .end code 
.end method 

.method public interface [73] : [74] 
    .attribute [66] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L9 
L7:     lconst_0 
L8:     freturn 
L9:     aload_0 
L10:    getfield [8] 
L13:    invokevirtual [9] 
L16:    i2l 
L17:    freturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = String [18] 
.const [4] = Class [19] 
.const [5] = String [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Field [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Class [35] 
.const [15] = Field [36] [37] 
.const [16] = Class [38] 
.const [17] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [18] = Utf8 '' 
.const [19] = Utf8 java/lang/IllegalArgumentException 
.const [20] = Utf8 'Constant identifier value must not be null' 
.const [21] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [22] = Utf8 java/lang/String 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [36] = Class [57] 
.const [37] = NameAndType [58] [59] 
.const [38] = Utf8 java/lang/IllegalArgumentException 
.const [39] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [40] = Utf8 identifier 
.const [41] = Utf8 Ljava/lang/String; 
.const [42] = Utf8 java/lang/String 
.const [43] = Utf8 length 
.const [44] = Utf8 ()I 
.const [45] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [46] = Utf8 maxLength 
.const [47] = Utf8 ()J 
.const [48] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (Ljava/lang/String;)V 
.const [51] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [52] = Utf8 <init> 
.const [53] = Utf8 ()V 
.const [54] = Utf8 java/lang/IllegalArgumentException 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Ljava/lang/String;)V 
.const [57] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [58] = Utf8 identifier 
.const [59] = Utf8 Ljava/lang/String; 
.const [60] = Utf8 org/apache/commons/id/ConstantIdentifierGenerator 
.const [61] = Class [60] 
.const [62] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [63] = Class [62] 
.const [64] = Utf8 identifier 
.const [65] = Utf8 Ljava/lang/String; 
.const [66] = Utf8 Code 
.const [67] = Utf8 getInstance 
.const [68] = Utf8 (Ljava/lang/String;)Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Ljava/lang/String;)V 
.const [73] = Utf8 nextStringIdentifier 
.const [74] = Utf8 ()Ljava/lang/String; 
.const [75] = Utf8 maxLength 
.const [76] = Utf8 ()J 
.const [77] = Utf8 minLength 
.const [78] = Utf8 ()J 
.end class 
