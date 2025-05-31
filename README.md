# GitHub User Activity (EN)
GitHub User Activity (GHActivity) is a command-line tool developed in Java that allows users to fetch and display the recent public activity (up to a maximum of 30 events) of a specific GitHub user.

## Main Features

*   Displays recent events for a GitHub user.
*   Allows filtering activity by event type (e.g., "push", "create").
*   Allows specifying the number of events to display (maximum 30).
*   Provides a help text with usage instructions.
*   Lists valid event types for filtering.
*   Error handling for invalid requests or API failures.

## Usage Modes

The application supports several usage modes via command-line arguments:

### Username Only:
Displays the last 30 events for the specified user.
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <username>`

  Example:
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat`

### Username + Event Type:
Filters activity by the specified event type. The event type must be enclosed in quotes.
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <username> "<event_type>"`

  Example:
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat "push"`

### Username + Number of Events:
Displays the specified number of events (maximum 30; if the number is invalid or out of range, it defaults to 30).
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <username> <number_of_events>`

  Example:
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat 10`

### Username + Event Type + Number of Events:
Combines filtering by type and limiting the count.
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <username> "<event_type>" <number_of_events>`

  Example:
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat "push" 5`

### Show Valid Event Types:
Lists the event types that the application supports for filtering.
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity --events`

### Show Help:
Displays the help message with usage modes.
- **Usage:**
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity --help`

## Additional Notes
- **Build:** This program was built with JDK version 24.
- **Execution:** Designed for the command line (CLI).
- **Project:** This project was suggested by [roadmap.sh](https://roadmap.sh/projects/github-user-activity).



# GitHub User Activity (ES)
GitHub User Activity (GHActivity) es una herramienta de línea de comandos desarrollada en Java que permite a los usuarios obtener y visualizar la actividad pública reciente (hasta un máximo de 30 eventos) de un usuario específico de GitHub.

## Características Principales

*   Muestra los eventos recientes de un usuario de GitHub.
*   Permite filtrar la actividad por tipo de evento (ej. "push", "create").
*   Permite especificar el número de eventos a mostrar (máximo 30).
*   Proporciona un texto de ayuda con instrucciones de uso.
*   Lista los tipos de eventos válidos para el filtrado.
*   Manejo de errores para solicitudes inválidas o fallos de API.

## Modos de Uso

La aplicación soporta varios modos de uso a través de argumentos de línea de comandos:

### Solo Nombre de Usuario:
Muestra los últimos 30 eventos del usuario especificado.
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <nombre_de_usuario>`

  Ejemplo:  
  ` java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat`

### Nombre de Usuario + Tipo de Evento:
Filtra la actividad por el tipo de evento especificado. El tipo de evento debe ir entre comillas.
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <nombre_de_usuario> "<tipo_de_evento>"`

  Ejemplo:  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat "push"`

### Nombre de Usuario + Número de Eventos:
Muestra la cantidad especificada de eventos (máximo 30, si el número es inválido o está fuera de rango por defecto sera 30 ).
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <nombre_de_usuario> <numero_de_eventos>`

  Ejemplo:  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat 10`

### Nombre de Usuario + Tipo de Evento + Número de Eventos:
Combina el filtrado por tipo y la limitación de cantidad.
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity <nombre_de_usuario> "<tipo_de_evento>" <numero_de_eventos>`

  Ejemplo:  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity octocat "push" 5`

### Mostrar Tipos de Eventos Válidos:
Lista los tipos de eventos que la aplicación soporta para el filtrado.
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity --events`

### Mostrar Ayuda:
Muestra el mensaje de ayuda con los modos de uso.
- **Uso:**  
  `java -cp bin com.carlosescobar30.githubactivity.GHActivity --help`

## Notas adicionales
- **Construcción:** Este programa fue construido con el JDK versión 24.
- **Ejecución:** Diseñado para línea de comandos (CLI).
- **Proyecto:** Este proyecto fue sugerido por [roadmap.sh](https://roadmap.sh/projects/github-user-activity).
