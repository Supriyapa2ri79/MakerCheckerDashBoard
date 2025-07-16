# Running Maker-Checker Dashboard (Frontend Only & Full Stack)

---

## **Frontend (ReactJS) Only**

1. **Navigate to the frontend directory:**
   ```bash
   cd maker-checker-dashboard/frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start the development server:**
   ```bash
   npm start
   ```

4. **Access the app:**  
   Open your browser and go to [http://localhost:3000](http://localhost:3000)

**Note:**  
By default, the frontend expects the backend API to be available on `/api/`. If you are only running the frontend, API calls will fail unless you mock them or use tools like [Mock Service Worker (MSW)](https://mswjs.io/).

---

## **Full Stack (Frontend + Backend locally)**

### **1. Backend (Java Spring Boot)**

- Make sure you have Java 11+, Maven, and a local (or cloud) PostgreSQL/MySQL database.

- Configure `backend/src/main/resources/application.properties` with your DB credentials.

- Navigate to the backend directory and start the backend:
  ```bash
  cd maker-checker-dashboard/backend
  mvn spring-boot:run
  ```
- Backend runs on `http://localhost:8080` by default.

### **2. Frontend**

- In a separate terminal, follow the frontend steps above.

- If running both locally, you may need a proxy for API calls. Add a `proxy` field to `frontend/package.json`:
  ```json
  "proxy": "http://localhost:8080"
  ```

---

## **Deploying to GCP (App Engine + Cloud SQL)**

### **Backend**

1. Configure `app.yaml` and `application.properties` with your Cloud SQL connection information.

2. Build and deploy:
   ```bash
   mvn package
   gcloud app deploy backend/app.yaml
   ```

### **Frontend**

1. Build your React app:
   ```bash
   npm run build
   ```

2. Deploy to App Engine:
   ```bash
   gcloud app deploy frontend/app.yaml
   ```

---

## **Database Setup (Cloud SQL)**

1. Create a Cloud SQL instance in GCP.
2. Run the schema script:
   ```sql
   CREATE TABLE product (
     id SERIAL PRIMARY KEY,
     product_code VARCHAR(50),
     rate_of_intrest DECIMAL(5,2)
   );

   CREATE TABLE approval (
     id SERIAL PRIMARY KEY,
     product_id INTEGER REFERENCES product(id),
     maker_id INTEGER,
     checker_id INTEGER,
     status VARCHAR(20),
     comments TEXT
   );
   ```

---

## **Troubleshooting**

- **Port conflicts:** Make sure nothing else is running on ports 3000 (frontend) or 8080 (backend).
- **API errors:** Ensure backend is running and accessible at the expected URL.
- **GCP issues:** Check IAM permissions, database connectivity, and environment variables.

---

## **References**

- [ReactJS Docs](https://react.dev/)
- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [GCP App Engine Docs](https://cloud.google.com/appengine/docs)
- [GCP Cloud SQL Docs](https://cloud.google.com/sql/docs)
