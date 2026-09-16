PRIMERA ENTREGA - GENERACION Y CLASIFICACION DE DATOS
Estudiante: ELBER PEREZ ARDILA

Esta entrega corresponde a la primera fase del proyecto. Se implementa la clase
GenerateInfoFiles para generar archivos planos pseudoaleatorios que sirven como
entrada para la etapa posterior de procesamiento.

Requisitos cubiertos:
- Clase GenerateInfoFiles con metodo main.
- createSalesMenFile(int randomSalesCount, String name, long id).
- createProductsFile(int productsCount).
- createSalesManInfoFile(int salesmanCount).
- Generacion automatica sin solicitar informacion al usuario.
- Manejo basico de excepciones.
- Documentacion JavaDoc.
- Archivos de prueba incluidos en la carpeta data.

Ejecucion en Eclipse:
1. Crear un proyecto Java con Java 8.
2. Agregar GenerateInfoFiles.java a src.
3. Ejecutar Run As > Java Application.
4. Se generara/actualizara la carpeta data.

Los archivos de entrada siguen el formato establecido en la guia:
salesmanInfo.txt: TipoDocumento;NumeroDocumento;Nombres;Apellidos
products.txt: IDProducto;NombreProducto;PrecioPorUnidad
sales_<documento>_<nombre>.txt:
TipoDocumento;NumeroDocumento
IDProducto;CantidadVendida

NOTA:
La guia indica que la primera entrega se centra en GenerateInfoFiles y en la
generacion de los archivos planos que recibira el problema principal.
