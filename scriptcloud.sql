DROP DATABASE IF EXISTS LavanderiaPiscis;
CREATE DATABASE LavanderiaPiscis;
USE LavanderiaPiscis;

-- Tabla: Distrito
CREATE TABLE Distrito (
    DistritoID INT AUTO_INCREMENT PRIMARY KEY,
    NombreDistrito VARCHAR(50) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla: Sucursal
CREATE TABLE Sucursal (
    SucursalID INT AUTO_INCREMENT PRIMARY KEY,
    DistritoID INT NOT NULL,
    NombreSucursal VARCHAR(50) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    Estado BOOLEAN NOT NULL,
    FOREIGN KEY (DistritoID) REFERENCES Distrito(DistritoID)
);

-- Tabla: Cliente
CREATE TABLE Cliente (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    DNI CHAR(8) NOT NULL UNIQUE,
    Numero CHAR(9) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla: Rol
CREATE TABLE Rol (
    RolID INT AUTO_INCREMENT PRIMARY KEY,
    NombreRol VARCHAR(20) NOT NULL,
    Descripcion VARCHAR(200) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla: Empleado
CREATE TABLE Empleado (
    EmpleadoID INT AUTO_INCREMENT PRIMARY KEY,
    SucursalID INT NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    DNI CHAR(8) NOT NULL UNIQUE,
    Numero CHAR(9) NOT NULL,
    HoraEntrada TIME NOT NULL,
    HoraSalida TIME NOT NULL,
    Estado BOOLEAN NOT NULL,
    FOREIGN KEY (SucursalID) REFERENCES Sucursal(SucursalID)
);

-- Tabla: Usuario
CREATE TABLE Usuario (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    EmpleadoID INT DEFAULT NULL,
    CorreoElectronico VARCHAR(100) NOT NULL UNIQUE,
    Clave VARCHAR(100) NOT NULL,
    Numero CHAR(9) NOT NULL,
    RolID INT NOT NULL,
    Estado BOOLEAN NOT NULL,
    FOREIGN KEY (EmpleadoID) REFERENCES Empleado(EmpleadoID),
    FOREIGN KEY (RolID) REFERENCES Rol(RolID)
);

-- Tabla: Boleta
CREATE TABLE Boleta (
    BoletaID INT AUTO_INCREMENT PRIMARY KEY,
    ClienteID INT NOT NULL,
    EmpleadoID INT NOT NULL,
    SucursalID INT NOT NULL,
    FechaEmision DATE NOT NULL,
    FechaEntrega DATE NOT NULL,
    Total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
    FOREIGN KEY (EmpleadoID) REFERENCES Empleado(EmpleadoID),
    FOREIGN KEY (SucursalID) REFERENCES Sucursal(SucursalID)
);

-- Tabla: DetalleBoleta
CREATE TABLE DetalleBoleta (
    DetalleID INT AUTO_INCREMENT PRIMARY KEY,
    BoletaID INT NOT NULL,
    TipoCobro ENUM('kilo', 'unidad') NOT NULL,
    PrendaNombre VARCHAR(100) NULL,
    Peso DECIMAL(10,2) NULL,
    Precio DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (BoletaID) REFERENCES Boleta(BoletaID)
);

-- Tabla: Proveedor
CREATE TABLE Proveedor (
    ProveedorID INT AUTO_INCREMENT PRIMARY KEY,
    RUC CHAR(11) NOT NULL UNIQUE,
    RazonSocial VARCHAR(30) NOT NULL,
    Direccion VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) NOT NULL,
    Numero CHAR(9) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla: Insumo
CREATE TABLE Insumo (
    InsumoID INT AUTO_INCREMENT PRIMARY KEY,
    ProveedorID INT NOT NULL,
    NombreInsumo VARCHAR(30) NOT NULL,
    StockMinimo INT NULL,
    StockActual INT NULL,
    Estado BOOLEAN NOT NULL,
    FOREIGN KEY (ProveedorID) REFERENCES Proveedor(ProveedorID)
);

-- Vista corregida: VistaDetalleBoleta
CREATE VIEW VistaDetalleBoleta AS
SELECT 
    b.BoletaID,
    b.FechaEmision,
    b.FechaEntrega,
    CONCAT(c.Nombre, ' ', c.Apellido) AS NombreCliente,
    c.DNI AS DNICliente,
    c.Numero AS Telefono,
    CONCAT(e.Nombre, ' ', e.Apellido) AS AtendidoPor,
    s.NombreSucursal AS NombreLavanderia,
    s.Direccion AS DireccionLavanderia,
    d.NombreDistrito AS Distrito,
    db.PrendaNombre AS Prenda,
    db.TipoCobro,
    CASE 
        WHEN db.TipoCobro = 'kilo' THEN db.Peso
        ELSE 1 
    END AS Cantidad,
    db.Precio AS PrecioUnitario,
    db.Peso,
    db.Precio AS Subtotal,
    b.Total,
    ROUND(b.Total * 0.18, 2) AS IGV,
    ROUND(b.Total * 1.18, 2) AS TotalConIGV
FROM Boleta b
JOIN Cliente c ON b.ClienteID = c.ClienteID
JOIN Empleado e ON b.EmpleadoID = e.EmpleadoID
JOIN Sucursal s ON b.SucursalID = s.SucursalID
JOIN Distrito d ON s.DistritoID = d.DistritoID
JOIN DetalleBoleta db ON b.BoletaID = db.BoletaID;