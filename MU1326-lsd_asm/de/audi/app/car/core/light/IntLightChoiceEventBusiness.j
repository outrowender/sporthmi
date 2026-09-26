.version 50 0 
.class public super [80] 
.super [82] 

.method public [84] : [85] 
    .attribute [83] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [17] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [86] : [87] 
    .attribute [83] .code stack 5 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_3 
L5:     aload_0 
L6:     invokevirtual [11] 
L9:     invokevirtual [12] 
L12:    ifeq L32 
L15:    aload_0 
L16:    invokevirtual [11] 
L19:    ldc [3] 
L21:    ldc [4] 
L23:    aload_3 
L24:    invokevirtual [13] 
L27:    i2l 
L28:    invokevirtual [14] 
L31:    pop 
L32:    aload_3 
L33:    invokevirtual [13] 
L36:    ifle L84 
L39:    aload_3 
L40:    invokevirtual [13] 
L43:    bipush 9 
L45:    if_icmpge L84 
L48:    aload_3 
L49:    invokevirtual [13] 
L52:    aload_3 
L53:    invokevirtual [15] 
L56:    if_icmpne L68 
L59:    aload_2 
L60:    invokeinterface [19] 0 
L65:    goto L104 
L68:    aload_0 
L69:    invokespecial [18] 
L72:    aload_3 
L73:    invokevirtual [13] 
L76:    invokeinterface [20] 0 
L81:    goto L104 
L84:    aload_0 
L85:    invokevirtual [11] 
L88:    sipush 1000 
L91:    ldc [5] 
L93:    aload_3 
L94:    invokevirtual [13] 
L97:    i2l 
L98:    invokevirtual [14] 
L101:   pop 
L102:   iconst_0 
L103:   areturn 
L104:   iconst_1 
L105:   areturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method private [88] : [89] 
    .attribute [83] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     checkcast [6] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Int 1078071040 
.const [4] = String [22] 
.const [5] = String [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = InterfaceMethod [45] [46] 
.const [20] = InterfaceMethod [47] [48] 
.const [21] = Utf8 de/audi/app/car/core/light/IntLightChoiceHandlerTransactionData 
.const [22] = Utf8 '[IntLightChoiceEventBusiness#processItemSelected] Profile wit id = %1 has been selected' 
.const [23] = Utf8 'Profile id out of range: %1' 
.const [24] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [25] = Utf8 de/audi/app/car/core/light/IntLightChoiceEventBusiness 
.const [26] = Utf8 de/audi/app/car/common/handler/business/ChoiceModelEventBusinessAdapter 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Utf8 de/audi/app/car/common/handler/ChoiceModelHandler 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Utf8 de/audi/app/car/core/light/IntLightChoiceEventBusiness 
.const [50] = Utf8 getLogChannel 
.const [51] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 isInfo 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 de/audi/app/car/core/light/IntLightChoiceHandlerTransactionData 
.const [56] = Utf8 getNewSelected 
.const [57] = Utf8 ()I 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 log 
.const [60] = Utf8 (ILjava/lang/String;J)Z 
.const [61] = Utf8 de/audi/app/car/core/light/IntLightChoiceHandlerTransactionData 
.const [62] = Utf8 getOldSelected 
.const [63] = Utf8 ()I 
.const [64] = Utf8 de/audi/app/car/core/light/IntLightChoiceEventBusiness 
.const [65] = Utf8 getDSI 
.const [66] = Utf8 ()Lorg/dsi/ifc/base/DSIBase; 
.const [67] = Utf8 de/audi/app/car/common/handler/business/ChoiceModelEventBusinessAdapter 
.const [68] = Utf8 <init> 
.const [69] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Lde/audi/atip/log/LogChannel;)V 
.const [70] = Utf8 de/audi/app/car/core/light/IntLightChoiceEventBusiness 
.const [71] = Utf8 getDSICarLight 
.const [72] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.const [73] = Utf8 de/audi/app/car/common/handler/ChoiceModelHandler 
.const [74] = Utf8 fireEvent 
.const [75] = Utf8 ()V 
.const [76] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [77] = Utf8 setIntLightActiveProfile 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 de/audi/app/car/core/light/IntLightChoiceEventBusiness 
.const [80] = Class [79] 
.const [81] = Utf8 de/audi/app/car/common/handler/business/ChoiceModelEventBusinessAdapter 
.const [82] = Class [81] 
.const [83] = Utf8 Code 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lorg/dsi/ifc/carlight/DSICarLight;Lde/audi/atip/log/LogChannel;)V 
.const [86] = Utf8 processItemSelected 
.const [87] = Utf8 (Lde/audi/app/car/common/handler/business/HandlerTransactionData;Lde/audi/app/car/common/handler/ChoiceModelHandler;)Z 
.const [88] = Utf8 getDSICarLight 
.const [89] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.end class 
