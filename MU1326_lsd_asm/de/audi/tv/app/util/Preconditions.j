.version 50 0 
.class public super [37] 
.super [39] 

.method public annotation [41] : [42] 
    .attribute [40] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [43] : [44] 
    .attribute [40] .code stack 2 locals 0 
L0:     iload_0 
L1:     ifne L12 
L4:     new [10] 
L7:     dup 
L8:     invokespecial [8] 
L11:    athrow 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [45] : [46] 
    .attribute [40] .code stack 3 locals 0 
L0:     iload_0 
L1:     ifne L16 
L4:     new [10] 
L7:     dup 
L8:     aload_1 
L9:     invokestatic [3] 
L12:    invokespecial [9] 
L15:    athrow 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [40] .code stack 3 locals 0 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     new [10] 
L7:     dup 
L8:     ldc [4] 
L10:    invokespecial [9] 
L13:    athrow 
L14:    aload_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [49] : [50] 
    .attribute [40] .code stack 3 locals 0 
L0:     aload_0 
L1:     ifnonnull L16 
L4:     new [10] 
L7:     dup 
L8:     aload_1 
L9:     invokestatic [3] 
L12:    invokespecial [9] 
L15:    athrow 
L16:    aload_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Method [12] [13] 
.const [4] = String [14] 
.const [5] = Class [15] 
.const [6] = Class [16] 
.const [7] = Method [17] [18] 
.const [8] = Method [19] [20] 
.const [9] = Method [21] [22] 
.const [10] = Class [23] 
.const [11] = Utf8 java/lang/IllegalArgumentException 
.const [12] = Class [24] 
.const [13] = NameAndType [25] [26] 
.const [14] = Utf8 '[Preconditions.checkNotNull] Got a null reference' 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 java/lang/String 
.const [17] = Class [27] 
.const [18] = NameAndType [28] [29] 
.const [19] = Class [30] 
.const [20] = NameAndType [31] [32] 
.const [21] = Class [33] 
.const [22] = NameAndType [34] [35] 
.const [23] = Utf8 java/lang/IllegalArgumentException 
.const [24] = Utf8 java/lang/String 
.const [25] = Utf8 valueOf 
.const [26] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 java/lang/IllegalArgumentException 
.const [31] = Utf8 <init> 
.const [32] = Utf8 ()V 
.const [33] = Utf8 java/lang/IllegalArgumentException 
.const [34] = Utf8 <init> 
.const [35] = Utf8 (Ljava/lang/String;)V 
.const [36] = Utf8 de/audi/tv/app/util/Preconditions 
.const [37] = Class [36] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [38] 
.const [40] = Utf8 Code 
.const [41] = Utf8 <init> 
.const [42] = Utf8 ()V 
.const [43] = Utf8 checkArgument 
.const [44] = Utf8 (Z)V 
.const [45] = Utf8 checkArgument 
.const [46] = Utf8 (ZLjava/lang/Object;)V 
.const [47] = Utf8 checkNotNull 
.const [48] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [49] = Utf8 checkNotNull 
.const [50] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.end class 
