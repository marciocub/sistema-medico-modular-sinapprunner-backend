# Stack Tecnológico

El sistema utiliza las siguientes tecnologías, seleccionadas para garantizar escalabilidad, mantenibilidad y seguridad.

## Backend (Java + Spring Boot)

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 21 | Lenguaje de programación principal |
| Spring Boot | 3.3.4 | Framework de aplicación |
| Spring Security | 6.x | Autenticación y autorización |
| Spring Data JPA | 6.x | Acceso a datos (ORM con Hibernate) |
| MySQL Connector/J | 8.3.0 | Driver JDBC para MySQL |
| MapStruct | 1.6.2 | Mapeo de objetos (DTO ↔ Entity) |
| Lombok | - | Reducción de código boilerplate |
| JWT (JJWT) | 0.12.6 | Tokens JWT (almacenados en cookies HttpOnly) |
| BCrypt | - | Hashing de contraseñas |
| Maven | 3.9 | Gestión de dependencias y build |

## Frontend (React.js + Vite)

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| React | 19.3.1 | Interfaz de usuario (componentes funcionales + Hooks) |
| Vite | 8.3.5 | Empaquetador y servidor de desarrollo |
| React Router DOM | 6.x | Navegación entre vistas |
| Axios | 1.x | Cliente HTTP con `withCredentials: true` |
| Tailwind CSS | 4.x | Estilos utility-first, diseño responsivo |
| Lucide React | - | Iconografía |
| date-fns | - | Manipulación de fechas y horas |

## Infraestructura

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Docker | - | Contenedorización |
| Docker Compose | v2.40.3 | Orquestación de servicios |
| MySQL | 8.0 | Base de datos relacional |
| Nginx | Alpine | Servidor web para el frontend (producción) |

---

## ¿Por qué estas tecnologías?

### Arquitectura Monolito Modular
Se eligió un **monolito modular** en lugar de microservicios porque:
- El dominio es coherente y acotado (gestión médica)
- Facilita el desarrollo y despliegue inicial
- Permite extraer módulos a microservicios en el futuro si es necesario
- Reduce la complejidad operativa en etapas tempranas

### Cookies HttpOnly + BFF
El patrón **Backend for Frontend (BFF)** con cookies HttpOnly protege las sesiones contra ataques XSS, ya que las cookies no son accesibles desde JavaScript.

### React + Vite
Vite ofrece tiempos de carga casi instantáneos y Hot Module Replacement (HMR) eficiente, ideal para desarrollo rápido de interfaces React.

---
