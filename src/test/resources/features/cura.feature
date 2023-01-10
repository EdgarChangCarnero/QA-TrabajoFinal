Feature: Solicitar una atencion en la aplicación CURA Healthcare Service
    Rule: Yo como usuario necesito validar que mi solicitud de atención creada se genere de manera exitosa
        Background: Doy inicio ingresando a la aplicación
            Given que ingreso a la web cura healthcare service
        @regresion-exito
        Scenario Outline: Validar que los datos ingresados en la solicitud de atención creada fue exitosa
            When ingreso el usuario <username> y contrasenia <password>
            And realizo la solicitud de atencion ingresando el centro atencion <facility>, el programa <program>, la fecha <date> y un comentario <comment>
            Then valido que se genero la solicitud de atencion creada
            Examples: [HAPPY PATH]
                    | username | password           | facility                      | program  | date       | comment |
                    | John Doe | ThisIsNotAPassword | Tokyo CURA Healthcare Center  | Medicare | 14/01/2023 | Exito   |
        @regresion-error
        Scenario Outline: Validar que los datos ingresados en la solicitud de atención creada no fue exitosa
            When ingreso el usuario <username> y contrasenia <password>
            And realizo la solicitud de atencion ingresando el centro atencion <facility>, el programa <program>, la fecha <date> y un comentario <comment>
            Then valido que se genero la solicitud de atencion creada
            Examples: [UNHAPPY PATH]
                    | username | password           | facility                      | program  | date       | comment |
                    | Edgar    | ThisIsNotAPassword | Tokyo CURA Healthcare Center  | Medicare | 14/01/2023 | Exito   |