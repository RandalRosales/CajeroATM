Cajero ATM
# Cajero Automático en Java

Este proyecto es una simulación sencilla de un **cajero automático** usando Java. Permite consultar el saldo, retirar dinero y salir del sistema. Utiliza archivos binarios para guardar el saldo actual del usuario, asegurando persistencia entre ejecuciones del programa.

## Objetivo del Proyecto

El objetivo principal es demostrar el uso de:
- Archivos para almacenamiento de datos.
- Manejo de excepciones con `try-catch`
- Uso del componente `Scanner` para entrada de datos
- Menús interactivos en consola
- Validación de entradas

## ¿Cómo compilar y ejecutar el código?

### Requisitos

- Tener instalado **Java JDK** (versión 8 o superior)
- Tener configurado el entorno de desarrollo, ya sea:
  - Terminal (Command Prompt, PowerShell, Bash, etc.)
  - Un IDE como Visual Studio Code, el cual fue utilizado en este codigo.

### Instrucciones para compilar y ejecutar

1. Guardar el archivo con el nombre: `CajeroAutomatico.java`
2. Abrir una terminal en la carpeta donde guardaste el archivo
3. Compilar el programa con: javac CajeroAutomatico.java
4. Ejecutar el programa en la terminal con: java CajeroAutomatico

**Nota:** Este programa crea un archivo llamado `saldo.data`.
Si deseas cambiar la ruta, edita la constante ARCHIVO_SALDO al inicio del código.


### Instrucciones de uso del MENU

*********************
* Cajero Automático *
*********************

1. Consultar saldo
 * Muestra el saldo actual guardado en el archivo saldo.data.

2. Retirar dinero
 * Solicita al usuario un monto, verifica si hay suficiente dinero y, si es así, realiza el retiro y actualiza el archivo.

3. Salir
 * Cierra la aplicación con un mensaje de despedida.

# ADVERTENCIA: Si el usuario ingresa letras en lugar de números, el programa muestra un mensaje de error y solicita una nueva entrada.
# El sistema evita retiros mayores al saldo disponible.
# Se asegura que el archivo de saldo exista antes de cualquier operación.

### Autor: Randal Jazuary Cordón Rosales