package pe.com.techpeople.logistic.model.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
    public void initializeDatabase() {
        // Crear tabla si no existe
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS tbl_tipo_cambio (id INT AUTO_INCREMENT PRIMARY KEY, fecha DATE, "
        		+ " compra NUMERIC(10,2), venta NUMERIC(10,2), periodo NUMERIC(6,0), fecha_crea DATE, usuario_crea VARCHAR(150), fecha_update DATE,"
        		+ " usuario_update VARCHAR(150), flag_estado INT) ");

        // Insertar datos de ejemplo
        //jdbcTemplate.update("INSERT INTO example_table (name) VALUES (?)", "Ejemplo 1");
        //jdbcTemplate.update("INSERT INTO example_table (name) VALUES (?)", "Ejemplo 2");

        System.out.println("Base de datos inicializada correctamente.");
    }

}
