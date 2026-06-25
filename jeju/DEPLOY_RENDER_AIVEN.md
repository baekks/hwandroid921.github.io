# Render + Aiven Deployment

This Spring Boot app is ready to run on Render with PostgreSQL hosted on Aiven.

## Aiven PostgreSQL

Create or reuse an Aiven PostgreSQL service, then copy these values from the Aiven console:

- Host
- Port
- Database
- User
- Password

Use this JDBC URL format for Render:

```text
jdbc:postgresql://HOST:PORT/DATABASE?sslmode=require
```

For example:

```text
jdbc:postgresql://pg-example.aivencloud.com:12345/defaultdb?sslmode=require
```

## Render

1. Push this repository to GitHub.
2. In Render, create a new Blueprint from the repository.
3. Render reads `/render.yaml` and creates the Docker web service from the `jeju` directory.
4. Fill the prompted secret environment variables:

```text
SPRING_DATASOURCE_URL=jdbc:postgresql://HOST:PORT/DATABASE?sslmode=require
SPRING_DATASOURCE_USERNAME=avnadmin
SPRING_DATASOURCE_PASSWORD=your-aiven-password
```

Render automatically provides `PORT`, and the app maps it through `server.port=${PORT:8101}`.

## Notes

- `FILE_UPLOAD_DIR` defaults to `/tmp/jeju/uploads/` on Render.
- Render free web services do not provide persistent local storage. Uploaded files can disappear after redeploys or restarts.
- For persistent uploads, use external object storage or a paid Render persistent disk and set `FILE_UPLOAD_DIR` to that disk path.
- `SPRING_JPA_HIBERNATE_DDL_AUTO` defaults to `update` for project/demo deployment. Use `validate` or migrations for production.
