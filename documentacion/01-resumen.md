# Sistema Médico Modular - Documentación del Proyecto

## Resumen Ejecutivo

El **Sistema Médico Modular** es una aplicación fullstack para la gestión de turnos médicos construida con una arquitectura monolito modular en el backend (Spring Boot + Java 21) y una aplicación frontend moderna (React.js + Vite). El sistema utiliza autenticación basada en cookies HttpOnly a través de un patrón BFF (Backend for Frontend), permitiendo que las sesiones viajen de forma segura entre el frontend y el backend.

### Arquitectura General

```
┌─────────────────────────────────────────────────────────────────────┐
│                         CLIENTE (Frontend)                          │
│                    React.js + Vite + Tailwind CSS                   │
│                          (puerto 3000)                              │
└──────────────────────────────────┬──────────────────────────────────┘
                                   │ HTTP + Cookies HttpOnly
                                   ▼
┌─────────────────────────────────────────────────────────────────────┐
│                        BACKEND (Spring Boot)                        │
│              Monolito Modular - Puerto 8080                         │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐  ┌────────────┐ │
│  │ Seguridad   │  │ Pacientes   │  │ Profesionales│ │ Turnos     │ │
│  │ Módulo      │  │ Módulo      │  │ Módulo       │  │ Módulo     │ │
│  └─────────────┘  └─────────────┘  └─────────────┘  └────────────┘ │
└──────────────────────────────────┬──────────────────────────────────┘
                                   │ JDBC
                                   ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      BASE DE DATOS (MySQL 8.0)                      │
│                         (puerto 3311 host)                          │
└─────────────────────────────────────────────────────────────────────┘
```

### Módulos del Backend

| Módulo | Responsabilidad |
|--------|-----------------|
| `modulo-seguridad` | Autenticación, autorización, gestión de usuarios y roles |
| `modulo-pacientes` | Registro y gestión de pacientes |
| `modulo-profesionales` | Gestión de médicos y especialidades |
| `modulo-turnos` | Gestión de turnos médicos |
| `app-runner` | Punto de entrada, configuración general, orquestación |

### Endpoints Principales

| Endpoint | Método | Descripción | Acceso |
|----------|--------|-------------|--------|
| `/api/auth/login` | POST | Iniciar sesión (establece cookie HttpOnly) | Público |
| `/api/auth/logout` | POST | Cerrar sesión | Autenticado |
| `/api/auth/me` | GET | Obtener usuario autenticado | Autenticado |
| `/api/pacientes/registro` | POST | Registrar nuevo paciente | Público |
| `/api/turnos` | GET/POST | Listar/crear turnos | Autenticado |
| `/api/profesionales` | GET | Listar médicos | Autenticado |
| `/api/especialidades` | GET | Listar especialidades | Autenticado |
| `/api/medicos` | POST | Crear médico | Solo ADMIN |

---

## 📁 Archivos de Documentación

Este directorio contiene los siguientes archivos:

| # | Archivo | Descripción |
|---|---------|-------------|
| 1 | `01-resumen.md` | Resumen general y arquitectura de alto nivel |
| 2 | `02-tecnologias.md` | Stack tecnológico completo y justificaciones |
| 3 | `03-arquitectura-modular.md` | Arquitectura modular, patrones y referencias |
| 4 | `04-levantar-nativo.md` | Paso a paso para ejecutar nativamente (Front + Back) |
| 5 | `05-levantar-docker.md` | Paso a paso para ejecutar con Docker Compose |
| 6 | `06-credenciales.md` | Credenciales de BD, usuario admin y configuración |

---

**Versión:** 1.0.0  
**Fecha:** 31/10/2026  
**Autor:** Equipo de Desarrollo
