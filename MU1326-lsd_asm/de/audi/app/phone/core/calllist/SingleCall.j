.version 50 0 
.class public super [89] 
.super [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     invokespecial [17] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     astore_1 
L5:     aload_1 
L6:     invokestatic [2] 
L9:     ifeq L28 
L12:    new [21] 
L15:    dup 
L16:    aload_1 
L17:    invokevirtual [13] 
L20:    aload_1 
L21:    invokevirtual [14] 
L24:    invokespecial [18] 
L27:    areturn 
L28:    new [21] 
L31:    dup 
L32:    iconst_m1 
L33:    getstatic [4] 
L36:    invokespecial [18] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 2 locals 1 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [19] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [15] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokespecial [20] 
L20:    invokevirtual [15] 
L23:    pop 
L24:    aload_1 
L25:    ldc [7] 
L27:    invokevirtual [15] 
L30:    pop 
L31:    aload_1 
L32:    invokevirtual [16] 
L35:    areturn 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Class [25] 
.const [4] = Field [26] [27] 
.const [5] = Class [28] 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Class [53] 
.const [22] = Class [54] 
.const [23] = Class [55] 
.const [24] = NameAndType [56] [57] 
.const [25] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [26] = Class [58] 
.const [27] = NameAndType [59] [60] 
.const [28] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [29] = Utf8 SingleCall( 
.const [30] = Utf8 ')' 
.const [31] = Utf8 de/audi/app/phone/core/calllist/SingleCall 
.const [32] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [33] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [34] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [54] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [55] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [56] = Utf8 isPictureAvailable 
.const [57] = Utf8 (Lorg/dsi/ifc/global/ResourceLocator;)Z 
.const [58] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [59] = Utf8 UNDEFINED_URI 
.const [60] = Utf8 Ljava/lang/String; 
.const [61] = Utf8 de/audi/app/phone/core/calllist/SingleCall 
.const [62] = Utf8 getTelRemPictureId 
.const [63] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [64] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [65] = Utf8 getId 
.const [66] = Utf8 ()I 
.const [67] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [68] = Utf8 getUrl 
.const [69] = Utf8 ()Ljava/lang/String; 
.const [70] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [71] = Utf8 append 
.const [72] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [73] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [74] = Utf8 toString 
.const [75] = Utf8 ()Ljava/lang/String; 
.const [76] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Z)V 
.const [79] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (ILjava/lang/String;)V 
.const [82] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [86] = Utf8 toString 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 de/audi/app/phone/core/calllist/SingleCall 
.const [89] = Class [88] 
.const [90] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [91] = Class [90] 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;)V 
.const [95] = Utf8 getHMIResourceLocator 
.const [96] = Utf8 ()Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [97] = Utf8 toString 
.const [98] = Utf8 ()Ljava/lang/String; 
.end class 
