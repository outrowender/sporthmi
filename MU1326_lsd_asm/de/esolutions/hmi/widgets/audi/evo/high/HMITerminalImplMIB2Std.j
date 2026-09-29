.version 50 0 
.class public super [57] 
.super [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [9] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [63] : [64] 
    .attribute [60] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokeinterface [13] 0 
L9:     lookupswitch 
            0 : L47 
            1 : L36 
            default : L58 

L36:    new [14] 
L39:    dup 
L40:    invokespecial [10] 
L43:    astore_1 
L44:    goto L66 
L47:    new [15] 
L50:    dup 
L51:    invokespecial [11] 
L54:    astore_1 
L55:    goto L66 
L58:    new [14] 
L61:    dup 
L62:    invokespecial [10] 
L65:    astore_1 
L66:    aload_1 
L67:    areturn 
L68:    
    .end code 
.end method 

.method protected [65] : [66] 
    .attribute [60] .code stack 3 locals 0 
L0:     new [16] 
L3:     dup 
L4:     bipush 109 
L6:     invokespecial [12] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Field [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = InterfaceMethod [33] [34] 
.const [14] = Class [35] 
.const [15] = Class [36] 
.const [16] = Class [37] 
.const [17] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2StdPlus 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2Std 
.const [19] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/AnimationControllerMIB2Std 
.const [20] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2Std 
.const [21] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2High 
.const [22] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [23] = Class [38] 
.const [24] = NameAndType [39] [40] 
.const [25] = Class [41] 
.const [26] = NameAndType [42] [43] 
.const [27] = Class [44] 
.const [28] = NameAndType [45] [46] 
.const [29] = Class [47] 
.const [30] = NameAndType [48] [49] 
.const [31] = Class [50] 
.const [32] = NameAndType [51] [52] 
.const [33] = Class [53] 
.const [34] = NameAndType [54] [55] 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2StdPlus 
.const [36] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2Std 
.const [37] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/AnimationControllerMIB2Std 
.const [38] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2Std 
.const [39] = Utf8 framework 
.const [40] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2High 
.const [42] = Utf8 <init> 
.const [43] = Utf8 (ILorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [44] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2StdPlus 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/LayoutMIB2Std 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/AnimationControllerMIB2Std 
.const [51] = Utf8 <init> 
.const [52] = Utf8 (I)V 
.const [53] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [54] = Utf8 getScreenRes 
.const [55] = Utf8 ()I 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2Std 
.const [57] = Class [56] 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/HMITerminalImplMIB2High 
.const [59] = Class [58] 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (ILorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [63] = Utf8 generateLayout 
.const [64] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/Layout; 
.const [65] = Utf8 generateAnimationController 
.const [66] = Utf8 ()Lde/audi/atip/hmi/view/IAnimationController; 
.end class 
