.version 50 0 
.class public super [19] 
.super [21] 
.implements [23] 
.field private static final [24] [25] 
.field private static final [26] [27] 

.method public annotation [29] : [30] 
    .attribute [28] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [4] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [31] : [32] 
    .attribute [28] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            0 : L38 
            1 : L28 
            default : L48 

L28:    aload_2 
L29:    iconst_1 
L30:    invokeinterface [5] 0 
L35:    goto L50 
L38:    aload_2 
L39:    iconst_0 
L40:    invokeinterface [5] 0 
L45:    goto L50 
L48:    iconst_0 
L49:    areturn 
L50:    iconst_1 
L51:    areturn 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [6] 
.const [3] = Class [7] 
.const [4] = Method [8] [9] 
.const [5] = InterfaceMethod [10] [11] 
.const [6] = Utf8 java/lang/Object 
.const [7] = Utf8 de/audi/atip/interapp/media/IMediaSDSService 
.const [8] = Class [12] 
.const [9] = NameAndType [13] [14] 
.const [10] = Class [15] 
.const [11] = NameAndType [16] [17] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Utf8 <init> 
.const [14] = Utf8 ()V 
.const [15] = Utf8 de/audi/atip/interapp/media/IMediaSDSService 
.const [16] = Utf8 mix 
.const [17] = Utf8 (Z)V 
.const [18] = Utf8 de/audi/app/sdsmanager/apps/media/MediaPlayModeEvo 
.const [19] = Class [18] 
.const [20] = Utf8 java/lang/Object 
.const [21] = Class [20] 
.const [22] = Utf8 de/audi/app/sdsmanager/apps/media/IMediaPlayModeStrategy 
.const [23] = Class [22] 
.const [24] = Utf8 PLAYMODE_MIX_OFF 
.const [25] = Utf8 I 
.const [26] = Utf8 PLAYMODE_MIX_ON 
.const [27] = Utf8 I 
.const [28] = Utf8 Code 
.const [29] = Utf8 <init> 
.const [30] = Utf8 ()V 
.const [31] = Utf8 executePlayMode 
.const [32] = Utf8 (ILde/audi/atip/interapp/media/IMediaSDSService;)Z 
.end class 
