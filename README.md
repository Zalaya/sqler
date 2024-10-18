# **Sqler**

Sqler es un proyecto cuyo objetivo es proporcionar una herramienta útil que permita convertir archivos de datos estáticos, como archivos `.csv`, en tablas de datos que puedan ser accedidas y consultadas mediante el lenguaje SQL.

---

## **Proceso de conversión de datos**

El proceso de conversión de datos consta de dos pasos principales:

### 1. **Mapeo de datos**

En este primer paso, Sqler realiza la lectura y el mapeo de los datos a un formato interno. Este enfoque proporciona la ventaja de permitir trabajar con cualquier tipo de almacén de datos, sin necesidad de preocuparse por su conversión a SQL en este punto.

### 2. **Conversión a SQL**

En este segundo paso, se lleva a cabo la conversión de los datos mapeados a sentencias SQL. Dado que los datos ya han sido unificados en el paso anterior, Sqler se enfoca en la conversión de estos modelos de negocio en tablas SQL.
