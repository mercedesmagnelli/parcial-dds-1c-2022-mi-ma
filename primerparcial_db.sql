CREATE DATABASE  IF NOT EXISTS `primerparcial_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `primerparcial_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: primerparcial_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrito_de_compras`
--

DROP TABLE IF EXISTS carrito_de_compras;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE carrito_de_compras (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  esta_en_dolares bit(1) NOT NULL,
  fecha_de_venta date DEFAULT NULL,
  medio_de_pago varchar(255) DEFAULT NULL,
  cliente_id int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY FK2kjemcj3gxvrnlewtn9lx0q6j (cliente_id),
  CONSTRAINT FK2kjemcj3gxvrnlewtn9lx0q6j FOREIGN KEY (cliente_id) REFERENCES rol (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_de_compras`
--

/*!40000 ALTER TABLE carrito_de_compras DISABLE KEYS */;
/*!40000 ALTER TABLE carrito_de_compras ENABLE KEYS */;

--
-- Table structure for table `carrito_de_compras_promociones`
--

DROP TABLE IF EXISTS carrito_de_compras_promociones;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE carrito_de_compras_promociones (
  carrito_de_compras_id int(11) NOT NULL,
  promociones_id int(11) NOT NULL,
  KEY FK6aycwirm8j6j3vdhkqfwmo734 (promociones_id),
  KEY FKhsjvbr11749gx1qknij8uaxh9 (carrito_de_compras_id),
  CONSTRAINT FK6aycwirm8j6j3vdhkqfwmo734 FOREIGN KEY (promociones_id) REFERENCES promocion (`id`),
  CONSTRAINT FKhsjvbr11749gx1qknij8uaxh9 FOREIGN KEY (carrito_de_compras_id) REFERENCES carrito_de_compras (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_de_compras_promociones`
--

/*!40000 ALTER TABLE carrito_de_compras_promociones DISABLE KEYS */;
/*!40000 ALTER TABLE carrito_de_compras_promociones ENABLE KEYS */;

--
-- Table structure for table `item_venta`
--

DROP TABLE IF EXISTS item_venta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE item_venta (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  cantidad int(11) NOT NULL,
  precio_compra double NOT NULL,
  producto_id int(11) DEFAULT NULL,
  venta_id int(11) DEFAULT NULL,
  posicion int(11) DEFAULT NULL,
  carrito_de_compras_id int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY FK4vfin5d1lrbavmtaq76ah6qc2 (producto_id),
  KEY FK6ixcdqqa8ren81ahfss5oy5ds (venta_id),
  KEY FKs5ivtrpju05oprh81x73w4nu (carrito_de_compras_id),
  CONSTRAINT FK4vfin5d1lrbavmtaq76ah6qc2 FOREIGN KEY (producto_id) REFERENCES producto (`id`),
  CONSTRAINT FK6ixcdqqa8ren81ahfss5oy5ds FOREIGN KEY (venta_id) REFERENCES venta (`id`),
  CONSTRAINT FKs5ivtrpju05oprh81x73w4nu FOREIGN KEY (carrito_de_compras_id) REFERENCES carrito_de_compras (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_venta`
--

/*!40000 ALTER TABLE item_venta DISABLE KEYS */;
/*!40000 ALTER TABLE item_venta ENABLE KEYS */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS producto;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE producto (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  descripcion varchar(255) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  precio double DEFAULT NULL,
  stock int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE producto DISABLE KEYS */;
/*!40000 ALTER TABLE producto ENABLE KEYS */;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS promocion;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE promocion (
  tipo varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  porcentaje_descuento double DEFAULT NULL,
  medio_de_pago varchar(255) DEFAULT NULL,
  porcentaje double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

/*!40000 ALTER TABLE promocion DISABLE KEYS */;
/*!40000 ALTER TABLE promocion ENABLE KEYS */;

--
-- Table structure for table `promocion_clientes`
--

DROP TABLE IF EXISTS promocion_clientes;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE promocion_clientes (
  membresia_id int(11) NOT NULL,
  clientes_id int(11) NOT NULL,
  KEY FK6j7vdg4yfr94kx0ns76487kt (clientes_id),
  KEY FKbq0bdspon6svbngsy0enobl3g (membresia_id),
  CONSTRAINT FK6j7vdg4yfr94kx0ns76487kt FOREIGN KEY (clientes_id) REFERENCES rol (`id`),
  CONSTRAINT FKbq0bdspon6svbngsy0enobl3g FOREIGN KEY (membresia_id) REFERENCES promocion (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion_clientes`
--

/*!40000 ALTER TABLE promocion_clientes DISABLE KEYS */;
/*!40000 ALTER TABLE promocion_clientes ENABLE KEYS */;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS rol;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE rol (
  tipo varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  apellido varchar(255) DEFAULT NULL,
  mail varchar(255) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  nro_documento varchar(255) DEFAULT NULL,
  telefono varchar(255) DEFAULT NULL,
  tipo_de_documento varchar(255) DEFAULT NULL,
  estrellas int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

/*!40000 ALTER TABLE rol DISABLE KEYS */;
/*!40000 ALTER TABLE rol ENABLE KEYS */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE usuario (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  contrasenia varchar(255) DEFAULT NULL,
  usuario varchar(255) DEFAULT NULL,
  rol_id int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY FKshkwj12wg6vkm6iuwhvcfpct8 (rol_id),
  CONSTRAINT FKshkwj12wg6vkm6iuwhvcfpct8 FOREIGN KEY (rol_id) REFERENCES rol (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE usuario DISABLE KEYS */;
/*!40000 ALTER TABLE usuario ENABLE KEYS */;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS venta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE venta (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  fecha_de_venta date DEFAULT NULL,
  hecha_en_dolares bit(1) DEFAULT NULL,
  medio_de_pago varchar(255) DEFAULT NULL,
  precio_total_con_descuento double NOT NULL,
  precio_total_sin_descuento double NOT NULL,
  cliente_id int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY FKiguml2gwt1xrnua697kdhwlvd (cliente_id),
  CONSTRAINT FKiguml2gwt1xrnua697kdhwlvd FOREIGN KEY (cliente_id) REFERENCES rol (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

/*!40000 ALTER TABLE venta DISABLE KEYS */;
/*!40000 ALTER TABLE venta ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
