# 📺 API REST de Series

API REST para gestionar un catálogo de series de TV (CRUD) con **Spring Boot 3, Spring Data JPA, H2 y Lombok**.

## Requisitos
- Java 17 o superior
- Maven 3.8+ (o usar el de tu IDE: IntelliJ / VS Code)

## Cómo ejecutar
```bash
git clone <URL-DE-TU-REPO>
cd api-series
mvn spring-boot:run
```
La API queda en `http://localhost:8080/api/series`

Consola H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:seriesdb`
- Usuario: `sa` — Contraseña: (vacía)

## Estructura
```
src/main/java/com/puce/series/
├── controller/   SerieController, ManejadorErrores
├── service/      SerieService
├── repository/   SerieRepository
└── models/       Serie
```

## Entidad Serie
| Campo | Tipo | Descripción |
|---|---|---|
| id | Long | Autogenerado |
| titulo | String | Nombre de la serie |
| plataforma | String | Netflix, HBO, Prime, Disney+... |
| calificacion | Double | Del 1 al 10 |

## Endpoints
| Método | URL | Descripción | Respuesta |
|---|---|---|---|
| GET | /api/series | Listar todas | 200 |
| GET | /api/series/{id} | Buscar por ID | 200 / 404 |
| POST | /api/series | Crear | 201 / 400 |
| PUT | /api/series/{id} | Actualizar | 200 / 404 / 400 |
| DELETE | /api/series/{id} | Eliminar | 204 / 404 |

Ejemplo de JSON para POST / PUT:
```json
{ "titulo": "Stranger Things", "plataforma": "Netflix", "calificacion": 8.7 }
```

## Pruebas
Importa `postman/API-Series.postman_collection.json` en Postman y ejecuta las peticiones en orden.
Las capturas de cada endpoint están en el PDF de evidencias.
