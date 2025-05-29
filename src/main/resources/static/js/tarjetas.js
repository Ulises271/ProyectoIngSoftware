/*
Script para la consulta de las tarjetas del usuario. Mediante estas,
serán creadas en HTML.
*/

// Contenedor de todas las tarjetas
const tarjets_container = document.getElementsByClassName("all-tarjets")[0];
let tarjetas = []; // Variable donde almacenaremos las tarjetas


// Función para crear dinámicamente las tarjetas
const cargarTarjetas = () => {
  tarjets_container.innerHTML = ""; // Limpiar el contenedor

  tarjetas.forEach((tarjeta, index) => {
    const tarjetaDiv = document.createElement("div");
    tarjetaDiv.classList.add("tarjets");
    tarjeta["estado"]=="Expirada"?tarjetaDiv.classList.add("expiradas"):null;
    tarjetaDiv.id = `tarjeta-${tarjeta.idTarjeta}`; // ID único para cada tarjeta

    tarjetaDiv.innerHTML = `
      <h3 class="h3-b">Bancora</h3>
      <h3 class="h3-n" id="num-tarjeta-${tarjeta.idTarjeta}">${tarjeta.numeroTarjeta}</h3>
      <div class="aux-vencimiento">
          <label>Vencimiento</label><br>
          <label id="vencimiento-${tarjeta.idTarjeta}">${formatearFecha(tarjeta.fechaExpiracion)}</label>
      </div>
      <div class="aux-cvv">
          <label>CVV</label><br>
          <label class="hovercvv" id="cvv-${tarjeta.idTarjeta}">${generarCVV(tarjeta.idTarjeta)}</label>
      </div>
      <div class="aux-tarjets">
          <h4 class="disponible" id="cantidad-${tarjeta.idTarjeta}">$${parseFloat(tarjeta.saldo).toFixed(2)}</h4>
          <label>Disponible</label>
      </div>
    `;

    tarjets_container.appendChild(tarjetaDiv);
  });
};

// Función para formatear fechas YYYY-MM-DD → MM/YYYY
const formatearFecha = (fechaStr) => {
  const fecha = new Date(fechaStr);
  const mes = String(fecha.getMonth() + 1).padStart(2, "0");
  const año = fecha.getFullYear();
  return `${mes}/${año}`;
};

// Función para generar un CVV aleatorio reproducible (simulado)
const generarCVV = (id) => {
  return String((id * 77) % 900 + 100); // resultado entre 100 y 999
};