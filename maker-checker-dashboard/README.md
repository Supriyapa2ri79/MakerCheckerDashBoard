
# GCP Deployment Instructions

## Backend (Spring Boot)

1. **Configure Cloud SQL:**
   - Create a Cloud SQL (PostgreSQL) instance in your GCP project.
   - Create database and user.
   - Update `app.yaml` and `application.properties` with your connection details.

2. **Enable Cloud SQL Admin API:**
   ```
   gcloud services enable sqladmin.googleapis.com
   ```

3. **Build and Deploy:**
   - Build your Spring Boot app:
     ```
     mvn package
     ```
   - Deploy to App Engine:
     ```
     gcloud app deploy backend/app.yaml
     ```

## Frontend (ReactJS)

1. **Build React App:**
   ```
   cd frontend
   npm install
   npm run build
   ```

2. **Deploy to App Engine:**
   ```
   gcloud app deploy frontend/app.yaml
   ```

## Notes

- Make sure your backend can access Cloud SQL. Use IAM and App Engine service account for secure connectivity.
- Set environment variables for secrets/credentials.

## References

- [Deploy Java to App Engine](https://cloud.google.com/appengine/docs/standard/java/)
- [Connect App Engine to Cloud SQL](https://cloud.google.com/appengine/docs/standard/java/connect-cloudsql)
- [Deploy React to App Engine](https://cloud.google.com/community/tutorials/run-react-app-with-cloud-app-engine)
