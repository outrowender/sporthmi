.version 50 0 
.class public super [43] 
.super [45] 
.implements [47] 
.implements [49] 
.field private [50] [51] 

.method public [53] : [54] 
    .attribute [52] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     invokespecial [8] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [55] : [56] 
    .attribute [52] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [8] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [52] .code stack 1 locals 0 
L0:     bipush 11 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [59] : [60] 
    .attribute [52] .code stack 3 locals 0 
L0:     new [10] 
L3:     dup 
L4:     ldc [3] 
L6:     invokespecial [9] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [11] 
L5:     aload_0 
L6:     iconst_1 
L7:     invokevirtual [7] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [63] : [64] 
    .attribute [52] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [52] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     ifnonnull L11 
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

.method public enum [67] : [68] 
    .attribute [52] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = String [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Field [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Class [24] 
.const [11] = Field [25] [26] 
.const [12] = Utf8 java/lang/UnsupportedOperationException 
.const [13] = Utf8 'Not implemented!' 
.const [14] = Utf8 de/audi/atip/hmi/model/DataModel 
.const [15] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [16] = Class [27] 
.const [17] = NameAndType [28] [29] 
.const [18] = Class [30] 
.const [19] = NameAndType [31] [32] 
.const [20] = Class [33] 
.const [21] = NameAndType [34] [35] 
.const [22] = Class [36] 
.const [23] = NameAndType [37] [38] 
.const [24] = Utf8 java/lang/UnsupportedOperationException 
.const [25] = Class [39] 
.const [26] = NameAndType [40] [41] 
.const [27] = Utf8 de/audi/atip/hmi/model/DataModel 
.const [28] = Utf8 data 
.const [29] = Utf8 Ljava/lang/Object; 
.const [30] = Utf8 de/audi/atip/hmi/model/DataModel 
.const [31] = Utf8 fireModelUpdateEvent 
.const [32] = Utf8 (I)V 
.const [33] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [34] = Utf8 <init> 
.const [35] = Utf8 (II)V 
.const [36] = Utf8 java/lang/UnsupportedOperationException 
.const [37] = Utf8 <init> 
.const [38] = Utf8 (Ljava/lang/String;)V 
.const [39] = Utf8 de/audi/atip/hmi/model/DataModel 
.const [40] = Utf8 data 
.const [41] = Utf8 Ljava/lang/Object; 
.const [42] = Utf8 de/audi/atip/hmi/model/DataModel 
.const [43] = Class [42] 
.const [44] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [45] = Class [44] 
.const [46] = Utf8 de/audi/atip/hmi/modelaccess/DataModelApp 
.const [47] = Class [46] 
.const [48] = Utf8 de/audi/atip/hmi/modelaccess/DataModelGUI 
.const [49] = Class [48] 
.const [50] = Utf8 data 
.const [51] = Utf8 Ljava/lang/Object; 
.const [52] = Utf8 Code 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (II)V 
.const [57] = Utf8 getModelType 
.const [58] = Utf8 ()I 
.const [59] = Utf8 copy 
.const [60] = Utf8 (Lde/audi/atip/hmi/model/AbstractModel;)V 
.const [61] = Utf8 set 
.const [62] = Utf8 (Ljava/lang/Object;)V 
.const [63] = Utf8 get 
.const [64] = Utf8 ()Ljava/lang/Object; 
.const [65] = Utf8 isEmpty 
.const [66] = Utf8 ()Z 
.const [67] = Utf8 resetListener 
.const [68] = Utf8 ()V 
.end class 
