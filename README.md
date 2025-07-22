# 📚 MyBooks Backend - Sistema de Gestión de Biblioteca

API REST para gestión de libros desarrollada con Spring Boot y H2 Database.

## 🚀 Tecnologías

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **H2 Database** (En archivo para desarrollo, en memoria para producción)
- **Swagger/OpenAPI 3** para documentación
- **Lombok** para reducir boilerplate
- **Maven** para gestión de dependencias

## 📋 Funcionalidades

- ✅ CRUD completo de libros
- ✅ API REST con endpoints documentados
- ✅ Interfaz Swagger UI integrada
- ✅ Base de datos H2 con consola web (desarrollo)
- ✅ Configuración para deploy en Railway

## 🛠️ Configuración Local

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+ (o usar el wrapper incluido)

### Instalación y Ejecución

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/MyBooks-Bend.git
cd MyBooks-Bend

# Compilar y ejecutar
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 📖 API Endpoints

### Swagger UI
- **URL**: `http://localhost:8080/swagger-ui/index.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

### Base de Datos (Desarrollo)
- **H2 Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:file:./data/MyBooksDB`
- **Usuario**: `EttoreJunior`
- **Contraseña**: `DiosEsFiel1`

### Endpoints Principales

```
GET    /api/books          # Obtener todos los libros
GET    /api/books/{id}     # Obtener libro por ID
POST   /api/books          # Crear nuevo libro
PUT    /api/books/{id}     # Actualizar libro
DELETE /api/books/{id}     # Eliminar libro
```

## 🚀 Deploy en Railway

### Configuración Automática
El proyecto incluye:
- `nixpacks.toml` - Configuración de build para Railway
- `Procfile` - Comando de inicio
- `application-railway.properties` - Configuración para producción

### Pasos para Deploy

1. **Push al repositorio**:
   ```bash
   git add .
   git commit -m "Configure Railway deployment"
   git push origin main
   ```

2. **Crear proyecto en Railway**:
   - Ve a [railway.app](https://railway.app)
   - Conecta tu repositorio GitHub
   - Railway detectará automáticamente la configuración Java

3. **Variables de Entorno** (Opcional):
   ```
   SPRING_PROFILES_ACTIVE=railway
   H2_CONSOLE_ENABLED=false
   ```

4. **URLs después del deploy**:
   - API Base: `https://tu-proyecto.railway.app`
   - Swagger UI: `https://tu-proyecto.railway.app/swagger-ui/index.html`

### Diferencias Producción vs Desarrollo

| Aspecto | Desarrollo | Railway (Producción) |
|---------|------------|----------------------|
| Base de datos | Archivo local H2 | H2 en memoria |
| Puerto | 8080 | Variable $PORT |
| H2 Console | Habilitada | Deshabilitada |
| Logs SQL | Habilitados | Deshabilitados |

## 🔧 Configuración Avanzada

### Variables de Entorno Soportadas

- `PORT`: Puerto del servidor (Railway lo configura automáticamente)
- `DATABASE_URL`: URL de conexión a la base de datos
- `DB_USERNAME`: Usuario de la base de datos
- `DB_PASSWORD`: Contraseña de la base de datos
- `H2_CONSOLE_ENABLED`: Habilitar/deshabilitar consola H2
- `SPRING_PROFILES_ACTIVE`: Perfil activo de Spring

### Perfiles de Spring

- **default**: Configuración local con H2 en archivo
- **railway**: Configuración para Railway con H2 en memoria

## 🧪 Testing

```bash
# Ejecutar todos los tests
./mvnw test

# Compilar sin tests
./mvnw clean package -DskipTests=true

# Ejecutar con perfil específico
./mvnw spring-boot:run -Dspring-boot.run.profiles=railway
```

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── buchverwaltungssoftware/
│   │       └── mybooks/
│   │           ├── MyBooksApplication.java
│   │           └── books/
│   │               ├── Book.java              # Entidad
│   │               ├── BookController.java    # REST Controller
│   │               ├── BookService.java       # Lógica de negocio
│   │               ├── BookRepository.java    # Repositorio JPA
│   │               └── dtos/
│   │                   ├── BookDTO.java       # DTO de respuesta
│   │                   └── NewBookDTO.java    # DTO de creación
│   └── resources/
│       ├── application.properties             # Configuración base
│       └── application-railway.properties     # Configuración Railway
└── test/
    └── java/
        └── buchverwaltungssoftware/
            └── mybooks/
                └── MyBooksApplicationTests.java
```

## 🐛 Troubleshooting

### Problemas Comunes

1. **Error de puerto en Railway**:
   - Verificar que `server.port=${PORT:8080}` esté en application.properties

2. **Base de datos no persiste en Railway**:
   - Normal: Railway usa almacenamiento efímero. Los datos se recrean en cada deploy.
   - Para persistencia real, considerar migrar a PostgreSQL.

3. **Error de build**:
   - Verificar versión de Java 17
   - Limpiar cache: `./mvnw clean`

4. **H2 Console no funciona**:
   - En desarrollo: verificar que `spring.h2.console.enabled=true`
   - En Railway: está deshabilitada por seguridad

## 📝 Notas Importantes

- ⚠️ **Datos en Railway**: Se pierden en cada redeploy (H2 en memoria)
- 🔒 **Seguridad**: H2 Console deshabilitada en producción
- 📊 **Escalabilidad**: Para producción real, migrar a PostgreSQL/MySQL
- 🔧 **Logs**: Configurados para nivel INFO en producción

## 📄 Licencia

Este proyecto es de código abierto bajo la licencia MIT.

---

**Desarrollado por**: EttoreJunior  
**Versión**: 0.0.1-SNAPSHOT  
**Spring Boot**: 3.5.3
