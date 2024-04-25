CREATE TABLE IF NOT EXISTS tbl_tipo_cambio (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	fecha DATE, 
	compra NUMERIC(10,2), 
	venta NUMERIC(10,2), 
	periodo NUMERIC(6,0), 
	fecha_crea DATE,
	usuario_crea VARCHAR(150), 
	fecha_update DATE,
	usuario_update VARCHAR(150), 
	flag_estado INT
 )
 