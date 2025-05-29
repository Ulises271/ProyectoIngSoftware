
// ===================== CLIENTES =====================
function listarClientes() {
  fetch("http://localhost:8080/api/clientes")
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-clientes");
      tabla.innerHTML = "";
      data.forEach(c => {
        tabla.innerHTML += `
          <tr>
            <td>${c.idClientes}</td>
            <td>${c.nombre}</td>
            <td>${c.apellidos}</td>
            <td>${c.fechaNacimiento}</td>
            <td><button onclick="eliminarCliente(${c.idClientes})">Eliminar</button></td>
          </tr>`;
      });
    });
}

function crearCliente() {
  const cliente = {
    nombre: document.getElementById("nombre").value,
    apellidos: document.getElementById("apellidos").value,
    fechaNacimiento: document.getElementById("fechaNacimiento").value
  };

  fetch("http://localhost:8080/api/clientes", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(cliente)
  }).then(() => {
    listarClientes();
    document.getElementById("formCliente").reset();
  });
}

function eliminarCliente(id) {
  fetch(`http://localhost:8080/api/clientes/${id}`, { method: "DELETE" })
    .then(() => listarClientes());
}

// ===================== CUENTAS =====================
function listarCuentas() {
  fetch("http://localhost:8080/api/cuentas")
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-cuentas");
      tabla.innerHTML = "";
      data.forEach(c => {
        tabla.innerHTML += `
          <tr>
            <td>${c.id}</td>
            <td>${c.numeroCuenta}</td>
            <td>${c.saldo}</td>
            <td>${c.tipo}</td>
            <td><button onclick="eliminarCuenta(${c.id})">Eliminar</button></td>
          </tr>`;
      });
    });
}

function crearCuenta() {
  const cuenta = {
    numeroCuenta: document.getElementById("numeroCuenta").value,
    saldo: document.getElementById("saldo").value,
    tipo: document.getElementById("tipoCuenta").value
  };

  fetch("http://localhost:8080/api/cuentas", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(cuenta)
  }).then(() => {
    listarCuentas();
    document.getElementById("formCuenta").reset();
  });
}

function eliminarCuenta(id) {
  fetch(`http://localhost:8080/api/cuentas/${id}`, { method: "DELETE" })
    .then(() => listarCuentas());
}

// ===================== CONTACTOS =====================
function listarContactos() {
  fetch("http://localhost:8080/api/contactos")
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-contactos");
      tabla.innerHTML = "";
      data.forEach(c => {
        tabla.innerHTML += `
          <tr>
            <td>${c.id}</td>
            <td>${c.nombre}</td>
            <td>${c.telefono}</td>
            <td><button onclick="eliminarContacto(${c.id})">Eliminar</button></td>
          </tr>`;
      });
    });
}

function crearContacto() {
  const contacto = {
    nombre: document.getElementById("nombreContacto").value,
    telefono: document.getElementById("telefonoContacto").value
  };

  fetch("http://localhost:8080/api/contactos", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(contacto)
  }).then(() => {
    listarContactos();
    document.getElementById("formContacto").reset();
  });
}

function eliminarContacto(id) {
  fetch(`http://localhost:8080/api/contactos/${id}`, { method: "DELETE" })
    .then(() => listarContactos());
}

// ===================== TARJETAS =====================
function listarTarjetas() {
  fetch("http://localhost:8080/api/tarjetas")
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-tarjetas");
      tabla.innerHTML = "";
      data.forEach(t => {
        tabla.innerHTML += `
          <tr>
            <td>${t.id}</td>
            <td>${t.numero}</td>
            <td>${t.tipo}</td>
            <td>${t.fechaExpiracion}</td>
            <td><button onclick="eliminarTarjeta(${t.id})">Eliminar</button></td>
          </tr>`;
      });
    });
}

function crearTarjeta() {
  const tarjeta = {
    numero: document.getElementById("numeroTarjeta").value,
    tipo: document.getElementById("tipoTarjeta").value,
    fechaExpiracion: document.getElementById("fechaExpiracion").value
  };

  fetch("http://localhost:8080/api/tarjetas", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(tarjeta)
  }).then(() => {
    listarTarjetas();
    document.getElementById("formTarjeta").reset();
  });
}

function eliminarTarjeta(id) {
  fetch(`http://localhost:8080/api/tarjetas/${id}`, { method: "DELETE" })
    .then(() => listarTarjetas());
}

// ===================== TRANSFERENCIAS =====================
function listarTransferencias() {
  fetch("http://localhost:8080/api/transferencias")
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-transferencias");
      tabla.innerHTML = "";
      data.forEach(t => {
        tabla.innerHTML += `
          <tr>
            <td>${t.id}</td>
            <td>${t.monto}</td>
            <td>${t.origen}</td>
            <td>${t.destino}</td>
            <td><button onclick="eliminarTransferencia(${t.id})">Eliminar</button></td>
          </tr>`;
      });
    });
}

function crearTransferencia() {
  const transferencia = {
    monto: document.getElementById("monto").value,
    origen: document.getElementById("origen").value,
    destino: document.getElementById("destino").value
  };

  fetch("http://localhost:8080/api/transferencias", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(transferencia)
  }).then(() => {
    listarTransferencias();
    document.getElementById("formTransferencia").reset();
  });
}

function eliminarTransferencia(id) {
  fetch(`http://localhost:8080/api/transferencias/${id}`, { method: "DELETE" })
    .then(() => listarTransferencias());
}
