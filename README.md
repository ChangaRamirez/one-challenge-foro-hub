<!-- Improved compatibility of regresar al inicio link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![project_license][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/ChangaRamirez/challenge-literalura">
    <img src="https://github.com/ChangaRamirez/one-challenge-literalura/blob/main/assets/images/literalura-logo.png" alt="Logo" width="300" height="120">
  </a>

<h3 align="center">Foro Hub</h3>

  <p align="center">
    API REST para la gestión de tópicos en un foro, con funcionalidades de creación, listado, detalle, actualización y eliminación, protegida con autenticación JWT y conectada a base de datos MySQL.
    <br />
    <a href="https://github.com/ChangaRamirez/one-challenge-amigo-secreto"><strong>Explora los documentos »</strong></a>
    <br />
    <br />
    <a href="https://github.com/ChangaRamirez/one-challenge-amigo-secreto">Ver Demo</a>
    &middot;
    <a href="https://github.com/ChangaRamirez/one-challenge-amigo-secreto/issues/new?labels=bug&template=bug-report.md">Reportar Un Bug</a>
    &middot;
    <a href="https://github.com/ChangaRamirez/one-challenge-amigo-secreto/issues/new?labels=enhancement&template=feature-request.md">Solicitar Una Funcionalidad</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Tabla de Contenidos</summary>
  <ol>
    <li>
      <a href="#about-the-project">Acerca Del Proyecto</a>
      <ul>
        <li><a href="#built-with">Creado Con</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Empezando</a>
      <ul>
        <li><a href="#prerequisites">Prerequisitos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contribuyendo</a></li>
    <li><a href="#license">Licencia</a></li>
    <li><a href="#contact">Contacto</a></li>
    <li><a href="#acknowledgments">Reconocimientos</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Acerca Del Proyecto

<img src="https://github.com/ChangaRamirez/one-challenge-literalura/blob/main/assets/images/literalura-logo-transp.png" alt="Logo" width="500">

<!--Here's a blank template to get started. To avoid retyping too much info, do a search and replace with your text editor for the following: `ChangaRamirez`, `one-challenge-amigo-secreto`, `twitter_handle`, `linkedin_username`, `hotmail`, `laloraco`, `project_title`, `project_description`, `project_license`-->

### ¡Bienvenidos al foro más seguro y organizado de la historia!

Este proyecto nació con la idea de combinar el poder de Java con la robustez de Spring Boot para crear una API REST que gestione tópicos en un foro de forma segura y eficiente. 💬🔐

Aquí, nada de procesos manuales o datos sin protección: con esta aplicación podrás crear, listar, consultar, actualizar y eliminar tópicos, todo ello protegido mediante autenticación JWT y respaldado por una base de datos MySQL.

Durante el desarrollo, se implementaron Spring Security para la autenticación y autorización, Flyway para el control de versiones en la base de datos, y JPA/Hibernate para la persistencia de datos. Un recorrido técnico ideal para aprender sobre arquitecturas limpias, seguridad en APIs y operaciones CRUD completas.

Perfecto para proyectos de práctica, entornos de aprendizaje o como base para un foro real. Así que… ¿listo para levantar tu propia API de foro con seguridad y estilo? 🚀💻


![A Cool Gif](https://i.pinimg.com/originals/81/22/df/8122df968ad014a2cc8dcb9552bfdb02.gif)

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



### Creado con

* [![Java][Java]][Java-url]
* [![PostgreSQL][PostgreSQL]][PostgreSQL-url]
* [![SpringBoot][SpringBoot]][SpringBoot-url]
<!--* [![Next][Next.js]][Next-url]
* [![React][React.js]][React-url]
* [![Vue][Vue.js]][Vue-url]
* [![Angular][Angular.io]][Angular-url]
* [![Svelte][Svelte.dev]][Svelte-url]
* [![Laravel][Laravel.com]][Laravel-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]
* [![JQuery][JQuery.com]][JQuery-url]-->

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>

<!-- GETTING STARTED -->
## Empezando

Aquí van las instrucciones para poder visualizar el proyecto, ya sea desde un navegador web o si se desea, localmente desde tu computadora.
Para conseguir una copia local solo hay que seguir unos sencillos pasos.

### Prerequisitos

Al ser una aplicación Spring Boot con persistencia en base de datos, necesitarás tener configurado un entorno mínimo de desarrollo en Java. Para este proyecto utilicé Java 17, IntelliJ IDEA como editor, y una instancia local de MySQL para almacenar los datos.

También es necesario contar con Maven para la gestión de dependencias y Flyway (incluido en el proyecto) para el control de versiones de la base de datos.

Si solo quieres explorar el código, puedes revisar los archivos directamente desde este repositorio aquí en GitHub. No necesitas compilar nada para ver la estructura y la lógica del proyecto. 😉

### Instalación

1. Clonar el repositorio
   ```sh
   git clone https://github.com/ChangaRamirez/one-challenge-literalura.git
   ```
5. Cambiar el git remote url para evitar pushes accidentales al proyecto base
   ```sh
   git remote set-url origin ChangaRamirez/one-challenge-literalura
   git remote -v # confirmar los cambios
   ```
<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- USAGE EXAMPLES -->
## Uso

<div align=center><img src="assets/gifs/demo.gif" alt="Logo" width="500"></div>

 Este proyecto es una API REST para la gestión de un foro en línea, diseñada con Spring Boot, Spring Security y JWT. Te permite crear, listar, actualizar y eliminar tópicos, asegurando el acceso mediante autenticación basada en tokens.

Aquí tienes un vistazo de cómo sacarle provecho:

### Registrar un usuario e iniciar sesión
Para interactuar con la API, primero debes contar con un usuario registrado en la base de datos. Luego, realiza una solicitud POST /login enviando tus credenciales; la API devolverá un token JWT que deberás usar en todas las peticiones protegidas mediante el header:
```sh
   Authorization: Bearer <tu_token>
   ```

### Crear un nuevo tópico
Con tu token activo, puedes enviar una solicitud POST /topicos con un cuerpo en formato JSON que incluya título, mensaje, autor y curso. El servidor registrará la fecha de creación automáticamente y establecerá el estado inicial en ABIERTO.

### Listar todos los tópicos
Usa GET /topicos para obtener un listado paginado de todos los tópicos registrados, incluyendo título, mensaje, fecha de creación, estado, autor y curso.

## Consultar un tópico por ID
Con GET /topicos/{id}, podrás obtener todos los detalles de un tópico específico.

## Actualizar un tópico existente
Si necesitas modificar un título o mensaje, utiliza PUT /topicos/{id} enviando el nuevo contenido en el cuerpo de la solicitud. La API validará que el tópico exista antes de actualizarlo.


## Eliminar un tópico
Con DELETE /topicos/{id}, podrás eliminar definitivamente un tópico de la base de datos. Esta acción es irreversible, así que úsala con cuidado.

Ya estás listo para comenzar tu viaje en el mundo de los foros, con una API construida en Java, potenciada por Spring Boot y Spring Security, autenticada con JWT y respaldada por MySQL. Todo listo para ser consumido desde tu cliente favorito, como Insomnia o Postman. 💬💻

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- ROADMAP -->
## Roadmap

Este proyecto fue desarrollado paso a paso, integrando nuevas funcionalidades en cada iteración hasta convertirse en una API REST completa para la gestión de un foro con autenticación segura. A continuación, se detallan las etapas clave del desarrollo:

### ✅ 1. Configuración inicial del proyecto
Se creó la estructura base con Spring Boot, configurando dependencias para Spring Web, Spring Data JPA, Spring Security, JWT y MySQL.

### ✅ 2. Creación del modelo de dominio
Se definió la entidad Topico con sus atributos principales (título, mensaje, autor, curso, fecha de creación y estado), así como las relaciones necesarias con otras entidades.

### ✅ 3. Configuración de la base de datos y migraciones
Se configuró la conexión con MySQL y se implementaron scripts de migración con Flyway para la creación automática de tablas y datos iniciales.

### ✅ 4. Implementación de autenticación con JWT
Se desarrolló un sistema de autenticación con Spring Security y JSON Web Tokens, incluyendo el TokenService, un filtro de seguridad (SecurityFilter) y el endpoint /login.

### ✅ 5. Registro de tópicos
Se creó el endpoint POST /topicos para registrar nuevos tópicos en la base de datos, validando duplicados y asegurando que solo usuarios autenticados puedan realizar la acción.

### ✅ 6. Listado paginado de tópicos
Se implementó el endpoint GET /topicos para obtener un listado paginado con la información de todos los tópicos registrados.

### ✅ 7. Detalle de un tópico específico
Se agregó el endpoint GET /topicos/{id} para consultar un tópico individual por su ID, devolviendo todos sus datos.

### ✅ 8. Actualización de tópicos
Se implementó el endpoint PUT /topicos/{id} para modificar los datos de un tópico existente, validando su existencia antes de aplicar los cambios.

### ✅ 9. Eliminación de tópicos
Se creó el endpoint DELETE /topicos/{id} para borrar un tópico, verificando previamente que el registro exista en la base de datos.

Este roadmap refleja cómo el proyecto evolucionó desde una simple estructura base hasta convertirse en una API robusta y segura para la gestión de foros. 💬🚀

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- CONTRIBUTING -->
## Contribuyendo

Las contribuciones son lo que hace que la comunidad de código abierto sea un lugar tan increíble para aprender, inspirar y crear. Cualquier contribución que hagas será **muy apreciada**.

Si tienes una sugerencia que pueda mejorar esto, por favor haz un fork del repositorio y crea un pull request. También puedes abrir un issue con la etiqueta "enhancement" (mejora). ¡No olvides darle una estrella al proyecto! ¡Gracias nuevamente!

1. Haz un fork del proyecto
2. Crea tu rama de características (git checkout -b feature/AmazingFeature)
3. Haz commit de tus cambios (git commit -m 'Añadir una AmazingFeature')
4. Sube a la rama (git push origin feature/AmazingFeature)
5. Abre un pull request

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>

### Top contribuyentes:

<a href="https://github.com/ChangaRamirez/one-challenge-amigo-secreto/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=ChangaRamirez/one-challenge-amigo-secreto" alt="contrib.rocks image" />
</a>



<!-- LICENSE -->
## Licencia

Este proyecto es para uso personal y educativo exclusivamente. El uso comercial no está autorizado. Puedes leer más en [LICENCE.txt](LICENCE.txt)

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- CONTACT -->
## Contacto

Eduardo "Changa" Ramírez-García - laloraco@hotmail.com

Link del Proyecto: [https://github.com/ChangaRamirez/one-challenge-amigo-secreto](https://github.com/ChangaRamirez/one-challenge-amigo-secreto)

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Reconocimientos

* [Alura LATAM](https://www.aluracursos.com/)
* [ONE - Oracle Next Education](https://www.oracle.com/mx/education/oracle-next-education/)
* [Othneil Drew (tu plantilla README.md me salvó)](https://github.com/othneildrew)

<p align="right">(<a href="#readme-top">regresar al inicio</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/ChangaRamirez/one-challenge-amigo-secreto.svg?style=for-the-badge
[contributors-url]: https://github.com/ChangaRamirez/one-challenge-amigo-secreto/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/ChangaRamirez/one-challenge-amigo-secreto.svg?style=for-the-badge
[forks-url]: https://github.com/ChangaRamirez/one-challenge-amigo-secreto/network/members
[stars-shield]: https://img.shields.io/github/stars/ChangaRamirez/one-challenge-amigo-secreto.svg?style=for-the-badge
[stars-url]: https://github.com/ChangaRamirez/one-challenge-amigo-secreto/stargazers
[issues-shield]: https://img.shields.io/github/issues/ChangaRamirez/one-challenge-amigo-secreto.svg?style=for-the-badge
[issues-url]: https://github.com/ChangaRamirez/one-challenge-amigo-secreto/issues
[license-shield]: https://img.shields.io/github/license/ChangaRamirez/one-challenge-amigo-secreto.svg?style=for-the-badge
[license-url]: https://raw.githubusercontent.com/ChangaRamirez/one-challenge-amigo-secreto/refs/heads/main/LICENCE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/ramirezpaints/
[product-screenshot]: images/screenshot.png
[JavaScript]: https://shields.io/badge/JavaScript-F7DF1E?logo=JavaScript&logoColor=000&style=flat-square
[JavaScript-url]: https://www.javascript.com/
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/es/
[PostgreSQL]: https://img.shields.io/badge/postgresql-4169e1?style=for-the-badge&logo=postgresql&logoColor=white
[PostgreSQL-url]: https://www.postgresql.org/
[SpringBoot]: https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white
[SpringBoot-url]: https://spring.io/
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
