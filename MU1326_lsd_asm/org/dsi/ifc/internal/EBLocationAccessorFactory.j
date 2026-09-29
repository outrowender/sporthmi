.version 50 0 
.class public super [47] 
.super [49] 
.implements [51] 
.field static final [52] [53] 

.method public annotation [55] : [56] 
    .attribute [54] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [54] .code stack 3 locals 0 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L22 
L7:     new [11] 
L10:    dup 
L11:    aload_1 
L12:    checkcast [2] 
L15:    checkcast [2] 
L18:    invokespecial [7] 
L21:    areturn 
L22:    aconst_null 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [54] .code stack 4 locals 0 
L0:     new [11] 
L3:     dup 
L4:     iload_1 
L5:     iload_2 
L6:     invokespecial [8] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [54] .code stack 3 locals 0 
L0:     new [11] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [9] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [54] .code stack 1 locals 0 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L15 
L7:     aload_1 
L8:     checkcast [2] 
L11:    invokevirtual [5] 
L14:    areturn 
L15:    aconst_null 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [54] .code stack 3 locals 0 
L0:     new [11] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [10] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = String [14] 
.const [5] = Method [15] [16] 
.const [6] = Method [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Class [27] 
.const [12] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [13] = Utf8 java/lang/Object 
.const [14] = Utf8 EB-MIBHigh-20100902 
.const [15] = Class [28] 
.const [16] = NameAndType [29] [30] 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [28] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [29] = Utf8 getLocation 
.const [30] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 <init> 
.const [33] = Utf8 ()V 
.const [34] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [35] = Utf8 <init> 
.const [36] = Utf8 (Lorg/dsi/ifc/internal/EBLocationAccessor;)V 
.const [37] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [38] = Utf8 <init> 
.const [39] = Utf8 (II)V 
.const [40] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [41] = Utf8 <init> 
.const [42] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [43] = Utf8 org/dsi/ifc/internal/EBLocationAccessor 
.const [44] = Utf8 <init> 
.const [45] = Utf8 (Lorg/dsi/ifc/global/NavSegmentID;)V 
.const [46] = Utf8 org/dsi/ifc/internal/EBLocationAccessorFactory 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 org/dsi/ifc/navigation/util/ILocationAccessorFactory 
.const [51] = Class [50] 
.const [52] = Utf8 VERSION 
.const [53] = Utf8 Ljava/lang/String; 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 cloneLocationAccessor 
.const [58] = Utf8 (Lorg/dsi/ifc/navigation/util/ILocationAccessor;)Lorg/dsi/ifc/navigation/util/ILocationAccessor; 
.const [59] = Utf8 createLocationAccessorFromGeoPos 
.const [60] = Utf8 (II)Lorg/dsi/ifc/navigation/util/ILocationAccessor; 
.const [61] = Utf8 fromLocation 
.const [62] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/navigation/util/ILocationAccessor; 
.const [63] = Utf8 toLocation 
.const [64] = Utf8 (Lorg/dsi/ifc/navigation/util/ILocationAccessor;)Lorg/dsi/ifc/global/NavLocation; 
.const [65] = Utf8 fromTraceId 
.const [66] = Utf8 (Lorg/dsi/ifc/global/NavSegmentID;)Lorg/dsi/ifc/navigation/util/ILocationAccessor; 
.end class 
