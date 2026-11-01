# Credenciales y Datos de Conexión

## Base de Datos (MySQL 8.0)

### Conexión desde el Host (fuera de Docker)

| Parámetro | Valor |
|-----------|-------|
| Host | `localhost` |
| Puerto | `3311` |
| Base de datos | `sistema_turnos` |
| Usuario | `root` |
| Contraseña | `root` (o el valor de `DB_PASSWORD`) |

**Ejemplo de conexión:**

```bash
mysql -h localhost -P 3311 -u root -p sistema_turnos
```

### Conexión desde el Backend (dentro de Docker)

| Parámetro | Valor |
|-----------|-------|
| Host | `mysql` (nombre del servicio Docker) |
| Puerto | `3306` (puerto interno del contenedor) |
| Base de datos | `sistema_turnos` |
| Usuario | `root` |
| Contraseña | `root` (o el valor de `DB_PASSWORD`) |

### Cadena JDBC completa

```
jdbc:mysql://mysql:3306/sistema_turnos?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
```

---

## Usuario Admin por Defecto

El sistema crea automáticamente un usuario administrador al iniciar por primera vez:

| Campo | Valor |
|-------|-------|
| **Usuario** | `admin` |
| **Contraseña** | `admin123` |
| **Rol** | `ADMIN` |

Este usuario permite acceder al panel de administración (`/admin`) para dar de alta médicos y ver estadísticas.

**Nota:** Cambia la contraseña en producción.

---

## Usuarios de Prueba (Pacientes)

Los pacientes se registran públicamente desde el frontend en `/register`. No hay usuarios precargados.

---

## Variables de Entorno del Backend

| Variable | Valor por Defecto | Descripción |
|----------|-------------------|-------------|
| `DB_HOST` | `localhost` | Host de MySQL |
| `DB_PORT` | `3306` | Puerto de MySQL |
| `DB_NAME` | `sistema_turnos` | Nombre de la base de datos |
| `DB_USER` | `root` | Usuario de MySQL |
| `DB_PASSWORD` | `root` | Contraseña de MySQL |
| `JWT_SECRET` | `cambiame-en-produccion...` | Secreto para firmar JWT |
| `CORS_ORIGINS` | `http://localhost:5173,http://localhost:3000` | Orígenes permitidos para CORS |

---

## Variables de Entorno del Frontend

| Variable | Valor por Defecto | Descripción |
|----------|-------------------|-------------|
| `VITE_API_URL` | `''` (vacío) | URL base de la API. En desarrollo usa el proxy de Vite. En producción con Docker, Nginx hace el proxy. |

---
