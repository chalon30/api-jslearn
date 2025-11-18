package upn.pe.api_jslearn.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final DataSource dataSource;

    public DataLoader(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            // Verificar si la tabla existe
            try (ResultSet checkTable = conn.getMetaData()
                    .getTables(null, null, "curso", null)) {

                if (!checkTable.next()) {
                    System.out.println("⚠️ La tabla 'curso' no existe. Saltando ejecución de data.sql");
                    return;
                }
            }

            // Verificar si la tabla está vacía
            try (ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM curso")) {

                if (rs.next() && rs.getInt(1) == 0) {
                    System.out.println("▶ Ejecutando data.sql (tabla vacía)...");
                    ScriptUtils.executeSqlScript(conn, new ClassPathResource("data.sql"));
                    System.out.println("✔ data.sql ejecutado correctamente.");
                } else {
                    System.out.println("⏩ Saltando data.sql (ya hay datos xd).");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error en DataLoader: " + e.getMessage());
            throw e;
        }
    }
}
