# Foro Hub

![imagen foro hub](https://github.com/user-attachments/assets/f8962c10-6899-44ef-9e9d-18e776eace80)


Una api que cuya funcionalidad es la crear endpoins utilizables y desbocar informacion necesaria en dichos puntos,
para este challenge proporfcionado por #AluraLatam y el programa #One de ORACLE, urilizamos JAVA Spring Boot, MySQL
librerias como spring security, spring web, spring JPA y Aouth0 para la generacion de tokens.

## Índice

* [Foro Hub](#Foro_Hub)

- [Índice](#índice)

- [Funcionalidades del proyecto](#Funcionalidades-del-proyecto)

- [Como usar el programa](#Como-usar-el-programa)

- [Partes del codigo](#Partes-del-codigo)

- [Tecnologías](#Tecnologías)

## :hammer:Funcionalidades del proyecto

- `Funcionalidad 1`: Generar un CRUD .
- `Funcionalidad 2`: Conectarlo con la base de datos.

## Como usar el programa
Descargas el proyecto de github y lo abres en tu ide.

Despues solo conectas con tu base de datos en el archivo application.properties.
![gestiornar base de datos](https://github.com/user-attachments/assets/a8ee491e-29bf-4740-b6b9-f29c1a3e82b0)

Con eso ejecutás el codigo y automaticamente deberias de poder correr correctamente la base de datos, por cierto
tu base de datos deberia ser llamada "topicos" para evitar errores de conexción.

Despues de eso habres tu program insomnia, postman o cualquier probador y depurador de API´s, con eso generaremos
nuestros Get, Post, Put y Delete de nuestros topicos, tambien generar nuestro Post de nuestro Usuario para obtener
nuestor token de autentificación. Recuerda que para nuestro Usuario ya deberas tener un email en base de datos y 
tambien una contraseña en formato hash bcrypt de preferencia.

Despues solo ingresa los datos de esta forma en el area que aparece ahí.
![Login foro hub](https://github.com/user-attachments/assets/de4fd77d-b411-4259-91b6-ec82967e6605)

Despues configuraremos las demas partes, asi se ve el Obtener datos especificos por nuestor id sin tener el token
activo.
![OTE foro hub SIN token](https://github.com/user-attachments/assets/f9ba8a5e-672a-4868-8ae0-761ea5e6a474)

Y asi teniendo el token activo.
![OTE foro hub con token](https://github.com/user-attachments/assets/19abfaf9-2c4f-4cfb-878c-d4a61bdfd0f0)

Asi se ve el  Actualizar Topico sin tener el token activo:
![AT foro hub SIN token](https://github.com/user-attachments/assets/d00d8442-f1d2-421c-989c-713b4a3ef3e8)

Y asi se ve el Actualizar Topico con el token activo:
![AT foro hub con token](https://github.com/user-attachments/assets/d646e614-b3e5-49e9-8afe-6ad100d4b218)

Tambien deberiamos crear nuestro mecanismo de Eliminar un elemento, para eso lo gestionaremos nuestro endpoint y al final 
agregaremos el un numero y nos retornara algo o nos dara algun error, aqui un ejemplo:

Aqui muestra un Delete teneindo su respectivo token:
![DEL FORO HUB CON TOKEN](https://github.com/user-attachments/assets/a50afddd-9545-45dc-b3fd-05ee63fa5a1b)

Aqui ya no tiene token:
![DEL FORO HUB SIN TOKEN](https://github.com/user-attachments/assets/38f44b34-9c8f-4f73-afd3-c26db5f19a89)

Despues tenemos que buscar a mostrar el listado de nuestros topicos y aqui tienes un ejemplo:
![LT con token](https://github.com/user-attachments/assets/49986848-2c5d-45b8-89a0-0f377653135e)

Ahora ya con el ultimo que seria la forma de generar un Post a nuestra base de datos:

![RT con token](https://github.com/user-attachments/assets/372815f6-d78f-47bf-9297-83f3fb42efff)

Recuerda poner los parametros exactos que se muestran ahi, ya que de lo contrario mostrara un error.



## Partes del codigo


### Carpeta Domain

Esta carpeta contiene 2 carpetas donde se encuetrarán el codigo para nuestros topicos y usuario, junto a sus dto, 
repositorios y clases correspondiente.


### Carpeta Controller

Ahi se encuentran nuestros controladores que permitiran esa conexcion mediante endpoint y el Crud de nuestro codigo.

### Carpeta Infra

Se encuentra la carpetaerrores que es la parte encargada de gestionar los errores que aparezcan al conectarse a la base
de datos. Y tambien esta la carpeta Security en la cual se encuentra todo el codigo referente a la generacion y autorizacion
de nuestros token.

### Carpeta Resources

Ahi se encuentra  todos los archivos de las migraciones con flyway y tambien nuestro archivo application.properties que conecta
la base de datos para que funciones todo.


## Tecnologías

- java 17
- MySQL
- Spring Boot
- Insomnia
- Spring Data JPA
- Spring Security
- Flyway
- Hibernate
- Validation I/o
- JWT
- Lombok
