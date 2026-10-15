# Sistema de Documentos - Patrón Prototype

## Descripción

Este proyecto consiste en una aplicación de consola desarrollada en Java que permite administrar plantillas de documentos mediante el patrón de diseño **Prototype**.

El sistema permite crear plantillas, generar copias a partir de ellas, modificar los documentos generados y consultar su información. Su objetivo es demostrar cómo se pueden crear nuevos objetos copiando otros existentes, sin tener que construirlos desde cero.

## Funcionalidades

- Crear plantillas de documentos.
- Consultar las plantillas disponibles.
- Clonar plantillas utilizando el patrón Prototype.
- Modificar los documentos generados.
- Consultar los documentos creados.
- Mantener las copias independientes de sus plantillas originales.

## Tipos de documentos

- **Propuesta comercial:** número, cliente, descripción, valor y vigencia.
- **Informe técnico:** título, responsable, área de trabajo, fecha y conclusiones.
- **Contrato de servicios:** número de contrato, contratista, entidad contratante, valor y duración.

## Tecnologías utilizadas

- Java
- Programación orientada a objetos (POO)
- Colecciones `ArrayList`
- Entrada de datos mediante `Scanner`
- Patrón de diseño Prototype

## Ejecución

Compila los archivos Java desde la terminal:

```bash
javac *.java
```

Ejecuta la aplicación:

```bash
java SistemaDocumentos
```

## Objetivo académico

Aplicar y comprender el patrón de diseño Prototype mediante un sistema sencillo de gestión de documentos, demostrando la creación de copias independientes y el uso de conceptos fundamentales de programación orientada a objetos.
