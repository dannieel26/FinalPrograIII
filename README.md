# **Manual Técnico y de Usuario - SIRVE**
## Sistema Inteligente de Registro de Vehículos y Evaluación

---

## **Manual Técnico**

### **1. Descripción General del Proyecto**
SIRVE es una aplicación que permite gestionar registros de vehículos, incluyendo operaciones como búsqueda, inserción, modificación, eliminación de vehículos, y visualización de multas y traspasos asociados. Además, el sistema ofrece funcionalidades para la evaluación del rendimiento de los árboles de datos utilizados, así como la encriptación y desencriptación de los datos almacenados en el árbol.

### **2. Requisitos del Sistema**
- **Java 8 o superior**.
- **IDE recomendado**: IntelliJ IDEA, Eclipse o NetBeans.
- **JDK**: Requiere el JDK 8 o superior para la compilación y ejecución.

### **3. Estructura del Proyecto**

#### **Paquete: `controller`**
Contiene las clases encargadas de gestionar las operaciones del sistema:
- **ControladorVehiculos**: Gestiona las operaciones sobre los vehículos, como insertar, eliminar, y buscar vehículos en un árbol de búsqueda binaria o AVL.
- **ControladorMultas**: Se encarga de cargar y gestionar las multas asociadas a los vehículos.
- **ControladorTraspasos**: Permite gestionar los traspasos de vehículos.
- **ControladorRendimiento**: Realiza comparaciones de rendimiento entre diferentes estructuras de árbol.
- **ControladorEstadisticas**: Proporciona estadísticas relacionadas con los vehículos, multas y traspasos.

#### **Paquete: `datastructures`**
Contiene las implementaciones de las estructuras de datos:
- **Arbol**: Interfaz común para todas las estructuras de árbol.
- **ArbolBinarioBusqueda**: Implementación de un árbol binario de búsqueda.
- **ArbolAVL**: Implementación de un árbol AVL.
- **ArbolVisualizer**: Herramienta para visualizar la estructura de los árboles en formato SVG.
- **ListaDoble**: Implementación de una lista doblemente enlazada.
- **ListaCircular**: Implementación de una lista circular.

#### **Paquete: `model`**
Contiene las clases de modelos de datos:
- **Vehiculo**: Representa un vehículo con todos sus atributos.
- **Multa**: Representa una multa asociada a un vehículo.
- **Traspaso**: Representa un traspaso de un vehículo entre dos personas.

#### **Paquete: `utils`**
Contiene clases de utilidad:
- **EncriptadorArbol**: Implementa la encriptación y desencriptación de los datos del árbol.
- **Encriptacion**: Implementa el algoritmo de encriptación César para la encriptación y desencriptación de los árboles.
- **LectorVehiculos**: Carga los vehículos desde un archivo de texto.
- **LectorMultas**: Carga las multas asociadas a los vehículos.
- **LectorTraspasos**: Carga los traspasos de los vehículos.

#### **Paquete: `gui`**
Contiene la interfaz gráfica de usuario (GUI) utilizando `Swing`:
- **VentanaPrincipal**: La ventana principal de la aplicación, donde se gestionan las operaciones de los vehículos, multas, traspasos, y más.

### **4. Funcionamiento Interno**
El sistema utiliza árboles binarios y AVL para organizar los vehículos. Cada vehículo se asocia con un archivo de texto que contiene su información (placa, DPI, marca, modelo, multas y traspasos). Los árboles permiten realizar operaciones de inserción, eliminación y búsqueda de vehículos de manera eficiente.

El sistema también permite visualizar estadísticas, realizar análisis de rendimiento, y encriptar/desencriptar los datos utilizando el algoritmo César para asegurar la confidencialidad de la información.

---

## **Manual de Usuario**

### **1. Introducción**
Este sistema permite gestionar y consultar información sobre vehículos, multas, traspasos, y otras estadísticas asociadas. Además, permite realizar análisis de rendimiento sobre las estructuras de datos utilizadas.

### **2. Funcionalidades Principales**

#### **2.1 Gestión de Vehículos**
- **Buscar Vehículo**: Permite buscar vehículos mediante la placa. Se puede ingresar una parte de la placa para obtener resultados coincidentes.
- **Insertar Vehículo**: Permite agregar un nuevo vehículo al sistema, ingresando los datos como placa, DPI, nombre, marca, modelo, año, multas y traspasos.
- **Modificar Vehículo**: Permite modificar los datos de un vehículo existente en el sistema.
- **Eliminar Vehículo**: Permite eliminar un vehículo del sistema.

#### **2.2 Gestión de Multas**
- **Buscar Multa**: Permite buscar las multas asociadas a un vehículo mediante la placa.
- **Visualizar Multas**: Muestra una lista de todas las multas asociadas a la placa de un vehículo.

#### **2.3 Gestión de Traspasos**
- **Buscar Traspaso**: Permite buscar los traspasos realizados para un vehículo usando su placa.
- **Visualizar Traspasos**: Muestra una lista con los traspasos realizados para un vehículo.

#### **2.4 Estadísticas**
- **Estadísticas de Vehículos**: Permite ver estadísticas sobre los vehículos con más multas o traspasos.
- **Estadísticas de Eventos (Multas y Traspasos)**: Muestra estadísticas sobre los eventos ocurridos, como el mes con más eventos.

#### **2.5 Análisis de Rendimiento**
- **Comparación de Rendimiento**: Compara el rendimiento de las operaciones en un árbol binario de búsqueda frente a un árbol AVL. Muestra el tiempo de inserción y búsqueda de los vehículos en ambos tipos de árbol.

#### **2.6 Encriptación y Desencriptación**
- **Encriptar Árbol**: Permite encriptar los datos del árbol (vehículos) utilizando el algoritmo César.
- **Desencriptar Árbol**: Permite desencriptar el archivo encriptado previamente.

### **3. Interfaz Gráfica**
La interfaz gráfica está dividida en varias secciones, cada una con funcionalidades específicas:
- **Panel de Vehículos**: Permite gestionar los vehículos mediante un árbol de búsqueda binaria o AVL, con opciones de inserción, eliminación, modificación y búsqueda.
- **Panel de Multas**: Permite gestionar y visualizar las multas de los vehículos.
- **Panel de Traspasos**: Permite gestionar y visualizar los traspasos de los vehículos.
- **Panel de Estadísticas**: Muestra estadísticas sobre los vehículos, multas y traspasos.
- **Panel de Análisis de Rendimiento**: Muestra la comparación del rendimiento de los árboles binarios y AVL.
- **Panel de Encriptación**: Permite encriptar y desencriptar los datos.

### **4. Uso del Sistema**
1. **Inicio del Sistema**: Al iniciar el sistema, el usuario verá las opciones de elegir un tipo de árbol (Binario o AVL).
2. **Seleccionar un Departamento**: Al elegir un departamento, el sistema cargará los vehículos desde el archivo correspondiente.
3. **Operaciones con Vehículos**: El usuario puede realizar búsquedas, inserciones, modificaciones y eliminaciones de vehículos desde el panel correspondiente.
4. **Visualización de Multas y Traspasos**: A través de los paneles de multas y traspasos, el usuario puede consultar la información relacionada con las infracciones y los cambios de titularidad de los vehículos.

---

