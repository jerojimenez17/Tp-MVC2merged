# TP-Program3
Trabajo Practico grupal de Programacion 3 Unmdp
TP Final Programacion 3 unmdp






Patrones de diseño aplicados:

Patron State:
El patron State fue aplicado para controlar el estado de los tickets, se creo una interface IStateTicket donde se definen los metodos que cambian dicho estado:
 

Luego se creo una clase por cada estado posible del ticket, dichas clase implementa la interface antes mencionada.

Cada clase implementa los metodos segun corresponda, por ejemplo el metod activar desde la clase ActivarState va a retornar que el ticket ya esta activo, pero si es llamado desde otra clase puede activar el ticket.

Patron Observer-Observable:

Este patrón nos permite notificar a un observador cambios ocurridos dentro de un objeto “Observable”.
Lo utilizamos para la simulación con Threads, siendo cada Thread (Empleador y Empleado) Observados. El observador imprime en un TextField los cambios ocurridos con los TicketsSimplificados mediante el método “update”.

También usamos el patrón Observer-Observable en la clase ControladorVentanaEmpleado(Observador) y en la clase ControladorVentanaFormulario(Observado). En este caso el observado notifica un cambio, que es cerrar la ventana del formulario, ya sea con el botón aceptar o con el botón cancelar. De esta forma en el método  update() vuelve a escribir el ticket modificado y actualiza la lista de asignaciones del empleado.

Simulacion con Threads:

Empleador es el Thread productor, cada empleador tiene la posibilidad de crear tres tickets.
Empleado es el Thread consumidor, un empleado recorre la lista de tickets  que esta en BolsaDeTrabajos(Recurso compartido) buscando un ticket que concida con su Locacion pretendida, si hay uno lo remueve de la lista y si no el ticket queda en bolsa de trabajo.

Empleador(Productor):

 









Empleado(Consumidor):

 


Persistencia:

Para la persistencia  de la agencia elegimos los atributos que queremos persistir haciendo que los atributos no primitivos implementen la interfaz serializable y a los atributos que no queríamos persistir les pusimos la palabra reservada transient para que no sean serializados. Hicimos una serialización binaria de la agencia donde se serializó la agencia y en cascada todo lo elegido. Para la recuperación se recupera la agencia y se puede acceder a los demás elementos que se pedían serializar (lista de empleados, lista de empleadores, etc).

También hicimos una persistencia XML de la lista de empleados por separado para hacer de otra forma distinta y además para poder utilizar el patrón DTO ya que no todos los atributos tenían sus geters y seters. Creamos una clase utilDTO ue tiene metodos para pasar de un empleado a un empleadoDTO y viceversa.


Ventanas patron  MVC:

Para la parte de interfaz de comunicación con el usuario, si bien no llegamos a terminarla correctamente, aplicamos el patrón MVC (Model View Controller ) creando un controlador específico para cada tipo de ventana creada, desprendiendo así a la ventana  de todo el código del modelo. En la ventana se hacen algunas validaciones de datos de entrada, como por ejemplo activando y desactivando botones dependiendo de los valores ingresados o seleccionados. Por ejemplo en la VentanaRegistro se pueden completar los campos nombre de usuario, contraseña, nombre y seleccionar el tipo de usuario (Empleado o Empleador). Dependiendo del tipo de usuario seleccionado se habilitan los campos para terminar el registro de un empleado o un empleador. 
Las clases “controlador” son los vínculos de las ventanas con el código desarrollado en el modelo. Estos controladores implementan la interfaz ActionListener y sobreescribiendo el método actionPerformed(ActionEvent e) es como nos damos cuenta que fue lo que ocurrió en la ventana y ahí se hacen los llamados correspondientes al modelo para que resuelva
