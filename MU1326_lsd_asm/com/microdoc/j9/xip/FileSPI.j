.version 50 0 
.class public super [65] 
.super [67] 

.method public annotation [69] : [70] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [68] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnonnull L14 
L4:     new [15] 
L7:     dup 
L8:     ldc [4] 
L10:    invokespecial [13] 
L13:    athrow 
L14:    new [16] 
L17:    dup 
L18:    aload_1 
L19:    invokespecial [14] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_1 
L1:     checkcast [5] 
L4:     invokevirtual [7] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [68] .code stack 2 locals 1 
        .catch [6] from L0 to L8 using L9 
L0:     aload_1 
L1:     checkcast [5] 
L4:     aload_2 
L5:     invokevirtual [8] 
L8:     areturn 
L9:     astore_3 
L10:    aconst_null 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_1 
L1:     checkcast [5] 
L4:     aload_2 
L5:     invokevirtual [9] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_1 
L1:     checkcast [5] 
L4:     aload_2 
L5:     invokevirtual [10] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_1 
L1:     checkcast [5] 
L4:     invokevirtual [11] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = String [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Method [22] [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Class [38] 
.const [16] = Class [39] 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 java/lang/IllegalArgumentException 
.const [19] = Utf8 'Null classpath' 
.const [20] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [21] = Utf8 java/lang/ClassNotFoundException 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Utf8 java/lang/IllegalArgumentException 
.const [39] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [40] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [41] = Utf8 dispose 
.const [42] = Utf8 ()V 
.const [43] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [44] = Utf8 loadClass 
.const [45] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [46] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [47] = Utf8 loadJXE 
.const [48] = Utf8 (Ljava/lang/String;)V 
.const [49] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [50] = Utf8 unloadJXE 
.const [51] = Utf8 (Ljava/lang/String;)V 
.const [52] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [53] = Utf8 getLoadedJXEs 
.const [54] = Utf8 ()[Ljava/lang/String; 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 java/lang/IllegalArgumentException 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Ljava/lang/String;)V 
.const [61] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [62] = Utf8 <init> 
.const [63] = Utf8 ([Ljava/net/URL;)V 
.const [64] = Utf8 com/microdoc/j9/xip/FileSPI 
.const [65] = Class [64] 
.const [66] = Utf8 java/lang/Object 
.const [67] = Class [66] 
.const [68] = Utf8 Code 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 createClassLoader 
.const [72] = Utf8 ([Ljava/net/URL;)Ljava/lang/ClassLoader; 
.const [73] = Utf8 destroyClassloader 
.const [74] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [75] = Utf8 loadClass 
.const [76] = Utf8 (Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class; 
.const [77] = Utf8 loadXIPContainer 
.const [78] = Utf8 (Ljava/lang/ClassLoader;Ljava/lang/String;)V 
.const [79] = Utf8 unloadXIPContainer 
.const [80] = Utf8 (Ljava/lang/ClassLoader;Ljava/lang/String;)V 
.const [81] = Utf8 getLoadedXIPContainer 
.const [82] = Utf8 (Ljava/lang/ClassLoader;)[Ljava/lang/String; 
.end class 
