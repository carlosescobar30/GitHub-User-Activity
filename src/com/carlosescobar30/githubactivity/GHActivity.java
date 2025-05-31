package com.carlosescobar30.githubactivity;

public class Main {
    public static void main(String[] args) {
        /*File file = new File("src/com/carlosescobar30/githubactivity/code.json");
        Scanner scanner = new Scanner(System.in);
        String gitHubUser = scanner.nextLine();
        while (!gitHubUser.equals("-exit")) {
            EventOutput.eventOutput(gitHubUser,30,"df");
            gitHubUser = scanner.nextLine();
        }*/
        String errorMessage = "Invalid request\nIf you need help, use the following flag: --help\nSolicitud no valida\nSi necesita ayuda use la siguiente flag: --help";

        if (args.length > 3){
            System.out.println(errorMessage);
        }

        switch (args.length){
            case 1 :

                if (args[0].equals("--help")){
                    System.out.println("This program displays recent GitHub user activity (up to a maximum of 30 events).\n" +
                            "\n" +
                            "USAGE:\n" +
                            "  my_program <username>\n" +
                            "  my_program <username> \"<event_type>\"\n" +
                            "  my_program <username> <number_of_events>\n" +
                            "  my_program <username> \"<event_type>\" <number_of_events>\n" +
                            "  my_program --events\n" +
                            "\n" +
                            "ARGUMENTS:\n" +
                            "  <username>          GitHub username.\n" +
                            "  \"<event_type>\"    (Optional) Event type to filter by (must be in quotes).\n" +
                            "                           Use '--events' to see the list of event types.\n" +
                            "  <number_of_events>     (Optional) Number of events to display (maximum 30).\n" +
                            "                           Values outside the 0-30 range will be treated as 30.\n" +
                            "\n" +
                            "OPTIONS:\n" +
                            "  --events                 Displays the list of all available GitHub event types for filtering.\n" +
                            "\n" +
                            "DETAILED USAGE MODES:\n" +
                            "  1. Username only:\n" +
                            "     my_program <username>\n" +
                            "     Displays recent activity for the specified user.\n" +
                            "\n" +
                            "  2. Username + event type:\n" +
                            "     my_program <username> \"<event_type>\"\n" +
                            "     Filters activity by the specified event type (e.g., \"push\", \"create\").\n" +
                            "\n" +
                            "  3. Username + number of events:\n" +
                            "     my_program <username> <number>\n" +
                            "     Displays the specified number of events for the user (max 30).\n" +
                            "\n" +
                            "  4. Username + event type + number of events:\n" +
                            "     my_program <username> \"<event_type>\" <number>\n" +
                            "     Combines event type filtering and limiting the number of events.\n" +
                            "\n" +
                            "NOTE:\n" +
                            "  * If there are not enough events matching the query, fewer (or no) results than requested will be displayed.");

                    System.out.println("Este programa muestra la actividad reciente de usuarios de GitHub (hasta un máximo de 30 eventos).\n" +
                            "\n" +
                            "USO:\n" +
                            "  mi_programa <usuario>\n" +
                            "  mi_programa <usuario> \"<tipo_de_evento>\"\n" +
                            "  mi_programa <usuario> <numero_de_eventos>\n" +
                            "  mi_programa <usuario> \"<tipo_de_evento>\" <numero_de_eventos>\n" +
                            "  mi_programa --events\n" +
                            "\n" +
                            "ARGUMENTOS:\n" +
                            "  <usuario>                  Nombre de usuario de GitHub.\n" +
                            "  \"<tipo_de_evento>\"         (Opcional) Tipo de evento por el que filtrar (entre comillas).\n" +
                            "                             Usa '--events' para ver la lista de tipos de evento.\n" +
                            "  <numero_de_eventos>        (Opcional) Cantidad de eventos a mostrar (máximo 30).\n" +
                            "                             Valores fuera del rango 0-30 se ajustarán a 30.\n" +
                            "\n" +
                            "OPCIONES:\n" +
                            "  --events                   Muestra la lista de todos los tipos de evento de GitHub disponibles para filtrar.\n" +
                            "\n" +
                            "MODOS DE USO DETALLADOS:\n" +
                            "  1. Solo usuario:\n" +
                            "     mi_programa <nombre_de_usuario>\n" +
                            "     Muestra la actividad reciente del usuario especificado.\n" +
                            "\n" +
                            "  2. Usuario + tipo de evento:\n" +
                            "     mi_programa <nombre_de_usuario> \"<tipo_del_evento>\"\n" +
                            "     Filtra la actividad por el tipo de evento especificado (ej. \"PushEvent\", \"CreateEvent\").\n" +
                            "\n" +
                            "  3. Usuario + número de eventos:\n" +
                            "     mi_programa <nombre_de_usuario> <numero>\n" +
                            "     Muestra la cantidad especificada de eventos para el usuario (máx. 30).\n" +
                            "\n" +
                            "  4. Usuario + tipo de evento + número de eventos:\n" +
                            "     mi_programa <nombre_de_usuario> \"<tipo_del_evento>\" <numero>\n" +
                            "     Combina el filtrado por tipo y la limitación de cantidad.\n" +
                            "\n" +
                            "NOTA:\n" +
                            "  * Si no hay suficientes eventos para la consulta, se mostrarán menos (o ningún) resultados de los solicitados.");
                }
        }
    }
}